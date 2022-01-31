import com.tencent.qphone.base.util.QLog;
import java.io.File;

class yoc
  extends yoh
{
  yoc(ynx paramynx, long paramLong, ynu paramynu, File paramFile)
  {
    super(paramynx.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Ynu.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yoc
 * JD-Core Version:    0.7.0.1
 */