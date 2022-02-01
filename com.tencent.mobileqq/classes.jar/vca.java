import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class vca
  extends uyw
{
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private vcu jdField_a_of_type_Vcu;
  
  public vca(Context paramContext, vcu paramvcu)
  {
    super(paramContext);
    this.jdField_a_of_type_Vcu = paramvcu;
  }
  
  private void g()
  {
    f();
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_Vcu.a();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.i())) {
      this.jdField_a_of_type_Vcu.a(localWSPlayerManager);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new vcc(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560445;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131369085));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/muteguide/muteguide.json");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetsFolder("wsfollow/muteguide/images");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new vcb(this));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Vcu.a())
    {
      h();
      this.jdField_a_of_type_Vcu.d();
      vmp.e("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vca
 * JD-Core Version:    0.7.0.1
 */