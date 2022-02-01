import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

public class uoa
  extends ukz
{
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private uou jdField_a_of_type_Uou;
  
  public uoa(Context paramContext, uou paramuou)
  {
    super(paramContext);
    this.jdField_a_of_type_Uou = paramuou;
  }
  
  private void g()
  {
    f();
    WSPlayerManager localWSPlayerManager = this.jdField_a_of_type_Uou.a();
    if ((localWSPlayerManager != null) && (localWSPlayerManager.i())) {
      this.jdField_a_of_type_Uou.a(localWSPlayerManager);
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.addAnimatorListener(new uoc(this));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.playAnimation();
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560395;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)a(2131368924));
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setAnimation("wsfollow/muteguide/muteguide.json");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setImageAssetsFolder("wsfollow/muteguide/images");
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setOnClickListener(new uob(this));
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Uou.a())
    {
      h();
      this.jdField_a_of_type_Uou.d();
      uya.e("WSFollowTabMuteGuideController", "[WSFollowTabMuteGuideController.java][playAnimationForMuteGuide] doPlay!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoa
 * JD-Core Version:    0.7.0.1
 */