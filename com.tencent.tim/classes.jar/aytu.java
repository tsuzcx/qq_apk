import android.content.Intent;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aytu
{
  public static long Mt = 0L;
  public static long aDg = 0L;
  private static long aDh = 0L;
  private static long aDi = 0L;
  public static long aDj = 0L;
  public static String bdX = "";
  public static String cXU;
  public static String cXV;
  public static boolean dAI;
  public static boolean dAJ;
  public static Map<String, adfg> iH = new ConcurrentHashMap();
  public static long sShowTime;
  
  static
  {
    cXU = ".photo";
    cXV = ".openCamera";
    dAI = true;
    dAJ = true;
  }
  
  public static void AK(String paramString)
  {
    X(paramString, Mt);
  }
  
  public static void X(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d(cXU, 2, paramString + ";" + (l - paramLong));
      Mt = l;
    }
  }
  
  public static void a(int paramInt, long paramLong, String paramString, boolean paramBoolean)
  {
    if ((paramLong < 0L) || (paramInt < 0))
    {
      QLog.d("DynamicAdjustment", 2, "report data check failed, stratTime: " + paramLong + "   cameraType : " + paramInt);
      return;
    }
    if (paramInt == 2) {}
    for (String str = "back";; str = "front")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("camera_type", str);
      localHashMap.put("start_time_cost", paramLong + "");
      localHashMap.put("activity_from", paramString);
      localHashMap.put("first_launch", paramBoolean + "");
      b(localHashMap, "DynamicAdjustment", "cameraStartTimeCost");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "cameraStartTimeCost", true, 0L, 0L, localHashMap, null);
      return;
    }
  }
  
  public static void a(Camera.Parameters paramParameters, String paramString)
  {
    int j = 1;
    if (paramParameters == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("open_custom_camera", 2, paramString + "   model compatibility");
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString);
    paramString = "";
    String str = paramString;
    int i;
    if (paramParameters != null)
    {
      localObject = paramParameters.getSupportedFlashModes();
      str = paramString;
      if (localObject != null)
      {
        str = paramString;
        if (((List)localObject).size() > 0)
        {
          paramString = (String)((List)localObject).get(0);
          i = 1;
          for (;;)
          {
            str = paramString;
            if (i >= ((List)localObject).size()) {
              break;
            }
            paramString = paramString + "#";
            paramString = paramString + (String)((List)localObject).get(i);
            i += 1;
          }
        }
      }
    }
    Object localObject = "";
    paramString = (String)localObject;
    if (paramParameters != null)
    {
      List localList = paramParameters.getSupportedFocusModes();
      paramString = (String)localObject;
      if (localList != null)
      {
        paramString = (String)localObject;
        if (localList.size() > 0)
        {
          paramParameters = (String)localList.get(0);
          i = j;
          for (;;)
          {
            paramString = paramParameters;
            if (i >= localList.size()) {
              break;
            }
            paramParameters = paramParameters + "#";
            paramParameters = paramParameters + (String)localList.get(i);
            i += 1;
          }
        }
      }
    }
    localHashMap.put("supported_focus_mode", paramString);
    localHashMap.put("supported_flash_mode", str);
    a(null, "sv_model_compatibility", localHashMap);
  }
  
  private static void a(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (QLog.isColorLevel())) {
      QLog.d("open_custom_camera", 2, paramString1);
    }
    if (paramHashMap == null) {}
    for (paramString1 = new HashMap();; paramString1 = paramHashMap)
    {
      paramString1.put("MANUFACTURER", Build.MANUFACTURER);
      paramString1.put("MODEL", Build.MODEL);
      paramString1.put("DEVICE_TYPE_NAME", aeag.a().ta());
      b(paramString1, "open_custom_camera", paramString2);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, paramString2, true, 0L, 0L, paramString1, null);
      return;
    }
  }
  
  private static void b(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    for (paramMap = "事件Code : " + paramString2 + "   上报内容 ----------  \n"; localIterator.hasNext(); paramMap = paramMap + "\n")
    {
      paramString2 = (Map.Entry)localIterator.next();
      paramMap = paramMap + (String)paramString2.getKey();
      paramMap = paramMap + "   :   ";
      paramMap = paramMap + (String)paramString2.getValue();
    }
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramMap);
    }
  }
  
  public static long c(Intent paramIntent)
  {
    return paramIntent.getLongExtra("start_intent_time", 0L);
  }
  
  public static void cW(Intent paramIntent)
  {
    paramIntent.putExtra("start_intent_time", Mt);
  }
  
  public static void cxA()
  {
    a("custom photo send", "sv_custom_photo_send", null);
  }
  
  public static void cxB()
  {
    a("capture photo send", "sv_capture_photo_send", null);
  }
  
  public static void cxC()
  {
    a("system photo send", "sv_system_photo_send", null);
  }
  
  public static void cxF()
  {
    a("photo taken by custom", "sv_photo_taken_by_custom", null);
  }
  
  public static void cxG()
  {
    a("photo taken by capture", "sv_photo_taken_by_capture", null);
  }
  
  public static void eTA()
  {
    long l1 = SystemClock.uptimeMillis();
    if (aDh > 0L)
    {
      long l2 = aDh;
      Log.i("AutoMonitor", "ActionLoginO, cost=" + (l1 - l2));
      aDh = 0L;
    }
  }
  
  public static void eTB()
  {
    long l = SystemClock.uptimeMillis();
    if (aDi > 0L)
    {
      l -= aDi;
      Log.i("AutoMonitor", "COT, cost=" + l);
      HashMap localHashMap = new HashMap();
      localHashMap.put("cost", l + "");
      anpc.a(BaseApplicationImpl.sApplication).collectPerformance(null, "COT", true, l, 0L, localHashMap, null);
      aDi = 0L;
    }
  }
  
  public static void eTC()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    if (sShowTime > 0L)
    {
      l2 = l1 - sShowTime;
      Log.i("AutoMonitor", "ActionLoginQ, cost=" + l2);
      HashMap localHashMap = new HashMap();
      localHashMap.put("cost", l2 + "");
      anpc.a(BaseApplicationImpl.sApplication).collectPerformance(null, "actLoginQ", true, l2, 0L, localHashMap, null);
      sShowTime = 0L;
    }
    if (aDj > 0L)
    {
      l2 = aDj;
      if (QLog.isColorLevel()) {
        QLog.d("AutoMonitor", 2, "ActionLoginOnScreen = " + (l1 - l2));
      }
    }
    eTA();
  }
  
  public static void eTy()
  {
    if (dAI)
    {
      AK("first frame onto screen");
      eTC();
      eTB();
      dAI = false;
    }
  }
  
  public static void eTz()
  {
    if (dAJ)
    {
      AK("first frame from camera");
      dAJ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytu
 * JD-Core Version:    0.7.0.1
 */