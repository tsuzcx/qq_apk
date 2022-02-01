import com.tencent.qphone.base.util.QLog;
import java.io.File;

class slt
  implements sli.a
{
  slt(slq paramslq, long paramLong) {}
  
  public void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineWordingTime:" + (System.currentTimeMillis() - this.CT));
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      this.a.a.aED = paramString1;
      this.a.this$1.a.b(this.a.this$1);
      this.a.this$1.runNext();
      return;
    }
    this.a.this$1.msg = paramString2;
    this.a.this$1.a.a(this.a.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slt
 * JD-Core Version:    0.7.0.1
 */