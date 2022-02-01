import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;

public class acqo
  extends acqp
{
  public acqo(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.bqy = acbn.bkx;
    this.czi = 6003;
  }
  
  public long a(DataLineMsgRecord paramDataLineMsgRecord, boolean paramBoolean)
  {
    if (paramDataLineMsgRecord != null)
    {
      paramDataLineMsgRecord.selfuin = this.bqy;
      paramDataLineMsgRecord.frienduin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.senderuin = paramDataLineMsgRecord.selfuin;
      paramDataLineMsgRecord.istroop = this.czi;
      paramDataLineMsgRecord.dataline_type = 1;
    }
    return super.a(paramDataLineMsgRecord, paramBoolean);
  }
  
  protected acxt a()
  {
    return this.app.a(1);
  }
  
  protected void cNT()
  {
    ((acde)this.app.getBusinessHandler(8)).EJ(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqo
 * JD-Core Version:    0.7.0.1
 */