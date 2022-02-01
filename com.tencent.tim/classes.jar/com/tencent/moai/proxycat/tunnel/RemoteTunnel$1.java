package com.tencent.moai.proxycat.tunnel;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Readable;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

class RemoteTunnel$1
  implements Readable
{
  RemoteTunnel$1(RemoteTunnel paramRemoteTunnel) {}
  
  public void onReadable(SelectionKey paramSelectionKey)
  {
    this.this$0.buffer.clear();
    try
    {
      int i = this.this$0.channel.read(this.this$0.buffer);
      if (i == -1)
      {
        Logger.e(RemoteTunnel.access$000(this.this$0), "Connection establish receive read -1 ");
        this.this$0.close();
        return;
      }
    }
    catch (IOException paramSelectionKey)
    {
      Logger.e(RemoteTunnel.access$000(this.this$0), Log.getStackTraceString(paramSelectionKey));
      this.this$0.close();
      return;
    }
    paramSelectionKey = new String(this.this$0.buffer.array(), 0, this.this$0.buffer.position());
    Logger.i(RemoteTunnel.access$000(this.this$0), "Connection establish ret " + paramSelectionKey);
    paramSelectionKey = paramSelectionKey.split(" ");
    if (paramSelectionKey.length >= 3)
    {
      if ("200".equals(paramSelectionKey[1]))
      {
        this.this$0.beginReceiving();
        this.this$0.brother.beginReceiving();
        return;
      }
      this.this$0.close();
      return;
    }
    this.this$0.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tunnel.RemoteTunnel.1
 * JD-Core Version:    0.7.0.1
 */