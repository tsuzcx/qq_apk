import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class tkc
  extends QQUIEventReceiver<tkb, swq>
{
  public tkc(@NonNull tkb paramtkb)
  {
    super(paramtkb);
  }
  
  public void a(@NonNull tkb paramtkb, @NonNull swq paramswq)
  {
    if ((!TextUtils.equals(tkb.a(paramtkb).mContext, paramswq.jdField_a_of_type_JavaLangString)) || (tkb.a(paramtkb) == null)) {
      return;
    }
    if (paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      urk.a(this.TAG, "pull feedId list fail %s", paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      tkb.a(paramtkb).a(new ErrorMessage(paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramswq.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    tkb.a(paramtkb).mIsEnd = paramswq.jdField_a_of_type_Boolean;
    tkb.a(paramtkb).b(new ErrorMessage(), tkb.b(paramswq.jdField_a_of_type_JavaUtilList), paramswq.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return swq.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkc
 * JD-Core Version:    0.7.0.1
 */