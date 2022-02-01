import android.view.View;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.ArrayList;

public class aton
  implements AdapterView.c
{
  public aton(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.this$0.wA.get(paramInt);
    if (paramAdapterView.isDirectory()) {
      LocalFileBrowserActivity.a(this.this$0, paramAdapterView.getPath(), true);
    }
    while (!this.this$0.akL()) {
      return;
    }
    if (atwb.d(paramAdapterView)) {
      atwb.e(paramAdapterView);
    }
    for (;;)
    {
      this.this$0.deR();
      LocalFileBrowserActivity.a(this.this$0);
      return;
      if (this.this$0.ccD) {
        atwb.clearSelected();
      }
      atwb.d(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aton
 * JD-Core Version:    0.7.0.1
 */