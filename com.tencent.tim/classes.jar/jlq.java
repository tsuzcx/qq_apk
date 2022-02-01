import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.download.BaseDownloadAsyncTask.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.HttpConnectionParams;

public class jlq
  extends AsyncTask<ArrayList<jlr>, jlr, Integer>
{
  private static final Handler mHandler = new jlq.b(null);
  private String TAG = jlq.class.getSimpleName();
  boolean aao = false;
  private HttpClient b;
  
  private HttpGet a(jlr paramjlr, jls paramjls)
  {
    try
    {
      localObject = new HttpGet(paramjlr.mUrl);
      paramjls = (jls)localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject;
        if (localIllegalArgumentException != null) {
          paramjls.SX = localIllegalArgumentException.toString();
        }
        paramjls = null;
        continue;
        paramjls.setHeader("Net-type", "gprs");
      }
    }
    if (paramjls != null) {
      if (aqiw.isWifiConnected(BaseApplication.getContext()))
      {
        paramjls.setHeader("Net-type", "Wifi");
        if (paramjlr.mHeaders == null) {
          return paramjls;
        }
        paramjlr = paramjlr.mHeaders.entrySet().iterator();
        while (paramjlr.hasNext())
        {
          localObject = (Map.Entry)paramjlr.next();
          paramjls.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
        }
      }
    }
    return paramjls;
  }
  
  private boolean a(jls paramjls, HttpEntity paramHttpEntity, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    try
    {
      paramHttpEntity = paramHttpEntity.getContent();
      if (paramHttpEntity == null)
      {
        i = 0;
        if (paramHttpEntity == null) {}
      }
    }
    catch (IOException paramHttpEntity)
    {
      try
      {
        for (;;)
        {
          paramHttpEntity.close();
          if (i != paramInt) {
            break;
          }
          bool = true;
          if (!bool) {
            break label235;
          }
          paramjls.mBytes = arrayOfByte1;
          paramjls.mFileLength = paramInt;
          paramjls.mErrCode = 0;
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "readContent done. isSucess = " + bool + ",length=" + paramInt);
          }
          return bool;
          paramHttpEntity = paramHttpEntity;
          paramjls.mErrCode = 3;
          if (paramHttpEntity != null) {
            paramjls.SX = paramHttpEntity.toString();
          }
          paramHttpEntity = null;
        }
        byte[] arrayOfByte2 = new byte[2048];
        i = 0;
        for (;;)
        {
          try
          {
            j = paramHttpEntity.read(arrayOfByte2);
            if (j > 0) {}
          }
          catch (IOException localIOException)
          {
            paramjls.mErrCode = 3;
            if (localIOException != null) {
              paramjls.SX = localIOException.toString();
            }
            int j = 0;
            continue;
            if (i + j > paramInt)
            {
              i += j;
              break;
            }
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, j);
            i += j;
          }
        }
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          int i;
          paramHttpEntity.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label235:
          paramjls.mErrCode = 3;
          if (i < paramInt) {
            paramjls.SX = ("ContentLength " + paramInt + " but read " + i);
          } else {
            paramjls.SX = ("ContentLength " + paramInt + ",but read " + i);
          }
        }
      }
    }
  }
  
  protected Integer a(ArrayList<jlr>... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs[0] == null)) {
      return null;
    }
    Iterator localIterator = paramVarArgs[0].iterator();
    jlr localjlr;
    while (localIterator.hasNext())
    {
      localjlr = (jlr)localIterator.next();
      localjlr.a = new jls();
      localjlr.a.mErrCode = -1;
    }
    if (dj.a() != null) {}
    int m;
    int i;
    int j;
    int k;
    for (boolean bool = true;; bool = false)
    {
      this.aao = bool;
      this.b = dj.a(false, this.aao, 5000, 60000);
      localIterator = paramVarArgs[0].iterator();
      m = 5000;
      i = 60000;
      j = 0;
      paramVarArgs = "";
      if (localIterator.hasNext())
      {
        localjlr = (jlr)localIterator.next();
        k = m;
        if (localjlr.aBo != m)
        {
          k = localjlr.aBo;
          HttpConnectionParams.setConnectionTimeout(this.b.getParams(), k);
        }
        m = i;
        if (localjlr.aBp != i)
        {
          m = localjlr.aBp;
          HttpConnectionParams.setSoTimeout(this.b.getParams(), m);
        }
        i = localjlr.QV;
        if (!isCancelled()) {
          break;
        }
      }
      if ((QLog.isColorLevel()) && (!paramVarArgs.equals(""))) {
        QLog.i(this.TAG, 2, paramVarArgs);
      }
      return Integer.valueOf(j);
    }
    long l1 = System.currentTimeMillis();
    if (isCancelled()) {
      n = i;
    }
    label272:
    do
    {
      j += 1;
      long l2 = System.currentTimeMillis();
      localjlr.a.mCostTime = (l2 - l1);
      localjlr.a.QV = (localjlr.QV - n);
      paramVarArgs = paramVarArgs + localjlr.toString() + ", ";
      b(localjlr);
      mHandler.obtainMessage(1, new jlq.a(this, new jlr[] { localjlr })).sendToTarget();
      i = m;
      m = k;
      break;
      n = i;
    } while (a(this.b, localjlr));
    int n = 3;
    for (;;)
    {
      try
      {
        Thread.sleep(1000L);
        if (n > 0)
        {
          bool = aqiw.isNetworkAvailable(BaseApplication.getContext());
          if (!bool) {
            break label453;
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        continue;
        i = n;
      }
      n = i - 1;
      if (i <= 0) {
        break label272;
      }
      break;
      label453:
      n -= 1;
    }
  }
  
  public void a(jlr paramjlr) {}
  
  protected boolean a(HttpClient paramHttpClient, jlr paramjlr)
  {
    jls localjls = paramjlr.a;
    localjls.mErrCode = -2;
    HttpGet localHttpGet = a(paramjlr, localjls);
    if (localHttpGet == null) {}
    for (;;)
    {
      return localjls.mIsSucc;
      paramjlr = null;
      try
      {
        paramHttpClient = paramHttpClient.execute(localHttpGet);
        if (paramHttpClient == null) {
          return false;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          paramHttpClient = paramjlr;
          if (localIOException != null)
          {
            localjls.SX = localIOException.toString();
            paramHttpClient = paramjlr;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramHttpClient = paramjlr;
          if (localException != null)
          {
            localjls.SX = localException.toString();
            paramHttpClient = paramjlr;
          }
        }
        paramjlr = paramHttpClient.getEntity();
        if (paramjlr == null)
        {
          localjls.mErrCode = 2;
        }
        else
        {
          paramHttpClient = paramHttpClient.getStatusLine();
          int i = paramHttpClient.getStatusCode();
          int j = (int)paramjlr.getContentLength();
          if ((i == 200) || (i == 206)) {
            if (j <= 0)
            {
              localjls.mErrCode = 2;
              localjls.SX = ("invalid contentLength " + j);
              label192:
              if (localjls.mIsSucc) {
                continue;
              }
            }
          }
          try
          {
            paramjlr.getContent().close();
          }
          catch (IOException paramHttpClient)
          {
            continue;
            localjls.mIsSucc = a(localjls, paramjlr, j);
            break label192;
            localjls.mErrCode = 2;
            localjls.SX = paramHttpClient.getReasonPhrase();
            break label192;
          }
          catch (Exception paramHttpClient) {}
        }
      }
    }
  }
  
  public void b(jlr paramjlr) {}
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (this.b != null)
    {
      ThreadManager.excute(new BaseDownloadAsyncTask.1(this, this.b), 16, null, false);
      this.b = null;
    }
  }
  
  static class a<Data>
  {
    final jlq a;
    final Data[] mData;
    
    a(jlq paramjlq, Data... paramVarArgs)
    {
      this.a = paramjlq;
      this.mData = paramVarArgs;
    }
  }
  
  static class b
    extends Handler
  {
    public void handleMessage(Message paramMessage)
    {
      jlq.a locala = (jlq.a)paramMessage.obj;
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      locala.a.a(((jlr[])locala.mData)[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlq
 * JD-Core Version:    0.7.0.1
 */