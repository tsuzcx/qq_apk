public class vxq<T>
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
  
  private vxq(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static <T> vxq<T> a()
  {
    return new vxq(0);
  }
  
  public static <T> vxq<T> a(int paramInt1, int paramInt2)
  {
    return new vxq(5).a(paramInt1).b(paramInt2);
  }
  
  public static <T> vxq<T> a(String paramString)
  {
    return new vxq(4).b(paramString);
  }
  
  public static <T> vxq<T> a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 3) {
      return new vxq(i);
    }
  }
  
  public static <T> vxq<T> b()
  {
    return new vxq(1);
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
  
  public vxq<T> a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public vxq<T> a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public vxq<T> a(boolean paramBoolean, T paramT)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangObject = paramT;
    return this;
  }
  
  public vxq<T> a(byte[] paramArrayOfByte)
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
  
  public vxq<T> b(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  public vxq<T> b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public vxq<T> b(boolean paramBoolean)
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
  
  public vxq<T> c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxq
 * JD-Core Version:    0.7.0.1
 */