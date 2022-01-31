import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.biz.pubaccount.util.OfflineUpdateStatus;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import java.util.HashMap;

public class bou
  implements Runnable
{
  public bou(OfflinePlugin paramOfflinePlugin) {}
  
  public void run()
  {
    if (OfflinePlugin.jdField_a_of_type_JavaUtilHashMap != null)
    {
      OfflineUpdateStatus localOfflineUpdateStatus = (OfflineUpdateStatus)OfflinePlugin.jdField_a_of_type_JavaUtilHashMap.get(OfflinePlugin.b(this.a));
      if ((localOfflineUpdateStatus != null) && (localOfflineUpdateStatus.b() == 1))
      {
        this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localOfflineUpdateStatus.c(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bou
 * JD-Core Version:    0.7.0.1
 */