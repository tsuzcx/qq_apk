package NS_QQRADIO_PROTOCOL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetLiveShowSimpleRoomInfoRsp
  extends JceStruct
{
  static RecordPlayInfo cache_recordPlayInfo = new RecordPlayInfo();
  public int happychat;
  public int isRecordVideo;
  public String multiVideoStreamUrl = "";
  public RecordPlayInfo recordPlayInfo;
  public String roomName = "";
  public int roomStatus;
  public String roomid = "";
  public String uid = "";
  public String videoRtmpUrl = "";
  
  public GetLiveShowSimpleRoomInfoRsp() {}
  
  public GetLiveShowSimpleRoomInfoRsp(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, RecordPlayInfo paramRecordPlayInfo, int paramInt3)
  {
    this.roomid = paramString1;
    this.uid = paramString2;
    this.roomName = paramString3;
    this.roomStatus = paramInt1;
    this.multiVideoStreamUrl = paramString4;
    this.videoRtmpUrl = paramString5;
    this.isRecordVideo = paramInt2;
    this.recordPlayInfo = paramRecordPlayInfo;
    this.happychat = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.roomid = paramJceInputStream.readString(0, false);
    this.uid = paramJceInputStream.readString(1, false);
    this.roomName = paramJceInputStream.readString(2, false);
    this.roomStatus = paramJceInputStream.read(this.roomStatus, 3, false);
    this.multiVideoStreamUrl = paramJceInputStream.readString(4, false);
    this.videoRtmpUrl = paramJceInputStream.readString(5, false);
    this.isRecordVideo = paramJceInputStream.read(this.isRecordVideo, 6, false);
    this.recordPlayInfo = ((RecordPlayInfo)paramJceInputStream.read(cache_recordPlayInfo, 7, false));
    this.happychat = paramJceInputStream.read(this.happychat, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.roomid != null) {
      paramJceOutputStream.write(this.roomid, 0);
    }
    if (this.uid != null) {
      paramJceOutputStream.write(this.uid, 1);
    }
    if (this.roomName != null) {
      paramJceOutputStream.write(this.roomName, 2);
    }
    paramJceOutputStream.write(this.roomStatus, 3);
    if (this.multiVideoStreamUrl != null) {
      paramJceOutputStream.write(this.multiVideoStreamUrl, 4);
    }
    if (this.videoRtmpUrl != null) {
      paramJceOutputStream.write(this.videoRtmpUrl, 5);
    }
    paramJceOutputStream.write(this.isRecordVideo, 6);
    if (this.recordPlayInfo != null) {
      paramJceOutputStream.write(this.recordPlayInfo, 7);
    }
    paramJceOutputStream.write(this.happychat, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_QQRADIO_PROTOCOL.GetLiveShowSimpleRoomInfoRsp
 * JD-Core Version:    0.7.0.1
 */