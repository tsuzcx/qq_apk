class vng
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  boolean b;
  
  vng(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static vng a()
  {
    return new vng(false, "");
  }
  
  static vng a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = voh.a(paramProcess.getInputStream());; str = voh.a(paramProcess.getErrorStream())) {
      return new vng(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vng
 * JD-Core Version:    0.7.0.1
 */