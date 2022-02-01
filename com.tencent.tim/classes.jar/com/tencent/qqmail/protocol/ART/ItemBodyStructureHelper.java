package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemBodyStructureHelper
  extends BaseProtoBuf
{
  private static final int fieldNumberBody_struture_info_ = 1;
  public LinkedList<MailItemBodyStructureInfo> body_struture_info_ = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.body_struture_info_);
  }
  
  public final ItemBodyStructureHelper parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.body_struture_info_.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemBodyStructureHelper paramItemBodyStructureHelper, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      MailItemBodyStructureInfo localMailItemBodyStructureInfo = new MailItemBodyStructureInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localMailItemBodyStructureInfo.populateBuilderWithField((InputReader)localObject, localMailItemBodyStructureInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramItemBodyStructureHelper.body_struture_info_.add(localMailItemBodyStructureInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.body_struture_info_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ItemBodyStructureHelper
 * JD-Core Version:    0.7.0.1
 */