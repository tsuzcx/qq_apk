package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PopularizeSubItem
  extends BaseProtoBuf
{
  private static final int fieldNumberAction = 8;
  private static final int fieldNumberBottom_ratio = 10;
  private static final int fieldNumberCondition = 7;
  private static final int fieldNumberImage_md5 = 3;
  private static final int fieldNumberImage_url = 2;
  private static final int fieldNumberOpen_url = 9;
  private static final int fieldNumberPosition = 4;
  private static final int fieldNumberSequence = 5;
  private static final int fieldNumberShow_type = 6;
  private static final int fieldNumberSvr_id = 11;
  private static final int fieldNumberText = 1;
  public int action = -2147483648;
  public int bottom_ratio = -2147483648;
  public int condition = -2147483648;
  public ByteString image_md5;
  public ByteString image_url;
  public ByteString open_url;
  public int position = -2147483648;
  public int sequence = -2147483648;
  public int show_type = -2147483648;
  public int svr_id = -2147483648;
  public ByteString text;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.text != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.text);
    }
    int i = j;
    if (this.image_url != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.image_url);
    }
    j = i;
    if (this.image_md5 != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.image_md5);
    }
    i = j;
    if (this.position != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.position);
    }
    j = i;
    if (this.sequence != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.sequence);
    }
    i = j;
    if (this.show_type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.show_type);
    }
    j = i;
    if (this.condition != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(7, this.condition);
    }
    i = j;
    if (this.action != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(8, this.action);
    }
    j = i;
    if (this.open_url != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(9, this.open_url);
    }
    i = j;
    if (this.bottom_ratio != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(10, this.bottom_ratio);
    }
    j = i;
    if (this.svr_id != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(11, this.svr_id);
    }
    return j;
  }
  
  public final PopularizeSubItem parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PopularizeSubItem paramPopularizeSubItem, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPopularizeSubItem.text = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramPopularizeSubItem.image_url = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramPopularizeSubItem.image_md5 = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramPopularizeSubItem.position = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramPopularizeSubItem.sequence = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramPopularizeSubItem.show_type = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramPopularizeSubItem.condition = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramPopularizeSubItem.action = paramInputReader.readInteger(paramInt);
      return true;
    case 9: 
      paramPopularizeSubItem.open_url = paramInputReader.readByteString(paramInt);
      return true;
    case 10: 
      paramPopularizeSubItem.bottom_ratio = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramPopularizeSubItem.svr_id = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.text != null) {
      paramOutputWriter.writeByteString(1, this.text);
    }
    if (this.image_url != null) {
      paramOutputWriter.writeByteString(2, this.image_url);
    }
    if (this.image_md5 != null) {
      paramOutputWriter.writeByteString(3, this.image_md5);
    }
    if (this.position != -2147483648) {
      paramOutputWriter.writeInteger(4, this.position);
    }
    if (this.sequence != -2147483648) {
      paramOutputWriter.writeInteger(5, this.sequence);
    }
    if (this.show_type != -2147483648) {
      paramOutputWriter.writeInteger(6, this.show_type);
    }
    if (this.condition != -2147483648) {
      paramOutputWriter.writeInteger(7, this.condition);
    }
    if (this.action != -2147483648) {
      paramOutputWriter.writeInteger(8, this.action);
    }
    if (this.open_url != null) {
      paramOutputWriter.writeByteString(9, this.open_url);
    }
    if (this.bottom_ratio != -2147483648) {
      paramOutputWriter.writeInteger(10, this.bottom_ratio);
    }
    if (this.svr_id != -2147483648) {
      paramOutputWriter.writeInteger(11, this.svr_id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PopularizeSubItem
 * JD-Core Version:    0.7.0.1
 */