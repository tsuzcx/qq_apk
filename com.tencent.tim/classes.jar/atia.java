import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.tim.cloudfile.CloudFileWeiYunActvitiy;

public class atia
  implements TabBarView.a
{
  public atia(CloudFileWeiYunActvitiy paramCloudFileWeiYunActvitiy) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    CloudFileWeiYunActvitiy.a(this.a).setSelected(true);
    String str = "";
    switch (paramInt2)
    {
    }
    for (;;)
    {
      this.a.etu();
      CloudFileWeiYunActvitiy.a(this.a).setMode(3);
      CloudFileWeiYunActvitiy.a(this.a).notifyDataSetChanged();
      CloudFileWeiYunActvitiy.a(this.a, str);
      return;
      str = "document";
      continue;
      str = "picture";
      continue;
      str = "video";
      continue;
      str = "music";
      continue;
      str = "other";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atia
 * JD-Core Version:    0.7.0.1
 */