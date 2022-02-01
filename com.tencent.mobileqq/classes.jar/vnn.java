import java.io.File;

class vnn
  implements Comparable<vnn>
{
  public final long a;
  public final File a;
  
  public vnn(vnm paramvnm, File paramFile)
  {
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Long = paramFile.lastModified();
  }
  
  public int a(vnn paramvnn)
  {
    if (this.jdField_a_of_type_Long < paramvnn.jdField_a_of_type_Long) {
      return -1;
    }
    if (this.jdField_a_of_type_Long == paramvnn.jdField_a_of_type_Long) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnn
 * JD-Core Version:    0.7.0.1
 */