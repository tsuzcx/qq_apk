import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter;
import com.tencent.mobileqq.adapter.LebaListMgrAdapter.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LebaUtil;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class yee
  implements Runnable
{
  public yee(LebaListMgrAdapter paramLebaListMgrAdapter, LebaViewItem paramLebaViewItem, String paramString, LebaListMgrAdapter.ViewHolder paramViewHolder) {}
  
  public void run()
  {
    Object localObject = LebaUtil.a(LebaListMgrAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter), this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strPkgName, this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResURL);
    if (((File)localObject).exists())
    {
      localObject = LebaUtil.a((File)localObject);
      if (localObject == null) {
        break label122;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.lebatab.mgr", 2, "found bitmap from sdcard, info=" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName);
      }
      BaseApplicationImpl.sImageHashMap.put(this.jdField_a_of_type_JavaLangString, localObject);
      ((BaseActivity)LebaListMgrAdapter.a(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListMgrAdapter)).runOnUiThread(new yef(this, (Bitmap)localObject));
    }
    label122:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.lebatab.mgr", 2, "can't find bitmap form cache & sdcard" + this.jdField_a_of_type_ComTencentMobileqqConfigStructLebaViewItem.a.strResName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yee
 * JD-Core Version:    0.7.0.1
 */