import java.io.File;

class uoj
  implements Comparable<uoj>
{
  public long a;
  public final File a;
  
  public uoj(uoi paramuoi, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramuoi = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramuoi);
      return;
    }
    catch (Exception paramFile)
    {
      wxe.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramuoi, paramFile.getMessage() });
    }
  }
  
  public int a(uoj paramuoj)
  {
    if (this.jdField_a_of_type_Long < paramuoj.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramuoj.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoj
 * JD-Core Version:    0.7.0.1
 */