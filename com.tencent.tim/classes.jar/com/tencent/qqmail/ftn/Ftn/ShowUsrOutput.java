package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ShowUsrOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberAlias = 6;
  private static final int fieldNumberExpiredays = 13;
  private static final int fieldNumberFavoritefreespace = 8;
  private static final int fieldNumberFavoritemaxspace = 7;
  private static final int fieldNumberFavoriteusedspace = 9;
  private static final int fieldNumberFsizelimit = 4;
  private static final int fieldNumberPreviewzipsizelimit = 14;
  private static final int fieldNumberRatinglink = 12;
  private static final int fieldNumberStorage = 2;
  private static final int fieldNumberStoreday = 5;
  private static final int fieldNumberUsage = 3;
  private static final int fieldNumberVideodurationlimitation = 11;
  private static final int fieldNumberVideosizelimitation = 10;
  private static final int fieldNumberVlevel = 1;
  public String alias;
  public int expiredays;
  public float favoritefreespace;
  public long favoritemaxspace;
  public float favoriteusedspace;
  public float fsizelimit;
  public int previewzipsizelimit;
  public String ratinglink;
  public float storage;
  public long storeday;
  public float usage;
  public int videodurationlimitation;
  public int videosizelimitation;
  public long vlevel;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeLongSize(1, this.vlevel) + ComputeSizeUtil.computeFloatSize(2, this.storage) + ComputeSizeUtil.computeFloatSize(3, this.usage) + ComputeSizeUtil.computeFloatSize(4, this.fsizelimit) + ComputeSizeUtil.computeLongSize(5, this.storeday);
    int i = j;
    if (this.alias != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.alias);
    }
    j = i + ComputeSizeUtil.computeLongSize(7, this.favoritemaxspace) + ComputeSizeUtil.computeFloatSize(8, this.favoritefreespace) + ComputeSizeUtil.computeFloatSize(9, this.favoriteusedspace) + ComputeSizeUtil.computeIntegerSize(10, this.videosizelimitation) + ComputeSizeUtil.computeIntegerSize(11, this.videodurationlimitation);
    i = j;
    if (this.ratinglink != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.ratinglink);
    }
    return i + ComputeSizeUtil.computeIntegerSize(13, this.expiredays) + ComputeSizeUtil.computeIntegerSize(14, this.previewzipsizelimit);
  }
  
  public final ShowUsrOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.alias == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ShowUsrOutput paramShowUsrOutput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramShowUsrOutput.vlevel = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramShowUsrOutput.storage = paramInputReader.readFloat(paramInt);
      return true;
    case 3: 
      paramShowUsrOutput.usage = paramInputReader.readFloat(paramInt);
      return true;
    case 4: 
      paramShowUsrOutput.fsizelimit = paramInputReader.readFloat(paramInt);
      return true;
    case 5: 
      paramShowUsrOutput.storeday = paramInputReader.readLong(paramInt);
      return true;
    case 6: 
      paramShowUsrOutput.alias = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramShowUsrOutput.favoritemaxspace = paramInputReader.readLong(paramInt);
      return true;
    case 8: 
      paramShowUsrOutput.favoritefreespace = paramInputReader.readFloat(paramInt);
      return true;
    case 9: 
      paramShowUsrOutput.favoriteusedspace = paramInputReader.readFloat(paramInt);
      return true;
    case 10: 
      paramShowUsrOutput.videosizelimitation = paramInputReader.readInteger(paramInt);
      return true;
    case 11: 
      paramShowUsrOutput.videodurationlimitation = paramInputReader.readInteger(paramInt);
      return true;
    case 12: 
      paramShowUsrOutput.ratinglink = paramInputReader.readString(paramInt);
      return true;
    case 13: 
      paramShowUsrOutput.expiredays = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramShowUsrOutput.previewzipsizelimit = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.alias == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeLong(1, this.vlevel);
    paramOutputWriter.writeFloat(2, this.storage);
    paramOutputWriter.writeFloat(3, this.usage);
    paramOutputWriter.writeFloat(4, this.fsizelimit);
    paramOutputWriter.writeLong(5, this.storeday);
    if (this.alias != null) {
      paramOutputWriter.writeString(6, this.alias);
    }
    paramOutputWriter.writeLong(7, this.favoritemaxspace);
    paramOutputWriter.writeFloat(8, this.favoritefreespace);
    paramOutputWriter.writeFloat(9, this.favoriteusedspace);
    paramOutputWriter.writeInteger(10, this.videosizelimitation);
    paramOutputWriter.writeInteger(11, this.videodurationlimitation);
    if (this.ratinglink != null) {
      paramOutputWriter.writeString(12, this.ratinglink);
    }
    paramOutputWriter.writeInteger(13, this.expiredays);
    paramOutputWriter.writeInteger(14, this.previewzipsizelimit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ShowUsrOutput
 * JD-Core Version:    0.7.0.1
 */