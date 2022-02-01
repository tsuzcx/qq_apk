package com.tencent.mobileqq.activity.contact.newfriend;

import achq;
import acrp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import anot;
import anzd;
import aqiw;
import arhz;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;
import ytm;
import ytn;

public class SystemRequestInfoView
  extends LinearLayout
  implements View.OnClickListener
{
  private long Fg;
  private long Fh;
  private achq jdField_a_of_type_Achq = new ytm(this);
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private String aKN;
  private final int bDP = 1017;
  int bDQ;
  Button cR;
  Button cS;
  Button en;
  public long lToMobile;
  private BaseActivity mActivity;
  private QQAppInterface mApp;
  private Intent mIntent;
  public arhz progressDialog;
  public String strNickName;
  byte[] vSig;
  
  public SystemRequestInfoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SystemRequestInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void Ey(int paramInt)
  {
    if (this.progressDialog == null)
    {
      this.progressDialog = new arhz(getContext(), getTitleBarHeight());
      this.progressDialog.setOnDismissListener(new ytn(this));
      this.progressDialog.setMessage(paramInt);
      this.progressDialog.setCanceledOnTouchOutside(false);
      this.progressDialog.setCancelable(false);
      this.progressDialog.show();
    }
  }
  
  public boolean Uj()
  {
    boolean bool = false;
    if (this.progressDialog != null)
    {
      bool = true;
      this.progressDialog.cancel();
      this.progressDialog = null;
    }
    return bool;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(getContext())) {
      QQToast.a(getContext(), getResources().getString(2131696270), 0).show(getTitleBarHeight());
    }
    label866:
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int k = 0;
      int j = 0;
      int i = 0;
      if (paramView == this.cR) {
        if (this.bDQ == -1011)
        {
          ((FriendListHandler)this.mApp.getBusinessHandler(1)).a(0, Long.parseLong(this.aKN), this.lToMobile, this.vSig, (byte)0, this.strNickName, this.Fh, this.Fg);
          i = 1;
          label113:
          anot.a(this.mApp, "CliOper", "", "", "0X800673B", "0X800673B", 0, 0, "", "", "", "");
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label866;
        }
        Ey(2131719519);
        break;
        long l1 = anzd.a().hf();
        Object localObject1 = anzd.a().a(Long.valueOf(l1));
        long l2;
        int m;
        int n;
        Object localObject2;
        if (localObject1 != null)
        {
          i = ((structmsg.StructMsg)localObject1).msg_type.get();
          l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
          l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
          j = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
          k = ((structmsg.StructMsg)localObject1).msg.src_id.get();
          m = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
          n = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
          localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
            ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
            ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
            structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
            localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
            localAddFrdSNInfo.uint32_set_sn.set(0);
            ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
            this.mApp.a().a().a(i, l1, l2, j, k, m, n, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false);
            i = 1;
            break label113;
          }
          localObject1 = new StringBuilder().append("agree, ");
          if (localObject2 != null) {}
          for (i = ((List)localObject2).size();; i = -1)
          {
            QLog.d("SystemRequestInfoView", 1, i);
            i = 0;
            break;
          }
        }
        QLog.d("SystemRequestInfoView", 1, "agree");
        break label113;
        if (paramView == this.cS)
        {
          l1 = anzd.a().hf();
          this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = anzd.a().a(Long.valueOf(l1));
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg != null)
          {
            i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get();
            l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
            l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
            k = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            m = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
            n = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
            int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
            localObject1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
            if ((localObject1 != null) && (1 < ((List)localObject1).size()))
            {
              this.mApp.a().a().a(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject1).get(1)).action_info.get(), 1, null, false);
              i = 1;
            }
          }
          for (;;)
          {
            anot.a(this.mApp, "CliOper", "", "", "0X800673A", "0X800673A", 0, 0, "", "", "", "");
            break;
            localObject2 = new StringBuilder().append("refuse, ");
            if (localObject1 != null) {}
            for (i = ((List)localObject1).size();; i = -1)
            {
              QLog.d("SystemRequestInfoView", 1, i);
              i = j;
              break;
            }
            QLog.d("SystemRequestInfoView", 1, "refuse");
            i = j;
          }
        }
        i = k;
        if (paramView == this.en)
        {
          localObject1 = new Intent(this.mIntent);
          ((Intent)localObject1).setClass(this.mActivity, AddRequestActivity.class);
          this.mActivity.startActivityForResult((Intent)localObject1, 1018);
          anot.a(this.mApp, "CliOper", "", "", "0X800673D", "0X800673D", 0, 0, "", "", "", "");
          i = k;
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView
 * JD-Core Version:    0.7.0.1
 */