import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tribe.async.dispatch.QQUIEventReceiver;

class xdi
  extends QQUIEventReceiver<xdh, wqc>
{
  public xdi(@NonNull xdh paramxdh)
  {
    super(paramxdh);
  }
  
  public void a(@NonNull xdh paramxdh, @NonNull wqc paramwqc)
  {
    if ((!TextUtils.equals(xdh.a(paramxdh).mContext, paramwqc.jdField_a_of_type_JavaLangString)) || (xdh.a(paramxdh) == null)) {
      return;
    }
    if (paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      ykq.a(this.TAG, "pull feedId list fail %s", paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
      xdh.a(paramxdh).a(new ErrorMessage(paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramwqc.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
      return;
    }
    xdh.a(paramxdh).mIsEnd = paramwqc.jdField_a_of_type_Boolean;
    xdh.a(paramxdh).b(new ErrorMessage(), xdh.b(paramwqc.jdField_a_of_type_JavaUtilList), paramwqc.jdField_a_of_type_Boolean);
  }
  
  public Class acceptEventClass()
  {
    return wqc.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdi
 * JD-Core Version:    0.7.0.1
 */