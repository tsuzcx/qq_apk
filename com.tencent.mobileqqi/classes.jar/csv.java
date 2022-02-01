import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.config.DownloadIconsListener;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import java.io.File;
import java.util.HashMap;

public class csv
  extends DownloadIconsListener
{
  public csv(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    int k = 0;
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {}
    label209:
    label210:
    for (;;)
    {
      return;
      int m = LebaListMgrActivity.a(this.a).getCount();
      int j = 0;
      int i = k;
      if (j < m)
      {
        Object localObject = (LebaViewItem)LebaListMgrActivity.a(this.a).getItem(j);
        if ((((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null) && (paramString.equals(((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName)))
        {
          ((LebaViewItem)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramBitmap);
          j = 1;
          localObject = LebaShowListManager.a(this.a.a(), paramString, ((LebaViewItem)localObject).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
          i = j;
          if (localObject == null) {
            break label209;
          }
          i = j;
          if (paramBitmap == null) {
            break label209;
          }
          i = j;
          if (LebaShowListManager.a().a.containsKey(((File)localObject).getAbsolutePath())) {
            break label209;
          }
          LebaShowListManager.a().a.put(((File)localObject).getAbsolutePath(), paramBitmap);
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label210;
        }
        this.a.runOnUiThread(new csw(this, paramString));
        return;
        j += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     csv
 * JD-Core Version:    0.7.0.1
 */