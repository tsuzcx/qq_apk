import java.io.File;

class wci
  implements Comparable<wci>
{
  public final long a;
  public final File a;
  
  public wci(wch paramwch, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(wci paramwci)
  {
    if (this.jdField_a_of_type_Long < paramwci.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwci.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wci
 * JD-Core Version:    0.7.0.1
 */