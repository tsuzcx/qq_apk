package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class LoginOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberCode = 5;
  private static final int fieldNumberSid = 1;
  private static final int fieldNumberVerifykey = 3;
  private static final int fieldNumberVerifyuin = 4;
  private static final int fieldNumberVerifyurl = 2;
  public int code;
  public String sid;
  public String verifykey;
  public String verifyuin;
  public String verifyurl;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.sid != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.sid);
    }
    int i = j;
    if (this.verifyurl != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.verifyurl);
    }
    j = i;
    if (this.verifykey != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.verifykey);
    }
    i = j;
    if (this.verifyuin != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.verifyuin);
    }
    return i + ComputeSizeUtil.computeIntegerSize(5, this.code);
  }
  
  public final LoginOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.sid == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, LoginOutput paramLoginOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramLoginOutput.sid = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramLoginOutput.verifyurl = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramLoginOutput.verifykey = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramLoginOutput.verifyuin = paramInputReader.readString(paramInt);
      return true;
    }
    paramLoginOutput.code = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.sid == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.sid != null) {
      paramOutputWriter.writeString(1, this.sid);
    }
    if (this.verifyurl != null) {
      paramOutputWriter.writeString(2, this.verifyurl);
    }
    if (this.verifykey != null) {
      paramOutputWriter.writeString(3, this.verifykey);
    }
    if (this.verifyuin != null) {
      paramOutputWriter.writeString(4, this.verifyuin);
    }
    paramOutputWriter.writeInteger(5, this.code);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.LoginOutput
 * JD-Core Version:    0.7.0.1
 */