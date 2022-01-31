import java.io.File;

final class tir
  implements shc
{
  tir(File paramFile, String paramString) {}
  
  public void a(sha paramsha)
  {
    String str = paramsha.b;
    if (str != null)
    {
      if ((paramsha.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!shq.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      tio.a(new tiu(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tir
 * JD-Core Version:    0.7.0.1
 */