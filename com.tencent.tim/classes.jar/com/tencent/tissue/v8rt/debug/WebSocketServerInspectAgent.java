package com.tencent.tissue.v8rt.debug;

import com.tencent.tissue.v8rt.anno.NotNull;
import com.tencent.tissue.v8rt.anno.Nullable;
import com.tencent.tissue.v8rt.engine.IInspectorAgent;
import com.tencent.tissue.v8rt.engine.IInspectorAgent.IDebuggerMessageListener;
import com.tencent.tissue.v8rt.engine.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WebSocketServerInspectAgent
  implements IInspectorAgent
{
  private static final boolean DEBUG = true;
  private static final int DEFAULT_SERVER_PORT = 5678;
  private static final String TAG = "WebSocketServerInspectAgent";
  private final AgentServer mAgentServer = new AgentServer(5678);
  private IInspectorAgent.IDebuggerMessageListener mDebuggerMessageListener;
  private boolean mWaitForDebugger = false;
  private WebSocket mWebSocket;
  
  public WebSocketServerInspectAgent(boolean paramBoolean)
  {
    this.mAgentServer.start();
    this.mWaitForDebugger = paramBoolean;
  }
  
  public boolean isWaitForDebugger()
  {
    return this.mWaitForDebugger;
  }
  
  public void sendMessageToDebugger(@NotNull String paramString)
  {
    if (this.mWebSocket != null)
    {
      this.mWebSocket.send(paramString);
      Logger.i("WebSocketServerInspectAgent", ">> " + paramString);
    }
  }
  
  public void setOnDebuggerMessageListener(@Nullable IInspectorAgent.IDebuggerMessageListener paramIDebuggerMessageListener)
  {
    this.mDebuggerMessageListener = paramIDebuggerMessageListener;
  }
  
  public void stop()
  {
    try
    {
      if (this.mWebSocket != null) {
        this.mWebSocket.close();
      }
      this.mAgentServer.stop();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  class AgentServer
    extends WebSocketServer
  {
    private final int mPort;
    
    AgentServer(int paramInt)
    {
      super();
      setReuseAddr(true);
      this.mPort = paramInt;
      setConnectionLostTimeout(2147483647);
    }
    
    public void onClose(WebSocket paramWebSocket, int paramInt, String paramString, boolean paramBoolean)
    {
      Logger.w("WebSocketServerInspectAgent", "Debugger disconnected " + paramString + " " + paramWebSocket);
      WebSocketServerInspectAgent.access$002(WebSocketServerInspectAgent.this, null);
    }
    
    public void onError(WebSocket paramWebSocket, Exception paramException)
    {
      WebSocketServerInspectAgent.access$002(WebSocketServerInspectAgent.this, null);
      Logger.w("WebSocketServerInspectAgent", "ScriptEngine Inspector Debugger server failed", paramException);
    }
    
    public void onMessage(WebSocket paramWebSocket, String paramString)
    {
      if (WebSocketServerInspectAgent.this.mDebuggerMessageListener != null)
      {
        WebSocketServerInspectAgent.this.mDebuggerMessageListener.sendMessageToEngine(paramString);
        Logger.i("WebSocketServerInspectAgent", "<< " + paramString);
      }
    }
    
    public void onOpen(WebSocket paramWebSocket, ClientHandshake paramClientHandshake)
    {
      WebSocketServerInspectAgent.access$002(WebSocketServerInspectAgent.this, paramWebSocket);
      Logger.w("WebSocketServerInspectAgent", "Debugger connected " + paramWebSocket);
    }
    
    public void onStart()
    {
      Logger.i("WebSocketServerInspectAgent", "ScriptEngine Inspector Debugger server successfully started on port:" + this.mPort + "\nfollow the steps to start debug:\n1. adb forward tcp:" + this.mPort + " tcp:" + this.mPort + "\n2. open chrome with url to start inspect\nchrome-devtools://devtools/bundled/js_app.html?ws=localhost:" + this.mPort);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.debug.WebSocketServerInspectAgent
 * JD-Core Version:    0.7.0.1
 */