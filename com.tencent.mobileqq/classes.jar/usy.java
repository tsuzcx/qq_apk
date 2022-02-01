import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class usy
  extends uej<usv>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stNewIconStyle jdField_a_of_type_UserGrowthStNewIconStyle;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private urj jdField_a_of_type_Urj;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public usy(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(String paramString, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramstSimpleMetaFeed == null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.floatingLayerCardStyle.cardType == 1002)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      return;
    }
    paramstSimpleMetaFeed = new SpannableStringBuilder();
    paramstSimpleMetaFeed.append(paramString + "ao");
    paramString = a().getDrawable(2130840197);
    paramString.setBounds(bhtq.b(4.0F), bhtq.b(-5.0F), bhtq.b(25.0F), bhtq.b(6.0F));
    paramString = new ImageSpan(paramString);
    paramstSimpleMetaFeed.setSpan(paramString, paramstSimpleMetaFeed.length() - 2, paramstSimpleMetaFeed.length(), 33);
    if ((TextUtils.isEmpty(paramstSimpleMetaFeed)) || (paramString == null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramstSimpleMetaFeed);
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.title)))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStNewIconStyle.title);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
      this.jdField_a_of_type_UserGrowthStNewIconStyle = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.new_icon;
    }
  }
  
  protected int b()
  {
    return 2131559214;
  }
  
  protected void b()
  {
    Object localObject = (usv)a();
    if (localObject == null) {
      return;
    }
    if ((((usv)localObject).a() instanceof stSimpleMetaFeed))
    {
      localObject = (stSimpleMetaFeed)((usv)localObject).a();
      a(((stSimpleMetaFeed)localObject).feed_desc, (stSimpleMetaFeed)localObject);
    }
    if ((this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 0) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.floatingLayerCardStyle.cardType == 1002))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367423));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367408));
    this.jdField_b_of_type_AndroidViewView = a(2131367413);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131367415));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
    {
      uqf.b("GdtWSVerticalItemBottomController", "跳转到广告落地页");
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
          this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new usz(this);
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
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     usy
 * JD-Core Version:    0.7.0.1
 */