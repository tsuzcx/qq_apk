import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class mrc
  implements mqv.a
{
  mrc(mra parammra) {}
  
  public void L(float paramFloat)
  {
    mra.a(this.a, paramFloat);
  }
  
  public void aDx()
  {
    mra.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void e(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      mra.a(this.a, 4);
      if (QLog.isColorLevel()) {
        QLog.d("VideoDeliverController", 2, "mVideoTransProcessorHandler mVideoMd5=" + paramString2 + ", mVideoUuid=" + paramString3 + ", mVideoUrl=" + paramString1);
      }
      mra.b(this.a, NetConnInfoCenter.getServerTimeMillis());
      kbp.a(mra.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(mra.a(this.a)), String.valueOf(mra.b(this.a)), String.valueOf(mra.c(this.a) - mra.d(this.a)), String.valueOf(mra.e(this.a) - mra.f(this.a)));
      mra.a(this.a, 0, mra.a(this.a), mra.b(this.a), paramString1, paramString2, paramString3);
      paramString1 = mqt.a().a(mra.a(this.a)).b(mra.b(this.a)).d(paramString2).c(paramString1).e(paramString3).a(mra.b(this.a)).b(mra.g(this.a)).a();
      mra.a(this.a, paramString1);
      return;
    case 1001: 
      mra.b(this.a, 6);
      return;
    case 1002: 
      mra.b(this.a, 5);
      return;
    case 1003: 
      mra.b(this.a, 7);
      return;
    case 1004: 
      mra.b(this.a, 7);
      mra.c(this.a, 1004);
      kbp.a(mra.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(mra.a(this.a)), String.valueOf(mra.b(this.a)), String.valueOf(mra.c(this.a) - mra.d(this.a)), String.valueOf(mra.e(this.a) - mra.f(this.a)));
      return;
    }
    mra.b(this.a, 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mrc
 * JD-Core Version:    0.7.0.1
 */