class vzz
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  boolean b;
  
  vzz(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static vzz a()
  {
    return new vzz(false, "");
  }
  
  static vzz a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = wba.a(paramProcess.getInputStream());; str = wba.a(paramProcess.getErrorStream())) {
      return new vzz(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzz
 * JD-Core Version:    0.7.0.1
 */