package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcReqDelToken
  extends JceStruct
{
  static ArrayList cache_vTokenID;
  public long lUin = 0L;
  public String sExtends = "";
  public ArrayList vTokenID = null;
  
  public SvcReqDelToken() {}
  
  public SvcReqDelToken(long paramLong, ArrayList paramArrayList, String paramString)
  {
    this.lUin = paramLong;
    this.vTokenID = paramArrayList;
    this.sExtends = paramString;
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
    this.sExtends = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.vTokenID, 1);
    paramJceOutputStream.write(this.sExtends, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.SvcReqDelToken
 * JD-Core Version:    0.7.0.1
 */