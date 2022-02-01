package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class FriendInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberBirthday = 4;
  private static final int fieldNumberEmail = 8;
  private static final int fieldNumberIschinese = 7;
  private static final int fieldNumberNickname = 3;
  private static final int fieldNumberPhotourl = 6;
  private static final int fieldNumberSubid = 1;
  private static final int fieldNumberTodayto = 5;
  private static final int fieldNumberUin = 2;
  public ByteString birthday;
  public ByteString email;
  public boolean ischinese;
  public ByteString nickname;
  public ByteString photourl;
  public ByteString subid;
  public long todayto = -9223372036854775808L;
  public long uin = -9223372036854775808L;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.subid != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.subid);
    }
    int i = j;
    if (this.uin != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.uin);
    }
    j = i;
    if (this.nickname != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.nickname);
    }
    i = j;
    if (this.birthday != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.birthday);
    }
    j = i;
    if (this.todayto != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(5, this.todayto);
    }
    i = j;
    if (this.photourl != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.photourl);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(7, this.ischinese);
    i = j;
    if (this.email != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(8, this.email);
    }
    return i;
  }
  
  public final FriendInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, FriendInfo paramFriendInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramFriendInfo.subid = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramFriendInfo.uin = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramFriendInfo.nickname = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramFriendInfo.birthday = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramFriendInfo.todayto = paramInputReader.readLong(paramInt);
      return true;
    case 6: 
      paramFriendInfo.photourl = paramInputReader.readByteString(paramInt);
      return true;
    case 7: 
      paramFriendInfo.ischinese = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramFriendInfo.email = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.subid != null) {
      paramOutputWriter.writeByteString(1, this.subid);
    }
    if (this.uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.uin);
    }
    if (this.nickname != null) {
      paramOutputWriter.writeByteString(3, this.nickname);
    }
    if (this.birthday != null) {
      paramOutputWriter.writeByteString(4, this.birthday);
    }
    if (this.todayto != -9223372036854775808L) {
      paramOutputWriter.writeLong(5, this.todayto);
    }
    if (this.photourl != null) {
      paramOutputWriter.writeByteString(6, this.photourl);
    }
    paramOutputWriter.writeBoolean(7, this.ischinese);
    if (this.email != null) {
      paramOutputWriter.writeByteString(8, this.email);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.FriendInfo
 * JD-Core Version:    0.7.0.1
 */