import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

public class atwv
  extends agie
{
  long HO;
  public atww a;
  public atwy a;
  public QQAppInterface app;
  public FileManagerEntity c;
  public boolean ceF;
  
  public void as(long paramLong1, long paramLong2)
  {
    this.c.setfProgress((float)paramLong1 / (float)paramLong2);
    this.c.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.HO >= 1000L)
    {
      this.HO = paramLong1;
      this.c.setCloudType(3);
      this.app.a().a(this.c.uniseq, this.c.nSessionId, this.c.peerUin, this.c.peerType, 16, null, 0, null);
      if (QLog.isColorLevel()) {
        QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + String.valueOf(this.c.nSessionId) + "],speed:" + this.a.vq());
      }
    }
  }
  
  protected void d(boolean paramBoolean, Long paramLong)
  {
    this.a.Zs = paramLong.longValue();
    this.app.a().jp(this.c.nSessionId);
    if (paramBoolean)
    {
      paramLong = (ateh)this.app.getBusinessHandler(180);
      this.c.errCode = 0;
      paramLong.c(this.c, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atwv
 * JD-Core Version:    0.7.0.1
 */