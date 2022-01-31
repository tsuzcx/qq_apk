class xor
{
  final String jdField_a_of_type_JavaLangString;
  final boolean jdField_a_of_type_Boolean;
  boolean b;
  
  xor(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static xor a()
  {
    return new xor(false, "");
  }
  
  static xor a(Process paramProcess)
  {
    if (a(Integer.valueOf(paramProcess.exitValue()))) {}
    for (String str = xps.a(paramProcess.getInputStream());; str = xps.a(paramProcess.getErrorStream())) {
      return new xor(a(Integer.valueOf(paramProcess.exitValue())), str);
    }
  }
  
  static boolean a(Integer paramInteger)
  {
    return (paramInteger != null) && (paramInteger.intValue() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xor
 * JD-Core Version:    0.7.0.1
 */