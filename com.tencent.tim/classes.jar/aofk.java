import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract.Contacts;
import android.text.GetChars;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JobQueue;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText.SmallEmojiSpan.1;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class aofk
  implements GetChars, Spannable, CharSequence, Cloneable
{
  static final Object[] EMPTY;
  public static Spannable.Factory a;
  public static final boolean cLs;
  public static final boolean cLt;
  public static String ckA = acfp.m(2131712543);
  private static String ckB;
  private static String mTag;
  private MessageRecord G;
  private amks b;
  private String caG;
  private int dOo = 32;
  public int mFlags;
  public String mSource;
  public int mSpanCount;
  public Object[] mSpans;
  protected String mText;
  private int mUinType = -1;
  private int[] os;
  
  static
  {
    EMPTY = new Object[0];
    a = new aofl();
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
      bool = true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        cLt = false;
      }
    }
    if ((Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 14))
    {
      cLt = true;
      cLs = bool;
      return;
    }
  }
  
  public aofk(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public aofk(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  public aofk(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected aofk(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.dOo = paramInt4;
    long l = SystemClock.uptimeMillis();
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject1 != null) {
      ckB = ((AppRuntime)localObject1).getAccount();
    }
    if (ckB == null) {
      localObject1 = "";
    }
    for (;;)
    {
      ckB = (String)localObject1;
      this.mUinType = paramInt5;
      paramInt5 = idealIntArraySize(3);
      try
      {
        this.mSpans = new Object[paramInt5];
        this.os = new int[paramInt5 * 3];
        paramInt4 = (int)(paramInt4 * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
        if (paramCharSequence == null)
        {
          this.mText = "";
          this.mSource = "";
          return;
          localObject1 = ckB;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
        this.mSource = paramCharSequence.toString();
        this.mText = this.mSource;
        this.mFlags = paramInt3;
        if ((paramInt3 & 0x1) == 1) {
          break label190;
        }
      }
    }
    label190:
    Object localObject2;
    if ((paramInt3 & 0x6) > 0)
    {
      localObject2 = new StringBuilder(this.mSource);
      paramInt4 = a(0, ((StringBuilder)localObject2).length(), paramInt3, paramInt4, (StringBuilder)localObject2);
      this.mText = ((StringBuilder)localObject2).toString();
      if (!cLs) {
        this.mSource = this.mText;
      }
      if (paramInt4 < afky.Df()) {}
    }
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      Object localObject3;
      if (paramInt4 != 0)
      {
        localObject2 = (aofk.a[])getSpans(paramInt1, paramInt2, aofk.a.class);
        if (localObject2 != null)
        {
          paramInt5 = localObject2.length;
          paramInt4 = 0;
          if (paramInt4 < paramInt5)
          {
            localObject3 = localObject2[paramInt4];
            if (((aofk.a)localObject3).emojiType == 1) {
              ((aofk.a)localObject3).index &= 0x7FFFFFFF;
            }
            for (;;)
            {
              paramInt4 += 1;
              break;
              if (((aofk.a)localObject3).emojiType == 2) {
                ((aofk.c)localObject3).cLv = false;
              }
            }
          }
        }
      }
      if (((paramInt3 & 0x8) == 8) && (this.mText != null)) {
        if ((ckB.length() > 3) && (ckB.charAt(ckB.length() - 3) == '0') && (ckB.charAt(ckB.length() - 2) == '1'))
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("length", this.mText.length() + "");
          localObject3 = anpc.a(BaseApplication.getContext());
          if (this.mText.length() >= 1000) {
            break label649;
          }
        }
      }
      label649:
      for (boolean bool = true;; bool = false)
      {
        ((anpc)localObject3).collectPerformance(null, "qq_url_length_report", bool, 0L, 0L, (HashMap)localObject2, null);
        if (this.mText.length() < 1000) {
          ayY();
        }
        if (!(paramCharSequence instanceof Spanned)) {
          break;
        }
        localObject2 = (Spanned)paramCharSequence;
        localObject3 = ((Spanned)localObject2).getSpans(paramInt1, paramInt2, Object.class);
        paramInt3 = 0;
        while (paramInt3 < localObject3.length)
        {
          paramInt5 = ((Spanned)localObject2).getSpanStart(localObject3[paramInt3]);
          int i = ((Spanned)localObject2).getSpanEnd(localObject3[paramInt3]);
          int j = ((Spanned)localObject2).getSpanFlags(localObject3[paramInt3]);
          paramInt4 = paramInt5;
          if (paramInt5 < paramInt1) {
            paramInt4 = paramInt1;
          }
          paramInt5 = i;
          if (i > paramInt2) {
            paramInt5 = paramInt2;
          }
          setSpan(localObject3[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, j);
          paramInt3 += 1;
        }
      }
      if (SystemClock.uptimeMillis() - l <= 400L) {
        break;
      }
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("time", SystemClock.uptimeMillis() - l + "");
      if (QLog.isColorLevel()) {
        QLog.i("QQText", 2, SystemClock.uptimeMillis() - l + ", " + paramCharSequence.length() + ", " + this.mSpanCount);
      }
      ((HashMap)localObject2).put("length", paramCharSequence.length() + "");
      ((HashMap)localObject2).put("emoji", this.mSpanCount + "");
      anpc.a(BaseApplication.getContext()).collectPerformance(null, "qqTextData", false, 0L, 0L, (HashMap)localObject2, null);
      return;
    }
  }
  
  public aofk(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
    this.G = paramMessageRecord;
  }
  
  private static String S(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder)
  {
    int i5 = paramStringBuilder.length();
    int j = 0;
    int i = 0;
    float f = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int i2 = (int)(22.0F * f + 0.5F);
    int i6 = (int)(f * 32.0F + 0.5F);
    int k = paramInt1;
    paramInt1 = i;
    int i7;
    boolean bool1;
    label82:
    int m;
    if (k < paramInt2)
    {
      i7 = paramStringBuilder.codePointAt(k);
      if ((paramInt3 & 0x4) == 4)
      {
        bool1 = true;
        if (((paramInt3 & 0x6) <= 0) || (i7 != 20) || (k >= i5 - 1)) {
          break label620;
        }
        m = paramStringBuilder.charAt(k + 1);
        if (!afky.jr(m)) {
          break label252;
        }
        if (!cLs) {
          break label230;
        }
        paramStringBuilder.replace(k, k + 2, "##");
        label145:
        i = m;
        if (bool1) {
          i = m | 0x80000000;
        }
        b(new aofk.a(i, paramInt4, 1), k, k + 2, 33);
        i = k + 1;
        k = j + 1;
        paramInt1 += 1;
        j = i;
        i = k;
        label210:
        if (i <= 512) {
          break label1104;
        }
      }
    }
    label424:
    label473:
    label1117:
    for (;;)
    {
      if (paramInt1 > 0) {}
      return paramInt1;
      bool1 = false;
      break label82;
      label230:
      if (m != 10) {
        break label145;
      }
      paramStringBuilder.setCharAt(k + 1, 'ú');
      break label145;
      label252:
      if ((m >= 255) && (k + 4 < i5))
      {
        char[] arrayOfChar = new char[4];
        arrayOfChar[0] = paramStringBuilder.charAt(k + 4);
        arrayOfChar[1] = paramStringBuilder.charAt(k + 3);
        arrayOfChar[2] = paramStringBuilder.charAt(k + 2);
        arrayOfChar[3] = paramStringBuilder.charAt(k + 1);
        i = 0;
        if (i < 3)
        {
          if (arrayOfChar[i] == 'ú') {
            arrayOfChar[i] = '\n';
          }
          for (;;)
          {
            i += 1;
            break;
            if (arrayOfChar[i] == 'þ') {
              arrayOfChar[i] = '\r';
            }
          }
        }
        boolean bool2;
        if (m == 511)
        {
          bool2 = true;
          b(new aofk.c(arrayOfChar, paramInt4, bool1, bool2), k, k + 5, 33);
          i = 2;
          if (i >= 5) {
            break label504;
          }
          if (paramStringBuilder.charAt(k + i) != '\n') {
            break label473;
          }
          paramStringBuilder.setCharAt(k + i, 'ú');
        }
        for (;;)
        {
          i += 1;
          break label424;
          bool2 = false;
          break;
          if (paramStringBuilder.charAt(k + i) == '\r') {
            paramStringBuilder.setCharAt(k + i, 'þ');
          }
        }
        k += 4;
        i = j + 1;
        paramInt1 += 1;
        j = k;
        break label210;
      }
      label504:
      int i3;
      label620:
      int n;
      if (m == 250)
      {
        if (cLs) {
          paramStringBuilder.replace(k, k + 2, "##");
        }
        if (bool1) {}
        for (i = -2147483638;; i = 10)
        {
          b(new aofk.a(i, paramInt4, 1), k, k + 2, 33);
          k += 1;
          i = j + 1;
          paramInt1 += 1;
          j = k;
          break;
        }
        if ((paramInt3 & 0x1) == 1)
        {
          m = aoff.jw(i7);
          i = -1;
          i1 = 0;
          i3 = 0;
          if (i7 > 65535)
          {
            n = i3;
            if (i5 > k + 2)
            {
              i = paramStringBuilder.codePointAt(k + 2);
              n = i3;
            }
            if (aoff.lM(i)) {
              i1 = 1;
            }
            if ((m != -1) && (i1 == 0)) {
              break label1131;
            }
            i1 = aoff.aO(i7, i);
            if (i1 != -1) {
              break label960;
            }
          }
        }
      }
      label994:
      label1131:
      for (int i1 = 1;; i1 = 0)
      {
        if (m != -1)
        {
          if (i1 != 0) {
            if ((i7 > 65535) && (i5 >= k + 2))
            {
              if (cLs) {
                paramStringBuilder.replace(k, k + 2, "##");
              }
              i1 = 2;
              if ((i <= 65535) || (i5 < k + 2)) {
                break label994;
              }
              if (cLs) {
                paramStringBuilder.replace(k + 2, k + 4, "##");
              }
              i = i1 + 2;
              if (n == 0) {
                break label1117;
              }
              i += 1;
            }
          }
          for (;;)
          {
            if (paramInt4 == i6) {}
            for (n = i2;; n = paramInt4)
            {
              b(new aofk.a(m, n, 0), k, k + i, 33);
              k += i - 1;
              i = j + 1;
              j = k;
              break;
              n = i3;
              if (i5 <= k + 1) {
                break label679;
              }
              int i4 = paramStringBuilder.codePointAt(k + 1);
              n = i3;
              i = i4;
              if (i4 != 65039) {
                break label679;
              }
              n = i3;
              i = i4;
              if (i5 <= k + 2) {
                break label679;
              }
              i = paramStringBuilder.codePointAt(k + 2);
              n = 1;
              break label679;
              m = i1;
              break label716;
              if (cLs) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i1 = 1;
              break label771;
              if (cLs) {
                paramStringBuilder.replace(k + 2, k + 3, "#");
              }
              i = i1 + 1;
              break label817;
              if ((i7 > 65535) && (i5 >= k + 2))
              {
                if (cLs) {
                  paramStringBuilder.replace(k, k + 2, "##");
                }
                i = 2;
                break label828;
              }
              if (cLs) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i = 1;
              break label828;
            }
            k = j + 1;
            j = i;
            break;
          }
        }
        i = j;
        j = k;
        break label210;
      }
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  private void aH(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " has end before start");
    }
    int i = length();
    if ((paramInt1 > i) || (paramInt2 > i)) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " ends beyond length " + i);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + S(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  public static final boolean azx()
  {
    StackTraceElement localStackTraceElement = new Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  public static void b(Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    ausj localausj = ausj.b(paramContext);
    if (paramInt == 0)
    {
      localausj.setMainTitle(String.format(paramContext.getString(2131696502), new Object[] { paramString1 }));
      localausj.addButton(2131692643, 1);
      localausj.addButton(2131692330, 1);
      localausj.addButton(2131689837, 1);
      localausj.addButton(2131689787, 1);
      localausj.addButton(2131695152, 1);
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new aofm(paramInt, paramString1, paramContext, paramString2, localausj));
      localausj.show();
      return;
      if (paramInt == 1)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString1 }));
        localausj.addButton(2131692643, 1);
        localausj.addButton(2131692330, 1);
        localausj.addButton(2131689837, 1);
      }
      else if (paramInt == 2)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131695604), new Object[] { paramString1 }));
        localausj.addButton(2131719492, 1);
        localausj.addButton(2131692330, 1);
      }
      else if (paramInt == 3)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString1 }));
        localausj.addButton(2131692643, 1);
        localausj.addButton(2131692330, 1);
        localausj.addButton(2131689837, 1);
      }
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  public static void ca(Context paramContext, String paramString)
  {
    ausj localausj = ausj.b(paramContext);
    localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString }));
    localausj.addButton(2131721061, 1);
    localausj.addButton(2131721056, 1);
    localausj.addCancelButton(2131721058);
    localausj.a(new aofq(aurq.a(new aofp(paramContext, paramString, localausj)).a(1000L)));
    localausj.show();
  }
  
  private static void cb(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT");
    localIntent.setType("vnd.android.cursor.item/person");
    localIntent.setType("vnd.android.cursor.item/contact");
    localIntent.setType("vnd.android.cursor.item/raw_contact");
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    hD("0X800A00C", "0X800A00C");
  }
  
  private static void cc(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.putExtra("phone", paramString);
    paramContext.startActivity(localIntent);
    hD("0X800A00B", "0X800A00B");
  }
  
  public static boolean containsEmoji(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        j = paramString.codePointAt(i);
        if (aoff.ah.get(j, -1) < 0) {
          break label43;
        }
      }
      label43:
      for (int j = 1; j != 0; j = 0)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  public static void e(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      b(paramContext, paramString, i, null);
      return;
    }
  }
  
  private static void hD(String paramString1, String paramString2)
  {
    try
    {
      anot.a((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(ckB), "dc00898", "", "", paramString1, paramString2, 0, 0, "", "", "", "");
      return;
    }
    catch (AccountNotMatchException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (ClassCastException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static void hE(String paramString1, String paramString2)
  {
    if (mTag == null) {
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(ckB);
      if (paramString2 != null)
      {
        anot.a(localQQAppInterface1, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, mTag, "" + paramString1, "" + paramString2, "");
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localClassCastException.printStackTrace();
        localQQAppInterface2 = null;
      }
      anot.a(localQQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, mTag, "" + paramString1, "" + paramString1, "");
      return;
    }
    catch (AccountNotMatchException paramString1) {}
  }
  
  private static int idealIntArraySize(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  public static boolean pU(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        if (20 == paramString.codePointAt(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public String AE()
  {
    return v(true);
  }
  
  public String AF()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int j = 0;
    int k = 0;
    if (j < this.mSpanCount)
    {
      Object localObject = this.mSpans[j];
      int i = k;
      int m;
      if ((localObject instanceof aofk.a))
      {
        i = this.os[(j * 3 + 0)];
        m = this.os[(j * 3 + 1)];
        localObject = (aofk.a)localObject;
        switch (((aofk.a)localObject).emojiType)
        {
        default: 
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        localStringBuffer.replace(i + k, m + k, "");
        i = k + (0 - (m - i));
        continue;
        localObject = ((aofk.a)localObject).getDescription();
        localStringBuffer.replace(i + k, m + k, (String)localObject);
        i = k + (((String)localObject).length() - (m - i));
        continue;
        localStringBuffer.replace(i + k, m + k, "");
        i = k + (0 - (m - i));
      }
    }
    return localStringBuffer.toString();
  }
  
  public void RO(String paramString)
  {
    this.caG = paramString;
  }
  
  public aofk a(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    aofk localaofk = new aofk("", 0);
    localaofk.dOo = this.dOo;
    localaofk.mUinType = this.mUinType;
    localaofk.G = this.G;
    localaofk.mSpanCount = this.mSpanCount;
    localaofk.os = new int[this.os.length];
    System.arraycopy(this.os, 0, localaofk.os, 0, this.os.length);
    localaofk.mSpans = new Object[this.mSpans.length];
    System.arraycopy(this.mSpans, 0, localaofk.mSpans, 0, this.mSpans.length);
    int i = 0;
    int j = 0;
    if (paramVarArgs.length >= 2)
    {
      i = paramVarArgs[0];
      j = (int)(paramVarArgs[1] * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder().append(paramString).append(this.mText);
      int m = paramString.length();
      int k = 0;
      while (k < localaofk.mSpans.length)
      {
        this.os[(k * 3 + 0)] += m;
        this.os[(k * 3 + 1)] += m;
        k += 1;
      }
      if (i != 0) {
        localaofk.a(0, paramString.length(), i, j, localStringBuilder);
      }
      localaofk.mSource = (paramString + this.mSource);
      localaofk.mText = localStringBuilder.toString();
      if (paramVarArgs.length >= 3) {
        if (paramVarArgs[2] != 1) {
          break label442;
        }
      }
    }
    label442:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localaofk.mFlags = this.mFlags;
      }
      return localaofk;
      localStringBuilder = new StringBuilder().append(paramString).append(this.mText);
      if (i != 0) {
        localaofk.a(this.mText.length(), this.mText.length() + paramString.length(), i, j, localStringBuilder);
      }
      this.mSource += paramString;
      localaofk.mText = localStringBuilder.toString();
      break;
    }
  }
  
  public void a(Context paramContext, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "msg is null, show old action sheet");
      }
      b(paramContext, paramString, paramInt, this.caG);
      return;
    }
    Object localObject1 = null;
    if ((paramContext instanceof BaseActivity)) {
      localObject1 = ((BaseActivity)paramContext).app;
    }
    if (localObject1 == null) {}
    for (;;)
    {
      try
      {
        Object localObject2 = paramMessageRecord.selfuin;
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject2);
        localObject1 = localObject2;
        if (localObject1 != null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "app is null, show old action sheet");
        }
        b(paramContext, paramString, paramInt, this.caG);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        QLog.e("QQText", 1, localAccountNotMatchException, new Object[0]);
      }
    }
    int i;
    ausj localausj;
    Object localObject3;
    if (paramInt == 2)
    {
      i = 5;
      localausj = ausj.b(paramContext);
      localObject3 = (acff)((QQAppInterface)localObject1).getManager(51);
      if (paramInt != 0) {
        break label367;
      }
      if (aqiw.isNetworkAvailable()) {
        break label328;
      }
      localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString }));
      localausj.addButton(2131692330, 1);
      localausj.addButton(2131693407, 1);
      localausj.addButton(2131692643, 1);
      localausj.addButton(2131689837, 1);
      anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", amks.c((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new aofn(this, paramContext, paramString, (QQAppInterface)localObject1, i, paramMessageRecord, paramInt, localausj));
      localausj.a(new aofo(this, (QQAppInterface)localObject1, i));
      localausj.show();
      return;
      i = 4;
      break;
      label328:
      if (this.b == null) {
        this.b = new amks(this.caG);
      }
      this.b.a((QQAppInterface)localObject1, paramContext, paramString, (ChatMessage)paramMessageRecord);
      return;
      label367:
      if (paramInt == 1)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString }));
        localausj.addButton(2131692330, 1);
        localausj.addButton(2131693407, 1);
        localausj.addButton(2131692643, 1);
        localausj.addButton(2131689837, 1);
        if ((!paramMessageRecord.isSend()) && (((acff)localObject3).isFriend(paramMessageRecord.senderuin)))
        {
          localObject3 = (CardHandler)((QQAppInterface)localObject1).getBusinessHandler(2);
          if (localObject3 != null) {
            ((CardHandler)localObject3).a(ckB, paramMessageRecord.senderuin, 1, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          }
          localausj.addButton(2131689848, 1);
        }
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", amks.c((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
      else if (paramInt == 2)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131695604), new Object[] { paramString }));
        localausj.addButton(2131692330, 1);
        localausj.addButton(2131693407, 1);
        localausj.addButton(2131719492, 1);
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A924", "0X800A924", amks.c((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
      else if (paramInt == 3)
      {
        localausj.setMainTitle(String.format(paramContext.getString(2131696503), new Object[] { paramString }));
        localausj.addButton(2131692330, 1);
        localausj.addButton(2131693407, 1);
        localausj.addButton(2131692643, 1);
        localausj.addButton(2131689837, 1);
        anot.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A923", "0X800A923", amks.c((QQAppInterface)localObject1, paramMessageRecord.istroop, paramMessageRecord.frienduin), 0, "", "", "", "");
      }
    }
  }
  
  protected void a(View paramView, String paramString)
  {
    int i;
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getAppRuntime(ckB);
      if ((localObject1 instanceof QQAppInterface)) {
        wta.a(paramView.getContext(), (QQAppInterface)localObject1, this.G, 5, paramString);
      }
      localObject2 = null;
      i = paramString.lastIndexOf("#");
      if (i > 0) {
        localObject2 = paramString.substring(i);
      }
      String str2 = URLUtil.guessUrl(paramString);
      localObject1 = str2;
      if (localObject2 != null) {
        localObject1 = str2 + (String)localObject2;
      }
      if (aobw.pN((String)localObject1))
      {
        localObject2 = paramView.getContext();
        if (aqiw.isNetSupport(BaseApplication.getContext()))
        {
          localObject2 = new Bundle();
          ((Bundle)localObject2).putString("url", (String)localObject1);
          ((Bundle)localObject2).putString("tdsourcetag", "s_qq_aiomsg");
          TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject2, false);
          if (this.G != null) {
            break label271;
          }
          anot.a(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        QLog.e("QQText", 1, localThrowable, new Object[0]);
        continue;
        QQToast.a((Context)localObject2, ((Context)localObject2).getResources().getString(2131693404), 0).show(((Context)localObject2).getResources().getDimensionPixelSize(2131299627));
        continue;
        ajhj.a(paramView.getContext(), localThrowable, true, true, true, false, this.G, this.caG);
      }
    }
    for (;;)
    {
      try
      {
        label271:
        paramView = this.G;
        String str1 = paramView.frienduin;
        if (paramView.istroop == 1)
        {
          i = 2;
          if ((paramString == null) || (paramString.length() <= 150)) {
            break label405;
          }
          paramView = paramString.substring(0, 150);
          paramString = new URL(paramString).getHost();
          anot.a(null, "CliOper", "", str1, "0X80061B1", "0X80061B1", i, 0, "", "", paramView, paramString);
          if (!QLog.isDebugVersion()) {
            break;
          }
          QLog.d("QQText", 4, String.format("the report params:%s,%s,%s,%s", new Object[] { "", "", paramView, paramString }));
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      i = 1;
      continue;
      label405:
      paramView = paramString;
    }
  }
  
  public int[] ac()
  {
    return this.os;
  }
  
  protected void ayY()
  {
    Object localObject = aofv.aS(this.mText);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aofg localaofg = (aofg)((Iterator)localObject).next();
        b(new aofk.b(localaofg.content), localaofg.start, localaofg.end, 33);
      }
    }
  }
  
  protected void b(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mSpanCount + 1 >= this.mSpans.length)
    {
      int i = idealIntArraySize(this.mSpanCount + 1);
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.mSpans, 0, arrayOfObject, 0, this.mSpanCount);
      System.arraycopy(this.os, 0, arrayOfInt, 0, this.mSpanCount * 3);
      this.mSpans = arrayOfObject;
      this.os = arrayOfInt;
    }
    this.mSpans[this.mSpanCount] = paramObject;
    this.os[(this.mSpanCount * 3 + 0)] = paramInt1;
    this.os[(this.mSpanCount * 3 + 1)] = paramInt2;
    this.os[(this.mSpanCount * 3 + 2)] = paramInt3;
    this.mSpanCount += 1;
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.mText.charAt(paramInt);
  }
  
  protected Object clone()
    throws CloneNotSupportedException
  {
    aofk localaofk = (aofk)super.clone();
    localaofk.os = new int[this.os.length];
    System.arraycopy(this.os, 0, localaofk.os, 0, this.os.length);
    localaofk.mSpans = new Object[this.mSpans.length];
    System.arraycopy(this.mSpans, 0, localaofk.mSpans, 0, this.mSpans.length);
    return localaofk;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof aofk)) {
      return this.mSource.equals(((aofk)paramObject).mSource);
    }
    return false;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    this.mText.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 1)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 2)];
      }
      i -= 1;
    }
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 0)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    int m = this.mSpanCount;
    Object[] arrayOfObject2 = this.mSpans;
    int[] arrayOfInt = this.os;
    Object localObject = null;
    if (paramClass == null) {
      return null;
    }
    int j = 0;
    Object[] arrayOfObject1 = null;
    int i = 0;
    if (j < m)
    {
      if (!paramClass.isInstance(arrayOfObject2[j])) {}
      for (;;)
      {
        j += 1;
        break;
        int k = arrayOfInt[(j * 3 + 0)];
        int n = arrayOfInt[(j * 3 + 1)];
        if ((k <= paramInt2) && (n >= paramInt1) && ((k == n) || (paramInt1 == paramInt2) || ((k != paramInt2) && (n != paramInt1)))) {
          if (i == 0)
          {
            localObject = arrayOfObject2[j];
            i += 1;
          }
          else
          {
            if (i == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
              arrayOfObject1[0] = localObject;
            }
            n = 0xFF0000 & arrayOfInt[(j * 3 + 2)];
            if (n != 0)
            {
              k = 0;
              for (;;)
              {
                if ((k >= i) || (n > (getSpanFlags(arrayOfObject1[k]) & 0xFF0000)))
                {
                  System.arraycopy(arrayOfObject1, k, arrayOfObject1, k + 1, i - k);
                  arrayOfObject1[k] = arrayOfObject2[j];
                  i += 1;
                  break;
                }
                k += 1;
              }
            }
            arrayOfObject1[i] = arrayOfObject2[j];
            i += 1;
          }
        }
      }
    }
    if (i == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (i == 1)
    {
      arrayOfObject1 = (Object[])Array.newInstance(paramClass, 1);
      if (arrayOfObject1 == null) {
        return (Object[])Array.newInstance(paramClass, 0);
      }
      arrayOfObject1[0] = localObject;
      return (Object[])arrayOfObject1;
    }
    if (i == arrayOfObject1.length) {
      return (Object[])arrayOfObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, i);
    System.arraycopy(arrayOfObject1, 0, paramClass, 0, i);
    return (Object[])paramClass;
  }
  
  SpannableString l()
  {
    SpannableString localSpannableString = new SpannableString(this.mText);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public final int length()
  {
    return this.mText.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int m = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int i = 0;
    int j;
    if (i < m)
    {
      int k = arrayOfInt[(i * 3 + 0)];
      j = arrayOfInt[(i * 3 + 1)];
      if ((k <= paramInt1) || (k >= paramInt2) || (!((Class)localObject).isInstance(arrayOfObject[i]))) {
        break label131;
      }
      paramInt2 = k;
    }
    label131:
    for (;;)
    {
      if ((j > paramInt1) && (j < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i]))) {
        paramInt2 = j;
      }
      for (;;)
      {
        i += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  public void removeSpan(Object paramObject)
  {
    int j = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    int i = j - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (arrayOfObject[i] == paramObject)
        {
          int k = arrayOfInt[(i * 3 + 0)];
          int m = arrayOfInt[(i * 3 + 1)];
          j -= i + 1;
          System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
          System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
          this.mSpanCount -= 1;
          b(paramObject, k, m);
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    aH("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c = charAt(paramInt1 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c = charAt(paramInt2 - 1);
        if (c != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c + ")");
        }
      }
    }
    int j = this.mSpanCount;
    Object[] arrayOfObject = this.mSpans;
    int[] arrayOfInt = this.os;
    int i = 0;
    if (i < j) {
      if (arrayOfObject[i] == paramObject)
      {
        j = arrayOfInt[(i * 3 + 0)];
        int k = arrayOfInt[(i * 3 + 1)];
        arrayOfInt[(i * 3 + 0)] = paramInt1;
        arrayOfInt[(i * 3 + 1)] = paramInt2;
        arrayOfInt[(i * 3 + 2)] = paramInt3;
        a(paramObject, j, k, paramInt1, paramInt2);
      }
    }
    do
    {
      return;
      i += 1;
      break;
      if (this.mSpanCount + 1 >= this.mSpans.length)
      {
        i = idealIntArraySize(this.mSpanCount + 1);
        arrayOfObject = new Object[i];
        arrayOfInt = new int[i * 3];
        System.arraycopy(this.mSpans, 0, arrayOfObject, 0, this.mSpanCount);
        System.arraycopy(this.os, 0, arrayOfInt, 0, this.mSpanCount * 3);
        this.mSpans = arrayOfObject;
        this.os = arrayOfInt;
      }
      this.mSpans[this.mSpanCount] = paramObject;
      this.os[(this.mSpanCount * 3 + 0)] = paramInt1;
      this.os[(this.mSpanCount * 3 + 1)] = paramInt2;
      this.os[(this.mSpanCount * 3 + 2)] = paramInt3;
      this.mSpanCount += 1;
    } while (!(this instanceof Spannable));
    a(paramObject, paramInt1, paramInt2);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    label18:
    Object localObject;
    if (paramInt1 < 0)
    {
      paramInt1 = 0;
      int i = length();
      if (paramInt2 <= i) {
        break label47;
      }
      paramInt2 = i;
      if ((!cLs) || (!azx())) {
        break label50;
      }
      localObject = this.mText.subSequence(paramInt1, paramInt2);
    }
    label47:
    label50:
    do
    {
      return localObject;
      break;
      break label18;
      if ((Build.VERSION.SDK_INT < 26) || (paramInt1 != 0)) {
        break label73;
      }
      localObject = this;
    } while (paramInt2 == length());
    label73:
    return new aofk(this.mText, paramInt1, paramInt2, this.mFlags, this.dOo, this.mUinType);
  }
  
  public String toString()
  {
    if ((cLs) && (azx())) {
      return this.mText;
    }
    return this.mSource;
  }
  
  public String trim()
  {
    char[] arrayOfChar = this.mSource.toCharArray();
    int k = this.mSource.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024')))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k)) {
          return this.mSource;
        }
        return this.mSource.substring(i, j + 1);
        j = k;
      }
    }
  }
  
  public String v(boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(this.mText);
    int m = "[emoji]".length();
    int j = 0;
    int k = 0;
    if (j < this.mSpanCount)
    {
      Object localObject = this.mSpans[j];
      int i = k;
      int n;
      int i1;
      if ((localObject instanceof aofk.a))
      {
        n = this.os[(j * 3 + 0)];
        i1 = this.os[(j * 3 + 1)];
        localObject = (aofk.a)localObject;
        switch (((aofk.a)localObject).emojiType)
        {
        default: 
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (paramBoolean)
        {
          localStringBuffer.replace(n + k, i1 + k, "[emoji]");
          i = k + (m - (i1 - n));
          continue;
          localObject = ((aofk.a)localObject).getDescription();
          localStringBuffer.replace(n + k, i1 + k, (String)localObject);
          i = k + (((String)localObject).length() - (i1 - n));
          continue;
          localObject = afky.ea(((aofk.a)localObject).index & 0x7FFFFFFF);
          localStringBuffer.replace(n + k, i1 + k, (String)localObject);
          i = k + (((String)localObject).length() - (i1 - n));
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  public static class a
    extends ReplacementSpan
  {
    public float Aa;
    public float Ab;
    public float Ac;
    public float Ad;
    protected volatile boolean cLu;
    public int emojiType;
    public int index;
    private WeakReference<Drawable> mDrawableRef;
    int size;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.index = paramInt1;
      this.size = paramInt2;
      this.emojiType = paramInt3;
    }
    
    protected Drawable aR()
    {
      Drawable localDrawable2;
      Drawable localDrawable1;
      if (this.emojiType == 0)
      {
        localDrawable2 = afku.x(this.index);
        localDrawable1 = localDrawable2;
        if (localDrawable2 != null)
        {
          localDrawable2.setBounds(0, 0, this.size, this.size);
          localDrawable1 = localDrawable2;
        }
      }
      do
      {
        int i;
        do
        {
          do
          {
            return localDrawable1;
            if ((0x80000000 & this.index) != 0) {
              break;
            }
            localDrawable2 = aofy.b(this.index, false);
            localDrawable1 = localDrawable2;
          } while (localDrawable2 == null);
          localDrawable2.setBounds(0, 0, this.size, this.size);
          return localDrawable2;
          i = 0x7FFFFFFF & this.index;
          if (!afky.jr(i)) {
            break label158;
          }
          if (!afky.jo(i)) {
            break;
          }
          localDrawable2 = aofy.b(i, false);
          localDrawable1 = localDrawable2;
        } while (localDrawable2 == null);
        localDrawable2.setBounds(0, 0, this.size, this.size);
        return localDrawable2;
        localDrawable2 = aofy.b(i, true);
        localDrawable1 = localDrawable2;
      } while (localDrawable2 == null);
      localDrawable2.setBounds(0, 0, this.size, this.size);
      return localDrawable2;
      label158:
      return new ColorDrawable();
    }
    
    public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      paramCanvas.save();
      float f2 = paramInt4 - this.size;
      float f1 = f2;
      if (paramInt5 > paramInt4)
      {
        f1 = f2;
        if (paramPaint != null) {
          f1 = f2 + paramPaint.getFontMetrics().descent;
        }
      }
      paramCanvas.translate(paramFloat, f1);
      if (paramCharSequence != null)
      {
        paramCharSequence.draw(paramCanvas);
        this.Aa = paramFloat;
        this.Ab = paramInt3;
        this.Ac = (this.Aa + this.size);
        this.Ad = paramInt5;
      }
      paramCanvas.restore();
    }
    
    public String getDescription()
    {
      return "";
    }
    
    public Drawable getDrawable()
    {
      Object localObject1 = this.mDrawableRef;
      if (localObject1 != null) {}
      for (localObject1 = (Drawable)((WeakReference)localObject1).get();; localObject1 = null)
      {
        Object localObject2;
        if ((localObject1 instanceof URLDrawable))
        {
          localObject2 = (URLDrawable)localObject1;
          if ((this.cLu) && (!((URLDrawable)localObject2).mUseApngImage))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQText", 2, "getDrawable: change to apng");
            }
            localObject1 = null;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = aR();
            this.mDrawableRef = new WeakReference(localObject2);
          }
          return localObject2;
        }
      }
    }
    
    public int getIndex()
    {
      return 0x7FFFFFFF & this.index;
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      if (paramFontMetricsInt != null)
      {
        paramFontMetricsInt.ascent = (-this.size);
        paramFontMetricsInt.descent = 0;
        paramFontMetricsInt.top = paramFontMetricsInt.ascent;
        paramFontMetricsInt.bottom = 0;
      }
      return this.size;
    }
    
    public void setSize(int paramInt)
    {
      this.size = paramInt;
      Drawable localDrawable = getDrawable();
      if (localDrawable != null) {
        localDrawable.setBounds(0, 0, paramInt, paramInt);
      }
    }
  }
  
  public class b
    extends ClickableSpan
  {
    public String mUrl;
    
    public b(String paramString)
    {
      this.mUrl = paramString;
    }
    
    public void onClick(View paramView)
    {
      if (aqgq.cTW) {
        if (QLog.isColorLevel()) {
          QLog.e("LinkSpan", 2, "LinkSpan.onCLick is invoked by LongClick misstake");
        }
      }
      Object localObject;
      do
      {
        return;
        localObject = paramView.getTag();
        if ((localObject instanceof String)) {
          aofk.access$102((String)localObject);
        }
        localObject = this.mUrl;
        boolean bool2 = aqjb.WEB_URL.matcher((CharSequence)localObject).find();
        boolean bool1 = bool2;
        if (!bool2) {
          bool1 = aqjb.an.matcher((CharSequence)localObject).find();
        }
        if (bool1)
        {
          if (aofv.ai.matcher((CharSequence)localObject).find())
          {
            aofk.this.a(paramView.getContext(), (String)localObject, 2, aofk.a(aofk.this));
            aofk.hE("1", null);
            return;
          }
          aofk.this.a(paramView, (String)localObject);
          aofk.hE("0", null);
          return;
        }
        if (aofv.ae.matcher((CharSequence)localObject).find())
        {
          aofk.this.a(paramView.getContext(), (String)localObject, 3, aofk.a(aofk.this));
          aofk.hE("2", null);
          return;
        }
        Matcher localMatcher = aofv.e.matcher((CharSequence)localObject);
        if ((localMatcher.find()) && (localMatcher.start() == 0) && (localMatcher.end() == ((String)localObject).length()))
        {
          aofk.this.a(paramView.getContext(), (String)localObject, 0, aofk.a(aofk.this));
          aofk.hE("1", null);
          return;
        }
      } while (!aofv.ah.matcher((CharSequence)localObject).find());
      aofk.this.a(paramView.getContext(), (String)localObject, 1, aofk.a(aofk.this));
      aofk.hE("2", null);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      super.updateDrawState(paramTextPaint);
      paramTextPaint.clearShadowLayer();
    }
  }
  
  public static class c
    extends aofk.a
  {
    boolean cLv;
    public int dOt;
    public int dOu;
    int mSize;
    
    public c(char[] paramArrayOfChar, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramInt, 2);
      this.mSize = paramInt;
      this.cLv = paramBoolean1;
      this.cLu = paramBoolean2;
      paramArrayOfChar = afgc.a(paramArrayOfChar);
      if ((paramArrayOfChar != null) && (paramArrayOfChar.length == 2))
      {
        this.dOt = paramArrayOfChar[0];
        this.dOu = paramArrayOfChar[1];
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "mEpId:" + this.dOt + ",mEId:" + this.dOu);
      }
    }
    
    private void dUv()
    {
      QQText.SmallEmojiSpan.1 local1 = new QQText.SmallEmojiSpan.1(this);
      try
      {
        afke localafke = (afke)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(aofk.access$000())).getManager(43);
        if (localafke != null) {
          localafke.a.execute(local1, 128, true);
        }
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
    
    protected Drawable aR()
    {
      Object localObject = new afqh(aofk.access$000());
      Emoticon localEmoticon = new Emoticon();
      localEmoticon.eId = String.valueOf(this.dOu);
      localEmoticon.epId = String.valueOf(this.dOt);
      if (!this.cLv)
      {
        localEmoticon.jobType = 3;
        ((afqh)localObject).e = localEmoticon;
        localObject = ((afqh)localObject).b(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
      }
      for (;;)
      {
        if (localObject != null) {
          ((Drawable)localObject).setBounds(0, 0, this.mSize, this.mSize);
        }
        return localObject;
        localEmoticon.jobType = 3;
        ((afqh)localObject).e = localEmoticon;
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "SmallEmojiSpan doGetDrawable: epid = " + this.dOt + " eid = " + this.dOu + " isAPNG = " + this.cLu);
        }
        ((afqh)localObject).isAPNG = this.cLu;
        localObject = ((afqh)localObject).c(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density);
        dUv();
      }
    }
    
    public String getDescription()
    {
      String str = aofk.ckA;
      Emoticon localEmoticon = null;
      ajdg localajdg = afnu.a();
      if (localajdg != null) {
        localEmoticon = localajdg.a(Integer.toString(this.dOt), Integer.toString(this.dOu));
      }
      if (localEmoticon != null) {
        str = localEmoticon.character;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQText", 2, "descp:" + str);
      }
      return str;
    }
    
    public int getIndex()
    {
      return this.dOt;
    }
    
    public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      if (paramFontMetricsInt != null)
      {
        paramFontMetricsInt.ascent = (-this.mSize);
        paramFontMetricsInt.descent = 0;
        paramFontMetricsInt.top = paramFontMetricsInt.ascent;
        paramFontMetricsInt.bottom = 0;
      }
      return this.mSize;
    }
    
    public void n(EmoticonPackage paramEmoticonPackage)
    {
      if ((!this.cLu) && (paramEmoticonPackage != null) && (paramEmoticonPackage.isAPNG == 2))
      {
        this.cLu = true;
        if (QLog.isColorLevel()) {
          QLog.d("QQText", 2, "updateApngFlag mIsAPNG = true");
        }
      }
    }
    
    public void setSize(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + paramInt);
      }
      this.mSize = paramInt;
      this.size = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aofk
 * JD-Core Version:    0.7.0.1
 */