package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdLstContactWithTypeRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberContact = 1;
  public LinkedList<ContactWithType> contact = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.contact);
  }
  
  public final CmdLstContactWithTypeRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.contact.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdLstContactWithTypeRsp paramCmdLstContactWithTypeRsp, int paramInt)
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
      ContactWithType localContactWithType = new ContactWithType();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localContactWithType.populateBuilderWithField((InputReader)localObject, localContactWithType, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdLstContactWithTypeRsp.contact.add(localContactWithType);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.contact);
  }
  
  public static final class ContactWithType
    extends BaseProtoBuf
  {
    private static final int fieldNumberEmail = 1;
    private static final int fieldNumberType = 2;
    public String email;
    public LinkedList<Integer> type = new LinkedList();
    
    public final int computeSize()
    {
      int i = 0;
      if (this.email != null) {
        i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
      }
      return i + ComputeSizeUtil.computeListSize(2, 2, this.type);
    }
    
    public final ContactWithType parseFrom(byte[] paramArrayOfByte)
      throws IOException
    {
      this.type.clear();
      paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
      for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
        if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
          paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
        }
      }
      return this;
    }
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, ContactWithType paramContactWithType, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramContactWithType.email = paramInputReader.readString(paramInt);
        return true;
      }
      paramContactWithType.type.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (this.email != null) {
        paramOutputWriter.writeString(1, this.email);
      }
      paramOutputWriter.writeList(2, 2, this.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdLstContactWithTypeRsp
 * JD-Core Version:    0.7.0.1
 */