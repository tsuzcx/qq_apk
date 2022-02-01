import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xjo
  extends QQUIEventReceiver<xjn, xji>
{
  public xjo(@NonNull xjn paramxjn)
  {
    super(paramxjn);
  }
  
  public void a(@NonNull xjn paramxjn, @NonNull xji paramxji)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramxji.jdField_a_of_type_JavaLangString)) {}
    switch (paramxji.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    yuk.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramxji.b);
    xjn.a(paramxjn, false);
    paramxjn.a(paramxjn.jdField_a_of_type_AndroidOsBundle, paramxjn.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxjn.jdField_a_of_type_JavaLangString, paramxji.b);
  }
  
  public Class acceptEventClass()
  {
    return xji.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjo
 * JD-Core Version:    0.7.0.1
 */