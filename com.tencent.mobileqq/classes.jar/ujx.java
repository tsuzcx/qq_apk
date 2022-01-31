import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import java.net.URL;

public class ujx
  implements Runnable
{
  public ujx(BaseBubbleBuilder paramBaseBubbleBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = AbsDownloader.a(URLDrawableHelper.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder.a.a().a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujx
 * JD-Core Version:    0.7.0.1
 */