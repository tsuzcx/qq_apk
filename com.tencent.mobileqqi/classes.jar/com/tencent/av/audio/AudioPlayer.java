package com.tencent.av.audio;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;

public class AudioPlayer
  extends Thread
{
  private static final String jdField_a_of_type_JavaLangString = "MVAudio";
  static final int jdField_b_of_type_Int = 2;
  private float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 2;
  Context jdField_a_of_type_AndroidContentContext;
  AudioTrack jdField_a_of_type_AndroidMediaAudioTrack = null;
  AudioPlayDevCallBack jdField_a_of_type_ComTencentAvAudioAudioPlayDevCallBack = null;
  boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = null;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  
  public int a()
  {
    this.jdField_a_of_type_AndroidMediaAudioTrack.release();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    return 1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (true == this.jdField_a_of_type_Boolean) {
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
      this.d = AudioTrack.getMinBufferSize(this.e, this.jdField_a_of_type_Int, 2);
      if ((this.d != -2) && (this.d != -1)) {
        break;
      }
      return 0;
    }
    if (AudioSettingManager.j()) {}
    for (this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(3, this.e, this.jdField_a_of_type_Int, 2, this.d, 1); this.jdField_a_of_type_AndroidMediaAudioTrack == null; this.jdField_a_of_type_AndroidMediaAudioTrack = new AudioTrack(0, this.e, this.jdField_a_of_type_Int, 2, this.d, 1)) {
      return 0;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[this.d];
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      return 0;
    }
    this.jdField_b_of_type_ArrayOfByte = new byte[this.jdField_c_of_type_Int];
    if (this.jdField_b_of_type_ArrayOfByte == null) {
      return 0;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    return 1;
  }
  
  public int a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return 0;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_AndroidMediaAudioTrack != null) {
      this.jdField_a_of_type_AndroidMediaAudioTrack.setStereoVolume(this.jdField_a_of_type_Float, this.jdField_a_of_type_Float);
    }
  }
  
  public void a(AudioPlayDevCallBack paramAudioPlayDevCallBack)
  {
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayDevCallBack = paramAudioPlayDevCallBack;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int c()
  {
    if (true == this.jdField_a_of_type_Boolean) {
      return 1;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidMediaAudioTrack.play();
    if (this.jdField_a_of_type_AndroidMediaAudioTrack.getState() == 0) {
      return 0;
    }
    start();
    return 1;
  }
  
  public int d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return 1;
    }
    this.jdField_a_of_type_Boolean = false;
    try
    {
      join();
      this.jdField_a_of_type_AndroidMediaAudioTrack.stop();
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
  
  public int e()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidMediaAudioTrack.pause();
    return 1;
  }
  
  public void run()
  {
    Process.setThreadPriority(-19);
    int i = 0;
    while (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentAvAudioAudioPlayDevCallBack != null)
      {
        this.jdField_a_of_type_ComTencentAvAudioAudioPlayDevCallBack.b(this.jdField_b_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
        if (this.d >= this.jdField_c_of_type_Int)
        {
          this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_c_of_type_Int);
        }
        else
        {
          System.arraycopy(this.jdField_b_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, i, this.d - i);
          this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
          int j = this.d - i;
          i = this.jdField_c_of_type_Int - j;
          while (i >= this.d)
          {
            this.jdField_a_of_type_AndroidMediaAudioTrack.write(this.jdField_b_of_type_ArrayOfByte, j, this.d);
            j += this.d;
            i -= this.d;
          }
          System.arraycopy(this.jdField_b_of_type_ArrayOfByte, j, this.jdField_a_of_type_ArrayOfByte, 0, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.audio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */