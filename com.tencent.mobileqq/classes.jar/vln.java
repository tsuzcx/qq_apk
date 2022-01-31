import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class vln
  extends QQUIEventReceiver<vlm, uyb>
{
  public vln(@NonNull vlm paramvlm)
  {
    super(paramvlm);
  }
  
  public void a(@NonNull vlm paramvlm, @NonNull uyb paramuyb)
  {
    if ((!TextUtils.equals(vlm.a(paramvlm).mContext, paramuyb.jdField_a_of_type_JavaLangString)) || (vlm.a(paramvlm) == null)) {
      return;
    }
    if (paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      wsv.a(this.TAG, "pull feedId list fail %s", paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      vlm.a(paramvlm).a(new ErrorMessage(paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramuyb.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    vlm.a(paramvlm).mIsEnd = paramuyb.jdField_a_of_type_Boolean;
    vlm.a(paramvlm).b(new ErrorMessage(), vlm.b(paramuyb.jdField_a_of_type_JavaUtilList), paramuyb.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return uyb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vln
 * JD-Core Version:    0.7.0.1
 */