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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mqq.manager.TicketManager;

public class tha
  implements IHttpAdapter
{
  public static String a;
  private static final thb jdField_a_of_type_Thb = new thc(null);
  public static final String b = "QQ/8.4.8 Android/0.17 Android/" + Build.VERSION.RELEASE;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  
  static
  {
    jdField_a_of_type_JavaLangString = "BaseHttpAdapter";
  }
  
  private String a(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
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
  {
    HttpURLConnection localHttpURLConnection = a(new URL(paramHttpRequset.url));
    localHttpURLConnection.setConnectTimeout(paramHttpRequset.timeoutMs);
    localHttpURLConnection.setReadTimeout(paramHttpRequset.timeoutMs);
    localHttpURLConnection.setUseCaches(false);
    localHttpURLConnection.setDoInput(true);
    Object localObject1;
    Object localObject2;
    if (paramHttpRequset.paramMap != null)
    {
      localObject1 = paramHttpRequset.paramMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localHttpURLConnection.addRequestProperty((String)localObject2, (String)paramHttpRequset.paramMap.get(localObject2));
      }
    }
    if ((paramHttpRequset.paramMap == null) || (!paramHttpRequset.paramMap.containsKey("Cookie")))
    {
      localObject2 = (QQAppInterface)pay.a();
      if (localObject2 != null)
      {
        TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject2).getManager(2);
        localObject1 = ((QQAppInterface)localObject2).getAccount();
        localObject2 = localTicketManager.getSkey(((QQAppInterface)localObject2).getCurrentAccountUin());
        localHttpURLConnection.addRequestProperty("Cookie", "uin=o" + (String)localObject1 + "; skey=" + (String)localObject2);
      }
    }
    if ((paramHttpRequset.paramMap == null) || (!paramHttpRequset.paramMap.containsKey("User-Agent"))) {
      localHttpURLConnection.addRequestProperty("User-Agent", b);
    }
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
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(6);
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(paramRunnable);
  }
  
  private byte[] a(InputStream paramInputStream, IHttpAdapter.OnHttpListener paramOnHttpListener)
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
  {
    return (HttpURLConnection)paramURL.openConnection();
  }
  
  @NonNull
  public thb a()
  {
    return jdField_a_of_type_Thb;
  }
  
  public void sendRequest(HttpRequset paramHttpRequset, IHttpAdapter.OnHttpListener paramOnHttpListener, boolean paramBoolean)
  {
    a(paramHttpRequset, paramOnHttpListener, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tha
 * JD-Core Version:    0.7.0.1
 */