package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import dkh;
import dki;
import dkj;
import dkk;
import dkm;
import dkn;
import dko;
import dkp;
import dkq;
import dkr;
import dks;
import dkt;
import java.util.Timer;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class RegisterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private static final int k = 1;
  public byte a;
  public int a;
  public Dialog a;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new dkk(this);
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final byte jdField_b_of_type_Byte = 0;
  final int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString;
  private final byte jdField_c_of_type_Byte = 1;
  final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private final byte jdField_d_of_type_Byte = 2;
  final int jdField_d_of_type_Int = 2;
  private String jdField_d_of_type_JavaLangString = "";
  private final byte jdField_e_of_type_Byte = 3;
  final int jdField_e_of_type_Int = 3;
  private String jdField_e_of_type_JavaLangString = "";
  private final byte jdField_f_of_type_Byte = 4;
  final int jdField_f_of_type_Int = 4;
  private String jdField_f_of_type_JavaLangString = "";
  private final byte jdField_g_of_type_Byte = 5;
  final int jdField_g_of_type_Int = 5;
  private String jdField_g_of_type_JavaLangString = "86";
  private final byte jdField_h_of_type_Byte = 6;
  final int jdField_h_of_type_Int = 6;
  final int i = 7;
  final int j = 8;
  private final int l = 30;
  private final int m = 0;
  private final int n = 1;
  private final int o = 2;
  private final int p = 3;
  private final int q = 4;
  private final int r = 5;
  private final int s = -1;
  
  public RegisterActivity()
  {
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 30;
    this.jdField_a_of_type_AndroidOsHandler = new dkj(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
      {
        if (i1 == paramInt)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i1].setTextColor(-16777216);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i1].setTextColor(-7829368);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(4);
        }
      }
    }
    if (paramInt >= 1) {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[(paramInt - 1)].setVisibility(0);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "reQuerySms time = " + paramLong);
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new dkt(this, paramLong), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean a(String paramString)
  {
    int i2 = paramString.length();
    if ((i2 < 6) || (i2 > 16))
    {
      Toast.makeText(this, 2131561570, 0).show();
      return false;
    }
    try
    {
      Integer.parseInt(paramString);
      i1 = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
    if ((i2 <= 9) && (i1 != 0))
    {
      Toast.makeText(this, 2131562531, 0).show();
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624405);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130903073);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131231029)).setText(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private String c()
  {
    try
    {
      String str1 = ((TelephonyManager)getSystemService("phone")).getSimSerialNumber();
      String str2 = str1;
      if (str1 == null) {
        str2 = "";
      }
      return str2;
    }
    catch (Exception localException) {}
    return "";
  }
  
  private void c(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, d());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new dkp(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private boolean c()
  {
    boolean bool = ((CheckBox)findViewById(2131234383)).isChecked();
    if (!bool) {
      Toast.makeText(this, 2131562637, 0).show();
    }
    return bool;
  }
  
  private String d()
  {
    try
    {
      String str1 = ((TelephonyManager)getSystemService("phone")).getLine1Number();
      if (str1 != null) {}
      boolean bool;
      str2 = null;
    }
    catch (Exception localException1)
    {
      try
      {
        if (str1.length() < 1) {
          break label50;
        }
        bool = str1.startsWith("+");
        if (!bool) {
          return ???;
        }
        return null;
      }
      catch (Exception localException2)
      {
        return localException1;
      }
      localException1 = localException1;
      return "";
    }
    label50:
    String str2;
    return str2;
  }
  
  private boolean f()
  {
    Editable localEditable = ((EditText)findViewById(2131234382)).getText();
    boolean bool2 = true;
    int i1;
    if (localEditable != null) {
      i1 = 3;
    }
    for (;;)
    {
      try
      {
        if ("852".equals(this.jdField_g_of_type_JavaLangString)) {
          break label171;
        }
        if (!"853".equals(this.jdField_g_of_type_JavaLangString)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        boolean bool3;
        bool1 = false;
        continue;
      }
      this.jdField_c_of_type_JavaLangString = localEditable.toString().trim();
      Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_c_of_type_JavaLangString.length() < i1) {
        bool2 = false;
      }
      boolean bool1 = bool2;
      if (!this.jdField_c_of_type_JavaLangString.startsWith("1"))
      {
        bool3 = "86".equals(this.jdField_g_of_type_JavaLangString);
        bool1 = bool2;
        if (bool3) {
          bool1 = false;
        }
      }
      if (!bool1) {
        Toast.makeText(this, 2131562244, 0).show();
      }
      return bool1;
      bool1 = "886".equals(this.jdField_g_of_type_JavaLangString);
      if (bool1)
      {
        i1 = 9;
        continue;
        bool1 = false;
        continue;
        label171:
        i1 = 6;
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131234377));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)findViewById(2131234362));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)findViewById(2131234366));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)findViewById(2131234370));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[2];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(2131234363));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(2131234367));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = findViewById(2131234364);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = findViewById(2131234368);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = findViewById(2131234372);
    TextView localTextView = (TextView)findViewById(2131234384);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    a(0);
    h();
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131234380));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + getString(2131559097));
    findViewById(2131234381).setOnClickListener(this);
  }
  
  private void i()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131562738));
    localQQCustomDialog.setMessage(getString(2131561968));
    dkh localdkh = new dkh(this);
    dkm localdkm = new dkm(this);
    localQQCustomDialog.setPositiveButton(2131562539, localdkh);
    localQQCustomDialog.setNegativeButton(2131561746, localdkm);
    localQQCustomDialog.show();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dkq(this));
  }
  
  private void k()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void l()
  {
    try
    {
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void m()
  {
    if ((!f()) || (!c())) {
      return;
    }
    try
    {
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegisterQueryMobile(this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131562877);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    try
    {
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegistByPhoneNumber((byte)2, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, Long.valueOf(AppSetting.jdField_a_of_type_Int), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void o()
  {
    findViewById(2131234373).setVisibility(8);
    findViewById(2131234374).setVisibility(0);
    ((TextView)findViewById(2131234390)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131561859);
  }
  
  private void p()
  {
    Editable localEditable = ((EditText)findViewById(2131234388)).getText();
    if (localEditable != null)
    {
      this.jdField_d_of_type_JavaLangString = localEditable.toString();
      if (this.jdField_d_of_type_JavaLangString != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.trim();
      }
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
      try
      {
        ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegisterByCommitSmsVerifycode(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
        b(2131563166);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(this, 2131562029, 0).show();
  }
  
  private void q()
  {
    this.jdField_a_of_type_Int = 0;
    findViewById(2131234373).setVisibility(8);
    findViewById(2131234374).setVisibility(8);
    findViewById(2131234375).setVisibility(0);
    a(1);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131562980);
  }
  
  private void r()
  {
    Object localObject3 = null;
    Object localObject1 = ((EditText)findViewById(2131231905)).getText();
    if (localObject1 != null)
    {
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      if ((localObject1 == null) || (((String)localObject1).length() <= 0))
      {
        Toast.makeText(this, 2131562622, 0).show();
        return;
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = ((EditText)findViewById(2131234385)).getText();
      if (localObject1 != null)
      {
        localObject3 = localObject1.toString();
        localObject1 = localObject3;
        if (localObject3 != null) {
          localObject1 = ((String)localObject3).trim();
        }
        if (localObject1 != null)
        {
          localObject3 = localObject1;
          if (((String)localObject1).length() > 0) {}
        }
        else
        {
          Toast.makeText(this, 2131562635, 0).show();
          return;
        }
      }
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3)))
      {
        if (!a((String)localObject2)) {
          break;
        }
        try
        {
          this.jdField_f_of_type_JavaLangString = ((String)localObject2);
          ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegisterBySetPass((String)localObject2, "nickName", "smsCode", this.jdField_a_of_type_MqqObserverAccountObserver);
          b(2131563167);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      Toast.makeText(this, 2131561456, 0).show();
      return;
    }
  }
  
  private void s()
  {
    findViewById(2131234375).setVisibility(8);
    findViewById(2131234376).setVisibility(0);
    a(2);
    ((TextView)findViewById(2131234378)).setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131562930);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void t()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("password", this.jdField_f_of_type_JavaLangString);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void u()
  {
    try
    {
      ((AccountManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      ((TextView)findViewById(2131234389)).setVisibility(0);
      ((TextView)findViewById(2131234390)).setVisibility(8);
      d();
      b(2131563166);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://")) {
      str = "http://" + paramString;
    }
    paramString = DialogUtil.a(this, 230);
    paramString.setTitle(2131562779);
    paramString.setMessage(2131561455);
    paramString.setPositiveButton(2131562539, new dkn(this, str));
    paramString.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {}
    while ((paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131562779);
    localQQCustomDialog.setMessage(getString(2131559098, new Object[] { paramString2, paramString1 }));
    localQQCustomDialog.setPositiveButton(2131562539, new dko(this, paramString2, paramString1));
    localQQCustomDialog.show();
  }
  
  public void b(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    paramString1 = new dkr(this);
    paramString2 = new dks(this);
    localQQCustomDialog.setPositiveButton(2131562539, paramString1);
    localQQCustomDialog.setNegativeButton(2131234393, paramString2);
    localQQCustomDialog.show();
  }
  
  protected boolean b()
  {
    int i1 = this.jdField_a_of_type_Byte;
    getClass();
    if (i1 != 6) {
      i();
    }
    for (;;)
    {
      return true;
      c();
    }
  }
  
  public void c()
  {
    int i1 = 0;
    switch (this.jdField_a_of_type_Byte)
    {
    }
    for (;;)
    {
      if (i1 != 0) {
        this.jdField_a_of_type_Byte = ((byte)(this.jdField_a_of_type_Byte + 1));
      }
      return;
      n();
      continue;
      o();
      i1 = 1;
      continue;
      p();
      continue;
      q();
      i1 = 1;
      continue;
      r();
      continue;
      s();
      i1 = 1;
      continue;
      t();
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putString("telNum", paramString1);
    localBundle.putString("msg", paramString2);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_Int = 30;
      ((TextView)findViewById(2131234389)).setVisibility(8);
      ((TextView)findViewById(2131234390)).setVisibility(0);
      return;
    }
    ((TextView)findViewById(2131234389)).setText(this.jdField_a_of_type_Int + getResources().getString(2131562872));
    this.jdField_a_of_type_Int -= 1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new dki(this));
  }
  
  /* Error */
  public void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 638	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 655	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 660	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 638	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 655	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 663	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 669	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 675	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore_3
    //   27: new 677	android/graphics/Canvas
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 680	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 684	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   40: invokevirtual 690	android/view/Window:getDecorView	()Landroid/view/View;
    //   43: aload_1
    //   44: invokevirtual 694	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   47: new 696	java/io/File
    //   50: dup
    //   51: getstatic 699	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 701	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 704	java/io/File:exists	()Z
    //   62: ifne +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 707	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: new 696	java/io/File
    //   73: dup
    //   74: new 166	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   81: getstatic 699	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 71	com/tencent/mobileqq/activity/RegisterActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 709
    //   97: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 701	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +33 -> 141
    //   111: aconst_null
    //   112: astore_2
    //   113: new 711	java/io/FileOutputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 714	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_1
    //   122: aload_3
    //   123: getstatic 720	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: bipush 100
    //   128: aload_1
    //   129: invokevirtual 724	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 727	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -5 -> 141
    //   149: aload_1
    //   150: invokevirtual 727	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: return
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 727	java/io/FileOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: return
    //   169: astore_2
    //   170: goto -5 -> 165
    //   173: astore_3
    //   174: aload_1
    //   175: astore_2
    //   176: aload_3
    //   177: astore_1
    //   178: goto -21 -> 157
    //   181: astore_2
    //   182: goto -37 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	RegisterActivity
    //   35	103	1	localObject1	Object
    //   142	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   144	6	1	localObject2	Object
    //   154	1	1	localIOException1	java.io.IOException
    //   156	10	1	localObject3	Object
    //   167	8	1	localIOException2	java.io.IOException
    //   177	1	1	localObject4	Object
    //   112	50	2	localObject5	Object
    //   169	1	2	localIOException3	java.io.IOException
    //   175	1	2	localIOException4	java.io.IOException
    //   181	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   26	97	3	localBitmap	android.graphics.Bitmap
    //   173	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   113	122	142	java/io/FileNotFoundException
    //   149	153	154	java/io/IOException
    //   113	122	156	finally
    //   137	141	167	java/io/IOException
    //   161	165	169	java/io/IOException
    //   122	133	173	finally
    //   122	133	181	java/io/FileNotFoundException
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + " " + str);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131234377) {
      m();
    }
    do
    {
      return;
      if (i1 == 2131234381)
      {
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
        return;
      }
      if (i1 == 2131234390)
      {
        u();
        return;
      }
    } while (i1 != 2131234384);
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "http://zc.qq.com/chs/agreement1_chs.html");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903934);
    j(2130837729);
    setTitle(2131562738);
    g();
    getWindow().getDecorView().setDrawingCacheEnabled(true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    k();
  }
  
  protected void onResume()
  {
    super.onResume();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity
 * JD-Core Version:    0.7.0.1
 */