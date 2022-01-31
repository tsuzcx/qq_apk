package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ExtResult_FailGrpMember
  extends JceStruct
{
  static ArrayList cache_vGrpMember;
  public ArrayList vGrpMember = null;
  
  public ExtResult_FailGrpMember() {}
  
  public ExtResult_FailGrpMember(ArrayList paramArrayList)
  {
    this.vGrpMember = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vGrpMember == null)
    {
      cache_vGrpMember = new ArrayList();
      cache_vGrpMember.add(Long.valueOf(0L));
    }
    this.vGrpMember = ((ArrayList)paramJceInputStream.read(cache_vGrpMember, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.vGrpMember, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ExtResult_FailGrpMember
 * JD-Core Version:    0.7.0.1
 */