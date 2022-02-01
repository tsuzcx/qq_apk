import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class ytt
  implements yrp<yre>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  int b;
  
  private ytt(DoodleLayout paramDoodleLayout) {}
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, System.currentTimeMillis() + 500L);
    if (paramBoolean3) {
      DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) + 500L);
    }
    Object localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setDuration(500L);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setAnimationListener(new ytu(this));
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(500L);
    if (paramBoolean3) {
      localAlphaAnimation.setStartOffset(500L);
    }
    localAlphaAnimation.setFillAfter(true);
    localAlphaAnimation.setAnimationListener(new ytv(this));
    if (paramBoolean2) {
      localObject = localAlphaAnimation;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.startAnimation((Animation)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setAnimationEndTime(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Yto != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Yto.b((Animation)localObject);
      }
      return;
    }
  }
  
  public boolean a(yre paramyre, MotionEvent paramMotionEvent)
  {
    zbt localzbt = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.a();
    if (localzbt != null) {}
    int i;
    int j;
    switch (localzbt.jdField_a_of_type_Int)
    {
    default: 
      i = Math.round(paramMotionEvent.getY());
      j = Math.round(paramMotionEvent.getX());
      switch (paramMotionEvent.getAction())
      {
      }
      break;
    }
    label516:
    do
    {
      do
      {
        do
        {
          return false;
          i = localzbt.jdField_b_of_type_Int;
          if (i != yup.jdField_a_of_type_Int) {
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Int, true);
          }
          for (;;)
          {
            localObject = (yup)paramyre.a(101);
            if (localObject != null) {
              ((yup)localObject).a(i);
            }
            if (paramyre.b()) {
              break;
            }
            paramyre.e();
            break;
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_AndroidUtilSparseBooleanArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Int, false);
          }
          if (paramyre.c()) {
            break;
          }
          paramyre.d();
          break;
          Object localObject = null;
          if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext() instanceof QQStoryBaseActivity)) {
            localObject = ((QQStoryBaseActivity)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.getContext()).a;
          }
          paramyre.a((AppInterface)localObject, 2, localzbt.jdField_b_of_type_Int);
          break;
          this.jdField_a_of_type_Int = Math.round(paramMotionEvent.getX());
          this.jdField_b_of_type_Int = Math.round(paramMotionEvent.getY());
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          return false;
        } while (((Math.abs(j - this.jdField_a_of_type_Int) < 3) && (Math.abs(i - this.jdField_b_of_type_Int) < 3)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 6) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 5));
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(5);
        if (DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout) > System.currentTimeMillis()) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(false));
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Personality", 2, "LineLayer draw move hide");
          return false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(5, Boolean.valueOf(true));
          a(true, false, true);
        }
        if (paramyre.a.a() > 0) {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout.setUndoViewEnable(true);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int != 5) {
          break label516;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(2);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(2);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
        a(true, true, true);
      } while (!QLog.isColorLevel());
      QLog.d("Personality", 2, "LineLayer draw up show");
      return false;
    } while ((Math.abs(j - this.jdField_a_of_type_Int) >= 3) || (Math.abs(i - this.jdField_b_of_type_Int) >= 3));
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_b_of_type_Int == 6)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(2, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(2);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
      if (paramyre.a.a() > 0) {}
      for (bool = true;; bool = false)
      {
        a(bool, true, false);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Personality", 2, "LineLayer tap up show");
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.c(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(6);
    ykw.b("0X80080E5", ykw.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout });
    if (paramyre.a.a() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool, false, true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Personality", 2, "LineLayer tap up hide");
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ytt
 * JD-Core Version:    0.7.0.1
 */