import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class ucy
  extends bebk
{
  public ucy(beey parambeey)
  {
    super(parambeey);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()) + xee.b(this.jdField_a_of_type_AndroidViewView.getContext(), 50.0F), 0, 0);
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
        if (this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity.getResources();
        if (!this.jdField_a_of_type_Befb.m)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(tra.b(false));
          if ((this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d != null))
          {
            ImmersiveUtils.a(true, this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity.getWindow());
            this.jdField_a_of_type_Beey.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.d.setBackgroundColor(tra.b(false));
          }
        }
        if ((this.jdField_a_of_type_Befb.a instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.jdField_a_of_type_Befb.a).a)
        {
        case 0: 
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843675));
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = xee.b(this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).width = xee.b(this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(xee.b(this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidAppActivity, 5.0F), 0, 0, 0);
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
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843675));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843528));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843529));
    }
  }
  
  public void c()
  {
    super.c();
    if ((this.jdField_a_of_type_Beey.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Beey.jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.jdField_a_of_type_Beey.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Beey.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucy
 * JD-Core Version:    0.7.0.1
 */