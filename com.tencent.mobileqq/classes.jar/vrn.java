import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public abstract class vrn
  extends vqg<vpj>
{
  private static final int a;
  public vfs a;
  public vgb a;
  
  static
  {
    jdField_a_of_type_Int = ScreenUtil.dip2px(51.0F);
  }
  
  public vrn(ViewGroup paramViewGroup, int paramInt1, int paramInt2, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramViewGroup, paramInt1, paramInt2, paramWSVerticalPageFragment);
  }
  
  private View a()
  {
    if ((this.jdField_a_of_type_Uyx instanceof vqe)) {
      return ((vqe)this.jdField_a_of_type_Uyx).a();
    }
    return null;
  }
  
  private View b()
  {
    if ((this.jdField_a_of_type_Uyx instanceof vqe)) {
      return ((vqe)this.jdField_a_of_type_Uyx).b();
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    View localView = b();
    if (localView == null) {
      return;
    }
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2))
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private int c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    vgg localvgg = new vgg(a(), a(), paramstSimpleMetaFeed.video.width, paramstSimpleMetaFeed.video.height, b(), a());
    int i = a(paramstSimpleMetaFeed);
    vmp.e("WSVerticalVideoHolder", "[WSVerticalVideoHolder.java][calculatePlayerLayoutRatio] videoScaleType:" + i + ", " + localvgg.toString());
    switch (i)
    {
    case 0: 
    default: 
      return vgd.b(localvgg);
    case -1: 
      return vgd.a(localvgg);
    case 1: 
      return vgd.b(localvgg);
    }
    return vgd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localvgg, new vro(this));
  }
  
  public int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public int a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return paramstSimpleMetaFeed.scaleType;
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
    if (this.jdField_a_of_type_Uyx != null) {
      this.jdField_a_of_type_Uyx.b(paramInt);
    }
  }
  
  public void a(vpj paramvpj)
  {
    super.a(paramvpj);
    if (this.jdField_a_of_type_Uyx != null) {
      this.jdField_a_of_type_Uyx.a(paramvpj);
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public int b()
  {
    return ((voh)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b()).b();
  }
  
  public int b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    return c(paramstSimpleMetaFeed);
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
    if (this.jdField_a_of_type_Uyx != null) {
      this.jdField_a_of_type_Uyx.c();
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_a_of_type_Uyx != null) {
      this.jdField_a_of_type_Uyx.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrn
 * JD-Core Version:    0.7.0.1
 */