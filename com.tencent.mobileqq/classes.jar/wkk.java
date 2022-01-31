import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wkk
  extends wkp
{
  wkk(wkf paramwkf, long paramLong, wkc paramwkc, File paramFile)
  {
    super(paramwkf.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Wkc.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wkk
 * JD-Core Version:    0.7.0.1
 */