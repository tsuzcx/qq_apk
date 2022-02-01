package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;

public class IMAPBody
  implements IMAPFetchItem
{
  static final char[] name = { 66, 79, 68, 89 };
  private ByteArray data;
  private boolean isHeader;
  private int origin;
  private String section;
  
  public IMAPBody() {}
  
  public IMAPBody(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    paramIMAPResponse.skipSpaces();
    if (paramIMAPResponse.readByte() != 91) {
      throw new MessageException(2, "BODY parse error: missing ``['' at section start" + paramIMAPResponse.getContent());
    }
    this.section = paramIMAPResponse.readString(']');
    if (paramIMAPResponse.readByte() != 93) {
      throw new MessageException(2, "BODY parse error: missing ``]'' at section end" + paramIMAPResponse.getContent());
    }
    this.isHeader = this.section.regionMatches(true, 0, "HEADER", 0, 6);
    if (paramIMAPResponse.readByte() == 60)
    {
      this.origin = paramIMAPResponse.readNumber();
      paramIMAPResponse.skip(1);
    }
    for (;;)
    {
      this.data = paramIMAPResponse.readByteArray();
      return;
      this.origin = 0;
    }
  }
  
  public ByteArray getData()
  {
    return this.data;
  }
  
  public int getOrigin()
  {
    return this.origin;
  }
  
  public String getSection()
  {
    return this.section;
  }
  
  public boolean isHeader()
  {
    return this.isHeader;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPBody
 * JD-Core Version:    0.7.0.1
 */