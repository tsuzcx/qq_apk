import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.BaseApplication;

public class vzy
{
  private static aaaf jdField_a_of_type_Aaaf = new aaaf();
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQAnimationDrawable jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new QCircleFolderTabView.1(this);
  private final zzi jdField_a_of_type_Zzi = new vzz(this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Aaaf.a(new aaai("https://downv6.qq.com/video_story/qcircle/animation/follow_tab_update_notification_android.zip", uyk.a()));
    jdField_a_of_type_Aaaf.a();
  }
  
  public vzy(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560731, paramViewGroup, false));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131371948));
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null) || (this.jdField_a_of_type_AndroidWidgetImageView == null))
    {
      QLog.e("QCircleFolderTabView", 1, "playUpdateAnim AnimationDrawable is null or updateAnimView is null!");
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.e("QCircleFolderTabView", 1, "playUpdateAnim action canceled,direct return!");
      return;
    }
    vtq.a("", 22, 15, 1);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.start();
    bkdz.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, vtd.h() * 1000L);
    QLog.d("QCircleFolderTabView", 1, "playUpdateAnim called");
  }
  
  private void f()
  {
    QLog.d("QCircleFolderTabView", 1, "playDismissAnim");
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.758F, 1, 0.25F);
      localScaleAnimation.setDuration(200L);
      localScaleAnimation.setAnimationListener(new waa(this));
      Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130844113);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localScaleAnimation);
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetFrameLayout;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable == null)
    {
      QLog.d("QCircleFolderTabView", 1, "showUpdateAnim Async fetchAnimDrawable first!");
      if (aaae.a(uyk.a()).a("https://downv6.qq.com/video_story/qcircle/animation/follow_tab_update_notification_android.zip"))
      {
        QLog.d("QCircleFolderTabView", 1, "showUpdateAnim AnimDrawable already downloaded!");
        zzb localzzb = new zzb("https://downv6.qq.com/video_story/qcircle/animation/follow_tab_update_notification_android.zip");
        localzzb.b(40);
        localzzb.a(2147483647L);
        localzzb.a(true);
        localzzb.b(true);
        zzc.a().a(hashCode(), localzzb.a(), this.jdField_a_of_type_Zzi);
        return;
      }
      b();
      QLog.d("QCircleFolderTabView", 1, "showUpdateAnim AnimDrawable need download,show default dot first!");
      return;
    }
    QLog.d("QCircleFolderTabView", 1, "showUpdateAnim sync!");
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("QCircleFolderTabView", 1, "hideUpdateAnim called,need show dismiss Anim:" + paramBoolean);
    vtq.a("", 22, 15, 2);
    if (paramBoolean)
    {
      f();
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    g();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      QLog.e("QCircleFolderTabView", 1, "showDefaultUpdateDot updateAnimView is null!");
      return;
    }
    vtq.a("", 22, 15, 1);
    Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130844113);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    bkdz.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, vtd.h() * 1000L);
    QLog.d("QCircleFolderTabView", 1, "showDefaultUpdateDot called");
  }
  
  public void c()
  {
    bkdz.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.isRunning()))
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.stop();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null)
      {
        Drawable localDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130844113);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      }
      QLog.e("QCircleFolderTabView", 1, "onPause，stop running update animation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzy
 * JD-Core Version:    0.7.0.1
 */