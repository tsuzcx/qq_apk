import UserGrowth.stOpVideo;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uth
  extends ueh<uru>
  implements View.OnClickListener
{
  private stOpVideo jdField_a_of_type_UserGrowthStOpVideo;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public uth(Context paramContext, utw paramutw)
  {
    super(paramContext);
    if (paramutw != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramutw.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private static WSDownloadParams a(WSVerticalPageFragment paramWSVerticalPageFragment, int paramInt, String paramString)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = urc.a(paramWSVerticalPageFragment.a());
    localWSDownloadParams.mLinkStrategyType = ugb.a().a();
    localWSDownloadParams.mEventId = paramInt;
    localWSDownloadParams.mTestId = ups.a(localWSDownloadParams.mScene);
    localWSDownloadParams.mScheme = paramString;
    return localWSDownloadParams;
  }
  
  private void f()
  {
    String str2;
    String str3;
    uip localuip;
    WSVerticalPageFragment localWSVerticalPageFragment;
    if (this.jdField_a_of_type_UserGrowthStOpVideo != null)
    {
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      str3 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      localuip = new uip(a()).a(this.jdField_a_of_type_UserGrowthStOpVideo.jump);
      localWSVerticalPageFragment = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
      if (this.jdField_a_of_type_UserGrowthStOpVideo.jump == null) {
        break label103;
      }
    }
    label103:
    for (String str1 = this.jdField_a_of_type_UserGrowthStOpVideo.jump.schema;; str1 = "")
    {
      localuip.a(a(localWSVerticalPageFragment, 17, str1)).a(new uti(this, str2, str3)).a();
      return;
    }
  }
  
  protected void a() {}
  
  protected int b()
  {
    return 2131560020;
  }
  
  protected void b()
  {
    Object localObject = (uru)a();
    if (localObject == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(((uru)localObject).a() instanceof stSimpleMetaFeed));
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((uru)localObject).a());
        this.jdField_a_of_type_UserGrowthStOpVideo = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.opVideo;
      } while (this.jdField_a_of_type_UserGrowthStOpVideo == null);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStOpVideo.img_url))
      {
        localObject = BaseApplicationImpl.getContext().getResources().getDrawable(2130841680);
        ups.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, this.jdField_a_of_type_UserGrowthStOpVideo.img_url, (Drawable)localObject);
        uut.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStOpVideo.text));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStOpVideo.text);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131369360));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380017));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uth
 * JD-Core Version:    0.7.0.1
 */