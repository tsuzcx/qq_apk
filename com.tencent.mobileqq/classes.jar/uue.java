import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.FeedRichTextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uue
  extends uej<usv>
  implements View.OnClickListener
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FeedRichTextView jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public uue(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
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
  
  private void f()
  {
    ure.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    uvv.g(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    uoi.e();
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
    return 2131560024;
  }
  
  protected void b()
  {
    Object localObject = (usv)a();
    if (localObject == null) {}
    while (!(((usv)localObject).a() instanceof stSimpleMetaFeed)) {
      return;
    }
    localObject = (stSimpleMetaFeed)((usv)localObject).a();
    a(((stSimpleMetaFeed)localObject).feed_desc);
    b(((stSimpleMetaFeed)localObject).material_desc);
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView = ((FeedRichTextView)a(2131380685));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newUtilFeedRichTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380686));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
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
      uqf.b("WSVerticalItemBottomContentController", "跳转到微视端内");
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uue
 * JD-Core Version:    0.7.0.1
 */