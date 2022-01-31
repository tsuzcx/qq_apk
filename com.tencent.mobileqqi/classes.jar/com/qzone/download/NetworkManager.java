package com.qzone.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.qzone.common.DnsService;
import com.qzone.common.logging.QDLog;
import com.qzone.download.uinterface.IDownloadConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkManager
{
  private static Object LOCK_NETLSTENER = new Object();
  public static final int Operator_CMCC = 1;
  public static final int Operator_CMCT = 3;
  public static final int Operator_Unicom = 2;
  public static final int Operator_Unknown = 0;
  public static final int Operator_WIFI = 4;
  private static Context mContext;
  private static List<WeakReference<NetStatusListener>> mNetworkListener = Collections.synchronizedList(new ArrayList());
  private static NetworkChangeReceiver sNetworkChangeReceiver;
  
  public static String getApnValue()
  {
    Object localObject = "none";
    if (sNetworkChangeReceiver == null) {}
    String str;
    do
    {
      return localObject;
      str = sNetworkChangeReceiver.getApn();
      localObject = str;
    } while (str != "none");
    return sNetworkChangeReceiver.getApnValue();
  }
  
  public static String getBSSID()
  {
    WifiInfo localWifiInfo = ((WifiManager)mContext.getSystemService("wifi")).getConnectionInfo();
    if (localWifiInfo != null) {
      return localWifiInfo.getBSSID();
    }
    return null;
  }
  
  public static int getISPType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i;
    if ((paramString.contains("cmnet")) || (paramString.contains("cmwap")) || (paramString.contains("cmcc"))) {
      i = 1;
    }
    for (;;)
    {
      return i;
      if ((paramString.contains("uninet")) || (paramString.contains("uniwap")) || (paramString.contains("unicom")) || (paramString.contains("3gnet")) || (paramString.contains("3gwap"))) {
        i = 2;
      } else if ((paramString.contains("ctwap")) || (paramString.contains("ctnet")) || (paramString.contains("cmct")) || (paramString.contains("#777"))) {
        i = 3;
      } else {
        i = getOperator();
      }
    }
  }
  
  public static int getIspType()
  {
    return getISPType(getApnValue());
  }
  
  private static int getOperator()
  {
    if (DownloaderFactory.getDownloadConfig() != null) {
      return DownloaderFactory.getDownloadConfig().getOperator();
    }
    return 0;
  }
  
  public static void init(Context paramContext)
  {
    mContext = paramContext;
    sNetworkChangeReceiver = new NetworkChangeReceiver(paramContext);
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(sNetworkChangeReceiver, localIntentFilter);
  }
  
  public static boolean isMobile()
  {
    NetworkInfo localNetworkInfo = null;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
    if (localConnectivityManager != null) {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    }
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {}
    while (localNetworkInfo.getType() != 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = null;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
    if (localConnectivityManager != null) {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    }
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }
  
  public static boolean isWap()
  {
    String str = getApnValue();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.contains("cmwap")) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap"))) {
      return false;
    }
    return true;
  }
  
  public static boolean isWifi()
  {
    boolean bool = true;
    NetworkInfo localNetworkInfo = null;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
    if (localConnectivityManager != null) {
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    }
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      bool = false;
    }
    while (1 == localNetworkInfo.getType()) {
      return bool;
    }
    return false;
  }
  
  public static void registNetStatusListener(NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    if (localWeakReference != null) {
      synchronized (LOCK_NETLSTENER)
      {
        mNetworkListener.add(localWeakReference);
        return;
      }
    }
  }
  
  public static void unregistNetStatusListener(NetStatusListener paramNetStatusListener)
  {
    synchronized (LOCK_NETLSTENER)
    {
      Iterator localIterator = mNetworkListener.iterator();
      WeakReference localWeakReference;
      do
      {
        if (!localIterator.hasNext()) {
          return;
        }
        localWeakReference = (WeakReference)localIterator.next();
      } while ((NetStatusListener)localWeakReference.get() != paramNetStatusListener);
      mNetworkListener.remove(localWeakReference);
    }
  }
  
  public static final class APNName
  {
    public static final String NAME_3GNET = "3gnet";
    public static final String NAME_3GWAP = "3gwap";
    public static final String NAME_777 = "#777";
    public static final String NAME_CMCC = "cmcc";
    public static final String NAME_CMCT = "cmct";
    public static final String NAME_CMNET = "cmnet";
    public static final String NAME_CMWAP = "cmwap";
    public static final String NAME_CTNET = "ctnet";
    public static final String NAME_CTWAP = "ctwap";
    public static final String NAME_NONE = "none";
    public static final String NAME_UNICOM = "unicom";
    public static final String NAME_UNINET = "uninet";
    public static final String NAME_UNIWAP = "uniwap";
    public static final String NAME_UNKNOWN = "unknown";
    public static final String NAME_WIFI = "wifi";
  }
  
  public static abstract interface NetStatusListener
  {
    public abstract void onNetworkChanged(String paramString1, String paramString2);
  }
  
  public static class NetworkChangeReceiver
    extends BroadcastReceiver
  {
    private String mApn = "none";
    private Context mContext;
    private int mIsp = 0;
    
    public NetworkChangeReceiver(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public String getApn()
    {
      return this.mApn;
    }
    
    public String getApnValue()
    {
      NetworkInfo localNetworkInfo = null;
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
        return "none";
      }
      if (1 == localNetworkInfo.getType()) {
        return "wifi";
      }
      if (localNetworkInfo.getExtraInfo() != null) {
        return localNetworkInfo.getExtraInfo().toLowerCase();
      }
      return "unknown";
    }
    
    public Context getContext()
    {
      return this.mContext;
    }
    
    public boolean isNetworkAvailable()
    {
      NetworkInfo localNetworkInfo = null;
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
    }
    
    public void onReceive(Context arg1, Intent paramIntent)
    {
      int i;
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
      {
        paramIntent = getApnValue();
        i = NetworkManager.getISPType(paramIntent);
        QDLog.i("downloader", "old apn:" + this.mApn + "  new apn:" + paramIntent + " old isp:" + this.mIsp + " new isp:" + i);
        if (paramIntent.equals(this.mApn)) {}
      }
      synchronized (NetworkManager.LOCK_NETLSTENER)
      {
        Iterator localIterator = NetworkManager.mNetworkListener.iterator();
        NetworkManager.NetStatusListener localNetStatusListener;
        do
        {
          if (!localIterator.hasNext())
          {
            this.mApn = paramIntent;
            this.mIsp = i;
            if ((isNetworkAvailable()) && (!paramIntent.equals(this.mApn))) {
              DnsService.getInstance().reset();
            }
            return;
          }
          localNetStatusListener = (NetworkManager.NetStatusListener)((WeakReference)localIterator.next()).get();
        } while (localNetStatusListener == null);
        localNetStatusListener.onNetworkChanged(this.mApn, paramIntent);
      }
    }
    
    public void setApn(String paramString)
    {
      this.mApn = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.NetworkManager
 * JD-Core Version:    0.7.0.1
 */