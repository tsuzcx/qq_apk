import android.view.View;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter.ViewHolder;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class fpt
  implements AdapterView.OnItemClickListener
{
  public fpt(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ImageFileAdapter.ViewHolder)paramView.getTag();
    paramInt = this.a.a.b(paramInt);
    this.a.a.getClass();
    if (paramInt == 1)
    {
      paramInt = paramAdapterView.a;
      CloudFileBrowserActivity.a(this.a, paramInt);
      return;
    }
    CloudFileBrowserActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpt
 * JD-Core Version:    0.7.0.1
 */