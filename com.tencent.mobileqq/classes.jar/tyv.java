import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;

public class tyv
{
  public static final String a;
  private static volatile tyv a;
  
  static
  {
    jdField_a_of_type_JavaLangString = tyv.class.getSimpleName();
  }
  
  public static tyv a()
  {
    if (jdField_a_of_type_Tyv == null) {}
    try
    {
      if (jdField_a_of_type_Tyv == null) {
        jdField_a_of_type_Tyv = new tyv();
      }
      return jdField_a_of_type_Tyv;
    }
    finally {}
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getIntentByParseUrl intent is null");
    }
    for (;;)
    {
      return;
      try
      {
        paramString = Uri.parse(paramString);
        if (paramString != null)
        {
          if ("1".equals(paramString.getQueryParameter("show_right_cancel"))) {
            paramIntent.putExtra("rightTopCancel", true);
          }
          if ("1".equals(paramString.getQueryParameter("move_web_view_top")))
          {
            paramIntent.putExtra("webViewMoveTop", true);
            return;
          }
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getStyleFromUrl error " + paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext)
  {
    if (paramContext == null) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "context is null");
    }
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    localQCircleWebViewTitleStyle.b = paramContext.getResources().getColor(2131166178);
    localQCircleWebViewTitleStyle.c = paramContext.getResources().getColor(2131166178);
    localQCircleWebViewTitleStyle.d = paramContext.getResources().getColor(2131165307);
    localQCircleWebViewTitleStyle.e = paramContext.getResources().getColor(2131165307);
    return localQCircleWebViewTitleStyle;
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("left_back_icon");
        if (!TextUtils.isEmpty(paramString)) {
          paramContext.a = Integer.valueOf(paramString).intValue();
        }
      }
      return paramContext;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyv
 * JD-Core Version:    0.7.0.1
 */