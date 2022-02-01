import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class utc
  extends uej<usv>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private urj jdField_a_of_type_Urj;
  private View b;
  
  public utc(Context paramContext)
  {
    super(paramContext);
  }
  
  public utc(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if (localusv == null) {}
    while (!(localusv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
  }
  
  protected int b()
  {
    return 2131559216;
  }
  
  @UiThread
  protected void b()
  {
    uqf.a("GdtAdWSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    usv localusv = (usv)a();
    if (localusv == null) {}
    while (!(localusv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.nick);
    uqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
  }
  
  protected void c() {}
  
  protected void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = uqs.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = uqs.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = uqs.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.b = a(2131376945);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131367418));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367421));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
    {
      uqf.b("GdtAdWSVerticalItemTopController", "跳转到广告落地页");
      if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      Object localObject;
      if (usw.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed))
      {
        localObject = new GdtAd(usw.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
        if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
          this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new utd(this);
        }
        AdExposureChecker.onClick(a(), (Ad)localObject, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      }
      this.jdField_a_of_type_Urj = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      if ((this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
      {
        localObject = this.jdField_a_of_type_Urj.a();
        if ((localObject != null) && (((uuy)localObject).a != null)) {
          usw.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, ((uuy)localObject).a);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */