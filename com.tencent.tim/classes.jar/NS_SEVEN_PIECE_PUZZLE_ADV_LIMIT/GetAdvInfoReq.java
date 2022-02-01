package NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAdvInfoReq
  extends JceStruct
{
  static ArrayList<String> cache_vecAdvIdList = new ArrayList();
  public String strUid = "";
  public ArrayList<String> vecAdvIdList;
  
  static
  {
    cache_vecAdvIdList.add("");
  }
  
  public GetAdvInfoReq() {}
  
  public GetAdvInfoReq(ArrayList<String> paramArrayList, String paramString)
  {
    this.vecAdvIdList = paramArrayList;
    this.strUid = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.vecAdvIdList = ((ArrayList)paramJceInputStream.read(cache_vecAdvIdList, 0, false));
    this.strUid = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecAdvIdList != null) {
      paramJceOutputStream.write(this.vecAdvIdList, 0);
    }
    if (this.strUid != null) {
      paramJceOutputStream.write(this.strUid, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_SEVEN_PIECE_PUZZLE_ADV_LIMIT.GetAdvInfoReq
 * JD-Core Version:    0.7.0.1
 */