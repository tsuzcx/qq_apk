import java.io.File;

class wlo
  implements Comparable<wlo>
{
  public final long a;
  public final File a;
  
  public wlo(wln paramwln, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(wlo paramwlo)
  {
    if (this.jdField_a_of_type_Long < paramwlo.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwlo.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlo
 * JD-Core Version:    0.7.0.1
 */