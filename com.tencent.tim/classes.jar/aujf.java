import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.CloudFileActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.call.activity.CallActivity;
import com.tencent.tim.mvp.me.MePresenter.1;
import com.tencent.tim.mvp.me.MePresenter.3;
import com.tencent.tim.mvp.me.MePresenter.4;
import com.tencent.tim.mvp.me.MePresenter.6;
import com.tencent.tim.todo.TodoListActivity;
import cooperation.qwallet.plugin.QWalletHelper;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class aujf
  extends augv
  implements auje.a
{
  private auje.b a;
  private String aPb;
  private boolean aXN = true;
  private acfd c = new auji(this);
  private String cIu = "";
  private String cIv = "";
  private String cIw = "";
  accn cardObserver = new aujh(this);
  private long createTime;
  private boolean diW;
  public MqqHandler g = new aujg(this);
  
  public aujf(QQAppInterface paramQQAppInterface, auje.b paramb)
  {
    super(paramQQAppInterface, paramb);
    this.a = paramb;
  }
  
  private void evk()
  {
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)20021));
    localCardHandler.d(localArrayList, null);
    ((FriendListHandler)this.app.getBusinessHandler(1)).K(new String[] { this.app.getCurrentAccountUin() });
  }
  
  private void m(Card paramCard)
  {
    if ((!this.diW) && (((TextUtils.isEmpty(paramCard.strSchool)) && (TextUtils.isEmpty(paramCard.strCompany))) || (paramCard.getRichStatus() == null)))
    {
      this.diW = true;
      evk();
      return;
    }
    n(paramCard);
  }
  
  private void n(Card paramCard)
  {
    for (;;)
    {
      try
      {
        bTL();
        if (!TextUtils.isEmpty(paramCard.strCompany)) {
          this.cIw = paramCard.strCompany;
        }
        if (!TextUtils.isEmpty(paramCard.strSchool)) {
          this.cIv = paramCard.strSchool;
        }
        Object localObject2 = paramCard.strCompany;
        Object localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = paramCard.strSchool;
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = this.cIw;
          localObject2 = localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = this.cIv;
            this.a.Bl((String)localObject1);
            localObject2 = "";
            RichStatus localRichStatus = paramCard.getRichStatus();
            paramCard = (Card)localObject2;
            if (localRichStatus != null) {
              paramCard = localRichStatus.getPlainText();
            }
            if (TextUtils.isEmpty(paramCard))
            {
              paramCard = this.cIu;
              localObject2 = paramCard;
              if (TextUtils.isEmpty(paramCard))
              {
                localObject2 = paramCard;
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  localObject2 = this.a.a().getString(2131695222);
                }
              }
              this.a.Bm((String)localObject2);
              return;
            }
            this.cIu = paramCard;
            continue;
          }
        }
        localObject1 = localObject2;
      }
      catch (Throwable paramCard)
      {
        QLog.d("MePresenter", 1, paramCard, new Object[0]);
        return;
      }
    }
  }
  
  private void showToast()
  {
    QQToast.a(this.a.a(), "调整中...", 0).show();
  }
  
  public void VQ(boolean paramBoolean)
  {
    if (isActive())
    {
      if (paramBoolean) {
        break label31;
      }
      this.app.cLw();
      this.g.sendEmptyMessageDelayed(1, 200L);
    }
    label31:
    while (aunq.cdv <= 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    auns.F(localArrayList, aunq.a().dq());
    aunq.cdv = 0;
    this.a.hO(localArrayList);
  }
  
  public void b(aunr paramaunr)
  {
    if ((paramaunr == null) || (paramaunr.c == null)) {}
    Object localObject;
    String str1;
    BaseActivity localBaseActivity;
    do
    {
      int i;
      do
      {
        String str2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject = paramaunr.c.strGotoUrl;
                str1 = paramaunr.c.strResName;
                i = paramaunr.c.sResSubType;
                str2 = paramaunr.c.strPkgName;
                localBaseActivity = this.a.a();
                if (i == 0)
                {
                  paramaunr = (aunr)localObject;
                  if (((String)localObject).indexOf("plg_uin=1") > -1) {
                    paramaunr = (String)localObject + "&mqquin=" + this.app.getCurrentAccountUin();
                  }
                  localObject = paramaunr;
                  if (paramaunr.indexOf("plg_vkey=1") > -1) {
                    localObject = paramaunr + "&mqqvkey=" + this.app.rL();
                  }
                  paramaunr = new Intent(localBaseActivity, QQBrowserActivity.class);
                  if (((String)localObject).indexOf("plg_nld=1") > -1) {
                    paramaunr.putExtra("reportNld", true);
                  }
                  paramaunr.putExtra("uin", this.app.getCurrentAccountUin());
                  paramaunr.putExtra("vkey", this.app.rK());
                  paramaunr.putExtra("plugin_start_time", System.nanoTime());
                  paramaunr.putExtra("click_start_time", System.currentTimeMillis());
                  paramaunr.putExtra("startOpenPageTime", System.currentTimeMillis());
                  paramaunr.putExtra("is_from_leba", true);
                  localBaseActivity.startActivity(paramaunr.putExtra("url", (String)localObject).putExtra("title", str1));
                  return;
                }
                if (i != 1) {
                  break;
                }
              } while ("PKG_MY_COMPUTER".equals(str2));
              if ("PKG_FAV".equals(str2))
              {
                if (!localBaseActivity.isInMultiWindow()) {}
                for (boolean bool = true;; bool = false)
                {
                  avja.a(localBaseActivity, this.app.getAccount(), null, -1, bool);
                  avjg.b(this.app, 1, 0);
                  avjj.ZS(this.app.getCurrentAccountUin());
                  anpc.report("tim_mine_tab_favorite_click");
                  return;
                }
              }
              if ("PKG_PHONE".equals(str2))
              {
                paramaunr = new Intent(localBaseActivity, CallActivity.class);
                paramaunr.putExtra("key_is_from_me", true);
                localBaseActivity.startActivity(paramaunr);
                anpc.report("tim_mine_tab_phone_click");
                return;
              }
              if ("PKG_FILE".equals(str2))
              {
                localBaseActivity.startActivity(new Intent(localBaseActivity, CloudFileActivity.class));
                anpc.report("tim_mine_tab_file_click");
                return;
              }
              if ("PKG_APPCENTER".equals(str2))
              {
                new Intent();
                return;
              }
              if ("PKG_SCHEDULE".equals(str2))
              {
                atni.aU("0X80069FE", 0, 1);
                paramaunr = new Intent();
                localObject = (atnk)this.app.getManager(115);
                paramaunr.putExtra("schedule_unread_count", ((atnk)localObject).Ow());
                atni.startPluginActivityForResult(localBaseActivity, "com.dingdong.business.Schedule.Activity.ScheduleListActivity", paramaunr, -1);
                ((atnk)localObject).aay(0);
                anpc.report("tim_mine_tab_agenda_click");
                atni.eM(this.app);
                return;
              }
              if ("PKG_TODOLIST".equals(str2))
              {
                paramaunr = new Intent(localBaseActivity, TodoListActivity.class);
                paramaunr.putExtra("from_me_tab", true);
                localBaseActivity.startActivity(paramaunr);
                localBaseActivity.overridePendingTransition(2130772004, 2130772005);
                anpc.report("tim_mine_tab_remain_click");
                return;
              }
            } while ("PKG_SETTING".equals(str2));
            if ("PKG_EMAIL".equals(str2))
            {
              ((augo)this.app.getManager(374)).g(localBaseActivity, new Intent(), 1);
              anpc.report("tim_mine_tab_email_click");
              return;
            }
          } while (("PKG_TEAMWORK_DOC".equals(str2)) || ("PKG_FULI".equals(str2)));
          if ("PKG_CLOUD_FILE".equals(str2))
          {
            showToast();
            return;
          }
          if ("PKG_QQ_WALLET".equals(str2))
          {
            QWalletHelper.launchQWalletAct(localBaseActivity, this.app, true, false);
            anpc.report("tim_mine_tab_wallet_click");
            return;
          }
        } while (!"PKG_XIAOCHENGXU".equals(str2));
        MiniAppLauncher.startMiniApp(BaseApplicationImpl.getContext(), "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fapp-list%2Fapp-list%3Fmode%3Dtim&_vt=3&via=2106_1&_sig=132974282", 2106, null);
        anpc.report("tim_mine_tab_mini_app_click");
        return;
      } while (i != 2);
      localObject = aqik.c(this.app, localBaseActivity, (String)localObject);
    } while (localObject == null);
    if ((paramaunr.c.strPkgName.equals("com.tx.gamecenter.android")) || (paramaunr.c.strResName.contains(this.app.getApp().getResources().getString(2131694197)))) {
      ((aqhv)localObject).gY("platformId=qq_m");
    }
    while ((paramaunr.c == null) || (!paramaunr.c.strPkgName.equals("qzone_feedlist")))
    {
      ((aqhv)localObject).fj("from_leba", "fromleba");
      ((aqhv)localObject).fj("config_res_plugin_item_name", str1);
      ((aqhv)localObject).fj("redtouch_click_timestamp", String.valueOf((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L)));
      ((aqhv)localObject).setPkgName(paramaunr.c.strPkgName);
      ((aqhv)localObject).ace();
      return;
    }
    anpc.report("tim_mine_tab_qqspace_click");
    ThreadManager.executeOnSubThread(new MePresenter.4(this, localBaseActivity, (aqhv)localObject, paramaunr));
  }
  
  void bQx()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MePresenter", 2, "refreshLebaConfig. begin.");
    }
    ThreadManager.excute(new MePresenter.3(this), 16, null, true);
  }
  
  public void bTL()
  {
    String str;
    if (isActive())
    {
      str = this.app.getCurrentAccountUin();
      this.a.wd(str);
      if (TextUtils.isEmpty(str))
      {
        this.aPb = "";
        this.a.Bn(this.aPb);
      }
    }
    else
    {
      return;
    }
    if (!TextUtils.isEmpty(this.aPb))
    {
      this.a.Bn(this.aPb);
      return;
    }
    Object localObject = (acff)this.app.getManager(51);
    if (localObject != null)
    {
      localObject = ((acff)localObject).a(str);
      if ((localObject == null) || (TextUtils.isEmpty(((Friends)localObject).name))) {
        break label147;
      }
    }
    label147:
    for (localObject = ((Friends)localObject).name;; localObject = "")
    {
      this.aPb = ((String)localObject);
      if (TextUtils.isEmpty(this.aPb)) {
        break;
      }
      this.a.Bn(this.aPb);
      return;
    }
    ThreadManager.excute(new MePresenter.1(this, str), 64, null, true);
  }
  
  public void evj()
  {
    bTL();
    acff localacff = (acff)this.app.getManager(51);
    Card localCard = localacff.a(this.app.getCurrentAccountUin());
    if (localCard == null)
    {
      ThreadManager.excute(new MePresenter.6(this, localacff), 32, null, true);
      return;
    }
    m(localCard);
  }
  
  public void onCreate()
  {
    this.createTime = SystemClock.uptimeMillis();
    this.app.addObserver(this.cardObserver);
    this.app.addObserver(this.c);
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.cardObserver);
    this.app.removeObserver(this.c);
    this.diW = false;
    this.cIw = "";
    this.cIv = "";
    this.cIu = "";
    this.aPb = "";
  }
  
  public void onItemClick(View paramView)
  {
    b((aunr)paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujf
 * JD-Core Version:    0.7.0.1
 */