import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class bq
  implements ahal.a
{
  public bq(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void aD()
  {
    int i = DataLineMsgRecord.getDevTypeBySeId(this.b.sessionid);
    if (this.a == null)
    {
      ahao.JE(ahav.kY(this.bA) + this.this$0.getString(2131694099));
      FileManagerEntity localFileManagerEntity = this.this$0.app.a().a(this.aW, null, this.this$0.app.getAccount(), 0, false);
      this.b.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.this$0.app.b().a(i).ig(this.b.msgId);
      return;
    }
    ahao.JE(ahav.kY(this.bA) + this.this$0.getString(2131694099));
    this.this$0.app.a().jk(this.b.nWeiyunSessionId);
  }
  
  public void aE() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bq
 * JD-Core Version:    0.7.0.1
 */