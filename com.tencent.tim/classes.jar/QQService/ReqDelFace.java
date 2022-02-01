package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqDelFace
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static ArrayList<FaceInfo> cache_vFaceInfo;
  public ReqHead stHeader;
  public int uFaceTimeStamp;
  public ArrayList<FaceInfo> vFaceInfo;
  
  public ReqDelFace() {}
  
  public ReqDelFace(ReqHead paramReqHead, int paramInt, ArrayList<FaceInfo> paramArrayList)
  {
    this.stHeader = paramReqHead;
    this.uFaceTimeStamp = paramInt;
    this.vFaceInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, true);
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
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
    paramJceOutputStream.write(this.vFaceInfo, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     QQService.ReqDelFace
 * JD-Core Version:    0.7.0.1
 */