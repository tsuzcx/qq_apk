package com.tencent.biz.qrcode.activity;

import acof;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import anot;
import aqha;
import aqju;
import arhz;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import jqc;
import mqq.manager.WtloginManager;
import mqq.observer.WtloginObserver;
import rvd;
import rve;
import rvf;
import rvg;
import rvx;
import rwr;
import rwt;

public class QRLoginAuthActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener
{
  static final short[] base64_reverse_table_url = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  public long Cx;
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager;
  private WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new rvd(this);
  protected String aCC;
  public String aCD;
  public String aCE;
  protected String aCF;
  public String aCG;
  public boolean aJS;
  private boolean aJT;
  protected boolean aJU;
  public int appType = -1;
  protected byte[] bM;
  public int bvy;
  public Handler bx = new rvg(this);
  protected Button cA;
  public Button cB;
  protected RelativeLayout fY;
  public LinearLayout fg;
  public arhz mProgress;
  public ImageView nL;
  public ProgressBar progressBar;
  public String userAccount;
  public TextView zx;
  public TextView zy;
  
  public static byte[] base64_decode_url(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = base64_reverse_table_url[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  protected void bwS()
  {
    if (super.isFinishing()) {
      return;
    }
    Object localObject = super.getIntent();
    this.aCC = ((Intent)localObject).getStringExtra("QR_CODE_STRING");
    this.aJT = ((Intent)localObject).getBooleanExtra("KEY_QR_CODE_EXPIRED", false);
    int i = this.aCC.indexOf("?k=") + 3;
    localObject = this.aCC.substring(i, i + 32);
    this.bM = base64_decode_url(((String)localObject).getBytes(), ((String)localObject).length());
    this.aCF = this.aCC.substring(this.aCC.indexOf("&f=") + 3);
    localObject = this.jdField_a_of_type_MqqManagerWtloginManager;
    String str = this.userAccount;
    byte[] arrayOfByte = this.bM;
    WtloginObserver localWtloginObserver = this.jdField_a_of_type_MqqObserverWtloginObserver;
    ((WtloginManager)localObject).VerifyCode(str, 16L, true, arrayOfByte, new int[] { 3, 5, 32, 53 }, 1, localWtloginObserver);
  }
  
  public void bwT()
  {
    if (!isFinishing())
    {
      localIntent = new Intent(this, SplashActivity.class);
      localIntent.putExtra("tab_index", MainFragment.bIk);
      localIntent.setFlags(67108864);
      super.startActivity(localIntent);
    }
    Toast.makeText(getApplicationContext(), 2131719034, 0).show();
    if ((!TextUtils.isEmpty(this.aCF)) && ("1600000104".equals(this.aCF.trim())))
    {
      localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
      localIntent.putExtra("loginInfo", this.aCE);
      localIntent.putExtra("loginAppId", this.aCF);
      localIntent.putExtra("status", "login");
      super.sendBroadcast(localIntent);
      return;
    }
    Intent localIntent = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    localIntent.putExtra("loginInfo", this.aCE);
    localIntent.putExtra("status", "login");
    localIntent.putExtra("bannerTips", this.aCG);
    localIntent.putExtra("subappid", this.Cx);
    localIntent.putExtra("appType", this.appType);
    super.sendBroadcast(localIntent);
  }
  
  public void doOnBackPressed()
  {
    super.doOnBackPressed();
    this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.bM);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.userAccount = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_MqqManagerWtloginManager = ((WtloginManager)this.app.getManager(1));
    this.nM.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginAuthActivity", 2, "wtloginManager:" + this.jdField_a_of_type_MqqManagerWtloginManager + " isLogin:" + this.app.isLogin());
    }
    if (this.app.isLogin())
    {
      bwS();
      return true;
    }
    sM(null);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing())) {
      this.mProgress.dismiss();
    }
    super.doOnDestroy();
    rvx.cJ(this);
  }
  
  protected void initUI()
  {
    super.setContentView(2131560591);
    this.fY = ((RelativeLayout)super.findViewById(2131370898));
    this.fg = ((LinearLayout)super.findViewById(2131375285));
    this.cA = ((Button)super.findViewById(2131365220));
    this.cB = ((Button)super.findViewById(2131379886));
    this.zx = ((TextView)super.findViewById(2131371087));
    this.zy = ((TextView)super.findViewById(2131373521));
    this.nL = ((ImageView)super.findViewById(2131365818));
    this.progressBar = ((ProgressBar)super.findViewById(2131375286));
    this.cA.setOnClickListener(this);
    this.cB.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131365220) {
      if (this.aJU)
      {
        Intent localIntent = new Intent(this, ScannerActivity.class);
        localIntent.setFlags(67108864);
        startActivity(localIntent);
        if (this.aJT) {
          finish();
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      un(false);
      anot.a(null, "dc00898", "", "", "0X800A46E", "0X800A46E", rwr.en(this.appType), 0, "", "", "", "");
      continue;
      if (i == 2131379886)
      {
        un(true);
        anot.a(null, "dc00898", "", "", "0X800A46F", "0X800A46F", rwr.en(this.appType), 0, "", "", "", "");
      }
      else if (i == 2131370344)
      {
        finish();
        this.jdField_a_of_type_MqqManagerWtloginManager.cancelCode(getCurrentAccountUin(), 16L, this.bM);
      }
    }
  }
  
  public void sM(String paramString)
  {
    if (isFinishing()) {
      return;
    }
    Object localObject;
    if (!jqc.ak(this))
    {
      localObject = aqha.a(this, 230);
      ((aqju)localObject).setMessage(2131719035);
      ((aqju)localObject).setPositiveButton(2131721079, new rvf(this));
      ((aqju)localObject).show();
    }
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = getString(2131719033);
    }
    this.nL.setVisibility(0);
    this.nL.setImageDrawable(getResources().getDrawable(2130840192));
    this.zx.setVisibility(8);
    this.zy.setText((CharSequence)localObject);
    this.aJU = true;
    this.cA.setText(2131719032);
    this.cB.setVisibility(8);
  }
  
  protected void un(boolean paramBoolean)
  {
    ((acof)this.app.getManager(85)).cNf();
    this.mProgress = new arhz(this, super.getTitleBarHeight());
    this.mProgress.setMessage(2131717230);
    this.mProgress.setOnCancelListener(new rve(this));
    this.mProgress.show();
    Object localObject1 = rwt.longToBytes(this.app.eV());
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putShort((short)2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    ((ByteBuffer)localObject2).put((byte[])localObject1);
    localObject2 = ((ByteBuffer)localObject2).array();
    Object localObject3 = this.app.jm(this.userAccount);
    localObject1 = new ArrayList();
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(this.userAccount)))
    {
      localObject3 = ((String)localObject3).getBytes();
      ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)1);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      localByteBuffer = ByteBuffer.allocate(localObject3.length + 4);
      localByteBuffer.putShort((short)4);
      localByteBuffer.putShort((short)localObject3.length);
      localByteBuffer.put((byte[])localObject3);
      localObject3 = localByteBuffer.array();
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject3));
      localObject2 = ByteBuffer.allocate(8);
      ((ByteBuffer)localObject2).putShort((short)21);
      ((ByteBuffer)localObject2).putShort((short)4);
      if (!paramBoolean) {
        break label354;
      }
    }
    label354:
    for (int i = 1;; i = 0)
    {
      ((ByteBuffer)localObject2).putInt(i);
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr(((ByteBuffer)localObject2).array()));
      this.jdField_a_of_type_MqqManagerWtloginManager.CloseCode(this.userAccount, 16L, this.bM, 1, (ArrayList)localObject1, this.jdField_a_of_type_MqqObserverWtloginObserver);
      return;
      ((ArrayList)localObject1).add(HexUtil.bytes2HexStr((byte[])localObject2));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginAuthActivity
 * JD-Core Version:    0.7.0.1
 */