package com.tencent.qqmail.ftn;

import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Map;

final class FtnManagerImpl$5
  extends Thread
{
  FtnManagerImpl$5(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, FtnDefine.FtnCallback paramFtnCallback, long paramLong) {}
  
  public void run()
  {
    QMLog.log(4, "FtnManagerImpl", "thread num: " + FtnManagerImpl.access$700().size());
    FtnManagerImpl.access$800(this.val$ip, this.val$port, this.val$uploadKey, this.val$sha, this.val$filePath, this.val$callback, this.val$taskId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */