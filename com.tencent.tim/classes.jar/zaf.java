import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.dataline.activities.LiteActivity;
import com.dataline.activities.PrinterActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter.3;
import com.tencent.mobileqq.activity.contacts.device.ContactsDeviceAdapter.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import cooperation.smartdevice.SmartDevicePluginDownloadActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zaf
  extends abeg
  implements View.OnClickListener
{
  private boolean bqf;
  private boolean bqg;
  public boolean bqh = true;
  protected boolean bqi = true;
  protected int ccs;
  protected QQAppInterface mApp;
  protected Context mContext;
  public ArrayList<DeviceInfo> rr = new ArrayList(1);
  protected ArrayList<yzr> rs;
  
  public zaf(Context paramContext, QQAppInterface paramQQAppInterface, ListView paramListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramListView, paramInt, paramBoolean);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  private void a(View paramView, Friends paramFriends)
  {
    this.bqh = false;
    syw localsyw = (syw)this.mApp.getBusinessHandler(51);
    paramFriends = localsyw.a(paramFriends.signature, paramFriends.iTermType);
    localsyw.a((Activity)this.mContext, paramFriends, false);
    paramView.postDelayed(new ContactsDeviceAdapter.4(this), 1000L);
    long l;
    if (paramFriends == null)
    {
      l = paramFriends.din;
      if (paramFriends.isAdmin != 1) {
        break label129;
      }
      i = 1;
      tar.a(null, l, "Usr_LiteApp_Open", i, 0, paramFriends.productId);
      l = paramFriends.din;
      if (paramFriends.userStatus != 10) {
        break label134;
      }
    }
    label129:
    label134:
    for (int i = 1;; i = 2)
    {
      tar.a(null, l, "Usr_LiteApp_Open_Online", i, 0, paramFriends.productId);
      return;
      i = 2;
      break;
    }
  }
  
  private void cnq()
  {
    ArrayList localArrayList = new ArrayList();
    Friends localFriends = new Friends();
    localFriends.uin = acbn.bkw;
    localFriends.remark = acfp.m(2131696154);
    localFriends.name = acfp.m(2131696154);
    if (im(acbn.bkw))
    {
      i = 10;
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(yzq.a(5, localFriends, this.mApp, this.mContext));
      if (localFriends.status != 0) {
        this.ccs += 1;
      }
      if ((im(acbn.bkx)) || (this.bqf))
      {
        localFriends = new Friends();
        localFriends.uin = acbn.bkx;
        localFriends.remark = this.mContext.getString(2131695447);
        localFriends.name = this.mContext.getString(2131695447);
        if (!im(acbn.bkx)) {
          break label422;
        }
        i = 10;
        label175:
        localFriends.status = ((byte)i);
        localFriends.groupid = 1001;
        localArrayList.add(yzq.a(5, localFriends, this.mApp, this.mContext));
        if (localFriends.status != 0) {
          this.ccs += 1;
        }
        if (!this.bqg)
        {
          anot.a(this.mApp, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.bqg = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
        }
      }
      if (((acir)this.mApp.getBusinessHandler(74)).abe())
      {
        localFriends = new Friends();
        localFriends.uin = acbn.bky;
        localFriends.remark = this.mContext.getString(2131692404);
        localFriends.name = this.mContext.getString(2131692404);
        if (!im(acbn.bkx)) {
          break label427;
        }
      }
    }
    label422:
    label427:
    for (int i = 10;; i = 0)
    {
      localFriends.status = ((byte)i);
      localFriends.groupid = 1001;
      localArrayList.add(yzq.a(5, localFriends, this.mApp, this.mContext));
      if (localFriends.status != 0) {
        this.ccs += 1;
      }
      if (this.bqi) {}
      this.rs.addAll(localArrayList);
      return;
      i = 0;
      break;
      i = 0;
      break label175;
    }
  }
  
  private void fM(View paramView)
  {
    int i = 1;
    if (this.bqh)
    {
      this.bqh = false;
      if (awjb.a().cF(this.mApp)) {
        break label136;
      }
      Intent localIntent1 = new Intent(this.mContext, SmartDevicePluginDownloadActivity.class);
      this.mContext.startActivity(localIntent1);
    }
    for (;;)
    {
      boolean bool;
      try
      {
        bool = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).getBoolean("enable_public_device_" + this.mApp.getCurrentAccountUin(), true);
        if (bool)
        {
          tar.a(null, "Usr_NewDevice_Click", i, 0, 0);
          paramView.postDelayed(new ContactsDeviceAdapter.3(this), 1000L);
          return;
        }
      }
      catch (Exception localException1)
      {
        bool = true;
        continue;
        i = 0;
        continue;
      }
      label136:
      Intent localIntent2 = new Intent();
      localIntent2.putExtra("nickname", this.mApp.getCurrentNickname());
      localIntent2.putExtra("bitmap", this.mApp.a(this.mApp.getCurrentAccountUin(), (byte)2, false));
      localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
      String str1 = "com.tencent.device.activities.DeviceSearchActivity";
      try
      {
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4);
        bool = localSharedPreferences.getBoolean("enable_public_device_" + this.mApp.getCurrentAccountUin(), true);
        str2 = localSharedPreferences.getString("square_url_" + this.mApp.getCurrentAccountUin(), "");
        if (bool)
        {
          str1 = "com.tencent.device.activities.DeviceSquareActivity";
          i = 3;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            SharedPreferences localSharedPreferences;
            String str2;
            if (!TextUtils.isEmpty(str2)) {
              localIntent2.putExtra("url", str2);
            }
            bool = localSharedPreferences.getBoolean("search_device_enable_https_" + this.mApp.getCurrentAccountUin(), false);
            if ((VersionUtils.isIceScreamSandwich()) && (bool)) {
              localIntent2.putExtra("url", "https://qzs.qq.com/open/mobile/iot_public_device_2/html/devDiscover.html");
            }
            awjb.a().a((Activity)this.mContext, this.mApp, this.mApp.getAccount(), localIntent2, str1, 0, null, SmartDevicePluginProxyActivity.class);
            tar.a(null, "Usr_NewDevice_Click", i, 0, 0);
          }
          catch (Exception localException3)
          {
            continue;
          }
          localException2 = localException2;
          i = 2;
          continue;
          i = 2;
        }
      }
    }
  }
  
  private boolean im(String paramString)
  {
    ackv localackv = (ackv)this.mApp.getBusinessHandler(10);
    int i;
    if (paramString.equals(acbn.bkw)) {
      i = localackv.bi();
    }
    for (;;)
    {
      if ((i == 1) || (i == 2))
      {
        return true;
        if (paramString.equals(acbn.bkx)) {
          i = localackv.AM();
        }
      }
      else
      {
        return false;
      }
      i = 0;
    }
  }
  
  public void Bj(boolean paramBoolean)
  {
    this.bqi = paramBoolean;
  }
  
  public void am(boolean paramBoolean, String paramString)
  {
    Object localObject = this.rs;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    localObject = ((List)localObject).iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((yzr)((Iterator)localObject).next()).c;
      if (((localFriends.uin.equals(acbn.bkw)) || (localFriends.uin.equals(acbn.bky))) && ((paramString.equals(acbn.bkw)) || (paramString.equals(acbn.bky))))
      {
        if (paramBoolean)
        {
          j = 10;
          label117:
          localFriends.status = ((byte)j);
        }
      }
      else
      {
        if (localFriends.uin.equals(paramString))
        {
          if (!paramBoolean) {
            break label174;
          }
          j = 10;
          label145:
          localFriends.status = ((byte)j);
        }
        if (localFriends.status == 0) {
          break label186;
        }
        i += 1;
      }
    }
    label174:
    label186:
    for (;;)
    {
      break;
      j = 0;
      break label117;
      j = 0;
      break label145;
      this.ccs = i;
      return;
    }
  }
  
  public void bm(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != this.mApp) {
      this.mApp = paramQQAppInterface;
    }
  }
  
  public void clear()
  {
    if (this.rr != null) {
      this.rr.clear();
    }
    if (this.rs != null) {
      this.rs.clear();
    }
    super.notifyDataSetChanged();
  }
  
  public void cnr()
  {
    int j = 0;
    ArrayList localArrayList = this.rs;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return;
    }
    int i = 0;
    if (i < localArrayList.size()) {
      if (!((Friends)((yzr)localArrayList.get(i)).c).uin.equals(acbn.bky)) {}
    }
    for (;;)
    {
      if (((acir)this.mApp.getBusinessHandler(74)).abe()) {
        if (i == -1)
        {
          Friends localFriends = new Friends();
          localFriends.uin = acbn.bky;
          localFriends.remark = this.mContext.getString(2131692404);
          localFriends.name = this.mContext.getString(2131692404);
          i = j;
          if (im(acbn.bkw)) {
            i = 10;
          }
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(yzq.a(5, localFriends, this.mApp, this.mContext));
        }
      }
      for (;;)
      {
        am(im(acbn.bkw), acbn.bkw);
        return;
        i += 1;
        break;
        if (i != -1) {
          localArrayList.remove(i);
        }
      }
      i = -1;
    }
  }
  
  public void cns()
  {
    ArrayList localArrayList = this.rs;
    this.bqf = true;
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    label123:
    label253:
    for (;;)
    {
      return;
      int i = 0;
      if (i < localArrayList.size()) {
        if (!((Friends)((yzr)localArrayList.get(i)).c).uin.equals(acbn.bkx)) {}
      }
      for (;;)
      {
        if (i != -1) {
          break label253;
        }
        Friends localFriends = new Friends();
        localFriends.uin = acbn.bkx;
        localFriends.remark = this.mContext.getString(2131695447);
        localFriends.name = this.mContext.getString(2131695447);
        if (im(acbn.bkx))
        {
          i = 10;
          localFriends.status = ((byte)i);
          localFriends.groupid = 1001;
          localArrayList.add(yzq.a(5, localFriends, this.mApp, this.mContext));
          if (localFriends.status == 0) {
            break label245;
          }
        }
        for (i = 1;; i = 0)
        {
          this.ccs = i;
          anot.a(this.mApp, "CliOper", "", "", "0X8005D18", "0X8005D18", 0, 0, "", "", "", "");
          this.bqg = true;
          if (QLog.isColorLevel()) {
            QLog.d("ContactsDeviceAdapter", 2, "=== dataline report event show ipad 0X8005D18 ");
          }
          ((ackv)this.mApp.getBusinessHandler(10)).JI(1);
          return;
          i += 1;
          break;
          i = 0;
          break label123;
        }
        i = -1;
      }
    }
  }
  
  public int getCount()
  {
    if (this.rs == null) {
      return 0;
    }
    return this.rs.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.rs == null) {
      return null;
    }
    return (yzr)this.rs.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((yzr)this.rs.get(paramInt)).a(0, paramInt, paramView, paramViewGroup, null);
    if (localView != null)
    {
      a((yzr.b)localView.getTag(), null);
      localView.setOnClickListener(this);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.rs == null) {
      this.rs = new ArrayList();
    }
    for (;;)
    {
      cnq();
      super.notifyDataSetChanged();
      return;
      this.rs.clear();
    }
  }
  
  public void onClick(View paramView)
  {
    yzr.b localb = (yzr.b)paramView.getTag();
    BaseActivity localBaseActivity = null;
    Object localObject = localBaseActivity;
    if (localb != null)
    {
      localObject = localBaseActivity;
      if ((localb.item instanceof Friends)) {
        localObject = (Friends)localb.item;
      }
    }
    if (localObject == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (acbn.bkv.equals(((Friends)localObject).uin)) {
        if (QLog.isColorLevel()) {
          QLog.d("SDKQQAgentPerf", 2, "devicesearchEntry:" + System.currentTimeMillis());
        }
      }
      try
      {
        ((altq)this.mApp.getManager(36)).OS("100701.100702");
        label118:
        if ((this.mContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.mContext;
          if (Build.VERSION.SDK_INT < 23) {
            break label269;
          }
          if (aczy.bd(localBaseActivity)) {
            break label261;
          }
          localBaseActivity.requestPermissions(new zag(this, paramView, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        }
        for (;;)
        {
          if (!acbn.bkw.equals(((Friends)localObject).uin)) {
            break label277;
          }
          localObject = new Intent(this.mContext, LiteActivity.class);
          ((Intent)localObject).putExtra("targetUin", acbn.bkw);
          this.mContext.startActivity((Intent)localObject);
          anot.a(this.mApp, "CliOper", "", "", "0X800603C", "0X800603C", 0, 0, "", "", "", "");
          break;
          label261:
          fM(paramView);
          continue;
          label269:
          fM(paramView);
        }
        label277:
        if (acbn.bkx.equals(((Friends)localObject).uin))
        {
          localObject = new Intent(this.mContext, LiteActivity.class);
          ((Intent)localObject).putExtra("targetUin", acbn.bkx);
          this.mContext.startActivity((Intent)localObject);
          anot.a(this.mApp, "CliOper", "", "", "0X8006041", "0X8006041", 0, 0, "", "", "", "");
          continue;
        }
        if (acbn.bky.equals(((Friends)localObject).uin))
        {
          localObject = new Intent(this.mContext, PrinterActivity.class);
          this.mContext.startActivity((Intent)localObject);
          continue;
        }
        if ((!acbn.bkX.equals(((Friends)localObject).uin)) || (!this.bqh)) {
          continue;
        }
        if ((this.mContext instanceof BaseActivity))
        {
          localBaseActivity = (BaseActivity)this.mContext;
          if (Build.VERSION.SDK_INT < 23) {
            continue;
          }
          if (!aczy.bd(localBaseActivity))
          {
            localBaseActivity.requestPermissions(new zah(this, paramView, (Friends)localObject, localBaseActivity), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
            continue;
          }
          a(paramView, (Friends)localObject);
          continue;
        }
        a(paramView, (Friends)localObject);
      }
      catch (Exception localException)
      {
        break label118;
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt != 0) {
      ApngImage.pauseByTag(3);
    }
    if (paramInt == 0) {
      ApngImage.playByTag(3);
    }
  }
  
  public int ya()
  {
    int i = 0;
    while (i < getCount())
    {
      Object localObject1 = getItem(i);
      if ((localObject1 != null) && ((localObject1 instanceof zae)))
      {
        localObject1 = (Friends)((zae)localObject1).c;
        Object localObject2 = (syw)this.mApp.getBusinessHandler(51);
        if (localObject2 != null)
        {
          localObject2 = ((syw)localObject2).nX();
          if (((Friends)localObject1).name.equals(localObject2)) {
            return i;
          }
        }
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zaf
 * JD-Core Version:    0.7.0.1
 */