import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class alxh
{
  private static alxh a;
  private final String TAG = "short_video.param_manager";
  private String config;
  private Map<Integer, aasq> mP = new HashMap();
  private Map<Integer, Float> mQ = new HashMap();
  private Map<Integer, Integer> mR = new HashMap();
  private Map<Integer, Boolean> mS = new HashMap();
  private Map<Integer, aasq> mT = new HashMap();
  private Map<Integer, Integer> mU = new HashMap();
  
  private alxh()
  {
    this.mP.put(Integer.valueOf(1), new aasq(960, 720));
    this.mP.put(Integer.valueOf(2), new aasq(960, 720));
    this.mQ.put(Integer.valueOf(1), Float.valueOf(1.0F));
    this.mQ.put(Integer.valueOf(2), Float.valueOf(1.0F));
    this.config = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    if (TextUtils.isEmpty(this.config)) {}
    for (String str = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";; str = this.config)
    {
      this.config = str;
      anq();
      return;
    }
  }
  
  public static alxh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new alxh();
      }
      return a;
    }
    finally {}
  }
  
  private void anq()
  {
    String[] arrayOfString3;
    try
    {
      String[] arrayOfString1 = this.config.split(",");
      if ((arrayOfString1 == null) || (arrayOfString1.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label958;
        }
        QLog.d("short_video.param_manager", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      arrayOfString3 = arrayOfString1[0].split("\\|");
      if (arrayOfString3.length < 17) {
        break label631;
      }
      arrayOfString1 = arrayOfString3[3].split("\\*");
      if ((arrayOfString1 != null) && (arrayOfString1.length == 2)) {
        break label132;
      }
      if (!QLog.isColorLevel()) {
        break label958;
      }
      QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label958;
      }
    }
    QLog.e("short_video.param_manager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
    return;
    label132:
    int j = Integer.valueOf(localException[0]).intValue();
    int k = Integer.valueOf(localException[1]).intValue();
    Object localObject = getValue(arrayOfString3[13], "");
    String[] arrayOfString2;
    int[] arrayOfInt3;
    int[] arrayOfInt2;
    int[] arrayOfInt1;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      arrayOfString2 = ((String)localObject).split(";");
      if ((arrayOfString2 != null) && (arrayOfString2.length != 0))
      {
        arrayOfInt3 = new int[arrayOfString2.length];
        arrayOfInt2 = new int[arrayOfString2.length];
        arrayOfInt1 = new int[arrayOfString2.length];
        localObject = new int[arrayOfString2.length];
        i = 0;
        if (i >= arrayOfString2.length) {
          break label980;
        }
        String[] arrayOfString4 = arrayOfString2[i].split("#");
        if ((arrayOfString4 == null) || (arrayOfString4.length < 3)) {
          break label973;
        }
        String[] arrayOfString5 = arrayOfString4[0].split("\\*");
        if ((arrayOfString5 == null) || (arrayOfString5.length != 2))
        {
          if (!QLog.isColorLevel()) {
            break label959;
          }
          QLog.d("short_video.param_manager", 2, "initConfig(): res is null or length is not 2");
          break label959;
        }
        label295:
        while ((arrayOfString4[1] != null) && (arrayOfString4[2] != null))
        {
          arrayOfInt1[i] = Integer.valueOf(arrayOfString4[1]).intValue();
          localObject[i] = Integer.valueOf(arrayOfString4[2]).intValue();
          break;
          arrayOfInt3[i] = Integer.valueOf(arrayOfString5[0]).intValue();
          arrayOfInt2[i] = Integer.valueOf(arrayOfString5[1]).intValue();
        }
      }
    }
    label920:
    label958:
    label959:
    label973:
    label980:
    for (;;)
    {
      i = Integer.valueOf(getValue(arrayOfString3[14], "0")).intValue();
      if ((arrayOfString2 != null) && (i < arrayOfString2.length)) {
        if (arrayOfString2 == null) {
          break label920;
        }
      }
      for (j = arrayOfString2.length - 1;; j = 0)
      {
        if ((arrayOfInt3 != null) && (arrayOfInt2 != null))
        {
          this.mP.put(Integer.valueOf(2), new aasq(arrayOfInt3[i], arrayOfInt2[i]));
          this.mP.put(Integer.valueOf(1), new aasq(arrayOfInt3[i], arrayOfInt2[i]));
          this.mT.put(Integer.valueOf(2), new aasq(arrayOfInt3[j], arrayOfInt2[j]));
          this.mT.put(Integer.valueOf(1), new aasq(arrayOfInt3[j], arrayOfInt2[j]));
        }
        if (localObject != null)
        {
          this.mR.put(Integer.valueOf(2), Integer.valueOf(localObject[i]));
          this.mR.put(Integer.valueOf(1), Integer.valueOf(localObject[i]));
        }
        if (arrayOfInt1 != null)
        {
          this.mU.put(Integer.valueOf(2), Integer.valueOf(arrayOfInt1[j]));
          this.mU.put(Integer.valueOf(1), Integer.valueOf(arrayOfInt1[j]));
        }
        label631:
        if (arrayOfString3.length > 25)
        {
          localObject = getValue(arrayOfString3[24], "").split(";");
          i = Integer.valueOf(localObject[0]).intValue();
          j = Integer.valueOf(localObject[1]).intValue();
          if ((j > 0) && (i > 0))
          {
            float f = i / j;
            this.mQ.put(Integer.valueOf(2), Float.valueOf(f));
            this.mQ.put(Integer.valueOf(2), Float.valueOf(f));
          }
        }
        if (arrayOfString3.length > 27)
        {
          boolean bool = getValue(arrayOfString3[27], "0").equals("1");
          this.mS.put(Integer.valueOf(2), Boolean.valueOf(bool));
          this.mS.put(Integer.valueOf(1), Boolean.valueOf(bool));
        }
        if (!QLog.isColorLevel()) {
          break label958;
        }
        QLog.d("short_video.param_manager", 2, "cameraResolution : " + this.mP.toString());
        QLog.d("short_video.param_manager", 2, "videoResolutionRatioMap : " + this.mQ.toString());
        QLog.d("short_video.param_manager", 2, "isDynamic : " + this.mS);
        QLog.d("short_video.param_manager", 2, "bitRateMap : " + this.mR);
        return;
        i = 0;
        break;
      }
      arrayOfInt3 = null;
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      arrayOfInt3 = null;
      arrayOfString2 = null;
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      return;
      arrayOfInt3[i] = j;
      arrayOfInt2[i] = k;
      break label295;
      i += 1;
      break;
    }
  }
  
  private static String getValue(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("=");
    if (i == -1) {
      return paramString2;
    }
    return paramString1.substring(i + 1);
  }
  
  public aasq a(int paramInt)
  {
    if (this.mP.containsKey(Integer.valueOf(paramInt))) {
      return (aasq)this.mP.get(Integer.valueOf(paramInt));
    }
    return new aasq(960, 720);
  }
  
  public aasq b(int paramInt)
  {
    if (this.mT.containsKey(Integer.valueOf(paramInt))) {
      return (aasq)this.mT.get(Integer.valueOf(paramInt));
    }
    return new aasq(640, 480);
  }
  
  public int iS(int paramInt)
  {
    if (this.mR.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.mR.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  public float w(int paramInt)
  {
    if (this.mQ.containsKey(Integer.valueOf(paramInt))) {
      return ((Float)this.mQ.get(Integer.valueOf(paramInt))).floatValue();
    }
    return 1.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alxh
 * JD-Core Version:    0.7.0.1
 */