import com.tencent.qphone.base.util.QLog;
import java.io.File;

class wzj
  extends wzo
{
  wzj(wze paramwze, long paramLong, wzb paramwzb, File paramFile)
  {
    super(paramwze.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trace_video_combine", 2, "combineVideos total = " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Wzb.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzj
 * JD-Core Version:    0.7.0.1
 */