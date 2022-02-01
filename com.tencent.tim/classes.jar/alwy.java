import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;
import java.util.HashMap;

public class alwy
{
  public static boolean cAe;
  public static boolean cAf;
  public static boolean cAg;
  public static int dyF = -1;
  public static int dyG = -1;
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    int j = iN((int)(paramInt1 * paramFloat));
    int i = iN((int)(paramInt2 * paramFloat));
    float f1 = paramInt2 * 1.0F / paramInt1;
    float f2 = paramInt4 * 1.0F / paramInt3;
    if (f1 > f2) {
      i = iN((int)(j * f2));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "clipVideoSize(" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4 + "," + paramFloat + ") = (" + j + "," + i + ")");
      }
      return new int[] { j, i };
      j = iN((int)(i / f2));
    }
  }
  
  public static boolean auJ()
  {
    int i = 1;
    boolean bool1;
    if (Build.VERSION.SDK_INT < 21) {
      bool1 = false;
    }
    for (;;)
    {
      if (!anki.ahh())
      {
        i = 2;
        bool1 = false;
      }
      int j = i;
      boolean bool2 = bool1;
      if (Build.MODEL.equals("GT-I9500"))
      {
        j = i;
        bool2 = bool1;
        if (Build.VERSION.SDK_INT == 18)
        {
          j = 6;
          bool2 = false;
        }
      }
      if (BaseApplicationImpl.getApplication().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("sp_mc_crash_times", 0) >= 2) {
        i = 5;
      }
      for (bool1 = false;; bool1 = bool2)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_FailCode", Integer.toString(i));
        anpc.a(BaseApplicationImpl.getContext()).collectPerformance(null, "actMediaCodecSupport", bool1, 0L, 0L, localHashMap, "");
        if (QLog.isColorLevel()) {
          QLog.i("CaptureUtil", 2, "mediacodec isMediaCodecSupport:" + bool1 + ", code:" + i);
        }
        return bool1;
        i = j;
      }
      bool1 = true;
      i = 0;
    }
  }
  
  public static boolean auK()
  {
    try
    {
      boolean bool = bi(true);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean auL()
  {
    String str1 = Build.CPU_ABI;
    String str2 = Build.CPU_ABI2;
    if (QLog.isColorLevel()) {
      QLog.d("CaptureUtil", 2, "isX86Platform: Build.CPU_ABI=" + str1 + " Build.CPU_ABI2=" + str2);
    }
    if ((str1 != null) && (!"".equals(str1)) && ("x86".equalsIgnoreCase(str1))) {}
    do
    {
      return true;
      if (imm.getCpuArchitecture() != 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "isX86Platform: VcSystemInfo.getCpuArchitecture()=x86");
    return true;
    return false;
  }
  
  public static boolean auM()
  {
    return !auL();
  }
  
  public static boolean auN()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).getBoolean("capture_shared_gesture_recognize_result", false);
  }
  
  public static int[] b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > paramInt1) {
      return new int[] { iN((int)(paramInt2 * (1.0F * paramInt1 / paramInt3))), paramInt1 };
    }
    return new int[] { paramInt2, paramInt3 };
  }
  
  public static boolean bi(boolean paramBoolean)
  {
    boolean bool5 = true;
    boolean bool4 = true;
    for (;;)
    {
      boolean bool6;
      boolean bool2;
      boolean bool1;
      boolean bool3;
      try
      {
        if (!cAe)
        {
          bool6 = GraphicRenderMgr.loadSo();
          int j = ankq.aB(BaseApplicationImpl.getContext());
          axiy.e("CaptureUtil", "PtvFilterSoLoad.getFilterSoState result = " + j);
          if (j != 1) {
            continue;
          }
          bool2 = ankq.axX();
          bool1 = bool2;
          if (paramBoolean) {
            bool1 = bool2 & AIManager.installDetector(PTHumanSegmenter.class, FeatureManager.getSoDir(), FeatureManager.getResourceDir());
          }
          bool3 = ankq.axY();
          if ((!bool1) || (!bool3)) {
            continue;
          }
          i = 1;
          dyF = i;
          bool2 = bool1;
          bool1 = bool3;
          if (!ankq.isSupportPortarit()) {
            break label333;
          }
          if (!AIManager.isDetectorReady(AEDetectorType.SEGMENT)) {
            break label368;
          }
          break label333;
          if (!angh.by(BaseApplicationImpl.getContext())) {
            break label339;
          }
          angh.cFq = true;
          break label339;
          label143:
          cAe = paramBoolean;
          if (QLog.isColorLevel()) {
            QLog.d("CaptureUtil", 2, new Object[] { "loadEffectSo, ", Boolean.valueOf(cAe), "  avSo:", Boolean.valueOf(bool6), "  ptuSo:", Boolean.valueOf(bool2), "  ptuSoVersion:", Boolean.valueOf(bool1), "  portraitSo:", Boolean.valueOf(bool3), " result:", Integer.valueOf(j), "  PTV_FILTER_SO_LOADED:", Integer.valueOf(dyF), "  PTU_RES_DOWNLOADED:", Boolean.valueOf(angh.cFq) });
          }
        }
        paramBoolean = cAe;
        return paramBoolean;
        int i = 0;
        continue;
        dyF = 2;
        bool1 = false;
        bool2 = false;
        continue;
        label313:
        cAe = paramBoolean;
        continue;
        paramBoolean = false;
      }
      finally {}
      label333:
      label339:
      label368:
      do
      {
        break label313;
        bool3 = true;
        break;
        if (paramBoolean)
        {
          if ((bool6) && (bool2) && (bool1) && (bool3))
          {
            paramBoolean = bool4;
            break label143;
            bool3 = false;
            break;
          }
          paramBoolean = false;
          break label143;
        }
      } while ((!bool6) || (!bool2) || (!bool1));
      paramBoolean = bool5;
    }
  }
  
  public static void cr(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean2) && (cAf == paramBoolean1)) {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureUtil", 2, "no need to update ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
      }
    }
    do
    {
      return;
      cAf = paramBoolean1;
      aqmj.b(BaseApplicationImpl.getApplication().getSharedPreferences("CaptureUtil", 4).edit().putBoolean("capture_shared_gesture_recognize_result", paramBoolean1));
    } while (!QLog.isColorLevel());
    QLog.d("CaptureUtil", 2, "update sp ,update recognition result : " + paramBoolean1 + " force : " + paramBoolean2);
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  public static int iN(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 16 != 0)
    {
      if (paramInt % 16 < 8) {
        i = paramInt - paramInt % 16;
      }
    }
    else {
      return i;
    }
    return paramInt + (16 - paramInt % 16);
  }
  
  public static int iO(int paramInt)
  {
    switch (paramInt)
    {
    case 90: 
    default: 
      return 0;
    case 0: 
      return 270;
    case 180: 
      return 90;
    }
    return 180;
  }
  
  public static int iP(int paramInt)
  {
    return (paramInt + 45) / 90 * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alwy
 * JD-Core Version:    0.7.0.1
 */