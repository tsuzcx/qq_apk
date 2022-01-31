package com.tencent.common.config.provider;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkStateForConfig
  extends BroadcastReceiver
{
  public static final int a = 0;
  private static Uri jdField_a_of_type_AndroidNetUri;
  private static NetworkStateForConfig jdField_a_of_type_ComTencentCommonConfigProviderNetworkStateForConfig = null;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "[0]";
  private static Map jdField_a_of_type_JavaUtilMap;
  public static final int b = 1;
  private static final String b = NetworkStateForConfig.class.getName();
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  private static int g = 0;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private String c = null;
  private String d = null;
  private int f = 17;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://telephony/carriers/preferapn");
    jdField_a_of_type_JavaUtilMap.put("unknown", Integer.valueOf(0));
    jdField_a_of_type_JavaUtilMap.put("cmnet", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilMap.put("cmwap", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilMap.put("3gnet", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilMap.put("3gwap", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilMap.put("uninet", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilMap.put("uniwap", Integer.valueOf(6));
    jdField_a_of_type_JavaUtilMap.put("wifi", Integer.valueOf(7));
    jdField_a_of_type_JavaUtilMap.put("ctwap", Integer.valueOf(8));
    jdField_a_of_type_JavaUtilMap.put("ctnet", Integer.valueOf(9));
    jdField_a_of_type_JavaUtilMap.put("cmcc", Integer.valueOf(10));
    jdField_a_of_type_JavaUtilMap.put("unicom", Integer.valueOf(11));
    jdField_a_of_type_JavaUtilMap.put("cmct", Integer.valueOf(12));
  }
  
  public NetworkStateForConfig()
  {
    a();
    this.jdField_a_of_type_AndroidNetConnectivityManager = ((ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity"));
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private static int a(NetworkInfo paramNetworkInfo)
  {
    switch (paramNetworkInfo.getType())
    {
    }
    for (;;)
    {
      g = 0;
      return g;
      g = 1;
      return g;
      switch (paramNetworkInfo.getSubtype())
      {
      }
    }
    g = 3;
    return g;
    g = 2;
    return g;
  }
  
  public static NetworkStateForConfig a()
  {
    if (jdField_a_of_type_ComTencentCommonConfigProviderNetworkStateForConfig == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentCommonConfigProviderNetworkStateForConfig == null) {
        jdField_a_of_type_ComTencentCommonConfigProviderNetworkStateForConfig = new NetworkStateForConfig();
      }
      return jdField_a_of_type_ComTencentCommonConfigProviderNetworkStateForConfig;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      NetworkStateForConfig.NetworkStateListener[] arrayOfNetworkStateListener = new NetworkStateForConfig.NetworkStateListener[this.jdField_a_of_type_JavaUtilList.size()];
      this.jdField_a_of_type_JavaUtilList.toArray(arrayOfNetworkStateListener);
      if (arrayOfNetworkStateListener != null)
      {
        int j = arrayOfNetworkStateListener.length;
        int i = 0;
        if (i < j)
        {
          arrayOfNetworkStateListener[i].a(paramBoolean);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null)
    {
      QLog.i("TimeMonitor", 2, b + "\t isNetworkConnected false, connectivity is null, time:" + (System.currentTimeMillis() - l));
      return false;
    }
    paramContext = paramContext.getAllNetworkInfo();
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].isConnected())
        {
          a(paramContext[i]);
          QLog.i("TimeMonitor", 2, b + "\t isNetworkConnected true, time:" + (System.currentTimeMillis() - l));
          return true;
        }
        i += 1;
      }
    }
    QLog.i("TimeMonitor", 2, b + "\t isNetworkConnected, return false, time:" + (System.currentTimeMillis() - l));
    return false;
  }
  
  public int a()
  {
    Object localObject2 = null;
    Object localObject1 = (ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
    if (localObject1 == null) {
      return 0;
    }
    NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)localObject1).getAllNetworkInfo();
    localObject1 = localObject2;
    if (arrayOfNetworkInfo != null) {
      i = 0;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (i < arrayOfNetworkInfo.length)
      {
        if (arrayOfNetworkInfo[i].isConnectedOrConnecting()) {
          localObject1 = arrayOfNetworkInfo[i];
        }
      }
      else
      {
        if (localObject1 == null) {
          break;
        }
        if (1 != ((NetworkInfo)localObject1).getType()) {
          break label81;
        }
        return 4;
      }
      i += 1;
    }
    label81:
    int i = 5;
    if (jdField_a_of_type_JavaUtilMap.get(((NetworkInfo)localObject1).getExtraInfo()) != null) {
      i = ((Integer)jdField_a_of_type_JavaUtilMap.get(((NetworkInfo)localObject1).getExtraInfo())).intValue();
    }
    switch (i)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
    case 10: 
      return 1;
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 11: 
      return 2;
    case 8: 
    case 9: 
    case 12: 
      return 3;
    }
    return 4;
  }
  
  public NetworkStateForConfig.ApnNode a()
  {
    Object localObject3 = null;
    String str2 = "";
    Object localObject4 = "";
    Object localObject1;
    String str1;
    if (Build.VERSION.SDK_INT < this.f)
    {
      localObject4 = this.jdField_a_of_type_AndroidContentContext.getContentResolver().query(jdField_a_of_type_AndroidNetUri, null, null, null, null);
      localObject2 = localObject3;
      if (localObject4 != null)
      {
        localObject1 = "";
        for (str1 = ""; ((Cursor)localObject4).moveToNext(); str1 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("apn")).toLowerCase()) {
          localObject1 = ((Cursor)localObject4).getString(((Cursor)localObject4).getColumnIndex("name"));
        }
        ((Cursor)localObject4).close();
        if (TextUtils.getTrimmedLength(str1) <= 0)
        {
          localObject2 = localObject3;
          if (TextUtils.getTrimmedLength((CharSequence)localObject1) <= 0) {}
        }
        else
        {
          localObject2 = new NetworkStateForConfig.ApnNode();
          ((NetworkStateForConfig.ApnNode)localObject2).b((String)localObject1);
          ((NetworkStateForConfig.ApnNode)localObject2).a(str1);
        }
      }
      return localObject2;
    }
    if (this.jdField_a_of_type_AndroidNetConnectivityManager != null) {}
    for (Object localObject2 = this.jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();; localObject2 = null)
    {
      localObject1 = localObject4;
      str1 = str2;
      if (localObject2 == null) {
        break;
      }
      if (NetworkUtil.a((NetworkInfo)localObject2))
      {
        if (((NetworkInfo)localObject2).getExtraInfo() != null) {}
        for (str1 = ((NetworkInfo)localObject2).getExtraInfo().toLowerCase();; str1 = "unknown")
        {
          localObject1 = localObject4;
          break;
        }
      }
      localObject1 = localObject4;
      str1 = str2;
      if (((NetworkInfo)localObject2).getType() != 1) {
        break;
      }
      str1 = "wifi";
      localObject1 = localObject4;
      break;
    }
  }
  
  public String a()
  {
    String str;
    if (TextUtils.isEmpty(this.d))
    {
      str = ((TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone")).getSubscriberId();
      if ((str != null) && (!"".equals(str))) {
        break label51;
      }
      this.d = "unknown";
    }
    for (;;)
    {
      return this.d;
      label51:
      if ((str.startsWith("46000")) || (str.startsWith("46002"))) {
        this.d = "ChinaMobile";
      } else if (str.startsWith("46001")) {
        this.d = "ChinaUnicom";
      } else if (str.startsWith("46003")) {
        this.d = "ChinaTelecom";
      } else {
        this.d = "unknown";
      }
    }
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter(new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    try
    {
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(NetworkStateForConfig.NetworkStateListener paramNetworkStateListener)
  {
    if (paramNetworkStateListener == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNetworkStateListener)) {
        this.jdField_a_of_type_JavaUtilList.add(paramNetworkStateListener);
      }
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return true;
    }
    return a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public int b()
  {
    return g;
  }
  
  public String b()
  {
    if (g == 1)
    {
      QLog.d("ConfigProvider", 2, "mCurrentAPN:WIFI");
      return "wifi";
    }
    NetworkStateForConfig.ApnNode localApnNode;
    if ((this.c == null) || (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      localApnNode = a();
      if (localApnNode == null) {
        break label91;
      }
    }
    label91:
    for (this.c = localApnNode.a();; this.c = "unknown")
    {
      QLog.d("ConfigProvider", 2, "mCurrentAPN:" + this.c);
      return this.c;
    }
  }
  
  public void b(NetworkStateForConfig.NetworkStateListener paramNetworkStateListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramNetworkStateListener);
      return;
    }
  }
  
  public boolean b()
  {
    boolean bool1;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      bool1 = true;
    }
    NetworkInfo localNetworkInfo;
    boolean bool2;
    do
    {
      return bool1;
      localNetworkInfo = ((ConnectivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {
        return false;
      }
      bool2 = localNetworkInfo.isConnected();
      bool1 = bool2;
    } while (bool2);
    QLog.e(b, 2, "isNetworkEnable() : FALSE with TYPE = " + localNetworkInfo.getType());
    return bool2;
  }
  
  public boolean c()
  {
    NetworkInfo localNetworkInfo = this.jdField_a_of_type_AndroidNetConnectivityManager.getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.getType() == 1);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().compareTo("android.net.conn.CONNECTIVITY_CHANGE") == 0)
    {
      boolean bool = a();
      a(bool);
      if (bool) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.NetworkStateForConfig
 * JD-Core Version:    0.7.0.1
 */