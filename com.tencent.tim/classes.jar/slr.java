import com.tencent.qphone.base.util.QLog;
import java.io.File;

class slr
  implements sli.a
{
  slr(slq paramslq, long paramLong) {}
  
  public void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineMp4_M4a end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineMp4_M4aTime:" + (System.currentTimeMillis() - this.CS));
    }
    paramString1 = new File(paramString1);
    if ((paramBoolean) && (paramString1.exists()))
    {
      long l = System.currentTimeMillis();
      this.a.this$1.a(paramString1, this.a.this$1.wording, new sls(this, l));
      return;
    }
    this.a.this$1.msg = paramString2;
    this.a.this$1.a.a(this.a.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slr
 * JD-Core Version:    0.7.0.1
 */