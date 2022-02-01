package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class LocalDomainUnreadCountDetail
  extends BaseProtoBuf
{
  private static final int fieldNumberFolder_detail = 2;
  private static final int fieldNumberUin = 1;
  public LinkedList<FolderDetail> folder_detail = new LinkedList();
  public long uin = -9223372036854775808L;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.uin != -9223372036854775808L) {
      i = 0 + ComputeSizeUtil.computeLongSize(1, this.uin);
    }
    return i + ComputeSizeUtil.computeListSize(2, 8, this.folder_detail);
  }
  
  public final LocalDomainUnreadCountDetail parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.folder_detail.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, LocalDomainUnreadCountDetail paramLocalDomainUnreadCountDetail, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramLocalDomainUnreadCountDetail.uin = paramInputReader.readLong(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      FolderDetail localFolderDetail = new FolderDetail();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localFolderDetail.populateBuilderWithField((InputReader)localObject, localFolderDetail, getNextFieldNumber((InputReader)localObject))) {}
      paramLocalDomainUnreadCountDetail.folder_detail.add(localFolderDetail);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.uin);
    }
    paramOutputWriter.writeList(2, 8, this.folder_detail);
  }
  
  public static final class FolderDetail
    extends BaseProtoBuf
  {
    private static final int fieldNumberFolder_id = 1;
    private static final int fieldNumberNotify_newmail = 3;
    private static final int fieldNumberUnread_count = 2;
    public int folder_id = -2147483648;
    public boolean notify_newmail;
    public int unread_count = -2147483648;
    
    public final int computeSize()
    {
      int i = 0;
      if (this.folder_id != -2147483648) {
        i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.folder_id);
      }
      int j = i;
      if (this.unread_count != -2147483648) {
        j = i + ComputeSizeUtil.computeIntegerSize(2, this.unread_count);
      }
      return j + ComputeSizeUtil.computeBooleanSize(3, this.notify_newmail);
    }
    
    public final FolderDetail parseFrom(byte[] paramArrayOfByte)
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
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, FolderDetail paramFolderDetail, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramFolderDetail.folder_id = paramInputReader.readInteger(paramInt);
        return true;
      case 2: 
        paramFolderDetail.unread_count = paramInputReader.readInteger(paramInt);
        return true;
      }
      paramFolderDetail.notify_newmail = paramInputReader.readBoolean(paramInt);
      return true;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (this.folder_id != -2147483648) {
        paramOutputWriter.writeInteger(1, this.folder_id);
      }
      if (this.unread_count != -2147483648) {
        paramOutputWriter.writeInteger(2, this.unread_count);
      }
      paramOutputWriter.writeBoolean(3, this.notify_newmail);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.LocalDomainUnreadCountDetail
 * JD-Core Version:    0.7.0.1
 */