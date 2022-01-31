import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.BasePicOprerator;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import java.io.File;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class dzn
  implements Runnable
{
  public dzn(BasePicOprerator paramBasePicOprerator, DownCallBack.DownResult paramDownResult) {}
  
  public void run()
  {
    Object localObject;
    PicStatisticsManager localPicStatisticsManager;
    long l;
    if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null))
    {
      localObject = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b);
      if (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.a == 0)
      {
        localPicStatisticsManager = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
        if (localPicStatisticsManager != null)
        {
          l = ((File)localObject).length();
          switch (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.c)
          {
          }
        }
      }
    }
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (((PicPreDownloader)localObject).c.contains(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq))
      {
        ((PicPreDownloader)localObject).c.remove(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq);
        ((PicPreDownloader)localObject).a.decrementAndGet();
        Logger.a("PIC_TAG_PRELOAD", "onDownload", "uniseq:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.a + ",cmd:" + this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.i + ",curHandingNum:" + ((PicPreDownloader)localObject).a.get());
        if ((this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b != null) && (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size == 0L))
        {
          l = new File(this.jdField_a_of_type_ComTencentMobileqqPicDownCallBack$DownResult.b).length();
          this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, l);
        }
        this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d();
      }
      return;
      localPicStatisticsManager.a(13059, l);
      continue;
      localPicStatisticsManager.a(13060, l);
      localPicStatisticsManager.a(this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.width, this.jdField_a_of_type_ComTencentMobileqqPicBasePicOprerator.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.height);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dzn
 * JD-Core Version:    0.7.0.1
 */