package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddFriendReq
  extends JceStruct
{
  static int cache_adduinsetting;
  static byte[] cache_friend_src_desc;
  static byte[] cache_name;
  static byte[] cache_name1;
  static byte[] cache_remark;
  static byte[] cache_sig;
  static int cache_sourceID;
  static int cache_sourceSubID;
  static byte[] cache_src_description;
  public long adduin = 0L;
  public int adduinsetting = 0;
  public byte autoSend = 1;
  public boolean contact_bothway_friend = false;
  public byte[] friend_src_desc = null;
  public String msg = "";
  public byte msgLen = 0;
  public byte myAllowFlag = 0;
  public byte myfriendgroupid = 0;
  public byte[] name = null;
  public byte[] name1 = null;
  public byte[] remark = null;
  public byte[] sig = null;
  public int sourceID = 10004;
  public int sourceSubID = 0;
  public byte srcFlag = 0;
  public byte[] src_description = null;
  public long uin = 0L;
  
  public AddFriendReq() {}
  
  public AddFriendReq(long paramLong1, long paramLong2, int paramInt1, byte paramByte1, byte paramByte2, byte paramByte3, String paramString, byte paramByte4, byte paramByte5, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, boolean paramBoolean, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6)
  {
    this.uin = paramLong1;
    this.adduin = paramLong2;
    this.adduinsetting = paramInt1;
    this.myAllowFlag = paramByte1;
    this.myfriendgroupid = paramByte2;
    this.msgLen = paramByte3;
    this.msg = paramString;
    this.srcFlag = paramByte4;
    this.autoSend = paramByte5;
    this.sig = paramArrayOfByte1;
    this.sourceID = paramInt2;
    this.sourceSubID = paramInt3;
    this.name = paramArrayOfByte2;
    this.src_description = paramArrayOfByte3;
    this.friend_src_desc = paramArrayOfByte4;
    this.contact_bothway_friend = paramBoolean;
    this.remark = paramArrayOfByte5;
    this.name1 = paramArrayOfByte6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.adduin = paramJceInputStream.read(this.adduin, 1, true);
    this.adduinsetting = paramJceInputStream.read(this.adduinsetting, 2, true);
    this.myAllowFlag = paramJceInputStream.read(this.myAllowFlag, 3, true);
    this.myfriendgroupid = paramJceInputStream.read(this.myfriendgroupid, 4, true);
    this.msgLen = paramJceInputStream.read(this.msgLen, 5, false);
    this.msg = paramJceInputStream.readString(6, false);
    this.srcFlag = paramJceInputStream.read(this.srcFlag, 7, false);
    this.autoSend = paramJceInputStream.read(this.autoSend, 8, false);
    if (cache_sig == null)
    {
      cache_sig = (byte[])new byte[1];
      ((byte[])cache_sig)[0] = 0;
    }
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 9, false));
    this.sourceID = paramJceInputStream.read(this.sourceID, 10, false);
    this.sourceSubID = paramJceInputStream.read(this.sourceSubID, 11, false);
    if (cache_name == null)
    {
      cache_name = (byte[])new byte[1];
      ((byte[])cache_name)[0] = 0;
    }
    this.name = ((byte[])paramJceInputStream.read(cache_name, 12, false));
    if (cache_src_description == null)
    {
      cache_src_description = (byte[])new byte[1];
      ((byte[])cache_src_description)[0] = 0;
    }
    this.src_description = ((byte[])paramJceInputStream.read(cache_src_description, 13, false));
    if (cache_friend_src_desc == null)
    {
      cache_friend_src_desc = (byte[])new byte[1];
      ((byte[])cache_friend_src_desc)[0] = 0;
    }
    this.friend_src_desc = ((byte[])paramJceInputStream.read(cache_friend_src_desc, 14, false));
    this.contact_bothway_friend = paramJceInputStream.read(this.contact_bothway_friend, 15, false);
    if (cache_remark == null)
    {
      cache_remark = (byte[])new byte[1];
      ((byte[])cache_remark)[0] = 0;
    }
    this.remark = ((byte[])paramJceInputStream.read(cache_remark, 16, false));
    if (cache_name1 == null)
    {
      cache_name1 = (byte[])new byte[1];
      ((byte[])cache_name1)[0] = 0;
    }
    this.name1 = ((byte[])paramJceInputStream.read(cache_name1, 17, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.adduin, 1);
    paramJceOutputStream.write(this.adduinsetting, 2);
    paramJceOutputStream.write(this.myAllowFlag, 3);
    paramJceOutputStream.write(this.myfriendgroupid, 4);
    paramJceOutputStream.write(this.msgLen, 5);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 6);
    }
    paramJceOutputStream.write(this.srcFlag, 7);
    paramJceOutputStream.write(this.autoSend, 8);
    if (this.sig != null) {
      paramJceOutputStream.write(this.sig, 9);
    }
    paramJceOutputStream.write(this.sourceID, 10);
    paramJceOutputStream.write(this.sourceSubID, 11);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 12);
    }
    if (this.src_description != null) {
      paramJceOutputStream.write(this.src_description, 13);
    }
    if (this.friend_src_desc != null) {
      paramJceOutputStream.write(this.friend_src_desc, 14);
    }
    paramJceOutputStream.write(this.contact_bothway_friend, 15);
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 16);
    }
    if (this.name1 != null) {
      paramJceOutputStream.write(this.name1, 17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.AddFriendReq
 * JD-Core Version:    0.7.0.1
 */