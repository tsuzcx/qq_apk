import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.List;

class xaj
  implements Runnable
{
  xaj(xai paramxai, DownloadTask paramDownloadTask) {}
  
  public void run()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.size();
    Bundle localBundle = this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a();
    int i = 0;
    while (i < j)
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a.get(i);
      PreloadImgManager.a(this.jdField_a_of_type_Xai.a, BaseApplication.getContext(), localBundle.getString(str), str);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xaj
 * JD-Core Version:    0.7.0.1
 */