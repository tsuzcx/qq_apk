public class tzm<T>
{
  private int jdField_a_of_type_Int;
  private T jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  private tzm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static <T> tzm<T> a()
  {
    return new tzm(0);
  }
  
  public static <T> tzm<T> a(String paramString)
  {
    return new tzm(4).b(paramString);
  }
  
  public static <T> tzm<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3) {
      return new tzm(i);
    }
  }
  
  public static <T> tzm<T> b()
  {
    return new tzm(1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public tzm<T> a(boolean paramBoolean, T paramT)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramT;
    return this;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public tzm<T> b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public tzm<T> b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public tzm<T> c(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzm
 * JD-Core Version:    0.7.0.1
 */