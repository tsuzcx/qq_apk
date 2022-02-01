package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficInputStreamHandlerDispatcher
{
  private Set<ITrafficInputStreamHandler> inputStreamHandlers = new HashSet();
  
  public TrafficInputStreamHandlerDispatcher()
  {
    Iterator localIterator = TrafficIoStreamHandlerManager.getInputStreamHandlerFactories().iterator();
    while (localIterator.hasNext())
    {
      ITrafficInputStreamHandlerFactory localITrafficInputStreamHandlerFactory = (ITrafficInputStreamHandlerFactory)localIterator.next();
      this.inputStreamHandlers.add(localITrafficInputStreamHandlerFactory.create());
    }
  }
  
  public void dispatchClose()
  {
    Iterator localIterator = this.inputStreamHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ITrafficInputStreamHandler)localIterator.next()).onClose();
    }
  }
  
  public void dispatchRead(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, SocketInfo paramSocketInfo)
  {
    Iterator localIterator = this.inputStreamHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ITrafficInputStreamHandler)localIterator.next()).onInput(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramSocketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficInputStreamHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */