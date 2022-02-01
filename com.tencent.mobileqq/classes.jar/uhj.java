import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class uhj
  extends uej
{
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private uhz jdField_a_of_type_Uhz;
  
  public uhj(Context paramContext, uhz paramuhz)
  {
    super(paramContext);
    this.jdField_a_of_type_Uhz = paramuhz;
  }
  
  private void g()
  {
    f();
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_Uhz.a();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.i())) {
      this.jdField_a_of_type_Uhz.a(localWSPlayerManager);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new uhl(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560387;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131368899));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/muteguide/muteguide.json");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetsFolder("wsfollow/muteguide/images");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new uhk(this));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Uhz.a())
    {
      h();
      this.jdField_a_of_type_Uhz.d();
      uqf.e("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhj
 * JD-Core Version:    0.7.0.1
 */