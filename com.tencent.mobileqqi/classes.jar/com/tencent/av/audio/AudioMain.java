package com.tencent.av.audio;

import android.content.Context;
import com.tencent.av.core.IVcAudioData;
import com.tencent.qphone.base.util.QLog;

public class AudioMain
  implements AudioPlayDevCallBack, AudioRecDevCallBack
{
  private static final String jdField_a_of_type_JavaLangString = "MVAudio";
  private int jdField_a_of_type_Int = 204;
  long jdField_a_of_type_Long = 0L;
  Context jdField_a_of_type_AndroidContentContext;
  AudioPlayer jdField_a_of_type_ComTencentAvAudioAudioPlayer = null;
  AudioRecorder jdField_a_of_type_ComTencentAvAudioAudioRecorder = null;
  AudioSettingManager jdField_a_of_type_ComTencentAvAudioAudioSettingManager;
  IVcAudioData jdField_a_of_type_ComTencentAvCoreIVcAudioData = null;
  boolean jdField_a_of_type_Boolean = true;
  
  public AudioMain(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null)
    {
      AudioSettingManager localAudioSettingManager = this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager;
      AudioSettingManager.b();
    }
    return 0;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      return this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.a(paramInt);
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.b(paramBoolean);
    }
    return 0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcAudioData != null) {
      return this.jdField_a_of_type_ComTencentAvCoreIVcAudioData.a(paramArrayOfByte, paramInt);
    }
    return -1;
  }
  
  public void a()
  {
    QLog.d("MVAudio", 2, "Uninit");
    if (this.jdField_a_of_type_ComTencentAvAudioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.a();
    }
    if (this.jdField_a_of_type_ComTencentAvAudioAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.a();
    }
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayer = null;
    this.jdField_a_of_type_ComTencentAvAudioAudioRecorder = null;
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.a();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null)
    {
      AudioSettingManager localAudioSettingManager1 = this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager;
      AudioSettingManager localAudioSettingManager2 = this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager;
      localAudioSettingManager1.a(paramInt, AudioSettingManager.b());
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QLog.d("MVAudio", 2, "Init");
    this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager = new AudioSettingManager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.a(true, paramInt4);
    this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.b(true);
    this.jdField_a_of_type_ComTencentAvAudioAudioRecorder = new AudioRecorder();
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayer = new AudioPlayer();
    this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.a(this);
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.a(this);
    this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.a(paramInt1, paramInt3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.a(paramInt1, paramInt3, paramInt2);
    this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(IVcAudioData paramIVcAudioData)
  {
    QLog.d("MVAudio", 2, "SetVcController");
    this.jdField_a_of_type_ComTencentAvCoreIVcAudioData = paramIVcAudioData;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null)
    {
      AudioSettingManager localAudioSettingManager = this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager;
      return AudioSettingManager.a(this.jdField_a_of_type_AndroidContentContext);
    }
    return false;
  }
  
  public int b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager != null) {
      return this.jdField_a_of_type_ComTencentAvAudioAudioSettingManager.b(paramInt);
    }
    return 0;
  }
  
  public int b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAudioAudioRecorder != null)
    {
      this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.a(paramBoolean);
      return 0;
    }
    return -1;
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvCoreIVcAudioData != null) {
      return this.jdField_a_of_type_ComTencentAvCoreIVcAudioData.b(paramArrayOfByte, paramInt);
    }
    return -1;
  }
  
  public void b()
  {
    QLog.d("MVAudio", 2, "StarSound");
    if (this.jdField_a_of_type_ComTencentAvAudioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.c();
    }
    if (this.jdField_a_of_type_ComTencentAvAudioAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.b();
    }
  }
  
  public int c(boolean paramBoolean)
  {
    a(0);
    return -1;
  }
  
  public void c()
  {
    QLog.d("MVAudio", 2, "StopSound");
    if (this.jdField_a_of_type_ComTencentAvAudioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioPlayer.d();
    }
    if (this.jdField_a_of_type_ComTencentAvAudioAudioRecorder != null) {
      this.jdField_a_of_type_ComTencentAvAudioAudioRecorder.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.audio.AudioMain
 * JD-Core Version:    0.7.0.1
 */