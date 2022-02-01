package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RequestUpdateAddressBookNotBind
  extends JceStruct
{
  static ArrayList<AddressBookItem> cache_AddressBookAddList;
  static ArrayList<AddressBookItem> cache_AddressBookDelList;
  static byte[] cache_sessionSid = (byte[])new byte[1];
  public ArrayList<AddressBookItem> AddressBookAddList;
  public ArrayList<AddressBookItem> AddressBookDelList;
  public String MobileUniqueNo = "";
  public long nextFlag;
  public byte[] sessionSid;
  
  static
  {
    ((byte[])cache_sessionSid)[0] = 0;
    cache_AddressBookAddList = new ArrayList();
    AddressBookItem localAddressBookItem = new AddressBookItem();
    cache_AddressBookAddList.add(localAddressBookItem);
    cache_AddressBookDelList = new ArrayList();
    localAddressBookItem = new AddressBookItem();
    cache_AddressBookDelList.add(localAddressBookItem);
  }
  
  public RequestUpdateAddressBookNotBind() {}
  
  public RequestUpdateAddressBookNotBind(long paramLong, String paramString, byte[] paramArrayOfByte, ArrayList<AddressBookItem> paramArrayList1, ArrayList<AddressBookItem> paramArrayList2)
  {
    this.nextFlag = paramLong;
    this.MobileUniqueNo = paramString;
    this.sessionSid = paramArrayOfByte;
    this.AddressBookAddList = paramArrayList1;
    this.AddressBookDelList = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nextFlag = paramJceInputStream.read(this.nextFlag, 0, true);
    this.MobileUniqueNo = paramJceInputStream.readString(1, true);
    this.sessionSid = ((byte[])paramJceInputStream.read(cache_sessionSid, 2, true));
    this.AddressBookAddList = ((ArrayList)paramJceInputStream.read(cache_AddressBookAddList, 3, true));
    this.AddressBookDelList = ((ArrayList)paramJceInputStream.read(cache_AddressBookDelList, 4, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nextFlag, 0);
    paramJceOutputStream.write(this.MobileUniqueNo, 1);
    paramJceOutputStream.write(this.sessionSid, 2);
    paramJceOutputStream.write(this.AddressBookAddList, 3);
    paramJceOutputStream.write(this.AddressBookDelList, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestUpdateAddressBookNotBind
 * JD-Core Version:    0.7.0.1
 */