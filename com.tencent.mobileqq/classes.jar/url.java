import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class url
  extends uej<Object>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  
  public url(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
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
    return 2131560000;
  }
  
  protected void b() {}
  
  protected void c() {}
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment == null) {
      return;
    }
    RelativeLayout localRelativeLayout = (RelativeLayout)a(2131380700);
    usd.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.getActivity(), localRelativeLayout);
    a(2131380701).setOnClickListener(new urm(this));
    a(2131380702).setOnClickListener(new urn(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     url
 * JD-Core Version:    0.7.0.1
 */