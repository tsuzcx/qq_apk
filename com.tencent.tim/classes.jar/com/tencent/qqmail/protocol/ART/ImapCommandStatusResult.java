package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ImapCommandStatusResult
  extends BaseProtoBuf
{
  private static final int fieldNumberFolder_ = 1;
  private static final int fieldNumberMessages_ = 2;
  private static final int fieldNumberUidvalidity_ = 4;
  private static final int fieldNumberUnseen_ = 3;
  public String folder_;
  public int messages_ = -2147483648;
  public int uidvalidity_ = -2147483648;
  public int unseen_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.folder_ != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.folder_);
    }
    int i = j;
    if (this.messages_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.messages_);
    }
    j = i;
    if (this.unseen_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.unseen_);
    }
    i = j;
    if (this.uidvalidity_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.uidvalidity_);
    }
    return i;
  }
  
  public final ImapCommandStatusResult parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ImapCommandStatusResult paramImapCommandStatusResult, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramImapCommandStatusResult.folder_ = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramImapCommandStatusResult.messages_ = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramImapCommandStatusResult.unseen_ = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramImapCommandStatusResult.uidvalidity_ = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.folder_ != null) {
      paramOutputWriter.writeString(1, this.folder_);
    }
    if (this.messages_ != -2147483648) {
      paramOutputWriter.writeInteger(2, this.messages_);
    }
    if (this.unseen_ != -2147483648) {
      paramOutputWriter.writeInteger(3, this.unseen_);
    }
    if (this.uidvalidity_ != -2147483648) {
      paramOutputWriter.writeInteger(4, this.uidvalidity_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ImapCommandStatusResult
 * JD-Core Version:    0.7.0.1
 */