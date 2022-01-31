import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import cooperation.qzone.UploadServerSetting;
import cooperation.qzone.UploadServerSetting.ConfigItem;

public class igw
  implements AdapterView.OnItemClickListener
{
  public igw(UploadServerSetting paramUploadServerSetting) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.a = ((BaseAdapter)paramAdapterView.getAdapter());
    if (paramInt == 4) {
      this.a.a();
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("UploadServerSetting", 2, "ShareAlbum update upload server");
        }
        IUploadService.UploadServiceCreator.getInstance().setTestServer(paramInt);
        return;
      }
      catch (Exception paramAdapterView)
      {
        paramAdapterView.printStackTrace();
      }
      paramAdapterView = (UploadServerSetting.ConfigItem)paramAdapterView.getItemAtPosition(paramInt);
      this.a.a(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     igw
 * JD-Core Version:    0.7.0.1
 */