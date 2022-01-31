package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class UserAlterGrpInfo
  extends JceStruct
{
  static ArrayList cache_UsrAlterGrpInfo;
  public long GrpListStamp = 0L;
  public ArrayList UsrAlterGrpInfo = null;
  
  public UserAlterGrpInfo() {}
  
  public UserAlterGrpInfo(ArrayList paramArrayList, long paramLong)
  {
    this.UsrAlterGrpInfo = paramArrayList;
    this.GrpListStamp = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_UsrAlterGrpInfo == null)
    {
      cache_UsrAlterGrpInfo = new ArrayList();
      GrpAlterInfo localGrpAlterInfo = new GrpAlterInfo();
      cache_UsrAlterGrpInfo.add(localGrpAlterInfo);
    }
    this.UsrAlterGrpInfo = ((ArrayList)paramJceInputStream.read(cache_UsrAlterGrpInfo, 0, true));
    this.GrpListStamp = paramJceInputStream.read(this.GrpListStamp, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.UsrAlterGrpInfo, 0);
    paramJceOutputStream.write(this.GrpListStamp, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.UserAlterGrpInfo
 * JD-Core Version:    0.7.0.1
 */