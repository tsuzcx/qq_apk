import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.utils.AlbumUtil;
import java.util.Map;

public class wum
  implements Runnable
{
  public wum(PhotoListActivity paramPhotoListActivity, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_JavaLangString);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    AlbumUtil.a(localLocalMediaInfo, str);
    PhotoListActivity.a().put(str, localLocalMediaInfo);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wum
 * JD-Core Version:    0.7.0.1
 */