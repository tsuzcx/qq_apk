import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class twv
  extends QQUIEventReceiver<twu, tjj>
{
  public twv(@NonNull twu paramtwu)
  {
    super(paramtwu);
  }
  
  public void a(@NonNull twu paramtwu, @NonNull tjj paramtjj)
  {
    if ((!TextUtils.equals(twu.a(paramtwu).mContext, paramtjj.jdField_a_of_type_JavaLangString)) || (twu.a(paramtwu) == null)) {
      return;
    }
    if (paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      ved.a(this.TAG, "pull feedId list fail %s", paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      twu.a(paramtwu).a(new ErrorMessage(paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramtjj.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    twu.a(paramtwu).mIsEnd = paramtjj.jdField_a_of_type_Boolean;
    twu.a(paramtwu).b(new ErrorMessage(), twu.b(paramtjj.jdField_a_of_type_JavaUtilList), paramtjj.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return tjj.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twv
 * JD-Core Version:    0.7.0.1
 */