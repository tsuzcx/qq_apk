import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloRenderDriver.a;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.ApolloWebGameActivity;
import com.tencent.mobileqq.apollo.game.WebGameFakeView;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.2;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.3;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.6;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.7;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.8;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher.9;
import com.tencent.mobileqq.apollo.store.ApolloFloatActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class abos
  implements abja, Handler.Callback, View.OnKeyListener, ApolloRenderDriver.a
{
  private long Og;
  public long Oh;
  private abmw jdField_a_of_type_Abmw;
  private abnm jdField_a_of_type_Abnm;
  private abnq jdField_a_of_type_Abnq;
  private aboc jdField_a_of_type_Aboc;
  private aboo jdField_a_of_type_Aboo;
  private abos.a jdField_a_of_type_Abos$a;
  private abpb jdField_a_of_type_Abpb;
  private abpc jdField_a_of_type_Abpc;
  private abpf jdField_a_of_type_Abpf;
  private abpm jdField_a_of_type_Abpm;
  private abqe jdField_a_of_type_Abqe;
  private abya jdField_a_of_type_Abya;
  private IApolloRunnableTask jdField_a_of_type_ComTencentMobileqqApolloIApolloRunnableTask = new CmGameLauncher.7(this);
  private ApolloPanel.b jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b;
  private tzg jdField_a_of_type_Tzg;
  private BroadcastReceiver aV = new abot(this);
  private abyv.a jdField_b_of_type_Abyv$a = new abov(this);
  private IApolloRunnableTask jdField_b_of_type_ComTencentMobileqqApolloIApolloRunnableTask = new CmGameLauncher.8(this);
  private ApolloCmdChannel jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel;
  private boolean bEj;
  private boolean bEl;
  private boolean bEm;
  private boolean bEn;
  private boolean bEo;
  private boolean bEp;
  private boolean bEq;
  private boolean bEr;
  private boolean bEs;
  private boolean bEt;
  private boolean bEu;
  private ablv jdField_c_of_type_Ablv;
  private abob jdField_c_of_type_Abob;
  public int cpN;
  public int cqs;
  private int cqt;
  public int cqu;
  private ApolloSurfaceView jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  private CmGameStartChecker.StartCheckParam jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  private auru e = new auru(Looper.getMainLooper(), this);
  private CmGameInitParams f;
  private HashMap<Integer, ApolloFloatActivity> it = new HashMap();
  public WeakReference<Activity> mContextRef;
  private int mGameId;
  private int mGameType = 1;
  private abnm mPlayer;
  public int uiOptions = 0;
  
  public abos(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[CmGameLauncher], gameId:" + paramInt);
    aqgz.getDesity();
    aboz localaboz = abmt.a();
    if (localaboz != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel = localaboz.a();
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.makesureHasInitObj();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b = new ApolloPanel.b();
    this.jdField_a_of_type_Abpc = new abpc(paramInt);
    this.mGameId = paramInt;
    abpg.a();
    this.jdField_a_of_type_Abpm = new abpm(paramInt);
    this.jdField_a_of_type_Abmw = new abmw(paramInt);
  }
  
  private void cDC()
  {
    Activity localActivity = q();
    if (localActivity == null) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new CmGameLauncher.4(this, localActivity));
  }
  
  private void cDE()
  {
    if (!this.bEl)
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "game surface view is not ready.");
      abmt.x(new Object[] { "[startGameEngine], game is not ready, so status:", Boolean.valueOf(this.bEu) });
    }
    for (;;)
    {
      return;
      Object localObject1;
      if ((this.f == null) || (TextUtils.isEmpty(this.f.mGamePath)) || (!aqhq.fileExists(this.f.mGamePath)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "mGameParams error");
        }
        localObject1 = q();
        if ((localObject1 == null) || (!(localObject1 instanceof ApolloGameActivity))) {
          continue;
        }
        ((ApolloGameActivity)localObject1).a(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam, -16);
        return;
      }
      Object localObject2;
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        if (this.bEs)
        {
          QLog.w("cmgame_process.CmGameLauncher", 1, "has ready startGameEngine");
          return;
        }
        this.bEs = true;
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.init_global_var.local", abmt.b(this.f));
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameName(this.f.mGameName);
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameStatListener(this);
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.onEnterGame(this.f.mGamePath);
        int i = this.f.mSrc;
        localObject2 = this.f.mGameName;
        if (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          break label516;
        }
        localObject1 = "-1";
        label241:
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", i, 0, new String[] { localObject2, localObject1 });
        cDG();
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "handleMessage onEnterGame");
        }
        if (this.jdField_a_of_type_Abya != null) {
          this.jdField_a_of_type_Abya.cGh();
        }
      }
      try
      {
        if (YN()) {
          abmt.a().callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
        for (;;)
        {
          cDF();
          this.Oh = SystemClock.uptimeMillis();
          long l = this.Oh - this.Og;
          QLog.d("CmGameStat", 1, new Object[] { "cmgame_open_to_start_engine, duration=", Long.valueOf(l), ", mStartGameEngineTs=", Long.valueOf(this.Oh), ", mOpenCmGameTs=", Long.valueOf(this.Og), ", gameId=", this.f.mGameName });
          abmt.x(new Object[] { "[startGameEngine] cost:", Long.valueOf(l) });
          if (l <= 0L) {
            break;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_gameId", this.f.mGameName);
          localObject2 = abmt.getAppInterface();
          if (localObject2 == null) {
            break;
          }
          anpc.a(((AppInterface)localObject2).getApp()).collectPerformance(((AppInterface)localObject2).getCurrentAccountUin(), "cmgame_open_to_start_engine", true, l, 0L, (HashMap)localObject1, "", false);
          return;
          label516:
          localObject1 = String.valueOf(ablp.cf(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
          break label241;
          abmt.a().callbackFromRequest(getGameId(), 0, "cs.xy_life_cycle_event_activity.local", "{}");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
        }
      }
    }
  }
  
  private void cDF()
  {
    if (!this.f.isWhiteUsr) {}
    for (;;)
    {
      return;
      try
      {
        if (BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0).getBoolean("game_storage_switch", false))
        {
          this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRender();
          Object localObject = ApolloRender.getUserPath(this.mGameId);
          if (localObject != null)
          {
            localObject = new File((String)localObject);
            if (((File)localObject).exists())
            {
              ((File)localObject).delete();
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localException, new Object[0]);
      }
    }
  }
  
  private void cDG()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[showImmersiveMode] show fullscreen.");
    }
    if ((this.mContextRef.get() != null) && ((this.mContextRef.get() instanceof FragmentActivity)))
    {
      Object localObject = (ChatFragment)((FragmentActivity)this.mContextRef.get()).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if (localObject != null) {
          ((BaseChatPie)localObject).hideSoftInput();
        }
      }
    }
    if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setSystemUiVisibility(this.uiOptions);
    }
  }
  
  private void cDy()
  {
    ThreadManagerV2.excute(new CmGameLauncher.2(this), 16, null, false);
  }
  
  private void cDz()
  {
    ThreadManagerV2.excute(new CmGameLauncher.3(this), 16, null, false);
  }
  
  private void m(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (!TextUtils.isEmpty(paramStartCheckParam.extendJson))) {}
    try
    {
      JSONObject localJSONObject = new JSONObject(paramStartCheckParam.extendJson);
      this.jdField_a_of_type_Abos$a = new abos.a();
      this.jdField_a_of_type_Abos$a.bhj = localJSONObject.optString("payParam");
      paramStartCheckParam.gameTypeForRedPacket = localJSONObject.optInt("gameType", 0);
      paramStartCheckParam.redUrl = localJSONObject.optString("redUrl", "");
      this.jdField_a_of_type_Abos$a.cqv = localJSONObject.optInt("score", -1);
      this.jdField_a_of_type_Abos$a.url = localJSONObject.optString("baseUrl");
      this.jdField_a_of_type_Abos$a.listId = localJSONObject.optString("listId");
      this.jdField_a_of_type_Abos$a.gameId = this.mGameId;
      if (abmt.getAppInterface() != null) {
        this.jdField_a_of_type_Abos$a.uin = Long.parseLong(abmt.getAppInterface().getCurrentAccountUin());
      }
      this.jdField_a_of_type_Abos$a.nickname = localJSONObject.optString("nickName", String.valueOf(this.jdField_a_of_type_Abos$a.uin));
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameLauncher", 1, "[setRedPacketInfo] " + this.jdField_a_of_type_Abos$a.toString());
      }
      return;
    }
    catch (JSONException paramStartCheckParam)
    {
      paramStartCheckParam.printStackTrace();
    }
  }
  
  public void BR(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRuntimeState(), 0, "sc.web_callback_game.local", paramString);
        return;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] gameview null");
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "[sendMessageToGame] channel null");
  }
  
  public void CA(String paramString)
  {
    this.e.removeMessages(203);
    if (((!this.bEm) || ((!TextUtils.isEmpty(paramString)) && (paramString.contains("inner")))) && (this.jdField_a_of_type_Aboo != null))
    {
      boolean bool = this.bEj;
      this.e.post(new CmGameLauncher.9(this, paramString, bool));
    }
    QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "handleShareMsgCallbackFromEngine mHadHandleShareMsg:", Boolean.valueOf(this.bEm) });
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "reqData:" + paramString);
    }
  }
  
  public void Cm(String paramString)
  {
    if (paramString == null) {}
    abql localabql;
    do
    {
      return;
      localabql = a();
    } while (localabql == null);
    localabql.CL(paramString);
  }
  
  public void Cz(String paramString)
  {
    QLog.d("cmgame_process.CmGameLauncher", 1, "shareGameInMenu ");
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0, "sc.game_shell_share.local", "{}");
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_share.local", "{}");
      }
      this.e.removeMessages(203);
      Message localMessage = this.e.obtainMessage(203);
      localMessage.obj = paramString;
      this.e.sendMessageDelayed(localMessage, 1000L);
      this.bEm = false;
      this.bEj = true;
      return;
    }
    QLog.e("cmgame_process.CmGameLauncher", 1, "sendGameShareMsg reqData is empty");
  }
  
  public void DV(boolean paramBoolean)
  {
    this.bEr = paramBoolean;
    if ((this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.bEr)) {
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setCanDraw(true);
    }
  }
  
  public void DW(boolean paramBoolean)
  {
    this.bEo = paramBoolean;
  }
  
  public void HD(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[closeWeb], taskId:", Integer.valueOf(paramInt) });
    }
    if ((this.it == null) || (this.it.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ApolloFloatActivity localApolloFloatActivity = (ApolloFloatActivity)this.it.remove(Integer.valueOf(paramInt));
        if ((localApolloFloatActivity != null) && (!localApolloFloatActivity.isFinishing()))
        {
          localApolloFloatActivity.finish();
          QLog.i("cmgame_process.CmGameLauncher", 1, "succeed to close web activity.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void HE(int paramInt)
  {
    if (this.mPlayer == null)
    {
      if (paramInt != 0) {
        break label52;
      }
      this.mPlayer = new abmy(abmt.getAppInterface(), this.mGameId);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Abnm == null) {
        this.jdField_a_of_type_Abnm = new abnb(this.jdField_c_of_type_Abob);
      }
      return;
      label52:
      if (1 == paramInt) {
        this.mPlayer = new abnj(this.mGameId);
      }
    }
  }
  
  public void HF(int paramInt)
  {
    if ((this.mContextRef != null) && (this.mContextRef.get() != null) && ((this.mContextRef.get() instanceof ApolloGameActivity)))
    {
      ApolloGameActivity localApolloGameActivity = (ApolloGameActivity)this.mContextRef.get();
      if ((this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 3)) {
        localApolloGameActivity.getWindow().getDecorView().setSystemUiVisibility(paramInt);
      }
    }
  }
  
  public void HG(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), paramInt, "sc.send_b2c_redpacket_result.local", "{}");
    }
  }
  
  public void HH(int paramInt)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("shareType", paramInt);
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, 0, "sc.game_shell_share.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
    }
  }
  
  public void K(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Aboo != null) {
      this.jdField_a_of_type_Aboo.g(paramBitmap, this.mGameId);
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "checkShareDefaultPic bitmap:" + paramBitmap);
    }
  }
  
  public boolean YM()
  {
    return ((this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.f != null)) || ((this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1) && (this.f != null));
  }
  
  public boolean YN()
  {
    return this.mGameType == 1;
  }
  
  public boolean YO()
  {
    return (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) && (!this.bEr);
  }
  
  public boolean YP()
  {
    return this.bEo;
  }
  
  public abmw a()
  {
    return this.jdField_a_of_type_Abmw;
  }
  
  public abnm a()
  {
    return this.mPlayer;
  }
  
  public abos.a a()
  {
    return this.jdField_a_of_type_Abos$a;
  }
  
  public abpc a()
  {
    return this.jdField_a_of_type_Abpc;
  }
  
  public abpf a()
  {
    if ((this.jdField_a_of_type_Abpf == null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.f != null)) {
      this.jdField_a_of_type_Abpf = new abpf(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView, this.f, (Activity)this.mContextRef.get());
    }
    return this.jdField_a_of_type_Abpf;
  }
  
  public abpm a()
  {
    return this.jdField_a_of_type_Abpm;
  }
  
  public abqe a()
  {
    return this.jdField_a_of_type_Abqe;
  }
  
  public abql a()
  {
    Activity localActivity = q();
    if (!(localActivity instanceof ApolloGameActivity))
    {
      QLog.w("cmgame_process.CmGameLauncher", 1, "[playAdsVideo], not ApolloGameActivity");
      return null;
    }
    return ((ApolloGameActivity)localActivity).b();
  }
  
  public CmGameStartChecker.StartCheckParam a()
  {
    return this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam;
  }
  
  public ApolloPanel.b a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel$b;
  }
  
  public tzg a(long paramLong, Activity paramActivity)
  {
    if (this.jdField_a_of_type_Tzg != null) {
      return this.jdField_a_of_type_Tzg;
    }
    tzk.prepare();
    this.jdField_a_of_type_Tzg = tzk.a(paramActivity, 5, String.valueOf(paramLong));
    QLog.i("cmgame_process.CmGameLauncher", 1, "create API manager.");
    return this.jdField_a_of_type_Tzg;
  }
  
  public void a(abqk paramabqk)
  {
    if (paramabqk == null) {}
    abql localabql;
    do
    {
      return;
      localabql = a();
    } while (localabql == null);
    localabql.b(paramabqk);
  }
  
  public void a(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    if ((paramCmGameInitParams == null) || (paramActivity == null)) {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
    }
    do
    {
      return;
      this.Og = SystemClock.uptimeMillis();
      this.f = paramCmGameInitParams;
      this.mContextRef = new WeakReference(paramActivity);
      this.e.sendEmptyMessage(204);
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameLauncher", 2, "openCmGame params:" + paramCmGameInitParams);
  }
  
  public void a(ApolloFloatActivity paramApolloFloatActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[setWebViewObj], taskId:", Integer.valueOf(paramInt), ",web:", paramApolloFloatActivity });
    }
    if (this.it == null) {
      this.it = new HashMap();
    }
    this.it.put(Integer.valueOf(paramInt), paramApolloFloatActivity);
  }
  
  public ApolloSurfaceView b()
  {
    return this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView;
  }
  
  public void b(ablv paramablv)
  {
    this.jdField_c_of_type_Ablv = paramablv;
    this.mGameType = 2;
    if (this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) {
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(paramablv);
    }
  }
  
  public void b(Activity paramActivity, CmGameInitParams paramCmGameInitParams)
  {
    this.mContextRef = new WeakReference(paramActivity);
    this.f = paramCmGameInitParams;
    this.jdField_a_of_type_Aboo = new aboo(q(), abmt.getAppInterface());
    this.jdField_a_of_type_Aboo.g(null, this.mGameId);
    if (this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      this.jdField_a_of_type_Aboc = new aboc(this.mGameId, paramActivity);
      if (this.jdField_a_of_type_Abnq != null) {
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Abnq);
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Aboc);
      this.jdField_a_of_type_Abnq = new abnq(this.mGameId);
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Abnq);
    }
    int i;
    label152:
    String str;
    if (this.f != null) {
      if (this.f == null)
      {
        i = -1;
        if (this.f != null) {
          break label219;
        }
        paramCmGameInitParams = "-1";
        if (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
          break label230;
        }
        str = "-1";
        label164:
        VipUtils.a(null, "cmshow", "Apollo", "initialize_game", i, 0, new String[] { paramCmGameInitParams, str });
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Abpm != null) {
        this.jdField_a_of_type_Abpm.setContext(paramActivity);
      }
      return;
      i = this.f.mSrc;
      break;
      label219:
      paramCmGameInitParams = this.f.mGameName;
      break label152;
      label230:
      str = String.valueOf(ablp.cf(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.extendJson));
      break label164;
      QLog.e("cmgame_process.CmGameLauncher", 1, "[initContext] para is null");
    }
  }
  
  public void bL(Activity paramActivity)
  {
    this.mContextRef = new WeakReference(paramActivity);
    if (this.jdField_a_of_type_Abpm != null) {
      this.jdField_a_of_type_Abpm.setContext(paramActivity);
    }
    this.jdField_a_of_type_Aboo = new aboo(q(), abmt.getAppInterface());
    this.jdField_a_of_type_Aboo.g(null, this.mGameId);
  }
  
  public void bP(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "[sendMsgToTargetG");
    }
    if ((this.it == null) || (this.it.size() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        ApolloFloatActivity localApolloFloatActivity = (ApolloFloatActivity)this.it.get(Integer.valueOf(paramInt));
        if (localApolloFloatActivity.g != null)
        {
          paramString = new JSONObject(paramString);
          paramString = "window.mqq && mqq.execEventCallback && mqq.execEventCallback(" + jqo.toJsString("apolloGameWebMessage") + "," + String.valueOf(paramString) + "," + String.valueOf("") + ");";
          localApolloFloatActivity.g.callJs(paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
      }
    }
  }
  
  public void bY(Bundle paramBundle)
  {
    long l1 = 0L;
    if (paramBundle == null) {}
    Activity localActivity;
    do
    {
      long l2;
      CmGameInitParams localCmGameInitParams;
      do
      {
        return;
        l2 = paramBundle.getLong("ResultCode");
        localCmGameInitParams = (CmGameInitParams)paramBundle.getSerializable("CmGameInitParams");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "onCmGameCheckGameRsp cmGameInitParams", localCmGameInitParams });
        }
        localActivity = q();
        if ((l2 != 0L) || (localCmGameInitParams == null)) {
          break;
        }
      } while (!(localActivity instanceof ApolloGameActivity));
      if (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
      for (;;)
      {
        paramBundle = (CmGameStartChecker.StartCheckParam)paramBundle.getSerializable("StartCheckParam");
        n(paramBundle);
        abmt.x(new Object[] { "[checkFinish], loading from main process and tool process is on, before cost:", Long.valueOf(l1) });
        ((ApolloGameActivity)localActivity).n(paramBundle);
        ((ApolloGameActivity)localActivity).b(localCmGameInitParams);
        return;
        l1 = System.currentTimeMillis() - this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mCreateTs;
      }
      QLog.e("cmgame_process.CmGameLauncher", 1, new Object[] { "onCmGameCheckGameRsp resultCode:", Long.valueOf(l2) });
      if ((localActivity instanceof ApolloGameActivity)) {
        ((ApolloGameActivity)localActivity).cET();
      }
    } while (localActivity == null);
    localActivity.finish();
  }
  
  public CmGameInitParams c()
  {
    return this.f;
  }
  
  public void cCb()
  {
    Activity localActivity = q();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).cCb();
    }
  }
  
  public void cDA()
  {
    if ((this.mContextRef != null) && (this.mContextRef.get() != null) && (this.bEt)) {}
    try
    {
      ((Activity)this.mContextRef.get()).unregisterReceiver(this.aV);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "unRegisterScreenBroadcast error e=" + localThrowable.toString());
    }
  }
  
  public void cDB()
  {
    abql localabql = a();
    if (localabql != null) {
      localabql.DZ(false);
    }
  }
  
  public void cDD()
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[destroyGameView]");
    if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
    {
      HF(this.cqt);
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnDestroyCloseGame(true);
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl() != null) {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getRenderImpl().onDestroy();
      }
    }
    try
    {
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() != null)
      {
        if (!(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent() instanceof ViewGroup)) {
          break label231;
        }
        ((ViewGroup)this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getParent()).removeView(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
        this.mContextRef = null;
        this.bEl = false;
        this.f = null;
        if (this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
        {
          if (this.jdField_c_of_type_Ablv != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_c_of_type_Ablv);
          }
          if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeRenderRunner(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          }
          if (this.jdField_a_of_type_Aboc != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Aboc);
          }
          if (this.jdField_a_of_type_Abnq != null) {
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Abnq);
          }
          if (this.jdField_a_of_type_Abnq != null) {
            this.jdField_a_of_type_Abnq.onDestroy();
          }
          if (this.jdField_c_of_type_Abob != null)
          {
            this.jdField_c_of_type_Abob.destroyHandler();
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_c_of_type_Abob);
          }
        }
        return;
        label231:
        ((WindowManager)this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getContext().getSystemService("window")).removeView(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "destroyGameView windowManager.removeView(mApolloGameView)");
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public void cDH()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_close.local", "{}");
    }
    aboi.a("cs.close_room.local", "{}", false, null, this.mGameId);
  }
  
  public void cDI()
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("StartCheckParam", this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_query_check_game_data", localBundle, new abou(this));
  }
  
  public void caS()
  {
    this.bEn = true;
    if (this.mPlayer != null) {
      this.mPlayer.Zx();
    }
    if (this.jdField_a_of_type_Abnm != null) {
      this.jdField_a_of_type_Abnm.Zx();
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null)
    {
      if (this.jdField_a_of_type_Abnq != null) {
        this.jdField_a_of_type_Abnq.DU(false);
      }
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_minimize.local", "{}");
        this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_shell_pack_up.local", "{}");
      }
    }
    aboi.a("cs.make_room_min.local", "{}", false, null, this.mGameId);
    if ((abmt.a() != null) && (this.mContextRef != null)) {
      abmt.a(this.mGameId, (Context)this.mContextRef.get());
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameLauncher", 2, "onBackEvent");
    }
  }
  
  public void dD(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    paramContext.registerReceiver(this.aV, localIntentFilter);
    this.bEt = true;
  }
  
  public void doOnDestroy()
  {
    cDA();
    ApolloGameStateMachine.a().n(5, "CmGame.onDestroy");
    this.e.removeCallbacksAndMessages(null);
    if (this.mPlayer != null) {
      this.mPlayer.onDestroy();
    }
    if (this.jdField_a_of_type_Abnm != null) {
      this.jdField_a_of_type_Abnm.onDestroy();
    }
    if (Looper.getMainLooper() == Looper.myLooper()) {
      cDD();
    }
    for (;;)
    {
      this.bEl = false;
      this.bEs = false;
      this.f = null;
      if (this.jdField_a_of_type_Abpb != null) {}
      try
      {
        AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_Abpb);
        if (this.jdField_a_of_type_Abya != null) {
          this.jdField_a_of_type_Abya.cGi();
        }
        if (this.jdField_a_of_type_Aboo != null) {
          this.jdField_a_of_type_Aboo.cDx();
        }
        if (this.jdField_a_of_type_Tzg != null) {
          this.jdField_a_of_type_Tzg.release();
        }
        if (this.jdField_a_of_type_Abqe != null) {
          this.jdField_a_of_type_Abqe.onDestroy();
        }
        if (this.jdField_a_of_type_Abmw != null) {
          this.jdField_a_of_type_Abmw.onDestroy();
        }
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy");
        }
        return;
        this.e.obtainMessage(202).sendToTarget();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("cmgame_process.CmGameLauncher", 2, "onDestroy in AsyncThread");
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Abnq != null) {
      this.jdField_a_of_type_Abnq.onPause();
    }
    if (this.mPlayer != null) {
      this.mPlayer.Zx();
    }
    if (this.jdField_a_of_type_Abnm != null) {
      this.jdField_a_of_type_Abnm.Zx();
    }
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if ((localApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)) {
      localApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_background.local", "{}");
    }
  }
  
  public void doOnResume()
  {
    this.bEn = false;
    if (this.jdField_a_of_type_Abnq != null) {
      this.jdField_a_of_type_Abnq.onResume();
    }
    ApolloCmdChannel localApolloCmdChannel = abmt.a();
    if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
      ApolloGameStateMachine.a().n(3, "CmGame.onResume");
    }
    if ((this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (localApolloCmdChannel != null))
    {
      if (this.mPlayer != null) {
        this.mPlayer.resumeMusic();
      }
      if (this.jdField_a_of_type_Abnm != null) {
        this.jdField_a_of_type_Abnm.resumeMusic();
      }
      if (localApolloCmdChannel != null)
      {
        localApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_maximize.local", "{}");
        localApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.game_enter_foreground.local", "{}");
      }
    }
  }
  
  public void g(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {
      QLog.e("cmgame_process.CmGameLauncher", 2, "[openCmGame] parmas is null!");
    }
    long l;
    do
    {
      do
      {
        return;
        l = SystemClock.uptimeMillis();
        this.mContextRef = new WeakReference(paramActivity);
        if (!abyv.Zr())
        {
          QLog.e("cmgame_process.CmGameLauncher", 1, "engine is not ready.");
          abyv.b(this.jdField_b_of_type_Abyv$a);
          abyv.a(this.jdField_b_of_type_Abyv$a);
          abyv.loadSo("CmGameLauncher");
          return;
        }
        abyv.b(this.jdField_b_of_type_Abyv$a);
        bL(paramActivity);
        dD(paramActivity);
        this.jdField_a_of_type_Abya = new abya(this.mGameId);
        if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          break label562;
        }
        if (this.mContextRef != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContextRef=null");
      return;
      if (this.jdField_a_of_type_Abqe == null) {
        this.jdField_a_of_type_Abqe = new abqe((Context)this.mContextRef.get(), this.mGameId);
      }
      paramActivity = (Activity)this.mContextRef.get();
      if (paramActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext=null");
    return;
    if (paramActivity.isFinishing())
    {
      QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext is isFinishing");
      return;
    }
    boolean bool2;
    try
    {
      if (paramActivity.isDestroyed())
      {
        QLog.e("cmgame_process.CmGameLauncher", 2, "openApolloGame mContext not isDestroyed");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameLauncher", 1, localThrowable, new Object[0]);
      bool2 = abmt.hP(this.mGameId);
      if (!bool2) {}
    }
    label562:
    label755:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("cmgame_process.CmGameLauncher", 1, new Object[] { "[initGameUI] mGameId=", Integer.valueOf(this.mGameId), ", isIsland=", Boolean.valueOf(bool2), ", isTransparent=", Boolean.valueOf(bool1) });
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView = new ApolloSurfaceView(paramActivity, null, bool2, paramBoolean, bool1);
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setGameId(this.mGameId);
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.init(this, 1);
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setTouchMode(1);
      this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setFrameNum(60);
      if (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setMainLoadingGameMode(this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess);
      }
      this.cqt = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      this.uiOptions = paramActivity.getWindow().getDecorView().getSystemUiVisibility();
      for (;;)
      {
        try
        {
          if ((paramActivity instanceof ApolloGameActivity))
          {
            ((ApolloGameActivity)paramActivity).a(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addRenderRunner(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
            this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.setOnKeyListener(this);
            if (this.jdField_a_of_type_Aboc != null) {
              this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Aboc);
            }
            if (this.jdField_a_of_type_Abnq != null) {
              this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.removeCmdHandler(this.jdField_a_of_type_Abnq);
            }
            this.jdField_a_of_type_Aboc = new aboc(this.mGameId, paramActivity);
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Aboc);
            this.jdField_a_of_type_Abnq = new abnq(this.mGameId);
            this.jdField_c_of_type_Abob = new abob(this);
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_a_of_type_Abnq);
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.addCmdHandler(this.jdField_c_of_type_Abob);
            if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker() != null) {
              this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getWorker().mGameId = this.mGameId;
            }
            paramActivity = q();
            if ((paramActivity != null) && ((paramActivity instanceof ApolloGameActivity))) {
              ((ApolloGameActivity)paramActivity).ha(SystemClock.uptimeMillis() - l);
            }
            this.bEq = true;
            QLog.i("cmgame_process.CmGameLauncher", 2, "[initGameUI] gameId:" + this.mGameId);
            return;
            if ((this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (!this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess) || (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mIsTransGame)) {
              break label755;
            }
            bool1 = true;
            break;
          }
          if ((paramActivity instanceof ApolloWebGameActivity)) {
            ((ApolloWebGameActivity)paramActivity).a(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView);
          } else {
            QLog.e("cmgame_process.CmGameLauncher", 1, "[initGameUI] launch from other activity, check it, activity=" + paramActivity);
          }
        }
        catch (Exception paramActivity)
        {
          QLog.e("cmgame_process.CmGameLauncher", 2, paramActivity, new Object[0]);
          this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView = null;
          this.f = null;
          return;
        }
      }
    }
  }
  
  public void gQ(long paramLong)
  {
    Activity localActivity = q();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).gQ(paramLong);
    }
  }
  
  public void gR(long paramLong)
  {
    Activity localActivity = q();
    if ((localActivity != null) && ((localActivity instanceof ApolloGameActivity))) {
      ((ApolloGameActivity)localActivity).gR(paramLong);
    }
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 201: 
    default: 
    case 204: 
      do
      {
        return false;
      } while (this.f == null);
      if ((!this.bEq) && (this.mContextRef != null)) {
        g((Activity)this.mContextRef.get(), this.f.mIsEnableMSAA);
      }
      if ((this.f.mScreenMode == 0) && (Build.VERSION.SDK_INT >= 19))
      {
        this.uiOptions = 5894;
        if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
          this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.uiOptions = this.uiOptions;
        }
        HF(this.uiOptions);
      }
      if (this.bEl) {
        cDE();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("cmgame_process.CmGameLauncher", 2, "openCmGame screenMode:" + this.f.mScreenMode);
        return false;
        this.bEp = true;
      }
    case 200: 
      cDE();
      return false;
    case 202: 
      doOnDestroy();
      return false;
    }
    if ((paramMessage.obj instanceof String))
    {
      if ((this.jdField_a_of_type_Aboo == null) || (!this.jdField_a_of_type_Aboo.hS(this.mGameId))) {
        break label271;
      }
      this.jdField_a_of_type_Aboo.i((String)paramMessage.obj, this.mGameId, this.bEj);
      this.bEj = false;
    }
    for (;;)
    {
      this.bEm = true;
      return false;
      label271:
      abxt.b(this.mGameId, (String)paramMessage.obj, q());
    }
  }
  
  public void l(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
    m(paramStartCheckParam);
  }
  
  public void n(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam == null) || (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null)) {
      return;
    }
    if ((paramStartCheckParam.statMap != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap != null))
    {
      if (paramStartCheckParam.statMap.containsKey("download_confirm")) {
        this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("download_confirm", paramStartCheckParam.statMap.get("download_confirm"));
      }
      if (paramStartCheckParam.statMap.containsKey("download_game_res")) {
        this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap.put("download_game_res", paramStartCheckParam.statMap.get("download_game_res"));
      }
    }
    paramStartCheckParam.statMap = this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.statMap;
    this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam = paramStartCheckParam;
  }
  
  public void o(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType != 1))
        {
          localObject = q();
          if ((localObject != null) && ((localObject instanceof ApolloGameActivity)) && (!((Activity)localObject).isFinishing()))
          {
            localObject = ((ApolloGameActivity)localObject).a();
            if (localObject != null) {
              ((WebGameFakeView)localObject).H(paramInt1, this.mGameId, paramInt3, paramInt2);
            }
          }
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel != null) && (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null))
        {
          if (paramInt1 == -1)
          {
            this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), -1, "sc.share_game_to_friend_result.local", "{}");
            return;
          }
          localObject = new abpg.a();
          ((abpg.a)localObject).cqC = paramInt1;
          ((abpg.a)localObject).Oj = System.currentTimeMillis();
          ((abpg.a)localObject).mGameId = this.mGameId;
          ((abpg.a)localObject).bZN = paramInt2;
          ((abpg.a)localObject).byr = paramInt3;
          ((abpg.a)localObject).mUin = paramString;
          ((abpg.a)localObject).cpN = this.cqs;
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult],gameShareResult:", localObject });
          }
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("reqCode", this.cqu);
          this.cqu = 0;
          localJSONObject.put("ret", paramInt1);
          localJSONObject.put("gameId", this.mGameId);
          localJSONObject.put("aioType", paramInt3);
          localJSONObject.put("shareTo", paramInt2);
          if (!abpg.a().a((abpg.a)localObject)) {
            break label425;
          }
          paramInt3 = 0;
          localJSONObject.put("isFirstTimeShare", paramInt3);
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "[notifyEngineSharedResult] engine root:", localJSONObject.toString() });
          }
          this.jdField_b_of_type_ComTencentMobileqqApolloAioChannelApolloCmdChannel.callbackFromRequest(this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.getLuaState(), 0, "sc.share_game_to_friend_result.local", localJSONObject.toString());
          abpg.a().a((abpg.a)localObject);
        }
        if ((this.jdField_a_of_type_Aboo == null) || (!this.jdField_a_of_type_Aboo.YL())) {
          break label430;
        }
        paramInt3 = 1;
      }
      catch (Throwable paramString)
      {
        QLog.e("cmgame_process.CmGameLauncher", 1, paramString, new Object[0]);
        return;
      }
      VipUtils.a(null, "cmshow", "Apollo", (String)localObject, 0, paramInt1, new String[] { String.valueOf(this.mGameId), paramString });
      return;
      label425:
      paramInt3 = 1;
      continue;
      label430:
      paramInt3 = 0;
      label435:
      for (Object localObject = "sendShowOffButtonSuccessful"; paramInt1 != 0; localObject = "sendUniversialFrameShareButtonSuccessful")
      {
        paramInt1 = 4;
        break;
        if (paramInt3 == 0) {
          break label435;
        }
      }
      paramInt1 = paramInt2;
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      QLog.i("cmgame_process.CmGameLauncher", 1, "[KEYCODE_BACK]");
      paramView = abmt.a();
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null)
      {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.runRenderTask(new CmGameLauncher.6(this, paramView));
        return true;
      }
    }
    return false;
  }
  
  public void onNotifyLongTouch(String paramString) {}
  
  public void onNotifyStatusChanged(int paramInt, String paramString) {}
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (!this.bEl)
    {
      this.bEl = true;
      if (this.bEp)
      {
        this.e.sendEmptyMessage(200);
        this.bEp = false;
      }
      if (this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) {
        this.jdField_d_of_type_ComTencentMobileqqApolloApolloSurfaceView.mIsGameReady = true;
      }
      this.jdField_a_of_type_Abpb = new abpb(this.mGameId);
      AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getContext(), this.jdField_a_of_type_Abpb);
    }
  }
  
  public Activity q()
  {
    if (this.mContextRef != null) {
      return (Activity)this.mContextRef.get();
    }
    return null;
  }
  
  public void z(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_c_of_type_Ablv != null) {
      this.jdField_c_of_type_Ablv.v(paramInt, paramString1, paramString2);
    }
  }
  
  public static class a
  {
    public String aNy = "0";
    public volatile boolean bEw;
    public String bhi = "";
    public String bhj;
    public int cqv = -1;
    public volatile int cqw = 0;
    public int cqx;
    public int gameId;
    public String listId;
    public String nickname;
    public String state = "-1";
    public long uin;
    public String url;
    
    public String getResult()
    {
      Object localObject = new JSONObject();
      if (!TextUtils.isEmpty(this.url)) {
        try
        {
          String str = this.url + "?amount=" + this.aNy + "&state=" + this.state + "&goalScore=" + this.cqv + "&curScore=" + this.cqx + "&nickName=" + this.nickname;
          ((JSONObject)localObject).put("url", str);
          ((JSONObject)localObject).put("ret", this.state);
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameLauncher", 2, "url:" + str + ",state:" + this.state);
          }
          localObject = ((JSONObject)localObject).toString();
          return localObject;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      for (;;)
      {
        return null;
        QLog.e("cmgame_process.CmGameLauncher", 1, "[getResult] baseUrl is null");
      }
    }
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("RedPacketInfo{");
      localStringBuffer.append("targetScore=").append(this.cqv);
      localStringBuffer.append(", grabState=").append(this.cqw);
      localStringBuffer.append(", res='").append(this.bhi).append('\'');
      localStringBuffer.append(", needNotifyResult=").append(this.bEw);
      localStringBuffer.append(", listId='").append(this.listId).append('\'');
      localStringBuffer.append(", url='").append(this.url).append('\'');
      localStringBuffer.append(", gameId=").append(this.gameId);
      localStringBuffer.append(", amount='").append(this.aNy).append('\'');
      localStringBuffer.append(", nickname='").append(this.nickname).append('\'');
      localStringBuffer.append(", endScore=").append(this.cqx);
      localStringBuffer.append(", state='").append(this.state).append('\'');
      localStringBuffer.append(", payParam='").append(this.bhj).append('\'');
      localStringBuffer.append(", uin=").append(this.uin);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abos
 * JD-Core Version:    0.7.0.1
 */