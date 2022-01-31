import android.media.AudioRecord;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;

public class bpe
  implements Runnable
{
  public bpe(SensorAPIJavaScript paramSensorAPIJavaScript, int paramInt, String paramString) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
    short[] arrayOfShort = new short[this.jdField_a_of_type_Int];
    if (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfShort, 0, this.jdField_a_of_type_Int);
      long l = 0L;
      int i = 0;
      while (i < arrayOfShort.length)
      {
        l += arrayOfShort[i] * arrayOfShort[i];
        i += 1;
      }
      double d = Math.log10(Math.sqrt(l / j));
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        ??? = new Message();
        ((Message)???).what = 0;
        ((Message)???).obj = ("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + true + "," + d * 20.0D + ")");
        this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)???);
      }
      try
      {
        synchronized (this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_JavaLangObject.wait(100L);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidMediaAudioRecord.stop();
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidMediaAudioRecord.release();
    this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.jdField_a_of_type_AndroidMediaAudioRecord = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bpe
 * JD-Core Version:    0.7.0.1
 */