package com.tencent.youtu.ytagreflectlivecheck.controller;

import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;

public class InitController
{
  private static int GET_RGBCONFIG_FAILED = 0;
  private static int RGBCONFIG_GET_COLLORSEQREQ_FAILED = 0;
  private static int RGBCONFIG_GET_RGBCONFIG_NULL = 0;
  private static int RGBCONFIG_PARSE_FAILED = 5;
  private static int RGBCONFIG_RETURN_NULL = 1;
  private static int RGBCONFIG_WRONG_TYPE = 6;
  private static int RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 0;
  private static final String TAG = "YoutuLightLiveCheck";
  
  static
  {
    RGBCONFIG_GET_COLLORSEQREQ_FAILED = 2;
    RGBCONFIG_GET_RGBCONFIG_NULL = 3;
    RGBCONFIG_YOUTU_SERVER_RETURNCODE_NOT_0 = 4;
  }
  
  public void start(RGBConfigRequester paramRGBConfigRequester, ProcessManager.ProcessResult paramProcessResult, long paramLong)
  {
    paramRGBConfigRequester.request(new InitController.1(this, paramProcessResult, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.controller.InitController
 * JD-Core Version:    0.7.0.1
 */