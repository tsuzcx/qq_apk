import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.applist.WebAppActivity;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;

public class hlk
  implements View.OnClickListener
{
  public hlk(WebAppActivity paramWebAppActivity) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (paramView == this.a.jdField_a_of_type_AndroidWidgetImageView)
      {
        if (!this.a.jdField_a_of_type_ComTencentSmttSdkWebView.canGoBack()) {
          return;
        }
        this.a.jdField_a_of_type_ComTencentSmttSdkWebView.goBack();
        return;
      }
      if (paramView == this.a.b)
      {
        this.a.jdField_a_of_type_ComTencentSmttSdkWebView.goForward();
        return;
      }
    }
    catch (Exception paramView)
    {
      LogUtility.c("WebAppActivity", "onClick", paramView);
      return;
    }
    if (paramView == this.a.c)
    {
      this.a.jdField_a_of_type_ComTencentSmttSdkWebView.reload();
      return;
    }
    if (paramView == this.a.d) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     hlk
 * JD-Core Version:    0.7.0.1
 */