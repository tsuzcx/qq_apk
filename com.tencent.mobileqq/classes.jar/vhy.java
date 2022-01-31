import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vhy
  extends QQUIEventReceiver<vhx, vhs>
{
  public vhy(@NonNull vhx paramvhx)
  {
    super(paramvhx);
  }
  
  public void a(@NonNull vhx paramvhx, @NonNull vhs paramvhs)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramvhs.jdField_a_of_type_JavaLangString)) {}
    switch (paramvhs.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    wsv.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramvhs.b);
    vhx.a(paramvhx, false);
    paramvhx.a(paramvhx.jdField_a_of_type_AndroidOsBundle, paramvhx.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvhx.jdField_a_of_type_JavaLangString, paramvhs.b);
  }
  
  public Class acceptEventClass()
  {
    return vhs.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vhy
 * JD-Core Version:    0.7.0.1
 */