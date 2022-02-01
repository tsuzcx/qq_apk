package dov.com.qq.im.capture.music.humrecognition.view;

import acfp;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import arxa;
import auru;
import axov;
import axrh;
import axro;
import axrq;
import axrr;
import axsb;
import axsc;
import axsd;
import axsf;
import axsh;
import ayep;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.view.ProviderView;
import dov.com.qq.im.capture.view.ProviderView.a;

public class BgmRecognitionProviderView
  extends ProviderView
  implements Handler.Callback, View.OnClickListener, axrq
{
  axrh jdField_a_of_type_Axrh = new axsh(this);
  private ayep jdField_a_of_type_Ayep;
  private Button aK;
  private TextView ahy;
  private TextView ahz;
  private auru jdField_b_of_type_Auru;
  private axro jdField_b_of_type_Axro;
  private axsb jdField_b_of_type_Axsb;
  private axsf jdField_b_of_type_Axsf;
  QIMMusicConfigManager c;
  private boolean dwt;
  public MusicItemInfo f;
  private Runnable iP = new BgmRecognitionProviderView.2(this);
  private Button ia;
  private Button ib;
  private Button ic;
  
  public BgmRecognitionProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void ayJ()
  {
    if (this.jdField_b_of_type_Axro != null) {
      this.jdField_b_of_type_Axro.eOq();
    }
  }
  
  private void bPt()
  {
    eOD();
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null)
    {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.aex(2);
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.O(33, Integer.valueOf(1001));
    }
  }
  
  private void eOD()
  {
    this.ahy.setText("");
    this.ahz.setText(2131700416);
    this.ia.setEnabled(false);
  }
  
  private void eOE()
  {
    if (axrr.qH()) {
      return;
    }
    this.jdField_b_of_type_Axsb = new axsd();
    eOI();
  }
  
  private void eOF()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickOriginalSongRecognition: invoked. ");
    }
    if (axrr.qH()) {
      return;
    }
    this.jdField_b_of_type_Axsb = new axsc();
    eOI();
  }
  
  private void eOG()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickHumRecognitionResult: invoked. ");
    }
    if (axrr.qH()) {}
    while (this.jdField_b_of_type_Axro == null) {
      return;
    }
    if (this.jdField_b_of_type_Axro.b(this.f))
    {
      this.jdField_b_of_type_Axro.a(this.f, this.eCJ);
      return;
    }
    this.ahz.setText(2131700418);
    this.jdField_b_of_type_Axro.a(this.f, this.jdField_a_of_type_Axrh);
  }
  
  private void eOH()
  {
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.uZ(true);
    }
  }
  
  private void eOI()
  {
    arxa.a().showToast(2131700425);
    this.ahz.setText(2131700420);
    ThreadManager.post(this.iP, 5, null, false);
  }
  
  private void eOJ()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickCancel: invoked. ");
    }
    ayJ();
    if (this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a != null) {
      this.jdField_c_of_type_DovComQqImCaptureViewProviderView$a.aex(2);
    }
    eOD();
  }
  
  private void j(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "updateHumMusicItemToMyTab: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7)) {
      return;
    }
    this.jdField_c_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.a(paramMusicItemInfo, true);
  }
  
  public int QW()
  {
    return 2131561098;
  }
  
  public void dKI()
  {
    super.dKI();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderShow: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_b_of_type_Axsf.a(this);
  }
  
  public void dLs()
  {
    super.dLs();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onProviderDismiss: invoked. info: TAG = BgmRecognitionProviderView");
    }
    this.jdField_b_of_type_Axsf.b(this);
  }
  
  public void eOK()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "doOnClickFinish: invoked. ");
    }
    this.dwt = true;
    j(this.f);
    if (this.jdField_b_of_type_Axro != null)
    {
      if (this.jdField_b_of_type_Axro.b(this.f))
      {
        this.jdField_b_of_type_Axro.a(this.f);
        eOH();
        bPt();
      }
    }
    else {
      return;
    }
    this.ahz.setText(2131700418);
    this.jdField_b_of_type_Axro.a(this.f, this.jdField_a_of_type_Axrh);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
      this.ahz.setText(2131700419);
      if (!localMusicItemInfo.mHasCopyright)
      {
        paramMessage = axrr.a(localMusicItemInfo) + acfp.m(2131703180);
        this.ahy.setText(paramMessage);
        this.ahy.setEnabled(false);
        return false;
      }
      paramMessage = acfp.m(2131703177) + axrr.a(localMusicItemInfo);
      this.ahy.setText(paramMessage);
      this.ia.setEnabled(true);
      this.ahy.setEnabled(true);
      return false;
      this.ahz.setText(2131700419);
      this.ahy.setText(axrr.a(localMusicItemInfo));
      this.ahy.setEnabled(false);
      this.ia.setEnabled(false);
      return false;
      this.ahz.setText(2131700417);
      if (this.jdField_b_of_type_Axro != null) {
        this.jdField_b_of_type_Axro.a(this.f);
      }
      eOH();
    } while (!this.dwt);
    bPt();
    return false;
  }
  
  public void i(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "update: invoked. info: musicItemInfo = " + paramMusicItemInfo);
    }
    arxa.a().showToast(acfp.m(2131703179) + this.f);
    if ((paramMusicItemInfo == null) || (paramMusicItemInfo.mType == 7))
    {
      localMessage = this.jdField_b_of_type_Auru.obtainMessage();
      localMessage.obj = paramMusicItemInfo;
      localMessage.what = 1002;
      this.jdField_b_of_type_Auru.sendMessage(localMessage);
      return;
    }
    Message localMessage = this.jdField_b_of_type_Auru.obtainMessage();
    localMessage.obj = paramMusicItemInfo;
    this.f = paramMusicItemInfo;
    localMessage.what = 1001;
    this.jdField_b_of_type_Auru.sendMessage(localMessage);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      eOJ();
      continue;
      eOK();
      continue;
      eOF();
      continue;
      eOE();
      continue;
      eOG();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onCreate: invoked. info: data = " + paramBundle);
    }
    super.onCreate(paramBundle);
    if (this.mContentView == null) {
      this.mContentView = LayoutInflater.from(getContext()).inflate(2131561098, this, false);
    }
    addContentView(this.mContentView);
    setNeedTabBar(false);
    this.mContentView.setOnClickListener(this);
    this.jdField_b_of_type_Auru = new auru(Looper.getMainLooper(), this);
    this.jdField_b_of_type_Axsf = ((axsf)axov.a().c(10));
    this.jdField_c_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)axov.a(2));
    this.aK = ((Button)this.mContentView.findViewById(2131364098));
    this.aK.setOnClickListener(this);
    this.ia = ((Button)this.mContentView.findViewById(2131364108));
    this.ia.setOnClickListener(this);
    this.ib = ((Button)this.mContentView.findViewById(2131363931));
    this.ib.setOnClickListener(this);
    this.ic = ((Button)this.mContentView.findViewById(2131363932));
    this.ic.setOnClickListener(this);
    this.ahy = ((TextView)this.mContentView.findViewById(2131379586));
    this.ahz = ((TextView)this.mContentView.findViewById(2131379595));
    this.ahy.setOnClickListener(this);
    this.jdField_b_of_type_Axro = ((axro)axov.a().c(8));
    eOD();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onDestroy: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.onDestroy();
    this.jdField_a_of_type_Axrh = null;
    this.iP = null;
  }
  
  public void onResume()
  {
    super.onResume();
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onResume: invoked. info: TAG = BgmRecognitionProviderView");
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.i("BgmRecognitionProviderView", 2, "onStop: invoked. info: TAG = BgmRecognitionProviderView");
    }
    super.onStop();
    this.dwt = false;
  }
  
  public void setRecognitionPart(ayep paramayep)
  {
    this.jdField_a_of_type_Ayep = paramayep;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.humrecognition.view.BgmRecognitionProviderView
 * JD-Core Version:    0.7.0.1
 */