import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uuh
  extends uej<usv>
  implements View.OnClickListener
{
  private stNewIconStyle jdField_a_of_type_UserGrowthStNewIconStyle;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View jdField_b_of_type_AndroidViewView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private KandianUrlImageView c;
  
  public uuh(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.title)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.c.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStNewIconStyle.title);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl)) {
        this.c.setImage(uqt.a(this.jdField_a_of_type_UserGrowthStNewIconStyle.iconUrl));
      }
      for (;;)
      {
        if (paramBoolean2) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842660);
        }
        return;
        this.c.setImageResource(2130843159);
      }
    }
    this.c.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
  }
  
  private void f()
  {
    a(true, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageResource(2130842660);
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
      this.jdField_a_of_type_UserGrowthStNewIconStyle = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.new_icon;
      if (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) {
        uoi.a(this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type, this.jdField_a_of_type_UserGrowthStNewIconStyle.id);
      }
    }
  }
  
  protected int b()
  {
    return 2131560027;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && ((this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 1) || (this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 2)))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      int i = this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type;
      String str = this.jdField_a_of_type_UserGrowthStNewIconStyle.img_url;
      if (i == 1)
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(8);
        f();
      }
      while (i != 2) {
        return;
      }
      a(false, false);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setVisibility(0);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(uqt.a(str));
        return;
      }
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImage(uqt.a("https://isee.weishi.qq.com/qq/doudi_ban.png"));
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_b_of_type_AndroidViewView = a(2131380708);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131380690));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131380707));
    this.c = ((KandianUrlImageView)a(2131380710));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380709));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380708) {
      ure.c(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuh
 * JD-Core Version:    0.7.0.1
 */