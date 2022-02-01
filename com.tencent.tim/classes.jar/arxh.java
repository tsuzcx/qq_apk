import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.base.http.HttpBaseUtil.HttpStatusException;
import com.tencent.open.base.http.HttpBaseUtil.NetworkUnavailableException;
import com.tencent.open.base.http.HttpBaseUtil.c;
import com.tencent.open.base.http.HttpCgiAsyncTask.1;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.HashMap;
import java.util.InvalidPropertiesFormatException;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class arxh
  extends arxd<Bundle, Void, HashMap<String, Object>>
{
  public arxh.a b;
  private boolean ddr;
  protected Handler handler = new Handler(Looper.getMainLooper());
  
  public arxh(String paramString1, String paramString2, arxh.a parama)
  {
    super(paramString1, paramString2);
    this.b = parama;
  }
  
  public arxh(String paramString1, String paramString2, arxh.a parama, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.b = parama;
    this.ddr = paramBoolean;
  }
  
  public static int a(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramIOException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramIOException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramIOException instanceof HttpResponseException)) {
      return -23;
    }
    if ((paramIOException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramIOException instanceof ConnectionClosedException)) {
      return -25;
    }
    if ((paramIOException instanceof EOFException)) {
      return -26;
    }
    if ((paramIOException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramIOException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramIOException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramIOException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramIOException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramIOException instanceof MalformedChunkCodingException)) {
      return -31;
    }
    if ((paramIOException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramIOException instanceof NoHttpResponseException)) {
      return -32;
    }
    if ((paramIOException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramIOException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramIOException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramIOException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramIOException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramIOException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramIOException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramIOException instanceof SSLHandshakeException)) {
      return -41;
    }
    if ((paramIOException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramIOException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramIOException instanceof BindException)) {
      return -45;
    }
    if ((paramIOException instanceof ConnectException)) {
      return -46;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramIOException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramIOException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramIOException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramIOException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramIOException instanceof ZipException)) {
      return -54;
    }
    return -2;
  }
  
  protected HashMap<String, Object> a(Bundle... paramVarArgs)
  {
    return b(paramVarArgs);
  }
  
  public HttpBaseUtil.c b(String paramString1, String paramString2, Bundle paramBundle)
    throws Exception
  {
    return HttpBaseUtil.a(paramString1, paramString2, paramBundle);
  }
  
  public HashMap<String, Object> b(Bundle... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    if (isCancelled()) {
      return localHashMap;
    }
    long l3 = SystemClock.elapsedRealtime();
    long l1 = 0L;
    String str2 = MsfSdkUtils.insertMtype("yingyongbao", this.mUri);
    Object localObject = paramVarArgs[0].getString("appid_for_getting_config");
    try
    {
      bool = paramVarArgs[0].getBoolean("from_h5", false);
      j = arxs.a(aroi.a().getContext(), (String)localObject).getInt("Common_HttpRetryCount");
      arwt.d("OpenConfig_agent", "config 1:Common_HttpRetryCount            config_value:" + j + "   appid:" + (String)localObject + "     url:" + str2);
      if (j == 0)
      {
        j = 3;
        arwt.d("OpenConfig_agent", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + (String)localObject + "     url:" + str2);
        str3 = paramVarArgs[0].getString("downloadfile");
        i = 0;
        if (!isCancelled()) {
          break label203;
        }
        return localHashMap;
      }
    }
    catch (Exception localException)
    {
      int j;
      int i;
      label203:
      int k;
      long l2;
      long l4;
      label1348:
      for (;;)
      {
        String str3;
        boolean bool = false;
        continue;
        continue;
        k = i + 1;
        l2 = l1;
        l4 = l1;
        for (;;)
        {
          try
          {
            localc = b(this.mUri, this.mMethodName, paramVarArgs[0]);
            l2 = l1;
            l4 = l1;
            str1 = localc.response;
            l2 = l1;
            l4 = l1;
            localObject = new JSONObject();
            if (str3 == null) {
              continue;
            }
            l2 = l1;
            l4 = l1;
            ((JSONObject)localObject).put("content", localc.inputStream);
          }
          catch (ConnectTimeoutException localConnectTimeoutException)
          {
            HttpBaseUtil.c localc;
            String str1;
            JSONObject localJSONObject2;
            long l5;
            localConnectTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", localConnectTimeoutException);
            i = -7;
            l1 = SystemClock.elapsedRealtime();
            l2 = 0L;
            if (k < j) {
              break label1348;
            }
            l3 = 0L;
            l4 = l1;
            l1 = l3;
            continue;
            l2 = l1;
            l4 = l1;
            localJSONObject1 = HttpBaseUtil.D(str1);
            continue;
            l2 = l1;
            l4 = l1;
            localJSONObject1.put("httpdatamodified", localc.elg);
            continue;
          }
          catch (SocketTimeoutException localSocketTimeoutException)
          {
            localSocketTimeoutException.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", localSocketTimeoutException);
            i = -8;
            l1 = SystemClock.elapsedRealtime();
            continue;
            i = -55;
            continue;
            l2 = l1;
            l4 = l1;
            try
            {
              i = localSocketTimeoutException.getInt("ret");
            }
            catch (JSONException localJSONException2)
            {
              l2 = l1;
              l4 = l1;
              try
              {
                i = localSocketTimeoutException.getInt("resultCode");
              }
              catch (JSONException localJSONException1)
              {
                i = -55;
              }
            }
            continue;
          }
          catch (JSONException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            i = -4;
            l4 = l3;
            continue;
          }
          catch (HttpBaseUtil.NetworkUnavailableException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            return localHashMap;
          }
          catch (HttpBaseUtil.HttpStatusException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            try
            {
              i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
              arxy.a().b(str2, l3, l2, 0L, i, aroi.a().getUin(), "1000002", null, this.ddr);
              return localHashMap;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              continue;
            }
          }
          catch (IOException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = a(paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            l4 = l3;
            continue;
          }
          catch (Exception paramVarArgs)
          {
            if (!(paramVarArgs instanceof HttpBaseUtil.NetworkUnavailableException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            return localHashMap;
            if (!(paramVarArgs instanceof HttpBaseUtil.HttpStatusException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            try
            {
              i = Integer.parseInt(paramVarArgs.getMessage().replace("http status code error:", ""));
              arxy.a().b(str2, l3, l4, 0L, i, aroi.a().getUin(), "1000002", null, this.ddr);
              return localHashMap;
            }
            catch (Exception paramVarArgs)
            {
              paramVarArgs.printStackTrace();
              continue;
            }
            if (!(paramVarArgs instanceof IOException)) {
              continue;
            }
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = a((IOException)paramVarArgs);
            l1 = 0L;
            l2 = 0L;
            l4 = l3;
            continue;
            paramVarArgs.printStackTrace();
            localHashMap.put("ResultType", Integer.valueOf(0));
            localHashMap.put("ResultValue", paramVarArgs);
            i = -6;
            l1 = 0L;
            l2 = 0L;
            l4 = l3;
            continue;
          }
          l2 = l1;
          l4 = l1;
          arwt.v("HttpCgiAsyncTask", "response.isModified= " + localc.elg);
          l2 = l1;
          l4 = l1;
          if (localc.elg == 0)
          {
            if (!bool) {
              continue;
            }
            l2 = l1;
            l4 = l1;
            localJSONObject2 = new JSONObject();
            l2 = l1;
            l4 = l1;
            localJSONObject2.put("httpdatamodified", localc.elg);
            l2 = l1;
            l4 = l1;
            ((JSONObject)localObject).put("extend", localJSONObject2);
          }
          l2 = l1;
          l4 = l1;
          localHashMap.put("ResultType", Integer.valueOf(1));
          l2 = l1;
          l4 = l1;
          localHashMap.put("ResultValue", localObject);
          if (!bool) {
            continue;
          }
          l2 = l1;
          l4 = l1;
          localObject = Pattern.compile("\"(?:ret|resultCode)\"\\s*\\:\\s*(\\d+)").matcher(str1);
          l2 = l1;
          l4 = l1;
          if (!((Matcher)localObject).find()) {
            continue;
          }
          l2 = l1;
          l4 = l1;
          i = Integer.parseInt(((Matcher)localObject).group(1));
          l2 = l1;
          l4 = l1;
          l1 = localc.reqSize;
          l2 = l1;
          l4 = l1;
          l5 = localc.awI;
          l2 = l5;
          l4 = l3;
          arwt.d("ReportManager", str2 + " | " + l4 + " | " + l1 + " | " + l2 + " | " + i);
          l3 = 0L;
          try
          {
            paramVarArgs = BaseApplicationImpl.getApplication().getFirstSimpleAccount();
            if (paramVarArgs != null) {
              l3 = Long.valueOf(paramVarArgs.getUin()).longValue();
            }
          }
          catch (Exception paramVarArgs)
          {
            JSONObject localJSONObject1;
            paramVarArgs.printStackTrace();
            l3 = 0L;
            continue;
            i = k;
            l2 = 0L;
            l3 = l1;
            l1 = l2;
          }
          arxy.a().b(str2, l4, l1, l2, i, l3, "1000002", null, this.ddr);
          return localHashMap;
          if (!bool) {
            continue;
          }
          l2 = l1;
          l4 = l1;
          str1 = HttpBaseUtil.qC(str1);
          l2 = l1;
          l4 = l1;
          ((JSONObject)localObject).put("content", str1);
        }
      }
    }
  }
  
  public void clearCallback()
  {
    if (this.handler != null)
    {
      this.handler.removeCallbacksAndMessages(null);
      this.b = null;
    }
  }
  
  @SuppressLint({"InlinedApi", "NewApi"})
  public void dL(Bundle paramBundle)
  {
    Executor localExecutor = obtainMultiExecutor();
    if (localExecutor != null)
    {
      executeOnExecutor(localExecutor, new Bundle[] { paramBundle });
      return;
    }
    execute(new Bundle[] { paramBundle });
  }
  
  public void elV()
  {
    this.b = null;
  }
  
  protected void x(HashMap<String, Object> paramHashMap)
  {
    if (!isCancelled()) {
      this.handler.post(new HttpCgiAsyncTask.1(this, paramHashMap));
    }
  }
  
  public static abstract interface a
  {
    public abstract void ai(JSONObject paramJSONObject);
    
    public abstract void onException(Exception paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arxh
 * JD-Core Version:    0.7.0.1
 */