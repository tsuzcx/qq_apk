import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.ImageFileAdapter.ViewHolder;
import com.tencent.mobileqq.filemanager.data.OfflineFileAdapter.CloudFileItemHolder;
import com.tencent.mobileqq.filemanager.data.WeiYunFileAdapter.WeiYunFileItemHolder;
import com.tencent.qphone.base.util.QLog;

public class fpy
  implements View.OnClickListener
{
  public fpy(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.a.a == 9L)
    {
      i = ((OfflineFileAdapter.CloudFileItemHolder)paramView.getTag()).a;
      if (i == -1) {
        break label81;
      }
      CloudFileBrowserActivity.a(this.a, i);
    }
    label81:
    while (!QLog.isColorLevel())
    {
      return;
      if (this.a.a == 10L)
      {
        i = ((ImageFileAdapter.ViewHolder)paramView.getTag()).a;
        break;
      }
      i = ((WeiYunFileAdapter.WeiYunFileItemHolder)paramView.getTag()).a;
      break;
    }
    QLog.d(CloudFileBrowserActivity.b, 2, "get position err, bug");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpy
 * JD-Core Version:    0.7.0.1
 */