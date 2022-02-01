import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class xft
  extends QQUIEventReceiver<xfs, xfn>
{
  public xft(@NonNull xfs paramxfs)
  {
    super(paramxfs);
  }
  
  public void a(@NonNull xfs paramxfs, @NonNull xfn paramxfn)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramxfn.jdField_a_of_type_JavaLangString)) {}
    switch (paramxfn.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    yqp.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramxfn.b);
    xfs.a(paramxfs, false);
    paramxfs.a(paramxfs.jdField_a_of_type_AndroidOsBundle, paramxfs.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramxfs.jdField_a_of_type_JavaLangString, paramxfn.b);
  }
  
  public Class acceptEventClass()
  {
    return xfn.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xft
 * JD-Core Version:    0.7.0.1
 */