import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SensorReport.2;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class jla
{
  static String SJ = "actAVGSensorCaseReport";
  private static BroadcastReceiver ac = new jlb();
  private String SI = "";
  jla.a a = null;
  int aAL = 0;
  int aAM = 1;
  int aAN = 2;
  int aAO = 4;
  int aAP = 8;
  int aAQ = 16;
  int aAR = 32;
  int aAS = 0;
  final int aAT = 0;
  final int aAU = 1;
  final int aAV = 2;
  ArrayList<jla.a> jd = new ArrayList();
  private String mGuid;
  private long oi;
  private long pZ;
  private long qa;
  private long qb;
  private long qc;
  private long qd;
  
  public static void bE(Context paramContext)
  {
    AudioHelper.fx(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(SJ);
    ThreadManager.post(new SensorReport.2(paramContext, localIntentFilter), 5, null, false);
  }
  
  public static void bF(Context paramContext)
  {
    try
    {
      paramContext.unregisterReceiver(ac);
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("SensorReport", 2, "unregistonUserActionReceiver e = " + paramContext);
    }
  }
  
  private void g(int paramInt, ArrayList<jla.a> paramArrayList)
  {
    if ((this.pZ == 0L) || (this.oi == 0L)) {
      if (QLog.isDevelopLevel()) {
        QLog.d(SJ, 4, "report Ignore, mRoomID[" + this.oi + "], guid[" + this.mGuid);
      }
    }
    for (;;)
    {
      return;
      Object localObject1 = "";
      if (paramArrayList.size() > 0) {}
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("size", paramArrayList.size());
        localObject2 = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          jla.a locala = (jla.a)paramArrayList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("i", locala.index);
          localJSONObject.put("off", locala.qe);
          localJSONObject.put("on", locala.qf);
          localJSONObject.put("why", locala.qg);
          ((JSONArray)localObject2).put(localJSONObject);
        }
      }
      catch (JSONException paramArrayList)
      {
        Object localObject2;
        for (localObject1 = "JSONException. ";; localObject1 = ((JSONObject)localObject1).toString())
        {
          paramArrayList = new HashMap();
          paramArrayList.put("guid", this.mGuid);
          paramArrayList.put("RoomID", String.valueOf(this.oi));
          paramArrayList.put("EnterRoomTime", String.valueOf(this.qd));
          paramArrayList.put("screenInfo", localObject1);
          paramArrayList.put("StartSensorTime", String.valueOf(this.pZ));
          paramArrayList.put("EndSensorTime", String.valueOf(this.qa));
          paramArrayList.put("SetIgnore", String.valueOf(this.qb));
          paramArrayList.put("ClearIgnore", String.valueOf(this.qc));
          paramArrayList.put("reportType", String.valueOf(paramInt));
          paramArrayList.put("Log", this.SI);
          paramArrayList.put("ScreenInfoCount", String.valueOf(this.aAS));
          if (this.qb != 0L)
          {
            paramArrayList.put("sdkVersion", String.valueOf(Build.VERSION.SDK_INT));
            paramArrayList.put("devicesInfo", AppSetting.aHR);
          }
          if (QLog.isDevelopLevel()) {
            QLog.d(SJ, 4, "mRoomID[" + this.oi + "], guid[" + this.mGuid + "], [" + (String)localObject1);
          }
          if (!TextUtils.isEmpty(this.SI)) {
            QLog.d(SJ, 1, this.mGuid + this.SI);
          }
          if (paramInt != 0) {
            break label643;
          }
          localObject1 = (VideoAppInterface)BaseApplicationImpl.sApplication.getRuntime();
          if (localObject1 != null)
          {
            localObject2 = new Intent(SJ);
            ((Intent)localObject2).putExtra("params", paramArrayList);
            ((Intent)localObject2).setPackage(((VideoAppInterface)localObject1).getApp().getPackageName());
            ((VideoAppInterface)localObject1).getApp().sendBroadcast((Intent)localObject2);
          }
          this.SI = "";
          this.a = null;
          if (paramInt == 1) {
            break;
          }
          this.pZ = 0L;
          this.qa = 0L;
          this.qb = 0L;
          this.qc = 0L;
          return;
          ((JSONObject)localObject1).put("infos", localObject2);
        }
      }
      catch (Exception paramArrayList)
      {
        for (;;)
        {
          localObject1 = "json_" + paramArrayList.getClass().getName() + ". ";
          continue;
          label643:
          UserAction.onUserAction(SJ, true, -1L, -1L, paramArrayList, true);
        }
      }
    }
  }
  
  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, boolean paramBoolean4, VideoController paramVideoController)
  {
    if (this.oi == 0L) {
      u(paramVideoController);
    }
    int j = this.aAL;
    int i = j;
    if (!paramBoolean1) {
      i = j | this.aAO;
    }
    j = i;
    if (!paramBoolean2) {
      j = i | this.aAP;
    }
    i = j;
    if (paramBoolean3) {
      i = j | this.aAM;
    }
    j = i;
    if (paramInt == 3) {
      j = i | this.aAN;
    }
    i = j;
    if (paramInt == 1) {
      i = j | this.aAQ;
    }
    paramInt = i;
    if (paramBoolean4) {
      paramInt = i | this.aAR;
    }
    long l = System.currentTimeMillis();
    paramVideoController = this.a;
    this.a = null;
    if (paramVideoController != null)
    {
      paramVideoController.qf = l;
      paramVideoController.qg = paramInt;
    }
    for (;;)
    {
      if ((!paramBoolean4) && (this.jd.size() >= 6))
      {
        paramVideoController = this.jd;
        this.jd = new ArrayList();
        g(1, paramVideoController);
      }
      return;
      this.SI = (this.SI + "setScreenOn_LastScreenInfo_null[" + l + "], why[" + paramInt + "]。");
    }
  }
  
  void axC()
  {
    this.a = new jla.a();
    this.a.index = this.aAS;
    this.aAS += 1;
    this.a.qe = System.currentTimeMillis();
    this.jd.add(this.a);
  }
  
  void axD()
  {
    long l = System.currentTimeMillis();
    if (this.qb != 0L) {
      this.SI = (this.SI + "setIgnore[" + this.qb + "->" + l + "]。");
    }
    this.qb = l;
  }
  
  void axE()
  {
    long l = System.currentTimeMillis();
    if (this.qc != 0L) {
      this.SI = (this.SI + "clearIgnoreFlag[" + this.qc + "->" + l + "]。");
    }
    this.qc = l;
  }
  
  void begin()
  {
    long l = System.currentTimeMillis();
    String str = UUID.randomUUID().toString();
    if (this.pZ != 0L)
    {
      this.SI = (this.SI + "[" + this.mGuid + "->" + str + "]begin had came[" + this.pZ + "->" + l + "]");
      if (this.qa == 0L) {
        this.qa = l;
      }
      ArrayList localArrayList = this.jd;
      this.jd = new ArrayList();
      g(2, localArrayList);
    }
    this.pZ = l;
    this.mGuid = str;
  }
  
  void end()
  {
    if (this.qa != 0L) {
      this.SI = (this.SI + "end_came[" + this.qa + "]。");
    }
    this.qa = System.currentTimeMillis();
    ArrayList localArrayList = this.jd;
    this.jd = new ArrayList();
    g(0, localArrayList);
  }
  
  void u(VideoController paramVideoController)
  {
    if (paramVideoController != null)
    {
      this.oi = paramVideoController.by();
      if (this.oi != 0L)
      {
        int i = paramVideoController.b().amI;
        if ((i == 3) || (i == 4)) {
          this.qd = paramVideoController.bx();
        }
        if (QLog.isDevelopLevel()) {
          QLog.d(SJ, 4, "setRoomID[" + this.oi + "], EnterRoomTime[" + this.qd);
        }
      }
    }
  }
  
  class a
  {
    int index = 0;
    long qe = 0L;
    long qf = 0L;
    long qg = jla.this.aAL;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jla
 * JD-Core Version:    0.7.0.1
 */