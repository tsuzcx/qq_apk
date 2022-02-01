package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QvipSpecialCareObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import eso;
import esp;
import esq;
import esr;
import ess;
import est;
import esu;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QvipSpecialSoundActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int jdField_a_of_type_Int = 0;
  public static final String a = "friendUin";
  private static final int jdField_b_of_type_Int = 1;
  private static final long jdField_b_of_type_Long = 90000L;
  private static final String jdField_b_of_type_JavaLangString = "SpecialSoundActivity";
  private static final int jdField_c_of_type_Int = 2;
  private static final String d = "mvip.gongneng.mobileqq.tiexintixing.ringandroid";
  private static final String e = "mvip.gongneng.mobileqq.tiexintixing.listandroid";
  private long jdField_a_of_type_Long;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private Handler jdField_a_of_type_AndroidOsHandler = new esp(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QvipSpecialCareManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager;
  private QvipSpecialSoundActivity.SpecialSoundAdapter jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter;
  private QvipSpecialSoundManager jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager;
  private QvipSpecialCareObserver jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver = new est(this);
  private QQToastNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = null;
  public List a;
  private boolean jdField_a_of_type_Boolean = false;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  
  public QvipSpecialSoundActivity()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(Uri paramUri)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
        return;
      }
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this, paramUri);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
      return;
    }
    catch (Exception paramUri)
    {
      paramUri.printStackTrace();
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!NetworkUtil.e(this))
    {
      b(getString(2131562488));
      return;
    }
    d();
    this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 2), 90000L);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    paramString = new ArrayList();
    paramString.add(String.valueOf(paramInt));
    if (paramInt == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(localArrayList, 2, paramString);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(localArrayList, 3, paramString);
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 300L;
  }
  
  private void b(String paramString)
  {
    if (!isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = new QQToastNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a(paramString, d(), 0, 0);
    }
  }
  
  private void c(String paramString)
  {
    DialogUtil.a(this, 230, getString(2131562519), paramString, 2131561746, 2131562229, new esr(this), new ess(this)).show();
  }
  
  private boolean c()
  {
    return (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.k()) && (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.l()) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.m()) && ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().e()));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131233460));
    h(2131561692);
    View localView = LayoutInflater.from(this).inflate(2130903701, this.jdField_a_of_type_ComTencentWidgetXListView, false);
    this.jdField_a_of_type_ComTencentWidgetXListView.a(localView);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233462));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233463));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131233466));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131233461));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidContentIntent = getIntent();
    this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("friendUin");
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager = new QvipSpecialCareManager(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager = new QvipSpecialSoundManager(this, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter = new QvipSpecialSoundActivity.SpecialSoundAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter);
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562762));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131562014));
  }
  
  private void f()
  {
    String str = "key_special_sound_list" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a())
    {
      d();
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundManager.a(new eso(this, str));
      return;
    }
    this.jdField_a_of_type_JavaUtilList = ((List)QvipSpecialSoundManager.jdField_a_of_type_JavaUtilHashMap.get(str));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity$SpecialSoundAdapter.a(this.jdField_a_of_type_JavaUtilList);
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.a(this.jdField_c_of_type_JavaLangString) == 1) {
      i();
    }
  }
  
  private void h()
  {
    a(this.jdField_c_of_type_JavaLangString, 1);
    if (c())
    {
      k();
      a(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165214));
    }
  }
  
  private void i()
  {
    ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233464)).setImageDrawable(getResources().getDrawable(2130840346));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void j()
  {
    ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131233464)).setImageDrawable(getResources().getDrawable(2130840348));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
    }
  }
  
  public void a(View paramView)
  {
    long l = System.currentTimeMillis();
    if (!a(this.jdField_a_of_type_Long, l)) {}
    Object localObject;
    label214:
    do
    {
      int i;
      do
      {
        for (;;)
        {
          return;
          this.jdField_a_of_type_Long = l;
          localObject = (esu)paramView.getTag();
          if (localObject != null)
          {
            i = ((esu)localObject).jdField_a_of_type_Int;
            if (VipUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
              a(this.jdField_c_of_type_JavaLangString, ((esu)localObject).jdField_a_of_type_Int);
            }
            while (c())
            {
              try
              {
                k();
                if (i != 1) {
                  break label214;
                }
                a(Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + 2131165214));
                return;
              }
              catch (Exception paramView)
              {
                if (QLog.isColorLevel()) {
                  QLog.i("SpecialSoundActivity", 2, "onItemClick play music exception:" + paramView.getMessage());
                }
                paramView.printStackTrace();
                return;
              }
              if (!this.jdField_a_of_type_Boolean)
              {
                c(String.format(getString(2131562018), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialCareManager.b()) }));
                this.jdField_a_of_type_Boolean = true;
              }
            }
          }
        }
      } while (i <= 1);
      paramView = new File(getFilesDir(), ((esu)localObject).jdField_a_of_type_JavaLangString);
      if (paramView.exists())
      {
        a(paramView.getAbsolutePath());
        return;
      }
      if (!NetworkUtil.e(this))
      {
        b(getString(2131562488));
        return;
      }
      localObject = ((esu)localObject).jdField_a_of_type_JavaLangString;
    } while (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject));
    this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Boolean.valueOf(true));
    d();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new esq(this, (String)localObject, paramView));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    }
    try
    {
      if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (paramString != null))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(new FileInputStream(paramString).getFD());
        this.jdField_a_of_type_AndroidMediaMediaPlayer.prepare();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(false);
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903700);
    setTitle(2131562597);
    d();
    e();
    f();
    return true;
  }
  
  protected void doOnDestroy()
  {
    k();
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppQvipSpecialCareObserver);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToastNotifier = null;
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    g();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131233466: 
      VipUtils.b(this, 3, "mvip.gongneng.mobileqq.tiexintixing.listandroid");
      return;
    case 2131233461: 
      h();
      return;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity
 * JD-Core Version:    0.7.0.1
 */