package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ProfileInfoOperResp
  extends JceStruct
{
  static ArrayList cache_vecInfo;
  public byte cResult = 0;
  public long uin = 0L;
  public ArrayList vecInfo = null;
  
  public ProfileInfoOperResp() {}
  
  public ProfileInfoOperResp(long paramLong, byte paramByte, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.cResult = paramByte;
    this.vecInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.cResult = paramJceInputStream.read(this.cResult, 1, true);
    if (cache_vecInfo == null)
    {
      cache_vecInfo = new ArrayList();
      ProfileInfoResp localProfileInfoResp = new ProfileInfoResp();
      cache_vecInfo.add(localProfileInfoResp);
    }
    this.vecInfo = ((ArrayList)paramJceInputStream.read(cache_vecInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.cResult, 1);
    paramJceOutputStream.write(this.vecInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.ProfileInfoOperResp
 * JD-Core Version:    0.7.0.1
 */