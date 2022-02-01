import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;

class vmj
  implements vmo
{
  private vmj(vmg paramvmg) {}
  
  public void a(vmp paramvmp)
  {
    QQStoryContext.a();
    QQAppInterface localQQAppInterface = QQStoryContext.a();
    bbqx localbbqx = bbqf.a(2, 2);
    MessageForShortVideo localMessageForShortVideo = paramvmp.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    bbqh localbbqh = localMessageForShortVideo.getDownloadInfo(localbbqx.b);
    if (paramvmp.jdField_a_of_type_Int == 2)
    {
      localbbqh.i = ShortVideoUtils.getShortVideoThumbPicPath(localMessageForShortVideo.thumbMD5, "jpg");
      localbbqh.a(localMessageForShortVideo.istroop, 1);
    }
    for (;;)
    {
      localbbqx.a(localbbqh);
      localbbqx.a(new vmk(this, paramvmp.jdField_a_of_type_JavaLangString));
      bbqf.a(localbbqx, localQQAppInterface);
      xvv.b("AsyncFileDownloader", String.format("start download with shortvideo downloader, task = %s", new Object[] { paramvmp }));
      return;
      localbbqh.h = ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4");
      localbbqh.a(localMessageForShortVideo.istroop, 0);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b(vmp paramvmp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */