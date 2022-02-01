import java.io.File;

final class wnc
  implements vmc
{
  wnc(File paramFile, String paramString) {}
  
  public void a(vma paramvma)
  {
    String str = paramvma.b;
    if (str != null)
    {
      if ((paramvma.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!vmq.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      wmz.a(new wnf(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wnc
 * JD-Core Version:    0.7.0.1
 */