import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qwallet.PreloadImgManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import java.util.List;
import java.util.Map;

public class xga
  extends DownloadListener
{
  public xga(PreloadImgManager paramPreloadImgManager, AppInterface paramAppInterface) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    List localList = (List)PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager).get(paramDownloadTask.c);
    if (paramDownloadTask.c.endsWith(".zip")) {
      PreloadImgManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadTask.c, localList);
    }
    while (!paramDownloadTask.c.endsWith(".png")) {
      return;
    }
    PreloadImgManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadImgManager, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramDownloadTask.c, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xga
 * JD-Core Version:    0.7.0.1
 */