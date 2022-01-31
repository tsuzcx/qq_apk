package com.tencent.mobileqq.magicface.model;

import android.media.AudioRecord;

public class RecordVolume
  implements Runnable
{
  private static int b = 8000;
  private int jdField_a_of_type_Int;
  private AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private RecordVolume.RecordVolumeListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public RecordVolume(RecordVolume.RecordVolumeListener paramRecordVolumeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener = paramRecordVolumeListener;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_Int = AudioRecord.getMinBufferSize(b, 2, 2);
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, b, 2, 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
      arrayOfByte = new byte[this.jdField_a_of_type_Int];
      this.jdField_a_of_type_Boolean = true;
      if (!this.jdField_a_of_type_Boolean) {}
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte;
          int j = this.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfByte, 0, this.jdField_a_of_type_Int);
          long l = 0L;
          int i = 0;
          if (i < arrayOfByte.length)
          {
            int k = arrayOfByte[i];
            int m = arrayOfByte[i];
            l += k * m;
            i += 1;
            continue;
            localException = localException;
            localException.printStackTrace();
          }
          else
          {
            double d = l / j;
            d = Math.log10(d);
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume$RecordVolumeListener.a((int)(d * 10.0D));
            }
            Thread.sleep(100L);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.model.RecordVolume
 * JD-Core Version:    0.7.0.1
 */