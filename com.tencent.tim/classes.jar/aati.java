import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class aati
  implements INetInfoHandler
{
  aati(aath paramaath) {}
  
  public void onNetMobile2None()
  {
    boolean bool = true;
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    aath localaath2 = this.this$0;
    if (!aath.a(this.this$0).bzF) {}
    for (;;)
    {
      localaath2.bn(bool, true);
      return;
      bool = false;
    }
  }
  
  public void onNetMobile2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onNetMobile2Wifi, AutoTranslate:  ");
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    this.this$0.bn(false, true);
    aath.a(this.this$0);
  }
  
  public void onNetNone2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onNetNone2Mobile ");
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    this.this$0.bn(false, true);
    aath.a(this.this$0);
  }
  
  public void onNetNone2Wifi(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onNetNone2Wifi, AutoTranslate:  ");
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    this.this$0.bn(false, true);
    aath.a(this.this$0);
  }
  
  public void onNetWifi2Mobile(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d(aath.access$000(), 2, "onNetWifi2Mobile, need restore:  ");
    }
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    this.this$0.bn(false, true);
    aath.a(this.this$0);
  }
  
  public void onNetWifi2None()
  {
    boolean bool = true;
    synchronized (this.this$0)
    {
      if (aath.a(this.this$0) == null) {
        return;
      }
      if (aath.a(this.this$0).mListenerRef == null) {
        return;
      }
    }
    aath localaath2 = this.this$0;
    if (!aath.a(this.this$0).bzF) {}
    for (;;)
    {
      localaath2.bn(bool, true);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aati
 * JD-Core Version:    0.7.0.1
 */