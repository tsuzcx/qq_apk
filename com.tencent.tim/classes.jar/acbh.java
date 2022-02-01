import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JDHongbaoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.1;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.2;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActInfo;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActShowInfo;

public class acbh
  extends aqrd
  implements abja, View.OnClickListener, wnq
{
  public boolean bGN;
  public boolean bGO;
  public boolean bGP;
  private Runnable fI = new ChatApolloViewListener.3(this);
  public WeakReference<BaseChatPie> fj;
  public PopupWindow i;
  
  public acbh(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof xys)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof xyi)) || ((paramBaseChatPie instanceof yam))) {
      this.fj = new WeakReference(paramBaseChatPie);
    }
  }
  
  private void a(Activity paramActivity, qqshop_act.SQQSHPActShowInfo paramSQQSHPActShowInfo, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramSQQSHPActShowInfo == null)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, JDHongbaoActivity.class);
    localIntent.putExtra("jd_hb_is_check_delay", paramBoolean);
    localIntent.putExtra("jd_hb_title", paramSQQSHPActShowInfo.title.get());
    localIntent.putExtra("jd_hb_subtitle", paramSQQSHPActShowInfo.subtext.get());
    localIntent.putExtra("jd_hb_detail_text", paramSQQSHPActShowInfo.gift_text.get());
    localIntent.putExtra("jd_hongbao_tips", paramSQQSHPActShowInfo.act_text.get());
    localIntent.putExtra("jd_hb_btn_text", paramSQQSHPActShowInfo.btn_text.get());
    localIntent.putExtra("jd_hb_detail_url", paramSQQSHPActShowInfo.detail_url.get());
    localIntent.putExtra("jd_hb_btn_url", paramSQQSHPActShowInfo.btn_url.get());
    localIntent.putExtra("jd_hb_logo_url", paramSQQSHPActShowInfo.logo.get());
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  private void cGS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[initJDRedPackEntry],mIsJumpEggStart:" + this.bGN);
    }
    if (this.fj == null) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.fj.get();
    } while ((localObject == null) || (((BaseChatPie)localObject).app == null) || (!this.bGN) || (((BaseChatPie)localObject).a() == null));
    ((BaseChatPie)localObject).a().x(this);
    kec localkec = (kec)((BaseChatPie)localObject).app.getBusinessHandler(88);
    String str = Integer.toString(kdm.cS(((BaseChatPie)localObject).sessionInfo.cZ));
    if ((((BaseChatPie)localObject).sessionInfo.cZ == 1) || (((BaseChatPie)localObject).sessionInfo.cZ == 3000)) {}
    for (Object localObject = ((BaseChatPie)localObject).sessionInfo.aTl;; localObject = "")
    {
      localkec.a(134247330, "", str, (String)localObject, "", 0L, false);
      return;
    }
  }
  
  public static void d(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[doJDRedPackReport], key:" + paramInt + ",app:" + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    ((kec)paramQQAppInterface.getBusinessHandler(88)).a(paramInt, "", "", "", "", 0L, false);
  }
  
  public void Dm(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[addJDEndView],imgUrl:" + paramString);
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(BaseApplicationImpl.getContext(), 2131558730, null);
    if (localLinearLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "errInfo->inflate err.");
      }
    }
    do
    {
      do
      {
        return;
        Object localObject = (ImageView)localLinearLayout.findViewById(2131369970);
        TextView localTextView = (TextView)localLinearLayout.findViewById(2131369791);
        ((ImageView)localObject).setOnClickListener(this);
        localTextView.setOnClickListener(this);
        localObject = (URLImageView)localLinearLayout.findViewById(2131369649);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
          if ((localObject != null) && (paramString != null)) {
            ((URLImageView)localObject).setImageDrawable(paramString);
          }
        }
        if (this.i == null) {
          this.i = new PopupWindow(localLinearLayout, -1, -1, false);
        }
      } while (this.fj == null);
      paramString = (BaseChatPie)this.fj.get();
    } while (paramString == null);
    this.i.showAsDropDown(paramString.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO);
    d(134247341, paramString.app);
  }
  
  public void aS(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.bGO = true;
      if (paramInt == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.bGP = paramBoolean;
        return;
      }
    }
    this.bGO = false;
    this.bGP = false;
  }
  
  public void bZP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimStart], mIsJumpEggStart:" + this.bGN);
    }
    if (this.fj == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.fj.get();
    } while ((this.bGN) || (localBaseChatPie == null) || (localBaseChatPie.app == null));
    localBaseChatPie.app.getHandler(ChatActivity.class).removeCallbacks(this.fI);
    this.bGN = true;
    kdm localkdm = (kdm)localBaseChatPie.app.getManager(88);
    ((aqrb)localBaseChatPie.app.getBusinessHandler(71)).mF(localkdm.aHZ);
  }
  
  public void bZQ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimEnd], mIsJumpEggStart:" + this.bGN);
    }
    if ((this.fj == null) || (!this.bGN)) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.fj.get();
    } while (localObject == null);
    kdm localkdm = (kdm)((BaseChatPie)localObject).app.getManager(88);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "currentDelay:" + localkdm.aIa);
    }
    Object localObject = ((BaseChatPie)localObject).app.getHandler(ChatActivity.class);
    if (localkdm.aIa > 0)
    {
      ((MqqHandler)localObject).postDelayed(this.fI, localkdm.aIa * 1000);
      return;
    }
    cGT();
    this.bGN = false;
  }
  
  public void cGT()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[removeJDRedPackEntry]");
    }
    if (this.fj == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.fj.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.a() == null));
    localBaseChatPie.a().ciC();
  }
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ChatApolloViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  protected void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "TROOP, [onChangeUserApolloStatus], result:" + paramBoolean + ",data:" + paramObject);
    }
    if ((!paramBoolean) || (paramObject == null)) {}
    label50:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          break label50;
          do
          {
            return;
          } while (this.fj == null);
          localBaseChatPie = (BaseChatPie)this.fj.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.sessionInfo == null) || (localBaseChatPie.app == null));
        if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
          localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.onChangeUserApolloStatus(paramBoolean, paramObject);
        }
        MqqHandler localMqqHandler = localBaseChatPie.app.getHandler(ChatActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
      } while (!((String)paramObject.first).equals(localBaseChatPie.app.getCurrentUin()));
      QLog.i("ChatApolloViewListener", 1, "my cmshow status has changed, status:" + paramObject.second);
      if ((2 == ((Integer)paramObject.second).intValue()) || (((Integer)paramObject.second).intValue() == 0))
      {
        abrb.b(localBaseChatPie.getApp(), "cmshow_status", true);
        return;
      }
    } while (1 != ((Integer)paramObject.second).intValue());
    abrb.b(localBaseChatPie.getApp(), "cmshow_status", false);
    ApolloGameUtil.i(localBaseChatPie.app, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "request user game list");
    }
    ((abhe)localBaseChatPie.app.getManager(211)).cBE();
  }
  
  public void onClick(View paramView)
  {
    if (this.fj == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (BaseChatPie)this.fj.get();
      if ((localObject1 == null) || (((BaseChatPie)localObject1).app != null)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131368601: 
          if (((BaseChatPie)localObject1).jdField_a_of_type_Arhz == null)
          {
            int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627);
            ((BaseChatPie)localObject1).jdField_a_of_type_Arhz = new arhz(((BaseChatPie)localObject1).mContext, j);
          }
          ((BaseChatPie)localObject1).jdField_a_of_type_Arhz.setMessage(acfp.m(2131703598));
          ((BaseChatPie)localObject1).jdField_a_of_type_Arhz.show();
          cGT();
          Object localObject2 = (kdm)((BaseChatPie)localObject1).app.getManager(88);
          Object localObject3 = (aqrb)((BaseChatPie)localObject1).app.getBusinessHandler(71);
          if ((localObject2 != null) && (localObject3 != null))
          {
            ((aqrb)localObject3).Q(((kdm)localObject2).aHZ, ((BaseChatPie)localObject1).sessionInfo.cZ, ((BaseChatPie)localObject1).sessionInfo.troopUin);
            localObject2 = (kec)((BaseChatPie)localObject1).app.getBusinessHandler(88);
            localObject3 = Integer.toString(kdm.cS(((BaseChatPie)localObject1).sessionInfo.cZ));
            if ((((BaseChatPie)localObject1).sessionInfo.cZ == 1) || (((BaseChatPie)localObject1).sessionInfo.cZ == 3000)) {}
            for (localObject1 = ((BaseChatPie)localObject1).sessionInfo.aTl;; localObject1 = "")
            {
              ((kec)localObject2).a(134247331, "", (String)localObject3, (String)localObject1, Integer.toString(kdm.nf()), 0L, false);
              break;
            }
          }
          break;
        case 2131369970: 
          if (this.i != null)
          {
            this.i.dismiss();
            d(134247343, ((BaseChatPie)localObject1).app);
          }
          break;
        case 2131369791: 
          if (this.i != null)
          {
            this.i.dismiss();
            d(134247343, ((BaseChatPie)localObject1).app);
          }
          break;
        }
      }
    }
  }
  
  protected void onJDCheckRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDCheckRsp],result:" + paramBoolean + ",mIsAIOFinish:" + this.bGO + ",mChatPieRef:" + this.fj);
    }
    if (this.fj == null) {}
    do
    {
      do
      {
        return;
        paramObject = (BaseChatPie)this.fj.get();
        if (!paramBoolean) {
          break;
        }
      } while (this.bGO);
      cGS();
      return;
    } while ((paramObject == null) || (this.bGO));
    d(134247332, paramObject.app);
  }
  
  protected void onJDHongbaoRsp(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDHongbaoRsp],result:" + paramBoolean + ",data:" + paramObject + ",mIsAIOFinish:" + this.bGO);
    }
    if (this.fj == null) {}
    do
    {
      Object localObject;
      BaseChatPie localBaseChatPie;
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
                  return;
                  localObject = (BaseChatPie)this.fj.get();
                  if ((localObject != null) && (((BaseChatPie)localObject).jdField_a_of_type_Arhz != null)) {
                    ((BaseChatPie)localObject).jdField_a_of_type_Arhz.dismiss();
                  }
                  if ((!paramBoolean) && (!this.bGO))
                  {
                    QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131703600), 1).show();
                    return;
                  }
                } while (paramObject == null);
                if ((paramObject instanceof qqshop_act.SQQSHPActRsp)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ChatApolloViewListener", 2, "errInfo->Wrong data object.");
              return;
              paramObject = (qqshop_act.SQQSHPActRsp)paramObject;
              localObject = paramObject.act_show_info;
            } while ((localObject == null) || (this.fj == null));
            localBaseChatPie = (BaseChatPie)this.fj.get();
            int j = paramObject.code.get();
            if (QLog.isColorLevel()) {
              QLog.d("ChatApolloViewListener", 2, "errCode:" + j);
            }
            switch (j)
            {
            }
          } while (this.bGO);
          QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131703599), 1).show();
          return;
        } while ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null) || (this.bGO));
        a(localBaseChatPie.mActivity, (qqshop_act.SQQSHPActShowInfo)localObject, false);
        return;
      } while ((localBaseChatPie == null) || (localBaseChatPie.mActivity == null) || (this.bGO));
      a(localBaseChatPie.mActivity, (qqshop_act.SQQSHPActShowInfo)localObject, true);
      return;
    } while ((this.bGO) || (paramObject.act_info == null));
    Dm(paramObject.act_info.fail_pic.get());
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!apqw.isNumeric(paramString))) {
      QLog.w("ChatApolloViewListener", 1, "longTouch uin = null");
    }
    label23:
    BaseChatPie localBaseChatPie;
    Object localObject;
    do
    {
      do
      {
        do
        {
          break label23;
          do
          {
            return;
          } while (this.fj == null);
          localBaseChatPie = (BaseChatPie)this.fj.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.jdField_a_of_type_Abin == null) || (!localBaseChatPie.jdField_a_of_type_Abin.Yo()) || (localBaseChatPie.sessionInfo == null));
        if (!aqiw.isNetworkAvailable(localBaseChatPie.mContext))
        {
          ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690322), 1, localBaseChatPie.mContext);
          return;
        }
        localObject = abrj.a(localBaseChatPie.app);
        if (localObject == null) {
          break;
        }
        localObject = ((abrg)localObject).a();
      } while ((localObject != null) && (((abrh)localObject).Zg()));
      localObject = (abhh)localBaseChatPie.app.getManager(153);
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "long_press_avatar", localBaseChatPie.sessionInfo.aTl, ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ), 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      if (((abhh)localObject).cd(paramString) != 1)
      {
        ApolloItemBuilder.a(localBaseChatPie.mContext.getString(2131690381), 1, localBaseChatPie.mContext);
        return;
      }
    } while (abhh.h(localBaseChatPie.app, paramString) == 2);
    if (localBaseChatPie.sessionInfo.cZ == 0) {
      localObject = aqgv.D(localBaseChatPie.app, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onLoncClick uin = " + paramString + " ,nickName =" + (String)localObject);
      }
      localBaseChatPie.jdField_a_of_type_Abin.stopRender();
      Intent localIntent = new Intent(localBaseChatPie.mActivity, ApolloGuestsStateActivity.class);
      localIntent.putExtra("extra_guest_uin", paramString);
      localIntent.putExtra("extra_guest_nick", (String)localObject);
      localIntent.putExtra("extra_guest_from", ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ));
      localBaseChatPie.mActivity.startActivity(localIntent);
      return;
      if (localBaseChatPie.sessionInfo.cZ == 1) {
        localObject = aqgv.o(localBaseChatPie.app, localBaseChatPie.sessionInfo.aTl, paramString);
      } else if (localBaseChatPie.sessionInfo.cZ == 3000) {
        localObject = aqgv.b(localBaseChatPie.app, paramString, true);
      } else {
        localObject = "";
      }
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (this.fj == null) {}
    BaseChatPie localBaseChatPie;
    int j;
    do
    {
      boolean bool;
      int k;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localBaseChatPie = (BaseChatPie)this.fj.get();
            } while ((localBaseChatPie == null) || (localBaseChatPie.app == null) || (localBaseChatPie.jdField_a_of_type_Abin == null) || (!localBaseChatPie.jdField_a_of_type_Abin.Yo()) || (localBaseChatPie.sessionInfo == null));
            if (paramInt == 7)
            {
              localObject = (abhe)localBaseChatPie.app.getManager(211);
              if (((abhe)localObject).coA != -1)
              {
                ApolloGameUtil.a(localBaseChatPie.app, ((abhe)localObject).coA, 0L, 0, "", 321, null);
                return;
              }
              if (((abhe)localObject).a != null)
              {
                localObject = ((abhe)localObject).a.a();
                if ((localObject != null) && ((((DrawerPushItem)localObject).msg_type == 10) || (((DrawerPushItem)localObject).msg_type == 7))) {
                  abhh.t(102, String.valueOf(((DrawerPushItem)localObject).tianshuAdId), ((DrawerPushItem)localObject).tianshuTraceInfo);
                }
              }
            }
            Object localObject = abrj.a(localBaseChatPie.app);
            if (localObject != null) {
              ((abqt)localObject).A(abrj.ge(paramInt), null, paramString);
            }
            paramString = (abrg)localBaseChatPie.app.getManager(249);
          } while (paramString == null);
          paramString = paramString.a();
        } while (paramString == null);
        j = paramString.zT();
        paramString = localBaseChatPie.app.getApp().getSharedPreferences("apollo_sp", 0);
        bool = paramString.getBoolean("is_add_new_game" + localBaseChatPie.app.getCurrentAccountUin(), false);
        k = paramString.getInt("new_added_game_id" + localBaseChatPie.app.getCurrentAccountUin(), -1);
        if (9 == paramInt) {
          VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "click_action_hotspot", ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ), 0, new String[0]);
        }
        if (j != 1) {
          break;
        }
      } while ((!bool) || (-1 == k));
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "avatar_clk_togame", ApolloUtil.gi(localBaseChatPie.sessionInfo.cZ), 1, new String[] { String.valueOf(k) });
      paramString.edit().remove("is_add_new_game" + localBaseChatPie.app.getCurrentAccountUin()).commit();
      return;
    } while ((j != 2) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.cGC();
  }
  
  protected void onQueryUserApolloAction(boolean paramBoolean, Object paramObject)
  {
    if (this.fj == null)
    {
      abhh.bCz = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.fj.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.onQueryUserApolloAction(paramBoolean, paramObject);
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[TraceReport onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.fj.get();
    if (localBaseChatPie == null) {
      return;
    }
    abrg localabrg = (abrg)localBaseChatPie.app.getManager(249);
    if (localabrg.a() != null) {
      abwh.a(abrj.gf(localabrg.a().cqU), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (!localBaseChatPie.jdField_a_of_type_Abin.bDf)
    {
      abyy.Df("TraceReport_initApolloSurfaceView_PreLoadJS");
      ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
      return;
    }
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbh
 * JD-Core Version:    0.7.0.1
 */