package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class TranslationResp
  extends BaseProtoBuf
{
  private static final int fieldNumberDst_mailcontent = 1;
  private static final int fieldNumberDst_subject = 2;
  public ByteString dst_mailcontent;
  public ByteString dst_subject;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.dst_mailcontent != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.dst_mailcontent);
    }
    int j = i;
    if (this.dst_subject != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.dst_subject);
    }
    return j;
  }
  
  public final TranslationResp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, TranslationResp paramTranslationResp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramTranslationResp.dst_mailcontent = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramTranslationResp.dst_subject = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.dst_mailcontent != null) {
      paramOutputWriter.writeByteString(1, this.dst_mailcontent);
    }
    if (this.dst_subject != null) {
      paramOutputWriter.writeByteString(2, this.dst_subject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.TranslationResp
 * JD-Core Version:    0.7.0.1
 */