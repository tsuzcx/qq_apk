package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class XFVideoPieceInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberCookiename = 5;
  private static final int fieldNumberCookievalue = 6;
  private static final int fieldNumberOrder = 1;
  private static final int fieldNumberSha = 2;
  private static final int fieldNumberSize = 3;
  private static final int fieldNumberTime = 7;
  private static final int fieldNumberUrl = 4;
  public String cookiename;
  public String cookievalue;
  public int order;
  public String sha;
  public int size;
  public int time;
  public String url;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.order);
    int i = j;
    if (this.sha != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sha);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(3, this.size);
    i = j;
    if (this.url != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.url);
    }
    j = i;
    if (this.cookiename != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.cookiename);
    }
    i = j;
    if (this.cookievalue != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.cookievalue);
    }
    return i + ComputeSizeUtil.computeIntegerSize(7, this.time);
  }
  
  public final XFVideoPieceInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.sha == null) || (this.url == null) || (this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, XFVideoPieceInfo paramXFVideoPieceInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramXFVideoPieceInfo.order = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramXFVideoPieceInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramXFVideoPieceInfo.size = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramXFVideoPieceInfo.url = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramXFVideoPieceInfo.cookiename = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramXFVideoPieceInfo.cookievalue = paramInputReader.readString(paramInt);
      return true;
    }
    paramXFVideoPieceInfo.time = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.sha == null) || (this.url == null) || (this.cookiename == null) || (this.cookievalue == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.order);
    if (this.sha != null) {
      paramOutputWriter.writeString(2, this.sha);
    }
    paramOutputWriter.writeInteger(3, this.size);
    if (this.url != null) {
      paramOutputWriter.writeString(4, this.url);
    }
    if (this.cookiename != null) {
      paramOutputWriter.writeString(5, this.cookiename);
    }
    if (this.cookievalue != null) {
      paramOutputWriter.writeString(6, this.cookievalue);
    }
    paramOutputWriter.writeInteger(7, this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.XFVideoPieceInfo
 * JD-Core Version:    0.7.0.1
 */