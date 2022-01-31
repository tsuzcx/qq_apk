import android.os.Bundle;
import com.tencent.mobileqq.bubble.AnimationConfig;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.BubbleInfoLruCache;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class fpi
  extends DownloadListener
{
  public fpi(BubbleManager paramBubbleManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onStart| task:" + paramDownloadTask);
    }
    String str = paramDownloadTask.a().getString("name");
    BubbleManager.a(this.a, "Bubble_download", paramDownloadTask.k, str);
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onCancel| task:" + paramDownloadTask);
    }
    String str = paramDownloadTask.a().getString("name");
    BubbleManager.a(this.a, "Bubble_download_cancel", paramDownloadTask.k, str);
  }
  
  public void c(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BubbleManager.jdField_a_of_type_JavaLangString, 2, "bubbleDownloadListener.onDone| task:" + paramDownloadTask);
    }
    if (paramDownloadTask.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == -1) {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramDownloadTask.k, -1, paramDownloadTask.a());
      }
    }
    String str;
    do
    {
      return;
      str = paramDownloadTask.a().getString("name");
    } while (str == null);
    Object localObject1;
    if ("all.zip".equals(str))
    {
      localObject1 = this.a.a(paramDownloadTask.k, false);
      if (DownloaderFactory.a(paramDownloadTask.jdField_a_of_type_JavaIoFile, (File)localObject1))
      {
        if (BubbleManager.a(this.a, paramDownloadTask.k, false)) {
          this.a.a(paramDownloadTask.k, null);
        }
        if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId"))) {
          this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramDownloadTask.k, 3, paramDownloadTask.a());
        }
      }
    }
    for (;;)
    {
      BubbleManager.a(this.a, "Bubble_download_succ", paramDownloadTask.k, str);
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramDownloadTask.a().containsKey("callbackId")))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramDownloadTask.k, -2, paramDownloadTask.a());
        continue;
        Object localObject2 = new File(this.a.a(paramDownloadTask.k, true), str);
        int i = str.lastIndexOf(".zip");
        if (i < 0) {
          break;
        }
        localObject1 = str.substring(0, i);
        if (DownloaderFactory.a((File)localObject2, new File(this.a.a(paramDownloadTask.k, false), (String)localObject1))) {
          if ("static".equals(localObject1))
          {
            if (BubbleManager.a(this.a, paramDownloadTask.k, false)) {
              this.a.a(paramDownloadTask.k, "static");
            }
          }
          else
          {
            localObject2 = BubbleManager.a(this.a, paramDownloadTask.k, (String)localObject1);
            localObject2 = this.a.a(paramDownloadTask.k, (AnimationConfig)localObject2, false);
            if (localObject2 != null)
            {
              BubbleInfo localBubbleInfo = (BubbleInfo)this.a.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramDownloadTask.k));
              if (localBubbleInfo != null) {
                localBubbleInfo.a.add(localObject2);
              }
              this.a.a(paramDownloadTask.k, (String)localObject1);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fpi
 * JD-Core Version:    0.7.0.1
 */