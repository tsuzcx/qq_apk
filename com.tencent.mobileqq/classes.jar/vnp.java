import java.io.File;

class vnp
  implements Comparable<vnp>
{
  public long a;
  public final File a;
  
  public vnp(vno paramvno, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    paramvno = paramFile.getName();
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(paramvno);
      return;
    }
    catch (Exception paramFile)
    {
      xvv.d("Q.qqstory.cleaner:MyVideoCleanStep", "Parse %s error , %s", new Object[] { paramvno, paramFile.getMessage() });
    }
  }
  
  public int a(vnp paramvnp)
  {
    if (this.jdField_a_of_type_Long < paramvnp.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramvnp.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnp
 * JD-Core Version:    0.7.0.1
 */