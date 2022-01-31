import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class wvc
{
  private Animator jdField_a_of_type_AndroidAnimationAnimator;
  private Activity jdField_a_of_type_AndroidAppActivity;
  protected bhqy a;
  private QIMMusicConfigManager jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = (QIMMusicConfigManager)bhfm.a(2);
  private wvg jdField_a_of_type_Wvg;
  private Animator b;
  
  public wvc(Activity paramActivity, View paramView)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ((ViewStub)paramView.findViewById(2131313583)).inflate();
    this.jdField_a_of_type_Bhqy = new bhqy(paramView, "biz_src_jc_story");
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.g();
    this.jdField_a_of_type_Bhqy.a(new wvd(this));
    this.jdField_a_of_type_Bhqy.a(this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.b);
    this.jdField_a_of_type_Bhqy.a().setOnTouchListener(new wve(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimator == null) {
      this.jdField_a_of_type_AndroidAnimationAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bhqy.a(), "alpha", new float[] { 0.0F, 1.0F }).setDuration(600L);
    }
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
    this.jdField_a_of_type_Bhqy.a().setVisibility(0);
    this.jdField_a_of_type_AndroidAnimationAnimator.start();
    boolean bool = vnd.a(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_Bhqy.a(bool);
  }
  
  public void a(wvg paramwvg)
  {
    this.jdField_a_of_type_Wvg = paramwvg;
  }
  
  public void b()
  {
    if (this.b == null)
    {
      this.b = ObjectAnimator.ofFloat(this.jdField_a_of_type_Bhqy.a(), "alpha", new float[] { 1.0F, 0.0F }).setDuration(600L);
      this.b.addListener(new wvf(this));
    }
    if ((this.jdField_a_of_type_AndroidAnimationAnimator != null) && (this.jdField_a_of_type_AndroidAnimationAnimator.isRunning())) {}
    while (this.jdField_a_of_type_Bhqy.a().getVisibility() == 8) {
      return;
    }
    this.b.start();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bhqy != null)
    {
      boolean bool = vnd.a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_Bhqy.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */