import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class wkk
  implements wkp
{
  private wkk(wkh paramwkh) {}
  
  public void a(wkq paramwkq)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    bcxn localbcxn = bcwu.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramwkq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    bcwx localbcwx = localMessageForShortVideo.getDownloadInfo(localbcxn.b);
    if (paramwkq.jdField_a_of_type_Int == 2)
    {
      localbcwx.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localbcwx.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localbcxn.a(localbcwx);
      localbcxn.a(new wkl(this, paramwkq.jdField_a_of_type_JavaLangString));
      bcwu.a(localbcxn, localQQAppInterface);
      yuk.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramwkq }));
      return;
      localbcwx.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localbcwx.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wkq paramwkq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkk
 * JD-Core Version:    0.7.0.1
 */