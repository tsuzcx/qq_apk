public class upy
{
  public float a;
  public long a;
  public float b = 0.0F;
  public float c = 0.0F;
  
  upy()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Long = 0L;
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  void a(upy paramupy)
  {
    this.jdField_a_of_type_Float = paramupy.jdField_a_of_type_Float;
    this.b = paramupy.b;
    this.c = paramupy.c;
    this.jdField_a_of_type_Long = paramupy.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     upy
 * JD-Core Version:    0.7.0.1
 */