import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;

public class vvf
{
  private static volatile vvf a;
  
  public static vvf a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new vvf();
      }
      return a;
    }
    finally {}
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      QLog.e("QCircleHybirdStyleFactory", 1, "getIntentByParseUrl intent is null");
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
        QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getQueryParameter("_wv");
        if (!TextUtils.isEmpty(paramString))
        {
          long l = Long.parseLong(paramString);
          if ((l & 0x80000) != 0L) {
            return true;
          }
        }
        return false;
      }
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return false;
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext)
  {
    if (paramContext == null) {
      QLog.d("QCircleHybirdStyleFactory", 1, "context is null");
    }
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    localQCircleWebViewTitleStyle.b = paramContext.getResources().getColor(2131166234);
    localQCircleWebViewTitleStyle.c = paramContext.getResources().getColor(2131166234);
    localQCircleWebViewTitleStyle.d = paramContext.getResources().getColor(2131165343);
    localQCircleWebViewTitleStyle.e = paramContext.getResources().getColor(2131165343);
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
          paramContext.a = Integer.parseInt(paramString);
        }
      }
      return paramContext;
    }
    catch (Exception paramString)
    {
      QLog.e("QCircleHybirdStyleFactory", 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvf
 * JD-Core Version:    0.7.0.1
 */