import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantActivity;

public class gjl
  implements Runnable
{
  public gjl(QZoneShareAlbumAssistantActivity paramQZoneShareAlbumAssistantActivity) {}
  
  public void run()
  {
    QZoneShareAlbumAssistantActivity.a(this.a).a(QZoneShareAlbumAssistantActivity.b(this.a));
    QZoneShareAlbumAssistantActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gjl
 * JD-Core Version:    0.7.0.1
 */