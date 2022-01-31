import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.MD5;

public class yhl
{
  public static Pair<Boolean, Setting> a(int paramInt1, String paramString, int paramInt2)
  {
    String str = QQAppInterface.b(paramInt1, paramString, paramInt2);
    paramString = new QQEntityManagerFactory(paramString).createEntityManager();
    if ((0 == 0) && (!TextUtils.isEmpty(str)) && (paramString != null)) {}
    for (paramString = (Setting)paramString.a(Setting.class, str);; paramString = null)
    {
      if (paramString == null) {
        return new Pair(Boolean.valueOf(true), paramString);
      }
      boolean bool;
      switch (paramInt1)
      {
      default: 
        bool = false;
      }
      for (;;)
      {
        return new Pair(Boolean.valueOf(bool), paramString);
        if ((paramString == null) || (System.currentTimeMillis() - paramString.updateTimestamp > 86400000L)) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
  }
  
  public static bdam a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = bdaw.a;
    bdam localbdam = new bdam();
    int i = 0;
    do
    {
      bdal.a(paramString, localOptions, localbdam);
      if (localbdam.a == 1) {
        NearbyAppInterface.b();
      }
      i += 1;
    } while ((i < 2) && (localbdam.a == 1));
    return localbdam;
  }
  
  public static String a(Setting paramSetting, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = paramSetting;
    if (paramSetting == null)
    {
      localObject = paramSetting;
      if (paramString != null)
      {
        localObject = paramSetting;
        if (paramInt1 != 101)
        {
          localObject = paramSetting;
          if (paramInt1 != 1001) {
            localObject = (Setting)a(paramInt1, paramString, paramInt2).second;
          }
        }
      }
    }
    paramSetting = new StringBuilder(256);
    if (paramInt1 == 32) {
      if (bdep.a())
      {
        paramSetting.append(alof.bL);
        localObject = a((Setting)localObject, paramString, paramInt1);
        switch (((Integer)localObject[0]).intValue())
        {
        }
      }
    }
    for (;;)
    {
      localObject = MD5.toMD5(paramString);
      localObject = MD5.toMD5((String)localObject + paramString);
      paramSetting.append(MD5.toMD5((String)localObject + paramString));
      paramSetting.append(".jpg_");
      return paramSetting.toString();
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
      break;
      if (bdep.a())
      {
        paramSetting.append(alof.bJ);
        break;
      }
      paramSetting.append("/data/data/com.tencent.mobileqq/files/head/_hd/");
      break;
      paramSetting.append("troop_sys_b_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("sys_");
      paramString = (String)localObject[1];
      continue;
      paramSetting.append("dis_g_");
      paramString = paramString + paramString;
      continue;
      paramSetting.append("dis_pstn_g_");
      paramString = paramString + paramString;
      continue;
      paramSetting.append("troop_");
      continue;
      paramSetting.append("new_troop_b_");
      continue;
      paramSetting.append("stranger_").append(Integer.toString(paramInt2)).append("_");
      continue;
      paramSetting.append("qcall_").append(Integer.toString(paramInt2)).append("_");
    }
  }
  
  private static Object[] a(Setting paramSetting, String paramString, int paramInt)
  {
    String str = paramString;
    int i = paramInt;
    if (paramSetting != null)
    {
      str = paramString;
      i = paramInt;
      if (paramInt != 101)
      {
        str = paramString;
        i = paramInt;
        if (paramInt != 1001)
        {
          str = paramString;
          i = paramInt;
          if (paramString != null)
          {
            str = paramString;
            i = paramInt;
            if (paramSetting.bHeadType == 0)
            {
              str = String.valueOf(paramSetting.systemHeadID);
              if (paramInt != 4) {
                break label87;
              }
              i = -56;
            }
          }
        }
      }
    }
    for (;;)
    {
      return new Object[] { Integer.valueOf(i), str };
      label87:
      if (paramInt == 16) {
        i = 16;
      } else {
        i = -55;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhl
 * JD-Core Version:    0.7.0.1
 */