import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xjh
  extends QQUIEventReceiver<xjg, wvw>
{
  public xjh(@NonNull xjg paramxjg)
  {
    super(paramxjg);
  }
  
  public void a(@NonNull xjg paramxjg, @NonNull wvw paramwvw)
  {
    if ((!TextUtils.equals(xjg.a(paramxjg).mContext, paramwvw.jdField_a_of_type_JavaLangString)) || (xjg.a(paramxjg) == null)) {
      return;
    }
    if (paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      yqp.a(this.TAG, "pull feedId list fail %s", paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      xjg.a(paramxjg).a(new ErrorMessage(paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramwvw.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    xjg.a(paramxjg).mIsEnd = paramwvw.jdField_a_of_type_Boolean;
    xjg.a(paramxjg).b(new ErrorMessage(), xjg.b(paramwvw.jdField_a_of_type_JavaUtilList), paramwvw.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return wvw.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjh
 * JD-Core Version:    0.7.0.1
 */