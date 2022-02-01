package com.tencent.mobileqq.teamworkforgroup;

import acbn;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.TextUtils;
import aoae.b;
import aoaf;
import aobh;
import aobl;
import aobw;
import aoeh;
import aoeh.a;
import aoen;
import aqmf;
import aurf;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rwt;

public class TeamWorkTransparentShareActivity
  extends BaseActivity
  implements Handler.Callback, aoeh.a
{
  private ArrayList<aoae.b> Bf;
  private aobh jdField_a_of_type_Aobh;
  private aoeh jdField_a_of_type_Aoeh;
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  public long aoW;
  protected String aue;
  protected String auf;
  public WXShareHelper.a b;
  private int bQb = -1;
  private String beJ;
  private boolean cLl;
  public String cjl;
  public String cks;
  protected String ckt;
  public int cpk;
  public int dNK;
  private int dNL;
  public int dOk;
  Map<String, aoae.b> mCache = new HashMap();
  public String mTitle;
  public String mTroopName;
  MqqHandler mUIHandler;
  private ResultReceiver resultReceiver;
  private String title;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void initUI()
  {
    this.mUIHandler = new MqqHandler();
    this.app.setHandler(getClass(), this.uiHandler);
    if (this.jdField_a_of_type_Aoeh == null) {
      this.jdField_a_of_type_Aoeh = new aoeh(this, this.app);
    }
    if (!TextUtils.isEmpty(this.cjl))
    {
      if (TextUtils.isEmpty(this.aue))
      {
        this.aue = getString(2131720968);
        if (this.dOk == 2) {
          this.aue = getString(2131720969);
        }
      }
      String str;
      if (TextUtils.isEmpty(this.auf))
      {
        this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
        str = aobl.Ax();
        if (!TextUtils.isEmpty(str)) {
          this.auf = str;
        }
        if (this.dOk == 2)
        {
          this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
          str = aobl.Ay();
          if (!TextUtils.isEmpty(str)) {
            this.auf = str;
          }
        }
      }
      if (TextUtils.isEmpty(this.ckt))
      {
        this.ckt = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
        str = aobl.Az();
        if (!TextUtils.isEmpty(str)) {
          this.ckt = str;
        }
        if (this.dOk == 2)
        {
          this.ckt = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
          str = aobl.AA();
          if (!TextUtils.isEmpty(str)) {
            this.ckt = str;
          }
        }
      }
      this.jdField_a_of_type_Aoeh.g(this.cjl, this.title, this.aue, "", this.dOk);
      if (this.cLl) {
        this.jdField_a_of_type_Aoeh.QJ(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aoeh.a(this);
        this.jdField_a_of_type_Aoeh.Qq();
        return;
        this.jdField_a_of_type_Aoeh.QJ(true);
      }
    }
    finish();
  }
  
  private void parseIntent()
  {
    Intent localIntent = getIntent();
    this.title = localIntent.getStringExtra(aoaf.cjn);
    this.aue = localIntent.getStringExtra(aoaf.cjo);
    this.auf = localIntent.getStringExtra(aoaf.cjp);
    this.ckt = localIntent.getStringExtra(aoaf.cjq);
    this.cjl = localIntent.getStringExtra("team_work_pad_url");
    this.dNK = localIntent.getIntExtra("team_work_pad_list_type", -1);
    this.dOk = localIntent.getIntExtra("team_work_pad_type", -1);
    this.dNL = localIntent.getIntExtra("team_policy", -1);
    this.aoW = localIntent.getLongExtra("key_group_team_work_doc_group_uin", 0L);
    this.cpk = localIntent.getIntExtra("key_group_team_work_doc_domain_id", 0);
    this.cks = localIntent.getStringExtra("key_group_team_work_doc_pad_id");
    this.mTitle = localIntent.getStringExtra("key_team_work_title");
    this.mTroopName = localIntent.getStringExtra("troop_name");
    this.Bf = new ArrayList();
    this.cLl = localIntent.getBooleanExtra("team_is_my_document", false);
    this.beJ = localIntent.getStringExtra("from_activity");
    this.bQb = localIntent.getIntExtra("select_type", -1);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = ((SharePolicyInfo)getIntent().getParcelableExtra("team_work_auth_info"));
    if ((this.dNL == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo policy cannot be -1");
    }
    if ((this.dNK == -1) && (QLog.isColorLevel())) {
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mPadListType cannot be -1");
    }
    this.resultReceiver = ((ResultReceiver)getIntent().getParcelableExtra("key_result_receiver"));
  }
  
  public void dUm()
  {
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563181);
    parseIntent();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Aoeh.destroy();
    if (this.b != null)
    {
      WXShareHelper.a().b(this.b);
      this.b = null;
    }
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void doOnStart()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.isCreator)) {
      this.jdField_a_of_type_Aobh = ((aobh)this.app.getBusinessHandler(122));
    }
    while (this.jdField_a_of_type_Aoeh == null) {
      return;
    }
    this.jdField_a_of_type_Aoeh.dUl();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void rr(int paramInt)
  {
    String str1 = aobw.nT(this.cjl);
    Object localObject4;
    String str3;
    Object localObject5;
    Object localObject3;
    if (paramInt == 2)
    {
      localObject4 = aobw.cjU;
      str3 = getString(2131720970);
      if (TextUtils.isEmpty(this.auf))
      {
        localObject2 = null;
        localObject5 = this.title;
        if (!TextUtils.isEmpty(this.aue)) {
          break label139;
        }
        localObject3 = str1;
        label59:
        aqmf.a(this, 1001, 95, "web_share", "", (String)localObject2, (String)localObject5, (String)localObject3, getString(2131698632, new Object[] { this.title }), str1, "web", null, null, null, "web", null, null, null, (String)localObject4, str3, "", null, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        finish();
      }
    }
    label139:
    label206:
    label382:
    Object localObject1;
    label431:
    label466:
    do
    {
      return;
      localObject2 = this.auf;
      break;
      localObject3 = this.aue;
      break label59;
      if ((paramInt == 9) || (paramInt == 10))
      {
        int i = -1;
        if (!WXShareHelper.a().isWXinstalled())
        {
          i = 2131721935;
          if (i == -1) {
            break label206;
          }
          rwt.ez(0, i);
        }
        do
        {
          for (;;)
          {
            finish();
            return;
            if (WXShareHelper.a().isWXsupportApi()) {
              break;
            }
            i = 2131721936;
            break;
            localObject3 = String.valueOf(System.currentTimeMillis());
            if (this.b == null) {
              this.b = new aoen(this, (String)localObject3);
            }
            if (paramInt != 9) {
              break label382;
            }
            WXShareHelper.a().a(this.b);
            localObject2 = "pages/detail/detail?url=" + str1;
            if (aobw.pQ(this.ckt))
            {
              localObject3 = aobw.J(this.ckt);
              if (localObject3 != null) {
                WXShareHelper.a().d((String)localObject2, "gh_252c5f06840b", (Bitmap)localObject3, this.title, this.aue, str1);
              } else {
                WXShareHelper.a().d((String)localObject2, "gh_252c5f06840b", aobw.o(this.dOk), this.title, this.aue, str1);
              }
            }
            else
            {
              WXShareHelper.a().d((String)localObject2, "gh_252c5f06840b", aobw.o(this.dOk), this.title, this.aue, str1);
            }
          }
        } while (paramInt != 10);
        WXShareHelper.a().a(this.b);
        localObject4 = WXShareHelper.a();
        str3 = this.title;
        localObject5 = aobw.o(this.dOk);
        if (TextUtils.isEmpty(this.aue))
        {
          localObject2 = str1;
          if (paramInt != 9) {
            break label466;
          }
        }
        for (paramInt = 0;; paramInt = 1)
        {
          ((WXShareHelper)localObject4).a((String)localObject3, str3, (Bitmap)localObject5, (String)localObject2, str1, paramInt);
          break;
          localObject2 = this.aue;
          break label431;
        }
      }
      if (paramInt == 12)
      {
        localObject3 = this.title;
        localObject2 = this.auf;
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(this.cjl)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append((String)localObject3).append(" (分享自#腾讯文档#) ");
        }
        for (;;)
        {
          try
          {
            localObject3 = URLEncoder.encode(((StringBuilder)localObject4).toString(), "UTF-8");
            localObject3 = "https://service.weibo.com/share/share.php?" + "title=" + (String)localObject3;
            str1 = URLEncoder.encode(str1, "UTF-8");
            str1 = (String)localObject3 + "&url=" + str1;
            localObject2 = URLEncoder.encode((String)localObject2, "UTF-8");
            str1 = str1 + "&pic=" + (String)localObject2;
            str1 = str1 + "&_wv=0";
            localObject2 = new Intent(this, QQBrowserActivity.class);
            ((Intent)localObject2).putExtra("url", str1);
            startActivity((Intent)localObject2);
            finish();
            return;
          }
          catch (Exception localException)
          {
            QQToast.a(getApplicationContext(), 1, 2131720029, 0).show(getResources().getDimensionPixelSize(2131299627));
            QLog.e("TeamWorkTransparentShareActivity", 1, " ==== share to weibo exp: " + localException.toString());
            continue;
          }
          QQToast.a(getApplicationContext(), 1, 2131720029, 0).show(getResources().getDimensionPixelSize(2131299627));
        }
      }
      if (paramInt == 11)
      {
        localObject3 = this.app.getCurrentAccountUin();
        localObject2 = null;
        try
        {
          String str2 = URLEncoder.encode(this.cjl, "UTF-8");
          str2 = "https://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str2 + "&qq=" + (String)localObject3 + "&_wv=7";
          localObject2 = new Intent(this, QQBrowserActivity.class);
          ((Intent)localObject2).putExtra("url", str2);
          ((Intent)localObject2).putExtra("hide_more_button", true);
          startActivity((Intent)localObject2);
          finish();
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localObject1 = localObject2;
            if (QLog.isColorLevel())
            {
              QLog.d("TeamWorkTransparentShareActivity", 2, "encode shareUrl failed, because UTF-8 is unknown");
              localObject1 = localObject2;
            }
          }
        }
      }
      if (paramInt == 1)
      {
        localObject2 = (ClipboardManager)getSystemService("clipboard");
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("我分享了腾讯文档 “").append(this.title).append("”，点击查看：\n").append(localObject1).append(" ");
        ((ClipboardManager)localObject2).setText((CharSequence)localObject3);
        rwt.ez(2, 2131692332);
        finish();
        return;
      }
    } while (paramInt != 26);
    Object localObject2 = new Intent(this, DirectForwardActivity.class);
    ((Intent)localObject2).putExtra("isFromShare", true);
    ((Intent)localObject2).putExtra("isFromTeamWork", true);
    ((Intent)localObject2).putExtra("toUin", acbn.bkw);
    ((Intent)localObject2).putExtra("uinType", 6000);
    ((Intent)localObject2).putExtra("forward_type", -1);
    ((Intent)localObject2).putExtra("forward_text", localObject1);
    ((Intent)localObject2).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
    startActivity((Intent)localObject2);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TeamWorkTransparentShareActivity
 * JD-Core Version:    0.7.0.1
 */