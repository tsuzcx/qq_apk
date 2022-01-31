package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ModifyGroupInfoResp
  extends JceStruct
{
  static int cache_result;
  public long dwGroupCode = 0L;
  public int result = 0;
  
  public ModifyGroupInfoResp() {}
  
  public ModifyGroupInfoResp(int paramInt, long paramLong)
  {
    this.result = paramInt;
    this.dwGroupCode = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.dwGroupCode, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.ModifyGroupInfoResp
 * JD-Core Version:    0.7.0.1
 */