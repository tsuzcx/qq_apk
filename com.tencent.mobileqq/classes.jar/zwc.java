import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ARRenderModel.GreetingCardRender;

class zwc
  implements Runnable
{
  zwc(zwb paramzwb, float[] paramArrayOfFloat) {}
  
  public void run()
  {
    GreetingCardRender.a(this.jdField_a_of_type_Zwb.a).native_setARCardQuaternion(this.jdField_a_of_type_ArrayOfFloat[0], this.jdField_a_of_type_ArrayOfFloat[1], this.jdField_a_of_type_ArrayOfFloat[2], this.jdField_a_of_type_ArrayOfFloat[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zwc
 * JD-Core Version:    0.7.0.1
 */