package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhotoParseRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberCardinfo = 2;
  private static final int fieldNumberOcrresult = 1;
  public NameCard cardinfo;
  public ByteString ocrresult;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.ocrresult != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.ocrresult);
    }
    int j = i;
    if (this.cardinfo != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.cardinfo.computeSize());
    }
    return j;
  }
  
  public final PhotoParseRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhotoParseRsp paramPhotoParseRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhotoParseRsp.ocrresult = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      NameCard localNameCard = new NameCard();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localNameCard.populateBuilderWithField((InputReader)localObject, localNameCard, getNextFieldNumber((InputReader)localObject))) {}
      paramPhotoParseRsp.cardinfo = localNameCard;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.ocrresult != null) {
      paramOutputWriter.writeByteString(1, this.ocrresult);
    }
    if (this.cardinfo != null)
    {
      paramOutputWriter.writeMessage(2, this.cardinfo.computeSize());
      this.cardinfo.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhotoParseRsp
 * JD-Core Version:    0.7.0.1
 */