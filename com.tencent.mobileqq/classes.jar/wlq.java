import java.io.File;

class wlq
  implements Comparable<wlq>
{
  public long a;
  public final File a;
  
  public wlq(wlp paramwlp, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramwlp = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramwlp);
      return;
    }
    catch (Exception paramFile)
    {
      yuk.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramwlp, paramFile.getMessage() });
    }
  }
  
  public int a(wlq paramwlq)
  {
    if (this.jdField_a_of_type_Long < paramwlq.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwlq.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlq
 * JD-Core Version:    0.7.0.1
 */