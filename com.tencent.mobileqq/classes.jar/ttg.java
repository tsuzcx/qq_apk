import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ttg
  extends QQUIEventReceiver<ttf, tta>
{
  public ttg(@NonNull ttf paramttf)
  {
    super(paramttf);
  }
  
  public void a(@NonNull ttf paramttf, @NonNull tta paramtta)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramtta.jdField_a_of_type_JavaLangString)) {}
    switch (paramtta.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    ved.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramtta.b);
    ttf.a(paramttf, false);
    paramttf.a(paramttf.jdField_a_of_type_AndroidOsBundle, paramttf.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramttf.jdField_a_of_type_JavaLangString, paramtta.b);
  }
  
  public Class acceptEventClass()
  {
    return tta.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttg
 * JD-Core Version:    0.7.0.1
 */