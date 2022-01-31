import java.io.File;

class uoh
  implements Comparable<uoh>
{
  public final long a;
  public final File a;
  
  public uoh(uog paramuog, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(uoh paramuoh)
  {
    if (this.jdField_a_of_type_Long < paramuoh.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramuoh.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uoh
 * JD-Core Version:    0.7.0.1
 */