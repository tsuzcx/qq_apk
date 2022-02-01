package com.tencent.biz.qrcode.activity;

import acdt;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import ashy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.TicketManager;
import rtu;
import rwt;

class QRDisplayActivity$4
  implements Runnable
{
  QRDisplayActivity$4(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void run()
  {
    int k = 0;
    int i = (int)(20.0F * QRDisplayActivity.a(this.this$0));
    int m = this.this$0.mScrollView.getWidth() - i * 2;
    int n = this.this$0.mScrollView.getHeight() - i * 2;
    int j = 540;
    i = 740;
    Object localObject1;
    switch (this.this$0.type)
    {
    default: 
      if ((m >= j) && (n >= i))
      {
        this.this$0.bvt = j;
        this.this$0.bvu = i;
        if (this.this$0.cT == null) {
          ThreadManager.post(new QRDisplayActivity.4.1(this), 8, null, false);
        }
        if (((this.this$0.type != 2) || (this.this$0.cT == null)) || (this.this$0.O == null))
        {
          this.this$0.O = new Bundle();
          this.this$0.O.putInt("bkgRes", 0);
          this.this$0.O.putInt("nameClr", -16777216);
          this.this$0.O.putInt("tipsClr", -8947849);
          this.this$0.O.putInt("B", -16777216);
          this.this$0.O.putInt("W", 16777215);
          this.this$0.O.putParcelable("qrloc", new Rect(45, 76, 495, 526));
          this.this$0.O.putInt("head", 1);
        }
        if (this.this$0.type == 5) {
          break label808;
        }
        if (this.this$0.type == 11)
        {
          localObject1 = this.this$0.getIntent().getStringExtra("url");
          this.this$0.u(this.this$0.uin, this.this$0.type, (String)localObject1);
        }
        if (this.this$0.jdField_a_of_type_Lk == null) {
          this.this$0.jdField_a_of_type_Lk = this.this$0.b(this.this$0.uin, this.this$0.type, -1);
        }
        if ((this.this$0.jdField_a_of_type_Lk == null) || (this.this$0.type == 2)) {
          break label615;
        }
        this.this$0.bwD();
      }
      break;
    }
    for (;;)
    {
      this.this$0.pm.post(this.this$0.dz);
      return;
      j = 550;
      i = 844;
      break;
      if (m * j < n * j) {
        this.this$0.bvt = m;
      }
      for (this.this$0.bvu = ((int)(m / j * i));; this.this$0.bvu = n)
      {
        localObject1 = this.this$0.nC.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.this$0.bvt;
        ((ViewGroup.LayoutParams)localObject1).height = this.this$0.bvu;
        this.this$0.nC.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.this$0.pn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).width = this.this$0.bvt;
        ((ViewGroup.LayoutParams)localObject1).height = this.this$0.bvu;
        this.this$0.pn.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        this.this$0.bvt = ((int)(n / i * j));
      }
      label615:
      if (QLog.isDevelopLevel()) {
        QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
      }
      Object localObject2 = this.this$0.getIntent();
      if (this.this$0.isQidianPrivateTroop)
      {
        localObject1 = ((Intent)localObject2).getStringExtra("groupOwner");
        ((ashy)this.this$0.app.getBusinessHandler(85)).iQ(this.this$0.uin, (String)localObject1);
        return;
      }
      Object localObject3 = (TicketManager)this.this$0.app.getManager(2);
      localObject1 = this.this$0.app.getAccount();
      localObject3 = ((TicketManager)localObject3).getSkey((String)localObject1);
      String str = ((Intent)localObject2).getStringExtra("uin");
      i = ((Intent)localObject2).getIntExtra("type", 1);
      localObject2 = new QRDisplayActivity.d(null);
      ((QRDisplayActivity.d)localObject2).activityRef = new WeakReference(this.this$0);
      ((QRDisplayActivity.d)localObject2).uinType = i;
      ((QRDisplayActivity.d)localObject2).aCy = str;
      rwt.a(this.this$0.app, this.this$0, str, i, (String)localObject1, (String)localObject3, 0, (rtu)localObject2);
      continue;
      label808:
      localObject1 = this.this$0.getSharedPreferences("qrcode", 0);
      this.this$0.mValidTime = ((SharedPreferences)localObject1).getLong("discussionvalidtime" + this.this$0.uin, 0L);
      this.this$0.aCs = ((SharedPreferences)localObject1).getString("discussion" + this.this$0.uin, null);
      this.this$0.aCt = ((SharedPreferences)localObject1).getString("discussionfullSig" + this.this$0.uin, null);
      i = k;
      if (this.this$0.mValidTime - System.currentTimeMillis() / 1000L > 0L) {
        i = 1;
      }
      this.this$0.findViewById(2131375327).setOnClickListener(this.this$0);
      if ((this.this$0.aCs == null) || (this.this$0.aCt == null) || (i == 0)) {
        break label1059;
      }
      ((TextView)this.this$0.findViewById(2131374349)).setText(this.this$0.aCs);
      this.this$0.jdField_a_of_type_Lk = rwt.a(this.this$0.aCs, -1);
      this.this$0.bwD();
    }
    label1059:
    if (QLog.isDevelopLevel()) {
      QLog.d("QRDisplayActivity", 4, "qrcode url not valid");
    }
    this.this$0.jdField_a_of_type_Acdt.ah(Long.parseLong(this.this$0.uin), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.4
 * JD-Core Version:    0.7.0.1
 */