package com.tencent.mobileqq.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.MQLruCache;
import android.text.Editable;
import android.util.Pair;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.emoji.EmojiUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class TextUtils
{
  private static final String a = "TextUtils";
  
  public static final int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
  }
  
  public static final Drawable a(int paramInt)
  {
    if ((EmotcationConstants.jdField_b_of_type_JavaLangString == null) || (EmotcationConstants.jdField_b_of_type_JavaLangString.equals(""))) {
      EmotcationConstants.jdField_b_of_type_JavaLangString = EmojiUtil.a(BaseApplicationImpl.getContext());
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("invaid emoji index: " + paramInt);
    }
    int j = 2130838021;
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < EmotcationConstants.f)
      {
        Object localObject = new File(EmotcationConstants.jdField_b_of_type_JavaLangString);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          String str = new DecimalFormat("000").format(paramInt + 0);
          localObject = null;
          if (BaseApplicationImpl.a != null) {
            localObject = a(BaseApplicationImpl.getContext().getResources(), str);
          }
          if (localObject != null) {
            return localObject;
          }
        }
        i = 2130838020;
      }
    }
    if (BaseApplicationImpl.a != null) {
      return a(BaseApplicationImpl.getContext().getResources(), i);
    }
    return BaseApplicationImpl.getContext().getResources().getDrawable(i);
  }
  
  public static final Drawable a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    if (!paramBoolean)
    {
      paramInt = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
      if (BaseApplicationImpl.a != null) {
        localObject1 = a(localResources, paramInt);
      }
    }
    for (;;)
    {
      return localObject1;
      return localResources.getDrawable(paramInt);
      int i = EmotcationConstants.jdField_a_of_type_ArrayOfInt[paramInt];
      try
      {
        Object localObject2 = new URL("emotion", localResources.getResourceEntryName(2130837760 + paramInt), "");
        if (localObject2 == null) {
          continue;
        }
        localObject1 = ((URL)localObject2).toString();
        if (BaseApplicationImpl.a.get(localObject1) != null)
        {
          localObject1 = new ColorDrawable();
          localObject2 = URLDrawable.getDrawable((URL)localObject2, (Drawable)localObject1, (Drawable)localObject1, true);
          localObject1 = localObject2;
          if (localObject2 == null) {
            continue;
          }
          ((URLDrawable)localObject2).addHeader("faceIdx", Integer.toString(paramInt));
          return localObject2;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TextUtils", 2, "getDrawable ,", localMalformedURLException);
          }
          Object localObject3 = null;
          continue;
          localObject1 = localResources.getDrawable(i);
          localObject3 = URLDrawable.getDrawable((URL)localObject3, (Drawable)localObject1, (Drawable)localObject1, true);
        }
      }
    }
  }
  
  public static Drawable a(Resources paramResources, int paramInt)
  {
    String str = "android.resource://" + paramInt;
    Object localObject = (Pair)BaseApplicationImpl.a.get(str);
    if (localObject != null) {
      paramResources = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramResources);
    }
    do
    {
      return paramResources;
      localObject = paramResources.getDrawable(paramInt);
      paramInt = SkinUtils.a((Drawable)localObject);
      paramResources = (Resources)localObject;
    } while (paramInt <= 0);
    BaseApplicationImpl.a.put(str, new Pair(((Drawable)localObject).getConstantState(), Integer.valueOf(paramInt)));
    return localObject;
  }
  
  public static Drawable a(Resources paramResources, String paramString)
  {
    String str = "android.resource://" + paramString;
    Pair localPair = (Pair)BaseApplicationImpl.a.get(str);
    if (localPair != null) {
      paramString = ((Drawable.ConstantState)localPair.first).newDrawable(paramResources);
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramResources = Drawable.createFromPath(EmotcationConstants.jdField_b_of_type_JavaLangString + "emoji_" + paramString + ".png");
        int i = SkinUtils.a(paramResources);
        paramString = paramResources;
        if (i <= 0) {
          continue;
        }
        BaseApplicationImpl.a.put(str, new Pair(paramResources.getConstantState(), Integer.valueOf(i)));
        return paramResources;
      }
      catch (OutOfMemoryError paramResources)
      {
        for (;;)
        {
          BaseApplicationImpl.a.trimToSize(BaseApplicationImpl.a.size() / 2);
          System.gc();
          Thread.yield();
          System.gc();
          try
          {
            paramResources = Drawable.createFromPath(EmotcationConstants.jdField_b_of_type_JavaLangString + "emoji_" + paramString + ".png");
          }
          catch (OutOfMemoryError paramResources)
          {
            paramResources = null;
          }
        }
      }
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
  
  public static String b(String paramString)
  {
    String str;
    if (android.text.TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!a(paramString));
    paramString = new StringBuilder(paramString);
    int j;
    for (int i = 0; i < paramString.length(); i = j + 1)
    {
      j = i;
      if (paramString.codePointAt(i) == 20)
      {
        j = i;
        if (i < paramString.length() - 1)
        {
          int k = paramString.charAt(i + 1);
          if (k >= EmotcationConstants.jdField_b_of_type_Int)
          {
            j = i;
            if (250 != k) {}
          }
          else
          {
            j = k;
            if (250 == k) {
              j = 10;
            }
            str = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[j];
            paramString.replace(i, i + 2, str);
            j = i + (str.length() - 1);
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public static final String c(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= EmotcationConstants.jdField_b_of_type_Int)) {
      throw new IllegalArgumentException("invaid sys emotcation index: " + paramInt);
    }
    return EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.text.TextUtils
 * JD-Core Version:    0.7.0.1
 */