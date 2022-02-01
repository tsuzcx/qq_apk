import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.together.TogetherUIData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wxc
  implements Handler.Callback, View.OnClickListener, wvs
{
  private long IJ;
  private aoif jdField_a_of_type_Aoif = new wxd(this);
  aois jdField_a_of_type_Aois;
  private TogetherUIData jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData;
  private yjk jdField_a_of_type_Yjk;
  acku jdField_c_of_type_Acku = new wxe(this);
  private BaseChatPie jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie;
  private long iu;
  private BaseActivity mActivity;
  ImageView sI;
  ImageView sJ;
  
  public wxc(BaseChatPie paramBaseChatPie)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.mActivity = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData = new TogetherUIData();
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
    }
  }
  
  private boolean Sk()
  {
    return false;
  }
  
  private void ccU() {}
  
  public int[] C()
  {
    return new int[] { 3, 5, 9, 10, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      aohy localaohy = (aohy)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(339);
      if (localaohy != null) {
        localaohy.b(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo, paramInt);
      }
      return;
      onCreate();
      continue;
      onResume();
      continue;
      onPause();
      continue;
      onStop();
      continue;
      onDestroy();
    }
  }
  
  public boolean Si()
  {
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null) || (this.jdField_a_of_type_Yjk == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    while (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().a() != this.jdField_a_of_type_Yjk) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "curTip is togetherTip");
    }
    return true;
  }
  
  public boolean Sj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "dismissTogetherTip");
    }
    if ((this.jdField_a_of_type_Yjk == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "tipManager is null or together is null");
      }
    }
    yjf localyjf;
    do
    {
      return false;
      localyjf = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().a();
    } while ((localyjf == null) || (localyjf != this.jdField_a_of_type_Yjk));
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "currTip is togetherTip");
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a().ciA();
    return true;
  }
  
  public boolean Sl()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) && (QLog.isColorLevel())) {
        QLog.d("TogetherControlHelper.helper", 2, "TogetherControlHelper isTogetherTime mUIData=" + Integer.toHexString(System.identityHashCode(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData)));
      }
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().status == 3) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().status == 0)) {
      return false;
    }
    return true;
  }
  
  public boolean Sm()
  {
    return (Sl()) && (aihl.f(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().serviceType, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().uin, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().type));
  }
  
  public boolean Sn()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      bool1 = true;
    }
    aoii localaoii;
    do
    {
      do
      {
        return bool1;
        localaoii = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "isHideTogetherTip = " + localaoii.dOF);
        }
        bool1 = bool2;
      } while (!(localaoii instanceof WatchTogetherSession));
      bool1 = bool2;
    } while (localaoii.dOF != 2);
    return true;
  }
  
  public void a(int paramInt, yjf paramyjf)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip=" + paramyjf + " type=" + paramInt);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide mUIData is null or session is null");
      }
    }
    while ((paramInt != 1) || (this.jdField_a_of_type_Yjk == null) || (this.jdField_a_of_type_Yjk == paramyjf)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide tip not equal TogetherTip");
    }
    if ((aoij.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession())) && (!aihl.f(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().serviceType, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().uin, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().type)) && (!Sn())) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsHide expand=" + bool);
      }
      if (bool) {
        Sk();
      }
      ccU();
      return;
      bool = false;
    }
  }
  
  public void b(int paramInt, yjf paramyjf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onOtherTipsShow tip=" + paramyjf + " type=" + paramInt);
    }
    if (paramInt == 1) {}
  }
  
  public void ccV()
  {
    if (!(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie))
    {
      QLog.d("TogetherControlHelper.helper", 1, "chat pie not TroopChatPie");
      return;
    }
    if (this.jdField_a_of_type_Aois == null) {
      this.jdField_a_of_type_Aois = new aois(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    }
    View localView = this.mActivity.findViewById(2131364469);
    this.jdField_a_of_type_Aois.a((TroopChatPie)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie, localView);
  }
  
  public void ccW()
  {
    Object localObject = (aeog)aeif.a().o(553);
    if ((localObject != null) && (((aeog)localObject).bVm) && (!TroopInfo.isHomeworkTroop(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)))
    {
      localObject = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      if (!jof.a().dd(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)) {
        break label137;
      }
    }
    for (int i = 2130851422;; i = 2130851423)
    {
      ((NavBarAIO)localObject).setRight2Icon(i);
      try
      {
        if (!jof.a().dd(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl))
        {
          i = this.mActivity.getResources().getColor(2131167301);
          localObject = ThemeUtil.drawableTint(this.mActivity, 2130851423, i);
          this.sI.setImageDrawable((Drawable)localObject);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        label137:
        QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
      }
    }
  }
  
  public void ccX()
  {
    if ((this.sI == null) || (this.sJ == null)) {
      return;
    }
    Object localObject1 = (TroopManager)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52);
    Object localObject2 = (aeog)aeif.a().o(553);
    if ((localObject2 != null) && (((aeog)localObject2).bVm) && (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo != null) && (!TroopInfo.isHomeworkTroop(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)) && (localObject1 != null) && (!((TroopManager)localObject1).kB(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)))
    {
      localObject1 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a;
      int i;
      if (jof.a().dd(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)) {
        i = 2130851422;
      }
      for (;;)
      {
        ((NavBarAIO)localObject1).setRight2Icon(i);
        localObject1 = (altq)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(36);
        localObject2 = ((altq)localObject1).a(4, String.valueOf(130500));
        if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1))
        {
          this.sJ.setVisibility(0);
          ((altq)localObject1).e((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
        }
        try
        {
          for (;;)
          {
            if (!jof.a().dd(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl))
            {
              i = this.mActivity.getResources().getColor(2131167301);
              localObject1 = ThemeUtil.drawableTint(this.mActivity, 2130851423, i);
              this.sI.setImageDrawable((Drawable)localObject1);
            }
            if (AppSetting.enableTalkBack) {
              this.sI.setContentDescription(acfp.m(2131701811));
            }
            this.sI.setOnClickListener(this);
            this.sI.setVisibility(0);
            this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.bIL();
            anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "exp_hi", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)), "");
            return;
            i = 2130851423;
            break;
            this.sJ.setVisibility(8);
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("TogetherControlHelper.helper", 2, localThrowable, new Object[0]);
          }
        }
      }
    }
    this.sI.setOnClickListener(null);
    this.sI.setVisibility(8);
    this.sJ.setVisibility(8);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    return (this.jdField_a_of_type_Aois != null) && (this.jdField_a_of_type_Aois.azJ());
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131379975) || (paramView.getId() == 2131379972)) {
      if (System.currentTimeMillis() - this.iu < 1000L) {
        if (QLog.isColorLevel()) {
          QLog.d("TogetherControlHelper.helper", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.iu));
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.iu = System.currentTimeMillis();
      if (!aqiw.isNetworkAvailable(this.mActivity))
      {
        QQToast.a(this.mActivity, 2131699442, 0).show(this.mActivity.getTitleBarHeight());
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null))
      {
        QQToast.a(this.mActivity, 0, 2131694552, 0).show();
      }
      else
      {
        aohy localaohy = (aohy)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(339);
        if (localaohy != null)
        {
          aoii localaoii = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
          Object localObject1;
          if ((localaoii instanceof WatchTogetherSession))
          {
            localObject1 = ((TroopManager)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52)).c(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
            if (localObject1 != null)
            {
              localObject1 = aoij.a(true, ((TroopInfo)localObject1).isTroopOwner(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentAccountUin()), ((TroopInfo)localObject1).isAdmin(), ((TroopInfo)localObject1).troopowneruin, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, 0);
              switch (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().videoType)
              {
              default: 
                if (localaohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, 2, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL(), 1)) {
                  if (QLog.isColorLevel()) {
                    QLog.d("TogetherControlHelper.helper", 2, new Object[] { "start serviceType=", Integer.valueOf(2), " fail because of other together business exist, from=", Integer.valueOf(1) });
                  }
                }
                break;
              }
              for (;;)
              {
                localaohy.g("video_tab", "clk_join", 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
                break;
                QQToast.a(this.mActivity, 0, 2131694552, 0).show();
                continue;
                localaohy.g("video_tab", "clk_join_suc", 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
                localaohy.b(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.mContext, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL(), 1, 2, 1, (Bundle)localObject1);
                continue;
                localaohy.g("video_tab", "clk_join_suc", 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
                aoij.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().dOE, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().ckO, null, (Bundle)localObject1, 1);
              }
            }
          }
          else if ((localaoii instanceof SingTogetherSession))
          {
            if (QLog.isColorLevel()) {
              QLog.d("TogetherControlHelper.helper", 2, "SING together is click");
            }
            localObject1 = null;
            int i = -1;
            int j = -1;
            Object localObject2 = new Bundle();
            String str = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentAccountUin();
            boolean bool = localaohy.e(4, -1, localaoii.uin);
            if (localaoii.type == 1)
            {
              j = 1;
              localObject1 = ((TroopManager)this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.getManager(52)).c(localaoii.uin);
              if (localObject1 != null)
              {
                localObject2 = aoij.a(bool, ((TroopInfo)localObject1).isTroopOwner(str), ((TroopInfo)localObject1).isAdmin(), ((TroopInfo)localObject1).troopowneruin, localaoii.uin, 1);
                localaohy.g("sing_tab", "clk_join", 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
                i = 1;
                localObject1 = "SP_KEY_SING_TOGETHER_TROOP_AIO_RED_DOT_SHOW";
              }
            }
            else
            {
              for (;;)
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label786;
                }
                if (!bool) {
                  break label788;
                }
                localaohy.b(this.mActivity, localaoii.uin, i, 4, j, (Bundle)localObject2);
                break;
                if (localaoii.type == 2)
                {
                  localObject2 = aoij.a(bool, 4);
                  anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join", 0, 0, localaoii.uin, "", "", "");
                  j = 4;
                  i = 2;
                  localObject1 = "SP_KEY_SING_TOGETHER_FRIEND_AIO_RED_DOT_SHOW";
                }
              }
              label786:
              continue;
              label788:
              localaohy.a(this.mActivity, localaoii.uin, i, 4, j, (Bundle)localObject2);
              continue;
              if (paramView.getId() == 2131369588)
              {
                ccV();
                localObject1 = (altq)this.mActivity.app.getManager(36);
                localObject2 = ((altq)localObject1).a(10, String.valueOf(130500));
                if ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1)) {
                  ((altq)localObject1).d((BusinessInfoCheckUpdate.AppInfo)localObject2, "");
                }
                anot.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, "dc00899", "Grp_AIO", "", "hi_tab", "clk_hi", 0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, "", "" + apuh.o(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app, String.valueOf(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)), "");
              }
            }
          }
        }
      }
    }
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onCreate()");
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.addObserver(this.jdField_a_of_type_Aoif);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.addObserver(this.jdField_c_of_type_Acku);
    aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app).a(this.jdField_a_of_type_Aoif);
    if ((this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie instanceof TroopChatPie)) {
      aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app).QQ(true);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onDestroy()");
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aoif);
    this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app.removeObserver(this.jdField_c_of_type_Acku);
    aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app).b(this.jdField_a_of_type_Aoif);
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) {
      Sj();
    }
    this.IJ = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData != null) {
      this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.reset();
    }
    if (this.jdField_a_of_type_Aois != null)
    {
      this.jdField_a_of_type_Aois.dUK();
      this.jdField_a_of_type_Aois = null;
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onPause()");
    }
    yjh localyjh = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (localyjh != null) {
      localyjh.h(1003, new Object[0]);
    }
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onResume()");
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherControlHelper.helper", 2, "onStop()");
    }
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie == null) {
      return;
    }
    int i;
    if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getCurType() == 1) {
      i = 1;
    }
    for (;;)
    {
      WatchTogetherSession localWatchTogetherSession = (WatchTogetherSession)aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app).a(2, i, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.oL());
      if ((localWatchTogetherSession == null) || (localWatchTogetherSession.status != 1) || (localWatchTogetherSession.deR == 2) || (localWatchTogetherSession.dOF != 0)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onStop() hideTogetherTip");
      }
      localWatchTogetherSession.dOF = 2;
      return;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.getCurType() == 0) {
        i = 2;
      } else {
        i = 2;
      }
    }
  }
  
  public String pr()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) {
      return "";
    }
    boolean bool = Si();
    return this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getSubTitleText(bool, this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app);
  }
  
  public void xM(String paramString)
  {
    boolean bool3 = false;
    if (Math.abs(System.currentTimeMillis() - this.IJ) < 500L) {}
    boolean bool4;
    boolean bool2;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData == null) || (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession() == null));
      bool4 = Si();
      if (!bool4) {
        break;
      }
      bool2 = Sj();
      this.IJ = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("TogetherControlHelper.helper", 2, "onSubTitleClicked isPanelShow= " + bool4 + " handle=" + bool2);
      }
    } while (!bool2);
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().type == 2)
    {
      localObject2 = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app;
      if (!bool4)
      {
        localObject1 = "clk_expand";
        label142:
        anot.a((QQAppInterface)localObject2, "dc00899", "c2c_AIO", "", "sing_tab", (String)localObject1, 0, 2, paramString, "", "", "");
        label173:
        paramString = this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
        bool1 = bool3;
        if (!bool4) {
          bool1 = true;
        }
        aoij.a(paramString, (aoii)localObject1, bool1);
        ccU();
        return;
        if (aihl.f(this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().serviceType, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().uin, this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().type)) {
          break label426;
        }
      }
    }
    label426:
    for (boolean bool1 = Sk();; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession();
      bool2 = bool1;
      if (!(localObject1 instanceof WatchTogetherSession)) {
        break;
      }
      bool2 = bool1;
      if (((aoii)localObject1).dOF != 2) {
        break;
      }
      ((aoii)localObject1).dOF = 1;
      bool2 = bool1;
      break;
      localObject1 = "clk_fold";
      break label142;
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().serviceType == 2)
      {
        localObject2 = aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app);
        if (!bool4) {}
        for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
        {
          ((aohy)localObject2).g("video_tab", (String)localObject1, 2, paramString);
          break;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherUIData.getTogetherSession().serviceType != 4) {
        break label173;
      }
      localObject2 = aohy.a(this.jdField_c_of_type_ComTencentMobileqqActivityBaseChatPie.app);
      if (!bool4) {}
      for (localObject1 = "clk_expand";; localObject1 = "clk_fold")
      {
        ((aohy)localObject2).g("sing_tab", (String)localObject1, 2, paramString);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxc
 * JD-Core Version:    0.7.0.1
 */