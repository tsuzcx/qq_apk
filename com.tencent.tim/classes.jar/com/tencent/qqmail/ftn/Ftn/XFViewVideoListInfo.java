package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class XFViewVideoListInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberXfiteminfo = 1;
  public LinkedList<XFViewVideoItemInfo> xfiteminfo = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.xfiteminfo);
  }
  
  public final XFViewVideoListInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.xfiteminfo.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, XFViewVideoListInfo paramXFViewVideoListInfo, int paramInt)
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
      XFViewVideoItemInfo localXFViewVideoItemInfo = new XFViewVideoItemInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localXFViewVideoItemInfo.populateBuilderWithField((InputReader)localObject, localXFViewVideoItemInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramXFViewVideoListInfo.xfiteminfo.add(localXFViewVideoItemInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.xfiteminfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.XFViewVideoListInfo
 * JD-Core Version:    0.7.0.1
 */