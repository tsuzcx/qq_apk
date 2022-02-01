import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class akxp
{
  private static final Object em = "PicReporter";
  
  public static void Nt(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "device busy " + paramBoolean);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "Pic.Mkdir.DeviceBusy", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void Nu(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicReporter", 2, "Aio preview " + paramBoolean);
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "Pic.AioPreview.Empty", paramBoolean, 0L, 0L, null, "");
  }
  
  public static void ak(int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_network", String.valueOf(paramInt));
    localHashMap.put("param_limit", String.valueOf(paramLong));
    akxe.a(em, "reportOverFlow", "param_network:" + paramInt + ",param_limit:" + paramLong);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actPicPreDownOverFlow", false, 0L, 0L, localHashMap, "");
  }
  
  public static void dDV()
  {
    boolean bool = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131697129), "qqsetting_auto_receive_pic_key", true);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_state", String.valueOf(bool));
    akxe.a(em, "report2G3G4GSwitchState", "param_state:" + bool);
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "act2G3G4GSwitch", false, 0L, 0L, localHashMap, "");
  }
  
  public static void e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    akxe.a(em, "reportBigPicDownCost", "uintype:" + paramInt1 + ",networktype:" + paramInt2 + ",timeCost:" + paramLong);
    if ((paramInt1 == -1) || (paramInt2 == -1) || (paramLong < 0L)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uintype", String.valueOf(paramInt1));
    localHashMap.put("param_networktype", String.valueOf(paramInt2));
    localHashMap.put("param_timecost", String.valueOf(paramLong));
    anpc.a(BaseApplication.getContext()).collectPerformance(paramString, "actBigPicDownCost", false, 0L, 0L, localHashMap, "");
  }
  
  public static void k(String paramString, HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null)
    {
      akxe.a(em, "reportPicDownAutoLearn", "reportInfo == null");
      return;
    }
    if ((String)paramHashMap.get("xgPreDownCount") == null)
    {
      akxe.a(em, "reportPicDownAutoLearn", "no xg report data");
      return;
    }
    anpc.a(BaseApplication.getContext()).collectPerformance(paramString, "actPicDownAutoLearn", false, 0L, 0L, paramHashMap, "");
    akxe.a(em, "reportPicDownAutoLearn", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akxp
 * JD-Core Version:    0.7.0.1
 */