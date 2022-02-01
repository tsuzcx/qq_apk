package com.tencent.av.redpacket.config;

import aduq;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.qphone.base.util.QLog;
import irz;
import itw;

public class AVRedPacketConfigManager$1
  implements Runnable
{
  public AVRedPacketConfigManager$1(irz paramirz, itw paramitw) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("downloadRes, threadName[").append(Thread.currentThread().getName()).append("], threadId[").append(Thread.currentThread().getId()).append("], resDownloadManager[");
    if (this.this$0.jdField_a_of_type_Aduq != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedPacketConfigManger", 1, bool + "]");
      this.this$0.b = this.c;
      this.this$0.UE = false;
      this.this$0.UF = false;
      if (this.this$0.jdField_a_of_type_Aduq != null)
      {
        this.this$0.jdField_a_of_type_Aduq.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resMD5, ".zip", true, 4, Integer.valueOf(1));
        this.this$0.jdField_a_of_type_Aduq.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResMd5, ".zip", true, 4, Integer.valueOf(2));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager.1
 * JD-Core Version:    0.7.0.1
 */