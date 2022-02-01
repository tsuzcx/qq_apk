import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tim.cloudfile.CloudFileListFragment;
import java.util.Arrays;

public class atfo
  implements auuw.b
{
  public atfo(CloudFileListFragment paramCloudFileListFragment) {}
  
  public void a(auuw.a parama)
  {
    int j = 0;
    Bundle localBundle = new Bundle();
    int i = j;
    switch (parama.id)
    {
    default: 
      i = j;
    }
    while (i == -1)
    {
      return;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      parama = (atgc)CloudFileListFragment.k(this.this$0).getManager(373);
      if (Arrays.equals(CloudFileListFragment.a(this.this$0), parama.aG()))
      {
        i = j;
      }
      else
      {
        i = j;
        continue;
        i = 1;
        continue;
        if (CloudFileListFragment.a(this.this$0) != null) {
          aakj.a(this.this$0.getActivity(), 0L, 0L, 0);
        }
        i = -1;
      }
    }
    switch (i)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 0: 
    case 1: 
      if (CloudFileListFragment.a(this.this$0) != null)
      {
        localBundle.putByteArray("key_parent_dir_key", CloudFileListFragment.a(this.this$0).Y());
        localBundle.putString("key_parent_dir_name", CloudFileListFragment.a(this.this$0).getName());
      }
      parama = CloudFileListFragment.a(this.this$0).a(i);
      parama.setBundle(localBundle);
      parama.show();
      return;
    }
    if (BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("CreateDocFromTemplate", true))
    {
      this.this$0.aam(i);
      return;
    }
    if (CloudFileListFragment.a(this.this$0) != null)
    {
      localBundle.putByteArray("key_parent_dir_key", CloudFileListFragment.a(this.this$0).Y());
      localBundle.putString("key_parent_dir_name", CloudFileListFragment.a(this.this$0).getName());
    }
    parama = CloudFileListFragment.a(this.this$0).a(i);
    parama.setBundle(localBundle);
    parama.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atfo
 * JD-Core Version:    0.7.0.1
 */