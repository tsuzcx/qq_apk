package cooperation.qqreader.ui;

import aeay;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import avmc;
import avmt;
import avmw;
import avng;
import avnh;
import avnm;
import avny;
import avnz;
import avob.a;
import avoc;
import avog;
import avoh;
import avoj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.host.filemanager.ReaderFileInfo;
import cooperation.qqreader.net.QueryUserIdentityTask;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

public class ReaderHomePageActivity
  extends ReaderBaseWebActivity
{
  private aeay jdField_b_of_type_Aeay;
  private avmt jdField_b_of_type_Avmt;
  private String cMm;
  private String cMn;
  private boolean dnG;
  
  private static int a(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int i = 0;
      if (i < paramArrayOfInt.length) {
        if (paramInt != paramArrayOfInt[i]) {}
      }
      for (;;)
      {
        if (i > paramArrayOfInt.length)
        {
          return 0;
          i += 1;
          break;
        }
        return i;
        i = paramInt;
      }
    }
    return paramInt;
  }
  
  private ArrayList<WebViewTabBarData> a(ArrayList<avnh> paramArrayList, @NonNull Intent paramIntent)
  {
    int j = paramArrayList.size();
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.hasExtra(avng.jk)) {}
    for (paramIntent = "" + "&" + avng.jk + "=" + paramIntent.getStringExtra(avng.jk);; paramIntent = "")
    {
      int i = 0;
      while (i < j)
      {
        avnh localavnh = (avnh)paramArrayList.get(i);
        if (localavnh.exA == 0)
        {
          WebViewTabBarData localWebViewTabBarData = new WebViewTabBarData();
          localWebViewTabBarData.tabIcon = localavnh.tabIcon;
          localWebViewTabBarData.tabName = localavnh.tabName;
          localWebViewTabBarData.tag = String.valueOf(localavnh.tabID);
          localWebViewTabBarData.url = ((String)localavnh.EP.get(0) + paramIntent);
          localArrayList.add(localWebViewTabBarData);
          if (localavnh.EP.size() == 2)
          {
            this.cMm = ((String)localavnh.EP.get(0) + paramIntent);
            this.cMn = ((String)localavnh.EP.get(1) + paramIntent);
          }
        }
        i += 1;
      }
      return localArrayList;
    }
  }
  
  private static boolean aj(@NonNull Intent paramIntent)
  {
    boolean bool1 = ak(paramIntent);
    boolean bool2 = avmc.a().aKJ();
    int i = paramIntent.getIntExtra("redtouch_type", -1);
    boolean bool3 = avob.a.cO(BaseApplicationImpl.getApplication());
    if (QLog.isColorLevel()) {
      QLog.e("ReaderHomePageActivity", 2, "-->isPluginReady:" + bool2 + ",exceed30days:" + bool1 + ",isShelf:" + bool3 + ",has red touch extra:" + paramIntent.hasExtra("redtouch_type") + ",has interval:" + paramIntent.hasExtra("login_interval") + ",isPluginReady=" + bool2);
    }
    return ((i != -1) && (i != 0)) || (bool1) || (!bool3);
  }
  
  private static boolean ak(Intent paramIntent)
  {
    return paramIntent.getLongExtra("login_interval", 0L) > 155520000000L;
  }
  
  private static int b(String paramString1, int paramInt, String paramString2)
  {
    try
    {
      int i = Color.parseColor(paramString2);
      return i;
    }
    catch (Exception localException)
    {
      avoc.e("ReaderHomePageActivity", "Color is ex" + paramString1 + "=" + paramString2);
    }
    return paramInt;
  }
  
  private void by(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_b_of_type_Aeay.setServiceInfo(new avny(this, paramString1, paramString2, paramString3));
  }
  
  private void eBn()
  {
    this.jdField_b_of_type_Aeay = new aeay(this, false, true);
    this.jdField_b_of_type_Aeay.attachToActivity(this);
  }
  
  private void eBo()
  {
    QueryUserIdentityTask localQueryUserIdentityTask = new QueryUserIdentityTask();
    localQueryUserIdentityTask.a(new avnz(this), true);
    localQueryUserIdentityTask.execute();
  }
  
  private void el(@NonNull Intent paramIntent)
  {
    this.jdField_b_of_type_Avmt = new avmt(this);
    this.jdField_b_of_type_Avmt.eAR();
    paramIntent.putExtra("tabConfigData", a(this.jdField_b_of_type_Avmt.eB(), paramIntent));
    int i = h(paramIntent);
    avoc.i("ReaderHomePageActivity", "tabIndex =" + i);
    int[] arrayOfInt = this.jdField_b_of_type_Avmt.al();
    StringBuilder localStringBuilder = new StringBuilder().append("itemids is null");
    if (arrayOfInt == null) {}
    for (boolean bool = true;; bool = false)
    {
      avoc.i("ReaderHomePageActivity", bool);
      i = a(i, arrayOfInt);
      paramIntent.putExtra("key_tab_main_tab_pos", i);
      paramIntent.putExtra("tabDefaultIndex", i);
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.cMm);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.cMn);
      paramIntent.putExtra("key_tab_color", b("tabColor", avmt.exw, this.jdField_b_of_type_Avmt.FR()));
      paramIntent.putExtra("key_tab_name_color", b("tabNameDefaultColor", avmt.exx, this.jdField_b_of_type_Avmt.FS()));
      paramIntent.putExtra("key_name_selected_color", b("tabNameSelectedColor", avmt.exy, this.jdField_b_of_type_Avmt.FT()));
      return;
    }
  }
  
  private static int h(@NonNull Intent paramIntent)
  {
    int j = 0;
    int k = 1;
    int i;
    if (paramIntent.hasExtra(avng.jj)) {
      i = paramIntent.getIntExtra(avng.jj, 1);
    }
    for (;;)
    {
      return i;
      i = k;
      if (!paramIntent.getBooleanExtra("is_from_qreader_shortcut", false))
      {
        i = k;
        if (!avob.a.cQ(BaseApplicationImpl.getApplication()))
        {
          boolean bool1 = avog.cT(BaseApplicationImpl.getApplication());
          boolean bool2 = aj(paramIntent);
          if (bool1)
          {
            i = k;
            if (bool2) {}
          }
          else
          {
            if (bool1) {
              return 0;
            }
            i = j;
            if (paramIntent.getIntExtra("redtouch_type", -1) != 0) {
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public boolean F(String paramString1, String paramString2, String paramString3)
  {
    by(paramString1, paramString2, paramString3);
    return this.jdField_b_of_type_Aeay.isColorNoteExist();
  }
  
  public void WG(boolean paramBoolean)
  {
    this.dnG = paramBoolean;
  }
  
  public avmt a()
  {
    return this.jdField_b_of_type_Avmt;
  }
  
  @Nullable
  public avoj a()
  {
    avoj localavoj = null;
    WebViewFragment localWebViewFragment = c();
    if (localWebViewFragment != null) {
      localavoj = (avoj)localWebViewFragment.a;
    }
    return localavoj;
  }
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    paramWebViewTabBarData = super.a(paramWebViewTabBarData);
    Object localObject = paramWebViewTabBarData.getIntent();
    if (localObject != null)
    {
      int j = ((Intent)localObject).getIntExtra("key_tab_id", -1);
      int i = j;
      if (j < 0) {
        i = Integer.parseInt(paramWebViewTabBarData.getTag());
      }
      localObject = a();
      if (localObject != null) {
        ((avoj)localObject).abR(i);
      }
    }
    return paramWebViewTabBarData;
  }
  
  public boolean aKL()
  {
    if ((aM() instanceof ReaderTabBarView)) {
      return ((ReaderTabBarView)aM()).aKS();
    }
    return false;
  }
  
  public boolean aKP()
  {
    long l1 = avob.a.v(BaseApplicationImpl.getApplication());
    long l2 = System.currentTimeMillis();
    Object localObject1 = new Date(l1);
    Object localObject2 = new Date(l2);
    if ((aM() != null) && (((ReaderTabBarView)aM()).aKT()) && (avoh.a((Date)localObject1, (Date)localObject2)) && (AppNetConnInfo.isNetSupport()) && (avnm.a().handleEvent("START_WEBVIEW_ACTIVITY_CONDITION", null)))
    {
      localObject2 = (String)avmw.pZ.get("qqreaderBookStoreGamepop");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "https://cdn.vip.qq.com/club/client/read/6/rel/gameAd_index.html";
      }
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("from", 2);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      avmc.a().d(this, (Intent)localObject2, "com.qqreader.pureader.WebViewActivity");
      return true;
    }
    return false;
  }
  
  public boolean aKQ()
  {
    return this.dnG;
  }
  
  public void bw(String paramString1, String paramString2, String paramString3)
  {
    by(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Aeay.canAddColorNote()) {
      this.jdField_b_of_type_Aeay.insertColorNote();
    }
  }
  
  public void bx(String paramString1, String paramString2, String paramString3)
  {
    by(paramString1, paramString2, paramString3);
    if (this.jdField_b_of_type_Aeay.isColorNoteExist()) {
      this.jdField_b_of_type_Aeay.deleteColorNote();
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        break label29;
      }
    }
    label29:
    do
    {
      return;
      localObject = paramIntent.getParcelableArrayList("reslut_select_file_info_list");
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    ArrayList localArrayList = new ArrayList();
    Object localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(new ReaderFileInfo((FileInfo)((Iterator)localObject).next()));
    }
    paramIntent.remove("reslut_select_file_info_list");
    paramIntent.putParcelableArrayList("key_reader_file_for_bundle", localArrayList);
    avnm.a().handleEvent("EVENT_IMPORT_LOCAL_BOOK", paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Intent localIntent2 = getIntent();
    Intent localIntent1 = localIntent2;
    if (localIntent2 == null)
    {
      avoc.e("ReaderHomePageActivity", "[ReaderHomePageActivity] intent is null! ");
      localIntent1 = new Intent();
    }
    localIntent1.putExtra("key_enter_reader_homepage_activity_oncreate_time", System.currentTimeMillis());
    el(localIntent1);
    super.doOnCreate(paramBundle);
    eBo();
    eBn();
    avoc.u("cost_time_tag", "ReaderHomePageActivity mClickToOnCreateTime=" + (System.currentTimeMillis() - getIntent().getLongExtra("key_click_leba_start_time", 0L)));
    return true;
  }
  
  public void doOnDestroy()
  {
    this.jdField_b_of_type_Aeay.onDestroy();
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
    }
    if (aKP()) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    ek(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.putExtra("key_subtab", 0);
      paramIntent.putExtra("key_title_bar_left_tab_url", this.cMm);
      paramIntent.putExtra("key_title_bar_right_tab_url", this.cMn);
    }
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    paramIntent = (ReaderTabBarView)aM();
    if (paramIntent != null) {
      paramIntent.setSelectedTab(a(h(getIntent()), this.jdField_b_of_type_Avmt.al()), false);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = (ReaderTabBarView)aM();
    if (localObject != null) {
      ((ReaderTabBarView)localObject).bOU();
    }
    localObject = c();
    if ((localObject instanceof ReaderHomeTabFragment))
    {
      localObject = (ReaderHomeTabFragment)localObject;
      if (((ReaderHomeTabFragment)localObject).dnD)
      {
        localIntent = getIntent();
        if (localIntent != null)
        {
          j = localIntent.getIntExtra("key_tab_id", -1);
          i = j;
          if (j < 0) {
            i = Integer.parseInt(((ReaderHomeTabFragment)localObject).getTag());
          }
          localObject = (avoj)((ReaderHomeTabFragment)localObject).a;
          if (localObject != null) {
            ((avoj)localObject).abR(i);
          }
        }
      }
    }
    while (localObject == null)
    {
      Intent localIntent;
      int j;
      int i;
      return;
    }
    avoc.i("ReaderHomePageActivity", "webViewFragment =" + localObject.getClass().getName());
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    BaseApplicationImpl localBaseApplicationImpl;
    if (aM() != null)
    {
      bool = avnm.a().handleEvent("EVENT_BOOK_SHELF_IS_NOT_EMPTY", null);
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((!((ReaderTabBarView)aM()).aKS()) || (!bool)) {
        break label51;
      }
    }
    label51:
    for (boolean bool = true;; bool = false)
    {
      avob.a.V(localBaseApplicationImpl, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomePageActivity
 * JD-Core Version:    0.7.0.1
 */