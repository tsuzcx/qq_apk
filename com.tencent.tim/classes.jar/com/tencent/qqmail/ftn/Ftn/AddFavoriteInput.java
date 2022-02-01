package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class AddFavoriteInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFids = 1;
  private static final int fieldNumberTopathid = 2;
  public LinkedList<String> fids = new LinkedList();
  public String topathid;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 1, this.fids);
    int i = j;
    if (this.topathid != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.topathid);
    }
    return i;
  }
  
  public final AddFavoriteInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.fids.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.topathid == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AddFavoriteInput paramAddFavoriteInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAddFavoriteInput.fids.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramAddFavoriteInput.topathid = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.topathid == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeList(1, 1, this.fids);
    if (this.topathid != null) {
      paramOutputWriter.writeString(2, this.topathid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.AddFavoriteInput
 * JD-Core Version:    0.7.0.1
 */