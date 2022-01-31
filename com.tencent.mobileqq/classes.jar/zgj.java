import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.UrlCheckPlugin.1;
import com.tencent.biz.webviewplugin.UrlCheckPlugin.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class zgj
  extends WebViewPlugin
{
  public static int a;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = null;
  WindowManager jdField_a_of_type_AndroidViewWindowManager = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  CustomWebView jdField_a_of_type_ComTencentBizPubaccountCustomWebView = null;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  public Runnable a;
  public nad a;
  boolean jdField_a_of_type_Boolean = false;
  public int e = jdField_a_of_type_Int;
  int f = 0;
  int g = 0;
  int h = 0;
  
  public zgj()
  {
    this.jdField_a_of_type_JavaLangRunnable = new UrlCheckPlugin.4(this);
    this.mPluginNameSpace = "URL_CHECK";
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Nad == null) {
      this.jdField_a_of_type_Nad = new nad(this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView, new zgk(this));
    }
  }
  
  public void a()
  {
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.e == c))
    {
      localObject = ((Activity)localObject).getWindowManager();
      this.e = d;
    }
    try
    {
      ((WindowManager)localObject).removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "removeView Error:" + localIllegalArgumentException.getMessage());
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.mRuntime.a();
    if (!(localObject instanceof BaseActivity)) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
        continue;
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)localObject);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131558964, null));
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378113));
        this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131378107));
        this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager();
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
      }
      try
      {
        i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 49;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (i + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.type = 1002;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.flags = 262664;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = -1;
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = -2;
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zgl(this));
        }
        if (this.jdField_a_of_type_AndroidViewWindowManager == null) {
          this.jdField_a_of_type_AndroidViewWindowManager = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager();
        }
        if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getText(paramInt));
        }
        this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.h + this.g);
        this.e = c;
        try
        {
          this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
          return;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(this.TAG, 2, "addView exception:" + localException1.getMessage());
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i = (int)(localException1.getDisplayMetrics().density * 25.0F + 0.5D);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView = this.mRuntime.a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramString = this.mRuntime.a();
        } while (!(paramString instanceof BaseActivity));
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramString);
        b();
        if (paramLong != 8589934597L) {
          break;
        }
        if (this.jdField_a_of_type_Nad != null)
        {
          this.jdField_a_of_type_Nad.a();
          this.jdField_a_of_type_Nad = null;
        }
      } while ((this.e != c) || (this.jdField_a_of_type_AndroidWidgetImageView == null));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      a();
      return false;
    } while ((paramLong != 8589934594L) || (this.f != 2) || (this.e == c));
    this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.postDelayed(new UrlCheckPlugin.1(this), this.g);
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Nad != null)
    {
      this.jdField_a_of_type_Nad.a();
      this.jdField_a_of_type_Nad = null;
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zgj
 * JD-Core Version:    0.7.0.1
 */