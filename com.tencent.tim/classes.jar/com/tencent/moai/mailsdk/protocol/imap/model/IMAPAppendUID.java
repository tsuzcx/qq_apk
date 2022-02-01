package com.tencent.moai.mailsdk.protocol.imap.model;

import com.tencent.moai.mailsdk.exception.MessageException;

public class IMAPAppendUID
{
  private long uid = -1L;
  private long uidValidity = -1L;
  
  public IMAPAppendUID(long paramLong1, long paramLong2)
  {
    this.uidValidity = paramLong1;
    this.uid = paramLong2;
  }
  
  public IMAPAppendUID(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    int i;
    do
    {
      i = paramIMAPResponse.readByte();
    } while ((i > 0) && (i != 91));
    if (i == 0) {
      throw new MessageException(2, "appendUID no detail");
    }
    if (!paramIMAPResponse.readAtom().equalsIgnoreCase("APPENDUID")) {
      throw new MessageException(2, "not appendUID");
    }
    this.uidValidity = paramIMAPResponse.readLong();
    this.uid = paramIMAPResponse.readLong();
  }
  
  public long getUid()
  {
    return this.uid;
  }
  
  public long getUidValidity()
  {
    return this.uidValidity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.model.IMAPAppendUID
 * JD-Core Version:    0.7.0.1
 */