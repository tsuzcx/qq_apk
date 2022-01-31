import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.TraeAudioManager;

public class hzf
  extends hzg
{
  public hzf(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void a()
  {
    int j = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, true);
    e();
    int i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, " _run:" + a() + " _running:" + this.jdField_a_of_type_Boolean);
      i = j;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn() != true) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, true);
        }
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label123:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label123;
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hzf
 * JD-Core Version:    0.7.0.1
 */