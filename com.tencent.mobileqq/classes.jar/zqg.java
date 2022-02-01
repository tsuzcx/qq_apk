import com.tencent.qphone.base.util.QLog;
import java.io.File;

class zqg
  extends zql
{
  zqg(zqb paramzqb, long paramLong, zpy paramzpy, File paramFile)
  {
    super(paramzqb.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Zpy.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqg
 * JD-Core Version:    0.7.0.1
 */