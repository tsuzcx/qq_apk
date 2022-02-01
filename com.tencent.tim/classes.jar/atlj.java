import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.cloudfile.feeds.CloudFeedListActivity;

public class atlj
  implements auuw.b
{
  public atlj(CloudFeedListActivity paramCloudFeedListActivity) {}
  
  public void a(auuw.a parama)
  {
    Bundle localBundle = new Bundle();
    Object localObject = null;
    int i;
    switch (parama.id)
    {
    default: 
      i = 0;
      parama = localObject;
    }
    for (;;)
    {
      if (parama != null) {}
      switch (i)
      {
      default: 
        return;
        i = 2;
        parama = "0X8008780";
        continue;
        i = 3;
        parama = "0X8008785";
        continue;
        parama = "0X8008774";
        i = 0;
      }
    }
    if (BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("CreateDocFromTemplate", false))
    {
      ault.a(this.a.app, this.a, i);
      return;
    }
    parama = CloudFeedListActivity.a(this.a).a(i);
    parama.setBundle(localBundle);
    parama.show();
    return;
    parama = CloudFeedListActivity.a(this.a).a(i);
    parama.setBundle(localBundle);
    parama.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlj
 * JD-Core Version:    0.7.0.1
 */