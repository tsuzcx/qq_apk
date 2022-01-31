import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class tmx
  extends tck<tmv>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public tmx(Context paramContext, tnj paramtnj)
  {
    super(paramContext);
    if (paramtnj != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramtnj.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setText(paramString);
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  private int c()
  {
    return tmo.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
  }
  
  private void f()
  {
    String str;
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)
    {
      str = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.feed_material_jump_url;
      tlo.b("WSVerticalItemBottomContentController", "mFeedMaterialJumpUrl = " + str);
      if (tlq.a(str)) {
        break label93;
      }
      str = tlq.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    }
    label93:
    for (;;)
    {
      tmo.a((Activity)this.jdField_a_of_type_AndroidContentContext, str, 3, c(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, a(), null);
      tnt.e(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      return;
      str = "";
      break;
    }
  }
  
  protected void a()
  {
    tmv localtmv = (tmv)a();
    if ((localtmv != null) && ((localtmv.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localtmv.a());
    }
  }
  
  protected int b()
  {
    return 2131559869;
  }
  
  protected void b()
  {
    Object localObject = (tmv)a();
    if (localObject == null) {}
    while (!(((tmv)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((tmv)localObject).a();
    a(((stSimpleMetaFeed)localObject).feed_desc);
    b(((stSimpleMetaFeed)localObject).material_desc);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131379560));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379561));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    tlo.b("WSVerticalItemBottomContentController", "跳转到微视端内");
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tmx
 * JD-Core Version:    0.7.0.1
 */