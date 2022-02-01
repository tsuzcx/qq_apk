package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class RarExchangeInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFid = 1;
  private static final int fieldNumberHost = 2;
  private static final int fieldNumberPkgname = 4;
  private static final int fieldNumberVkey = 3;
  public String fid;
  public String host;
  public String pkgname;
  public String vkey;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.fid != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.fid);
    }
    int i = j;
    if (this.host != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.host);
    }
    j = i;
    if (this.vkey != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.vkey);
    }
    i = j;
    if (this.pkgname != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.pkgname);
    }
    return i;
  }
  
  public final RarExchangeInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fid == null) || (this.host == null) || (this.vkey == null) || (this.pkgname == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, RarExchangeInput paramRarExchangeInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramRarExchangeInput.fid = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramRarExchangeInput.host = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramRarExchangeInput.vkey = paramInputReader.readString(paramInt);
      return true;
    }
    paramRarExchangeInput.pkgname = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.host == null) || (this.vkey == null) || (this.pkgname == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(1, this.fid);
    }
    if (this.host != null) {
      paramOutputWriter.writeString(2, this.host);
    }
    if (this.vkey != null) {
      paramOutputWriter.writeString(3, this.vkey);
    }
    if (this.pkgname != null) {
      paramOutputWriter.writeString(4, this.pkgname);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.RarExchangeInput
 * JD-Core Version:    0.7.0.1
 */