import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.filemanager.util.FMToastUtil.1;
import com.tencent.tim.filemanager.util.FMToastUtil.10;
import com.tencent.tim.filemanager.util.FMToastUtil.11;
import com.tencent.tim.filemanager.util.FMToastUtil.2;
import com.tencent.tim.filemanager.util.FMToastUtil.3;
import com.tencent.tim.filemanager.util.FMToastUtil.4;
import com.tencent.tim.filemanager.util.FMToastUtil.5;
import com.tencent.tim.filemanager.util.FMToastUtil.7;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class auds
{
  private static Map<Integer, Long> kL = new HashMap();
  private static Map<String, Long> kM = new HashMap();
  private static int mToastOffset = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
  
  public static void D(int paramInt1, String paramString, int paramInt2)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!mG(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.7(paramInt1, paramString, paramInt2));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), paramInt1, paramString, paramInt2).show(mToastOffset);
  }
  
  public static void JD(String paramString)
  {
    if (BaseApplicationImpl.sApplication.getRuntime().isBackground_Pause) {}
    while (!mG(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.2(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).show(mToastOffset);
  }
  
  public static void JE(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.4(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 0).show(mToastOffset);
  }
  
  public static void JF(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!mG(paramString)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.5(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramString, 1).show(mToastOffset);
  }
  
  public static void JG(String paramString)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.10(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).show(mToastOffset);
  }
  
  public static void OS(int paramInt)
  {
    try
    {
      if (BaseApplicationImpl.sApplication.getRuntime().isBackground_Pause) {
        return;
      }
      if (jO(paramInt))
      {
        Looper localLooper = Looper.getMainLooper();
        if (Thread.currentThread() != localLooper.getThread())
        {
          new Handler(localLooper).post(new FMToastUtil.1(paramInt));
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), 0, paramInt, 0).show(mToastOffset);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public static void OT(int paramInt)
  {
    if (((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).isBackground_Pause) {}
    while (!jO(paramInt)) {
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.3(paramInt));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, paramInt, 0).show(mToastOffset);
  }
  
  public static void Zn(String paramString)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new FMToastUtil.11(paramString));
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 0, paramString, 0).show(mToastOffset);
  }
  
  private static boolean jO(int paramInt)
  {
    if (kL.containsKey(Integer.valueOf(paramInt)))
    {
      long l1 = ((Long)kL.get(Integer.valueOf(paramInt))).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        kL.put(Integer.valueOf(paramInt), Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      kL.clear();
      kL.put(Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
  
  private static boolean mG(String paramString)
  {
    if (kM.containsKey(paramString))
    {
      long l1 = ((Long)kM.get(paramString)).longValue();
      long l2 = SystemClock.uptimeMillis();
      if (l1 + 2000L < l2)
      {
        kM.put(paramString, Long.valueOf(l2));
        return true;
      }
    }
    else
    {
      kM.clear();
      kM.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auds
 * JD-Core Version:    0.7.0.1
 */