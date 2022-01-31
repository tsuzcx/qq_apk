import java.io.File;

class ujy
  implements Comparable<ujy>
{
  public final long a;
  public final File a;
  
  public ujy(ujx paramujx, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(ujy paramujy)
  {
    if (this.jdField_a_of_type_Long < paramujy.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramujy.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ujy
 * JD-Core Version:    0.7.0.1
 */