package com.tencent.biz.videostory.config;

import aeif;
import com.tencent.qphone.base.util.QLog;
import spp;
import spq;
import spw;
import spy;
import sqj;

public class VSConfigManager$1
  implements Runnable
{
  public VSConfigManager$1(spp paramspp) {}
  
  public void run()
  {
    Object localObject = (spq)aeif.a().o(411);
    if (localObject != null) {
      QLog.i("Q.videostory.config.VSConfigManager", 2, "init load conf:" + ((spq)localObject).toString());
    }
    localObject = (spy)aeif.a().o(463);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSSubscribeConfBean : " + localObject);
    }
    localObject = (spw)aeif.a().o(595);
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.config.VSConfigManager", 2, "init load VSStickyNoteConfBean : " + localObject);
    }
    sqj.a().loadConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.config.VSConfigManager.1
 * JD-Core Version:    0.7.0.1
 */