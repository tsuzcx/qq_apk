package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class TranslationReq
  extends BaseProtoBuf
{
  private static final int fieldNumberFrom = 3;
  private static final int fieldNumberMailcontent = 1;
  private static final int fieldNumberSubject = 2;
  private static final int fieldNumberTo = 4;
  public ByteString from;
  public ByteString mailcontent;
  public ByteString subject;
  public ByteString to;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.mailcontent != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.mailcontent);
    }
    int i = j;
    if (this.subject != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.subject);
    }
    j = i;
    if (this.from != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.from);
    }
    i = j;
    if (this.to != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.to);
    }
    return i;
  }
  
  public final TranslationReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, TranslationReq paramTranslationReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramTranslationReq.mailcontent = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramTranslationReq.subject = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramTranslationReq.from = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramTranslationReq.to = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.mailcontent != null) {
      paramOutputWriter.writeByteString(1, this.mailcontent);
    }
    if (this.subject != null) {
      paramOutputWriter.writeByteString(2, this.subject);
    }
    if (this.from != null) {
      paramOutputWriter.writeByteString(3, this.from);
    }
    if (this.to != null) {
      paramOutputWriter.writeByteString(4, this.to);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.TranslationReq
 * JD-Core Version:    0.7.0.1
 */