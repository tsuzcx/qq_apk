import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.tim.cloudfile.feeds.CloudPhotoListActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class atlt
  implements AdapterView.c
{
  public atlt(CloudPhotoListActivity paramCloudPhotoListActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileManagerEntity)CloudPhotoListActivity.a(this.a).get(paramInt);
    athu.a(this.a.app, this.a, paramAdapterView, CloudPhotoListActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atlt
 * JD-Core Version:    0.7.0.1
 */