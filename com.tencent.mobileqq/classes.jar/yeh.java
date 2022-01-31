import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.LebaListViewAdapter;
import com.tencent.mobileqq.adapter.LebaListViewAdapter.CornerListItemHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class yeh
  implements Runnable
{
  public yeh(LebaListViewAdapter paramLebaListViewAdapter, LebaViewItem paramLebaViewItem, String paramString, LebaListViewAdapter.CornerListItemHolder paramCornerListItemHolder) {}
  
  public void run()
  {
    Object localObject = LebaUtil.a(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strPkgName, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResURL);
    if (((File)localObject).exists())
    {
      localObject = LebaUtil.a((File)localObject);
      if (localObject == null) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LebaListViewAdapter", 2, "found bitmap from sdcard, info=" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName);
      }
      BaseApplicationImpl.sImageHashMap.put(this.jdField_a_of_type_JavaLangString, localObject);
      ((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter.a).runOnUiThread(new yei(this, (Bitmap)localObject));
    }
    label122:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("LebaListViewAdapter", 2, "can't find bitmap form cache & sdcard" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yeh
 * JD-Core Version:    0.7.0.1
 */