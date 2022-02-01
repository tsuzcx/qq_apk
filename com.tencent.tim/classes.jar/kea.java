import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;

public class kea
{
  public static final String Yl = BaseApplication.getContext().getFilesDir() + File.separator + "shop_assit_banner_json.txt";
  public ShopWebViewFragment a;
  public kec a;
  public boolean aet;
  Runnable bz = new EcshopCacheTool.1(this);
  BusinessObserver d = new keb(this);
  public Map<String, Friends> du;
  Map<String, Bitmap> dv;
  public Map<String, Integer> dw;
  public Map<String, String> dx;
  public EntityManager mEntityManager;
  
  public kea(AppInterface paramAppInterface, ShopWebViewFragment paramShopWebViewFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment = paramShopWebViewFragment;
    this.dw = new ConcurrentHashMap();
    this.dx = new ConcurrentHashMap();
    this.dv = new ConcurrentHashMap();
    this.mEntityManager = paramAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Kec = ((kec)paramAppInterface.getBusinessHandler(0));
    ThreadManager.post(this.bz, 5, null, true);
  }
  
  public void a(AppRuntime paramAppRuntime, List<Long> paramList, double paramDouble1, double paramDouble2)
  {
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ailu.class);
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.puinlist.addAll(paramList);
    if ((!TextUtils.isEmpty(paramAppRuntime.getAccount())) && (paramDouble1 != 0.0D) && (paramDouble2 != 0.0D))
    {
      localSQQSHPClientReq.latitude.set(paramDouble2);
      localSQQSHPClientReq.longitude.set(paramDouble1);
      QLog.i("EcshopCacheTool", 2, "lat:" + paramDouble2 + ",lon:" + paramDouble1);
    }
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetShopBindUin");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.d);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void aF(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent("action_get_PA_head");
    localIntent.putExtra("uin", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void aG(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    paramContext.startActivity(localIntent);
  }
  
  public void c(AppRuntime paramAppRuntime, int paramInt)
  {
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    localSQQSHPClientReq.msglistlen.set(paramInt);
    NewIntent localNewIntent = new NewIntent(paramAppRuntime.getApplication(), ailu.class);
    localNewIntent.putExtra("extra_cmd", "SQQShopFolderSvc.GetFolderInfo");
    localNewIntent.putExtra("extra_data", localSQQSHPClientReq.toByteArray());
    localNewIntent.putExtra("extra_timeout", 30000L);
    localNewIntent.setObserver(this.d);
    paramAppRuntime.startServlet(localNewIntent);
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitShopWebViewFragment = null;
    this.jdField_a_of_type_Kec = null;
    if (this.du != null) {
      this.du.clear();
    }
    if (this.dv != null) {
      this.dv.clear();
    }
    if (this.dw != null) {
      this.dw.clear();
    }
    if (this.dx != null) {
      this.dx.clear();
    }
  }
  
  public String getNickName(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.du == null)) {
      return "";
    }
    paramString = (Friends)this.du.get(paramString);
    if (paramString != null) {
      return paramString.getFriendNick();
    }
    return "";
  }
  
  public boolean isFriend(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.du == null)) {
      return false;
    }
    return (Friends)this.du.get(paramString) != null;
  }
  
  public void j(String paramString, Bitmap paramBitmap)
  {
    synchronized (this.dv)
    {
      this.dv.put(paramString, paramBitmap);
      return;
    }
  }
  
  public Bitmap q(String paramString)
  {
    synchronized (this.dv)
    {
      paramString = (Bitmap)this.dv.get(paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kea
 * JD-Core Version:    0.7.0.1
 */