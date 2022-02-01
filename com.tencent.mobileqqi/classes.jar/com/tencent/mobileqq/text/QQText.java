package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
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
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.widget.ActionSheet;
import gmp;
import gmq;
import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQText
  implements GetChars, Spannable, CharSequence, Cloneable
{
  public static final char a = '\n';
  public static final int a = 0;
  public static Spannable.Factory a;
  public static Boolean a;
  static final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  public static final boolean a;
  static final Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  public static final char b = 'ú';
  public static final int b = 1;
  static final Pattern jdField_b_of_type_JavaUtilRegexPattern;
  public static final boolean b;
  public static final int c = 2;
  static final String c = "[emoji]";
  public static final int d = 4;
  static final String d = "\\d{5,}";
  public static final int e = 8;
  static final String e = Patterns.jdField_b_of_type_JavaUtilRegexPattern.pattern() + "|" + Patterns.f + "|" + "\\d{5,}";
  public static final int f = 3;
  public static final int g = 5;
  public static final int h = 7;
  public static final int i = 6;
  public static final int j = 13;
  public static final int k = 32;
  public static final int l = 10;
  public static final int m = 16;
  private static final int o = 0;
  private static final int p = 1;
  private static final int q = 2;
  private static final int r = 3;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private Object[] jdField_b_of_type_ArrayOfJavaLangObject;
  public String f;
  private int n;
  private int s = -1;
  
  static
  {
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(e);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{5,}");
    jdField_a_of_type_ArrayOfJavaLangObject = new Object[0];
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    jdField_a_of_type_AndroidTextSpannable$Factory = new gmp();
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
        jdField_b_of_type_Boolean = false;
      }
    }
    if ((Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 14))
    {
      jdField_b_of_type_Boolean = true;
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.s = paramInt5;
    paramInt5 = a(3);
    this.jdField_b_of_type_ArrayOfJavaLangObject = new Object[paramInt5];
    this.jdField_a_of_type_ArrayOfInt = new int[paramInt5 * 3];
    paramInt4 = (int)(paramInt4 * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    if (paramCharSequence == null)
    {
      this.jdField_a_of_type_JavaLangString = "";
      this.f = "";
      return;
    }
    this.f = paramCharSequence.toString();
    this.jdField_a_of_type_JavaLangString = this.f;
    Object localObject1;
    if (((paramInt3 & 0x1) == 1) || ((paramInt3 & 0x6) > 0))
    {
      localObject1 = new StringBuilder(this.f);
      paramInt4 = a(0, ((StringBuilder)localObject1).length(), paramInt3, paramInt4, (StringBuilder)localObject1);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      if (!jdField_a_of_type_Boolean) {
        this.f = this.jdField_a_of_type_JavaLangString;
      }
      if (paramInt4 < 10) {}
    }
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      if (paramInt4 != 0)
      {
        localObject1 = (QQText.EmotcationSpan[])getSpans(paramInt1, paramInt2, QQText.EmotcationSpan.class);
        if (localObject1 != null)
        {
          paramInt5 = localObject1.length;
          paramInt4 = 0;
          while (paramInt4 < paramInt5)
          {
            Object localObject2 = localObject1[paramInt4];
            if (!localObject2.jdField_a_of_type_Boolean) {
              localObject2.jdField_a_of_type_Int &= 0x7FFFFFFF;
            }
            paramInt4 += 1;
          }
        }
      }
      if ((paramInt3 & 0x8) == 8)
      {
        localObject1 = jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_a_of_type_JavaLangString);
        while (((Matcher)localObject1).find())
        {
          paramInt3 = ((Matcher)localObject1).start();
          paramInt4 = ((Matcher)localObject1).end();
          a(new QQText.LinkSpan(this, this.jdField_a_of_type_JavaLangString.substring(paramInt3, paramInt4)), paramInt3, paramInt4, 33);
        }
      }
      if (!(paramCharSequence instanceof Spanned)) {
        break;
      }
      paramCharSequence = (Spanned)paramCharSequence;
      localObject1 = paramCharSequence.getSpans(paramInt1, paramInt2, Object.class);
      paramInt3 = i1;
      while (paramInt3 < localObject1.length)
      {
        paramInt5 = paramCharSequence.getSpanStart(localObject1[paramInt3]);
        i1 = paramCharSequence.getSpanEnd(localObject1[paramInt3]);
        int i2 = paramCharSequence.getSpanFlags(localObject1[paramInt3]);
        paramInt4 = paramInt5;
        if (paramInt5 < paramInt1) {
          paramInt4 = paramInt1;
        }
        paramInt5 = i1;
        if (i1 > paramInt2) {
          paramInt5 = paramInt2;
        }
        setSpan(localObject1[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, i2);
        paramInt3 += 1;
      }
      break;
    }
  }
  
  private static int a(int paramInt)
  {
    int i2 = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i1 = i2;
      if (paramInt < 32)
      {
        if (i2 <= (1 << paramInt) - 12) {
          i1 = (1 << paramInt) - 12;
        }
      }
      else {
        return i1 / 4;
      }
      paramInt += 1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder)
  {
    int i5 = paramStringBuilder.length();
    int i1 = 0;
    if (paramInt1 < paramInt2)
    {
      int i3 = paramStringBuilder.codePointAt(paramInt1);
      label33:
      int i4;
      if ((paramInt3 & 0x4) == 4)
      {
        i2 = 1;
        if (((paramInt3 & 0x6) <= 0) || (i3 != 20) || (paramInt1 >= i5 - 1)) {
          break label276;
        }
        i4 = paramStringBuilder.charAt(paramInt1 + 1);
        if (i4 >= EmotcationConstants.b) {
          break label188;
        }
        if (!jdField_a_of_type_Boolean) {
          break label167;
        }
        paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
      }
      for (;;)
      {
        i3 = i4;
        if (i2 != 0) {
          i3 = i4 | 0x80000000;
        }
        a(new QQText.EmotcationSpan(this, false, i3, paramInt4), paramInt1, paramInt1 + 2, 33);
        i2 = i1 + 1;
        i1 = paramInt1 + 1;
        paramInt1 = i2;
        i2 = i1 + 1;
        i1 = paramInt1;
        paramInt1 = i2;
        break;
        i2 = 0;
        break label33;
        label167:
        if (i4 == 10) {
          paramStringBuilder.setCharAt(paramInt1 + 1, 'ú');
        }
      }
      label188:
      label337:
      QQText.EmotcationSpan localEmotcationSpan;
      if (i4 == 250)
      {
        if (jdField_a_of_type_Boolean) {
          paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
        }
        if (i2 != 0) {}
        for (i2 = -2147483638;; i2 = 10)
        {
          a(new QQText.EmotcationSpan(this, false, i2, paramInt4), paramInt1, paramInt1 + 2, 33);
          i1 += 1;
          i2 = paramInt1 + 1;
          paramInt1 = i1;
          i1 = i2;
          break;
        }
        label276:
        if ((paramInt3 & 0x1) == 1)
        {
          i4 = EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(i3, -1);
          if (i4 >= 0)
          {
            if ((i3 <= 65535) || (i5 < paramInt1 + 2)) {
              break label386;
            }
            if (jdField_a_of_type_Boolean) {
              paramStringBuilder.replace(paramInt1, paramInt1 + 2, "##");
            }
            i2 = 1;
            localEmotcationSpan = new QQText.EmotcationSpan(this, true, i4, paramInt4);
            if (i2 == 0) {
              break label411;
            }
          }
        }
      }
      label386:
      label411:
      for (int i2 = 2;; i2 = 1)
      {
        a(localEmotcationSpan, paramInt1, i2 + paramInt1, 33);
        i2 = paramInt1;
        paramInt1 = i1;
        i1 = i2;
        break;
        if (jdField_a_of_type_Boolean) {
          paramStringBuilder.replace(paramInt1, paramInt1 + 1, "#");
        }
        i2 = 0;
        break label337;
      }
    }
    if (i1 > 0) {}
    return i1;
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.a(2131561727, 1);
    localActionSheet.a(2131561879, 1);
    if (paramBoolean)
    {
      localActionSheet.a(2131561597, 1);
      localActionSheet.a(2131562263, 1);
    }
    localActionSheet.d(2131561746);
    if (paramBoolean) {
      localActionSheet.a(String.format(paramContext.getString(2131561504), new Object[] { paramString }));
    }
    for (;;)
    {
      localActionSheet.a(new gmq(paramString, paramContext, localActionSheet));
      localActionSheet.show();
      return;
      localActionSheet.a(paramString);
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.n + 1 >= this.jdField_b_of_type_ArrayOfJavaLangObject.length)
    {
      int i1 = a(this.n + 1);
      Object[] arrayOfObject = new Object[i1];
      int[] arrayOfInt = new int[i1 * 3];
      System.arraycopy(this.jdField_b_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.n);
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.n * 3);
      this.jdField_b_of_type_ArrayOfJavaLangObject = arrayOfObject;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
    this.jdField_b_of_type_ArrayOfJavaLangObject[this.n] = paramObject;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 0)] = paramInt1;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 1)] = paramInt2;
    this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 2)] = paramInt3;
    this.n += 1;
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i1 += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " has end before start");
    }
    int i1 = length();
    if ((paramInt1 > i1) || (paramInt2 > i1)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " ends beyond length " + i1);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private static final boolean a()
  {
    StackTraceElement localStackTraceElement = new java.lang.Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramString.length())
      {
        i2 = paramString.codePointAt(i1);
        if (EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(i2, -1) < 0) {
          break label43;
        }
      }
      label43:
      for (int i2 = 1; i2 != 0; i2 = 0)
      {
        bool1 = true;
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int i2 = arrayOfSpanWatcher.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfSpanWatcher[i1].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i1 += 1;
    }
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramString.length())
      {
        if (20 == paramString.codePointAt(i1)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_a_of_type_JavaLangString);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public QQText a(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    QQText localQQText = new QQText("", 0);
    localQQText.s = this.s;
    localQQText.n = this.n;
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_b_of_type_ArrayOfJavaLangObject = new Object[this.jdField_b_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_b_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_b_of_type_ArrayOfJavaLangObject, 0, this.jdField_b_of_type_ArrayOfJavaLangObject.length);
    int i1;
    int i2;
    if (paramVarArgs.length >= 2)
    {
      i1 = paramVarArgs[0];
      i2 = (int)(paramVarArgs[1] * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        paramVarArgs = new StringBuilder().append(paramString).append(this.jdField_a_of_type_JavaLangString);
        int i4 = paramString.length();
        int i3 = 0;
        while (i3 < localQQText.jdField_b_of_type_ArrayOfJavaLangObject.length)
        {
          this.jdField_a_of_type_ArrayOfInt[(i3 * 3 + 0)] += i4;
          this.jdField_a_of_type_ArrayOfInt[(i3 * 3 + 1)] += i4;
          i3 += 1;
        }
        if (i1 != 0) {
          localQQText.a(0, paramString.length(), i1, i2, paramVarArgs);
        }
        localQQText.f = (paramString + this.f);
        localQQText.jdField_a_of_type_JavaLangString = paramVarArgs.toString();
        return localQQText;
      }
      paramVarArgs = new StringBuilder().append(paramString).append(this.jdField_a_of_type_JavaLangString);
      if (i1 != 0) {
        localQQText.a(this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_JavaLangString.length() + paramString.length(), i1, i2, paramVarArgs);
      }
      this.f += paramString;
      localQQText.jdField_a_of_type_JavaLangString = paramVarArgs.toString();
      return localQQText;
      i2 = 0;
      i1 = 0;
    }
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_a_of_type_JavaLangString);
    int i4 = "[emoji]".length();
    int i2 = 0;
    int i3 = 0;
    if (i2 < this.n)
    {
      Object localObject = this.jdField_b_of_type_ArrayOfJavaLangObject[i2];
      int i1 = i3;
      int i5;
      if ((localObject instanceof QQText.EmotcationSpan))
      {
        i1 = this.jdField_a_of_type_ArrayOfInt[(i2 * 3 + 0)];
        i5 = this.jdField_a_of_type_ArrayOfInt[(i2 * 3 + 1)];
        localObject = (QQText.EmotcationSpan)localObject;
        if (!((QQText.EmotcationSpan)localObject).jdField_a_of_type_Boolean) {
          break label122;
        }
        localStringBuffer.replace(i1 + i3, i5 + i3, "[emoji]");
      }
      for (i1 = i3 + (i4 - (i5 - i1));; i1 = i3 + (((String)localObject).length() - (i5 - i1)))
      {
        i2 += 1;
        i3 = i1;
        break;
        label122:
        localObject = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[(localObject.jdField_a_of_type_Int & 0x7FFFFFFF)];
        localStringBuffer.replace(i1 + i3, i5 + i3, (String)localObject);
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(View paramView, String paramString)
  {
    String str1 = null;
    int i1 = paramString.lastIndexOf("#");
    if (i1 > 0) {
      str1 = paramString.substring(i1);
    }
    String str2 = URLUtil.guessUrl(paramString);
    paramString = str2;
    if (str1 != null) {
      paramString = str2 + str1;
    }
    MttBrowerWrapper.a(paramView.getContext(), paramString, true, true, true, false, this.s, "");
  }
  
  public String b()
  {
    char[] arrayOfChar = this.f.toCharArray();
    int i3 = this.f.length() - 1;
    int i1 = 0;
    while ((i1 <= i3) && (arrayOfChar[i1] <= ' ') && (arrayOfChar[i1] != '\024')) {
      i1 += 1;
    }
    for (;;)
    {
      int i2;
      if ((i2 >= i1) && (arrayOfChar[i2] <= ' ') && ((i2 == 0) || (arrayOfChar[(i2 - 1)] != '\024')))
      {
        i2 -= 1;
      }
      else
      {
        if ((i1 == 0) && (i2 == i3)) {
          return this.f;
        }
        return this.f.substring(i1, i2 + 1);
        i2 = i3;
      }
    }
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.jdField_a_of_type_JavaLangString.charAt(paramInt);
  }
  
  public Object clone()
  {
    QQText localQQText = (QQText)super.clone();
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_b_of_type_ArrayOfJavaLangObject = new Object[this.jdField_b_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_b_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_b_of_type_ArrayOfJavaLangObject, 0, this.jdField_b_of_type_ArrayOfJavaLangObject.length);
    return localQQText;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QQText)) {
      return this.f.equals(((QQText)paramObject).f);
    }
    return false;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    int i2 = length();
    paramInt1 = paramInt2;
    if (paramInt2 > i2) {
      paramInt1 = i2;
    }
    this.jdField_a_of_type_JavaLangString.getChars(i1, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 1)];
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 2)];
      }
      i1 -= 1;
    }
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i1 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i1 -= 1;
    while (i1 >= 0)
    {
      if (arrayOfObject[i1] == paramObject) {
        return arrayOfInt[(i1 * 3 + 0)];
      }
      i1 -= 1;
    }
    return -1;
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    int i4 = this.n;
    Object[] arrayOfObject2 = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = null;
    int i2 = 0;
    Object[] arrayOfObject1 = null;
    int i1 = 0;
    if (i2 < i4)
    {
      if ((paramClass != null) && (!paramClass.isInstance(arrayOfObject2[i2]))) {}
      for (;;)
      {
        i2 += 1;
        break;
        int i3 = arrayOfInt[(i2 * 3 + 0)];
        int i5 = arrayOfInt[(i2 * 3 + 1)];
        if ((i3 <= paramInt2) && (i5 >= paramInt1) && ((i3 == i5) || (paramInt1 == paramInt2) || ((i3 != paramInt2) && (i5 != paramInt1)))) {
          if (i1 == 0)
          {
            localObject = arrayOfObject2[i2];
            i1 += 1;
          }
          else
          {
            if (i1 == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, i4 - i2 + 1);
              arrayOfObject1[0] = localObject;
            }
            i5 = 0xFF0000 & arrayOfInt[(i2 * 3 + 2)];
            if (i5 != 0)
            {
              i3 = 0;
              for (;;)
              {
                if ((i3 >= i1) || (i5 > (getSpanFlags(arrayOfObject1[i3]) & 0xFF0000)))
                {
                  System.arraycopy(arrayOfObject1, i3, arrayOfObject1, i3 + 1, i1 - i3);
                  arrayOfObject1[i3] = arrayOfObject2[i2];
                  i1 += 1;
                  break;
                }
                i3 += 1;
              }
            }
            arrayOfObject1[i1] = arrayOfObject2[i2];
            i1 += 1;
          }
        }
      }
    }
    if (i1 == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (i1 == 1)
    {
      paramClass = (Object[])Array.newInstance(paramClass, 1);
      paramClass[0] = localObject;
      return (Object[])paramClass;
    }
    if (i1 == arrayOfObject1.length) {
      return (Object[])arrayOfObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, i1);
    System.arraycopy(arrayOfObject1, 0, paramClass, 0, i1);
    return (Object[])paramClass;
  }
  
  public final int length()
  {
    return this.jdField_a_of_type_JavaLangString.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int i4 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int i1 = 0;
    int i2;
    if (i1 < i4)
    {
      int i3 = arrayOfInt[(i1 * 3 + 0)];
      i2 = arrayOfInt[(i1 * 3 + 1)];
      if ((i3 <= paramInt1) || (i3 >= paramInt2) || (!((Class)localObject).isInstance(arrayOfObject[i1]))) {
        break label131;
      }
      paramInt2 = i3;
    }
    label131:
    for (;;)
    {
      if ((i2 > paramInt1) && (i2 < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i1]))) {
        paramInt2 = i2;
      }
      for (;;)
      {
        i1 += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  public void removeSpan(Object paramObject)
  {
    int i2 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i1 = i2 - 1;
    for (;;)
    {
      if (i1 >= 0)
      {
        if (arrayOfObject[i1] == paramObject)
        {
          int i3 = arrayOfInt[(i1 * 3 + 0)];
          int i4 = arrayOfInt[(i1 * 3 + 1)];
          i2 -= i1 + 1;
          System.arraycopy(arrayOfObject, i1 + 1, arrayOfObject, i1, i2);
          System.arraycopy(arrayOfInt, (i1 + 1) * 3, arrayOfInt, i1 * 3, i2 * 3);
          this.n -= 1;
          b(paramObject, i3, i4);
        }
      }
      else {
        return;
      }
      i1 -= 1;
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c1;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c1 = charAt(paramInt1 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c1 + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c1 = charAt(paramInt2 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c1 + ")");
        }
      }
    }
    int i2 = this.n;
    Object[] arrayOfObject = this.jdField_b_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i1 = 0;
    if (i1 < i2) {
      if (arrayOfObject[i1] == paramObject)
      {
        i2 = arrayOfInt[(i1 * 3 + 0)];
        int i3 = arrayOfInt[(i1 * 3 + 1)];
        arrayOfInt[(i1 * 3 + 0)] = paramInt1;
        arrayOfInt[(i1 * 3 + 1)] = paramInt2;
        arrayOfInt[(i1 * 3 + 2)] = paramInt3;
        a(paramObject, i2, i3, paramInt1, paramInt2);
      }
    }
    do
    {
      return;
      i1 += 1;
      break;
      if (this.n + 1 >= this.jdField_b_of_type_ArrayOfJavaLangObject.length)
      {
        i1 = a(this.n + 1);
        arrayOfObject = new Object[i1];
        arrayOfInt = new int[i1 * 3];
        System.arraycopy(this.jdField_b_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.n);
        System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.n * 3);
        this.jdField_b_of_type_ArrayOfJavaLangObject = arrayOfObject;
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      }
      this.jdField_b_of_type_ArrayOfJavaLangObject[this.n] = paramObject;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 0)] = paramInt1;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 1)] = paramInt2;
      this.jdField_a_of_type_ArrayOfInt[(this.n * 3 + 2)] = paramInt3;
      this.n += 1;
    } while (!(this instanceof Spannable));
    a(paramObject, paramInt1, paramInt2);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    int i2 = length();
    paramInt1 = paramInt2;
    if (paramInt2 > i2) {
      paramInt1 = i2;
    }
    if ((jdField_a_of_type_Boolean) && (a())) {
      return this.jdField_a_of_type_JavaLangString.subSequence(i1, paramInt1);
    }
    return new QQText(this, i1, paramInt1);
  }
  
  public String toString()
  {
    if ((jdField_a_of_type_Boolean) && (a())) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText
 * JD-Core Version:    0.7.0.1
 */