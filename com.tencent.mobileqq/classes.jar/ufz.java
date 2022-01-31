import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ufz
  extends beft
{
  public ufz(bejh parambejh)
  {
    super(parambejh);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()) + xin.b(this.jdField_a_of_type_AndroidViewView.getContext(), 50.0F), 0, 0);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      }
      super.a(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "setWarnToastVisible error");
        localException.printStackTrace();
      }
    }
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getResources();
        if (!this.jdField_a_of_type_Bejk.m)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(tra.b(false));
          if ((this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null))
          {
            ImmersiveUtils.a(true, this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity.getWindow());
            this.jdField_a_of_type_Bejh.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(tra.b(false));
          }
        }
        if ((this.jdField_a_of_type_Bejk.a instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.jdField_a_of_type_Bejk.a).a)
        {
        case 0: 
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843739));
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = xin.b(this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).width = xin.b(this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(xin.b(this.jdField_a_of_type_Bejh.jdField_a_of_type_AndroidAppActivity, 5.0F), 0, 0, 0);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.c.setTextColor(-16777216);
          this.b.setTextColor(-16777216);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + localException.getMessage());
        localException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843739));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843541));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843542));
    }
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufz
 * JD-Core Version:    0.7.0.1
 */