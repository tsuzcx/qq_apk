package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeAddress;
import java.util.ArrayList;

public class IMAPAddress
  extends MimeAddress
{
  private boolean group = false;
  private ArrayList<IMAPAddress> grouplist;
  private String groupname;
  
  IMAPAddress(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.readByte() != 40) {
      throw new MessageException(2, "parse address error missing (" + paramIMAPResponse.getContent());
    }
    setNick(paramIMAPResponse.readString());
    paramIMAPResponse.readString();
    Object localObject1 = paramIMAPResponse.readString();
    Object localObject2 = paramIMAPResponse.readString();
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.readByte() != 41) {
      throw new MessageException(2, "parse address error missing ) " + paramIMAPResponse.getContent());
    }
    if (localObject2 == null)
    {
      this.group = true;
      this.groupname = ((String)localObject1);
      if (this.groupname == null) {
        return;
      }
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append(this.groupname).append(':');
      for (;;)
      {
        if (paramIMAPResponse.peekByte() != 41)
        {
          localObject2 = new IMAPAddress(paramIMAPResponse);
          if (!((IMAPAddress)localObject2).isEndOfGroup()) {}
        }
        else
        {
          ((StringBuffer)localObject1).append(';');
          setEmail(((StringBuffer)localObject1).toString());
          return;
        }
        if (this.grouplist.size() != 0) {
          ((StringBuffer)localObject1).append(',');
        }
        ((StringBuffer)localObject1).append(((IMAPAddress)localObject2).toString());
        this.grouplist.add(localObject2);
      }
    }
    if ((localObject1 == null) || (((String)localObject1).length() == 0))
    {
      setEmail((String)localObject2);
      return;
    }
    if (((String)localObject2).length() == 0)
    {
      setEmail((String)localObject1);
      return;
    }
    setEmail((String)localObject1 + "@" + (String)localObject2);
  }
  
  public ArrayList<IMAPAddress> getGrouplist()
  {
    return this.grouplist;
  }
  
  public boolean isEndOfGroup()
  {
    return (this.group) && (this.groupname == null);
  }
  
  public boolean isGroup()
  {
    return this.group;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPAddress
 * JD-Core Version:    0.7.0.1
 */