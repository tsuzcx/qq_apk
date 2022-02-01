package com.tencent.component.network.downloader.impl.ipc;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.component.network.downloader.Downloader.DownloadMode;
import java.util.ArrayList;
import java.util.List;

public class Const
{
  public static final String BUNDLE_KEY_REQUEST = "request";
  public static final String BUNDLE_KEY_RESULT = "result";
  public static final String BUNDLE_KEY_URL = "url";
  public static final int MSG_WHAT_BASE = 100;
  public static final int MSG_WHAT_CLEAN_CACHE = 107;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST = 101;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST_ABORT = 103;
  public static final int MSG_WHAT_DOWNLOAD_REQUEST_CANCEL = 102;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_CANCELED = 105;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_FAILED = 104;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_PROGRESS = 106;
  public static final int MSG_WHAT_DOWNLOAD_RESPONSE_SUCCEED = 103;
  
  private static boolean equalsObject(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static Message obtainCleanCacheMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 107;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadAbortMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 103;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadCancelMsg(String paramString, int paramInt, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadCanceledMsg(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 105;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message obtainDownloadFailedMsg(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 104;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
  
  public static Message obtainDownloadProgressMsg(String paramString, long paramLong, float paramFloat)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 106;
    localMessage.arg1 = ((int)paramLong);
    localMessage.arg2 = ((int)paramFloat);
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    return localMessage;
  }
  
  public static Message obtainDownloadRequestMsg(String paramString, String[] paramArrayOfString, int paramInt, Downloader.DownloadMode paramDownloadMode, Messenger paramMessenger)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.replyTo = paramMessenger;
    paramMessenger = new SimpleRequest();
    paramMessenger.url = paramString;
    paramMessenger.content_type = paramInt;
    paramMessenger.mode = paramDownloadMode;
    if (paramArrayOfString != null)
    {
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramMessenger.addDstPath(paramArrayOfString[paramInt]);
        paramInt += 1;
      }
    }
    paramString = new Bundle();
    paramString.putParcelable("request", paramMessenger);
    localMessage.setData(paramString);
    return localMessage;
  }
  
  public static Message obtainDownloadSucceedMsg(String paramString, DownloadResult paramDownloadResult)
  {
    paramString = Message.obtain();
    paramString.what = 103;
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("result", paramDownloadResult);
    paramString.setData(localBundle);
    return paramString;
  }
  
  public static class SimpleRequest
    implements Parcelable
  {
    public static final Parcelable.Creator<SimpleRequest> CREATOR = new Const.SimpleRequest.1();
    public int content_type;
    public Downloader.DownloadListener listener;
    public Downloader.DownloadMode mode;
    public List<String> pathList;
    public String url;
    
    public SimpleRequest() {}
    
    public SimpleRequest(Parcel paramParcel)
    {
      if (paramParcel == null) {
        return;
      }
      this.url = paramParcel.readString();
      this.pathList = new ArrayList();
      paramParcel.readStringList(this.pathList);
      this.content_type = paramParcel.readInt();
      if (paramParcel.readInt() == 0) {}
      for (paramParcel = Downloader.DownloadMode.FastMode;; paramParcel = Downloader.DownloadMode.StrictMode)
      {
        this.mode = paramParcel;
        return;
      }
    }
    
    public void addDstPath(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      do
      {
        return;
        if (this.pathList == null) {
          this.pathList = new ArrayList();
        }
      } while (this.pathList.contains(paramString));
      this.pathList.add(paramString);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (!(paramObject instanceof SimpleRequest))) {
          return false;
        }
        paramObject = (SimpleRequest)paramObject;
      } while ((this.url.equalsIgnoreCase(paramObject.url)) && (Const.equalsObject(this.listener, paramObject.listener)));
      return false;
    }
    
    public String[] getPaths()
    {
      if (this.pathList == null) {
        return null;
      }
      String[] arrayOfString = new String[this.pathList.size()];
      int i = 0;
      while (i < this.pathList.size())
      {
        arrayOfString[i] = ((String)this.pathList.get(i));
        i += 1;
      }
      return arrayOfString;
    }
    
    public String toString()
    {
      if (this.pathList != null)
      {
        String str1 = "";
        int i = 0;
        for (;;)
        {
          str2 = str1;
          if (i >= this.pathList.size()) {
            break;
          }
          str1 = str1 + (String)this.pathList.get(i) + ";";
          i += 1;
        }
      }
      String str2 = "";
      return new String("Download SimpleRequest: " + this.url + ", Path:" + str2 + ", content_type:" + this.content_type);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (paramParcel == null) {
        return;
      }
      paramParcel.writeString(this.url);
      paramParcel.writeStringList(this.pathList);
      paramParcel.writeInt(this.content_type);
      if (this.mode == Downloader.DownloadMode.FastMode) {}
      for (paramInt = 0;; paramInt = 1)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.ipc.Const
 * JD-Core Version:    0.7.0.1
 */