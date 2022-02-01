import android.media.AudioTrack;
import com.tencent.mobileqq.activity.voip.VoipNumberKeySoundPlay;
import java.util.HashMap;

public class ewv
  extends Thread
{
  private final AudioTrack jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, 8000, 2, 2, 1600, 0);
  private final byte[] jdField_a_of_type_ArrayOfByte = new byte[3200];
  private final double[] jdField_a_of_type_ArrayOfDouble = new double[1600];
  
  public ewv(VoipNumberKeySoundPlay paramVoipNumberKeySoundPlay, String paramString)
  {
    a(paramString);
  }
  
  private void a(String paramString)
  {
    int j = 0;
    paramString = (int[])VoipNumberKeySoundPlay.a(this.jdField_a_of_type_ComTencentMobileqqActivityVoipVoipNumberKeySoundPlay).get(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < 1600)
      {
        this.jdField_a_of_type_ArrayOfDouble[i] = ((Math.sin(i * 6.283185307179586D / (8000 / paramString[0])) + Math.sin(i * 6.283185307179586D / (8000 / paramString[1]))) / 2.0D);
        i += 1;
      }
      paramString = this.jdField_a_of_type_ArrayOfDouble;
      int k = paramString.length;
      i = 0;
      while (i < k)
      {
        int m = (short)(int)(paramString[i] * 32767.0D);
        byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        int n = j + 1;
        arrayOfByte[j] = ((byte)(m & 0xFF));
        arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        j = n + 1;
        arrayOfByte[n] = ((byte)((m & 0xFF00) >>> 8));
        i += 1;
      }
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioTrack.getState() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ewv
 * JD-Core Version:    0.7.0.1
 */