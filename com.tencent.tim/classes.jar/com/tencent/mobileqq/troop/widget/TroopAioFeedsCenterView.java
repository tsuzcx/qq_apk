package com.tencent.mobileqq.troop.widget;

import acfp;
import ajdr;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import apbo;
import apmp;
import apvr;
import aqiw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import jll;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements Observer
{
  protected apbo a;
  protected apvr a;
  protected boolean cSI;
  protected LinearLayout lc;
  protected QQAppInterface mApp;
  protected Context mContext;
  protected SessionInfo mSessionInfo;
  protected RelativeLayout mr;
  protected TextView ni;
  
  public TroopAioFeedsCenterView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131561380, this);
  }
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, apmp paramapmp)
  {
    super(paramContext);
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mSessionInfo = paramSessionInfo;
    this.cSI = paramBoolean;
    ajdr localajdr = (ajdr)paramQQAppInterface.getManager(37);
    try
    {
      this.jdField_a_of_type_Apbo = localajdr.a(Long.valueOf(Long.parseLong(paramSessionInfo.aTl)), true);
      this.jdField_a_of_type_Apbo.addObserver(this);
      this.jdField_a_of_type_Apvr = new apvr(this.mApp, this.mContext, this.mSessionInfo, this.jdField_a_of_type_Apbo, paramapmp);
      a(paramQQAppInterface, paramContext);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAioFeedsCenterView", 2, paramSessionInfo.toString());
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    inflate(paramContext, 2131560758, this);
    this.mr = ((RelativeLayout)findViewById(2131366987));
    this.lc = ((LinearLayout)findViewById(2131379738));
    this.ni = ((TextView)findViewById(2131379724));
    if (aqiw.isNetSupport(this.mContext))
    {
      this.ni.setText(acfp.m(2131715515));
      return;
    }
    this.ni.setText(acfp.m(2131715526));
  }
  
  public void Sn(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Apbo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mr.setVisibility(8);
      this.lc.setVisibility(0);
      this.ni.setText(acfp.m(2131715524));
    }
    this.jdField_a_of_type_Apvr.ecm();
    this.jdField_a_of_type_Apbo.Wz(1000);
  }
  
  void Xg(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_Apbo == null) || (paramInt >= this.jdField_a_of_type_Apbo.mItems.size())) {}
    label468:
    for (;;)
    {
      return;
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)this.jdField_a_of_type_Apbo.mItems.get(paramInt);
      if (localTroopFeedItem != null)
      {
        int i = localTroopFeedItem.type;
        String str;
        if (paramInt == 0)
        {
          str = "0";
          switch (i)
          {
          }
        }
        for (;;)
        {
          if (!localTroopFeedItem.isStoryType()) {
            break label468;
          }
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.mSessionInfo.aTl, "", "", "");
          return;
          str = "1";
          break;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.mSessionInfo.aTl, str, "", "");
          continue;
          anot.a(this.mApp, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.mSessionInfo.aTl, str, localTroopFeedItem.ex_1, "");
        }
      }
    }
  }
  
  public View b(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Apbo == null) || (this.jdField_a_of_type_Apbo.mItems.size() <= paramInt)) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      localObject = (TroopFeedItem)this.jdField_a_of_type_Apbo.mItems.get(paramInt);
      localView = this.jdField_a_of_type_Apvr.a((TroopFeedItem)localObject, paramInt, true);
      localObject = localView;
    } while (localView == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(localView, 0);
    paramInt = (int)jll.dp2px(this.mContext, 15.0F);
    paramViewGroup.setPadding(paramInt, 0, paramInt, 0);
    return localView;
  }
  
  public void destory()
  {
    if (this.jdField_a_of_type_Apbo != null) {
      this.jdField_a_of_type_Apbo.deleteObserver(this);
    }
  }
  
  public void eci()
  {
    if (this.jdField_a_of_type_Apbo == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioFeedsCenterView.troop.notification_center.auto_pull_down", 2, "doAutoPullDownLogic");
    }
    this.mr.setVisibility(8);
    this.lc.setVisibility(0);
    this.ni.setText(acfp.m(2131715522));
    this.jdField_a_of_type_Apbo.Wz(1002);
  }
  
  public void ecj()
  {
    this.mr.setVisibility(8);
    this.lc.setVisibility(0);
    this.ni.setText(acfp.m(2131715528));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i;
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 105)) {
        break label143;
      }
      if (this.jdField_a_of_type_Apbo != null) {
        break label92;
      }
      i = 0;
      if (i != 0) {
        break label108;
      }
      this.mr.setVisibility(8);
      this.lc.setVisibility(0);
      this.ni.setText(acfp.m(2131715516));
      label73:
      if (this.mr.getVisibility() == 0) {
        this.mr.requestFocus();
      }
    }
    label92:
    label108:
    do
    {
      return;
      i = this.jdField_a_of_type_Apbo.mItems.size();
      break;
      this.mr.setVisibility(0);
      this.lc.setVisibility(8);
      b(this.mr, 0);
      Xg(0);
      break label73;
      if (paramObservable.intValue() == 103)
      {
        this.mr.setVisibility(8);
        this.lc.setVisibility(0);
        if (aqiw.isNetSupport(this.mContext))
        {
          this.ni.setText(acfp.m(2131715525));
          return;
        }
        this.ni.setText(acfp.m(2131715514));
        return;
      }
    } while (paramObservable.intValue() != 1010);
    label143:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */