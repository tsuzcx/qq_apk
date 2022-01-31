package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopListResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecTroopNum;
  public short errorCode = 0;
  public int result = 0;
  public short troopcount = 0;
  public long uin = 0L;
  public ArrayList vecTroopNum = null;
  
  public GetTroopListResp() {}
  
  public GetTroopListResp(long paramLong, short paramShort1, ArrayList paramArrayList, int paramInt, short paramShort2)
  {
    this.uin = paramLong;
    this.troopcount = paramShort1;
    this.vecTroopNum = paramArrayList;
    this.result = paramInt;
    this.errorCode = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.troopcount = paramJceInputStream.read(this.troopcount, 1, true);
    if (cache_vecTroopNum == null)
    {
      cache_vecTroopNum = new ArrayList();
      stTroopNum localstTroopNum = new stTroopNum();
      cache_vecTroopNum.add(localstTroopNum);
    }
    this.vecTroopNum = ((ArrayList)paramJceInputStream.read(cache_vecTroopNum, 2, true));
    this.result = paramJceInputStream.read(this.result, 3, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.troopcount, 1);
    paramJceOutputStream.write(this.vecTroopNum, 2);
    paramJceOutputStream.write(this.result, 3);
    paramJceOutputStream.write(this.errorCode, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     friendlist.GetTroopListResp
 * JD-Core Version:    0.7.0.1
 */