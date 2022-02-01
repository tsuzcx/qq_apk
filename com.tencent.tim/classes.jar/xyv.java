import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class xyv
  extends acbw
{
  xyv(xys paramxys) {}
  
  protected void aH(Object paramObject)
  {
    int i = -1;
    paramObject = (Integer)paramObject;
    switch (paramObject.intValue())
    {
    default: 
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject + " but panel is opened");
        }
        ((acbs)this.this$0.app.getBusinessHandler(53)).cGZ();
      }
      break;
    }
    do
    {
      do
      {
        return;
        if ((xys.a(this.this$0) != null) && (xys.b(this.this$0).getVisibility() == 0)) {
          break;
        }
        i = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK().indexOf(xro.hL);
        break;
        i = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK().indexOf(xro.hV);
        break;
        if (ShortVideoUtils.awN())
        {
          i = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK().indexOf(xro.hS);
          break;
        }
        i = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK().indexOf(xro.hV);
        break;
        if ((xys.a(this.this$0) != null) && (xys.b(this.this$0).getVisibility() == 0)) {
          break;
        }
        i = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.bK().indexOf(xro.hz);
        break;
      } while (this.this$0.xn != null);
      this.this$0.xn = new View(this.this$0.mContext);
      this.this$0.xn.setBackgroundResource(2130845822);
      Object localObject = this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      xys.a(this.this$0).addView(this.this$0.xn, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.this$0.mContext, 2130772298);
      ((Animation)localObject).setAnimationListener(new xyw(this));
      this.this$0.xn.startAnimation((Animation)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject);
  }
  
  protected void cgl()
  {
    if (this.this$0.xn != null)
    {
      Animation localAnimation = this.this$0.xn.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      xys.b(this.this$0).removeView(this.this$0.xn);
      this.this$0.xn = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  protected void zL(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null)) {
      this.this$0.jdField_b_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.bYN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xyv
 * JD-Core Version:    0.7.0.1
 */