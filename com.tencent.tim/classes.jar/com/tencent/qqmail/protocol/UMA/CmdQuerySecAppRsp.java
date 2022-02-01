package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQuerySecAppRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberGuide_url = 2;
  private static final int fieldNumberMatched_info = 3;
  private static final int fieldNumberPrompt_type_flag = 1;
  public ByteString guide_url;
  public LinkedList<AndroidSecAppMatchingInfo> matched_info = new LinkedList();
  public int prompt_type_flag = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.prompt_type_flag != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.prompt_type_flag);
    }
    int j = i;
    if (this.guide_url != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.guide_url);
    }
    return j + ComputeSizeUtil.computeListSize(3, 8, this.matched_info);
  }
  
  public final CmdQuerySecAppRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.matched_info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQuerySecAppRsp paramCmdQuerySecAppRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdQuerySecAppRsp.prompt_type_flag = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCmdQuerySecAppRsp.guide_url = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      AndroidSecAppMatchingInfo localAndroidSecAppMatchingInfo = new AndroidSecAppMatchingInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localAndroidSecAppMatchingInfo.populateBuilderWithField((InputReader)localObject, localAndroidSecAppMatchingInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdQuerySecAppRsp.matched_info.add(localAndroidSecAppMatchingInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.prompt_type_flag != -2147483648) {
      paramOutputWriter.writeInteger(1, this.prompt_type_flag);
    }
    if (this.guide_url != null) {
      paramOutputWriter.writeByteString(2, this.guide_url);
    }
    paramOutputWriter.writeList(3, 8, this.matched_info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQuerySecAppRsp
 * JD-Core Version:    0.7.0.1
 */