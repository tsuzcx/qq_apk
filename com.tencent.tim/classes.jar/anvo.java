import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.SliceSttManager.SliceSttServet.2;
import java.io.File;
import java.util.HashMap;

public class anvo
  extends anvq
{
  public anvo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private Long b(MessageForPtt paramMessageForPtt)
  {
    if (this.nG == null)
    {
      this.nG = new HashMap();
      this.mApp.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (this.nG.containsKey(localLong)) {
      return localLong;
    }
    this.nG.put(localLong, paramMessageForPtt);
    return localLong;
  }
  
  public Long a(MessageForPtt paramMessageForPtt)
  {
    long l = b(paramMessageForPtt).longValue();
    new anvo.a(this.mApp, paramMessageForPtt, Long.valueOf(l)).dTC();
    return Long.valueOf(l);
  }
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (xla.bhD) {
      return a(paramMessageForPtt);
    }
    return b(paramMessageForPtt, paramInt);
  }
  
  public class a
  {
    private wqp a = new wqp();
    private Long ai;
    QQAppInterface app;
    wqc b;
    public String cix = "";
    String ciy;
    public MessageForPtt g;
    
    public a(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, Long paramLong)
    {
      this.jdField_b_of_type_Wqc = new anvp(this);
      this.app = paramQQAppInterface;
      this.ai = paramLong;
      this.g = paramMessageForPtt;
    }
    
    private void dTD()
    {
      if (this.ciy != null)
      {
        File localFile = new File(this.ciy);
        if (localFile.exists()) {
          localFile.delete();
        }
      }
      this.g.sttAbility = 2;
      this.g.sttText = this.cix;
      this.g.isReadPtt = true;
      this.g.serial();
      this.jdField_b_of_type_Anvo.mApp.b().c(this.g.frienduin, this.g.istroop, this.g.uniseq, this.g.msgData);
      this.jdField_b_of_type_Anvo.M.post(new SliceSttManager.SliceSttServet.2(this));
    }
    
    public void dTC()
    {
      this.ciy = MessageForPtt.getTmpFilePath(this.g.getLocalFilePath());
      this.a.a(this.ciy, this.app, this.jdField_b_of_type_Wqc, this.g.istroop, this.g.frienduin);
      this.a.xE(this.g.getLocalFilePath());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anvo
 * JD-Core Version:    0.7.0.1
 */