import android.app.Activity;
import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class abqc
  implements Handler.Callback, View.OnClickListener
{
  private static int cqF = 600000;
  private abqb a;
  private boolean bEC;
  private String bhp;
  private auru e = new auru(Looper.getMainLooper(), this);
  public WeakReference<abpr> fI;
  private CmGameStartChecker.StartCheckParam g;
  WeakReference<Context> mContextRef;
  private int mGameId = -1;
  
  public abqc(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.mContextRef = new WeakReference(paramActivity);
    this.g = paramStartCheckParam;
    if (this.g.game == null)
    {
      this.g.game = new ApolloGameData();
      this.g.game.name = this.g.gameName;
    }
    this.a = new abqb((Context)this.mContextRef.get(), this);
    if (this.g != null) {
      this.mGameId = this.g.gameId;
    }
    if (abxh.ctr > 0)
    {
      cqF = abxh.ctr * 1000;
      if (cqF < 30000) {
        cqF = 30000;
      }
      if (cqF > 1800000) {
        cqF = 1800000;
      }
    }
    QLog.i("cmgame_process.CmGameUIManager", 1, "sMinimizeGameTimeOut :" + cqF);
  }
  
  private BaseChatPie c()
  {
    ChatFragment localChatFragment = null;
    Object localObject2 = abmt.getAppInterface();
    Object localObject1 = localChatFragment;
    if (localObject2 != null)
    {
      localObject1 = localChatFragment;
      if ((localObject2 instanceof QQAppInterface))
      {
        localObject2 = (abhh)((AppInterface)localObject2).getManager(153);
        localObject1 = localChatFragment;
        if (localObject2 != null)
        {
          localObject2 = ((abhh)localObject2).g();
          localObject1 = localChatFragment;
          if (localObject2 != null) {
            localObject1 = (BaseChatPie)((WeakReference)localObject2).get();
          }
        }
      }
    }
    if ((localObject1 == null) && (this.mContextRef != null) && (this.mContextRef.get() != null) && ((this.mContextRef.get() instanceof FragmentActivity)))
    {
      localChatFragment = (ChatFragment)((FragmentActivity)this.mContextRef.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localChatFragment != null) {
        return localChatFragment.a();
      }
    }
    return localObject1;
  }
  
  private void cEf()
  {
    BaseChatPie localBaseChatPie = c();
    if ((localBaseChatPie != null) && (this.a != null) && (localBaseChatPie.a().a() == this.a) && (this.a.el.isShown()))
    {
      this.a.cEc();
      this.e.removeMessages(20);
      this.e.sendEmptyMessageDelayed(20, 1000L);
    }
  }
  
  public void DY(boolean paramBoolean)
  {
    this.bEC = paramBoolean;
  }
  
  public void a(abpr paramabpr)
  {
    this.fI = new WeakReference(paramabpr);
  }
  
  public void bM(Activity paramActivity)
  {
    this.a = new abqb(paramActivity, this);
  }
  
  public void cDO()
  {
    if (this.mGameId == 3112) {
      return;
    }
    if ((this.mContextRef != null) && (this.mContextRef.get() != null)) {
      try
      {
        if (((Activity)this.mContextRef.get()).isFinishing())
        {
          QLog.e("cmgame_process.CmGameUIManager", 1, "showAIOTips error act is finishing");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameUIManager", 1, "showAIOTips error e=" + localThrowable.toString());
      }
    }
    if (this.a != null)
    {
      if (TextUtils.isEmpty(this.bhp)) {
        break label249;
      }
      this.a.PR.setText(this.bhp);
      this.a.jj.setVisibility(0);
      this.a.jk.setVisibility(8);
    }
    label249:
    while (this.g == null)
    {
      localObject1 = c();
      if ((localObject1 == null) || ((((BaseChatPie)localObject1).sessionInfo != null) && (((BaseChatPie)localObject1).sessionInfo.cZ == 1036))) {
        break;
      }
      localObject1 = ((BaseChatPie)localObject1).a();
      if (localObject1 == null) {
        break;
      }
      if (this.a != null)
      {
        if ((this.a.el.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.a.el.getParent()).removeView(this.a.el);
        }
        ((yjh)localObject1).a(this.a, new Object[0]);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameUIManager", 2, "showAIOTips ");
      return;
    }
    if (this.g.game == null) {}
    for (Object localObject1 = null;; localObject1 = this.g.game.name)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131704150);
      }
      localObject1 = acfp.m(2131704152) + (String)localObject2;
      this.a.PR.setText((CharSequence)localObject1);
      this.a.PS.setText((CharSequence)localObject1);
      break;
    }
  }
  
  public void cDP()
  {
    Object localObject1 = abmt.getAppInterface();
    MqqHandler localMqqHandler;
    Message localMessage;
    if (localObject1 != null)
    {
      localMqqHandler = ((AppInterface)localObject1).getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        localMessage = localMqqHandler.obtainMessage(1134051);
        localMessage.obj = this.bhp;
        if ((TextUtils.isEmpty(this.bhp)) && (this.g != null)) {
          if (this.g.game != null) {
            break label119;
          }
        }
      }
    }
    label119:
    for (localObject1 = null;; localObject1 = this.g.game.name)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = acfp.m(2131704151);
      }
      localMessage.obj = (acfp.m(2131704147) + (String)localObject2);
      localMqqHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void cEe()
  {
    ApolloGameStateMachine.a().n(5, "CmGame.onDestroy");
    this.e.removeCallbacksAndMessages(null);
    cEg();
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUIManager", 2, "uimanager onDestroy");
    }
  }
  
  public void cEg()
  {
    Object localObject = c();
    if (localObject != null)
    {
      localObject = ((BaseChatPie)localObject).a();
      if ((localObject != null) && (((yjh)localObject).a() == this.a))
      {
        ((yjh)localObject).ciA();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar currentTipsTask dismissTipsBar()");
        }
      }
    }
    localObject = abmt.getAppInterface();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((AppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null)
      {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1134052));
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameUIManager", 2, "cancelTipBar Conversation.MSG_APOLLO_GAME_HIDE");
        }
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    switch (paramMessage.what)
    {
    }
    label594:
    label608:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        return false;
                        paramMessage = c();
                      } while (paramMessage == null);
                      paramMessage.hidePanel();
                      return false;
                      if ((this.a != null) && ((paramMessage.obj instanceof String)))
                      {
                        if (ApolloUtil.z((String)paramMessage.obj, "retcode") != 0) {
                          return true;
                        }
                        ApolloUtil.b(c(), 0);
                        return false;
                      }
                    } while (!QLog.isColorLevel());
                    QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_JION_ROOM, msg.obj is null");
                    return false;
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_ROOM_MIN");
                    }
                    paramMessage = c();
                    if (paramMessage != null)
                    {
                      localObject3 = paramMessage.a();
                      if ((localObject3 != null) && (this.a != null))
                      {
                        if ((this.a.el.getParent() instanceof ViewGroup)) {
                          ((ViewGroup)this.a.el.getParent()).removeView(this.a.el);
                        }
                        if (this.g != null)
                        {
                          if (this.g.game != null) {
                            break label594;
                          }
                          paramMessage = null;
                          localObject1 = paramMessage;
                          if (TextUtils.isEmpty(paramMessage)) {
                            localObject1 = acfp.m(2131704153);
                          }
                          paramMessage = acfp.m(2131704148) + (String)localObject1;
                          this.a.PR.setText(paramMessage);
                          this.a.PS.setText(paramMessage);
                        }
                        this.a.jj.setVisibility(0);
                        this.a.jk.setVisibility(8);
                        ((yjh)localObject3).a(this.a, new Object[0]);
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "showGameTips");
                        }
                      }
                    }
                    Object localObject3 = abmt.getAppInterface();
                    MqqHandler localMqqHandler;
                    Message localMessage;
                    if (localObject3 != null)
                    {
                      localMqqHandler = ((AppInterface)localObject3).getHandler(Conversation.class);
                      if (localMqqHandler != null)
                      {
                        localMessage = localMqqHandler.obtainMessage(1134051);
                        localMessage.obj = this.bhp;
                        if ((TextUtils.isEmpty(this.bhp)) && (this.g != null)) {
                          if (this.g.game != null) {
                            break label608;
                          }
                        }
                      }
                    }
                    for (paramMessage = (Message)localObject2;; paramMessage = this.g.game.name)
                    {
                      localObject1 = paramMessage;
                      if (TextUtils.isEmpty(paramMessage)) {
                        localObject1 = acfp.m(2131704144);
                      }
                      localMessage.obj = (acfp.m(2131704146) + (String)localObject1);
                      localMqqHandler.sendMessage(localMessage);
                      if (this.mGameId > 0) {
                        VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "miniature_game", zK(), 0, new String[] { Integer.toString(this.mGameId) });
                      }
                      if (this.fI != null)
                      {
                        paramMessage = (abpr)this.fI.get();
                        if (paramMessage != null) {
                          paramMessage.cDL();
                        }
                      }
                      ApolloGameStateMachine.a().n(4, "message game min");
                      this.e.removeMessages(25);
                      this.e.sendEmptyMessageDelayed(25, cqF);
                      return false;
                      paramMessage = this.g.game.name;
                      break;
                    }
                    if (this.g != null) {
                      if (this.g.game != null) {
                        break label735;
                      }
                    }
                    for (paramMessage = "";; paramMessage = this.g.game.name)
                    {
                      VipUtils.a(null, "cmshow", "Apollo", "game_shutdown", 0, 0, new String[] { paramMessage });
                      if (this.fI != null)
                      {
                        paramMessage = (abpr)this.fI.get();
                        if (paramMessage != null) {
                          paramMessage.CE("");
                        }
                      }
                      abml.Hw(this.mGameId);
                      QLog.i("cmgame_process.CmGameUIManager", 1, "MSG_CODE_CLOSE_GAME_TIMEOUT timeout colsegame mGameParams:" + this.g);
                      return false;
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_CLOSE_ROOM");
                    }
                    localObject2 = c();
                    if (localObject2 != null)
                    {
                      localObject2 = ((BaseChatPie)localObject2).a();
                      if (localObject2 != null)
                      {
                        if ((this.a == null) || (this.a != ((yjh)localObject2).a())) {
                          break label966;
                        }
                        ((yjh)localObject2).ciA();
                        if (QLog.isColorLevel()) {
                          QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage currentTipsTask dismissTipsBar()");
                        }
                      }
                    }
                    for (;;)
                    {
                      if (((this.mContextRef.get() == null) || (!(this.mContextRef.get() instanceof FragmentActivity))) || (this.fI != null))
                      {
                        localObject2 = (abpr)this.fI.get();
                        if ((paramMessage.obj instanceof String)) {
                          localObject1 = (String)paramMessage.obj;
                        }
                        if (localObject2 != null) {
                          ((abpr)localObject2).CE((String)localObject1);
                        }
                      }
                      paramMessage = abmt.getAppInterface();
                      if ((paramMessage == null) || (this.mGameId <= 0) || (this.g == null)) {
                        break;
                      }
                      VipUtils.a(paramMessage, "cmshow", "Apollo", "shutdown_game", 0, 0, new String[] { Integer.toString(this.mGameId), Integer.toString(abmt.zF()), Integer.toString(this.g.commFlag & 0x1) });
                      return false;
                      if (QLog.isColorLevel()) {
                        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage not dismissTipsBar()");
                      }
                    }
                    QLog.e("cmgame_process.CmGameUIManager", 1, "[min game] null app");
                    return false;
                    if ((paramMessage.obj instanceof String))
                    {
                      this.bhp = ((String)paramMessage.obj);
                      if (QLog.isColorLevel()) {
                        QLog.d("cmgame_process.CmGameUIManager", 2, new Object[] { "MSG_CODE_SHOW_TIPS update tips:", this.bhp });
                      }
                      if (this.a != null)
                      {
                        this.a.jk.setVisibility(8);
                        this.a.jj.setVisibility(0);
                        this.a.PR.setText((String)paramMessage.obj);
                      }
                    }
                    paramMessage = abmt.getAppInterface();
                  } while (!(paramMessage instanceof QQAppInterface));
                  paramMessage = paramMessage.getHandler(Conversation.class);
                } while (paramMessage == null);
                localObject1 = paramMessage.obtainMessage(1134051);
                ((Message)localObject1).arg1 = 1;
                ((Message)localObject1).obj = this.bhp;
                paramMessage.sendMessage((Message)localObject1);
                return false;
                this.e.removeMessages(25);
                if (this.mContextRef != null)
                {
                  if (this.g != null) {
                    this.g.mStartType = 1;
                  }
                  ApolloGameUtil.a((Context)this.mContextRef.get(), this.g);
                }
                ApolloGameStateMachine.a().n(3, "message show game");
                paramMessage = c();
              } while (paramMessage == null);
              if (paramMessage != null)
              {
                paramMessage.hidePanel();
                if (QLog.isColorLevel()) {
                  QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_SHOW_GAME hidePanel");
                }
              }
              this.e.sendEmptyMessageDelayed(24, 500L);
              return false;
              paramMessage = c();
            } while (paramMessage == null);
            paramMessage.hidePanel();
          } while (!QLog.isColorLevel());
          QLog.d("cmgame_process.CmGameUIManager", 2, "MSG_CODE_CHECK_HIDE_PANEL hidePanel");
          return false;
        } while (!(paramMessage.obj instanceof String));
        if ((!this.bEC) && (this.a != null))
        {
          localObject1 = (String)paramMessage.obj;
          localObject2 = new SpannableString((String)localObject1 + acfp.m(2131704149));
          ((SpannableString)localObject2).setSpan(new ForegroundColorSpan(-16776961), 0, ((String)localObject1).length(), 17);
          this.a.PS.setText((CharSequence)localObject2);
          cEf();
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_SHOW_JOIN_TIP, msg.obj is " + paramMessage.obj + ",mGameStarted:" + this.bEC);
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameUIManager", 2, "handleMessage MSG_CODE_RESET_JION_ROOM");
      }
      paramMessage = c();
    } while ((paramMessage == null) || (this.a == null) || (paramMessage.a().a() != this.a) || (!this.a.el.isShown()));
    label735:
    this.a.cEd();
    label966:
    return false;
  }
  
  public void onActivityResume()
  {
    this.e.removeMessages(25);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityResume mGameId:" + this.mGameId);
  }
  
  public void onActivityStop()
  {
    this.e.removeMessages(25);
    this.e.sendEmptyMessageDelayed(25, cqF);
    QLog.d("cmgame_process.CmGameUIManager", 2, "onActivityStop mGameId:" + this.mGameId);
  }
  
  public void onClick(View paramView)
  {
    int i;
    if ((paramView != null) && (this.g != null))
    {
      localObject = c();
      if (localObject == null) {
        break label106;
      }
      AppInterface localAppInterface = abmt.getAppInterface();
      i = ApolloUtil.a(((BaseChatPie)localObject).a(), localAppInterface);
      if (this.g.game != null) {
        break label120;
      }
    }
    label106:
    label120:
    for (Object localObject = "";; localObject = this.g.game.name)
    {
      VipUtils.a(null, "cmshow", "Apollo", "clk_game_banner", i, 0, new String[] { localObject });
      localObject = c();
      if (localObject != null) {
        ((BaseChatPie)localObject).hidePanel();
      }
      this.e.sendEmptyMessageDelayed(18, 300L);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ApolloUtil.gi(this.g.aioType);
      break;
    }
  }
  
  public int zK()
  {
    if ((this.mContextRef != null) && (this.mContextRef.get() != null) && ((this.mContextRef.get() instanceof BaseActivity)) && ((BaseActivity)this.mContextRef.get() != null) && (BaseActivity.sTopActivity != null) && ((((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.bKT == 2)) || ((BaseActivity.sTopActivity instanceof ChatActivity)))) {
      return 1;
    }
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqc
 * JD-Core Version:    0.7.0.1
 */