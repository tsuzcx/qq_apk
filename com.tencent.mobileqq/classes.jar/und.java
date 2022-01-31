import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class und
  implements uni
{
  private und(una paramuna) {}
  
  public void a(unj paramunj)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    azdx localazdx = azdd.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramunj.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    azdg localazdg = localMessageForShortVideo.getDownloadInfo(localazdx.b);
    if (paramunj.jdField_a_of_type_Int == 2)
    {
      localazdg.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localazdg.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localazdx.a(localazdg);
      localazdx.a(new une(this, paramunj.jdField_a_of_type_JavaLangString));
      azdd.a(localazdx, localQQAppInterface);
      wxe.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramunj }));
      return;
      localazdg.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localazdg.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(unj paramunj) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     und
 * JD-Core Version:    0.7.0.1
 */