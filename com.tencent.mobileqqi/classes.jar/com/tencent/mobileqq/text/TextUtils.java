package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class TextUtils
{
  private static final String a = "TextUtils";
  
  public static final Drawable a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130839942;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < EmotcationConstants.e) {
        i = 2130839808 + paramInt;
      }
    }
    if (BaseApplicationImpl.a != null) {
      return BaseApplicationImpl.a(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static final Drawable a(int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    Object localObject = BaseApplicationImpl.getContext().getResources();
    if (!paramBoolean)
    {
      paramInt = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
      if (BaseApplicationImpl.a != null) {
        return BaseApplicationImpl.a((Resources)localObject, paramInt);
      }
      return ((Resources)localObject).getDrawable(paramInt);
    }
    int i = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
    try
    {
      URL localURL1 = new URL("emotion", ((Resources)localObject).getResourceEntryName(2130838784 + paramInt), "");
      String str = localURL1.toString();
      if (BaseApplicationImpl.a.get(str) != null)
      {
        localObject = new ColorDrawable();
        return URLDrawable.getDrawable(localURL1, (Drawable)localObject, (Drawable)localObject, true);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      URL localURL2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TextUtils", 2, "getDrawable ,", localMalformedURLException);
        }
        localURL2 = null;
      }
      localObject = ((Resources)localObject).getDrawable(i);
      return URLDrawable.getDrawable(localURL2, (Drawable)localObject, (Drawable)localObject, true);
    }
  }
  
  public static final String a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_ArrayOfInt.length)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(Character.toChars(EmotcationConstants.jdField_b_of_type_ArrayOfInt[paramInt]));
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    String str;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int k;
    do
    {
      return str;
      i = 0;
      while (i < EmotcationConstants.jdField_b_of_type_ArrayOfInt.length)
      {
        k = paramString.indexOf(EmotcationConstants.jdField_b_of_type_ArrayOfInt[i], 0);
        str = paramString;
        if (k != -1)
        {
          str = paramString;
          if (k + 2 <= paramString.length()) {
            str = paramString.replace(paramString.substring(k, k + 2), "");
          }
        }
        i += 1;
        paramString = str;
      }
      str = paramString;
    } while (!a(paramString));
    paramString = new StringBuilder(paramString);
    for (int i = j; i < paramString.length(); i = j + 1)
    {
      j = i;
      if (paramString.codePointAt(i) == 20)
      {
        j = i;
        if (i < paramString.length() - 1)
        {
          k = paramString.charAt(i + 1);
          j = i;
          if (k < EmotcationConstants.jdField_b_of_type_Int)
          {
            str = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[k];
            paramString.replace(i, i + 2, str);
            j = i + (str.length() - 1);
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public static final void a(EditText paramEditText)
  {
    Editable localEditable = paramEditText.getText();
    int i = paramEditText.getSelectionStart();
    int j = android.text.TextUtils.getOffsetBefore(paramEditText.getText(), i);
    if (i != j) {
      localEditable.delete(Math.min(i, j), Math.max(i, j));
    }
  }
  
  public static boolean a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    while (-1 == paramString.indexOf('\024')) {
      return false;
    }
    return true;
  }
  
  public static final String b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return String.valueOf(new char[] { '\024', (char)paramInt });
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils
 * JD-Core Version:    0.7.0.1
 */