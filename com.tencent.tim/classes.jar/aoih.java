import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.aio.media.aio_media.RspLatestPlayingState;

public abstract interface aoih
{
  public abstract void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, Object paramObject);
  
  public abstract void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean);
  
  public abstract void a(ToServiceMsg paramToServiceMsg, aio_media.RspLatestPlayingState paramRspLatestPlayingState);
  
  public abstract void bp(Object paramObject);
  
  public abstract void cG(String paramString, int paramInt);
  
  public abstract void q(int paramInt1, int paramInt2, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoih
 * JD-Core Version:    0.7.0.1
 */