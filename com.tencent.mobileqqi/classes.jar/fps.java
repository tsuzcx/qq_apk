import android.view.View;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter.ViewHolder;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class fps
  implements AdapterView.OnItemClickListener
{
  public fps(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
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
 * Qualified Name:     fps
 * JD-Core Version:    0.7.0.1
 */