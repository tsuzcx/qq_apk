package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetFace
  extends JceStruct
{
  static RespHead cache_stHeader;
  static UserCntlData cache_stUserData;
  static ArrayList cache_vFaceInfo;
  public RespHead stHeader = null;
  public UserCntlData stUserData = null;
  public ArrayList vFaceInfo = null;
  
  public RespGetFace() {}
  
  public RespGetFace(RespHead paramRespHead, UserCntlData paramUserCntlData, ArrayList paramArrayList)
  {
    this.stHeader = paramRespHead;
    this.stUserData = paramUserCntlData;
    this.vFaceInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new RespHead();
    }
    this.stHeader = ((RespHead)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 1, true));
    if (cache_vFaceInfo == null)
    {
      cache_vFaceInfo = new ArrayList();
      FaceInfo localFaceInfo = new FaceInfo();
      cache_vFaceInfo.add(localFaceInfo);
    }
    this.vFaceInfo = ((ArrayList)paramJceInputStream.read(cache_vFaceInfo, 2, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stUserData, 1);
    paramJceOutputStream.write(this.vFaceInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.RespGetFace
 * JD-Core Version:    0.7.0.1
 */