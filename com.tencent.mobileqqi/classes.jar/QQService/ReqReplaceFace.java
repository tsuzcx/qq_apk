package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqReplaceFace
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static FaceInfo cache_stNewFaceInfo;
  static FaceInfo cache_stOldFaceInfo;
  public ReqHead stHeader = null;
  public FaceInfo stNewFaceInfo = null;
  public FaceInfo stOldFaceInfo = null;
  public int uFaceTimeStamp = 0;
  
  public ReqReplaceFace() {}
  
  public ReqReplaceFace(ReqHead paramReqHead, int paramInt, FaceInfo paramFaceInfo1, FaceInfo paramFaceInfo2)
  {
    this.stHeader = paramReqHead;
    this.uFaceTimeStamp = paramInt;
    this.stOldFaceInfo = paramFaceInfo1;
    this.stNewFaceInfo = paramFaceInfo2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.uFaceTimeStamp = paramJceInputStream.read(this.uFaceTimeStamp, 1, true);
    if (cache_stOldFaceInfo == null) {
      cache_stOldFaceInfo = new FaceInfo();
    }
    this.stOldFaceInfo = ((FaceInfo)paramJceInputStream.read(cache_stOldFaceInfo, 2, true));
    if (cache_stNewFaceInfo == null) {
      cache_stNewFaceInfo = new FaceInfo();
    }
    this.stNewFaceInfo = ((FaceInfo)paramJceInputStream.read(cache_stNewFaceInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.uFaceTimeStamp, 1);
    paramJceOutputStream.write(this.stOldFaceInfo, 2);
    paramJceOutputStream.write(this.stNewFaceInfo, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     QQService.ReqReplaceFace
 * JD-Core Version:    0.7.0.1
 */