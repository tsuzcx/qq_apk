import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.AppRuntime;

public class afwv
{
  public static final Set<String> co;
  public static final String[] fa = { "coverVertical.png", "coverVerticalSmall.png", "coverHorizontal.png", "expend_match_ellipisis.json", "expand_voice_animation2.json", "fire/fire_00.png", "bomb/bomb_00.png" };
  
  static
  {
    co = new HashSet(1);
    co.add("matchAndAIOPageForNewVersion");
  }
  
  public static void It(String paramString)
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    aqmj.ai(BaseApplicationImpl.getApplication().getBaseContext(), str, paramString);
    if (QLog.isColorLevel())
    {
      if (paramString != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 " + paramString);
      }
    }
    else {
      return;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "setBgPicResMd5 null");
  }
  
  private static void S(String[] paramArrayOfString)
  {
    paramArrayOfString = e(paramArrayOfString);
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        File localFile = new File(paramArrayOfString[i]);
        if (localFile.exists()) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  public static boolean akw()
  {
    return k(fa);
  }
  
  public static boolean akx()
  {
    int i;
    if (new File(kJ("bomb/bomb_00.png")).exists())
    {
      i = 1;
      if (!new File(kJ("fire/fire_00.png")).exists()) {
        break label63;
      }
    }
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label76;
      }
      return true;
      QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "bBombExist signal bomb no");
      i = 0;
      break;
      label63:
      QLog.e("ExtendFriendResourceDownloaderLimitChat", 2, "bFireExist signal bomb no");
    }
    label76:
    return false;
  }
  
  public static boolean b(afsi.a parama)
  {
    boolean bool = false;
    if ((parama != null) && (parama.kw != null))
    {
      String str = uL();
      parama = (afsi.b)parama.kw.get(str);
      if (parama != null)
      {
        parama = parama.md5;
        str = uM();
        if (TextUtils.isEmpty(str))
        {
          bool = true;
          if ((!TextUtils.isEmpty(parama)) && (!parama.equalsIgnoreCase(str))) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if ((bool) && (parama != null)) {
        It(parama);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "checkBgPicMd5 " + bool);
      }
      return bool;
      continue;
      bool = false;
      break;
      parama = null;
    }
  }
  
  public static void ddx()
  {
    S(fa);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "delBgPicFiles ");
    }
  }
  
  public static String[] e(String[] paramArrayOfString)
  {
    Object localObject = null;
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = kJ(paramArrayOfString[i]);
        i += 1;
      }
    }
    return localObject;
  }
  
  public static String ed(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "coverVertical.png";
    }
    for (;;)
    {
      return kJ(str);
      if (paramInt == 2) {
        str = "coverVerticalSmall.png";
      } else {
        str = "coverHorizontal.png";
      }
    }
  }
  
  private static boolean k(String[] paramArrayOfString)
  {
    return afxw.l(e(paramArrayOfString));
  }
  
  public static String kJ(String paramString)
  {
    return String.format("%s/%s", new Object[] { uN(), paramString });
  }
  
  public static String uL()
  {
    return "matchAndAIOPageForNewVersion";
  }
  
  public static String uM()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    str = aqmj.al(BaseApplicationImpl.getApplication().getBaseContext(), str);
    if (QLog.isColorLevel())
    {
      if (str != null) {
        QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 " + str);
      }
    }
    else {
      return str;
    }
    QLog.d("ExtendFriendResourceDownloaderLimitChat", 2, "getBgPicResMd5 null");
    return str;
  }
  
  public static String uN()
  {
    return String.format("%s/matchChat", new Object[] { afss.uI() });
  }
  
  public static String uO()
  {
    return kJ("fire/");
  }
  
  public static String uP()
  {
    return kJ("bomb/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwv
 * JD-Core Version:    0.7.0.1
 */