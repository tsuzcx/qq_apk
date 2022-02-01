package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ProfUsrFullInfoRes
  extends JceStruct
{
  static Map<Long, String> cache_sRemarkInfo;
  static ArrayList<TagInfo> cache_sTagInfo;
  static ProfSmpInfoRes cache_strPfileSmpInfoRes;
  public Map<Long, String> sRemarkInfo;
  public String sSigInfo = "";
  public ArrayList<TagInfo> sTagInfo;
  public ProfSmpInfoRes strPfileSmpInfoRes;
  
  public ProfUsrFullInfoRes() {}
  
  public ProfUsrFullInfoRes(ProfSmpInfoRes paramProfSmpInfoRes, String paramString, Map<Long, String> paramMap, ArrayList<TagInfo> paramArrayList)
  {
    this.strPfileSmpInfoRes = paramProfSmpInfoRes;
    this.sSigInfo = paramString;
    this.sRemarkInfo = paramMap;
    this.sTagInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_strPfileSmpInfoRes == null) {
      cache_strPfileSmpInfoRes = new ProfSmpInfoRes();
    }
    this.strPfileSmpInfoRes = ((ProfSmpInfoRes)paramJceInputStream.read(cache_strPfileSmpInfoRes, 1, true));
    this.sSigInfo = paramJceInputStream.readString(2, true);
    if (cache_sRemarkInfo == null)
    {
      cache_sRemarkInfo = new HashMap();
      cache_sRemarkInfo.put(Long.valueOf(0L), "");
    }
    this.sRemarkInfo = ((Map)paramJceInputStream.read(cache_sRemarkInfo, 3, true));
    if (cache_sTagInfo == null)
    {
      cache_sTagInfo = new ArrayList();
      TagInfo localTagInfo = new TagInfo();
      cache_sTagInfo.add(localTagInfo);
    }
    this.sTagInfo = ((ArrayList)paramJceInputStream.read(cache_sTagInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPfileSmpInfoRes, 1);
    paramJceOutputStream.write(this.sSigInfo, 2);
    paramJceOutputStream.write(this.sRemarkInfo, 3);
    if (this.sTagInfo != null) {
      paramJceOutputStream.write(this.sTagInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     KQQ.ProfUsrFullInfoRes
 * JD-Core Version:    0.7.0.1
 */