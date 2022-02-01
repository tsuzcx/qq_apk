import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wzz
  extends QQUIEventReceiver<wzy, wzt>
{
  public wzz(@NonNull wzy paramwzy)
  {
    super(paramwzy);
  }
  
  public void a(@NonNull wzy paramwzy, @NonNull wzt paramwzt)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramwzt.jdField_a_of_type_JavaLangString)) {}
    switch (paramwzt.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    ykq.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramwzt.b);
    wzy.a(paramwzy, false);
    paramwzy.a(paramwzy.jdField_a_of_type_AndroidOsBundle, paramwzy.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwzy.jdField_a_of_type_JavaLangString, paramwzt.b);
  }
  
  public Class acceptEventClass()
  {
    return wzt.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wzz
 * JD-Core Version:    0.7.0.1
 */