package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CardData
  extends BaseProtoBuf
{
  private static final int fieldNumberCardid = 1;
  private static final int fieldNumberCardname = 2;
  private static final int fieldNumberCardpara = 9;
  private static final int fieldNumberCardtag = 11;
  private static final int fieldNumberCardurl = 4;
  private static final int fieldNumberCirclelimit = 16;
  private static final int fieldNumberFriendnum = 20;
  private static final int fieldNumberFriendtype = 18;
  private static final int fieldNumberIscomplete = 8;
  private static final int fieldNumberMailtitle = 13;
  private static final int fieldNumberMailword = 12;
  private static final int fieldNumberPagetype = 17;
  private static final int fieldNumberPictures = 3;
  private static final int fieldNumberPriority = 10;
  private static final int fieldNumberQqsharelimit = 22;
  private static final int fieldNumberSeqtype = 19;
  private static final int fieldNumberSharetitle = 14;
  private static final int fieldNumberShareword = 15;
  private static final int fieldNumberThankscount = 6;
  private static final int fieldNumberThankslist = 7;
  private static final int fieldNumberViewcount = 5;
  private static final int fieldNumberWxsharelimit = 21;
  public ByteString cardid;
  public ByteString cardname;
  public LinkedList<CardPara> cardpara = new LinkedList();
  public ByteString cardtag;
  public ByteString cardurl;
  public boolean circlelimit;
  public int friendnum = -2147483648;
  public int friendtype = -2147483648;
  public boolean iscomplete;
  public ByteString mailtitle;
  public ByteString mailword;
  public int pagetype = -2147483648;
  public LinkedList<CardPicture> pictures = new LinkedList();
  public double priority = 4.9E-324D;
  public boolean qqsharelimit;
  public int seqtype = -2147483648;
  public ByteString sharetitle;
  public ByteString shareword;
  public int thankscount = -2147483648;
  public LinkedList<FriendInfo> thankslist = new LinkedList();
  public int viewcount = -2147483648;
  public boolean wxsharelimit;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.cardid != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.cardid);
    }
    int j = i;
    if (this.cardname != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.cardname);
    }
    j += ComputeSizeUtil.computeListSize(3, 8, this.pictures);
    i = j;
    if (this.cardurl != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.cardurl);
    }
    j = i;
    if (this.viewcount != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.viewcount);
    }
    i = j;
    if (this.thankscount != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.thankscount);
    }
    j = i + ComputeSizeUtil.computeListSize(7, 8, this.thankslist) + ComputeSizeUtil.computeBooleanSize(8, this.iscomplete) + ComputeSizeUtil.computeListSize(9, 8, this.cardpara);
    i = j;
    if (this.priority != 4.9E-324D) {
      i = j + ComputeSizeUtil.computeDoubleSize(10, this.priority);
    }
    j = i;
    if (this.cardtag != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(11, this.cardtag);
    }
    i = j;
    if (this.mailword != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(12, this.mailword);
    }
    j = i;
    if (this.mailtitle != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(13, this.mailtitle);
    }
    i = j;
    if (this.sharetitle != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(14, this.sharetitle);
    }
    j = i;
    if (this.shareword != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(15, this.shareword);
    }
    j += ComputeSizeUtil.computeBooleanSize(16, this.circlelimit);
    i = j;
    if (this.pagetype != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(17, this.pagetype);
    }
    j = i;
    if (this.friendtype != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(18, this.friendtype);
    }
    i = j;
    if (this.seqtype != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(19, this.seqtype);
    }
    j = i;
    if (this.friendnum != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(20, this.friendnum);
    }
    return j + ComputeSizeUtil.computeBooleanSize(21, this.wxsharelimit) + ComputeSizeUtil.computeBooleanSize(22, this.qqsharelimit);
  }
  
  public final CardData parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.pictures.clear();
    this.thankslist.clear();
    this.cardpara.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CardData paramCardData, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCardData.cardid = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCardData.cardname = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CardPicture();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CardPicture)localObject1).populateBuilderWithField((InputReader)localObject2, (CardPicture)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCardData.pictures.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 4: 
      paramCardData.cardurl = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramCardData.viewcount = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramCardData.thankscount = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new FriendInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((FriendInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (FriendInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCardData.thankslist.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 8: 
      paramCardData.iscomplete = paramInputReader.readBoolean(paramInt);
      return true;
    case 9: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new CardPara();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((CardPara)localObject1).populateBuilderWithField((InputReader)localObject2, (CardPara)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCardData.cardpara.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 10: 
      paramCardData.priority = paramInputReader.readDouble(paramInt);
      return true;
    case 11: 
      paramCardData.cardtag = paramInputReader.readByteString(paramInt);
      return true;
    case 12: 
      paramCardData.mailword = paramInputReader.readByteString(paramInt);
      return true;
    case 13: 
      paramCardData.mailtitle = paramInputReader.readByteString(paramInt);
      return true;
    case 14: 
      paramCardData.sharetitle = paramInputReader.readByteString(paramInt);
      return true;
    case 15: 
      paramCardData.shareword = paramInputReader.readByteString(paramInt);
      return true;
    case 16: 
      paramCardData.circlelimit = paramInputReader.readBoolean(paramInt);
      return true;
    case 17: 
      paramCardData.pagetype = paramInputReader.readInteger(paramInt);
      return true;
    case 18: 
      paramCardData.friendtype = paramInputReader.readInteger(paramInt);
      return true;
    case 19: 
      paramCardData.seqtype = paramInputReader.readInteger(paramInt);
      return true;
    case 20: 
      paramCardData.friendnum = paramInputReader.readInteger(paramInt);
      return true;
    case 21: 
      paramCardData.wxsharelimit = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramCardData.qqsharelimit = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.cardid != null) {
      paramOutputWriter.writeByteString(1, this.cardid);
    }
    if (this.cardname != null) {
      paramOutputWriter.writeByteString(2, this.cardname);
    }
    paramOutputWriter.writeList(3, 8, this.pictures);
    if (this.cardurl != null) {
      paramOutputWriter.writeByteString(4, this.cardurl);
    }
    if (this.viewcount != -2147483648) {
      paramOutputWriter.writeInteger(5, this.viewcount);
    }
    if (this.thankscount != -2147483648) {
      paramOutputWriter.writeInteger(6, this.thankscount);
    }
    paramOutputWriter.writeList(7, 8, this.thankslist);
    paramOutputWriter.writeBoolean(8, this.iscomplete);
    paramOutputWriter.writeList(9, 8, this.cardpara);
    if (this.priority != 4.9E-324D) {
      paramOutputWriter.writeDouble(10, this.priority);
    }
    if (this.cardtag != null) {
      paramOutputWriter.writeByteString(11, this.cardtag);
    }
    if (this.mailword != null) {
      paramOutputWriter.writeByteString(12, this.mailword);
    }
    if (this.mailtitle != null) {
      paramOutputWriter.writeByteString(13, this.mailtitle);
    }
    if (this.sharetitle != null) {
      paramOutputWriter.writeByteString(14, this.sharetitle);
    }
    if (this.shareword != null) {
      paramOutputWriter.writeByteString(15, this.shareword);
    }
    paramOutputWriter.writeBoolean(16, this.circlelimit);
    if (this.pagetype != -2147483648) {
      paramOutputWriter.writeInteger(17, this.pagetype);
    }
    if (this.friendtype != -2147483648) {
      paramOutputWriter.writeInteger(18, this.friendtype);
    }
    if (this.seqtype != -2147483648) {
      paramOutputWriter.writeInteger(19, this.seqtype);
    }
    if (this.friendnum != -2147483648) {
      paramOutputWriter.writeInteger(20, this.friendnum);
    }
    paramOutputWriter.writeBoolean(21, this.wxsharelimit);
    paramOutputWriter.writeBoolean(22, this.qqsharelimit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CardData
 * JD-Core Version:    0.7.0.1
 */