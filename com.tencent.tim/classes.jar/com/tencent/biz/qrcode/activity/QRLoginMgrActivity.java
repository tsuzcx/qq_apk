package com.tencent.biz.qrcode.activity;

import acbn;
import acde;
import acfd;
import aeif;
import aejn;
import afsf;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import aqdj;
import aqgv;
import aqha;
import aqiw;
import aqju;
import arhz;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.Switch;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import rvi;
import rvl;
import rvm;
import rvn;
import rvo;
import rvp;
import rvq;
import rvr;
import rwk;
import rwk.a;
import rwo;
import rwp;
import rwp.a;
import rwr;

public class QRLoginMgrActivity
  extends QRLoginBaseActivity
  implements View.OnClickListener, rwk.a
{
  private long Cy;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new rvi(this);
  private arhz jdField_a_of_type_Arhz;
  private rwk jdField_a_of_type_Rwk;
  private rwp.a jdField_a_of_type_Rwp$a = new rvo(this);
  private rwp jdField_a_of_type_Rwp;
  private String aCH;
  private Set<Long> aP;
  private MqqHandler b = ThreadManager.getUIHandler();
  private ConcurrentHashMap<Long, rwo> cq;
  private acfd e = new rvp(this);
  private ListView i;
  private Context mContext;
  private ImageView nN;
  private Switch x;
  private TextView zA;
  private TextView zz;
  
  private void am(int paramInt)
  {
    this.b.post(new QRLoginMgrActivity.4(this, paramInt));
  }
  
  private void bwU()
  {
    this.jdField_a_of_type_Rwp = ((rwp)this.app.getManager(335));
    this.jdField_a_of_type_Rwp.a(this.jdField_a_of_type_Rwp$a);
  }
  
  private void bwV()
  {
    this.b.post(new QRLoginMgrActivity.5(this));
  }
  
  private void d(rwo paramrwo)
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("category", 6);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", acbn.bkw);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("max_select_count", 50);
    localIntent.putExtra("qrlogin_appid", paramrwo.Cz);
    startActivityForResult(localIntent, 2);
    anot.a(null, "dc00898", "", "", "0X800A472", "0X800A472", paramrwo.bvC, 0, "", "", "", "");
  }
  
  private void initListView()
  {
    this.i = ((ListView)findViewById(2131365819));
    this.jdField_a_of_type_Rwk = new rwk();
    this.jdField_a_of_type_Rwk.a(this);
    View localView = LayoutInflater.from(this).inflate(2131560594, null);
    this.x = ((Switch)localView.findViewById(2131372131));
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);
    this.x.setChecked(bool);
    this.x.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.i.addFooterView(localView);
    this.i.setAdapter(this.jdField_a_of_type_Rwk);
    if (((aejn)aeif.a().o(528)).cNu == 1)
    {
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void x(boolean paramBoolean, long paramLong)
  {
    am(1);
    if (this.aP != null)
    {
      this.aP.clear();
      this.aP = null;
    }
    if (this.cq == null) {
      this.cq = new ConcurrentHashMap();
    }
    this.cq.clear();
    Iterator localIterator = this.jdField_a_of_type_Rwk.cl().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (rwo)localIterator.next();
      this.cq.put(Long.valueOf(((rwo)localObject).Cz), localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "confirmQRLogout allLogout:", Boolean.valueOf(paramBoolean), " appid:", Long.valueOf(paramLong), " size:", Integer.valueOf(this.cq.size()) });
    }
    if (paramBoolean)
    {
      localIterator = this.cq.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (Long)localIterator.next();
        if (!afsf.a().a(this.app, ((Long)localObject).longValue(), (byte)0, new byte[0], 101))
        {
          bwV();
          QQToast.a(getApplicationContext(), 1, 2131717175, 0).show();
        }
      }
    }
    while (afsf.a().a(this.app, paramLong, (byte)0, new byte[0], 100)) {
      return;
    }
    bwV();
    QQToast.a(getApplicationContext(), 1, 2131717175, 0).show();
  }
  
  public void a(rwo paramrwo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onItmeClick type:", Integer.valueOf(paramrwo.bvB) });
    }
    Intent localIntent;
    if (rwr.bd(paramrwo.bvB))
    {
      localIntent = new Intent(this, LiteActivity.class);
      localIntent.putExtra("targetUin", acbn.bkw);
      localIntent.addFlags(67108864);
      startActivity(localIntent);
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800A471", "0X800A471", paramrwo.bvC, 0, "", "", "", "");
      return;
      if (rwr.be(paramrwo.bvB))
      {
        localIntent = new Intent(this, LiteActivity.class);
        localIntent.putExtra("targetUin", acbn.bkx);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
      }
      else if (rwr.bf(paramrwo.bvB))
      {
        QQToast.a(getApplicationContext(), getString(2131717195), 0).show(getTitleBarHeight());
      }
    }
  }
  
  public void b(rwo paramrwo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onCloseClick type:", Integer.valueOf(paramrwo.bvB) });
    }
    if (!aqiw.isNetworkAvailable(this))
    {
      QQToast.a(this.mContext, 1, 2131698346, 0).show(getTitleBarHeight());
      return;
    }
    aqju localaqju = aqha.a(this, 230);
    localaqju.setMessage(getString(2131717170, new Object[] { paramrwo.mDeviceName, paramrwo.mAppName }));
    localaqju.setPositiveButton(2131717198, new rvq(this, paramrwo));
    localaqju.setNegativeButton(2131721058, new rvr(this));
    localaqju.show();
    anot.a(null, "dc00898", "", "", "0X800A473", "0X800A473", paramrwo.bvC, 0, "", "", "", "");
  }
  
  public void c(rwo paramrwo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "onFileClick type:", Integer.valueOf(paramrwo.bvB) });
    }
    acde localacde = (acde)this.app.getBusinessHandler(8);
    if (rwr.bd(paramrwo.bvB))
    {
      localacde.aR = acbn.bkw;
      localacde.cuM = 0;
    }
    while (!CheckPermission.isHasStoragePermission(this))
    {
      CheckPermission.requestSDCardPermission(this, new rvl(this, paramrwo));
      return;
      if (rwr.be(paramrwo.bvB))
      {
        localacde.aR = acbn.bkx;
        localacde.cuM = 1;
      }
    }
    d(paramrwo);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    long l;
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      l = paramIntent.getLongExtra("qrlogin_appid", -1L);
      if (l != -1L) {
        break label48;
      }
      QLog.w("QRLoginMgrActivity", 1, "appid is -1 !");
    }
    label48:
    rwo localrwo;
    do
    {
      return;
      while (!paramIntent.hasNext()) {
        paramIntent = this.jdField_a_of_type_Rwk.cl().iterator();
      }
      localrwo = (rwo)paramIntent.next();
    } while (localrwo.Cz != l);
    a(localrwo);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (this.app == null)
    {
      super.finish();
      return true;
    }
    this.mContext = this;
    this.aCH = getIntent().getStringExtra("qrlogin_position");
    this.Cy = getIntent().getLongExtra("qrlogin_appid", -1L);
    paramBundle = this.app.getCurrentAccountUin();
    this.zA.setText(aqgv.n(this.app, paramBundle));
    paramBundle = aqdj.a(this.app, paramBundle, (byte)1);
    if (paramBundle != null) {
      this.nN.setImageDrawable(paramBundle);
    }
    bwU();
    addObserver(this.e);
    anot.a(null, "dc00898", "", "", "0X800A470", "0X800A470", 0, 0, "", "", "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    bwV();
    removeObserver(this.e);
    this.b.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Rwp != null) {
      this.jdField_a_of_type_Rwp.b(this.jdField_a_of_type_Rwp$a);
    }
    this.mContext = null;
    this.cq = null;
    this.aP = null;
  }
  
  protected void initUI()
  {
    super.setContentView(2131560592);
    super.setTitle(2131717188);
    this.zA = ((TextView)findViewById(2131372364));
    this.nN = ((ImageView)findViewById(2131366628));
    this.zz = ((TextView)findViewById(2131372627));
    this.zz.setOnClickListener(this);
    initListView();
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
      if (aqiw.isNetworkAvailable(this)) {
        break;
      }
      QQToast.a(this.mContext, 1, 2131698346, 0).show(getTitleBarHeight());
    }
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(2131717158);
    if (this.jdField_a_of_type_Rwp != null) {
      localaqju.setMessage(this.jdField_a_of_type_Rwp.ao(this.mContext));
    }
    for (;;)
    {
      localaqju.setPositiveButton(2131717198, new rvm(this));
      localaqju.setNegativeButton(2131721058, new rvn(this));
      localaqju.show();
      anot.a(null, "dc00898", "", "", "0X800A477", "0X800A477", 0, 0, "", "", "", "");
      break;
      localaqju.setMessage(2131717159);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity
 * JD-Core Version:    0.7.0.1
 */