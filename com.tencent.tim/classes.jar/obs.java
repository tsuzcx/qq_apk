import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.imageopt.RIJImageOptBitmapFile;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader.1;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AccountNotMatchException;
import mqq.os.MqqHandler;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.protocol.HttpContext;
import org.jetbrains.annotations.Nullable;

public class obs
  extends aolf
{
  private BaseApplicationImpl b;
  
  public obs(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.b = paramBaseApplicationImpl;
  }
  
  private void H(String paramString, long paramLong)
  {
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {}
    for (String[] arrayOfString = { "param_WIFIPublicPlatDownloadFlow", "param_WIFIFlow", "param_Flow" };; arrayOfString = new String[] { "param_XGPublicPlatDownloadFlow", "param_XGFlow", "param_Flow" }) {
      try
      {
        ((QQAppInterface)this.b.getAppRuntime(paramString)).sendAppDataIncerment(paramString, arrayOfString, paramLong);
        if (QLog.isColorLevel()) {
          QLog.d("PubAccountHttpDownloader", 2, "param_PublicPlatDownloadFlow fileSize: " + paramLong);
        }
        return;
      }
      catch (AccountNotMatchException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private File a(byte[] paramArrayOfByte, long paramLong)
    throws IOException
  {
    if (paramArrayOfByte != null) {
      return new RIJImageOptBitmapFile(paramArrayOfByte, paramLong);
    }
    return null;
  }
  
  public static URL a(String paramString, int paramInt)
  {
    return a(paramString, paramInt, null);
  }
  
  public static URL a(String paramString, int paramInt, Object paramObject)
  {
    String str;
    for (;;)
    {
      try
      {
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("https"))) {
          return new URL(paramString);
        }
        paramObject = aurr.getArgumentsFromURL(paramString);
        if (!paramObject.containsKey("busiType")) {
          continue;
        }
        paramString = paramString.replace("busiType=" + (String)paramObject.get("busiType"), "busiType=" + paramInt);
        paramString = new URL("pubaccountimage", null, paramString);
        str = paramString;
        try
        {
          if (!QLog.isColorLevel()) {
            return str;
          }
          QLog.d("PubAccountHttpDownloader", 2, "<--generateURL urlString =" + paramString.toString());
          return paramString;
        }
        catch (MalformedURLException paramObject) {}
      }
      catch (MalformedURLException paramObject)
      {
        paramString = null;
        continue;
      }
      str = paramString;
      if (!QLog.isColorLevel()) {
        return str;
      }
      QLog.e("PubAccountHttpDownloader", 2, "<--generateURL urlString", paramObject);
      return paramString;
      paramString = aurr.addParameter(paramString, "busiType", paramInt + "");
    }
    return str;
  }
  
  private void a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, HttpContext paramHttpContext, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
  {
    ThreadManager.getFileThreadHandler().post(new PubAccountHttpDownloader.1(this, paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramHttpContext, paramBoolean, paramInt2, paramInputStream, paramLong));
  }
  
  private byte[] a(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    return ajxq.readBytes(paramInputStream, (int)paramLong);
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws IOException
  {
    String str = paramDownloadParams.urlStr;
    if (str.startsWith("pubaccountimage")) {
      str = paramDownloadParams.url.getFile();
    }
    for (;;)
    {
      Object localObject1 = aurr.getArgumentsFromURL(str);
      if (((Map)localObject1).get("busiType") != null) {}
      int i;
      obs.b localb;
      int j;
      Object localObject4;
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)((Map)localObject1).get("busiType"));
          paramDownloadParams.url = new URL(str);
          paramDownloadParams.urlStr = str;
          localb = new obs.b(this.b, i);
          localb.a(paramDownloadParams, (Map)localObject1);
          localObject1 = null;
          if (paramDownloadParams.headers == null) {
            break label695;
          }
          Header[] arrayOfHeader = paramDownloadParams.headers;
          j = arrayOfHeader.length;
          i = 0;
          if (i >= j) {
            break;
          }
          localObject4 = arrayOfHeader[i];
          if ("my_uin".equals(((Header)localObject4).getName())) {
            localObject1 = ((Header)localObject4).getValue();
          }
          i += 1;
          continue;
          i = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str + "  busiType:" + (String)((Map)localObject1).get("busiType"), localNumberFormatException);
        }
      }
      label692:
      label695:
      for (Object localObject5 = localObject1;; localObject5 = null)
      {
        obs.a locala = new obs.a(paramOutputStream);
        Object localObject3 = null;
        j = 0;
        int k = 1;
        i = k - 1;
        localObject1 = localObject3;
        if (k > 0)
        {
          j += 1;
          localObject1 = localObject3;
          localObject4 = localObject3;
        }
        for (;;)
        {
          try
          {
            localb.clearError();
            localObject1 = localObject3;
            localObject4 = localObject3;
            localObject3 = super.a(locala, paramDownloadParams, localb.a(paramURLDrawableHandler));
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              localObject4 = localObject3;
              boolean bool = localObject3 instanceof RIJImageOptBitmapFile;
              if (!bool) {
                break label692;
              }
            }
            i = -1;
            if (!this.dY.get()) {
              continue;
            }
            localb.a(j, paramDownloadParams);
            localObject1 = localObject3;
          }
          catch (IOException localIOException)
          {
            localObject4 = localObject2;
            if (!localIOException.getMessage().contains(" response error! response code: ")) {
              continue;
            }
            if (i != 0) {
              continue;
            }
            localObject4 = localObject2;
            throw localIOException;
          }
          finally
          {
            if (!this.dY.get()) {
              continue;
            }
            localb.a(j, paramDownloadParams);
            Object localObject2 = localObject4;
            continue;
            localObject4 = localObject2;
            localb.aF(-1, localIOException.getMessage());
            continue;
            localObject4 = localObject2;
            try
            {
              ((FileOutputStream)paramOutputStream).getChannel().truncate(0L);
              if (this.dY.get()) {
                localb.a(j, paramDownloadParams);
              }
            }
            catch (Exception localException)
            {
              localObject4 = localObject2;
              QLog.e("PubAccountHttpDownloader", 2, "urlString: " + str, localException);
              continue;
              if ((i == -1) || (i == 0))
              {
                localb.a(j, paramDownloadParams);
                continue;
              }
              try
              {
                Thread.sleep(5L);
              }
              catch (InterruptedException localInterruptedException2)
              {
                localInterruptedException2.printStackTrace();
              }
            }
            continue;
            if ((i != -1) && (i != 0)) {
              continue;
            }
            localb.a(j, paramDownloadParams);
            throw paramOutputStream;
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException paramDownloadParams)
            {
              paramDownloadParams.printStackTrace();
            }
            continue;
            if (localObject5 == null) {
              continue;
            }
            H(localObject5, locala.mCount);
            return localObject2;
          }
          if (this.dY.get())
          {
            throw new IOException("cancelled");
            if ((i == -1) || (i == 0))
            {
              localb.a(j, paramDownloadParams);
              localObject1 = localObject3;
              localObject3 = localObject1;
              k = i;
              break;
            }
            try
            {
              Thread.sleep(5L);
              localObject1 = localObject3;
            }
            catch (InterruptedException localInterruptedException1)
            {
              localInterruptedException1.printStackTrace();
              localObject2 = localObject3;
            }
            continue;
          }
        }
      }
    }
  }
  
  @Nullable
  protected File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt1, HttpContext paramHttpContext, boolean paramBoolean, int paramInt2, InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (lgj.Cf())
    {
      byte[] arrayOfByte = a(paramInputStream, paramLong);
      QLog.d("PubAccountHttpDownloader", 1, "read into memory done");
      if (arrayOfByte != null)
      {
        a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramHttpContext, paramBoolean, paramInt2, new ByteArrayInputStream(arrayOfByte), paramLong);
        return a(arrayOfByte, paramLong);
      }
    }
    return super.a(paramOutputStream, paramDownloadParams, paramURLDrawableHandler, paramInt1, paramHttpContext, paramBoolean, paramInt2, paramInputStream, paramLong);
  }
  
  public void a(HttpResponse paramHttpResponse, String paramString, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramURLDrawableHandler instanceof obs.b.a))
    {
      paramURLDrawableHandler = ((obs.b.a)paramURLDrawableHandler).a();
      if (paramURLDrawableHandler != null) {
        paramURLDrawableHandler.a(paramHttpResponse, paramString);
      }
    }
  }
  
  protected boolean r(File paramFile)
  {
    return paramFile instanceof RIJImageOptBitmapFile;
  }
  
  class a
    extends FilterOutputStream
  {
    int mCount = 0;
    
    public a(OutputStream paramOutputStream)
    {
      super();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      this.mCount += 1;
      this.out.write(paramInt);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      this.mCount += paramInt2;
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static class b
  {
    private static String[] bI = { "2909288299" };
    private final String LOGTAG;
    private String ape;
    private String apf;
    private String apg;
    private String aph;
    private String apj;
    private String apk;
    private BaseApplicationImpl c;
    private HashMap<String, String> eG = new HashMap();
    private Map<String, String> eV;
    private int mBusiType;
    private int mErrorCode;
    private String mHost;
    private long mStartTime;
    private boolean mSuccess;
    private String mUrl;
    private final int seq;
    private long yx;
    private long yy;
    
    public b(BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
    {
      this.mBusiType = paramInt;
      this.c = paramBaseApplicationImpl;
      this.seq = kxm.getSeq();
      this.LOGTAG = ("PubAccountHttpDownloader." + this.seq);
    }
    
    private boolean inBlackList(String paramString)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      String[] arrayOfString;
      int j;
      int i;
      if (paramString != null)
      {
        arrayOfString = bI;
        j = arrayOfString.length;
        i = 0;
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < j)
        {
          if (paramString.equals(arrayOfString[i])) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public void X(boolean paramBoolean, int paramInt)
    {
      QLog.d(this.LOGTAG, 2, "download task finish, ret : " + paramBoolean + ", errCode : " + paramInt);
      this.mSuccess = paramBoolean;
      this.mErrorCode = paramInt;
      this.yx = (SystemClock.uptimeMillis() - this.mStartTime);
    }
    
    public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
    {
      return new obs.b.a(paramURLDrawableHandler, this);
    }
    
    public void a(int paramInt, DownloadParams paramDownloadParams)
    {
      Object localObject1;
      if (this.eV.containsKey("puin"))
      {
        localObject1 = (String)this.eV.get("puin");
        paramDownloadParams = (String)this.eV.get("msgid");
      }
      for (;;)
      {
        if (inBlackList((String)localObject1)) {}
        Object localObject2;
        do
        {
          return;
          if ((paramDownloadParams.mExtraInfo == null) || (!(paramDownloadParams.mExtraInfo instanceof MessageRecord))) {
            break label910;
          }
          paramDownloadParams = (MessageRecord)paramDownloadParams.mExtraInfo;
          localObject1 = paramDownloadParams.frienduin;
          if (((paramDownloadParams instanceof MessageForStructing)) && (((MessageForStructing)paramDownloadParams).structingMsg != null))
          {
            paramDownloadParams = "" + ((MessageForStructing)paramDownloadParams).structingMsg.msgId;
            break;
          }
          if ((!(paramDownloadParams instanceof MessageForPubAccount)) || (((MessageForPubAccount)paramDownloadParams).mPAMessage == null)) {
            break label905;
          }
          paramDownloadParams = "" + ((MessageForPubAccount)paramDownloadParams).mPAMessage.mMsgId;
          break;
          localObject2 = this.c.getRuntime();
          if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {
            break label334;
          }
          localObject2 = (QQAppInterface)localObject2;
          if (localObject1 == null) {
            break label310;
          }
          switch (ocp.d((QQAppInterface)localObject2, (String)localObject1))
          {
          }
        } while (this.mBusiType == 0);
        int i = 0;
        this.eG.put("param_acc_type", "" + i);
        this.eG.put("param_puin", localObject1);
        label310:
        localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
        if (localObject1 != null) {
          this.eG.put("param_uin", localObject1);
        }
        label334:
        if (paramDownloadParams != null) {
          this.eG.put("param_msgid", paramDownloadParams);
        }
        this.eG.put("AttemptCount", "" + paramInt);
        this.eG.put("picFormat", this.apf);
        this.eG.put("netType", this.apj);
        this.eG.put("plateform", this.aph);
        this.eG.put("pixDensity", this.apk);
        paramDownloadParams = aopd.a().a(this.mHost, 1009);
        if (paramDownloadParams != null)
        {
          paramDownloadParams = TextUtils.join(",", paramDownloadParams);
          label459:
          this.eG.put("IPs", paramDownloadParams);
          this.eG.put("ServerIP", "");
          this.eG.put("OriginURL", this.mUrl);
          localObject1 = this.eG;
          if (!this.mSuccess) {
            break label862;
          }
          paramDownloadParams = String.valueOf(1);
          label514:
          ((HashMap)localObject1).put("Success", paramDownloadParams);
          this.eG.put("TotalTime", Long.toString(this.yx));
          this.eG.put("picType", this.apg);
          this.eG.put("ReceivedBytes", String.valueOf(this.yy));
          this.eG.put("ErrorReason", this.ape);
          this.eG.put("param_FailCode", this.mErrorCode + "");
          this.eG.put("Speed", Float.toString((float)this.yy / ((float)this.yx / 1000.0F)));
          paramDownloadParams = "actSubscriptionUnkonw";
          switch (this.mBusiType)
          {
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("reportTag:").append(paramDownloadParams).append(", success:").append(this.mSuccess).append(", time:").append(this.yx).append(", size:").append(this.yy).append(", url:").append(this.mUrl).append(", exInfo:").append(this.eG.toString());
            QLog.d(this.LOGTAG, 2, ((StringBuilder)localObject1).toString());
          }
          anpc.a(BaseApplication.getContext()).collectPerformance(null, paramDownloadParams, this.mSuccess, this.yx, this.yy, this.eG, "", true);
          return;
          i = 1;
          break;
          i = 2;
          break;
          i = 3;
          break;
          i = 4;
          break;
          paramDownloadParams = "";
          break label459;
          label862:
          paramDownloadParams = String.valueOf(0);
          break label514;
          paramDownloadParams = "actSubscriptionAIO";
          continue;
          paramDownloadParams = "actSubscriptionDetail";
          continue;
          paramDownloadParams = "actSubscriptionFolder";
          continue;
          paramDownloadParams = "actKandianImage";
          continue;
          paramDownloadParams = "actNativeWebImage";
        }
        label905:
        paramDownloadParams = null;
        continue;
        label910:
        paramDownloadParams = null;
        localObject1 = null;
      }
    }
    
    public void a(DownloadParams paramDownloadParams, Map<String, String> paramMap)
    {
      long l = aomi.a().getNetType();
      this.apj = "None";
      if ((l > 0L) && (l < acbn.dQ.length)) {
        this.apj = acbn.dQ[((int)l)];
      }
      this.aph = ("ANDROID.MOBILE-" + Build.MODEL + ".SDK-" + Build.VERSION.SDK);
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
      this.apk = (localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels);
      this.mUrl = paramDownloadParams.urlStr;
      this.mHost = paramDownloadParams.url.getHost();
      this.apf = "none";
      int i = this.mUrl.lastIndexOf("/");
      if ((i != -1) && (i + 1 <= this.mUrl.length()) && (i + 1 < this.mUrl.length()))
      {
        this.apf = this.mUrl.substring(i + 1);
        i = this.apf.indexOf("?");
        if (i != -1) {
          this.apf = this.apf.substring(0, i);
        }
      }
      this.eV = paramMap;
    }
    
    public void a(HttpResponse paramHttpResponse, String paramString)
    {
      if (paramHttpResponse != null)
      {
        paramString = paramHttpResponse.getFirstHeader("Content-Type");
        this.apg = "none";
        if ((paramString != null) && (paramString.getValue().startsWith("image/"))) {
          this.apg = paramString.getValue().replace("image/", "");
        }
        paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Length");
        if (paramHttpResponse != null) {}
        try
        {
          this.yy = Long.valueOf(paramHttpResponse.getValue()).longValue();
          return;
        }
        catch (NumberFormatException paramHttpResponse)
        {
          paramHttpResponse.printStackTrace();
          return;
        }
      }
      this.ape = paramString;
    }
    
    public void aF(int paramInt, String paramString)
    {
      if (this.mErrorCode == 0) {
        this.mErrorCode = paramInt;
      }
      this.ape = paramString;
      this.mSuccess = false;
      this.yx = (SystemClock.uptimeMillis() - this.mStartTime);
    }
    
    public void bdn()
    {
      this.mStartTime = SystemClock.uptimeMillis();
      QLog.d(this.LOGTAG, 2, "start download pic , url : " + this.mUrl);
    }
    
    public void clearError()
    {
      this.mErrorCode = 0;
      this.ape = null;
    }
    
    public static class a
      implements URLDrawableHandler
    {
      private URLDrawableHandler jdField_a_of_type_ComTencentImageURLDrawableHandler;
      private obs.b jdField_a_of_type_Obs$b;
      
      public a(URLDrawableHandler paramURLDrawableHandler, obs.b paramb)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
        this.jdField_a_of_type_Obs$b = paramb;
      }
      
      public obs.b a()
      {
        return this.jdField_a_of_type_Obs$b;
      }
      
      public void doCancel()
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.doCancel();
      }
      
      public boolean isCancelled()
      {
        return this.jdField_a_of_type_ComTencentImageURLDrawableHandler.isCancelled();
      }
      
      public void onFileDownloadFailed(int paramInt)
      {
        this.jdField_a_of_type_Obs$b.X(false, paramInt);
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadFailed(paramInt);
      }
      
      public void onFileDownloadStarted()
      {
        this.jdField_a_of_type_Obs$b.bdn();
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadStarted();
      }
      
      public void onFileDownloadSucceed(long paramLong)
      {
        this.jdField_a_of_type_Obs$b.X(true, 0);
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.onFileDownloadSucceed(paramLong);
      }
      
      public void publishProgress(int paramInt)
      {
        this.jdField_a_of_type_ComTencentImageURLDrawableHandler.publishProgress(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     obs
 * JD-Core Version:    0.7.0.1
 */