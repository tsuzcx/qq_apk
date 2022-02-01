import com.tencent.qphone.base.util.QLog;
import java.io.File;

class zqd
  implements zpy
{
  zqd(zqc paramzqc, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineMp4_M4a end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineMp4_M4aTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    paramString1 = new File(paramString1);
    if ((paramBoolean) && (paramString1.exists()))
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_Zqc.a.a(paramString1, this.jdField_a_of_type_Zqc.a.b, new zqe(this, l));
      return;
    }
    this.jdField_a_of_type_Zqc.a.d = paramString2;
    this.jdField_a_of_type_Zqc.a.a.a(this.jdField_a_of_type_Zqc.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqd
 * JD-Core Version:    0.7.0.1
 */