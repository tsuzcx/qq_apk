import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import rx.functions.Action1;

final class vnh
  implements Action1<Throwable>
{
  vnh(RoundImageView paramRoundImageView, Drawable paramDrawable) {}
  
  public void a(Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnh
 * JD-Core Version:    0.7.0.1
 */