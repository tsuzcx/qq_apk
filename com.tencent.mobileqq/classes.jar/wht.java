import java.io.File;

class wht
  implements Comparable<wht>
{
  public final long a;
  public final File a;
  
  public wht(whs paramwhs, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(wht paramwht)
  {
    if (this.jdField_a_of_type_Long < paramwht.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramwht.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wht
 * JD-Core Version:    0.7.0.1
 */