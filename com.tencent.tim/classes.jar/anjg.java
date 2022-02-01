import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class anjg
{
  public static String[] ax = { "Le X620", "Nexus 5X", "ZTE A2017", "PRA-AL00X" };
  private static boolean cHk;
  public static HashMap<String, WeakReference<Drawable>> nq = new HashMap();
  
  public static void Qb(boolean paramBoolean)
  {
    if (cHk == paramBoolean) {
      return;
    }
    cHk = paramBoolean;
    aqmj.b(BaseApplicationImpl.getApplication().getSharedPreferences("GestureRecognitionUtils", 4).edit().putBoolean("shared_gesture_recognize_result", paramBoolean));
  }
  
  public static boolean axw()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    String[] arrayOfString = ax;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfString[i].contains(str)) {
          bool1 = true;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("GestureRecognitionUtils", 2, "isPhoneInBlackList ： phone = " + str + ", result=" + bool1);
        }
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean axx()
  {
    boolean bool = anhs.a().ug();
    if (!bool) {
      anhs.a().uh();
    }
    QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check gestureResource ready " + bool);
    return bool;
  }
  
  public static boolean axy()
  {
    boolean bool1;
    if ((iow.k(8, 1400000L)) || (iow.k(4, 2150000L)))
    {
      bool1 = true;
      QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils check condition 2 +cpuNumber is" + bool1);
      ioj localioj = ioj.a();
      if ((localioj == null) || (localioj.tw())) {
        break label193;
      }
    }
    label193:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (Build.VERSION.SDK_INT > 17) {}
      for (boolean bool3 = true;; bool3 = false)
      {
        boolean bool4 = anki.axG();
        boolean bool5 = axw();
        QLog.d("GestureRecognitionUtils", 2, "GestureRecognitionUtils isSupportGestureFilter faceFilterCheck: " + true + ";checkDeviceSupport:" + bool1 + ":inBlackLists:" + bool2 + ":isSDKEnable:" + bool3 + ":isNotInShortVideoBlackWhiteList:" + bool4 + ":isHardCodePhoneInBlackList" + bool5);
        if ((bool1) && (!bool2) && (bool3) && (bool4) && (!bool5))
        {
          return true;
          bool1 = false;
          break;
        }
        return false;
      }
    }
  }
  
  public static alwl c(alwl paramalwl)
  {
    if ((!axy()) || (!axx())) {}
    for (int i = 1; i == 0; i = 0) {
      return paramalwl;
    }
    alwl localalwl = new alwl();
    localalwl.categoryId = paramalwl.categoryId;
    localalwl.categoryName = paramalwl.categoryName;
    localalwl.Fv = new ArrayList();
    paramalwl = paramalwl.Fv.iterator();
    if (i != 0) {
      while (paramalwl.hasNext())
      {
        PtvTemplateManager.PtvTemplateInfo localPtvTemplateInfo = (PtvTemplateManager.PtvTemplateInfo)paramalwl.next();
        if (!localPtvTemplateInfo.hasGesture()) {
          localalwl.Fv.add(localPtvTemplateInfo);
        }
      }
    }
    return localalwl;
  }
  
  public static Drawable g(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    Object localObject2;
    if (nq.containsKey(paramString))
    {
      localObject2 = (Drawable)((WeakReference)nq.get(paramString)).get();
      localObject1 = localObject2;
      if (localObject2 != null) {
        return localObject2;
      }
    }
    if (paramString.equals("fivea")) {
      paramContext = paramContext.getResources().getDrawable(2130842984);
    }
    for (;;)
    {
      localObject2 = paramContext;
      if (paramContext == null) {
        break;
      }
      nq.put(paramString, new WeakReference(paramContext));
      return paramContext;
      if (paramString.equals("palmup"))
      {
        paramContext = paramContext.getResources().getDrawable(2130842985);
      }
      else if (paramString.equals("qheart"))
      {
        paramContext = paramContext.getResources().getDrawable(2130842986);
      }
      else
      {
        paramContext = localObject1;
        if (!paramString.equals("")) {
          paramContext = new BitmapDrawable(ahbj.B(anhx.getModelPath() + paramString + ".png"));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anjg
 * JD-Core Version:    0.7.0.1
 */