package com.tencent.mobileqq.msf.core.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.l;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.utils.a;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class c
  extends BroadcastReceiver
{
  public static final String a = "MSF.C.MonitorNetFlowStore";
  public static final String d = "com.tencent.mobileqq.msf.core.report.alarmAction";
  static final String e = "SQQzoneSvcDev";
  public static final String f = "MONITOR_NetflowRdmReport";
  public static final String g = "MONITOR_NetflowRdmReport_TIME";
  public static final int h = 1;
  static SimpleDateFormat i = new SimpleDateFormat("dd HH:mm:ss");
  public ConcurrentHashMap b = new ConcurrentHashMap();
  public ConcurrentHashMap c = new ConcurrentHashMap();
  final String j = "dataflow";
  private MsfCore k;
  private Context l;
  private AlarmManager m;
  private String n = "";
  private PendingIntent o;
  private b p;
  private SQLiteDatabase q;
  
  public c(MsfCore paramMsfCore, Context paramContext)
  {
    this.k = paramMsfCore;
    this.l = paramContext;
    a(this.l);
  }
  
  private void a()
  {
    int i2 = 0;
    try
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MonitorNetFlowStore", 2, "write data : " + this.b.size() + " | read data : " + this.c.size() + ", starting to store.");
      }
      Iterator localIterator = this.b.keySet().iterator();
      int i1 = 0;
      String str;
      a locala;
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.b.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|write|" + locala.f + "|" + locala.g);
        }
        this.q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime) values(?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.g(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1) });
        i1 = (int)(i1 + ((a)this.b.get(str)).f);
        this.b.remove(str);
      }
      localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        locala = (a)this.c.get(str);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.MonitorNetFlowStore", 2, "mType|" + locala.h + "|" + locala.b + "|" + locala.d + "|read|" + locala.f + "|" + locala.g);
        }
        this.q.execSQL("insert into dataflow(processName, uin, ip, refer, port, flag, buffersize, networktype, mType, curtime) values(?,?,?,?,?,?,?,?,?,?)", new Object[] { locala.a, this.k.sender.g(), locala.b, locala.c, Integer.valueOf(locala.d), Integer.valueOf(locala.e), Long.valueOf(locala.f), Integer.valueOf(locala.g), locala.h, Long.valueOf(l1) });
        long l2 = i2;
        i2 = (int)(((a)this.c.get(str)).f + l2);
        this.c.remove(str);
      }
      QLog.d("MSF.D.MonitorSocket", 1, "write data lenth : " + i1 + " | read data lenth : " + i2 + ", has been stored.");
      f.a(System.currentTimeMillis(), 1);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("MSF.C.MonitorNetFlowStore", 1, "data store failed.", localException);
    }
  }
  
  private void a(Context paramContext)
  {
    this.n = (MsfSdkUtils.getProcessName(paramContext) + "_" + getClass().hashCode());
    paramContext = new IntentFilter();
    paramContext.addAction(this.n);
    BaseApplication.getContext().registerReceiver(this, paramContext);
    paramContext = Calendar.getInstance();
    paramContext.set(6, paramContext.get(6));
    paramContext.set(11, paramContext.get(11));
    paramContext.set(12, 0);
    paramContext.set(13, 0);
    paramContext.set(14, 0);
    a(paramContext.getTimeInMillis() + 3600000L);
  }
  
  public void a(long paramLong)
  {
    Intent localIntent = new Intent(this.n);
    localIntent.setAction(this.n);
    this.o = PendingIntent.getBroadcast(BaseApplication.getContext(), 0, localIntent, 0);
    this.m = ((AlarmManager)BaseApplication.getContext().getSystemService("alarm"));
    this.m.setRepeating(0, paramLong, 3600000L, this.o);
    QLog.d("MSF.D.MonitorSocket", 1, "register " + this.n.hashCode() + " alarm alive send at " + i.format(Long.valueOf(paramLong)));
  }
  
  public void a(a parama)
  {
    try
    {
      switch (parama.e)
      {
      case 0: 
        locala = (a)this.b.get(parama.h);
        if (locala != null)
        {
          this.b.put(parama.h, locala.a(parama.f));
          return;
        }
        break;
      }
    }
    catch (Exception parama)
    {
      QLog.d("MSF.D.MonitorSocket", 1, "MonitorDataFlow cache failed.", parama);
      return;
    }
    this.b.put(parama.h, parama);
    return;
    a locala = (a)this.c.get(parama.h);
    if (locala != null)
    {
      this.c.put(parama.h, locala.a(parama.f));
      return;
    }
    this.c.put(parama.h, parama);
    return;
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = paramToServiceMsg.extraData;
        a locala = new a(paramToServiceMsg.getString("ip"), paramToServiceMsg.getString("refer"), paramToServiceMsg.getInt("port"), paramToServiceMsg.getInt("flag"), paramToServiceMsg.getLong("buffersize"), paramToServiceMsg.getInt("networktype"));
        locala.a = paramToServiceMsg.getString("processName");
        int i1 = paramToServiceMsg.getString("mType").indexOf(".");
        if (i1 != -1)
        {
          if (paramToServiceMsg.getString("mType").indexOf(".", i1 + 1) != -1)
          {
            locala.h = paramToServiceMsg.getString("mType");
            a(locala);
            return;
          }
          locala.h = paramToServiceMsg.getString("mType").substring(0, i1);
          continue;
        }
        locala.h = paramToServiceMsg.getString("mType");
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "ToServiceMsg analysis error.", paramToServiceMsg);
        return;
      }
    }
  }
  
  public HashMap b(long paramLong)
  {
    Object localObject4;
    Object localObject5;
    HashMap localHashMap;
    String str;
    int i1;
    label383:
    StringBuilder localStringBuilder;
    for (;;)
    {
      try
      {
        Object localObject1 = this.l.getAssets().open("xgwifi.xml");
        localObject4 = new Properties();
        ((Properties)localObject4).loadFromXML((InputStream)localObject1);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).set(6, ((Calendar)localObject1).get(6) - 1);
        ((Calendar)localObject1).set(11, 0);
        ((Calendar)localObject1).set(12, 0);
        ((Calendar)localObject1).set(13, 0);
        ((Calendar)localObject1).set(14, 0);
        paramLong = ((Calendar)localObject1).getTimeInMillis();
        if (this.p == null) {
          this.p = new b(this.l);
        }
        if (this.q == null) {
          this.q = this.p.getWritableDatabase();
        }
        localObject5 = this.q.query("dataflow", new String[] { "processName", "uin", "buffersize", "mType", "networktype" }, "curtime >= ? and curtime <= ?", new String[] { String.valueOf(paramLong), String.valueOf(paramLong + 86400000L) }, null, null, null);
        if (localObject5 == null) {
          return null;
        }
        localHashMap = new HashMap();
        ((Cursor)localObject5).moveToFirst();
        if (((Cursor)localObject5).isAfterLast()) {
          break label821;
        }
        localObject3 = ((Cursor)localObject5).getString(0);
        str = ((Cursor)localObject5).getString(1);
        paramLong = ((Cursor)localObject5).getLong(2);
        localObject1 = ((Cursor)localObject5).getString(3);
        i1 = ((Cursor)localObject5).getInt(4);
        if ((i1 == 1) || (i1 == 2)) {
          break label977;
        }
        i1 = 1;
        if ((!((String)localObject3).contains(":")) || (((String)localObject3).endsWith("MSF")) || (((String)localObject3).endsWith("picture"))) {
          break label974;
        }
        int i2 = ((String)localObject3).indexOf(":");
        localObject1 = ((String)localObject3).substring(i2 + 1, i2 + 2).toUpperCase() + ((String)localObject3).substring(i2 + 2);
        if (((String)localObject1).startsWith("SQQzoneSvcDev"))
        {
          localObject3 = (String)((Properties)localObject4).get("SQQzoneSvcDev" + i1);
          if (!localHashMap.containsKey(str)) {
            break;
          }
          if (localObject3 != null) {
            break label620;
          }
          localStringBuilder = new StringBuilder();
          if (i1 != 1) {
            break label980;
          }
          localObject3 = "XG";
          label456:
          localObject1 = (String)localObject3 + (String)localObject1 + "Flow";
          if (!((HashMap)localHashMap.get(str)).containsKey(localObject1)) {
            break label597;
          }
          ((HashMap)localHashMap.get(str)).put(localObject1, Long.valueOf(((Long)((HashMap)localHashMap.get(str)).get(localObject1)).longValue() + paramLong));
          label539:
          ((Cursor)localObject5).moveToNext();
          continue;
        }
        localObject3 = (String)((Properties)localObject4).get(localException + i1);
      }
      catch (Exception localException)
      {
        QLog.d("MSF.C.MonitorNetFlowStore", 1, "read net flow statistics failed.", localException);
        return null;
      }
      continue;
      label597:
      ((HashMap)localHashMap.get(str)).put(localException, Long.valueOf(paramLong));
      continue;
      label620:
      if (((HashMap)localHashMap.get(str)).containsKey(localObject3)) {
        ((HashMap)localHashMap.get(str)).put(localObject3, Long.valueOf(((Long)((HashMap)localHashMap.get(str)).get(localObject3)).longValue() + paramLong));
      } else {
        ((HashMap)localHashMap.get(str)).put(localObject3, Long.valueOf(paramLong));
      }
    }
    if (localObject3 == null)
    {
      localStringBuilder = new StringBuilder();
      if (i1 != 1) {
        break label988;
      }
    }
    label821:
    label974:
    label977:
    label980:
    label988:
    for (Object localObject3 = "XG";; localObject3 = "WiFi")
    {
      Object localObject2 = (String)localObject3 + localException + "Flow";
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, Long.valueOf(paramLong));
      localHashMap.put(str, localObject3);
      break label539;
      localObject2 = new HashMap();
      ((HashMap)localObject2).put(localObject3, Long.valueOf(paramLong));
      localHashMap.put(str, localObject2);
      break label539;
      if (QLog.isColorLevel())
      {
        localObject2 = localHashMap.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = ((HashMap)localHashMap.get(localObject3)).keySet().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (String)((Iterator)localObject4).next();
            QLog.d("MSF.C.MonitorNetFlowStore", 2, "report RDM data for " + MsfSdkUtils.getShortUin((String)localObject3) + ", mType : " + (String)localObject5 + "|buffersize : " + ((HashMap)localHashMap.get(localObject3)).get(localObject5));
          }
        }
      }
      return localHashMap;
      break label383;
      break;
      localObject3 = "WiFi";
      break label456;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals(this.n)) {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "receive broadcast : " + paramIntent.getAction() + ", start to store socket flow at " + i.format(Long.valueOf(System.currentTimeMillis())));
      }
    }
    try
    {
      if (this.p == null) {
        this.p = new b(paramContext);
      }
      if (this.q == null) {
        this.q = this.p.getWritableDatabase();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "create DBHelper failed.", paramContext);
      }
      a();
    }
    if ((this.b.isEmpty()) && (this.c.isEmpty())) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.d.c
 * JD-Core Version:    0.7.0.1
 */