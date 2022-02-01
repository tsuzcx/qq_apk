import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;

class acdg
  implements agmf.a
{
  acdg(acde paramacde, long paramLong) {}
  
  public void onError(int paramInt, String paramString)
  {
    ahao.JF(BaseApplicationImpl.getContext().getString(2131693843));
    ((acde)this.this$0.app.getBusinessHandler(8)).OnSessionComplete(this.Pp, 41, paramInt);
  }
  
  public void onSuccess(Object paramObject)
  {
    Object localObject = (String)paramObject;
    paramObject = (acde)this.this$0.app.getBusinessHandler(8);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject.OnSessionComplete(this.Pp, 0, -999);
    }
    DataLineMsgRecord localDataLineMsgRecord;
    do
    {
      do
      {
        return;
        int i = DataLineMsgRecord.getDevTypeBySeId(this.Pp);
        localDataLineMsgRecord = this.this$0.app.b().a(i).a(this.Pp);
      } while (localDataLineMsgRecord == null);
      localDataLineMsgRecord.serverPath = ((String)localObject);
      localDataLineMsgRecord.nOpType = 1;
      localDataLineMsgRecord.bIsSended = true;
      localDataLineMsgRecord.bIsTransfering = false;
      if (localDataLineMsgRecord.entityID != 0L)
      {
        localObject = this.this$0.app.a().b(localDataLineMsgRecord.entityID);
        if (localObject != null)
        {
          ((FileManagerEntity)localObject).status = 1;
          ((FileManagerEntity)localObject).Uuid = localDataLineMsgRecord.serverPath;
        }
      }
    } while (!paramObject.c(localDataLineMsgRecord));
    paramObject.e(localDataLineMsgRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdg
 * JD-Core Version:    0.7.0.1
 */