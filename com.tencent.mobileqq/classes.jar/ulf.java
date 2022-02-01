import UserGrowth.stFeed;
import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.10;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.11;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8;
import com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class ulf
{
  private List<uof> jdField_a_of_type_JavaUtilList;
  private Map<String, Set<String>> jdField_a_of_type_JavaUtilMap;
  
  private stSimpleGetFeedListRsp a(int paramInt)
  {
    return (stSimpleGetFeedListRsp)a(new stSimpleGetFeedListRsp(), paramInt);
  }
  
  private <T extends JceStruct> T a(T paramT, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = a();
    }
    while (TextUtils.isEmpty(str))
    {
      return null;
      if (paramInt == 2) {
        str = c();
      } else if (paramInt == 3) {
        str = d();
      } else if (paramInt == 4) {
        str = b();
      }
    }
    return a(paramT, FileUtils.readFile(str));
  }
  
  private String a()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_data";
  }
  
  @NotNull
  private Set<String> a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    Set localSet = (Set)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
    }
    return localObject;
  }
  
  public static ulf a()
  {
    return ulg.a();
  }
  
  private boolean a(JceStruct paramJceStruct, String paramString, int paramInt)
  {
    if (paramInt <= 0) {}
    byte[] arrayOfByte;
    do
    {
      return false;
      arrayOfByte = a(paramJceStruct);
    } while ((arrayOfByte == null) || (arrayOfByte.length <= 0));
    boolean bool = FileUtils.writeFile(arrayOfByte, paramString, false);
    paramString = new StringBuilder().append("write cache to ").append(paramString);
    if (bool) {}
    for (paramJceStruct = " succeed";; paramJceStruct = " failed")
    {
      uya.d("WeiShiCacheManager", paramJceStruct + ", cache list size = " + paramInt + ", bytes length = " + arrayOfByte.length);
      return bool;
    }
  }
  
  private int b()
  {
    return umu.a().d();
  }
  
  private String b()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_recommend_vertical_data";
  }
  
  private int c()
  {
    return unc.a().a;
  }
  
  private String c()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_reddot_data";
  }
  
  private String d()
  {
    return BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath() + "/file/weishi/ws_follow_data_" + uyo.a();
  }
  
  public int a()
  {
    return LocalMultiProcConfig.getInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
  }
  
  public <T extends JceStruct> T a(T paramT, byte[] paramArrayOfByte)
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
  
  public List<uof> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return Collections.emptyList();
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public Set<String> a()
  {
    return a(uyo.a());
  }
  
  public void a()
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.11(this));
  }
  
  public void a(String paramString)
  {
    a(uyo.a()).add(paramString);
  }
  
  public void a(List<stFeed> paramList)
  {
    if (c() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.3(this));
    }
    while (uxr.a(paramList)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.4(this, paramList));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, int paramInt)
  {
    if (b() == 0) {
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.5(this));
    }
    while ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.6(this, new ArrayList(paramList), paramInt));
  }
  
  public void a(List<stSimpleMetaFeed> paramList, long paramLong)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList(paramList);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp.feeds = localArrayList;
      ThreadManager.executeOnFileThread(new WeiShiCacheManager.10(this, localstSimpleGetFeedListRsp, localArrayList, paramLong, paramList));
      return;
    }
    a();
  }
  
  public void a(ulb paramulb)
  {
    ThreadManager.post(new WeiShiCacheManager.1(this, paramulb), 8, null, true);
  }
  
  public boolean a()
  {
    long l1 = LocalMultiProcConfig.getLong("weishi_usergrowth", "key_red_msg_valid_timestamp", 0L);
    long l2 = System.currentTimeMillis();
    long l3 = l1 - l2;
    uya.d("WeiShiCacheManager", "validTimestamp-currentTimestamp = " + l1 + "-" + l2 + " = " + l3);
    return l3 > 0L;
  }
  
  public byte[] a(JceStruct paramJceStruct)
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
  
  public void b(List<stSimpleMetaFeed> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.8(this, paramList));
  }
  
  public void b(ulb paramulb)
  {
    ThreadManager.post(new WeiShiCacheManager.2(this, new WeakReference(paramulb)), 8, null, true);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void c(List<uof> paramList)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void c(ulb paramulb)
  {
    ThreadManager.executeOnFileThread(new WeiShiCacheManager.9(this, paramulb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ulf
 * JD-Core Version:    0.7.0.1
 */