package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class File
  extends BaseProtoBuf
{
  private static final int fieldNumberFilesize = 8;
  private static final int fieldNumberFiletype = 6;
  private static final int fieldNumberFullname = 4;
  private static final int fieldNumberName = 2;
  private static final int fieldNumberPath = 7;
  private static final int fieldNumberSubDir = 3;
  private static final int fieldNumberType = 1;
  private static final int fieldNumberViewtype = 5;
  public long filesize;
  public int filetype;
  public String fullname;
  public String name;
  public String path;
  public LinkedList<File> subDir = new LinkedList();
  public int type;
  public int viewtype;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.name != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.name);
    }
    j = i + ComputeSizeUtil.computeListSize(3, 8, this.subDir);
    i = j;
    if (this.fullname != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.fullname);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(5, this.viewtype) + ComputeSizeUtil.computeIntegerSize(6, this.filetype);
    i = j;
    if (this.path != null) {
      i = j + ComputeSizeUtil.computeStringSize(7, this.path);
    }
    return i + ComputeSizeUtil.computeLongSize(8, this.filesize);
  }
  
  public final File parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.subDir.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.name == null) || (this.fullname == null) || (this.path == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, File paramFile, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramFile.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramFile.name = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        File localFile = new File();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localFile.populateBuilderWithField((InputReader)localObject, localFile, getNextFieldNumber((InputReader)localObject))) {}
        paramFile.subDir.add(localFile);
        paramInt += 1;
      }
      return true;
    case 4: 
      paramFile.fullname = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramFile.viewtype = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramFile.filetype = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramFile.path = paramInputReader.readString(paramInt);
      return true;
    }
    paramFile.filesize = paramInputReader.readLong(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.name == null) || (this.fullname == null) || (this.path == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeInteger(1, this.type);
    if (this.name != null) {
      paramOutputWriter.writeString(2, this.name);
    }
    paramOutputWriter.writeList(3, 8, this.subDir);
    if (this.fullname != null) {
      paramOutputWriter.writeString(4, this.fullname);
    }
    paramOutputWriter.writeInteger(5, this.viewtype);
    paramOutputWriter.writeInteger(6, this.filetype);
    if (this.path != null) {
      paramOutputWriter.writeString(7, this.path);
    }
    paramOutputWriter.writeLong(8, this.filesize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.File
 * JD-Core Version:    0.7.0.1
 */