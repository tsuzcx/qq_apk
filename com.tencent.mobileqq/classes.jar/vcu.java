import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class vcu
  implements Runnable
{
  vcu(vcr paramvcr, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    FileUtils.a(new File(this.jdField_a_of_type_Vcr.b), new File(ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vcu
 * JD-Core Version:    0.7.0.1
 */