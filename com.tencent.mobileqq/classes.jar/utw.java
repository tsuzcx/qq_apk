import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public abstract class utw
  extends usr<uru>
{
  public ujv a;
  public ukb a;
  
  public utw(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().e(a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().d(a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(b());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(c());
    }
    if (this.jdField_a_of_type_Uei != null) {
      this.jdField_a_of_type_Uei.b(paramInt);
    }
  }
  
  public void a(uru paramuru)
  {
    super.a(paramuru);
    if (this.jdField_a_of_type_Uei != null) {
      this.jdField_a_of_type_Uei.a(paramuru);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public abstract void b();
  
  protected boolean b()
  {
    return true;
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_Uei != null) {
      this.jdField_a_of_type_Uei.b();
    }
  }
  
  protected boolean c()
  {
    return true;
  }
  
  public abstract void d();
  
  public void e()
  {
    if (this.jdField_a_of_type_Uei != null) {
      this.jdField_a_of_type_Uei.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utw
 * JD-Core Version:    0.7.0.1
 */