package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

public class LocalSocketServer
{
  private static final int MAX_BIND_RETRIES = 2;
  private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
  private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
  private final String mAddress;
  private final String mFriendlyName;
  private Thread mListenerThread;
  private LocalServerSocket mServerSocket;
  private final SocketHandler mSocketHandler;
  private boolean mStopped;
  private final AtomicInteger mThreadId = new AtomicInteger();
  
  public LocalSocketServer(String paramString1, String paramString2, SocketHandler paramSocketHandler)
  {
    this.mFriendlyName = ((String)Util.throwIfNull(paramString1));
    this.mAddress = ((String)Util.throwIfNull(paramString2));
    this.mSocketHandler = paramSocketHandler;
  }
  
  @Nonnull
  private static LocalServerSocket bindToSocket(String paramString)
    throws IOException
  {
    Object localObject = null;
    int i = 2;
    for (;;)
    {
      try
      {
        if (LogUtil.isLoggable(3)) {
          LogUtil.d("Trying to bind to @" + paramString);
        }
        LocalServerSocket localLocalServerSocket = new LocalServerSocket(paramString);
        return localLocalServerSocket;
      }
      catch (BindException localBindException)
      {
        LogUtil.w(localBindException, "Binding error, sleep 1000 ms...");
        if (localObject == null)
        {
          localObject = localBindException;
          Util.sleepUninterruptibly(1000L);
          if (i <= 0) {
            throw localObject;
          }
        }
        else
        {
          continue;
        }
        i -= 1;
      }
    }
  }
  
  private void listenOnAddress(String paramString)
    throws IOException
  {
    this.mServerSocket = bindToSocket(paramString);
    LogUtil.i("Listening on @" + paramString);
    for (;;)
    {
      if (!Thread.interrupted()) {}
      try
      {
        WorkerThread localWorkerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
        localWorkerThread.setName("StethoWorker-" + this.mFriendlyName + "-" + this.mThreadId.incrementAndGet());
        localWorkerThread.setDaemon(true);
        localWorkerThread.start();
      }
      catch (SocketException localSocketException)
      {
        if (Thread.interrupted())
        {
          LogUtil.i("Server shutdown on @" + paramString);
          return;
        }
        LogUtil.w(localSocketException, "I/O error");
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LogUtil.w(localIOException, "I/O error initialising connection thread");
        }
      }
      catch (InterruptedIOException localInterruptedIOException)
      {
        label115:
        break label115;
      }
    }
  }
  
  public String getName()
  {
    return this.mFriendlyName;
  }
  
  public void run()
    throws IOException
  {
    try
    {
      if (this.mStopped) {
        return;
      }
      this.mListenerThread = Thread.currentThread();
      listenOnAddress(this.mAddress);
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.mStopped = true;
      if (this.mListenerThread == null) {
        return;
      }
      this.mListenerThread.interrupt();
      try
      {
        if (this.mServerSocket != null)
        {
          this.mServerSocket.close();
          return;
        }
      }
      catch (IOException localIOException) {}
      return;
    }
    finally {}
  }
  
  static class WorkerThread
    extends Thread
  {
    private final LocalSocket mSocket;
    private final SocketHandler mSocketHandler;
    
    public WorkerThread(LocalSocket paramLocalSocket, SocketHandler paramSocketHandler)
    {
      this.mSocket = paramLocalSocket;
      this.mSocketHandler = paramSocketHandler;
    }
    
    public void run()
    {
      try
      {
        this.mSocketHandler.onAccepted(this.mSocket);
        label53:
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1 = localIOException1;
        LogUtil.w("I/O error: %s", new Object[] { localIOException1 });
        try
        {
          this.mSocket.close();
          return;
        }
        catch (IOException localIOException2)
        {
          return;
        }
      }
      finally
      {
        try
        {
          this.mSocket.close();
          throw localObject;
        }
        catch (IOException localIOException4)
        {
          break label53;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.LocalSocketServer
 * JD-Core Version:    0.7.0.1
 */