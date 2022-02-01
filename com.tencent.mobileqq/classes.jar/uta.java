import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
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

public class uta
  extends uej<usv>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private urj jdField_a_of_type_Urj;
  
  public uta(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
    }
  }
  
  protected int b()
  {
    return 2131559215;
  }
  
  protected void b()
  {
    usv localusv = (usv)a();
    if (localusv == null) {}
    while (!(localusv.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.nick);
    uqt.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(8);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#66FFFFFF"));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131367417));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367420));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367409));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131367409)
    {
      localObject = new upd();
      ((upd)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      ((upd)localObject).jdField_a_of_type_Int = 2;
      ((upd)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((upd)localObject).jdField_a_of_type_JavaLangString = uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
      ((upd)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      ((upd)localObject).c = "more_operations";
      ((upd)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
      uqi.a(this.jdField_a_of_type_AndroidContentContext, (upd)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
      {
        uqf.b("GdtAdWSVerticalItemBottomUserController", "跳转到广告落地页");
        if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
        {
          jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
          jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
        }
        if (usw.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed))
        {
          localObject = new GdtAd(usw.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new utb(this);
          }
          AdExposureChecker.onClick(a(), (Ad)localObject, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
        }
        this.jdField_a_of_type_Urj = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
        if ((this.jdField_a_of_type_Urj != null) && (this.jdField_a_of_type_Urj.a() != null))
        {
          localObject = this.jdField_a_of_type_Urj.a();
          if ((localObject != null) && (((uuy)localObject).jdField_a_of_type_Ukz != null)) {
            usw.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, ((uuy)localObject).jdField_a_of_type_Ukz);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uta
 * JD-Core Version:    0.7.0.1
 */