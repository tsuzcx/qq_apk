package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ProtocolInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberActivesync_policykey_ = 21;
  private static final int fieldNumberActivesync_version_ = 20;
  private static final int fieldNumberCmd_unique_id_ = 23;
  private static final int fieldNumberDevice_id_ = 18;
  private static final int fieldNumberDevice_type_ = 19;
  private static final int fieldNumberDomain_ = 24;
  private static final int fieldNumberExchange_version_ = 16;
  private static final int fieldNumberHttp_realm_ = 15;
  private static final int fieldNumberLdap_server_addr_ = 14;
  private static final int fieldNumberLdap_server_port_ = 13;
  private static final int fieldNumberPassword_ = 2;
  private static final int fieldNumberProxy_password_ = 11;
  private static final int fieldNumberProxy_port_ = 9;
  private static final int fieldNumberProxy_server_ = 8;
  private static final int fieldNumberProxy_type_ = 12;
  private static final int fieldNumberProxy_username_ = 10;
  private static final int fieldNumberServer_addr_ = 3;
  private static final int fieldNumberServer_domain_ = 17;
  private static final int fieldNumberServer_port_ = 4;
  private static final int fieldNumberSsl_support_ = 5;
  private static final int fieldNumberType_ = 6;
  private static final int fieldNumberUse_ssl_scheme_ = 7;
  private static final int fieldNumberUser_agent_ = 22;
  private static final int fieldNumberUsername_ = 1;
  public String activesync_policykey_;
  public String activesync_version_;
  public String cmd_unique_id_;
  public String device_id_;
  public String device_type_;
  public String domain_;
  public int exchange_version_ = 1;
  public boolean http_realm_;
  public String ldap_server_addr_;
  public int ldap_server_port_ = -2147483648;
  public String password_;
  public String proxy_password_;
  public long proxy_port_ = -9223372036854775808L;
  public String proxy_server_;
  public int proxy_type_ = -2147483648;
  public String proxy_username_;
  public String server_addr_;
  public String server_domain_;
  public int server_port_ = -2147483648;
  public boolean ssl_support_;
  public int type_ = -2147483648;
  public boolean use_ssl_scheme_;
  public String user_agent_;
  public String username_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.username_ != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.username_);
    }
    int i = j;
    if (this.password_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.password_);
    }
    j = i;
    if (this.server_addr_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.server_addr_);
    }
    i = j;
    if (this.server_port_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.server_port_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(5, this.ssl_support_);
    i = j;
    if (this.type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.type_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(7, this.use_ssl_scheme_);
    i = j;
    if (this.proxy_server_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.proxy_server_);
    }
    j = i;
    if (this.proxy_port_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(9, this.proxy_port_);
    }
    i = j;
    if (this.proxy_username_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.proxy_username_);
    }
    j = i;
    if (this.proxy_password_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(11, this.proxy_password_);
    }
    i = j;
    if (this.proxy_type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(12, this.proxy_type_);
    }
    j = i;
    if (this.ldap_server_port_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(13, this.ldap_server_port_);
    }
    i = j;
    if (this.ldap_server_addr_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(14, this.ldap_server_addr_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(15, this.http_realm_);
    i = j;
    if (this.exchange_version_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(16, this.exchange_version_);
    }
    j = i;
    if (this.server_domain_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(17, this.server_domain_);
    }
    i = j;
    if (this.device_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(18, this.device_id_);
    }
    j = i;
    if (this.device_type_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(19, this.device_type_);
    }
    i = j;
    if (this.activesync_version_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(20, this.activesync_version_);
    }
    j = i;
    if (this.activesync_policykey_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(21, this.activesync_policykey_);
    }
    i = j;
    if (this.user_agent_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(22, this.user_agent_);
    }
    j = i;
    if (this.cmd_unique_id_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(23, this.cmd_unique_id_);
    }
    i = j;
    if (this.domain_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(24, this.domain_);
    }
    return i;
  }
  
  public final ProtocolInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ProtocolInfo paramProtocolInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramProtocolInfo.username_ = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramProtocolInfo.password_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramProtocolInfo.server_addr_ = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramProtocolInfo.server_port_ = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramProtocolInfo.ssl_support_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 6: 
      paramProtocolInfo.type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramProtocolInfo.use_ssl_scheme_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 8: 
      paramProtocolInfo.proxy_server_ = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramProtocolInfo.proxy_port_ = paramInputReader.readLong(paramInt);
      return true;
    case 10: 
      paramProtocolInfo.proxy_username_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramProtocolInfo.proxy_password_ = paramInputReader.readString(paramInt);
      return true;
    case 12: 
      paramProtocolInfo.proxy_type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 13: 
      paramProtocolInfo.ldap_server_port_ = paramInputReader.readInteger(paramInt);
      return true;
    case 14: 
      paramProtocolInfo.ldap_server_addr_ = paramInputReader.readString(paramInt);
      return true;
    case 15: 
      paramProtocolInfo.http_realm_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 16: 
      paramProtocolInfo.exchange_version_ = paramInputReader.readInteger(paramInt);
      return true;
    case 17: 
      paramProtocolInfo.server_domain_ = paramInputReader.readString(paramInt);
      return true;
    case 18: 
      paramProtocolInfo.device_id_ = paramInputReader.readString(paramInt);
      return true;
    case 19: 
      paramProtocolInfo.device_type_ = paramInputReader.readString(paramInt);
      return true;
    case 20: 
      paramProtocolInfo.activesync_version_ = paramInputReader.readString(paramInt);
      return true;
    case 21: 
      paramProtocolInfo.activesync_policykey_ = paramInputReader.readString(paramInt);
      return true;
    case 22: 
      paramProtocolInfo.user_agent_ = paramInputReader.readString(paramInt);
      return true;
    case 23: 
      paramProtocolInfo.cmd_unique_id_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramProtocolInfo.domain_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.username_ != null) {
      paramOutputWriter.writeString(1, this.username_);
    }
    if (this.password_ != null) {
      paramOutputWriter.writeString(2, this.password_);
    }
    if (this.server_addr_ != null) {
      paramOutputWriter.writeString(3, this.server_addr_);
    }
    if (this.server_port_ != -2147483648) {
      paramOutputWriter.writeInteger(4, this.server_port_);
    }
    paramOutputWriter.writeBoolean(5, this.ssl_support_);
    if (this.type_ != -2147483648) {
      paramOutputWriter.writeInteger(6, this.type_);
    }
    paramOutputWriter.writeBoolean(7, this.use_ssl_scheme_);
    if (this.proxy_server_ != null) {
      paramOutputWriter.writeString(8, this.proxy_server_);
    }
    if (this.proxy_port_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(9, this.proxy_port_);
    }
    if (this.proxy_username_ != null) {
      paramOutputWriter.writeString(10, this.proxy_username_);
    }
    if (this.proxy_password_ != null) {
      paramOutputWriter.writeString(11, this.proxy_password_);
    }
    if (this.proxy_type_ != -2147483648) {
      paramOutputWriter.writeInteger(12, this.proxy_type_);
    }
    if (this.ldap_server_port_ != -2147483648) {
      paramOutputWriter.writeInteger(13, this.ldap_server_port_);
    }
    if (this.ldap_server_addr_ != null) {
      paramOutputWriter.writeString(14, this.ldap_server_addr_);
    }
    paramOutputWriter.writeBoolean(15, this.http_realm_);
    if (this.exchange_version_ != -2147483648) {
      paramOutputWriter.writeInteger(16, this.exchange_version_);
    }
    if (this.server_domain_ != null) {
      paramOutputWriter.writeString(17, this.server_domain_);
    }
    if (this.device_id_ != null) {
      paramOutputWriter.writeString(18, this.device_id_);
    }
    if (this.device_type_ != null) {
      paramOutputWriter.writeString(19, this.device_type_);
    }
    if (this.activesync_version_ != null) {
      paramOutputWriter.writeString(20, this.activesync_version_);
    }
    if (this.activesync_policykey_ != null) {
      paramOutputWriter.writeString(21, this.activesync_policykey_);
    }
    if (this.user_agent_ != null) {
      paramOutputWriter.writeString(22, this.user_agent_);
    }
    if (this.cmd_unique_id_ != null) {
      paramOutputWriter.writeString(23, this.cmd_unique_id_);
    }
    if (this.domain_ != null) {
      paramOutputWriter.writeString(24, this.domain_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ProtocolInfo
 * JD-Core Version:    0.7.0.1
 */