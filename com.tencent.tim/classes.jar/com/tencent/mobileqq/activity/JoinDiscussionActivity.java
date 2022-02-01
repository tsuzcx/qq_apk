package com.tencent.mobileqq.activity;

import QQService.DiscussMemberInfo;
import QQService.InteRemarkInfo;
import QQService.RespGetDiscussInfo;
import acdt;
import acdv;
import acfd;
import acff;
import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqiw;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ved;
import vee;
import wja;

public class JoinDiscussionActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  TextView DO;
  TextView DP;
  acdt jdField_a_of_type_Acdt;
  private a jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$a;
  private b jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$b;
  String aMM;
  String aNI;
  String aNJ;
  String aNK = "";
  String aNL = "";
  int bHM = 0;
  int bHN = 0;
  private acfd c = new vee(this);
  private Button di;
  private RelativeLayout gJ;
  private RelativeLayout gK;
  long mCreateTime;
  public String mOwnerName = "";
  public long mOwnerUin;
  ArrayList<String> pm = new ArrayList();
  List<DiscussMemberInfo> qG;
  ImageView qi;
  
  private void aDR()
  {
    this.gJ = ((RelativeLayout)findViewById(2131365952));
    this.qi = ((ImageView)findViewById(2131365962));
    this.DO = ((TextView)findViewById(2131365968));
    this.DP = ((TextView)findViewById(2131365521));
    this.di = ((Button)findViewById(2131369980));
    this.gK = ((RelativeLayout)findViewById(2131366584));
  }
  
  private void bPR()
  {
    setTitle(acfp.m(2131707523));
    setRightButton(2131721058, this);
    this.leftView.setVisibility(4);
    this.di.setOnClickListener(new ved(this));
  }
  
  private void bPS()
  {
    if (aqiw.isNetSupport(this))
    {
      startTitleProgress();
      if ((this.aNI != null) && (this.aNI.length() > 0)) {
        this.jdField_a_of_type_Acdt.DB(this.aNI);
      }
      while ((this.aNJ == null) || (this.aNJ.length() <= 0)) {
        return;
      }
      this.jdField_a_of_type_Acdt.DA(this.aNJ);
      return;
    }
    bT(0, -160);
  }
  
  private void updateText()
  {
    runOnUiThread(new JoinDiscussionActivity.3(this));
  }
  
  public void bPT()
  {
    if (aqiw.isNetSupport(this))
    {
      startTitleProgress();
      this.jdField_a_of_type_Acdt.ds(this.aNI, this.bHM);
      return;
    }
    bT(1, -160);
  }
  
  void bT(int paramInt1, int paramInt2)
  {
    stopTitleProgress();
    String str = "";
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = acfp.m(2131707521);
      }
      break;
    }
    for (;;)
    {
      QQToast.a(this, str, 0).show(getTitleBarHeight());
      return;
      str = acfp.m(2131707515);
      continue;
      str = acfp.m(2131707519);
      continue;
      str = acfp.m(2131707517);
      continue;
      this.gJ.setVisibility(8);
      this.gK.setVisibility(0);
      return;
      str = acfp.m(2131707518);
      continue;
      if (paramInt1 == 0) {
        str = acfp.m(2131707516);
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559456);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$b = new b(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$a = new a(null);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$b);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$a);
    addObserver(this.c);
    this.bHM = paramBundle.getInt("addDisSource");
    this.aNI = paramBundle.getString("sig");
    this.aNJ = paramBundle.getString("innerSig");
    if (this.aNJ != null)
    {
      paramBundle = this.aNJ.toUpperCase();
      if (this.aNJ.contains("?_wv=5")) {
        this.aNJ = this.aNJ.replace("?_wv=5", "");
      }
      if ((this.aNJ != null) && (!paramBundle.startsWith("HTTP://")) && (!paramBundle.startsWith("HTTPS://"))) {
        this.aNI = this.aNJ;
      }
    }
    if ((this.aNI != null) && (this.aNI.endsWith("#flyticket"))) {
      this.aNI = this.aNI.substring(0, this.aNI.length() - "#flyticket".length());
    }
    aDR();
    bPR();
    this.jdField_a_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
    bPS();
    return true;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$b);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityJoinDiscussionActivity$a);
    removeObserver(this.c);
    super.doOnDestroy();
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771990);
  }
  
  public void onClick(View paramView)
  {
    finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  class a
    extends acfd
  {
    private a() {}
    
    public void onUpdateCustomHead(boolean paramBoolean, String paramString)
    {
      if ((!paramBoolean) || (JoinDiscussionActivity.this.qG == null) || (JoinDiscussionActivity.this.app.getCurrentAccountUin().equals(paramString))) {}
      label192:
      for (;;)
      {
        return;
        Object localObject = JoinDiscussionActivity.this.qG.iterator();
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!String.valueOf(((DiscussMemberInfo)((Iterator)localObject).next()).Uin).equals(paramString));
        for (int i = 1;; i = 0)
        {
          if ((i == 0) || (JoinDiscussionActivity.this.pm.contains(paramString))) {
            break label192;
          }
          JoinDiscussionActivity.this.pm.add(paramString);
          localObject = new StringBuilder();
          JoinDiscussionActivity localJoinDiscussionActivity = JoinDiscussionActivity.this;
          localJoinDiscussionActivity.aNL = (localJoinDiscussionActivity.aNL + paramString + ";");
          if (JoinDiscussionActivity.this.pm.size() != JoinDiscussionActivity.this.bHN) {
            break;
          }
          ThreadManager.post(new JoinDiscussionActivity.FaceObserver.1(this), 8, null, true);
          return;
        }
      }
    }
  }
  
  class b
    extends acdv
  {
    private b() {}
    
    public void W(boolean paramBoolean, String paramString)
    {
      if (paramBoolean)
      {
        JoinDiscussionActivity.this.aNI = paramString;
        JoinDiscussionActivity.this.a.DB(JoinDiscussionActivity.this.aNI);
        return;
      }
      JoinDiscussionActivity.this.bT(0, -161);
    }
    
    public void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo)
    {
      if (paramBoolean)
      {
        JoinDiscussionActivity.this.stopTitleProgress();
        JoinDiscussionActivity.this.aMM = String.valueOf(paramRespGetDiscussInfo.DiscussUin);
        JoinDiscussionActivity.this.aNK = paramRespGetDiscussInfo.Name;
        JoinDiscussionActivity.this.qG = paramRespGetDiscussInfo.Members;
        JoinDiscussionActivity.this.mOwnerUin = paramRespGetDiscussInfo.OwnerUin;
        JoinDiscussionActivity.this.mCreateTime = (paramRespGetDiscussInfo.CreateTime * 1000L);
        HashMap localHashMap = new HashMap();
        if (JoinDiscussionActivity.this.qG != null)
        {
          Object localObject3 = JoinDiscussionActivity.this.qG.iterator();
          Object localObject2;
          if (((Iterator)localObject3).hasNext())
          {
            localObject2 = (DiscussMemberInfo)((Iterator)localObject3).next();
            if (((DiscussMemberInfo)localObject2).Uin == JoinDiscussionActivity.this.mOwnerUin) {
              JoinDiscussionActivity.this.mOwnerName = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
            }
            l = ((DiscussMemberInfo)localObject2).Uin;
            localObject1 = null;
            if (0 == 0)
            {
              localObject1 = new DiscussionMemberInfo();
              ((DiscussionMemberInfo)localObject1).discussionUin = JoinDiscussionActivity.this.aMM;
              ((DiscussionMemberInfo)localObject1).memberUin = String.valueOf(l);
            }
            ((DiscussionMemberInfo)localObject1).flag = ((DiscussMemberInfo)localObject2).Flag;
            if ((((DiscussMemberInfo)localObject2).StInteRemark != null) && (!TextUtils.isEmpty(((DiscussMemberInfo)localObject2).StInteRemark.StrValue)))
            {
              ((DiscussionMemberInfo)localObject1).inteRemark = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
              ((DiscussionMemberInfo)localObject1).inteRemarkSource = ((DiscussMemberInfo)localObject2).StInteRemark.Source;
            }
            for (;;)
            {
              localHashMap.put(((DiscussionMemberInfo)localObject1).memberUin, localObject1);
              break;
              if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark))
              {
                localObject2 = ((acff)JoinDiscussionActivity.this.app.getManager(51)).b(((DiscussionMemberInfo)localObject1).memberUin);
                if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
                {
                  ((DiscussionMemberInfo)localObject1).memberName = ((Friends)localObject2).name;
                  if (TextUtils.isEmpty(((Friends)localObject2).remark)) {}
                  for (localObject2 = ((Friends)localObject2).name;; localObject2 = ((Friends)localObject2).remark)
                  {
                    ((DiscussionMemberInfo)localObject1).inteRemark = ((String)localObject2);
                    ((DiscussionMemberInfo)localObject1).inteRemarkSource = 129L;
                    break;
                  }
                }
                ((DiscussionMemberInfo)localObject1).inteRemarkSource = 0L;
              }
            }
          }
          Object localObject1 = new ArrayList();
          if (JoinDiscussionActivity.this.qG != null)
          {
            l = Long.parseLong(JoinDiscussionActivity.this.app.getCurrentAccountUin());
            paramInt = 0;
            while (paramInt < JoinDiscussionActivity.this.qG.size())
            {
              if (((DiscussMemberInfo)JoinDiscussionActivity.this.qG.get(paramInt)).Uin != l) {
                ((ArrayList)localObject1).add(Long.valueOf(((DiscussMemberInfo)JoinDiscussionActivity.this.qG.get(paramInt)).Uin));
              }
              paramInt += 1;
            }
          }
          JoinDiscussionActivity.this.bHN = Math.min(((ArrayList)localObject1).size(), 4);
          JoinDiscussionActivity.this.pm.clear();
          JoinDiscussionActivity.this.aNL = "";
          paramInt = 0;
          while (paramInt < JoinDiscussionActivity.this.bHN)
          {
            localObject2 = String.valueOf(((ArrayList)localObject1).get(paramInt));
            if (aqdj.a(JoinDiscussionActivity.this.app, 1, (String)localObject2) != null)
            {
              JoinDiscussionActivity.this.pm.add(localObject2);
              localObject2 = new StringBuilder();
              localObject3 = JoinDiscussionActivity.this;
              ((JoinDiscussionActivity)localObject3).aNL = (((JoinDiscussionActivity)localObject3).aNL + String.valueOf(((ArrayList)localObject1).get(paramInt)) + ";");
            }
            paramInt += 1;
          }
        }
        long l = paramRespGetDiscussInfo.DiscussFlag;
        JoinDiscussionActivity.this.aNK = aqgv.a(JoinDiscussionActivity.this.app, JoinDiscussionActivity.this.aMM, String.valueOf(JoinDiscussionActivity.this.mOwnerUin), l | 0x20000000, paramRespGetDiscussInfo.Name, localHashMap);
        if (JoinDiscussionActivity.this.pm.size() == JoinDiscussionActivity.this.bHN) {
          ThreadManager.post(new JoinDiscussionActivity.MyDiscussionObserver.1(this), 8, null, true);
        }
        JoinDiscussionActivity.a(JoinDiscussionActivity.this);
        if (TextUtils.isEmpty(JoinDiscussionActivity.this.mOwnerName)) {
          ((FriendListHandler)JoinDiscussionActivity.this.app.getBusinessHandler(1)).bC(JoinDiscussionActivity.this.mOwnerUin + "", false);
        }
        return;
      }
      JoinDiscussionActivity.this.bT(0, paramInt);
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt)
    {
      String str;
      if (paramBoolean)
      {
        anot.a(JoinDiscussionActivity.this.app, "CliOper", "", JoinDiscussionActivity.this.app.getCurrentAccountUin(), "discuss", "discuss_QR_join", 0, 0, "", "", "", "");
        JoinDiscussionActivity.this.stopTitleProgress();
        str = String.valueOf(paramLong);
        if ((str != null) && (str.length() > 0))
        {
          if (JoinDiscussionActivity.this.qG == null) {
            break label290;
          }
          paramLong = Long.parseLong(JoinDiscussionActivity.this.app.getCurrentAccountUin());
          paramInt = 0;
          if (paramInt >= JoinDiscussionActivity.this.qG.size()) {
            break label290;
          }
          if (((DiscussMemberInfo)JoinDiscussionActivity.this.qG.get(paramInt)).Uin != paramLong) {
            break label270;
          }
        }
      }
      label270:
      label290:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0) {
          QQToast.a(JoinDiscussionActivity.this, acfp.m(2131707520), 0).show(JoinDiscussionActivity.this.getTitleBarHeight());
        }
        Intent localIntent = wja.a(new Intent(JoinDiscussionActivity.this, SplashActivity.class), null);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("uintype", 3000);
        localIntent.putExtra("uinname", JoinDiscussionActivity.this.aNK);
        localIntent.putExtra("isBack2Root", true);
        localIntent.putExtra("isFromDiscussionFlyTicket", true);
        JoinDiscussionActivity.this.startActivity(localIntent);
        JoinDiscussionActivity.this.finish();
        return;
        paramInt += 1;
        break;
        JoinDiscussionActivity.this.bT(1, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */