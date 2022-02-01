package com.tencent.mobileqq.apollo.process.ui.framework;

import ablw;
import abmt;
import abos;
import abqf;
import acbk;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import auru;
import ausj;
import ausj.a;
import auss;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class CmGameFloatView
  extends FrameworkView
  implements View.OnClickListener
{
  private View AL;
  private SparseIntArray P = new SparseIntArray();
  private boolean bED;
  private boolean bEE;
  private boolean bEF;
  private boolean bEG;
  private int cqG = -1;
  private int cqH = -1;
  private int cqI = -1;
  private int cqJ = -1;
  private int cqK = -1;
  private FrameGifView f;
  private ausj.a i = new abqf(this);
  private ausj mActionSheet;
  private ImageView mCloseBtn;
  private ImageView xw;
  private ImageView xx;
  
  public CmGameFloatView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }
  
  public CmGameFloatView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    initView(paramContext);
    p(paramStartCheckParam);
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318))) {
      this.bEE = true;
    }
  }
  
  private boolean YV()
  {
    boolean bool = true;
    if ((this.b == null) || (this.b.pushItem == null)) {
      bool = false;
    }
    while (this.b.pushItem.is_show_red == 1) {
      return bool;
    }
    return false;
  }
  
  private void initView(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131559005, null);
    this.xw = ((ImageView)localRelativeLayout.findViewById(2131363912));
    this.mCloseBtn = ((ImageView)localRelativeLayout.findViewById(2131363823));
    this.f = ((FrameGifView)localRelativeLayout.findViewById(2131363962));
    this.f.setPlayLoop(true);
    this.AL = localRelativeLayout.findViewById(2131370486);
    this.xx = ((ImageView)localRelativeLayout.findViewById(2131371953));
    this.f.setVisibility(8);
    this.AL.setVisibility(8);
    this.xw.setBackgroundResource(2130838612);
    if (YV()) {
      this.xx.setVisibility(0);
    }
    this.xw.setOnClickListener(this);
    this.mCloseBtn.setOnClickListener(this);
    this.f.setOnClickListener(this);
    addView(localRelativeLayout);
    localRelativeLayout = (RelativeLayout)((Activity)this.mActivityRef.get()).findViewById(2131377555);
    int j = (int)paramContext.getResources().getDimension(2131296521);
    int k = (int)paramContext.getResources().getDimension(2131296520);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(11);
    paramContext.addRule(10);
    paramContext.rightMargin = k;
    paramContext.topMargin = j;
    localRelativeLayout.addView(this, paramContext);
  }
  
  public boolean YU()
  {
    return (this.b != null) && (this.b.mGameType == 3);
  }
  
  public void at(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.b.mTempAIOUin)))
    {
      this.bEF = paramBoolean;
      ThreadManager.getUIHandler().post(new CmGameFloatView.2(this, paramBoolean));
    }
  }
  
  public void cEh()
  {
    this.xw.setEnabled(false);
    this.mCloseBtn.setEnabled(false);
  }
  
  public void cEi()
  {
    if (this.jdField_a_of_type_Abos != null)
    {
      String str = this.jdField_a_of_type_Abos.a().mTempAIOUin;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", str);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_voice_switch", localBundle, null);
    }
  }
  
  public void i(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, "[onQueryVoiceStatus] get voice status.");
    }
    this.bEG = paramBoolean1;
    this.bEF = paramBoolean2;
  }
  
  public void onClick(View paramView)
  {
    if (this.b == null) {}
    Object localObject1;
    label112:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363823: 
          if ((this.jdField_a_of_type_Abos != null) && (this.jdField_a_of_type_Abos.YM())) {
            break label1033;
          }
          QLog.d("cmframe_CmGameFloatView", 1, "game not running, finish");
          localObject1 = (Activity)this.mActivityRef.get();
          if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
            ((Activity)localObject1).finish();
          }
          if (this.mActivityRef != null)
          {
            localObject1 = (Activity)this.mActivityRef.get();
            if ((localObject1 != null) && ((localObject1 instanceof ApolloGameActivity))) {
              ((ApolloGameActivity)localObject1).cES();
            }
          }
          break;
        case 2131363912: 
          if (this.jdField_a_of_type_Abos != null)
          {
            if (!this.jdField_a_of_type_Abos.YO()) {
              break label185;
            }
            QLog.e("cmframe_CmGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
          }
          break;
        }
      }
    } while ((this.mActionSheet != null) && (this.mActionSheet.isShowing()));
    label185:
    label234:
    int k;
    if (this.mActionSheet == null) {
      if (YU())
      {
        this.mActionSheet = ((ausj)auss.a(this.jdField_a_of_type_Abos.q(), null));
        if (QLog.isColorLevel()) {
          QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "isWhiteUsr:", Boolean.valueOf(this.b.isWhiteUsr) });
        }
        if (this.b.pushItem == null) {
          break label1328;
        }
        localObject1 = acfp.m(2131704082);
        if (!TextUtils.isEmpty(this.b.pushItem.content)) {
          localObject1 = this.b.pushItem.content;
        }
        if (this.b.pushItem.is_show_red != 1) {
          break label813;
        }
        this.mActionSheet.addButtonWithRightIcon((String)localObject1, 2130851400, 0);
        label343:
        this.cqJ = 0;
        this.P.put(0, 6);
        k = this.b.src;
        int m = this.b.gameId;
        localObject1 = this.b.pushItem.msg_id;
        if (this.b.pushItem.is_show_red != 1) {
          break label834;
        }
        j = 1;
        label403:
        VipUtils.a(null, "cmshow", "Apollo", "exporePromoteInUnversialFrame", k, 0, new String[] { String.valueOf(m), localObject1, String.valueOf(j) });
      }
    }
    label550:
    label813:
    label1328:
    for (int j = 1;; j = 0)
    {
      k = j;
      if (!this.b.disableMinGame)
      {
        k = this.b.enter;
        if ((k == 0) || (k == 1) || (k == 7))
        {
          this.mActionSheet.addButton(2131690364, 0);
          label490:
          this.P.put(j, 0);
          k = j + 1;
        }
      }
      else
      {
        j = k;
        if (this.bEE)
        {
          j = k;
          if (this.bEG)
          {
            j = k;
            if (!this.bED)
            {
              if (!this.bEF) {
                break label853;
              }
              this.mActionSheet.addButton(acfp.m(2131704087));
              this.cqG = k;
              this.P.put(k, 5);
              j = k + 1;
            }
          }
        }
        this.mActionSheet.addButton(2131690370, 0);
        localObject1 = this.P;
        k = j + 1;
        ((SparseIntArray)localObject1).put(j, 1);
        this.mActionSheet.addButton(2131690358, 0);
        localObject1 = this.P;
        j = k + 1;
        ((SparseIntArray)localObject1).put(k, 3);
        if ((this.b.game == null) || (TextUtils.isEmpty(this.b.game.name))) {
          break label869;
        }
        this.mActionSheet.addButton(acfp.m(2131704084) + this.b.game.name, 0);
        label690:
        localObject1 = this.P;
        k = j + 1;
        ((SparseIntArray)localObject1).put(j, 2);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
        if (this.b.isWhiteUsr) {
          break label883;
        }
        this.mActionSheet.addCancelButton(2131721058);
        this.mActionSheet.a(this.i);
      }
      label834:
      label853:
      label869:
      label883:
      do
      {
        do
        {
          this.mActionSheet.show();
          VipUtils.a(null, "cmshow", "Apollo", "more_info", 0, 0, new String[] { String.valueOf(this.b.gameId) });
          break;
          this.mActionSheet = ((ausj)auss.b(this.jdField_a_of_type_Abos.q(), null));
          break label234;
          this.mActionSheet.addButton(this.b.pushItem.content, 0);
          break label343;
          j = 0;
          break label403;
          this.mActionSheet.addButton(2131690365, 0);
          break label490;
          this.mActionSheet.addButton(acfp.m(2131704086));
          break label550;
          this.mActionSheet.addButton(2131690368, 0);
          break label690;
          bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
          localObject1 = this.mActionSheet;
          if (bool) {}
          for (j = 2131690362;; j = 2131690363)
          {
            ((ausj)localObject1).addButton(j, 0);
            this.cqK = k;
            this.P.put(k, 9);
            break;
          }
        } while (!this.b.isWhiteUsr);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      } while (this.cqK < 0);
      boolean bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
      localObject1 = this.mActionSheet;
      k = this.cqK;
      Object localObject2 = getResources();
      if (bool) {}
      for (j = 2131690362;; j = 2131690363)
      {
        ((ausj)localObject1).updateButton(k, ((Resources)localObject2).getString(j));
        break;
      }
      QLog.d("cmframe_CmGameFloatView", 1, "notify game");
      if (!YW())
      {
        if (this.jdField_a_of_type_Ablw != null) {
          this.jdField_a_of_type_Ablw.cCT();
        }
        this.jdField_a_of_type_Abos.cDH();
        if ((this.b == null) || ((this.b.commFlag & 0x1) == 0))
        {
          this.e.sendEmptyMessageDelayed(102, 1000L);
          break label112;
        }
        this.e.sendEmptyMessageDelayed(102, 5000L);
        QLog.i("cmframe_CmGameFloatView", 1, "comm flag bit0 is 1.");
        break label112;
      }
      this.e.sendEmptyMessage(111);
      break label112;
      if (this.bED)
      {
        if (!abmt.isFastDoubleClick())
        {
          cEi();
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmframe_CmGameFloatView", 2, "[onClick] click audio button too fast.");
        break;
      }
      localObject2 = (String)this.f.getTag();
      if (this.b != null) {}
      for (localObject1 = String.valueOf(this.b.gameId);; localObject1 = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "clickpacket", 0, 0, new String[] { localObject1 });
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = super.getContext();
        Intent localIntent = new Intent((Context)localObject1, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject2);
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hide_more_button", true);
        ((Context)localObject1).startActivity(localIntent);
        break;
      }
    }
  }
  
  public void p(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", paramStartCheckParam.mTempAIOUin);
      localBundle.putBoolean("key_open_voice", false);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_enter_room", localBundle, null);
    }
  }
  
  public void resetView()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      Resources localResources = ((Activity)this.mActivityRef.get()).getResources();
      localLayoutParams.topMargin = ((int)localResources.getDimension(2131296521));
      localLayoutParams.rightMargin = ((int)localResources.getDimension(2131296520));
      QLog.d("cmframe_CmGameFloatView", 1, "[handleMessage] MSG_RESET_TOP_MENU reset");
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void u(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "[updateRedPacketButton] isVisible=", Boolean.valueOf(paramBoolean), ", url=", paramString1, ", iconUrl=", paramString2 });
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)))
    {
      this.f.setVisibility(0);
      this.AL.setVisibility(0);
      this.f.setTag(paramString1);
      this.xw.setBackgroundResource(2130838611);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.f.setGifData(100, null, paramString2, acbk.jb(paramString2), true);
        if (this.f.getState() == 3)
        {
          this.f.cGV();
          if (this.b == null) {
            break label350;
          }
        }
      }
    }
    label322:
    label350:
    for (paramString1 = String.valueOf(this.b.gameId);; paramString1 = "")
    {
      VipUtils.a(null, "cmshow", "Apollo", "packetshow", 0, 0, new String[] { paramString1 });
      do
      {
        return;
        this.f.setImageResource(2130838613);
        break;
        this.f.setImageResource(2130838613);
        break;
        if (!this.bEE) {
          break label322;
        }
        this.f.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", acbk.jb("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      } while (!this.bEG);
      this.f.setVisibility(0);
      this.AL.setVisibility(0);
      this.xw.setBackgroundResource(2130838611);
      if (this.bEF) {
        if (this.f.getState() == 3) {
          this.f.cGV();
        }
      }
      for (;;)
      {
        this.bED = true;
        return;
        this.f.setImageResource(2130839445);
        continue;
        this.f.setImageResource(2130839443);
      }
      this.f.setVisibility(8);
      this.AL.setVisibility(8);
      this.xw.setBackgroundResource(2130838612);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView
 * JD-Core Version:    0.7.0.1
 */