package com.tencent.moai.mailsdk.protocol.pop3;

import android.util.Log;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.net.SocketFetcher;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeMessage;
import com.tencent.moai.mailsdk.task.BaseHandler;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.SharedByteArrayOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.StringTokenizer;
import javax.net.ssl.SSLSocket;

public class POP3Handler
  extends BaseHandler
{
  private static final String ERR = "-ERR";
  private static final String OK = "+OK";
  private static final int SLOP = 128;
  private static final String TAG = "POP3Handler";
  private static char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private String apopChallenge;
  private Map<String, String> capabilities = null;
  private BufferedReader input;
  private boolean isAuthenticate;
  private PrintWriter output;
  private boolean pipelining;
  private Profile profile;
  private InputStream serverInput;
  private OutputStream serverOutput;
  private Socket serverSocket;
  
  public POP3Handler(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
  
  private String getDigest(String paramString)
  {
    paramString = this.apopChallenge + paramString;
    try
    {
      paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes("iso-8859-1"));
      return toHex(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      return null;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  private void handleAuthError(boolean paramBoolean, String paramString)
    throws MessageException
  {
    this.isAuthenticate = false;
    if ((paramBoolean) || ((paramString != null) && (paramString.contains("authorization failed")))) {
      throw new MessageException(4, paramString);
    }
    throw new MessageException(3, paramString);
  }
  
  /* Error */
  private boolean hasCapability(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:capabilities	Ljava/util/Map;
    //   6: ifnull +30 -> 36
    //   9: aload_0
    //   10: getfield 65	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:capabilities	Ljava/util/Map;
    //   13: aload_1
    //   14: getstatic 134	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   17: invokevirtual 138	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   20: invokeinterface 144 2 0
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq +9 -> 36
    //   30: iconst_1
    //   31: istore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: iload_2
    //   35: ireturn
    //   36: iconst_0
    //   37: istore_2
    //   38: goto -6 -> 32
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	POP3Handler
    //   0	46	1	paramString	String
    //   25	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	26	41	finally
  }
  
  private void initNormalSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSocket(this.profile.getPopServer(), this.profile.getPopPort(), this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
  }
  
  private void initSSLSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSSLSocket(this.serverSocket);
  }
  
  private void initSocket()
    throws IOException
  {
    String str = this.profile.getPopServer();
    boolean bool = this.profile.isPopUsingSSL();
    int i;
    if ((this.profile.getPopPort() == 0) || (this.profile.getPopPort() == 995))
    {
      i = 110;
      if ((this.profile.getPopSSLPort() != 0) && (this.profile.getPopSSLPort() != 110)) {
        break label121;
      }
    }
    label121:
    for (int j = 995;; j = this.profile.getPopSSLPort())
    {
      this.serverSocket = SocketFetcher.createSocket(str, bool, i, j, this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
      return;
      i = this.profile.getPopPort();
      break;
    }
  }
  
  private void initStream()
    throws IOException
  {
    this.serverOutput = new BufferedOutputStream(this.serverSocket.getOutputStream());
    this.serverInput = new BufferedInputStream(this.serverSocket.getInputStream());
    this.output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.serverOutput, "iso-8859-1")));
    this.input = new BufferedReader(new InputStreamReader(this.serverInput, "iso-8859-1"));
  }
  
  private POP3Response multilineCommand(String paramString, int paramInt)
    throws MessageException
  {
    writeCommand(paramString);
    paramString = readLineResponse();
    if (!paramString.isOk()) {
      return paramString;
    }
    paramString.setBytes(readMultilineResponse(paramInt));
    return paramString;
  }
  
  private POP3Response readLineResponse()
    throws MessageException
  {
    try
    {
      String str = this.input.readLine();
      if (str == null) {
        throw new MessageException(3, "pop3 read response null");
      }
    }
    catch (IOException localIOException)
    {
      throw new MessageException(3, "pop3 read response error", localIOException);
    }
    POP3Response localPOP3Response = new POP3Response();
    if (localIOException.startsWith("+OK")) {
      localPOP3Response.setOk(true);
    }
    for (;;)
    {
      int i = localIOException.indexOf(' ');
      if (i >= 0) {
        localPOP3Response.setData(localIOException.substring(i + 1));
      }
      return localPOP3Response;
      if (!localIOException.startsWith("-ERR")) {
        break;
      }
      Logger.log(6, "POP3Handler", "readline error : " + localIOException);
      localPOP3Response.setOk(false);
    }
    throw new MessageException(3, "pop3 read response " + localIOException);
  }
  
  private InputStream readMultilineResponse(int paramInt)
    throws MessageException
  {
    SharedByteArrayOutputStream localSharedByteArrayOutputStream = new SharedByteArrayOutputStream(paramInt);
    int i = 10;
    try
    {
      for (;;)
      {
        int j = this.input.read();
        paramInt = j;
        if (j >= 0)
        {
          paramInt = j;
          if (i == 10)
          {
            paramInt = j;
            if (j == 46)
            {
              i = this.input.read();
              paramInt = i;
              if (i == 13) {
                paramInt = this.input.read();
              }
            }
          }
        }
        else
        {
          if (paramInt >= 0) {
            break;
          }
          throw new MessageException(3, "EOF on socket");
        }
        localSharedByteArrayOutputStream.write(paramInt);
        i = paramInt;
      }
      return localIOException.toStream();
    }
    catch (IOException localIOException)
    {
      throw new MessageException(3, "pop3 read response error", localIOException);
    }
  }
  
  /* Error */
  private void setCapabilities(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: aload_0
    //   7: aconst_null
    //   8: putfield 65	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:capabilities	Ljava/util/Map;
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 325	java/util/HashMap
    //   18: dup
    //   19: bipush 10
    //   21: invokespecial 326	java/util/HashMap:<init>	(I)V
    //   24: putfield 65	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:capabilities	Ljava/util/Map;
    //   27: new 235	java/io/BufferedReader
    //   30: dup
    //   31: new 237	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: ldc_w 328
    //   39: invokespecial 240	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   42: invokespecial 243	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_3
    //   46: new 75	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   53: astore 6
    //   55: aload_3
    //   56: invokevirtual 270	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   59: astore 5
    //   61: aload 5
    //   63: ifnull +129 -> 192
    //   66: aload 5
    //   68: bipush 32
    //   70: invokevirtual 289	java/lang/String:indexOf	(I)I
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +174 -> 249
    //   78: aload 5
    //   80: iconst_0
    //   81: iload_2
    //   82: invokevirtual 331	java/lang/String:substring	(II)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: getstatic 134	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   92: invokevirtual 138	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   95: astore 4
    //   97: aload_0
    //   98: getfield 65	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:capabilities	Ljava/util/Map;
    //   101: aload 4
    //   103: aload 5
    //   105: invokeinterface 335 3 0
    //   110: pop
    //   111: aload 6
    //   113: new 75	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   120: aload 4
    //   122: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc_w 337
    //   128: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload 5
    //   133: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 339
    //   139: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: goto -94 -> 55
    //   152: astore_3
    //   153: bipush 6
    //   155: ldc 17
    //   157: aload_3
    //   158: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   161: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokevirtual 350	java/io/InputStream:close	()V
    //   168: goto -157 -> 11
    //   171: astore_1
    //   172: goto -161 -> 11
    //   175: astore_3
    //   176: bipush 6
    //   178: ldc 17
    //   180: aload_3
    //   181: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   184: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   187: aconst_null
    //   188: astore_3
    //   189: goto -143 -> 46
    //   192: iconst_4
    //   193: ldc 17
    //   195: new 75	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 352
    //   205: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 6
    //   210: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: invokevirtual 350	java/io/InputStream:close	()V
    //   226: goto -215 -> 11
    //   229: astore_1
    //   230: goto -219 -> 11
    //   233: astore_3
    //   234: aload_1
    //   235: invokevirtual 350	java/io/InputStream:close	()V
    //   238: aload_3
    //   239: athrow
    //   240: astore_1
    //   241: aload_0
    //   242: monitorexit
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: goto -8 -> 238
    //   249: aload 5
    //   251: astore 4
    //   253: goto -166 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	POP3Handler
    //   0	256	1	paramInputStream	InputStream
    //   73	9	2	i	int
    //   45	11	3	localBufferedReader	BufferedReader
    //   152	6	3	localIOException	IOException
    //   175	6	3	localUnsupportedEncodingException	UnsupportedEncodingException
    //   188	1	3	localObject1	Object
    //   233	6	3	localObject2	Object
    //   85	167	4	str1	String
    //   59	191	5	str2	String
    //   53	156	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   46	55	152	java/io/IOException
    //   55	61	152	java/io/IOException
    //   66	74	152	java/io/IOException
    //   78	87	152	java/io/IOException
    //   87	149	152	java/io/IOException
    //   192	222	152	java/io/IOException
    //   164	168	171	java/io/IOException
    //   27	46	175	java/io/UnsupportedEncodingException
    //   222	226	229	java/io/IOException
    //   46	55	233	finally
    //   55	61	233	finally
    //   66	74	233	finally
    //   78	87	233	finally
    //   87	149	233	finally
    //   153	164	233	finally
    //   192	222	233	finally
    //   6	11	240	finally
    //   14	27	240	finally
    //   27	46	240	finally
    //   164	168	240	finally
    //   176	187	240	finally
    //   222	226	240	finally
    //   234	238	240	finally
    //   238	240	240	finally
    //   234	238	245	java/io/IOException
  }
  
  private POP3Response simpleCommand(String paramString)
    throws MessageException
  {
    writeCommand(paramString);
    return readLineResponse();
  }
  
  private static String toHex(byte[] paramArrayOfByte)
  {
    int j = 0;
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k = paramArrayOfByte[i] & 0xFF;
      int m = j + 1;
      arrayOfChar[j] = digits[(k >> 4)];
      j = m + 1;
      arrayOfChar[m] = digits[(k & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private void writeCommand(String paramString)
    throws MessageException
  {
    paramString = paramString + MimeDefine.CRLF;
    if (this.output == null) {
      throw new MessageException(3, "writeCommand " + paramString + " but output is null");
    }
    this.output.print(paramString);
    this.output.flush();
  }
  
  public void auth(boolean paramBoolean)
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "doAuth:" + this.profile.getPopName());
    boolean bool = this.serverSocket instanceof SSLSocket;
    Object localObject = null;
    if (this.apopChallenge != null) {
      localObject = getDigest(this.profile.getPopPassword());
    }
    if ((this.apopChallenge != null) && (localObject != null))
    {
      localObject = simpleCommand("APOP " + this.profile.getPopName() + " " + (String)localObject);
      if (!((POP3Response)localObject).isOk()) {
        Logger.log(6, "POP3Handler", "auth apop error:" + ((POP3Response)localObject).getData());
      }
    }
    else
    {
      if ((!this.pipelining) || (!bool)) {
        break label344;
      }
      writeCommand("USER " + this.profile.getPopName());
      writeCommand("PASS " + this.profile.getPopPassword());
      localObject = readLineResponse();
      if (!((POP3Response)localObject).isOk())
      {
        Logger.log(6, "POP3Handler", "auth ssl name error:" + ((POP3Response)localObject).getData());
        handleAuthError(paramBoolean, ((POP3Response)localObject).getData());
      }
      localObject = readLineResponse();
      if (!((POP3Response)localObject).isOk())
      {
        Logger.log(6, "POP3Handler", "auth ssl pwd error:" + ((POP3Response)localObject).getData());
        handleAuthError(paramBoolean, ((POP3Response)localObject).getData());
      }
    }
    for (;;)
    {
      Logger.log(4, "POP3Handler", "auth success");
      this.isAuthenticate = true;
      return;
      this.isAuthenticate = true;
      return;
      label344:
      POP3Response localPOP3Response = simpleCommand("USER " + this.profile.getPopName());
      if (!localPOP3Response.isOk())
      {
        localObject = localPOP3Response;
        if (localPOP3Response.getData() != null)
        {
          localObject = localPOP3Response;
          if (localPOP3Response.getData().contains("user#servername")) {
            localObject = simpleCommand("USER " + this.profile.getPopName().replace("@", "#"));
          }
        }
        if (!((POP3Response)localObject).isOk())
        {
          Logger.log(6, "POP3Handler", "auth name error:" + ((POP3Response)localObject).getData());
          handleAuthError(paramBoolean, ((POP3Response)localObject).getData());
        }
      }
      localObject = simpleCommand("PASS " + this.profile.getPopPassword());
      if (!((POP3Response)localObject).isOk())
      {
        Logger.log(6, "POP3Handler", "auth pwd error:" + ((POP3Response)localObject).getData());
        handleAuthError(paramBoolean, ((POP3Response)localObject).getData());
      }
    }
  }
  
  public InputStream capa()
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "CAPA");
    return multilineCommand("CAPA", 128).getBytes();
  }
  
  /* Error */
  public void closeConnection()
  {
    // Byte code:
    //   0: iconst_4
    //   1: ldc 17
    //   3: new 75	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 434
    //   13: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 437	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:getTag	()Ljava/lang/String;
    //   20: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 233	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:output	Ljava/io/PrintWriter;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 233	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:output	Ljava/io/PrintWriter;
    //   40: invokevirtual 438	java/io/PrintWriter:close	()V
    //   43: aload_0
    //   44: getfield 245	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:input	Ljava/io/BufferedReader;
    //   47: ifnull +10 -> 57
    //   50: aload_0
    //   51: getfield 245	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:input	Ljava/io/BufferedReader;
    //   54: invokevirtual 439	java/io/BufferedReader:close	()V
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 233	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:output	Ljava/io/PrintWriter;
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 245	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:input	Ljava/io/BufferedReader;
    //   67: aload_0
    //   68: getfield 218	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverInput	Ljava/io/InputStream;
    //   71: ifnull +10 -> 81
    //   74: aload_0
    //   75: getfield 218	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverInput	Ljava/io/InputStream;
    //   78: invokevirtual 350	java/io/InputStream:close	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 218	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverInput	Ljava/io/InputStream;
    //   86: aload_0
    //   87: getfield 207	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverOutput	Ljava/io/OutputStream;
    //   90: ifnull +10 -> 100
    //   93: aload_0
    //   94: getfield 207	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverOutput	Ljava/io/OutputStream;
    //   97: invokevirtual 442	java/io/OutputStream:close	()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 207	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverOutput	Ljava/io/OutputStream;
    //   105: aload_0
    //   106: getfield 176	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverSocket	Ljava/net/Socket;
    //   109: ifnull +10 -> 119
    //   112: aload_0
    //   113: getfield 176	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverSocket	Ljava/net/Socket;
    //   116: invokevirtual 443	java/net/Socket:close	()V
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 176	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverSocket	Ljava/net/Socket;
    //   124: return
    //   125: astore_1
    //   126: bipush 6
    //   128: ldc 17
    //   130: aload_1
    //   131: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   134: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: aconst_null
    //   139: putfield 233	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:output	Ljava/io/PrintWriter;
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 245	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:input	Ljava/io/BufferedReader;
    //   147: goto -80 -> 67
    //   150: astore_1
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 233	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:output	Ljava/io/PrintWriter;
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 245	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:input	Ljava/io/BufferedReader;
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: bipush 6
    //   166: ldc 17
    //   168: aload_1
    //   169: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   172: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 218	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverInput	Ljava/io/InputStream;
    //   180: goto -94 -> 86
    //   183: astore_1
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 218	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverInput	Ljava/io/InputStream;
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: bipush 6
    //   194: ldc 17
    //   196: aload_1
    //   197: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: aconst_null
    //   205: putfield 207	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverOutput	Ljava/io/OutputStream;
    //   208: goto -103 -> 105
    //   211: astore_1
    //   212: aload_0
    //   213: aconst_null
    //   214: putfield 207	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverOutput	Ljava/io/OutputStream;
    //   217: aload_1
    //   218: athrow
    //   219: astore_1
    //   220: bipush 6
    //   222: ldc 17
    //   224: aload_1
    //   225: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   228: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   231: aload_0
    //   232: aconst_null
    //   233: putfield 176	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverSocket	Ljava/net/Socket;
    //   236: return
    //   237: astore_1
    //   238: aload_0
    //   239: aconst_null
    //   240: putfield 176	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:serverSocket	Ljava/net/Socket;
    //   243: aload_1
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	POP3Handler
    //   125	6	1	localIOException1	IOException
    //   150	12	1	localObject1	Object
    //   163	6	1	localIOException2	IOException
    //   183	7	1	localObject2	Object
    //   191	6	1	localIOException3	IOException
    //   211	7	1	localObject3	Object
    //   219	6	1	localIOException4	IOException
    //   237	7	1	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   29	43	125	java/io/IOException
    //   43	57	125	java/io/IOException
    //   29	43	150	finally
    //   43	57	150	finally
    //   126	137	150	finally
    //   67	81	163	java/io/IOException
    //   67	81	183	finally
    //   164	175	183	finally
    //   86	100	191	java/io/IOException
    //   86	100	211	finally
    //   192	203	211	finally
    //   105	119	219	java/io/IOException
    //   105	119	237	finally
    //   220	231	237	finally
  }
  
  public boolean dele(int paramInt)
    throws MessageException
  {
    boolean bool = simpleCommand("DELE " + paramInt).isOk();
    Logger.log(4, "POP3Handler", "DELE " + paramInt + " isOk:" + bool);
    return bool;
  }
  
  public boolean isAuthenticate()
  {
    return this.isAuthenticate;
  }
  
  public boolean isConnected()
  {
    if ((this.serverSocket == null) || (this.serverOutput == null)) {}
    for (;;)
    {
      return false;
      if (this.serverSocket.isConnected()) {
        try
        {
          if (this.isAuthenticate)
          {
            boolean bool = noop();
            return bool;
          }
        }
        catch (MessageException localMessageException) {}
      }
    }
    return false;
  }
  
  public POP3MsgStatus list(int paramInt)
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "LIST " + paramInt);
    POP3Response localPOP3Response = simpleCommand("LIST " + paramInt);
    if (!localPOP3Response.isOk())
    {
      Logger.log(6, "POP3Handler", "list error msgNum " + paramInt + "response:" + localPOP3Response.getData());
      return null;
    }
    if (localPOP3Response.getData() == null)
    {
      Logger.log(6, "POP3Handler", "list error msgNum " + paramInt + "response null");
      return null;
    }
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(localPOP3Response.getData());
      localPOP3MsgStatus = new POP3MsgStatus();
      try
      {
        localPOP3MsgStatus.setMsgNum(Integer.parseInt(localStringTokenizer.nextToken()));
        localPOP3MsgStatus.setSize(Long.parseLong(localStringTokenizer.nextToken()));
        return localPOP3MsgStatus;
      }
      catch (Exception localException2) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        POP3MsgStatus localPOP3MsgStatus;
        Object localObject = null;
      }
    }
    Logger.log(6, "POP3Handler", "list error msgNum " + paramInt + "response:" + localPOP3Response.getData());
    return localPOP3MsgStatus;
  }
  
  /* Error */
  public java.util.ArrayList<POP3MsgStatus> list()
    throws MessageException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_4
    //   3: ldc 17
    //   5: ldc_w 505
    //   8: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   11: new 507	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 508	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_0
    //   21: ldc_w 505
    //   24: sipush 128
    //   27: invokespecial 429	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:multilineCommand	(Ljava/lang/String;I)Lcom/tencent/moai/mailsdk/protocol/pop3/POP3Response;
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 260	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:isOk	()Z
    //   35: ifne +36 -> 71
    //   38: bipush 6
    //   40: ldc 17
    //   42: new 75	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 510
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 396	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getData	()Ljava/lang/String;
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: aload 5
    //   70: areturn
    //   71: aload_1
    //   72: invokevirtual 431	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getBytes	()Ljava/io/InputStream;
    //   75: ifnonnull +16 -> 91
    //   78: bipush 6
    //   80: ldc 17
    //   82: ldc_w 512
    //   85: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   88: aload 5
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual 431	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getBytes	()Ljava/io/InputStream;
    //   95: astore_1
    //   96: new 514	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 515	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore_3
    //   105: aload_3
    //   106: invokevirtual 516	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +134 -> 245
    //   114: new 475	java/util/StringTokenizer
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 477	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: new 479	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgStatus
    //   127: dup
    //   128: invokespecial 480	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgStatus:<init>	()V
    //   131: astore 6
    //   133: aload 6
    //   135: aload 4
    //   137: invokevirtual 483	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   140: invokestatic 489	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: invokevirtual 492	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgStatus:setMsgNum	(I)V
    //   146: aload 6
    //   148: aload 4
    //   150: invokevirtual 483	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   153: invokestatic 498	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   156: invokevirtual 502	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgStatus:setSize	(J)V
    //   159: aload 5
    //   161: aload 6
    //   163: invokevirtual 519	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: goto -62 -> 105
    //   170: astore 4
    //   172: bipush 6
    //   174: ldc 17
    //   176: new 75	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 510
    //   186: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_2
    //   190: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   199: goto -94 -> 105
    //   202: astore 4
    //   204: aload_1
    //   205: astore_2
    //   206: aload_3
    //   207: astore_1
    //   208: aload 4
    //   210: astore_3
    //   211: bipush 6
    //   213: ldc 17
    //   215: aload_3
    //   216: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   230: aload_2
    //   231: ifnull -163 -> 68
    //   234: aload_2
    //   235: invokevirtual 350	java/io/InputStream:close	()V
    //   238: aload 5
    //   240: areturn
    //   241: astore_1
    //   242: aload 5
    //   244: areturn
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   253: aload_1
    //   254: ifnull -186 -> 68
    //   257: aload_1
    //   258: invokevirtual 350	java/io/InputStream:close	()V
    //   261: aload 5
    //   263: areturn
    //   264: astore_1
    //   265: aload 5
    //   267: areturn
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_3
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_3
    //   274: ifnull +7 -> 281
    //   277: aload_3
    //   278: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   281: aload_1
    //   282: ifnull +7 -> 289
    //   285: aload_1
    //   286: invokevirtual 350	java/io/InputStream:close	()V
    //   289: aload_2
    //   290: athrow
    //   291: astore_2
    //   292: goto -39 -> 253
    //   295: astore_1
    //   296: goto -66 -> 230
    //   299: astore_3
    //   300: goto -19 -> 281
    //   303: astore_1
    //   304: goto -15 -> 289
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_3
    //   310: goto -37 -> 273
    //   313: astore_2
    //   314: goto -41 -> 273
    //   317: astore_3
    //   318: aload_2
    //   319: astore 4
    //   321: aload_3
    //   322: astore_2
    //   323: aload_1
    //   324: astore_3
    //   325: aload 4
    //   327: astore_1
    //   328: goto -55 -> 273
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -123 -> 211
    //   337: astore_3
    //   338: aconst_null
    //   339: astore 4
    //   341: aload_1
    //   342: astore_2
    //   343: aload 4
    //   345: astore_1
    //   346: goto -135 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	POP3Handler
    //   30	197	1	localObject1	Object
    //   241	17	1	localIOException1	IOException
    //   264	1	1	localIOException2	IOException
    //   272	14	1	localObject2	Object
    //   295	1	1	localIOException3	IOException
    //   303	21	1	localIOException4	IOException
    //   327	19	1	localObject3	Object
    //   1	234	2	localObject4	Object
    //   268	22	2	localObject5	Object
    //   291	1	2	localIOException5	IOException
    //   307	1	2	localObject6	Object
    //   313	6	2	localObject7	Object
    //   322	21	2	localObject8	Object
    //   104	174	3	localObject9	Object
    //   299	1	3	localIOException6	IOException
    //   309	1	3	localObject10	Object
    //   317	5	3	localObject11	Object
    //   324	1	3	localIOException7	IOException
    //   331	1	3	localIOException8	IOException
    //   337	1	3	localIOException9	IOException
    //   122	27	4	localStringTokenizer	StringTokenizer
    //   170	1	4	localException	Exception
    //   202	7	4	localIOException10	IOException
    //   319	25	4	localObject12	Object
    //   18	248	5	localArrayList	java.util.ArrayList
    //   131	31	6	localPOP3MsgStatus	POP3MsgStatus
    // Exception table:
    //   from	to	target	type
    //   114	167	170	java/lang/Exception
    //   105	110	202	java/io/IOException
    //   114	167	202	java/io/IOException
    //   172	199	202	java/io/IOException
    //   234	238	241	java/io/IOException
    //   257	261	264	java/io/IOException
    //   91	96	268	finally
    //   249	253	291	java/io/IOException
    //   226	230	295	java/io/IOException
    //   277	281	299	java/io/IOException
    //   285	289	303	java/io/IOException
    //   96	105	307	finally
    //   105	110	313	finally
    //   114	167	313	finally
    //   172	199	313	finally
    //   211	222	317	finally
    //   91	96	331	java/io/IOException
    //   96	105	337	java/io/IOException
  }
  
  public boolean noop()
    throws MessageException
  {
    boolean bool = simpleCommand("NOOP").isOk();
    Logger.log(4, "POP3Handler", "NOOP isOk:" + bool);
    return bool;
  }
  
  public void openConnection()
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "openConnection " + getTag() + ", svr:" + this.profile.getPopServer() + ", ssl:" + this.profile.isPopUsingSSL() + ", port:" + this.profile.getPopPort() + ", sslPort:" + this.profile.getPopSSLPort());
    this.isAuthenticate = false;
    POP3Response localPOP3Response;
    for (;;)
    {
      try
      {
        initSocket();
        initStream();
        localPOP3Response = readLineResponse();
        if ((localPOP3Response != null) && (localPOP3Response.isOk())) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("open connection response:");
        if (localPOP3Response == null)
        {
          String str1 = "response null";
          Logger.log(6, "POP3Handler", str1);
          if (localPOP3Response != null) {
            break label281;
          }
          str1 = "response null";
          throw new MessageException(5, str1);
        }
      }
      catch (IOException localIOException)
      {
        Logger.log(6, "POP3Handler", "open connection io exception:" + Log.getStackTraceString(localIOException));
        throw new MessageException(5, "init socket error", localIOException);
      }
      catch (Exception localException)
      {
        Logger.log(6, "POP3Handler", "open connection exception:" + Log.getStackTraceString(localException));
        throw new MessageException(5, "init socket error", localException);
      }
      String str2 = localPOP3Response.getData();
      continue;
      label281:
      str2 = localPOP3Response.getData();
    }
    if (localPOP3Response.getData() != null)
    {
      int i = localPOP3Response.getData().indexOf('<');
      int j = localPOP3Response.getData().indexOf('>', i);
      if ((i != -1) && (j != -1))
      {
        this.apopChallenge = localPOP3Response.getData().substring(i, j + 1);
        Logger.log(4, "POP3Handler", "apopChallenge:" + this.apopChallenge);
      }
    }
    setCapabilities(capa());
    this.pipelining = hasCapability("PIPELINING");
    if ((!(this.serverSocket instanceof SSLSocket)) && (hasCapability("STLS")) && (stls())) {
      setCapabilities(capa());
    }
  }
  
  public boolean quit()
    throws MessageException
  {
    boolean bool = simpleCommand("QUIT").isOk();
    Logger.log(4, "POP3Handler", "QUIT isOk:" + bool);
    return bool;
  }
  
  public MimeMessage retr(int paramInt)
    throws MessageException
  {
    j = 0;
    Logger.log(4, "POP3Handler", "RETR " + paramInt);
    Object localObject1 = simpleCommand("RETR " + paramInt);
    if (!((POP3Response)localObject1).isOk())
    {
      Logger.log(6, "POP3Handler", "retr error msgNum:" + paramInt + " response:" + ((POP3Response)localObject1).getData());
      return null;
    }
    for (;;)
    {
      try
      {
        localObject2 = new StringTokenizer(((POP3Response)localObject1).getData());
        k = Integer.parseInt(((StringTokenizer)localObject2).nextToken());
        boolean bool = ((StringTokenizer)localObject2).nextToken().equals("octets");
        i = j;
        if (bool)
        {
          i = j;
          if (k <= 1073741824)
          {
            if (k >= 0) {
              continue;
            }
            i = j;
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject2;
        int k;
        int i = j;
        continue;
      }
      ((POP3Response)localObject1).setBytes(readMultilineResponse(i));
      if (((POP3Response)localObject1).getBytes() != null) {
        continue;
      }
      Logger.log(6, "POP3Handler", "retr get bytes error msgNum:" + paramInt + " response:" + ((POP3Response)localObject1).getData());
      return null;
      i = k + 128;
    }
    localObject2 = new MimeMessage();
    try
    {
      localObject1 = ((POP3Response)localObject1).getBytes();
      ((MimeMessage)localObject2).setAvailableSize(((InputStream)localObject1).available());
      ((MimeMessage)localObject2).read((InputStream)localObject1, null);
      return localObject2;
    }
    catch (IOException localIOException)
    {
      Logger.log(6, "POP3Handler", "retr error msgNum:" + paramInt + " io:" + Log.getStackTraceString(localIOException));
      return null;
    }
  }
  
  public boolean rset()
    throws MessageException
  {
    boolean bool = simpleCommand("RSET").isOk();
    Logger.log(4, "POP3Handler", "RSET isOk:" + bool);
    return bool;
  }
  
  public POP3Status stat()
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "STAT");
    POP3Response localPOP3Response = simpleCommand("STAT");
    if (!localPOP3Response.isOk())
    {
      Logger.log(6, "POP3Handler", "stat error response:" + localPOP3Response.getData());
      return null;
    }
    if (localPOP3Response.getData() == null)
    {
      Logger.log(6, "POP3Handler", "stat error response null");
      return null;
    }
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(localPOP3Response.getData());
      localPOP3Status = new POP3Status();
      try
      {
        localPOP3Status.setMsgCount(Integer.parseInt(localStringTokenizer.nextToken()));
        localPOP3Status.setMsgSize(Long.parseLong(localStringTokenizer.nextToken()));
        return localPOP3Status;
      }
      catch (Exception localException2) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        POP3Status localPOP3Status;
        Object localObject = null;
      }
    }
    Logger.log(6, "POP3Handler", "stat error response:" + localPOP3Response.getData());
    return localPOP3Status;
  }
  
  public boolean stls()
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "STLS");
    POP3Response localPOP3Response2 = simpleCommand("STLS");
    POP3Response localPOP3Response1 = localPOP3Response2;
    if (localPOP3Response2.isOk()) {}
    try
    {
      initSSLSocket();
      initStream();
      localPOP3Response1 = localPOP3Response2;
      return localPOP3Response1.isOk();
    }
    catch (IOException localIOException1)
    {
      Logger.log(6, "POP3Handler", "create ssl socket fail after tls:" + Log.getStackTraceString(localIOException1));
      closeConnection();
    }
    for (;;)
    {
      try
      {
        initNormalSocket();
        initStream();
        localPOP3Response2 = readLineResponse();
        Object localObject;
        if (localPOP3Response2 != null)
        {
          localObject = localPOP3Response2;
          if (localPOP3Response2.isOk()) {
            break;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder().append("open connection response:");
        if (localPOP3Response2 == null)
        {
          localObject = "response null";
          Logger.log(6, "POP3Handler", (String)localObject);
          if (localPOP3Response2 != null) {
            break label213;
          }
          localObject = "response null";
          throw new MessageException(5, (String)localObject);
        }
      }
      catch (IOException localIOException2)
      {
        Logger.log(6, "POP3Handler", "create normal ssl socket fail:" + Log.getStackTraceString(localIOException2));
        closeConnection();
        throw new MessageException(5, "init socket error", localIOException2);
      }
      String str = localPOP3Response2.getData();
      continue;
      label213:
      str = localPOP3Response2.getData();
    }
  }
  
  public MimeMessage top(int paramInt1, int paramInt2)
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "TOP " + paramInt1 + " " + paramInt2);
    Object localObject = multilineCommand("TOP " + paramInt1 + " " + paramInt2, 0);
    if (!((POP3Response)localObject).isOk())
    {
      Logger.log(6, "POP3Handler", "top error msgNum:" + paramInt1 + " line:" + paramInt2 + " response:" + ((POP3Response)localObject).getData());
      return null;
    }
    if (((POP3Response)localObject).getBytes() == null)
    {
      Logger.log(6, "POP3Handler", "top error msgNum:" + paramInt1 + " line:" + paramInt2 + " response null");
      return null;
    }
    MimeMessage localMimeMessage = new MimeMessage();
    try
    {
      localObject = ((POP3Response)localObject).getBytes();
      localMimeMessage.setAvailableSize(((InputStream)localObject).available());
      localMimeMessage.read((InputStream)localObject, null);
      return localMimeMessage;
    }
    catch (IOException localIOException)
    {
      Logger.log(6, "POP3Handler", "top error msgNum:" + paramInt1 + " io:" + Log.getStackTraceString(localIOException));
    }
    return null;
  }
  
  public POP3MsgUID uidl(int paramInt)
    throws MessageException
  {
    Logger.log(4, "POP3Handler", "UIDL " + paramInt);
    POP3Response localPOP3Response = simpleCommand("UIDL " + paramInt);
    if (!localPOP3Response.isOk())
    {
      Logger.log(6, "POP3Handler", "uidl error msgNum " + paramInt + "response:" + localPOP3Response.getData());
      return null;
    }
    if (localPOP3Response.getData() == null)
    {
      Logger.log(6, "POP3Handler", "list error msgNum " + paramInt + "response null");
      return null;
    }
    try
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(localPOP3Response.getData());
      localPOP3MsgUID = new POP3MsgUID();
      try
      {
        localPOP3MsgUID.setMsgNum(Integer.parseInt(localStringTokenizer.nextToken()));
        localPOP3MsgUID.setUid(localStringTokenizer.nextToken());
        return localPOP3MsgUID;
      }
      catch (Exception localException2) {}
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        POP3MsgUID localPOP3MsgUID;
        Object localObject = null;
      }
    }
    Logger.log(6, "POP3Handler", "uidl error msgNum " + paramInt + "response:" + localPOP3Response.getData());
    return localPOP3MsgUID;
  }
  
  /* Error */
  public java.util.ArrayList<POP3MsgUID> uidl()
    throws MessageException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: iconst_4
    //   3: ldc 17
    //   5: ldc_w 659
    //   8: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   11: new 507	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 508	java/util/ArrayList:<init>	()V
    //   18: astore 5
    //   20: aload_0
    //   21: ldc_w 659
    //   24: sipush 128
    //   27: invokespecial 429	com/tencent/moai/mailsdk/protocol/pop3/POP3Handler:multilineCommand	(Ljava/lang/String;I)Lcom/tencent/moai/mailsdk/protocol/pop3/POP3Response;
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 260	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:isOk	()Z
    //   35: ifne +36 -> 71
    //   38: bipush 6
    //   40: ldc 17
    //   42: new 75	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 661
    //   52: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_1
    //   56: invokevirtual 396	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getData	()Ljava/lang/String;
    //   59: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   68: aload 5
    //   70: areturn
    //   71: aload_1
    //   72: invokevirtual 431	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getBytes	()Ljava/io/InputStream;
    //   75: ifnonnull +16 -> 91
    //   78: bipush 6
    //   80: ldc 17
    //   82: ldc_w 663
    //   85: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   88: aload 5
    //   90: areturn
    //   91: aload_1
    //   92: invokevirtual 431	com/tencent/moai/mailsdk/protocol/pop3/POP3Response:getBytes	()Ljava/io/InputStream;
    //   95: astore_1
    //   96: new 514	com/tencent/moai/mailsdk/util/stream/LineInputStream
    //   99: dup
    //   100: aload_1
    //   101: invokespecial 515	com/tencent/moai/mailsdk/util/stream/LineInputStream:<init>	(Ljava/io/InputStream;)V
    //   104: astore_3
    //   105: aload_3
    //   106: invokevirtual 516	com/tencent/moai/mailsdk/util/stream/LineInputStream:readLine	()Ljava/lang/String;
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +131 -> 242
    //   114: new 475	java/util/StringTokenizer
    //   117: dup
    //   118: aload_2
    //   119: invokespecial 477	java/util/StringTokenizer:<init>	(Ljava/lang/String;)V
    //   122: astore 4
    //   124: new 652	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgUID
    //   127: dup
    //   128: invokespecial 653	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgUID:<init>	()V
    //   131: astore 6
    //   133: aload 6
    //   135: aload 4
    //   137: invokevirtual 483	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   140: invokestatic 489	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: invokevirtual 654	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgUID:setMsgNum	(I)V
    //   146: aload 6
    //   148: aload 4
    //   150: invokevirtual 483	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   153: invokevirtual 657	com/tencent/moai/mailsdk/protocol/pop3/POP3MsgUID:setUid	(Ljava/lang/String;)V
    //   156: aload 5
    //   158: aload 6
    //   160: invokevirtual 519	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   163: pop
    //   164: goto -59 -> 105
    //   167: astore 4
    //   169: bipush 6
    //   171: ldc 17
    //   173: new 75	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 661
    //   183: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_2
    //   187: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   196: goto -91 -> 105
    //   199: astore 4
    //   201: aload_1
    //   202: astore_2
    //   203: aload_3
    //   204: astore_1
    //   205: aload 4
    //   207: astore_3
    //   208: bipush 6
    //   210: ldc 17
    //   212: aload_3
    //   213: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   216: invokestatic 304	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   219: aload_1
    //   220: ifnull +7 -> 227
    //   223: aload_1
    //   224: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   227: aload_2
    //   228: ifnull -160 -> 68
    //   231: aload_2
    //   232: invokevirtual 350	java/io/InputStream:close	()V
    //   235: aload 5
    //   237: areturn
    //   238: astore_1
    //   239: aload 5
    //   241: areturn
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   250: aload_1
    //   251: ifnull -183 -> 68
    //   254: aload_1
    //   255: invokevirtual 350	java/io/InputStream:close	()V
    //   258: aload 5
    //   260: areturn
    //   261: astore_1
    //   262: aload 5
    //   264: areturn
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_3
    //   268: aconst_null
    //   269: astore_1
    //   270: aload_3
    //   271: ifnull +7 -> 278
    //   274: aload_3
    //   275: invokevirtual 520	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   278: aload_1
    //   279: ifnull +7 -> 286
    //   282: aload_1
    //   283: invokevirtual 350	java/io/InputStream:close	()V
    //   286: aload_2
    //   287: athrow
    //   288: astore_2
    //   289: goto -39 -> 250
    //   292: astore_1
    //   293: goto -66 -> 227
    //   296: astore_3
    //   297: goto -19 -> 278
    //   300: astore_1
    //   301: goto -15 -> 286
    //   304: astore_2
    //   305: aconst_null
    //   306: astore_3
    //   307: goto -37 -> 270
    //   310: astore_2
    //   311: goto -41 -> 270
    //   314: astore_3
    //   315: aload_2
    //   316: astore 4
    //   318: aload_3
    //   319: astore_2
    //   320: aload_1
    //   321: astore_3
    //   322: aload 4
    //   324: astore_1
    //   325: goto -55 -> 270
    //   328: astore_3
    //   329: aconst_null
    //   330: astore_1
    //   331: goto -123 -> 208
    //   334: astore_3
    //   335: aconst_null
    //   336: astore 4
    //   338: aload_1
    //   339: astore_2
    //   340: aload 4
    //   342: astore_1
    //   343: goto -135 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	POP3Handler
    //   30	194	1	localObject1	Object
    //   238	17	1	localIOException1	IOException
    //   261	1	1	localIOException2	IOException
    //   269	14	1	localObject2	Object
    //   292	1	1	localIOException3	IOException
    //   300	21	1	localIOException4	IOException
    //   324	19	1	localObject3	Object
    //   1	231	2	localObject4	Object
    //   265	22	2	localObject5	Object
    //   288	1	2	localIOException5	IOException
    //   304	1	2	localObject6	Object
    //   310	6	2	localObject7	Object
    //   319	21	2	localObject8	Object
    //   104	171	3	localObject9	Object
    //   296	1	3	localIOException6	IOException
    //   306	1	3	localObject10	Object
    //   314	5	3	localObject11	Object
    //   321	1	3	localIOException7	IOException
    //   328	1	3	localIOException8	IOException
    //   334	1	3	localIOException9	IOException
    //   122	27	4	localStringTokenizer	StringTokenizer
    //   167	1	4	localException	Exception
    //   199	7	4	localIOException10	IOException
    //   316	25	4	localObject12	Object
    //   18	245	5	localArrayList	java.util.ArrayList
    //   131	28	6	localPOP3MsgUID	POP3MsgUID
    // Exception table:
    //   from	to	target	type
    //   114	164	167	java/lang/Exception
    //   105	110	199	java/io/IOException
    //   114	164	199	java/io/IOException
    //   169	196	199	java/io/IOException
    //   231	235	238	java/io/IOException
    //   254	258	261	java/io/IOException
    //   91	96	265	finally
    //   246	250	288	java/io/IOException
    //   223	227	292	java/io/IOException
    //   274	278	296	java/io/IOException
    //   282	286	300	java/io/IOException
    //   96	105	304	finally
    //   105	110	310	finally
    //   114	164	310	finally
    //   169	196	310	finally
    //   208	219	314	finally
    //   91	96	328	java/io/IOException
    //   96	105	334	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.pop3.POP3Handler
 * JD-Core Version:    0.7.0.1
 */