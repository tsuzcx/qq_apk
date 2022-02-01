import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.tim.cloudfile.anima.CloudTeamWorkAnimActivity;

public class urb
  implements auuw.b
{
  public urb(CloudFileActivity paramCloudFileActivity) {}
  
  public void a(auuw.a parama)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    atgc localatgc = (atgc)this.this$0.app.getManager(373);
    switch (parama.id)
    {
    default: 
      parama = null;
    }
    while ((parama == null) || (i == -1))
    {
      return;
      parama = new Intent(this.this$0.getApplicationContext(), LiteActivity.class);
      try
      {
        localBundle.putLong("category", 12L);
        parama.putExtra("bundle", localBundle);
        parama.putExtra("from", "FileAssistant");
        this.this$0.startActivityForResult(parama, 101);
        i = 10;
        parama = null;
      }
      catch (Exception parama)
      {
        for (;;)
        {
          parama.printStackTrace();
        }
      }
      i = 2;
      parama = "0X800877F";
      anpc.report("tim_mine_tab_file_click_r_plus_click_add_tencent_file");
      continue;
      i = 3;
      parama = "0X8008784";
      continue;
      i = 8;
      parama = "0X80099D7";
      continue;
      i = 9;
      parama = null;
      continue;
      anpc.report("tim_mine_tab_file_click_r_plus_click_cloud_file_click");
      localBundle.putByteArray("key_parent_dir_key", localatgc.aG());
      parama = "0X8008773";
      continue;
      i = 1;
      anpc.report("tim_mine_tab_file_click_r_plus_click_cloud_folder_click");
      localBundle.putByteArray("key_parent_dir_key", localatgc.aE());
      parama = "0X800878A";
      continue;
      aakj.a(this.this$0, 4L, 0L, 0);
      anpc.report("tim_mine_tab_file_click_r_plus_click_file_scan_click");
      parama = null;
      i = -1;
    }
    switch (i)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      return;
    case 0: 
    case 1: 
      parama = CloudFileActivity.a(this.this$0).a(i);
      parama.setBundle(localBundle);
      parama.show();
      return;
    }
    parama = new Intent(this.this$0.getActivity(), CloudTeamWorkAnimActivity.class);
    parama.putExtra("create_type", i);
    this.this$0.getActivity().startActivity(parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     urb
 * JD-Core Version:    0.7.0.1
 */