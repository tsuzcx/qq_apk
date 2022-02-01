package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class LoginInput
  extends BaseProtoBuf
{
  private static final int fieldNumberAlias = 3;
  private static final int fieldNumberDevicetoken = 10;
  private static final int fieldNumberParams = 9;
  private static final int fieldNumberPassword = 2;
  private static final int fieldNumberSpcache = 7;
  private static final int fieldNumberUin = 1;
  private static final int fieldNumberVerifycode = 8;
  private static final int fieldNumberVerifykey = 5;
  private static final int fieldNumberVerifyuin = 6;
  private static final int fieldNumberVerifyurl = 4;
  public String alias;
  public String devicetoken;
  public String params;
  public String password;
  public String spcache;
  public String uin;
  public String verifycode;
  public String verifykey;
  public String verifyuin;
  public String verifyurl;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.uin != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.uin);
    }
    int i = j;
    if (this.password != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.password);
    }
    j = i;
    if (this.alias != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.alias);
    }
    i = j;
    if (this.verifyurl != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.verifyurl);
    }
    j = i;
    if (this.verifykey != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.verifykey);
    }
    i = j;
    if (this.verifyuin != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.verifyuin);
    }
    j = i;
    if (this.spcache != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.spcache);
    }
    i = j;
    if (this.verifycode != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.verifycode);
    }
    j = i;
    if (this.params != null) {
      j = i + ComputeSizeUtil.computeStringSize(9, this.params);
    }
    i = j;
    if (this.devicetoken != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.devicetoken);
    }
    return i;
  }
  
  public final LoginInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.uin == null) || (this.password == null) || (this.alias == null) || (this.verifyurl == null) || (this.verifykey == null) || (this.verifyuin == null) || (this.spcache == null) || (this.verifycode == null) || (this.params == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, LoginInput paramLoginInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramLoginInput.uin = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramLoginInput.password = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramLoginInput.alias = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramLoginInput.verifyurl = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramLoginInput.verifykey = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramLoginInput.verifyuin = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramLoginInput.spcache = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramLoginInput.verifycode = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramLoginInput.params = paramInputReader.readString(paramInt);
      return true;
    }
    paramLoginInput.devicetoken = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.uin == null) || (this.password == null) || (this.alias == null) || (this.verifyurl == null) || (this.verifykey == null) || (this.verifyuin == null) || (this.spcache == null) || (this.verifycode == null) || (this.params == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.uin != null) {
      paramOutputWriter.writeString(1, this.uin);
    }
    if (this.password != null) {
      paramOutputWriter.writeString(2, this.password);
    }
    if (this.alias != null) {
      paramOutputWriter.writeString(3, this.alias);
    }
    if (this.verifyurl != null) {
      paramOutputWriter.writeString(4, this.verifyurl);
    }
    if (this.verifykey != null) {
      paramOutputWriter.writeString(5, this.verifykey);
    }
    if (this.verifyuin != null) {
      paramOutputWriter.writeString(6, this.verifyuin);
    }
    if (this.spcache != null) {
      paramOutputWriter.writeString(7, this.spcache);
    }
    if (this.verifycode != null) {
      paramOutputWriter.writeString(8, this.verifycode);
    }
    if (this.params != null) {
      paramOutputWriter.writeString(9, this.params);
    }
    if (this.devicetoken != null) {
      paramOutputWriter.writeString(10, this.devicetoken);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.LoginInput
 * JD-Core Version:    0.7.0.1
 */