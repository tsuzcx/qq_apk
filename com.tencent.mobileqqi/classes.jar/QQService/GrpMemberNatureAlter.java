package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GrpMemberNatureAlter
  extends JceStruct
{
  static ArrayList cache_vGrpMemberNature;
  public byte NatureValidBit = 0;
  public ArrayList vGrpMemberNature = null;
  
  public GrpMemberNatureAlter() {}
  
  public GrpMemberNatureAlter(ArrayList paramArrayList, byte paramByte)
  {
    this.vGrpMemberNature = paramArrayList;
    this.NatureValidBit = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vGrpMemberNature == null)
    {
      cache_vGrpMemberNature = new ArrayList();
      GrpMemberNature localGrpMemberNature = new GrpMemberNature();
      cache_vGrpMemberNature.add(localGrpMemberNature);
    }
    this.vGrpMemberNature = ((ArrayList)paramJceInputStream.read(cache_vGrpMemberNature, 0, true));
    this.NatureValidBit = paramJceInputStream.read(this.NatureValidBit, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vGrpMemberNature, 0);
    paramJceOutputStream.write(this.NatureValidBit, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpMemberNatureAlter
 * JD-Core Version:    0.7.0.1
 */