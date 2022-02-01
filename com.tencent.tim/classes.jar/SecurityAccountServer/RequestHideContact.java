package SecurityAccountServer;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RequestHideContact
  extends JceStruct
{
  static AddressBookItem cache_contact = new AddressBookItem();
  public AddressBookItem contact;
  public boolean isHide = true;
  
  public RequestHideContact() {}
  
  public RequestHideContact(AddressBookItem paramAddressBookItem, boolean paramBoolean)
  {
    this.contact = paramAddressBookItem;
    this.isHide = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.contact = ((AddressBookItem)paramJceInputStream.read(cache_contact, 0, true));
    this.isHide = paramJceInputStream.read(this.isHide, 1, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.contact, 0);
    paramJceOutputStream.write(this.isHide, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     SecurityAccountServer.RequestHideContact
 * JD-Core Version:    0.7.0.1
 */