import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import java.util.HashMap;

public class sa
  implements Runnable
{
  public sa(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null)
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      if ((localOfflineUpdateStatus != null) && (localOfflineUpdateStatus.b() == 1))
      {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localOfflineUpdateStatus.b(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sa
 * JD-Core Version:    0.7.0.1
 */