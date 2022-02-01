import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.biz.common.offline.OfflineExpire.2;
import com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate.1;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class jpf
{
  public static int PLATFORM_ANDROID = 3;
  public static String TAG = "OfflineExpire";
  private static int aCB;
  public static boolean isInit;
  
  protected static void a(String paramString, QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "parsePreDown:" + paramString);
    }
    if (paramInt == 1) {}
    for (paramInt = 300000;; paramInt = 0)
    {
      ArrayList localArrayList;
      for (;;)
      {
        Object localObject;
        try
        {
          paramString = new JSONObject(paramString).optJSONArray("data");
          aCB = 0;
          paramContext = new WeakReference(paramQQAppInterface);
          localArrayList = new ArrayList();
          int j = paramString.length();
          int i = 0;
          if (i >= j) {
            break label399;
          }
          localObject = paramString.optJSONObject(i);
          if (localObject != null) {
            break label163;
          }
          i += 1;
          continue;
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
        QLog.i(TAG, 2, "parsePreDown: " + QLog.getStackTraceString(paramString));
        return;
        label163:
        int k = ((JSONObject)localObject).optInt("code");
        if ((k > 0) && (k < 10))
        {
          String str1 = ((JSONObject)localObject).optInt("bid") + "";
          String str2 = ((JSONObject)localObject).optString("url");
          int m = ((JSONObject)localObject).optInt("filesize", 0);
          BidDownloader localBidDownloader = new BidDownloader(str1, paramQQAppInterface, new jpg(paramContext, str2, m, str1), true, k);
          localBidDownloader.ver = ((JSONObject)localObject).optInt("id");
          JSONObject localJSONObject = jpa.b(str1);
          if ((localJSONObject == null) || (localJSONObject.optInt("version", 0) < localBidDownloader.ver))
          {
            if (((JSONObject)localObject).optInt("network", 0) == 1) {}
            for (boolean bool = true;; bool = false)
            {
              localBidDownloader.aaY = bool;
              aCB += 1;
              localBidDownloader.url = str2;
              localBidDownloader.aCy = m;
              localBidDownloader.aaT = true;
              localObject = new jpf.b(paramQQAppInterface, str1, localBidDownloader);
              if (!localBidDownloader.aaY) {
                break label388;
              }
              localArrayList.add(localObject);
              break;
            }
            label388:
            localArrayList.add(0, localObject);
          }
        }
      }
      label399:
      ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.2(paramContext, localArrayList), paramInt);
      return;
    }
  }
  
  private static String getLocalVerify(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.tmdownloader.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = MD5.toMD5(localStringBuilder.toString());
      return MD5.toMD5(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  protected static void lb(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "parseExpire:" + paramString);
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        int j = paramString.length();
        if (i >= j) {
          break;
        }
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          break label121;
        }
        i += 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      QLog.i(TAG, 2, "parseExpire: " + QLog.getStackTraceString(paramString));
      return;
      label121:
      int k = ((JSONObject)localObject).optInt("bid");
      if (k > 0)
      {
        localObject = jpe.dO(k + "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = (String)localObject + k;
          if (new File((String)localObject).exists()) {
            jqo.dn((String)localObject);
          }
        }
      }
    }
  }
  
  public static class a
    implements andh
  {
    public a(QQAppInterface paramQQAppInterface)
    {
      if (paramQQAppInterface.getLongAccountUin() % 10L == 6L) {}
      for (boolean bool = true;; bool = false)
      {
        jpa.aba = bool;
        return;
      }
    }
    
    public ReqItem a(int paramInt)
    {
      if (jpf.isInit) {
        return null;
      }
      jpf.isInit = true;
      if (QLog.isColorLevel()) {
        QLog.d(jpf.TAG, 2, "getCheckUpdateItemData");
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      ReqItem localReqItem;
      OfflinePkg.ReqBody localReqBody;
      int j;
      String str;
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        localReqItem = new ReqItem();
        localReqItem.cOperType = 1;
        localReqItem.eServiceID = 127;
        localReqBody = new OfflinePkg.ReqBody();
        localReqBody.uint32_cmd.set(2);
        localReqBody.uint32_platform.set(jpf.PLATFORM_ANDROID);
        if (QLog.isColorLevel()) {
          QLog.d(jpf.TAG, 1, String.format("OfflineExpireCheckUpdate, check update QQ Version: %s", new Object[] { "3.4.4.3058" }));
        }
        localReqBody.str_qver.set(ByteStringMicro.copyFrom("3.4.4.3058".getBytes()));
        localReqBody.str_osrelease.set(ByteStringMicro.copyFrom(Build.VERSION.RELEASE.getBytes()));
        paramInt = jqi.getNetworkType(((QQAppInterface)localObject).getApp());
        localReqBody.int32_network.set(paramInt);
        localReqBody.str_from.set(ByteStringMicro.copyFrom("predown".getBytes()));
        localObject = jpa.hN();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label426;
        }
        String[] arrayOfString = ((String)localObject).split(",");
        int m = arrayOfString.length;
        j = 0;
        if (j >= m) {
          break label426;
        }
        str = arrayOfString[j];
        if (!TextUtils.isEmpty(str)) {
          localObject = str.split("\\|");
        }
      }
      for (;;)
      {
        for (;;)
        {
          int i;
          try
          {
            paramInt = Integer.valueOf(localObject[0]).intValue();
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            int k;
            i = 0;
            localNumberFormatException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i(jpf.TAG, 2, "NumberFormatException:" + str);
            }
            paramInt = 0;
            continue;
          }
          catch (Exception localException1)
          {
            i = 0;
          }
          try
          {
            k = Integer.valueOf(localObject[1]).intValue();
            i = paramInt;
            paramInt = k;
            if (i != 0) {
              break label383;
            }
            j += 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              OfflinePkg.BidPkg localBidPkg;
              i = paramInt;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            label383:
            i = paramInt;
          }
        }
        return null;
        if (QLog.isColorLevel()) {
          QLog.i(jpf.TAG, 2, "Exception:" + str);
        }
        paramInt = 0;
        continue;
        localBidPkg = new OfflinePkg.BidPkg();
        localBidPkg.uint32_bid.set(i);
        localBidPkg.uint32_pkg_id.add(Integer.valueOf(paramInt));
        localReqBody.st_bid_pkg.add(localBidPkg);
      }
      label426:
      localReqItem.vecParam = aqnv.I(localReqBody.toByteArray());
      return localReqItem;
    }
    
    public void a(RespItem paramRespItem)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jpf.TAG, 2, "handleCheckUpdateItemData");
      }
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        if (paramRespItem.cResult != 2) {
          break label279;
        }
        if (paramRespItem.eServiceID == 127)
        {
          paramRespItem = aqnv.J(paramRespItem.vecUpdate);
          if (paramRespItem != null) {
            localRspBody = new OfflinePkg.RspBody();
          }
        }
      }
      label279:
      while (!QLog.isColorLevel()) {
        try
        {
          OfflinePkg.RspBody localRspBody;
          localRspBody.mergeFrom(paramRespItem);
          jpf.lb(new String(localRspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
          jpf.a(new String(localRspBody.str_predown_pkg_ex.get().toByteArray(), "UTF-8"), (QQAppInterface)localObject, ((QQAppInterface)localObject).getApp().getApplicationContext(), 1);
          ThreadManager.getSubThreadHandler().postDelayed(new OfflineExpire.OfflineExpireCheckUpdate.1(this), 180000L);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramRespItem)
        {
          for (;;)
          {
            paramRespItem.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i(jpf.TAG, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
            }
          }
        }
        catch (UnsupportedEncodingException paramRespItem)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jpf.TAG, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
            }
          }
        }
        catch (Exception paramRespItem)
        {
          for (;;)
          {
            paramRespItem.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i(jpf.TAG, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
            }
          }
        }
      }
      QLog.d(jpf.TAG, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
    }
    
    public int mT()
    {
      return 1;
    }
  }
  
  public static class b
    extends aopm
  {
    public BidDownloader a;
    
    public b(QQAppInterface paramQQAppInterface, String paramString, BidDownloader paramBidDownloader)
    {
      super(paramString);
      this.a = paramBidDownloader;
    }
    
    protected void realCancel()
    {
      QLog.i(jpf.TAG, 1, "cancel predown bid=" + this.a.mBusinessId);
    }
    
    protected void realStart()
    {
      QLog.i(jpf.TAG, 1, "start predown bid=" + this.a.mBusinessId);
      this.a.yh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpf
 * JD-Core Version:    0.7.0.1
 */