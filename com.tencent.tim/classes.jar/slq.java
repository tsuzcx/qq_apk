import com.tencent.qphone.base.util.QLog;
import java.io.File;

class slq
  implements sli.a
{
  slq(sli.d paramd, sli.c paramc) {}
  
  public void e(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "combineVideos end! isSuccess:" + paramBoolean + " path = " + paramString1);
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      if (this.a.aLV)
      {
        this.this$1.a.b(this.this$1);
        return;
      }
      if (this.this$1.aEE != null)
      {
        l = System.currentTimeMillis();
        this.this$1.this$0.a(paramString1, this.this$1.aEE, new slr(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      this.this$1.a(localFile, this.this$1.wording, new slt(this, l));
      return;
    }
    this.this$1.msg = paramString2;
    this.this$1.a.a(this.this$1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     slq
 * JD-Core Version:    0.7.0.1
 */