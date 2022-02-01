import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class andx
  extends swr
{
  private static String[] ba = { "QQServiceTroopSvc" };
  private andv jdField_a_of_type_Andv = new andv();
  private andw jdField_a_of_type_Andw;
  
  public andx(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Andw = new andw(paramAppInterface);
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return this.jdField_a_of_type_Andv.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    return this.jdField_a_of_type_Andw.n(paramToServiceMsg, paramUniPacket);
  }
  
  public String[] y()
  {
    return ba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     andx
 * JD-Core Version:    0.7.0.1
 */