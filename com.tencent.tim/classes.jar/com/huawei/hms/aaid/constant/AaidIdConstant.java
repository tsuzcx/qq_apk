package com.huawei.hms.aaid.constant;

public abstract interface AaidIdConstant
{
  public static final String AAID = "aaid";
  public static final String AAID_FILE = "aaid";
  public static final String CREATE_TIME = "creationTime";
  public static final String DEFAULT_SCOPE_TYPE = "HCM";
  public static final String PUSH_VERSION = "com.huawei.hms.client.service.name:push";
  public static final String SIGNATURE_SHA256 = "SHA-256";
  public static final String deleteToken = "push.deletetoken";
  public static final String getToken = "push.gettoken";
  
  public static abstract interface PushClientSelfInfo
  {
    public static final String FILE_NAME = "push_client_self_info";
    public static final String HAS_REQUEST_AGREEMENT = "hasRequestAgreement";
    public static final String PUSH_KIT_AUTO_INIT_ENABLED = "push_kit_auto_init_enabled";
    public static final String TOKEN_INFO = "token_info_v2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.aaid.constant.AaidIdConstant
 * JD-Core Version:    0.7.0.1
 */