import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class wbe
  implements wbj
{
  private wbe(wbb paramwbb) {}
  
  public void a(wbk paramwbk)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    bcxr localbcxr = bcwz.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramwbk.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    bcxb localbcxb = localMessageForShortVideo.getDownloadInfo(localbcxr.b);
    if (paramwbk.jdField_a_of_type_Int == 2)
    {
      localbcxb.i = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      localbcxb.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localbcxr.a(localbcxb);
      localbcxr.a(new wbf(this, paramwbk.jdField_a_of_type_JavaLangString));
      bcwz.a(localbcxr, localQQAppInterface);
      ykq.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramwbk }));
      return;
      localbcxb.h = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
      localbcxb.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(wbk paramwbk) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbe
 * JD-Core Version:    0.7.0.1
 */