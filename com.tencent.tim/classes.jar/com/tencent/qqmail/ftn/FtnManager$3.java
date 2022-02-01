package com.tencent.qqmail.ftn;

import android.text.TextUtils;
import com.tencent.qqmail.ftn.Ftn.FileInfo;
import com.tencent.qqmail.ftn.Ftn.ListOutput;
import com.tencent.qqmail.ftn.util.FtnCommonUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import rx.Subscriber;

class FtnManager$3
  extends FtnDefine.FtnCallback
{
  FtnManager$3(FtnManager paramFtnManager, Subscriber paramSubscriber) {}
  
  public void onError(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QMLog.log(6, "FtnManager", "Ftn get list error:" + FtnCommonUtils.netErrorFormat(paramInt1, paramInt2, paramInt3, paramString));
    QMNotification.postNotification("actiongetlisterror", FtnManager.access$200(null, paramInt1, paramInt2, paramInt3, paramString, ""));
    if (this.val$subscriber != null) {
      this.val$subscriber.onError(new QMNetworkError(9, paramInt1, paramString));
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    do
    {
      int i;
      try
      {
        paramArrayOfByte1 = new ArrayList(new ListOutput().parseFrom(paramArrayOfByte2).itemlist);
        i = paramArrayOfByte1.size();
        paramArrayOfByte2 = paramArrayOfByte1.iterator();
        while (paramArrayOfByte2.hasNext())
        {
          FileInfo localFileInfo = (FileInfo)paramArrayOfByte2.next();
          if ((localFileInfo.uploadsize == 0L) || (TextUtils.isEmpty(localFileInfo.key)) || (TextUtils.isEmpty(localFileInfo.code))) {
            paramArrayOfByte2.remove();
          }
        }
        FtnManager.access$100(this.this$0).deleteFtn();
      }
      catch (IOException paramArrayOfByte1)
      {
        QMLog.log(6, "FtnManager", "Ftn get list error:" + paramArrayOfByte1.toString());
        if (this.val$subscriber != null) {
          this.val$subscriber.onError(paramArrayOfByte1);
        }
        return;
      }
      FtnManager.access$100(this.this$0).insertFtn(paramArrayOfByte1);
      this.this$0.asyncFtnExpireTime();
      QMLog.log(4, "FtnManager", "Ftn get list success, num: " + paramArrayOfByte1.size() + ", total: " + i);
      QMNotification.postNotification("actiongetlistsucc", QMNotification.EMPTY_NOTIFICATION);
    } while (this.val$subscriber == null);
    this.val$subscriber.onNext(null);
    this.val$subscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.FtnManager.3
 * JD-Core Version:    0.7.0.1
 */