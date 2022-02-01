package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemReNewUrlInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberExpiretime = 3;
  private static final int fieldNumberSha = 1;
  private static final int fieldNumberUrl = 2;
  public int expiretime;
  public String sha;
  public String url;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.sha != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.sha);
    }
    int j = i;
    if (this.url != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.url);
    }
    return j + ComputeSizeUtil.computeIntegerSize(3, this.expiretime);
  }
  
  public final ItemReNewUrlInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemReNewUrlInfo paramItemReNewUrlInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemReNewUrlInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemReNewUrlInfo.url = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemReNewUrlInfo.expiretime = paramInputReader.readInteger(paramInt);
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
    if (this.url != null) {
      paramOutputWriter.writeString(2, this.url);
    }
    paramOutputWriter.writeInteger(3, this.expiretime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemReNewUrlInfo
 * JD-Core Version:    0.7.0.1
 */