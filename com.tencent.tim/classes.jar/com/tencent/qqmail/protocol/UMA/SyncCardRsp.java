package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncCardRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberCardlist = 2;
  private static final int fieldNumberCardtypes = 1;
  public LinkedList<GetCardListRsp> cardlist = new LinkedList();
  public LinkedList<CardType> cardtypes = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.cardtypes) + ComputeSizeUtil.computeListSize(2, 8, this.cardlist);
  }
  
  public final SyncCardRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.cardtypes.clear();
    this.cardlist.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncCardRsp paramSyncCardRsp, int paramInt)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CardType();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CardType)localObject1).populateBuilderWithField((InputReader)localObject2, (CardType)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramSyncCardRsp.cardtypes.add(localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new GetCardListRsp();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((GetCardListRsp)localObject1).populateBuilderWithField((InputReader)localObject2, (GetCardListRsp)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramSyncCardRsp.cardlist.add(localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.cardtypes);
    paramOutputWriter.writeList(2, 8, this.cardlist);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncCardRsp
 * JD-Core Version:    0.7.0.1
 */