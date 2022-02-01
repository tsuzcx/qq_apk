package com.huawei.hms.framework.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NetworkUtil
{
  private static final String TAG = NetworkUtil.class.getSimpleName();
  private static final int TYPE_WIFI_P2P = 13;
  
  public static String getDnsServerIps(Context paramContext)
  {
    return Arrays.toString(getDnsServerIpsFromConnectionManager(paramContext));
  }
  
  private static String[] getDnsServerIpsFromConnectionManager(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject = localLinkedList;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = localLinkedList;
      if (paramContext != null)
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        localObject = localLinkedList;
        if (paramContext == null) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject = paramContext.getActiveNetworkInfo();
        if (localObject == null) {
          break label158;
        }
        paramContext = getDnsServerIpsFromLinkProperties(paramContext, (NetworkInfo)localObject);
        localObject = paramContext;
      }
      catch (SecurityException paramContext)
      {
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + paramContext.getClass().getSimpleName());
        localObject = localLinkedList;
        continue;
      }
      catch (RuntimeException paramContext)
      {
        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + paramContext.getClass().getSimpleName());
        localObject = localLinkedList;
        continue;
      }
      if (((LinkedList)localObject).isEmpty()) {
        return new String[0];
      }
      return (String[])((LinkedList)localObject).toArray(new String[((LinkedList)localObject).size()]);
      label158:
      paramContext = localLinkedList;
    }
  }
  
  private static LinkedList<String> getDnsServerIpsFromLinkProperties(ConnectivityManager paramConnectivityManager, NetworkInfo paramNetworkInfo)
  {
    LinkedList localLinkedList = new LinkedList();
    Network[] arrayOfNetwork = paramConnectivityManager.getAllNetworks();
    if ((arrayOfNetwork == null) || (arrayOfNetwork.length == 0)) {
      return localLinkedList;
    }
    int j = arrayOfNetwork.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfNetwork[i];
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        NetworkInfo localNetworkInfo = paramConnectivityManager.getNetworkInfo((Network)localObject);
        if ((localNetworkInfo != null) && (localNetworkInfo.getType() == paramNetworkInfo.getType()))
        {
          localObject = paramConnectivityManager.getLinkProperties((Network)localObject);
          if (localObject != null)
          {
            localObject = ((LinkProperties)localObject).getDnsServers().iterator();
            while (((Iterator)localObject).hasNext()) {
              localLinkedList.add(((InetAddress)((Iterator)localObject).next()).getHostAddress());
            }
          }
        }
      }
    }
    return localLinkedList;
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getActiveNetworkInfo();
          return paramContext;
        }
        catch (SecurityException paramContext)
        {
          return null;
        }
      }
    }
    return null;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    int i = 0;
    if (paramContext != null) {
      i = getNetworkType(getNetworkInfo(paramContext));
    }
    return i;
  }
  
  public static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    int j = 2;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      int i = paramNetworkInfo.getType();
      if ((1 == i) || (13 == i))
      {
        i = 1;
        return i;
      }
      if (i == 0)
      {
        int k = paramNetworkInfo.getSubtype();
        switch (k)
        {
        default: 
          i = 0;
        }
        while ((i == 0) && (Build.VERSION.SDK_INT >= 25))
        {
          i = j;
          switch (k)
          {
          case 16: 
          default: 
            return 0;
            i = 2;
            continue;
            i = 3;
            continue;
            i = 4;
          }
        }
        return 3;
      }
      return 0;
      return i;
    }
    return -1;
  }
  
  public static String getSSIDByNetWorkId(Context paramContext)
  {
    return "";
  }
  
  public static final class NetType
  {
    public static final int TYPE_2G = 2;
    public static final int TYPE_3G = 3;
    public static final int TYPE_4G = 4;
    public static final int TYPE_NO_NETWORK = -1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.common.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */