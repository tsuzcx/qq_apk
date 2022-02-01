package com.tencent.mobileqq.activity.aio.doodle;

import acfp;
import akxe;
import amjb;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import aqfe;
import aqha;
import aqju;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorPicker.a;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker;
import com.tencent.mobileqq.activity.aio.doodle.control.GifTemplatePicker.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.e;
import wja;
import wrb;
import wrg;
import wrh;
import wri;
import wrk;
import wrl;
import wrn;

public class DoodlePanel
  extends RelativeLayout
  implements View.OnClickListener, View.OnLongClickListener, XPanelContainer.e
{
  public static int bQS = -1;
  public static final int bQT;
  private long Iv;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$a;
  private ColorPicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker;
  private GifTemplatePicker jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker;
  private DoodleLayout b;
  private boolean bfK;
  private boolean bfw;
  private ProgressDialog d;
  private Button dQ;
  private Button dR;
  public QQAppInterface mApp;
  private BaseChatPie mBaseChatPie;
  private int mLastHeight;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    int i = (int)(Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) * 1.0F / 1.132931F);
    bQT = wja.dp2px(81.0F, localResources) + i;
  }
  
  public DoodlePanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public DoodlePanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean RK()
  {
    long l = System.currentTimeMillis();
    if (l - this.Iv < 500L)
    {
      QLog.d("Scribble", 2, " send click is invalid, lasttime:" + this.Iv + " currenttime:" + l);
      return false;
    }
    this.Iv = l;
    QLog.d("Scribble", 2, " send click is valid, lasttime:" + this.Iv);
    return true;
  }
  
  /* Error */
  private boolean a(String paramString, wrb paramwrb)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_1
    //   10: ifnull +14 -> 24
    //   13: aload_2
    //   14: ifnull +10 -> 24
    //   17: aload_1
    //   18: invokevirtual 154	java/lang/String:length	()I
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aload 7
    //   28: astore 5
    //   30: new 156	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload 7
    //   41: astore 5
    //   43: aload_1
    //   44: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   47: invokevirtual 166	java/io/File:exists	()Z
    //   50: ifne +15 -> 65
    //   53: aload 7
    //   55: astore 5
    //   57: aload_1
    //   58: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   61: invokevirtual 169	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload 7
    //   67: astore 5
    //   69: new 171	java/io/BufferedOutputStream
    //   72: dup
    //   73: new 173	java/io/FileOutputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 176	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 179	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   84: astore_1
    //   85: aload_2
    //   86: new 181	wrm
    //   89: dup
    //   90: aload_0
    //   91: aload_1
    //   92: invokespecial 184	wrm:<init>	(Lcom/tencent/mobileqq/activity/aio/doodle/DoodlePanel;Ljava/io/OutputStream;)V
    //   95: invokestatic 189	wre:a	(Lwrb;Lwre$a;)Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 194	java/io/OutputStream:close	()V
    //   103: iconst_0
    //   104: ifeq +11 -> 115
    //   107: new 196	java/lang/NullPointerException
    //   110: dup
    //   111: invokespecial 197	java/lang/NullPointerException:<init>	()V
    //   114: athrow
    //   115: iconst_1
    //   116: istore_3
    //   117: ldc 102
    //   119: iconst_2
    //   120: new 104	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   127: ldc 199
    //   129: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokestatic 96	java/lang/System:currentTimeMillis	()J
    //   135: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   138: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: iload_3
    //   145: ireturn
    //   146: astore_1
    //   147: ldc 102
    //   149: iconst_2
    //   150: new 104	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   157: ldc 201
    //   159: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: iload 4
    //   174: istore_3
    //   175: goto -58 -> 117
    //   178: astore_2
    //   179: aload 6
    //   181: astore_1
    //   182: aload_1
    //   183: astore 5
    //   185: aload_2
    //   186: invokevirtual 207	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: astore 5
    //   192: ldc 102
    //   194: iconst_2
    //   195: new 104	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   202: ldc 209
    //   204: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: iload 4
    //   219: istore_3
    //   220: aload_1
    //   221: ifnull -104 -> 117
    //   224: aload_1
    //   225: invokevirtual 194	java/io/OutputStream:close	()V
    //   228: iload 4
    //   230: istore_3
    //   231: goto -114 -> 117
    //   234: astore_1
    //   235: ldc 102
    //   237: iconst_2
    //   238: new 104	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   245: ldc 201
    //   247: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: iload 4
    //   262: istore_3
    //   263: goto -146 -> 117
    //   266: astore_1
    //   267: aload 5
    //   269: ifnull +8 -> 277
    //   272: aload 5
    //   274: invokevirtual 194	java/io/OutputStream:close	()V
    //   277: aload_1
    //   278: athrow
    //   279: astore_2
    //   280: ldc 102
    //   282: iconst_2
    //   283: new 104	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   290: ldc 201
    //   292: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_2
    //   296: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -28 -> 277
    //   308: astore_2
    //   309: aload_1
    //   310: astore 5
    //   312: aload_2
    //   313: astore_1
    //   314: goto -47 -> 267
    //   317: astore_2
    //   318: goto -136 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	DoodlePanel
    //   0	321	1	paramString	String
    //   0	321	2	paramwrb	wrb
    //   116	147	3	bool1	boolean
    //   7	254	4	bool2	boolean
    //   28	283	5	localObject1	Object
    //   4	176	6	localObject2	Object
    //   1	65	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   107	115	146	java/lang/Exception
    //   30	39	178	java/lang/Exception
    //   43	53	178	java/lang/Exception
    //   57	65	178	java/lang/Exception
    //   69	85	178	java/lang/Exception
    //   224	228	234	java/lang/Exception
    //   30	39	266	finally
    //   43	53	266	finally
    //   57	65	266	finally
    //   69	85	266	finally
    //   185	189	266	finally
    //   192	217	266	finally
    //   272	277	279	java/lang/Exception
    //   85	103	308	finally
    //   85	103	317	java/lang/Exception
  }
  
  private void cbm()
  {
    boolean bool2 = true;
    Button localButton;
    if (this.b != null)
    {
      int i = this.b.e(false, false);
      if (this.dQ != null)
      {
        localButton = this.dQ;
        if (i <= 0) {
          break label70;
        }
        bool1 = true;
        localButton.setEnabled(bool1);
      }
      if (this.dR != null)
      {
        localButton = this.dR;
        if (i <= 0) {
          break label75;
        }
      }
    }
    label70:
    label75:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean RL()
  {
    Context localContext = getContext();
    if ((t(true) > 0) && (this.mBaseChatPie.vm() == 0)) {
      anot.a(this.mApp, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((t(true) > 10) && (this.mBaseChatPie.vm() == 0))
    {
      wrn localwrn = new wrn(this);
      aqha.a(localContext, 230, null, localContext.getString(2131690118), localContext.getString(2131690116), localContext.getString(2131690117), localwrn, localwrn).show();
      return true;
    }
    return false;
  }
  
  void U(Context paramContext, int paramInt)
  {
    try
    {
      if (this.d != null) {
        cancleProgressDailog();
      }
      while (!this.d.isShowing())
      {
        this.d.show();
        return;
        this.d = new ReportProgressDialog(paramContext, 2131756467);
        this.d.setCancelable(true);
        this.d.show();
        this.d.setContentView(2131559761);
        ((TextView)this.d.findViewById(2131373180)).setText(paramInt);
      }
      return;
    }
    catch (Throwable paramContext)
    {
      akxe.b("PIC_TAG_ERROR", "DoodlePanel showProgress ", paramContext.toString());
    }
  }
  
  public void a(ColorPicker.a parama)
  {
    if ((this.b == null) || (parama == null)) {
      return;
    }
    if (parama.mType == 0)
    {
      this.b.setColor(parama.mValue);
      return;
    }
    this.b.setTexture(parama.mID);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, XPanelContainer paramXPanelContainer, a parama)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$a = parama;
    this.mBaseChatPie = paramBaseChatPie;
    this.mApp = paramQQAppInterface;
    bQS = XPanelContainer.aLe;
    QLog.d("Scribble", 2, "mOriginPanelHeight:" + bQS);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = ((ColorPicker)super.findViewById(2131364917));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.setListener(new wrg(this));
    this.dQ = ((Button)findViewById(2131363985));
    this.dQ.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = ((GifTemplatePicker)findViewById(2131368030));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.setListener(new wrh(this));
    this.dR = ((Button)findViewById(2131369943));
    this.dR.setOnClickListener(this);
    this.dR.setOnLongClickListener(this);
    this.b = ((DoodleLayout)findViewById(2131366036));
    this.b.setDoodleLayoutListener(new wri(this));
    paramQQAppInterface = aqfe.get(getContext(), "aio_doodle_colorpicker_select");
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      paramQQAppInterface = paramQQAppInterface.split(";");
      if (paramQQAppInterface.length == 3)
      {
        paramInt = Integer.valueOf(paramQQAppInterface[0]).intValue();
        int j = Integer.valueOf(paramQQAppInterface[1]).intValue();
        int k = Integer.valueOf(paramQQAppInterface[2]).intValue();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.d(new ColorPicker.a(paramInt, j, k), false);
      }
      paramQQAppInterface = aqfe.get(getContext(), "aio_doodle_template_picker_select");
    }
    try
    {
      if (TextUtils.isEmpty(paramQQAppInterface)) {
        break label452;
      }
      paramInt = Integer.valueOf(paramQQAppInterface).intValue();
      i = paramInt;
      paramInt = i;
      if (i == -1) {
        paramInt = 0;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        continue;
        paramInt = -1;
        continue;
        paramInt = 1;
      }
    }
    i = paramInt;
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.getItemCount()) {
        break label446;
      }
      if (((GifTemplatePicker.a)this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.i(paramInt)).mID == i)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.Q(paramInt, false);
        cbm();
        if (AppSetting.enableTalkBack)
        {
          this.dQ.setContentDescription(acfp.m(2131705204));
          this.dR.setContentDescription(acfp.m(2131705205));
          this.b.setContentDescription(acfp.m(2131705206));
        }
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.Q(0, false);
        break;
      }
      paramInt += 1;
    }
  }
  
  public void b(Bitmap paramBitmap, wrb paramwrb, int paramInt)
  {
    QLog.d("Scribble", 2, "sendDoodleMessage begin:" + System.currentTimeMillis());
    if ((paramBitmap == null) || (paramwrb == null)) {
      return;
    }
    U(getContext(), 2131696921);
    QLog.d("Scribble", 2, "sendDoodleMessage before SendPapScribbleMsg:" + System.currentTimeMillis());
    amjb.a(this.mBaseChatPie.app, this.mBaseChatPie.sessionInfo.aTl, this.mBaseChatPie.sessionInfo.cZ, paramBitmap, paramInt, new wrl(this, paramwrb));
  }
  
  void cancleProgressDailog()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scribble", 2, "cancelProgressDialog " + System.currentTimeMillis());
    }
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.cancel();
    }
  }
  
  public int nA()
  {
    if (BaseApplicationImpl.sApplication != null)
    {
      Resources localResources = BaseApplicationImpl.sApplication.getResources();
      if (localResources != null)
      {
        Object localObject = localResources.getDisplayMetrics();
        int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
        localObject = getParent();
        if ((localObject instanceof View))
        {
          int j = ((View)localObject).getWidth();
          if ((i != j) && (j > 0))
          {
            QLog.d("Scribble", 2, "getPanelHeight , disWidth:" + i + " winwidth:" + j);
            int k = (int)(j * 1.0F / 1.132931F) + wja.dp2px(81.0F, localResources);
            QLog.d("Scribble", 2, "getPanelHeight , disWidth:" + i + " winwidth:" + j + " nWinHeight:" + k);
            return k;
          }
        }
      }
    }
    QLog.d("Scribble", 2, "getPanelHeight , use max height:" + bQT);
    return bQT;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369943)
    {
      if (this.b != null) {
        this.b.undo();
      }
      cbm();
      anot.a(this.mApp, "dc00898", "", "", "0X80081B6", "0X80081B6", 1, 0, "", "", "", "");
    }
    Bitmap localBitmap;
    wrb localwrb;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131363985) {
        if (!RK())
        {
          QLog.d("Scribble", 2, " onsend error, invalid click, return");
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$a != null)
        {
          localBitmap = this.b.U();
          if (localBitmap == null)
          {
            QLog.d("Scribble", 2, " onsend error : bitmap is null");
          }
          else
          {
            localwrb = this.b.a();
            if (localwrb != null) {
              break;
            }
            QLog.d("Scribble", 2, " onsend error : doodleParam is null");
          }
        }
      }
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80081BB", "0X80081BB", 1, this.b.e(false, true), "", "", "", "");
    i = this.b.vY();
    String str = "";
    if (this.b.a() != null) {
      str = this.b.a().pl();
    }
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", "", "0X8008326", "0X8008326", 0, 0, "", "", String.valueOf(i), str);
      b(localBitmap, localwrb, this.b.vY());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$a.a(localBitmap, localwrb, this.b.vY());
      break;
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.bfw)
    {
      if (XPanelContainer.aLe == this.mLastHeight) {
        XPanelContainer.aLe = bQS;
      }
      QLog.d("Scribble", 2, "onDetachedFromWindow, set mExternalPanelheight :" + XPanelContainer.aLe);
    }
    this.bfw = false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131369943)
    {
      paramView = new wrk(this);
      aqha.a(getContext(), 230, null, getContext().getString(2131690121), getContext().getString(2131690119), getContext().getString(2131690120), paramView, paramView).show();
    }
    anot.a(this.mApp, "dc00898", "", "", "0X80081B7", "0X80081B7", 1, 0, "", "", "", "");
    return true;
  }
  
  public void onShow()
  {
    bQS = XPanelContainer.aLe;
    QLog.d("Scribble", 2, "mOriginPanelHeight:" + bQS);
    this.bfw = true;
    this.mLastHeight = nA();
    XPanelContainer.aLe = this.mLastHeight;
    QLog.d("Scribble", 2, "set mExternalPanelheight :" + XPanelContainer.aLe);
    anot.a(this.mApp, "dc00898", "", "", "0X80081B3", "0X80081B3", 1, 0, "", "", "", "");
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public void reset()
  {
    if (this.b != null) {
      this.b.ba(true, true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.Q(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.wd(), false);
    }
    cbm();
  }
  
  public int t(boolean paramBoolean)
  {
    int i = 0;
    if (this.b != null) {
      i = this.b.e(false, paramBoolean);
    }
    return i;
  }
  
  public void unInit()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel$a = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker.unInit();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlColorPicker = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker.unInit();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleControlGifTemplatePicker = null;
    }
    if (this.b != null)
    {
      this.b.unInit();
      this.b = null;
    }
    this.mApp = null;
  }
  
  public int vV()
  {
    this.mLastHeight = nA();
    QLog.d("Scribble", 2, "getDefaultExternalPanelheight , orginal:" + XPanelContainer.aLe + " return:" + this.mLastHeight);
    return this.mLastHeight;
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Scribble", 2, "onHide :" + paramBoolean);
    }
    this.bfw = false;
    this.mLastHeight = 0;
    if (!paramBoolean) {
      XPanelContainer.aLe = bQS;
    }
    QLog.d("Scribble", 2, "set mExternalPanelheight :" + XPanelContainer.aLe);
    setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap, wrb paramwrb, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel
 * JD-Core Version:    0.7.0.1
 */