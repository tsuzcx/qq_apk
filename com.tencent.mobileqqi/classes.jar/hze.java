import android.media.AudioManager;
import com.tencent.sharp.jni.TraeAudioManager;

public class hze
  extends hzg
{
  public hze(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public String a()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.setWiredHeadsetOn(true);
    e();
    int i = 0;
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean == true)
      {
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn()) {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_AndroidContentContext, false);
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
            label83:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label83;
        }
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hze
 * JD-Core Version:    0.7.0.1
 */