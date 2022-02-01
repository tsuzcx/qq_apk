package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class Folder
  extends BaseProtoBuf
{
  private static final int fieldNumberAccountId = 3;
  private static final int fieldNumberFolderId = 1;
  private static final int fieldNumberFolderType = 13;
  private static final int fieldNumberIsTop = 10;
  private static final int fieldNumberIsVirtual = 11;
  private static final int fieldNumberName = 5;
  private static final int fieldNumberParentId = 12;
  private static final int fieldNumberParentname = 15;
  private static final int fieldNumberRemoteFolderType = 18;
  private static final int fieldNumberRemoteId = 4;
  private static final int fieldNumberSequence_idr = 14;
  private static final int fieldNumberShowname = 6;
  private static final int fieldNumberShowname_fromServer = 7;
  private static final int fieldNumberSvrKey = 17;
  private static final int fieldNumberSyncStatus = 16;
  private static final int fieldNumberTotalCnt = 8;
  private static final int fieldNumberUidvalidity = 2;
  private static final int fieldNumberUnreadCnt = 9;
  public int accountId = -2147483648;
  public int folderId = -2147483648;
  public int folderType = -2147483648;
  public boolean isTop;
  public boolean isVirtual;
  public String name;
  public int parentId = -2147483648;
  public String parentname;
  public int remoteFolderType = -2147483648;
  public String remoteId;
  public String sequence_idr;
  public String showname;
  public String showname_fromServer;
  public String svrKey;
  public String syncStatus;
  public int totalCnt = -2147483648;
  public int uidvalidity = -2147483648;
  public int unreadCnt = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.folderId != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.folderId);
    }
    int i = j;
    if (this.uidvalidity != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.uidvalidity);
    }
    j = i;
    if (this.accountId != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.accountId);
    }
    i = j;
    if (this.remoteId != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.remoteId);
    }
    j = i;
    if (this.name != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.name);
    }
    i = j;
    if (this.showname != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.showname);
    }
    j = i;
    if (this.showname_fromServer != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.showname_fromServer);
    }
    i = j;
    if (this.totalCnt != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(8, this.totalCnt);
    }
    j = i;
    if (this.unreadCnt != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(9, this.unreadCnt);
    }
    j = j + ComputeSizeUtil.computeBooleanSize(10, this.isTop) + ComputeSizeUtil.computeBooleanSize(11, this.isVirtual);
    i = j;
    if (this.parentId != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(12, this.parentId);
    }
    j = i;
    if (this.folderType != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(13, this.folderType);
    }
    i = j;
    if (this.sequence_idr != null) {
      i = j + ComputeSizeUtil.computeStringSize(14, this.sequence_idr);
    }
    j = i;
    if (this.parentname != null) {
      j = i + ComputeSizeUtil.computeStringSize(15, this.parentname);
    }
    i = j;
    if (this.syncStatus != null) {
      i = j + ComputeSizeUtil.computeStringSize(16, this.syncStatus);
    }
    j = i;
    if (this.svrKey != null) {
      j = i + ComputeSizeUtil.computeStringSize(17, this.svrKey);
    }
    i = j;
    if (this.remoteFolderType != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(18, this.remoteFolderType);
    }
    return i;
  }
  
  public final Folder parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, Folder paramFolder, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramFolder.folderId = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramFolder.uidvalidity = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramFolder.accountId = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramFolder.remoteId = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramFolder.name = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramFolder.showname = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramFolder.showname_fromServer = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramFolder.totalCnt = paramInputReader.readInteger(paramInt);
      return true;
    case 9: 
      paramFolder.unreadCnt = paramInputReader.readInteger(paramInt);
      return true;
    case 10: 
      paramFolder.isTop = paramInputReader.readBoolean(paramInt);
      return true;
    case 11: 
      paramFolder.isVirtual = paramInputReader.readBoolean(paramInt);
      return true;
    case 12: 
      paramFolder.parentId = paramInputReader.readInteger(paramInt);
      return true;
    case 13: 
      paramFolder.folderType = paramInputReader.readInteger(paramInt);
      return true;
    case 14: 
      paramFolder.sequence_idr = paramInputReader.readString(paramInt);
      return true;
    case 15: 
      paramFolder.parentname = paramInputReader.readString(paramInt);
      return true;
    case 16: 
      paramFolder.syncStatus = paramInputReader.readString(paramInt);
      return true;
    case 17: 
      paramFolder.svrKey = paramInputReader.readString(paramInt);
      return true;
    }
    paramFolder.remoteFolderType = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.folderId != -2147483648) {
      paramOutputWriter.writeInteger(1, this.folderId);
    }
    if (this.uidvalidity != -2147483648) {
      paramOutputWriter.writeInteger(2, this.uidvalidity);
    }
    if (this.accountId != -2147483648) {
      paramOutputWriter.writeInteger(3, this.accountId);
    }
    if (this.remoteId != null) {
      paramOutputWriter.writeString(4, this.remoteId);
    }
    if (this.name != null) {
      paramOutputWriter.writeString(5, this.name);
    }
    if (this.showname != null) {
      paramOutputWriter.writeString(6, this.showname);
    }
    if (this.showname_fromServer != null) {
      paramOutputWriter.writeString(7, this.showname_fromServer);
    }
    if (this.totalCnt != -2147483648) {
      paramOutputWriter.writeInteger(8, this.totalCnt);
    }
    if (this.unreadCnt != -2147483648) {
      paramOutputWriter.writeInteger(9, this.unreadCnt);
    }
    paramOutputWriter.writeBoolean(10, this.isTop);
    paramOutputWriter.writeBoolean(11, this.isVirtual);
    if (this.parentId != -2147483648) {
      paramOutputWriter.writeInteger(12, this.parentId);
    }
    if (this.folderType != -2147483648) {
      paramOutputWriter.writeInteger(13, this.folderType);
    }
    if (this.sequence_idr != null) {
      paramOutputWriter.writeString(14, this.sequence_idr);
    }
    if (this.parentname != null) {
      paramOutputWriter.writeString(15, this.parentname);
    }
    if (this.syncStatus != null) {
      paramOutputWriter.writeString(16, this.syncStatus);
    }
    if (this.svrKey != null) {
      paramOutputWriter.writeString(17, this.svrKey);
    }
    if (this.remoteFolderType != -2147483648) {
      paramOutputWriter.writeInteger(18, this.remoteFolderType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.Folder
 * JD-Core Version:    0.7.0.1
 */