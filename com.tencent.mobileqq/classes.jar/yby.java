class yby
{
  private int jdField_a_of_type_Int;
  private short[] jdField_a_of_type_ArrayOfShort;
  private int b;
  
  public yby(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_ArrayOfShort = new short[paramInt];
    }
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
  }
  
  public void a(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ArrayOfShort == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ArrayOfShort.length - this.jdField_a_of_type_Int < paramInt2) {
          break;
        }
        System.arraycopy(paramArrayOfShort, paramInt1, this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_Int, paramInt2);
        this.jdField_a_of_type_Int += paramInt2;
        if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfShort.length) {
          this.jdField_a_of_type_Int = 0;
        }
        this.b += paramInt2;
      } while (this.b <= this.jdField_a_of_type_ArrayOfShort.length);
      this.b = this.jdField_a_of_type_ArrayOfShort.length;
      return;
      System.arraycopy(paramArrayOfShort, paramInt1, this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfShort.length - this.jdField_a_of_type_Int);
      System.arraycopy(paramArrayOfShort, this.jdField_a_of_type_ArrayOfShort.length + paramInt1 - this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfShort, 0, paramInt2 - (this.jdField_a_of_type_ArrayOfShort.length - this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Int = (paramInt2 - (this.jdField_a_of_type_ArrayOfShort.length - this.jdField_a_of_type_Int));
      if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfShort.length) {
        this.jdField_a_of_type_Int = 0;
      }
      this.b += paramInt2;
    } while (this.b <= this.jdField_a_of_type_ArrayOfShort.length);
    this.b = this.jdField_a_of_type_ArrayOfShort.length;
  }
  
  public short[] a()
  {
    if ((this.jdField_a_of_type_ArrayOfShort == null) || (this.b == 0) || (this.b > this.jdField_a_of_type_ArrayOfShort.length)) {
      return null;
    }
    short[] arrayOfShort = new short[this.b];
    if (this.jdField_a_of_type_Int >= this.b)
    {
      System.arraycopy(this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_Int - this.b, arrayOfShort, 0, this.b);
      return arrayOfShort;
    }
    System.arraycopy(this.jdField_a_of_type_ArrayOfShort, this.jdField_a_of_type_ArrayOfShort.length - (this.b - this.jdField_a_of_type_Int), arrayOfShort, 0, this.b - this.jdField_a_of_type_Int);
    System.arraycopy(this.jdField_a_of_type_ArrayOfShort, 0, arrayOfShort, this.b - this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yby
 * JD-Core Version:    0.7.0.1
 */