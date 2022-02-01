package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetEntrance
  extends JceStruct
{
  static ReqUserInfo cache_stUserInfo = new ReqUserInfo();
  public ReqUserInfo stUserInfo;
  public int support_entrace_type;
  
  public ReqGetEntrance() {}
  
  public ReqGetEntrance(ReqUserInfo paramReqUserInfo, int paramInt)
  {
    this.stUserInfo = paramReqUserInfo;
    this.support_entrace_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.support_entrace_type = paramJceInputStream.read(this.support_entrace_type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.support_entrace_type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     EncounterSvc.ReqGetEntrance
 * JD-Core Version:    0.7.0.1
 */