package com.tencent.av.ui;

import acdt;
import acdu;
import acdv;
import acfp;
import achp;
import anaz;
import anbi;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import anre;
import aqiw;
import aqjl;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import jlq;
import jlr;
import jls;
import mqq.manager.TicketManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class ConferenceFlyTicketActivity
  extends BaseActivity
{
  String Ra = null;
  String Rb = null;
  String Rc = null;
  String Rd = null;
  String Re = null;
  String Rf = null;
  String Rg = null;
  String Rh = null;
  final String TAG = "ConferenceFlyTicketActivity." + AudioHelper.hG();
  boolean Vj = false;
  boolean Vk = false;
  acdt jdField_a_of_type_Acdt;
  a jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$a;
  b jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$b;
  c jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$c;
  d jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$d;
  int avz = -1;
  Handler mHandler = null;
  String mSubject = null;
  
  static boolean cE(String paramString)
  {
    return (paramString.startsWith("https:")) || (paramString.startsWith("http:"));
  }
  
  private void g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = anaz.gQ();
    ArrayList localArrayList = new ArrayList();
    MessageRecord localMessageRecord = anbi.d(-7003);
    if (aqjl.mv(this.avz)) {}
    for (String str = this.app.getApp().getString(2131692894);; str = this.app.getApp().getString(2131692893))
    {
      localMessageRecord.init(paramString2, paramString1, paramString3, str, l, -7003, 3000, l);
      localMessageRecord.isread = true;
      localMessageRecord.saveExtInfoToExtStr("troop_msg_nickname", paramString4);
      boolean bool1 = localMessageRecord instanceof MessageForNewGrayTips;
      if (bool1) {
        ((MessageForNewGrayTips)localMessageRecord).updateMsgData();
      }
      boolean bool2 = achp.a(this.app, localMessageRecord, false);
      if (!bool2) {
        localArrayList.add(localMessageRecord);
      }
      QLog.w(this.TAG, 1, "showHRMeetingTip, friendUin[" + localMessageRecord.frienduin + "], msgType[" + -7003 + "], friendType[" + 3000 + "], bMessageForNewGrayTips[" + bool1 + "], msgFilter[" + bool2 + "], msgContent[" + localMessageRecord.getLogColorContent() + "]");
      if (localArrayList.size() > 0) {
        this.app.b().s(localArrayList, String.valueOf(paramString2));
      }
      return;
    }
  }
  
  @TargetApi(9)
  private boolean wb()
  {
    AudioHelper.rw("上传SelfNickName");
    Object localObject = (TicketManager)this.app.getManager(2);
    if (localObject == null) {
      return false;
    }
    localObject = ((TicketManager)localObject).getSkey(this.app.getAccount());
    if ((localObject == null) || (((String)localObject).isEmpty())) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$d = new d();
    ArrayList localArrayList = new ArrayList();
    jlr localjlr = new jlr();
    String str = this.app.getCurrentAccountUin();
    localjlr.mUrl = ("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/report_nickname_video_meeting_for_hr?discid=" + this.Rf + "&uin=" + str + "&name=" + URLEncoder.encode(this.Rh));
    localjlr.mHeaders = new HashMap();
    localjlr.mHeaders.put("Cookie", "uin=o" + str + ";skey=" + (String)localObject);
    localArrayList.add(localjlr);
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$d.execute(new ArrayList[] { localArrayList });
    return true;
  }
  
  void aqX()
  {
    Intent localIntent = super.getIntent();
    this.Ra = localIntent.getStringExtra("confid");
    this.mSubject = localIntent.getStringExtra("subject");
    this.Rb = localIntent.getStringExtra("ticket");
    this.Rc = localIntent.getStringExtra("ticket_f");
    String str = localIntent.getStringExtra("stask");
    if (str != null) {}
    for (this.avz = Integer.valueOf(str).intValue();; this.avz = 0)
    {
      this.Rd = localIntent.getStringExtra("confidshort");
      this.Re = localIntent.getStringExtra("callphonenum");
      this.Rf = localIntent.getStringExtra("discid");
      this.Rh = localIntent.getStringExtra("user");
      this.Rg = localIntent.getStringExtra("businesstype");
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "processExtraData, mConfid[" + this.Ra + "], mSubject[" + this.mSubject + "], mTicket[" + this.Rb + "], mTicketFull[" + this.Rc + "], mConfIDShort[" + this.Rd + "], mCallbackPhone[" + this.Re + "], mDiscID[" + this.Rf + "], mStasks[" + this.avz + "], mHrMeetingNickName[" + this.Rh + "], mBusinessType[" + this.Rg + "]");
      }
      return;
    }
  }
  
  @TargetApi(9)
  void asd()
  {
    AudioHelper.rw(acfp.m(2131704275));
    if (aqiw.isNetSupport(this))
    {
      if (!TextUtils.isEmpty(this.Rc))
      {
        if (cE(this.Rc))
        {
          jU(this.Rc);
          return;
        }
        jU("https://q.url.cn/s/" + this.Rc);
        return;
      }
      if (!TextUtils.isEmpty(this.Rb))
      {
        if (cE(this.Rb))
        {
          jU(this.Rb);
          return;
        }
        jU("https://url.cn/" + this.Rb);
        return;
      }
      finish();
      bT(0, -162);
      return;
    }
    finish();
    bT(0, -160);
  }
  
  void ase()
  {
    if (this.Vj) {}
    DiscussionInfo localDiscussionInfo;
    do
    {
      do
      {
        return;
        localObject = (acdu)this.app.getManager(53);
        localDiscussionInfo = ((acdu)localObject).a(this.Rf);
      } while (localDiscussionInfo == null);
      if (localDiscussionInfo.mSelfRight != this.avz)
      {
        localDiscussionInfo.mSelfRight = this.avz;
        ((acdu)localObject).d(localDiscussionInfo);
      }
      QLog.w(this.TAG, 1, "gotoAIO, DiscussionInfo_" + localDiscussionInfo);
    } while (localDiscussionInfo.isHidden());
    Object localObject = wja.a(new Intent(BaseApplicationImpl.getApplication(), SplashActivity.class), new int[] { 2 });
    ((Intent)localObject).putExtra("uin", this.Rf);
    ((Intent)localObject).putExtra("uintype", 3000);
    ((Intent)localObject).putExtra("uinname", localDiscussionInfo.discussionName);
    ((Intent)localObject).putExtra("entrance", 8);
    BaseApplicationImpl.getApplication().startActivity((Intent)localObject);
    this.Vj = true;
  }
  
  void bT(int paramInt1, int paramInt2)
  {
    QLog.w(this.TAG, 1, "showFailMessage, type[" + paramInt1 + "], errorCode[" + paramInt2 + "]");
    String str;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 == 1) {
        str = acfp.m(2131704285);
      }
      break;
    }
    for (;;)
    {
      this.mHandler.post(new ConferenceFlyTicketActivity.1(this, str));
      return;
      str = acfp.m(2131704274);
      continue;
      str = acfp.m(2131704276);
      continue;
      str = acfp.m(2131704281);
      continue;
      str = acfp.m(2131704284);
      continue;
      str = acfp.m(2131704283);
      continue;
      str = acfp.m(2131704279);
      continue;
      if (paramInt1 == 0) {
        str = acfp.m(2131704278);
      } else {
        str = "";
      }
    }
  }
  
  void bf(String paramString1, String paramString2)
  {
    if (this.Vk) {
      return;
    }
    boolean bool = AVNotifyCenter.ul();
    QLog.w(this.TAG, 1, "startGAudioOnCreateDiscussion, discID[" + paramString1 + "], discussName[" + paramString2 + "], isBeInvitingOnDoubleVideo[" + bool + "]");
    if (bool)
    {
      QQToast.a(getApplicationContext(), 2131698108, 1).show(getApplicationContext().getResources().getDimensionPixelSize(2131299627));
      return;
    }
    this.Vk = true;
    paramString2 = new Bundle();
    paramString2.putInt("MultiAVType", 1);
    paramString2.putBoolean("disableInvite", true);
    if ((this.Rg.equals("video_hr")) || ((this.avz & 0x4) != 0))
    {
      paramString2.putBoolean("isVideo", true);
      paramString2.putInt("MeetingStasks", this.avz);
      QLog.w(this.TAG, 1, "ShowNameCard, mBusinessType[" + this.Rg + "], mStasks[" + this.avz + "]");
      jT(paramString1);
    }
    AudioHelper.rw(acfp.m(2131704277));
    ChatActivityUtils.a(this.app, this.app.getApp(), 3000, paramString1, true, true, null, paramString2);
  }
  
  public void d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      AbsStructMsg localAbsStructMsg;
      do
      {
        return;
        localAbsStructMsg = anre.a(paramString1.getBytes(), 0);
      } while (localAbsStructMsg == null);
      paramString1 = (MessageForStructing)anbi.d(-2011);
      paramString1.msgtype = -2011;
      paramString1.istroop = 3000;
      paramString1.issend = 0;
      paramString1.isread = true;
      paramString1.selfuin = this.app.getCurrentAccountUin();
      paramString1.senderuin = paramString4;
      paramString1.frienduin = paramString2;
      paramString1.mIsParsed = true;
      paramString1.structingMsg = localAbsStructMsg;
      paramString1.msgData = localAbsStructMsg.getBytes();
      paramString1.saveExtInfoToExtStr("troop_msg_nickname", paramString5);
      paramString2 = new ArrayList();
      if (!achp.a(this.app, paramString1, false)) {
        paramString2.add(paramString1);
      }
    } while (paramString2.size() <= 0);
    this.app.b().s(paramString2, String.valueOf(paramString3));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    AudioHelper.rw("ConferenceFlyTicketActivity.doOnCreate.begin");
    boolean bool = super.doOnCreate(paramBundle);
    aqX();
    this.jdField_a_of_type_Acdt = ((acdt)this.app.getBusinessHandler(6));
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$a = new a();
    addObserver(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$a);
    if (this.Rg.equals("video_hr"))
    {
      if (!wb()) {
        return false;
      }
    }
    else {
      asd();
    }
    this.mHandler = new Handler();
    AudioHelper.rw("ConferenceFlyTicketActivity.doOnCreate.end");
    return bool;
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$a);
    this.mHandler = null;
    super.doOnDestroy();
  }
  
  @TargetApi(9)
  void jT(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$c = new c(paramString);
    paramString = new ArrayList();
    jlr localjlr = new jlr();
    String str1 = this.app.getCurrentAccountUin();
    localjlr.mUrl = ("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/get_namecard_by_discid?discid=" + this.Rf);
    localjlr.mHeaders = new HashMap();
    String str2 = ((TicketManager)this.app.getManager(2)).getSkey(this.app.getAccount());
    if ((str2 == null) || (str2.isEmpty())) {
      return;
    }
    localjlr.mHeaders.put("Cookie", "uin=o" + str1 + ";skey=" + str2);
    paramString.add(localjlr);
    this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$c.execute(new ArrayList[] { paramString });
  }
  
  void jU(String paramString)
  {
    AudioHelper.rw("加入讨论组_delay_获取讨论组签名");
    ThreadManager.post(new ConferenceFlyTicketActivity.2(this, paramString), 5, null, false);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  class a
    extends acdv
  {
    a() {}
    
    public void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
    {
      QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "onGetFlyTicket, isSuccess[" + paramBoolean + "], errorCode[" + paramInt + "], validTime[" + paramLong1 + "], sigUrl[" + paramString1 + "], shortUrl[" + paramString2 + "], discussionUin[" + paramLong2 + "], mDiscID[" + ConferenceFlyTicketActivity.this.Rf + "]");
      if (paramBoolean)
      {
        if (!TextUtils.isEmpty(ConferenceFlyTicketActivity.this.Rf))
        {
          ConferenceFlyTicketActivity.this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$b = new ConferenceFlyTicketActivity.b(ConferenceFlyTicketActivity.this);
          paramString1 = new ArrayList();
          jlr localjlr = new jlr();
          localjlr.mUrl = ("https://pubacc.mobile.qq.com/mqqweb-rtx2qq/mqqweb/createConfCallback?feedkey=" + ConferenceFlyTicketActivity.this.Ra);
          ConferenceFlyTicketActivity.this.Rb = paramString2.substring("https://url.cn/".length(), paramString2.length() - "#flyticket".length());
          QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "onGetFlyTicket, mTicket[" + ConferenceFlyTicketActivity.this.Rb + "]");
          localjlr.mUrl = (localjlr.mUrl + "&ret=0&ticket=" + ConferenceFlyTicketActivity.this.Rb);
          paramString1.add(localjlr);
          ConferenceFlyTicketActivity.this.jdField_a_of_type_ComTencentAvUiConferenceFlyTicketActivity$b.execute(new ArrayList[] { paramString1 });
        }
        return;
      }
      ConferenceFlyTicketActivity.this.jdField_a_of_type_Acdt.hm(paramLong2);
      ConferenceFlyTicketActivity.this.bT(1, paramInt);
    }
    
    public void a(boolean paramBoolean, long paramLong, int paramInt)
    {
      QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "onJoinDiscussionByFlyTicket, isSuccess[" + paramBoolean + "], discussUin[" + paramLong + "], errorCode[" + paramInt + "], mDiscID[" + ConferenceFlyTicketActivity.this.Rf + "]");
      if (paramBoolean)
      {
        ConferenceFlyTicketActivity.this.Rf = String.valueOf(paramLong);
        if (!TextUtils.isEmpty(ConferenceFlyTicketActivity.this.Rf)) {
          ((acdt)ConferenceFlyTicketActivity.this.app.getBusinessHandler(6)).hk(paramLong);
        }
        return;
      }
      ConferenceFlyTicketActivity.this.bT(1, paramInt);
    }
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "DiscussObserver.onUpdate, type[" + paramInt + "], isSuccess[" + paramBoolean + "], mDiscID[" + ConferenceFlyTicketActivity.this.Rf + "]");
      if (paramInt == 1001)
      {
        AudioHelper.rw("获取讨论组资料_rsp");
        if ((paramObject instanceof ArrayList))
        {
          paramObject = (ArrayList)paramObject;
          paramObject = new Object[] { String.valueOf(paramObject.get(0)), paramObject.get(1) };
          str = (String)paramObject[0];
          ((Boolean)paramObject[1]).booleanValue();
          if ((ConferenceFlyTicketActivity.this.Rf.equals(str)) && (paramBoolean))
          {
            ConferenceFlyTicketActivity.this.ase();
            ConferenceFlyTicketActivity.this.bf(ConferenceFlyTicketActivity.this.Rf, ConferenceFlyTicketActivity.this.mSubject);
          }
          ConferenceFlyTicketActivity.this.finish();
        }
      }
      while (1014 != paramInt) {
        for (;;)
        {
          String str;
          return;
          paramObject = (Object[])paramObject;
        }
      }
      AudioHelper.rw("通过签名加入讨论组_rsp");
      paramObject = (Long[])paramObject;
      long l = paramObject[1].longValue();
      paramInt = paramObject[0].intValue();
      QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "NOTIFY_TYPE_JOIN_DISCUSSION_BY_FLYY_TICKET, discussUin[" + l + "], errCode[" + paramInt + "], mDiscID[" + ConferenceFlyTicketActivity.this.Rf + "]");
      if (paramInt == 0)
      {
        if (TextUtils.equals(String.valueOf(l), ConferenceFlyTicketActivity.this.Rf))
        {
          ConferenceFlyTicketActivity.this.ase();
          AudioHelper.rw(acfp.m(2131704280));
          ((acdt)ConferenceFlyTicketActivity.this.app.getBusinessHandler(6)).hk(l);
          return;
        }
        ConferenceFlyTicketActivity.this.finish();
        return;
      }
      ConferenceFlyTicketActivity.this.finish();
      ConferenceFlyTicketActivity.this.bT(1, paramInt);
    }
  }
  
  class b
    extends jlq
  {
    public b()
    {
      SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }
    
    public void a(jlr paramjlr)
    {
      String str3 = "";
      if (paramjlr.a.mIsSucc) {}
      for (;;)
      {
        try
        {
          String str1 = new String(paramjlr.a.mBytes, "UTF-8");
          if (str1 != null)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject(str1);
              i = localJSONObject.getInt("retcode");
              if (QLog.isColorLevel()) {
                QLog.d(ConferenceFlyTicketActivity.this.TAG, 2, "OnAfterCreateDiscussionAsyncTask.onPostDownloadComplete : retcode = " + i);
              }
              str1 = str3;
              if (localJSONObject.has("result"))
              {
                localJSONObject = localJSONObject.getJSONObject("result");
                str1 = str3;
                if (localJSONObject.has("result_code")) {
                  str1 = localJSONObject.getString("result_code");
                }
              }
            }
            catch (JSONException localJSONException)
            {
              Object localObject;
              if (!QLog.isColorLevel()) {
                break label368;
              }
              QLog.i(ConferenceFlyTicketActivity.this.TAG, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
              str2 = "";
              i = -2;
              continue;
              ConferenceFlyTicketActivity.this.a.hm(Long.parseLong(ConferenceFlyTicketActivity.this.Rf));
              ConferenceFlyTicketActivity.this.bT(1, 0);
              return;
            }
            QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "OnAfterCreateDiscussionAsyncTask, IsSucc[" + paramjlr.a.mIsSucc + "], retcode[" + i + "], result_code[" + str1 + "], mDiscID[" + ConferenceFlyTicketActivity.this.Rf + "]");
            if ((i == 0) && (str1.equals("0")))
            {
              ConferenceFlyTicketActivity.this.a.ad(Long.parseLong(ConferenceFlyTicketActivity.this.Rf), ConferenceFlyTicketActivity.this.mSubject);
              ConferenceFlyTicketActivity.this.bf(ConferenceFlyTicketActivity.this.Rf, ConferenceFlyTicketActivity.this.mSubject);
              ConferenceFlyTicketActivity.this.finish();
              return;
            }
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(ConferenceFlyTicketActivity.this.TAG, 2, "onPostDownloadComplete :" + localException.toString());
          }
          localObject = null;
          continue;
        }
        label368:
        String str2 = "";
        int i = 1;
      }
    }
  }
  
  class c
    extends jlq
  {
    String Rf;
    
    public c(String paramString)
    {
      this.Rf = paramString;
      SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }
    
    public void a(jlr paramjlr)
    {
      jlr localjlr = null;
      Object localObject3 = null;
      Object localObject1 = null;
      Object localObject8 = null;
      Object localObject2 = "";
      String str1 = "";
      String str3 = "";
      if (paramjlr.a.mIsSucc) {}
      for (;;)
      {
        Object localObject5;
        Object localObject4;
        try
        {
          paramjlr = new String(paramjlr.a.mBytes, "UTF-8");
          if (paramjlr != null)
          {
            localObject5 = str1;
            localObject4 = localObject2;
            localObject3 = localObject1;
            try
            {
              paramjlr = new JSONObject(paramjlr);
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              i = paramjlr.getInt("retcode");
              String str2 = str3;
              Object localObject7 = str1;
              Object localObject6 = localObject2;
              localObject5 = str1;
              localObject4 = localObject2;
              localObject3 = localObject1;
              if (paramjlr.has("result"))
              {
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = localObject1;
                JSONObject localJSONObject = paramjlr.getJSONObject("result");
                paramjlr = localObject8;
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = localObject1;
                if (localJSONObject.has("result_code"))
                {
                  localObject5 = str1;
                  localObject4 = localObject2;
                  localObject3 = localObject1;
                  paramjlr = localJSONObject.getString("result_code");
                }
                localObject1 = localObject2;
                localObject5 = str1;
                localObject4 = localObject2;
                localObject3 = paramjlr;
                if (localJSONObject.has("disc_name_card"))
                {
                  localObject5 = str1;
                  localObject4 = localObject2;
                  localObject3 = paramjlr;
                  localObject1 = localJSONObject.getString("disc_name_card");
                }
                localObject2 = str1;
                localObject5 = str1;
                localObject4 = localObject1;
                localObject3 = paramjlr;
                if (localJSONObject.has("name_card_sender_uin"))
                {
                  localObject5 = str1;
                  localObject4 = localObject1;
                  localObject3 = paramjlr;
                  localObject2 = localJSONObject.getString("name_card_sender_uin");
                }
                str2 = str3;
                localObject7 = localObject2;
                localObject6 = localObject1;
                localjlr = paramjlr;
                localObject5 = localObject2;
                localObject4 = localObject1;
                localObject3 = paramjlr;
                if (localJSONObject.has("name_card_sender_name"))
                {
                  localObject5 = localObject2;
                  localObject4 = localObject1;
                  localObject3 = paramjlr;
                  str2 = localJSONObject.getString("name_card_sender_name");
                  localjlr = paramjlr;
                  localObject6 = localObject1;
                  localObject7 = localObject2;
                }
              }
              localObject2 = str2;
              localObject1 = localObject7;
              paramjlr = localObject6;
              localObject3 = localjlr;
            }
            catch (JSONException paramjlr)
            {
              localObject1 = localObject5;
              if (!QLog.isColorLevel()) {
                break label602;
              }
              QLog.d(ConferenceFlyTicketActivity.this.TAG, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + paramjlr.toString());
              localObject2 = "";
              i = -2;
              paramjlr = localObject4;
              continue;
            }
            QLog.w(ConferenceFlyTicketActivity.this.TAG, 1, "OnGetDiscNameCardTask.onPostDownloadComplete, result_code[" + (String)localObject3 + "], disc_name_card[" + paramjlr + "], name_card_sender_uin[" + (String)localObject1 + "], name_card_sender_name[" + (String)localObject2 + "], retcode[" + i + "], mDiscID[" + this.Rf + "]");
            ConferenceFlyTicketActivity.a(ConferenceFlyTicketActivity.this, this.Rf, ConferenceFlyTicketActivity.this.app.getCurrentUin(), (String)localObject1, (String)localObject2);
            if ((i == 0) && (TextUtils.equals((CharSequence)localObject3, "0")) && (!TextUtils.isEmpty(paramjlr)) && (!paramjlr.equals("null"))) {
              ConferenceFlyTicketActivity.this.d(paramjlr, this.Rf, ConferenceFlyTicketActivity.this.app.getCurrentUin(), (String)localObject1, (String)localObject2);
            }
            return;
          }
        }
        catch (Exception paramjlr)
        {
          if (QLog.isColorLevel()) {
            QLog.d(ConferenceFlyTicketActivity.this.TAG, 2, "OnGetDiscNameCardTask.onPostDownloadComplete e = " + paramjlr.toString());
          }
          paramjlr = null;
          continue;
        }
        label602:
        localObject2 = "";
        int i = -1;
        localObject1 = "";
        paramjlr = "";
      }
    }
  }
  
  class d
    extends jlq
  {
    public d()
    {
      SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }
    
    public void a(jlr paramjlr)
    {
      AudioHelper.rw("上传SelfNickName_rsp");
      String str = "";
      if (paramjlr.a.mIsSucc) {}
      for (;;)
      {
        try
        {
          paramjlr = new String(paramjlr.a.mBytes, "UTF-8");
          if (paramjlr != null)
          {
            try
            {
              JSONObject localJSONObject = new JSONObject(paramjlr);
              i = localJSONObject.getInt("retcode");
              if (QLog.isColorLevel()) {
                QLog.d(ConferenceFlyTicketActivity.this.TAG, 2, "OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = " + i);
              }
              paramjlr = str;
              if (localJSONObject.has("result"))
              {
                localJSONObject = localJSONObject.getJSONObject("result");
                paramjlr = str;
                if (localJSONObject.has("result_code")) {
                  paramjlr = localJSONObject.getString("result_code");
                }
              }
            }
            catch (JSONException paramjlr)
            {
              if (!QLog.isColorLevel()) {
                break label248;
              }
              QLog.i(ConferenceFlyTicketActivity.this.TAG, 2, "onPostDownloadComplete : result_code = " + "" + ",retcode = " + -2);
              paramjlr = "";
              i = -2;
              continue;
              ConferenceFlyTicketActivity.this.bT(1, 0);
              ConferenceFlyTicketActivity.this.finish();
              return;
            }
            if ((i == 0) && (paramjlr.equals("0")))
            {
              ConferenceFlyTicketActivity.this.asd();
              return;
            }
          }
        }
        catch (Exception paramjlr)
        {
          if (QLog.isColorLevel()) {
            QLog.i(ConferenceFlyTicketActivity.this.TAG, 2, "onPostDownloadComplete :" + paramjlr.toString());
          }
          paramjlr = null;
          continue;
        }
        label248:
        paramjlr = "";
        int i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity
 * JD-Core Version:    0.7.0.1
 */