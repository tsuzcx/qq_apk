package com.tencent.moai.mailsdk.protocol.imap.model;

public class IMAPRFC822Size
  implements IMAPFetchItem
{
  static final char[] name = { 82, 70, 67, 56, 50, 50, 46, 83, 73, 90, 69 };
  private long size;
  
  public IMAPRFC822Size() {}
  
  public IMAPRFC822Size(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    this.size = paramIMAPResponse.readNumber();
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPRFC822Size
 * JD-Core Version:    0.7.0.1
 */