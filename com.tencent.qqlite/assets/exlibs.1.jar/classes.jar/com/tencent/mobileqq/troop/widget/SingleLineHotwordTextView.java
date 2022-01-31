package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class SingleLineHotwordTextView
  extends TextView
{
  protected static final int a = -97212;
  protected static final String a = "SingleLineHotwordTextView";
  public static final HashMap a;
  public static final String b = "…";
  public static final int e = 0;
  public static final int f = 1;
  public static final int g = -1;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  protected static final int k = 0;
  protected static final int l = 1;
  protected static final int m = 2;
  protected static final int n = 3;
  private ArrayList a;
  public int b = 2147483647;
  public int c;
  public String c;
  public int d;
  public String d;
  protected String e = "";
  protected String f = "";
  private int o = -97212;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public SingleLineHotwordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilArrayList = null;
    setSingleLine();
  }
  
  public static int a(String paramString1, String paramString2, int paramInt, TextPaint paramTextPaint, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return 0;
    }
    paramString1 = new StringBuilder(paramString1);
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.append(".").append(paramString3);
    }
    paramString1 = paramString1.toString();
    int i3 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
    if (i3 != -1)
    {
      int i4 = paramString1.length();
      if (paramTextPaint.measureText(paramString1, 0, i4) <= paramInt) {
        return 0;
      }
      if (i3 == 0) {
        return 2;
      }
      float[] arrayOfFloat = new float[i4];
      paramTextPaint.getTextWidths(paramString1, 0, i4, arrayOfFloat);
      int i1 = (int)(paramInt - paramTextPaint.measureText("…"));
      paramInt = i1;
      if (!TextUtils.isEmpty(paramString3)) {
        paramInt = (int)(i1 - paramTextPaint.measureText(paramString3));
      }
      int i5 = paramString2.length();
      i1 = 0;
      int i2 = 0;
      while (i1 < i3 + i5)
      {
        i2 = (int)(i2 + arrayOfFloat[i1]);
        i1 += 1;
      }
      if (i2 < paramInt) {
        return 2;
      }
      i2 = 0;
      i1 = i3;
      while (i1 < i4)
      {
        i2 = (int)(i2 + arrayOfFloat[i1]);
        i1 += 1;
      }
      if (i2 < paramInt) {
        return 1;
      }
      return 3;
    }
    return 0;
  }
  
  public static SpannableString a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new SpannableString(paramString);
    if (TroopUtils.a(paramArrayList)) {
      return paramString;
    }
    String str1 = paramString.toString().toLowerCase();
    int i1 = 0;
    while (i1 < paramArrayList.size())
    {
      String str2 = (String)paramArrayList.get(i1);
      if (!TextUtils.isEmpty(str2))
      {
        int i2 = str1.indexOf(str2.toLowerCase());
        if (i2 > -1) {
          paramString.setSpan(new ForegroundColorSpan(paramInt), i2, str2.length() + i2, 33);
        }
      }
      i1 += 1;
    }
    return paramString;
  }
  
  public static String a(int paramInt1, String paramString1, String paramString2, int paramInt2, TextPaint paramTextPaint, String paramString3)
  {
    int i3 = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    String str1;
    int i2;
    do
    {
      return paramString1;
      paramString1 = new StringBuilder(paramString1);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString1.append(".").append(paramString3);
      }
      str1 = paramString1.toString();
      i2 = str1.toLowerCase().indexOf(paramString2.toLowerCase());
      paramString1 = str1;
    } while (i2 == -1);
    int i5 = str1.length();
    float[] arrayOfFloat = new float[i5];
    paramTextPaint.getTextWidths(str1, 0, i5, arrayOfFloat);
    String str2;
    if (paramInt1 == 2)
    {
      str2 = "." + paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        break label549;
      }
      paramString1 = str1.substring(0, str1.lastIndexOf(str2));
    }
    for (paramInt1 = (int)(0 + paramTextPaint.measureText(str2));; paramInt1 = 0)
    {
      int i1 = (int)(paramInt1 + paramTextPaint.measureText("…"));
      paramInt1 = 0;
      label179:
      if (paramInt1 < i5)
      {
        i1 = (int)(i1 + arrayOfFloat[paramInt1]);
        if (i1 <= paramInt2) {}
      }
      for (;;)
      {
        paramString2 = paramString1.substring(0, paramInt1) + "…";
        paramString1 = paramString2;
        if (TextUtils.isEmpty(paramString3)) {
          break;
        }
        return paramString2 + str2;
        paramInt1 += 1;
        break label179;
        if (paramInt1 == 1)
        {
          i1 = (int)(0 + paramTextPaint.measureText("…"));
          paramInt1 = i5 - 1;
          for (;;)
          {
            i2 = i3;
            if (paramInt1 > 0)
            {
              i1 = (int)(i1 + arrayOfFloat[paramInt1]);
              if (i1 > paramInt2) {
                i2 = paramInt1 + 1;
              }
            }
            else
            {
              return "…" + str1.substring(i2, i5);
            }
            paramInt1 -= 1;
          }
        }
        paramString1 = str1;
        if (paramInt1 != 3) {
          break;
        }
        i1 = paramString2.length() + i2;
        paramInt1 = (int)(0 + (paramTextPaint.measureText("…") * 2.0F + paramTextPaint.measureText(str1.substring(i2, i1))));
        i3 = 1;
        if ((i2 > 0) && (i1 < i5))
        {
          int i4;
          if (i3 != 0)
          {
            paramInt1 = (int)(paramInt1 + arrayOfFloat[(i2 - 1)]);
            if (paramInt1 >= paramInt2) {
              break label510;
            }
            i4 = i2 - 1;
            i2 = i1;
            i1 = i4;
            label449:
            if (i3 != 0) {
              break label504;
            }
          }
          label504:
          for (i3 = 1;; i3 = 0)
          {
            i4 = i1;
            i1 = i2;
            i2 = i4;
            break;
            paramInt1 = (int)(paramInt1 + arrayOfFloat[i1]);
            if (paramInt1 >= paramInt2) {
              break label510;
            }
            i4 = i2;
            i2 = i1 + 1;
            i1 = i4;
            break label449;
          }
        }
        label510:
        return "…" + str1.substring(i2, i1) + "…";
        paramInt1 = i5;
      }
      label549:
      paramString1 = str1;
    }
  }
  
  protected static String a(String paramString, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("key=[");
    if (paramArrayList != null)
    {
      int i2 = paramArrayList.size();
      int i1 = 0;
      if (i1 < i2)
      {
        String str2 = (String)paramArrayList.get(i1);
        String str1 = str2;
        if (!TextUtils.isEmpty(str2)) {
          str1 = str2.toLowerCase();
        }
        localStringBuilder.append(str1);
        if (i1 != i2 - 1) {
          localStringBuilder.append("|");
        }
        for (;;)
        {
          i1 += 1;
          break;
          localStringBuilder.append("]");
        }
      }
    }
    return ("&&text=[" + paramString + "]").toLowerCase();
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  protected int a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    int i2 = -1;
    int i1 = i2;
    String str;
    if (!TextUtils.isEmpty(paramString1))
    {
      i1 = i2;
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString1.toLowerCase();
        if (paramInt != 1) {
          break label187;
        }
        if (paramString2.toLowerCase().contains(str)) {
          break label135;
        }
        i1 = i2;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "getTargetType targetType = " + i1 + ", hotword = " + paramString1 + ", text = " + paramString2 + ", fileName = " + paramString3 + ", extension = " + paramString4 + ", contentType = " + paramInt);
      }
      return i1;
      label135:
      if ((paramString3 != null) && (paramString3.toLowerCase().contains(str)))
      {
        i1 = 1;
      }
      else if ((paramString4 != null) && (paramString4.toLowerCase().contains(str)))
      {
        i1 = 2;
      }
      else
      {
        i1 = 3;
        continue;
        label187:
        i1 = 1;
      }
    }
  }
  
  public String a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    String str;
    if (paramString1 == null) {
      str = null;
    }
    do
    {
      do
      {
        do
        {
          return str;
          str = paramString1;
        } while (paramString2 == null);
        str = paramString1;
      } while (paramString1.length() <= paramInt1);
      paramInt2 = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      if (paramInt2 == -1) {
        return paramString1.substring(0, paramInt1) + "…";
      }
      str = paramString1;
    } while (paramString2.length() >= paramString1.length());
    if (paramString2.length() + paramInt2 == paramString1.length()) {
      return "…" + paramString1.substring(paramString1.length() - paramInt1, paramString1.length());
    }
    if (paramInt2 == 0) {
      return paramString1.substring(0, paramInt2 + paramInt1) + "…";
    }
    if (paramString1.length() - paramInt2 > paramInt1 - 1) {
      return "…" + paramString1.substring(paramInt2, paramInt2 + paramInt1) + "…";
    }
    return "…." + paramString1.substring(paramString1.length() - paramInt1, paramString1.length());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (TextUtils.isEmpty(this.e)) {
      return;
    }
    Object localObject;
    label52:
    long l1;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label127;
      }
      if (this.jdField_c_of_type_JavaLangString == null)
      {
        this.jdField_c_of_type_JavaLangString = this.e;
        this.jdField_d_of_type_JavaLangString = null;
      }
      l1 = System.currentTimeMillis();
      if (!jdField_a_of_type_JavaUtilHashMap.containsKey(this.f)) {
        break label129;
      }
      localObject = (SpannableString)jdField_a_of_type_JavaUtilHashMap.get(this.f);
    }
    for (;;)
    {
      super.setText((CharSequence)localObject, TextView.BufferType.SPANNABLE);
      return;
      localObject = null;
      break label52;
      label127:
      break;
      label129:
      paramInt1 = getWidth();
      TextPaint localTextPaint = getPaint();
      paramInt2 = a(this.jdField_c_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_d_of_type_JavaLangString);
      String str = a(paramInt2, this.jdField_c_of_type_JavaLangString, (String)localObject, paramInt1, localTextPaint, this.jdField_d_of_type_JavaLangString);
      localObject = a(str, this.jdField_a_of_type_JavaUtilArrayList, this.o);
      jdField_a_of_type_JavaUtilHashMap.put(this.f, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "type = " + paramInt2 + ", displayText = " + str + ", text = " + this.e + ", viewWidth = " + paramInt1 + ", new = " + localTextPaint.measureText(str) + ", old = " + localTextPaint.measureText(this.e) + ", onLayout t = " + (System.currentTimeMillis() - l1));
      }
    }
  }
  
  public void setContentType(int paramInt1, int paramInt2)
  {
    this.b = paramInt2;
    this.jdField_c_of_type_Int = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("SingleLineHotwordTextView", 2, "setContentType text = " + this.e);
    }
    String str2 = this.e;
    this.jdField_c_of_type_JavaLangString = str2;
    this.jdField_d_of_type_JavaLangString = null;
    String str1;
    if (paramInt1 == 1)
    {
      str1 = FileUtil.a(str2);
      if (!TextUtils.isEmpty(str1))
      {
        paramInt1 = str2.toLowerCase().lastIndexOf(str1.toLowerCase());
        if (paramInt1 > -1)
        {
          this.jdField_c_of_type_JavaLangString = str2.substring(0, paramInt1);
          this.jdField_d_of_type_JavaLangString = str1;
          if (str1.length() > 1) {
            this.jdField_d_of_type_JavaLangString = str1.substring(1);
          }
        }
        if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label274;
        }
        str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        this.jdField_d_of_type_Int = a(str1, str2, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_Int);
        if (this.jdField_d_of_type_Int != 3) {
          break label279;
        }
        this.jdField_c_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + "." + this.jdField_d_of_type_JavaLangString);
        this.jdField_d_of_type_JavaLangString = null;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SingleLineHotwordTextView", 2, "setContentType name = " + this.jdField_c_of_type_JavaLangString + ", extension = " + this.jdField_d_of_type_JavaLangString);
      }
      return;
      label274:
      str1 = null;
      break;
      label279:
      this.jdField_d_of_type_JavaLangString = a(this.jdField_d_of_type_JavaLangString, str1, this.b, this.jdField_d_of_type_Int);
      if ((this.jdField_d_of_type_Int == 2) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (str1 != null) && (str1.length() > this.b))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void setHotword(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void setHotword(ArrayList paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.o = paramInt;
  }
  
  public void setHotwords(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SingleLineHotwordTextView", 2, "setText text = " + paramCharSequence);
    }
    this.e = paramCharSequence.toString();
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.b = 2147483647;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.f = a(this.e, this.jdField_a_of_type_JavaUtilArrayList);
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.f))
    {
      super.setText((SpannableString)jdField_a_of_type_JavaUtilHashMap.get(this.f), paramBufferType);
      return;
    }
    super.setText(paramCharSequence, paramBufferType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView
 * JD-Core Version:    0.7.0.1
 */