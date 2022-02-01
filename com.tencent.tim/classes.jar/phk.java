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

public class phk
  extends aqzl
{
  public phk(arcd paramarcd)
  {
    super(paramarcd);
  }
  
  public void bkY()
  {
    if (this.aK != null) {
      this.aK.setVisibility(8);
    }
    if (this.jdField_a_of_type_Arcd.mLoadingProgressBar != null) {
      this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
    }
  }
  
  public void bkZ()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Arcd.s == null) {
          break;
        }
        localObject = this.jdField_a_of_type_Arcd.s.getResources();
        if (!this.jdField_a_of_type_Arcd$a.cYw)
        {
          this.aK.setBackgroundColor(ovd.p(false));
          if ((this.jdField_a_of_type_Arcd.c != null) && (this.jdField_a_of_type_Arcd.c.Js != null))
          {
            ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_Arcd.s.getWindow());
            this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(ovd.p(false));
          }
        }
        if ((this.jdField_a_of_type_Arcd$a.a instanceof QCircleWebViewTitleStyle)) {}
        switch (((QCircleWebViewTitleStyle)this.jdField_a_of_type_Arcd$a.a).bht)
        {
        case 0: 
          this.d.setImageDrawable(((Resources)localObject).getDrawable(2130844964));
          localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).height = riw.dip2px(this.jdField_a_of_type_Arcd.s, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).width = riw.dip2px(this.jdField_a_of_type_Arcd.s, 50.0F);
          ((RelativeLayout.LayoutParams)localObject).setMargins(riw.dip2px(this.jdField_a_of_type_Arcd.s, 5.0F), 0, 0, 0);
          this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.d.setVisibility(0);
          this.leftView.setVisibility(8);
          this.rightViewText.setTextColor(-16777216);
          this.centerView.setTextColor(-16777216);
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
      this.d.setImageDrawable(((Resources)localObject).getDrawable(2130844964));
      continue;
      this.d.setImageDrawable(localException.getDrawable(2130844757));
      continue;
      this.d.setImageDrawable(localException.getDrawable(2130844758));
    }
  }
  
  public void bla()
  {
    super.bla();
  }
  
  public void c(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      if (this.Jo != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.Jo.getLayoutParams();
        localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(this.Jo.getContext()) + riw.dip2px(this.Jo.getContext(), 50.0F), 0, 0);
        this.Jo.setLayoutParams(localLayoutParams);
      }
      super.c(paramBoolean, paramInt1, paramInt2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     phk
 * JD-Core Version:    0.7.0.1
 */