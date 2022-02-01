package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class Contacts
  extends BaseProtoBuf
{
  private static final int fieldNumberAddress = 8;
  private static final int fieldNumberBirthday = 10;
  private static final int fieldNumberCid = 1;
  private static final int fieldNumberContact_type = 3;
  private static final int fieldNumberCustom_infos = 14;
  private static final int fieldNumberEmail_address = 13;
  private static final int fieldNumberIsdel = 15;
  private static final int fieldNumberIsvip = 4;
  private static final int fieldNumberMark = 7;
  private static final int fieldNumberName = 5;
  private static final int fieldNumberNick = 6;
  private static final int fieldNumberPhone_number = 9;
  private static final int fieldNumberPinyin = 16;
  private static final int fieldNumberQq = 11;
  private static final int fieldNumberTid = 2;
  private static final int fieldNumberWechat = 12;
  public LinkedList<ByteString> address = new LinkedList();
  public LinkedList<ByteString> birthday = new LinkedList();
  public int cid = -2147483648;
  public int contact_type = -2147483648;
  public LinkedList<ContactsCustomInfo> custom_infos = new LinkedList();
  public LinkedList<ByteString> email_address = new LinkedList();
  public int isdel = -2147483648;
  public boolean isvip;
  public LinkedList<ByteString> mark = new LinkedList();
  public ByteString name;
  public ByteString nick;
  public LinkedList<ByteString> phone_number = new LinkedList();
  public ByteString pinyin;
  public LinkedList<ByteString> qq = new LinkedList();
  public int tid = -2147483648;
  public LinkedList<ByteString> wechat = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0;
    if (this.cid != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.cid);
    }
    int i = j;
    if (this.tid != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.tid);
    }
    j = i;
    if (this.contact_type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.contact_type);
    }
    j += ComputeSizeUtil.computeBooleanSize(4, this.isvip);
    i = j;
    if (this.name != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(5, this.name);
    }
    j = i;
    if (this.nick != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(6, this.nick);
    }
    j = j + ComputeSizeUtil.computeListSize(7, 6, this.mark) + ComputeSizeUtil.computeListSize(8, 6, this.address) + ComputeSizeUtil.computeListSize(9, 6, this.phone_number) + ComputeSizeUtil.computeListSize(10, 6, this.birthday) + ComputeSizeUtil.computeListSize(11, 6, this.qq) + ComputeSizeUtil.computeListSize(12, 6, this.wechat) + ComputeSizeUtil.computeListSize(13, 6, this.email_address) + ComputeSizeUtil.computeListSize(14, 8, this.custom_infos);
    i = j;
    if (this.isdel != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(15, this.isdel);
    }
    j = i;
    if (this.pinyin != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(16, this.pinyin);
    }
    return j;
  }
  
  public final Contacts parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.mark.clear();
    this.address.clear();
    this.phone_number.clear();
    this.birthday.clear();
    this.qq.clear();
    this.wechat.clear();
    this.email_address.clear();
    this.custom_infos.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, Contacts paramContacts, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramContacts.cid = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramContacts.tid = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramContacts.contact_type = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramContacts.isvip = paramInputReader.readBoolean(paramInt);
      return true;
    case 5: 
      paramContacts.name = paramInputReader.readByteString(paramInt);
      return true;
    case 6: 
      paramContacts.nick = paramInputReader.readByteString(paramInt);
      return true;
    case 7: 
      paramContacts.mark.add(paramInputReader.readByteString(paramInt));
      return true;
    case 8: 
      paramContacts.address.add(paramInputReader.readByteString(paramInt));
      return true;
    case 9: 
      paramContacts.phone_number.add(paramInputReader.readByteString(paramInt));
      return true;
    case 10: 
      paramContacts.birthday.add(paramInputReader.readByteString(paramInt));
      return true;
    case 11: 
      paramContacts.qq.add(paramInputReader.readByteString(paramInt));
      return true;
    case 12: 
      paramContacts.wechat.add(paramInputReader.readByteString(paramInt));
      return true;
    case 13: 
      paramContacts.email_address.add(paramInputReader.readByteString(paramInt));
      return true;
    case 14: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        ContactsCustomInfo localContactsCustomInfo = new ContactsCustomInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localContactsCustomInfo.populateBuilderWithField((InputReader)localObject, localContactsCustomInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramContacts.custom_infos.add(localContactsCustomInfo);
        paramInt += 1;
      }
      return true;
    case 15: 
      paramContacts.isdel = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramContacts.pinyin = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.cid != -2147483648) {
      paramOutputWriter.writeInteger(1, this.cid);
    }
    if (this.tid != -2147483648) {
      paramOutputWriter.writeInteger(2, this.tid);
    }
    if (this.contact_type != -2147483648) {
      paramOutputWriter.writeInteger(3, this.contact_type);
    }
    paramOutputWriter.writeBoolean(4, this.isvip);
    if (this.name != null) {
      paramOutputWriter.writeByteString(5, this.name);
    }
    if (this.nick != null) {
      paramOutputWriter.writeByteString(6, this.nick);
    }
    paramOutputWriter.writeList(7, 6, this.mark);
    paramOutputWriter.writeList(8, 6, this.address);
    paramOutputWriter.writeList(9, 6, this.phone_number);
    paramOutputWriter.writeList(10, 6, this.birthday);
    paramOutputWriter.writeList(11, 6, this.qq);
    paramOutputWriter.writeList(12, 6, this.wechat);
    paramOutputWriter.writeList(13, 6, this.email_address);
    paramOutputWriter.writeList(14, 8, this.custom_infos);
    if (this.isdel != -2147483648) {
      paramOutputWriter.writeInteger(15, this.isdel);
    }
    if (this.pinyin != null) {
      paramOutputWriter.writeByteString(16, this.pinyin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.Contacts
 * JD-Core Version:    0.7.0.1
 */