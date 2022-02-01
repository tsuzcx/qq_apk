package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SaveCardReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCardid = 1;
  private static final int fieldNumberCardpara = 2;
  private static final int fieldNumberEmail = 4;
  private static final int fieldNumberType = 6;
  private static final int fieldNumberUin = 5;
  public ByteString cardid;
  public LinkedList<CardPara> cardpara = new LinkedList();
  public ByteString email;
  public int type;
  public long uin = -9223372036854775808L;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.cardid != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.cardid);
    }
    int j = i + ComputeSizeUtil.computeListSize(2, 8, this.cardpara);
    i = j;
    if (this.email != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.email);
    }
    j = i;
    if (this.uin != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(5, this.uin);
    }
    return j + ComputeSizeUtil.computeIntegerSize(6, this.type);
  }
  
  public final SaveCardReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.cardpara.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SaveCardReq paramSaveCardReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    case 3: 
    default: 
      return false;
    case 1: 
      paramSaveCardReq.cardid = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        CardPara localCardPara = new CardPara();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localCardPara.populateBuilderWithField((InputReader)localObject, localCardPara, getNextFieldNumber((InputReader)localObject))) {}
        paramSaveCardReq.cardpara.add(localCardPara);
        paramInt += 1;
      }
      return true;
    case 4: 
      paramSaveCardReq.email = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramSaveCardReq.uin = paramInputReader.readLong(paramInt);
      return true;
    }
    paramSaveCardReq.type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.cardid != null) {
      paramOutputWriter.writeByteString(1, this.cardid);
    }
    paramOutputWriter.writeList(2, 8, this.cardpara);
    if (this.email != null) {
      paramOutputWriter.writeByteString(4, this.email);
    }
    if (this.uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(5, this.uin);
    }
    paramOutputWriter.writeInteger(6, this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SaveCardReq
 * JD-Core Version:    0.7.0.1
 */