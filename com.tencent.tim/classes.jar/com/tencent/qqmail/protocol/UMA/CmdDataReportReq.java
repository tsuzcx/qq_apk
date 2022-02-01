package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdDataReportReq
  extends BaseProtoBuf
{
  private static final int fieldNumberPhone_type = 3;
  private static final int fieldNumberReport = 1;
  private static final int fieldNumberReport_data = 4;
  private static final int fieldNumberSys_version = 2;
  private static final int fieldNumberUse_gzip = 5;
  public String phone_type;
  public LinkedList<DataReport> report = new LinkedList();
  public ByteString report_data;
  public String sys_version;
  public boolean use_gzip;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 8, this.report);
    int i = j;
    if (this.sys_version != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sys_version);
    }
    j = i;
    if (this.phone_type != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.phone_type);
    }
    i = j;
    if (this.report_data != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.report_data);
    }
    return i + ComputeSizeUtil.computeBooleanSize(5, this.use_gzip);
  }
  
  public final CmdDataReportReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.report.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdDataReportReq paramCmdDataReportReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        DataReport localDataReport = new DataReport();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localDataReport.populateBuilderWithField((InputReader)localObject, localDataReport, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdDataReportReq.report.add(localDataReport);
        paramInt += 1;
      }
      return true;
    case 2: 
      paramCmdDataReportReq.sys_version = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCmdDataReportReq.phone_type = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCmdDataReportReq.report_data = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCmdDataReportReq.use_gzip = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.report);
    if (this.sys_version != null) {
      paramOutputWriter.writeString(2, this.sys_version);
    }
    if (this.phone_type != null) {
      paramOutputWriter.writeString(3, this.phone_type);
    }
    if (this.report_data != null) {
      paramOutputWriter.writeByteString(4, this.report_data);
    }
    paramOutputWriter.writeBoolean(5, this.use_gzip);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdDataReportReq
 * JD-Core Version:    0.7.0.1
 */