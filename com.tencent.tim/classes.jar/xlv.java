import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletTransferMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

class xlv
  extends aacb
{
  xlv(xlt paramxlt) {}
  
  public void d(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i(xlt.TAG, 2, "onNotifyMsg btype:" + paramInt + " bid:" + paramString);
    }
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)) && (paramBundle != null))
    {
      SparseArray localSparseArray = (SparseArray)this.a.gN.get(paramString);
      if (localSparseArray != null)
      {
        paramInt = 0;
        while (paramInt < localSparseArray.size())
        {
          Object localObject = (WeakReference)localSparseArray.valueAt(paramInt);
          paramBundle = null;
          if (localObject != null) {
            paramBundle = (xlt.a)((WeakReference)localObject).get();
          }
          if ((paramBundle != null) && ((paramBundle.mMessage instanceof MessageForQQWalletMsg)))
          {
            localObject = (MessageForQQWalletMsg)paramBundle.mMessage;
            if ((localObject != null) && (((MessageForQQWalletMsg)localObject).messageType == 16) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg != null) && (((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.listId != null) && (paramString.equals(((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.listId))) {
              this.a.a(paramBundle, (MessageForQQWalletMsg)localObject, ((MessageForQQWalletMsg)localObject).mQQWalletTransferMsg.elem);
            }
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xlv
 * JD-Core Version:    0.7.0.1
 */