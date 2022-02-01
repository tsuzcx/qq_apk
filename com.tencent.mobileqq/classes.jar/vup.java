public class vup<T>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private T jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  private vup(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static <T> vup<T> a()
  {
    return new vup(0);
  }
  
  public static <T> vup<T> a(int paramInt1, int paramInt2)
  {
    return new vup(5).a(paramInt1).b(paramInt2);
  }
  
  public static <T> vup<T> a(String paramString)
  {
    return new vup(4).b(paramString);
  }
  
  public static <T> vup<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3) {
      return new vup(i);
    }
  }
  
  public static <T> vup<T> b()
  {
    return new vup(1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public vup<T> a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public vup<T> a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public vup<T> a(boolean paramBoolean, T paramT)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramT;
    return this;
  }
  
  public vup<T> a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
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
  
  public vup<T> b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public vup<T> b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vup<T> b(boolean paramBoolean)
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
  
  public vup<T> c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vup
 * JD-Core Version:    0.7.0.1
 */