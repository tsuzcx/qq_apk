package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class NameCard
  extends BaseProtoBuf
{
  private static final int fieldNumberAddr = 5;
  private static final int fieldNumberAngle = 10;
  private static final int fieldNumberComminfo = 8;
  private static final int fieldNumberCompany = 6;
  private static final int fieldNumberMail = 3;
  private static final int fieldNumberName = 1;
  private static final int fieldNumberPhone = 2;
  private static final int fieldNumberSite = 9;
  private static final int fieldNumberTel = 7;
  private static final int fieldNumberTitle = 4;
  public ByteString addr;
  public int angle = -2147483648;
  public LinkedList<CommInfo> comminfo = new LinkedList();
  public ByteString company;
  public ByteString mail;
  public ByteString name;
  public ByteString phone;
  public ByteString site;
  public ByteString tel;
  public ByteString title;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.name != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.name);
    }
    int i = j;
    if (this.phone != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.phone);
    }
    j = i;
    if (this.mail != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.mail);
    }
    i = j;
    if (this.title != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.title);
    }
    j = i;
    if (this.addr != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.addr);
    }
    i = j;
    if (this.company != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.company);
    }
    j = i;
    if (this.tel != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(7, this.tel);
    }
    j += ComputeSizeUtil.computeListSize(8, 8, this.comminfo);
    i = j;
    if (this.site != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(9, this.site);
    }
    j = i;
    if (this.angle != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(10, this.angle);
    }
    return j;
  }
  
  public final NameCard parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.comminfo.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, NameCard paramNameCard, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramNameCard.name = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramNameCard.phone = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramNameCard.mail = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramNameCard.title = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramNameCard.addr = paramInputReader.readByteString(paramInt);
      return true;
    case 6: 
      paramNameCard.company = paramInputReader.readByteString(paramInt);
      return true;
    case 7: 
      paramNameCard.tel = paramInputReader.readByteString(paramInt);
      return true;
    case 8: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        CommInfo localCommInfo = new CommInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localCommInfo.populateBuilderWithField((InputReader)localObject, localCommInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramNameCard.comminfo.add(localCommInfo);
        paramInt += 1;
      }
      return true;
    case 9: 
      paramNameCard.site = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramNameCard.angle = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.name != null) {
      paramOutputWriter.writeByteString(1, this.name);
    }
    if (this.phone != null) {
      paramOutputWriter.writeByteString(2, this.phone);
    }
    if (this.mail != null) {
      paramOutputWriter.writeByteString(3, this.mail);
    }
    if (this.title != null) {
      paramOutputWriter.writeByteString(4, this.title);
    }
    if (this.addr != null) {
      paramOutputWriter.writeByteString(5, this.addr);
    }
    if (this.company != null) {
      paramOutputWriter.writeByteString(6, this.company);
    }
    if (this.tel != null) {
      paramOutputWriter.writeByteString(7, this.tel);
    }
    paramOutputWriter.writeList(8, 8, this.comminfo);
    if (this.site != null) {
      paramOutputWriter.writeByteString(9, this.site);
    }
    if (this.angle != -2147483648) {
      paramOutputWriter.writeInteger(10, this.angle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.NameCard
 * JD-Core Version:    0.7.0.1
 */