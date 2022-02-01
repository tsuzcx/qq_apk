package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CodeInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberCode_content = 2;
  private static final int fieldNumberCode_name = 1;
  private static final int fieldNumberReplace_rule = 3;
  public ByteString code_content;
  public ByteString code_name;
  public ByteString replace_rule;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.code_name != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.code_name);
    }
    int i = j;
    if (this.code_content != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.code_content);
    }
    j = i;
    if (this.replace_rule != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.replace_rule);
    }
    return j;
  }
  
  public final CodeInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CodeInfo paramCodeInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCodeInfo.code_name = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCodeInfo.code_content = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCodeInfo.replace_rule = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.code_name != null) {
      paramOutputWriter.writeByteString(1, this.code_name);
    }
    if (this.code_content != null) {
      paramOutputWriter.writeByteString(2, this.code_content);
    }
    if (this.replace_rule != null) {
      paramOutputWriter.writeByteString(3, this.replace_rule);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CodeInfo
 * JD-Core Version:    0.7.0.1
 */