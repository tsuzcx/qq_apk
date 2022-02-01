import java.io.File;

final class xbx
  implements wax
{
  xbx(File paramFile, String paramString) {}
  
  public void a(wav paramwav)
  {
    String str = paramwav.b;
    if (str != null)
    {
      if ((paramwav.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!wbl.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      xbu.a(new xca(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbx
 * JD-Core Version:    0.7.0.1
 */