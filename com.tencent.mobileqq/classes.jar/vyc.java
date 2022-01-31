import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.BabyQAIOPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BabyQObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class vyc
  extends BabyQObserver
{
  public vyc(FriendChatPie paramFriendChatPie) {}
  
  protected void a()
  {
    if (this.a.q != null)
    {
      Animation localAnimation = this.a.q.getAnimation();
      if (localAnimation != null) {
        localAnimation.cancel();
      }
      FriendChatPie.b(this.a).removeView(this.a.q);
      this.a.q = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.BabyQ", 2, "onStopGuide");
      }
    }
  }
  
  protected void a(Object paramObject)
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
        ((BabyQHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).b();
      }
      break;
    }
    do
    {
      do
      {
        return;
        if ((FriendChatPie.a(this.a) != null) && (FriendChatPie.b(this.a).getVisibility() == 0)) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(AIOPanelUtiles.g);
        break;
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(AIOPanelUtiles.m);
        break;
        if (ShortVideoUtils.f())
        {
          i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(AIOPanelUtiles.j);
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(AIOPanelUtiles.m);
        break;
        if ((FriendChatPie.a(this.a) != null) && (FriendChatPie.b(this.a).getVisibility() == 0)) {
          break;
        }
        i = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a().indexOf(AIOPanelUtiles.a);
        break;
      } while (this.a.q != null);
      this.a.q = new View(this.a.jdField_a_of_type_AndroidContentContext);
      this.a.q.setBackgroundResource(2130842346);
      Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getChildAt(i);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(((View)localObject).getHeight(), ((View)localObject).getHeight());
      localLayoutParams.addRule(12);
      localLayoutParams.setMargins(((View)localObject).getLeft() + ((View)localObject).getWidth() / 2 - ((View)localObject).getHeight() / 2, 0, 0, (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() - ((View)localObject).getHeight()) / 2);
      FriendChatPie.a(this.a).addView(this.a.q, localLayoutParams);
      localObject = AnimationUtils.loadAnimation(this.a.jdField_a_of_type_AndroidContentContext, 2131034320);
      ((Animation)localObject).setAnimationListener(new vyd(this));
      this.a.q.startAnimation((Animation)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.BabyQ", 2, "onStartGuide " + paramObject);
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioBabyQAIOPanel.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vyc
 * JD-Core Version:    0.7.0.1
 */