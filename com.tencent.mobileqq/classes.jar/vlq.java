import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask.ResultListener;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;

public class vlq
  implements EncodeVideoTask.ResultListener
{
  public vlq(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(int paramInt)
  {
    ShortVideoRealItemBuilder.a(this.a);
  }
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (ShortVideoRealItemBuilder.a(this.a) != null)
    {
      ShortVideoRealItemBuilder.a(this.a).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, ShortVideoRealItemBuilder.a(this.a), paramString1, this.a).run();
      return;
    }
    ShortVideoExceptionReporter.a(new RuntimeException("onMediaMessageSend failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vlq
 * JD-Core Version:    0.7.0.1
 */