import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;

public class dzt
  implements Runnable
{
  public dzt(PicPreDownloader paramPicPreDownloader, PicReq paramPicReq) {}
  
  public void run()
  {
    PicBusiManager.a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq, PicPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqPicPicPreDownloader));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dzt
 * JD-Core Version:    0.7.0.1
 */