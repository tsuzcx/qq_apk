import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class uiu
  implements uiz
{
  private uiu(uir paramuir) {}
  
  public void a(uja paramuja)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    ayzo localayzo = ayyu.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramuja.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    ayyx localayyx = localMessageForShortVideo.getDownloadInfo(localayzo.b);
    if (paramuja.jdField_a_of_type_Int == 2)
    {
      localayyx.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localayyx.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localayzo.a(localayyx);
      localayzo.a(new uiv(this, paramuja.jdField_a_of_type_JavaLangString));
      ayyu.a(localayzo, localQQAppInterface);
      wsv.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramuja }));
      return;
      localayyx.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localayyx.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(uja paramuja) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uiu
 * JD-Core Version:    0.7.0.1
 */