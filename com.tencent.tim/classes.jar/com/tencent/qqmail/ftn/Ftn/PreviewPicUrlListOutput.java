package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class PreviewPicUrlListOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberCookiename = 1;
  private static final int fieldNumberCookievalue = 2;
  private static final int fieldNumberUrl = 3;
  public String cookiename;
  public String cookievalue;
  public LinkedList<String> url = new LinkedList();
  
  public final int computeSize()
  {
    int i = 0;
    if (this.cookiename != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.cookiename);
    }
    int j = i;
    if (this.cookievalue != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.cookievalue);
    }
    return j + ComputeSizeUtil.computeListSize(3, 1, this.url);
  }
  
  public final PreviewPicUrlListOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.url.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PreviewPicUrlListOutput paramPreviewPicUrlListOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPreviewPicUrlListOutput.cookiename = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramPreviewPicUrlListOutput.cookievalue = paramInputReader.readString(paramInt);
      return true;
    }
    paramPreviewPicUrlListOutput.url.add(paramInputReader.readString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.cookiename != null) {
      paramOutputWriter.writeString(1, this.cookiename);
    }
    if (this.cookievalue != null) {
      paramOutputWriter.writeString(2, this.cookievalue);
    }
    paramOutputWriter.writeList(3, 1, this.url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.PreviewPicUrlListOutput
 * JD-Core Version:    0.7.0.1
 */