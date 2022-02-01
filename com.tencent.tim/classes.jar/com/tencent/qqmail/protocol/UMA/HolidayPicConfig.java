package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class HolidayPicConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberAction = 4;
  private static final int fieldNumberBegin_time = 1;
  private static final int fieldNumberDuration = 5;
  private static final int fieldNumberEnd_time = 2;
  private static final int fieldNumberPic_md5 = 7;
  private static final int fieldNumberPic_url = 3;
  private static final int fieldNumberRet_data = 6;
  public int action = -2147483648;
  public int begin_time = -2147483648;
  public int duration = -2147483648;
  public int end_time = -2147483648;
  public String pic_md5;
  public String pic_url;
  public String ret_data;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.begin_time != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.begin_time);
    }
    int i = j;
    if (this.end_time != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.end_time);
    }
    j = i;
    if (this.pic_url != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.pic_url);
    }
    i = j;
    if (this.action != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.action);
    }
    j = i;
    if (this.duration != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.duration);
    }
    i = j;
    if (this.ret_data != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.ret_data);
    }
    j = i;
    if (this.pic_md5 != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.pic_md5);
    }
    return j;
  }
  
  public final HolidayPicConfig parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, HolidayPicConfig paramHolidayPicConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramHolidayPicConfig.begin_time = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramHolidayPicConfig.end_time = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramHolidayPicConfig.pic_url = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramHolidayPicConfig.action = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramHolidayPicConfig.duration = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramHolidayPicConfig.ret_data = paramInputReader.readString(paramInt);
      return true;
    }
    paramHolidayPicConfig.pic_md5 = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.begin_time != -2147483648) {
      paramOutputWriter.writeInteger(1, this.begin_time);
    }
    if (this.end_time != -2147483648) {
      paramOutputWriter.writeInteger(2, this.end_time);
    }
    if (this.pic_url != null) {
      paramOutputWriter.writeString(3, this.pic_url);
    }
    if (this.action != -2147483648) {
      paramOutputWriter.writeInteger(4, this.action);
    }
    if (this.duration != -2147483648) {
      paramOutputWriter.writeInteger(5, this.duration);
    }
    if (this.ret_data != null) {
      paramOutputWriter.writeString(6, this.ret_data);
    }
    if (this.pic_md5 != null) {
      paramOutputWriter.writeString(7, this.pic_md5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.HolidayPicConfig
 * JD-Core Version:    0.7.0.1
 */