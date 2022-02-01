package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protobuf.BaseProtoBuf;

public class ProtocolInfo
  implements ARTConvert
{
  public String activesync_policykey_;
  public String activesync_version_;
  public String cmd_unique_id_;
  public String device_id_;
  public String device_type_;
  public String domain_;
  public int exchange_version_ = 1;
  public boolean http_realm_;
  public String ldap_server_addr_;
  public int ldap_server_port_;
  public String password_;
  public String proxy_password_;
  public long proxy_port_;
  public String proxy_server_;
  public int proxy_type_;
  public String proxy_username_;
  public String server_addr_;
  public String server_domain_;
  public int server_port_;
  public boolean ssl_support_;
  public int type_;
  public boolean use_ssl_scheme_;
  public String user_agent_;
  public String username_;
  
  public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
  {
    paramBaseProtoBuf = (com.tencent.qqmail.protocol.ART.ProtocolInfo)paramBaseProtoBuf;
    this.username_ = paramBaseProtoBuf.username_;
    this.password_ = paramBaseProtoBuf.password_;
    this.server_addr_ = paramBaseProtoBuf.server_addr_;
    this.server_port_ = paramBaseProtoBuf.server_port_;
    this.ssl_support_ = paramBaseProtoBuf.ssl_support_;
    this.type_ = paramBaseProtoBuf.type_;
    this.use_ssl_scheme_ = paramBaseProtoBuf.use_ssl_scheme_;
    this.proxy_server_ = paramBaseProtoBuf.proxy_server_;
    this.proxy_port_ = paramBaseProtoBuf.proxy_port_;
    this.proxy_username_ = paramBaseProtoBuf.proxy_username_;
    this.proxy_password_ = paramBaseProtoBuf.proxy_password_;
    this.proxy_type_ = paramBaseProtoBuf.proxy_type_;
    this.ldap_server_port_ = paramBaseProtoBuf.ldap_server_port_;
    this.ldap_server_addr_ = paramBaseProtoBuf.ldap_server_addr_;
    this.http_realm_ = paramBaseProtoBuf.http_realm_;
    this.exchange_version_ = paramBaseProtoBuf.exchange_version_;
    this.server_domain_ = paramBaseProtoBuf.server_domain_;
    this.device_id_ = paramBaseProtoBuf.device_id_;
    this.device_type_ = paramBaseProtoBuf.device_type_;
    this.activesync_version_ = paramBaseProtoBuf.activesync_version_;
    this.activesync_policykey_ = paramBaseProtoBuf.activesync_policykey_;
    this.user_agent_ = paramBaseProtoBuf.user_agent_;
    this.cmd_unique_id_ = paramBaseProtoBuf.cmd_unique_id_;
    this.domain_ = paramBaseProtoBuf.domain_;
  }
  
  public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ProtocolInfo
 * JD-Core Version:    0.7.0.1
 */