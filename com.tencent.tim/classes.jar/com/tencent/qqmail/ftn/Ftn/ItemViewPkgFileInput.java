package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewPkgFileInput
  extends BaseProtoBuf
{
  private static final int fieldNumberAction = 5;
  private static final int fieldNumberCode = 2;
  private static final int fieldNumberFid = 1;
  private static final int fieldNumberFullname = 4;
  private static final int fieldNumberPkgname = 3;
  public int action;
  public String code;
  public String fid;
  public String fullname;
  public String pkgname;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.fid != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.fid);
    }
    int i = j;
    if (this.code != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.code);
    }
    j = i;
    if (this.pkgname != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.pkgname);
    }
    i = j;
    if (this.fullname != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.fullname);
    }
    return i + ComputeSizeUtil.computeIntegerSize(5, this.action);
  }
  
  public final ItemViewPkgFileInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fid == null) || (this.code == null) || (this.pkgname == null) || (this.fullname == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewPkgFileInput paramItemViewPkgFileInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewPkgFileInput.fid = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramItemViewPkgFileInput.code = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramItemViewPkgFileInput.pkgname = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramItemViewPkgFileInput.fullname = paramInputReader.readString(paramInt);
      return true;
    }
    paramItemViewPkgFileInput.action = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.code == null) || (this.pkgname == null) || (this.fullname == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(1, this.fid);
    }
    if (this.code != null) {
      paramOutputWriter.writeString(2, this.code);
    }
    if (this.pkgname != null) {
      paramOutputWriter.writeString(3, this.pkgname);
    }
    if (this.fullname != null) {
      paramOutputWriter.writeString(4, this.fullname);
    }
    paramOutputWriter.writeInteger(5, this.action);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewPkgFileInput
 * JD-Core Version:    0.7.0.1
 */