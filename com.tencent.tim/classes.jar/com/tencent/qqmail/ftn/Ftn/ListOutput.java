package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ListOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberAllcount = 1;
  private static final int fieldNumberItemlist = 2;
  private static final int fieldNumberLastupdatetime = 3;
  private static final int fieldNumberPwdencryptstr = 5;
  private static final int fieldNumberUpdatemsg = 4;
  public int allcount;
  public LinkedList<FileInfo> itemlist = new LinkedList();
  public int lastupdatetime;
  public String pwdencryptstr;
  public UpdateMsgOutput updatemsg;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.allcount) + ComputeSizeUtil.computeListSize(2, 8, this.itemlist) + ComputeSizeUtil.computeIntegerSize(3, this.lastupdatetime);
    int i = j;
    if (this.updatemsg != null) {
      i = j + ComputeSizeUtil.computeMessageSize(4, this.updatemsg.computeSize());
    }
    j = i;
    if (this.pwdencryptstr != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.pwdencryptstr);
    }
    return j;
  }
  
  public final ListOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.itemlist.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.updatemsg == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ListOutput paramListOutput, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramListOutput.allcount = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new FileInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FileInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (FileInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramListOutput.itemlist.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 3: 
      paramListOutput.lastupdatetime = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new UpdateMsgOutput();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((UpdateMsgOutput)localObject1).populateBuilderWithField((InputReader)localObject2, (UpdateMsgOutput)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramListOutput.updatemsg = ((UpdateMsgOutput)localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramListOutput.pwdencryptstr = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.updatemsg == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.allcount);
    paramOutputWriter.writeList(2, 8, this.itemlist);
    paramOutputWriter.writeInteger(3, this.lastupdatetime);
    if (this.updatemsg != null)
    {
      paramOutputWriter.writeMessage(4, this.updatemsg.computeSize());
      this.updatemsg.writeFields(paramOutputWriter);
    }
    if (this.pwdencryptstr != null) {
      paramOutputWriter.writeString(5, this.pwdencryptstr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ListOutput
 * JD-Core Version:    0.7.0.1
 */