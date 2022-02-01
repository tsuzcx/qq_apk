import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afky
{
  private static int cRM = -1;
  public static int cRN = 10;
  public static int cRO = 100;
  
  public static Drawable A(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface gif index: " + paramInt);
    }
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof afkx)) {
      return ((afkx)localQQSysAndEmojiResInfo).y(paramInt);
    }
    return null;
  }
  
  public static int De()
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof afkx))
    {
      int j = ((afkx)localQQSysAndEmojiResInfo).Dd();
      int i = j;
      if (j == 0) {
        i = anbk.k.length;
      }
      return i;
    }
    return 0;
  }
  
  public static int Df()
  {
    if (cRM == -1)
    {
      long l = System.currentTimeMillis();
      aenf.c localc = (aenf.c)aeif.a().o(545);
      if (!TextUtils.isEmpty(localc.a.bzJ)) {
        cRM = I(localc.a.bzJ, Build.MODEL);
      }
      if ((cRM == -1) && (!TextUtils.isEmpty(localc.a.bzK))) {
        cRM = X(localc.a.bzK, Build.VERSION.SDK_INT);
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "animCount:", Integer.valueOf(cRM), ", parseCost:", Long.valueOf(System.currentTimeMillis() - l) });
    }
    if (cRM < cRN) {
      cRM = cRN;
    }
    for (;;)
    {
      return cRM;
      if (cRM > cRO) {
        cRM = cRO;
      } else if (cRM == -1) {
        cRM = cRN;
      }
    }
  }
  
  protected static int I(String paramString1, String paramString2)
  {
    int i = 0;
    int k = -1;
    try
    {
      paramString1 = paramString1.split("\\|");
      int m = paramString1.length;
      for (;;)
      {
        int j = k;
        if (i < m)
        {
          String[] arrayOfString = paramString1[i].split(":");
          if ((arrayOfString.length == 2) && (paramString2.equalsIgnoreCase(arrayOfString[0]))) {
            j = Integer.parseInt(arrayOfString[1]);
          }
        }
        else
        {
          return j;
        }
        i += 1;
      }
      return -1;
    }
    catch (Exception paramString1)
    {
      QLog.e("SysFaceUtil", 1, "parseAnimCountByModel error!", paramString1);
    }
  }
  
  protected static int X(String paramString, int paramInt)
  {
    int i = 0;
    int k = 10;
    for (;;)
    {
      try
      {
        paramString = paramString.split("\\|");
        int m = paramString.length;
        int j = k;
        if (i < m)
        {
          String[] arrayOfString1 = paramString[i].split(":");
          if (arrayOfString1.length == 2)
          {
            String[] arrayOfString2 = arrayOfString1[0].split("-");
            if (((TextUtils.isEmpty(arrayOfString2[0])) || (paramInt >= Integer.parseInt(arrayOfString2[0]))) && ((arrayOfString2.length <= 1) || (TextUtils.isEmpty(arrayOfString2[1])) || (paramInt < Integer.parseInt(arrayOfString2[1])))) {
              j = Integer.parseInt(arrayOfString1[1]);
            }
          }
        }
        else
        {
          return j;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("SysFaceUtil", 1, "parseAnimCountByVersion error!", paramString);
        return 10;
      }
      i += 1;
    }
  }
  
  public static int cM(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof afkx)) {
      return ((afkx)localQQSysAndEmojiResInfo).cM(paramString);
    }
    return -1;
  }
  
  public static ArrayList<Integer> cV()
  {
    Object localObject = afkv.a().a(1).cV();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
      return localObject;
    }
    localObject = afqv.Q();
    ArrayList localArrayList = new ArrayList(localObject.length);
    int i = 0;
    while (i < localObject.length)
    {
      localArrayList.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static void dad()
  {
    afkv.a().a(1).cZY();
  }
  
  public static String ea(int paramInt)
  {
    String str2 = afkv.a().a(1).dY(paramInt);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (paramInt < aoff.hj.length) {
        str1 = aoff.hj[paramInt];
      }
    }
    return str1;
  }
  
  public static final String eb(int paramInt)
  {
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static int hl(int paramInt)
  {
    int i = afkv.a().a(1).hh(paramInt);
    if (i == -1)
    {
      if (paramInt < anbk.j.length) {
        return anbk.j[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized localId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static int hm(int paramInt)
  {
    int i = afkv.a().a(1).hk(paramInt);
    if (i == -1)
    {
      if (paramInt < anbk.k.length) {
        return anbk.k[paramInt];
      }
      QLog.d("SysFaceUtil", 1, new Object[] { "unrecognized serverId:", Integer.valueOf(paramInt) });
      return paramInt;
    }
    return i;
  }
  
  public static boolean jm(int paramInt)
  {
    return afkv.a().a(1).jk(paramInt);
  }
  
  public static boolean jo(int paramInt)
  {
    Object localObject = afkv.a().a(1);
    if ((localObject instanceof afkx))
    {
      localObject = (afkx)localObject;
      try
      {
        boolean bool = ((afkx)localObject).jo(paramInt);
        return bool;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        return false;
      }
    }
    return false;
  }
  
  public static boolean jq(int paramInt)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof afkx)) {
      return ((afkx)localQQSysAndEmojiResInfo).jp(paramInt);
    }
    return false;
  }
  
  public static boolean jr(int paramInt)
  {
    if ((paramInt == 255) || (paramInt == 511) || (paramInt == 250)) {}
    while ((paramInt < 0) || (paramInt > 65535)) {
      return false;
    }
    return true;
  }
  
  public static String kF(String paramString)
  {
    QQSysAndEmojiResInfo localQQSysAndEmojiResInfo = afkv.a().a(1);
    if ((localQQSysAndEmojiResInfo instanceof afkx)) {
      return ((afkx)localQQSysAndEmojiResInfo).kF(paramString);
    }
    return null;
  }
  
  public static Drawable z(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid sysface static index: " + paramInt);
    }
    Object localObject;
    if (paramInt < aoff.dOp)
    {
      localObject = BaseApplicationImpl.getContext().getResources();
      paramInt = aoff.om[paramInt];
      if (BaseApplicationImpl.sImageCache != null) {
        localObject = aofy.i((Resources)localObject, paramInt);
      }
    }
    Drawable localDrawable;
    do
    {
      return localObject;
      return ((Resources)localObject).getDrawable(paramInt);
      localDrawable = afkv.a().a(1).getDrawable(paramInt);
      localObject = localDrawable;
    } while (!QLog.isColorLevel());
    QLog.d("SysFaceUtil", 2, "getFaceDrawable in new way");
    return localDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afky
 * JD-Core Version:    0.7.0.1
 */