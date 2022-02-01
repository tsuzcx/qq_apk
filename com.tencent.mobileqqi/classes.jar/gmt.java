import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.FileMsg;

public class gmt
  extends MessageObserver
{
  public gmt(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  protected void a(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    this.a.c(2);
    if ((paramUploadStreamStruct == null) || (paramUploadStreamStruct.a == null) || (!paramUploadStreamStruct.a.equalsIgnoreCase(this.a.a.e))) {
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.a(this.a, false, paramUploadStreamStruct);
      return;
    }
    BuddyTransfileProcessor.a(this.a, true, paramUploadStreamStruct);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gmt
 * JD-Core Version:    0.7.0.1
 */