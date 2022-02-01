package com.tencent.qqmail.activity.networkanalyse;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqmail.utilities.log.NetworkAnalyseGeneralCallback;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.NetworkManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

class NetworkAnalyseHelper
{
  public static void debugDNS(String paramString, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    try
    {
      InetAddress localInetAddress = InetAddress.getByName(paramString);
      localStringBuilder.append(localInetAddress.getHostName()).append("\t:").append(localInetAddress.getHostAddress());
      if (paramNetworkAnalyseGeneralCallback != null)
      {
        localArrayList.add(localStringBuilder.toString());
        paramNetworkAnalyseGeneralCallback.onFinish(true, localArrayList, paramTextView, paramImageView);
      }
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      if (paramNetworkAnalyseGeneralCallback != null)
      {
        localArrayList.clear();
        localArrayList.add("dns " + paramString + " err.");
        paramNetworkAnalyseGeneralCallback.onFinish(false, localArrayList, paramTextView, paramImageView);
      }
      QMLog.log(6, "NetworkAnalyse", "debugDNS err:" + localUnknownHostException.toString());
    }
  }
  
  public static void debugPing(String paramString, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Runtime.getRuntime();
    int i;
    StringBuffer localStringBuffer;
    try
    {
      paramString = ((Runtime)localObject).exec("ping -c 3 " + paramString);
      i = paramString.waitFor();
      localObject = new BufferedReader(new InputStreamReader(paramString.getInputStream()));
      localStringBuffer = new StringBuffer();
      localStringBuffer.append("");
      for (;;)
      {
        String str = ((BufferedReader)localObject).readLine();
        if (str == null) {
          break;
        }
        localStringBuffer.append(str).append("\n");
      }
      ((BufferedReader)localObject).close();
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "QMApplicationContext", "debugPing err:" + paramString.toString());
      if (paramNetworkAnalyseGeneralCallback != null) {
        paramNetworkAnalyseGeneralCallback.onFinish(false, new ArrayList(), paramTextView, paramImageView);
      }
      return;
    }
    paramString.destroy();
    localStringBuilder.append(localStringBuffer.toString());
    paramString = new ArrayList();
    paramString.add(localStringBuilder.toString());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramNetworkAnalyseGeneralCallback.onFinish(bool, paramString, paramTextView, paramImageView);
      return;
    }
  }
  
  public static void debugSendRequest(NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder1.append("");
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnComplete(new NetworkAnalyseHelper.1(localStringBuilder1, localStringBuilder2, paramNetworkAnalyseGeneralCallback, paramTextView, paramImageView));
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest("https://i.mail.qq.com");
    localQMNetworkRequest.setRequestCallback(localQMCallback);
    NetworkManager.sharedInstance().sendRequest(localQMNetworkRequest);
    localQMCallback = new QMCallback();
    localQMCallback.setOnComplete(new NetworkAnalyseHelper.2(localStringBuilder1, localStringBuilder2, paramNetworkAnalyseGeneralCallback, paramTextView, paramImageView));
    paramNetworkAnalyseGeneralCallback = new QMNetworkRequest("http://i.mail.qq.com");
    paramNetworkAnalyseGeneralCallback.setRequestCallback(localQMCallback);
    NetworkManager.sharedInstance().sendRequest(paramNetworkAnalyseGeneralCallback);
  }
  
  public static void debugSocket(String paramString, int paramInt, NetworkAnalyseGeneralCallback paramNetworkAnalyseGeneralCallback, TextView paramTextView, ImageView paramImageView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = paramString + " port: " + paramInt;
    localStringBuilder.append("Try connect host: ");
    localStringBuilder.append((String)localObject);
    localObject = new ArrayList();
    try
    {
      Socket localSocket = SocketChannel.open().socket();
      localSocket.setSoTimeout(10000);
      localSocket.connect(new InetSocketAddress(paramString, paramInt), 10000);
      if (paramNetworkAnalyseGeneralCallback != null)
      {
        localStringBuilder.append(" Connect host success ");
        ((List)localObject).add(localStringBuilder.toString());
        paramNetworkAnalyseGeneralCallback.onFinish(true, (List)localObject, paramTextView, paramImageView);
      }
      if (localSocket != null) {
        localSocket.close();
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        QMLog.log(6, "QMApplicationContext", "debugSocket err:" + localException.toString() + " ip: " + paramString + " port: " + paramInt);
        localStringBuilder.append(" Connect host error ");
        ((List)localObject).add(localStringBuilder.toString());
      } while (paramNetworkAnalyseGeneralCallback == null);
      paramNetworkAnalyseGeneralCallback.onFinish(false, (List)localObject, paramTextView, paramImageView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseHelper
 * JD-Core Version:    0.7.0.1
 */