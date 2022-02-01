package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemRarDownloadInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberDownloadhost = 1;
  private static final int fieldNumberExpire = 2;
  private static final int fieldNumberVkey = 3;
  public String downloadhost;
  public int expire;
  public String vkey;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.downloadhost != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.downloadhost);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.expire);
    i = j;
    if (this.vkey != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.vkey);
    }
    return i;
  }
  
  public final ItemRarDownloadInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.downloadhost == null) || (this.vkey == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemRarDownloadInfo paramItemRarDownloadInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemRarDownloadInfo.downloadhost = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemRarDownloadInfo.expire = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramItemRarDownloadInfo.vkey = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.downloadhost == null) || (this.vkey == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.downloadhost != null) {
      paramOutputWriter.writeString(1, this.downloadhost);
    }
    paramOutputWriter.writeInteger(2, this.expire);
    if (this.vkey != null) {
      paramOutputWriter.writeString(3, this.vkey);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemRarDownloadInfo
 * JD-Core Version:    0.7.0.1
 */