import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.activity.contact.troop.RecommendTroopView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import mqq.app.NewIntent;
import tencent.im.nearbygroup.ext.NearbyGroupExt.ReqBody;
import tencent.im.troop_search_userinfo.userinfo.AppInfo;
import tencent.im.troop_search_userinfo.userinfo.DevAttr;
import tencent.im.troop_search_userinfo.userinfo.GPS;
import tencent.im.troop_search_userinfo.userinfo.UserInfo;

public class wqd
  extends SosoInterface.OnLocationListener
{
  public wqd(RecommendTroopView paramRecommendTroopView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject1;
    Object localObject2;
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      this.a.b = Double.valueOf(paramSosoLbsInfo.a.a * 1000000.0D).intValue();
      this.a.c = Double.valueOf(paramSosoLbsInfo.a.b * 1000000.0D).intValue();
      paramSosoLbsInfo = new userinfo.UserInfo();
      localObject1 = new userinfo.GPS();
      if (this.a.b != 0)
      {
        ((userinfo.GPS)localObject1).uint32_lat.set(this.a.b);
        ((userinfo.GPS)localObject1).uint32_lon.set(this.a.c);
        paramSosoLbsInfo.gps.set((MessageMicro)localObject1);
        localObject1 = (TelephonyManager)this.a.a().getSystemService("phone");
        if (localObject1 != null)
        {
          localObject2 = new userinfo.DevAttr();
          if (((TelephonyManager)localObject1).getSimSerialNumber() != null) {
            ((userinfo.DevAttr)localObject2).str_imei.set(((TelephonyManager)localObject1).getSimSerialNumber());
          }
          if (((TelephonyManager)localObject1).getSubscriberId() != null) {
            ((userinfo.DevAttr)localObject2).str_imsi.set(((TelephonyManager)localObject1).getSubscriberId());
          }
          if (((TelephonyManager)localObject1).getLine1Number() != null) {
            ((userinfo.DevAttr)localObject2).str_phonenum.set(((TelephonyManager)localObject1).getLine1Number());
          }
          paramSosoLbsInfo.attr.set((MessageMicro)localObject2);
        }
        localObject1 = new userinfo.AppInfo();
        ((userinfo.AppInfo)localObject1).plat_type.set(2);
      }
    }
    try
    {
      localObject2 = this.a.a().getPackageManager().getPackageInfo(this.a.a().getPackageName(), 0);
      ((userinfo.AppInfo)localObject1).str_app_version.set(((PackageInfo)localObject2).versionName);
      paramSosoLbsInfo.app_info.set((MessageMicro)localObject1);
      localObject1 = new NearbyGroupExt.ReqBody();
      ((NearbyGroupExt.ReqBody)localObject1).user_info.set(paramSosoLbsInfo);
      ((NearbyGroupExt.ReqBody)localObject1).uint32_type.set(2);
      paramSosoLbsInfo = new NewIntent(this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().getApplicationContext(), ProtoServlet.class);
      paramSosoLbsInfo.putExtra("cmd", "NearbyGroupExt.GetGroupList");
      paramSosoLbsInfo.putExtra("data", ((NearbyGroupExt.ReqBody)localObject1).toByteArray());
      paramSosoLbsInfo.setObserver(new wqe(this));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramSosoLbsInfo);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wqd
 * JD-Core Version:    0.7.0.1
 */