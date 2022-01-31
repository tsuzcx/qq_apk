import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ysr
  extends ysw
{
  ysr(ysm paramysm, long paramLong, ysj paramysj, File paramFile)
  {
    super(paramysm.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Ysj.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ysr
 * JD-Core Version:    0.7.0.1
 */