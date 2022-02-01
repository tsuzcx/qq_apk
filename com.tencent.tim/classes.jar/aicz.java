import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;

class aicz
  implements INetEventHandler
{
  aicz(aicu paramaicu) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (aicu.a(this.this$0) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("GroupVideoManager", 2, "onNetChangeEvent connect:" + paramBoolean + " isMSFConnect:" + aicu.a(this.this$0).bIT);
      }
    } while (!paramBoolean);
    this.this$0.KW(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aicz
 * JD-Core Version:    0.7.0.1
 */