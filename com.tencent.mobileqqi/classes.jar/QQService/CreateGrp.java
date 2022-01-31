package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class CreateGrp
  extends JceStruct
{
  static GrpMsg cache_FirstMsg;
  static ArrayList cache_GrpMember;
  public GrpMsg FirstMsg = null;
  public ArrayList GrpMember = null;
  public String GrpName = "";
  public long Mid = 0L;
  
  public CreateGrp() {}
  
  public CreateGrp(String paramString, GrpMsg paramGrpMsg, ArrayList paramArrayList, long paramLong)
  {
    this.GrpName = paramString;
    this.FirstMsg = paramGrpMsg;
    this.GrpMember = paramArrayList;
    this.Mid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GrpName = paramJceInputStream.readString(0, true);
    if (cache_FirstMsg == null) {
      cache_FirstMsg = new GrpMsg();
    }
    this.FirstMsg = ((GrpMsg)paramJceInputStream.read(cache_FirstMsg, 1, true));
    if (cache_GrpMember == null)
    {
      cache_GrpMember = new ArrayList();
      cache_GrpMember.add(Long.valueOf(0L));
    }
    this.GrpMember = ((ArrayList)paramJceInputStream.read(cache_GrpMember, 2, true));
    this.Mid = paramJceInputStream.read(this.Mid, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpName, 0);
    paramJceOutputStream.write(this.FirstMsg, 1);
    paramJceOutputStream.write(this.GrpMember, 2);
    paramJceOutputStream.write(this.Mid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.CreateGrp
 * JD-Core Version:    0.7.0.1
 */