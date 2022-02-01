package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class GetCardListRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberAdd_list = 3;
  private static final int fieldNumberMaxid = 6;
  private static final int fieldNumberRemove_list = 4;
  private static final int fieldNumberSynkey = 2;
  private static final int fieldNumberType = 1;
  private static final int fieldNumberUpdate_list = 5;
  public LinkedList<CardData> add_list = new LinkedList();
  public long maxid = -9223372036854775808L;
  public LinkedList<CardData> remove_list = new LinkedList();
  public ByteString synkey;
  public int type = 0;
  public LinkedList<CardData> update_list = new LinkedList();
  
  public final int computeSize()
  {
    int i = 0;
    if (this.type != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    }
    int j = i;
    if (this.synkey != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.synkey);
    }
    j = j + ComputeSizeUtil.computeListSize(3, 8, this.add_list) + ComputeSizeUtil.computeListSize(4, 8, this.remove_list) + ComputeSizeUtil.computeListSize(5, 8, this.update_list);
    i = j;
    if (this.maxid != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(6, this.maxid);
    }
    return i;
  }
  
  public final GetCardListRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.add_list.clear();
    this.remove_list.clear();
    this.update_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, GetCardListRsp paramGetCardListRsp, int paramInt)
    throws IOException
  {
    int i;
    Object localObject;
    CardData localCardData;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramGetCardListRsp.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramGetCardListRsp.synkey = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localCardData = new CardData();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localCardData.populateBuilderWithField((InputReader)localObject, localCardData, getNextFieldNumber((InputReader)localObject))) {}
        paramGetCardListRsp.add_list.add(localCardData);
        paramInt += 1;
      }
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localCardData = new CardData();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localCardData.populateBuilderWithField((InputReader)localObject, localCardData, getNextFieldNumber((InputReader)localObject))) {}
        paramGetCardListRsp.remove_list.add(localCardData);
        paramInt += 1;
      }
      return true;
    case 5: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localCardData = new CardData();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localCardData.populateBuilderWithField((InputReader)localObject, localCardData, getNextFieldNumber((InputReader)localObject))) {}
        paramGetCardListRsp.update_list.add(localCardData);
        paramInt += 1;
      }
      return true;
    }
    paramGetCardListRsp.maxid = paramInputReader.readLong(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(1, this.type);
    }
    if (this.synkey != null) {
      paramOutputWriter.writeByteString(2, this.synkey);
    }
    paramOutputWriter.writeList(3, 8, this.add_list);
    paramOutputWriter.writeList(4, 8, this.remove_list);
    paramOutputWriter.writeList(5, 8, this.update_list);
    if (this.maxid != -9223372036854775808L) {
      paramOutputWriter.writeLong(6, this.maxid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.GetCardListRsp
 * JD-Core Version:    0.7.0.1
 */