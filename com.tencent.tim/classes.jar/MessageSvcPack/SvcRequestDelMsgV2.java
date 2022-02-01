package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRequestDelMsgV2
  extends JceStruct
{
  static ArrayList<AccostMsg> cache_vAccostMsg;
  static ArrayList<SvcDelMsgInfo> cache_vDelInfos;
  public byte cInst;
  public byte cVerifyType;
  public long lUin;
  public ArrayList<AccostMsg> vAccostMsg;
  public ArrayList<SvcDelMsgInfo> vDelInfos;
  
  public SvcRequestDelMsgV2() {}
  
  public SvcRequestDelMsgV2(long paramLong, ArrayList<SvcDelMsgInfo> paramArrayList, byte paramByte1, ArrayList<AccostMsg> paramArrayList1, byte paramByte2)
  {
    this.lUin = paramLong;
    this.vDelInfos = paramArrayList;
    this.cVerifyType = paramByte1;
    this.vAccostMsg = paramArrayList1;
    this.cInst = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    Object localObject;
    if (cache_vDelInfos == null)
    {
      cache_vDelInfos = new ArrayList();
      localObject = new SvcDelMsgInfo();
      cache_vDelInfos.add(localObject);
    }
    this.vDelInfos = ((ArrayList)paramJceInputStream.read(cache_vDelInfos, 1, true));
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 2, true);
    if (cache_vAccostMsg == null)
    {
      cache_vAccostMsg = new ArrayList();
      localObject = new AccostMsg();
      cache_vAccostMsg.add(localObject);
    }
    this.vAccostMsg = ((ArrayList)paramJceInputStream.read(cache_vAccostMsg, 3, true));
    this.cInst = paramJceInputStream.read(this.cInst, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vDelInfos, 1);
    paramJceOutputStream.write(this.cVerifyType, 2);
    paramJceOutputStream.write(this.vAccostMsg, 3);
    paramJceOutputStream.write(this.cInst, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcRequestDelMsgV2
 * JD-Core Version:    0.7.0.1
 */