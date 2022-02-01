import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class xnk
  implements aaza.c
{
  public xnk(ShortVideoRealItemBuilder paramShortVideoRealItemBuilder) {}
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte2 = new StringBuilder().append("onEncodeSuccess curMsg:");
      if (ShortVideoRealItemBuilder.a(this.this$0) == null) {
        break label120;
      }
    }
    label120:
    for (paramString2 = Long.valueOf(ShortVideoRealItemBuilder.a(this.this$0).uniseq);; paramString2 = "")
    {
      QLog.i("ShortVideoRealItemBuilder", 2, paramString2);
      if (ShortVideoRealItemBuilder.a(this.this$0) == null) {
        break;
      }
      ShortVideoRealItemBuilder.a(this.this$0).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.this$0.app, this.this$0.mContext, ShortVideoRealItemBuilder.a(this.this$0), paramString1, this.this$0).run();
      return;
    }
    ambe.j(new RuntimeException("onMediaMessageSend failed"));
  }
  
  public void onError(int paramInt)
  {
    ShortVideoRealItemBuilder localShortVideoRealItemBuilder = this.this$0;
    if (ShortVideoRealItemBuilder.a(this.this$0) != null) {}
    for (long l = ShortVideoRealItemBuilder.a(this.this$0).uniseq;; l = -1L)
    {
      ShortVideoRealItemBuilder.a(localShortVideoRealItemBuilder, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xnk
 * JD-Core Version:    0.7.0.1
 */