package com.tencent.qqmail.utilities.qmnetwork;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.marcos.CommonMatch;
import com.tencent.qqmail.marcos.LinuxSystemErrno;
import com.tencent.qqmail.utilities.httpclient.QMAndroidHttpClientConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.report.QMHttpReportManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lorg.apache.http.NameValuePair;>;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.cookie.Cookie;
import rx.Observable;
import rx.Subscriber;

public class QMHttpUtil
{
  private static final String BOUNDARY = "---------7d4a6d158c9";
  private static final String DATA_DISPOSITION = "Content-Disposition: form-data; name=\"";
  private static final String DATA_END = "-----------7d4a6d158c9--\r\n";
  private static final String DATA_START = "-----------7d4a6d158c9\r\n";
  private static final String KEY_FORCE_HTTP = "force_http";
  private static final String KEY_PROBLEM_PROXY = "problem_proxy";
  private static final String METHOD_GET = "GET";
  private static final String METHOD_OPTIONS = "OPTIONS";
  private static final String METHOD_POST = "POST";
  private static final String[] PROBLEM_PROXY = { "127.0.0.1", "10.0.0.200", "10.0.0.172" };
  private static final String PROTOCOL_HTTP = "http";
  private static final String PROTOCOL_HTTPS = "https";
  private static final String SEPARATE = "\r\n";
  private static final String SP_NAME = "http_info";
  private static final int STEP_COMPLETE = 8;
  private static final int STEP_CONNECT = 3;
  private static final int STEP_HANDLE_DATA = 7;
  private static final int STEP_INIT_SEND = 1;
  private static final int STEP_OPEN = 2;
  private static final int STEP_POST_DATA = 4;
  private static final int STEP_RECEIVE_DATA = 6;
  private static final int STEP_RESPOND = 5;
  private static final String TAG = "HttpRequest";
  private static volatile boolean sEnableProblemProxy = SPManager.getSp("http_info").getBoolean("problem_proxy", false);
  private static volatile boolean sForceHttp = SPManager.getSp("http_info").getBoolean("force_http", false);
  
  public static void asyncSend(QMNetworkRequest paramQMNetworkRequest)
  {
    NetworkManager localNetworkManager1 = NetworkManager.sharedInstance();
    NetworkManager localNetworkManager2 = NetworkManager.sharedInstance();
    localNetworkManager2.getClass();
    localNetworkManager1.executeTask(new NetworkManager.Task(localNetworkManager2, paramQMNetworkRequest));
  }
  
  public static boolean enableProblemProxy()
  {
    return sEnableProblemProxy;
  }
  
  public static boolean forceHttp()
  {
    return sForceHttp;
  }
  
  private static String formatCookieString(QMNetworkRequest paramQMNetworkRequest)
  {
    Object localObject = paramQMNetworkRequest.getRequestCookies();
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    paramQMNetworkRequest = new StringBuilder();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Cookie localCookie = (Cookie)((Iterator)localObject).next();
      paramQMNetworkRequest.append(localCookie.getName());
      paramQMNetworkRequest.append('=');
      paramQMNetworkRequest.append(localCookie.getValue());
      paramQMNetworkRequest.append(';');
    }
    return paramQMNetworkRequest.toString();
  }
  
  private static String getDebugDescription(StringBuilder paramStringBuilder, Throwable paramThrowable, int paramInt)
  {
    return "," + paramThrowable.getClass().getSimpleName() + "," + paramInt;
  }
  
  private static StringBuilder getErrLogStringBuilder(QMNetworkRequest paramQMNetworkRequest, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(";");
    localStringBuilder.append(CommonMatch.findCgiName(paramQMNetworkRequest.getRequestUrlString()));
    localStringBuilder.append(";");
    if ((paramQMNetworkRequest instanceof CGIRequest))
    {
      paramQMNetworkRequest = AccountManager.shareInstance().getAccountList().getAccountById(((CGIRequest)paramQMNetworkRequest).accountId);
      if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.isQQMail())) {
        localStringBuilder.append(paramQMNetworkRequest.getUin());
      }
    }
    localStringBuilder.append(";");
    return localStringBuilder;
  }
  
  private static long getPostContentLen(QMNetworkRequest paramQMNetworkRequest, List<NameValuePair> paramList, List<QMFileEntity> paramList1)
  {
    Object localObject1;
    Object localObject2;
    if (paramList != null)
    {
      localObject1 = new StringBuilder();
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject2 = (NameValuePair)paramList.get(i);
        ((StringBuilder)localObject1).append("-----------7d4a6d158c9\r\n");
        ((StringBuilder)localObject1).append("Content-Disposition: form-data; name=\"").append(((NameValuePair)localObject2).getName()).append("\"\r\n\r\n");
        ((StringBuilder)localObject1).append(((NameValuePair)localObject2).getValue()).append("\r\n");
        i += 1;
      }
    }
    for (long l1 = ((StringBuilder)localObject1).toString().getBytes().length + 0L;; l1 = 0L)
    {
      if (paramList1 != null)
      {
        localObject2 = paramList1.iterator();
        for (;;)
        {
          l2 = l1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          QMFileEntity localQMFileEntity = (QMFileEntity)((Iterator)localObject2).next();
          paramList1 = localQMFileEntity.getFileNameString();
          localObject1 = paramQMNetworkRequest.getMultiPartCustomName();
          paramList = (List<NameValuePair>)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramList = paramList1;
          }
          localObject1 = localQMFileEntity.getContentType().getValue();
          paramList1 = "-----------7d4a6d158c9\r\nContent-Disposition: form-data; name=\"" + paramList + "\"; filename=\"" + paramList1 + "\"\r\n";
          paramList = paramList1;
          if (!"".equals(localObject1)) {
            paramList = paramList1 + "Content-Type: " + (String)localObject1 + "\r\n";
          }
          l2 = (paramList + "\r\n").getBytes().length;
          l1 = localQMFileEntity.getContentLength() + (l1 + l2) + "\r\n".length();
        }
      }
      long l2 = l1;
      return "-----------7d4a6d158c9--\r\n".length() + l2;
    }
  }
  
  private static long getPostContentLen(List<Pair<String, byte[]>> paramList)
  {
    if (paramList == null) {}
    for (int i = 0; i == 0; i = paramList.size()) {
      return 0L;
    }
    long l1 = "-----------7d4a6d158c9\r\n".getBytes().length * i;
    long l2 = i * "Content-Disposition: form-data; name=\"\"\r\n\r\n\r\n".getBytes().length;
    paramList = paramList.iterator();
    Pair localPair;
    for (l1 = 0L + l1 + l2; paramList.hasNext(); l1 = ((byte[])localPair.second).length + i + l1)
    {
      localPair = (Pair)paramList.next();
      i = ((String)localPair.first).getBytes().length;
    }
    return "-----------7d4a6d158c9--\r\n".getBytes().length + l1;
  }
  
  private static QMNetworkResponse getResponse(QMNetworkRequest paramQMNetworkRequest, HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = new QMNetworkResponse(parseContentTypeString(paramHttpURLConnection.getContentType()), paramHttpURLConnection.getHeaderFields());
    paramQMNetworkRequest.responseReceiveHeader(paramHttpURLConnection.getResponseHeaders());
    return paramHttpURLConnection;
  }
  
  private static float getSpeed(int paramInt, long paramLong)
  {
    return getSpeed(paramInt, paramLong);
  }
  
  private static float getSpeed(long paramLong1, long paramLong2)
  {
    return Math.round((float)paramLong1 / 1024.0F / (float)((float)paramLong2 / Math.pow(10.0D, 9.0D)) * 100.0F) / 100.0F;
  }
  
  private static void handleClassCastException(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkError paramQMNetworkError, Exception paramException, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    paramQMNetworkError = paramException.toString() + "," + paramException.getCause();
    QMLog.log(6, "HttpRequest", "send ClassCastException : " + paramQMNetworkRequest.getRequestUrlString() + "; " + paramException.getMessage() + "; send ClassCastException detail : " + paramQMNetworkError);
    StringBuilder localStringBuilder = getErrLogStringBuilder(paramQMNetworkRequest, String.valueOf(-10000));
    paramQMNetworkRequest.responseError(null, new QMNetworkError(8, -10000, QMApplicationContext.sharedInstance().getString(2131696284), getDebugDescription(localStringBuilder.append(paramQMNetworkError), paramException, paramInt)));
    if (paramSubscriber != null) {
      paramSubscriber.onError(paramException);
    }
  }
  
  private static void handleIOException(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkError paramQMNetworkError, Exception paramException, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    paramQMNetworkError = paramException.getMessage();
    String str = paramQMNetworkError + "," + paramException.getCause();
    QMLog.log(6, "HttpRequest", "send IOException : " + paramQMNetworkRequest.getRequestUrlString() + "; send IOException detail : " + str);
    int i = LinuxSystemErrno.getErrnoFromErrmsg(str);
    StringBuilder localStringBuilder = getErrLogStringBuilder(paramQMNetworkRequest, String.valueOf(i));
    if (paramInt == 4) {
      if ("unexpected end of stream".equals(paramQMNetworkError)) {
        paramQMNetworkError = "附件上传失败，附件可能已损坏，请检查";
      }
    }
    for (;;)
    {
      paramQMNetworkRequest.responseError(null, new QMNetworkError(8, i, paramQMNetworkError, getDebugDescription(localStringBuilder.append(str), paramException, paramInt)));
      if (paramSubscriber != null) {
        paramSubscriber.onError(paramException);
      }
      return;
      if ((paramException.getCause() instanceof OutOfMemoryError))
      {
        paramQMNetworkError = "附件过大，内存不足，上传失败";
      }
      else if ((paramException.getCause() instanceof ArrayIndexOutOfBoundsException))
      {
        paramQMNetworkError = "附件上传失败，请检查附件";
      }
      else
      {
        paramQMNetworkError = QMApplicationContext.sharedInstance().getString(2131696284);
        continue;
        if (paramInt == 7) {
          paramQMNetworkError = "数据格式错误";
        } else {
          paramQMNetworkError = QMApplicationContext.sharedInstance().getString(2131696284);
        }
      }
    }
  }
  
  private static void handleNoClassDefFoundError(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkError paramQMNetworkError, Error paramError, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    paramQMNetworkError = paramError.toString() + "," + paramError.getCause();
    QMLog.log(6, "HttpRequest", "send NoClassDefFoundException : " + paramQMNetworkRequest.getRequestUrlString() + "; " + paramError.getMessage() + "; send NoClassDefFoundException detail : " + paramQMNetworkError);
    int i = LinuxSystemErrno.getErrnoFromErrmsg(paramQMNetworkError);
    StringBuilder localStringBuilder = getErrLogStringBuilder(paramQMNetworkRequest, String.valueOf(i));
    paramQMNetworkRequest.responseError(null, new QMNetworkError(8, i, QMApplicationContext.sharedInstance().getString(2131696285), getDebugDescription(localStringBuilder.append(paramQMNetworkError), paramError, paramInt)));
    if (paramSubscriber != null) {
      paramSubscriber.onError(paramError);
    }
  }
  
  private static void handleOtherException(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkError paramQMNetworkError, Exception paramException, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    String str = paramException.toString() + "," + paramException.getCause();
    QMLog.log(6, "HttpRequest", "send Exception : " + paramQMNetworkRequest.getRequestUrlString(), paramException);
    int j = LinuxSystemErrno.getErrnoFromErrmsg(str);
    paramQMNetworkError = QMApplicationContext.sharedInstance().getString(2131696284);
    int i;
    if ((paramException instanceof DataFormatException))
    {
      i = -10012;
      paramQMNetworkError = "获取附件内容错误";
    }
    for (;;)
    {
      paramQMNetworkRequest.responseError(null, new QMNetworkError(8, i, paramQMNetworkError, getDebugDescription(getErrLogStringBuilder(paramQMNetworkRequest, String.valueOf(i)).append(str), paramException, paramInt)));
      if (paramSubscriber != null) {
        paramSubscriber.onError(paramException);
      }
      return;
      i = j;
      if (paramInt == 7)
      {
        paramQMNetworkError = "数据格式错误";
        i = j;
      }
    }
  }
  
  /* Error */
  private static void handleSSLException(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkError paramQMNetworkError, Exception paramException, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    // Byte code:
    //   0: new 145	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   7: aload_3
    //   8: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   11: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 194
    //   16: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_3
    //   20: invokevirtual 368	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   23: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore 7
    //   31: aload 7
    //   33: astore_2
    //   34: aload_1
    //   35: invokevirtual 473	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:prepareURL	()Ljava/lang/String;
    //   38: invokestatic 478	org/apache/commons/lang3/StringUtils:isBlank	(Ljava/lang/CharSequence;)Z
    //   41: ifne +32 -> 73
    //   44: new 145	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   51: aload 7
    //   53: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 480
    //   59: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 473	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:prepareURL	()Ljava/lang/String;
    //   66: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore_2
    //   73: aload_2
    //   74: astore 7
    //   76: invokestatic 486	javax/net/ssl/SSLContext:getDefault	()Ljavax/net/ssl/SSLContext;
    //   79: astore 9
    //   81: aload_2
    //   82: astore 8
    //   84: aload 9
    //   86: ifnull +138 -> 224
    //   89: aload_2
    //   90: astore 7
    //   92: aload 9
    //   94: invokevirtual 490	javax/net/ssl/SSLContext:getDefaultSSLParameters	()Ljavax/net/ssl/SSLParameters;
    //   97: astore 9
    //   99: aload_2
    //   100: astore 8
    //   102: aload 9
    //   104: ifnull +120 -> 224
    //   107: aload_2
    //   108: astore 7
    //   110: aload 9
    //   112: invokevirtual 496	javax/net/ssl/SSLParameters:getProtocols	()[Ljava/lang/String;
    //   115: astore 9
    //   117: aload_2
    //   118: astore 8
    //   120: aload 9
    //   122: ifnull +102 -> 224
    //   125: aload_2
    //   126: astore 8
    //   128: aload_2
    //   129: astore 7
    //   131: aload 9
    //   133: arraylength
    //   134: ifle +90 -> 224
    //   137: aload_2
    //   138: astore 7
    //   140: new 145	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   147: aload_2
    //   148: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 498
    //   154: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: astore_2
    //   161: aload 9
    //   163: arraylength
    //   164: istore 6
    //   166: iconst_0
    //   167: istore 5
    //   169: aload_2
    //   170: astore 8
    //   172: iload 5
    //   174: iload 6
    //   176: if_icmpge +48 -> 224
    //   179: aload 9
    //   181: iload 5
    //   183: aaload
    //   184: astore 8
    //   186: aload_2
    //   187: astore 7
    //   189: new 145	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   196: aload_2
    //   197: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 8
    //   202: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc_w 500
    //   208: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore_2
    //   215: iload 5
    //   217: iconst_1
    //   218: iadd
    //   219: istore 5
    //   221: goto -52 -> 169
    //   224: aload 8
    //   226: astore_2
    //   227: bipush 6
    //   229: ldc 66
    //   231: new 145	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 502
    //   241: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   248: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: ldc_w 504
    //   254: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_2
    //   258: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   267: aload_2
    //   268: invokestatic 430	com/tencent/qqmail/marcos/LinuxSystemErrno:getErrnoFromErrmsg	(Ljava/lang/String;)I
    //   271: istore 5
    //   273: aload_1
    //   274: iload 5
    //   276: invokestatic 390	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   279: invokestatic 392	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getErrLogStringBuilder	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: astore 7
    //   284: aload_3
    //   285: invokevirtual 368	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   288: instanceof 506
    //   291: ifeq +93 -> 384
    //   294: new 508	com/tencent/qqmail/utilities/qmnetwork/QMSslError
    //   297: dup
    //   298: bipush 8
    //   300: sipush -600
    //   303: invokestatic 399	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   306: ldc_w 400
    //   309: invokevirtual 403	com/tencent/qqmail/QMApplicationContext:getString	(I)Ljava/lang/String;
    //   312: aload 7
    //   314: aload_2
    //   315: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: iload_0
    //   320: invokestatic 405	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getDebugDescription	(Ljava/lang/StringBuilder;Ljava/lang/Throwable;I)Ljava/lang/String;
    //   323: invokespecial 509	com/tencent/qqmail/utilities/qmnetwork/QMSslError:<init>	(IILjava/lang/String;Ljava/lang/String;)V
    //   326: astore 7
    //   328: aload_1
    //   329: aconst_null
    //   330: aload 7
    //   332: invokevirtual 412	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseError	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   335: aload 4
    //   337: ifnull +9 -> 346
    //   340: aload 4
    //   342: aload_3
    //   343: invokevirtual 418	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   346: ldc_w 511
    //   349: lconst_0
    //   350: ldc2_w 512
    //   353: aload_2
    //   354: invokestatic 519	com/tencent/qqmail/protocol/DataCollector:logDetailEvent	(Ljava/lang/String;JJLjava/lang/String;)V
    //   357: invokestatic 524	com/tencent/qqmail/model/mail/QMSettingManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMSettingManager;
    //   360: invokestatic 529	java/lang/System:currentTimeMillis	()J
    //   363: invokevirtual 533	com/tencent/qqmail/model/mail/QMSettingManager:setSSLErrorTime	(J)V
    //   366: return
    //   367: astore 8
    //   369: aload 7
    //   371: astore_2
    //   372: aload 8
    //   374: astore 7
    //   376: aload 7
    //   378: invokevirtual 536	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   381: goto -154 -> 227
    //   384: new 394	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError
    //   387: dup
    //   388: bipush 8
    //   390: iload 5
    //   392: invokestatic 399	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   395: ldc_w 400
    //   398: invokevirtual 403	com/tencent/qqmail/QMApplicationContext:getString	(I)Ljava/lang/String;
    //   401: aload 7
    //   403: aload_2
    //   404: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload_3
    //   408: iload_0
    //   409: invokestatic 405	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getDebugDescription	(Ljava/lang/StringBuilder;Ljava/lang/Throwable;I)Ljava/lang/String;
    //   412: invokespecial 408	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError:<init>	(IILjava/lang/String;Ljava/lang/String;)V
    //   415: astore 7
    //   417: goto -89 -> 328
    //   420: astore 7
    //   422: goto -46 -> 376
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramInt	int
    //   0	425	1	paramQMNetworkRequest	QMNetworkRequest
    //   0	425	2	paramQMNetworkError	QMNetworkError
    //   0	425	3	paramException	Exception
    //   0	425	4	paramSubscriber	Subscriber<? super QMNetworkResponse>
    //   167	224	5	i	int
    //   164	13	6	j	int
    //   29	387	7	localObject1	Object
    //   420	1	7	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   82	143	8	localQMNetworkError	QMNetworkError
    //   367	6	8	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   79	101	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   76	81	367	java/security/NoSuchAlgorithmException
    //   92	99	367	java/security/NoSuchAlgorithmException
    //   110	117	367	java/security/NoSuchAlgorithmException
    //   131	137	367	java/security/NoSuchAlgorithmException
    //   140	161	367	java/security/NoSuchAlgorithmException
    //   189	215	367	java/security/NoSuchAlgorithmException
    //   161	166	420	java/security/NoSuchAlgorithmException
  }
  
  /* Error */
  private static QMNetworkError handleSendError(QMNetworkRequest paramQMNetworkRequest, HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    // Byte code:
    //   0: new 145	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload_1
    //   10: invokevirtual 544	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   13: astore_3
    //   14: aload_1
    //   15: invokevirtual 547	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   18: astore 5
    //   20: aload_3
    //   21: ifnull +399 -> 420
    //   24: aload 5
    //   26: ifnull +394 -> 420
    //   29: ldc_w 549
    //   32: aload 5
    //   34: invokevirtual 287	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +71 -> 108
    //   40: new 551	java/util/zip/GZIPInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 554	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_3
    //   49: aload_3
    //   50: ifnull +364 -> 414
    //   53: getstatic 560	com/tencent/qqmail/utilities/httpclient/QMAndroidHttpClientConfig:RECEIVE_BUFF_LEN_INTEGER	Ljava/lang/Integer;
    //   56: invokevirtual 565	java/lang/Integer:intValue	()I
    //   59: newarray byte
    //   61: astore 7
    //   63: new 567	java/io/ByteArrayOutputStream
    //   66: dup
    //   67: invokespecial 568	java/io/ByteArrayOutputStream:<init>	()V
    //   70: astore 4
    //   72: aload_3
    //   73: aload 7
    //   75: invokevirtual 574	java/io/InputStream:read	([B)I
    //   78: istore_2
    //   79: iload_2
    //   80: iconst_m1
    //   81: if_icmpeq +58 -> 139
    //   84: aload 4
    //   86: aload 7
    //   88: iconst_0
    //   89: iload_2
    //   90: invokevirtual 578	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -21 -> 72
    //   96: astore_0
    //   97: aload_3
    //   98: invokevirtual 581	java/io/InputStream:close	()V
    //   101: aload 4
    //   103: invokevirtual 582	java/io/ByteArrayOutputStream:close	()V
    //   106: aload_0
    //   107: athrow
    //   108: ldc_w 584
    //   111: aload 5
    //   113: invokevirtual 287	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +304 -> 420
    //   119: new 586	java/util/zip/InflaterInputStream
    //   122: dup
    //   123: aload_3
    //   124: new 588	java/util/zip/Inflater
    //   127: dup
    //   128: iconst_1
    //   129: invokespecial 591	java/util/zip/Inflater:<init>	(Z)V
    //   132: invokespecial 594	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   135: astore_3
    //   136: goto -87 -> 49
    //   139: aload 6
    //   141: new 89	java/lang/String
    //   144: dup
    //   145: aload 4
    //   147: invokevirtual 597	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   150: invokespecial 600	java/lang/String:<init>	([B)V
    //   153: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: invokevirtual 581	java/io/InputStream:close	()V
    //   161: aload 4
    //   163: invokevirtual 582	java/io/ByteArrayOutputStream:close	()V
    //   166: aload 6
    //   168: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_3
    //   172: iconst_5
    //   173: ldc 66
    //   175: new 145	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 602
    //   185: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 5
    //   190: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc_w 604
    //   196: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload_3
    //   200: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: aload_1
    //   210: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   213: sipush 302
    //   216: if_icmpeq +113 -> 329
    //   219: aload_3
    //   220: invokestatic 613	com/tencent/qqmail/utilities/stringextention/StringExtention:isNullOrEmpty	(Ljava/lang/String;)Z
    //   223: ifne +60 -> 283
    //   226: aload_0
    //   227: invokevirtual 473	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:prepareURL	()Ljava/lang/String;
    //   230: ldc_w 615
    //   233: invokevirtual 618	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   236: ifeq +69 -> 305
    //   239: aload_1
    //   240: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   243: sipush 404
    //   246: if_icmpeq +13 -> 259
    //   249: aload_1
    //   250: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   253: sipush 304
    //   256: if_icmpne +49 -> 305
    //   259: new 394	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError
    //   262: dup
    //   263: iconst_0
    //   264: aload_1
    //   265: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   268: aload_3
    //   269: ldc_w 283
    //   272: aload_1
    //   273: invokevirtual 622	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   276: invokevirtual 625	java/net/URL:toString	()Ljava/lang/String;
    //   279: invokespecial 628	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError:<init>	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   282: areturn
    //   283: aload_0
    //   284: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   287: ifnonnull +10 -> 297
    //   290: ldc_w 283
    //   293: astore_3
    //   294: goto -68 -> 226
    //   297: aload_0
    //   298: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   301: astore_3
    //   302: goto -8 -> 294
    //   305: new 394	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError
    //   308: dup
    //   309: iconst_2
    //   310: aload_1
    //   311: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   314: aload_3
    //   315: ldc_w 283
    //   318: aload_1
    //   319: invokevirtual 622	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   322: invokevirtual 625	java/net/URL:toString	()Ljava/lang/String;
    //   325: invokespecial 628	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError:<init>	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   328: areturn
    //   329: aload_1
    //   330: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   333: istore_2
    //   334: aload_0
    //   335: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   338: ifnonnull +37 -> 375
    //   341: ldc_w 283
    //   344: astore_3
    //   345: aload_0
    //   346: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   349: ifnonnull +34 -> 383
    //   352: ldc_w 283
    //   355: astore_0
    //   356: new 394	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError
    //   359: dup
    //   360: iconst_2
    //   361: iload_2
    //   362: aload_3
    //   363: aload_0
    //   364: aload_1
    //   365: invokevirtual 622	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   368: invokevirtual 625	java/net/URL:toString	()Ljava/lang/String;
    //   371: invokespecial 628	com/tencent/qqmail/utilities/qmnetwork/QMNetworkError:<init>	(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   374: areturn
    //   375: aload_0
    //   376: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   379: astore_3
    //   380: goto -35 -> 345
    //   383: aload_0
    //   384: invokevirtual 197	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getRequestUrlString	()Ljava/lang/String;
    //   387: astore_0
    //   388: goto -32 -> 356
    //   391: astore_3
    //   392: goto -231 -> 161
    //   395: astore_3
    //   396: goto -230 -> 166
    //   399: astore_1
    //   400: goto -299 -> 101
    //   403: astore_1
    //   404: goto -298 -> 106
    //   407: astore_0
    //   408: aconst_null
    //   409: astore 4
    //   411: goto -314 -> 97
    //   414: aconst_null
    //   415: astore 4
    //   417: goto -260 -> 157
    //   420: goto -371 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramQMNetworkRequest	QMNetworkRequest
    //   0	423	1	paramHttpURLConnection	HttpURLConnection
    //   78	284	2	i	int
    //   13	367	3	localObject	Object
    //   391	1	3	localException1	Exception
    //   395	1	3	localException2	Exception
    //   70	346	4	localByteArrayOutputStream	ByteArrayOutputStream
    //   18	171	5	str	String
    //   7	160	6	localStringBuilder	StringBuilder
    //   61	26	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   72	79	96	finally
    //   84	93	96	finally
    //   139	157	96	finally
    //   157	161	391	java/lang/Exception
    //   161	166	395	java/lang/Exception
    //   97	101	399	java/lang/Exception
    //   101	106	403	java/lang/Exception
    //   53	72	407	finally
  }
  
  private static QMNetworkResponse handleSendSuccess(QMNetworkRequest paramQMNetworkRequest, HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    String str1 = "UTF-8";
    if (isCompressRequest(paramQMNetworkRequest)) {
      str1 = "gb2312";
    }
    QMNetworkResponse localQMNetworkResponse = getResponse(paramQMNetworkRequest, paramHttpURLConnection);
    int n = paramHttpURLConnection.getContentLength();
    Object localObject = paramHttpURLConnection.getInputStream();
    String str2 = paramHttpURLConnection.getContentEncoding();
    QMLog.log(4, "HttpRequest", "contentEncode " + str2);
    if ((localObject != null) && (str2 != null)) {
      if (!"gzip".equals(str2)) {}
    }
    int j;
    byte[] arrayOfByte;
    label317:
    label458:
    for (paramHttpURLConnection = new GZIPInputStream((InputStream)localObject);; paramHttpURLConnection = (HttpURLConnection)localObject) {
      for (;;)
      {
        localObject = new ByteArrayOutputStream();
        j = 0;
        int i = 0;
        int m = 0;
        int k = 0;
        arrayOfByte = new byte[QMAndroidHttpClientConfig.RECEIVE_BUFF_LEN_INTEGER.intValue()];
        if (paramHttpURLConnection != null) {
          try
          {
            long l1 = System.nanoTime();
            for (;;)
            {
              int i1 = paramHttpURLConnection.read(arrayOfByte);
              j = i;
              if (i1 == -1) {
                break;
              }
              m += i1;
              long l2 = System.nanoTime() - l1;
              k += i1;
              j = k;
              if (l2 / 1000L / 1000L / 1000L > 5L)
              {
                QMLog.log(4, "HttpRequest", "read response, elapse: " + nanos2Millis(l2) + "ms, readLen: " + k + ", speed: " + getSpeed(k, l2) + "KB/s, hasRead: " + m);
                l1 = System.nanoTime();
                j = 0;
              }
              ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i1);
              i += i1;
              paramQMNetworkRequest.responseReceiveData(arrayOfByte, i1, n);
              k = j;
            }
            try
            {
              paramHttpURLConnection.close();
            }
            catch (Exception paramHttpURLConnection)
            {
              try
              {
                for (;;)
                {
                  ((ByteArrayOutputStream)localObject).close();
                  throw paramQMNetworkRequest;
                  if (!"deflate".equals(str2)) {
                    break label458;
                  }
                  paramHttpURLConnection = new InflaterInputStream((InputStream)localObject, new Inflater(true));
                  break;
                  arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
                  if (paramQMNetworkRequest.isRawResponse()) {
                    localQMNetworkResponse.setResponseData(arrayOfByte);
                  }
                  for (;;)
                  {
                    QMLog.log(4, "HttpRequest", "handleSendSuccess, encode: " + str2 + ", responseLen: " + j);
                    try
                    {
                      paramHttpURLConnection.close();
                      try
                      {
                        ((ByteArrayOutputStream)localObject).close();
                        return localQMNetworkResponse;
                      }
                      catch (Exception paramQMNetworkRequest)
                      {
                        return localQMNetworkResponse;
                      }
                      localQMNetworkResponse.setResponseString(new String(arrayOfByte, 0, j, str1));
                    }
                    catch (Exception paramQMNetworkRequest)
                    {
                      break label413;
                    }
                  }
                  paramHttpURLConnection = paramHttpURLConnection;
                }
              }
              catch (Exception paramHttpURLConnection)
              {
                break label317;
              }
            }
          }
          finally {}
        }
      }
    }
  }
  
  private static boolean isCompressRequest(QMNetworkRequest paramQMNetworkRequest)
  {
    return "viewcompress".equals(paramQMNetworkRequest.getRequestUrlString());
  }
  
  private static float nanos2Millis(long paramLong)
  {
    return Math.round((float)paramLong / 1000.0F / 1000.0F * 100.0F) / 100.0F;
  }
  
  public static HttpURLConnection openConnection(QMNetworkRequest paramQMNetworkRequest, String paramString)
    throws IOException
  {
    return openConnection(paramQMNetworkRequest.getProxy(), paramString);
  }
  
  public static HttpURLConnection openConnection(QMProxy paramQMProxy, String paramString)
    throws IOException
  {
    paramString = new URL(paramString);
    String str1 = paramString.getProtocol();
    if (("http".equals(str1)) || ("https".equals(str1)))
    {
      if ((paramQMProxy != null) && (paramQMProxy.getProxyType() != 0)) {
        return HttpURLConnectionFactory.open(paramString, paramQMProxy);
      }
      String[] arrayOfString;
      int j;
      int i;
      if (!sEnableProblemProxy)
      {
        paramQMProxy = System.getProperty("http.proxyHost");
        str1 = System.getProperty("https.proxyHost");
        if ((!TextUtils.isEmpty(paramQMProxy)) || (!TextUtils.isEmpty(str1)))
        {
          QMLog.log(5, "HttpRequest", "system proxy, http: " + paramQMProxy + ", https: " + str1);
          arrayOfString = PROBLEM_PROXY;
          j = arrayOfString.length;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          String str2 = arrayOfString[i];
          if ((str2.equals(paramQMProxy)) || (str2.equals(str1)))
          {
            System.clearProperty("http.proxyHost");
            System.clearProperty("https.proxyHost");
          }
        }
        else
        {
          return HttpURLConnectionFactory.open(paramString, null);
        }
        i += 1;
      }
    }
    throw new IOException("not http request");
  }
  
  private static String parseContentTypeString(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return "";
    }
    paramString = paramString.split(";");
    if (paramString.length > 0) {
      return paramString[0];
    }
    return "";
  }
  
  private static float percent(long paramLong, int paramInt)
  {
    return percent(paramLong, paramInt);
  }
  
  private static float percent(long paramLong1, long paramLong2)
  {
    return Math.round((float)paramLong1 / (float)paramLong2 * 10000.0F) / 100.0F;
  }
  
  private static void reportHttpException(int paramInt1, QMNetworkRequest paramQMNetworkRequest, long paramLong, String paramString, int paramInt2, Throwable paramThrowable)
  {
    boolean bool = false;
    paramLong = SystemClock.elapsedRealtime() - paramLong;
    switch (paramInt1)
    {
    case 1: 
    default: 
      return;
    case 2: 
      try
      {
        QMHttpReportManager.openConnection(paramLong, paramString, false, paramThrowable);
        return;
      }
      catch (Exception paramQMNetworkRequest)
      {
        QMLog.log(6, "HttpRequest", "reportHttpException", paramQMNetworkRequest);
        return;
      }
    case 3: 
      QMHttpReportManager.connect(paramLong, paramString, false, paramThrowable);
      return;
    case 4: 
      if (paramQMNetworkRequest.getHttpMethod() == QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART) {
        bool = true;
      }
      QMHttpReportManager.post(bool, paramLong, paramString, false, paramThrowable);
      return;
    case 5: 
      QMHttpReportManager.response(paramLong, paramString, false, paramInt2, paramThrowable);
      return;
    case 6: 
      QMHttpReportManager.read(paramLong, paramString, false, paramThrowable);
      return;
    }
    QMHttpReportManager.handleData(paramLong, paramString, false, paramThrowable);
  }
  
  public static void send(QMNetworkRequest paramQMNetworkRequest)
  {
    sendRequest(paramQMNetworkRequest, null);
  }
  
  public static Observable<QMNetworkResponse> sendInObservable(QMNetworkRequest paramQMNetworkRequest)
  {
    return Observable.create(new QMHttpUtil.1(paramQMNetworkRequest));
  }
  
  /* Error */
  private static void sendRequest(QMNetworkRequest paramQMNetworkRequest, Subscriber<? super QMNetworkResponse> paramSubscriber)
  {
    // Byte code:
    //   0: invokestatic 810	com/tencent/qqmail/utilities/validate/ValidateHelper:notMainThread	()V
    //   3: aload_0
    //   4: invokevirtual 473	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:prepareURL	()Ljava/lang/String;
    //   7: astore 29
    //   9: aload 29
    //   11: astore 43
    //   13: getstatic 87	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:sForceHttp	Z
    //   16: ifeq +35 -> 51
    //   19: aload 29
    //   21: astore 43
    //   23: aload 29
    //   25: ldc_w 812
    //   28: invokevirtual 815	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: ifeq +20 -> 51
    //   34: aload 29
    //   36: ldc 40
    //   38: ldc 37
    //   40: invokevirtual 819	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 43
    //   45: aload_0
    //   46: aload 43
    //   48: invokevirtual 822	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setUrl	(Ljava/lang/String;)V
    //   51: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   54: lstore 24
    //   56: iconst_4
    //   57: ldc 66
    //   59: new 145	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 824
    //   69: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 43
    //   74: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_0
    //   86: invokevirtual 827	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:isAborted	()Z
    //   89: ifeq +43 -> 132
    //   92: iconst_5
    //   93: ldc 66
    //   95: new 145	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   102: ldc_w 829
    //   105: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 43
    //   110: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 831
    //   116: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: monitorexit
    //   131: return
    //   132: aload_0
    //   133: invokevirtual 834	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:resetStatus	()Z
    //   136: pop
    //   137: aload_0
    //   138: invokevirtual 837	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getStatus	()I
    //   141: ifeq +55 -> 196
    //   144: iconst_5
    //   145: ldc 66
    //   147: new 145	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 839
    //   157: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: invokevirtual 837	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getStatus	()I
    //   164: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: aload 43
    //   169: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc_w 831
    //   175: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   188: aload_0
    //   189: monitorexit
    //   190: return
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: aload_0
    //   197: iconst_1
    //   198: invokevirtual 843	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setStatus	(I)V
    //   201: aload_0
    //   202: monitorexit
    //   203: iconst_1
    //   204: istore 8
    //   206: iconst_1
    //   207: istore 9
    //   209: iconst_1
    //   210: istore 10
    //   212: iconst_1
    //   213: istore 11
    //   215: iconst_1
    //   216: istore_2
    //   217: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   220: lstore 12
    //   222: aconst_null
    //   223: astore 34
    //   225: aconst_null
    //   226: astore 35
    //   228: aconst_null
    //   229: astore 36
    //   231: aconst_null
    //   232: astore 29
    //   234: aconst_null
    //   235: astore 40
    //   237: aconst_null
    //   238: astore 33
    //   240: aconst_null
    //   241: astore 37
    //   243: aconst_null
    //   244: astore 38
    //   246: aconst_null
    //   247: astore 39
    //   249: aconst_null
    //   250: astore 42
    //   252: aconst_null
    //   253: astore 41
    //   255: aconst_null
    //   256: astore 32
    //   258: aload_0
    //   259: invokevirtual 847	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getBodyData	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$BodyData;
    //   262: astore 45
    //   264: iload_2
    //   265: istore 4
    //   267: lload 12
    //   269: lstore 14
    //   271: iload 8
    //   273: istore 5
    //   275: lload 12
    //   277: lstore 16
    //   279: iload 9
    //   281: istore 6
    //   283: lload 12
    //   285: lstore 18
    //   287: aload 42
    //   289: astore 30
    //   291: aload 29
    //   293: astore 31
    //   295: iload 10
    //   297: istore_3
    //   298: lload 12
    //   300: lstore 20
    //   302: iload 11
    //   304: istore 7
    //   306: lload 12
    //   308: lstore 22
    //   310: aload_0
    //   311: invokevirtual 850	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseBeforeSend	()V
    //   314: aload_1
    //   315: ifnull +53 -> 368
    //   318: iload_2
    //   319: istore 4
    //   321: lload 12
    //   323: lstore 14
    //   325: iload 8
    //   327: istore 5
    //   329: lload 12
    //   331: lstore 16
    //   333: iload 9
    //   335: istore 6
    //   337: lload 12
    //   339: lstore 18
    //   341: aload 42
    //   343: astore 30
    //   345: aload 29
    //   347: astore 31
    //   349: iload 10
    //   351: istore_3
    //   352: lload 12
    //   354: lstore 20
    //   356: iload 11
    //   358: istore 7
    //   360: lload 12
    //   362: lstore 22
    //   364: aload_1
    //   365: invokevirtual 853	rx/Subscriber:onStart	()V
    //   368: lload 12
    //   370: lstore 14
    //   372: aload 42
    //   374: astore 30
    //   376: aload 29
    //   378: astore 31
    //   380: lload 12
    //   382: lstore 16
    //   384: lload 12
    //   386: lstore 18
    //   388: lload 12
    //   390: lstore 20
    //   392: lload 12
    //   394: lstore 22
    //   396: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   399: lstore 12
    //   401: lload 12
    //   403: lstore 14
    //   405: aload 42
    //   407: astore 30
    //   409: aload 29
    //   411: astore 31
    //   413: lload 12
    //   415: lstore 16
    //   417: lload 12
    //   419: lstore 18
    //   421: lload 12
    //   423: lstore 20
    //   425: lload 12
    //   427: lstore 22
    //   429: aload_0
    //   430: aload 43
    //   432: invokestatic 855	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:openConnection	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   435: astore 44
    //   437: lload 12
    //   439: lstore 14
    //   441: aload 42
    //   443: astore 30
    //   445: aload 29
    //   447: astore 31
    //   449: lload 12
    //   451: lstore 16
    //   453: lload 12
    //   455: lstore 18
    //   457: lload 12
    //   459: lstore 20
    //   461: lload 12
    //   463: lstore 22
    //   465: aload 44
    //   467: aload_0
    //   468: aload 45
    //   470: invokestatic 859	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:setProperty	(Ljava/net/HttpURLConnection;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$BodyData;)V
    //   473: lload 12
    //   475: lstore 14
    //   477: aload 42
    //   479: astore 30
    //   481: aload 29
    //   483: astore 31
    //   485: lload 12
    //   487: lstore 16
    //   489: lload 12
    //   491: lstore 18
    //   493: lload 12
    //   495: lstore 20
    //   497: lload 12
    //   499: lstore 22
    //   501: aload 44
    //   503: aload_0
    //   504: invokestatic 863	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:setUserHeads	(Ljava/net/HttpURLConnection;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   507: lload 12
    //   509: lstore 14
    //   511: aload 42
    //   513: astore 30
    //   515: aload 29
    //   517: astore 31
    //   519: lload 12
    //   521: lstore 16
    //   523: lload 12
    //   525: lstore 18
    //   527: lload 12
    //   529: lstore 20
    //   531: lload 12
    //   533: lstore 22
    //   535: aload 44
    //   537: aload_0
    //   538: invokestatic 866	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:setUserCookies	(Ljava/net/HttpURLConnection;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   541: lload 12
    //   543: lstore 14
    //   545: aload 42
    //   547: astore 30
    //   549: aload 29
    //   551: astore 31
    //   553: lload 12
    //   555: lstore 16
    //   557: lload 12
    //   559: lstore 18
    //   561: lload 12
    //   563: lstore 20
    //   565: lload 12
    //   567: lstore 22
    //   569: aload_0
    //   570: monitorenter
    //   571: aload_0
    //   572: invokevirtual 827	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:isAborted	()Z
    //   575: ifeq +135 -> 710
    //   578: aload 44
    //   580: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   583: aload_0
    //   584: monitorexit
    //   585: aload_0
    //   586: monitorenter
    //   587: aload_0
    //   588: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   591: astore_1
    //   592: aload_1
    //   593: ifnull +15 -> 608
    //   596: aload_0
    //   597: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   600: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   603: aload_0
    //   604: aconst_null
    //   605: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   608: aload_0
    //   609: monitorexit
    //   610: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   613: lload 24
    //   615: lsub
    //   616: lstore 12
    //   618: iconst_4
    //   619: ldc 66
    //   621: new 145	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 875
    //   631: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 43
    //   636: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 877
    //   642: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: lload 12
    //   647: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   650: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   653: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   656: aload 43
    //   658: lload 12
    //   660: l2d
    //   661: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   664: aload_0
    //   665: aconst_null
    //   666: aconst_null
    //   667: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   670: return
    //   671: astore_1
    //   672: bipush 6
    //   674: ldc 66
    //   676: new 145	java/lang/StringBuilder
    //   679: dup
    //   680: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   683: ldc_w 891
    //   686: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: aload_1
    //   690: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   693: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   702: goto -99 -> 603
    //   705: astore_1
    //   706: aload_0
    //   707: monitorexit
    //   708: aload_1
    //   709: athrow
    //   710: aload_0
    //   711: aload 44
    //   713: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   716: aload_0
    //   717: iconst_3
    //   718: invokevirtual 843	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setStatus	(I)V
    //   721: aload_0
    //   722: monitorexit
    //   723: iconst_3
    //   724: istore_2
    //   725: iload_2
    //   726: istore 4
    //   728: lload 12
    //   730: lstore 14
    //   732: iload_2
    //   733: istore 5
    //   735: lload 12
    //   737: lstore 16
    //   739: iload_2
    //   740: istore 6
    //   742: lload 12
    //   744: lstore 18
    //   746: aload 42
    //   748: astore 30
    //   750: aload 29
    //   752: astore 31
    //   754: iload_2
    //   755: istore_3
    //   756: lload 12
    //   758: lstore 20
    //   760: iload_2
    //   761: istore 7
    //   763: lload 12
    //   765: lstore 22
    //   767: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   770: lstore 12
    //   772: iload_2
    //   773: istore 4
    //   775: lload 12
    //   777: lstore 14
    //   779: iload_2
    //   780: istore 5
    //   782: lload 12
    //   784: lstore 16
    //   786: iload_2
    //   787: istore 6
    //   789: lload 12
    //   791: lstore 18
    //   793: aload 42
    //   795: astore 30
    //   797: aload 29
    //   799: astore 31
    //   801: iload_2
    //   802: istore_3
    //   803: lload 12
    //   805: lstore 20
    //   807: iload_2
    //   808: istore 7
    //   810: lload 12
    //   812: lstore 22
    //   814: iconst_3
    //   815: ldc 66
    //   817: new 145	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   824: ldc_w 893
    //   827: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload 43
    //   832: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: ldc_w 895
    //   838: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 44
    //   843: invokevirtual 898	java/net/HttpURLConnection:getRequestProperties	()Ljava/util/Map;
    //   846: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   849: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   855: iload_2
    //   856: istore 4
    //   858: lload 12
    //   860: lstore 14
    //   862: iload_2
    //   863: istore 5
    //   865: lload 12
    //   867: lstore 16
    //   869: iload_2
    //   870: istore 6
    //   872: lload 12
    //   874: lstore 18
    //   876: aload 42
    //   878: astore 30
    //   880: aload 29
    //   882: astore 31
    //   884: iload_2
    //   885: istore_3
    //   886: lload 12
    //   888: lstore 20
    //   890: iload_2
    //   891: istore 7
    //   893: lload 12
    //   895: lstore 22
    //   897: aload 44
    //   899: invokevirtual 900	java/net/HttpURLConnection:connect	()V
    //   902: iload_2
    //   903: istore 4
    //   905: lload 12
    //   907: lstore 14
    //   909: iload_2
    //   910: istore 5
    //   912: lload 12
    //   914: lstore 16
    //   916: iload_2
    //   917: istore 6
    //   919: lload 12
    //   921: lstore 18
    //   923: aload 42
    //   925: astore 30
    //   927: aload 29
    //   929: astore 31
    //   931: iload_2
    //   932: istore_3
    //   933: lload 12
    //   935: lstore 20
    //   937: iload_2
    //   938: istore 7
    //   940: lload 12
    //   942: lstore 22
    //   944: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   947: lload 12
    //   949: lsub
    //   950: aload 43
    //   952: iconst_1
    //   953: aconst_null
    //   954: invokestatic 762	com/tencent/qqmail/utilities/report/QMHttpReportManager:connect	(JLjava/lang/String;ZLjava/lang/Throwable;)V
    //   957: iconst_4
    //   958: istore_2
    //   959: iload_2
    //   960: istore 4
    //   962: lload 12
    //   964: lstore 14
    //   966: iload_2
    //   967: istore 5
    //   969: lload 12
    //   971: lstore 16
    //   973: iload_2
    //   974: istore 6
    //   976: lload 12
    //   978: lstore 18
    //   980: aload 42
    //   982: astore 30
    //   984: aload 29
    //   986: astore 31
    //   988: iload_2
    //   989: istore_3
    //   990: lload 12
    //   992: lstore 20
    //   994: iload_2
    //   995: istore 7
    //   997: lload 12
    //   999: lstore 22
    //   1001: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1004: lstore 12
    //   1006: aload 42
    //   1008: astore 30
    //   1010: aload 29
    //   1012: astore 31
    //   1014: aload_0
    //   1015: invokevirtual 766	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getHttpMethod	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1018: getstatic 903	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod:QMHttpMethod_POST	Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1021: if_acmpne +840 -> 1861
    //   1024: aload 45
    //   1026: ifnull +829 -> 1855
    //   1029: iconst_1
    //   1030: istore 28
    //   1032: aload 42
    //   1034: astore 30
    //   1036: aload 29
    //   1038: astore 31
    //   1040: ldc_w 283
    //   1043: iload 28
    //   1045: invokestatic 907	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;Z)V
    //   1048: aload 42
    //   1050: astore 30
    //   1052: aload 29
    //   1054: astore 31
    //   1056: aload 44
    //   1058: aload 45
    //   1060: aload_0
    //   1061: invokestatic 911	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:writePostParams	(Ljava/net/HttpURLConnection;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$BodyData;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   1064: aload 42
    //   1066: astore 30
    //   1068: aload 29
    //   1070: astore 31
    //   1072: aload_0
    //   1073: invokevirtual 766	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getHttpMethod	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1076: getstatic 772	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod:QMHttpMethod_MULTIPART	Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1079: if_acmpne +1068 -> 2147
    //   1082: iconst_1
    //   1083: istore 28
    //   1085: aload 42
    //   1087: astore 30
    //   1089: aload 29
    //   1091: astore 31
    //   1093: iload 28
    //   1095: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1098: lload 12
    //   1100: lsub
    //   1101: aload 43
    //   1103: iconst_1
    //   1104: aconst_null
    //   1105: invokestatic 776	com/tencent/qqmail/utilities/report/QMHttpReportManager:post	(ZJLjava/lang/String;ZLjava/lang/Throwable;)V
    //   1108: aload 42
    //   1110: astore 30
    //   1112: aload 29
    //   1114: astore 31
    //   1116: aload_0
    //   1117: iconst_5
    //   1118: invokevirtual 843	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:setStatus	(I)V
    //   1121: aload 42
    //   1123: astore 30
    //   1125: aload 29
    //   1127: astore 31
    //   1129: lload 12
    //   1131: lstore 14
    //   1133: lload 12
    //   1135: lstore 16
    //   1137: lload 12
    //   1139: lstore 18
    //   1141: lload 12
    //   1143: lstore 20
    //   1145: lload 12
    //   1147: lstore 22
    //   1149: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1152: lstore 12
    //   1154: aload 42
    //   1156: astore 30
    //   1158: aload 29
    //   1160: astore 31
    //   1162: lload 12
    //   1164: lstore 14
    //   1166: lload 12
    //   1168: lstore 16
    //   1170: lload 12
    //   1172: lstore 18
    //   1174: lload 12
    //   1176: lstore 20
    //   1178: lload 12
    //   1180: lstore 22
    //   1182: iconst_3
    //   1183: ldc 66
    //   1185: new 145	java/lang/StringBuilder
    //   1188: dup
    //   1189: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1192: ldc_w 913
    //   1195: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload 43
    //   1200: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1209: aload 42
    //   1211: astore 30
    //   1213: aload 29
    //   1215: astore 31
    //   1217: lload 12
    //   1219: lstore 14
    //   1221: lload 12
    //   1223: lstore 16
    //   1225: lload 12
    //   1227: lstore 18
    //   1229: lload 12
    //   1231: lstore 20
    //   1233: lload 12
    //   1235: lstore 22
    //   1237: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1240: lstore 26
    //   1242: aload 42
    //   1244: astore 30
    //   1246: aload 29
    //   1248: astore 31
    //   1250: lload 12
    //   1252: lstore 14
    //   1254: lload 12
    //   1256: lstore 16
    //   1258: lload 12
    //   1260: lstore 18
    //   1262: lload 12
    //   1264: lstore 20
    //   1266: lload 12
    //   1268: lstore 22
    //   1270: aload 44
    //   1272: invokevirtual 607	java/net/HttpURLConnection:getResponseCode	()I
    //   1275: istore_2
    //   1276: aload 42
    //   1278: astore 30
    //   1280: aload 29
    //   1282: astore 31
    //   1284: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1287: lstore 14
    //   1289: iload_2
    //   1290: sipush 200
    //   1293: if_icmplt +860 -> 2153
    //   1296: iload_2
    //   1297: sipush 300
    //   1300: if_icmpge +853 -> 2153
    //   1303: iconst_1
    //   1304: istore 28
    //   1306: aload 42
    //   1308: astore 30
    //   1310: aload 29
    //   1312: astore 31
    //   1314: lload 14
    //   1316: lload 26
    //   1318: lsub
    //   1319: aload 43
    //   1321: iload 28
    //   1323: iload_2
    //   1324: aconst_null
    //   1325: invokestatic 780	com/tencent/qqmail/utilities/report/QMHttpReportManager:response	(JLjava/lang/String;ZILjava/lang/Throwable;)V
    //   1328: aload 42
    //   1330: astore 30
    //   1332: aload 29
    //   1334: astore 31
    //   1336: lload 12
    //   1338: lstore 14
    //   1340: lload 12
    //   1342: lstore 16
    //   1344: lload 12
    //   1346: lstore 18
    //   1348: lload 12
    //   1350: lstore 20
    //   1352: lload 12
    //   1354: lstore 22
    //   1356: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1359: lstore 12
    //   1361: iload 28
    //   1363: ifeq +796 -> 2159
    //   1366: aload 42
    //   1368: astore 30
    //   1370: aload 29
    //   1372: astore 31
    //   1374: lload 12
    //   1376: lstore 14
    //   1378: lload 12
    //   1380: lstore 16
    //   1382: lload 12
    //   1384: lstore 18
    //   1386: lload 12
    //   1388: lstore 20
    //   1390: lload 12
    //   1392: lstore 22
    //   1394: aload_0
    //   1395: aload 44
    //   1397: invokestatic 915	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleSendSuccess	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/net/HttpURLConnection;)Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;
    //   1400: astore 29
    //   1402: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1405: lload 12
    //   1407: lsub
    //   1408: aload 43
    //   1410: iconst_1
    //   1411: aconst_null
    //   1412: invokestatic 782	com/tencent/qqmail/utilities/report/QMHttpReportManager:read	(JLjava/lang/String;ZLjava/lang/Throwable;)V
    //   1415: aload 29
    //   1417: invokevirtual 919	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:getError	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;
    //   1420: astore 30
    //   1422: aload 30
    //   1424: astore 37
    //   1426: aload 29
    //   1428: astore 31
    //   1430: aload 30
    //   1432: astore 38
    //   1434: aload 29
    //   1436: astore 32
    //   1438: aload 30
    //   1440: astore 39
    //   1442: aload 29
    //   1444: astore 33
    //   1446: aload 30
    //   1448: astore 40
    //   1450: aload 29
    //   1452: astore 34
    //   1454: aload 30
    //   1456: astore 41
    //   1458: aload 29
    //   1460: astore 35
    //   1462: aload 30
    //   1464: astore 42
    //   1466: aload 29
    //   1468: astore 36
    //   1470: aload_0
    //   1471: aload 29
    //   1473: invokevirtual 923	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseSuccess	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;)V
    //   1476: aload_1
    //   1477: ifnull +57 -> 1534
    //   1480: aload 30
    //   1482: astore 37
    //   1484: aload 29
    //   1486: astore 31
    //   1488: aload 30
    //   1490: astore 38
    //   1492: aload 29
    //   1494: astore 32
    //   1496: aload 30
    //   1498: astore 39
    //   1500: aload 29
    //   1502: astore 33
    //   1504: aload 30
    //   1506: astore 40
    //   1508: aload 29
    //   1510: astore 34
    //   1512: aload 30
    //   1514: astore 41
    //   1516: aload 29
    //   1518: astore 35
    //   1520: aload 30
    //   1522: astore 42
    //   1524: aload 29
    //   1526: astore 36
    //   1528: aload_1
    //   1529: aload 29
    //   1531: invokevirtual 927	rx/Subscriber:onNext	(Ljava/lang/Object;)V
    //   1534: aload 30
    //   1536: astore 31
    //   1538: aload 29
    //   1540: astore 32
    //   1542: aload_1
    //   1543: ifnull +63 -> 1606
    //   1546: aload 30
    //   1548: astore 37
    //   1550: aload 29
    //   1552: astore 31
    //   1554: aload 30
    //   1556: astore 38
    //   1558: aload 29
    //   1560: astore 32
    //   1562: aload 30
    //   1564: astore 39
    //   1566: aload 29
    //   1568: astore 33
    //   1570: aload 30
    //   1572: astore 40
    //   1574: aload 29
    //   1576: astore 34
    //   1578: aload 30
    //   1580: astore 41
    //   1582: aload 29
    //   1584: astore 35
    //   1586: aload 30
    //   1588: astore 42
    //   1590: aload 29
    //   1592: astore 36
    //   1594: aload_1
    //   1595: invokevirtual 930	rx/Subscriber:onCompleted	()V
    //   1598: aload 29
    //   1600: astore 32
    //   1602: aload 30
    //   1604: astore 31
    //   1606: aload_0
    //   1607: monitorenter
    //   1608: aload_0
    //   1609: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1612: astore_1
    //   1613: aload_1
    //   1614: ifnull +15 -> 1629
    //   1617: aload_0
    //   1618: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1621: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   1624: aload_0
    //   1625: aconst_null
    //   1626: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1629: aload_0
    //   1630: monitorexit
    //   1631: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1634: lload 24
    //   1636: lsub
    //   1637: lstore 12
    //   1639: iconst_4
    //   1640: ldc 66
    //   1642: new 145	java/lang/StringBuilder
    //   1645: dup
    //   1646: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1649: ldc_w 875
    //   1652: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1655: aload 43
    //   1657: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: ldc_w 877
    //   1663: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1666: lload 12
    //   1668: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1671: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1674: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1677: aload 43
    //   1679: lload 12
    //   1681: l2d
    //   1682: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   1685: aload_0
    //   1686: aload 32
    //   1688: aload 31
    //   1690: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   1693: return
    //   1694: astore 40
    //   1696: aload_0
    //   1697: monitorexit
    //   1698: lload 12
    //   1700: lstore 14
    //   1702: aload 42
    //   1704: astore 30
    //   1706: aload 29
    //   1708: astore 31
    //   1710: lload 12
    //   1712: lstore 16
    //   1714: lload 12
    //   1716: lstore 18
    //   1718: lload 12
    //   1720: lstore 20
    //   1722: lload 12
    //   1724: lstore 22
    //   1726: aload 40
    //   1728: athrow
    //   1729: astore 31
    //   1731: iconst_0
    //   1732: istore_3
    //   1733: iconst_2
    //   1734: istore_2
    //   1735: aconst_null
    //   1736: astore 29
    //   1738: aconst_null
    //   1739: astore 30
    //   1741: lload 14
    //   1743: lstore 12
    //   1745: iload_2
    //   1746: aload_0
    //   1747: aload 29
    //   1749: aload 31
    //   1751: aload_1
    //   1752: invokestatic 932	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleClassCastException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;Ljava/lang/Exception;Lrx/Subscriber;)V
    //   1755: iload_2
    //   1756: aload_0
    //   1757: lload 12
    //   1759: aload 43
    //   1761: iload_3
    //   1762: aload 31
    //   1764: invokestatic 934	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:reportHttpException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;JLjava/lang/String;ILjava/lang/Throwable;)V
    //   1767: aload_0
    //   1768: monitorenter
    //   1769: aload_0
    //   1770: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1773: astore_1
    //   1774: aload_1
    //   1775: ifnull +15 -> 1790
    //   1778: aload_0
    //   1779: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1782: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   1785: aload_0
    //   1786: aconst_null
    //   1787: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   1790: aload_0
    //   1791: monitorexit
    //   1792: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   1795: lload 24
    //   1797: lsub
    //   1798: lstore 12
    //   1800: iconst_4
    //   1801: ldc 66
    //   1803: new 145	java/lang/StringBuilder
    //   1806: dup
    //   1807: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1810: ldc_w 875
    //   1813: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1816: aload 43
    //   1818: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1821: ldc_w 877
    //   1824: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1827: lload 12
    //   1829: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1832: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1835: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1838: aload 43
    //   1840: lload 12
    //   1842: l2d
    //   1843: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   1846: aload_0
    //   1847: aload 30
    //   1849: aload 29
    //   1851: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   1854: return
    //   1855: iconst_0
    //   1856: istore 28
    //   1858: goto -826 -> 1032
    //   1861: aload 42
    //   1863: astore 30
    //   1865: aload 29
    //   1867: astore 31
    //   1869: aload_0
    //   1870: invokevirtual 766	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getHttpMethod	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1873: getstatic 772	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod:QMHttpMethod_MULTIPART	Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$QMHttpMethod;
    //   1876: if_acmpne -812 -> 1064
    //   1879: aload 42
    //   1881: astore 30
    //   1883: aload 29
    //   1885: astore 31
    //   1887: aload_0
    //   1888: invokevirtual 937	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:isRawPost	()Z
    //   1891: ifeq +20 -> 1911
    //   1894: aload 42
    //   1896: astore 30
    //   1898: aload 29
    //   1900: astore 31
    //   1902: aload 44
    //   1904: aload_0
    //   1905: invokestatic 940	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:writeRawMultiPostParams	(Ljava/net/HttpURLConnection;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   1908: goto -844 -> 1064
    //   1911: aload 42
    //   1913: astore 30
    //   1915: aload 29
    //   1917: astore 31
    //   1919: aload_0
    //   1920: invokevirtual 944	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getFileParams	()Ljava/util/List;
    //   1923: astore 45
    //   1925: aload 42
    //   1927: astore 30
    //   1929: aload 29
    //   1931: astore 31
    //   1933: aload_0
    //   1934: invokevirtual 847	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getBodyData	()Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest$BodyData;
    //   1937: invokeinterface 947 1 0
    //   1942: iconst_1
    //   1943: invokestatic 951	com/tencent/qqmail/utilities/stringextention/StringExtention:parseParams	(Ljava/lang/String;Z)Ljava/util/List;
    //   1946: astore 46
    //   1948: aload 46
    //   1950: ifnull +191 -> 2141
    //   1953: aload 42
    //   1955: astore 30
    //   1957: aload 29
    //   1959: astore 31
    //   1961: aload 46
    //   1963: invokeinterface 240 1 0
    //   1968: ifle +173 -> 2141
    //   1971: iconst_1
    //   1972: istore 28
    //   1974: aload 42
    //   1976: astore 30
    //   1978: aload 29
    //   1980: astore 31
    //   1982: ldc_w 283
    //   1985: iload 28
    //   1987: invokestatic 907	com/tencent/qqmail/utilities/validate/ValidateHelper:assertInDebug	(Ljava/lang/String;Z)V
    //   1990: aload 42
    //   1992: astore 30
    //   1994: aload 29
    //   1996: astore 31
    //   1998: aload 44
    //   2000: aload 46
    //   2002: aload 45
    //   2004: aload_0
    //   2005: invokestatic 955	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:writeMultiPostParams	(Ljava/net/HttpURLConnection;Ljava/util/List;Ljava/util/List;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;)V
    //   2008: goto -944 -> 1064
    //   2011: astore 29
    //   2013: iconst_0
    //   2014: istore_3
    //   2015: aload 32
    //   2017: astore 30
    //   2019: aload 33
    //   2021: astore 31
    //   2023: iload_2
    //   2024: aload_0
    //   2025: aload 32
    //   2027: aload 29
    //   2029: aload_1
    //   2030: invokestatic 957	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleSSLException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;Ljava/lang/Exception;Lrx/Subscriber;)V
    //   2033: aload 32
    //   2035: astore 30
    //   2037: aload 33
    //   2039: astore 31
    //   2041: iload_2
    //   2042: aload_0
    //   2043: lload 12
    //   2045: aload 43
    //   2047: iload_3
    //   2048: aload 29
    //   2050: invokestatic 934	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:reportHttpException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;JLjava/lang/String;ILjava/lang/Throwable;)V
    //   2053: aload_0
    //   2054: monitorenter
    //   2055: aload_0
    //   2056: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2059: astore_1
    //   2060: aload_1
    //   2061: ifnull +15 -> 2076
    //   2064: aload_0
    //   2065: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2068: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   2071: aload_0
    //   2072: aconst_null
    //   2073: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2076: aload_0
    //   2077: monitorexit
    //   2078: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   2081: lload 24
    //   2083: lsub
    //   2084: lstore 12
    //   2086: iconst_4
    //   2087: ldc 66
    //   2089: new 145	java/lang/StringBuilder
    //   2092: dup
    //   2093: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2096: ldc_w 875
    //   2099: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2102: aload 43
    //   2104: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: ldc_w 877
    //   2110: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: lload 12
    //   2115: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2118: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2121: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2124: aload 43
    //   2126: lload 12
    //   2128: l2d
    //   2129: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   2132: aload_0
    //   2133: aload 33
    //   2135: aload 32
    //   2137: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   2140: return
    //   2141: iconst_0
    //   2142: istore 28
    //   2144: goto -170 -> 1974
    //   2147: iconst_0
    //   2148: istore 28
    //   2150: goto -1065 -> 1085
    //   2153: iconst_0
    //   2154: istore 28
    //   2156: goto -850 -> 1306
    //   2159: aload 42
    //   2161: astore 30
    //   2163: aload 29
    //   2165: astore 31
    //   2167: lload 12
    //   2169: lstore 14
    //   2171: lload 12
    //   2173: lstore 16
    //   2175: lload 12
    //   2177: lstore 18
    //   2179: lload 12
    //   2181: lstore 20
    //   2183: lload 12
    //   2185: lstore 22
    //   2187: aload_0
    //   2188: aload 44
    //   2190: invokestatic 959	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleSendError	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/net/HttpURLConnection;)Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;
    //   2193: astore 29
    //   2195: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   2198: lload 12
    //   2200: lsub
    //   2201: aload 43
    //   2203: iconst_1
    //   2204: aconst_null
    //   2205: invokestatic 782	com/tencent/qqmail/utilities/report/QMHttpReportManager:read	(JLjava/lang/String;ZLjava/lang/Throwable;)V
    //   2208: aload_0
    //   2209: aload 44
    //   2211: invokestatic 640	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getResponse	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/net/HttpURLConnection;)Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;
    //   2214: astore 30
    //   2216: aload 29
    //   2218: astore 37
    //   2220: aload 30
    //   2222: astore 31
    //   2224: aload 29
    //   2226: astore 38
    //   2228: aload 30
    //   2230: astore 32
    //   2232: aload 29
    //   2234: astore 39
    //   2236: aload 30
    //   2238: astore 33
    //   2240: aload 29
    //   2242: astore 40
    //   2244: aload 30
    //   2246: astore 34
    //   2248: aload 29
    //   2250: astore 41
    //   2252: aload 30
    //   2254: astore 35
    //   2256: aload 29
    //   2258: astore 42
    //   2260: aload 30
    //   2262: astore 36
    //   2264: aload 30
    //   2266: iload_2
    //   2267: invokevirtual 962	com/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse:setResponseCode	(I)V
    //   2270: aload 29
    //   2272: astore 37
    //   2274: aload 30
    //   2276: astore 31
    //   2278: aload 29
    //   2280: astore 38
    //   2282: aload 30
    //   2284: astore 32
    //   2286: aload 29
    //   2288: astore 39
    //   2290: aload 30
    //   2292: astore 33
    //   2294: aload 29
    //   2296: astore 40
    //   2298: aload 30
    //   2300: astore 34
    //   2302: aload 29
    //   2304: astore 41
    //   2306: aload 30
    //   2308: astore 35
    //   2310: aload 29
    //   2312: astore 42
    //   2314: aload 30
    //   2316: astore 36
    //   2318: aload_0
    //   2319: aload 30
    //   2321: aload 29
    //   2323: invokevirtual 412	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseError	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   2326: aload 29
    //   2328: astore 31
    //   2330: aload 30
    //   2332: astore 32
    //   2334: aload_1
    //   2335: ifnull -729 -> 1606
    //   2338: aload 29
    //   2340: astore 37
    //   2342: aload 30
    //   2344: astore 31
    //   2346: aload 29
    //   2348: astore 38
    //   2350: aload 30
    //   2352: astore 32
    //   2354: aload 29
    //   2356: astore 39
    //   2358: aload 30
    //   2360: astore 33
    //   2362: aload 29
    //   2364: astore 40
    //   2366: aload 30
    //   2368: astore 34
    //   2370: aload 29
    //   2372: astore 41
    //   2374: aload 30
    //   2376: astore 35
    //   2378: aload 29
    //   2380: astore 42
    //   2382: aload 30
    //   2384: astore 36
    //   2386: aload_1
    //   2387: aload 29
    //   2389: invokevirtual 418	rx/Subscriber:onError	(Ljava/lang/Throwable;)V
    //   2392: aload 29
    //   2394: astore 31
    //   2396: aload 30
    //   2398: astore 32
    //   2400: goto -794 -> 1606
    //   2403: astore 32
    //   2405: aload 37
    //   2407: astore 29
    //   2409: aload 31
    //   2411: astore 30
    //   2413: iload_2
    //   2414: istore_3
    //   2415: aload 32
    //   2417: astore 31
    //   2419: bipush 7
    //   2421: istore_2
    //   2422: goto -677 -> 1745
    //   2425: astore_1
    //   2426: bipush 6
    //   2428: ldc 66
    //   2430: new 145	java/lang/StringBuilder
    //   2433: dup
    //   2434: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2437: ldc_w 891
    //   2440: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2443: aload_1
    //   2444: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2447: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2450: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2453: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2456: goto -832 -> 1624
    //   2459: astore_1
    //   2460: aload_0
    //   2461: monitorexit
    //   2462: aload_1
    //   2463: athrow
    //   2464: astore_1
    //   2465: bipush 6
    //   2467: ldc 66
    //   2469: new 145	java/lang/StringBuilder
    //   2472: dup
    //   2473: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2476: ldc_w 891
    //   2479: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: aload_1
    //   2483: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2486: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2489: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2492: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2495: goto -710 -> 1785
    //   2498: astore_1
    //   2499: aload_0
    //   2500: monitorexit
    //   2501: aload_1
    //   2502: athrow
    //   2503: astore_1
    //   2504: bipush 6
    //   2506: ldc 66
    //   2508: new 145	java/lang/StringBuilder
    //   2511: dup
    //   2512: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2515: ldc_w 891
    //   2518: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2521: aload_1
    //   2522: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2525: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2528: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2531: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2534: goto -463 -> 2071
    //   2537: astore_1
    //   2538: aload_0
    //   2539: monitorexit
    //   2540: aload_1
    //   2541: athrow
    //   2542: astore 29
    //   2544: iconst_0
    //   2545: istore_3
    //   2546: aload 34
    //   2548: astore 33
    //   2550: aload 37
    //   2552: astore 32
    //   2554: lload 14
    //   2556: lstore 12
    //   2558: iload 4
    //   2560: istore_2
    //   2561: aload 32
    //   2563: astore 30
    //   2565: aload 33
    //   2567: astore 31
    //   2569: iload_2
    //   2570: aload_0
    //   2571: aload 32
    //   2573: aload 29
    //   2575: aload_1
    //   2576: invokestatic 964	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleIOException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;Ljava/lang/Exception;Lrx/Subscriber;)V
    //   2579: aload 32
    //   2581: astore 30
    //   2583: aload 33
    //   2585: astore 31
    //   2587: iload_2
    //   2588: aload_0
    //   2589: lload 12
    //   2591: aload 43
    //   2593: iload_3
    //   2594: aload 29
    //   2596: invokestatic 934	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:reportHttpException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;JLjava/lang/String;ILjava/lang/Throwable;)V
    //   2599: aload_0
    //   2600: monitorenter
    //   2601: aload_0
    //   2602: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2605: astore_1
    //   2606: aload_1
    //   2607: ifnull +15 -> 2622
    //   2610: aload_0
    //   2611: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2614: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   2617: aload_0
    //   2618: aconst_null
    //   2619: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2622: aload_0
    //   2623: monitorexit
    //   2624: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   2627: lload 24
    //   2629: lsub
    //   2630: lstore 12
    //   2632: iconst_4
    //   2633: ldc 66
    //   2635: new 145	java/lang/StringBuilder
    //   2638: dup
    //   2639: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2642: ldc_w 875
    //   2645: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2648: aload 43
    //   2650: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2653: ldc_w 877
    //   2656: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: lload 12
    //   2661: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2664: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2667: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2670: aload 43
    //   2672: lload 12
    //   2674: l2d
    //   2675: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   2678: aload_0
    //   2679: aload 33
    //   2681: aload 32
    //   2683: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   2686: return
    //   2687: astore_1
    //   2688: bipush 6
    //   2690: ldc 66
    //   2692: new 145	java/lang/StringBuilder
    //   2695: dup
    //   2696: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2699: ldc_w 891
    //   2702: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2705: aload_1
    //   2706: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2709: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2712: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2715: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2718: goto -101 -> 2617
    //   2721: astore_1
    //   2722: aload_0
    //   2723: monitorexit
    //   2724: aload_1
    //   2725: athrow
    //   2726: astore 29
    //   2728: iconst_0
    //   2729: istore_3
    //   2730: aload 35
    //   2732: astore 33
    //   2734: aload 38
    //   2736: astore 32
    //   2738: lload 16
    //   2740: lstore 12
    //   2742: iload 5
    //   2744: istore_2
    //   2745: aload 32
    //   2747: astore 30
    //   2749: aload 33
    //   2751: astore 31
    //   2753: iload_2
    //   2754: aload_0
    //   2755: aload 32
    //   2757: aload 29
    //   2759: aload_1
    //   2760: invokestatic 966	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleNoClassDefFoundError	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;Ljava/lang/Error;Lrx/Subscriber;)V
    //   2763: aload 32
    //   2765: astore 30
    //   2767: aload 33
    //   2769: astore 31
    //   2771: iload_2
    //   2772: aload_0
    //   2773: lload 12
    //   2775: aload 43
    //   2777: iload_3
    //   2778: aload 29
    //   2780: invokestatic 934	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:reportHttpException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;JLjava/lang/String;ILjava/lang/Throwable;)V
    //   2783: aload_0
    //   2784: monitorenter
    //   2785: aload_0
    //   2786: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2789: astore_1
    //   2790: aload_1
    //   2791: ifnull +15 -> 2806
    //   2794: aload_0
    //   2795: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2798: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   2801: aload_0
    //   2802: aconst_null
    //   2803: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2806: aload_0
    //   2807: monitorexit
    //   2808: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   2811: lload 24
    //   2813: lsub
    //   2814: lstore 12
    //   2816: iconst_4
    //   2817: ldc 66
    //   2819: new 145	java/lang/StringBuilder
    //   2822: dup
    //   2823: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2826: ldc_w 875
    //   2829: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: aload 43
    //   2834: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2837: ldc_w 877
    //   2840: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2843: lload 12
    //   2845: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2848: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2851: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2854: aload 43
    //   2856: lload 12
    //   2858: l2d
    //   2859: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   2862: aload_0
    //   2863: aload 33
    //   2865: aload 32
    //   2867: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   2870: return
    //   2871: astore_1
    //   2872: bipush 6
    //   2874: ldc 66
    //   2876: new 145	java/lang/StringBuilder
    //   2879: dup
    //   2880: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   2883: ldc_w 891
    //   2886: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: aload_1
    //   2890: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2893: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2896: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2899: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2902: goto -101 -> 2801
    //   2905: astore_1
    //   2906: aload_0
    //   2907: monitorexit
    //   2908: aload_1
    //   2909: athrow
    //   2910: astore 29
    //   2912: iconst_0
    //   2913: istore_3
    //   2914: aload 36
    //   2916: astore 33
    //   2918: aload 39
    //   2920: astore 32
    //   2922: lload 18
    //   2924: lstore 12
    //   2926: iload 6
    //   2928: istore_2
    //   2929: aload 32
    //   2931: astore 30
    //   2933: aload 33
    //   2935: astore 31
    //   2937: iload_2
    //   2938: aload_0
    //   2939: aload 32
    //   2941: aload 29
    //   2943: aload_1
    //   2944: invokestatic 968	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:handleOtherException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;Ljava/lang/Exception;Lrx/Subscriber;)V
    //   2947: aload 32
    //   2949: astore 30
    //   2951: aload 33
    //   2953: astore 31
    //   2955: iload_2
    //   2956: aload_0
    //   2957: lload 12
    //   2959: aload 43
    //   2961: iload_3
    //   2962: aload 29
    //   2964: invokestatic 934	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:reportHttpException	(ILcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;JLjava/lang/String;ILjava/lang/Throwable;)V
    //   2967: aload_0
    //   2968: monitorenter
    //   2969: aload_0
    //   2970: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2973: astore_1
    //   2974: aload_1
    //   2975: ifnull +15 -> 2990
    //   2978: aload_0
    //   2979: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2982: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   2985: aload_0
    //   2986: aconst_null
    //   2987: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   2990: aload_0
    //   2991: monitorexit
    //   2992: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   2995: lload 24
    //   2997: lsub
    //   2998: lstore 12
    //   3000: iconst_4
    //   3001: ldc 66
    //   3003: new 145	java/lang/StringBuilder
    //   3006: dup
    //   3007: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   3010: ldc_w 875
    //   3013: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3016: aload 43
    //   3018: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3021: ldc_w 877
    //   3024: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3027: lload 12
    //   3029: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3032: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3035: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3038: aload 43
    //   3040: lload 12
    //   3042: l2d
    //   3043: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   3046: aload_0
    //   3047: aload 33
    //   3049: aload 32
    //   3051: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   3054: return
    //   3055: astore_1
    //   3056: bipush 6
    //   3058: ldc 66
    //   3060: new 145	java/lang/StringBuilder
    //   3063: dup
    //   3064: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   3067: ldc_w 891
    //   3070: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: aload_1
    //   3074: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3077: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3080: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3083: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3086: goto -101 -> 2985
    //   3089: astore_1
    //   3090: aload_0
    //   3091: monitorexit
    //   3092: aload_1
    //   3093: athrow
    //   3094: astore_1
    //   3095: aload_0
    //   3096: monitorenter
    //   3097: aload_0
    //   3098: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   3101: astore 29
    //   3103: aload 29
    //   3105: ifnull +15 -> 3120
    //   3108: aload_0
    //   3109: getfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   3112: invokevirtual 869	java/net/HttpURLConnection:disconnect	()V
    //   3115: aload_0
    //   3116: aconst_null
    //   3117: putfield 873	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:connection	Ljava/net/HttpURLConnection;
    //   3120: aload_0
    //   3121: monitorexit
    //   3122: invokestatic 753	android/os/SystemClock:elapsedRealtime	()J
    //   3125: lload 24
    //   3127: lsub
    //   3128: lstore 12
    //   3130: iconst_4
    //   3131: ldc 66
    //   3133: new 145	java/lang/StringBuilder
    //   3136: dup
    //   3137: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   3140: ldc_w 875
    //   3143: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3146: aload 43
    //   3148: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3151: ldc_w 877
    //   3154: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3157: lload 12
    //   3159: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3162: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3165: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3168: aload 43
    //   3170: lload 12
    //   3172: l2d
    //   3173: invokestatic 886	com/tencent/qqmail/utilities/qmnetwork/CgiTimer:report	(Ljava/lang/String;D)V
    //   3176: aload_0
    //   3177: aload 31
    //   3179: aload 30
    //   3181: invokevirtual 889	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseComplete	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkResponse;Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkError;)V
    //   3184: aload_1
    //   3185: athrow
    //   3186: astore 29
    //   3188: bipush 6
    //   3190: ldc 66
    //   3192: new 145	java/lang/StringBuilder
    //   3195: dup
    //   3196: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   3199: ldc_w 891
    //   3202: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3205: aload 29
    //   3207: invokevirtual 378	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3210: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3213: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3216: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   3219: goto -104 -> 3115
    //   3222: astore_1
    //   3223: aload_0
    //   3224: monitorexit
    //   3225: aload_1
    //   3226: athrow
    //   3227: astore_1
    //   3228: aload 41
    //   3230: astore 30
    //   3232: aload 29
    //   3234: astore 31
    //   3236: goto -141 -> 3095
    //   3239: astore_1
    //   3240: aload 38
    //   3242: astore 30
    //   3244: aload 32
    //   3246: astore 31
    //   3248: goto -153 -> 3095
    //   3251: astore_1
    //   3252: aload 29
    //   3254: astore 30
    //   3256: aload 40
    //   3258: astore 31
    //   3260: goto -165 -> 3095
    //   3263: astore_1
    //   3264: aload 30
    //   3266: astore 31
    //   3268: aload 29
    //   3270: astore 30
    //   3272: goto -177 -> 3095
    //   3275: astore 29
    //   3277: iconst_0
    //   3278: istore_3
    //   3279: iconst_2
    //   3280: istore_2
    //   3281: lload 16
    //   3283: lstore 12
    //   3285: aload 39
    //   3287: astore 32
    //   3289: aload 36
    //   3291: astore 33
    //   3293: goto -364 -> 2929
    //   3296: astore 29
    //   3298: iconst_0
    //   3299: istore_3
    //   3300: aload 39
    //   3302: astore 32
    //   3304: aload 36
    //   3306: astore 33
    //   3308: goto -379 -> 2929
    //   3311: astore 29
    //   3313: lload 14
    //   3315: lstore 12
    //   3317: iconst_0
    //   3318: istore_3
    //   3319: iconst_5
    //   3320: istore_2
    //   3321: aload 39
    //   3323: astore 32
    //   3325: aload 36
    //   3327: astore 33
    //   3329: goto -400 -> 2929
    //   3332: astore 29
    //   3334: iload_2
    //   3335: istore_3
    //   3336: iconst_5
    //   3337: istore_2
    //   3338: aload 39
    //   3340: astore 32
    //   3342: aload 36
    //   3344: astore 33
    //   3346: goto -417 -> 2929
    //   3349: astore 29
    //   3351: iload_2
    //   3352: istore_3
    //   3353: bipush 6
    //   3355: istore_2
    //   3356: lload 14
    //   3358: lstore 12
    //   3360: aload 39
    //   3362: astore 32
    //   3364: aload 36
    //   3366: astore 33
    //   3368: goto -439 -> 2929
    //   3371: astore 30
    //   3373: aload 29
    //   3375: astore 33
    //   3377: iload_2
    //   3378: istore_3
    //   3379: aload 30
    //   3381: astore 29
    //   3383: bipush 6
    //   3385: istore_2
    //   3386: aload 39
    //   3388: astore 32
    //   3390: goto -461 -> 2929
    //   3393: astore 30
    //   3395: aload 29
    //   3397: astore 33
    //   3399: iload_2
    //   3400: istore_3
    //   3401: aload 30
    //   3403: astore 29
    //   3405: bipush 7
    //   3407: istore_2
    //   3408: aload 39
    //   3410: astore 32
    //   3412: goto -483 -> 2929
    //   3415: astore 29
    //   3417: aload 39
    //   3419: astore 32
    //   3421: iload_2
    //   3422: istore_3
    //   3423: bipush 7
    //   3425: istore_2
    //   3426: goto -497 -> 2929
    //   3429: astore 30
    //   3431: aload 29
    //   3433: astore 32
    //   3435: iload_2
    //   3436: istore_3
    //   3437: aload 30
    //   3439: astore 29
    //   3441: bipush 6
    //   3443: istore_2
    //   3444: aload 36
    //   3446: astore 33
    //   3448: goto -519 -> 2929
    //   3451: astore 30
    //   3453: aload 29
    //   3455: astore 32
    //   3457: iload_2
    //   3458: istore_3
    //   3459: aload 30
    //   3461: astore 29
    //   3463: bipush 7
    //   3465: istore_2
    //   3466: aload 36
    //   3468: astore 33
    //   3470: goto -541 -> 2929
    //   3473: astore 29
    //   3475: iconst_0
    //   3476: istore_3
    //   3477: iconst_2
    //   3478: istore_2
    //   3479: lload 18
    //   3481: lstore 12
    //   3483: aload 38
    //   3485: astore 32
    //   3487: aload 35
    //   3489: astore 33
    //   3491: goto -746 -> 2745
    //   3494: astore 29
    //   3496: iconst_0
    //   3497: istore_3
    //   3498: aload 38
    //   3500: astore 32
    //   3502: aload 35
    //   3504: astore 33
    //   3506: goto -761 -> 2745
    //   3509: astore 29
    //   3511: lload 16
    //   3513: lstore 12
    //   3515: iconst_0
    //   3516: istore_3
    //   3517: iconst_5
    //   3518: istore_2
    //   3519: aload 38
    //   3521: astore 32
    //   3523: aload 35
    //   3525: astore 33
    //   3527: goto -782 -> 2745
    //   3530: astore 29
    //   3532: iload_2
    //   3533: istore_3
    //   3534: iconst_5
    //   3535: istore_2
    //   3536: aload 38
    //   3538: astore 32
    //   3540: aload 35
    //   3542: astore 33
    //   3544: goto -799 -> 2745
    //   3547: astore 29
    //   3549: iload_2
    //   3550: istore_3
    //   3551: bipush 6
    //   3553: istore_2
    //   3554: lload 16
    //   3556: lstore 12
    //   3558: aload 38
    //   3560: astore 32
    //   3562: aload 35
    //   3564: astore 33
    //   3566: goto -821 -> 2745
    //   3569: astore 30
    //   3571: aload 29
    //   3573: astore 33
    //   3575: iload_2
    //   3576: istore_3
    //   3577: aload 30
    //   3579: astore 29
    //   3581: bipush 6
    //   3583: istore_2
    //   3584: aload 38
    //   3586: astore 32
    //   3588: goto -843 -> 2745
    //   3591: astore 30
    //   3593: aload 29
    //   3595: astore 33
    //   3597: iload_2
    //   3598: istore_3
    //   3599: aload 30
    //   3601: astore 29
    //   3603: bipush 7
    //   3605: istore_2
    //   3606: aload 38
    //   3608: astore 32
    //   3610: goto -865 -> 2745
    //   3613: astore 29
    //   3615: aload 40
    //   3617: astore 32
    //   3619: aload 34
    //   3621: astore 33
    //   3623: iload_2
    //   3624: istore_3
    //   3625: bipush 7
    //   3627: istore_2
    //   3628: goto -883 -> 2745
    //   3631: astore 30
    //   3633: aload 29
    //   3635: astore 32
    //   3637: iload_2
    //   3638: istore_3
    //   3639: aload 30
    //   3641: astore 29
    //   3643: bipush 6
    //   3645: istore_2
    //   3646: aload 35
    //   3648: astore 33
    //   3650: goto -905 -> 2745
    //   3653: astore 30
    //   3655: aload 29
    //   3657: astore 32
    //   3659: iload_2
    //   3660: istore_3
    //   3661: aload 30
    //   3663: astore 29
    //   3665: bipush 7
    //   3667: istore_2
    //   3668: aload 35
    //   3670: astore 33
    //   3672: goto -927 -> 2745
    //   3675: astore 29
    //   3677: iconst_0
    //   3678: istore_3
    //   3679: iconst_2
    //   3680: istore_2
    //   3681: lload 20
    //   3683: lstore 12
    //   3685: aload 37
    //   3687: astore 32
    //   3689: aload 34
    //   3691: astore 33
    //   3693: goto -1132 -> 2561
    //   3696: astore 29
    //   3698: iconst_0
    //   3699: istore_3
    //   3700: aload 37
    //   3702: astore 32
    //   3704: aload 34
    //   3706: astore 33
    //   3708: goto -1147 -> 2561
    //   3711: astore 29
    //   3713: lload 18
    //   3715: lstore 12
    //   3717: iconst_0
    //   3718: istore_3
    //   3719: iconst_5
    //   3720: istore_2
    //   3721: aload 37
    //   3723: astore 32
    //   3725: aload 34
    //   3727: astore 33
    //   3729: goto -1168 -> 2561
    //   3732: astore 29
    //   3734: iload_2
    //   3735: istore_3
    //   3736: iconst_5
    //   3737: istore_2
    //   3738: aload 37
    //   3740: astore 32
    //   3742: aload 34
    //   3744: astore 33
    //   3746: goto -1185 -> 2561
    //   3749: astore 29
    //   3751: iload_2
    //   3752: istore_3
    //   3753: bipush 6
    //   3755: istore_2
    //   3756: lload 18
    //   3758: lstore 12
    //   3760: aload 37
    //   3762: astore 32
    //   3764: aload 34
    //   3766: astore 33
    //   3768: goto -1207 -> 2561
    //   3771: astore 30
    //   3773: aload 29
    //   3775: astore 33
    //   3777: iload_2
    //   3778: istore_3
    //   3779: aload 30
    //   3781: astore 29
    //   3783: bipush 6
    //   3785: istore_2
    //   3786: aload 37
    //   3788: astore 32
    //   3790: goto -1229 -> 2561
    //   3793: astore 30
    //   3795: aload 29
    //   3797: astore 33
    //   3799: iload_2
    //   3800: istore_3
    //   3801: aload 30
    //   3803: astore 29
    //   3805: bipush 7
    //   3807: istore_2
    //   3808: aload 37
    //   3810: astore 32
    //   3812: goto -1251 -> 2561
    //   3815: astore 29
    //   3817: aload 41
    //   3819: astore 32
    //   3821: aload 35
    //   3823: astore 33
    //   3825: iload_2
    //   3826: istore_3
    //   3827: bipush 7
    //   3829: istore_2
    //   3830: goto -1269 -> 2561
    //   3833: astore 30
    //   3835: aload 29
    //   3837: astore 32
    //   3839: iload_2
    //   3840: istore_3
    //   3841: aload 30
    //   3843: astore 29
    //   3845: bipush 6
    //   3847: istore_2
    //   3848: aload 34
    //   3850: astore 33
    //   3852: goto -1291 -> 2561
    //   3855: astore 30
    //   3857: aload 29
    //   3859: astore 32
    //   3861: iload_2
    //   3862: istore_3
    //   3863: aload 30
    //   3865: astore 29
    //   3867: bipush 7
    //   3869: istore_2
    //   3870: aload 34
    //   3872: astore 33
    //   3874: goto -1313 -> 2561
    //   3877: astore 29
    //   3879: iconst_0
    //   3880: istore 4
    //   3882: iload_3
    //   3883: istore_2
    //   3884: lload 20
    //   3886: lstore 12
    //   3888: iload 4
    //   3890: istore_3
    //   3891: goto -1876 -> 2015
    //   3894: astore 29
    //   3896: iconst_0
    //   3897: istore_3
    //   3898: iconst_2
    //   3899: istore_2
    //   3900: lload 22
    //   3902: lstore 12
    //   3904: goto -1889 -> 2015
    //   3907: astore 29
    //   3909: lload 20
    //   3911: lstore 12
    //   3913: iconst_0
    //   3914: istore_3
    //   3915: iconst_5
    //   3916: istore_2
    //   3917: goto -1902 -> 2015
    //   3920: astore 29
    //   3922: iload_2
    //   3923: istore_3
    //   3924: iconst_5
    //   3925: istore_2
    //   3926: goto -1911 -> 2015
    //   3929: astore 29
    //   3931: iload_2
    //   3932: istore_3
    //   3933: bipush 6
    //   3935: istore_2
    //   3936: lload 20
    //   3938: lstore 12
    //   3940: goto -1925 -> 2015
    //   3943: astore 30
    //   3945: aload 29
    //   3947: astore 33
    //   3949: iload_2
    //   3950: istore_3
    //   3951: aload 30
    //   3953: astore 29
    //   3955: bipush 6
    //   3957: istore_2
    //   3958: goto -1943 -> 2015
    //   3961: astore 30
    //   3963: aload 29
    //   3965: astore 33
    //   3967: iload_2
    //   3968: istore_3
    //   3969: aload 30
    //   3971: astore 29
    //   3973: bipush 7
    //   3975: istore_2
    //   3976: goto -1961 -> 2015
    //   3979: astore 29
    //   3981: aload 42
    //   3983: astore 32
    //   3985: aload 36
    //   3987: astore 33
    //   3989: iload_2
    //   3990: istore_3
    //   3991: bipush 7
    //   3993: istore_2
    //   3994: goto -1979 -> 2015
    //   3997: astore 30
    //   3999: aload 29
    //   4001: astore 32
    //   4003: iload_2
    //   4004: istore_3
    //   4005: aload 30
    //   4007: astore 29
    //   4009: bipush 6
    //   4011: istore_2
    //   4012: goto -1997 -> 2015
    //   4015: astore 30
    //   4017: aload 29
    //   4019: astore 32
    //   4021: iload_2
    //   4022: istore_3
    //   4023: aload 30
    //   4025: astore 29
    //   4027: bipush 7
    //   4029: istore_2
    //   4030: goto -2015 -> 2015
    //   4033: astore 31
    //   4035: iconst_0
    //   4036: istore_3
    //   4037: aconst_null
    //   4038: astore 29
    //   4040: aconst_null
    //   4041: astore 30
    //   4043: iload 7
    //   4045: istore_2
    //   4046: lload 22
    //   4048: lstore 12
    //   4050: goto -2305 -> 1745
    //   4053: astore 31
    //   4055: lload 22
    //   4057: lstore 12
    //   4059: iconst_0
    //   4060: istore_3
    //   4061: iconst_5
    //   4062: istore_2
    //   4063: aconst_null
    //   4064: astore 29
    //   4066: aconst_null
    //   4067: astore 30
    //   4069: goto -2324 -> 1745
    //   4072: astore 31
    //   4074: aconst_null
    //   4075: astore 29
    //   4077: iload_2
    //   4078: istore_3
    //   4079: aconst_null
    //   4080: astore 30
    //   4082: iconst_5
    //   4083: istore_2
    //   4084: goto -2339 -> 1745
    //   4087: astore 31
    //   4089: aconst_null
    //   4090: astore 29
    //   4092: iload_2
    //   4093: istore_3
    //   4094: aconst_null
    //   4095: astore 30
    //   4097: bipush 6
    //   4099: istore_2
    //   4100: lload 22
    //   4102: lstore 12
    //   4104: goto -2359 -> 1745
    //   4107: astore 31
    //   4109: aconst_null
    //   4110: astore 32
    //   4112: iload_2
    //   4113: istore_3
    //   4114: aload 29
    //   4116: astore 30
    //   4118: bipush 6
    //   4120: istore_2
    //   4121: aload 32
    //   4123: astore 29
    //   4125: goto -2380 -> 1745
    //   4128: astore 31
    //   4130: aconst_null
    //   4131: astore 32
    //   4133: iload_2
    //   4134: istore_3
    //   4135: aload 29
    //   4137: astore 30
    //   4139: bipush 7
    //   4141: istore_2
    //   4142: aload 32
    //   4144: astore 29
    //   4146: goto -2401 -> 1745
    //   4149: astore 31
    //   4151: aconst_null
    //   4152: astore 30
    //   4154: iload_2
    //   4155: istore_3
    //   4156: bipush 6
    //   4158: istore_2
    //   4159: goto -2414 -> 1745
    //   4162: astore 31
    //   4164: aconst_null
    //   4165: astore 30
    //   4167: iload_2
    //   4168: istore_3
    //   4169: bipush 7
    //   4171: istore_2
    //   4172: goto -2427 -> 1745
    //   4175: astore 31
    //   4177: iconst_0
    //   4178: istore_3
    //   4179: aconst_null
    //   4180: astore 29
    //   4182: aconst_null
    //   4183: astore 30
    //   4185: goto -2440 -> 1745
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4188	0	paramQMNetworkRequest	QMNetworkRequest
    //   0	4188	1	paramSubscriber	Subscriber<? super QMNetworkResponse>
    //   216	3956	2	i	int
    //   297	3882	3	j	int
    //   265	3624	4	k	int
    //   273	2470	5	m	int
    //   281	2646	6	n	int
    //   304	3740	7	i1	int
    //   204	122	8	i2	int
    //   207	127	9	i3	int
    //   210	140	10	i4	int
    //   213	144	11	i5	int
    //   220	3883	12	l1	long
    //   269	3088	14	l2	long
    //   277	3278	16	l3	long
    //   285	3472	18	l4	long
    //   300	3637	20	l5	long
    //   308	3793	22	l6	long
    //   54	3072	24	l7	long
    //   1240	77	26	l8	long
    //   1030	1125	28	bool	boolean
    //   7	1988	29	localObject1	Object
    //   2011	153	29	localSSLException1	javax.net.ssl.SSLException
    //   2193	215	29	localObject2	Object
    //   2542	53	29	localIOException1	IOException
    //   2726	53	29	localNoClassDefFoundError1	java.lang.NoClassDefFoundError
    //   2910	53	29	localException1	Exception
    //   3101	3	29	localHttpURLConnection1	HttpURLConnection
    //   3186	83	29	localException2	Exception
    //   3275	1	29	localException3	Exception
    //   3296	1	29	localException4	Exception
    //   3311	1	29	localException5	Exception
    //   3332	1	29	localException6	Exception
    //   3349	25	29	localException7	Exception
    //   3381	23	29	localObject3	Object
    //   3415	17	29	localException8	Exception
    //   3439	23	29	localObject4	Object
    //   3473	1	29	localNoClassDefFoundError2	java.lang.NoClassDefFoundError
    //   3494	1	29	localNoClassDefFoundError3	java.lang.NoClassDefFoundError
    //   3509	1	29	localNoClassDefFoundError4	java.lang.NoClassDefFoundError
    //   3530	1	29	localNoClassDefFoundError5	java.lang.NoClassDefFoundError
    //   3547	25	29	localNoClassDefFoundError6	java.lang.NoClassDefFoundError
    //   3579	23	29	localObject5	Object
    //   3613	21	29	localNoClassDefFoundError7	java.lang.NoClassDefFoundError
    //   3641	23	29	localObject6	Object
    //   3675	1	29	localIOException2	IOException
    //   3696	1	29	localIOException3	IOException
    //   3711	1	29	localIOException4	IOException
    //   3732	1	29	localIOException5	IOException
    //   3749	25	29	localIOException6	IOException
    //   3781	23	29	localObject7	Object
    //   3815	21	29	localIOException7	IOException
    //   3843	23	29	localObject8	Object
    //   3877	1	29	localSSLException2	javax.net.ssl.SSLException
    //   3894	1	29	localSSLException3	javax.net.ssl.SSLException
    //   3907	1	29	localSSLException4	javax.net.ssl.SSLException
    //   3920	1	29	localSSLException5	javax.net.ssl.SSLException
    //   3929	17	29	localSSLException6	javax.net.ssl.SSLException
    //   3953	19	29	localObject9	Object
    //   3979	21	29	localSSLException7	javax.net.ssl.SSLException
    //   4007	174	29	localObject10	Object
    //   289	2982	30	localObject11	Object
    //   3371	9	30	localException9	Exception
    //   3393	9	30	localException10	Exception
    //   3429	9	30	localException11	Exception
    //   3451	9	30	localException12	Exception
    //   3569	9	30	localNoClassDefFoundError8	java.lang.NoClassDefFoundError
    //   3591	9	30	localNoClassDefFoundError9	java.lang.NoClassDefFoundError
    //   3631	9	30	localNoClassDefFoundError10	java.lang.NoClassDefFoundError
    //   3653	9	30	localNoClassDefFoundError11	java.lang.NoClassDefFoundError
    //   3771	9	30	localIOException8	IOException
    //   3793	9	30	localIOException9	IOException
    //   3833	9	30	localIOException10	IOException
    //   3855	9	30	localIOException11	IOException
    //   3943	9	30	localSSLException8	javax.net.ssl.SSLException
    //   3961	9	30	localSSLException9	javax.net.ssl.SSLException
    //   3997	9	30	localSSLException10	javax.net.ssl.SSLException
    //   4015	9	30	localSSLException11	javax.net.ssl.SSLException
    //   4041	143	30	localObject12	Object
    //   293	1416	31	localObject13	Object
    //   1729	34	31	localClassCastException1	java.lang.ClassCastException
    //   1867	1400	31	localObject14	Object
    //   4033	1	31	localClassCastException2	java.lang.ClassCastException
    //   4053	1	31	localClassCastException3	java.lang.ClassCastException
    //   4072	1	31	localClassCastException4	java.lang.ClassCastException
    //   4087	1	31	localClassCastException5	java.lang.ClassCastException
    //   4107	1	31	localClassCastException6	java.lang.ClassCastException
    //   4128	1	31	localClassCastException7	java.lang.ClassCastException
    //   4149	1	31	localClassCastException8	java.lang.ClassCastException
    //   4162	1	31	localClassCastException9	java.lang.ClassCastException
    //   4175	1	31	localClassCastException10	java.lang.ClassCastException
    //   256	2143	32	localObject15	Object
    //   2403	13	32	localClassCastException11	java.lang.ClassCastException
    //   2552	1591	32	localObject16	Object
    //   238	3750	33	localObject17	Object
    //   223	3648	34	localObject18	Object
    //   226	3596	35	localObject19	Object
    //   229	3757	36	localObject20	Object
    //   241	3568	37	localObject21	Object
    //   244	3363	38	localObject22	Object
    //   247	3171	39	localObject23	Object
    //   235	1338	40	localObject24	Object
    //   1694	33	40	localObject25	Object
    //   2242	1374	40	localObject26	Object
    //   253	3565	41	localObject27	Object
    //   250	3732	42	localObject28	Object
    //   11	3158	43	localObject29	Object
    //   435	1775	44	localHttpURLConnection2	HttpURLConnection
    //   262	1741	45	localObject30	Object
    //   1946	55	46	localList	List
    // Exception table:
    //   from	to	target	type
    //   85	131	191	finally
    //   132	190	191	finally
    //   192	194	191	finally
    //   196	203	191	finally
    //   596	603	671	java/lang/Exception
    //   587	592	705	finally
    //   596	603	705	finally
    //   603	608	705	finally
    //   608	610	705	finally
    //   672	702	705	finally
    //   706	708	705	finally
    //   571	585	1694	finally
    //   710	723	1694	finally
    //   1696	1698	1694	finally
    //   396	401	1729	java/lang/ClassCastException
    //   429	437	1729	java/lang/ClassCastException
    //   465	473	1729	java/lang/ClassCastException
    //   501	507	1729	java/lang/ClassCastException
    //   535	541	1729	java/lang/ClassCastException
    //   569	571	1729	java/lang/ClassCastException
    //   1726	1729	1729	java/lang/ClassCastException
    //   1014	1024	2011	javax/net/ssl/SSLException
    //   1040	1048	2011	javax/net/ssl/SSLException
    //   1056	1064	2011	javax/net/ssl/SSLException
    //   1072	1082	2011	javax/net/ssl/SSLException
    //   1093	1108	2011	javax/net/ssl/SSLException
    //   1116	1121	2011	javax/net/ssl/SSLException
    //   1869	1879	2011	javax/net/ssl/SSLException
    //   1887	1894	2011	javax/net/ssl/SSLException
    //   1902	1908	2011	javax/net/ssl/SSLException
    //   1919	1925	2011	javax/net/ssl/SSLException
    //   1933	1948	2011	javax/net/ssl/SSLException
    //   1961	1971	2011	javax/net/ssl/SSLException
    //   1982	1990	2011	javax/net/ssl/SSLException
    //   1998	2008	2011	javax/net/ssl/SSLException
    //   1470	1476	2403	java/lang/ClassCastException
    //   1528	1534	2403	java/lang/ClassCastException
    //   1594	1598	2403	java/lang/ClassCastException
    //   2264	2270	2403	java/lang/ClassCastException
    //   2318	2326	2403	java/lang/ClassCastException
    //   2386	2392	2403	java/lang/ClassCastException
    //   1617	1624	2425	java/lang/Exception
    //   1608	1613	2459	finally
    //   1617	1624	2459	finally
    //   1624	1629	2459	finally
    //   1629	1631	2459	finally
    //   2426	2456	2459	finally
    //   2460	2462	2459	finally
    //   1778	1785	2464	java/lang/Exception
    //   1769	1774	2498	finally
    //   1778	1785	2498	finally
    //   1785	1790	2498	finally
    //   1790	1792	2498	finally
    //   2465	2495	2498	finally
    //   2499	2501	2498	finally
    //   2064	2071	2503	java/lang/Exception
    //   2055	2060	2537	finally
    //   2064	2071	2537	finally
    //   2071	2076	2537	finally
    //   2076	2078	2537	finally
    //   2504	2534	2537	finally
    //   2538	2540	2537	finally
    //   310	314	2542	java/io/IOException
    //   364	368	2542	java/io/IOException
    //   767	772	2542	java/io/IOException
    //   814	855	2542	java/io/IOException
    //   897	902	2542	java/io/IOException
    //   944	957	2542	java/io/IOException
    //   1001	1006	2542	java/io/IOException
    //   2610	2617	2687	java/lang/Exception
    //   2601	2606	2721	finally
    //   2610	2617	2721	finally
    //   2617	2622	2721	finally
    //   2622	2624	2721	finally
    //   2688	2718	2721	finally
    //   2722	2724	2721	finally
    //   310	314	2726	java/lang/NoClassDefFoundError
    //   364	368	2726	java/lang/NoClassDefFoundError
    //   767	772	2726	java/lang/NoClassDefFoundError
    //   814	855	2726	java/lang/NoClassDefFoundError
    //   897	902	2726	java/lang/NoClassDefFoundError
    //   944	957	2726	java/lang/NoClassDefFoundError
    //   1001	1006	2726	java/lang/NoClassDefFoundError
    //   2794	2801	2871	java/lang/Exception
    //   2785	2790	2905	finally
    //   2794	2801	2905	finally
    //   2801	2806	2905	finally
    //   2806	2808	2905	finally
    //   2872	2902	2905	finally
    //   2906	2908	2905	finally
    //   310	314	2910	java/lang/Exception
    //   364	368	2910	java/lang/Exception
    //   767	772	2910	java/lang/Exception
    //   814	855	2910	java/lang/Exception
    //   897	902	2910	java/lang/Exception
    //   944	957	2910	java/lang/Exception
    //   1001	1006	2910	java/lang/Exception
    //   2978	2985	3055	java/lang/Exception
    //   2969	2974	3089	finally
    //   2978	2985	3089	finally
    //   2985	2990	3089	finally
    //   2990	2992	3089	finally
    //   3056	3086	3089	finally
    //   3090	3092	3089	finally
    //   310	314	3094	finally
    //   364	368	3094	finally
    //   396	401	3094	finally
    //   429	437	3094	finally
    //   465	473	3094	finally
    //   501	507	3094	finally
    //   535	541	3094	finally
    //   569	571	3094	finally
    //   767	772	3094	finally
    //   814	855	3094	finally
    //   897	902	3094	finally
    //   944	957	3094	finally
    //   1001	1006	3094	finally
    //   1014	1024	3094	finally
    //   1040	1048	3094	finally
    //   1056	1064	3094	finally
    //   1072	1082	3094	finally
    //   1093	1108	3094	finally
    //   1116	1121	3094	finally
    //   1149	1154	3094	finally
    //   1182	1209	3094	finally
    //   1237	1242	3094	finally
    //   1270	1276	3094	finally
    //   1284	1289	3094	finally
    //   1314	1328	3094	finally
    //   1356	1361	3094	finally
    //   1394	1402	3094	finally
    //   1726	1729	3094	finally
    //   1869	1879	3094	finally
    //   1887	1894	3094	finally
    //   1902	1908	3094	finally
    //   1919	1925	3094	finally
    //   1933	1948	3094	finally
    //   1961	1971	3094	finally
    //   1982	1990	3094	finally
    //   1998	2008	3094	finally
    //   2023	2033	3094	finally
    //   2041	2053	3094	finally
    //   2187	2195	3094	finally
    //   2569	2579	3094	finally
    //   2587	2599	3094	finally
    //   2753	2763	3094	finally
    //   2771	2783	3094	finally
    //   2937	2947	3094	finally
    //   2955	2967	3094	finally
    //   3108	3115	3186	java/lang/Exception
    //   3097	3103	3222	finally
    //   3108	3115	3222	finally
    //   3115	3120	3222	finally
    //   3120	3122	3222	finally
    //   3188	3219	3222	finally
    //   3223	3225	3222	finally
    //   1402	1415	3227	finally
    //   1415	1422	3227	finally
    //   1470	1476	3239	finally
    //   1528	1534	3239	finally
    //   1594	1598	3239	finally
    //   2264	2270	3239	finally
    //   2318	2326	3239	finally
    //   2386	2392	3239	finally
    //   2195	2208	3251	finally
    //   2208	2216	3251	finally
    //   1745	1767	3263	finally
    //   396	401	3275	java/lang/Exception
    //   429	437	3275	java/lang/Exception
    //   465	473	3275	java/lang/Exception
    //   501	507	3275	java/lang/Exception
    //   535	541	3275	java/lang/Exception
    //   569	571	3275	java/lang/Exception
    //   1726	1729	3275	java/lang/Exception
    //   1014	1024	3296	java/lang/Exception
    //   1040	1048	3296	java/lang/Exception
    //   1056	1064	3296	java/lang/Exception
    //   1072	1082	3296	java/lang/Exception
    //   1093	1108	3296	java/lang/Exception
    //   1116	1121	3296	java/lang/Exception
    //   1869	1879	3296	java/lang/Exception
    //   1887	1894	3296	java/lang/Exception
    //   1902	1908	3296	java/lang/Exception
    //   1919	1925	3296	java/lang/Exception
    //   1933	1948	3296	java/lang/Exception
    //   1961	1971	3296	java/lang/Exception
    //   1982	1990	3296	java/lang/Exception
    //   1998	2008	3296	java/lang/Exception
    //   1149	1154	3311	java/lang/Exception
    //   1182	1209	3311	java/lang/Exception
    //   1237	1242	3311	java/lang/Exception
    //   1270	1276	3311	java/lang/Exception
    //   1284	1289	3332	java/lang/Exception
    //   1314	1328	3332	java/lang/Exception
    //   1356	1361	3349	java/lang/Exception
    //   1394	1402	3349	java/lang/Exception
    //   2187	2195	3349	java/lang/Exception
    //   1402	1415	3371	java/lang/Exception
    //   1415	1422	3393	java/lang/Exception
    //   1470	1476	3415	java/lang/Exception
    //   1528	1534	3415	java/lang/Exception
    //   1594	1598	3415	java/lang/Exception
    //   2264	2270	3415	java/lang/Exception
    //   2318	2326	3415	java/lang/Exception
    //   2386	2392	3415	java/lang/Exception
    //   2195	2208	3429	java/lang/Exception
    //   2208	2216	3451	java/lang/Exception
    //   396	401	3473	java/lang/NoClassDefFoundError
    //   429	437	3473	java/lang/NoClassDefFoundError
    //   465	473	3473	java/lang/NoClassDefFoundError
    //   501	507	3473	java/lang/NoClassDefFoundError
    //   535	541	3473	java/lang/NoClassDefFoundError
    //   569	571	3473	java/lang/NoClassDefFoundError
    //   1726	1729	3473	java/lang/NoClassDefFoundError
    //   1014	1024	3494	java/lang/NoClassDefFoundError
    //   1040	1048	3494	java/lang/NoClassDefFoundError
    //   1056	1064	3494	java/lang/NoClassDefFoundError
    //   1072	1082	3494	java/lang/NoClassDefFoundError
    //   1093	1108	3494	java/lang/NoClassDefFoundError
    //   1116	1121	3494	java/lang/NoClassDefFoundError
    //   1869	1879	3494	java/lang/NoClassDefFoundError
    //   1887	1894	3494	java/lang/NoClassDefFoundError
    //   1902	1908	3494	java/lang/NoClassDefFoundError
    //   1919	1925	3494	java/lang/NoClassDefFoundError
    //   1933	1948	3494	java/lang/NoClassDefFoundError
    //   1961	1971	3494	java/lang/NoClassDefFoundError
    //   1982	1990	3494	java/lang/NoClassDefFoundError
    //   1998	2008	3494	java/lang/NoClassDefFoundError
    //   1149	1154	3509	java/lang/NoClassDefFoundError
    //   1182	1209	3509	java/lang/NoClassDefFoundError
    //   1237	1242	3509	java/lang/NoClassDefFoundError
    //   1270	1276	3509	java/lang/NoClassDefFoundError
    //   1284	1289	3530	java/lang/NoClassDefFoundError
    //   1314	1328	3530	java/lang/NoClassDefFoundError
    //   1356	1361	3547	java/lang/NoClassDefFoundError
    //   1394	1402	3547	java/lang/NoClassDefFoundError
    //   2187	2195	3547	java/lang/NoClassDefFoundError
    //   1402	1415	3569	java/lang/NoClassDefFoundError
    //   1415	1422	3591	java/lang/NoClassDefFoundError
    //   1470	1476	3613	java/lang/NoClassDefFoundError
    //   1528	1534	3613	java/lang/NoClassDefFoundError
    //   1594	1598	3613	java/lang/NoClassDefFoundError
    //   2264	2270	3613	java/lang/NoClassDefFoundError
    //   2318	2326	3613	java/lang/NoClassDefFoundError
    //   2386	2392	3613	java/lang/NoClassDefFoundError
    //   2195	2208	3631	java/lang/NoClassDefFoundError
    //   2208	2216	3653	java/lang/NoClassDefFoundError
    //   396	401	3675	java/io/IOException
    //   429	437	3675	java/io/IOException
    //   465	473	3675	java/io/IOException
    //   501	507	3675	java/io/IOException
    //   535	541	3675	java/io/IOException
    //   569	571	3675	java/io/IOException
    //   1726	1729	3675	java/io/IOException
    //   1014	1024	3696	java/io/IOException
    //   1040	1048	3696	java/io/IOException
    //   1056	1064	3696	java/io/IOException
    //   1072	1082	3696	java/io/IOException
    //   1093	1108	3696	java/io/IOException
    //   1116	1121	3696	java/io/IOException
    //   1869	1879	3696	java/io/IOException
    //   1887	1894	3696	java/io/IOException
    //   1902	1908	3696	java/io/IOException
    //   1919	1925	3696	java/io/IOException
    //   1933	1948	3696	java/io/IOException
    //   1961	1971	3696	java/io/IOException
    //   1982	1990	3696	java/io/IOException
    //   1998	2008	3696	java/io/IOException
    //   1149	1154	3711	java/io/IOException
    //   1182	1209	3711	java/io/IOException
    //   1237	1242	3711	java/io/IOException
    //   1270	1276	3711	java/io/IOException
    //   1284	1289	3732	java/io/IOException
    //   1314	1328	3732	java/io/IOException
    //   1356	1361	3749	java/io/IOException
    //   1394	1402	3749	java/io/IOException
    //   2187	2195	3749	java/io/IOException
    //   1402	1415	3771	java/io/IOException
    //   1415	1422	3793	java/io/IOException
    //   1470	1476	3815	java/io/IOException
    //   1528	1534	3815	java/io/IOException
    //   1594	1598	3815	java/io/IOException
    //   2264	2270	3815	java/io/IOException
    //   2318	2326	3815	java/io/IOException
    //   2386	2392	3815	java/io/IOException
    //   2195	2208	3833	java/io/IOException
    //   2208	2216	3855	java/io/IOException
    //   310	314	3877	javax/net/ssl/SSLException
    //   364	368	3877	javax/net/ssl/SSLException
    //   767	772	3877	javax/net/ssl/SSLException
    //   814	855	3877	javax/net/ssl/SSLException
    //   897	902	3877	javax/net/ssl/SSLException
    //   944	957	3877	javax/net/ssl/SSLException
    //   1001	1006	3877	javax/net/ssl/SSLException
    //   396	401	3894	javax/net/ssl/SSLException
    //   429	437	3894	javax/net/ssl/SSLException
    //   465	473	3894	javax/net/ssl/SSLException
    //   501	507	3894	javax/net/ssl/SSLException
    //   535	541	3894	javax/net/ssl/SSLException
    //   569	571	3894	javax/net/ssl/SSLException
    //   1726	1729	3894	javax/net/ssl/SSLException
    //   1149	1154	3907	javax/net/ssl/SSLException
    //   1182	1209	3907	javax/net/ssl/SSLException
    //   1237	1242	3907	javax/net/ssl/SSLException
    //   1270	1276	3907	javax/net/ssl/SSLException
    //   1284	1289	3920	javax/net/ssl/SSLException
    //   1314	1328	3920	javax/net/ssl/SSLException
    //   1356	1361	3929	javax/net/ssl/SSLException
    //   1394	1402	3929	javax/net/ssl/SSLException
    //   2187	2195	3929	javax/net/ssl/SSLException
    //   1402	1415	3943	javax/net/ssl/SSLException
    //   1415	1422	3961	javax/net/ssl/SSLException
    //   1470	1476	3979	javax/net/ssl/SSLException
    //   1528	1534	3979	javax/net/ssl/SSLException
    //   1594	1598	3979	javax/net/ssl/SSLException
    //   2264	2270	3979	javax/net/ssl/SSLException
    //   2318	2326	3979	javax/net/ssl/SSLException
    //   2386	2392	3979	javax/net/ssl/SSLException
    //   2195	2208	3997	javax/net/ssl/SSLException
    //   2208	2216	4015	javax/net/ssl/SSLException
    //   310	314	4033	java/lang/ClassCastException
    //   364	368	4033	java/lang/ClassCastException
    //   767	772	4033	java/lang/ClassCastException
    //   814	855	4033	java/lang/ClassCastException
    //   897	902	4033	java/lang/ClassCastException
    //   944	957	4033	java/lang/ClassCastException
    //   1001	1006	4033	java/lang/ClassCastException
    //   1149	1154	4053	java/lang/ClassCastException
    //   1182	1209	4053	java/lang/ClassCastException
    //   1237	1242	4053	java/lang/ClassCastException
    //   1270	1276	4053	java/lang/ClassCastException
    //   1284	1289	4072	java/lang/ClassCastException
    //   1314	1328	4072	java/lang/ClassCastException
    //   1356	1361	4087	java/lang/ClassCastException
    //   1394	1402	4087	java/lang/ClassCastException
    //   2187	2195	4087	java/lang/ClassCastException
    //   1402	1415	4107	java/lang/ClassCastException
    //   1415	1422	4128	java/lang/ClassCastException
    //   2195	2208	4149	java/lang/ClassCastException
    //   2208	2216	4162	java/lang/ClassCastException
    //   1014	1024	4175	java/lang/ClassCastException
    //   1040	1048	4175	java/lang/ClassCastException
    //   1056	1064	4175	java/lang/ClassCastException
    //   1072	1082	4175	java/lang/ClassCastException
    //   1093	1108	4175	java/lang/ClassCastException
    //   1116	1121	4175	java/lang/ClassCastException
    //   1869	1879	4175	java/lang/ClassCastException
    //   1887	1894	4175	java/lang/ClassCastException
    //   1902	1908	4175	java/lang/ClassCastException
    //   1919	1925	4175	java/lang/ClassCastException
    //   1933	1948	4175	java/lang/ClassCastException
    //   1961	1971	4175	java/lang/ClassCastException
    //   1982	1990	4175	java/lang/ClassCastException
    //   1998	2008	4175	java/lang/ClassCastException
  }
  
  public static void setForceHttp(boolean paramBoolean)
  {
    sForceHttp = paramBoolean;
    SPManager.getEditor("http_info").putBoolean("force_http", paramBoolean).apply();
  }
  
  public static void setProblemProxyEnable(boolean paramBoolean)
  {
    sEnableProblemProxy = paramBoolean;
    SPManager.getEditor("http_info").putBoolean("problem_proxy", paramBoolean).apply();
  }
  
  @SuppressLint({"NewApi"})
  private static void setProperty(HttpURLConnection paramHttpURLConnection, QMNetworkRequest paramQMNetworkRequest, QMNetworkRequest.BodyData paramBodyData)
    throws IOException
  {
    if (paramQMNetworkRequest.connectTimeout > 0) {
      paramHttpURLConnection.setConnectTimeout(paramQMNetworkRequest.connectTimeout);
    }
    label30:
    QMNetworkRequest.QMHttpMethod localQMHttpMethod;
    label83:
    label119:
    do
    {
      break label119;
      if (paramQMNetworkRequest.readTimeout > 0)
      {
        paramHttpURLConnection.setReadTimeout(paramQMNetworkRequest.readTimeout);
        paramHttpURLConnection.setInstanceFollowRedirects(true);
        paramHttpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
        paramHttpURLConnection.setUseCaches(false);
        localQMHttpMethod = paramQMNetworkRequest.getHttpMethod();
        if ((localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST) && (localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART)) {
          break label154;
        }
        paramHttpURLConnection.setRequestMethod("POST");
        paramHttpURLConnection.setDoOutput(true);
        if (localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART) {
          break label171;
        }
        paramHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------7d4a6d158c9");
      }
      for (;;)
      {
        if (localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST) {
          break label184;
        }
        paramHttpURLConnection.setFixedLengthStreamingMode(paramBodyData.size());
        return;
        if (paramQMNetworkRequest.connectTimeout >= 0) {
          break;
        }
        paramHttpURLConnection.setConnectTimeout(15000);
        break;
        if (paramQMNetworkRequest.readTimeout >= 0) {
          break label30;
        }
        paramHttpURLConnection.setReadTimeout(15000);
        break label30;
        if (localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_OPTIONS) {
          break label83;
        }
        paramHttpURLConnection.setRequestMethod("OPTIONS");
        break label83;
        paramHttpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      }
    } while (localQMHttpMethod != QMNetworkRequest.QMHttpMethod.QMHttpMethod_MULTIPART);
    label154:
    label171:
    label184:
    if (paramQMNetworkRequest.isRawPost()) {}
    for (long l = getPostContentLen(paramQMNetworkRequest.getMultipartDataList()); Build.VERSION.SDK_INT >= 19; l = getPostContentLen(paramQMNetworkRequest, StringExtention.parseParams(paramQMNetworkRequest.getBodyData().toString(), true), paramBodyData))
    {
      paramHttpURLConnection.setFixedLengthStreamingMode(l);
      return;
      paramBodyData = paramQMNetworkRequest.getFileParams();
    }
    if (l <= 2147483647L)
    {
      paramHttpURLConnection.setFixedLengthStreamingMode((int)l);
      return;
    }
    paramHttpURLConnection.setChunkedStreamingMode(0);
  }
  
  private static void setUserCookies(HttpURLConnection paramHttpURLConnection, QMNetworkRequest paramQMNetworkRequest)
  {
    paramQMNetworkRequest = formatCookieString(paramQMNetworkRequest);
    if (paramQMNetworkRequest != null)
    {
      QMLog.log(2, "HttpRequest", "setUserCookies: " + paramQMNetworkRequest);
      paramHttpURLConnection.setRequestProperty("Cookie", paramQMNetworkRequest);
    }
  }
  
  private static void setUserHeads(HttpURLConnection paramHttpURLConnection, QMNetworkRequest paramQMNetworkRequest)
  {
    paramQMNetworkRequest = paramQMNetworkRequest.getRequestHeaders();
    if ((paramQMNetworkRequest == null) || (paramQMNetworkRequest.isEmpty())) {}
    for (;;)
    {
      return;
      paramQMNetworkRequest = paramQMNetworkRequest.entrySet().iterator();
      while (paramQMNetworkRequest.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramQMNetworkRequest.next();
        paramHttpURLConnection.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  /* Error */
  private static void writeMultiPostParams(HttpURLConnection paramHttpURLConnection, List<NameValuePair> paramList, List<QMFileEntity> paramList1, QMNetworkRequest paramQMNetworkRequest)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 1083	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   4: astore 22
    //   6: aload_3
    //   7: aload_1
    //   8: aload_2
    //   9: invokestatic 1046	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getPostContentLen	(Lcom/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest;Ljava/util/List;Ljava/util/List;)J
    //   12: lstore 16
    //   14: lconst_0
    //   15: lstore 14
    //   17: lload 14
    //   19: lstore 12
    //   21: aload_1
    //   22: ifnull +389 -> 411
    //   25: lload 14
    //   27: lstore 8
    //   29: lload 14
    //   31: lstore 6
    //   33: lload 14
    //   35: lstore 12
    //   37: lload 14
    //   39: lstore 10
    //   41: aload_1
    //   42: invokeinterface 240 1 0
    //   47: ifle +364 -> 411
    //   50: lload 14
    //   52: lstore 8
    //   54: lload 14
    //   56: lstore 6
    //   58: lload 14
    //   60: lstore 10
    //   62: new 145	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   69: astore_0
    //   70: lload 14
    //   72: lstore 8
    //   74: lload 14
    //   76: lstore 6
    //   78: lload 14
    //   80: lstore 10
    //   82: aload_1
    //   83: invokeinterface 255 1 0
    //   88: astore_1
    //   89: lload 14
    //   91: lstore 8
    //   93: lload 14
    //   95: lstore 6
    //   97: lload 14
    //   99: lstore 10
    //   101: aload_1
    //   102: invokeinterface 155 1 0
    //   107: ifeq +171 -> 278
    //   110: lload 14
    //   112: lstore 8
    //   114: lload 14
    //   116: lstore 6
    //   118: lload 14
    //   120: lstore 10
    //   122: aload_1
    //   123: invokeinterface 159 1 0
    //   128: checkcast 246	org/apache/http/NameValuePair
    //   131: astore 23
    //   133: lload 14
    //   135: lstore 8
    //   137: lload 14
    //   139: lstore 6
    //   141: lload 14
    //   143: lstore 10
    //   145: aload_0
    //   146: ldc 17
    //   148: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: lload 14
    //   154: lstore 8
    //   156: lload 14
    //   158: lstore 6
    //   160: lload 14
    //   162: lstore 10
    //   164: aload_0
    //   165: ldc 11
    //   167: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 23
    //   172: invokeinterface 247 1 0
    //   177: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 249
    //   182: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: lload 14
    //   188: lstore 8
    //   190: lload 14
    //   192: lstore 6
    //   194: lload 14
    //   196: lstore 10
    //   198: aload_0
    //   199: aload 23
    //   201: invokeinterface 250 1 0
    //   206: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 43
    //   211: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: goto -126 -> 89
    //   218: astore_0
    //   219: lload 8
    //   221: lstore 6
    //   223: new 540	java/io/IOException
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 1085	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   231: athrow
    //   232: astore_0
    //   233: iconst_4
    //   234: ldc 66
    //   236: new 145	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 1087
    //   246: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: lload 6
    //   251: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: ldc_w 1089
    //   257: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: lload 16
    //   262: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   271: aload 22
    //   273: invokevirtual 1092	java/io/OutputStream:close	()V
    //   276: aload_0
    //   277: athrow
    //   278: lload 14
    //   280: lstore 8
    //   282: lload 14
    //   284: lstore 6
    //   286: lload 14
    //   288: lstore 10
    //   290: aload_0
    //   291: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokevirtual 254	java/lang/String:getBytes	()[B
    //   297: astore_0
    //   298: lload 14
    //   300: lstore 8
    //   302: lload 14
    //   304: lstore 6
    //   306: lload 14
    //   308: lstore 10
    //   310: iconst_4
    //   311: ldc 66
    //   313: new 145	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 1094
    //   323: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_0
    //   327: arraylength
    //   328: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: ldc_w 1096
    //   334: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: lload 16
    //   339: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   342: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   348: lload 14
    //   350: lstore 8
    //   352: lload 14
    //   354: lstore 6
    //   356: lload 14
    //   358: lstore 10
    //   360: aload 22
    //   362: aload_0
    //   363: invokevirtual 1098	java/io/OutputStream:write	([B)V
    //   366: lload 14
    //   368: lstore 8
    //   370: lload 14
    //   372: lstore 6
    //   374: lload 14
    //   376: lstore 10
    //   378: lconst_0
    //   379: aload_0
    //   380: arraylength
    //   381: i2l
    //   382: ladd
    //   383: lstore 12
    //   385: lload 12
    //   387: lstore 8
    //   389: lload 12
    //   391: lstore 6
    //   393: lload 12
    //   395: lstore 10
    //   397: aload_3
    //   398: lload 12
    //   400: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   403: lload 16
    //   405: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   408: invokevirtual 1107	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseSendData	(Ljava/lang/Long;Ljava/lang/Long;)V
    //   411: lload 12
    //   413: lstore 14
    //   415: aload_2
    //   416: ifnull +1052 -> 1468
    //   419: lload 12
    //   421: lstore 8
    //   423: lload 12
    //   425: lstore 6
    //   427: lload 12
    //   429: lstore 10
    //   431: lload 12
    //   433: lstore 14
    //   435: aload_2
    //   436: invokeinterface 240 1 0
    //   441: ifle +1027 -> 1468
    //   444: lload 12
    //   446: lstore 8
    //   448: lload 12
    //   450: lstore 6
    //   452: lload 12
    //   454: lstore 10
    //   456: iconst_4
    //   457: ldc 66
    //   459: new 145	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   466: ldc_w 1109
    //   469: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_2
    //   473: invokeinterface 240 1 0
    //   478: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc_w 1096
    //   484: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: lload 16
    //   489: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   492: ldc_w 1111
    //   495: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_2
    //   499: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   508: lload 12
    //   510: lstore 8
    //   512: lload 12
    //   514: lstore 6
    //   516: lload 12
    //   518: lstore 10
    //   520: aload_2
    //   521: invokeinterface 255 1 0
    //   526: astore 24
    //   528: lload 12
    //   530: lstore 8
    //   532: lload 12
    //   534: lstore 6
    //   536: lload 12
    //   538: lstore 10
    //   540: lload 12
    //   542: lstore 14
    //   544: aload 24
    //   546: invokeinterface 155 1 0
    //   551: ifeq +917 -> 1468
    //   554: lload 12
    //   556: lstore 8
    //   558: lload 12
    //   560: lstore 6
    //   562: lload 12
    //   564: lstore 10
    //   566: aload 24
    //   568: invokeinterface 159 1 0
    //   573: checkcast 257	com/tencent/qqmail/utilities/qmnetwork/QMFileEntity
    //   576: astore 25
    //   578: lload 12
    //   580: lstore 8
    //   582: lload 12
    //   584: lstore 6
    //   586: lload 12
    //   588: lstore 10
    //   590: aload 25
    //   592: invokevirtual 1115	com/tencent/qqmail/utilities/qmnetwork/QMFileEntity:getFile	()Ljava/io/File;
    //   595: astore 23
    //   597: lload 12
    //   599: lstore 8
    //   601: lload 12
    //   603: lstore 6
    //   605: lload 12
    //   607: lstore 10
    //   609: aload 23
    //   611: invokevirtual 1119	java/io/File:length	()J
    //   614: lstore 18
    //   616: lload 12
    //   618: lstore 8
    //   620: lload 12
    //   622: lstore 6
    //   624: lload 12
    //   626: lstore 10
    //   628: invokestatic 650	java/lang/System:nanoTime	()J
    //   631: lstore 20
    //   633: lload 12
    //   635: lstore 8
    //   637: lload 12
    //   639: lstore 6
    //   641: lload 12
    //   643: lstore 10
    //   645: iconst_2
    //   646: ldc 66
    //   648: new 145	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 1121
    //   658: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: aload 23
    //   663: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   666: ldc_w 1123
    //   669: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: lload 18
    //   674: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   677: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   683: lload 12
    //   685: lstore 8
    //   687: lload 12
    //   689: lstore 6
    //   691: lload 12
    //   693: lstore 10
    //   695: aload 25
    //   697: invokevirtual 260	com/tencent/qqmail/utilities/qmnetwork/QMFileEntity:getFileNameString	()Ljava/lang/String;
    //   700: astore_1
    //   701: lload 12
    //   703: lstore 8
    //   705: lload 12
    //   707: lstore 6
    //   709: lload 12
    //   711: lstore 10
    //   713: aload_3
    //   714: invokevirtual 263	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:getMultiPartCustomName	()Ljava/lang/String;
    //   717: astore_2
    //   718: lload 12
    //   720: lstore 8
    //   722: lload 12
    //   724: lstore 6
    //   726: aload_2
    //   727: astore_0
    //   728: lload 12
    //   730: lstore 10
    //   732: aload_2
    //   733: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   736: ifeq +5 -> 741
    //   739: aload_1
    //   740: astore_0
    //   741: lload 12
    //   743: lstore 8
    //   745: lload 12
    //   747: lstore 6
    //   749: lload 12
    //   751: lstore 10
    //   753: aload 25
    //   755: invokevirtual 272	com/tencent/qqmail/utilities/qmnetwork/QMFileEntity:getContentType	()Lorg/apache/http/Header;
    //   758: invokeinterface 275 1 0
    //   763: astore_2
    //   764: lload 12
    //   766: lstore 8
    //   768: lload 12
    //   770: lstore 6
    //   772: lload 12
    //   774: lstore 10
    //   776: new 145	java/lang/StringBuilder
    //   779: dup
    //   780: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   783: ldc_w 277
    //   786: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload_0
    //   790: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: ldc_w 279
    //   796: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_1
    //   800: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 281
    //   806: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: astore_1
    //   813: lload 12
    //   815: lstore 8
    //   817: lload 12
    //   819: lstore 6
    //   821: aload_1
    //   822: astore_0
    //   823: lload 12
    //   825: lstore 10
    //   827: aload_2
    //   828: ldc_w 283
    //   831: invokevirtual 287	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   834: ifne +45 -> 879
    //   837: lload 12
    //   839: lstore 8
    //   841: lload 12
    //   843: lstore 6
    //   845: lload 12
    //   847: lstore 10
    //   849: new 145	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   856: aload_1
    //   857: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: ldc_w 289
    //   863: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_2
    //   867: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc 43
    //   872: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: astore_0
    //   879: lload 12
    //   881: lstore 8
    //   883: lload 12
    //   885: lstore 6
    //   887: lload 12
    //   889: lstore 10
    //   891: new 145	java/lang/StringBuilder
    //   894: dup
    //   895: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   898: aload_0
    //   899: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: ldc 43
    //   904: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   910: astore_0
    //   911: lload 12
    //   913: lstore 8
    //   915: lload 12
    //   917: lstore 6
    //   919: lload 12
    //   921: lstore 10
    //   923: aload 22
    //   925: aload_0
    //   926: invokevirtual 254	java/lang/String:getBytes	()[B
    //   929: invokevirtual 1098	java/io/OutputStream:write	([B)V
    //   932: lload 12
    //   934: lstore 8
    //   936: lload 12
    //   938: lstore 6
    //   940: lload 12
    //   942: lstore 10
    //   944: lload 12
    //   946: aload_0
    //   947: invokevirtual 254	java/lang/String:getBytes	()[B
    //   950: arraylength
    //   951: i2l
    //   952: ladd
    //   953: lstore 14
    //   955: lload 14
    //   957: lstore 8
    //   959: lload 14
    //   961: lstore 6
    //   963: lload 14
    //   965: lstore 10
    //   967: aload 25
    //   969: invokevirtual 1126	com/tencent/qqmail/utilities/qmnetwork/QMFileEntity:getContent	()Ljava/io/InputStream;
    //   972: astore_0
    //   973: iconst_0
    //   974: istore 4
    //   976: lload 14
    //   978: lstore 6
    //   980: lload 14
    //   982: lstore 12
    //   984: getstatic 1129	com/tencent/qqmail/utilities/httpclient/QMAndroidHttpClientConfig:SEND_BUFF_LEN_INTEGER	Ljava/lang/Integer;
    //   987: invokevirtual 565	java/lang/Integer:intValue	()I
    //   990: newarray byte
    //   992: astore_1
    //   993: lload 14
    //   995: lstore 6
    //   997: lload 14
    //   999: lstore 12
    //   1001: invokestatic 650	java/lang/System:nanoTime	()J
    //   1004: pop2
    //   1005: lload 14
    //   1007: lstore 6
    //   1009: lload 14
    //   1011: lstore 12
    //   1013: aload_0
    //   1014: aload_1
    //   1015: iconst_0
    //   1016: getstatic 1129	com/tencent/qqmail/utilities/httpclient/QMAndroidHttpClientConfig:SEND_BUFF_LEN_INTEGER	Ljava/lang/Integer;
    //   1019: invokevirtual 565	java/lang/Integer:intValue	()I
    //   1022: invokevirtual 1132	java/io/InputStream:read	([BII)I
    //   1025: istore 5
    //   1027: iload 5
    //   1029: ifle +72 -> 1101
    //   1032: lload 14
    //   1034: lstore 6
    //   1036: lload 14
    //   1038: lstore 12
    //   1040: aload 22
    //   1042: aload_1
    //   1043: iconst_0
    //   1044: iload 5
    //   1046: invokevirtual 1133	java/io/OutputStream:write	([BII)V
    //   1049: lload 14
    //   1051: iload 5
    //   1053: i2l
    //   1054: ladd
    //   1055: lstore 14
    //   1057: lload 14
    //   1059: lstore 6
    //   1061: lload 14
    //   1063: lstore 12
    //   1065: aload_3
    //   1066: lload 14
    //   1068: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1071: lload 16
    //   1073: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1076: invokevirtual 1107	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseSendData	(Ljava/lang/Long;Ljava/lang/Long;)V
    //   1079: lload 14
    //   1081: lstore 6
    //   1083: lload 14
    //   1085: lstore 12
    //   1087: invokestatic 650	java/lang/System:nanoTime	()J
    //   1090: pop2
    //   1091: iload 4
    //   1093: iload 5
    //   1095: iadd
    //   1096: istore 4
    //   1098: goto -93 -> 1005
    //   1101: lload 14
    //   1103: lstore 6
    //   1105: lload 14
    //   1107: lstore 12
    //   1109: aload 22
    //   1111: ldc 43
    //   1113: invokevirtual 254	java/lang/String:getBytes	()[B
    //   1116: invokevirtual 1098	java/io/OutputStream:write	([B)V
    //   1119: lload 14
    //   1121: lstore 6
    //   1123: lload 14
    //   1125: lstore 12
    //   1127: ldc 43
    //   1129: invokevirtual 296	java/lang/String:length	()I
    //   1132: istore 4
    //   1134: lload 14
    //   1136: iload 4
    //   1138: i2l
    //   1139: ladd
    //   1140: lstore 12
    //   1142: lload 12
    //   1144: lstore 8
    //   1146: lload 12
    //   1148: lstore 6
    //   1150: lload 12
    //   1152: lstore 10
    //   1154: invokestatic 650	java/lang/System:nanoTime	()J
    //   1157: lload 20
    //   1159: lsub
    //   1160: lstore 14
    //   1162: lload 12
    //   1164: lstore 8
    //   1166: lload 12
    //   1168: lstore 6
    //   1170: lload 12
    //   1172: lstore 10
    //   1174: iconst_4
    //   1175: ldc 66
    //   1177: new 145	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1184: ldc_w 1135
    //   1187: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: aload 23
    //   1192: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1195: ldc_w 1123
    //   1198: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: lload 18
    //   1203: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1206: ldc_w 1137
    //   1209: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: lload 14
    //   1214: invokestatic 660	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:nanos2Millis	(J)F
    //   1217: invokevirtual 663	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1220: ldc_w 1139
    //   1223: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: lload 18
    //   1228: lload 14
    //   1230: invokestatic 343	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getSpeed	(JJ)F
    //   1233: invokevirtual 663	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1236: ldc_w 1141
    //   1239: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: lload 12
    //   1244: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: ldc_w 1143
    //   1250: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1253: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1256: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1259: lload 12
    //   1261: lstore 8
    //   1263: lload 12
    //   1265: lstore 6
    //   1267: lload 12
    //   1269: lstore 10
    //   1271: aload_0
    //   1272: invokevirtual 581	java/io/InputStream:close	()V
    //   1275: goto -747 -> 528
    //   1278: astore_0
    //   1279: lload 10
    //   1281: lstore 6
    //   1283: new 540	java/io/IOException
    //   1286: dup
    //   1287: aload_0
    //   1288: invokespecial 1085	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   1291: athrow
    //   1292: astore_1
    //   1293: lload 6
    //   1295: lstore 12
    //   1297: iconst_5
    //   1298: ldc 66
    //   1300: ldc_w 1145
    //   1303: aload_1
    //   1304: invokestatic 463	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1307: lload 6
    //   1309: lstore 12
    //   1311: new 540	java/io/IOException
    //   1314: dup
    //   1315: aload_1
    //   1316: invokespecial 1085	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   1319: athrow
    //   1320: astore_1
    //   1321: lload 12
    //   1323: lstore 8
    //   1325: lload 12
    //   1327: lstore 6
    //   1329: lload 12
    //   1331: lstore 10
    //   1333: invokestatic 650	java/lang/System:nanoTime	()J
    //   1336: lload 20
    //   1338: lsub
    //   1339: lstore 14
    //   1341: lload 12
    //   1343: lstore 8
    //   1345: lload 12
    //   1347: lstore 6
    //   1349: lload 12
    //   1351: lstore 10
    //   1353: iconst_4
    //   1354: ldc 66
    //   1356: new 145	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1363: ldc_w 1135
    //   1366: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: aload 23
    //   1371: invokevirtual 371	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1374: ldc_w 1123
    //   1377: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: lload 18
    //   1382: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1385: ldc_w 1137
    //   1388: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: lload 14
    //   1393: invokestatic 660	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:nanos2Millis	(J)F
    //   1396: invokevirtual 663	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1399: ldc_w 1139
    //   1402: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: lload 18
    //   1407: lload 14
    //   1409: invokestatic 343	com/tencent/qqmail/utilities/qmnetwork/QMHttpUtil:getSpeed	(JJ)F
    //   1412: invokevirtual 663	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1415: ldc_w 1141
    //   1418: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: lload 12
    //   1423: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1426: ldc_w 1143
    //   1429: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1435: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1438: lload 12
    //   1440: lstore 8
    //   1442: lload 12
    //   1444: lstore 6
    //   1446: lload 12
    //   1448: lstore 10
    //   1450: aload_0
    //   1451: invokevirtual 581	java/io/InputStream:close	()V
    //   1454: lload 12
    //   1456: lstore 8
    //   1458: lload 12
    //   1460: lstore 6
    //   1462: lload 12
    //   1464: lstore 10
    //   1466: aload_1
    //   1467: athrow
    //   1468: lload 14
    //   1470: lstore 8
    //   1472: lload 14
    //   1474: lstore 6
    //   1476: lload 14
    //   1478: lstore 10
    //   1480: aload 22
    //   1482: ldc 14
    //   1484: invokevirtual 254	java/lang/String:getBytes	()[B
    //   1487: invokevirtual 1098	java/io/OutputStream:write	([B)V
    //   1490: lload 14
    //   1492: lstore 8
    //   1494: lload 14
    //   1496: lstore 6
    //   1498: lload 14
    //   1500: lstore 10
    //   1502: lload 14
    //   1504: ldc 14
    //   1506: invokevirtual 296	java/lang/String:length	()I
    //   1509: i2l
    //   1510: ladd
    //   1511: lstore 12
    //   1513: lload 12
    //   1515: lstore 8
    //   1517: lload 12
    //   1519: lstore 6
    //   1521: lload 12
    //   1523: lstore 10
    //   1525: aload_3
    //   1526: lload 12
    //   1528: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1531: lload 16
    //   1533: invokestatic 1103	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1536: invokevirtual 1107	com/tencent/qqmail/utilities/qmnetwork/QMNetworkRequest:responseSendData	(Ljava/lang/Long;Ljava/lang/Long;)V
    //   1539: iconst_4
    //   1540: ldc 66
    //   1542: new 145	java/lang/StringBuilder
    //   1545: dup
    //   1546: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   1549: ldc_w 1087
    //   1552: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1555: lload 12
    //   1557: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1560: ldc_w 1089
    //   1563: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1566: lload 16
    //   1568: invokevirtual 880	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1571: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1574: invokestatic 386	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1577: aload 22
    //   1579: invokevirtual 1092	java/io/OutputStream:close	()V
    //   1582: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1583	0	paramHttpURLConnection	HttpURLConnection
    //   0	1583	1	paramList	List<NameValuePair>
    //   0	1583	2	paramList1	List<QMFileEntity>
    //   0	1583	3	paramQMNetworkRequest	QMNetworkRequest
    //   974	163	4	i	int
    //   1025	71	5	j	int
    //   31	1489	6	l1	long
    //   27	1489	8	l2	long
    //   39	1485	10	l3	long
    //   19	1537	12	l4	long
    //   15	1488	14	l5	long
    //   12	1555	16	l6	long
    //   614	792	18	l7	long
    //   631	706	20	l8	long
    //   4	1574	22	localOutputStream	OutputStream
    //   131	1239	23	localObject	Object
    //   526	41	24	localIterator	Iterator
    //   576	392	25	localQMFileEntity	QMFileEntity
    // Exception table:
    //   from	to	target	type
    //   41	50	218	java/lang/OutOfMemoryError
    //   62	70	218	java/lang/OutOfMemoryError
    //   82	89	218	java/lang/OutOfMemoryError
    //   101	110	218	java/lang/OutOfMemoryError
    //   122	133	218	java/lang/OutOfMemoryError
    //   145	152	218	java/lang/OutOfMemoryError
    //   164	186	218	java/lang/OutOfMemoryError
    //   198	215	218	java/lang/OutOfMemoryError
    //   290	298	218	java/lang/OutOfMemoryError
    //   310	348	218	java/lang/OutOfMemoryError
    //   360	366	218	java/lang/OutOfMemoryError
    //   378	385	218	java/lang/OutOfMemoryError
    //   397	411	218	java/lang/OutOfMemoryError
    //   435	444	218	java/lang/OutOfMemoryError
    //   456	508	218	java/lang/OutOfMemoryError
    //   520	528	218	java/lang/OutOfMemoryError
    //   544	554	218	java/lang/OutOfMemoryError
    //   566	578	218	java/lang/OutOfMemoryError
    //   590	597	218	java/lang/OutOfMemoryError
    //   609	616	218	java/lang/OutOfMemoryError
    //   628	633	218	java/lang/OutOfMemoryError
    //   645	683	218	java/lang/OutOfMemoryError
    //   695	701	218	java/lang/OutOfMemoryError
    //   713	718	218	java/lang/OutOfMemoryError
    //   732	739	218	java/lang/OutOfMemoryError
    //   753	764	218	java/lang/OutOfMemoryError
    //   776	813	218	java/lang/OutOfMemoryError
    //   827	837	218	java/lang/OutOfMemoryError
    //   849	879	218	java/lang/OutOfMemoryError
    //   891	911	218	java/lang/OutOfMemoryError
    //   923	932	218	java/lang/OutOfMemoryError
    //   944	955	218	java/lang/OutOfMemoryError
    //   967	973	218	java/lang/OutOfMemoryError
    //   1154	1162	218	java/lang/OutOfMemoryError
    //   1174	1259	218	java/lang/OutOfMemoryError
    //   1271	1275	218	java/lang/OutOfMemoryError
    //   1333	1341	218	java/lang/OutOfMemoryError
    //   1353	1438	218	java/lang/OutOfMemoryError
    //   1450	1454	218	java/lang/OutOfMemoryError
    //   1466	1468	218	java/lang/OutOfMemoryError
    //   1480	1490	218	java/lang/OutOfMemoryError
    //   1502	1513	218	java/lang/OutOfMemoryError
    //   1525	1539	218	java/lang/OutOfMemoryError
    //   41	50	232	finally
    //   62	70	232	finally
    //   82	89	232	finally
    //   101	110	232	finally
    //   122	133	232	finally
    //   145	152	232	finally
    //   164	186	232	finally
    //   198	215	232	finally
    //   223	232	232	finally
    //   290	298	232	finally
    //   310	348	232	finally
    //   360	366	232	finally
    //   378	385	232	finally
    //   397	411	232	finally
    //   435	444	232	finally
    //   456	508	232	finally
    //   520	528	232	finally
    //   544	554	232	finally
    //   566	578	232	finally
    //   590	597	232	finally
    //   609	616	232	finally
    //   628	633	232	finally
    //   645	683	232	finally
    //   695	701	232	finally
    //   713	718	232	finally
    //   732	739	232	finally
    //   753	764	232	finally
    //   776	813	232	finally
    //   827	837	232	finally
    //   849	879	232	finally
    //   891	911	232	finally
    //   923	932	232	finally
    //   944	955	232	finally
    //   967	973	232	finally
    //   1154	1162	232	finally
    //   1174	1259	232	finally
    //   1271	1275	232	finally
    //   1283	1292	232	finally
    //   1333	1341	232	finally
    //   1353	1438	232	finally
    //   1450	1454	232	finally
    //   1466	1468	232	finally
    //   1480	1490	232	finally
    //   1502	1513	232	finally
    //   1525	1539	232	finally
    //   41	50	1278	java/lang/ArrayIndexOutOfBoundsException
    //   62	70	1278	java/lang/ArrayIndexOutOfBoundsException
    //   82	89	1278	java/lang/ArrayIndexOutOfBoundsException
    //   101	110	1278	java/lang/ArrayIndexOutOfBoundsException
    //   122	133	1278	java/lang/ArrayIndexOutOfBoundsException
    //   145	152	1278	java/lang/ArrayIndexOutOfBoundsException
    //   164	186	1278	java/lang/ArrayIndexOutOfBoundsException
    //   198	215	1278	java/lang/ArrayIndexOutOfBoundsException
    //   290	298	1278	java/lang/ArrayIndexOutOfBoundsException
    //   310	348	1278	java/lang/ArrayIndexOutOfBoundsException
    //   360	366	1278	java/lang/ArrayIndexOutOfBoundsException
    //   378	385	1278	java/lang/ArrayIndexOutOfBoundsException
    //   397	411	1278	java/lang/ArrayIndexOutOfBoundsException
    //   435	444	1278	java/lang/ArrayIndexOutOfBoundsException
    //   456	508	1278	java/lang/ArrayIndexOutOfBoundsException
    //   520	528	1278	java/lang/ArrayIndexOutOfBoundsException
    //   544	554	1278	java/lang/ArrayIndexOutOfBoundsException
    //   566	578	1278	java/lang/ArrayIndexOutOfBoundsException
    //   590	597	1278	java/lang/ArrayIndexOutOfBoundsException
    //   609	616	1278	java/lang/ArrayIndexOutOfBoundsException
    //   628	633	1278	java/lang/ArrayIndexOutOfBoundsException
    //   645	683	1278	java/lang/ArrayIndexOutOfBoundsException
    //   695	701	1278	java/lang/ArrayIndexOutOfBoundsException
    //   713	718	1278	java/lang/ArrayIndexOutOfBoundsException
    //   732	739	1278	java/lang/ArrayIndexOutOfBoundsException
    //   753	764	1278	java/lang/ArrayIndexOutOfBoundsException
    //   776	813	1278	java/lang/ArrayIndexOutOfBoundsException
    //   827	837	1278	java/lang/ArrayIndexOutOfBoundsException
    //   849	879	1278	java/lang/ArrayIndexOutOfBoundsException
    //   891	911	1278	java/lang/ArrayIndexOutOfBoundsException
    //   923	932	1278	java/lang/ArrayIndexOutOfBoundsException
    //   944	955	1278	java/lang/ArrayIndexOutOfBoundsException
    //   967	973	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1154	1162	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1174	1259	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1271	1275	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1333	1341	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1353	1438	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1450	1454	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1466	1468	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1480	1490	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1502	1513	1278	java/lang/ArrayIndexOutOfBoundsException
    //   1525	1539	1278	java/lang/ArrayIndexOutOfBoundsException
    //   984	993	1292	java/lang/Exception
    //   1001	1005	1292	java/lang/Exception
    //   1013	1027	1292	java/lang/Exception
    //   1040	1049	1292	java/lang/Exception
    //   1065	1079	1292	java/lang/Exception
    //   1087	1091	1292	java/lang/Exception
    //   1109	1119	1292	java/lang/Exception
    //   1127	1134	1292	java/lang/Exception
    //   984	993	1320	finally
    //   1001	1005	1320	finally
    //   1013	1027	1320	finally
    //   1040	1049	1320	finally
    //   1065	1079	1320	finally
    //   1087	1091	1320	finally
    //   1109	1119	1320	finally
    //   1127	1134	1320	finally
    //   1297	1307	1320	finally
    //   1311	1320	1320	finally
  }
  
  private static void writePostParams(HttpURLConnection paramHttpURLConnection, QMNetworkRequest.BodyData paramBodyData, QMNetworkRequest paramQMNetworkRequest)
    throws IOException
  {
    paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
    paramBodyData = paramBodyData.getBytes();
    int m = paramBodyData.length;
    long l2 = 0L;
    QMLog.log(2, "HttpRequest", "writePostParams, start to write, total: " + m);
    long l3 = System.nanoTime();
    long l1 = l2;
    try
    {
      System.nanoTime();
      int k = 0;
      int j = 0;
      if (k < m)
      {
        l1 = l2;
        int i = QMAndroidHttpClientConfig.SEND_BUFF_LEN_INTEGER.intValue() + k;
        if (i < m) {}
        for (;;)
        {
          int n = i - k;
          l1 = l2;
          paramHttpURLConnection.write(paramBodyData, k, n);
          l2 += n;
          l1 = l2;
          paramQMNetworkRequest.responseSendData(Long.valueOf(l2), Long.valueOf(m));
          l1 = l2;
          System.nanoTime();
          j += n;
          k = i;
          break;
          i = m;
        }
      }
      l1 = System.nanoTime() - l3;
      if (l2 != m) {
        QMLog.log(5, "HttpRequest", "writePostParams, finish with exception!! elapse: " + nanos2Millis(l1) + "ms, hasWritten: " + l2 + ", speed: " + getSpeed(l2, l1) + "KB/s");
      }
      for (;;)
      {
        paramHttpURLConnection.close();
        return;
        QMLog.log(2, "HttpRequest", "writePostParams, finish write, elapse: " + nanos2Millis(l1) + "ms, speed: " + getSpeed(m, l1) + "KB/s");
      }
      QMLog.log(5, "HttpRequest", "writePostParams, finish with exception!! elapse: " + nanos2Millis(l2) + "ms, hasWritten: " + l1 + ", speed: " + getSpeed(l1, l2) + "KB/s");
    }
    finally
    {
      l2 = System.nanoTime() - l3;
      if (l1 == m) {}
    }
    for (;;)
    {
      paramHttpURLConnection.close();
      throw paramBodyData;
      QMLog.log(2, "HttpRequest", "writePostParams, finish write, elapse: " + nanos2Millis(l2) + "ms, speed: " + getSpeed(m, l2) + "KB/s");
    }
  }
  
  private static void writeRawMultiPostParams(HttpURLConnection paramHttpURLConnection, QMNetworkRequest paramQMNetworkRequest)
    throws IOException
  {
    Object localObject1 = paramQMNetworkRequest.getMultipartDataList();
    paramHttpURLConnection = paramHttpURLConnection.getOutputStream();
    long l4 = getPostContentLen((List)localObject1);
    if (l4 == 0L) {
      return;
    }
    long l1 = 0L;
    long l5 = System.nanoTime();
    long l3 = l1;
    long l2 = l1;
    int i;
    try
    {
      paramQMNetworkRequest = "\r\n".getBytes();
      l3 = l1;
      l2 = l1;
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        l3 = l1;
        l2 = l1;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        l3 = l1;
        l2 = l1;
        Object localObject2 = (Pair)((Iterator)localObject1).next();
        l3 = l1;
        l2 = l1;
        byte[] arrayOfByte1 = ("-----------7d4a6d158c9\r\nContent-Disposition: form-data; name=\"" + (String)((Pair)localObject2).first + "\"\r\n\r\n").getBytes();
        l3 = l1;
        l2 = l1;
        localObject2 = (byte[])((Pair)localObject2).second;
        l3 = l1;
        l2 = l1;
        byte[] arrayOfByte2 = new byte[arrayOfByte1.length + localObject2.length + paramQMNetworkRequest.length];
        l3 = l1;
        l2 = l1;
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
        l3 = l1;
        l2 = l1;
        System.arraycopy(localObject2, 0, arrayOfByte2, arrayOfByte1.length, localObject2.length);
        l3 = l1;
        l2 = l1;
        i = arrayOfByte1.length;
        l3 = l1;
        l2 = l1;
        System.arraycopy(paramQMNetworkRequest, 0, arrayOfByte2, localObject2.length + i, paramQMNetworkRequest.length);
        l3 = l1;
        l2 = l1;
        paramHttpURLConnection.write(arrayOfByte2);
        l3 = l1;
        l2 = l1;
        l1 += arrayOfByte2.length;
      }
      l3 = l1;
      l2 = l1;
      paramHttpURLConnection.write("-----------7d4a6d158c9--\r\n".getBytes());
      l3 = l1;
      l2 = l1;
      i = "-----------7d4a6d158c9--\r\n".getBytes().length;
      l2 = i;
      l3 = System.nanoTime() - l5;
      if (l2 + l1 == l4) {}
      for (i = 4;; i = 5)
      {
        QMLog.log(i, "HttpRequest", "writeRawMultiPostParams, finish write, elase: " + nanos2Millis(l3) + "ms, speed: " + getSpeed(l4, l3) + "KB/s");
        try
        {
          paramHttpURLConnection.close();
          return;
        }
        catch (Exception paramHttpURLConnection)
        {
          return;
        }
      }
      i = 4;
    }
    catch (Throwable paramQMNetworkRequest)
    {
      l2 = l3;
      throw new IOException(paramQMNetworkRequest);
    }
    finally
    {
      l1 = System.nanoTime() - l5;
      if (l2 != l4) {}
    }
    for (;;)
    {
      QMLog.log(i, "HttpRequest", "writeRawMultiPostParams, finish write, elase: " + nanos2Millis(l1) + "ms, speed: " + getSpeed(l4, l1) + "KB/s");
      try
      {
        paramHttpURLConnection.close();
        label471:
        throw paramQMNetworkRequest;
        i = 5;
      }
      catch (Exception paramHttpURLConnection)
      {
        break label471;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil
 * JD-Core Version:    0.7.0.1
 */