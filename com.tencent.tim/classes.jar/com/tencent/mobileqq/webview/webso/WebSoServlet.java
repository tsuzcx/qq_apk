package com.tencent.mobileqq.webview.webso;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import arcz;
import ardb;
import ardk;
import avpw;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import wns_proxy.HttpReq;

public class WebSoServlet
  extends MSFServlet
{
  private ToServiceMsg h;
  private long startTime;
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2)
  {
    return a(paramIntent, paramLong, paramString1, paramHttpReq, paramString2, 60000, 100, WebSoService.class);
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2, int paramInt1, int paramInt2, Class<? extends BusinessObserver> paramClass)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("hostUin", paramLong);
    localIntent.putExtra("key_req", paramHttpReq);
    localIntent.putExtra("refer", paramString2);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("key_time_out", paramInt1);
    localIntent.putExtra("key_request_code", paramInt2);
    localIntent.putExtra("key_receive_class", paramClass);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, long paramLong, String paramString1, HttpReq paramHttpReq, String paramString2, int paramInt1, int paramInt2, String paramString3, Class<? extends BusinessObserver> paramClass)
  {
    paramIntent = a(paramIntent, paramLong, paramString1, paramHttpReq, paramString2, paramInt1, paramInt2, paramClass);
    paramIntent.putExtra("key_uni_key", paramString3);
    return paramIntent;
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return null;
    }
    String[] arrayOfString = new String[5];
    long l1 = paramToServiceMsg.extraData.getLong("sendTime", 0L);
    long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
    long l5 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
    long l8 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
    long l3 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
    long l4 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
    long l2 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
    long l7 = System.currentTimeMillis();
    arrayOfString[1] = String.valueOf(l7 - l1);
    arrayOfString[2] = String.valueOf(l7 - l3);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handler");
    if (l6 != 0L)
    {
      paramToServiceMsg.append("|").append(String.valueOf(l6 - l1)).append("|app");
      l1 = l6;
    }
    for (;;)
    {
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|").append(String.valueOf(l5 - l1)).append("|msf");
        l1 = l5;
      }
      for (;;)
      {
        if (l8 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l8 - l1)).append("|net");
        }
        arrayOfString[3] = paramToServiceMsg.toString();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("net");
        if (l4 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l4 - l3)).append("|msf");
        }
        for (l1 = l4;; l1 = l3)
        {
          if (l2 != 0L)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l2 - l1)).append("|app");
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l7 - l1)).append("|handler");
            arrayOfString[4] = paramToServiceMsg.toString();
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("{");
            paramToServiceMsg.append("total:").append(arrayOfString[1]).append(",");
            paramToServiceMsg.append("recv:").append(arrayOfString[2]).append(",");
            paramToServiceMsg.append("sendDetail:").append(arrayOfString[3]).append(",");
            paramToServiceMsg.append("recvDetail:").append(arrayOfString[4]);
            paramToServiceMsg.append("}");
            arrayOfString[0] = paramToServiceMsg.toString();
            return arrayOfString;
          }
        }
      }
    }
  }
  
  private static boolean aGl()
  {
    return 1 == QzoneConfig.getInstance().getConfig("QZoneSetting", "enableWnsCgiOptimization", 1);
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if ((paramClass == arcz.class) && (aGl()))
    {
      paramIntent = new ReceiveRunnable(paramInt, paramBoolean, paramBundle);
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").getHandler().post(paramIntent);
      return;
    }
    super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null) {
      if (QLog.isColorLevel()) {
        QLog.e("WebSoServlet", 2, "onReceive, request is null");
      }
    }
    Bundle localBundle;
    String str;
    int j;
    Class localClass;
    do
    {
      return;
      localBundle = new Bundle();
      str = paramIntent.getStringExtra("url");
      localBundle.putString("url", str);
      if (paramFromServiceMsg != null)
      {
        localBundle.putInt("rsp_code", paramFromServiceMsg.getResultCode());
        localBundle.putString("rsp_message", paramFromServiceMsg.getBusinessFailMsg());
      }
      j = paramIntent.getIntExtra("key_request_code", 100);
      localClass = (Class)paramIntent.getSerializableExtra("key_receive_class");
    } while (localClass == null);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("receive url: ").append(str).append(", code: ");
      if (paramFromServiceMsg == null) {
        break label426;
      }
    }
    label426:
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      QLog.d("WebSoServlet", 2, i);
      localBundle.putString("key_uni_key", paramIntent.getStringExtra("key_uni_key"));
      if (paramFromServiceMsg != null)
      {
        localObject = paramFromServiceMsg.getAttribute("_tag_socket");
        paramIntent = new String[2];
        if (localObject != null)
        {
          localObject = localObject.toString().split(":");
          paramIntent = (Intent)localObject;
          if (localObject != null)
          {
            paramIntent = (Intent)localObject;
            if (localObject.length > 1)
            {
              localBundle.putString("key_server_ip", localObject[0]);
              localBundle.putString("key_server_port", localObject[1]);
              paramIntent = (Intent)localObject;
            }
          }
        }
        localBundle.putString("key_user_ip", "");
        if ((paramIntent != null) && (paramIntent.length > 0)) {
          localBundle.putString("key_dns_result", paramIntent[0]);
        }
        localBundle.putInt("key_time_cost", (int)(System.currentTimeMillis() - this.startTime));
      }
      if (paramFromServiceMsg != null)
      {
        paramIntent = a(this.h, paramFromServiceMsg);
        avpw.a(null, ardk.qk(str), paramFromServiceMsg.getResultCode(), paramIntent[0], 1, System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("WebSoServlet", 2, "WebSo url: " + str + ", req time cost: " + paramIntent[0]);
        }
        localBundle.putString("key_detail_info", paramIntent[0]);
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
        break label499;
      }
      paramIntent = paramFromServiceMsg.getWupBuffer();
      paramFromServiceMsg = ardb.qe(ardk.qj(str));
      if (!TextUtils.isEmpty(paramFromServiceMsg)) {
        break;
      }
      QLog.w("WebSoServlet", 1, "uniKey is EMPTY OR NULL !!!");
      return;
    }
    localBundle.putInt("rsp_code", 0);
    paramIntent = ardb.a(paramIntent, paramFromServiceMsg);
    if (paramIntent != null)
    {
      localBundle.putSerializable("rsp_data", paramIntent);
      notifyObserver(null, j, true, localBundle, localClass);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebSoServlet", 2, "inform WebSoServlet isSuccess false");
    }
    notifyObserver(null, j, false, localBundle, localClass);
    return;
    label499:
    if (QLog.isColorLevel()) {
      QLog.d("WebSoServlet", 2, "inform WebSoServlet resultcode fail.");
    }
    notifyObserver(null, j, false, localBundle, localClass);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("hostUin", 0L);
    HttpReq localHttpReq = (HttpReq)paramIntent.getSerializableExtra("key_req");
    String str2 = paramIntent.getStringExtra("refer");
    String str1 = paramIntent.getStringExtra("url");
    int i = paramIntent.getIntExtra("key_time_out", 60000);
    paramIntent = new ardb(ardk.qj(str1), l, localHttpReq, str2).encode();
    if (paramIntent == null) {
      paramIntent = new byte[4];
    }
    for (;;)
    {
      if (i <= 0) {}
      for (l = 60000L;; l = i)
      {
        paramPacket.setTimeout(l);
        paramPacket.setSSOCommand(ardk.qk(str1));
        paramPacket.putSendData(paramIntent);
        if (QLog.isColorLevel()) {
          QLog.d("WebSoServlet", 2, "send req url: " + str1);
        }
        this.startTime = System.currentTimeMillis();
        return;
      }
    }
  }
  
  public void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.h = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
  
  static class ReceiveRunnable
    implements Runnable
  {
    private Bundle mData;
    private boolean mIsSuccess;
    private int mType;
    
    public ReceiveRunnable(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      this.mType = paramInt;
      this.mIsSuccess = paramBoolean;
      this.mData = paramBundle;
    }
    
    public void run()
    {
      arcz.a().onReceive(this.mType, this.mIsSuccess, this.mData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.webso.WebSoServlet
 * JD-Core Version:    0.7.0.1
 */