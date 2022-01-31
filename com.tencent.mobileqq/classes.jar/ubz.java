public class ubz<T>
{
  private int jdField_a_of_type_Int;
  private T jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  private ubz(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static <T> ubz<T> a()
  {
    return new ubz(0);
  }
  
  public static <T> ubz<T> a(int paramInt1, int paramInt2)
  {
    return new ubz(5).a(paramInt1).b(paramInt2);
  }
  
  public static <T> ubz<T> a(String paramString)
  {
    return new ubz(4).b(paramString);
  }
  
  public static <T> ubz<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3) {
      return new ubz(i);
    }
  }
  
  public static <T> ubz<T> b()
  {
    return new ubz(1);
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
  
  public ubz<T> a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ubz<T> a(boolean paramBoolean, T paramT)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramT;
    return this;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public ubz<T> b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public ubz<T> b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ubz<T> b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public ubz<T> c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubz
 * JD-Core Version:    0.7.0.1
 */