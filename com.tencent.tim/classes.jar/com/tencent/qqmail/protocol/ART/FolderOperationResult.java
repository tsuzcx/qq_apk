package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class FolderOperationResult
  extends BaseProtoBuf
{
  private static final int fieldNumberAdded_folder_ = 1;
  private static final int fieldNumberDeleted_folder_ = 2;
  private static final int fieldNumberUpdate_folder_ = 3;
  public Folder added_folder_;
  public Folder deleted_folder_;
  public Folder update_folder_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.added_folder_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.added_folder_.computeSize());
    }
    int i = j;
    if (this.deleted_folder_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(2, this.deleted_folder_.computeSize());
    }
    j = i;
    if (this.update_folder_ != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.update_folder_.computeSize());
    }
    return j;
  }
  
  public final FolderOperationResult parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, FolderOperationResult paramFolderOperationResult, int paramInt)
    throws IOException
  {
    Object localObject;
    Folder localFolder;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localFolder = new Folder();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localFolder.populateBuilderWithField((InputReader)localObject, localFolder, getNextFieldNumber((InputReader)localObject))) {}
        paramFolderOperationResult.added_folder_ = localFolder;
        paramInt += 1;
      }
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localFolder = new Folder();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localFolder.populateBuilderWithField((InputReader)localObject, localFolder, getNextFieldNumber((InputReader)localObject))) {}
        paramFolderOperationResult.deleted_folder_ = localFolder;
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject = (byte[])paramInputReader.get(paramInt);
      localFolder = new Folder();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (bool = true; bool; bool = localFolder.populateBuilderWithField((InputReader)localObject, localFolder, getNextFieldNumber((InputReader)localObject))) {}
      paramFolderOperationResult.update_folder_ = localFolder;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.added_folder_ != null)
    {
      paramOutputWriter.writeMessage(1, this.added_folder_.computeSize());
      this.added_folder_.writeFields(paramOutputWriter);
    }
    if (this.deleted_folder_ != null)
    {
      paramOutputWriter.writeMessage(2, this.deleted_folder_.computeSize());
      this.deleted_folder_.writeFields(paramOutputWriter);
    }
    if (this.update_folder_ != null)
    {
      paramOutputWriter.writeMessage(3, this.update_folder_.computeSize());
      this.update_folder_.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.FolderOperationResult
 * JD-Core Version:    0.7.0.1
 */