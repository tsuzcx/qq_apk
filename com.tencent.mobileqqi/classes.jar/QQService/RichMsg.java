package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RichMsg
  extends JceStruct
{
  static ArrayList cache_VecMsg;
  public ArrayList VecMsg = null;
  
  public RichMsg() {}
  
  public RichMsg(ArrayList paramArrayList)
  {
    this.VecMsg = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_VecMsg == null)
    {
      cache_VecMsg = new ArrayList();
      MsgItem localMsgItem = new MsgItem();
      cache_VecMsg.add(localMsgItem);
    }
    this.VecMsg = ((ArrayList)paramJceInputStream.read(cache_VecMsg, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.VecMsg, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RichMsg
 * JD-Core Version:    0.7.0.1
 */