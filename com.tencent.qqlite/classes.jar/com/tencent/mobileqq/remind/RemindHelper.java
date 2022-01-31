package com.tencent.mobileqq.remind;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.IosTimepicker.OnTimePickerSelectListener;
import com.tencent.mobileqq.webviewplugin.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import ear;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class RemindHelper
{
  public static String a;
  public static boolean a = false;
  public static String b;
  public static final String c = "url";
  public static final String d = "uin";
  public static final String e = "uin_name";
  public static final String f = "uin_type";
  private static String g = "remind";
  
  static
  {
    jdField_a_of_type_JavaLangString = "1";
    b = "0";
    jdField_a_of_type_Boolean = true;
  }
  
  public static Long a(String paramString)
  {
    long l2 = new Date().getTime() / 1000L;
    try
    {
      l1 = Long.valueOf(paramString).longValue();
      return Long.valueOf(l1);
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d(g, 2, "getLong error: " + paramString.getMessage());
          paramString.printStackTrace();
          l1 = l2;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = "";
    try
    {
      paramString1 = new JSONObject(paramString1).optString(paramString2);
      return paramString1;
    }
    catch (JSONException paramString2)
    {
      do
      {
        paramString1 = str;
      } while (!QLog.isColorLevel());
      QLog.d(g, 2, "getString from json error:" + paramString2.getMessage());
    }
    return "";
  }
  
  public static void a(Context paramContext, long paramLong, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, JsBridgeListener paramJsBridgeListener)
  {
    Object localObject = LayoutInflater.from(paramContext);
    ActionSheet localActionSheet;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localActionSheet = (ActionSheet)ActionSheetHelper.a(paramContext, null, 2131624119);
      ((DispatchActionMoveScrollView)localActionSheet.findViewById(2131296499)).jdField_a_of_type_Boolean = true;
      localObject = (IosTimepicker)((LayoutInflater)localObject).inflate(2130903694, null);
      ((IosTimepicker)localObject).setMaxDays(25568);
      ((IosTimepicker)localObject).a(paramContext, localActionSheet, paramLong, paramOnTimePickerSelectListener, null);
      if (Build.VERSION.SDK_INT >= 11) {
        localActionSheet.getWindow().setFlags(16777216, 16777216);
      }
      localActionSheet.b((View)localObject, null);
      localActionSheet.setOnDismissListener(new ear((IosTimepicker)localObject, paramJsBridgeListener));
    }
    try
    {
      localActionSheet.show();
      return;
    }
    catch (Throwable paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(g, 2, paramContext.getMessage());
    }
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong1, long paramLong2)
  {
    return new CalendarHelper(paramContext).a(paramString, paramLong1, paramLong2);
  }
  
  public static boolean a(String paramString)
  {
    return paramString.equalsIgnoreCase(jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.RemindHelper
 * JD-Core Version:    0.7.0.1
 */