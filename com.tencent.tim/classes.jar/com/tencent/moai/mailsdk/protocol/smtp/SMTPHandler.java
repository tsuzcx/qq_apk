package com.tencent.moai.mailsdk.protocol.smtp;

import android.util.Log;
import com.tencent.moai.mailsdk.MailParser;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.net.SocketFetcher;
import com.tencent.moai.mailsdk.protocol.auth.DigestMD5;
import com.tencent.moai.mailsdk.protocol.auth.NtlmV2;
import com.tencent.moai.mailsdk.protocol.mime.DataListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.model.Address;
import com.tencent.moai.mailsdk.protocol.model.Message;
import com.tencent.moai.mailsdk.protocol.model.Message.RecipientType;
import com.tencent.moai.mailsdk.task.BaseHandler;
import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.LoginUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import com.tencent.moai.mailsdk.util.stream.SMTPOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Locale;
import javax.net.ssl.SSLSocket;
import org.json.JSONException;
import org.json.JSONObject;

public class SMTPHandler
  extends BaseHandler
{
  private static final String TAG = "SMTPHandler";
  private Hashtable<String, String> extMap;
  private boolean isAuthenticate;
  private String lastCommand;
  private String lastResponse;
  private LineInputStream lineInputStream;
  private String localHostName;
  private Profile profile;
  private InputStream serverInput;
  private OutputStream serverOutput;
  private Socket serverSocket;
  
  public SMTPHandler(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
  
  private void command(String paramString, int paramInt)
    throws MessageException
  {
    writeCommand(paramString);
    int i = readResponse();
    if (i != paramInt) {
      throw new MessageException(7, i, this.lastResponse);
    }
  }
  
  private void doAuth()
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "doAuth:" + this.profile.getSmtpName());
    if (this.profile.isOauth()) {}
    for (Object localObject = new OAuth2Authenticator();; localObject = new LoginAuthenticator())
    {
      this.isAuthenticate = ((Authenticator)localObject).authenticate();
      return;
    }
  }
  
  private String getLocalHost()
  {
    if (!StringUtility.isNullOrEmpty(this.localHostName)) {
      return this.localHostName;
    }
    try
    {
      this.localHostName = InetAddress.getLocalHost().getCanonicalHostName();
      if (!StringUtility.isNullOrEmpty(this.localHostName)) {
        return this.localHostName;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        Logger.log(6, "SMTPHandler", Log.getStackTraceString(localUnknownHostException));
      }
      if ((this.serverSocket != null) && (this.serverSocket.isBound()))
      {
        InetAddress localInetAddress = this.serverSocket.getLocalAddress();
        this.localHostName = localInetAddress.getCanonicalHostName();
        if (this.localHostName == null) {
          this.localHostName = ("[" + localInetAddress.getHostAddress() + "]");
        }
      }
      Logger.log(4, "SMTPHandler", "getLocalHost:" + this.localHostName);
    }
    return this.localHostName;
  }
  
  private int getSMTPSSLPort()
  {
    String str = StringUtility.getDomain(this.profile.getMailAddress());
    if ((str.equalsIgnoreCase("outlook.com")) || (str.equalsIgnoreCase("hotmail.com"))) {
      return 587;
    }
    if ((this.profile.getSmtpSSLPort() == 0) || (this.profile.getSmtpSSLPort() == 25)) {
      return 465;
    }
    return this.profile.getSmtpSSLPort();
  }
  
  private void initNormalSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSocket(this.profile.getSmtpServer(), this.profile.getSmtpPort(), this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
  }
  
  private void initSSLSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSSLSocket(this.serverSocket);
  }
  
  private void initSocket()
    throws IOException
  {
    String str = this.profile.getSmtpServer();
    boolean bool = this.profile.isSmtpUsingSSL();
    if ((this.profile.getSmtpPort() == 0) || (this.profile.getSmtpPort() == 465)) {}
    for (int i = 25;; i = this.profile.getSmtpPort())
    {
      this.serverSocket = SocketFetcher.createSocket(str, bool, i, getSMTPSSLPort(), this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
      return;
    }
  }
  
  private void initStream()
    throws IOException
  {
    this.serverOutput = new BufferedOutputStream(this.serverSocket.getOutputStream());
    this.serverInput = new BufferedInputStream(this.serverSocket.getInputStream());
    this.lineInputStream = new LineInputStream(this.serverInput);
  }
  
  private boolean isNotLastLine(String paramString)
  {
    return (paramString != null) && (paramString.length() >= 4) && (paramString.charAt(3) == '-');
  }
  
  private int readResponse()
    throws MessageException
  {
    int i = -1;
    Object localObject = new StringBuilder(100);
    for (;;)
    {
      try
      {
        str = this.lineInputStream.readLine();
        if (str == null)
        {
          localObject = ((StringBuilder)localObject).toString();
          Logger.log(4, "SMTPHandler", "response:" + (String)localObject);
          this.lastResponse = ((String)localObject);
        }
      }
      catch (IOException localIOException)
      {
        String str;
        boolean bool;
        resetLast();
        throw new MessageException(3, "smtp read response error", localIOException);
      }
      try
      {
        if (((String)localObject).length() > 3) {
          i = Integer.parseInt(((String)localObject).substring(0, 3));
        }
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        resetLast();
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("\n");
      bool = isNotLastLine(str);
      if (bool) {}
    }
    return -1;
  }
  
  private void resetLast()
  {
    this.lastCommand = null;
    this.lastResponse = null;
  }
  
  private boolean supportsExtension(String paramString)
  {
    return (this.extMap != null) && (this.extMap.get(paramString.toUpperCase(Locale.ENGLISH)) != null);
  }
  
  private void writeCommand(String paramString)
    throws MessageException
  {
    try
    {
      this.lastCommand = paramString;
      if (this.serverOutput == null) {
        return;
      }
      this.serverOutput.write(ASCIIUtility.getBytes(paramString));
      this.serverOutput.write(MimeDefine.CRLF.getBytes());
      this.serverOutput.flush();
      return;
    }
    catch (IOException paramString)
    {
      resetLast();
      throw new MessageException(3, "smtp send request error", paramString);
    }
  }
  
  public void auth(boolean paramBoolean)
    throws MessageException
  {
    try
    {
      doAuth();
      return;
    }
    catch (MessageException localMessageException)
    {
      if ((!paramBoolean) && (localMessageException.getResultCode() == 4))
      {
        int i = LoginUtility.getProtocolLoginError(localMessageException.getDetailMessage());
        String str = this.profile.getSmtpName();
        if ((i != 3) && (str.contains("@")) && (!MailParser.canUseFullName(str)))
        {
          this.profile.setSmtpName(MailParser.getUserName(str));
          doAuth();
          return;
        }
      }
      throw localMessageException;
    }
  }
  
  /* Error */
  public void closeConnection()
  {
    // Byte code:
    //   0: iconst_4
    //   1: ldc 26
    //   3: new 86	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 374
    //   13: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 377	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:getTag	()Ljava/lang/String;
    //   20: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 107	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 253	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 253	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   40: invokevirtual 380	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 253	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   48: aload_0
    //   49: getfield 248	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverInput	Ljava/io/InputStream;
    //   52: ifnull +10 -> 62
    //   55: aload_0
    //   56: getfield 248	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverInput	Ljava/io/InputStream;
    //   59: invokevirtual 383	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 248	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverInput	Ljava/io/InputStream;
    //   67: aload_0
    //   68: getfield 237	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverOutput	Ljava/io/OutputStream;
    //   71: ifnull +10 -> 81
    //   74: aload_0
    //   75: getfield 237	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverOutput	Ljava/io/OutputStream;
    //   78: invokevirtual 384	java/io/OutputStream:close	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 237	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverOutput	Ljava/io/OutputStream;
    //   86: aload_0
    //   87: getfield 146	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverSocket	Ljava/net/Socket;
    //   90: ifnull +10 -> 100
    //   93: aload_0
    //   94: getfield 146	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverSocket	Ljava/net/Socket;
    //   97: invokevirtual 385	java/net/Socket:close	()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 146	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverSocket	Ljava/net/Socket;
    //   105: return
    //   106: astore_1
    //   107: bipush 6
    //   109: ldc 26
    //   111: aload_1
    //   112: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokestatic 107	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 253	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   123: goto -75 -> 48
    //   126: astore_1
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 253	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: bipush 6
    //   137: ldc 26
    //   139: aload_1
    //   140: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   143: invokestatic 107	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 248	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverInput	Ljava/io/InputStream;
    //   151: goto -84 -> 67
    //   154: astore_1
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 248	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverInput	Ljava/io/InputStream;
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: bipush 6
    //   165: ldc 26
    //   167: aload_1
    //   168: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   171: invokestatic 107	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 237	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverOutput	Ljava/io/OutputStream;
    //   179: goto -93 -> 86
    //   182: astore_1
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 237	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverOutput	Ljava/io/OutputStream;
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: bipush 6
    //   193: ldc 26
    //   195: aload_1
    //   196: invokestatic 144	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   199: invokestatic 107	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 146	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverSocket	Ljava/net/Socket;
    //   207: return
    //   208: astore_1
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 146	com/tencent/moai/mailsdk/protocol/smtp/SMTPHandler:serverSocket	Ljava/net/Socket;
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	SMTPHandler
    //   106	6	1	localIOException1	IOException
    //   126	7	1	localObject1	Object
    //   134	6	1	localIOException2	IOException
    //   154	7	1	localObject2	Object
    //   162	6	1	localIOException3	IOException
    //   182	7	1	localObject3	Object
    //   190	6	1	localIOException4	IOException
    //   208	7	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	106	java/io/IOException
    //   29	43	126	finally
    //   107	118	126	finally
    //   48	62	134	java/io/IOException
    //   48	62	154	finally
    //   135	146	154	finally
    //   67	81	162	java/io/IOException
    //   67	81	182	finally
    //   163	174	182	finally
    //   86	100	190	java/io/IOException
    //   86	100	208	finally
    //   191	202	208	finally
  }
  
  public void data(Message paramMessage, DataListener paramDataListener)
    throws MessageException
  {
    try
    {
      command("DATA", 354);
      Logger.log(4, "SMTPHandler", "data begin");
      SMTPOutputStream localSMTPOutputStream = new SMTPOutputStream(this.serverOutput);
      paramMessage.write(localSMTPOutputStream, paramDataListener);
      localSMTPOutputStream.ensureAtBOL();
      Logger.log(4, "SMTPHandler", "data end");
      command(".", 250);
      return;
    }
    catch (IOException paramMessage)
    {
      throw new MessageException(3, "smtp data io error", paramMessage);
    }
    catch (MessageException paramMessage) {}
    for (;;)
    {
      try
      {
        if (paramMessage.getResultCode() == 7) {
          break label122;
        }
        i = readResponse();
        if (i != -1) {
          throw new MessageException(7, i, this.lastResponse, paramMessage);
        }
      }
      catch (Exception paramDataListener)
      {
        i = -1;
        continue;
      }
      throw paramMessage;
      label122:
      int i = -1;
    }
  }
  
  public boolean ehlo(String paramString)
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "EHLO" + paramString);
    if (paramString != null) {
      writeCommand("EHLO " + paramString);
    }
    int j;
    for (;;)
    {
      j = readResponse();
      if (j == 250)
      {
        Logger.log(4, "SMTPHandler", "ehlo success");
        this.extMap = new Hashtable();
        try
        {
          BufferedReader localBufferedReader = new BufferedReader(new StringReader(this.lastResponse));
          int i = 1;
          for (;;)
          {
            paramString = localBufferedReader.readLine();
            if (paramString == null) {
              break label226;
            }
            if (i != 0)
            {
              i = 0;
              continue;
              writeCommand("EHLO");
              break;
            }
            if (paramString.length() >= 5)
            {
              String str2 = paramString.substring(4);
              int k = str2.indexOf(' ');
              String str1 = "";
              paramString = str2;
              if (k > 0)
              {
                str1 = str2.substring(k + 1);
                paramString = str2.substring(0, k);
              }
              this.extMap.put(paramString.toUpperCase(Locale.ENGLISH), str1);
            }
          }
          if (j != 250) {
            break label235;
          }
        }
        catch (IOException paramString)
        {
          Logger.log(6, "SMTPHandler", Log.getStackTraceString(paramString));
        }
      }
    }
    label226:
    return true;
    label235:
    return false;
  }
  
  public void helo(String paramString)
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "HELO" + paramString);
    if (paramString != null)
    {
      command("HELO " + paramString, 250);
      return;
    }
    command("HELO", 250);
  }
  
  public boolean isAuthenticate()
  {
    return this.isAuthenticate;
  }
  
  public boolean isConnected()
  {
    if ((this.serverSocket == null) || (this.serverOutput == null)) {}
    while (!this.serverSocket.isConnected()) {
      return false;
    }
    try
    {
      boolean bool = noop();
      return bool;
    }
    catch (MessageException localMessageException) {}
    return false;
  }
  
  public void mailFrom(Message paramMessage)
    throws MessageException
  {
    paramMessage = paramMessage.getFrom().getEmail();
    String str = "MAIL FROM:<" + paramMessage + ">";
    writeCommand(str);
    int i = readResponse();
    Logger.log(4, "SMTPHandler", "mail from cmd:" + str + " ret:" + i);
    if (i != 250) {
      throw new MessageException(2, i, "from error " + paramMessage);
    }
  }
  
  public boolean noop()
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "NOOP");
    writeCommand("NOOP");
    return readResponse() == 250;
  }
  
  public void openConnection()
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "openConnection " + getTag() + ", svr:" + this.profile.getSmtpServer() + ", ssl:" + this.profile.isSmtpUsingSSL() + ", port:" + this.profile.getSmtpPort() + ", sslPort:" + this.profile.getSmtpSSLPort());
    this.isAuthenticate = false;
    try
    {
      initSocket();
      initStream();
      int i = readResponse();
      if (i != 220)
      {
        Logger.log(6, "SMTPHandler", "open connection resultCode:" + i + " response:" + this.lastResponse);
        throw new MessageException(5, i, this.lastResponse);
      }
    }
    catch (IOException localIOException)
    {
      Logger.log(6, "SMTPHandler", "open connection io exception:" + Log.getStackTraceString(localIOException));
      throw new MessageException(5, "init socket error", localIOException);
    }
    catch (Exception localException)
    {
      Logger.log(6, "SMTPHandler", "open connection exception:" + Log.getStackTraceString(localException));
      throw new MessageException(5, "init socket error", localException);
    }
    ehlo(getLocalHost());
    if ((!(this.serverSocket instanceof SSLSocket)) && (supportsExtension("STARTTLS")))
    {
      if (startTLS()) {
        ehlo(getLocalHost());
      }
    }
    else {
      return;
    }
    helo(getLocalHost());
  }
  
  public void quit()
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "QUIT");
    writeCommand("QUIT");
  }
  
  public void rcptTo(Message paramMessage)
    throws MessageException
  {
    int j = 0;
    Object localObject = paramMessage.getRecipients(Message.RecipientType.TO);
    int k;
    int i;
    String str1;
    String str2;
    int m;
    if ((localObject != null) && (localObject.length > 0))
    {
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        str1 = localObject[i].getEmail();
        str2 = "RCPT TO:<" + str1 + ">";
        writeCommand(str2);
        m = readResponse();
        Logger.log(4, "SMTPHandler", "mail to cmd:" + str2 + " ret:" + m);
        if (m != 250) {
          throw new MessageException(2, m, "rcp to error " + str1 + " " + this.lastResponse);
        }
        i += 1;
      }
    }
    localObject = paramMessage.getRecipients(Message.RecipientType.CC);
    if ((localObject != null) && (localObject.length > 0))
    {
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        str1 = localObject[i].getEmail();
        str2 = "RCPT TO:<" + str1 + ">";
        writeCommand(str2);
        m = readResponse();
        Logger.log(4, "SMTPHandler", "mail cc cmd:" + str2 + " ret:" + m);
        if (m != 250) {
          throw new MessageException(2, m, "rcp cc error " + str1 + " " + this.lastResponse);
        }
        i += 1;
      }
    }
    paramMessage = paramMessage.getRecipients(Message.RecipientType.BCC);
    if ((paramMessage != null) && (paramMessage.length > 0))
    {
      k = paramMessage.length;
      i = j;
      while (i < k)
      {
        localObject = paramMessage[i].getEmail();
        str1 = "RCPT TO:<" + (String)localObject + ">";
        writeCommand(str1);
        j = readResponse();
        Logger.log(4, "SMTPHandler", "mail bcc cmd:" + str1 + " ret:" + j);
        if (j != 250) {
          throw new MessageException(2, j, "rcp bcc error " + (String)localObject + " " + this.lastResponse);
        }
        i += 1;
      }
    }
  }
  
  public void sendMessage(Message paramMessage, DataListener paramDataListener)
    throws MessageException
  {
    mailFrom(paramMessage);
    rcptTo(paramMessage);
    data(paramMessage, paramDataListener);
    quit();
  }
  
  public boolean startTLS()
    throws MessageException
  {
    Logger.log(4, "SMTPHandler", "STARTTLS");
    command("STARTTLS", 220);
    try
    {
      initSSLSocket();
      initStream();
      return true;
    }
    catch (IOException localIOException1)
    {
      Logger.log(6, "SMTPHandler", "create ssl socket fail after tls:" + Log.getStackTraceString(localIOException1));
      closeConnection();
      try
      {
        initNormalSocket();
        initStream();
        int i = readResponse();
        if (i != 220)
        {
          Logger.log(6, "SMTPHandler", "open connection resultCode:" + i + " response:" + this.lastResponse);
          throw new MessageException(5, i, this.lastResponse);
        }
      }
      catch (IOException localIOException2)
      {
        Logger.log(6, "SMTPHandler", "create normal ssl socket fail:" + Log.getStackTraceString(localIOException2));
        closeConnection();
        throw new MessageException(5, "init socket error", localIOException2);
      }
    }
    return false;
  }
  
  abstract class Authenticator
  {
    private final String mechanism;
    protected int responseCode;
    
    public Authenticator(String paramString)
    {
      this.mechanism = paramString;
    }
    
    public boolean authenticate()
      throws MessageException
    {
      String str1 = getInitialResponse();
      SMTPHandler localSMTPHandler;
      StringBuilder localStringBuilder;
      String str2;
      if (str1 != null)
      {
        localSMTPHandler = SMTPHandler.this;
        localStringBuilder = new StringBuilder().append("AUTH ").append(this.mechanism).append(" ");
        if (str1.length() == 0)
        {
          str2 = "=";
          localSMTPHandler.writeCommand(str2);
          this.responseCode = SMTPHandler.this.readResponse();
          Logger.log(4, "SMTPHandler", "auth mechanism:" + this.mechanism + " responseCode:" + this.responseCode);
        }
      }
      for (;;)
      {
        if (this.responseCode == 530)
        {
          Logger.log(4, "SMTPHandler", "auth start tls");
          if (!SMTPHandler.this.startTLS())
          {
            throw new MessageException(5, "create ssl socket fail");
            str2 = str1;
            break;
            SMTPHandler.this.writeCommand("AUTH " + this.mechanism);
            this.responseCode = SMTPHandler.this.readResponse();
            Logger.log(4, "SMTPHandler", "auth mechanism:" + this.mechanism + " responseCode:" + this.responseCode);
            continue;
          }
          if (str1 == null) {
            break label407;
          }
          localSMTPHandler = SMTPHandler.this;
          localStringBuilder = new StringBuilder().append("AUTH ").append(this.mechanism).append(" ");
          str2 = str1;
          if (str1.length() == 0) {
            str2 = "=";
          }
          localSMTPHandler.writeCommand(str2);
          this.responseCode = SMTPHandler.this.readResponse();
          Logger.log(4, "SMTPHandler", "auth ssl mechanism:" + this.mechanism + " responseCode:" + this.responseCode);
        }
      }
      for (;;)
      {
        if ((this.responseCode == 334) || ((this.responseCode != 235) && (SMTPHandler.this.profile.isOauth())))
        {
          Logger.log(4, "SMTPHandler", "doAuth");
          doAuth();
        }
        Logger.log(4, "SMTPHandler", "auth success");
        return true;
        label407:
        SMTPHandler.this.writeCommand("AUTH " + this.mechanism);
        this.responseCode = SMTPHandler.this.readResponse();
        Logger.log(4, "SMTPHandler", "auth ssl mechanism:" + this.mechanism + " responseCode:" + this.responseCode);
      }
    }
    
    protected abstract void doAuth()
      throws MessageException;
    
    protected abstract String getInitialResponse()
      throws MessageException;
    
    public String getMechanism()
    {
      return this.mechanism;
    }
  }
  
  class DigestMD5Authenticator
    extends SMTPHandler.Authenticator
  {
    public DigestMD5Authenticator()
    {
      super("DIGEST-MD5");
    }
    
    protected void doAuth()
      throws MessageException
    {
      DigestMD5 localDigestMD5 = new DigestMD5();
      try
      {
        byte[] arrayOfByte = localDigestMD5.authClient(SMTPHandler.this.profile.getSmtpDigistMd5Host(), SMTPHandler.this.profile.getSmtpName(), SMTPHandler.this.profile.getSmtpPassword(), SMTPHandler.this.profile.getSmtpDigistMd5Realm(), SMTPHandler.this.lastResponse);
        SMTPHandler.this.writeCommand(new String(arrayOfByte));
        this.responseCode = SMTPHandler.this.readResponse();
        if ((this.responseCode == 334) && (localDigestMD5.authServer(SMTPHandler.this.lastResponse)))
        {
          SMTPHandler.this.writeCommand("");
          this.responseCode = SMTPHandler.this.readResponse();
          if (this.responseCode != 235) {
            throw new MessageException(4, this.responseCode, SMTPHandler.this.lastResponse);
          }
        }
      }
      catch (IOException localIOException) {}
    }
    
    protected String getInitialResponse()
      throws MessageException
    {
      return null;
    }
  }
  
  class LoginAuthenticator
    extends SMTPHandler.Authenticator
  {
    public LoginAuthenticator()
    {
      super("LOGIN");
    }
    
    protected void doAuth()
      throws MessageException
    {
      SMTPHandler.this.writeCommand(new String(BASE64EncoderStream.encode(ASCIIUtility.getBytes(SMTPHandler.this.profile.getSmtpName()))));
      this.responseCode = SMTPHandler.this.readResponse();
      Logger.log(4, "SMTPHandler", "auth login name responseCode:" + this.responseCode);
      if (this.responseCode != 334) {
        throw new MessageException(4, this.responseCode, SMTPHandler.this.lastResponse);
      }
      SMTPHandler.this.writeCommand(new String(BASE64EncoderStream.encode(ASCIIUtility.getBytes(SMTPHandler.this.profile.getSmtpPassword()))));
      this.responseCode = SMTPHandler.this.readResponse();
      Logger.log(4, "SMTPHandler", "auth login pwd responseCode:" + this.responseCode);
      if (this.responseCode != 235) {
        throw new MessageException(4, this.responseCode, SMTPHandler.this.lastResponse);
      }
    }
    
    protected String getInitialResponse()
      throws MessageException
    {
      return null;
    }
  }
  
  class NtlmAuthenticator
    extends SMTPHandler.Authenticator
  {
    private NtlmV2 ntlm;
    
    public NtlmAuthenticator()
    {
      super("NTLM");
    }
    
    protected void doAuth()
      throws MessageException
    {
      SMTPHandler.this.writeCommand(this.ntlm.generateType3Msg(SMTPHandler.this.lastResponse.substring(4).trim()));
      this.responseCode = SMTPHandler.this.readResponse();
      if (this.responseCode != 235) {
        throw new MessageException(4, this.responseCode, SMTPHandler.this.lastResponse);
      }
    }
    
    protected String getInitialResponse()
      throws MessageException
    {
      this.ntlm = new NtlmV2(SMTPHandler.this.profile.getSmtpNtlmDomain(), SMTPHandler.this.getLocalHost(), SMTPHandler.this.profile.getSmtpName(), SMTPHandler.this.profile.getSmtpPassword());
      try
      {
        String str = this.ntlm.generateType1Msg();
        return str;
      }
      catch (Exception localException)
      {
        Logger.log(6, "SMTPHandler", localException.getMessage());
      }
      return null;
    }
  }
  
  class OAuth2Authenticator
    extends SMTPHandler.Authenticator
  {
    public OAuth2Authenticator()
    {
      super("XOAUTH2");
    }
    
    protected void doAuth()
      throws MessageException
    {
      Object localObject = SMTPHandler.this.lastResponse;
      if (localObject != null)
      {
        Logger.log(4, "SMTPHandler", "auth login error :" + (String)localObject);
        localObject = ((String)localObject).split(" ");
        if (localObject.length >= 2)
        {
          localObject = new String(BASE64DecoderStream.decode(localObject[1].trim().getBytes()));
          try
          {
            localObject = new JSONObject((String)localObject);
            if (("400".equals(((JSONObject)localObject).get("status"))) || ("401".equals(((JSONObject)localObject).get("status")))) {
              throw new MessageException(8, "The access token you're using is either expired or invalid");
            }
          }
          catch (JSONException localJSONException) {}
        }
      }
      throw new MessageException(4, "XOAUTH2 asked for more");
    }
    
    protected String getInitialResponse()
      throws MessageException
    {
      return SMTPHandler.this.profile.getAccessToken();
    }
  }
  
  class PlainAuthenticator
    extends SMTPHandler.Authenticator
  {
    public PlainAuthenticator()
    {
      super("PLAIN");
    }
    
    protected void doAuth()
      throws MessageException
    {
      throw new MessageException(4, "PLAIN asked for more");
    }
    
    protected String getInitialResponse()
      throws MessageException
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      BASE64EncoderStream localBASE64EncoderStream = new BASE64EncoderStream(localByteArrayOutputStream, 2147483647);
      try
      {
        localBASE64EncoderStream.write(ASCIIUtility.getBytes(SMTPHandler.this.profile.getSmtpAuthzid()));
        localBASE64EncoderStream.write(0);
        localBASE64EncoderStream.write(ASCIIUtility.getBytes(SMTPHandler.this.profile.getSmtpName()));
        localBASE64EncoderStream.write(0);
        localBASE64EncoderStream.write(ASCIIUtility.getBytes(SMTPHandler.this.profile.getSmtpPassword()));
        localBASE64EncoderStream.flush();
        label84:
        return ASCIIUtility.toString(localByteArrayOutputStream.toByteArray());
      }
      catch (IOException localIOException)
      {
        break label84;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.smtp.SMTPHandler
 * JD-Core Version:    0.7.0.1
 */