import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.VideoEnvironment.b;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aarz
{
  public static long Mt = 0L;
  public static String bdX = "";
  public static Map<String, adfg> iH = new ConcurrentHashMap();
  
  public static void AK(String paramString)
  {
    X(paramString, Mt);
  }
  
  public static void CU(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("on_auto_focus_result", paramBoolean + "");
    a(null, "sv_on_auto_focus", localHashMap);
  }
  
  public static void Gp(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", paramInt + "");
    if (QLog.isColorLevel()) {
      QLog.d("NewFlowCameraReporter", 2, "reportQQFilterDownload :  " + localHashMap.toString());
    }
    b(localHashMap, "DynamicAdjustment", "acQQFilterDownload");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "acQQFilterDownload", true, 0L, 0L, localHashMap, null);
  }
  
  public static void Gq(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status", paramInt + "");
    if (QLog.isColorLevel()) {
      QLog.d("NewFlowCameraReporter", 2, "reportQQFilterView :  " + localHashMap.toString());
    }
    b(localHashMap, "DynamicAdjustment", "acQQfilterView");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "acQQfilterView", true, 0L, 0L, localHashMap, null);
  }
  
  public static void X(String paramString, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("PTV.NewFlowCameraActivity.photo", 2, paramString + ";" + (l - paramLong));
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
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, adfg.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString1);
    localHashMap.put("before_trigger_resolution", paramString2 + "");
    localHashMap.put("after_trigger_resolution", paramString3 + "");
    localHashMap.put("up_threshold", paramInt1 + "");
    localHashMap.put("down_threshold", paramInt2 + "");
    localHashMap.put("is_dynamic", VideoEnvironment.a.nk + "");
    if ((parama == null) || (parama.ag == null) || (parama.ag.length == 0)) {
      return;
    }
    localHashMap.put("cost_time", parama.ag[((int)(parama.ag.length * 0.5F))] + "");
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "dynamic_adjustment_on_triggering", true, parama.ag[((int)(parama.ag.length * 0.5F))], 0L, localHashMap, null);
    b(localHashMap, "DynamicAdjustment", "dynamic_adjustment_on_triggering");
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
  
  public static void a(String paramString1, boolean paramBoolean, String paramString2, long paramLong)
  {
    Object localObject = new StringBuilder().append(paramString1).append("#");
    if (paramBoolean) {}
    for (paramString1 = "beauty";; paramString1 = "nBeauty")
    {
      localObject = paramString1 + "#" + paramString2;
      paramString2 = (adfg)iH.get(localObject);
      paramString1 = paramString2;
      if (paramString2 == null)
      {
        paramString1 = new adfg(2147483647);
        iH.put(localObject, paramString1);
      }
      paramString1.bP(paramLong);
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2, int paramInt5, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    int j = 0;
    int i = j;
    anpc localanpc;
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        i = 10;
      }
    }
    else
    {
      localHashMap.put("param_FailCode", String.valueOf(i));
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("previewWidth", "" + paramInt1);
      localHashMap.put("previewHeight", "" + paramInt2);
      localHashMap.put("photoWidth", "" + paramInt3);
      localHashMap.put("photoHeight", "" + paramInt4);
      localHashMap.put("rotation", "" + paramInt5);
      localanpc = anpc.a(BaseApplication.getContext());
      if (paramBoolean1) {
        break label322;
      }
    }
    label322:
    for (boolean bool = true;; bool = false)
    {
      localanpc.collectPerformance(null, "actShootPhotoClip", bool, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {
        QLog.e("NewFlowCameraReporter", 2, "[reportShootPhotoClip] result=" + paramBoolean1 + "ratioNeedClip " + paramBoolean2 + " rotation" + paramInt5 + " needFlip" + paramBoolean3);
      }
      return;
      if (paramInt5 != 0)
      {
        i = 20;
        break;
      }
      i = j;
      if (!paramBoolean3) {
        break;
      }
      i = 30;
      break;
    }
  }
  
  public static void aCD()
  {
    Iterator localIterator = iH.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((adfg)((Map.Entry)localIterator.next()).getValue()).clear();
    }
    bdX = "";
  }
  
  public static void ap(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("camera_type", paramString1);
    localHashMap.put("currentResolution", paramString2);
    localHashMap.put("configedResolution", paramString3);
    paramString2 = "";
    int i = -1;
    Iterator localIterator = iH.entrySet().iterator();
    paramString1 = null;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramString3 = ((adfg)localEntry.getValue()).a();
      if (paramString3.num <= i) {
        break label328;
      }
      i = paramString3.num;
      paramString2 = (String)localEntry.getKey();
      paramString1 = paramString3;
    }
    label328:
    for (;;)
    {
      break;
      if ((paramString1 == null) || (paramString1.ag == null) || (paramString1.ag.length == 0)) {
        return;
      }
      paramString2 = paramString2.split("#");
      localHashMap.put("cost_camera_type", paramString2[0]);
      localHashMap.put("cost_Beauty", "beauty".equals(paramString2[1]) + "");
      localHashMap.put("cost_material_id", paramString2[2]);
      localHashMap.put("is_dynamic", VideoEnvironment.a.nk + "");
      localHashMap.put("cost_time", paramString1.ag[((int)(paramString1.ag.length * 0.5F))] + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "dynamic_adjustment_on_destroy", true, paramString1.ag[((int)(paramString1.ag.length * 0.5F))], 0L, localHashMap, null);
      b(localHashMap, "DynamicAdjustment", "dynamic_adjustment_on_destroy");
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
  
  public static void c(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("previewWidth", "" + paramInt1);
    localHashMap.put("previewHeight", "" + paramInt2);
    localHashMap.put("photoWidth", "" + paramInt3);
    localHashMap.put("photoHeight", "" + paramInt4);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actSetPhotoClipSize", paramBoolean, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[reportSetShootSizeClip] result=" + paramBoolean);
    }
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
  
  public static void cxD()
  {
    a("photo send from album", "sv_photo_send_from_album", null);
  }
  
  public static void cxE()
  {
    a("album photo send in minute", "photo_send_from_album_in_minute", null);
  }
  
  public static void cxF()
  {
    a("photo taken by custom", "sv_photo_taken_by_custom", null);
  }
  
  public static void cxG()
  {
    a("photo taken by capture", "sv_photo_taken_by_capture", null);
  }
  
  public static void cxH()
  {
    a("enter short video", "sv_enter_shortvideo", null);
  }
  
  public static void cxI()
  {
    a("enter system camera", "sv_enter_system_camera", null);
  }
  
  public static void cxy()
  {
    anot.a(null, "dc00898", "", "", "0X80072C1", "0X80072C1", 0, 0, "", "", "", "");
  }
  
  public static void cxz()
  {
    a("call request focus", "sv_call_request_focus", null);
  }
  
  public static void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("param_FailCode", String.valueOf(paramInt1));
    localHashMap.put("previewWidth", "" + paramInt4);
    localHashMap.put("previewHeight", "" + paramInt5);
    localHashMap.put("wantedWidth", "" + paramInt2);
    localHashMap.put("wantedHeight", "" + paramInt3);
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSetPreviewSizeWay", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[reportPreviewSizeWay] STEP=" + paramInt1);
    }
  }
  
  public static void d(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramBoolean));
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("cameraFrontBack", "" + paramInt1);
    localHashMap.put("templateId", "" + paramInt2);
    localHashMap.put("photoCaptureMethod", "" + paramInt3);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "photo_shot_from_shortvideo", false, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {
      QLog.e("NewFlowCameraReporter", 2, "[ShortVideoMergeReport] tag=photo_shot_from_shortvideo templateId=" + paramInt2 + " camera=" + paramInt1);
    }
  }
  
  public static void hJ(List<String> paramList)
  {
    if ((paramList == null) || (paramList.size() != 1)) {}
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramList = (String)paramList.get(0);
            } while (paramList == null);
            if (paramList.contains("DCIM/Camera")) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("open_custom_camera", 2, "not a album path : " + paramList);
          return;
          paramList = new File(paramList);
        } while (!paramList.exists());
        cxD();
        l = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getLong("sv_latest_taken_photo_time", -1L);
      } while (l == -1L);
      l = (paramList.lastModified() - l) / 1000L;
      if ((l > 0L) && (l < 60L)) {
        cxE();
      }
    } while (!QLog.isColorLevel());
    QLog.d("open_custom_camera", 2, "album time diff : " + l);
  }
  
  public static void x(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (aaqh.cix == 2) {}
    for (String str = "0"; (!aqmr.isEmpty(paramString1)) || (!aeah.afY()); str = "1")
    {
      anot.a(null, "dc00898", "", "", "0X80072C3", "0X80072C3", 0, 0, str, paramString1, "", "");
      if (paramBoolean) {
        anot.a(null, "dc00898", "", "", "0X80083B0", "0X80083B0", 0, 0, str, paramString1, "", "");
      }
      if (!aqmr.isEmpty(paramString2)) {
        anot.a(null, "dc00898", "", "", "0X80083B6", "0X80083B6", 0, 0, paramString1, "", paramString2, "");
      }
      return;
    }
    anot.a(null, "dc00898", "", "", "0X80072C2", "0X80072C2", 0, 0, str, "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aarz
 * JD-Core Version:    0.7.0.1
 */