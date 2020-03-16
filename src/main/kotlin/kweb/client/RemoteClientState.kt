package kweb.client

import kweb.DebugInfo
import kweb.browserConnection.KwebClientConnection
import kweb.gson
import java.time.Instant
import java.util.*

data class RemoteClientState(val id: String, @Volatile var clientConnection: KwebClientConnection, val handlers: MutableMap<Int, (Any) -> Unit> = HashMap(), val debugTokens: MutableMap<String, DebugInfo> = HashMap(), var lastModified : Instant = Instant.now()) {
    fun send(message: Server2ClientMessage) {
        clientConnection.send(gson.toJson(message))
    }

    override fun toString() = "RemoteClientState(id = $id)"
}