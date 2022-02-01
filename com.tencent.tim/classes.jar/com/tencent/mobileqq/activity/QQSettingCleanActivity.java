package com.tencent.mobileqq.activity;

import acfp;
import afka;
import aglz;
import ahaf;
import ahao;
import ahcj.b;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import anot;
import anql;
import aqha;
import aqil;
import aqiw;
import aqju;
import aqmb;
import arhz;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.HttpDownloadUtil.a;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import vpe;
import vpf;
import vpg;

public class QQSettingCleanActivity
  extends IphoneTitleBarActivity
  implements ahcj.b, View.OnClickListener, HttpDownloadUtil.a
{
  public static final String aPa = acfp.m(2131712166);
  public static final String[] cs = { "sdcard/Tencent/Tim", "sdcard/Tencent/Tim_Images", "sdcard/Tencent/TIMfile_recv", "sdcard/Tencent/QQ_Collection", "sdcard/Tencent/TIM_Favorite", "sdcard/Tencent/QQ_Video", "sdcard/Tencent/QQfile_share", "sdcard/Tencent/QQHomework_recv", "sdcard/Tencent/QQHomework_attach", "sdcard/Tencent/AIO_FORWARD", "sdcard/Tencent/QQ_business" };
  public static final ArrayList<String> pv = new ArrayList(2);
  public TextView Fb;
  public TextView Fc;
  public TextView Fd;
  public TextView Fe;
  public TextView Ff;
  public TextView Fg;
  public long GI;
  public long GJ;
  public long GK;
  public long GL;
  public long GM;
  public ProgressBar N;
  public b a;
  public CircleProgressBar a;
  public Button ds;
  public Button dt;
  public LinearLayout go;
  public boolean isDownloading;
  public long mFileSize;
  public View tY;
  public View tZ;
  public View ua;
  public View ub;
  public arhz v;
  
  public QQSettingCleanActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQSettingCleanActivity$b = new b();
  }
  
  private String aV(long paramLong)
  {
    if (paramLong <= 0L) {
      return null;
    }
    if (paramLong < 1024L) {
      return paramLong + "B";
    }
    if (paramLong < 1048576L) {
      return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F) }) + "K";
    }
    if (paramLong < 1073741824L) {
      return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F) }) + "M";
    }
    return String.format("%.1f", new Object[] { Float.valueOf((float)paramLong / 1024.0F / 1024.0F / 1024.0F) }) + "G";
  }
  
  public static void dg(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQSettingMsgHistoryActivity.class);
    localIntent.putExtra("set_display_type", 1);
    paramContext.startActivity(localIntent);
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    this.isDownloading = false;
    runOnUiThread(new ShowTask(4));
    anot.a(this.app, "dc00898", "", "", "0X8007911", "0X8007911", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
  }
  
  public boolean a(afka paramafka)
  {
    if (paramafka.resultCode == 0)
    {
      long l = paramafka.cRp;
      if ((aqiw.isNetSupport(this)) && (l > 0L))
      {
        paramafka = new Bundle();
        paramafka.putString("_filename_from_dlg", aPa);
        paramafka.putLong("_filesize_from_dlg", l);
        paramafka.putString("big_brother_source_key", "biz_src_tmm");
        paramafka.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_tmm");
        this.isDownloading = true;
        runOnUiThread(new ShowTask(2));
        aglz.a().a("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean", paramafka, this);
      }
      return true;
    }
    runOnUiThread(new ShowTask(3));
    return true;
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    this.isDownloading = false;
    runOnUiThread(new ShowTask(4));
  }
  
  public void bTy()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.start();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.setPercent(0);
    anql.y().post(new ScanSpaceTask());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131561668);
    setTitle(getString(2131701630));
    this.ds = ((Button)findViewById(2131364634));
    this.dt = ((Button)findViewById(2131364633));
    this.ds.setOnClickListener(this);
    this.dt.setOnClickListener(this);
    this.tY = findViewById(2131374730);
    this.tZ = findViewById(2131374725);
    this.ua = findViewById(2131372742);
    this.ub = findViewById(2131363173);
    ((GradientDrawable)this.tY.getBackground()).setColor(Color.parseColor("#00d1a4"));
    ((GradientDrawable)this.tZ.getBackground()).setColor(Color.parseColor("#fea356"));
    ((GradientDrawable)this.ua.getBackground()).setColor(Color.parseColor("#529eff"));
    ((GradientDrawable)this.ub.getBackground()).setColor(Color.parseColor("#e6e6e7"));
    this.Fb = ((TextView)findViewById(2131374871));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar = ((CircleProgressBar)findViewById(2131377684));
    this.Fc = ((TextView)findViewById(2131374729));
    this.Fd = ((TextView)findViewById(2131374726));
    this.Fe = ((TextView)findViewById(2131372741));
    this.Ff = ((TextView)findViewById(2131363172));
    this.go = ((LinearLayout)findViewById(2131378591));
    this.Fg = ((TextView)findViewById(2131364635));
    this.N = ((ProgressBar)findViewById(2131366102));
    anql.a().Qm(false);
    paramBundle = ahaf.a().vZ();
    String str = ahaf.a().vY();
    pv.clear();
    if (!TextUtils.isEmpty(paramBundle))
    {
      pv.add(paramBundle);
      QLog.d("QQCleanActivity", 2, " need scan file path1 = " + paramBundle);
    }
    if (!TextUtils.isEmpty(str))
    {
      pv.add(str);
      QLog.d("QQCleanActivity", 2, " need scan file path2 = " + str);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQCleanActivity", 2, " need scan file path1 = " + paramBundle + " path2 = " + str);
    }
    bTy();
    ThreadManager.executeOnNetWorkThread(new GetApkSizeTask());
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.v != null) && (this.v.isShowing())) {
      dismissDialog(1);
    }
    aglz.a().IW("https://qqwx.qq.com/s?aid=index&g_f=429&mType=QQSpaceClean");
    anql.dTd();
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (anql.a().ayL())
    {
      anql.a().Qm(false);
      bTy();
    }
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
      anot.a(this.app, "dc00898", "", "", "0X8007543", "0X8007543", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      Object localObject = new Intent(getActivity(), QQSettingMsgHistoryActivity.class);
      ((Intent)localObject).putExtra("set_display_type", 2);
      getActivity().startActivity((Intent)localObject);
      continue;
      anot.a(this.app, "dc00898", "", "", "0X8007544", "0X8007544", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
      if (!aqil.bQ(this))
      {
        anot.a(this.app, "dc00898", "", "", "0X8007912", "0X8007912", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        localObject = aqha.a(this, 230).setTitle(getString(2131720395)).setMessage(getString(2131720407)).setPositiveButton(getString(2131720400), new vpf(this)).setNegativeButton(getString(2131721058), new vpe(this));
        if ((localObject != null) && (!((Dialog)localObject).isShowing()) && (!isFinishing()))
        {
          ((Dialog)localObject).setCancelable(false);
          ((Dialog)localObject).show();
        }
      }
      else
      {
        anot.a(this.app, "dc00898", "", "", "0X8007913", "0X8007913", 0, 0, this.app.getCurrentAccountUin(), "", "", "");
        aqil.E(this, "mobileqq", 9502721);
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.v = null;
    this.v = new arhz(this, getTitleBarHeight());
    this.v.setMessage(getString(2131691516));
    this.v.setBackAndSearchFilter(true);
    this.v.showTipImageView(false);
    this.v.showProgerss(true);
    return this.v;
  }
  
  public void p(int paramInt, Bundle paramBundle) {}
  
  public void q(int paramInt, Bundle paramBundle) {}
  
  public void r(int paramInt, Bundle paramBundle)
  {
    runOnUiThread(new ShowTask(4));
  }
  
  public void s(int paramInt, Bundle paramBundle) {}
  
  class GetApkSizeTask
    implements Runnable
  {
    GetApkSizeTask() {}
    
    public void run()
    {
      try
      {
        Object localObject = new HttpGet("https://qqwx.qq.com/s?aid=index&p=5&c=102120&vt=2&pf=0");
        localObject = new DefaultHttpClient().execute((HttpUriRequest)localObject);
        if (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200)
        {
          localObject = EntityUtils.toString(((HttpResponse)localObject).getEntity());
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            long l = new JSONObject(((String)localObject).substring(6, ((String)localObject).length() - 2)).getLong("size");
            if (l > 0L)
            {
              QQSettingCleanActivity.this.GI = l;
              QQSettingCleanActivity.this.runOnUiThread(new QQSettingCleanActivity.ShowTask(QQSettingCleanActivity.this, 0));
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
  
  public class ScanSpaceTask
    implements Runnable
  {
    ScanSpaceTask() {}
    
    public void run()
    {
      long l1 = aqmb.getTotalInternalMemorySize();
      long l2 = aqmb.s(QQSettingCleanActivity.this);
      long l3 = aqmb.getAvailableInternalMemorySize();
      long l4 = aqmb.t(QQSettingCleanActivity.this);
      QQSettingCleanActivity.this.GJ = (l1 + l2);
      QQSettingCleanActivity.this.GL = (l3 + l4);
      vpg localvpg = new vpg(this);
      QQSettingCleanActivity.this.GK = anql.a().a(localvpg, 0, 98);
      QQSettingCleanActivity.this.mFileSize = anql.a().e(QQSettingCleanActivity.pv);
      QQSettingCleanActivity.this.GK -= QQSettingCleanActivity.this.mFileSize;
      localvpg.Bq(100);
      QLog.d("QQCleanActivity", 1, "SpaceInfo total: " + QQSettingCleanActivity.this.GJ + " ava: " + QQSettingCleanActivity.this.GL + " qq: " + QQSettingCleanActivity.this.GK + " file: " + QQSettingCleanActivity.this.mFileSize);
      QLog.d("QQCleanActivity", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
      QQSettingCleanActivity.this.a.setFinish(QQSettingCleanActivity.this.GK, QQSettingCleanActivity.this.mFileSize, QQSettingCleanActivity.this.GJ - QQSettingCleanActivity.this.GK - QQSettingCleanActivity.this.mFileSize - QQSettingCleanActivity.this.GL, QQSettingCleanActivity.this.GL, 3.0F);
      QQSettingCleanActivity.this.runOnUiThread(new QQSettingCleanActivity.ShowTask(QQSettingCleanActivity.this, 5));
    }
  }
  
  class ShowTask
    implements Runnable
  {
    public int CP;
    
    public ShowTask(int paramInt)
    {
      this.CP = paramInt;
    }
    
    public void run()
    {
      switch (this.CP)
      {
      default: 
        return;
      case 0: 
        QQSettingCleanActivity.this.Fb.setText(QQSettingCleanActivity.this.getString(2131720401) + "(" + QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.GI) + ")");
        return;
      case 1: 
        QQSettingCleanActivity.this.Fg.setText(QQSettingCleanActivity.this.getString(2131720405) + QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.GK - QQSettingCleanActivity.this.GM));
        QQSettingCleanActivity.this.Fg.setVisibility(0);
        return;
      case 2: 
        QQSettingCleanActivity.this.N.setVisibility(0);
        QQSettingCleanActivity.this.dt.setEnabled(false);
        QQSettingCleanActivity.this.dt.setText(QQSettingCleanActivity.this.getString(2131720396));
        return;
      case 3: 
        ahao.OS(2131696348);
        return;
      case 4: 
        QQSettingCleanActivity.this.N.setVisibility(8);
        QQSettingCleanActivity.this.dt.setEnabled(true);
        QQSettingCleanActivity.this.dt.setText(QQSettingCleanActivity.this.getString(2131720395));
        return;
      }
      TextView localTextView = QQSettingCleanActivity.this.Fc;
      if (QQSettingCleanActivity.this.GK <= 0L)
      {
        str = "0M";
        localTextView.setText(str);
        localTextView = QQSettingCleanActivity.this.Fd;
        if (QQSettingCleanActivity.this.mFileSize > 0L) {
          break label471;
        }
      }
      label471:
      for (String str = "0M";; str = QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.mFileSize))
      {
        localTextView.setText(str);
        QQSettingCleanActivity.this.Fe.setText(QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.GJ - QQSettingCleanActivity.this.GK - QQSettingCleanActivity.this.GL));
        QQSettingCleanActivity.this.Ff.setText(QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.GL));
        QQSettingCleanActivity.this.go.setVisibility(0);
        QQSettingCleanActivity.this.ds.setEnabled(true);
        QQSettingCleanActivity.this.dt.setEnabled(true);
        QQSettingCleanActivity.this.dt.setBackgroundResource(2130839524);
        QQSettingCleanActivity.this.dt.setTextColor(QQSettingCleanActivity.this.getResources().getColor(2131167335));
        return;
        str = QQSettingCleanActivity.a(QQSettingCleanActivity.this, QQSettingCleanActivity.this.GK);
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Bq(int paramInt);
  }
  
  class b
    extends Handler
  {
    b() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        if (!QQSettingCleanActivity.this.isFinishing())
        {
          QQSettingCleanActivity.this.v.setMessage(QQSettingCleanActivity.this.getString(2131691514));
          QQSettingCleanActivity.this.v.setTipImageView(2130850674);
          QQSettingCleanActivity.this.v.showProgerss(false);
        }
        sendEmptyMessageDelayed(1, 1000L);
        return;
      } while ((QQSettingCleanActivity.this.v == null) || (!QQSettingCleanActivity.this.v.isShowing()));
      QQSettingCleanActivity.this.v.cancel();
      QQSettingCleanActivity.this.v.setMessage(QQSettingCleanActivity.this.getString(2131691516));
      QQSettingCleanActivity.this.v.setBackAndSearchFilter(true);
      QQSettingCleanActivity.this.v.showTipImageView(false);
      QQSettingCleanActivity.this.v.showProgerss(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity
 * JD-Core Version:    0.7.0.1
 */