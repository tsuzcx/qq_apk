import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class twy
  extends QQUIEventReceiver<twx, tjm>
{
  public twy(@NonNull twx paramtwx)
  {
    super(paramtwx);
  }
  
  public void a(@NonNull twx paramtwx, @NonNull tjm paramtjm)
  {
    if ((!TextUtils.equals(twx.a(paramtwx).mContext, paramtjm.jdField_a_of_type_JavaLangString)) || (twx.a(paramtwx) == null)) {
      return;
    }
    if (paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      veg.a(this.TAG, "pull feedId list fail %s", paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      twx.a(paramtwx).a(new ErrorMessage(paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramtjm.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    twx.a(paramtwx).mIsEnd = paramtjm.jdField_a_of_type_Boolean;
    twx.a(paramtwx).b(new ErrorMessage(), twx.b(paramtjm.jdField_a_of_type_JavaUtilList), paramtjm.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return tjm.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twy
 * JD-Core Version:    0.7.0.1
 */