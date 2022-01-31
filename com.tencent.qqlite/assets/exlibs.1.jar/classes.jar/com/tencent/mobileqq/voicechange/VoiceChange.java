package com.tencent.mobileqq.voicechange;

import android.content.Context;
import com.tencent.mobileqq.ptt.PttSoLoader;

public class VoiceChange
{
  private static boolean jdField_a_of_type_Boolean;
  private int jdField_a_of_type_Int;
  
  public VoiceChange(Context paramContext)
  {
    if (!jdField_a_of_type_Boolean)
    {
      PttSoLoader.a(paramContext, "voicechange");
      jdField_a_of_type_Boolean = true;
    }
  }
  
  public native int Create();
  
  public native int Init(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public native int Release(int paramInt);
  
  public int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Init(this.jdField_a_of_type_Int, paramInt1, paramInt2, paramInt3);
  }
  
  public int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return doChange(this.jdField_a_of_type_Int, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void a()
  {
    Release(this.jdField_a_of_type_Int);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == 0) {
      this.jdField_a_of_type_Int = Create();
    }
    return this.jdField_a_of_type_Int != 0;
  }
  
  public native int doChange(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceChange
 * JD-Core Version:    0.7.0.1
 */