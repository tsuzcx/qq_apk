package com.tencent.moai.mailsdk.protocol.imap;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.moai.mailsdk.exception.MessageException;
import com.tencent.moai.mailsdk.model.Profile;
import com.tencent.moai.mailsdk.net.SocketFetcher;
import com.tencent.moai.mailsdk.protocol.auth.NtlmV2;
import com.tencent.moai.mailsdk.protocol.imap.model.ByteArray;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPAppendUID;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPArgument;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPAttach;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBody;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPBodyStructure;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPContent;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPFetchResponse;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPFlags;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPFolder;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailBoxStatus;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPMailboxInfo;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPRFC822Size;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPResponse;
import com.tencent.moai.mailsdk.protocol.imap.model.IMAPUid;
import com.tencent.moai.mailsdk.protocol.imap.util.IMAPBodyStructureUtil;
import com.tencent.moai.mailsdk.protocol.mime.AttachListener;
import com.tencent.moai.mailsdk.protocol.mime.MimeDefine;
import com.tencent.moai.mailsdk.protocol.mime.model.MimeHeader;
import com.tencent.moai.mailsdk.protocol.model.Flags;
import com.tencent.moai.mailsdk.task.BaseHandler;
import com.tencent.moai.mailsdk.util.ASCIIUtility;
import com.tencent.moai.mailsdk.util.FileUtility;
import com.tencent.moai.mailsdk.util.MimeUtility;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.moai.mailsdk.util.StringUtility;
import com.tencent.moai.mailsdk.util.log.Logger;
import com.tencent.moai.mailsdk.util.stream.BASE64DecoderStream;
import com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream;
import com.tencent.moai.mailsdk.util.stream.LineInputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLSocket;
import moai.oss.OssHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class IMAPHandler
  extends BaseHandler
{
  private static final String CAPABILITY_IMAP4_SUN_VERSION = "IMAP4SUNVERSION";
  private static final String CAPABILITY_LOGIN_DISABLED = "LOGINDISABLED";
  private static final String CAPABILITY_SASL_IR = "SASL-IR";
  private static final String TAG = "IMAPHandler";
  public static final char TAG_PREFIX = 'A';
  private static final ArrayList<String> unSupportSearchLatestDomain = new ArrayList();
  private ArrayList<String> authmechs;
  private Map<String, String> capabilities;
  private boolean isAuthenticate;
  private LineInputStream lineInputStream;
  private String localHostName;
  private Profile profile;
  private boolean rev1 = false;
  private InputStream serverInput;
  private OutputStream serverOutput;
  private Socket serverSocket;
  private String tag = "";
  private int tagCounter = 0;
  private HashMap<String, Boolean> unSupportSearchLatestMap = new HashMap();
  
  static
  {
    unSupportSearchLatestDomain.add("139.com");
    unSupportSearchLatestDomain.add("icloud.com");
    unSupportSearchLatestDomain.add("hotmail.com");
    unSupportSearchLatestDomain.add("msn.com");
    unSupportSearchLatestDomain.add("outlook.com");
    unSupportSearchLatestDomain.add("live.com");
    unSupportSearchLatestDomain.add("live.cn");
  }
  
  public IMAPHandler(Profile paramProfile)
  {
    this.profile = paramProfile;
  }
  
  private ArrayList<IMAPFolder> doList(String paramString1, String paramString2, String paramString3)
    throws MessageException
  {
    String str = paramString2;
    if (StringUtility.isNullOrEmpty(paramString2)) {
      str = "\"\"";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "*";
    }
    paramString3 = new IMAPArgument();
    paramString3.writeAtom(str);
    paramString3.writeAtom(paramString2);
    Logger.log(4, "IMAPHandler", paramString1 + " " + paramString3);
    paramString1 = simpleCommand(paramString1, paramString3);
    paramString2 = new ArrayList();
    if ((paramString1.size() > 1) && (handleResult((IMAPResponse)paramString1.get(paramString1.size() - 1)))) {
      return IMAPFolder.parseFolderList(paramString1, this.profile);
    }
    return paramString2;
  }
  
  private IMAPMailboxInfo doSelect(String paramString1, String paramString2)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString2);
    Logger.log(4, "IMAPHandler", paramString1 + " " + localIMAPArgument);
    paramString1 = simpleCommand(paramString1, localIMAPArgument);
    if ((paramString1.size() > 0) && (handleResult((IMAPResponse)paramString1.get(paramString1.size() - 1)))) {
      return new IMAPMailboxInfo(paramString1);
    }
    return null;
  }
  
  private void fetchFlagsAndSize(ArrayList<String> paramArrayList, HashMap<String, IMAPFlags> paramHashMap, HashMap<String, Long> paramHashMap1, String paramString)
    throws MessageException
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      Object localObject1 = new IMAPArgument();
      ((IMAPArgument)localObject1).writeAtomString(getUidSeqStr(paramArrayList));
      ((IMAPArgument)localObject1).writeAtomString(paramString);
      Logger.log(4, "IMAPHandler", "UID FETCH " + localObject1);
      writeCommand("UID FETCH", (IMAPArgument)localObject1);
      paramArrayList = readMultiFetchResponse();
      if (paramArrayList.size() > 0)
      {
        if (paramArrayList.size() == 1) {
          Logger.osslog(new Object[] { "fetch_flag_size_empty", localObject1 + " " + ((IMAPResponse)paramArrayList.get(0)).getContent() });
        }
        if (handleResult((IMAPResponse)paramArrayList.get(paramArrayList.size() - 1)))
        {
          int i = 0;
          while (i < paramArrayList.size() - 1)
          {
            paramString = (IMAPResponse)paramArrayList.get(i);
            try
            {
              Object localObject2 = new IMAPFetchResponse(paramString);
              localObject1 = (IMAPUid)((IMAPFetchResponse)localObject2).getItem(IMAPUid.class);
              IMAPFlags localIMAPFlags = (IMAPFlags)((IMAPFetchResponse)localObject2).getItem(IMAPFlags.class);
              localObject2 = (IMAPRFC822Size)((IMAPFetchResponse)localObject2).getItem(IMAPRFC822Size.class);
              if (localObject1 != null)
              {
                if ((localIMAPFlags != null) && (paramHashMap != null)) {
                  paramHashMap.put(((IMAPUid)localObject1).getUid(), localIMAPFlags);
                }
                if ((localObject2 != null) && (paramHashMap1 != null)) {
                  paramHashMap1.put(((IMAPUid)localObject1).getUid(), Long.valueOf(((IMAPRFC822Size)localObject2).getSize()));
                }
              }
            }
            catch (MessageException localMessageException)
            {
              for (;;)
              {
                Logger.log(6, "IMAPHandler", "read size or flag error:" + paramString.getContent());
              }
            }
            i += 1;
          }
        }
      }
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
        Logger.log(6, "IMAPHandler", Log.getStackTraceString(localUnknownHostException));
      }
      if ((this.serverSocket != null) && (this.serverSocket.isBound()))
      {
        InetAddress localInetAddress = this.serverSocket.getLocalAddress();
        this.localHostName = localInetAddress.getCanonicalHostName();
        if (this.localHostName == null) {
          this.localHostName = ("[" + localInetAddress.getHostAddress() + "]");
        }
      }
      Logger.log(4, "IMAPHandler", "getLocalHost:" + this.localHostName);
    }
    return this.localHostName;
  }
  
  private boolean handleResult(IMAPResponse paramIMAPResponse)
    throws MessageException
  {
    if (paramIMAPResponse == null) {
      Logger.log(6, "IMAPHandler", "response is null");
    }
    do
    {
      return false;
      if (paramIMAPResponse.isOK()) {
        return true;
      }
      if (paramIMAPResponse.isNO())
      {
        Logger.log(6, "IMAPHandler", "response is no:" + paramIMAPResponse.getContent());
        return false;
      }
      if (paramIMAPResponse.isBAD())
      {
        Logger.log(6, "IMAPHandler", "response is bad:" + paramIMAPResponse.getContent());
        return false;
      }
    } while (!paramIMAPResponse.isBYE());
    Logger.log(6, "IMAPHandler", "response is bye:" + paramIMAPResponse.getContent());
    closeConnection();
    Logger.log(6, "IMAPHandler", "response is bye:" + paramIMAPResponse.getContent());
    throw new MessageException(16, paramIMAPResponse.getContent());
  }
  
  private boolean hasCapability(String paramString)
  {
    if (paramString.endsWith("*"))
    {
      paramString = paramString.substring(0, paramString.length() - 1).toUpperCase(Locale.ENGLISH);
      Iterator localIterator = this.capabilities.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).startsWith(paramString)) {
          return true;
        }
      }
      return false;
    }
    return this.capabilities.containsKey(paramString.toUpperCase(Locale.ENGLISH));
  }
  
  private void initNormalSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSocket(this.profile.getImapServer(), this.profile.getImapPort(), this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
  }
  
  private void initSSLSocket()
    throws IOException
  {
    this.serverSocket = SocketFetcher.getSSLSocket(this.serverSocket);
  }
  
  private void initSocket()
    throws IOException
  {
    String str = this.profile.getImapServer();
    boolean bool = this.profile.isImapUsingSSL();
    int i;
    if ((this.profile.getImapPort() == 0) || (this.profile.getImapPort() == 993))
    {
      i = 143;
      if ((this.profile.getImapSSLPort() != 0) && (this.profile.getImapSSLPort() != 143)) {
        break label123;
      }
    }
    label123:
    for (int j = 993;; j = this.profile.getImapSSLPort())
    {
      this.serverSocket = SocketFetcher.createSocket(str, bool, i, j, this.profile.getProxyServer(), this.profile.getProxyPort(), this.profile.getProxyUserName(), this.profile.getProxyPassword());
      return;
      i = this.profile.getImapPort();
      break;
    }
  }
  
  private void initStream()
    throws IOException
  {
    this.serverOutput = new BufferedOutputStream(this.serverSocket.getOutputStream());
    this.serverInput = new BufferedInputStream(this.serverSocket.getInputStream());
    this.lineInputStream = new LineInputStream(this.serverInput);
  }
  
  private boolean judgeResponseSupport(IMAPResponse paramIMAPResponse)
  {
    if (paramIMAPResponse.isBAD()) {}
    while ((paramIMAPResponse.isNO()) && (!paramIMAPResponse.getContent().toLowerCase().contains("internal"))) {
      return false;
    }
    return true;
  }
  
  private void parseCapabilities(IMAPResponse paramIMAPResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      String str = paramIMAPResponse.readAtom();
      if (str != null)
      {
        if (str.length() != 0) {
          break label96;
        }
        if (paramIMAPResponse.peekByte() != 93) {}
      }
      else
      {
        if (this.capabilities.containsKey("AUTH-LOGIN")) {
          this.authmechs.add("LOGIN");
        }
        Logger.log(4, "IMAPHandler", "set capability:" + localStringBuilder.toString());
        return;
      }
      paramIMAPResponse.skipSpaces();
      continue;
      label96:
      this.capabilities.put(str.toUpperCase(Locale.ENGLISH), str);
      localStringBuilder.append(str + " ");
      if (str.regionMatches(true, 0, "AUTH=", 0, 5)) {
        this.authmechs.add(str.substring(5));
      }
    }
  }
  
  private ArrayList<IMAPResponse> readFetchResponse()
    throws MessageException
  {
    int j = 0;
    localArrayList = new ArrayList();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.lineInputStream.readLine();
      Object localObject2;
      int i;
      if ((localObject1 != null) && (((String)localObject1).startsWith("*")))
      {
        localObject2 = new IMAPResponse((String)localObject1);
        i = j;
        if (((IMAPResponse)localObject2).getKey() != null)
        {
          i = j;
          if (((IMAPResponse)localObject2).getKey().toUpperCase().equals("FETCH"))
          {
            label80:
            if (!((String)localObject1).startsWith(this.tag)) {
              break label165;
            }
            if (localStringBuilder.length() > 0)
            {
              localArrayList.add(new IMAPResponse(localStringBuilder.toString()));
              localStringBuilder.setLength(0);
            }
            localArrayList.add(new IMAPResponse((String)localObject1));
            i = 1;
          }
        }
      }
      for (;;)
      {
        if (i != 0) {
          break label255;
        }
        localObject2 = this.lineInputStream.readLine();
        j = i;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return localArrayList;
        label165:
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(MimeDefine.CRLF);
        localObject2 = this.lineInputStream.readLine();
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label80;
        }
        i = j;
        continue;
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((String)localObject1).startsWith(this.tag))
          {
            localArrayList.add(new IMAPResponse((String)localObject1));
            i = 1;
          }
        }
      }
      return localArrayList;
    }
    catch (IOException localIOException)
    {
      throw new MessageException(3, "read response error", localIOException);
    }
  }
  
  private IMAPResponse readLineResponse()
    throws MessageException
  {
    IMAPResponse localIMAPResponse = null;
    try
    {
      String str = this.lineInputStream.readLine();
      if (str != null) {
        localIMAPResponse = new IMAPResponse(str);
      }
      return localIMAPResponse;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      throw new MessageException(13, "read timeout", localSocketTimeoutException);
    }
    catch (IOException localIOException)
    {
      throw new MessageException(3, "read response error", localIOException);
    }
  }
  
  private ArrayList<IMAPResponse> readMultiFetchResponse()
    throws MessageException
  {
    int i = 0;
    localArrayList = new ArrayList();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = this.lineInputStream.readLine();
      int j = i;
      Object localObject2;
      if (localObject1 != null)
      {
        if (!((String)localObject1).startsWith("*")) {
          break label158;
        }
        localObject2 = new IMAPResponse((String)localObject1);
        j = i;
        if (((IMAPResponse)localObject2).getKey() != null)
        {
          j = i;
          if (((IMAPResponse)localObject2).getKey().toUpperCase().equals("FETCH"))
          {
            if (localStringBuilder.length() > 0)
            {
              localArrayList.add(new IMAPResponse(localStringBuilder.toString()));
              localStringBuilder.setLength(0);
            }
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(MimeDefine.CRLF);
            j = i;
          }
        }
      }
      for (;;)
      {
        if (j != 0) {
          break label236;
        }
        localObject2 = this.lineInputStream.readLine();
        i = j;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        return localArrayList;
        label158:
        j = i;
        if (((String)localObject1).startsWith(this.tag))
        {
          if (localStringBuilder.length() > 0)
          {
            localArrayList.add(new IMAPResponse(localStringBuilder.toString()));
            localStringBuilder.setLength(0);
          }
          localArrayList.add(new IMAPResponse((String)localObject1));
          j = 1;
        }
      }
      return localArrayList;
    }
    catch (IOException localIOException)
    {
      throw new MessageException(3, "read response error", localIOException);
    }
  }
  
  private ArrayList<IMAPResponse> readResponseList()
    throws MessageException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject = null;
    for (;;)
    {
      IMAPResponse localIMAPResponse;
      if (i == 0)
      {
        localIMAPResponse = readLineResponse();
        if (localIMAPResponse != null) {}
      }
      else
      {
        if (localObject != null) {
          localArrayList.add(localObject);
        }
        return localArrayList;
      }
      if (localIMAPResponse.isBYE())
      {
        localObject = localIMAPResponse;
        i = 1;
      }
      else
      {
        localArrayList.add(localIMAPResponse);
        if ((localIMAPResponse.isTagged()) && (localIMAPResponse.getTag().equals(this.tag))) {
          i = 1;
        }
      }
    }
  }
  
  private IMAPResponse readStreamResponse()
    throws MessageException
  {
    return new IMAPResponse(this.serverInput);
  }
  
  private ArrayList<IMAPResponse> simpleCommand(String paramString, IMAPArgument paramIMAPArgument)
    throws MessageException
  {
    writeCommand(paramString, paramIMAPArgument);
    return readResponseList();
  }
  
  private boolean simpleCommandResult(String paramString, IMAPArgument paramIMAPArgument)
    throws MessageException
  {
    paramString = simpleCommand(paramString, paramIMAPArgument);
    if (paramString.size() > 0) {
      return handleResult((IMAPResponse)paramString.get(paramString.size() - 1));
    }
    return false;
  }
  
  private boolean store(String paramString, Flags paramFlags, boolean paramBoolean1, boolean paramBoolean2)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeAtomString(paramString);
    if (paramBoolean1)
    {
      paramString = "+FLAGS";
      localIMAPArgument.writeAtomString(paramString);
      localIMAPArgument.writeAtomString(paramFlags.toString());
      if (!paramBoolean2) {
        break label92;
      }
    }
    label92:
    for (paramString = "UID STORE";; paramString = "STORE")
    {
      Logger.log(4, "IMAPHandler", paramString + " " + localIMAPArgument);
      return simpleCommandResult(paramString, localIMAPArgument);
      paramString = "-FLAGS";
      break;
    }
  }
  
  private void writeCommand(String paramString, IMAPArgument paramIMAPArgument)
    throws MessageException
  {
    try
    {
      Object localObject = new StringBuilder().append('A');
      int i = this.tagCounter;
      this.tagCounter = (i + 1);
      this.tag = Integer.toString(i, 10);
      localObject = this.tag + " " + paramString;
      paramString = (String)localObject;
      if (paramIMAPArgument != null) {
        paramString = (String)localObject + " ";
      }
      if (this.serverOutput == null) {
        return;
      }
      this.serverOutput.write(ASCIIUtility.getBytes(paramString));
      if (paramIMAPArgument != null) {
        paramIMAPArgument.write(this.serverOutput);
      }
      this.serverOutput.write(MimeDefine.CRLF.getBytes());
      this.serverOutput.flush();
      return;
    }
    catch (IOException paramString)
    {
      throw new MessageException(3, "write command error", paramString);
    }
  }
  
  public IMAPAppendUID append(String paramString, String[] paramArrayOfString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localIMAPArgument.writeAtom(paramArrayOfString[i]);
      i += 1;
    }
    Logger.log(4, "IMAPHandler", "APPEND " + localIMAPArgument);
    paramString = simpleCommand("APPEND", localIMAPArgument);
    if (paramString.size() > 1)
    {
      paramString = (IMAPResponse)paramString.get(paramString.size() - 1);
      if (handleResult(paramString)) {
        return new IMAPAppendUID(paramString);
      }
    }
    return null;
  }
  
  /* Error */
  public boolean append(String paramString1, String paramString2, Flags paramFlags)
    throws MessageException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iload 6
    //   5: istore 5
    //   7: aload_1
    //   8: invokestatic 102	com/tencent/moai/mailsdk/util/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   11: ifne +14 -> 25
    //   14: aload_2
    //   15: invokestatic 102	com/tencent/moai/mailsdk/util/StringUtility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   18: ifeq +10 -> 28
    //   21: iload 6
    //   23: istore 5
    //   25: iload 5
    //   27: ireturn
    //   28: new 579	java/io/File
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 580	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 7
    //   38: new 108	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument
    //   41: dup
    //   42: invokespecial 109	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument:<init>	()V
    //   45: astore 8
    //   47: aload 8
    //   49: aload_2
    //   50: invokevirtual 181	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument:writeAtomString	(Ljava/lang/String;)V
    //   53: aload_3
    //   54: ifnull +12 -> 66
    //   57: aload 8
    //   59: aload_3
    //   60: invokevirtual 529	com/tencent/moai/mailsdk/protocol/model/Flags:toString	()Ljava/lang/String;
    //   63: invokevirtual 113	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument:writeAtom	(Ljava/lang/String;)V
    //   66: aload 8
    //   68: new 115	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 582
    //   78: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 7
    //   83: invokevirtual 584	java/io/File:length	()J
    //   86: invokevirtual 587	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: ldc_w 589
    //   92: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 181	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument:writeAtomString	(Ljava/lang/String;)V
    //   101: iconst_4
    //   102: ldc 17
    //   104: new 115	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 591
    //   114: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 8
    //   119: invokevirtual 592	com/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument:toString	()Ljava/lang/String;
    //   122: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: ldc_w 571
    //   135: aload 8
    //   137: invokespecial 189	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:writeCommand	(Ljava/lang/String;Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPArgument;)V
    //   140: aload_0
    //   141: invokespecial 509	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:readLineResponse	()Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;
    //   144: astore_2
    //   145: aload_2
    //   146: ifnonnull +27 -> 173
    //   149: aload_1
    //   150: invokestatic 597	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   153: pop
    //   154: iload 6
    //   156: istore 5
    //   158: iconst_0
    //   159: ifeq -134 -> 25
    //   162: new 599	java/lang/NullPointerException
    //   165: dup
    //   166: invokespecial 600	java/lang/NullPointerException:<init>	()V
    //   169: athrow
    //   170: astore_1
    //   171: iconst_0
    //   172: ireturn
    //   173: aload_2
    //   174: invokevirtual 603	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse:isContinuation	()Z
    //   177: ifeq +207 -> 384
    //   180: new 605	java/io/FileInputStream
    //   183: dup
    //   184: aload 7
    //   186: invokespecial 608	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: astore_3
    //   190: aload_3
    //   191: astore_2
    //   192: sipush 1024
    //   195: newarray byte
    //   197: astore 7
    //   199: aload_3
    //   200: astore_2
    //   201: aload_3
    //   202: aload 7
    //   204: invokevirtual 614	java/io/InputStream:read	([B)I
    //   207: istore 4
    //   209: iload 4
    //   211: ifle +51 -> 262
    //   214: aload_3
    //   215: astore_2
    //   216: aload_0
    //   217: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   220: aload 7
    //   222: iconst_0
    //   223: iload 4
    //   225: invokevirtual 617	java/io/OutputStream:write	([BII)V
    //   228: goto -29 -> 199
    //   231: astore 7
    //   233: aload_3
    //   234: astore_2
    //   235: aload 7
    //   237: astore_3
    //   238: aload_3
    //   239: athrow
    //   240: astore 7
    //   242: aload_2
    //   243: astore_3
    //   244: aload 7
    //   246: astore_2
    //   247: aload_1
    //   248: invokestatic 597	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   251: pop
    //   252: aload_3
    //   253: ifnull +7 -> 260
    //   256: aload_3
    //   257: invokevirtual 620	java/io/InputStream:close	()V
    //   260: aload_2
    //   261: athrow
    //   262: aload_3
    //   263: astore_2
    //   264: aload_0
    //   265: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   268: ldc_w 622
    //   271: invokevirtual 561	java/lang/String:getBytes	()[B
    //   274: invokevirtual 556	java/io/OutputStream:write	([B)V
    //   277: aload_3
    //   278: astore_2
    //   279: aload_0
    //   280: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   283: ldc_w 622
    //   286: invokevirtual 561	java/lang/String:getBytes	()[B
    //   289: invokevirtual 556	java/io/OutputStream:write	([B)V
    //   292: aload_3
    //   293: astore_2
    //   294: aload_0
    //   295: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   298: ldc_w 622
    //   301: invokevirtual 561	java/lang/String:getBytes	()[B
    //   304: invokevirtual 556	java/io/OutputStream:write	([B)V
    //   307: aload_3
    //   308: astore_2
    //   309: aload_0
    //   310: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   313: invokevirtual 564	java/io/OutputStream:flush	()V
    //   316: aload_3
    //   317: astore_2
    //   318: aload_0
    //   319: invokespecial 519	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:readResponseList	()Ljava/util/ArrayList;
    //   322: astore 8
    //   324: aload_3
    //   325: astore_2
    //   326: aload_3
    //   327: astore 7
    //   329: aload 8
    //   331: invokevirtual 143	java/util/ArrayList:size	()I
    //   334: ifle +53 -> 387
    //   337: aload_3
    //   338: astore_2
    //   339: aload_0
    //   340: aload 8
    //   342: aload 8
    //   344: invokevirtual 143	java/util/ArrayList:size	()I
    //   347: iconst_1
    //   348: isub
    //   349: invokevirtual 147	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   352: checkcast 149	com/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse
    //   355: invokespecial 153	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:handleResult	(Lcom/tencent/moai/mailsdk/protocol/imap/model/IMAPResponse;)Z
    //   358: istore 6
    //   360: aload_1
    //   361: invokestatic 597	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   364: pop
    //   365: iload 6
    //   367: istore 5
    //   369: aload_3
    //   370: ifnull -345 -> 25
    //   373: aload_3
    //   374: invokevirtual 620	java/io/InputStream:close	()V
    //   377: iload 6
    //   379: ireturn
    //   380: astore_1
    //   381: iload 6
    //   383: ireturn
    //   384: aconst_null
    //   385: astore 7
    //   387: aload_1
    //   388: invokestatic 597	com/tencent/moai/mailsdk/util/FileUtility:deleteFile	(Ljava/lang/String;)Z
    //   391: pop
    //   392: iload 6
    //   394: istore 5
    //   396: aload 7
    //   398: ifnull -373 -> 25
    //   401: aload 7
    //   403: invokevirtual 620	java/io/InputStream:close	()V
    //   406: iconst_0
    //   407: ireturn
    //   408: astore_1
    //   409: iconst_0
    //   410: ireturn
    //   411: astore 7
    //   413: aconst_null
    //   414: astore_2
    //   415: new 96	com/tencent/moai/mailsdk/exception/MessageException
    //   418: dup
    //   419: iconst_3
    //   420: ldc_w 623
    //   423: aload 7
    //   425: invokevirtual 626	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   428: aload 7
    //   430: invokespecial 629	com/tencent/moai/mailsdk/exception/MessageException:<init>	(IILjava/lang/String;Ljava/lang/Throwable;)V
    //   433: athrow
    //   434: astore_1
    //   435: goto -175 -> 260
    //   438: astore_2
    //   439: aconst_null
    //   440: astore_3
    //   441: goto -194 -> 247
    //   444: astore 7
    //   446: aload_3
    //   447: astore_2
    //   448: goto -33 -> 415
    //   451: astore_3
    //   452: aconst_null
    //   453: astore_2
    //   454: goto -216 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	this	IMAPHandler
    //   0	457	1	paramString1	String
    //   0	457	2	paramString2	String
    //   0	457	3	paramFlags	Flags
    //   207	17	4	i	int
    //   5	390	5	bool1	boolean
    //   1	392	6	bool2	boolean
    //   36	185	7	localObject1	Object
    //   231	5	7	localMessageException	MessageException
    //   240	5	7	localObject2	Object
    //   327	75	7	localFlags	Flags
    //   411	18	7	localException1	Exception
    //   444	1	7	localException2	Exception
    //   45	298	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   149	154	170	java/io/IOException
    //   162	170	170	java/io/IOException
    //   192	199	231	com/tencent/moai/mailsdk/exception/MessageException
    //   201	209	231	com/tencent/moai/mailsdk/exception/MessageException
    //   216	228	231	com/tencent/moai/mailsdk/exception/MessageException
    //   264	277	231	com/tencent/moai/mailsdk/exception/MessageException
    //   279	292	231	com/tencent/moai/mailsdk/exception/MessageException
    //   294	307	231	com/tencent/moai/mailsdk/exception/MessageException
    //   309	316	231	com/tencent/moai/mailsdk/exception/MessageException
    //   318	324	231	com/tencent/moai/mailsdk/exception/MessageException
    //   329	337	231	com/tencent/moai/mailsdk/exception/MessageException
    //   339	360	231	com/tencent/moai/mailsdk/exception/MessageException
    //   192	199	240	finally
    //   201	209	240	finally
    //   216	228	240	finally
    //   238	240	240	finally
    //   264	277	240	finally
    //   279	292	240	finally
    //   294	307	240	finally
    //   309	316	240	finally
    //   318	324	240	finally
    //   329	337	240	finally
    //   339	360	240	finally
    //   415	434	240	finally
    //   360	365	380	java/io/IOException
    //   373	377	380	java/io/IOException
    //   387	392	408	java/io/IOException
    //   401	406	408	java/io/IOException
    //   101	145	411	java/lang/Exception
    //   173	190	411	java/lang/Exception
    //   247	252	434	java/io/IOException
    //   256	260	434	java/io/IOException
    //   101	145	438	finally
    //   173	190	438	finally
    //   192	199	444	java/lang/Exception
    //   201	209	444	java/lang/Exception
    //   216	228	444	java/lang/Exception
    //   264	277	444	java/lang/Exception
    //   279	292	444	java/lang/Exception
    //   294	307	444	java/lang/Exception
    //   309	316	444	java/lang/Exception
    //   318	324	444	java/lang/Exception
    //   329	337	444	java/lang/Exception
    //   339	360	444	java/lang/Exception
    //   101	145	451	com/tencent/moai/mailsdk/exception/MessageException
    //   173	190	451	com/tencent/moai/mailsdk/exception/MessageException
  }
  
  public void auth(boolean paramBoolean)
    throws MessageException
  {
    Logger.log(4, "IMAPHandler", "doAuth:" + this.profile.getImapName());
    IMAPResponse localIMAPResponse = null;
    if ((this.profile.isOauth()) || ("imap.gmail.com".equalsIgnoreCase(this.profile.getImapServer())))
    {
      if (StringUtility.isNullOrEmpty(this.profile.getAccessToken())) {
        throw new MessageException(8, "The access token is null");
      }
      Logger.log(4, "IMAPHandler", "authenticateOAuth");
      localIMAPResponse = authenticateOAuth();
    }
    for (int i = 1;; i = 0)
    {
      String str;
      if ((i == 0) && (this.authmechs != null) && (this.authmechs.size() > 0))
      {
        Iterator localIterator = this.authmechs.iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (str.equalsIgnoreCase("PLAIN"))
          {
            Logger.log(4, "IMAPHandler", "authenticatePlain");
            localIMAPResponse = authenticatePlain();
            i = 1;
            label181:
            if ((i == 0) || (localIMAPResponse == null) || (localIMAPResponse.isOK())) {
              break label525;
            }
            if (localIMAPResponse.getContent() == null) {
              break label423;
            }
            str = localIMAPResponse.getContent().toLowerCase();
            label212:
            if (((!str.contains("support")) && (!str.contains("invalid"))) || ((!str.contains("command")) && (!str.contains("mechanism")))) {
              break label525;
            }
            i = 0;
            label258:
            if (i == 0) {
              break label430;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0)
        {
          if (!hasCapability("LOGINDISABLED"))
          {
            Logger.log(4, "IMAPHandler", "only login with no authmechs");
            localIMAPResponse = login();
          }
        }
        else
        {
          if (localIMAPResponse != null) {
            break label455;
          }
          Logger.log(6, "IMAPHandler", "doAuth error response null");
          this.isAuthenticate = false;
          throw new MessageException(3, "auth response null");
          if (str.equalsIgnoreCase("LOGIN"))
          {
            Logger.log(4, "IMAPHandler", "authenticateLogin");
            localIMAPResponse = authenticateLogin();
            i = 1;
            break label181;
          }
          if (str.equalsIgnoreCase("NTLM"))
          {
            Logger.log(4, "IMAPHandler", "authenticateNtlm");
            localIMAPResponse = authenticateNtlm();
            i = 1;
            break label181;
          }
          if ((!str.equalsIgnoreCase("XOAUTH2")) || (StringUtility.isNullOrEmpty(this.profile.getAccessToken()))) {
            break label528;
          }
          Logger.log(4, "IMAPHandler", "authenticateOAuth");
          localIMAPResponse = authenticateOAuth();
          i = 1;
          break label181;
          label423:
          str = "";
          break label212;
          label430:
          break;
        }
        Logger.log(6, "IMAPHandler", "no login method");
        throw new MessageException(4, "no login method");
        label455:
        if (!localIMAPResponse.isOK())
        {
          Logger.log(6, "IMAPHandler", "doAuth error response:" + localIMAPResponse.getContent());
          this.isAuthenticate = false;
          throw new MessageException(4, localIMAPResponse.getContent());
        }
        Logger.log(4, "IMAPHandler", "auth success");
        this.isAuthenticate = true;
        return;
        label525:
        break label258;
        label528:
        break label181;
      }
    }
  }
  
  public IMAPResponse authenticateLogin()
    throws MessageException
  {
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      int i;
      try
      {
        localObject3 = new IMAPArgument();
        ((IMAPArgument)localObject3).writeAtom("LOGIN");
        writeCommand("AUTHENTICATE", (IMAPArgument)localObject3);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream localBASE64EncoderStream = new BASE64EncoderStream(localByteArrayOutputStream, 2147483647);
        int j = 1;
        i = 0;
        if (i != 0) {
          break;
        }
        localObject3 = readLineResponse();
        if (localObject3 == null) {
          return localObject3;
        }
        if (!((IMAPResponse)localObject3).isContinuation()) {
          break label182;
        }
        if (j != 0)
        {
          localObject1 = this.profile.getImapName();
          j = 0;
          localBASE64EncoderStream.write(ASCIIUtility.getBytes((String)localObject1));
          localBASE64EncoderStream.flush();
          localByteArrayOutputStream.write(MimeDefine.CRLF.getBytes());
          this.serverOutput.write(localByteArrayOutputStream.toByteArray());
          this.serverOutput.flush();
          localByteArrayOutputStream.reset();
          localObject1 = localObject3;
          continue;
        }
        localObject2 = this.profile.getImapPassword();
      }
      catch (IOException localIOException)
      {
        throw new MessageException(3, "authenticate login error", localIOException);
      }
      continue;
      label182:
      if ((((IMAPResponse)localObject3).isTagged()) && (((IMAPResponse)localObject3).getTag().equals(this.tag)))
      {
        i = 1;
        localObject2 = localObject3;
      }
      else
      {
        boolean bool = ((IMAPResponse)localObject3).isBYE();
        localObject2 = localObject3;
        if (bool)
        {
          i = 1;
          localObject2 = localObject3;
        }
      }
    }
    return localObject2;
  }
  
  public IMAPResponse authenticateNtlm()
    throws MessageException
  {
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      int i;
      try
      {
        NtlmV2 localNtlmV2 = new NtlmV2(this.profile.getImapNtlmDomain(), getLocalHost(), this.profile.getImapName(), this.profile.getImapPassword());
        localObject3 = new IMAPArgument();
        ((IMAPArgument)localObject3).writeAtom("NTLM");
        writeCommand("AUTHENTICATE", (IMAPArgument)localObject3);
        int j = 1;
        i = 0;
        if (i != 0) {
          break;
        }
        localObject3 = readLineResponse();
        if (localObject3 == null) {
          return localObject3;
        }
        if (!((IMAPResponse)localObject3).isContinuation()) {
          break label176;
        }
        if (j != 0)
        {
          localObject1 = localNtlmV2.generateType1Msg();
          j = 0;
          this.serverOutput.write(((String)localObject1).getBytes());
          this.serverOutput.write(MimeDefine.CRLF.getBytes());
          this.serverOutput.flush();
          localObject1 = localObject3;
          continue;
        }
        localObject2 = localNtlmV2.generateType3Msg(((IMAPResponse)localObject3).getRest());
      }
      catch (Exception localException)
      {
        throw new MessageException(3, "ntlm login error", localException);
      }
      continue;
      label176:
      if ((((IMAPResponse)localObject3).isTagged()) && (((IMAPResponse)localObject3).getTag().equals(this.tag)))
      {
        i = 1;
        localObject2 = localObject3;
      }
      else
      {
        boolean bool = ((IMAPResponse)localObject3).isBYE();
        localObject2 = localObject3;
        if (bool)
        {
          i = 1;
          localObject2 = localObject3;
        }
      }
    }
    return localObject2;
  }
  
  public IMAPResponse authenticateOAuth()
    throws MessageException
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      try
      {
        String str;
        if (this.profile.getAccessToken() == null)
        {
          str = "";
          localObject3 = new IMAPArgument();
          ((IMAPArgument)localObject3).writeAtom("XOAUTH2");
          if (hasCapability("SASL-IR")) {
            ((IMAPArgument)localObject3).writeAtom(str);
          }
          writeCommand("AUTHENTICATE", (IMAPArgument)localObject3);
          if (i != 0) {
            break;
          }
          localObject3 = readLineResponse();
          if (localObject3 == null) {
            return localObject3;
          }
        }
        else
        {
          str = this.profile.getAccessToken();
          continue;
        }
        if (((IMAPResponse)localObject3).isContinuation())
        {
          localObject1 = ((IMAPResponse)localObject3).getContent();
          if (localObject1 != null)
          {
            Logger.log(4, "IMAPHandler", "auth login error :" + (String)localObject1);
            localObject1 = ((String)localObject1).split(" ");
            if (localObject1.length >= 2)
            {
              localObject1 = new String(BASE64DecoderStream.decode(localObject1[1].trim().getBytes()));
              try
              {
                localObject1 = new JSONObject((String)localObject1);
                if (("400".equals(((JSONObject)localObject1).get("status"))) || ("401".equals(((JSONObject)localObject1).get("status")))) {
                  throw new MessageException(8, "The access token you're using is either expired or invalid");
                }
              }
              catch (JSONException localJSONException) {}
            }
          }
          this.serverOutput.write(str.getBytes());
          this.serverOutput.write(MimeDefine.CRLF.getBytes());
          this.serverOutput.flush();
          localObject2 = localObject3;
          continue;
        }
        if (!((IMAPResponse)localObject3).isTagged()) {
          break label317;
        }
      }
      catch (IOException localIOException)
      {
        throw new MessageException(3, "oauth2 login error", localIOException);
      }
      if (((IMAPResponse)localObject3).getTag().equals(this.tag))
      {
        i = 1;
        localObject2 = localObject3;
      }
      else
      {
        label317:
        boolean bool = ((IMAPResponse)localObject3).isBYE();
        localObject2 = localObject3;
        if (bool)
        {
          i = 1;
          localObject2 = localObject3;
        }
      }
    }
    return localObject2;
  }
  
  public IMAPResponse authenticatePlain()
    throws MessageException
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    for (;;)
    {
      Object localObject3;
      try
      {
        byte[] arrayOfByte = ASCIIUtility.getBytes(this.profile.getImapName() + "" + this.profile.getImapName() + "" + this.profile.getImapPassword());
        localObject3 = new IMAPArgument();
        ((IMAPArgument)localObject3).writeAtom("PLAIN");
        writeCommand("AUTHENTICATE", (IMAPArgument)localObject3);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream localBASE64EncoderStream = new BASE64EncoderStream(localByteArrayOutputStream, 2147483647);
        if (i != 0) {
          break;
        }
        localObject3 = readLineResponse();
        if (localObject3 == null) {
          return localObject3;
        }
        if (((IMAPResponse)localObject3).isContinuation())
        {
          localBASE64EncoderStream.write(arrayOfByte);
          localBASE64EncoderStream.flush();
          localByteArrayOutputStream.write(MimeDefine.CRLF.getBytes());
          this.serverOutput.write(localByteArrayOutputStream.toByteArray());
          this.serverOutput.flush();
          localByteArrayOutputStream.reset();
          localObject1 = localObject3;
          continue;
        }
        if (!((IMAPResponse)localObject3).isTagged()) {
          break label234;
        }
      }
      catch (IOException localIOException)
      {
        throw new MessageException(3, "plain login error", localIOException);
      }
      if (((IMAPResponse)localObject3).getTag().equals(this.tag))
      {
        i = 1;
        localObject2 = localObject3;
      }
      else
      {
        label234:
        boolean bool = ((IMAPResponse)localObject3).isBYE();
        localObject2 = localObject3;
        if (bool)
        {
          i = 1;
          localObject2 = localObject3;
        }
      }
    }
    return localObject2;
  }
  
  public void capability()
    throws MessageException
  {
    this.capabilities = new HashMap();
    this.authmechs = new ArrayList();
    Logger.log(4, "IMAPHandler", "capability");
    Object localObject = simpleCommand("CAPABILITY", null);
    if ((((ArrayList)localObject).size() >= 1) && (handleResult((IMAPResponse)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1))))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        IMAPResponse localIMAPResponse = (IMAPResponse)((Iterator)localObject).next();
        if (localIMAPResponse.keyEquals("CAPABILITY")) {
          parseCapabilities(localIMAPResponse);
        }
      }
    }
  }
  
  public boolean check()
    throws MessageException
  {
    boolean bool = simpleCommandResult("CHECK", null);
    Logger.log(4, "IMAPHandler", "CHECK isOk:" + bool);
    return bool;
  }
  
  public boolean close()
    throws MessageException
  {
    boolean bool = simpleCommandResult("CLOSE", null);
    Logger.log(4, "IMAPHandler", "CLOSE isOk:" + bool);
    return bool;
  }
  
  /* Error */
  public void closeConnection()
  {
    // Byte code:
    //   0: iconst_4
    //   1: ldc 17
    //   3: new 115	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 806
    //   13: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: invokevirtual 807	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:getTag	()Ljava/lang/String;
    //   20: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   29: aload_0
    //   30: getfield 429	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 429	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   40: invokevirtual 808	com/tencent/moai/mailsdk/util/stream/LineInputStream:close	()V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 429	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   48: aload_0
    //   49: getfield 424	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverInput	Ljava/io/InputStream;
    //   52: ifnull +10 -> 62
    //   55: aload_0
    //   56: getfield 424	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverInput	Ljava/io/InputStream;
    //   59: invokevirtual 620	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: aconst_null
    //   64: putfield 424	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverInput	Ljava/io/InputStream;
    //   67: aload_0
    //   68: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   71: ifnull +10 -> 81
    //   74: aload_0
    //   75: getfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   78: invokevirtual 809	java/io/OutputStream:close	()V
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   86: aload_0
    //   87: getfield 260	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverSocket	Ljava/net/Socket;
    //   90: ifnull +10 -> 100
    //   93: aload_0
    //   94: getfield 260	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverSocket	Ljava/net/Socket;
    //   97: invokevirtual 810	java/net/Socket:close	()V
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 260	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverSocket	Ljava/net/Socket;
    //   105: return
    //   106: astore_1
    //   107: bipush 6
    //   109: ldc 17
    //   111: aload_1
    //   112: invokestatic 258	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   115: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   118: aload_0
    //   119: aconst_null
    //   120: putfield 429	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   123: goto -75 -> 48
    //   126: astore_1
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 429	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:lineInputStream	Lcom/tencent/moai/mailsdk/util/stream/LineInputStream;
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: bipush 6
    //   137: ldc 17
    //   139: aload_1
    //   140: invokestatic 258	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   143: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 424	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverInput	Ljava/io/InputStream;
    //   151: goto -84 -> 67
    //   154: astore_1
    //   155: aload_0
    //   156: aconst_null
    //   157: putfield 424	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverInput	Ljava/io/InputStream;
    //   160: aload_1
    //   161: athrow
    //   162: astore_1
    //   163: bipush 6
    //   165: ldc 17
    //   167: aload_1
    //   168: invokestatic 258	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   171: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   179: goto -93 -> 86
    //   182: astore_1
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 413	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverOutput	Ljava/io/OutputStream;
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: bipush 6
    //   193: ldc 17
    //   195: aload_1
    //   196: invokestatic 258	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   199: invokestatic 135	com/tencent/moai/mailsdk/util/log/Logger:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   202: aload_0
    //   203: aconst_null
    //   204: putfield 260	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverSocket	Ljava/net/Socket;
    //   207: return
    //   208: astore_1
    //   209: aload_0
    //   210: aconst_null
    //   211: putfield 260	com/tencent/moai/mailsdk/protocol/imap/IMAPHandler:serverSocket	Ljava/net/Socket;
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	IMAPHandler
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
  
  public boolean copy(ArrayList<String> paramArrayList, String paramString, boolean paramBoolean)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeAtom(getUidSeqStr(paramArrayList));
    localIMAPArgument.writeString(paramString);
    if (paramBoolean) {}
    for (paramArrayList = "UID COPY";; paramArrayList = "COPY")
    {
      Logger.log(4, "IMAPHandler", paramArrayList + " " + localIMAPArgument);
      return simpleCommandResult(paramArrayList, localIMAPArgument);
    }
  }
  
  public boolean create(String paramString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString);
    boolean bool = simpleCommandResult("CREATE", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "CREATE " + localIMAPArgument + " isOk" + bool);
    return bool;
  }
  
  public boolean delete(String paramString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString);
    boolean bool = simpleCommandResult("DELETE", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "DELETE " + localIMAPArgument + " isOk" + bool);
    return bool;
  }
  
  public IMAPMailboxInfo examine(String paramString)
    throws MessageException
  {
    return doSelect("EXAMINE", paramString);
  }
  
  public boolean expunge()
    throws MessageException
  {
    boolean bool = simpleCommandResult("EXPUNGE", null);
    Logger.log(4, "IMAPHandler", "EXPUNGE isOk " + bool);
    return bool;
  }
  
  public HashMap<String, ArrayList<IMAPBodyStructure>> fetchBodyStructure(ArrayList<String> paramArrayList)
    throws MessageException
  {
    HashMap localHashMap = new HashMap();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localHashMap;
    }
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return localHashMap;
      }
      Object localObject2 = (String)paramArrayList.next();
      Object localObject1 = new IMAPArgument();
      ((IMAPArgument)localObject1).writeAtomString((String)localObject2);
      ((IMAPArgument)localObject1).writeAtomString("(UID BODYSTRUCTURE)");
      Logger.log(4, "IMAPHandler", "UID FETCH " + localObject1);
      writeCommand("UID FETCH", (IMAPArgument)localObject1);
      localObject1 = readFetchResponse();
      if (((ArrayList)localObject1).size() > 0)
      {
        if (((ArrayList)localObject1).size() == 1)
        {
          Logger.log(6, "IMAPHandler", "fetch empty bodyStructure:" + (String)localObject2 + ":" + ((IMAPResponse)((ArrayList)localObject1).get(0)).getContent());
          Logger.osslog(new Object[] { "fetch_bodyStructure_empty", (String)localObject2 + ":" + ((IMAPResponse)((ArrayList)localObject1).get(0)).getContent() });
        }
        if (handleResult((IMAPResponse)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)))
        {
          int i = 0;
          while (i < ((ArrayList)localObject1).size() - 1)
          {
            localObject2 = (IMAPResponse)((ArrayList)localObject1).get(i);
            try
            {
              Object localObject3 = new IMAPFetchResponse((IMAPResponse)localObject2);
              localObject2 = (IMAPUid)((IMAPFetchResponse)localObject3).getItem(IMAPUid.class);
              localObject3 = (IMAPBodyStructure)((IMAPFetchResponse)localObject3).getItem(IMAPBodyStructure.class);
              if ((localObject2 != null) && (localObject3 != null)) {
                localHashMap.put(((IMAPUid)localObject2).getUid(), IMAPBodyStructureUtil.parseBodyStructure((IMAPBodyStructure)localObject3));
              }
            }
            catch (MessageException localMessageException)
            {
              for (;;)
              {
                Logger.log(6, "IMAPHandler", "read bodyStructure error:" + Log.getStackTraceString(localMessageException));
                OssHelper.parseBodystructureFail(new Object[] { localMessageException.getDetailMessage().replace("\r\n", "||").replace("\r", "|").replace("\n", "|") });
              }
            }
            i += 1;
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void fetchFlagAndSize(ArrayList<String> paramArrayList, HashMap<String, IMAPFlags> paramHashMap, HashMap<String, Long> paramHashMap1)
    throws MessageException
  {
    fetchFlagsAndSize(paramArrayList, paramHashMap, paramHashMap1, "(UID FLAGS RFC822.SIZE)");
  }
  
  @NonNull
  public HashMap<String, IMAPFlags> fetchFlags(ArrayList<String> paramArrayList)
    throws MessageException
  {
    HashMap localHashMap = new HashMap();
    fetchFlagsAndSize(paramArrayList, localHashMap, null, "(UID FLAGS)");
    return localHashMap;
  }
  
  public HashMap<String, MimeHeader> fetchHeader(ArrayList<String> paramArrayList)
    throws MessageException
  {
    HashMap localHashMap = new HashMap();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localHashMap;
    }
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        return localHashMap;
      }
      Object localObject2 = (String)paramArrayList.next();
      Object localObject1 = new IMAPArgument();
      ((IMAPArgument)localObject1).writeAtomString((String)localObject2);
      ((IMAPArgument)localObject1).writeAtomString("(UID BODY.PEEK[HEADER])");
      Logger.log(4, "IMAPHandler", "UID FETCH " + localObject1);
      writeCommand("UID FETCH", (IMAPArgument)localObject1);
      localObject1 = readFetchResponse();
      if (((ArrayList)localObject1).size() > 0)
      {
        if (((ArrayList)localObject1).size() == 1)
        {
          Logger.log(6, "IMAPHandler", "fetch empty header:" + (String)localObject2 + ":" + ((IMAPResponse)((ArrayList)localObject1).get(0)).getContent());
          Logger.osslog(new Object[] { "fetch_header_empty", (String)localObject2 + ":" + ((IMAPResponse)((ArrayList)localObject1).get(0)).getContent() });
        }
        if (handleResult((IMAPResponse)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)))
        {
          int i = 0;
          while (i < ((ArrayList)localObject1).size() - 1)
          {
            try
            {
              Object localObject3 = new IMAPFetchResponse((IMAPResponse)((ArrayList)localObject1).get(i));
              localObject2 = (IMAPUid)((IMAPFetchResponse)localObject3).getItem(IMAPUid.class);
              localObject3 = (IMAPBody)((IMAPFetchResponse)localObject3).getItem(IMAPBody.class);
              if ((localObject2 != null) && (localObject3 != null))
              {
                MimeHeader localMimeHeader = new MimeHeader();
                localMimeHeader.read(((IMAPBody)localObject3).getData().toByteArrayInputStream(), null);
                localHashMap.put(((IMAPUid)localObject2).getUid(), localMimeHeader);
              }
            }
            catch (MessageException localMessageException)
            {
              for (;;)
              {
                Logger.log(6, "IMAPHandler", "read header error:" + Log.getStackTraceString(localMessageException));
              }
            }
            i += 1;
          }
        }
      }
    }
    return localHashMap;
  }
  
  public void fetchMailAttach(String paramString1, IMAPBodyStructure paramIMAPBodyStructure, String paramString2, AttachListener paramAttachListener)
    throws MessageException
  {
    Object localObject = new IMAPArgument();
    ((IMAPArgument)localObject).writeAtomString(paramString1);
    ((IMAPArgument)localObject).writeAtomString("(BODY.PEEK[" + paramIMAPBodyStructure.getBodyId() + "])");
    Logger.log(4, "IMAPHandler", "UID FETCH attach argument:" + localObject);
    writeCommand("UID FETCH", (IMAPArgument)localObject);
    localObject = readStreamResponse();
    IMAPAttach localIMAPAttach = new IMAPAttach();
    localIMAPAttach.setFile(new File(paramString2));
    localIMAPAttach.setTempFile(new File(FileUtility.generateTmpFilePath(paramString1, paramIMAPBodyStructure.getBodyId())));
    try
    {
      localIMAPAttach.read(((IMAPResponse)localObject).getInputStream(), paramIMAPBodyStructure.getEncoding(), this.tag, paramAttachListener);
      return;
    }
    catch (MessageException paramIMAPBodyStructure)
    {
      if (paramIMAPBodyStructure.getResultCode() == 12)
      {
        paramString2 = new IMAPArgument();
        paramString2.writeAtomString(paramString1);
        paramString2.writeAtomString("(BODYSTRUCTURE)");
        writeCommand("UID FETCH", paramString2);
        paramString1 = readFetchResponse();
        if ((paramString1.size() > 0) && (handleResult((IMAPResponse)paramString1.get(paramString1.size() - 1))))
        {
          paramString2 = new StringBuilder();
          int i = 0;
          while (i < paramString1.size() - 1)
          {
            paramString2.append(((IMAPResponse)paramString1.get(i)).getContent());
            i += 1;
          }
          Logger.osslog(new Object[] { "fetch_nil", paramString2.toString() });
        }
      }
      throw paramIMAPBodyStructure;
    }
  }
  
  public ArrayList<IMAPContent> fetchMailText(String paramString, ArrayList<IMAPBodyStructure> paramArrayList)
    throws MessageException
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label325;
      }
      IMAPBodyStructure localIMAPBodyStructure = (IMAPBodyStructure)paramArrayList.next();
      Object localObject1 = new IMAPArgument();
      ((IMAPArgument)localObject1).writeAtomString(paramString);
      ((IMAPArgument)localObject1).writeAtomString("(UID BODY.PEEK[" + localIMAPBodyStructure.getBodyId() + "])");
      Logger.log(4, "IMAPHandler", "UID FETCH mailText argument:" + localObject1);
      writeCommand("UID FETCH", (IMAPArgument)localObject1);
      localObject1 = readFetchResponse();
      if ((((ArrayList)localObject1).size() > 0) && (handleResult((IMAPResponse)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1))))
      {
        int i = 0;
        while (i < ((ArrayList)localObject1).size() - 1)
        {
          try
          {
            Object localObject3 = new IMAPFetchResponse((IMAPResponse)((ArrayList)localObject1).get(i));
            Object localObject2 = (IMAPUid)((IMAPFetchResponse)localObject3).getItem(IMAPUid.class);
            localObject3 = (IMAPBody)((IMAPFetchResponse)localObject3).getItem(IMAPBody.class);
            if ((localObject2 != null) && (localObject3 != null) && (((IMAPBody)localObject3).getData() != null))
            {
              localObject2 = new IMAPContent();
              ((IMAPContent)localObject2).setSubType(localIMAPBodyStructure.getContentSubtype());
              ((IMAPContent)localObject2).read(((IMAPBody)localObject3).getData().toByteArrayInputStream(), MimeUtility.getCharsetFromContentParam(localIMAPBodyStructure.getContentParam()), localIMAPBodyStructure.getEncoding());
              localArrayList.add(localObject2);
            }
          }
          catch (MessageException localMessageException)
          {
            for (;;)
            {
              Logger.log(6, "IMAPHandler", "read mailText error:" + Log.getStackTraceString(localMessageException));
            }
          }
          i += 1;
        }
      }
    }
    label325:
    return localArrayList;
  }
  
  public String getUidSeqStr(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localStringBuilder.toString();
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(Long.valueOf(Long.parseLong((String)paramArrayList.next())));
    }
    Collections.sort(localArrayList, new IMAPHandler.1(this));
    int i = 0;
    if (i < localArrayList.size())
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(",");
      }
      int k = 0;
      int j = i;
      while ((j + 1 < localArrayList.size()) && (((Long)localArrayList.get(j)).longValue() == ((Long)localArrayList.get(j + 1)).longValue() + 1L))
      {
        j += 1;
        k += 1;
      }
      if (k > 0) {
        localStringBuilder.append(localArrayList.get(j) + ":" + localArrayList.get(i));
      }
      for (;;)
      {
        i = j + 1;
        break;
        localStringBuilder.append(localArrayList.get(i));
        j = i;
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean id(String paramString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeAtomString(paramString);
    boolean bool = simpleCommandResult("ID", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "ID " + localIMAPArgument + " isOk " + bool);
    return bool;
  }
  
  public IMAPResponse idle()
    throws MessageException
  {
    writeCommand("IDLE", null);
    Logger.log(4, "IMAPHandler", "IDLE");
    IMAPResponse localIMAPResponse = readLineResponse();
    Logger.log(4, "IMAPHandler", "IDLE ret: " + localIMAPResponse);
    return localIMAPResponse;
  }
  
  public boolean idleDone()
    throws IOException, MessageException
  {
    this.serverOutput.write("DONE".getBytes());
    this.serverOutput.write(MimeDefine.CRLF.getBytes());
    this.serverOutput.flush();
    Logger.log(4, "IMAPHandler", "DONE");
    IMAPResponse localIMAPResponse = readLineResponse();
    Logger.log(4, "IMAPHandler", "DONE ret: " + localIMAPResponse);
    return (localIMAPResponse != null) && (localIMAPResponse.isOK());
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
  
  public boolean isSupportIdle()
  {
    return hasCapability("IDLE");
  }
  
  public ArrayList<IMAPFolder> list(String paramString1, String paramString2)
    throws MessageException
  {
    return doList("LIST", paramString1, paramString2);
  }
  
  public IMAPResponse login()
    throws MessageException
  {
    Object localObject = new IMAPArgument();
    ((IMAPArgument)localObject).writeString(this.profile.getImapName());
    ((IMAPArgument)localObject).writeString(this.profile.getImapPassword());
    localObject = simpleCommand("LOGIN", (IMAPArgument)localObject);
    if (((ArrayList)localObject).size() > 0) {
      return (IMAPResponse)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
    }
    return null;
  }
  
  public boolean logout()
    throws MessageException
  {
    boolean bool = simpleCommandResult("LOGOUT", null);
    Logger.log(4, "IMAPHandler", "LOGOUT isOk" + bool);
    return bool;
  }
  
  public ArrayList<IMAPFolder> lsub(String paramString1, String paramString2)
    throws MessageException
  {
    return doList("LSUB", paramString1, paramString2);
  }
  
  public boolean noop()
    throws MessageException
  {
    boolean bool = simpleCommandResult("NOOP", null);
    Logger.log(4, "IMAPHandler", "NOOP isOk:" + bool);
    return bool;
  }
  
  public void openConnection()
    throws MessageException
  {
    Logger.log(4, "IMAPHandler", "openConnection " + getTag() + ", svr:" + this.profile.getImapServer() + ", ssl:" + this.profile.isImapUsingSSL() + ", port:" + this.profile.getImapPort() + ", sslPort:" + this.profile.getImapSSLPort());
    this.isAuthenticate = false;
    for (;;)
    {
      IMAPResponse localIMAPResponse;
      try
      {
        initSocket();
        initStream();
        localIMAPResponse = readLineResponse();
        if ((localIMAPResponse != null) && (localIMAPResponse.isOK())) {
          break;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("open connection response:");
        if (localIMAPResponse == null)
        {
          String str1 = "response null";
          Logger.log(6, "IMAPHandler", str1);
          if (localIMAPResponse != null) {
            break label273;
          }
          str1 = "response null";
          throw new MessageException(5, str1);
        }
      }
      catch (IOException localIOException)
      {
        Logger.log(6, "IMAPHandler", "open connection io exception:" + Log.getStackTraceString(localIOException));
        throw new MessageException(5, "init socket error", localIOException);
      }
      catch (Exception localException)
      {
        Logger.log(6, "IMAPHandler", "open connection exception:" + Log.getStackTraceString(localException));
        throw new MessageException(5, "init socket error", localException);
      }
      String str2 = localIMAPResponse.getContent();
      continue;
      label273:
      str2 = localIMAPResponse.getContent();
    }
    capability();
    if ((!(this.serverSocket instanceof SSLSocket)) && (hasCapability("STARTTLS")) && (startTLS())) {
      capability();
    }
    if (hasCapability("IMAP4rev1")) {
      this.rev1 = true;
    }
    if (hasCapability("ID")) {
      id(this.profile.getImapUserAgent());
    }
  }
  
  public IMAPResponse readResponse()
    throws MessageException
  {
    return readLineResponse();
  }
  
  public boolean rename(String paramString1, String paramString2)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString1);
    localIMAPArgument.writeString(paramString2);
    boolean bool = simpleCommandResult("RENAME", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "RENAME " + localIMAPArgument + " isOk" + bool);
    return bool;
  }
  
  @NonNull
  public ArrayList<String> search(String paramString, boolean paramBoolean)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeAtomString(paramString);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    int i;
    if (paramBoolean)
    {
      paramString = "UID SEARCH";
      Logger.log(4, "IMAPHandler", paramString + " " + localIMAPArgument);
      localArrayList1 = simpleCommand(paramString, localIMAPArgument);
      localArrayList2 = new ArrayList();
      if (localArrayList1.size() <= 0) {
        break label309;
      }
      if (handleResult((IMAPResponse)localArrayList1.get(localArrayList1.size() - 1))) {
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= localArrayList1.size() - 1) {
          break label309;
        }
        paramString = (IMAPResponse)localArrayList1.get(i);
        if (paramString.keyEquals("SEARCH"))
        {
          for (;;)
          {
            long l = paramString.readLong();
            if (l == -1L) {
              break;
            }
            localArrayList2.add(String.valueOf(l));
          }
          paramString = "SEARCH";
          break;
        }
        i += 1;
      }
    }
    Logger.log(6, "IMAPHandler", paramString + " " + localIMAPArgument + ", error:" + ((IMAPResponse)localArrayList1.get(localArrayList1.size() - 1)).getContent());
    Logger.osslog(new Object[] { "search_fail", StringUtility.getDomain(this.profile.getMailAddress()), paramString + " " + localIMAPArgument, ((IMAPResponse)localArrayList1.get(localArrayList1.size() - 1)).getContent() });
    label309:
    return localArrayList2;
  }
  
  public long searchMsgNumByUid(String paramString)
    throws MessageException
  {
    paramString = search("UID " + paramString, false);
    if (paramString.size() == 1) {
      try
      {
        long l = Long.parseLong((String)paramString.get(0));
        return l;
      }
      catch (Exception localException)
      {
        Logger.log(6, "IMAPHandler", "parse error:" + (String)paramString.get(0));
      }
    }
    return -1L;
  }
  
  public long searchNewMsgNum(@NonNull IMAPMailboxInfo paramIMAPMailboxInfo)
    throws MessageException
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramIMAPMailboxInfo.getTotal();
    paramIMAPMailboxInfo = new IMAPArgument();
    paramIMAPMailboxInfo.writeAtomString("*");
    Logger.log(4, "IMAPHandler", "SEARCH " + paramIMAPMailboxInfo);
    paramIMAPMailboxInfo = simpleCommand("SEARCH", paramIMAPMailboxInfo);
    long l;
    if (paramIMAPMailboxInfo.size() > 0)
    {
      if (handleResult((IMAPResponse)paramIMAPMailboxInfo.get(paramIMAPMailboxInfo.size() - 1)))
      {
        int i = 0;
        while (i < paramIMAPMailboxInfo.size() - 1)
        {
          IMAPResponse localIMAPResponse = (IMAPResponse)paramIMAPMailboxInfo.get(i);
          if (localIMAPResponse.keyEquals("SEARCH")) {
            for (;;)
            {
              l = localIMAPResponse.readLong();
              if (l == -1L) {
                break;
              }
              localArrayList.add(String.valueOf(l));
            }
          }
          i += 1;
        }
      }
      if (!judgeResponseSupport((IMAPResponse)paramIMAPMailboxInfo.get(paramIMAPMailboxInfo.size() - 1)))
      {
        paramIMAPMailboxInfo = ((IMAPResponse)paramIMAPMailboxInfo.get(paramIMAPMailboxInfo.size() - 1)).getContent();
        Logger.log(4, "IMAPHandler", "not support search * " + this.profile.getMailAddress() + ", error:" + paramIMAPMailboxInfo);
        SPUtility.setUnSupportSearchLatest(this.profile.getMailAddress());
        this.unSupportSearchLatestMap.put(StringUtility.getDomain(this.profile.getMailAddress()), Boolean.valueOf(true));
        Logger.osslog(new Object[] { "unsupport_search_latest", StringUtility.getDomain(this.profile.getMailAddress()), Integer.valueOf(j), Integer.valueOf(1) });
        throw new MessageException(17, "unSupport search *:" + this.profile.getMailAddress() + ", error:" + paramIMAPMailboxInfo);
      }
      paramIMAPMailboxInfo = ((IMAPResponse)paramIMAPMailboxInfo.get(paramIMAPMailboxInfo.size() - 1)).getContent();
      Logger.osslog(new Object[] { "search_latest_fail", StringUtility.getDomain(this.profile.getMailAddress()), paramIMAPMailboxInfo });
      Logger.log(4, "IMAPHandler", "search * error" + this.profile.getMailAddress() + ", error:" + paramIMAPMailboxInfo);
      throw new MessageException(17, "search * error:" + this.profile.getMailAddress() + ", " + paramIMAPMailboxInfo);
    }
    if ((localArrayList.size() == 0) && (j > 0))
    {
      Logger.log(4, "IMAPHandler", "search * empty to search all");
      SPUtility.setUnSupportSearchLatest(this.profile.getMailAddress());
      Logger.osslog(new Object[] { "unsupport_search_latest", StringUtility.getDomain(this.profile.getMailAddress()), Integer.valueOf(j), Integer.valueOf(0) });
      this.unSupportSearchLatestMap.put(StringUtility.getDomain(this.profile.getMailAddress()), Boolean.valueOf(true));
      throw new MessageException(17, "search * empty:" + this.profile.getMailAddress());
    }
    if (localArrayList.size() > 0) {
      try
      {
        l = Long.parseLong((String)localArrayList.get(localArrayList.size() - 1));
        return l;
      }
      catch (Exception paramIMAPMailboxInfo)
      {
        Logger.log(6, "IMAPHandler", "parse error:" + (String)localArrayList.get(localArrayList.size() - 1));
      }
    }
    return -1L;
  }
  
  public IMAPMailboxInfo select(String paramString)
    throws MessageException
  {
    return doSelect("SELECT", paramString);
  }
  
  public void setReadTimeout(int paramInt)
    throws IOException
  {
    this.serverSocket.setSoTimeout(paramInt);
  }
  
  public boolean startTLS()
    throws MessageException
  {
    Logger.log(4, "IMAPHandler", "STARTTLS");
    if (simpleCommandResult("STARTTLS", null))
    {
      try
      {
        initSSLSocket();
        initStream();
        return true;
      }
      catch (IOException localIOException1)
      {
        Logger.log(6, "IMAPHandler", "create ssl socket fail after tls:" + Log.getStackTraceString(localIOException1));
        closeConnection();
      }
      for (;;)
      {
        IMAPResponse localIMAPResponse;
        try
        {
          initNormalSocket();
          initStream();
          localIMAPResponse = readLineResponse();
          if ((localIMAPResponse != null) && (localIMAPResponse.isOK())) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder().append("open connection response:");
          if (localIMAPResponse == null)
          {
            String str1 = "response null";
            Logger.log(6, "IMAPHandler", str1);
            if (localIMAPResponse != null) {
              break label200;
            }
            str1 = "response null";
            throw new MessageException(5, str1);
          }
        }
        catch (IOException localIOException2)
        {
          Logger.log(6, "IMAPHandler", "create normal ssl socket fail:" + Log.getStackTraceString(localIOException2));
          closeConnection();
          throw new MessageException(5, "init socket error", localIOException2);
        }
        String str2 = localIMAPResponse.getContent();
        continue;
        label200:
        str2 = localIMAPResponse.getContent();
      }
    }
    return false;
  }
  
  public IMAPMailBoxStatus status(String paramString, String[] paramArrayOfString)
    throws MessageException
  {
    Object localObject = null;
    Iterator localIterator = null;
    if ((!this.rev1) && (!hasCapability("IMAP4SUNVERSION")))
    {
      Logger.log(4, "IMAPHandler", "STATUS is rev1 only");
      paramArrayOfString = localIterator;
    }
    do
    {
      do
      {
        do
        {
          return paramArrayOfString;
          IMAPArgument localIMAPArgument1 = new IMAPArgument();
          localIMAPArgument1.writeString(paramString);
          IMAPArgument localIMAPArgument2 = new IMAPArgument();
          paramString = paramArrayOfString;
          if (paramArrayOfString == null) {
            paramString = IMAPMailBoxStatus.standardItems;
          }
          int i = 0;
          int j = paramString.length;
          while (i < j)
          {
            localIMAPArgument2.writeAtom(paramString[i]);
            i += 1;
          }
          localIMAPArgument1.writeArgument(localIMAPArgument2);
          Logger.log(4, "IMAPHandler", "STATUS " + localIMAPArgument1);
          paramString = simpleCommand("STATUS", localIMAPArgument1);
          paramArrayOfString = localIterator;
        } while (paramString.size() <= 0);
        paramArrayOfString = localIterator;
      } while (!handleResult((IMAPResponse)paramString.get(paramString.size() - 1)));
      localIterator = paramString.iterator();
      paramString = localObject;
      paramArrayOfString = paramString;
    } while (!localIterator.hasNext());
    paramArrayOfString = (IMAPResponse)localIterator.next();
    if (paramArrayOfString.keyEquals("STATUS")) {
      if (paramString == null) {
        paramString = new IMAPMailBoxStatus(paramArrayOfString);
      }
    }
    for (;;)
    {
      break;
      paramString.add(new IMAPMailBoxStatus(paramArrayOfString));
    }
  }
  
  public boolean storeAll(Flags paramFlags, boolean paramBoolean)
    throws MessageException
  {
    return store("1:*", paramFlags, paramBoolean, false);
  }
  
  public boolean storeUidList(ArrayList<String> paramArrayList, Flags paramFlags, boolean paramBoolean)
    throws MessageException
  {
    return store(getUidSeqStr(paramArrayList), paramFlags, paramBoolean, true);
  }
  
  public boolean subscribe(String paramString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString);
    boolean bool = simpleCommandResult("SUBSCRIBE", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "SUBSCRIBE " + localIMAPArgument + " isOk" + bool);
    return bool;
  }
  
  public boolean unSubscribe(String paramString)
    throws MessageException
  {
    IMAPArgument localIMAPArgument = new IMAPArgument();
    localIMAPArgument.writeString(paramString);
    boolean bool = simpleCommandResult("UNSUBSCRIBE", localIMAPArgument);
    Logger.log(4, "IMAPHandler", "UNSUBSCRIBE " + localIMAPArgument + " isOk" + bool);
    return bool;
  }
  
  public boolean unSupportSearchLatest()
  {
    String str = StringUtility.getDomain(this.profile.getMailAddress());
    if (this.unSupportSearchLatestMap.get(str) != null) {}
    while (unSupportSearchLatestDomain.indexOf(str) != -1) {
      return true;
    }
    Object localObject = SPUtility.getUnSupportSearchLatest();
    if (StringUtility.isNullOrEmpty((String)localObject)) {
      return false;
    }
    localObject = ((String)localObject).split(";");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].equals(str))
      {
        this.unSupportSearchLatestMap.put(str, Boolean.valueOf(true));
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.IMAPHandler
 * JD-Core Version:    0.7.0.1
 */