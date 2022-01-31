import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class ttj
  extends QQUIEventReceiver<tti, ttd>
{
  public ttj(@NonNull tti paramtti)
  {
    super(paramtti);
  }
  
  public void a(@NonNull tti paramtti, @NonNull ttd paramttd)
  {
    if (TextUtils.equals("SendVideoToFriendHelper", paramttd.jdField_a_of_type_JavaLangString)) {}
    switch (paramttd.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    veg.a(this.TAG, "download video or picture finish. videoLocalPath = %s.", paramttd.b);
    tti.a(paramtti, false);
    paramtti.a(paramtti.jdField_a_of_type_AndroidOsBundle, paramtti.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, paramtti.jdField_a_of_type_JavaLangString, paramttd.b);
  }
  
  public Class acceptEventClass()
  {
    return ttd.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ttj
 * JD-Core Version:    0.7.0.1
 */