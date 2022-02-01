package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AndroidDeviceInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberBrand = 1;
  private static final int fieldNumberModel = 2;
  private static final int fieldNumberOs_version = 5;
  private static final int fieldNumberPackage_info = 6;
  private static final int fieldNumberRom = 3;
  private static final int fieldNumberRom_version = 4;
  public ByteString brand;
  public ByteString model;
  public ByteString os_version;
  public LinkedList<AndroidPackageInfo> package_info = new LinkedList();
  public ByteString rom;
  public ByteString rom_version;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.brand != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.brand);
    }
    int i = j;
    if (this.model != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.model);
    }
    j = i;
    if (this.rom != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.rom);
    }
    i = j;
    if (this.rom_version != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.rom_version);
    }
    j = i;
    if (this.os_version != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.os_version);
    }
    return j + ComputeSizeUtil.computeListSize(6, 8, this.package_info);
  }
  
  public final AndroidDeviceInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.package_info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AndroidDeviceInfo paramAndroidDeviceInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAndroidDeviceInfo.brand = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramAndroidDeviceInfo.model = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramAndroidDeviceInfo.rom = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramAndroidDeviceInfo.rom_version = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramAndroidDeviceInfo.os_version = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      AndroidPackageInfo localAndroidPackageInfo = new AndroidPackageInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localAndroidPackageInfo.populateBuilderWithField((InputReader)localObject, localAndroidPackageInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramAndroidDeviceInfo.package_info.add(localAndroidPackageInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.brand != null) {
      paramOutputWriter.writeByteString(1, this.brand);
    }
    if (this.model != null) {
      paramOutputWriter.writeByteString(2, this.model);
    }
    if (this.rom != null) {
      paramOutputWriter.writeByteString(3, this.rom);
    }
    if (this.rom_version != null) {
      paramOutputWriter.writeByteString(4, this.rom_version);
    }
    if (this.os_version != null) {
      paramOutputWriter.writeByteString(5, this.os_version);
    }
    paramOutputWriter.writeList(6, 8, this.package_info);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AndroidDeviceInfo
 * JD-Core Version:    0.7.0.1
 */