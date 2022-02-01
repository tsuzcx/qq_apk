import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class vng
  implements URLDrawable.URLDrawableListener
{
  vng(vnf paramvnf) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    vmp.d("AvatarImageLog", "WeishiUtils loadAvatarImage onFail url:" + this.a.jdField_a_of_type_JavaLangString + ", imageView:" + this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    vmp.b("AvatarImageLog", "WeishiUtils loadAvatarImage onSuccess url:" + this.a.jdField_a_of_type_JavaLangString + ", imageView:" + this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView);
    this.a.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vng
 * JD-Core Version:    0.7.0.1
 */