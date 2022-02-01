package com.tencent.mobileqq.nearby.gameroom;

import acff;
import acfp;
import ahgq;
import ajry;
import ajsf;
import ajsg;
import ajsh;
import ajsi;
import ajsj;
import ajsl;
import ajsm;
import ajsn;
import ajso;
import ajsp;
import ajsq;
import ajsr;
import ajss;
import ajsu;
import ajsv;
import ajsw;
import ajsx;
import ajsy;
import ajsz;
import ajtb;
import ajtc;
import ajtk;
import ajtw;
import ajtw.b;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anqv;
import anrd;
import anre;
import aprb.a;
import aqcx;
import aqdj;
import aqha;
import aqju;
import aqmf;
import ardq;
import arec;
import aree;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.a;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.werewolves.WereWolvesLoadingView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

public class GameRoomInviteActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  public static String bSp;
  public static SparseArray<String> cY = new SparseArray();
  protected ImageView Bj;
  public List<ajtw.b> DB = new ArrayList();
  protected View EK;
  public View EL;
  public String OG;
  protected TextView UY;
  public ajtw a;
  public aree a;
  public b a;
  protected PlayerInvitePanel a;
  public RecentUserInvitePanel a;
  public WereWolvesLoadingView a;
  public long adj = -1L;
  protected aprb.a b;
  ardq b;
  protected arec b;
  public boolean cpZ = true;
  boolean cqa = false;
  public boolean cqb = true;
  public int dkT = 10;
  public int dkU = 0;
  public int dkV = 1000;
  protected Button gO;
  protected Button gP;
  protected Button gQ;
  public boolean hasMore;
  public boolean isLoading = false;
  public LinearLayout jq;
  public ajry mGameRoomAVController;
  protected Handler mHandler = new Handler(Looper.getMainLooper());
  protected ImageView mLogoView;
  public long mOwnerUin;
  public List<a> mUsers = new ArrayList();
  public boolean ni = true;
  public int retryTimes = 0;
  public boolean uY = false;
  
  static
  {
    cY.put(-1, acfp.m(2131706812));
    cY.put(1000, acfp.m(2131706796));
    cY.put(1001, acfp.m(2131706802));
    cY.put(1002, acfp.m(2131706839));
    cY.put(1003, acfp.m(2131706835));
    cY.put(1004, "邀请id不存在");
    cY.put(1005, "接受邀请时uin已经存在");
    cY.put(1006, acfp.m(2131706842));
    cY.put(1007, acfp.m(2131706815));
    cY.put(1008, acfp.m(2131706787));
    cY.put(1009, acfp.m(2131706804));
    cY.put(1010, acfp.m(2131706810));
    cY.put(1011, acfp.m(2131706816));
  }
  
  public GameRoomInviteActivity()
  {
    this.jdField_b_of_type_Arec = new ajsj(this);
    this.jdField_b_of_type_Aprb$a = new ajss(this);
  }
  
  private Intent B()
  {
    Object localObject2 = "mqqapi://qwerewolf/openInvitationRoom?src_type=app&version=1&from=test&invitorId=" + this.OG + "&roomNum=" + this.dkT;
    String str = this.app.getCurrentNickname() + acfp.m(2131706841);
    Object localObject1;
    if (this.dkT == 10) {
      if (this.dkU == 1) {
        localObject1 = acfp.m(2131706792);
      }
    }
    for (;;)
    {
      localObject2 = new AbsShareMsg.a(StructMsgForGeneralShare.class).c(105).a(str).a("plugin", null, (String)localObject2, null, null).a(acfp.m(2131706767), null).f("https://nearby.qq.com/werewolf/game-overview.html?_bid=2652&_nav_bgclr=ffffff&_nav_titleclr=ffffff&_nav_txtclr=ffffff&_nav_anim=true&_nav_alpha=0&_wv=16779011&_wwv=5&from=9").a();
      anqv localanqv = anrd.a(2);
      localanqv.t("https://p.qpic.cn/qqconadmin/0/642c0594c9494bfa85666b448c3bfa68/0", str, (String)localObject1, 0);
      ((AbsShareMsg)localObject2).addItem(localanqv);
      ((AbsShareMsg)localObject2).mCommentText = null;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("forward_type", 41);
      ((Intent)localObject1).putExtra("share_comment_message", "");
      ((Intent)localObject1).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject2).getBytes());
      return localObject1;
      if (this.dkU == 2)
      {
        localObject1 = acfp.m(2131706771);
      }
      else
      {
        localObject1 = "基础10人局轻松碾压，一起开黑一起high！";
        continue;
        if (this.dkT == 12) {
          localObject1 = acfp.m(2131706783);
        } else {
          localObject1 = acfp.m(2131706789);
        }
      }
    }
  }
  
  private void fo(String paramString, int paramInt)
  {
    AbsStructMsg localAbsStructMsg = anre.a(B().getByteArrayExtra("stuctmsg_bytes"));
    if (localAbsStructMsg == null) {
      return;
    }
    aqmf.a(this.app, paramString, paramInt, localAbsStructMsg, null);
    this.jdField_a_of_type_Ajtw.U(paramString, paramInt, this.OG);
  }
  
  public void P(String paramString1, String paramString2, boolean paramBoolean)
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(paramString1);
    localaqju.setMessage(paramString2);
    localaqju.setNegativeButton(2131690700, new ajsp(this, paramBoolean));
    localaqju.setPositiveButton(acfp.m(2131706811), new ajsq(this));
    if (!isFinishing()) {
      localaqju.show();
    }
    this.cqb = false;
  }
  
  public a a()
  {
    if (this.mUsers != null)
    {
      Iterator localIterator = this.mUsers.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.uin.equals(this.app.getCurrentAccountUin())) {
          return locala;
        }
      }
    }
    return null;
  }
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "handle8e4Error errorCode = " + paramInt + " errorMsg = " + paramString);
    }
    Object localObject4;
    if (paramRspBody.string_err_title.has())
    {
      localObject4 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject2 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {}
    }
    for (Object localObject2 = null;; localObject2 = null)
    {
      localObject4 = paramString;
      if (paramRspBody.string_err_msg.has())
      {
        localObject3 = paramRspBody.string_err_msg.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          break label458;
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        localObject4 = paramString;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject4 = localObject1;
          localObject3 = localObject1;
        }
        if (paramInt == 1009)
        {
          paramString = aqha.a(this, 230);
          paramString.setTitle(localObject2);
          paramString.setMessage((CharSequence)localObject3);
          paramString.setPositiveButton(acfp.m(2131706759), new ajsl(this, paramRspBody));
          paramString.setNegativeButton(2131721058, new ajsm(this, paramString));
          if (!isFinishing()) {
            paramString.show();
          }
        }
        label374:
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (paramInt == 1008)
                {
                  this.jdField_b_of_type_Ardq.a(new ajsn(this, localObject2, (String)localObject3));
                  return;
                }
                if ((paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010)) {
                  break;
                }
              } while (isFinishing());
              P(localObject2, (String)localObject3, true);
              return;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                break label374;
              }
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                break;
              }
            } while (paramInt == -1);
            QQToast.a(this, 1, (String)localObject4 + "errorCode = " + paramInt + " errorMsg = " + (String)cY.get(paramInt), 0).show();
            return;
            QQToast.a(this, 1, (CharSequence)localObject4, 0).show();
            return;
            if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007) && (paramInt != 1013)) {
              break;
            }
          } while (isFinishing());
          ajtk.a(this, localObject2, (String)localObject3);
          return;
        } while ((paramInt == -1) || (isFinishing()));
        QQToast.a(this, 1, (CharSequence)localObject4, 0).show();
        return;
        label458:
        localObject1 = localObject3;
      }
    }
  }
  
  /* Error */
  public void a(com.tencent.mobileqq.data.HotChatInfo paramHotChatInfo, int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 136	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:cqa	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: iload_2
    //   19: aload_3
    //   20: aload 4
    //   22: invokestatic 472	ajtk:a	(Landroid/content/Context;Lcom/tencent/mobileqq/data/HotChatInfo;ILjava/lang/String;Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 189	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   29: aload_0
    //   30: getfield 143	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:jdField_b_of_type_Arec	Larec;
    //   33: invokevirtual 476	com/tencent/mobileqq/app/QQAppInterface:removeObserver	(Lacci;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 136	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:cqa	Z
    //   41: aload_0
    //   42: invokevirtual 477	com/tencent/mobileqq/nearby/gameroom/GameRoomInviteActivity:finish	()V
    //   45: goto -32 -> 13
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	GameRoomInviteActivity
    //   0	53	1	paramHotChatInfo	com.tencent.mobileqq.data.HotChatInfo
    //   0	53	2	paramInt	int
    //   0	53	3	paramString1	String
    //   0	53	4	paramString2	String
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	48	finally
    //   16	45	48	finally
  }
  
  public void bhq()
  {
    ahgq.f(this, B(), 111);
  }
  
  public void cgp()
  {
    if (!this.jdField_a_of_type_Aree.isLoaded())
    {
      this.isLoading = true;
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.ehy();
      this.jdField_a_of_type_Aree.cgp();
      report("load_page", "in_cnt");
      return;
    }
    init(true);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131559690);
    this.mGameRoomAVController = ajry.a();
    this.jdField_b_of_type_Ardq = ((ardq)this.app.getBusinessHandler(107));
    this.jdField_a_of_type_Aree = this.jdField_b_of_type_Ardq.a("");
    this.jdField_a_of_type_Ajtw = ((ajtw)this.app.getManager(247));
    this.gO = ((Button)findViewById(2131367878));
    this.gP = ((Button)findViewById(2131367872));
    this.EK = findViewById(2131378700);
    this.gQ = ((Button)findViewById(2131367877));
    this.UY = ((TextView)findViewById(2131367879));
    this.Bj = ((ImageView)findViewById(2131363394));
    this.mLogoView = ((ImageView)findViewById(2131368847));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView = ((WereWolvesLoadingView)findViewById(2131373421));
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.root.setBackgroundDrawable(null);
    this.gO.setOnClickListener(this);
    this.gP.setOnClickListener(this);
    this.gQ.setOnClickListener(this);
    paramBundle = getIntent();
    this.OG = paramBundle.getStringExtra("inviteId");
    this.dkT = paramBundle.getIntExtra("roomNum", 10);
    this.dkU = paramBundle.getIntExtra("zoneId", 0);
    this.adj = paramBundle.getLongExtra("gc", -1L);
    this.cpZ = paramBundle.getBooleanExtra("isInviteTroop", true);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = findViewById(2131377361);
      localObject = (RelativeLayout.LayoutParams)paramBundle.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = aqcx.dip2px(this, 25.0F);
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    findViewById(2131369579).setOnClickListener(new ajsf(this));
    this.EL = findViewById(2131369587);
    this.EL.setOnClickListener(new ajsr(this));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel = ((RecentUserInvitePanel)findViewById(2131369364));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.setOnClickListener(new ajsu(this));
    this.jq = ((LinearLayout)findViewById(2131369363));
    this.jq.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel = ((PlayerInvitePanel)findViewById(2131367880));
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$b = new b(null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setColumnCount(6);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomPlayerInvitePanel.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$b);
    paramBundle = URLDrawable.URLDrawableOptions.obtain();
    Object localObject = new ColorDrawable(Color.parseColor("#323e6f"));
    paramBundle.mFailedDrawable = ((Drawable)localObject);
    paramBundle.mLoadingDrawable = ((Drawable)localObject);
    localObject = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_game_room_bg.jpg", paramBundle);
    this.Bj.setBackgroundDrawable((Drawable)localObject);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    paramBundle.mFailedDrawable = localColorDrawable;
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
    paramBundle = URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/nearby_werewolf_logo.png", (URLDrawable.URLDrawableOptions)localObject);
    this.mLogoView.setImageDrawable(paramBundle);
    this.mLogoView.setVisibility(4);
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131696272, 1).show();
    }
    for (;;)
    {
      this.app.addObserver(this.jdField_b_of_type_Arec);
      return true;
      cgp();
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_b_of_type_Arec);
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    setIntent(paramIntent);
    this.jdField_a_of_type_Ajtw = ((ajtw)this.app.getManager(247));
    if (TextUtils.isEmpty(this.OG))
    {
      setIntent(paramIntent);
      this.OG = paramIntent.getStringExtra("inviteId");
      this.dkT = paramIntent.getIntExtra("roomNum", 10);
      this.dkU = paramIntent.getIntExtra("zoneId", 0);
      this.adj = paramIntent.getLongExtra("gc", -1L);
    }
    if (!TextUtils.isEmpty(this.OG))
    {
      init(true);
      return;
    }
    this.jdField_b_of_type_Ardq.a(new ajsw(this));
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.mGameRoomAVController.cpX = false;
    a locala = a();
    if ((this.mUsers != null) && (locala != null) && (locala.isPrepared)) {
      ajry.a().a(0, this.OG, this.dkT, 0L, null);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.mGameRoomAVController.cpX = true;
    if (this.mGameRoomAVController.GB() == 0) {
      this.mGameRoomAVController.dyZ();
    }
    this.mGameRoomAVController.onActivityResume();
  }
  
  public void dzb()
  {
    if (!NetworkUtils.isNetworkAvailable(this))
    {
      QQToast.a(this, 1, 2131696272, 1).show();
      return;
    }
    ((ardq)this.app.getBusinessHandler(107)).a(this.dkT, this.dkU, new ajsg(this));
    report("start_page", "clk_invite");
  }
  
  public void dzc()
  {
    ardq localardq = (ardq)this.app.getBusinessHandler(107);
    this.EL.setEnabled(false);
    localardq.a(this.OG, false, new ajsh(this));
  }
  
  public void dzd()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {}
    ardq localardq;
    do
    {
      return;
      localardq = (ardq)this.app.getBusinessHandler(107);
    } while (TextUtils.isEmpty(this.OG));
    localardq.a(this.OG, new ajsi(this));
  }
  
  public void dze()
  {
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.postDelayed(this, this.dkV);
    }
  }
  
  void dzf()
  {
    a locala = a();
    if (locala == null) {
      return;
    }
    if (!locala.isPrepared) {
      report("invite_page", "clk_ready");
    }
    ardq localardq = this.jdField_b_of_type_Ardq;
    String str = this.OG;
    if (!locala.isPrepared) {}
    for (boolean bool = true;; bool = false)
    {
      localardq.b(str, bool, new ajso(this, locala));
      return;
    }
  }
  
  public void dzg()
  {
    if (TextUtils.isEmpty(this.OG)) {}
    do
    {
      return;
      if ((this.DB != null) && (this.DB.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.av(this.DB, this.hasMore);
        return;
      }
    } while (this.uY);
    this.uY = true;
    ThreadManager.post(new GameRoomInviteActivity.20(this), 5, null, false);
  }
  
  public void finish()
  {
    a locala = a();
    if ((locala != null) && (!locala.isPrepared)) {
      dzc();
    }
    super.finish();
  }
  
  public void init(boolean paramBoolean)
  {
    this.isLoading = false;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWereWolvesLoadingView.setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomInviteActivity", 2, "init: mInviteId = " + this.OG);
    }
    this.mLogoView.setVisibility(0);
    if (!TextUtils.isEmpty(this.OG))
    {
      dzd();
      return;
    }
    this.jdField_b_of_type_Ardq.a(new ajsv(this, paramBoolean));
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void j(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((this.OG != null) && (this.OG.equals(paramString1))) {}
    do
    {
      return;
      paramString1 = aqha.a(this, 230, paramString2, paramString3, acfp.m(2131706774), acfp.m(2131706800), new ajsx(this, paramBoolean, paramString1), new ajsy(this));
    } while (isFinishing());
    paramString1.show();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i;
    if ((paramInt2 == -1) && (paramInt1 == 111))
    {
      Object localObject1 = new Intent();
      ((Intent)localObject1).putExtras(paramIntent);
      Object localObject2 = anre.a(((Intent)localObject1).getByteArrayExtra("stuctmsg_bytes"));
      if (localObject2 == null) {
        return;
      }
      String str = ((Intent)localObject1).getStringExtra("uin");
      i = ((Intent)localObject1).getIntExtra("uintype", -1);
      aqmf.a(this.app, str, i, (AbsStructMsg)localObject2, null);
      this.jdField_a_of_type_Ajtw.U(str, i, this.OG);
      localObject1 = this.DB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ajtw.b)((Iterator)localObject1).next();
        if ((((ajtw.b)localObject2).uinType == i) && (((ajtw.b)localObject2).uin.equals(str))) {
          if (!((ajtw.b)localObject2).cqf)
          {
            ((ajtw.b)localObject2).cqf = true;
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomRecentUserInvitePanel.a((ajtw.b)localObject2);
          }
        }
      }
      i = paramIntent.getIntExtra("uintype", 0);
      if (i != 0) {
        break label208;
      }
      report("start_page", "share_friend");
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      label208:
      if (i == 1) {
        report("start_page", "share_grp");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.gO) {
      startGame();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.gP) {
        dzb();
      } else if (paramView == this.gQ) {
        if (this.ni) {
          startGame();
        } else {
          dzf();
        }
      }
    }
  }
  
  public void refreshUI()
  {
    if (this.ni)
    {
      if ((this.mUsers != null) && (!this.mUsers.isEmpty()))
      {
        this.UY.setText(acfp.m(2131706765));
        this.UY.setVisibility(0);
        this.gQ.setVisibility(0);
        this.gQ.setText(acfp.m(2131706772));
        this.gQ.setTextColor(-1);
        this.gQ.setBackgroundResource(2130842149);
        this.EK.setVisibility(8);
        this.gP.setVisibility(8);
        this.EL.setVisibility(0);
        this.EL.setEnabled(true);
      }
      for (;;)
      {
        this.gQ.setPadding(0, 0, 0, 0);
        return;
        this.gQ.setVisibility(8);
        this.EK.setVisibility(0);
        this.gP.setVisibility(0);
        this.gO.setVisibility(0);
        this.UY.setVisibility(8);
        this.EL.setVisibility(4);
      }
    }
    a locala = a();
    if (locala != null)
    {
      this.gQ.setVisibility(0);
      this.EK.setVisibility(8);
      this.gP.setVisibility(8);
      this.gO.setVisibility(8);
      this.EL.setVisibility(0);
      this.EL.setEnabled(true);
      this.UY.setVisibility(0);
      if (locala.isPrepared)
      {
        this.gQ.setText(acfp.m(2131706830));
        this.gQ.setBackgroundResource(2130842152);
        this.gQ.setTextColor(-16777216);
        this.UY.setText(acfp.m(2131706784));
      }
    }
    for (;;)
    {
      this.EL.setVisibility(4);
      break;
      this.gQ.setText(acfp.m(2131706838));
      this.gQ.setBackgroundResource(2130842149);
      this.gQ.setTextColor(-1);
      this.UY.setText(acfp.m(2131706785));
      continue;
      this.gQ.setVisibility(0);
      this.EK.setVisibility(8);
      this.gO.setVisibility(8);
      this.EL.setVisibility(8);
      this.UY.setVisibility(8);
    }
  }
  
  public void report(String paramString1, String paramString2)
  {
    anot.a(this.app, "dc00899", "Grp_wolf", "", paramString1, paramString2, 0, 0, "", "", "", "");
  }
  
  public void run()
  {
    dzd();
  }
  
  public void setImmersiveStatus()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if ((this.mActNeedImmersive) && (this.mSystemBarComp == null)) {
        this.mSystemBarComp = new SystemBarCompact(this, true, 0);
      }
    }
  }
  
  protected void startGame()
  {
    if (!NetworkUtils.isNetworkAvailable(this)) {
      QQToast.a(this, 1, 2131696272, 1).show();
    }
    ardq localardq;
    do
    {
      return;
      localardq = (ardq)this.app.getBusinessHandler(107);
    } while (!this.ni);
    if (this.gP.getVisibility() == 0)
    {
      localardq.a(new ajsz(this, localardq));
      report("start_page", "clk_start");
      return;
    }
    localardq.b(this.OG, new ajtb(this));
    report("invite_page", "clk_start");
  }
  
  public class a
  {
    public boolean isPrepared;
    public String uin;
    
    public a() {}
  }
  
  public class b
    extends BaseAdapter
  {
    private b() {}
    
    public int getCount()
    {
      if (GameRoomInviteActivity.this.mUsers == null) {}
      for (int i = 0;; i = GameRoomInviteActivity.this.mUsers.size()) {
        return Math.min(i, GameRoomInviteActivity.this.dkT);
      }
    }
    
    public Object getItem(int paramInt)
    {
      if (GameRoomInviteActivity.this.mUsers != null) {
        return (GameRoomInviteActivity.a)GameRoomInviteActivity.this.mUsers.get(paramInt);
      }
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GameRoomInviteActivity.c localc;
      String str;
      aqdj localaqdj;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(GameRoomInviteActivity.this).inflate(2131559691, paramViewGroup, false);
        localc = new GameRoomInviteActivity.c(GameRoomInviteActivity.this, null);
        localc.Bk = ((ImageView)paramView.findViewById(2131367874));
        localc.NG = ((TextView)paramView.findViewById(2131367875));
        localc.aA = ((ImageButton)paramView.findViewById(2131367873));
        localc.EM = paramView.findViewById(2131368459);
        paramView.setTag(localc);
        ardq localardq = (ardq)GameRoomInviteActivity.this.app.getBusinessHandler(107);
        GameRoomInviteActivity.a locala = (GameRoomInviteActivity.a)GameRoomInviteActivity.this.mUsers.get(paramInt);
        str = locala.uin;
        if ((!((acff)GameRoomInviteActivity.this.app.getManager(51)).isFriend(((GameRoomInviteActivity.a)GameRoomInviteActivity.this.mUsers.get(paramInt)).uin)) && (!GameRoomInviteActivity.this.app.getCurrentAccountUin().equals(str))) {
          break label341;
        }
        localaqdj = aqdj.a(GameRoomInviteActivity.this.app, 1, str);
        label207:
        localc.Bk.setImageDrawable(localaqdj);
        localardq.a(localc.NG, str, "%s");
        if (!locala.isPrepared) {
          break label362;
        }
        localc.EM.setVisibility(0);
        label248:
        if ((!GameRoomInviteActivity.this.ni) || (locala.uin.equals(GameRoomInviteActivity.this.app.getCurrentAccountUin()))) {
          break label374;
        }
        localc.aA.setVisibility(0);
        localc.aA.setOnClickListener(new ajtc(this, paramInt, localardq));
      }
      for (;;)
      {
        localc.type = 1;
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localc = (GameRoomInviteActivity.c)paramView.getTag();
        break;
        label341:
        localaqdj = aqdj.b(GameRoomInviteActivity.this.app, 200, str, 3);
        break label207;
        label362:
        localc.EM.setVisibility(4);
        break label248;
        label374:
        localc.aA.setVisibility(8);
      }
    }
  }
  
  class c
  {
    public ImageView Bk;
    public View EM;
    public TextView NG;
    public ImageButton aA;
    public int type;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity
 * JD-Core Version:    0.7.0.1
 */