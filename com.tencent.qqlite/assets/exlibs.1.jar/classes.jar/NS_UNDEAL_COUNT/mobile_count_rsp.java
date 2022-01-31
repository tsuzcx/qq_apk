package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_rsp
  extends JceStruct
{
  static Map cache_mapBuf;
  static single_count cache_stActiveCount;
  static single_count cache_stAppCount;
  static ban_info cache_stBanInfo;
  static birth_info cache_stBirthInfo;
  static single_count cache_stFlower;
  static single_count cache_stFriendReqCount;
  static single_count cache_stFriendsBirthdayCount;
  static single_count cache_stGameBarInfo;
  static single_count cache_stMainPageCount;
  static single_count cache_stPassiveCount;
  static single_count cache_stPersionalInfo;
  static single_count cache_stQzoneVipInfo;
  static single_count cache_stReadSpace;
  static single_count cache_stSecretInfo;
  static single_count cache_stSubscribeAlbum;
  static single_count cache_stVisitReqInfo;
  static single_count cache_stVisitorCount;
  static yellow_info cache_stYellowInfo;
  static ArrayList cache_vecUpdateFeedFriendsList;
  static ArrayList cache_vecUpdatePassiveList;
  public int iNextTimeout = 0;
  public Map mapBuf = null;
  public single_count stActiveCount = null;
  public single_count stAppCount = null;
  public ban_info stBanInfo = null;
  public birth_info stBirthInfo = null;
  public single_count stFlower = null;
  public single_count stFriendReqCount = null;
  public single_count stFriendsBirthdayCount = null;
  public single_count stGameBarInfo = null;
  public single_count stMainPageCount = null;
  public single_count stPassiveCount = null;
  public single_count stPersionalInfo = null;
  public single_count stQzoneVipInfo = null;
  public single_count stReadSpace = null;
  public single_count stSecretInfo = null;
  public single_count stSubscribeAlbum = null;
  public single_count stVisitReqInfo = null;
  public single_count stVisitorCount = null;
  public yellow_info stYellowInfo = null;
  public String strDeviceName = "";
  public String strNick = "";
  public long uRspMask = 0L;
  public ArrayList vecUpdateFeedFriendsList = null;
  public ArrayList vecUpdatePassiveList = null;
  
  public mobile_count_rsp() {}
  
  public mobile_count_rsp(single_count paramsingle_count1, single_count paramsingle_count2, single_count paramsingle_count3, single_count paramsingle_count4, long paramLong, ban_info paramban_info, birth_info parambirth_info, String paramString1, single_count paramsingle_count5, int paramInt, single_count paramsingle_count6, single_count paramsingle_count7, yellow_info paramyellow_info, ArrayList paramArrayList1, String paramString2, ArrayList paramArrayList2, single_count paramsingle_count8, single_count paramsingle_count9, single_count paramsingle_count10, Map paramMap, single_count paramsingle_count11, single_count paramsingle_count12, single_count paramsingle_count13, single_count paramsingle_count14, single_count paramsingle_count15)
  {
    this.stPassiveCount = paramsingle_count1;
    this.stActiveCount = paramsingle_count2;
    this.stVisitorCount = paramsingle_count3;
    this.stFriendReqCount = paramsingle_count4;
    this.uRspMask = paramLong;
    this.stBanInfo = paramban_info;
    this.stBirthInfo = parambirth_info;
    this.strNick = paramString1;
    this.stAppCount = paramsingle_count5;
    this.iNextTimeout = paramInt;
    this.stFriendsBirthdayCount = paramsingle_count6;
    this.stMainPageCount = paramsingle_count7;
    this.stYellowInfo = paramyellow_info;
    this.vecUpdateFeedFriendsList = paramArrayList1;
    this.strDeviceName = paramString2;
    this.vecUpdatePassiveList = paramArrayList2;
    this.stReadSpace = paramsingle_count8;
    this.stFlower = paramsingle_count9;
    this.stSubscribeAlbum = paramsingle_count10;
    this.mapBuf = paramMap;
    this.stGameBarInfo = paramsingle_count11;
    this.stPersionalInfo = paramsingle_count12;
    this.stQzoneVipInfo = paramsingle_count13;
    this.stVisitReqInfo = paramsingle_count14;
    this.stSecretInfo = paramsingle_count15;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stPassiveCount == null) {
      cache_stPassiveCount = new single_count();
    }
    this.stPassiveCount = ((single_count)paramJceInputStream.read(cache_stPassiveCount, 0, false));
    if (cache_stActiveCount == null) {
      cache_stActiveCount = new single_count();
    }
    this.stActiveCount = ((single_count)paramJceInputStream.read(cache_stActiveCount, 1, false));
    if (cache_stVisitorCount == null) {
      cache_stVisitorCount = new single_count();
    }
    this.stVisitorCount = ((single_count)paramJceInputStream.read(cache_stVisitorCount, 2, false));
    if (cache_stFriendReqCount == null) {
      cache_stFriendReqCount = new single_count();
    }
    this.stFriendReqCount = ((single_count)paramJceInputStream.read(cache_stFriendReqCount, 3, false));
    this.uRspMask = paramJceInputStream.read(this.uRspMask, 4, false);
    if (cache_stBanInfo == null) {
      cache_stBanInfo = new ban_info();
    }
    this.stBanInfo = ((ban_info)paramJceInputStream.read(cache_stBanInfo, 5, false));
    if (cache_stBirthInfo == null) {
      cache_stBirthInfo = new birth_info();
    }
    this.stBirthInfo = ((birth_info)paramJceInputStream.read(cache_stBirthInfo, 6, false));
    this.strNick = paramJceInputStream.readString(7, false);
    if (cache_stAppCount == null) {
      cache_stAppCount = new single_count();
    }
    this.stAppCount = ((single_count)paramJceInputStream.read(cache_stAppCount, 8, false));
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 9, false);
    if (cache_stFriendsBirthdayCount == null) {
      cache_stFriendsBirthdayCount = new single_count();
    }
    this.stFriendsBirthdayCount = ((single_count)paramJceInputStream.read(cache_stFriendsBirthdayCount, 10, false));
    if (cache_stMainPageCount == null) {
      cache_stMainPageCount = new single_count();
    }
    this.stMainPageCount = ((single_count)paramJceInputStream.read(cache_stMainPageCount, 11, false));
    if (cache_stYellowInfo == null) {
      cache_stYellowInfo = new yellow_info();
    }
    this.stYellowInfo = ((yellow_info)paramJceInputStream.read(cache_stYellowInfo, 12, false));
    Object localObject;
    if (cache_vecUpdateFeedFriendsList == null)
    {
      cache_vecUpdateFeedFriendsList = new ArrayList();
      localObject = new feed_host_info();
      cache_vecUpdateFeedFriendsList.add(localObject);
    }
    this.vecUpdateFeedFriendsList = ((ArrayList)paramJceInputStream.read(cache_vecUpdateFeedFriendsList, 13, false));
    this.strDeviceName = paramJceInputStream.readString(14, false);
    if (cache_vecUpdatePassiveList == null)
    {
      cache_vecUpdatePassiveList = new ArrayList();
      localObject = new feed_host_info();
      cache_vecUpdatePassiveList.add(localObject);
    }
    this.vecUpdatePassiveList = ((ArrayList)paramJceInputStream.read(cache_vecUpdatePassiveList, 15, false));
    if (cache_stReadSpace == null) {
      cache_stReadSpace = new single_count();
    }
    this.stReadSpace = ((single_count)paramJceInputStream.read(cache_stReadSpace, 16, false));
    if (cache_stFlower == null) {
      cache_stFlower = new single_count();
    }
    this.stFlower = ((single_count)paramJceInputStream.read(cache_stFlower, 17, false));
    if (cache_stSubscribeAlbum == null) {
      cache_stSubscribeAlbum = new single_count();
    }
    this.stSubscribeAlbum = ((single_count)paramJceInputStream.read(cache_stSubscribeAlbum, 18, false));
    if (cache_mapBuf == null)
    {
      cache_mapBuf = new HashMap();
      localObject = new s_comm_data();
      cache_mapBuf.put(Long.valueOf(0L), localObject);
    }
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 19, false));
    if (cache_stGameBarInfo == null) {
      cache_stGameBarInfo = new single_count();
    }
    this.stGameBarInfo = ((single_count)paramJceInputStream.read(cache_stGameBarInfo, 20, false));
    if (cache_stPersionalInfo == null) {
      cache_stPersionalInfo = new single_count();
    }
    this.stPersionalInfo = ((single_count)paramJceInputStream.read(cache_stPersionalInfo, 21, false));
    if (cache_stQzoneVipInfo == null) {
      cache_stQzoneVipInfo = new single_count();
    }
    this.stQzoneVipInfo = ((single_count)paramJceInputStream.read(cache_stQzoneVipInfo, 22, false));
    if (cache_stVisitReqInfo == null) {
      cache_stVisitReqInfo = new single_count();
    }
    this.stVisitReqInfo = ((single_count)paramJceInputStream.read(cache_stVisitReqInfo, 23, false));
    if (cache_stSecretInfo == null) {
      cache_stSecretInfo = new single_count();
    }
    this.stSecretInfo = ((single_count)paramJceInputStream.read(cache_stSecretInfo, 24, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stPassiveCount != null) {
      paramJceOutputStream.write(this.stPassiveCount, 0);
    }
    if (this.stActiveCount != null) {
      paramJceOutputStream.write(this.stActiveCount, 1);
    }
    if (this.stVisitorCount != null) {
      paramJceOutputStream.write(this.stVisitorCount, 2);
    }
    if (this.stFriendReqCount != null) {
      paramJceOutputStream.write(this.stFriendReqCount, 3);
    }
    paramJceOutputStream.write(this.uRspMask, 4);
    if (this.stBanInfo != null) {
      paramJceOutputStream.write(this.stBanInfo, 5);
    }
    if (this.stBirthInfo != null) {
      paramJceOutputStream.write(this.stBirthInfo, 6);
    }
    if (this.strNick != null) {
      paramJceOutputStream.write(this.strNick, 7);
    }
    if (this.stAppCount != null) {
      paramJceOutputStream.write(this.stAppCount, 8);
    }
    paramJceOutputStream.write(this.iNextTimeout, 9);
    if (this.stFriendsBirthdayCount != null) {
      paramJceOutputStream.write(this.stFriendsBirthdayCount, 10);
    }
    if (this.stMainPageCount != null) {
      paramJceOutputStream.write(this.stMainPageCount, 11);
    }
    if (this.stYellowInfo != null) {
      paramJceOutputStream.write(this.stYellowInfo, 12);
    }
    if (this.vecUpdateFeedFriendsList != null) {
      paramJceOutputStream.write(this.vecUpdateFeedFriendsList, 13);
    }
    if (this.strDeviceName != null) {
      paramJceOutputStream.write(this.strDeviceName, 14);
    }
    if (this.vecUpdatePassiveList != null) {
      paramJceOutputStream.write(this.vecUpdatePassiveList, 15);
    }
    if (this.stReadSpace != null) {
      paramJceOutputStream.write(this.stReadSpace, 16);
    }
    if (this.stFlower != null) {
      paramJceOutputStream.write(this.stFlower, 17);
    }
    if (this.stSubscribeAlbum != null) {
      paramJceOutputStream.write(this.stSubscribeAlbum, 18);
    }
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 19);
    }
    if (this.stGameBarInfo != null) {
      paramJceOutputStream.write(this.stGameBarInfo, 20);
    }
    if (this.stPersionalInfo != null) {
      paramJceOutputStream.write(this.stPersionalInfo, 21);
    }
    if (this.stQzoneVipInfo != null) {
      paramJceOutputStream.write(this.stQzoneVipInfo, 22);
    }
    if (this.stVisitReqInfo != null) {
      paramJceOutputStream.write(this.stVisitReqInfo, 23);
    }
    if (this.stSecretInfo != null) {
      paramJceOutputStream.write(this.stSecretInfo, 24);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_rsp
 * JD-Core Version:    0.7.0.1
 */