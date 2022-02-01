import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class wle
  extends QQUIEventReceiver<wld, wky>
{
  public wle(@NonNull wld paramwld)
  {
    super(paramwld);
  }
  
  public void a(@NonNull wld paramwld, @NonNull wky paramwky)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramwky.jdField_a_of_type_JavaLangString)) {}
    switch (paramwky.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    xvv.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramwky.b);
    wld.a(paramwld, false);
    paramwld.a(paramwld.jdField_a_of_type_AndroidOsBundle, paramwld.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramwld.jdField_a_of_type_JavaLangString, paramwky.b);
  }
  
  public Class acceptEventClass()
  {
    return wky.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wle
 * JD-Core Version:    0.7.0.1
 */