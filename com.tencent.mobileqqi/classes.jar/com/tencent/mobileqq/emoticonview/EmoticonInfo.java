package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class EmoticonInfo
{
  public static final String c = "delete";
  public static final String d = "setting";
  public static final String e = "add";
  public static final String f = "show_fav_menu";
  public static final String g = "donothing";
  EmoticonCallback a;
  public String a;
  public int b = -1;
  public String b;
  public int c;
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    return b(paramContext, paramFloat);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public void a(EmoticonCallback paramEmoticonCallback)
  {
    this.a = paramEmoticonCallback;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return BaseApplicationImpl.a(paramContext.getResources(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonInfo
 * JD-Core Version:    0.7.0.1
 */