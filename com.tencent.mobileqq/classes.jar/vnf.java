import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import rx.functions.Action1;

final class vnf
  implements Action1<URLDrawable>
{
  vnf(RoundImageView paramRoundImageView, String paramString) {}
  
  public void a(URLDrawable paramURLDrawable)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramURLDrawable);
    paramURLDrawable.setURLDrawableListener(new vng(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnf
 * JD-Core Version:    0.7.0.1
 */