package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopMemberListResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecTroopMember;
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public long NextUin = 0L;
  public short errorCode = 0;
  public int result = 0;
  public long uin = 0L;
  public ArrayList vecTroopMember = null;
  
  public GetTroopMemberListResp() {}
  
  public GetTroopMemberListResp(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList, long paramLong4, int paramInt, short paramShort)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.vecTroopMember = paramArrayList;
    this.NextUin = paramLong4;
    this.result = paramInt;
    this.errorCode = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    if (cache_vecTroopMember == null)
    {
      cache_vecTroopMember = new ArrayList();
      stTroopMemberInfo localstTroopMemberInfo = new stTroopMemberInfo();
      cache_vecTroopMember.add(localstTroopMemberInfo);
    }
    this.vecTroopMember = ((ArrayList)paramJceInputStream.read(cache_vecTroopMember, 3, true));
    this.NextUin = paramJceInputStream.read(this.NextUin, 4, true);
    this.result = paramJceInputStream.read(this.result, 5, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.vecTroopMember, 3);
    paramJceOutputStream.write(this.NextUin, 4);
    paramJceOutputStream.write(this.result, 5);
    paramJceOutputStream.write(this.errorCode, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetTroopMemberListResp
 * JD-Core Version:    0.7.0.1
 */