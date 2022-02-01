package com.tencent.mobileqq.troop.filemanager.upload;

import apef.b;
import apft;
import java.util.LinkedList;
import java.util.Map;

public class TroopFileScaner$1
  implements Runnable
{
  public TroopFileScaner$1(apft paramapft, long paramLong, TroopFileScanTask paramTroopFileScanTask, String paramString) {}
  
  public void run()
  {
    apft.a(this.this$0).put(Long.valueOf(this.ars), this.a);
    apft.a(this.this$0).add(Long.valueOf(this.ars));
    apef.b.i("TroopFileScaner", apef.b.USR, "[" + this.ars + "] startScan filePath. " + this.val$filePath + apft.a(this.this$0));
    apft.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileScaner.1
 * JD-Core Version:    0.7.0.1
 */