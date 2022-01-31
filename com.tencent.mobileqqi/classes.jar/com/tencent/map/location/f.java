package com.tencent.map.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiListener;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiPOI;
import com.tencent.map.lbsapi.api.SOSOMapLBSApiResult;
import com.tencent.mapsdk.net.HttpUtil;
import com.tencent.mapsdk.net.NetContext;
import com.tencent.mapsdk.net.NetResponse;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  implements b.a, d.c, e.c, g.c
{
  private static f jdField_a_of_type_ComTencentMapLocationF = null;
  private static boolean jdField_b_of_type_Boolean = false;
  private int jdField_a_of_type_Int = 1024;
  private long jdField_a_of_type_Long = 5000L;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ((!paramAnonymousIntent.getBooleanExtra("noConnectivity", false)) && (f.a(f.this) != null)) {
        f.a(f.this).sendEmptyMessage(256);
      }
    }
  };
  private Context jdField_a_of_type_AndroidContentContext = null;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private SOSOMapLBSApiListener jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener = null;
  private SOSOMapLBSApiResult jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = null;
  private b jdField_a_of_type_ComTencentMapLocationB = null;
  private c jdField_a_of_type_ComTencentMapLocationC = null;
  private d.b jdField_a_of_type_ComTencentMapLocationD$b = null;
  private d jdField_a_of_type_ComTencentMapLocationD = null;
  private e.b jdField_a_of_type_ComTencentMapLocationE$b = null;
  private e jdField_a_of_type_ComTencentMapLocationE = null;
  private a jdField_a_of_type_ComTencentMapLocationF$a = null;
  private b jdField_a_of_type_ComTencentMapLocationF$b = null;
  private c jdField_a_of_type_ComTencentMapLocationF$c = null;
  private g.b jdField_a_of_type_ComTencentMapLocationG$b = null;
  private g jdField_a_of_type_ComTencentMapLocationG = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = new Runnable()
  {
    public final void run()
    {
      if (System.currentTimeMillis() - f.a(f.this) < 8000L) {
        return;
      }
      if ((f.a(f.this).a()) && (f.a(f.this).b()))
      {
        f.a(f.this).a(0L);
        return;
      }
      f.a(f.this);
    }
  };
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_b_of_type_Int = 4;
  private long jdField_b_of_type_Long = -1L;
  private SOSOMapLBSApiResult jdField_b_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = null;
  private String jdField_b_of_type_JavaLangString = "";
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString = "";
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString = "";
  private int g = 0;
  private int h = 1;
  
  public static f a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMapLocationF == null) {
        jdField_a_of_type_ComTencentMapLocationF = new f();
      }
      f localf = jdField_a_of_type_ComTencentMapLocationF;
      return localf;
    }
    finally {}
  }
  
  private static ArrayList<SOSOMapLBSApiPOI> a(JSONArray paramJSONArray)
    throws Exception
  {
    int j = paramJSONArray.length();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      localArrayList.add(new SOSOMapLBSApiPOI(localJSONObject.getString("name"), localJSONObject.getString("addr"), localJSONObject.getString("catalog"), localJSONObject.getDouble("dist"), Double.parseDouble(localJSONObject.getString("latitude")), Double.parseDouble(localJSONObject.getString("longitude"))));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMapLocationE$b != null) && (this.jdField_a_of_type_ComTencentMapLocationE$b.a()))
    {
      Location localLocation = this.jdField_a_of_type_ComTencentMapLocationE$b.a();
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult();
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Latitude = i.a(localLocation.getLatitude(), 6);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Longitude = i.a(localLocation.getLongitude(), 6);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Altitude = i.a(localLocation.getAltitude(), 1);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Accuracy = i.a(localLocation.getAccuracy(), 1);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Speed = i.a(localLocation.getSpeed(), 1);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Dir = i.a(localLocation.getBearing(), 1);
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.LocType = 0;
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.isMars = false;
      if (paramBoolean) {
        break label237;
      }
    }
    label237:
    for (this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.ErrorCode = 0;; this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.ErrorCode = 1)
    {
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 0;
      this.jdField_b_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult);
      this.jdField_f_of_type_Int = 0;
      if ((System.currentTimeMillis() - this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener != null) && (this.jdField_c_of_type_Int == 1))
      {
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.onLocationUpdate(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMapLocationF$a != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMapLocationF$a = new a(this.jdField_a_of_type_ComTencentMapLocationE$b, this.jdField_a_of_type_ComTencentMapLocationD$b, this.jdField_a_of_type_ComTencentMapLocationG$b);
    this.jdField_a_of_type_ComTencentMapLocationF$a.start();
  }
  
  private void b(String paramString)
  {
    int k = 0;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult();
        localJSONObject = new JSONObject(paramString);
        Object localObject1 = localJSONObject.getJSONObject("location");
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.LocType = 1;
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Latitude = i.a(((JSONObject)localObject1).getDouble("latitude"), 6);
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Longitude = i.a(((JSONObject)localObject1).getDouble("longitude"), 6);
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Altitude = i.a(((JSONObject)localObject1).getDouble("altitude"), 1);
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Accuracy = i.a(((JSONObject)localObject1).getDouble("accuracy"), 1);
        Object localObject2 = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult;
        if (this.jdField_e_of_type_Int != 1) {
          continue;
        }
        bool = true;
        ((SOSOMapLBSApiResult)localObject2).isMars = bool;
        localObject2 = localJSONObject.getString("bearing");
        j = -100;
        i = k;
        if (localObject2 != null)
        {
          i = k;
          if (((String)localObject2).split(",").length > 1) {
            i = Integer.parseInt(localObject2.split(",")[1]);
          }
        }
        if (this.jdField_a_of_type_ComTencentMapLocationD$b != null) {
          j = this.jdField_a_of_type_ComTencentMapLocationD$b.jdField_f_of_type_Int;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult;
        d1 = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Accuracy;
        if (i < 6) {
          continue;
        }
        d1 = 40.0D;
        ((SOSOMapLBSApiResult)localObject2).Accuracy = d1;
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 0;
        if ((this.jdField_d_of_type_Int == 1) && (this.jdField_e_of_type_Int == 1))
        {
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Name = ((JSONObject)localObject1).getString("name");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Address = ((JSONObject)localObject1).getString("addr");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 1;
        }
        if (((this.jdField_d_of_type_Int == 3) || (this.jdField_d_of_type_Int == 4)) && (this.jdField_e_of_type_Int == 1))
        {
          localObject1 = localJSONObject.getJSONObject("details").getJSONObject("subnation");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.setAddressLine(((JSONObject)localObject1).getString("name"));
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Town = ((JSONObject)localObject1).getString("town");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Village = ((JSONObject)localObject1).getString("village");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Street = ((JSONObject)localObject1).getString("street");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.StreetNo = ((JSONObject)localObject1).getString("street_no");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 3;
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.AreaStat = 0;
        }
        if ((this.jdField_d_of_type_Int == 4) && (this.jdField_e_of_type_Int == 1))
        {
          localObject1 = localJSONObject.getJSONObject("details").getJSONArray("poilist");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.POIList = a((JSONArray)localObject1);
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 4;
        }
        if ((this.jdField_d_of_type_Int == 7) && (this.jdField_e_of_type_Int == 1))
        {
          localJSONObject = localJSONObject.getJSONObject("details");
          i = localJSONObject.getInt("stat");
          localJSONObject = localJSONObject.getJSONObject("subnation");
          if (i != 0) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.setAddressLine(localJSONObject.getString("name"));
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Town = localJSONObject.getString("town");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Village = localJSONObject.getString("village");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Street = localJSONObject.getString("street");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.StreetNo = localJSONObject.getString("street_no");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.AreaStat = i;
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = 7;
        }
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.ErrorCode = 0;
        this.jdField_b_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult);
        this.jdField_f_of_type_Int = 0;
        if (this.jdField_a_of_type_ComTencentMapLocationC != null) {
          this.jdField_a_of_type_ComTencentMapLocationC.a(paramString);
        }
      }
      catch (Exception paramString)
      {
        JSONObject localJSONObject;
        boolean bool;
        int j;
        int i;
        double d1;
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult();
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = -1;
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.ErrorCode = 2;
        this.jdField_f_of_type_Int = 2;
        continue;
      }
      if ((this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener != null) && (this.jdField_c_of_type_Int == 1) && ((this.jdField_a_of_type_ComTencentMapLocationE$b == null) || (!this.jdField_a_of_type_ComTencentMapLocationE$b.a())))
      {
        this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.onLocationUpdate(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
      }
      return;
      bool = false;
      continue;
      if (i == 5)
      {
        d1 = 60.0D;
      }
      else if (i == 4)
      {
        d1 = 70.0D;
      }
      else if (i == 3)
      {
        d1 = 90.0D;
      }
      else if (i == 2)
      {
        d1 = 110.0D;
      }
      else if ((j >= -72) && (i == 0))
      {
        i = (int)(0.45D * d1 / 10.0D) * 10;
        d1 = i;
      }
      else if (d1 <= 100.0D)
      {
        i = (int)((d1 - 1.0D) / 10.0D + 1.0D) * 10;
      }
      else if ((d1 > 100.0D) && (d1 <= 800.0D))
      {
        i = (int)(0.85D * d1 / 10.0D) * 10;
      }
      else
      {
        i = (int)(0.8D * d1 / 10.0D) * 10;
        continue;
        if (i == 1)
        {
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Nation = localJSONObject.getString("nation");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.AdministrativeArea1 = localJSONObject.getString("admin_level_1");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.AdministrativeArea2 = localJSONObject.getString("admin_level_2");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.AdministrativeArea3 = localJSONObject.getString("admin_level_3");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Locality = localJSONObject.getString("locality");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Sublocality = localJSONObject.getString("sublocality");
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Route = localJSONObject.getString("route");
        }
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = new SOSOMapLBSApiResult();
    this.jdField_f_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.ErrorCode = 1;
    this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.Info = -1;
    this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult.LocType = 1;
    if ((this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener != null) && (this.jdField_c_of_type_Int == 1)) {
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.onLocationUpdate(this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult);
    }
  }
  
  public final SOSOMapLBSApiResult a()
  {
    return this.jdField_b_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult;
  }
  
  public final void a()
  {
    try
    {
      synchronized (this.jdField_a_of_type_ArrayOfByte)
      {
        if (this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener != null)
        {
          this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener = null;
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_ComTencentMapLocationE.a();
          this.jdField_a_of_type_ComTencentMapLocationD.a();
          this.jdField_a_of_type_ComTencentMapLocationG.a();
        }
        label62:
        return;
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(6);
      Location localLocation = new Location("Deflect");
      localLocation.setLatitude(paramDouble1);
      localLocation.setLongitude(paramDouble2);
      localMessage.obj = localLocation;
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(localMessage);
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(4, paramInt, 0);
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(localMessage);
      return;
    }
  }
  
  public final void a(long paramLong)
  {
    if ((paramLong >= 1000L) && (paramLong <= 20000L)) {
      this.jdField_a_of_type_Long = paramLong;
    }
  }
  
  public final void a(d.b paramb)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      paramb = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(2, paramb);
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(paramb);
      return;
    }
  }
  
  public final void a(e.b paramb)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      paramb = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(1, paramb);
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(paramb);
      return;
    }
  }
  
  public final void a(g.b paramb)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      paramb = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(3, paramb);
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(paramb);
      return;
    }
  }
  
  public final void a(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public final boolean a(Context paramContext, SOSOMapLBSApiListener paramSOSOMapLBSApiListener, boolean paramBoolean)
  {
    arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if ((paramContext == null) || (paramSOSOMapLBSApiListener == null)) {
      return false;
    }
    label141:
    try
    {
      if (!i.a(this.jdField_f_of_type_JavaLangString)) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMapLocationF$c = new c();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener = paramSOSOMapLBSApiListener;
      NetContext.getInstance().init(this.jdField_a_of_type_AndroidContentContext.getApplicationContext());
    }
    finally {}
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if ((paramContext != null) && (paramContext.getActiveNetworkInfo() != null)) {
        this.jdField_c_of_type_Boolean = paramContext.getActiveNetworkInfo().isRoaming();
      }
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
    catch (Exception paramContext)
    {
      break label141;
      paramBoolean = false;
      break label222;
    }
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.getReqType();
    this.jdField_d_of_type_Int = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.getReqLevel();
    this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiListener.getReqGeoType();
    this.jdField_b_of_type_Long = -1L;
    if (this.jdField_d_of_type_Int == 7) {
      this.jdField_d_of_type_Int = 0;
    }
    this.jdField_d_of_type_Boolean = false;
    this.h = 1;
    if (paramBoolean)
    {
      paramBoolean = this.jdField_a_of_type_ComTencentMapLocationE.a(this, this.jdField_a_of_type_AndroidContentContext);
      label222:
      boolean bool1 = this.jdField_a_of_type_ComTencentMapLocationD.a(this.jdField_a_of_type_AndroidContentContext, this);
      boolean bool2 = this.jdField_a_of_type_ComTencentMapLocationG.a(this.jdField_a_of_type_AndroidContentContext, this, 1);
      this.jdField_a_of_type_ComTencentMapLocationC = c.a();
      this.jdField_a_of_type_ComTencentMapLocationB = b.a();
      this.jdField_a_of_type_ComTencentMapLocationE$b = null;
      this.jdField_a_of_type_ComTencentMapLocationD$b = null;
      this.jdField_a_of_type_ComTencentMapLocationG$b = null;
      this.jdField_a_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = null;
      this.jdField_b_of_type_ComTencentMapLbsapiApiSOSOMapLBSApiResult = null;
      this.jdField_f_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMapLocationC != null) {
        this.jdField_a_of_type_ComTencentMapLocationC.a();
      }
      this.g = 1;
      if ((paramBoolean) && (this.jdField_e_of_type_Int == 0)) {
        return true;
      }
      return (bool1) || (bool2);
    }
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (a.a().a(paramString1, paramString2))
      {
        this.jdField_f_of_type_JavaLangString = paramString1;
        return true;
      }
      return false;
    }
  }
  
  public final void b(int paramInt)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      Message localMessage = this.jdField_a_of_type_ComTencentMapLocationF$c.obtainMessage(5, paramInt, 0);
      this.jdField_a_of_type_ComTencentMapLocationF$c.sendMessage(localMessage);
      return;
    }
  }
  
  final class a
    extends Thread
  {
    private d.b jdField_a_of_type_ComTencentMapLocationD$b = null;
    private e.b jdField_a_of_type_ComTencentMapLocationE$b = null;
    private g.b jdField_a_of_type_ComTencentMapLocationG$b = null;
    
    a(e.b paramb, d.b paramb1, g.b paramb2)
    {
      if (paramb != null) {
        this.jdField_a_of_type_ComTencentMapLocationE$b = ((e.b)paramb.clone());
      }
      if (paramb1 != null) {
        this.jdField_a_of_type_ComTencentMapLocationD$b = ((d.b)paramb1.clone());
      }
      if (paramb2 != null) {
        this.jdField_a_of_type_ComTencentMapLocationG$b = ((g.b)paramb2.clone());
      }
    }
    
    public final void run()
    {
      if (!f.a()) {}
      try
      {
        localObject1 = (TelephonyManager)f.a(f.this).getSystemService("phone");
        f.a(f.this, ((TelephonyManager)localObject1).getDeviceId());
        f.b(f.this, ((TelephonyManager)localObject1).getSubscriberId());
        localObject2 = Pattern.compile("[0-9a-zA-Z+-]*");
        localObject3 = f.this;
        if (f.a(f.this) != null) {
          break label619;
        }
        localObject1 = "";
        f.a((f)localObject3, (String)localObject1);
        if (!((Pattern)localObject2).matcher(f.a(f.this)).matches()) {
          break label641;
        }
        localObject3 = f.this;
        if (f.a(f.this) != null) {
          break label630;
        }
        localObject1 = "";
        label111:
        f.a((f)localObject3, (String)localObject1);
        label117:
        localObject3 = f.this;
        if (f.b(f.this) != null) {
          break label654;
        }
        localObject1 = "";
        label135:
        f.b((f)localObject3, (String)localObject1);
        if (!((Pattern)localObject2).matcher(f.b(f.this)).matches()) {
          break label676;
        }
        localObject3 = f.this;
        if (f.b(f.this) != null) {
          break label665;
        }
        localObject1 = "";
        label176:
        f.b((f)localObject3, (String)localObject1);
        label182:
        localObject3 = f.this;
        if (f.c(f.this) != null) {
          break label689;
        }
        localObject1 = "";
        label200:
        f.c((f)localObject3, (String)localObject1);
        if (!((Pattern)localObject2).matcher(f.c(f.this)).matches()) {
          break label711;
        }
        localObject2 = f.this;
        if (f.c(f.this) != null) {
          break label700;
        }
        localObject1 = "";
        label241:
        f.c((f)localObject2, (String)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        label247:
        String str1;
        break label247;
      }
      f.a(true);
      localObject2 = f.this;
      if (f.a(f.this) == null)
      {
        localObject1 = "";
        label270:
        f.a((f)localObject2, (String)localObject1);
        localObject2 = f.this;
        if (f.b(f.this) != null) {
          break label735;
        }
        localObject1 = "";
        label294:
        f.b((f)localObject2, (String)localObject1);
        localObject2 = f.this;
        if (f.c(f.this) != null) {
          break label746;
        }
        localObject1 = "";
        label318:
        f.c((f)localObject2, (String)localObject1);
        localObject2 = f.this;
        if (f.a(f.this) != null) {
          break label757;
        }
        localObject1 = "0123456789ABCDEF";
        label342:
        f.d((f)localObject2, j.a((String)localObject1));
        if (f.d(f.this) != 4) {
          break label768;
        }
        localObject1 = i.a(this.jdField_a_of_type_ComTencentMapLocationG$b);
        label370:
        localObject3 = i.a(this.jdField_a_of_type_ComTencentMapLocationD$b, f.a(f.this).a());
        str1 = i.a(f.a(f.this), f.b(f.this), f.c(f.this), f.d(f.this), f.a(f.this));
        if ((this.jdField_a_of_type_ComTencentMapLocationE$b == null) || (!this.jdField_a_of_type_ComTencentMapLocationE$b.a())) {
          break label774;
        }
      }
      label641:
      label774:
      for (localObject2 = i.a(this.jdField_a_of_type_ComTencentMapLocationE$b);; localObject2 = "{}")
      {
        String str2 = "{\"version\":\"1.9.1\",\"address\":" + f.e(f.this);
        str2 = str2 + ",\"source\":203,\"access_token\":\"" + f.e(f.this) + "\",\"app_name\":" + "\"" + f.f(f.this) + "\",\"bearing\":1";
        localObject1 = str2 + ",\"attribute\":" + str1 + ",\"location\":" + (String)localObject2 + ",\"cells\":" + (String)localObject3 + ",\"wifis\":" + (String)localObject1 + "}";
        localObject1 = f.a(f.this).obtainMessage(16, localObject1);
        f.a(f.this).sendMessage((Message)localObject1);
        return;
        label619:
        localObject1 = f.a(f.this);
        break;
        label630:
        localObject1 = f.a(f.this);
        break label111;
        f.a(f.this, "");
        break label117;
        label654:
        localObject1 = f.b(f.this);
        break label135;
        label665:
        localObject1 = f.b(f.this);
        break label176;
        label676:
        f.b(f.this, "");
        break label182;
        label689:
        localObject1 = f.c(f.this);
        break label200;
        label700:
        localObject1 = f.c(f.this);
        break label241;
        label711:
        f.c(f.this, "");
        break label247;
        localObject1 = f.a(f.this);
        break label270;
        label735:
        localObject1 = f.b(f.this);
        break label294;
        label746:
        localObject1 = f.c(f.this);
        break label318;
        label757:
        localObject1 = f.a(f.this);
        break label342;
        localObject1 = "[]";
        break label370;
      }
    }
  }
  
  final class b
    extends Thread
  {
    private String jdField_a_of_type_JavaLangString = null;
    private String b = null;
    private String c = null;
    
    public b(String paramString)
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      StringBuilder localStringBuilder = new StringBuilder();
      if (f.b(f.this) == 0) {}
      for (paramString = "http://lstest.map.soso.com/loc?c=1";; paramString = "http://lbs.map.qq.com/loc?c=1")
      {
        this.b = (paramString + "&mars=" + f.c(f.this));
        return;
      }
    }
    
    private String a(byte[] paramArrayOfByte, String paramString)
    {
      f.a(f.this, System.currentTimeMillis());
      StringBuffer localStringBuffer = new StringBuffer();
      try
      {
        localStringBuffer.append(new String(paramArrayOfByte, paramString));
        return localStringBuffer.toString();
      }
      catch (Exception paramArrayOfByte) {}
      return null;
    }
    
    public final void run()
    {
      Message localMessage = new Message();
      localMessage.what = 8;
      int i;
      try
      {
        Object localObject1 = j.a(this.jdField_a_of_type_JavaLangString.getBytes());
        f.a(f.this, true);
        localObject1 = HttpUtil.sendSyncPostRequest(this.b, "SOSO MAP LBS SDK", (byte[])localObject1);
        f.a(f.this, false);
        this.c = a(j.b(((NetResponse)localObject1).data), ((NetResponse)localObject1).charset);
        if (this.c != null)
        {
          localMessage.arg1 = 0;
          localMessage.obj = this.c;
        }
        for (;;)
        {
          f.c(f.this);
          f.a(f.this).sendMessage(localMessage);
          return;
          localMessage.arg1 = 1;
        }
        i += 1;
      }
      catch (Exception localException1)
      {
        i = 0;
      }
      for (;;)
      {
        if (i <= 3) {}
        try
        {
          sleep(1000L);
          Object localObject2 = j.a(this.jdField_a_of_type_JavaLangString.getBytes());
          f.a(f.this, true);
          localObject2 = HttpUtil.sendSyncPostRequest(this.b, "SOSO MAP LBS SDK", (byte[])localObject2);
          f.a(f.this, false);
          this.c = a(j.b(((NetResponse)localObject2).data), ((NetResponse)localObject2).charset);
          if (this.c != null)
          {
            localMessage.arg1 = 0;
            localMessage.obj = this.c;
            continue;
          }
          localMessage.arg1 = 1;
        }
        catch (Exception localException2) {}
        f.a(f.this, false);
        localMessage.arg1 = 1;
        break;
      }
    }
  }
  
  final class c
    extends Handler
  {
    public c()
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
            f.a(f.this, (e.b)paramMessage.obj);
            return;
            f.a(f.this, (d.b)paramMessage.obj);
            return;
            f.a(f.this, (g.b)paramMessage.obj);
            return;
            f.a(f.this, paramMessage.arg1);
            return;
            f.b(f.this, paramMessage.arg1);
            return;
            f.a(f.this, (Location)paramMessage.obj);
            return;
          } while (f.a(f.this) != 1);
          f.a(f.this);
          return;
        } while (paramMessage.obj == null);
        f.a(f.this, (String)paramMessage.obj);
        f.a(f.this, null);
        return;
        if (paramMessage.arg1 == 0)
        {
          f.b(f.this, (String)paramMessage.obj);
          return;
        }
      } while ((f.a(f.this) != null) && (f.a(f.this).a()));
      f.b(f.this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.map.location.f
 * JD-Core Version:    0.7.0.1
 */