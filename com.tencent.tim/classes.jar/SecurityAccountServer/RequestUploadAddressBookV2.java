package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RequestUploadAddressBookV2
  extends JceStruct
{
  static ArrayList<AddressBookItem> cache_AddressBookList;
  static byte[] cache_sessionSid;
  public ArrayList<AddressBookItem> AddressBookList;
  public String MobileUniqueNo = "";
  public long nextFlag;
  public byte[] sessionSid;
  
  public RequestUploadAddressBookV2() {}
  
  public RequestUploadAddressBookV2(long paramLong, String paramString, byte[] paramArrayOfByte, ArrayList<AddressBookItem> paramArrayList)
  {
    this.nextFlag = paramLong;
    this.MobileUniqueNo = paramString;
    this.sessionSid = paramArrayOfByte;
    this.AddressBookList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.MobileUniqueNo = paramJceInputStream.readString(1, true);
    if (cache_sessionSid == null)
    {
      cache_sessionSid = (byte[])new byte[1];
      ((byte[])cache_sessionSid)[0] = 0;
    }
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    if (cache_AddressBookList == null)
    {
      cache_AddressBookList = new ArrayList();
      AddressBookItem localAddressBookItem = new AddressBookItem();
      cache_AddressBookList.add(localAddressBookItem);
    }
    this.AddressBookList = ((ArrayList)paramJceInputStream.read(cache_AddressBookList, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.MobileUniqueNo, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.AddressBookList, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestUploadAddressBookV2
 * JD-Core Version:    0.7.0.1
 */