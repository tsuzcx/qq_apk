package com.tencent.mobileqq.activity;

import acfp;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import aqha;
import aqju;
import arhz;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Timer;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import vqy;
import vqz;
import vra;
import vrb;
import vrc;
import vrd;
import vre;
import vrf;
import vrg;
import vrh;

public class RegisterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Button aI;
  private String aPj;
  public String aPk = "";
  String aPl;
  private String aPm = "";
  private String aPn = "86";
  private final byte aQ = 0;
  private final byte aR = 1;
  private final byte aS = 2;
  private final byte aT = 3;
  private final byte aU = 4;
  private final byte aV = 5;
  private final byte aW = 6;
  public byte aX = 0;
  private final int bKh = 30;
  public int bKi = 30;
  final int bKj = -1;
  final int bKk = 1;
  final int bKl = 2;
  final int bKm = 3;
  final int bKn = 4;
  final int bKo = 5;
  final int bKp = 6;
  final int bKq = 7;
  final int bKr = 8;
  final int bKs = 9;
  private final int bKt = 0;
  private final int bKu = 1;
  private final int bKv = 2;
  private final int bKw = 3;
  private final int bKx = 4;
  private final int bKy = 5;
  private final int bKz = -1;
  private AccountObserver d = new vrb(this);
  Dialog dialog;
  public Handler handler = new vra(this);
  private MqqHandler jdField_m_of_type_MqqOsMqqHandler = new vqz(this);
  private ImageView[] jdField_m_of_type_ArrayOfAndroidWidgetImageView;
  private TextView mLocationText;
  private TextView[] o;
  private String password = "";
  private View[] t;
  private arhz u;
  private String uin = "";
  private Timer w;
  
  private void Bu(int paramInt)
  {
    if (paramInt < this.o.length)
    {
      int i = 0;
      if (i < this.o.length)
      {
        if (i == paramInt)
        {
          this.o[i].setTextColor(-16777216);
          this.t[i].setVisibility(0);
        }
        for (;;)
        {
          i += 1;
          break;
          this.o[i].setTextColor(-7829368);
          this.t[i].setVisibility(4);
        }
      }
    }
    if (paramInt >= 1) {
      this.jdField_m_of_type_ArrayOfAndroidWidgetImageView[(paramInt - 1)].setVisibility(0);
    }
  }
  
  private void Bv(int paramInt)
  {
    this.dialog = new ReportDialog(this, 2131756467);
    this.dialog.setContentView(2131558460);
    ((TextView)this.dialog.findViewById(2131365863)).setText(getString(paramInt));
    this.dialog.show();
  }
  
  private boolean QA()
  {
    boolean bool = ((CheckBox)findViewById(2131376645)).isChecked();
    if (!bool) {
      Toast.makeText(getApplicationContext(), 2131717081, 0).show();
    }
    return bool;
  }
  
  private boolean QB()
  {
    Editable localEditable = ((EditText)findViewById(2131371870)).getText();
    boolean bool2 = true;
    int i;
    if (localEditable != null) {
      i = 3;
    }
    for (;;)
    {
      try
      {
        if ("852".equals(this.aPn)) {
          break label171;
        }
        if (!"853".equals(this.aPn)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        boolean bool3;
        bool1 = false;
        continue;
      }
      this.aPj = localEditable.toString().trim();
      Long.parseLong(this.aPj);
      if (this.aPj.length() < i) {
        bool2 = false;
      }
      boolean bool1 = bool2;
      if (!this.aPj.startsWith("1"))
      {
        bool3 = "86".equals(this.aPn);
        bool1 = bool2;
        if (bool3) {
          bool1 = false;
        }
      }
      if (!bool1) {
        Toast.makeText(getApplicationContext(), 2131717079, 0).show();
      }
      return bool1;
      bool1 = "886".equals(this.aPn);
      if (bool1)
      {
        i = 9;
        continue;
        bool1 = false;
        continue;
        label171:
        i = 6;
      }
    }
  }
  
  private void bJQ()
  {
    this.handler.post(new RegisterActivity.6(this));
  }
  
  private void bUL()
  {
    this.mLocationText = ((TextView)findViewById(2131370841));
    this.mLocationText.setText("+" + this.aPn + acfp.m(2131713850));
    findViewById(2131364423).setOnClickListener(this);
  }
  
  private void bUM()
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(getString(2131717094));
    localaqju.setMessage(getString(2131717038));
    vqy localvqy = new vqy(this);
    vrc localvrc = new vrc(this);
    localaqju.setPositiveButton(2131721079, localvqy);
    localaqju.setNegativeButton(2131721058, localvrc);
    localaqju.show();
  }
  
  private void bUO()
  {
    try
    {
      if (this.w != null)
      {
        this.w.cancel();
        this.w = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void bUP()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).queryUpSmsStat(this.d);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bUQ()
  {
    if ((!QB()) || (!QA())) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.aPn, this.aPj, this.d);
      Bv(2131717125);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void bUR()
  {
    findViewById(2131371871).setVisibility(8);
    findViewById(2131381489).setVisibility(0);
    ((TextView)findViewById(2131377046)).setOnClickListener(this);
    this.handler.sendEmptyMessage(4);
    this.aI.setText(2131717030);
  }
  
  private void bUS()
  {
    Editable localEditable = ((EditText)findViewById(2131381484)).getText();
    if (localEditable != null)
    {
      this.aPm = localEditable.toString();
      if (this.aPm != null) {
        this.aPm = this.aPm.trim();
      }
    }
    if ((this.aPm != null) && (this.aPm.length() > 0)) {
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode(this.aPm, this.d);
        Bv(2131717032);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131717045, 0).show();
  }
  
  private void bUT()
  {
    this.bKi = 0;
    findViewById(2131371871).setVisibility(8);
    findViewById(2131381489).setVisibility(8);
    findViewById(2131372893).setVisibility(0);
    Bu(1);
    this.aI.setText(2131717029);
  }
  
  private void bUU()
  {
    Object localObject3 = null;
    Object localObject1 = ((EditText)findViewById(2131372885)).getText();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {
          break label66;
        }
      }
      Toast.makeText(getApplicationContext(), 2131717082, 0).show();
    }
    label66:
    do
    {
      return;
      localObject2 = null;
      localObject1 = ((EditText)findViewById(2131376640)).getText();
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
          Toast.makeText(getApplicationContext(), 2131717080, 0).show();
          return;
        }
      }
      if ((localObject2 == null) || (!((String)localObject2).equals(localObject3))) {
        break;
      }
    } while (!hp((String)localObject2));
    try
    {
      this.password = ((String)localObject2);
      ((AccountManager)this.app.getManager(0)).sendRegisterBySetPass((String)localObject2, "nickName", "smsCode", null, true, "3.4.4", this.d);
      Bv(2131717031);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Toast.makeText(getApplicationContext(), 2131717072, 0).show();
  }
  
  private void bUV()
  {
    findViewById(2131372893).setVisibility(8);
    findViewById(2131377072).setVisibility(0);
    Bu(2);
    ((TextView)findViewById(2131372159)).setText(this.uin);
    this.aI.setText(2131717052);
    this.handler.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void bUW()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.uin);
    localIntent.putExtra("password", this.password);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void bUX()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.d);
      ((TextView)findViewById(2131379698)).setVisibility(0);
      ((TextView)findViewById(2131377046)).setVisibility(8);
      bUY();
      Bv(2131717032);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void fM(long paramLong)
  {
    try
    {
      if (this.w != null)
      {
        this.w.cancel();
        this.w = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "reQuerySms time = " + paramLong);
      }
      this.w = new Timer();
      this.w.schedule(new RegisterActivity.9(this, paramLong), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean hp(String paramString)
  {
    int j = paramString.length();
    if ((j < 6) || (j > 16))
    {
      Toast.makeText(getApplicationContext(), 2131717073, 0).show();
      return false;
    }
    try
    {
      Integer.parseInt(paramString);
      i = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i = 0;
      }
    }
    if ((j <= 9) && (i != 0))
    {
      Toast.makeText(getApplicationContext(), 2131717074, 0).show();
      return false;
    }
    return true;
  }
  
  private void init()
  {
    this.aI = ((Button)findViewById(2131364084));
    this.aI.setOnClickListener(this);
    this.o = new TextView[3];
    this.o[0] = ((TextView)findViewById(2131381491));
    this.o[1] = ((TextView)findViewById(2131378102));
    this.o[2] = ((TextView)findViewById(2131377073));
    this.jdField_m_of_type_ArrayOfAndroidWidgetImageView = new ImageView[2];
    this.jdField_m_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(2131381490));
    this.jdField_m_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(2131378101));
    this.t = new View[3];
    this.t[0] = findViewById(2131381485);
    this.t[1] = findViewById(2131378100);
    this.t[2] = findViewById(2131377071);
    TextView localTextView = (TextView)findViewById(2131373713);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    Bu(0);
    bUL();
    this.aPl = getIntent().getStringExtra("uin");
  }
  
  private void vl(String paramString)
  {
    try
    {
      if (this.u == null) {
        this.u = new arhz(this, getTitleBarHeight());
      }
      this.u.setMessage(paramString);
      this.u.setOnKeyListener(new vrf(this));
      this.u.show();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void wq(String paramString)
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.aPn, this.aPj, null, Long.valueOf(AppSetting.getAppId()), "3.4.4", new Bundle(), this.d);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void bUN()
  {
    int i = 0;
    switch (this.aX)
    {
    }
    for (;;)
    {
      if (i != 0) {
        this.aX = ((byte)(this.aX + 1));
      }
      return;
      wq(null);
      continue;
      bUR();
      i = 1;
      continue;
      bUS();
      continue;
      bUT();
      i = 1;
      continue;
      bUU();
      continue;
      bUV();
      i = 1;
      continue;
      bUW();
    }
  }
  
  public void bUY()
  {
    if (this.bKi <= 0)
    {
      this.bKi = 30;
      ((TextView)findViewById(2131379698)).setVisibility(8);
      ((TextView)findViewById(2131377046)).setVisibility(0);
      return;
    }
    ((TextView)findViewById(2131379698)).setText(this.bKi + getResources().getString(2131717137));
    this.bKi -= 1;
    this.handler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  /* Error */
  public void bUZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 637	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 652	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 657	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 637	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 652	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 660	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 666	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 672	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore_3
    //   27: new 674	android/graphics/Canvas
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 677	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 681	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   40: invokevirtual 687	android/view/Window:getDecorView	()Landroid/view/View;
    //   43: aload_1
    //   44: invokevirtual 691	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   47: new 693	java/io/File
    //   50: dup
    //   51: getstatic 698	com/tencent/mobileqq/app/ScreenShot:bpb	Ljava/lang/String;
    //   54: invokespecial 700	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 703	java/io/File:exists	()Z
    //   62: ifne +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 706	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: new 693	java/io/File
    //   73: dup
    //   74: new 320	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   81: getstatic 698	com/tencent/mobileqq/app/ScreenShot:bpb	Ljava/lang/String;
    //   84: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 96	com/tencent/mobileqq/activity/RegisterActivity:uin	Ljava/lang/String;
    //   91: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 708
    //   97: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 700	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +33 -> 141
    //   111: aconst_null
    //   112: astore_2
    //   113: new 710	java/io/FileOutputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 713	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_1
    //   122: aload_3
    //   123: getstatic 719	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: bipush 100
    //   128: aload_1
    //   129: invokevirtual 723	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 726	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -5 -> 141
    //   149: aload_1
    //   150: invokevirtual 726	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: return
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 726	java/io/FileOutputStream:close	()V
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
  
  public void dq(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {}
    while ((paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(2131717147);
    localaqju.setMessage(acfp.m(2131713855) + paramString2 + acfp.m(2131713837) + paramString1 + acfp.m(2131713851));
    localaqju.setPositiveButton(2131721079, new vre(this, paramString2, paramString1));
    localaqju.show();
  }
  
  public void dr(String paramString1, String paramString2)
  {
    aqju localaqju = aqha.a(this, 230);
    localaqju.setTitle(paramString1);
    localaqju.setMessage(paramString2);
    paramString1 = new vrg(this);
    paramString2 = new vrh(this);
    localaqju.setPositiveButton(2131721079, paramString1);
    localaqju.setNegativeButton(2131364221, paramString2);
    localaqju.show();
  }
  
  public void ds(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putString("telNum", paramString1);
    localBundle.putString("msg", paramString2);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
  }
  
  public void gV()
  {
    this.handler.post(new RegisterActivity.10(this));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.aPn = paramIntent.getStringExtra("k_code");
      this.mLocationText.setText("+" + this.aPn + " " + str);
    }
  }
  
  public boolean onBackEvent()
  {
    int i = this.aX;
    getClass();
    if (i != 6) {
      bUM();
    }
    for (;;)
    {
      return true;
      bUN();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131364084) {
      bUQ();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131364423)
      {
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
      }
      else if (i == 2131377046)
      {
        bUX();
      }
      else if (i == 2131373713)
      {
        Intent localIntent = new Intent(this, QQBrowserActivity.class);
        localIntent.putExtra("uin", this.app.getCurrentAccountUin());
        localIntent.putExtra("ba_is_login", false);
        localIntent.putExtra("url", "https://ti.qq.com/tim/serverinfo.html");
        startActivity(localIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562977);
    setContentBackgroundResource(2130838900);
    setTitle(2131717094);
    init();
    this.app.setHandler(getClass(), this.jdField_m_of_type_MqqOsMqqHandler);
    getWindow().getDecorView().setDrawingCacheEnabled(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bUO();
  }
  
  public void onResume()
  {
    super.onResume();
    gV();
  }
  
  public void wp(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://")) {
      str = "http://" + paramString;
    }
    paramString = aqha.a(this, 230);
    paramString.setTitle(2131717147);
    paramString.setMessage(2131717150);
    paramString.setPositiveButton(2131721079, new vrd(this, str));
    paramString.show();
  }
  
  public void wr(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.handler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity
 * JD-Core Version:    0.7.0.1
 */