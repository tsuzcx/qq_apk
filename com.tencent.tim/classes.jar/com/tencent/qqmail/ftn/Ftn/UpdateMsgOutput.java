package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class UpdateMsgOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberLink = 4;
  private static final int fieldNumberMsg = 3;
  private static final int fieldNumberRet = 1;
  private static final int fieldNumberTitle = 2;
  public String link;
  public String msg;
  public int ret;
  public String title;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.ret);
    int i = j;
    if (this.title != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.title);
    }
    j = i;
    if (this.msg != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.msg);
    }
    i = j;
    if (this.link != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.link);
    }
    return i;
  }
  
  public final UpdateMsgOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.title == null) || (this.msg == null) || (this.link == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, UpdateMsgOutput paramUpdateMsgOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramUpdateMsgOutput.ret = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramUpdateMsgOutput.title = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramUpdateMsgOutput.msg = paramInputReader.readString(paramInt);
      return true;
    }
    paramUpdateMsgOutput.link = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.title == null) || (this.msg == null) || (this.link == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.ret);
    if (this.title != null) {
      paramOutputWriter.writeString(2, this.title);
    }
    if (this.msg != null) {
      paramOutputWriter.writeString(3, this.msg);
    }
    if (this.link != null) {
      paramOutputWriter.writeString(4, this.link);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.UpdateMsgOutput
 * JD-Core Version:    0.7.0.1
 */