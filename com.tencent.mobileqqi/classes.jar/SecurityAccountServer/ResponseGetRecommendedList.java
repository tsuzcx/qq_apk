package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponseGetRecommendedList
  extends JceStruct
{
  static ArrayList cache_alreadyBindContacts;
  static ArrayList cache_assistBindContacts;
  static ArrayList cache_circleInfo;
  static byte[] cache_sessionSid;
  static int cache_type;
  public String MobileUniqueNo = "";
  public ArrayList alreadyBindContacts = null;
  public ArrayList assistBindContacts = null;
  public ArrayList circleInfo = null;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  public long nextFlag = 0L;
  public long originBinder = 1L;
  public byte[] sessionSid = null;
  public long timeStamp = 0L;
  public int type = 0;
  
  public ResponseGetRecommendedList() {}
  
  public ResponseGetRecommendedList(long paramLong1, long paramLong2, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2, ArrayList paramArrayList3, String paramString1, String paramString2, String paramString3, long paramLong3, int paramInt, long paramLong4)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.alreadyBindContacts = paramArrayList1;
    this.circleInfo = paramArrayList2;
    this.assistBindContacts = paramArrayList3;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.MobileUniqueNo = paramString3;
    this.lastUsedFlag = paramLong3;
    this.type = paramInt;
    this.originBinder = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    Object localObject;
    if (cache_alreadyBindContacts == null)
    {
      cache_alreadyBindContacts = new ArrayList();
      localObject = new MobileContactsDetailInfo();
      cache_alreadyBindContacts.add(localObject);
    }
    this.alreadyBindContacts = ((ArrayList)paramJceInputStream.read(cache_alreadyBindContacts, 3, true));
    if (cache_circleInfo == null)
    {
      cache_circleInfo = new ArrayList();
      localObject = new CircleFriendInfo();
      cache_circleInfo.add(localObject);
    }
    this.circleInfo = ((ArrayList)paramJceInputStream.read(cache_circleInfo, 4, false));
    if (cache_assistBindContacts == null)
    {
      cache_assistBindContacts = new ArrayList();
      localObject = new MobileContactsDetailInfo();
      cache_assistBindContacts.add(localObject);
    }
    this.assistBindContacts = ((ArrayList)paramJceInputStream.read(cache_assistBindContacts, 5, false));
    this.nationCode = paramJceInputStream.readString(6, false);
    this.mobileNo = paramJceInputStream.readString(7, false);
    this.MobileUniqueNo = paramJceInputStream.readString(8, false);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 9, false);
    this.type = paramJceInputStream.read(this.type, 10, false);
    this.originBinder = paramJceInputStream.read(this.originBinder, 11, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.alreadyBindContacts, 3);
    if (this.circleInfo != null) {
      paramJceOutputStream.write(this.circleInfo, 4);
    }
    if (this.assistBindContacts != null) {
      paramJceOutputStream.write(this.assistBindContacts, 5);
    }
    if (this.nationCode != null) {
      paramJceOutputStream.write(this.nationCode, 6);
    }
    if (this.mobileNo != null) {
      paramJceOutputStream.write(this.mobileNo, 7);
    }
    if (this.MobileUniqueNo != null) {
      paramJceOutputStream.write(this.MobileUniqueNo, 8);
    }
    paramJceOutputStream.write(this.lastUsedFlag, 9);
    paramJceOutputStream.write(this.type, 10);
    paramJceOutputStream.write(this.originBinder, 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponseGetRecommendedList
 * JD-Core Version:    0.7.0.1
 */