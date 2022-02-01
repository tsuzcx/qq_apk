import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.UploadTask;

class szi
  implements aaza.c
{
  szi(szh paramszh) {}
  
  public void a(String paramString1, byte[] paramArrayOfByte1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (szh.a(this.this$0) != null)
    {
      szh.a(this.this$0).md5 = HexUtil.bytes2HexStr(paramArrayOfByte1);
      new ShortVideoRealItemBuilder.UploadTask(this.this$0.app, this.this$0.mContext, szh.a(this.this$0), paramString1, this.this$0).run();
    }
  }
  
  public void onError(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szi
 * JD-Core Version:    0.7.0.1
 */