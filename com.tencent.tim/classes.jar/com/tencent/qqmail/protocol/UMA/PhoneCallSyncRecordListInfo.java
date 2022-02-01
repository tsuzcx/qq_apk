package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhoneCallSyncRecordListInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_address = 1;
  private static final int fieldNumberRecord_infos = 2;
  private static final int fieldNumberSync_key = 3;
  public String account_address;
  public LinkedList<RecordInfo> record_infos = new LinkedList();
  public String sync_key;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_address != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.account_address);
    }
    int j = i + ComputeSizeUtil.computeListSize(2, 8, this.record_infos);
    i = j;
    if (this.sync_key != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.sync_key);
    }
    return i;
  }
  
  public final PhoneCallSyncRecordListInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.record_infos.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhoneCallSyncRecordListInfo paramPhoneCallSyncRecordListInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhoneCallSyncRecordListInfo.account_address = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        RecordInfo localRecordInfo = new RecordInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localRecordInfo.populateBuilderWithField((InputReader)localObject, localRecordInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramPhoneCallSyncRecordListInfo.record_infos.add(localRecordInfo);
        paramInt += 1;
      }
      return true;
    }
    paramPhoneCallSyncRecordListInfo.sync_key = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_address != null) {
      paramOutputWriter.writeString(1, this.account_address);
    }
    paramOutputWriter.writeList(2, 8, this.record_infos);
    if (this.sync_key != null) {
      paramOutputWriter.writeString(3, this.sync_key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhoneCallSyncRecordListInfo
 * JD-Core Version:    0.7.0.1
 */