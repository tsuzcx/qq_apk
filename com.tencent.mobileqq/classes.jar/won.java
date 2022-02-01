import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class won
  extends QQUIEventReceiver<wom, wbh>
{
  public won(@NonNull wom paramwom)
  {
    super(paramwom);
  }
  
  public void a(@NonNull wom paramwom, @NonNull wbh paramwbh)
  {
    if ((!TextUtils.equals(wom.a(paramwom).mContext, paramwbh.jdField_a_of_type_JavaLangString)) || (wom.a(paramwom) == null)) {
      return;
    }
    if (paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      xvv.a(this.TAG, "pull feedId list fail %s", paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      wom.a(paramwom).a(new ErrorMessage(paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramwbh.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    wom.a(paramwom).mIsEnd = paramwbh.jdField_a_of_type_Boolean;
    wom.a(paramwom).b(new ErrorMessage(), wom.b(paramwbh.jdField_a_of_type_JavaUtilList), paramwbh.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return wbh.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     won
 * JD-Core Version:    0.7.0.1
 */