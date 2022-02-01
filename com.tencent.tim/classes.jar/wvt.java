import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.2;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.b;
import mqq.os.MqqHandler;

public class wvt
  implements aluv, View.OnClickListener, XPanelContainer.b, wvs
{
  private aluq jdField_a_of_type_Aluq = new wvu(this);
  BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  AIOIceBreakShow jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow;
  private String aUf;
  QQAppInterface app;
  Context context;
  private int mSessionType;
  
  wvt(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.context = paramBaseChatPie.mContext;
    this.app = paramBaseChatPie.app;
  }
  
  private boolean j(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    int i = ((alur)this.app.getManager(285)).ai(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("checkNeedShowImmediately, sessionType: %s, sessionUin: %s, type: %s", new Object[] { Integer.valueOf(paramInt), paramString, Integer.valueOf(i) }));
    }
    if (i != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int[] C()
  {
    return new int[] { 3, 13, 7 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.i("IceBreak.HotPic", 1, "onMoveToState create.");
        } while (!aluu.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl));
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = new AIOIceBreakShow(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this.context, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.O(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().setOnGoingToShowPanelListener(this);
        localalur = (alur)this.app.getManager(285);
        localalur.a(this);
        localalur.a(this.jdField_a_of_type_Aluq);
        return;
        QLog.i("IceBreak.HotPic", 1, "onMoveToState destroy.");
      } while (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null);
      alur localalur = (alur)this.app.getManager(285);
      localalur.b(this);
      localalur.dJS();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow = null;
      return;
      QLog.i("IceBreak.HotPic", 1, "onMoveToState show first.");
      this.mSessionType = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
      this.aUf = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl;
    } while (TextUtils.isEmpty(this.aUf));
    if (j(this.mSessionType, this.aUf))
    {
      bb(true, true);
      return;
    }
    aluu.b(this.app, this.aUf, false, this.mSessionType);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Long paramLong)
  {
    if (!aluu.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onIceBreakResp suc=%b selfUin=%b frdUin=%b", new Object[] { Boolean.valueOf(paramBoolean), paramString1, paramString2 }));
      }
    } while ((!paramBoolean) || (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app.getCurrentAccountUin())) || (!paramString2.equals(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)));
    aluu.b(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, true, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ);
  }
  
  public void aW(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onAddIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl;
    if (!aluu.h(this.app, i, str)) {}
    while ((TextUtils.isEmpty(str)) || (!str.equals(paramString)) || (((!paramBoolean) || (!aluu.kW(i))) && ((paramBoolean) || (!aluu.kV(i))) && (!aluu.kX(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler().post(new IceBreakHelper.2(this));
  }
  
  public void aX(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IceBreakHelper", 2, String.format("onRemoveIceBreak uin: %s, isTroop: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl;
    if (!aluu.h(this.app, i, str)) {}
    while ((TextUtils.isEmpty(paramString)) || (!str.equals(paramString)) || (((!paramBoolean) || (!aluu.kW(i))) && ((paramBoolean) || (!aluu.kV(i))) && (!aluu.kX(i)))) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.getUIHandler().post(new IceBreakHelper.3(this));
  }
  
  public void bb(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.IceBreakingUtil", 2, String.format("updateIceBreakPokeShow bOnCreate=%b uin=%s, toShow=%s", new Object[] { Boolean.valueOf(paramBoolean1), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl, Boolean.valueOf(paramBoolean2) }));
    }
    if (paramBoolean2)
    {
      alur localalur = (alur)this.app.getManager(285);
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl;
      if (aluu.kV(i))
      {
        acff localacff = (acff)this.app.getManager(51);
        if ((this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null) && (localacff.isFriend(str)) && (!localalur.os(str))) {
          localalur.m(this.app.getCurrentUin(), 3, 1, str);
        }
      }
      do
      {
        do
        {
          return;
          if (!aluu.kW(i)) {
            break;
          }
        } while (localalur.ot(str));
        localalur.m(this.app.getCurrentUin(), 3, 2, str);
        return;
      } while ((!aluu.kX(i)) || (localalur.ou(str)));
      localalur.m(this.app.getCurrentUin(), 3, 1, str);
      return;
    }
    this.jdField_a_of_type_Aluq.w(true, null);
  }
  
  public void fE(int paramInt1, int paramInt2)
  {
    if ((!aluu.h(this.app, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.cZ, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.sessionInfo.aTl)) || (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, String.format("onGoingToShowPanel old=%d new=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vm() != 0) || (paramInt2 == 0));
    this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.Og(true);
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131369276) && (this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.IceBreakingUtil", 2, "onClick inputCustomClickLisenter");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.vm() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqRelationxIcebreakingAIOIceBreakShow.Og(true);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wvt
 * JD-Core Version:    0.7.0.1
 */