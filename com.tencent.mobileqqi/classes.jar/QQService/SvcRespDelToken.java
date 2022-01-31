package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcRespDelToken
  extends JceStruct
{
  static ArrayList cache_vTokenID;
  public byte cReplyCode = 0;
  public long lUin = 0L;
  public String strResult = "";
  public ArrayList vTokenID = null;
  
  public SvcRespDelToken() {}
  
  public SvcRespDelToken(long paramLong, ArrayList paramArrayList, byte paramByte, String paramString)
  {
    this.lUin = paramLong;
    this.vTokenID = paramArrayList;
    this.cReplyCode = paramByte;
    this.strResult = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    if (cache_vTokenID == null)
    {
      cache_vTokenID = new ArrayList();
      cache_vTokenID.add(Integer.valueOf(0));
    }
    this.vTokenID = ((ArrayList)paramJceInputStream.read(cache_vTokenID, 1, true));
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 2, true);
    this.strResult = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vTokenID, 1);
    paramJceOutputStream.write(this.cReplyCode, 2);
    paramJceOutputStream.write(this.strResult, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcRespDelToken
 * JD-Core Version:    0.7.0.1
 */