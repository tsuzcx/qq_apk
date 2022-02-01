package com.tencent.mobileqq.apollo.activity;

import aajb;
import aajg;
import abhh;
import abht;
import abht.b;
import abjd;
import abje;
import abjf;
import abjg;
import abjh;
import abxi;
import abxk;
import acfd;
import acfp;
import acfs;
import acfx;
import acgf;
import achq;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anpg;
import aojs;
import aojv;
import aokp;
import aooi;
import aook;
import apnu;
import aqft;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;
import tog;
import wja;

public class HotChatCenterFragment
  extends IphoneTitleBarFragment
  implements aajb, abht.b, Handler.Callback, DragFrameLayout.c, Observer
{
  private acfd jdField_a_of_type_Acfd = new abjd(this);
  private acgf jdField_a_of_type_Acgf = new abjf(this);
  private QQAppInterface app;
  private achq b = new abjg(this);
  private boolean bDq;
  private DragFrameLayout c;
  private aajg e;
  private WeakReference<acfs> fs;
  protected aook h = new abje(this);
  public HashMap<String, String> ij;
  private List<RecentBaseData> mDataList;
  private Handler mHandler;
  private XListView mListView;
  
  public static AioPushData a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = (abxk)paramQQAppInterface.getManager(155);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.a(paramString, paramInt);
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, AioPushData paramAioPushData, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (paramAioPushData == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("HotchatActivity", 1, "[enterPage] para is null");
    }
    do
    {
      return;
      ThreadManager.post(new HotChatCenterFragment.9(paramAioPushData, paramQQAppInterface), 8, null, true);
      paramQQAppInterface = paramAioPushData.url;
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break;
      }
      paramAioPushData = new Intent(paramContext, QQBrowserActivity.class);
      paramAioPushData.putExtra("url", paramQQAppInterface);
      paramContext.startActivity(paramAioPushData);
    } while (!QLog.isColorLevel());
    QLog.d("HotchatActivity", 2, String.format("[enterPage] url:%s", new Object[] { paramQQAppInterface }));
    return;
    QLog.e("HotchatActivity", 1, "[enterPage] url is empty");
  }
  
  public static void a(AioPushData paramAioPushData, QQAppInterface paramQQAppInterface)
  {
    if ((paramQQAppInterface != null) && (paramAioPushData != null))
    {
      paramQQAppInterface = (abxk)paramQQAppInterface.getManager(155);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface.b(paramAioPushData);
        return;
      }
      QLog.e("HotchatActivity", 1, "[removePushItem] dao manager is null");
      return;
    }
    QLog.e("HotchatActivity", 1, "[removePushItem] app or item null");
  }
  
  private void bWt()
  {
    if (this.app != null)
    {
      this.h.addFilter(new Class[] { aojs.class, aojv.class, GroupPttDownloadProcessor.class, C2CPttDownloadProcessor.class, aokp.class });
      this.app.a().a(this.h);
    }
  }
  
  private List<RecentBaseData> be()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = ((acfs)this.fs.get()).dW();
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      return localArrayList1;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = new RecentHotchatItem((HotChatItemData)localObject2);
        ((RecentHotchatItem)localObject2).c(this.app, BaseApplication.getContext());
        if (((RecentHotchatItem)localObject2).getGameId() > 0)
        {
          localArrayList1.add(localObject2);
          localArrayList1.add(RecentHotchatItem.a());
        }
        else
        {
          localArrayList2.add(localObject2);
        }
      }
    }
    if ((localArrayList2.size() == 0) && (localArrayList1.size() > 0)) {
      localArrayList1.remove(localArrayList1.size() - 1);
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  private void build()
  {
    this.mListView = ((XListView)this.mContentView.findViewById(2131368641));
    this.e = new a(getActivity(), this.app, this.mListView, this, 10);
    this.mListView.setAdapter(this.e);
    this.e.setDragHost(this.c);
  }
  
  private void cCs()
  {
    if (isAdded())
    {
      getActivity().addObserver(this.jdField_a_of_type_Acfd);
      getActivity().addObserver(this.b);
      getActivity().addObserver(this.jdField_a_of_type_Acgf);
    }
    if (this.app != null)
    {
      this.app.b().addObserver(this);
      bWt();
    }
    if (this.e != null) {
      this.e.onAccountChanged(this.app);
    }
  }
  
  private void cCt()
  {
    if ((this.app != null) && (this.e != null))
    {
      Object localObject = this.e.getItem(0);
      if ((localObject instanceof RecentBaseData))
      {
        localObject = (RecentBaseData)localObject;
        localObject = this.app.b().a(((RecentBaseData)localObject).qx(), ((RecentBaseData)localObject).ng());
        if (localObject != null)
        {
          ((acfs)this.app.getManager(255)).eh(((QQMessageFacade.Message)localObject).time);
          localObject = this.app.getHandler(Conversation.class);
          if (localObject != null) {
            ((MqqHandler)localObject).sendEmptyMessage(1009);
          }
        }
      }
    }
  }
  
  private void updateData()
  {
    this.mDataList = be();
  }
  
  public void C(String paramString1, String paramString2, int paramInt)
  {
    if (this.app == null) {
      QLog.e("HotchatActivity", 1, "[addActivity] app is null");
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(paramString1))
        {
          QLog.e("HotchatActivity", 1, "[addActivity] uin is null");
          return;
        }
        paramString2 = a(this.app, paramString2, paramInt);
      } while (paramString2 == null);
      long l = this.app.a().e(paramString1, 1);
      ((apnu)this.app.getManager(363)).a(paramString1, 24, l, l, paramString2.wording, 0, null);
    } while (!QLog.isColorLevel());
    QLog.d("HotchatActivity", 2, paramString2.toString());
  }
  
  public boolean Ys()
  {
    return (this.c != null) && (this.c.getMode() == -1);
  }
  
  protected void a(int paramInt, RecentBaseData paramRecentBaseData, boolean paramBoolean)
  {
    if ((this.fs != null) && (this.fs.get() != null) && (paramRecentBaseData != null))
    {
      if (paramBoolean)
      {
        ((acfs)this.fs.get()).DS(paramRecentBaseData.qx());
        if ((paramRecentBaseData instanceof RecentHotchatItem))
        {
          paramInt = ((RecentHotchatItem)paramRecentBaseData).getGameId();
          if (paramInt > 0) {
            VipUtils.a(this.app, "cmshow", "Apollo", "top_game_reliao", 0, 0, new String[] { String.valueOf(paramInt) });
          }
        }
        if ((paramRecentBaseData instanceof RecentHotchatItem)) {
          ((RecentHotchatItem)paramRecentBaseData).a();
        }
      }
      for (;;)
      {
        if (this.mHandler != null) {
          this.mHandler.sendEmptyMessage(1);
        }
        return;
        ((acfs)this.fs.get()).DT(paramRecentBaseData.qx());
      }
    }
    QLog.e("HotchatActivity", 1, String.format("[doShowUpMsg] up %s", new Object[] { Boolean.valueOf(paramBoolean) }));
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, String paramString, boolean paramBoolean)
  {
    if ((paramView == null) || (paramRecentBaseData == null) || (!(paramRecentBaseData instanceof RecentHotchatItem)) || (this.app == null)) {
      QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] data is null");
    }
    label77:
    Object localObject1;
    int i;
    do
    {
      return;
      paramString = (RecentHotchatItem)paramRecentBaseData;
      switch (paramView.getId())
      {
      default: 
        QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick]");
        localObject1 = paramRecentBaseData.qx();
        i = paramRecentBaseData.ng();
      }
    } while ((localObject1 == null) || (i != 1));
    Object localObject2 = (HotChatManager)this.app.getManager(60);
    paramView = ((HotChatManager)localObject2).a(paramRecentBaseData.qx());
    AioPushData localAioPushData;
    if (paramString.getGameId() > 0)
    {
      i = this.app.a().A((String)localObject1, 1);
      localAioPushData = ((abxk)this.app.getManager(155)).a(paramString.ra(), paramString.getGameId());
      if (i <= 0)
      {
        i = 0;
        label180:
        VipUtils.a(this.app, "cmshow", "Apollo", "clk_game_reliao", i, 0, new String[] { String.valueOf(paramString.getGameId()) });
      }
    }
    else
    {
      if (paramView != null) {
        break label974;
      }
      paramView = ((HotChatManager)localObject2).a(paramString.getGameId());
      if ((paramView == null) || (paramView.state != 0)) {
        break label968;
      }
      i = 1;
    }
    for (;;)
    {
      if ((paramString.getGameId() > 0) && (this.fs != null) && (this.fs.get() != null) && (paramString.Yt()) && (!paramString.isRead()))
      {
        ((acfs)this.fs.get()).dy(paramString.qx(), 2);
        ((acfs)this.fs.get()).DT(paramString.qx());
      }
      if ((paramView != null) && (paramView.state == 0))
      {
        if (i != 0)
        {
          if ((this.fs == null) || (this.fs.get() == null)) {
            break;
          }
          ((acfs)this.fs.get()).kg((String)localObject1);
          return;
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click relativeItem");
          break label77;
          QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] click apollo_hotchat_item_activity_layout");
          paramView = ApolloGameUtil.a(paramString.getGameId(), this.app);
          paramRecentBaseData = ((abxk)this.app.getManager(155)).a(paramString.getGameId());
          if (paramRecentBaseData == null) {
            break;
          }
          int j;
          label488:
          int m;
          int k;
          if (paramView != null)
          {
            if (!isAdded()) {
              break label727;
            }
            if (paramView.mSpRegion == 0)
            {
              paramString = new Intent(getActivity(), QQBrowserActivity.class);
              paramString.putExtra("url", paramView.mUrl);
              getActivity().startActivity(paramString);
              i = 0;
              paramString = this.app;
              if (paramView != null) {
                break label733;
              }
              j = 0;
              m = paramRecentBaseData.gameId;
              if (paramView != null) {
                break label742;
              }
              k = 0;
              label501:
              if (paramView != null) {
                break label748;
              }
            }
          }
          label727:
          label733:
          label742:
          label748:
          for (paramView = "";; paramView = paramView.mActId)
          {
            VipUtils.a(paramString, "cmshow", "Apollo", "clk_reliao_game_activity", j, i, new String[] { String.valueOf(m), String.valueOf(k), paramView });
            return;
            d(paramString.getGameId(), paramRecentBaseData.openKey, "", paramView.mSpRegion, paramView.mActId);
            i = 1;
            break;
            localObject2 = ((abhh)this.app.getManager(153)).db(paramRecentBaseData.gameId);
            localObject1 = new StringBuilder(100);
            ((StringBuilder)localObject1).append(abxi.bjk).append("&aio_type=").append(ApolloUtil.gi(paramString.ng())).append("&aio_id=").append(paramString.qx()).append("&game_id=").append(paramRecentBaseData.gameId).append("&game_version=").append((String)localObject2);
            paramString = new Intent(getActivity(), QQBrowserActivity.class);
            paramString.putExtra("big_brother_source_key", "biz_src_zf_lmx");
            VasWebviewUtil.openQQBrowserActivity(getActivity(), ((StringBuilder)localObject1).toString(), -1L, paramString, false, -1);
            QLog.e("HotchatActivity", 1, "[onRecentBaseDataClick] no activity ");
            i = 0;
            break;
            j = paramView.mDotId;
            break label488;
            k = 1;
            break label501;
          }
          if (localAioPushData != null)
          {
            i = 1;
            break label180;
          }
          i = 2;
          break label180;
        }
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 2;
        ((Message)localObject1).obj = new Object[] { paramRecentBaseData.qx(), paramView.troopCode, paramView.name, Integer.valueOf(paramString.getGameId()) };
        if (this.mHandler == null) {
          break;
        }
        this.mHandler.sendMessage((Message)localObject1);
        return;
      }
      paramView = paramString.ra();
      i = paramString.getGameId();
      if (this.app != null)
      {
        this.app.removeObserver(this.jdField_a_of_type_Acgf);
        this.app.addObserver(this.jdField_a_of_type_Acgf);
      }
      if (this.ij == null) {
        this.ij = new HashMap();
      }
      if (!this.ij.containsKey(localObject1)) {
        this.ij.put(localObject1, paramView);
      }
      ThreadManager.postImmediately(new HotChatCenterFragment.7(this, paramView, i), null, true);
      QLog.e("HotchatActivity", 1, String.format("[onRecentBaseDataClick] info is null and re join code:%s id:%s", new Object[] { paramView, Integer.valueOf(i) }));
      return;
      label968:
      i = 0;
      continue;
      label974:
      i = 0;
    }
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if (paramRecentBaseData != null)
    {
      String str = paramRecentBaseData.qx();
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[ onRecentBaseDataDelete] delete " + str);
      }
      if ((paramRecentBaseData instanceof RecentHotchatItem))
      {
        int i = ((RecentHotchatItem)paramRecentBaseData).getGameId();
        if (i > 0) {
          VipUtils.a(this.app, "cmshow", "Apollo", "delete_reliao_enter", 0, 0, new String[] { String.valueOf(i) });
        }
      }
      b(str, paramRecentBaseData, paramString);
      return;
    }
    QLog.e("HotchatActivity", 1, "[onRecentBaseDataDelete] delete when uin is null");
  }
  
  public void a(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    paramString2 = getResources();
    int i = paramRecentBaseData.ng();
    if (i == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onMenuItemClick]");
      }
      if (aqft.equalsWithNullCheck(paramString1, paramString2.getString(aakb.fy[2]))) {
        a(i, paramRecentBaseData, false);
      }
    }
    while ((paramRecentBaseData.ng() != 1) || (!aqft.equalsWithNullCheck(paramString2.getString(aakb.fy[1]), paramString1)))
    {
      do
      {
        return;
      } while (!aqft.equalsWithNullCheck(paramString1, paramString2.getString(aakb.fy[3])));
      a(i, paramRecentBaseData, true);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((Ys()) && (this.mHandler != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotchatActivity", 2, "[onChange] end of drag");
      }
      this.mHandler.sendEmptyMessage(1);
    }
  }
  
  public void aQ()
  {
    if ((this.leftView == null) || (this.mLeftBackText == null) || (this.mLeftBackText == null)) {
      return;
    }
    Object localObject = this.app.b();
    if (localObject != null) {}
    for (int i = ((QQMessageFacade)localObject).bl();; i = 0)
    {
      if (this.bDq)
      {
        this.leftView.setVisibility(8);
        this.mLeftBackIcon.setVisibility(0);
        this.mLeftBackIcon.setContentDescription(acfp.m(2131707203));
        this.mLeftBackText.setVisibility(0);
      }
      for (localObject = this.mLeftBackText; localObject != null; localObject = this.leftView)
      {
        ThreadManager.post(new HotChatCenterFragment.5(this, i, (TextView)localObject), 8, null, true);
        return;
        this.leftView.setVisibility(0);
        this.mLeftBackIcon.setVisibility(8);
        this.mLeftBackText.setVisibility(8);
      }
      break;
    }
  }
  
  public void b(String paramString1, RecentBaseData paramRecentBaseData, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (this.app != null))
    {
      Object localObject = this.app;
      localObject = ((HotChatManager)this.app.getManager(60)).a(paramString1);
      if (localObject == null) {
        break label63;
      }
      acfx.a((HotChatInfo)localObject, new abjh(this, (HotChatInfo)localObject, paramString1, paramRecentBaseData, paramString2));
    }
    label63:
    do
    {
      return;
      ((a)this.e).d(paramRecentBaseData, paramString2);
      QLog.e("HotchatActivity", 1, "[exitHotChat] uin null");
    } while (this.fs.get() == null);
    if (QLog.isColorLevel()) {
      QLog.d("HotchatActivity", 2, "remove");
    }
    ((acfs)this.fs.get()).kg(paramString1);
  }
  
  public void d(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3)
  {
    if (this.app == null) {
      return;
    }
    paramString2 = new CmGameStartChecker.StartCheckParam(paramInt1, true, "message", 0L, 6, 1, 0, 0, paramString2, 202, null);
    paramString2.extendJson = String.format("{\"actId\":\"%s\"}", new Object[] { paramString3 });
    paramString2.mFriendUin = paramString1;
    ApolloGameUtil.a(getActivity(), paramString2);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (isAdded())
    {
      paramLayoutInflater = getActivity().getWindow();
      if (paramLayoutInflater != null)
      {
        if (Build.VERSION.SDK_INT >= 11) {
          paramLayoutInflater.setFlags(16777216, 16777216);
        }
        paramLayoutInflater.setBackgroundDrawable(null);
      }
    }
    if (this.app != null)
    {
      this.fs = new WeakReference((acfs)this.app.getManager(255));
      if (isAdded())
      {
        if (this.c == null)
        {
          this.c = DragFrameLayout.b(getActivity());
          this.c.a(this, false);
        }
        this.bDq = ThemeUtil.isDefaultOrDIYTheme(false);
        this.mHandler = new Handler(getActivity().getMainLooper(), this);
        paramLayoutInflater = (abht)this.app.getManager(227);
        if (paramLayoutInflater != null) {
          paramLayoutInflater.a(this);
        }
      }
      setTitle(acfp.m(2131707197));
      build();
      update();
      cCs();
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131559429;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      QLog.e("HotchatActivity", 1, "[handleMessage] not found command");
    case 1: 
    case 2: 
      String str;
      do
      {
        return true;
        update();
        return true;
        if ((paramMessage.obj == null) || (!(paramMessage.obj instanceof Object[]))) {
          break label337;
        }
        paramMessage = (Object[])paramMessage.obj;
        if ((paramMessage.length < 4) || (!(paramMessage[0] instanceof String)) || (!(paramMessage[1] instanceof String)) || (!(paramMessage[2] instanceof String)) || (!(paramMessage[3] instanceof Integer))) {
          break;
        }
        Object localObject = new Intent(getActivity(), SplashActivity.class);
        str = (String)paramMessage[0];
        localObject = wja.a((Intent)localObject, null);
        ((Intent)localObject).putExtra("uin", str);
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("troop_uin", (String)paramMessage[1]);
        ((Intent)localObject).putExtra("uinname", (String)paramMessage[2]);
        if ((paramMessage.length >= 5) && ((paramMessage[4] instanceof Boolean))) {
          ((Intent)localObject).putExtra("startApolloGame", (Boolean)paramMessage[4]);
        }
        C(str, (String)paramMessage[2], ((Integer)paramMessage[3]).intValue());
        startActivity((Intent)localObject);
        localObject = getActivity();
        if ((localObject != null) && (isAdded())) {
          ((FragmentActivity)localObject).overridePendingTransition(2130772029, 2130772030);
        }
      } while (!QLog.isColorLevel());
      QLog.d("HotchatActivity", 2, String.format("[handleMessage] uin:%s uin_type:%s troop_uin:%s uin_name:%s", new Object[] { str, Integer.valueOf(1), (String)paramMessage[1], (String)paramMessage[2] }));
      return true;
      QLog.e("HotchatActivity", 1, "[handleMessage] msg para invalid");
      return true;
      label337:
      QLog.e("HotchatActivity", 1, "[handleMessage] msg obj invalid");
      return true;
    }
    if ((paramMessage.obj instanceof String))
    {
      paramMessage = (String)paramMessage.obj;
      QQToast.a(BaseApplication.getContext(), paramMessage, 0).show();
      return true;
    }
    QLog.e("HotchatActivity", 1, "[handleMessage] toast without wording");
    return true;
  }
  
  public boolean onBackEvent()
  {
    anpg.bX(getActivity(), this.app.getCurrentAccountUin());
    return super.onBackEvent();
  }
  
  public void onClick(View paramView, Object paramObject) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (isAdded()) {
      this.app = getActivity().app;
    }
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.app == null) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      abht localabht;
      do
      {
        for (;;)
        {
          QLog.e("HotchatActivity", 1, localThrowable, new Object[0]);
        }
        if (isAdded())
        {
          getActivity().removeObserver(this.b);
          getActivity().removeObserver(this.jdField_a_of_type_Acfd);
          getActivity().removeObserver(this.jdField_a_of_type_Acgf);
          this.app.a().b(this.h);
        }
        if (this.app.b() != null) {
          this.app.b().deleteObserver(this);
        }
        if (this.c != null) {
          this.c.a(this);
        }
        if (this.c != null) {
          this.c.a(this);
        }
        if (this.e != null)
        {
          this.mListView.setAdapter(null);
          this.e.onDestory();
          this.e = null;
        }
        if (this.mHandler != null)
        {
          this.mHandler.removeMessages(0);
          this.mHandler.removeCallbacks(null);
          this.mHandler = null;
        }
        localabht = (abht)this.app.getManager(227);
      } while (localabht == null);
      localabht.a(null);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    cCt();
  }
  
  public void onResume()
  {
    super.onResume();
    update();
  }
  
  public void update()
  {
    ThreadManager.post(new HotChatCenterFragment.6(this), 8, null, true);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (isAdded())) {
        getActivity().runOnUiThread(new HotChatCenterFragment.10(this));
      }
      if ((paramObservable.isSendFromLocal()) && (paramObservable.msgtype == -2002)) {
        return;
      }
    }
    update();
  }
  
  public void w(int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotchatActivity", 2, "[onReceivePush] from manager");
    }
    if ((paramObject != null) && ((paramObject instanceof AioPushData)))
    {
      paramInt = ((AioPushData)paramObject).busId;
      String str = ((AioPushData)paramObject).them;
      if ((this.fs != null) && (this.fs.get() != null))
      {
        Object localObject1 = ((acfs)this.fs.get()).dW();
        if (localObject1 != null)
        {
          boolean bool2 = false;
          boolean bool1 = bool2;
          Object localObject2;
          if (this.app != null)
          {
            localObject2 = (abxk)this.app.getManager(155);
            bool1 = bool2;
            if (localObject2 != null) {
              bool1 = ((abxk)localObject2).a((AioPushData)paramObject);
            }
          }
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (HotChatItemData)((Iterator)localObject1).next();
            if ((localObject2 != null) && (((HotChatItemData)localObject2).mHotChatCode != null) && (((HotChatItemData)localObject2).mHotChatCode.equals(str)) && (paramInt == ((HotChatItemData)localObject2).mGameId))
            {
              if (!bool1)
              {
                ((acfs)this.fs.get()).eL(((HotChatItemData)localObject2).mHotChatCode, ((AioPushData)paramObject).wording);
                ((acfs)this.fs.get()).DS(((HotChatItemData)localObject2).mTroopUin);
                ((acfs)this.fs.get()).dy(((HotChatItemData)localObject2).mTroopUin, 1);
              }
              if (QLog.isColorLevel()) {
                QLog.d("HotchatActivity", 2, "[onReceivePush] read");
              }
              update();
            }
          }
        }
      }
    }
  }
  
  public class a
    extends aajg
  {
    public a(Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, aajb paramaajb, int paramInt)
    {
      super(paramQQAppInterface, paramXListView, paramaajb, paramInt);
    }
    
    public void b(RecentBaseData paramRecentBaseData, String paramString)
    {
      HotChatCenterFragment.this.a(paramRecentBaseData, paramString);
    }
    
    public void d(RecentBaseData paramRecentBaseData, String paramString)
    {
      if (this.mDataList != null)
      {
        this.mDataList.remove(paramRecentBaseData);
        notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.activity.HotChatCenterFragment
 * JD-Core Version:    0.7.0.1
 */