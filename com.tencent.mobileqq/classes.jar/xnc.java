import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xnc
  extends QQUIEventReceiver<xnb, wzr>
{
  public xnc(@NonNull xnb paramxnb)
  {
    super(paramxnb);
  }
  
  public void a(@NonNull xnb paramxnb, @NonNull wzr paramwzr)
  {
    if ((!TextUtils.equals(xnb.a(paramxnb).mContext, paramwzr.jdField_a_of_type_JavaLangString)) || (xnb.a(paramxnb) == null)) {
      return;
    }
    if (paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yuk.a(this.TAG, "pull feedId list fail %s", paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      xnb.a(paramxnb).a(new ErrorMessage(paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramwzr.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    xnb.a(paramxnb).mIsEnd = paramwzr.jdField_a_of_type_Boolean;
    xnb.a(paramxnb).b(new ErrorMessage(), xnb.b(paramwzr.jdField_a_of_type_JavaUtilList), paramwzr.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return wzr.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnc
 * JD-Core Version:    0.7.0.1
 */