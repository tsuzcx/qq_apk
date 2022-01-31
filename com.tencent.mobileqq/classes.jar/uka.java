import java.io.File;

class uka
  implements Comparable<uka>
{
  public long a;
  public final File a;
  
  public uka(ujz paramujz, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramujz = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramujz);
      return;
    }
    catch (Exception paramFile)
    {
      wsv.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramujz, paramFile.getMessage() });
    }
  }
  
  public int a(uka paramuka)
  {
    if (this.jdField_a_of_type_Long < paramuka.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramuka.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uka
 * JD-Core Version:    0.7.0.1
 */