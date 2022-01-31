import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.QueryPhotoTask;

public class wud
  implements Runnable
{
  public wud(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    new PhotoListActivity.QueryPhotoTask(this.a).execute(new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wud
 * JD-Core Version:    0.7.0.1
 */