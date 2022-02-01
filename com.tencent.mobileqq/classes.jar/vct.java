import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public abstract class vct
  extends vbn<vaq>
{
  public urk a;
  public urt a;
  
  public vct(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().f(a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().e(a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(b());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(c());
    }
    if (this.jdField_a_of_type_Ula != null) {
      this.jdField_a_of_type_Ula.b(paramInt);
    }
  }
  
  public void a(vaq paramvaq)
  {
    super.a(paramvaq);
    if (this.jdField_a_of_type_Ula != null) {
      this.jdField_a_of_type_Ula.a(paramvaq);
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
  
  public abstract void c();
  
  protected boolean c()
  {
    return true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ula != null) {
      this.jdField_a_of_type_Ula.c();
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Ula != null) {
      this.jdField_a_of_type_Ula.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vct
 * JD-Core Version:    0.7.0.1
 */