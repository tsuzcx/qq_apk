package com.tencent.biz.qqstory.takevideo.rmw;

import anhz;
import ankq;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import imm;
import psx;
import rgp;
import rlg;

class RMWService$2
  extends Thread
{
  RMWService$2(RMWService paramRMWService) {}
  
  public void run()
  {
    rlg.d("RMWService", "preload AVCodec - start -");
    VideoEnvironment.a("AVCodec", null, true);
    rlg.d("RMWService", "preload AVCodec - end -");
    rlg.d("RMWService", "preload PtvFilterSoLoad - start -");
    ankq.axX();
    rlg.d("RMWService", "preload PtvFilterSoLoad - end -");
    rlg.d("RMWService", "preInit DoodleEmojiManager - start -");
    ((rgp)psx.a(8)).cG(this.this$0);
    rlg.d("RMWService", "preInit DoodleEmojiManager - end -");
    rlg.d("RMWService", "preInit HwEnvData.supportHardWareCodec - start -");
    anhz.axf();
    rlg.d("RMWService", "preInit HwEnvData.supportHardWareCodec - end -");
    rlg.d("RMWService", "preInit VcSystemInfo.getCpuInfo - start -");
    imm.getCpuInfo();
    rlg.d("RMWService", "preInit VcSystemInfo.getCpuInfo - end -");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.rmw.RMWService.2
 * JD-Core Version:    0.7.0.1
 */