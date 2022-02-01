package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class Actions
  extends BaseProtoBuf
{
  private static final int fieldNumberDes_folder_id_ = 10;
  private static final int fieldNumberDes_folder_type_ = 11;
  private static final int fieldNumberMark_as_read_ = 12;
  private static final int fieldNumberSoft_delete_mail_ = 13;
  private static final int fieldNumberStop_subsequent_rules = 14;
  public String des_folder_id_;
  public int des_folder_type_ = -2147483648;
  public boolean mark_as_read_;
  public boolean soft_delete_mail_;
  public boolean stop_subsequent_rules;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.des_folder_id_ != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(10, this.des_folder_id_);
    }
    int j = i;
    if (this.des_folder_type_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(11, this.des_folder_type_);
    }
    return j + ComputeSizeUtil.computeBooleanSize(12, this.mark_as_read_) + ComputeSizeUtil.computeBooleanSize(13, this.soft_delete_mail_) + ComputeSizeUtil.computeBooleanSize(14, this.stop_subsequent_rules);
  }
  
  public final Actions parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, Actions paramActions, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 10: 
      paramActions.des_folder_id_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramActions.des_folder_type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 12: 
      paramActions.mark_as_read_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 13: 
      paramActions.soft_delete_mail_ = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramActions.stop_subsequent_rules = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.des_folder_id_ != null) {
      paramOutputWriter.writeString(10, this.des_folder_id_);
    }
    if (this.des_folder_type_ != -2147483648) {
      paramOutputWriter.writeInteger(11, this.des_folder_type_);
    }
    paramOutputWriter.writeBoolean(12, this.mark_as_read_);
    paramOutputWriter.writeBoolean(13, this.soft_delete_mail_);
    paramOutputWriter.writeBoolean(14, this.stop_subsequent_rules);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.Actions
 * JD-Core Version:    0.7.0.1
 */