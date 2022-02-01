import android.text.TextUtils;
import java.util.List;

public class aqag
{
  public static void a(int paramInt1, int paramInt2, String[] paramArrayOfString, aqaf paramaqaf)
  {
    switch (paramInt1)
    {
    default: 
      paramaqaf.a.type = 0;
      paramaqaf.a.value = paramArrayOfString[0];
      paramaqaf.IC.clear();
      return;
    case 2: 
      a(paramArrayOfString, paramaqaf);
      return;
    case 3: 
      a(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 4: 
      b(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 5: 
      c(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 6: 
      d(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 7: 
      e(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 8: 
      g(paramInt2, paramArrayOfString, paramaqaf);
      return;
    case 9: 
    case 11: 
      f(paramInt2, paramArrayOfString, paramaqaf);
      return;
    }
    h(paramInt2, paramArrayOfString, paramaqaf);
  }
  
  public static void a(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    paramaqaf.IC.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[1]))
      {
        paramaqaf.a.type = 1;
        paramaqaf.a.value = paramArrayOfString[1];
        if (!TextUtils.isEmpty(paramArrayOfString[4]))
        {
          localaqae = new aqae();
          localaqae.type = 4;
          localaqae.value = paramArrayOfString[4];
          paramaqaf.IC.add(localaqae);
        }
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localaqae = new aqae();
          localaqae.type = 3;
          localaqae.value = paramArrayOfString[3];
          paramaqaf.IC.add(localaqae);
        }
      }
    }
    while (paramInt != 1)
    {
      do
      {
        do
        {
          return;
          if (TextUtils.isEmpty(paramArrayOfString[4])) {
            break;
          }
          paramaqaf.a.type = 4;
          paramaqaf.a.value = paramArrayOfString[4];
        } while (TextUtils.isEmpty(paramArrayOfString[3]));
        localaqae = new aqae();
        localaqae.type = 3;
        localaqae.value = paramArrayOfString[3];
        paramaqaf.IC.add(localaqae);
        return;
        paramaqaf.a.type = 0;
        paramaqaf.a.value = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      aqae localaqae = new aqae();
      localaqae.type = 3;
      localaqae.value = paramArrayOfString[3];
      paramaqaf.IC.add(localaqae);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[1]))
    {
      paramaqaf.a.type = 1;
      paramaqaf.a.value = paramArrayOfString[1];
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramaqaf.a.type = 6;
      paramaqaf.a.value = paramArrayOfString[6];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void a(String[] paramArrayOfString, aqaf paramaqaf)
  {
    paramaqaf.IC.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[4]))
    {
      paramaqaf.a.type = 4;
      paramaqaf.a.value = paramArrayOfString[4];
      if (!TextUtils.isEmpty(paramArrayOfString[3]))
      {
        localaqae = new aqae();
        localaqae.type = 3;
        localaqae.value = paramArrayOfString[3];
        paramaqaf.IC.add(localaqae);
      }
    }
    do
    {
      return;
      paramaqaf.a.type = 0;
      paramaqaf.a.value = paramArrayOfString[0];
    } while (TextUtils.isEmpty(paramArrayOfString[3]));
    aqae localaqae = new aqae();
    localaqae.type = 3;
    localaqae.value = paramArrayOfString[3];
    paramaqaf.IC.add(localaqae);
  }
  
  public static void b(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramaqaf);
    }
    while (paramInt != 1) {
      return;
    }
    paramaqaf.IC.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[6]))
    {
      paramaqaf.a.type = 6;
      paramaqaf.a.value = paramArrayOfString[6];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void c(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    paramaqaf.IC.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramaqaf.a.type = 4;
        paramaqaf.a.value = paramArrayOfString[4];
      }
    }
    while (paramInt != 1)
    {
      do
      {
        return;
        paramaqaf.a.type = 0;
        paramaqaf.a.value = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[2]));
      aqae localaqae = new aqae();
      localaqae.type = 2;
      localaqae.value = paramArrayOfString[2];
      paramaqaf.IC.add(localaqae);
      return;
    }
    if (!TextUtils.isEmpty(paramArrayOfString[2]))
    {
      paramaqaf.a.type = 2;
      paramaqaf.a.value = paramArrayOfString[2];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void d(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    paramaqaf.IC.clear();
    if (paramInt == 2) {
      if (!TextUtils.isEmpty(paramArrayOfString[4]))
      {
        paramaqaf.a.type = 4;
        paramaqaf.a.value = paramArrayOfString[4];
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          localaqae = new aqae();
          localaqae.type = 3;
          localaqae.value = paramArrayOfString[3];
          paramaqaf.IC.add(localaqae);
        }
      }
    }
    do
    {
      do
      {
        return;
        paramaqaf.a.type = 0;
        paramaqaf.a.value = paramArrayOfString[0];
      } while (TextUtils.isEmpty(paramArrayOfString[3]));
      localaqae = new aqae();
      localaqae.type = 3;
      localaqae.value = paramArrayOfString[3];
      paramaqaf.IC.add(localaqae);
      return;
      if (paramInt == 1)
      {
        localaqae = new aqae();
        localaqae.type = 0;
        localaqae.value = paramArrayOfString[0];
        paramaqaf.IC.add(localaqae);
        if (!TextUtils.isEmpty(paramArrayOfString[3]))
        {
          paramaqaf.a.type = 3;
          paramaqaf.a.value = paramArrayOfString[3];
          return;
        }
        paramaqaf.a.type = 0;
        paramaqaf.a.value = paramArrayOfString[0];
        return;
      }
    } while (paramInt != 3);
    aqae localaqae = new aqae();
    localaqae.type = 7;
    localaqae.value = paramArrayOfString[0];
    paramaqaf.IC.add(localaqae);
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramaqaf.a.type = 3;
      paramaqaf.a.value = paramArrayOfString[3];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void e(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramaqaf);
    }
    while (paramInt != 1) {
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
    paramaqaf.IC.clear();
  }
  
  public static void f(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramaqaf);
    }
    while (paramInt != 1) {
      return;
    }
    paramaqaf.IC.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[5]))
    {
      paramaqaf.a.type = 5;
      paramaqaf.a.value = paramArrayOfString[5];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void g(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramaqaf);
    }
    while (paramInt != 1) {
      return;
    }
    paramaqaf.IC.clear();
    if (!TextUtils.isEmpty(paramArrayOfString[3]))
    {
      paramaqaf.a.type = 3;
      paramaqaf.a.value = paramArrayOfString[3];
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
  }
  
  public static void h(int paramInt, String[] paramArrayOfString, aqaf paramaqaf)
  {
    if (paramInt == 2) {
      a(paramArrayOfString, paramaqaf);
    }
    while (paramInt != 1) {
      return;
    }
    paramaqaf.a.type = 0;
    paramaqaf.a.value = paramArrayOfString[0];
    paramaqaf.IC.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqag
 * JD-Core Version:    0.7.0.1
 */