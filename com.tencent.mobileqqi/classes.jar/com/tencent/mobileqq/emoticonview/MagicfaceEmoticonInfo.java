package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class MagicfaceEmoticonInfo
  extends EmoticonInfo
{
  private static final ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  private static final Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final Drawable b;
  private static final String i = "MagicfaceEmoticonInfo";
  public Emoticon a;
  public String h;
  private String j;
  
  static
  {
    Resources localResources = BaseApplication.getContext().getResources();
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = localResources.getDrawable(2130839112);
    b = localResources.getDrawable(2130839113);
  }
  
  public MagicfaceEmoticonInfo() {}
  
  public MagicfaceEmoticonInfo(String paramString)
  {
    this.j = paramString;
  }
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "panel_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.j);
        paramContext.addHeader("emo_tasks", Integer.toString(2));
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceEmoticonInfo", 2, "getDrawable ,", paramContext);
          }
          paramContext = null;
        }
      }
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo) {}
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) {
      try
      {
        paramContext = new URL("emotion_pic", "panel_preview", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        paramContext = URLDrawable.getDrawable(paramContext, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, false);
        paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        paramContext.addHeader("my_uin", this.j);
        paramContext.addHeader("emo_tasks", Integer.toString(2));
        return paramContext;
      }
      catch (MalformedURLException paramContext)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MagicfaceEmoticonInfo", 2, "getDrawable ,", paramContext);
          }
          paramContext = null;
        }
      }
    }
    return jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicfaceEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */