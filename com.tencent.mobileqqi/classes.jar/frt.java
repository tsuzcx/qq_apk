import android.view.View;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

public class frt
  implements AdapterView.OnItemClickListener
{
  public frt(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (FileInfo)this.a.a.get(paramInt);
    if (paramAdapterView.a()) {
      LocalFileBrowserActivity.a(this.a, paramAdapterView.c(), true);
    }
    while (!this.a.g()) {
      return;
    }
    if (FMDataCache.a(paramAdapterView)) {
      FMDataCache.b(paramAdapterView);
    }
    for (;;)
    {
      this.a.f();
      LocalFileBrowserActivity.a(this.a);
      return;
      FMDataCache.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     frt
 * JD-Core Version:    0.7.0.1
 */