package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class XFViewVideoItemInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberFormat = 2;
  private static final int fieldNumberInfo = 9;
  private static final int fieldNumberPiecenum = 3;
  private static final int fieldNumberQueuenum = 6;
  private static final int fieldNumberRemaintime = 8;
  private static final int fieldNumberResult = 1;
  private static final int fieldNumberStatus = 5;
  private static final int fieldNumberTaskper = 7;
  private static final int fieldNumberTotaltime = 4;
  public int format;
  public LinkedList<XFVideoPieceInfo> info = new LinkedList();
  public int piecenum;
  public int queuenum;
  public int remaintime;
  public int result;
  public int status;
  public int taskper;
  public int totaltime;
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeIntegerSize(1, this.result) + ComputeSizeUtil.computeIntegerSize(2, this.format) + ComputeSizeUtil.computeIntegerSize(3, this.piecenum) + ComputeSizeUtil.computeIntegerSize(4, this.totaltime) + ComputeSizeUtil.computeIntegerSize(5, this.status) + ComputeSizeUtil.computeIntegerSize(6, this.queuenum) + ComputeSizeUtil.computeIntegerSize(7, this.taskper) + ComputeSizeUtil.computeIntegerSize(8, this.remaintime) + ComputeSizeUtil.computeListSize(9, 8, this.info);
  }
  
  public final XFViewVideoItemInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, XFViewVideoItemInfo paramXFViewVideoItemInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramXFViewVideoItemInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramXFViewVideoItemInfo.format = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramXFViewVideoItemInfo.piecenum = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramXFViewVideoItemInfo.totaltime = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramXFViewVideoItemInfo.status = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramXFViewVideoItemInfo.queuenum = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramXFViewVideoItemInfo.taskper = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramXFViewVideoItemInfo.remaintime = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      XFVideoPieceInfo localXFVideoPieceInfo = new XFVideoPieceInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localXFVideoPieceInfo.populateBuilderWithField((InputReader)localObject, localXFVideoPieceInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramXFViewVideoItemInfo.info.add(localXFVideoPieceInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.result);
    paramOutputWriter.writeInteger(2, this.format);
    paramOutputWriter.writeInteger(3, this.piecenum);
    paramOutputWriter.writeInteger(4, this.totaltime);
    paramOutputWriter.writeInteger(5, this.status);
    paramOutputWriter.writeInteger(6, this.queuenum);
    paramOutputWriter.writeInteger(7, this.taskper);
    paramOutputWriter.writeInteger(8, this.remaintime);
    paramOutputWriter.writeList(9, 8, this.info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.XFViewVideoItemInfo
 * JD-Core Version:    0.7.0.1
 */