package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewVideoUrlInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberExpiretime = 5;
  private static final int fieldNumberSha = 1;
  private static final int fieldNumberSize = 2;
  private static final int fieldNumberTime = 4;
  private static final int fieldNumberUrl = 3;
  public int expiretime;
  public String sha;
  public long size;
  public int time;
  public String url;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sha != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.sha);
    }
    int j = i + ComputeSizeUtil.computeLongSize(2, this.size);
    i = j;
    if (this.url != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.url);
    }
    return i + ComputeSizeUtil.computeIntegerSize(4, this.time) + ComputeSizeUtil.computeIntegerSize(5, this.expiretime);
  }
  
  public final ItemViewVideoUrlInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.sha == null) || (this.url == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewVideoUrlInfo paramItemViewVideoUrlInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewVideoUrlInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemViewVideoUrlInfo.size = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramItemViewVideoUrlInfo.url = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramItemViewVideoUrlInfo.time = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramItemViewVideoUrlInfo.expiretime = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.sha == null) || (this.url == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(1, this.sha);
    }
    paramOutputWriter.writeLong(2, this.size);
    if (this.url != null) {
      paramOutputWriter.writeString(3, this.url);
    }
    paramOutputWriter.writeInteger(4, this.time);
    paramOutputWriter.writeInteger(5, this.expiretime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewVideoUrlInfo
 * JD-Core Version:    0.7.0.1
 */