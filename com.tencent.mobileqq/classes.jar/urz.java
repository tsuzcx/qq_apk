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

public class urz
  extends ueh<uru>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private uqi jdField_a_of_type_Uqi;
  
  public urz(Context paramContext, utw paramutw)
  {
    super(paramContext);
    if (paramutw != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramutw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  protected void a()
  {
    uru localuru = (uru)a();
    if ((localuru != null) && ((localuru.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localuru.a());
    }
  }
  
  protected int b()
  {
    return 2131559216;
  }
  
  protected void b()
  {
    uru localuru = (uru)a();
    if (localuru == null) {}
    while (!(localuru.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.nick);
    ups.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderWidth(8);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setBorderColor(Color.parseColor("#66FFFFFF"));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131367358));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367361));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367350));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView.getId() == 2131367350)
    {
      localObject = new uoc();
      ((uoc)localObject).jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      ((uoc)localObject).jdField_a_of_type_Int = 2;
      ((uoc)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((uoc)localObject).jdField_a_of_type_JavaLangString = uut.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
      ((uoc)localObject).jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      ((uoc)localObject).c = "more_operations";
      ((uoc)localObject).a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
      uph.a(this.jdField_a_of_type_AndroidContentContext, (uoc)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
      {
        upe.b("GdtAdWSVerticalItemBottomUserController", "跳转到广告落地页");
        if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
        {
          jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
          jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
        }
        if (urv.b(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed))
        {
          localObject = new GdtAd(urv.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
          if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
            this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new usa(this);
          }
          AdExposureChecker.onClick(a(), (Ad)localObject, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
        }
        this.jdField_a_of_type_Uqi = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
        if ((this.jdField_a_of_type_Uqi != null) && (this.jdField_a_of_type_Uqi.a() != null))
        {
          localObject = this.jdField_a_of_type_Uqi.a();
          if ((localObject != null) && (((utw)localObject).jdField_a_of_type_Ukb != null)) {
            urv.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, ((utw)localObject).jdField_a_of_type_Ukb);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     urz
 * JD-Core Version:    0.7.0.1
 */