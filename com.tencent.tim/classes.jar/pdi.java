import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.qphone.base.util.QLog;

public class pdi
{
  public static final String TAG = pdi.class.getSimpleName();
  private static volatile pdi a;
  
  public static pdi a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pdi();
      }
      return a;
    }
    finally {}
  }
  
  public static void g(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      QLog.e(TAG, 1, "getIntentByParseUrl intent is null");
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
        QLog.e(TAG, 1, "getStyleFromUrl error " + paramIntent.getMessage());
        paramIntent.printStackTrace();
      }
    }
  }
  
  public QCircleWebViewTitleStyle a(Context paramContext)
  {
    if (paramContext == null) {
      QLog.d(TAG, 1, "context is null");
    }
    QCircleWebViewTitleStyle localQCircleWebViewTitleStyle = new QCircleWebViewTitleStyle();
    localQCircleWebViewTitleStyle.statusBarColor = paramContext.getResources().getColor(2131166508);
    localQCircleWebViewTitleStyle.wP = paramContext.getResources().getColor(2131166508);
    localQCircleWebViewTitleStyle.titleColor = paramContext.getResources().getColor(2131165381);
    localQCircleWebViewTitleStyle.edP = paramContext.getResources().getColor(2131165381);
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
          paramContext.bht = Integer.valueOf(paramString).intValue();
        }
      }
      return paramContext;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, "getStyleFromUrl error " + paramString.getMessage());
      paramString.printStackTrace();
    }
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pdi
 * JD-Core Version:    0.7.0.1
 */