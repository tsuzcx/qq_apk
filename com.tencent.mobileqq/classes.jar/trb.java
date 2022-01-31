import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.util.FaceDrawable;

class trb
  implements Runnable
{
  trb(tra paramtra, String paramString, int paramInt) {}
  
  public void run()
  {
    FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_Tra.a.app, 1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Tra.a.runOnUiThread(new trc(this, localFaceDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trb
 * JD-Core Version:    0.7.0.1
 */