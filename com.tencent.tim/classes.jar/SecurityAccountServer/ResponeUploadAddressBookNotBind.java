package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ResponeUploadAddressBookNotBind
  extends JceStruct
{
  static ArrayList<NotBindContactFriendInfo> cache_BindFriendContacts;
  static ArrayList<NotBindContactNotFriendInfo> cache_BindNotFriendContacts;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public ArrayList<NotBindContactFriendInfo> BindFriendContacts;
  public ArrayList<NotBindContactNotFriendInfo> BindNotFriendContacts;
  public long nextFlag;
  public byte[] sessionSid;
  public long timeStamp;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_BindNotFriendContacts = new ArrayList();
    Object localObject = new NotBindContactNotFriendInfo();
    cache_BindNotFriendContacts.add(localObject);
    cache_BindFriendContacts = new ArrayList();
    localObject = new NotBindContactFriendInfo();
    cache_BindFriendContacts.add(localObject);
  }
  
  public ResponeUploadAddressBookNotBind() {}
  
  public ResponeUploadAddressBookNotBind(long paramLong1, byte[] paramArrayOfByte, ArrayList<NotBindContactNotFriendInfo> paramArrayList, ArrayList<NotBindContactFriendInfo> paramArrayList1, long paramLong2)
  {
    this.nextFlag = paramLong1;
    this.sessionSid = paramArrayOfByte;
    this.BindNotFriendContacts = paramArrayList;
    this.BindFriendContacts = paramArrayList1;
    this.timeStamp = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 1, true));
    this.BindNotFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindNotFriendContacts, 2, true));
    this.BindFriendContacts = ((ArrayList)paramJceInputStream.read(cache_BindFriendContacts, 3, true));
    this.timeStamp = paramJceInputStream.read(this.timeStamp, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.sessionSid, 1);
    paramJceOutputStream.write(this.BindNotFriendContacts, 2);
    paramJceOutputStream.write(this.BindFriendContacts, 3);
    paramJceOutputStream.write(this.timeStamp, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.ResponeUploadAddressBookNotBind
 * JD-Core Version:    0.7.0.1
 */