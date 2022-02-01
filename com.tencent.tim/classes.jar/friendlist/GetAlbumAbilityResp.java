package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAlbumAbilityResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList<stAlbumAbiInfo> cache_vecAlbumAbiUins;
  public int result;
  public long uin;
  public ArrayList<stAlbumAbiInfo> vecAlbumAbiUins;
  
  public GetAlbumAbilityResp() {}
  
  public GetAlbumAbilityResp(long paramLong, int paramInt, ArrayList<stAlbumAbiInfo> paramArrayList)
  {
    this.uin = paramLong;
    this.result = paramInt;
    this.vecAlbumAbiUins = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.result = paramJceInputStream.read(this.result, 1, true);
    if (cache_vecAlbumAbiUins == null)
    {
      cache_vecAlbumAbiUins = new ArrayList();
      stAlbumAbiInfo localstAlbumAbiInfo = new stAlbumAbiInfo();
      cache_vecAlbumAbiUins.add(localstAlbumAbiInfo);
    }
    this.vecAlbumAbiUins = ((ArrayList)paramJceInputStream.read(cache_vecAlbumAbiUins, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.result, 1);
    paramJceOutputStream.write(this.vecAlbumAbiUins, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     friendlist.GetAlbumAbilityResp
 * JD-Core Version:    0.7.0.1
 */