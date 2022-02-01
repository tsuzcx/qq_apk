import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.text.TextUtils.1;
import com.tencent.mobileqq.text.TextUtils.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class aofy
{
  public static final int dOw = aoff.hk.length;
  
  public static String M(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = "";
    }
    do
    {
      return localObject1;
      localObject1 = paramString;
    } while (!Z(paramString));
    Object localObject1 = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    StringBuilder localStringBuilder;
    int j;
    int k;
    label235:
    Object localObject3;
    label241:
    String str;
    for (;;)
    {
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject1);
        if (localObject1 == null) {}
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          try
          {
            if ((localObject1 instanceof NearbyAppInterface)) {
              break label235;
            }
            localObject1 = (ajdg)((AppInterface)localObject1).getManager(14);
            localStringBuilder = new StringBuilder(paramString);
            i = 0;
            if (i >= localStringBuilder.length()) {
              break label465;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if ((!afky.jr(k)) && (250 != k)) {
                  break label241;
                }
                j = k;
                if (250 == k) {
                  j = 10;
                }
                paramString = afky.ea(j);
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
            continue;
            i = 0;
          }
          catch (Throwable localThrowable)
          {
            Object localObject2;
            localThrowable.printStackTrace();
          }
          localAccountNotMatchException = localAccountNotMatchException;
          localAccountNotMatchException.printStackTrace();
          localObject2 = null;
          continue;
          localObject3 = null;
          continue;
          j = i;
          if (k == 255)
          {
            if (i + 4 < localStringBuilder.length()) {
              break label290;
            }
            paramString = aofk.ckA;
            localStringBuilder.replace(i, localStringBuilder.length(), paramString);
            i += paramString.length() - 1;
          }
        }
        label290:
        paramString = new char[4];
        paramString[0] = localStringBuilder.charAt(i + 4);
        paramString[1] = localStringBuilder.charAt(i + 3);
        paramString[2] = localStringBuilder.charAt(i + 2);
        paramString[3] = localStringBuilder.charAt(i + 1);
        j = 0;
        if (j < 3)
        {
          if (paramString[j] == 'ú') {
            paramString[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (paramString[j] == 'þ') {
              paramString[j] = 13;
            }
          }
        }
        paramString = afgc.a(paramString);
        str = aofk.ckA;
        if (paramString == null) {
          break label476;
        }
      }
    }
    if (paramString.length == 2)
    {
      k = paramString[0];
      j = paramString[1];
    }
    for (;;)
    {
      if (localObject3 != null) {}
      for (paramString = localObject3.a(Integer.toString(k), Integer.toString(j));; paramString = null)
      {
        if (paramString != null) {
          str = paramString.character;
        }
        localStringBuilder.replace(i, i + 5, str);
        j = i + (str.length() - 1);
        break;
        label465:
        return localStringBuilder.toString();
      }
      label476:
      j = 0;
      k = 0;
    }
  }
  
  public static void P(TextView paramTextView)
  {
    if ((Build.VERSION.SDK_INT >= 29) && (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
    try
    {
      if (!((aeji)aeif.a().o(566)).bUv) {
        paramTextView.setBreakStrategy(0);
      }
      return;
    }
    catch (Throwable paramTextView)
    {
      QLog.e("TextUtils", 1, paramTextView, new Object[0]);
    }
  }
  
  public static boolean Z(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\024')) {
      return false;
    }
    return true;
  }
  
  public static final Drawable a(int paramInt, aofy.a parama)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    Object localObject;
    if (paramInt >= 1000)
    {
      localObject = "emotion://" + paramInt;
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
      }
      ThreadManager.executeOnFileThread(new TextUtils.1(paramInt, parama));
      return null;
    }
    if ((paramInt >= 0) && (paramInt < aoff.dOq)) {}
    for (paramInt = 2130839808 + paramInt;; paramInt = 2130839942)
    {
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject = "android.resource://" + paramInt;
        localObject = (Pair)BaseApplicationImpl.sImageCache.get(localObject);
        if ((localObject != null) && (((Pair)localObject).first != null)) {
          return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(localResources);
        }
        ThreadManager.executeOnFileThread(new TextUtils.2(paramInt, parama));
        return null;
      }
      return BaseApplicationImpl.getContext().getResources().getDrawable(paramInt);
    }
  }
  
  public static String a(TextView paramTextView, String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramTextView = "";
    }
    int j;
    do
    {
      return paramTextView;
      paramTextView.getLayout();
      int m = (int)Layout.getDesiredWidth("...", paramTextView.getPaint());
      int k = paramString.codePointCount(0, paramString.length());
      j = paramString.length();
      for (int i = (int)Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint()) + 1; (k > 0) && (i > paramInt - m - 1); i = (int)Layout.getDesiredWidth(paramString.subSequence(0, j), paramTextView.getPaint()) + 1)
      {
        k -= 1;
        j = paramString.offsetByCodePoints(0, k);
      }
      paramTextView = paramString;
    } while (j == paramString.length());
    return paramString.substring(0, j) + "...";
  }
  
  public static String a(String paramString, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      localObject = "";
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (paramPaint == null);
    int j = 0;
    int i3 = paramString.length();
    int i = 0;
    int i4 = aqnm.dip2px(paramInt2);
    paramInt2 = 0;
    Object localObject = new StringBuilder();
    int k = 0;
    int i5;
    int m;
    int n;
    int i1;
    if ((k < i3) && (paramInt2 < paramInt3))
    {
      i5 = paramString.codePointAt(k);
      if (((paramInt1 & 0x6) > 0) && (i5 == 20) && (k < i3 - 1))
      {
        paramInt2 = paramString.charAt(k + 1);
        if (afky.jr(paramInt2))
        {
          paramInt2 = 2;
          i += 1;
          j = 1;
        }
        for (;;)
        {
          if (j == 0)
          {
            paramInt2 = 1;
            ((StringBuilder)localObject).append(paramString.charAt(k));
          }
          j = (int)(paramPaint.measureText(((StringBuilder)localObject).toString()) + i * i4 + 0.5F);
          m = k + paramInt2;
          k = paramInt2;
          paramInt2 = j;
          j = k;
          k = m;
          break;
          if ((paramInt2 >= 255) && (k + 4 < i3))
          {
            paramInt2 = 4;
            i += 1;
            j = 1;
          }
          else
          {
            if (paramInt2 != 250) {
              break label597;
            }
            paramInt2 = 2;
            i += 1;
            j = 1;
          }
        }
      }
      if ((paramInt1 & 0x1) != 1) {
        break label597;
      }
      j = aoff.jw(i5);
      paramInt2 = -1;
      n = 0;
      i1 = 0;
      if (i5 > 65535)
      {
        m = i1;
        if (i3 > k + 2)
        {
          paramInt2 = paramString.codePointAt(k + 2);
          m = i1;
        }
        label301:
        if (aoff.lM(paramInt2)) {
          n = 1;
        }
        if ((j != -1) && (n == 0)) {
          break label605;
        }
        n = aoff.aO(i5, paramInt2);
        if (n != -1) {
          break label489;
        }
        label336:
        i1 = 1;
        n = j;
      }
    }
    for (j = i1;; j = 0)
    {
      if (n != -1)
      {
        if (j != 0) {
          if ((i5 > 65535) && (i3 >= k + 2))
          {
            j = 2;
            label378:
            if ((paramInt2 <= 65535) || (i3 < k + 2)) {
              break label502;
            }
            paramInt2 = j + 2;
            label399:
            if (m == 0) {
              break label594;
            }
            paramInt2 += 1;
          }
        }
        label594:
        for (;;)
        {
          i += 1;
          j = 1;
          break;
          m = i1;
          if (i3 <= k + 1) {
            break label301;
          }
          int i2 = paramString.codePointAt(k + 1);
          m = i1;
          paramInt2 = i2;
          if (i2 != 65039) {
            break label301;
          }
          m = i1;
          paramInt2 = i2;
          if (i3 <= k + 2) {
            break label301;
          }
          paramInt2 = paramString.codePointAt(k + 2);
          m = 1;
          break label301;
          label489:
          j = n;
          break label336;
          j = 1;
          break label378;
          label502:
          paramInt2 = j + 1;
          break label399;
          if ((i5 > 65535) && (i3 >= k + 2))
          {
            paramInt2 = 2;
          }
          else
          {
            paramInt2 = 1;
            continue;
            if ((k < i3 - 1) && (paramBoolean)) {}
            for (paramString = paramString.substring(0, k - j) + "…";; paramString = paramString.substring(0, k)) {
              return paramString;
            }
          }
        }
      }
      label597:
      j = 0;
      paramInt2 = 0;
      break;
      label605:
      n = j;
    }
  }
  
  public static void a(TextView paramTextView, String paramString1, int paramInt1, TextUtils.TruncateAt paramTruncateAt, String paramString2, int paramInt2)
  {
    if ((paramTextView == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    int i = paramInt1 - paramInt2;
    float f1 = paramTextView.getPaint().measureText(paramString1);
    if (i >= f1)
    {
      paramTextView.setText(paramString1);
      return;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.END)
    {
      CharSequence localCharSequence = TextUtils.ellipsize(paramString1, paramTextView.getPaint(), i, paramTruncateAt);
      f1 = paramTextView.getPaint().measureText((String)localCharSequence);
      f2 = paramTextView.getPaint().measureText("的");
      paramString2 = localCharSequence;
      if (i - f1 > f2 / 2.0F)
      {
        paramString2 = localCharSequence;
        if (paramInt2 != 0)
        {
          paramInt2 = (int)(i + f2);
          paramTextView.setMaxWidth((int)(paramInt1 + f2));
          paramString2 = TextUtils.ellipsize(paramString1, paramTextView.getPaint(), paramInt2, paramTruncateAt);
        }
      }
      paramTextView.setText(paramString2);
      return;
    }
    if ((paramTruncateAt != TextUtils.TruncateAt.MIDDLE) || (TextUtils.isEmpty(paramString2)))
    {
      paramTextView.setEllipsize(paramTruncateAt);
      return;
    }
    paramInt1 = paramString1.lastIndexOf(paramString2);
    if (paramInt1 == -1)
    {
      paramTextView.setText(paramString1);
      return;
    }
    paramTruncateAt = paramString1.substring(0, paramInt1);
    paramString2 = "…" + paramString1.substring(paramInt1);
    f1 = paramTextView.getPaint().measureText(paramTruncateAt);
    float f2 = paramTextView.getPaint().measureText(paramString2);
    if (f2 > i)
    {
      paramTextView.setText(paramString1);
      return;
    }
    while (i - f1 < f2)
    {
      paramTruncateAt = paramTruncateAt.substring(0, paramTruncateAt.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramTruncateAt);
    }
    paramTextView.setText(paramTruncateAt + paramString2);
  }
  
  public static String aA(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder().append("**");
    if (paramInt >= paramString.length()) {}
    for (paramString = "-";; paramString = paramString.substring(paramInt)) {
      return paramString;
    }
  }
  
  public static int ao(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return 0;
    }
    int i3 = paramString.length();
    int k = 0;
    int n = 0;
    int i4;
    int i;
    int j;
    int m;
    if (n < i3)
    {
      i4 = paramString.codePointAt(n);
      if (((paramInt & 0x6) > 0) && (i4 == 20) && (n < i3 - 1))
      {
        i = paramString.charAt(n + 1);
        if (afky.jr(i))
        {
          j = 1;
          i = k + 1;
          m = 2;
          k = j;
          j = m;
        }
        for (;;)
        {
          m = i;
          if (k == 0)
          {
            m = i + 1;
            j = 1;
          }
          k = m;
          n = j + n;
          break;
          if ((i >= 255) && (n + 4 < i3))
          {
            j = 4;
            m = 1;
            i = k + 1;
            k = m;
          }
          else
          {
            if (i != 250) {
              break label449;
            }
            m = 1;
            i = k + 1;
            j = 2;
            k = m;
          }
        }
      }
      if ((paramInt & 0x1) != 1) {
        break label449;
      }
      m = aoff.jw(i4);
      if (i4 > 65535)
      {
        if (i3 <= n + 2) {
          break label485;
        }
        j = paramString.codePointAt(n + 2);
        i = 0;
      }
    }
    for (;;)
    {
      label222:
      if (aoff.lM(j)) {}
      for (int i1 = 1;; i1 = 0)
      {
        label257:
        int i2;
        if ((m == -1) || (i1 != 0))
        {
          i1 = aoff.aO(i4, j);
          if (i1 == -1)
          {
            i2 = 1;
            i1 = m;
          }
        }
        for (m = i2;; m = 0)
        {
          if (i1 != -1)
          {
            if (m != 0) {
              if ((i4 > 65535) && (i3 >= n + 2))
              {
                m = 2;
                label299:
                if ((j <= 65535) || (i3 < n + 2)) {
                  break label406;
                }
                j = m + 2;
                label320:
                if (i == 0) {
                  break label444;
                }
                i = j + 1;
              }
            }
            for (;;)
            {
              m = 1;
              j = i;
              i = k + 1;
              k = m;
              break;
              if (i3 <= n + 1) {
                break label485;
              }
              j = paramString.codePointAt(n + 1);
              if ((j != 65039) || (i3 <= n + 2)) {
                break label480;
              }
              j = paramString.codePointAt(n + 2);
              i = 1;
              break label222;
              m = i1;
              break label257;
              m = 1;
              break label299;
              label406:
              j = m + 1;
              break label320;
              if ((i4 > 65535) && (i3 >= n + 2))
              {
                i = 2;
              }
              else
              {
                i = 1;
                continue;
                return k;
                label444:
                i = j;
              }
            }
          }
          label449:
          m = 0;
          i = k;
          j = 0;
          k = m;
          break;
          i1 = m;
        }
      }
      label480:
      i = 0;
      continue;
      label485:
      i = 0;
      j = -1;
    }
  }
  
  public static final Drawable b(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return afky.z(paramInt);
    }
    return afky.A(paramInt);
  }
  
  public static String b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt2 * 4;
    int k;
    int m;
    int j;
    if (paramInt1 + i <= paramString.length())
    {
      k = i + paramInt1;
      m = paramInt1;
      j = 0;
      i = paramInt1;
      label31:
      if (m >= k) {
        break label327;
      }
      i = paramString.codePointAt(m);
      if ((i != 20) || (m + 1 >= k)) {
        break label287;
      }
      if ((paramString.charAt(m + 1) < 'ÿ') || (m + 4 >= k)) {
        break label278;
      }
      i = m + 4;
      label91:
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "subStringLength= ", Integer.valueOf(i), " start=", Integer.valueOf(paramInt1) });
      }
      j += 1;
      if (j < paramInt2) {
        break label300;
      }
    }
    label278:
    label287:
    label300:
    label327:
    for (;;)
    {
      if (j < paramInt2) {
        paramInt2 = paramInt1;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TextUtils", 2, new Object[] { "loopTime= ", Integer.valueOf(j), " start=", Integer.valueOf(paramInt1) });
        }
        String str = paramString.substring(paramInt1, paramInt2);
        paramString = str;
        if (paramBoolean) {
          if (!str.contains("\n"))
          {
            paramString = str;
            if (!str.contains("\r")) {}
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("TextUtils", 2, new Object[] { "cutString=", str });
            }
            paramString = "";
          }
        }
        return paramString;
        k = paramString.length();
        break;
        i = m + 2;
        break label91;
        i = Character.charCount(i) + m;
        break label91;
        m = i;
        break label31;
        paramInt2 = i;
        if (i > paramString.length()) {
          paramInt2 = paramString.length();
        }
      }
    }
  }
  
  public static int eC(String paramString)
  {
    int j;
    if (TextUtils.isEmpty(paramString)) {
      j = -1;
    }
    int i;
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  return j;
                                  i = 0;
                                  if (i >= paramString.length()) {
                                    break label245;
                                  }
                                  k = paramString.charAt(i);
                                  if (k < 8448) {
                                    break;
                                  }
                                  j = i;
                                } while (k <= 10239);
                                if (k < 10548) {
                                  break;
                                }
                                j = i;
                              } while (k <= 10549);
                              if (k < 11013) {
                                break;
                              }
                              j = i;
                            } while (k <= 11015);
                            if (k < 11035) {
                              break;
                            }
                            j = i;
                          } while (k <= 11036);
                          j = i;
                        } while (k == 169);
                        j = i;
                      } while (k == 174);
                      j = i;
                    } while (k == 8252);
                    j = i;
                  } while (k == 8265);
                  j = i;
                } while (k == 11088);
                j = i;
              } while (k == 11093);
              j = i;
            } while (k == 12336);
            j = i;
          } while (k == 12349);
          j = i;
        } while (k == 12951);
        j = i;
      } while (k == 12953);
      if ((k < 55296) || (k > 56319) || (i >= paramString.length() - 1)) {
        break label236;
      }
      k = paramString.charAt(i + 1);
      if (k < 56320) {
        break;
      }
      j = i;
    } while (k <= 57343);
    label236:
    while (k != 8419)
    {
      i += 1;
      break;
    }
    return i;
    label245:
    return -1;
  }
  
  public static final String fw(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= aoff.oo.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(aoff.oo[paramInt]));
  }
  
  public static final String fx(int paramInt)
  {
    return afky.eb(paramInt);
  }
  
  public static String fy(int paramInt)
  {
    return String.valueOf(new char[] { '<', '$', (char)afky.hl(paramInt), '>' });
  }
  
  public static final String fz(int paramInt)
  {
    return afky.ea(paramInt);
  }
  
  public static final void g(EditText paramEditText)
  {
    try
    {
      Editable localEditable = paramEditText.getText();
      int j = paramEditText.getSelectionStart();
      int i = 0;
      if (j > 1) {
        i = TextUtils.getOffsetBefore(paramEditText.getText(), j);
      }
      if (j != i) {
        localEditable.delete(Math.min(j, i), Math.max(j, i));
      }
      return;
    }
    catch (Exception paramEditText)
    {
      paramEditText.printStackTrace();
    }
  }
  
  public static Drawable i(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramResources;
      try
      {
        localObject = paramResources.getDrawable(paramInt);
        paramInt = aqff.c((Drawable)localObject);
        paramResources = (Resources)localObject;
        if (paramInt > 0)
        {
          BaseApplicationImpl.sImageCache.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
          return localObject;
        }
      }
      catch (Exception paramResources) {}
    }
    return null;
  }
  
  public static String iF(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = "";
    }
    int j;
    int i;
    int k;
    do
    {
      return str1;
      j = afku.Db();
      i = 0;
      while (i < j)
      {
        k = paramString.indexOf(afku.hi(i), 0);
        str1 = paramString;
        if (k != -1)
        {
          str1 = paramString;
          if (k + 2 <= paramString.length()) {
            str1 = paramString.replace(paramString.substring(k, k + 2), afku.dZ(i));
          }
        }
        i += 1;
        paramString = str1;
      }
      str1 = paramString;
    } while (!Z(paramString));
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      str1 = null;
      try
      {
        paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        if (paramString != null)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label526;
              }
              paramString = (ajdg)paramString.getManager(14);
              i = 0;
              str1 = paramString;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              i = 0;
              continue;
              j = i;
              if (k != 255) {
                continue;
              }
              if (i + 4 < localStringBuilder.length()) {
                continue;
              }
              paramString = aofk.ckA;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              continue;
              paramString = new char[4];
              paramString[0] = localStringBuilder.charAt(i + 4);
              paramString[1] = localStringBuilder.charAt(i + 3);
              paramString[2] = localStringBuilder.charAt(i + 2);
              paramString[3] = localStringBuilder.charAt(i + 1);
              j = 0;
              if (j >= 3) {
                continue;
              }
              if (paramString[j] != 'ú') {
                continue;
              }
              paramString[j] = 10;
              j += 1;
              continue;
              if (paramString[j] != 'þ') {
                continue;
              }
              paramString[j] = 13;
              continue;
              paramString = afgc.a(paramString);
              if (paramString == null) {
                break label519;
              }
            }
            if (i >= localStringBuilder.length()) {
              break label507;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if (!afky.jr(k)) {
                  continue;
                }
                paramString = afky.ea(k);
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
          }
          i = 0;
        }
      }
      catch (AccountNotMatchException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
          continue;
          if (paramString.length == 2)
          {
            k = paramString[0];
            j = paramString[1];
          }
          for (;;)
          {
            if (str1 != null) {}
            for (paramString = str1.bi(Integer.toString(k), Integer.toString(j));; paramString = "")
            {
              String str2 = paramString;
              if (TextUtils.isEmpty(paramString)) {
                str2 = aofk.ckA;
              }
              localStringBuilder.replace(i, i + 5, str2);
              j = i + (str2.length() - 1);
              break;
              label507:
              return localStringBuilder.toString();
            }
            label519:
            j = 0;
            k = 0;
          }
          label526:
          paramString = null;
        }
      }
    }
  }
  
  /* Error */
  public static final Drawable j(Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: new 85	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   7: ldc 213
    //   9: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: iload_1
    //   13: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: astore 7
    //   21: getstatic 217	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   24: ifnull +36 -> 60
    //   27: getstatic 217	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   30: aload 7
    //   32: invokevirtual 223	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 225	android/util/Pair
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +18 -> 60
    //   45: aload 5
    //   47: getfield 229	android/util/Pair:first	Ljava/lang/Object;
    //   50: checkcast 231	android/graphics/drawable/Drawable$ConstantState
    //   53: aload_0
    //   54: invokevirtual 235	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   57: astore_0
    //   58: aload_0
    //   59: areturn
    //   60: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   63: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   66: invokevirtual 528	com/tencent/mobileqq/utils/RandomAccessFileManager:a	(Ljava/lang/String;)Ljava/io/RandomAccessFile;
    //   69: astore 5
    //   71: iload_1
    //   72: sipush 1000
    //   75: isub
    //   76: i2l
    //   77: lstore_3
    //   78: aload 5
    //   80: astore_0
    //   81: aload 5
    //   83: lload_3
    //   84: invokevirtual 534	java/io/RandomAccessFile:seek	(J)V
    //   87: aload 5
    //   89: astore_0
    //   90: invokestatic 540	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   93: iconst_4
    //   94: invokevirtual 544	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   97: astore 6
    //   99: aload 5
    //   101: astore_0
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_0
    //   107: iconst_4
    //   108: invokevirtual 548	java/io/RandomAccessFile:read	([BII)I
    //   111: pop
    //   112: aload 5
    //   114: astore_0
    //   115: aload 6
    //   117: invokestatic 552	aofd:bytesToInt	([B)I
    //   120: istore_2
    //   121: aload 5
    //   123: astore_0
    //   124: invokestatic 540	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   127: aload 6
    //   129: invokevirtual 556	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   132: aload 5
    //   134: astore_0
    //   135: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +456 -> 594
    //   141: aload 5
    //   143: astore_0
    //   144: ldc_w 558
    //   147: iconst_2
    //   148: new 85	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 560
    //   158: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload_2
    //   162: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: goto +423 -> 594
    //   174: aload 5
    //   176: astore_0
    //   177: ldc_w 558
    //   180: iconst_4
    //   181: new 85	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   188: ldc_w 565
    //   191: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: iload_1
    //   195: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   198: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: aload 5
    //   206: ifnull +12 -> 218
    //   209: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   212: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   215: invokevirtual 568	com/tencent/mobileqq/utils/RandomAccessFileManager:UU	(Ljava/lang/String;)V
    //   218: aconst_null
    //   219: areturn
    //   220: aload 5
    //   222: astore_0
    //   223: invokestatic 540	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   226: sipush 4096
    //   229: invokevirtual 544	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   232: astore 6
    //   234: aload 5
    //   236: astore_0
    //   237: aload 6
    //   239: iconst_0
    //   240: aload 5
    //   242: aload 6
    //   244: iconst_0
    //   245: iload_2
    //   246: invokevirtual 548	java/io/RandomAccessFile:read	([BII)I
    //   249: invokestatic 574	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   252: astore 6
    //   254: aload 5
    //   256: astore_0
    //   257: aload 6
    //   259: invokestatic 580	aqft:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   262: istore_2
    //   263: aload 5
    //   265: astore_0
    //   266: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +33 -> 302
    //   272: aload 5
    //   274: astore_0
    //   275: ldc_w 558
    //   278: iconst_2
    //   279: new 85	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 582
    //   289: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: iload_2
    //   293: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   296: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: iload_2
    //   303: ifle +154 -> 457
    //   306: aload 5
    //   308: astore_0
    //   309: new 584	android/graphics/drawable/BitmapDrawable
    //   312: dup
    //   313: aload 6
    //   315: invokespecial 587	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   318: astore 6
    //   320: aload 5
    //   322: astore_0
    //   323: getstatic 217	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   326: ifnull +70 -> 396
    //   329: aload 5
    //   331: astore_0
    //   332: getstatic 217	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   335: aload 7
    //   337: new 225	android/util/Pair
    //   340: dup
    //   341: aload 6
    //   343: invokevirtual 487	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   346: iload_2
    //   347: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   350: invokespecial 490	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   353: invokevirtual 494	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   356: pop
    //   357: aload 5
    //   359: astore_0
    //   360: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +33 -> 396
    //   366: aload 5
    //   368: astore_0
    //   369: ldc_w 558
    //   372: iconst_2
    //   373: new 85	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 589
    //   383: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload_1
    //   387: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: aload 5
    //   398: astore_0
    //   399: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   402: ifeq +35 -> 437
    //   405: aload 5
    //   407: astore_0
    //   408: ldc_w 558
    //   411: iconst_2
    //   412: invokestatic 594	wja:b	()Ljava/lang/StringBuilder;
    //   415: ldc_w 596
    //   418: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iload_1
    //   422: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: ldc_w 598
    //   428: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 6
    //   439: astore_0
    //   440: aload 5
    //   442: ifnull -384 -> 58
    //   445: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   448: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   451: invokevirtual 568	com/tencent/mobileqq/utils/RandomAccessFileManager:UU	(Ljava/lang/String;)V
    //   454: aload 6
    //   456: areturn
    //   457: aload 5
    //   459: ifnull +12 -> 471
    //   462: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   465: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   468: invokevirtual 568	com/tencent/mobileqq/utils/RandomAccessFileManager:UU	(Ljava/lang/String;)V
    //   471: aconst_null
    //   472: areturn
    //   473: astore 6
    //   475: aconst_null
    //   476: astore 5
    //   478: aload 5
    //   480: astore_0
    //   481: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +18 -> 502
    //   487: aload 5
    //   489: astore_0
    //   490: ldc_w 558
    //   493: iconst_2
    //   494: ldc_w 600
    //   497: aload 6
    //   499: invokestatic 603	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   502: aload 5
    //   504: ifnonnull +9 -> 513
    //   507: aload 5
    //   509: astore_0
    //   510: invokestatic 606	aoff:dUu	()V
    //   513: aload 5
    //   515: ifnull +12 -> 527
    //   518: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   521: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   524: invokevirtual 568	com/tencent/mobileqq/utils/RandomAccessFileManager:UU	(Ljava/lang/String;)V
    //   527: invokestatic 385	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +32 -> 562
    //   533: ldc_w 558
    //   536: iconst_2
    //   537: invokestatic 594	wja:b	()Ljava/lang/StringBuilder;
    //   540: ldc_w 596
    //   543: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload_1
    //   547: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   550: ldc_w 608
    //   553: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 563	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aconst_null
    //   563: areturn
    //   564: astore 5
    //   566: aconst_null
    //   567: astore_0
    //   568: aload_0
    //   569: ifnull +12 -> 581
    //   572: invokestatic 520	com/tencent/mobileqq/utils/RandomAccessFileManager:a	()Lcom/tencent/mobileqq/utils/RandomAccessFileManager;
    //   575: getstatic 525	aofd:ckz	Ljava/lang/String;
    //   578: invokevirtual 568	com/tencent/mobileqq/utils/RandomAccessFileManager:UU	(Ljava/lang/String;)V
    //   581: aload 5
    //   583: athrow
    //   584: astore 5
    //   586: goto -18 -> 568
    //   589: astore 6
    //   591: goto -113 -> 478
    //   594: iload_2
    //   595: iflt -421 -> 174
    //   598: iload_2
    //   599: sipush 4096
    //   602: if_icmple -382 -> 220
    //   605: goto -431 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramResources	Resources
    //   0	608	1	paramInt	int
    //   120	483	2	i	int
    //   77	7	3	l	long
    //   38	476	5	localObject1	Object
    //   564	18	5	localObject2	Object
    //   584	1	5	localObject3	Object
    //   97	358	6	localObject4	Object
    //   473	25	6	localThrowable1	Throwable
    //   589	1	6	localThrowable2	Throwable
    //   19	317	7	str	String
    // Exception table:
    //   from	to	target	type
    //   60	71	473	java/lang/Throwable
    //   60	71	564	finally
    //   81	87	584	finally
    //   90	99	584	finally
    //   102	112	584	finally
    //   115	121	584	finally
    //   124	132	584	finally
    //   135	141	584	finally
    //   144	171	584	finally
    //   177	204	584	finally
    //   223	234	584	finally
    //   237	254	584	finally
    //   257	263	584	finally
    //   266	272	584	finally
    //   275	302	584	finally
    //   309	320	584	finally
    //   323	329	584	finally
    //   332	357	584	finally
    //   360	366	584	finally
    //   369	396	584	finally
    //   399	405	584	finally
    //   408	437	584	finally
    //   481	487	584	finally
    //   490	502	584	finally
    //   510	513	584	finally
    //   81	87	589	java/lang/Throwable
    //   90	99	589	java/lang/Throwable
    //   102	112	589	java/lang/Throwable
    //   115	121	589	java/lang/Throwable
    //   124	132	589	java/lang/Throwable
    //   135	141	589	java/lang/Throwable
    //   144	171	589	java/lang/Throwable
    //   177	204	589	java/lang/Throwable
    //   223	234	589	java/lang/Throwable
    //   237	254	589	java/lang/Throwable
    //   257	263	589	java/lang/Throwable
    //   266	272	589	java/lang/Throwable
    //   275	302	589	java/lang/Throwable
    //   309	320	589	java/lang/Throwable
    //   323	329	589	java/lang/Throwable
    //   332	357	589	java/lang/Throwable
    //   360	366	589	java/lang/Throwable
    //   369	396	589	java/lang/Throwable
    //   399	405	589	java/lang/Throwable
    //   408	437	589	java/lang/Throwable
  }
  
  public static String j(String paramString, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = paramInt2 * 4;
    SparseArray localSparseArray;
    int j;
    label27:
    int m;
    if (paramInt1 - i <= 0)
    {
      i = 0;
      localSparseArray = new SparseArray();
      j = 0;
      if (i >= paramInt1) {
        break label164;
      }
      localSparseArray.put(j, Integer.valueOf(i));
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore subStringLength= ", Integer.valueOf(i), " end:", Integer.valueOf(paramInt1) });
      }
      m = paramString.codePointAt(i);
      if ((m != 20) || (i + 1 >= paramInt1)) {
        break label153;
      }
      if ((paramString.charAt(i + 1) < 'ÿ') || (i + 4 >= paramInt1)) {
        break label146;
      }
      i += 4;
    }
    for (;;)
    {
      j += 1;
      break label27;
      i = paramInt1 - i;
      break;
      label146:
      i += 2;
      continue;
      label153:
      i += Character.charCount(m);
    }
    label164:
    if (localSparseArray.size() - paramInt2 >= 0)
    {
      j = ((Integer)localSparseArray.get(localSparseArray.size() - paramInt2)).intValue();
      i = j;
      if (QLog.isColorLevel()) {
        QLog.d("TextUtils", 2, new Object[] { "getNeoTextBefore from Array subStringLength= ", Integer.valueOf(j), " loopTime - maxContentLength:", Integer.valueOf(localSparseArray.size() - paramInt2) });
      }
    }
    for (i = j;; i = paramInt1)
    {
      if (i < 0) {}
      for (paramInt2 = k;; paramInt2 = i) {
        return paramString.substring(paramInt2, paramInt1);
      }
    }
  }
  
  public static boolean jq(int paramInt)
  {
    return afky.jq(paramInt);
  }
  
  public static String oe(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    paramString = BaseApplicationImpl.getContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
      String str1 = null;
      try
      {
        paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
        if (paramString != null)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label432;
              }
              paramString = (ajdg)paramString.getManager(14);
              i = 0;
              str1 = paramString;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
              i = 0;
              continue;
              j = i;
              if (k != 255) {
                continue;
              }
              if (i + 4 < localStringBuilder.length()) {
                continue;
              }
              paramString = aofk.ckA;
              localStringBuilder.replace(i, localStringBuilder.length(), paramString);
              i += paramString.length() - 1;
              continue;
              paramString = new char[4];
              paramString[0] = localStringBuilder.charAt(i + 4);
              paramString[1] = localStringBuilder.charAt(i + 3);
              paramString[2] = localStringBuilder.charAt(i + 2);
              paramString[3] = localStringBuilder.charAt(i + 1);
              j = 0;
              if (j >= 3) {
                continue;
              }
              if (paramString[j] != 'ú') {
                continue;
              }
              paramString[j] = 10;
              j += 1;
              continue;
              if (paramString[j] != 'þ') {
                continue;
              }
              paramString[j] = 13;
              continue;
              paramString = afgc.a(paramString);
              if (paramString == null) {
                break label425;
              }
            }
            if (i >= localStringBuilder.length()) {
              break label413;
            }
            j = i;
            if (localStringBuilder.codePointAt(i) == 20)
            {
              j = i;
              if (i < localStringBuilder.length() - 1)
              {
                k = localStringBuilder.charAt(i + 1);
                if (!afky.jr(k)) {
                  continue;
                }
                paramString = afky.ea(k);
                localStringBuilder.replace(i, i + 2, paramString);
                j = i + (paramString.length() - 1);
              }
            }
            i = j + 1;
          }
          i = 0;
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          int j;
          int k;
          paramString.printStackTrace();
          paramString = null;
          continue;
          if (paramString.length == 2)
          {
            k = paramString[0];
            j = paramString[1];
          }
          for (;;)
          {
            if (str1 != null) {}
            for (paramString = str1.bi(Integer.toString(k), Integer.toString(j));; paramString = "")
            {
              String str2 = paramString;
              if (TextUtils.isEmpty(paramString)) {
                str2 = aofk.ckA;
              }
              localStringBuilder.replace(i, i + 5, str2);
              j = i + (str2.length() - 1);
              break;
              label413:
              return localStringBuilder.toString();
            }
            label425:
            j = 0;
            k = 0;
          }
          label432:
          paramString = null;
        }
      }
    }
  }
  
  public static String of(String paramString)
  {
    int i = eC(paramString);
    if (i != -1)
    {
      if (i + 2 > paramString.length()) {}
      for (int j = paramString.length();; j = i + 2)
      {
        paramString = paramString.replace(paramString.substring(i, j), "");
        i = eC(paramString);
        break;
      }
    }
    return paramString;
  }
  
  public static String og(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = "";
      return localObject;
    }
    int i = 0;
    int k;
    while (i < dOw)
    {
      k = paramString.indexOf(aoff.oo[i], 0);
      localObject = paramString;
      if (k != -1)
      {
        if (k >= paramString.length()) {
          localObject = paramString;
        }
      }
      else
      {
        label53:
        i += 1;
        paramString = (String)localObject;
        continue;
      }
      if (paramString.codePointAt(k) <= 65535) {
        break label651;
      }
    }
    label648:
    label651:
    for (int j = 2;; j = 1)
    {
      localObject = paramString;
      if (k == -1) {
        break label53;
      }
      localObject = paramString;
      if (k + j > paramString.length()) {
        break label53;
      }
      localObject = aoff.fv(i);
      localObject = paramString.replace(paramString.substring(k, j + k), (CharSequence)localObject);
      break label53;
      localObject = paramString;
      if (!Z(paramString)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      paramString = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      }
      for (;;)
      {
        paramString = paramString.getSharedPreferences("Last_Login", i).getString("uin", "");
        try
        {
          paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
          if (paramString == null) {}
        }
        catch (AccountNotMatchException paramString)
        {
          for (;;)
          {
            try
            {
              if ((paramString instanceof NearbyAppInterface)) {
                break label375;
              }
              paramString = (ajdg)paramString.getManager(14);
              k = 0;
              i = 0;
              if (i >= localStringBuilder.length()) {
                break label629;
              }
              if ((localStringBuilder.codePointAt(i) != 20) || (i >= localStringBuilder.length() - 1)) {
                break label624;
              }
              j = localStringBuilder.charAt(i + 1);
              m = j;
              if (j == 250) {
                m = 10;
              }
              if (!afky.jr(m)) {
                break label380;
              }
              localObject = afky.ea(m);
              if (k != 0) {
                break label648;
              }
              localObject = acfp.m(2131715278) + (String)localObject;
              localStringBuilder.replace(i, i + 2, (String)localObject);
              j = i + (((String)localObject).length() - 1);
              k = 1;
              i = j;
              j = k;
              i += 1;
              k = j;
              continue;
              i = 0;
            }
            catch (Throwable paramString)
            {
              paramString.printStackTrace();
            }
            paramString = paramString;
            paramString.printStackTrace();
            paramString = null;
          }
        }
        catch (ClassCastException paramString)
        {
          for (;;)
          {
            int m;
            label336:
            paramString.printStackTrace();
            paramString = null;
            continue;
            label375:
            paramString = null;
            continue;
            label380:
            j = i;
            if (m == 255) {
              if (i + 4 >= localStringBuilder.length())
              {
                localObject = aofk.ckA;
                localStringBuilder.replace(i, localStringBuilder.length(), (String)localObject);
                i += ((String)localObject).length() - 1;
              }
              else
              {
                localObject = new char[4];
                localObject[0] = localStringBuilder.charAt(i + 4);
                localObject[1] = localStringBuilder.charAt(i + 3);
                localObject[2] = localStringBuilder.charAt(i + 2);
                localObject[3] = localStringBuilder.charAt(i + 1);
                j = 0;
                if (j < 3)
                {
                  if (localObject[j] == 'ú') {
                    localObject[j] = 10;
                  }
                  for (;;)
                  {
                    j += 1;
                    break;
                    if (localObject[j] == 'þ') {
                      localObject[j] = 13;
                    }
                  }
                }
                localObject = afgc.a((char[])localObject);
                String str = aofk.ckA;
                if ((localObject != null) && (localObject.length == 2))
                {
                  k = localObject[0];
                  j = localObject[1];
                }
                for (;;)
                {
                  if (paramString != null) {}
                  for (localObject = paramString.a(Integer.toString(k), Integer.toString(j));; localObject = null)
                  {
                    if (localObject != null) {
                      str = ((Emoticon)localObject).character;
                    }
                    localStringBuilder.replace(i, i + 5, str);
                    j = i + (str.length() - 1);
                    break;
                    label624:
                    j = 0;
                    break label336;
                    label629:
                    return localStringBuilder.toString();
                  }
                  j = 0;
                  k = 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static String oh(String paramString)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramString)) {
      localObject2 = null;
    }
    Object localObject1;
    int k;
    int i;
    do
    {
      return localObject2;
      localObject1 = "";
      k = paramString.length();
      i = 0;
      localObject2 = localObject1;
    } while (i >= k);
    int j;
    if (paramString.codePointAt(i) == 20)
    {
      j = i;
      localObject2 = localObject1;
      if (i < k - 1)
      {
        if (paramString.charAt(i + 1) >= 'ÿ') {
          break label88;
        }
        j = i + 1;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i = j + 1;
      localObject1 = localObject2;
      break;
      label88:
      j = i + 4;
      localObject2 = localObject1;
      continue;
      localObject2 = (String)localObject1 + paramString.charAt(i);
      j = i;
    }
  }
  
  public static String oi(String paramString)
  {
    Object localObject1;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = null;
    }
    Object localObject2;
    int k;
    int i;
    do
    {
      return localObject1;
      localObject2 = "";
      k = paramString.length();
      i = 0;
      localObject1 = localObject2;
    } while (i >= k);
    int j;
    if (paramString.codePointAt(i) == 20)
    {
      j = i;
      localObject1 = localObject2;
      if (i < k - 1)
      {
        if (paramString.charAt(i + 1) >= 'ÿ') {
          break label107;
        }
        localObject1 = (String)localObject2 + "  ";
        j = i + 1;
      }
    }
    for (;;)
    {
      i = j + 1;
      localObject2 = localObject1;
      break;
      label107:
      localObject1 = (String)localObject2 + "     ";
      j = i + 4;
      continue;
      localObject1 = (String)localObject2 + paramString.charAt(i);
      j = i;
    }
  }
  
  public static String oj(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 5)) {
      return paramString;
    }
    int i = 0;
    int j = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < j)
    {
      char c = paramString.charAt(i);
      if ((c == '<') && (i < j - 2))
      {
        int k = paramString.charAt(i + 1);
        if (((k == 36) || (k == 37) || (k == 38)) && (i < j - 5))
        {
          k = paramString.indexOf('>', i);
          if (k != -1)
          {
            i = i + k + 1;
            continue;
          }
        }
      }
      localStringBuilder.append(c);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String ok(String paramString)
  {
    int i = 0;
    String[] arrayOfString = new String[40];
    arrayOfString[0] = "！";
    arrayOfString[1] = "，";
    arrayOfString[2] = "。";
    arrayOfString[3] = "；";
    arrayOfString[4] = "~";
    arrayOfString[5] = "《";
    arrayOfString[6] = "》";
    arrayOfString[7] = "（";
    arrayOfString[8] = "）";
    arrayOfString[9] = "？";
    arrayOfString[10] = "”";
    arrayOfString[11] = "｛";
    arrayOfString[12] = "｝";
    arrayOfString[13] = "“";
    arrayOfString[14] = "：";
    arrayOfString[15] = "【";
    arrayOfString[16] = "】";
    arrayOfString[17] = "”";
    arrayOfString[18] = "‘";
    arrayOfString[19] = "’";
    arrayOfString[20] = "!";
    arrayOfString[21] = ",";
    arrayOfString[22] = ".";
    arrayOfString[23] = ";";
    arrayOfString[24] = "`";
    arrayOfString[25] = "<";
    arrayOfString[26] = ">";
    arrayOfString[27] = "(";
    arrayOfString[28] = ")";
    arrayOfString[29] = "?";
    arrayOfString[30] = "'";
    arrayOfString[31] = "{";
    arrayOfString[32] = "}";
    arrayOfString[33] = "\"";
    arrayOfString[34] = ":";
    arrayOfString[35] = "{";
    arrayOfString[36] = "}";
    arrayOfString[37] = "\"";
    arrayOfString[38] = "'";
    arrayOfString[39] = "'";
    while (i < arrayOfString.length / 2)
    {
      paramString = paramString.replaceAll(arrayOfString[i], arrayOfString[(arrayOfString.length / 2 + i)]);
      i += 1;
    }
    return paramString;
  }
  
  public static boolean pV(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString.charAt(i);
        if (((k >= 1536) && (k <= 1791)) || ((k >= 1872) && (k <= 1919)) || ((k >= 64336) && (k <= 65023)) || ((k >= 65136) && (k <= 65279))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean pW(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = 0;
    label11:
    if (i < paramString.length())
    {
      int j = paramString.codePointAt(i);
      if (20 == j) {
        i += 1;
      }
      for (;;)
      {
        i += 1;
        break label11;
        if (32 != j) {
          break;
        }
      }
    }
    return true;
  }
  
  public static final Drawable x(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130839942;
    if (paramInt >= 1000) {
      return j(BaseApplicationImpl.getContext().getResources(), paramInt);
    }
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < aoff.dOq) {
        i = 2130839808 + paramInt;
      }
    }
    if (BaseApplicationImpl.sImageCache != null) {
      return i(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static String x(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    int k;
    int m;
    do
    {
      return paramString;
      int n = 0;
      k = 0;
      int j = paramString.length();
      int i = j;
      if (paramBoolean)
      {
        i = k;
        for (;;)
        {
          k = j;
          m = i;
          if (i >= j) {
            break;
          }
          k = j;
          m = i;
          if (paramString.charAt(i) != '\n') {
            break;
          }
          i += 1;
        }
      }
      for (;;)
      {
        k = i;
        m = n;
        if (i >= 0) {
          break;
        }
        k = i;
        m = n;
        if (paramString.charAt(i - 1) != '\n') {
          break;
        }
        i -= 1;
      }
    } while ((m <= 0) && (k >= paramString.length()));
    return paramString.substring(m, k);
  }
  
  public static abstract interface a
  {
    public abstract void v(Drawable paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofy
 * JD-Core Version:    0.7.0.1
 */