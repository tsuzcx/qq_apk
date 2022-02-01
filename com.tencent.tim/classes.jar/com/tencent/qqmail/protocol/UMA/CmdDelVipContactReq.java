package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdDelVipContactReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDelete_all = 2;
  private static final int fieldNumberEmail = 1;
  public boolean delete_all;
  public LinkedList<String> email = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.email) + ComputeSizeUtil.computeBooleanSize(2, this.delete_all);
  }
  
  public final CmdDelVipContactReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.email.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdDelVipContactReq paramCmdDelVipContactReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdDelVipContactReq.email.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramCmdDelVipContactReq.delete_all = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.email);
    paramOutputWriter.writeBoolean(2, this.delete_all);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdDelVipContactReq
 * JD-Core Version:    0.7.0.1
 */