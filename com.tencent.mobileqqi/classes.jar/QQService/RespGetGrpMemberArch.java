package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetGrpMemberArch
  extends JceStruct
{
  static ArrayList cache_GrpMember;
  static RespHeader cache_stHeader;
  public int EndSeq = 0;
  public long GrpId = 0L;
  public ArrayList GrpMember = null;
  public int GrpMemberArchStamp = 0;
  public int TotalNum = 0;
  public RespHeader stHeader = null;
  
  public RespGetGrpMemberArch() {}
  
  public RespGetGrpMemberArch(RespHeader paramRespHeader, long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3)
  {
    this.stHeader = paramRespHeader;
    this.GrpId = paramLong;
    this.GrpMember = paramArrayList;
    this.GrpMemberArchStamp = paramInt1;
    this.TotalNum = paramInt2;
    this.EndSeq = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHeader();
    }
    this.stHeader = ((RespHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.GrpId = paramJceInputStream.read(this.GrpId, 1, true);
    if (cache_GrpMember == null)
    {
      cache_GrpMember = new ArrayList();
      GrpMemberNature localGrpMemberNature = new GrpMemberNature();
      cache_GrpMember.add(localGrpMemberNature);
    }
    this.GrpMember = ((ArrayList)paramJceInputStream.read(cache_GrpMember, 2, true));
    this.GrpMemberArchStamp = paramJceInputStream.read(this.GrpMemberArchStamp, 3, true);
    this.TotalNum = paramJceInputStream.read(this.TotalNum, 4, true);
    this.EndSeq = paramJceInputStream.read(this.EndSeq, 5, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.GrpId, 1);
    paramJceOutputStream.write(this.GrpMember, 2);
    paramJceOutputStream.write(this.GrpMemberArchStamp, 3);
    paramJceOutputStream.write(this.TotalNum, 4);
    paramJceOutputStream.write(this.EndSeq, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetGrpMemberArch
 * JD-Core Version:    0.7.0.1
 */