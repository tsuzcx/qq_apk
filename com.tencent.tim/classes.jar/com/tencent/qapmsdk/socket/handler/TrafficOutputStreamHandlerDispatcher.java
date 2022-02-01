package com.tencent.qapmsdk.socket.handler;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import com.tencent.qapmsdk.socket.model.SocketInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class TrafficOutputStreamHandlerDispatcher
{
  private Set<ITrafficOutputStreamHandler> outputStreamHandlers = new HashSet();
  
  public TrafficOutputStreamHandlerDispatcher()
  {
    Iterator localIterator = TrafficIoStreamHandlerManager.getOutputStreamHandlerFactories().iterator();
    while (localIterator.hasNext())
    {
      ITrafficOutputStreamHandlerFactory localITrafficOutputStreamHandlerFactory = (ITrafficOutputStreamHandlerFactory)localIterator.next();
      this.outputStreamHandlers.add(localITrafficOutputStreamHandlerFactory.create());
    }
  }
  
  public void dispatchWrite(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo)
  {
    Iterator localIterator = this.outputStreamHandlers.iterator();
    while (localIterator.hasNext()) {
      ((ITrafficOutputStreamHandler)localIterator.next()).onOutput(paramArrayOfByte, paramInt1, paramInt2, paramSocketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.TrafficOutputStreamHandlerDispatcher
 * JD-Core Version:    0.7.0.1
 */