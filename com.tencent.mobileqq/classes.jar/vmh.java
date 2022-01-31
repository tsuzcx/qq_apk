import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class vmh
  extends QQUIEventReceiver<vmg, vmb>
{
  public vmh(@NonNull vmg paramvmg)
  {
    super(paramvmg);
  }
  
  public void a(@NonNull vmg paramvmg, @NonNull vmb paramvmb)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramvmb.jdField_a_of_type_JavaLangString)) {}
    switch (paramvmb.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    wxe.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramvmb.b);
    vmg.a(paramvmg, false);
    paramvmg.a(paramvmg.jdField_a_of_type_AndroidOsBundle, paramvmg.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramvmg.jdField_a_of_type_JavaLangString, paramvmb.b);
  }
  
  public Class acceptEventClass()
  {
    return vmb.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */