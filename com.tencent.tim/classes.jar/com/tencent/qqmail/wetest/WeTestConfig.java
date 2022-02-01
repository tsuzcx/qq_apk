package com.tencent.qqmail.wetest;

import androidx.annotation.NonNull;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.provider.MailServiceProvider;
import java.util.ArrayList;

public final class WeTestConfig
{
  public static final int AUTO_LOGIN_ACTIVESYNC = 4;
  public static final int AUTO_LOGIN_ACTIVESYNC_FOR_MONKEY = 10;
  public static final int AUTO_LOGIN_IMAP = 3;
  public static final int AUTO_LOGIN_IMAP_FOR_MONKEY = 9;
  public static final int AUTO_LOGIN_NONE = 0;
  public static final int AUTO_LOGIN_POP = 2;
  public static final int AUTO_LOGIN_POP_FOR_MONKEY = 8;
  public static final int AUTO_LOGIN_QQ = 1;
  public static final int AUTO_LOGIN_QQ_AND_IMAP = 7;
  public static final int AUTO_LOGIN_QQ_FOR_MONKEY = 5;
  public static final int AUTO_LOGIN_QQ_WITH_FOLDER_PWD = 6;
  private static final String INPUT_EMAIL = "";
  private static final String INPUT_EMAIL_FOR_MONKEY = "";
  private static final String INPUT_PWD_ACTIVESYNC = "";
  private static final String INPUT_PWD_ACTIVESYNC_FOR_MONKEY = "";
  private static final String INPUT_PWD_IMAP = "";
  private static final String INPUT_PWD_IMAP_FOR_MONKEY = "";
  private static final String INPUT_PWD_POP3 = "";
  private static final String INPUT_PWD_POP3_FOR_MONKEY = "";
  
  public static final boolean autoLoginProtocol()
  {
    return false;
  }
  
  public static final boolean autoLoginQQ()
  {
    return false;
  }
  
  public static final String getInputEmail()
  {
    switch ()
    {
    case 5: 
    case 6: 
    default: 
      throw new UnsupportedOperationException();
    case 2: 
    case 3: 
    case 4: 
      return "";
    }
    return "";
  }
  
  public static final String getInputPwd()
  {
    switch ()
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      throw new UnsupportedOperationException();
    case 2: 
      return "";
    case 3: 
      return "";
    case 8: 
      return "";
    }
    return "";
  }
  
  @NonNull
  public static final MailServiceProvider getQQMailServiceProvider()
  {
    switch ()
    {
    case 4: 
    case 5: 
    case 6: 
    default: 
      throw new UnsupportedOperationException();
    case 2: 
    case 8: 
      return getQQMailServiceProvider("POP3");
    }
    return getQQMailServiceProvider("IMAP");
  }
  
  private static final MailServiceProvider getQQMailServiceProvider(String paramString)
  {
    MailServiceProvider localMailServiceProvider = new MailServiceProvider();
    localMailServiceProvider.setProviderName(null);
    localMailServiceProvider.setProviderIcon(null);
    localMailServiceProvider.setProviderAvatar(null);
    localMailServiceProvider.setProviderCompanyEntrys(new ArrayList());
    localMailServiceProvider.setMailAddressSuffix(new String[] { "qq.com", "vip.qq.com" });
    localMailServiceProvider.setDefaultRecvProtocol(paramString);
    localMailServiceProvider.setImapName(0);
    localMailServiceProvider.setImapServer("imap.qq.com");
    localMailServiceProvider.setImapPort(0);
    localMailServiceProvider.setImapSSLPort(993);
    localMailServiceProvider.setImapUsingSSL(true);
    localMailServiceProvider.setPop3Name(0);
    localMailServiceProvider.setPop3Server("pop.qq.com");
    localMailServiceProvider.setPop3Port(0);
    localMailServiceProvider.setPop3SSLPort(995);
    localMailServiceProvider.setPop3UsingSSL(true);
    localMailServiceProvider.setSmtpName(0);
    localMailServiceProvider.setSmtpServer("smtp.qq.com");
    localMailServiceProvider.setSmtpPort(0);
    localMailServiceProvider.setSmtpSSLPort(465);
    localMailServiceProvider.setSmtpUsingSSL(true);
    return localMailServiceProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.wetest.WeTestConfig
 * JD-Core Version:    0.7.0.1
 */