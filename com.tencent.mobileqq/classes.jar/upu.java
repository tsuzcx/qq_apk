import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class upu
  implements URLDrawable.URLDrawableListener
{
  upu(String paramString, RoundImageView paramRoundImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    upe.d("AvatarImageLog", "WeishiUtils loadAvatarImage onFail url:" + this.jdField_a_of_type_JavaLangString + ", imageView:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    upe.b("AvatarImageLog", "WeishiUtils loadAvatarImage onSuccess url:" + this.jdField_a_of_type_JavaLangString + ", imageView:" + this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upu
 * JD-Core Version:    0.7.0.1
 */