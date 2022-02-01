package com.tencent.component.network.downloader.impl.ipc;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;

public class DownloadSerice
  extends Service
{
  private static final String TAG = "DownloadSerice";
  private final Messenger mMessenger = new Messenger(new ClientHandler());
  
  private void cancel(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "cancel request from DownloadClient:" + paramSimpleRequest.toString());
    paramSimpleRequest = Const.obtainDownloadCanceledMsg(paramSimpleRequest.url);
    try
    {
      paramMessenger.send(paramSimpleRequest);
      return;
    }
    catch (RemoteException paramSimpleRequest)
    {
      paramSimpleRequest.printStackTrace();
    }
  }
  
  private void cleanCache(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "clean cache." + paramSimpleRequest.toString());
    int i = paramSimpleRequest.content_type;
    paramMessenger = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      paramMessenger = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    if ("".equals(paramSimpleRequest.url))
    {
      paramMessenger.cleanCache();
      return;
    }
    paramMessenger.cleanCache(paramSimpleRequest.url);
  }
  
  private void download(Const.SimpleRequest paramSimpleRequest, Messenger paramMessenger)
  {
    if ((paramSimpleRequest == null) || (paramMessenger == null)) {
      return;
    }
    Log.i("DownloadSerice", "download request from DownloadClient:" + paramSimpleRequest.toString());
    int i = paramSimpleRequest.content_type;
    Downloader localDownloader = DownloaderFactory.getInstance(this).getImageDownloader();
    if (i == 2) {
      localDownloader = DownloaderFactory.getInstance(this).getCommonDownloader();
    }
    localDownloader.download(paramSimpleRequest.url, paramSimpleRequest.getPaths(), true, new DownloadSerice.1(this, paramMessenger));
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    Log.w("DownloadSerice", "Download Service Binded");
    return this.mMessenger.getBinder();
  }
  
  public void onCreate()
  {
    Log.e("DownloadSerice", "start onCreate~~~");
    super.onCreate();
  }
  
  public void onDestroy()
  {
    Log.e("DownloadSerice", "start onDestroy~~~");
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    Log.e("DownloadSerice", "start onStart~~~");
    super.onStart(paramIntent, paramInt);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.e("DownloadSerice", "start onUnbind~~~");
    return super.onUnbind(paramIntent);
  }
  
  class ClientHandler
    extends Handler
  {
    ClientHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      Log.i("DownloadSerice", "on msg:" + paramMessage.what);
      for (;;)
      {
        try
        {
          switch (paramMessage.what)
          {
          case 101: 
            super.handleMessage(paramMessage);
            return;
          }
        }
        catch (Throwable paramMessage)
        {
          Log.e("DownloadSerice", "", paramMessage);
          return;
        }
        if (paramMessage.getData() == null) {
          break;
        }
        Object localObject = paramMessage.getData();
        ((Bundle)localObject).setClassLoader(DownloadSerice.this.getClassLoader());
        localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
        DownloadSerice.this.download((Const.SimpleRequest)localObject, paramMessage.replyTo);
        return;
        if (paramMessage.getData() == null) {
          break;
        }
        localObject = paramMessage.getData();
        ((Bundle)localObject).setClassLoader(DownloadSerice.this.getClassLoader());
        localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
        DownloadSerice.this.cancel((Const.SimpleRequest)localObject, paramMessage.replyTo);
        return;
        if (paramMessage.getData() == null) {
          break;
        }
        localObject = paramMessage.getData();
        ((Bundle)localObject).setClassLoader(DownloadSerice.this.getClassLoader());
        localObject = (Const.SimpleRequest)((Bundle)localObject).get("request");
        DownloadSerice.this.cleanCache((Const.SimpleRequest)localObject, paramMessage.replyTo);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.DownloadSerice
 * JD-Core Version:    0.7.0.1
 */