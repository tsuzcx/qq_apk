package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.adapter.BaseAdapter.BaseCallBack;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class HmsClient
  extends BaseHmsClient
  implements AnyClient
{
  public HmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    super(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
  
  public void post(IMessageEntity paramIMessageEntity, String paramString, AnyClient.CallBack paramCallBack)
  {
    if (paramCallBack == null)
    {
      HMSLog.e("HmsClient", "callback is invalid, discard.");
      return;
    }
    if ((!(paramIMessageEntity instanceof RequestHeader)) || (paramString == null))
    {
      HMSLog.e("HmsClient", "arguments is invalid.");
      paramCallBack.onCallback(new ResponseHeader(1, 907135000, "Args is invalid"), new JSONObject().toString());
      return;
    }
    if (!isConnected())
    {
      HMSLog.e("HmsClient", "post failed for no connected.");
      paramCallBack.onCallback(new ResponseHeader(1, 907135001, "Not Connected"), new JSONObject().toString());
      return;
    }
    RequestHeader localRequestHeader = (RequestHeader)paramIMessageEntity;
    HMSLog.i("HmsClient", "post msg " + localRequestHeader);
    paramIMessageEntity = getClientSettings().getCpActivity();
    if (paramIMessageEntity == null) {}
    for (paramIMessageEntity = new BaseAdapter(this);; paramIMessageEntity = new BaseAdapter(this, paramIMessageEntity))
    {
      paramIMessageEntity.baseRequest(localRequestHeader.toJson(), paramString, localRequestHeader.getParcelable(), new a(this, paramCallBack));
      return;
    }
  }
  
  public void updateSessionId(String paramString)
  {
    if (TextUtils.isEmpty(this.sessionId)) {
      this.sessionId = paramString;
    }
  }
  
  static class a
    implements BaseAdapter.BaseCallBack
  {
    private final AnyClient.CallBack a;
    private final WeakReference<HmsClient> b;
    
    a(HmsClient paramHmsClient, AnyClient.CallBack paramCallBack)
    {
      this.a = paramCallBack;
      this.b = new WeakReference(paramHmsClient);
    }
    
    private void a(String paramString)
    {
      HmsClient localHmsClient = (HmsClient)this.b.get();
      if (localHmsClient != null) {
        localHmsClient.updateSessionId(paramString);
      }
    }
    
    private void a(String paramString1, String paramString2)
    {
      ResponseHeader localResponseHeader = new ResponseHeader();
      if (localResponseHeader.fromJson(paramString1))
      {
        HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
        a(localResponseHeader.getSessionId());
        this.a.onCallback(localResponseHeader, paramString2);
        return;
      }
      this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
    }
    
    private void a(String paramString1, String paramString2, Parcelable paramParcelable)
    {
      ResponseHeader localResponseHeader = new ResponseHeader();
      if (localResponseHeader.fromJson(paramString1))
      {
        localResponseHeader.setParcelable(paramParcelable);
        HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
        a(localResponseHeader.getSessionId());
        this.a.onCallback(localResponseHeader, paramString2);
        return;
      }
      this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
    }
    
    public void onComplete(String paramString1, String paramString2, Parcelable paramParcelable)
    {
      if (paramParcelable == null)
      {
        a(paramString1, paramString2);
        return;
      }
      a(paramString1, paramString2, paramParcelable);
    }
    
    public void onError(String paramString)
    {
      ResponseHeader localResponseHeader = new ResponseHeader();
      if (localResponseHeader.fromJson(paramString))
      {
        HMSLog.i("HmsClient", "receive msg " + localResponseHeader);
        a(localResponseHeader.getSessionId());
        this.a.onCallback(localResponseHeader, new JSONObject().toString());
        return;
      }
      this.a.onCallback(new ResponseHeader(1, 907135000, "response header json error"), new JSONObject().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.HmsClient
 * JD-Core Version:    0.7.0.1
 */