package com.tencent.mobileqq.app;

import achg;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class MayknowRecommendManager$5
  implements Runnable
{
  public MayknowRecommendManager$5(achg paramachg, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void run()
  {
    achg.b(this.this$0, this.cwr);
    byte[] arrayOfByte = (byte[])achg.a(this.this$0).get(Integer.valueOf(this.cwr));
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      localBoolean = (Boolean)achg.b(this.this$0).get(Integer.valueOf(this.cwr));
      if ((localBoolean != null) && (localBoolean.booleanValue() == true)) {
        if (QLog.isColorLevel()) {
          QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage requesting " + this.cwr);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Boolean localBoolean;
      return;
      achg.b(this.this$0).put(Integer.valueOf(this.cwr), Boolean.valueOf(true));
      ((FriendListHandler)achg.a(this.this$0).getBusinessHandler(1)).a(this.cws, this.cwr, arrayOfByte, false, this.K);
      return;
    }
    QLog.d("MayknowRecommendManager", 2, "getConnectionsPersonRemoteNextPage no cookie! no need to request");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MayknowRecommendManager.5
 * JD-Core Version:    0.7.0.1
 */