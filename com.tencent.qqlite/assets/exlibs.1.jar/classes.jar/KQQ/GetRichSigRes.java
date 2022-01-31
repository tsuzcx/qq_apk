package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetRichSigRes
  extends JceStruct
{
  static ArrayList cache_vstSigInfo;
  public byte cResult = -1;
  public ArrayList vstSigInfo = null;
  
  public GetRichSigRes() {}
  
  public GetRichSigRes(byte paramByte, ArrayList paramArrayList)
  {
    this.cResult = paramByte;
    this.vstSigInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    if (cache_vstSigInfo == null)
    {
      cache_vstSigInfo = new ArrayList();
      ResRichSigInfo localResRichSigInfo = new ResRichSigInfo();
      cache_vstSigInfo.add(localResRichSigInfo);
    }
    this.vstSigInfo = ((ArrayList)paramJceInputStream.read(cache_vstSigInfo, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cResult, 1);
    if (this.vstSigInfo != null) {
      paramJceOutputStream.write(this.vstSigInfo, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.GetRichSigRes
 * JD-Core Version:    0.7.0.1
 */