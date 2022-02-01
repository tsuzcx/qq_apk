public class two
  implements txg
{
  int jdField_a_of_type_Int = 0;
  Object jdField_a_of_type_JavaLangObject = null;
  final txg jdField_a_of_type_Txg;
  int b = -1;
  int c = -1;
  
  public two(txg paramtxg)
  {
    this.jdField_a_of_type_Txg = paramtxg;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = null;
      this.jdField_a_of_type_Int = 0;
      return;
      this.jdField_a_of_type_Txg.a(this.b, this.c);
      continue;
      this.jdField_a_of_type_Txg.b(this.b, this.c);
      continue;
      this.jdField_a_of_type_Txg.a(this.b, this.c, this.jdField_a_of_type_JavaLangObject);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 1) && (paramInt1 >= this.b) && (paramInt1 <= this.b + this.c))
    {
      this.c += paramInt2;
      this.b = Math.min(paramInt1, this.b);
      return;
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if ((this.jdField_a_of_type_Int == 3) && (paramInt1 <= this.b + this.c) && (paramInt1 + paramInt2 >= this.b) && (this.jdField_a_of_type_JavaLangObject == paramObject))
    {
      int i = this.b;
      int j = this.c;
      this.b = Math.min(paramInt1, this.b);
      this.c = (Math.max(i + j, paramInt1 + paramInt2) - this.b);
      return;
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramObject;
    this.jdField_a_of_type_Int = 3;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == 2) && (this.b >= paramInt1) && (this.b <= paramInt1 + paramInt2))
    {
      this.c += paramInt2;
      this.b = paramInt1;
      return;
    }
    a();
    this.b = paramInt1;
    this.c = paramInt2;
    this.jdField_a_of_type_Int = 2;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a();
    this.jdField_a_of_type_Txg.c(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     two
 * JD-Core Version:    0.7.0.1
 */