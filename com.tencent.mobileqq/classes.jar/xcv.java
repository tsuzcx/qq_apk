import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import java.util.ArrayList;
import java.util.List;

public class xcv
  implements Runnable
{
  public xcv(PhotoListActivity paramPhotoListActivity, List paramList) {}
  
  public void run()
  {
    Object localObject = new ArrayList();
    ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
    if (localObject != null)
    {
      int i = 0;
      if (i < ((List)localObject).size())
      {
        LocalMediaInfo localLocalMediaInfo = (LocalMediaInfo)((List)localObject).get(i);
        if ((localLocalMediaInfo.mediaWidth <= 0) || (localLocalMediaInfo.mediaHeight <= 0)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight == 2.0F) || (localLocalMediaInfo.mediaWidth / localLocalMediaInfo.mediaHeight >= 4.0F) || (localLocalMediaInfo.mediaHeight / localLocalMediaInfo.mediaWidth >= 4.0F)) {
            PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, localLocalMediaInfo);
          } else {
            localLocalMediaInfo.panoramaPhotoType = 3;
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a.obtainMessage();
      ((Message)localObject).what = 4;
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a.sendMessage((Message)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xcv
 * JD-Core Version:    0.7.0.1
 */