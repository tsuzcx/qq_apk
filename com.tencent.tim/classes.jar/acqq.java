import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

public class acqq
  extends acqp
{
  public acqq(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.bqy = acbn.bkw;
    this.czi = 6000;
  }
  
  protected acxt a()
  {
    return this.app.a(0);
  }
  
  protected void cNT()
  {
    ((acde)this.app.getBusinessHandler(8)).EI(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acqq
 * JD-Core Version:    0.7.0.1
 */