package NS_KING_PUBLIC;

import android.support.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class stRspHeader
  extends JceStruct
{
  static Map<String, String> cache_mapExt = new HashMap();
  public int iRet;
  @Nullable
  public Map<String, String> mapExt;
  public String sErrmsg = "";
  
  static
  {
    cache_mapExt.put("", "");
  }
  
  public stRspHeader() {}
  
  public stRspHeader(int paramInt, String paramString)
  {
    this.iRet = paramInt;
    this.sErrmsg = paramString;
  }
  
  public stRspHeader(int paramInt, String paramString, Map<String, String> paramMap)
  {
    this.iRet = paramInt;
    this.sErrmsg = paramString;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iRet = paramJceInputStream.read(this.iRet, 0, true);
    this.sErrmsg = paramJceInputStream.readString(1, true);
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iRet, 0);
    paramJceOutputStream.write(this.sErrmsg, 1);
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_KING_PUBLIC.stRspHeader
 * JD-Core Version:    0.7.0.1
 */