package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GrpAddMember
  extends JceStruct
{
  static ArrayList cache_Member;
  public ArrayList Member = null;
  public long Mid = 0L;
  
  public GrpAddMember() {}
  
  public GrpAddMember(ArrayList paramArrayList, long paramLong)
  {
    this.Member = paramArrayList;
    this.Mid = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_Member == null)
    {
      cache_Member = new ArrayList();
      cache_Member.add(Long.valueOf(0L));
    }
    this.Member = ((ArrayList)paramJceInputStream.read(cache_Member, 0, true));
    this.Mid = paramJceInputStream.read(this.Mid, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Member, 0);
    paramJceOutputStream.write(this.Mid, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.GrpAddMember
 * JD-Core Version:    0.7.0.1
 */