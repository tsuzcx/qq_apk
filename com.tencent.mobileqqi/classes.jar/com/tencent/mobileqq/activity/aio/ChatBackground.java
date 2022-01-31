package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.QLog;

public class ChatBackground
{
  public static final int a = -1;
  public static final int b = -10395552;
  public ColorStateList a;
  public Drawable a;
  public String a;
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0).edit();
    if (paramString2 == null)
    {
      paramContext.clear();
      paramContext.putString("chat_uniform_bg", paramString3);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString2, paramString3);
    }
  }
  
  public static final boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ChatBackground paramChatBackground)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString2 = localSharedPreferences.getString(paramString2, null);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString2 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "null";
      }
    }
    if (paramChatBackground.jdField_a_of_type_JavaLangString != paramString1)
    {
      if (("".equals(paramString1)) || ("null".equals(paramString1)))
      {
        paramChatBackground.jdField_a_of_type_JavaLangString = "null";
        paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131362081);
      }
      for (;;)
      {
        try
        {
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837756);
          return true;
        }
        catch (Exception paramString1)
        {
          if (QLog.isColorLevel()) {
            paramString1.printStackTrace();
          }
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840057);
          continue;
        }
        if ("none".equals(paramString1))
        {
          paramChatBackground.jdField_a_of_type_JavaLangString = "none";
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-10395552);
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837752);
        }
        else
        {
          paramString2 = new BitmapFactory.Options();
          paramString2.inPreferredConfig = Bitmap.Config.RGB_565;
          paramString2 = BitmapManager.a(paramString1, paramString2);
          if (paramString2 != null)
          {
            paramChatBackground.jdField_a_of_type_JavaLangString = paramString1;
            paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), paramString2);
            paramContext = "chat_backgournd_nickname_color." + paramString1;
            if (localSharedPreferences.contains(paramContext))
            {
              paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(localSharedPreferences.getInt(paramContext, -10395552));
            }
            else
            {
              int i = a(paramString2);
              paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(i);
              localSharedPreferences.edit().putInt(paramContext, i).commit();
            }
          }
          else
          {
            paramChatBackground.jdField_a_of_type_JavaLangString = "null";
            paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131362081);
            try
            {
              paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837756);
            }
            catch (Exception paramString1)
            {
              if (QLog.isColorLevel()) {
                paramString1.printStackTrace();
              }
              paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840057);
            }
          }
        }
      }
    }
    return false;
  }
  
  public static final void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0).edit();
    if (paramString2 == null)
    {
      paramContext.clear();
      paramContext.putString("chat_uniform_bg", paramString3);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString2, paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */