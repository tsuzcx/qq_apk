package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class UpdateInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberDescription = 3;
  private static final int fieldNumberPop_tips = 7;
  private static final int fieldNumberTitle = 5;
  private static final int fieldNumberType = 4;
  private static final int fieldNumberUrl = 2;
  private static final int fieldNumberUrl_title = 6;
  private static final int fieldNumberVersion = 1;
  public String description;
  public boolean pop_tips;
  public String title;
  public int type;
  public String url;
  public String url_title;
  public ByteString version;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.version != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.version);
    }
    int i = j;
    if (this.url != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.url);
    }
    j = i;
    if (this.description != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.description);
    }
    j += ComputeSizeUtil.computeIntegerSize(4, this.type);
    i = j;
    if (this.title != null) {
      i = j + ComputeSizeUtil.computeStringSize(5, this.title);
    }
    j = i;
    if (this.url_title != null) {
      j = i + ComputeSizeUtil.computeStringSize(6, this.url_title);
    }
    return j + ComputeSizeUtil.computeBooleanSize(7, this.pop_tips);
  }
  
  public final UpdateInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, UpdateInfo paramUpdateInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramUpdateInfo.version = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramUpdateInfo.url = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramUpdateInfo.description = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramUpdateInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramUpdateInfo.title = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramUpdateInfo.url_title = paramInputReader.readString(paramInt);
      return true;
    }
    paramUpdateInfo.pop_tips = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.version != null) {
      paramOutputWriter.writeByteString(1, this.version);
    }
    if (this.url != null) {
      paramOutputWriter.writeString(2, this.url);
    }
    if (this.description != null) {
      paramOutputWriter.writeString(3, this.description);
    }
    paramOutputWriter.writeInteger(4, this.type);
    if (this.title != null) {
      paramOutputWriter.writeString(5, this.title);
    }
    if (this.url_title != null) {
      paramOutputWriter.writeString(6, this.url_title);
    }
    paramOutputWriter.writeBoolean(7, this.pop_tips);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.UpdateInfo
 * JD-Core Version:    0.7.0.1
 */