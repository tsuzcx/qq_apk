package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class QueryphoneCallRecordReq
  extends BaseProtoBuf
{
  private static final int fieldNumberRecord_query_list = 1;
  public LinkedList<QueryphoneCallRecordReqDomain> record_query_list = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.record_query_list);
  }
  
  public final QueryphoneCallRecordReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.record_query_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, QueryphoneCallRecordReq paramQueryphoneCallRecordReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      QueryphoneCallRecordReqDomain localQueryphoneCallRecordReqDomain = new QueryphoneCallRecordReqDomain();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localQueryphoneCallRecordReqDomain.populateBuilderWithField((InputReader)localObject, localQueryphoneCallRecordReqDomain, getNextFieldNumber((InputReader)localObject))) {}
      paramQueryphoneCallRecordReq.record_query_list.add(localQueryphoneCallRecordReqDomain);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.record_query_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.QueryphoneCallRecordReq
 * JD-Core Version:    0.7.0.1
 */