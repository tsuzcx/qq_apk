import com.tencent.mobileqq.activity.PortraitImageview;

public class czq
  implements Runnable
{
  public czq(PortraitImageview paramPortraitImageview, float paramFloat1, long paramLong, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    float f1 = Math.min(this.jdField_a_of_type_Float, (float)(l - this.jdField_a_of_type_Long));
    float f2 = this.b;
    float f3 = this.c;
    this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a(f2 + f3 * f1, this.d, this.e);
    if (f1 < this.jdField_a_of_type_Float) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.post(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     czq
 * JD-Core Version:    0.7.0.1
 */