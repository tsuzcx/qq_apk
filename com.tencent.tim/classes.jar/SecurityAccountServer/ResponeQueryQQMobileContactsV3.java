package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeQueryQQMobileContactsV3
  extends JceStruct
{
  static ArrayList<MobileContactsFriendInfo> cache_BindFriendContacts;
  static ArrayList<MobileContactsNotFriendInfo> cache_BindNotFriendContacts;
  static int cache_queryFlag;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  static int cache_type = 0;
  public ArrayList<MobileContactsFriendInfo> BindFriendContacts;
  public ArrayList<MobileContactsNotFriendInfo> BindNotFriendContacts;
  public long ConfigVersion;
  public long ForcePopSwitch;
  public long MaxsignTimeStamp;
  public String MobileUniqueNo = "";
  public long PopCloseCount;
  public long PopWindowsCount;
  public long PopWindowsTime;
  public long UIBits;
  public long bindingTime;
  public boolean isChangeDev;
  public boolean isInactive;
  public long isRecommend;
  public long lastUsedFlag = 1L;
  public String mobileNo = "";
  public String nationCode = "";
  public long nextFlag;
  public long nextQueryTimeInterval;
  public long nextReLoginTimeInterval;
  public long nextReconnectionTimeInterval;
  public boolean noBindUploadContacts;
  public long originBinder = 1L;
  public int queryFlag;
  public byte[] sessionSid;
  public long timeStamp;
  public int type = 0;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_queryFlag = 0;
    cache_BindFriendContacts = new ArrayList();
    Object localObject = new MobileContactsFriendInfo();
    cache_BindFriendContacts.add(localObject);
    cache_BindNotFriendContacts = new ArrayList();
    localObject = new MobileContactsNotFriendInfo();
    cache_BindNotFriendContacts.add(localObject);
  }
  
  public ResponeQueryQQMobileContactsV3() {}
  
  public ResponeQueryQQMobileContactsV3(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, ArrayList<MobileContactsFriendInfo> paramArrayList, ArrayList<MobileContactsNotFriendInfo> paramArrayList1, String paramString1, String paramString2, String paramString3, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, long paramLong12, long paramLong13, boolean paramBoolean1, long paramLong14, boolean paramBoolean2, boolean paramBoolean3, long paramLong15, long paramLong16)
  {
    this.nextFlag = paramLong1;
    this.timeStamp = paramLong2;
    this.sessionSid = paramArrayOfByte;
    this.queryFlag = paramInt1;
    this.BindFriendContacts = paramArrayList;
    this.BindNotFriendContacts = paramArrayList1;
    this.nationCode = paramString1;
    this.mobileNo = paramString2;
    this.MobileUniqueNo = paramString3;
    this.isRecommend = paramLong3;
    this.originBinder = paramLong4;
    this.bindingTime = paramLong5;
    this.lastUsedFlag = paramLong6;
    this.type = paramInt2;
    this.ConfigVersion = paramLong7;
    this.PopWindowsCount = paramLong8;
    this.PopWindowsTime = paramLong9;
    this.PopCloseCount = paramLong10;
    this.ForcePopSwitch = paramLong11;
    this.nextQueryTimeInterval = paramLong12;
    this.MaxsignTimeStamp = paramLong13;
    this.isInactive = paramBoolean1;
    this.UIBits = paramLong14;
    this.isChangeDev = paramBoolean2;
    this.noBindUploadContacts = paramBoolean3;
    this.nextReconnectionTimeInterval = paramLong15;
    this.nextReLoginTimeInterval = paramLong16;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.queryFlag = paramJceInputStream.read(this.queryFlag, 3, true);
    this.BindFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindFriendContacts, 4, true));
    this.BindNotFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindNotFriendContacts, 5, true));
    this.nationCode = paramJceInputStream.readString(6, true);
    this.mobileNo = paramJceInputStream.readString(7, true);
    this.MobileUniqueNo = paramJceInputStream.readString(8, true);
    this.isRecommend = paramJceInputStream.read(this.isRecommend, 9, true);
    this.originBinder = paramJceInputStream.read(this.originBinder, 10, true);
    this.bindingTime = paramJceInputStream.read(this.bindingTime, 11, false);
    this.lastUsedFlag = paramJceInputStream.read(this.lastUsedFlag, 12, false);
    this.type = paramJceInputStream.read(this.type, 13, false);
    this.ConfigVersion = paramJceInputStream.read(this.ConfigVersion, 14, false);
    this.PopWindowsCount = paramJceInputStream.read(this.PopWindowsCount, 15, false);
    this.PopWindowsTime = paramJceInputStream.read(this.PopWindowsTime, 16, false);
    this.PopCloseCount = paramJceInputStream.read(this.PopCloseCount, 17, false);
    this.ForcePopSwitch = paramJceInputStream.read(this.ForcePopSwitch, 18, false);
    this.nextQueryTimeInterval = paramJceInputStream.read(this.nextQueryTimeInterval, 19, false);
    this.MaxsignTimeStamp = paramJceInputStream.read(this.MaxsignTimeStamp, 20, false);
    this.isInactive = paramJceInputStream.read(this.isInactive, 21, false);
    this.UIBits = paramJceInputStream.read(this.UIBits, 22, false);
    this.isChangeDev = paramJceInputStream.read(this.isChangeDev, 23, false);
    this.noBindUploadContacts = paramJceInputStream.read(this.noBindUploadContacts, 24, false);
    this.nextReconnectionTimeInterval = paramJceInputStream.read(this.nextReconnectionTimeInterval, 25, false);
    this.nextReLoginTimeInterval = paramJceInputStream.read(this.nextReLoginTimeInterval, 26, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.timeStamp, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.queryFlag, 3);
    paramJceOutputStream.write(this.BindFriendContacts, 4);
    paramJceOutputStream.write(this.BindNotFriendContacts, 5);
    paramJceOutputStream.write(this.nationCode, 6);
    paramJceOutputStream.write(this.mobileNo, 7);
    paramJceOutputStream.write(this.MobileUniqueNo, 8);
    paramJceOutputStream.write(this.isRecommend, 9);
    paramJceOutputStream.write(this.originBinder, 10);
    paramJceOutputStream.write(this.bindingTime, 11);
    paramJceOutputStream.write(this.lastUsedFlag, 12);
    paramJceOutputStream.write(this.type, 13);
    paramJceOutputStream.write(this.ConfigVersion, 14);
    paramJceOutputStream.write(this.PopWindowsCount, 15);
    paramJceOutputStream.write(this.PopWindowsTime, 16);
    paramJceOutputStream.write(this.PopCloseCount, 17);
    paramJceOutputStream.write(this.ForcePopSwitch, 18);
    paramJceOutputStream.write(this.nextQueryTimeInterval, 19);
    paramJceOutputStream.write(this.MaxsignTimeStamp, 20);
    paramJceOutputStream.write(this.isInactive, 21);
    paramJceOutputStream.write(this.UIBits, 22);
    paramJceOutputStream.write(this.isChangeDev, 23);
    paramJceOutputStream.write(this.noBindUploadContacts, 24);
    paramJceOutputStream.write(this.nextReconnectionTimeInterval, 25);
    paramJceOutputStream.write(this.nextReLoginTimeInterval, 26);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeQueryQQMobileContactsV3
 * JD-Core Version:    0.7.0.1
 */