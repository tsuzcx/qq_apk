import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.LruLinkedHashMap;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class fkt
  extends DownloadListener
{
  public fkt(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void c(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|task=" + paramDownloadTask);
    }
    Object localObject = this.a.a(paramDownloadTask.k, false).getAbsolutePath() + File.separatorChar + "config.json";
    File localFile = new File(this.a.a(paramDownloadTask.k, true), "config.json");
    if (!localFile.exists()) {}
    do
    {
      return;
      FileUtils.a(localFile, new File(this.a.a(paramDownloadTask.k, false), "config.json"));
      localFile.delete();
      if (QLog.isColorLevel()) {
        QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|bubbleId=" + paramDownloadTask.k + ",copy temp file to formal dir finish");
      }
      localObject = BubbleManager.a(this.a, paramDownloadTask.k, (String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleConfigDownloadListener.onDone|bubbleId=" + paramDownloadTask.k + ",createBubbleConfig bubbleConfig=" + localObject);
      }
    } while (localObject == null);
    this.a.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramDownloadTask.k), localObject);
    this.a.a(paramDownloadTask.k, "json");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fkt
 * JD-Core Version:    0.7.0.1
 */