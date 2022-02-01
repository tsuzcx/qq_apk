import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class wgp
  implements wgu
{
  private wgp(wgm paramwgm) {}
  
  public void a(wgv paramwgv)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    bcev localbcev = bcec.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramwgv.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    bcef localbcef = localMessageForShortVideo.getDownloadInfo(localbcev.b);
    if (paramwgv.jdField_a_of_type_Int == 2)
    {
      localbcef.i = ShortVideoUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      localbcef.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localbcev.a(localbcef);
      localbcev.a(new wgq(this, paramwgv.jdField_a_of_type_JavaLangString));
      bcec.a(localbcev, localQQAppInterface);
      yqp.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramwgv }));
      return;
      localbcef.h = ShortVideoUtils.a(localMessageForShortVideo, "mp4");
      localbcef.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wgv paramwgv) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgp
 * JD-Core Version:    0.7.0.1
 */