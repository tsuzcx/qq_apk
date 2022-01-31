import java.io.File;

final class tvn
  implements sty
{
  tvn(File paramFile, String paramString) {}
  
  public void a(stw paramstw)
  {
    String str = paramstw.b;
    if (str != null)
    {
      if ((paramstw.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!sum.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      tvk.a(new tvq(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tvn
 * JD-Core Version:    0.7.0.1
 */