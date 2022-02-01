import java.io.File;

class wck
  implements Comparable<wck>
{
  public long a;
  public final File a;
  
  public wck(wcj paramwcj, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramwcj = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramwcj);
      return;
    }
    catch (Exception paramFile)
    {
      ykq.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramwcj, paramFile.getMessage() });
    }
  }
  
  public int a(wck paramwck)
  {
    if (this.jdField_a_of_type_Long < paramwck.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwck.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wck
 * JD-Core Version:    0.7.0.1
 */