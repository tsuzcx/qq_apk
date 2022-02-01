import UserGrowth.stFeed;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.util.WeakReference;

public class ogr
{
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  private <T extends JceStruct> T a(T paramT, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = jm();
    }
    while (TextUtils.isEmpty(str))
    {
      return null;
      if (paramInt == 2) {
        str = lk();
      } else if (paramInt == 3) {
        str = ll();
      }
    }
    return b(paramT, aqhq.readFile(str));
  }
  
  public static ogr a()
  {
    return ogr.a.b();
  }
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    byte[] arrayOfByte;
    do
    {
      return false;
      arrayOfByte = encodeWup(paramJceStruct);
    } while ((arrayOfByte == null) || (arrayOfByte.length <= 0));
    boolean bool = aqhq.writeFile(arrayOfByte, paramString, false);
    paramString = new StringBuilder().append("write cache to ").append(paramString);
    if (bool) {}
    for (paramJceStruct = " succeed";; paramJceStruct = " failed")
    {
      ooz.e("WeiShiCacheManager", paramJceStruct + ", cache list size = " + paramInt + ", bytes length = " + arrayOfByte.length);
      return bool;
    }
  }
  
  private String jm()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
  }
  
  private String lk()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_reddot_data";
  }
  
  private String ll()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_data";
  }
  
  private int rm()
  {
    return ohy.a().ru();
  }
  
  private int rn()
  {
    return oie.a().akP;
  }
  
  public boolean GJ()
  {
    long l1 = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_msg_valid_timestamp", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    ooz.e("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + l1 + "-" + l2 + " = " + l3);
    return l3 > 0L;
  }
  
  public boolean GK()
  {
    String str1 = opn.lM();
    String str2 = LocalMultiProcConfig.getString("weishi_usergrowth", "key_ws_cache_v", "");
    ooz.d("CacheResponseLog", "getCachedTrendsWSData versionName = " + str1 + ", cachedVersionName = " + str2);
    return (!TextUtils.isEmpty(str1)) && (TextUtils.equals(str1, str2));
  }
  
  public void a(ogo paramogo)
  {
    ThreadManager.post(new WeiShiCacheManager.1(this, paramogo), 8, null, true);
  }
  
  public <T extends JceStruct> T b(T paramT, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf8");
      paramT.readFrom(paramArrayOfByte);
      return paramT;
    }
    catch (Exception paramT)
    {
      paramT.printStackTrace();
    }
    return null;
  }
  
  public void b(ogo paramogo)
  {
    ThreadManager.post(new WeiShiCacheManager.2(this, new WeakReference(paramogo)), 8, null, true);
  }
  
  public void beC()
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.9(this));
  }
  
  public void c(List<stSimpleMetaFeed> paramList, long paramLong)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp.feeds = localArrayList;
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.8(this, localstSimpleGetFeedListRsp, localArrayList, paramLong, paramList));
      return;
    }
    beC();
  }
  
  public void dz(List<stFeed> paramList)
  {
    if (rn() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.3(this));
    }
    while (oor.v(paramList)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.4(this, paramList));
  }
  
  public byte[] encodeWup(JceStruct paramJceStruct)
  {
    if (paramJceStruct != null) {
      try
      {
        JceOutputStream localJceOutputStream = new JceOutputStream();
        localJceOutputStream.setServerEncoding("utf8");
        paramJceStruct.writeTo(localJceOutputStream);
        paramJceStruct = localJceOutputStream.toByteArray();
        return paramJceStruct;
      }
      catch (Exception paramJceStruct)
      {
        paramJceStruct.printStackTrace();
      }
    }
    return null;
  }
  
  public int ro()
  {
    return LocalMultiProcConfig.getInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
  }
  
  public void w(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (rm() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this));
    }
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this, new ArrayList(paramList), paramInt));
  }
  
  static class a
  {
    private static final ogr a = new ogr(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogr
 * JD-Core Version:    0.7.0.1
 */