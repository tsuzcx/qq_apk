import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask;

public class xdc
  implements Runnable
{
  public xdc(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    new PhotoListActivity.QueryPhotoTask(this.a).execute(new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdc
 * JD-Core Version:    0.7.0.1
 */