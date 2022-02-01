package com.tencent.qapmsdk.base.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/SDKConfig;", "", "()V", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class SDKConfig
{
  public static final Companion Companion = new Companion(null);
  private static int MAX_AUSTERITY_REPORT_NUM = 100;
  private static int MAX_LOOSE_REPORT_NUM = 100;
  @JvmField
  public static int RES_TYPE = 2;
  private static float USER_SAMPLE_RATIO = 1.0F;
  private static int VER_TYPE;
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/config/SDKConfig$Companion;", "", "()V", "MAX_AUSTERITY_REPORT_NUM", "", "getMAX_AUSTERITY_REPORT_NUM", "()I", "setMAX_AUSTERITY_REPORT_NUM", "(I)V", "MAX_LOOSE_REPORT_NUM", "getMAX_LOOSE_REPORT_NUM", "setMAX_LOOSE_REPORT_NUM", "RES_TYPE", "USER_SAMPLE_RATIO", "", "getUSER_SAMPLE_RATIO", "()F", "setUSER_SAMPLE_RATIO", "(F)V", "VER_TYPE", "getVER_TYPE", "setVER_TYPE", "qapmbase_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    public final int getMAX_AUSTERITY_REPORT_NUM()
    {
      return SDKConfig.access$getMAX_AUSTERITY_REPORT_NUM$cp();
    }
    
    public final int getMAX_LOOSE_REPORT_NUM()
    {
      return SDKConfig.access$getMAX_LOOSE_REPORT_NUM$cp();
    }
    
    public final float getUSER_SAMPLE_RATIO()
    {
      return SDKConfig.access$getUSER_SAMPLE_RATIO$cp();
    }
    
    public final int getVER_TYPE()
    {
      return SDKConfig.access$getVER_TYPE$cp();
    }
    
    public final void setMAX_AUSTERITY_REPORT_NUM(int paramInt)
    {
      SDKConfig.access$setMAX_AUSTERITY_REPORT_NUM$cp(paramInt);
    }
    
    public final void setMAX_LOOSE_REPORT_NUM(int paramInt)
    {
      SDKConfig.access$setMAX_LOOSE_REPORT_NUM$cp(paramInt);
    }
    
    public final void setUSER_SAMPLE_RATIO(float paramFloat)
    {
      SDKConfig.access$setUSER_SAMPLE_RATIO$cp(paramFloat);
    }
    
    public final void setVER_TYPE(int paramInt)
    {
      SDKConfig.access$setVER_TYPE$cp(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.config.SDKConfig
 * JD-Core Version:    0.7.0.1
 */