import com.tencent.mobileqq.activity.PortraitImageview;

public class czq
  implements Runnable
{
  float jdField_a_of_type_Float = 0.0F;
  float b = 0.0F;
  
  public czq(PortraitImageview paramPortraitImageview, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.c, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a(f1, 0.0F, this.d, this.c);
    float f3 = this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a(f1, 0.0F, this.e, this.c);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a(f2 - this.jdField_a_of_type_Float, f3 - this.b);
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.setImageMatrix(this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a());
    this.jdField_a_of_type_Float = f2;
    this.b = f3;
    if (f1 < this.c) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czq
 * JD-Core Version:    0.7.0.1
 */