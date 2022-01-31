package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SvcResponseBatchGetGroupFilter
  extends JceStruct
{
  static ArrayList cache_vGroupFilterInfo;
  public byte cReplyCode = 0;
  public long lUin = 0L;
  public String strResult = "";
  public ArrayList vGroupFilterInfo = null;
  
  public SvcResponseBatchGetGroupFilter() {}
  
  public SvcResponseBatchGetGroupFilter(long paramLong, byte paramByte, String paramString, ArrayList paramArrayList)
  {
    this.lUin = paramLong;
    this.cReplyCode = paramByte;
    this.strResult = paramString;
    this.vGroupFilterInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lUin = paramJceInputStream.read(this.lUin, 0, true);
    this.cReplyCode = paramJceInputStream.read(this.cReplyCode, 1, true);
    this.strResult = paramJceInputStream.readString(2, true);
    if (cache_vGroupFilterInfo == null)
    {
      cache_vGroupFilterInfo = new ArrayList();
      GroupFilterInfo localGroupFilterInfo = new GroupFilterInfo();
      cache_vGroupFilterInfo.add(localGroupFilterInfo);
    }
    this.vGroupFilterInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupFilterInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lUin, 0);
    paramJceOutputStream.write(this.cReplyCode, 1);
    paramJceOutputStream.write(this.strResult, 2);
    paramJceOutputStream.write(this.vGroupFilterInfo, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     MessageSvcPack.SvcResponseBatchGetGroupFilter
 * JD-Core Version:    0.7.0.1
 */