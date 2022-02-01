package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class FileInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAliasname = 6;
  private static final int fieldNumberCode = 12;
  private static final int fieldNumberCreatetime = 7;
  private static final int fieldNumberDownloadtimes = 11;
  private static final int fieldNumberExpiretime = 8;
  private static final int fieldNumberFavdir = 17;
  private static final int fieldNumberFid = 1;
  private static final int fieldNumberFilename = 5;
  private static final int fieldNumberFilesize = 9;
  private static final int fieldNumberFiletype = 14;
  private static final int fieldNumberIsdir = 16;
  private static final int fieldNumberIsfav = 15;
  private static final int fieldNumberKey = 4;
  private static final int fieldNumberMd5 = 3;
  private static final int fieldNumberSha = 2;
  private static final int fieldNumberUploadsize = 10;
  private static final int fieldNumberViewtype = 13;
  public String aliasname;
  public String code;
  public int createtime;
  public int downloadtimes;
  public int expiretime;
  public String favdir;
  public String fid;
  public String filename;
  public long filesize;
  public int filetype;
  public boolean isdir;
  public boolean isfav;
  public String key;
  public String md5;
  public String sha;
  public long uploadsize;
  public int viewtype;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.fid != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.fid);
    }
    int i = j;
    if (this.sha != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sha);
    }
    j = i;
    if (this.md5 != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.md5);
    }
    i = j;
    if (this.key != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.key);
    }
    j = i;
    if (this.filename != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.filename);
    }
    i = j;
    if (this.aliasname != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.aliasname);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(7, this.createtime) + ComputeSizeUtil.computeIntegerSize(8, this.expiretime) + ComputeSizeUtil.computeLongSize(9, this.filesize) + ComputeSizeUtil.computeLongSize(10, this.uploadsize) + ComputeSizeUtil.computeIntegerSize(11, this.downloadtimes);
    i = j;
    if (this.code != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.code);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(13, this.viewtype) + ComputeSizeUtil.computeIntegerSize(14, this.filetype) + ComputeSizeUtil.computeBooleanSize(15, this.isfav) + ComputeSizeUtil.computeBooleanSize(16, this.isdir);
    i = j;
    if (this.favdir != null) {
      i = j + ComputeSizeUtil.computeStringSize(17, this.favdir);
    }
    return i;
  }
  
  public final FileInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.fid == null) || (this.key == null) || (this.filename == null) || (this.code == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, FileInfo paramFileInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramFileInfo.fid = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramFileInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramFileInfo.md5 = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramFileInfo.key = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramFileInfo.filename = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramFileInfo.aliasname = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramFileInfo.createtime = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramFileInfo.expiretime = paramInputReader.readInteger(paramInt);
      return true;
    case 9: 
      paramFileInfo.filesize = paramInputReader.readLong(paramInt);
      return true;
    case 10: 
      paramFileInfo.uploadsize = paramInputReader.readLong(paramInt);
      return true;
    case 11: 
      paramFileInfo.downloadtimes = paramInputReader.readInteger(paramInt);
      return true;
    case 12: 
      paramFileInfo.code = paramInputReader.readString(paramInt);
      return true;
    case 13: 
      paramFileInfo.viewtype = paramInputReader.readInteger(paramInt);
      return true;
    case 14: 
      paramFileInfo.filetype = paramInputReader.readInteger(paramInt);
      return true;
    case 15: 
      paramFileInfo.isfav = paramInputReader.readBoolean(paramInt);
      return true;
    case 16: 
      paramFileInfo.isdir = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramFileInfo.favdir = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.fid == null) || (this.key == null) || (this.filename == null) || (this.code == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.fid != null) {
      paramOutputWriter.writeString(1, this.fid);
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(2, this.sha);
    }
    if (this.md5 != null) {
      paramOutputWriter.writeString(3, this.md5);
    }
    if (this.key != null) {
      paramOutputWriter.writeString(4, this.key);
    }
    if (this.filename != null) {
      paramOutputWriter.writeString(5, this.filename);
    }
    if (this.aliasname != null) {
      paramOutputWriter.writeString(6, this.aliasname);
    }
    paramOutputWriter.writeInteger(7, this.createtime);
    paramOutputWriter.writeInteger(8, this.expiretime);
    paramOutputWriter.writeLong(9, this.filesize);
    paramOutputWriter.writeLong(10, this.uploadsize);
    paramOutputWriter.writeInteger(11, this.downloadtimes);
    if (this.code != null) {
      paramOutputWriter.writeString(12, this.code);
    }
    paramOutputWriter.writeInteger(13, this.viewtype);
    paramOutputWriter.writeInteger(14, this.filetype);
    paramOutputWriter.writeBoolean(15, this.isfav);
    paramOutputWriter.writeBoolean(16, this.isdir);
    if (this.favdir != null) {
      paramOutputWriter.writeString(17, this.favdir);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.FileInfo
 * JD-Core Version:    0.7.0.1
 */