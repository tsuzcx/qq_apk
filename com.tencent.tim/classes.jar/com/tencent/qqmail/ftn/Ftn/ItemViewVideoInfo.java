package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewVideoInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberDownloadinfo = 5;
  private static final int fieldNumberFormat = 1;
  private static final int fieldNumberSections = 4;
  private static final int fieldNumberTotaltime = 2;
  private static final int fieldNumberType = 3;
  public ItemViewVideoUrlInfo downloadinfo;
  public int format;
  public LinkedList<ItemViewVideoUrlInfo> sections = new LinkedList();
  public int totaltime;
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.format) + ComputeSizeUtil.computeIntegerSize(2, this.totaltime) + ComputeSizeUtil.computeIntegerSize(3, this.type) + ComputeSizeUtil.computeListSize(4, 8, this.sections);
    int i = j;
    if (this.downloadinfo != null) {
      i = j + ComputeSizeUtil.computeMessageSize(5, this.downloadinfo.computeSize());
    }
    return i;
  }
  
  public final ItemViewVideoInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.sections.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewVideoInfo paramItemViewVideoInfo, int paramInt)
    throws IOException
  {
    Object localObject;
    ItemViewVideoUrlInfo localItemViewVideoUrlInfo;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewVideoInfo.format = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramItemViewVideoInfo.totaltime = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramItemViewVideoInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramInputReader.get(paramInt);
        localItemViewVideoUrlInfo = new ItemViewVideoUrlInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (bool = true; bool; bool = localItemViewVideoUrlInfo.populateBuilderWithField((InputReader)localObject, localItemViewVideoUrlInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramItemViewVideoInfo.sections.add(localItemViewVideoUrlInfo);
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
      localItemViewVideoUrlInfo = new ItemViewVideoUrlInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (bool = true; bool; bool = localItemViewVideoUrlInfo.populateBuilderWithField((InputReader)localObject, localItemViewVideoUrlInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramItemViewVideoInfo.downloadinfo = localItemViewVideoUrlInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.format);
    paramOutputWriter.writeInteger(2, this.totaltime);
    paramOutputWriter.writeInteger(3, this.type);
    paramOutputWriter.writeList(4, 8, this.sections);
    if (this.downloadinfo != null)
    {
      paramOutputWriter.writeMessage(5, this.downloadinfo.computeSize());
      this.downloadinfo.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewVideoInfo
 * JD-Core Version:    0.7.0.1
 */