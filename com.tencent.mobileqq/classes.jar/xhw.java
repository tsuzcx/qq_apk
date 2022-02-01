import java.io.File;

final class xhw
  implements wgi
{
  xhw(File paramFile, String paramString) {}
  
  public void a(wgg paramwgg)
  {
    String str = paramwgg.b;
    if (str != null)
    {
      if ((paramwgg.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!wgw.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      xht.a(new xhz(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xhw
 * JD-Core Version:    0.7.0.1
 */