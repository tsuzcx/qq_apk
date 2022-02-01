import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uro
  extends uej<Object>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  public uro(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  protected void a()
  {
    if ((a() != null) && ((a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)a());
    }
  }
  
  protected int b()
  {
    return 2131560001;
  }
  
  protected void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection != null))
    {
      int i = (int)(this.jdField_b_of_type_AndroidViewView.getWidth() * 1.5F);
      int j = uqs.c();
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(j - i);
      String str = a().getString(2131719355);
      str = str + this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.name;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  protected void c() {}
  
  public void c(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection != null))
    {
      String str = paramInt + "/" + this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.collection.feed_count;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380700);
    usd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localRelativeLayout);
    this.jdField_b_of_type_AndroidViewView = a(2131380699);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new urp(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380692));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131379741));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uro
 * JD-Core Version:    0.7.0.1
 */