import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAppReceiver;

public class oqy
  extends orb
{
  public static GdtAppReceiver mGdtAppReceiver;
  private oqr a;
  private ogm<oqr> b;
  private ogm<oqr> c;
  private ogm<oqr> d;
  private GestureDetector mGestureDetector;
  private int mPosition;
  
  public oqy(Context paramContext, osf paramosf)
  {
    super(paramContext, paramosf);
  }
  
  private void bgm()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381859);
    this.b = new oqv(this.mContext, this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    this.b.initLayout(localViewStub);
  }
  
  private void bgn()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381848);
    this.jdField_c_of_type_Ogm = new oqu(this.mContext, this.jdField_d_of_type_Osf);
    this.jdField_c_of_type_Ogm.initLayout(localViewStub);
  }
  
  private void bgo()
  {
    ViewStub localViewStub = (ViewStub)this.mItemView.findViewById(2131381861);
    this.jdField_d_of_type_Ogm = new oqw(this.mContext, this.jdField_d_of_type_Osf);
    this.jdField_d_of_type_Ogm.initLayout(localViewStub);
  }
  
  private void bgp()
  {
    if (this.mItemView == null) {
      return;
    }
    if (mGdtAppReceiver == null)
    {
      mGdtAppReceiver = new GdtAppReceiver();
      mGdtAppReceiver.register(BaseApplicationImpl.getContext());
    }
    this.mGestureDetector = new GestureDetector(this.mItemView.getContext(), new oqz(this));
    this.mItemView.setOnTouchListener(new ora(this));
  }
  
  private void bgq()
  {
    oqs.a(this.mItemView.getContext(), (stSimpleMetaFeed)this.a.B(), mGdtAppReceiver);
  }
  
  public stSimpleMetaFeed b()
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed))) {
      return (stSimpleMetaFeed)this.a.B();
    }
    return null;
  }
  
  public void b(oqr paramoqr)
  {
    super.b(paramoqr);
    this.a = paramoqr;
    if (this.b != null) {
      this.b.setData(paramoqr);
    }
    if (this.jdField_c_of_type_Ogm != null) {
      this.jdField_c_of_type_Ogm.setData(paramoqr);
    }
    if (this.jdField_d_of_type_Ogm != null) {
      this.jdField_d_of_type_Ogm.setData(paramoqr);
    }
  }
  
  public void bey()
  {
    if ((this.a != null) && ((this.a.B() instanceof stSimpleMetaFeed)))
    {
      stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)this.a.B();
      okd.a().pH(localstSimpleMetaFeed.id);
    }
  }
  
  public void bez()
  {
    ooe localooe = new ooe();
    localooe.b = b();
    localooe.mPageType = 2;
    localooe.mPosition = this.mPosition;
    localooe.mSopName = osv.fE(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getFrom());
    localooe.aqb = this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getPlayScene();
    localooe.aqU = "more_operations";
    localooe.b(this.jdField_c_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
    opc.a(this.mContext, localooe);
  }
  
  public void initUI()
  {
    super.initUI();
    bgm();
    bgn();
    bgo();
    bgp();
  }
  
  public void onPageSelected(int paramInt) {}
  
  public void recycle()
  {
    super.recycle();
    if (this.b != null) {
      this.b.recycle();
    }
    if (this.jdField_c_of_type_Ogm != null) {
      this.jdField_c_of_type_Ogm.recycle();
    }
    if (this.jdField_d_of_type_Ogm != null) {
      this.jdField_d_of_type_Ogm.recycle();
    }
  }
  
  public void setPosition(int paramInt)
  {
    super.setPosition(paramInt);
    this.mPosition = paramInt;
    if (this.b != null) {
      this.b.setPosition(paramInt);
    }
    if (this.jdField_c_of_type_Ogm != null) {
      this.jdField_c_of_type_Ogm.setPosition(paramInt);
    }
    if (this.jdField_d_of_type_Ogm != null) {
      this.jdField_d_of_type_Ogm.setPosition(paramInt);
    }
  }
  
  public void uE(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqy
 * JD-Core Version:    0.7.0.1
 */