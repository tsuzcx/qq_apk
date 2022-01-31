import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;

class yam
  extends ayvz
{
  yam(yak paramyak, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (ayqm)paramMessage.obj;
    if ((localObject == null) || (((ayqm)localObject).jdField_b_of_type_Int != 24)) {}
    while (((ayqm)localObject).c != 7) {
      return;
    }
    switch (paramMessage.what)
    {
    case 1001: 
    case 1002: 
    case 1004: 
    default: 
      return;
    case 1003: 
      paramMessage = new Intent();
      paramMessage.setAction("onFaceTransferComplete");
      localBundle = new Bundle();
      localBundle.putLong("uniseq", ((ayqm)localObject).jdField_b_of_type_Long);
      localBundle.putString("fileUrl", ((ayqm)localObject).i);
      localObject = ((ayqm)localObject).i;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("/");
        localBundle.putString("uuId", localObject[(localObject.length - 2)]);
      }
      paramMessage.putExtras(localBundle);
      BaseApplicationImpl.getApplication().sendBroadcast(paramMessage, "com.tencent.smartdevice.permission.broadcast");
      return;
    }
    paramMessage = new Intent();
    paramMessage.setAction("onFaceTransferError");
    Bundle localBundle = new Bundle();
    localBundle.putLong("uniseq", ((ayqm)localObject).jdField_b_of_type_Long);
    paramMessage.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(paramMessage, "com.tencent.smartdevice.permission.broadcast");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yam
 * JD-Core Version:    0.7.0.1
 */