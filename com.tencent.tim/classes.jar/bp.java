import com.dataline.activities.LiteActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class bp
  implements armm.a
{
  public bp(LiteActivity paramLiteActivity, DataLineMsgRecord paramDataLineMsgRecord, FileManagerEntity paramFileManagerEntity, String paramString1, String paramString2) {}
  
  public void callback(int paramInt)
  {
    paramInt = DataLineMsgRecord.getDevTypeBySeId(this.b.sessionid);
    if (this.a == null)
    {
      ahao.JE(ahav.kY(this.bA) + this.this$0.getString(2131694099));
      FileManagerEntity localFileManagerEntity = this.this$0.app.a().a(this.aW, null, this.this$0.app.getAccount(), 0, false);
      this.b.nWeiyunSessionId = localFileManagerEntity.nSessionId;
      this.this$0.app.b().a(paramInt).ig(this.b.msgId);
      return;
    }
    ahao.JE(ahav.kY(this.bA) + this.this$0.getString(2131694099));
    this.this$0.app.a().jk(this.b.nWeiyunSessionId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     bp
 * JD-Core Version:    0.7.0.1
 */