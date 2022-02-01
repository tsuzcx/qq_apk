package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class DomainConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberAvailable_proto_config = 4;
  private static final int fieldNumberCloud_support_switch_editable = 7;
  private static final int fieldNumberDefault_recv_type = 2;
  private static final int fieldNumberDefault_send_type = 3;
  private static final int fieldNumberDomain = 5;
  private static final int fieldNumberFit_add_account_entry = 6;
  private static final int fieldNumberUse_cloud_support = 1;
  public LinkedList<EmailProtocolConfig> available_proto_config = new LinkedList();
  public boolean cloud_support_switch_editable;
  public int default_recv_type;
  public int default_send_type;
  public String domain;
  public LinkedList<Integer> fit_add_account_entry = new LinkedList();
  public boolean use_cloud_support;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.use_cloud_support) + ComputeSizeUtil.computeIntegerSize(2, this.default_recv_type) + ComputeSizeUtil.computeIntegerSize(3, this.default_send_type) + ComputeSizeUtil.computeListSize(4, 8, this.available_proto_config);
    int i = j;
    if (this.domain != null) {
      i = j + ComputeSizeUtil.computeStringSize(5, this.domain);
    }
    return i + ComputeSizeUtil.computeListSize(6, 2, this.fit_add_account_entry) + ComputeSizeUtil.computeBooleanSize(7, this.cloud_support_switch_editable);
  }
  
  public final DomainConfig parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.available_proto_config.clear();
    this.fit_add_account_entry.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DomainConfig paramDomainConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDomainConfig.use_cloud_support = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramDomainConfig.default_recv_type = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramDomainConfig.default_send_type = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        EmailProtocolConfig localEmailProtocolConfig = new EmailProtocolConfig();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localEmailProtocolConfig.populateBuilderWithField((InputReader)localObject, localEmailProtocolConfig, getNextFieldNumber((InputReader)localObject))) {}
        paramDomainConfig.available_proto_config.add(localEmailProtocolConfig);
        paramInt += 1;
      }
      return true;
    case 5: 
      paramDomainConfig.domain = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramDomainConfig.fit_add_account_entry.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    }
    paramDomainConfig.cloud_support_switch_editable = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.use_cloud_support);
    paramOutputWriter.writeInteger(2, this.default_recv_type);
    paramOutputWriter.writeInteger(3, this.default_send_type);
    paramOutputWriter.writeList(4, 8, this.available_proto_config);
    if (this.domain != null) {
      paramOutputWriter.writeString(5, this.domain);
    }
    paramOutputWriter.writeList(6, 2, this.fit_add_account_entry);
    paramOutputWriter.writeBoolean(7, this.cloud_support_switch_editable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.DomainConfig
 * JD-Core Version:    0.7.0.1
 */