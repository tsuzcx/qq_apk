import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.adapter.BaseHttpAdapter.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.viola.adapter.HttpRequset;
import com.tencent.viola.adapter.HttpResponse;
import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.IHttpAdapter.OnHttpListener;
import com.tencent.viola.core.ViolaSDKManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.Nullable;
import mqq.manager.TicketManager;

public class nua
  implements IHttpAdapter
{
  public static String TAG = "BaseHttpAdapter";
  private static final nua.a a = new nua.b(null);
  public static final String ajL = "QQ/3.4.4 Android/0.17 Android/" + Build.VERSION.RELEASE;
  private ExecutorService mExecutorService;
  
  private String a(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
    throws IOException
  {
    if (paramInputStream == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    char[] arrayOfChar = new char[2048];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfChar);
      if (i == -1) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i);
      if (paramOnHttpListener == null) {}
    }
    paramInputStream.close();
    return localStringBuilder.toString();
  }
  
  private HttpURLConnection a(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = a(new URL(paramHttpRequset.url));
    localHttpURLConnection.setConnectTimeout(paramHttpRequset.timeoutMs);
    localHttpURLConnection.setReadTimeout(paramHttpRequset.timeoutMs);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    Object localObject1;
    if (paramHttpRequset.paramMap != null)
    {
      localObject1 = paramHttpRequset.paramMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localHttpURLConnection.addRequestProperty((String)localObject2, (String)paramHttpRequset.paramMap.get(localObject2));
      }
    }
    Object localObject2 = (QQAppInterface)kxm.getAppRuntime();
    if (localObject2 != null)
    {
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject2).getManager(2);
      localObject1 = ((QQAppInterface)localObject2).getAccount();
      localObject2 = localTicketManager.getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
      localHttpURLConnection.addRequestProperty("Cookie", "uin=o" + (String)localObject1 + "; skey=" + (String)localObject2);
    }
    localHttpURLConnection.addRequestProperty("User-Agent", ajL);
    if (("POST".equals(paramHttpRequset.method)) || ("PUT".equals(paramHttpRequset.method)) || ("PATCH".equals(paramHttpRequset.method)))
    {
      localHttpURLConnection.setRequestMethod(paramHttpRequset.method);
      if (paramHttpRequset.body != null)
      {
        if (paramOnHttpListener != null) {}
        localHttpURLConnection.setDoOutput(true);
        localObject1 = new DataOutputStream(localHttpURLConnection.getOutputStream());
        ((DataOutputStream)localObject1).write(paramHttpRequset.body.getBytes());
        ((DataOutputStream)localObject1).close();
        if (paramOnHttpListener == null) {}
      }
      return localHttpURLConnection;
    }
    if (!TextUtils.isEmpty(paramHttpRequset.method))
    {
      localHttpURLConnection.setRequestMethod(paramHttpRequset.method);
      return localHttpURLConnection;
    }
    localHttpURLConnection.setRequestMethod("GET");
    return localHttpURLConnection;
  }
  
  private void a(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean)
  {
    if (paramOnHttpListener != null) {
      paramOnHttpListener.onHttpStart();
    }
    a(new BaseHttpAdapter.1(this, paramHttpRequset, paramOnHttpListener), paramBoolean);
  }
  
  private void a(HttpResponse paramHttpResponse, IHttpAdapter.OnHttpListener paramOnHttpListener, String paramString)
  {
    paramHttpResponse.statusCode = "-1";
    paramHttpResponse.errorCode = "-1";
    paramHttpResponse.errorMsg = paramString;
    if (paramOnHttpListener != null) {
      paramOnHttpListener.onHttpFinish(paramHttpResponse);
    }
  }
  
  private void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ViolaSDKManager.getInstance().postOnThreadPool(paramRunnable);
      return;
    }
    if (this.mExecutorService == null) {
      this.mExecutorService = Executors.newFixedThreadPool(6);
    }
    this.mExecutorService.execute(paramRunnable);
  }
  
  private byte[] a(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
    throws IOException
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[2048];
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (j == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, j);
      j = i + j;
      i = j;
      if (paramOnHttpListener != null) {
        i = j;
      }
    }
    localByteArrayOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
  
  protected HttpURLConnection a(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  @NonNull
  public nua.a a()
  {
    return a;
  }
  
  public void sendRequest(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean)
  {
    a(paramHttpRequset, paramOnHttpListener, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void a(HttpURLConnection paramHttpURLConnection, @Nullable String paramString);
    
    public abstract InputStream b(@Nullable InputStream paramInputStream);
    
    public abstract void bbv();
  }
  
  static class b
    implements nua.a
  {
    public void a(HttpURLConnection paramHttpURLConnection, @Nullable String paramString) {}
    
    public InputStream b(@Nullable InputStream paramInputStream)
    {
      return paramInputStream;
    }
    
    public void bbv() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nua
 * JD-Core Version:    0.7.0.1
 */