package NearbyGroup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RspGetNearbyGroup
  extends JceStruct
{
  static int cache_eReplyCode;
  static RspActivity cache_stRspAct;
  static RspHotGrp cache_stRspHotGrp;
  static RspTopic cache_stRspTopic;
  static ArrayList cache_vActivity;
  static byte[] cache_vContext;
  static ArrayList cache_vGroupArea;
  static ArrayList cache_vGroupInfo;
  static ArrayList cache_vXiaoQuInfo;
  public int eReplyCode = 0;
  public int iCompletedFlag = 0;
  public int iLat = 0;
  public int iLon = 0;
  public int iRadius = 0;
  public short shSortType = 0;
  public RspActivity stRspAct = null;
  public RspHotGrp stRspHotGrp = null;
  public RspTopic stRspTopic = null;
  public ArrayList vActivity = null;
  public byte[] vContext = null;
  public ArrayList vGroupArea = null;
  public ArrayList vGroupInfo = null;
  public ArrayList vXiaoQuInfo = null;
  
  public RspGetNearbyGroup() {}
  
  public RspGetNearbyGroup(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, ArrayList paramArrayList4, short paramShort, int paramInt4, int paramInt5, RspHotGrp paramRspHotGrp, RspActivity paramRspActivity, RspTopic paramRspTopic)
  {
    this.eReplyCode = paramInt1;
    this.vContext = paramArrayOfByte;
    this.iCompletedFlag = paramInt2;
    this.iRadius = paramInt3;
    this.vGroupInfo = paramArrayList1;
    this.vXiaoQuInfo = paramArrayList2;
    this.vActivity = paramArrayList3;
    this.vGroupArea = paramArrayList4;
    this.shSortType = paramShort;
    this.iLat = paramInt4;
    this.iLon = paramInt5;
    this.stRspHotGrp = paramRspHotGrp;
    this.stRspAct = paramRspActivity;
    this.stRspTopic = paramRspTopic;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.eReplyCode = paramJceInputStream.read(this.eReplyCode, 0, true);
    if (cache_vContext == null)
    {
      cache_vContext = (byte[])new byte[1];
      ((byte[])cache_vContext)[0] = 0;
    }
    this.vContext = ((byte[])paramJceInputStream.read(cache_vContext, 1, false));
    this.iCompletedFlag = paramJceInputStream.read(this.iCompletedFlag, 2, true);
    this.iRadius = paramJceInputStream.read(this.iRadius, 3, false);
    Object localObject;
    if (cache_vGroupInfo == null)
    {
      cache_vGroupInfo = new ArrayList();
      localObject = new GroupInfo();
      cache_vGroupInfo.add(localObject);
    }
    this.vGroupInfo = ((ArrayList)paramJceInputStream.read(cache_vGroupInfo, 4, false));
    if (cache_vXiaoQuInfo == null)
    {
      cache_vXiaoQuInfo = new ArrayList();
      localObject = new XiaoQuInfo();
      cache_vXiaoQuInfo.add(localObject);
    }
    this.vXiaoQuInfo = ((ArrayList)paramJceInputStream.read(cache_vXiaoQuInfo, 5, false));
    if (cache_vActivity == null)
    {
      cache_vActivity = new ArrayList();
      localObject = new Activity();
      cache_vActivity.add(localObject);
    }
    this.vActivity = ((ArrayList)paramJceInputStream.read(cache_vActivity, 6, false));
    if (cache_vGroupArea == null)
    {
      cache_vGroupArea = new ArrayList();
      localObject = new GroupArea();
      cache_vGroupArea.add(localObject);
    }
    this.vGroupArea = ((ArrayList)paramJceInputStream.read(cache_vGroupArea, 7, false));
    this.shSortType = paramJceInputStream.read(this.shSortType, 8, false);
    this.iLat = paramJceInputStream.read(this.iLat, 9, false);
    this.iLon = paramJceInputStream.read(this.iLon, 10, false);
    if (cache_stRspHotGrp == null) {
      cache_stRspHotGrp = new RspHotGrp();
    }
    this.stRspHotGrp = ((RspHotGrp)paramJceInputStream.read(cache_stRspHotGrp, 11, false));
    if (cache_stRspAct == null) {
      cache_stRspAct = new RspActivity();
    }
    this.stRspAct = ((RspActivity)paramJceInputStream.read(cache_stRspAct, 12, false));
    if (cache_stRspTopic == null) {
      cache_stRspTopic = new RspTopic();
    }
    this.stRspTopic = ((RspTopic)paramJceInputStream.read(cache_stRspTopic, 13, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.eReplyCode, 0);
    if (this.vContext != null) {
      paramJceOutputStream.write(this.vContext, 1);
    }
    paramJceOutputStream.write(this.iCompletedFlag, 2);
    paramJceOutputStream.write(this.iRadius, 3);
    if (this.vGroupInfo != null) {
      paramJceOutputStream.write(this.vGroupInfo, 4);
    }
    if (this.vXiaoQuInfo != null) {
      paramJceOutputStream.write(this.vXiaoQuInfo, 5);
    }
    if (this.vActivity != null) {
      paramJceOutputStream.write(this.vActivity, 6);
    }
    if (this.vGroupArea != null) {
      paramJceOutputStream.write(this.vGroupArea, 7);
    }
    paramJceOutputStream.write(this.shSortType, 8);
    paramJceOutputStream.write(this.iLat, 9);
    paramJceOutputStream.write(this.iLon, 10);
    if (this.stRspHotGrp != null) {
      paramJceOutputStream.write(this.stRspHotGrp, 11);
    }
    if (this.stRspAct != null) {
      paramJceOutputStream.write(this.stRspAct, 12);
    }
    if (this.stRspTopic != null) {
      paramJceOutputStream.write(this.stRspTopic, 13);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     NearbyGroup.RspGetNearbyGroup
 * JD-Core Version:    0.7.0.1
 */