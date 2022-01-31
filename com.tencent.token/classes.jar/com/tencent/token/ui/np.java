package com.tencent.token.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.af;
import com.tencent.token.core.bean.CommonImgResult;
import com.tencent.token.core.bean.JLProtectionInfo;
import com.tencent.token.core.bean.JLProtectionInfo.ActivityItem;
import com.tencent.token.core.bean.JLProtectionInfo.ProtectionInfoItem;
import com.tencent.token.global.d;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.HorizontialListView;
import com.tencent.token.ui.base.SecondVerifyDialog;
import java.util.ArrayList;

final class np
  extends bo
{
  np(JianLingActivity paramJianLingActivity)
  {
    super(paramJianLingActivity);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 0;
    int j = 0;
    if (this.a.isFinishing()) {}
    for (;;)
    {
      return;
      e.b("jianling what=" + paramMessage.what + ", arg1=" + paramMessage.arg1);
      Object localObject;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 1010: 
      case 1012: 
        this.a.m2VerifyQuerying = false;
        if (3 == paramMessage.arg1)
        {
          j = this.a.m2VerifyItem.id;
          if (this.a.m2VerifyItem.value != 1) {}
        }
        break;
      case 1011: 
        for (i = 0;; i = 1)
        {
          paramMessage = af.a();
          localObject = this.a.mHandler;
          paramMessage.a(0L, new int[] { j }, new int[] { i }, "", (Handler)localObject);
          return;
          if (3 != paramMessage.arg1) {
            break;
          }
          paramMessage = new SecondVerifyDialog(this.a, this.a.mHandler, paramMessage.arg1);
          paramMessage.setCancelable(true);
          paramMessage.show();
          return;
        }
      case 3048: 
        if (paramMessage.arg1 == 0)
        {
          this.a.hideTip();
          this.a.mInfo = ((JLProtectionInfo)paramMessage.obj);
          if (this.a.mInfo != null)
          {
            JianLingActivity.access$000(this.a).setText(this.a.mInfo.recommandName);
            JianLingActivity.access$100(this.a).setText(this.a.mInfo.recommandDesc);
            JianLingActivity.access$200(this.a).setVisibility(0);
            JianLingActivity.access$200(this.a).removeAllViews();
            i = 0;
            while (i <= this.a.mInfo.protectionInfoItem.size())
            {
              paramMessage = LayoutInflater.from(this.a).inflate(2130903110, null);
              this.a.initListItem(paramMessage, i);
              JianLingActivity.access$200(this.a).addView(paramMessage);
              i += 1;
            }
            if (this.a.mInfo.activityItem.size() > 0) {
              JianLingActivity.access$300(this.a).setVisibility(0);
            }
            while (this.a.mLiBaoImgs == null)
            {
              this.a.mLiBaoImgs = new Bitmap[this.a.mInfo.activityItem.size()];
              i = j;
              while (i < this.a.mInfo.activityItem.size())
              {
                paramMessage = (JLProtectionInfo.ActivityItem)this.a.mInfo.activityItem.get(i);
                af.a().b(paramMessage.picURL, this.a.mHandler);
                this.a.mLiBaoImgs[i] = null;
                i += 1;
              }
              JianLingActivity.access$300(this.a).setVisibility(4);
              JianLingActivity.access$400(this.a).setVisibility(4);
            }
          }
        }
        else
        {
          paramMessage = (d)paramMessage.obj;
          d.a(this.a.getResources(), paramMessage);
          e.c("game lock load failed:" + paramMessage.a + "-" + paramMessage.b);
          if ((111 == paramMessage.a) || (110 == paramMessage.a) || (103 == paramMessage.a))
          {
            this.a.showTip(paramMessage.a, JianLingActivity.access$500(this.a), JianLingActivity.access$600(this.a), true);
            return;
          }
          this.a.showTip(paramMessage.a, paramMessage.c, null, false);
          return;
        }
        break;
      case 3050: 
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (CommonImgResult)paramMessage.obj;
          i = 0;
          while (i < this.a.mInfo.activityItem.size())
          {
            localObject = (JLProtectionInfo.ActivityItem)this.a.mInfo.activityItem.get(i);
            if (paramMessage.mUrl.equals(((JLProtectionInfo.ActivityItem)localObject).picURL)) {
              this.a.mLiBaoImgs[i] = paramMessage.mBmp;
            }
            i += 1;
          }
          i = 0;
          while ((i < this.a.mLiBaoImgs.length) && (this.a.mLiBaoImgs[i] != null)) {
            i += 1;
          }
          if (i == this.a.mLiBaoImgs.length)
          {
            JianLingActivity.access$400(this.a).setVisibility(0);
            JianLingActivity.access$700(this.a).notifyDataSetChanged();
            return;
          }
        }
        break;
      case 3018: 
        if (paramMessage.arg1 == 0)
        {
          paramMessage = (int[])paramMessage.obj;
          i = 0;
          while (i < paramMessage.length)
          {
            j = 0;
            if (j < this.a.mInfo.protectionInfoItem.size())
            {
              localObject = (JLProtectionInfo.ProtectionInfoItem)this.a.mInfo.protectionInfoItem.get(j);
              if (paramMessage[i] == ((JLProtectionInfo.ProtectionInfoItem)localObject).id) {
                if (((JLProtectionInfo.ProtectionInfoItem)localObject).value != 0) {
                  break label946;
                }
              }
              label946:
              for (int k = 1;; k = 0)
              {
                ((JLProtectionInfo.ProtectionInfoItem)localObject).value = k;
                ((JLProtectionInfo.ProtectionInfoItem)localObject).busy = false;
                j += 1;
                break;
              }
            }
            i += 1;
          }
          af.a().a(0L, this.a.mHandler, this.a);
          return;
        }
        paramMessage = (d)paramMessage.obj;
        d.a(this.a.getResources(), paramMessage);
        this.a.showUserDialog(2131361808, paramMessage.c, 2131361800, null);
        JianLingActivity.access$200(this.a).removeAllViews();
        while (i <= this.a.mInfo.protectionInfoItem.size())
        {
          paramMessage = LayoutInflater.from(this.a).inflate(2130903110, null);
          this.a.initListItem(paramMessage, i);
          JianLingActivity.access$200(this.a).addView(paramMessage);
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.np
 * JD-Core Version:    0.7.0.1
 */