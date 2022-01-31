package com.tencent.av.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Process;

public class AudioRecorder
  extends Thread
{
  private static final String jdField_a_of_type_JavaLangString = "MVAudio";
  static final int jdField_b_of_type_Int = 2;
  int jdField_a_of_type_Int = 2;
  Context jdField_a_of_type_AndroidContentContext;
  AudioRecord jdField_a_of_type_AndroidMediaAudioRecord = null;
  AudioRecDevCallBack jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack = null;
  boolean jdField_a_of_type_Boolean = false;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  boolean jdField_b_of_type_Boolean = false;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  private int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  
  public int a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return 0;
    }
    this.jdField_a_of_type_AndroidMediaAudioRecord.release();
    this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    return 1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (true == this.jdField_b_of_type_Boolean) {
      return 0;
    }
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.jdField_c_of_type_Int = (this.e / 1000 * paramInt2 * this.g * 2);
    return 1;
  }
  
  public int a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if (this.f == 2) {}
    for (this.jdField_a_of_type_Int = 3;; this.jdField_a_of_type_Int = 2)
    {
      this.d = AudioRecord.getMinBufferSize(this.e, this.jdField_a_of_type_Int, 2);
      if ((this.d != -2) && (this.d != -1)) {
        break;
      }
      return 0;
    }
    this.d <<= 1;
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(1, this.e, this.jdField_a_of_type_Int, 2, this.d);
      if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0) {
        return 0;
      }
    }
    catch (IllegalArgumentException paramContext)
    {
      return 0;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[this.d];
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return 0;
    }
    if (this.jdField_c_of_type_Int <= 0) {
      return 0;
    }
    if (this.d < this.jdField_c_of_type_Int)
    {
      this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int];
      if (this.jdField_b_of_type_ArrayOfByte == null) {
        return 0;
      }
    }
    this.i = 0;
    this.h = 0;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    return 1;
  }
  
  public void a(AudioRecDevCallBack paramAudioRecDevCallBack)
  {
    this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack = paramAudioRecDevCallBack;
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (!this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    boolean bool3 = this.jdField_c_of_type_Boolean;
    boolean bool1;
    if (!paramBoolean)
    {
      bool1 = true;
      label29:
      if (bool3 == bool1) {
        break label54;
      }
      if (!paramBoolean) {
        break label56;
      }
      label39:
      if (paramBoolean) {
        break label63;
      }
    }
    label54:
    label56:
    label63:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
      bool1 = false;
      break label29;
      break;
      interrupt();
      break label39;
    }
  }
  
  public int b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return 0;
      if (this.jdField_b_of_type_Boolean) {
        return 1;
      }
      this.jdField_b_of_type_Boolean = true;
      this.jdField_c_of_type_Boolean = true;
      start();
    } while (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() == 0);
    this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
    return 1;
  }
  
  public int c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return 0;
    }
    if (!this.jdField_b_of_type_Boolean) {
      return 1;
    }
    this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    try
    {
      join();
      return 1;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public void run()
  {
    this.i = 0;
    this.h = 0;
    Process.setThreadPriority(-19);
    while (this.jdField_b_of_type_Boolean) {
      if (!this.jdField_c_of_type_Boolean)
      {
        try
        {
          sleep(1000L);
        }
        catch (InterruptedException localInterruptedException) {}
      }
      else
      {
        int j;
        if (this.d >= this.jdField_c_of_type_Int)
        {
          j = this.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_c_of_type_Int);
          if ((j == this.jdField_c_of_type_Int) && (this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack != null)) {
            this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack.a(this.jdField_a_of_type_ArrayOfByte, j);
          }
        }
        else
        {
          j = this.jdField_a_of_type_AndroidMediaAudioRecord.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
          if (j == this.jdField_a_of_type_ArrayOfByte.length)
          {
            this.h = (this.i + j);
            if (this.h >= this.jdField_c_of_type_Int)
            {
              System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, this.i, this.jdField_c_of_type_Int - this.i);
              if (this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack != null) {
                this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack.a(this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
              }
              j -= this.jdField_c_of_type_Int - this.i;
              int k = this.jdField_c_of_type_Int - this.i;
              while (j >= this.jdField_c_of_type_Int)
              {
                System.arraycopy(this.jdField_a_of_type_ArrayOfByte, k, this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_c_of_type_Int);
                if (this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack != null) {
                  this.jdField_a_of_type_ComTencentAvAudioAudioRecDevCallBack.a(this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
                }
                k += this.jdField_c_of_type_Int;
                j -= this.jdField_c_of_type_Int;
              }
              this.i = j;
              System.arraycopy(this.jdField_a_of_type_ArrayOfByte, k, this.jdField_b_of_type_ArrayOfByte, 0, this.i);
            }
            else
            {
              System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_b_of_type_ArrayOfByte, this.i, j);
              this.i = (j + this.i);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.audio.AudioRecorder
 * JD-Core Version:    0.7.0.1
 */