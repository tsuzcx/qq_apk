import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;

public class ixo
{
  static void B(long paramLong, boolean paramBoolean)
  {
    Object localObject = imp.a();
    if (!imr.ub()) {
      localObject = "0X80077BF";
    }
    for (;;)
    {
      d((String)localObject, paramBoolean, paramLong);
      return;
      if (!((imp)localObject).ua()) {
        localObject = "0X80077C0";
      } else if (!((imp)localObject).SB) {
        localObject = "0X80077BE";
      } else {
        localObject = "0X80077BD";
      }
    }
  }
  
  static void a(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3)
  {
    String str2;
    Object localObject;
    String str1;
    switch (paramInt1)
    {
    default: 
      str2 = "0X8008395";
      localObject = str2;
      if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
      {
        str1 = "0X8008396";
        localObject = str2;
      }
      break;
    }
    for (;;)
    {
      str2 = String.valueOf(paramInt3);
      String str3 = String.valueOf(paramLong);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, paramInt2, 0, str2, "", str3, paramString);
      }
      if (!TextUtils.isEmpty(str1)) {
        anot.a(null, "dc00898", "", "", str1, str1, paramInt2, 0, str2, "", str3, paramString);
      }
      return;
      str1 = "0X8007F37";
      localObject = str1;
      if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
      {
        str2 = "0X80083AA";
        localObject = str1;
        str1 = str2;
        continue;
        str1 = "0X8007F31";
        localObject = str1;
        if (PtvTemplateManager.PtvTemplateInfo.isGesture(paramInt3))
        {
          str2 = "0X8008398";
          localObject = str1;
          str1 = str2;
          continue;
        }
      }
      str1 = null;
    }
  }
  
  static void a(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    String str = null;
    switch (paramInt1)
    {
    default: 
      if (paramBoolean) {
        str = "0X8006F8D";
      }
      break;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        d(str, paramBoolean, paramLong);
      }
      return;
      if (paramInt2 == 4) {
        if (iju.isSupport(paramContext))
        {
          str = "0X8007F2E";
        }
        else
        {
          str = "0X8007F2F";
          continue;
          if (paramInt2 == 4) {
            if (iju.isSupport(paramContext))
            {
              str = "0X8007F28";
            }
            else
            {
              str = "0X8007F29";
              continue;
              str = "0X8006F8E";
            }
          }
        }
      }
    }
  }
  
  static void a(VideoAppInterface paramVideoAppInterface, long paramLong, boolean paramBoolean)
  {
    boolean bool;
    if (paramVideoAppInterface != null)
    {
      paramVideoAppInterface = (ikt)paramVideoAppInterface.a(5);
      bool = paramVideoAppInterface.d(3, "normal");
      if (!paramVideoAppInterface.d(3, "interact")) {
        break label42;
      }
      paramVideoAppInterface = "0X8008023";
    }
    for (;;)
    {
      d(paramVideoAppInterface, paramBoolean, paramLong);
      return;
      label42:
      if (bool) {
        paramVideoAppInterface = "0X8008024";
      } else {
        paramVideoAppInterface = "0X8008132";
      }
    }
  }
  
  public static void arZ()
  {
    anot.a(null, "dc00898", "", "", "0X8006F88", "0X8006F88", 0, 0, "", "", "", "");
  }
  
  static void asa()
  {
    anot.a(null, "dc00898", "", "", "0X8006F8F", "0X8006F8F", 0, 0, "", "", "", "");
  }
  
  static void b(Context paramContext, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int j = 0;
    Object localObject = "";
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (iju.isSupport(paramContext))
      {
        i = j;
        if (anhs.a().axd()) {
          i = 1;
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      if (paramBoolean)
      {
        localObject = "0X8006F89";
        paramContext = (Context)localObject;
        if (i == 0) {
          break label163;
        }
        paramContext = "0X8008394";
      }
      break;
    }
    for (;;)
    {
      d((String)localObject, paramBoolean, paramLong);
      d(paramContext, paramBoolean, paramLong);
      return;
      paramContext = (Context)localObject;
      if (paramInt2 == 4)
      {
        paramContext = "0X8007F2C";
        if (i != 0)
        {
          paramContext = "0X80083A9";
          localObject = "0X8007F2C";
          continue;
          paramContext = (Context)localObject;
          if (paramInt2 == 4)
          {
            paramContext = "0X8007F26";
            if (i != 0)
            {
              paramContext = "0X8008397";
              localObject = "0X8007F26";
              continue;
              localObject = "0X8006F8A";
              break;
            }
          }
        }
      }
      label163:
      String str = "";
      localObject = paramContext;
      paramContext = str;
    }
  }
  
  public static void d(String paramString, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = -1)
    {
      anot.a(null, "dc00898", "", "", paramString, paramString, 0, i, "", "", String.valueOf(paramLong), "");
      return;
    }
  }
  
  public static void y(int paramInt, long paramLong)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "0X8006F87";
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str)) {
        anot.a(null, "dc00898", "", "", str, str, 0, 0, "", "", String.valueOf(paramLong), "");
      }
      return;
      str = "0X8007F2B";
      continue;
      str = "0X8007F25";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ixo
 * JD-Core Version:    0.7.0.1
 */