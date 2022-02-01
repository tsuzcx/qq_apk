import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uub
  extends uej<usv>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private uuy jdField_a_of_type_Uuy;
  private View b;
  
  public uub(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    this.jdField_a_of_type_Uuy = paramuuy;
    if (paramuuy != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramuuy.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(uvv.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a()), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(a());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a.a(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b());
    }
  }
  
  private void f()
  {
    a(0, 4);
  }
  
  private void g()
  {
    a(1, 7);
  }
  
  protected void a()
  {
    if ((a() != null) && ((((usv)a()).a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)((usv)a()).a());
    }
  }
  
  protected int b()
  {
    return 2131560023;
  }
  
  protected void b()
  {
    String str = ugd.a().f();
    if (!TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131379749));
    this.b = a(2131372126);
    this.b.setOnClickListener(new uuc(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131369151));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new uud(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uub
 * JD-Core Version:    0.7.0.1
 */