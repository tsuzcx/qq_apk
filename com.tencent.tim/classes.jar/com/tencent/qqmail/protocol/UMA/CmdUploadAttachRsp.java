package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdUploadAttachRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberDemand_digest_len = 5;
  private static final int fieldNumberDemand_digest_pos = 4;
  private static final int fieldNumberDemand_digest_type = 6;
  private static final int fieldNumberDemand_len = 3;
  private static final int fieldNumberDemand_pos = 2;
  private static final int fieldNumberLink = 1;
  public LinkedList<Integer> demand_digest_len = new LinkedList();
  public LinkedList<Integer> demand_digest_pos = new LinkedList();
  public LinkedList<Integer> demand_digest_type = new LinkedList();
  public int demand_len = -2147483648;
  public int demand_pos = -2147483648;
  public String link;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.link != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.link);
    }
    int i = j;
    if (this.demand_pos != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.demand_pos);
    }
    j = i;
    if (this.demand_len != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.demand_len);
    }
    return j + ComputeSizeUtil.computeListSize(4, 2, this.demand_digest_pos) + ComputeSizeUtil.computeListSize(5, 2, this.demand_digest_len) + ComputeSizeUtil.computeListSize(6, 2, this.demand_digest_type);
  }
  
  public final CmdUploadAttachRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.demand_digest_pos.clear();
    this.demand_digest_len.clear();
    this.demand_digest_type.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdUploadAttachRsp paramCmdUploadAttachRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdUploadAttachRsp.link = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCmdUploadAttachRsp.demand_pos = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramCmdUploadAttachRsp.demand_len = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramCmdUploadAttachRsp.demand_digest_pos.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    case 5: 
      paramCmdUploadAttachRsp.demand_digest_len.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    }
    paramCmdUploadAttachRsp.demand_digest_type.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.link != null) {
      paramOutputWriter.writeString(1, this.link);
    }
    if (this.demand_pos != -2147483648) {
      paramOutputWriter.writeInteger(2, this.demand_pos);
    }
    if (this.demand_len != -2147483648) {
      paramOutputWriter.writeInteger(3, this.demand_len);
    }
    paramOutputWriter.writeList(4, 2, this.demand_digest_pos);
    paramOutputWriter.writeList(5, 2, this.demand_digest_len);
    paramOutputWriter.writeList(6, 2, this.demand_digest_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdUploadAttachRsp
 * JD-Core Version:    0.7.0.1
 */