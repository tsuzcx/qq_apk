package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemGetDownloadUrlOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberCookiename = 2;
  private static final int fieldNumberCookievalue = 3;
  private static final int fieldNumberDownloadurl = 1;
  private static final int fieldNumberExpiretime = 4;
  public String cookiename;
  public String cookievalue;
  public String downloadurl;
  public int expiretime;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.downloadurl != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.downloadurl);
    }
    int i = j;
    if (this.cookiename != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.cookiename);
    }
    j = i;
    if (this.cookievalue != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.cookievalue);
    }
    return j + ComputeSizeUtil.computeIntegerSize(4, this.expiretime);
  }
  
  public final ItemGetDownloadUrlOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.downloadurl == null) || (this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemGetDownloadUrlOutput paramItemGetDownloadUrlOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemGetDownloadUrlOutput.downloadurl = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemGetDownloadUrlOutput.cookiename = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramItemGetDownloadUrlOutput.cookievalue = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemGetDownloadUrlOutput.expiretime = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.downloadurl == null) || (this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.downloadurl != null) {
      paramOutputWriter.writeString(1, this.downloadurl);
    }
    if (this.cookiename != null) {
      paramOutputWriter.writeString(2, this.cookiename);
    }
    if (this.cookievalue != null) {
      paramOutputWriter.writeString(3, this.cookievalue);
    }
    paramOutputWriter.writeInteger(4, this.expiretime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemGetDownloadUrlOutput
 * JD-Core Version:    0.7.0.1
 */