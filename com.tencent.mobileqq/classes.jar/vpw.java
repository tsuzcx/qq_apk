import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vpw
  extends QQUIEventReceiver<vpv, vck>
{
  public vpw(@NonNull vpv paramvpv)
  {
    super(paramvpv);
  }
  
  public void a(@NonNull vpv paramvpv, @NonNull vck paramvck)
  {
    if ((!TextUtils.equals(vpv.a(paramvpv).mContext, paramvck.jdField_a_of_type_JavaLangString)) || (vpv.a(paramvpv) == null)) {
      return;
    }
    if (paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wxe.a(this.TAG, "pull feedId list fail %s", paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      vpv.a(paramvpv).a(new ErrorMessage(paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramvck.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    vpv.a(paramvpv).mIsEnd = paramvck.jdField_a_of_type_Boolean;
    vpv.a(paramvpv).b(new ErrorMessage(), vpv.b(paramvck.jdField_a_of_type_JavaUtilList), paramvck.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return vck.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vpw
 * JD-Core Version:    0.7.0.1
 */