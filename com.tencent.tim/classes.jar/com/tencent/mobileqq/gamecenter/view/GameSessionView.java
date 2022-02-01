package com.tencent.mobileqq.gamecenter.view;

import ahta;
import ahtc;
import ahtz;
import ahuf;
import ahug;
import ahvg;
import ahvg.b;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aofk;
import awot;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.view.GameContentView.a;
import com.tencent.mobileqq.profile.PersonalityLabel.CornerImageView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import wja;

public class GameSessionView
  extends RelativeLayout
  implements ahvg.b, Handler.Callback, View.OnClickListener
{
  public static final String TAG = GameSessionView.class.getSimpleName();
  private View DA;
  private View Dz;
  private TextView TQ;
  private a jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$a;
  private GameContentView.a jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a;
  private boolean cik;
  private boolean cil;
  private boolean cim;
  private boolean cin;
  private long iu;
  private List<GameCenterSessionInfo> jl = new ArrayList();
  private AppRuntime mApp;
  private Handler mUiHandler = new Handler(Looper.getMainLooper(), this);
  private int mViewType;
  private ScaleAnimation q = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.75F, 1, 0.0F);
  
  public GameSessionView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public GameSessionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }
  
  public GameSessionView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void a(Context paramContext, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if (this.mApp == null) {
      return;
    }
    if ((this.mApp instanceof QQAppInterface))
    {
      ahtc.a(((ahta)this.mApp.getManager(358)).wD(), paramContext, paramGameCenterSessionInfo);
      return;
    }
    if ((this.mApp instanceof ToolAppRuntime))
    {
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsgUrl", null, new ahug(this, paramContext, paramGameCenterSessionInfo));
      return;
    }
    QLog.w(TAG, 1, "[initData] unknown interface:" + this.mApp.getClass().getSimpleName());
  }
  
  public void a(View paramView, GameCenterSessionInfo paramGameCenterSessionInfo)
  {
    if ((paramView.getTag() instanceof b)) {
      ((b)paramView.getTag()).a(paramGameCenterSessionInfo);
    }
  }
  
  public void a(String paramString, EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramString = paramEIPCResult.data;
      if (paramString != null)
      {
        paramEIPCResult = (List)paramString.getSerializable("key_get_game_msg");
        if (this.cil) {
          break label86;
        }
        this.mViewType = paramString.getInt("key_get_game_view_type", 1);
        if (paramString.getBoolean("key_get_game_gray_user", false)) {
          break label70;
        }
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 0, "[setData] gray is not open. return.");
        }
      }
    }
    return;
    label70:
    this.cik = paramString.getBoolean("key_get_game_show_on_list", false);
    this.cil = true;
    label86:
    QLog.e(TAG, 1, "[onCallback] list:" + paramEIPCResult.size() + ",type:" + this.mViewType);
    setData(paramEIPCResult);
  }
  
  public void a(AppRuntime paramAppRuntime, GameContentView.a parama)
  {
    if (paramAppRuntime == null) {}
    do
    {
      return;
      this.mApp = paramAppRuntime;
      this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a = parama;
      this.cil = false;
      ahvg.a().a("task_get_qgame_session_msg", this);
    } while (this.mApp == null);
    if ((this.mApp instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.1(this));
      return;
    }
    if ((this.mApp instanceof ToolAppRuntime))
    {
      ahvg.a().cn("task_get_qgame_session_msg", true);
      return;
    }
    QLog.i(TAG, 1, "[initData] unknown interface:" + this.mApp.getClass().getSimpleName());
  }
  
  public void bUI()
  {
    if (this.mApp == null) {
      return;
    }
    if ((this.mApp instanceof QQAppInterface))
    {
      ThreadManager.getSubThreadHandler().post(new GameSessionView.2(this));
      return;
    }
    if ((this.mApp instanceof ToolAppRuntime))
    {
      ahvg.a().cn("task_get_qgame_session_msg", true);
      QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "getGameMsg", null, new ahuf(this));
      return;
    }
    QLog.i(TAG, 1, "[initData] unknown interface:" + this.mApp.getClass().getSimpleName());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.cik = false;
      setVisibility(8);
      requestLayout();
    } while (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a == null);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a.dqk();
    return false;
  }
  
  public void i(AppRuntime paramAppRuntime)
  {
    a(paramAppRuntime, null);
  }
  
  public void initView(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext);
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    this.TQ = new TextView(getContext());
    this.TQ.setBackgroundResource(2130840552);
    this.TQ.setText("查看全部游戏消息");
    this.TQ.setTextSize(10.0F);
    this.TQ.setTextColor(Color.parseColor("#80333333"));
    this.TQ.setGravity(17);
    this.TQ.setId(2131371931);
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, wja.dp2px(17.0F, getResources()));
    localLayoutParams1.rightMargin = wja.dp2px(25.0F, getResources());
    localLayoutParams1.leftMargin = wja.dp2px(25.0F, getResources());
    localLayoutParams1.topMargin = wja.dp2px(60.0F, getResources());
    localFrameLayout.addView(this.TQ, localLayoutParams1);
    this.Dz = ((LayoutInflater)localObject).inflate(2131559373, null);
    this.Dz.setTag(new c(this.Dz));
    this.Dz.setId(2131367845);
    this.Dz.setBackgroundDrawable(ahtz.a(getContext()));
    localLayoutParams1 = new FrameLayout.LayoutParams(-1, wja.dp2px(64.0F, getResources()));
    localLayoutParams1.leftMargin = wja.dp2px(15.0F, getResources());
    localLayoutParams1.rightMargin = wja.dp2px(15.0F, getResources());
    localFrameLayout.addView(this.Dz, localLayoutParams1);
    this.Dz.setOnClickListener(this);
    this.TQ.setOnClickListener(this);
    addView(localFrameLayout, localLayoutParams);
    this.DA = ((LayoutInflater)localObject).inflate(2131559374, null);
    this.DA.setId(2131367846);
    this.DA.setOnClickListener(this);
    this.DA.setTag(new d(this.DA));
    localObject = new RelativeLayout.LayoutParams(wja.dp2px(172.0F, getResources()), wja.dp2px(64.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject).rightMargin = wja.dp2px(33.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(4.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    addView(this.DA, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$a = new a(null);
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("action_qgame_messgae_change");
    ((IntentFilter)localObject).addAction("action_qgame_unread_change");
    paramContext.registerReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$a, (IntentFilter)localObject);
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.iu < 2000L) {
      QLog.i(TAG, 1, "[onClick] click too frequently.");
    }
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.iu = l;
        switch (paramView.getId())
        {
        }
      }
    } while ((this.jl == null) || (this.jl.size() <= 0));
    GameCenterSessionInfo localGameCenterSessionInfo = (GameCenterSessionInfo)this.jl.get(0);
    int i = this.jl.size();
    if (this.jl.size() > 2) {
      i = 3;
    }
    for (;;)
    {
      a(getContext(), localGameCenterSessionInfo);
      awot.a().c(localGameCenterSessionInfo.wx(), "1", "145", "920", "92001", "206342", "0", this.mViewType + "", "20", "" + i);
      break;
      a(getContext(), null);
      if ((this.jl == null) || (this.jl.size() <= 0)) {
        break;
      }
      i = this.jl.size();
      if (this.jl.size() > 2) {
        i = 3;
      }
      for (;;)
      {
        awot.a().c("", "1", "145", "920", "92001", "206342", "0", this.mViewType + "", "20", "" + i);
        break;
      }
    }
  }
  
  public void onDestory()
  {
    if (getContext() != null) {
      getContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqGamecenterViewGameSessionView$a);
    }
    this.mUiHandler.removeCallbacksAndMessages(null);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.jl == null) || (this.jl.size() == 0) || ((this.mViewType == 2) && (!this.cik))) {
      setMeasuredDimension(0, 0);
    }
    do
    {
      return;
      super.onMeasure(paramInt1, paramInt2);
    } while (this.cim);
    String str = "";
    if (this.jl.get(0) != null) {
      str = ((GameCenterSessionInfo)this.jl.get(0)).wx();
    }
    awot.a().c(str, "1", "145", "920", "92001", "206341", "0", this.mViewType + "", "8", "");
    this.cim = true;
  }
  
  public void setData(List<GameCenterSessionInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.jl = new ArrayList();
      setVisibility(8);
      requestLayout();
      if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a.dqk();
      }
      return;
    }
    this.jl = paramList;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 0, "[setData] dataList size:" + paramList.size());
    }
    int i;
    if (this.jl.size() > 0)
    {
      i = 0;
      int j = 0;
      while (j < this.jl.size())
      {
        i += ((GameCenterSessionInfo)this.jl.get(j)).Fi();
        j += 1;
      }
    }
    for (;;)
    {
      if (this.mViewType == 1)
      {
        this.Dz.setVisibility(0);
        a(this.Dz, (GameCenterSessionInfo)this.jl.get(0));
        this.TQ.setVisibility(0);
        if (i > 0)
        {
          paramList = "共" + i + "条好友消息";
          this.TQ.setText(paramList);
        }
        for (;;)
        {
          this.DA.setVisibility(8);
          setVisibility(0);
          requestLayout();
          if (this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a.dqk();
          return;
          this.TQ.setText("查看全部游戏消息");
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a != null) && ((this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a instanceof QQGameFeedWebFragment)))
      {
        ((QQGameFeedWebFragment)this.jdField_a_of_type_ComTencentMobileqqGamecenterWebViewGameContentView$a).Ps(i);
        if (!this.cin)
        {
          paramList = "";
          if (this.jl.get(0) != null) {
            paramList = ((GameCenterSessionInfo)this.jl.get(0)).wx();
          }
          awot localawot = awot.a();
          String str = this.mViewType + "";
          StringBuilder localStringBuilder = new StringBuilder().append("");
          if (i <= 0) {
            break label513;
          }
          i = 1;
          label401:
          localawot.c(paramList, "1", "145", "920", "92001", "206829", "0", str, "8", i);
          this.cin = true;
        }
      }
      if (this.cik)
      {
        this.DA.setVisibility(0);
        a(this.DA, (GameCenterSessionInfo)this.jl.get(0));
        this.mUiHandler.sendEmptyMessageDelayed(1, 5000L);
      }
      for (;;)
      {
        this.Dz.setVisibility(8);
        this.TQ.setVisibility(8);
        break;
        label513:
        i = 0;
        break label401;
        this.DA.setVisibility(8);
      }
      i = 0;
    }
  }
  
  class a
    extends BroadcastReceiver
  {
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      String str1 = paramIntent.getAction();
      if (QLog.isColorLevel())
      {
        String str2 = GameSessionView.TAG;
        if ("[onRecevier] action:" + str1 + ",data:" + paramIntent.getExtras() != null)
        {
          paramContext = paramIntent.getExtras().toString();
          QLog.d(str2, 0, paramContext);
        }
      }
      else
      {
        if (str1 != null) {
          break label78;
        }
      }
      label78:
      int i;
      label163:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              paramContext = null;
              break;
              if (!"action_qgame_messgae_change".equals(str1)) {
                break label163;
              }
              paramContext = paramIntent.getExtras();
            } while (paramContext == null);
            paramIntent = (GameCenterSessionInfo)paramContext.getParcelable("key_game_msg");
            i = paramContext.getInt("key_msg_change_type");
            if (QLog.isColorLevel()) {
              QLog.d(GameSessionView.TAG, 0, "[onReceive] type:" + i + ",info:" + paramIntent);
            }
            GameSessionView.this.bUI();
            return;
          } while (!"action_qgame_unread_change".equals(str1));
          paramContext = paramIntent.getExtras();
        } while (paramContext == null);
        i = paramContext.getInt("key_msg_unread_cnt");
      } while (!QLog.isColorLevel());
      QLog.d(GameSessionView.TAG, 0, "[onReceive] cnt:" + i);
    }
  }
  
  static class b
  {
    public void a(GameCenterSessionInfo paramGameCenterSessionInfo) {}
  }
  
  static class c
    extends GameSessionView.b
  {
    TextView EK;
    TextView TR;
    TextView TS;
    TextView TT;
    Context context;
    CornerImageView o;
    
    public c(View paramView)
    {
      this.context = paramView.getContext();
      this.o = ((CornerImageView)paramView.findViewById(2131364625));
      this.o.setRadius(wja.dp2px(18.0F, this.context.getResources()));
      this.TR = ((TextView)paramView.findViewById(2131380821));
      this.EK = ((TextView)paramView.findViewById(2131380971));
      this.TS = ((TextView)paramView.findViewById(2131380803));
      this.TT = ((TextView)paramView.findViewById(2131381010));
    }
    
    public void a(GameCenterSessionInfo paramGameCenterSessionInfo)
    {
      if (paramGameCenterSessionInfo == null) {
        QLog.e(GameSessionView.TAG, 0, "[updateSession] info is null.");
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.context.getResources().getDrawable(2130840068);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.context.getResources().getDrawable(2130840068);
      try
      {
        if (paramGameCenterSessionInfo.getSessionType() == 0) {
          this.o.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.wv(), (URLDrawable.URLDrawableOptions)localObject));
        }
        while (paramGameCenterSessionInfo.getSessionType() == 0)
        {
          this.TR.setText(paramGameCenterSessionInfo.wy() + "好友新消息");
          localObject = "[" + paramGameCenterSessionInfo.getRequestCount() + "位好友请求] " + paramGameCenterSessionInfo.getNickName() + ": " + paramGameCenterSessionInfo.wA();
          this.TS.setText(new aofk((CharSequence)localObject, 3, 16));
          this.TT.setVisibility(4);
          this.EK.setText(ahtc.getTimeString(paramGameCenterSessionInfo.eI() * 1000L));
          return;
          this.o.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.wz(), (URLDrawable.URLDrawableOptions)localObject));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(GameSessionView.TAG, 1, "[updateSession] " + localException);
          continue;
          this.TR.setText(paramGameCenterSessionInfo.getNickName());
          String str = "[" + paramGameCenterSessionInfo.wy() + "] " + paramGameCenterSessionInfo.wA();
          this.TS.setText(new aofk(str, 3, 16, -1));
          if (paramGameCenterSessionInfo.Fi() == 0)
          {
            this.TT.setVisibility(4);
          }
          else
          {
            this.TT.setVisibility(0);
            this.TT.setText(ahtc.eo(paramGameCenterSessionInfo.Fi()));
          }
        }
      }
    }
  }
  
  static class d
    extends GameSessionView.b
  {
    TextView EK;
    TextView TE;
    TextView TS;
    Context context;
    CornerImageView o;
    
    public d(View paramView)
    {
      this.context = paramView.getContext();
      this.o = ((CornerImageView)paramView.findViewById(2131364625));
      this.o.setRadius(wja.dp2px(18.0F, this.context.getResources()));
      this.TE = ((TextView)paramView.findViewById(2131380726));
      this.EK = ((TextView)paramView.findViewById(2131380971));
      this.TS = ((TextView)paramView.findViewById(2131380803));
    }
    
    public void a(GameCenterSessionInfo paramGameCenterSessionInfo)
    {
      if (paramGameCenterSessionInfo == null) {
        QLog.e(GameSessionView.TAG, 0, "[updateSession] info is null.");
      }
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.context.getResources().getDrawable(2130840068);
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.context.getResources().getDrawable(2130840068);
      try
      {
        if (paramGameCenterSessionInfo.getSessionType() == 0) {
          this.o.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.wv(), (URLDrawable.URLDrawableOptions)localObject));
        }
        for (;;)
        {
          this.TE.setTextColor(Color.parseColor("#80333333"));
          this.TE.setText("来自" + paramGameCenterSessionInfo.wy());
          if (paramGameCenterSessionInfo.getSessionType() != 0) {
            break;
          }
          localObject = "[" + paramGameCenterSessionInfo.getRequestCount() + "位好友请求]来自" + paramGameCenterSessionInfo.wy();
          this.TS.setText(new aofk((CharSequence)localObject, 3, 16));
          this.EK.setTextColor(Color.parseColor("#80333333"));
          this.EK.setText(ahtc.getTimeString(paramGameCenterSessionInfo.eI() * 1000L));
          return;
          this.o.setImageDrawable(URLDrawable.getDrawable(paramGameCenterSessionInfo.wz(), (URLDrawable.URLDrawableOptions)localObject));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e(GameSessionView.TAG, 1, "[updateSession] " + localException);
          continue;
          String str = paramGameCenterSessionInfo.wA();
          this.TS.setText(new aofk(str, 3, 16, -1));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameSessionView
 * JD-Core Version:    0.7.0.1
 */