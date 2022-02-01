package dov.com.qq.im.capture.music.humrecognition;

import acfp;
import alwc;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import auru;
import axov;
import axrh;
import axro;
import axrq;
import axrr;
import axru;
import axrv;
import axrw;
import axrx;
import axry;
import axrz;
import axsa;
import axsb;
import axse;
import axsf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class HummingActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, axrq
{
  private ImageView ID;
  public axrh a;
  private axsb a;
  private TextView ahw;
  private TextView ahx;
  private auru jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
  private axro jdField_b_of_type_Axro = (axro)axov.a().c(8);
  private axsf jdField_b_of_type_Axsf = (axsf)axov.a().c(10);
  private AudioCapture jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture;
  private Animation bh;
  private boolean dwq = true;
  private boolean dwr;
  private int eGP;
  private int eGQ = 1;
  private Handler ej;
  private MusicItemInfo f;
  private Button hX;
  private Button hY;
  private Button hZ;
  private Runnable iP;
  
  public HummingActivity()
  {
    this.jdField_a_of_type_Axrh = new axru(this);
  }
  
  private void YW(boolean paramBoolean)
  {
    eOx();
    if (paramBoolean)
    {
      startRecord();
      QQToast.a(this, 2131700424, 0).show();
      if (this.eGQ == 1) {
        oe(3000L);
      }
      while (this.eGQ != 2) {
        return;
      }
      oe(7000L);
      return;
    }
    this.ej.removeCallbacks(this.iP);
    this.iP = null;
  }
  
  private void eOt()
  {
    this.iP = new HummingActivity.2(this);
  }
  
  private void eOu()
  {
    this.ID = ((ImageView)findViewById(2131364390));
    this.ID.setOnClickListener(new axrv(this));
    this.hX = ((Button)findViewById(2131364005));
    this.hX.setBackgroundResource(2130839524);
    this.hY = ((Button)findViewById(2131364040));
    this.hY.setBackgroundResource(2130839564);
    this.hZ = ((Button)findViewById(2131363891));
    this.ahw = ((TextView)findViewById(2131379586));
    this.ahw.setText(2131700411);
    this.ahx = ((TextView)findViewById(2131379591));
    this.ahx.setText(2131700414);
    setTitle(2131700421);
    this.bh = AnimationUtils.loadAnimation(this, 2130772293);
    this.hX.setOnClickListener(new axrw(this));
    this.hY.setOnClickListener(new axrx(this));
    this.hZ.setOnClickListener(new axry(this));
  }
  
  private void eOv()
  {
    this.dwq = true;
    eOw();
  }
  
  private void eOw()
  {
    YW(this.dwq);
    if (this.dwq)
    {
      this.ID.startAnimation(this.bh);
      if ((this.jdField_a_of_type_Axsb instanceof axrz))
      {
        this.ahw.setText(2131700412);
        this.ahx.setText(2131700415);
        label54:
        if (this.dwq) {
          break label112;
        }
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      this.dwq = bool;
      return;
      if (!(this.jdField_a_of_type_Axsb instanceof axsa)) {
        break;
      }
      this.ahw.setText(2131700413);
      break;
      this.ahw.setText("");
      this.ahx.setText(2131700414);
      break label54;
    }
  }
  
  private void eOx()
  {
    stopRecord();
    this.eGP = 0;
    this.dwr = false;
    if (this.ej != null) {
      this.ej.removeCallbacksAndMessages(null);
    }
    this.iP = null;
    this.ID.clearAnimation();
    this.ahx.setText(2131700414);
  }
  
  private void eOy()
  {
    this.hZ.setVisibility(8);
    this.ID.setVisibility(0);
    this.ahx.setVisibility(0);
  }
  
  private void eOz()
  {
    eOy();
    if (this.eGQ == 1)
    {
      this.jdField_a_of_type_Axsb = new axrz();
      setTitle(2131700421);
      this.ahw.setText(2131700412);
      this.hX.setBackgroundResource(2130839524);
      this.hY.setBackgroundResource(2130839564);
    }
    for (;;)
    {
      eOv();
      return;
      if (this.eGQ == 2)
      {
        this.jdField_a_of_type_Axsb = new axsa();
        setTitle(2131700422);
        this.ahw.setText(2131700413);
        this.hX.setBackgroundResource(2130839564);
        this.hY.setBackgroundResource(2130839524);
      }
    }
  }
  
  private void j(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    ((QIMMusicConfigManager)axov.a().c(2)).a(paramMusicItemInfo, true);
  }
  
  private void oe(long paramLong)
  {
    eOt();
    if (this.ej == null) {
      this.ej = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.ej.postDelayed(this.iP, paramLong);
  }
  
  private void startRecord()
  {
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.dJZ();
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.startRecord();
  }
  
  private void stopRecord()
  {
    HummingActivity.7 local7;
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.dKa();
      this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.stopRecord();
      if (this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b != null)
      {
        local7 = new HummingActivity.7(this, this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture.b.wX());
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break label67;
        }
        ThreadManager.post(local7, 5, null, false);
      }
    }
    return;
    label67:
    local7.run();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558489);
    this.jdField_b_of_type_Axsf.a(this);
    this.jdField_a_of_type_Axsb = new axrz();
    this.jdField_b_of_type_ComTencentMobileqqRichmediaCaptureAudioAudioCapture = new AudioCapture(axse.cVT, 1, 8000, 16, 2, null, null);
    eOu();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_b_of_type_Axsf.b(this);
    eOx();
    this.jdField_a_of_type_Axrh = null;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.eGP = 0;
    this.dwr = false;
    eOx();
  }
  
  public void doOnStart()
  {
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    eOx();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 3: 
    default: 
    case 1: 
      do
      {
        return false;
        paramMessage = (MusicItemInfo)paramMessage.obj;
        if (paramMessage != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("HUM_HummingActivity", 2, "handleMessage: humMusicItemInfo = " + paramMessage);
      return false;
      if (!paramMessage.mHasCopyright)
      {
        QQToast.a(this, 0, acfp.m(2131707325) + paramMessage.mMusicName + acfp.m(2131707326), 0).show();
        return false;
      }
      this.ahw.setText("");
      this.hZ.setText(acfp.m(2131707327) + axrr.a(paramMessage));
      this.f = paramMessage;
      this.hZ.setVisibility(0);
      this.ID.setVisibility(8);
      this.ahx.setVisibility(8);
      eOx();
      return false;
    case 2: 
      paramMessage = acfp.m(2131707322);
      this.ahw.setText(paramMessage);
      return false;
    case 4: 
      eOx();
      return false;
    }
    eOx();
    this.ahw.setText(acfp.m(2131707321));
    this.dwq = true;
    return false;
  }
  
  public void i(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HUM_HummingActivity", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if (paramMusicItemInfo == null) {
      return;
    }
    if (paramMusicItemInfo.mType != 7)
    {
      this.dwr = true;
      Message localMessage = this.jdField_b_of_type_Auru.obtainMessage();
      localMessage.what = 1;
      localMessage.obj = paramMusicItemInfo;
      this.jdField_b_of_type_Auru.sendMessage(localMessage);
      QQToast.a(BaseApplicationImpl.getContext(), acfp.m(2131707323) + paramMusicItemInfo, 0).show();
      j(paramMusicItemInfo);
      return;
    }
    this.dwr = false;
    this.jdField_b_of_type_Auru.sendEmptyMessage(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.HummingActivity
 * JD-Core Version:    0.7.0.1
 */