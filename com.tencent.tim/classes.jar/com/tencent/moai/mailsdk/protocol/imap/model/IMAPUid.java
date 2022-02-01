package com.tencent.moai.mailsdk.protocol.imap.model;

public class IMAPUid
  implements IMAPFetchItem
{
  static final char[] name = { 85, 73, 68 };
  private String uid;
  
  public IMAPUid() {}
  
  public IMAPUid(IMAPResponse paramIMAPResponse)
  {
    paramIMAPResponse.skipSpaces();
    this.uid = String.valueOf(paramIMAPResponse.readLong());
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPUid
 * JD-Core Version:    0.7.0.1
 */