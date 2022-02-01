import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.style.QCircleWebViewTitleStyle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FadeIconImageView;
import com.tencent.widget.immersive.ImmersiveUtils;

public class vlv
  extends bhmv
{
  public vlv(bhql parambhql)
  {
    super(parambhql);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    }
    if (this.jdField_a_of_type_Bhql.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar != null) {
      this.jdField_a_of_type_Bhql.jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidViewView.getContext()) + zby.b(this.jdField_a_of_type_AndroidViewView.getContext(), 52.0F), 0, 0);
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
        if (this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity.getResources();
        if (!this.jdField_a_of_type_Bhqo.m)
        {
          this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundColor(uxx.b(false));
          if ((this.jdField_a_of_type_Bhql.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment != null) && (this.jdField_a_of_type_Bhql.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSystemBarComp != null))
          {
            ImmersiveUtils.a(true, this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity.getWindow());
            this.jdField_a_of_type_Bhql.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mSystemBarComp.setBackgroundColor(uxx.b(false));
          }
        }
        if ((this.jdField_a_of_type_Bhqo.a instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.jdField_a_of_type_Bhqo.a).a)
        {
        case 0: 
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843979));
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setBackgroundResource(2130843994);
          i = zlx.a(BaseApplicationImpl.getContext(), 14.0F);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
          localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = zby.b(this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).width = zby.b(this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity, 52.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(zby.b(this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity, 8.0F), 0, zby.b(this.jdField_a_of_type_Bhql.jdField_a_of_type_AndroidAppActivity, 8.0F), 0);
          ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
          this.c.setTextColor(-16777216);
          this.b.setTextColor(-16777216);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        int i;
        QLog.e("WebLog_SwiftIphoneTitleBarUI", 1, "initDefaultThemeTitleBar error" + localException.getMessage());
        localException.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(((Resources)localObject).getDrawable(2130843979));
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setBackgroundResource(2130843994);
      i = zlx.a(BaseApplicationImpl.getContext(), 14.0F);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setPadding(i, i, i, i);
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843889));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843890));
      continue;
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setImageDrawable(localException.getDrawable(2130843891));
    }
  }
  
  public void c()
  {
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlv
 * JD-Core Version:    0.7.0.1
 */