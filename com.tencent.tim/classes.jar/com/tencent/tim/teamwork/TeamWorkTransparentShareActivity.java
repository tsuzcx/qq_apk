package com.tencent.tim.teamwork;

import acbn;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.ResultReceiver;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqgv;
import aqiw;
import aqmf;
import arhz;
import augo;
import aujz;
import aujz.a;
import aukn.b;
import auko;
import aulh;
import aull;
import aulm;
import aulq;
import aulr;
import auls;
import ault;
import aumy;
import aurf;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import rwt;

public class TeamWorkTransparentShareActivity
  extends BaseActivity
  implements Handler.Callback, aujz.a
{
  private ArrayList<aukn.b> Bf;
  private ImageView DR;
  private View KN;
  private arhz jdField_a_of_type_Arhz;
  private aujz jdField_a_of_type_Aujz;
  private aulh jdField_a_of_type_Aulh;
  aulm jdField_a_of_type_Aulm = new auls(this);
  aumy jdField_a_of_type_Aumy = new aulr(this);
  private SharePolicyInfo jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo;
  private TextView aft;
  private TextView afu;
  private TextView afv;
  public long aoW;
  protected String aue;
  protected String auf;
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
  private long kf;
  public Map<String, aukn.b> mCache = new HashMap();
  public String mTitle;
  public String mTroopName;
  public MqqHandler mUIHandler;
  private RelativeLayout nC;
  private ResultReceiver resultReceiver;
  private String title;
  private final MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this, true);
  
  private void VE(int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkTransparentShareActivity", 1, "pubFlag error:" + paramInt);
      return;
    }
    if (this.dOk == 2) {}
    for (String str = "表格";; str = "文档") {
      switch (paramInt)
      {
      default: 
        QLog.w("TeamWorkTransparentShareActivity", 1, "no process PUBFLAG:" + paramInt);
        return;
      }
    }
    this.aft.setText(getString(2131720874) + "可查看此" + str);
    this.DR.setImageResource(2130840742);
    return;
    this.aft.setText(getString(2131720874) + "可查看和编辑" + str);
    this.DR.setImageResource(2130840743);
    return;
    this.aft.setText(str + "对" + getString(2131720875) + "公开");
    this.DR.setImageResource(2130840750);
    return;
    this.aft.setText(str + getString(2131720876) + "可查看和编辑");
    this.DR.setImageResource(2130840750);
  }
  
  private void ag(List<String> paramList, int paramInt)
  {
    if ((paramInt > 3) || (paramInt < 0))
    {
      QLog.e("TeamWorkTransparentShareActivity", 1, "pubFlag error:" + paramInt);
      return;
    }
    this.afu.setTextColor(Color.parseColor("#777777"));
    if (this.dOk == 2) {}
    for (String str = "表格";; str = "文档") {
      switch (paramInt)
      {
      default: 
        QLog.w("TeamWorkTransparentShareActivity", 1, "no process PUBFLAG:" + paramInt);
        return;
      }
    }
    if (paramList != null)
    {
      ob(paramList);
      if (paramList.size() == 0)
      {
        this.afu.setTextColor(Color.parseColor("#fcba46"));
        this.afu.setText(getString(2131720902) + str);
      }
      this.afu.setVisibility(0);
      return;
    }
    this.afu.setText(getString(2131720903) + str);
    this.afu.setVisibility(0);
    return;
    this.afu.setVisibility(8);
    return;
    if (paramList != null)
    {
      ob(paramList);
      if (paramList.size() == 0) {
        this.afu.setText(getString(2131720902) + str);
      }
      this.afu.setVisibility(0);
      return;
    }
    this.afu.setText(getString(2131720903) + str);
    this.afu.setVisibility(0);
    return;
    this.afu.setVisibility(8);
  }
  
  private void b(SharePolicyInfo paramSharePolicyInfo)
  {
    if ((this.afv != null) && ((ViewGroup)this.afv.getParent() != null))
    {
      if ((paramSharePolicyInfo != null) && (paramSharePolicyInfo.isCreator))
      {
        c(paramSharePolicyInfo);
        this.jdField_a_of_type_Aujz.aB(this.KN, 0);
      }
      return;
    }
    bVR();
  }
  
  private void bVR()
  {
    this.KN = getLayoutInflater().inflate(2131563180, null);
    if (this.KN != null)
    {
      this.DR = ((ImageView)this.KN.findViewById(2131369667));
      this.aft = ((TextView)this.KN.findViewById(2131380567));
      this.afu = ((TextView)this.KN.findViewById(2131380568));
      this.nC = ((RelativeLayout)this.KN.findViewById(2131377619));
      this.afv = ((TextView)this.KN.findViewById(2131380569));
      if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.isCreator))
      {
        c(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo);
        this.jdField_a_of_type_Aujz.aB(this.KN, 0);
      }
    }
  }
  
  private void c(SharePolicyInfo paramSharePolicyInfo)
  {
    if ((paramSharePolicyInfo != null) && (paramSharePolicyInfo.isCreator) && (this.cjl.equals(ault.aS(paramSharePolicyInfo.share_url, this.dOk)))) {
      this.afv.setOnClickListener(new aulq(this, paramSharePolicyInfo));
    }
    switch (paramSharePolicyInfo.taskType)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (paramSharePolicyInfo.taskType != 1);
      this.afv.setText("更改权限");
      this.aft.setText(paramSharePolicyInfo.cjd);
      this.aft.setTextColor(Color.parseColor("#000000"));
      gb(paramSharePolicyInfo.cjh, paramSharePolicyInfo.dNJ);
      return;
    }
    this.afv.setText("更改有效期");
    this.aft.setText(paramSharePolicyInfo.cjd);
    this.aft.setTextColor(Color.parseColor("#fe6c6c"));
    if (TextUtils.isEmpty(paramSharePolicyInfo.cje))
    {
      this.afu.setVisibility(8);
      return;
    }
    this.afu.setVisibility(0);
    this.afu.setText(paramSharePolicyInfo.cje);
  }
  
  private void initUI()
  {
    this.mUIHandler = new MqqHandler();
    this.app.setHandler(getClass(), this.uiHandler);
    if (this.jdField_a_of_type_Aujz == null) {
      this.jdField_a_of_type_Aujz = new aujz(this, this.app);
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
        if (this.dOk != 1) {
          break label302;
        }
        this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/29c998e16c094b10a96b3e0d1589c2f6.png";
        str = aull.Ax();
        if (!TextUtils.isEmpty(str)) {
          this.auf = str;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(this.ckt))
        {
          this.ckt = "https://pub.idqqimg.com/pc/misc/files/20180410/1fce078ca2434b18bfec613961d526ff.png";
          str = aull.Az();
          if (!TextUtils.isEmpty(str)) {
            this.ckt = str;
          }
          if (this.dOk == 2)
          {
            this.ckt = "https://pub.idqqimg.com/pc/misc/files/20180410/5349bc325950481ebde04c38208d9028.png";
            str = aull.AA();
            if (!TextUtils.isEmpty(str)) {
              this.ckt = str;
            }
          }
        }
        this.jdField_a_of_type_Aujz.g(this.cjl, this.title, this.aue, "", this.dOk);
        if (this.cLl)
        {
          this.jdField_a_of_type_Aujz.QJ(false);
          this.jdField_a_of_type_Aujz.a(this);
          if ((this.cpk == 0) || ("null".equals(this.cks))) {}
        }
        try
        {
          this.jdField_a_of_type_Aujz.VS("TeamWorkDocEditBrowserActivity".equals(this.beJ));
          bVR();
          this.jdField_a_of_type_Aujz.Qq();
          return;
          label302:
          if (this.dOk == 2)
          {
            this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
            str = aull.Ay();
            if (!TextUtils.isEmpty(str)) {
              this.auf = str;
            }
          }
          else if (this.dOk == 3)
          {
            this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
            str = aull.Fd();
            if (!TextUtils.isEmpty(str)) {
              this.auf = str;
            }
          }
          else if (this.dOk == 4)
          {
            this.auf = "https://pub.idqqimg.com/pc/misc/files/20180403/da40f07bd79e4796b712b44023911be0.png";
            str = aull.Fe();
            if (!TextUtils.isEmpty(str))
            {
              this.auf = str;
              continue;
              this.jdField_a_of_type_Aujz.QJ(true);
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TeamWorkTransparentShareActivity", 2, "exception =" + localException.toString());
            }
          }
        }
      }
    }
    finish();
  }
  
  private void parseIntent()
  {
    Intent localIntent = getIntent();
    this.title = localIntent.getStringExtra(auko.cjn);
    this.aue = localIntent.getStringExtra(auko.cjo);
    this.auf = localIntent.getStringExtra(auko.cjp);
    this.ckt = localIntent.getStringExtra(auko.cjq);
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
  
  public void ac(int paramInt1, String paramString, int paramInt2)
  {
    if ((this.beJ == null) || (!this.beJ.equals("TeamWorkDocEditBrowserActivity")) || (paramInt1 == 0)) {}
    do
    {
      while (paramInt1 == 11)
      {
        return;
        if ((paramInt1 == 1) || (paramInt1 == 2) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt1 == 5) || (paramInt1 == 6) || (paramInt1 != 10)) {}
      }
    } while (paramInt1 != 12);
  }
  
  protected void am(int paramInt)
  {
    if (this.jdField_a_of_type_Arhz == null) {
      this.jdField_a_of_type_Arhz = new arhz(this, getTitleBarHeight());
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_Arhz.setMessage("");
    }
    for (;;)
    {
      this.jdField_a_of_type_Arhz.setCancelable(true);
      this.jdField_a_of_type_Arhz.show();
      return;
      this.jdField_a_of_type_Arhz.setMessage(paramInt);
    }
  }
  
  public void dUm()
  {
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131563169);
    parseIntent();
    initUI();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Aujz.destroy();
    if (this.mUIHandler != null) {
      this.mUIHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void doOnStart()
  {
    this.app.addObserver(this.jdField_a_of_type_Aulm);
    this.app.addObserver(this.jdField_a_of_type_Aumy);
    if ((this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo.isCreator)) {
      this.jdField_a_of_type_Aulh = ((aulh)this.app.getBusinessHandler(122));
    }
    while (this.jdField_a_of_type_Aujz == null) {
      return;
    }
    this.jdField_a_of_type_Aujz.dUl();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.app.removeObserver(this.jdField_a_of_type_Aulm);
    this.app.removeObserver(this.jdField_a_of_type_Aumy);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void gb(String paramString, int paramInt)
  {
    String str = "其中" + paramInt + "人可编辑：";
    this.nC.post(new TeamWorkTransparentShareActivity.5(this, paramString, str, paramInt));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo = ((SharePolicyInfo)paramMessage.getData().getParcelable("key_team_work_share_info"));
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqTeamworkSharePolicyInfo);
    }
    return false;
  }
  
  protected void hideProgressDialog()
  {
    if ((this.jdField_a_of_type_Arhz != null) && (this.jdField_a_of_type_Arhz.isShowing())) {
      this.jdField_a_of_type_Arhz.dismiss();
    }
  }
  
  public String nO(String paramString)
  {
    Object localObject = (aukn.b)this.mCache.get(paramString);
    if ((getAppInterface() instanceof QQAppInterface))
    {
      localObject = aqgv.b((QQAppInterface)getAppInterface(), ((aukn.b)localObject).uin, ((aukn.b)localObject).cjm, ((aukn.b)localObject).uinType);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ((aukn.b)this.mCache.get(paramString)).nickName = ((String)localObject);
      }
      return ((aukn.b)this.mCache.get(paramString)).nickName;
    }
    return null;
  }
  
  public void ob(List<String> paramList)
  {
    int i = paramList.size();
    String str = i + 1 + "人可编辑";
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList.size() == 0)
    {
      this.afu.setText(getString(2131720902));
      return;
    }
    this.nC.post(new TeamWorkTransparentShareActivity.4(this, paramList, localStringBuilder, str));
  }
  
  public void rr(int paramInt)
  {
    String str3 = ault.nT(this.cjl);
    Object localObject3;
    String str1;
    if (paramInt == 2)
    {
      localObject3 = getString(2131720970);
      if (TextUtils.isEmpty(this.auf))
      {
        str1 = null;
        String str4 = this.title;
        if (!TextUtils.isEmpty(this.aue)) {
          break label148;
        }
        localObject2 = str3;
        label54:
        aqmf.a(this, 1001, 95, "web_share", "", str1, str4, (String)localObject2, getString(2131698632, new Object[] { this.title }), str3, "web", null, null, null, "web", null, null, null, "https://docs.qq.com/desktop/favicon.ico", (String)localObject3, "", null, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
        ac(1, this.cjl, this.dOk);
        finish();
      }
    }
    label148:
    label1010:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          return;
          str1 = this.auf;
          break;
          localObject2 = this.aue;
          break label54;
          if ((paramInt == 9) || (paramInt == 10))
          {
            finish();
            return;
          }
          if (paramInt == 12)
          {
            localObject2 = this.title;
            str1 = this.auf;
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.cjl)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject2).append(" (分享自#腾讯文档#) ");
            }
            for (;;)
            {
              try
              {
                localObject2 = URLEncoder.encode(((StringBuilder)localObject3).toString(), "UTF-8");
                localObject2 = "https://service.weibo.com/share/share.php?" + "title=" + (String)localObject2;
                str3 = URLEncoder.encode(str3, "UTF-8");
                localObject2 = (String)localObject2 + "&url=" + str3;
                str1 = URLEncoder.encode(str1, "UTF-8");
                str1 = (String)localObject2 + "&pic=" + str1;
                str1 = str1 + "&_wv=0";
                localObject2 = new Intent(this, QQBrowserActivity.class);
                ((Intent)localObject2).putExtra("url", str1);
                startActivity((Intent)localObject2);
                ac(5, this.cjl, this.dOk);
                finish();
                return;
              }
              catch (Exception localException1)
              {
                QQToast.a(getApplicationContext(), 1, 2131720029, 0).show(getResources().getDimensionPixelSize(2131299627));
                QLog.e("TeamWorkTransparentShareActivity", 1, " ==== share to weibo exp: " + localException1.toString());
                continue;
              }
              QQToast.a(getApplicationContext(), 1, 2131720029, 0).show(getResources().getDimensionPixelSize(2131299627));
            }
          }
          if (paramInt == 11)
          {
            str3 = this.app.getCurrentAccountUin();
            localObject2 = null;
            try
            {
              String str2 = URLEncoder.encode(this.cjl, "UTF-8");
              str2 = "http://guanjia.qq.com/online_server/m_report.html?shareUrl=" + str2 + "&qq=" + str3 + "&_wv=7";
              localObject2 = new Intent(this, QQBrowserActivity.class);
              ((Intent)localObject2).putExtra("url", str2);
              ((Intent)localObject2).putExtra("hide_more_button", true);
              startActivity((Intent)localObject2);
              ac(6, this.cjl, this.dOk);
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
            localObject1 = (ClipboardManager)getSystemService("clipboard");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("我分享了腾讯文档 “").append(this.title).append("”，点击查看：\n").append(str3).append(" ");
            ((ClipboardManager)localObject1).setText((CharSequence)localObject2);
            rwt.ez(2, 2131692332);
            ac(2, this.cjl, this.dOk);
            finish();
            return;
          }
          if (paramInt == 26)
          {
            localObject1 = new Intent(this, DirectForwardActivity.class);
            ((Intent)localObject1).putExtra("isFromShare", true);
            ((Intent)localObject1).putExtra("isFromTeamWork", true);
            ((Intent)localObject1).putExtra("toUin", acbn.bkw);
            ((Intent)localObject1).putExtra("uinType", 6000);
            ((Intent)localObject1).putExtra("forward_type", -1);
            ((Intent)localObject1).putExtra("forward_text", str3);
            ((Intent)localObject1).putExtra("openerProc", MobileQQ.getMobileQQ().getQQProcessName());
            startActivity((Intent)localObject1);
            ac(10, this.cjl, this.dOk);
            finish();
            return;
          }
          if (paramInt != 27) {
            break label1010;
          }
          ac(12, this.cjl, this.dOk);
          if (!aqiw.isNetSupport(getApplicationContext()))
          {
            QQToast.a(getApplicationContext(), 2131693404, 0).show(getTitleBarHeight());
            return;
          }
          am(2131720882);
          this.kf = System.currentTimeMillis();
          localObject1 = (aulh)this.app.getBusinessHandler(122);
        } while ((this.cpk == 0) || ("null".equals(this.cks)));
        try
        {
          ((aulh)localObject1).ao(this.cpk, this.cks, "副本-" + this.title);
          return;
        }
        catch (Exception localException2) {}
      } while (!QLog.isColorLevel());
      QLog.e("TeamWorkTransparentShareActivity", 2, "exception =" + localException2.toString());
      return;
    } while (paramInt != 5);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<html><body><p>我分享了来自TIM的腾讯文档 “").append(this.title).append("”，点击查看：\n").append(str3).append("</p></body></html>");
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("cmd", "send_mail_chatrecord");
    ((Intent)localObject2).putExtra("mail_text", localStringBuilder.toString());
    ((augo)this.app.getManager(374)).g(this, (Intent)localObject2, 2);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.teamwork.TeamWorkTransparentShareActivity
 * JD-Core Version:    0.7.0.1
 */