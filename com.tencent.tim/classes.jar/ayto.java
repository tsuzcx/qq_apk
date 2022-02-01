import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ayto
  extends aygy
  implements View.OnClickListener
{
  private aytw jdField_a_of_type_Aytw;
  private ExtendEditText jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText;
  private boolean dAG;
  private int eMM;
  private Button fc;
  public RelativeLayout iO;
  private CheckBox n;
  private String uN = awhu.gK(1);
  private View zI;
  
  public ayto(@NonNull aytw paramaytw)
  {
    super(paramaytw);
    this.jdField_a_of_type_Aytw = paramaytw;
  }
  
  public static boolean bg(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private void cvH()
  {
    Typeface localTypeface = null;
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText == null) {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_a_of_type_Aytw.bdK);
    String str = avtz.a(this.jdField_a_of_type_Aytw.fontId, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Aytw.fontId = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
    }
  }
  
  private void eTx()
  {
    RelativeLayout localRelativeLayout1 = (RelativeLayout)y(2131366264);
    this.iO = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131562452, localRelativeLayout1, false));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(50.0F, getResources()));
    RelativeLayout localRelativeLayout2 = this.iO;
    if (this.jdField_a_of_type_Aytw.bxD)
    {
      i = 0;
      localRelativeLayout2.setVisibility(i);
      localLayoutParams.addRule(12);
      if (ayxa.eMW <= 0) {
        break label110;
      }
    }
    label110:
    for (int i = ayxa.eMW;; i = wja.dp2px(60.0F, getResources()))
    {
      localLayoutParams.bottomMargin = i;
      localRelativeLayout1.addView(this.iO, localLayoutParams);
      return;
      i = 8;
      break;
    }
  }
  
  private void gI(long paramLong) {}
  
  private boolean iT(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      gI(l);
      paramString = avtz.a(l);
      if (paramString == null) {
        return false;
      }
      this.jdField_a_of_type_Aytw.fontId = paramString.fontId;
      this.jdField_a_of_type_Aytw.cig = paramString.eyB;
      this.jdField_a_of_type_Aytw.mFontUrl = paramString.fontUrl;
      int i = this.jdField_a_of_type_Aytw.fontId;
      if (i > 0) {
        return true;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("loadDefaultFontData", 1, "loadDefaultFontData Throwable, errMsg = " + paramString.getMessage());
    }
    return false;
  }
  
  /* Error */
  public String bj(String paramString)
  {
    // Byte code:
    //   0: invokestatic 217	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 223	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 187	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   15: ldc 225
    //   17: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 231	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: aconst_null
    //   31: ldc 233
    //   33: iconst_1
    //   34: anewarray 235	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokestatic 241	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +216 -> 263
    //   50: aload_1
    //   51: invokeinterface 247 1 0
    //   56: ifeq +207 -> 263
    //   59: aload_1
    //   60: aload_1
    //   61: ldc 249
    //   63: invokeinterface 253 2 0
    //   68: invokeinterface 256 2 0
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +178 -> 256
    //   81: new 235	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 260	java/lang/String:getBytes	()[B
    //   89: ldc_w 262
    //   92: invokespecial 265	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokestatic 270	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_2
    //   99: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq +30 -> 132
    //   105: ldc_w 275
    //   108: iconst_2
    //   109: new 187	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 277
    //   119: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 280	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_2
    //   133: astore_3
    //   134: aload_1
    //   135: ifnull +11 -> 146
    //   138: aload_1
    //   139: invokeinterface 283 1 0
    //   144: aload_2
    //   145: astore_3
    //   146: aload_3
    //   147: areturn
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_2
    //   151: ldc_w 285
    //   154: astore_1
    //   155: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +33 -> 191
    //   161: ldc_w 275
    //   164: iconst_2
    //   165: new 187	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 287
    //   175: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokestatic 291	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 208	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull -48 -> 146
    //   197: aload_2
    //   198: invokeinterface 283 1 0
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 283 1 0
    //   218: aload_2
    //   219: athrow
    //   220: astore_2
    //   221: goto -13 -> 208
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: aload_3
    //   228: astore_2
    //   229: goto -21 -> 208
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: ldc_w 285
    //   238: astore_1
    //   239: goto -84 -> 155
    //   242: astore 4
    //   244: aload_2
    //   245: astore_3
    //   246: aload_1
    //   247: astore_2
    //   248: aload_3
    //   249: astore_1
    //   250: aload 4
    //   252: astore_3
    //   253: goto -98 -> 155
    //   256: ldc_w 285
    //   259: astore_2
    //   260: goto -161 -> 99
    //   263: ldc_w 285
    //   266: astore_2
    //   267: goto -135 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	ayto
    //   0	270	1	paramString	String
    //   6	192	2	localObject1	Object
    //   205	14	2	localObject2	Object
    //   220	6	2	localObject3	Object
    //   228	39	2	localObject4	Object
    //   133	14	3	localObject5	Object
    //   148	31	3	localException1	java.lang.Exception
    //   192	1	3	str	String
    //   224	4	3	localObject6	Object
    //   232	1	3	localException2	java.lang.Exception
    //   245	8	3	localObject7	Object
    //   242	9	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	46	148	java/lang/Exception
    //   7	46	205	finally
    //   50	99	220	finally
    //   99	132	220	finally
    //   155	191	224	finally
    //   50	99	232	java/lang/Exception
    //   99	132	242	java/lang/Exception
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.arg1)
    {
    }
    for (;;)
    {
      switch (paramMessage.what)
      {
      default: 
        this.eMM = paramMessage.arg1;
        return super.e(paramMessage);
        if (paramMessage.what != 3) {
          this.iO.setVisibility(8);
        }
        break;
      }
    }
    this.BK = ((Long)paramMessage.obj).longValue();
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if (paramInt1 == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EditVideoQzComment", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_Aytw.mPriv = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_Aytw.eo == null) {
            this.jdField_a_of_type_Aytw.eo = new ArrayList();
          }
          this.jdField_a_of_type_Aytw.eo.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_Aytw.eo.addAll((Collection)localObject);
          }
        }
        if (bg(this.jdField_a_of_type_Aytw.mPriv))
        {
          this.jdField_a_of_type_Aytw.pO = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Aytw.uO = paramIntent.getString("key_selected_tag");
        }
        if (rma.a().tG() == 22) {
          LpReportInfo_pf00064.allReport(680, 5, 2);
        }
        uy();
      }
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (rma.a().tG() != 22);
        LpReportInfo_pf00064.allReport(680, 5, 3);
        return;
      } while (paramInt1 != 1009);
      if (this.jdField_a_of_type_Aytw.zJ != null) {
        this.jdField_a_of_type_Aytw.zJ.setVisibility(8);
      }
      this.b.a(Message.obtain(null, 22));
    } while (paramIntent == null);
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.containsKey("extra_key_bundle_priv_key"))
    {
      paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Aytw.mPriv = paramIntent.getInt("permission_code");
        if (this.jdField_a_of_type_Aytw.eo == null) {
          this.jdField_a_of_type_Aytw.eo = new ArrayList();
        }
        this.jdField_a_of_type_Aytw.eo.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_Aytw.eo.addAll((Collection)localObject);
        }
        if (bg(this.jdField_a_of_type_Aytw.mPriv))
        {
          this.jdField_a_of_type_Aytw.pO = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Aytw.uO = paramIntent.getString("key_selected_tag");
        }
        uy();
      }
    }
    if (localBundle.containsKey("extraIsTopicSyncQzone"))
    {
      boolean bool = localBundle.getBoolean("extraIsTopicSyncQzone");
      this.n.setChecked(bool);
    }
    if (localBundle.containsKey("contentIntentKey"))
    {
      localObject = localBundle.getString("contentIntentKey");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
      this.jdField_a_of_type_Aytw.mContent = paramIntent;
      if (rma.a().tG() == 22) {
        LpReportInfo_pf00064.allReport(680, 2, 8);
      }
    }
    if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
    {
      paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_Aytw.fontId = localBundle.getInt("extra_key_font_id", -1);
    this.jdField_a_of_type_Aytw.cig = localBundle.getInt("extra_key_font_format_type");
    this.jdField_a_of_type_Aytw.mFontUrl = localBundle.getString("extra_key_font_url");
    this.jdField_a_of_type_Aytw.superFontId = localBundle.getInt("extra_key_super_font_id", -1);
    this.jdField_a_of_type_Aytw.bdK = localBundle.getString("extra_key_super_font_info");
    cvH();
  }
  
  public void onClick(View paramView)
  {
    if (this.BK > System.currentTimeMillis()) {}
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        i = paramView.getId();
        if (i != 2131367304) {
          break;
        }
        localObject1 = QzoneConfig.getInstance().getConfig("H5Url", "UgcPermitSetting", "https://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}&_proxy=1").replace("{uin}", QQStoryContext.a().mi()).replace("{qua}", avpq.getQUA3());
        this.jdField_a_of_type_Aytw.afI(3004);
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("permission_code", this.jdField_a_of_type_Aytw.mPriv);
        if ((this.jdField_a_of_type_Aytw.eo != null) && (this.jdField_a_of_type_Aytw.eo.size() > 0))
        {
          ((Bundle)localObject2).putStringArrayList("uin_list", this.jdField_a_of_type_Aytw.eo);
          localObject3 = new ArrayList(this.jdField_a_of_type_Aytw.eo.size());
          localObject4 = this.jdField_a_of_type_Aytw.eo.iterator();
          while (((Iterator)localObject4).hasNext()) {
            ((ArrayList)localObject3).add(bj((String)((Iterator)localObject4).next()));
          }
          ((Bundle)localObject2).putStringArrayList("key_nicknames", (ArrayList)localObject3);
        }
        if ((bg(this.jdField_a_of_type_Aytw.mPriv)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aytw.pO))) {
          ((Bundle)localObject2).putString("key_setting_raw_json", this.jdField_a_of_type_Aytw.pO);
        }
        if (rma.a().tG() == 22)
        {
          LpReportInfo_pf00064.allReport(680, 2, 4);
          LpReportInfo_pf00064.allReport(680, 5, 1);
        }
        avpw.forwardToBrowser((BaseActivity)this.jdField_a_of_type_Ayii, (String)localObject1, 1, (Bundle)localObject2, "");
      }
    } while (i != 2131367261);
    this.jdField_a_of_type_Aytw.afI(3001);
    Object localObject2 = avpw.d.a();
    Object localObject3 = new Bundle();
    ((Bundle)localObject3).putInt("permission_code", this.jdField_a_of_type_Aytw.mPriv);
    if ((this.jdField_a_of_type_Aytw.eo != null) && (this.jdField_a_of_type_Aytw.eo.size() > 0))
    {
      ((Bundle)localObject3).putStringArrayList("uin_list", this.jdField_a_of_type_Aytw.eo);
      localObject1 = new ArrayList(this.jdField_a_of_type_Aytw.eo.size());
      localObject4 = this.jdField_a_of_type_Aytw.eo.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((ArrayList)localObject1).add(bj((String)((Iterator)localObject4).next()));
      }
      ((Bundle)localObject3).putStringArrayList("key_nicknames", (ArrayList)localObject1);
    }
    if ((bg(this.jdField_a_of_type_Aytw.mPriv)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Aytw.pO))) {
      ((Bundle)localObject3).putString("key_setting_raw_json", this.jdField_a_of_type_Aytw.pO);
    }
    ((Bundle)localObject3).putBoolean("is_need_auto_close_from_pri", true);
    if (this.jdField_a_of_type_Aytw.zJ != null) {
      this.jdField_a_of_type_Aytw.zJ.setVisibility(0);
    }
    Object localObject1 = "";
    if (this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText != null) {
      localObject1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.getText().toString();
    }
    if (rma.a().tG() == 22) {
      LpReportInfo_pf00064.allReport(680, 2, 3);
    }
    Object localObject4 = new Bundle();
    ((Bundle)localObject4).putBoolean("key_at_click_hide_keyboard", true);
    this.b.a(Message.obtain(null, 21));
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_Ayii;
    if (this.jdField_a_of_type_Aytw.isTopic) {}
    for (int i = 0;; i = 1)
    {
      avpw.a(localBaseActivity, (avpw.d)localObject2, 1009, "", (String)localObject1, "", "", 0, i, 1, 0, 0, 0, "", 10000, (Bundle)localObject3, this.jdField_a_of_type_Aytw.isTopic, this.jdField_a_of_type_Aytw.topicSyncQzone, this.jdField_a_of_type_Aytw.fontId, this.jdField_a_of_type_Aytw.superFontId, false, (Bundle)localObject4);
      break;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    eTx();
    this.iO = ((RelativeLayout)y(2131367260));
    this.n = ((CheckBox)y(2131367310));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)y(2131367261));
    this.fc = ((Button)y(2131367304));
    this.zI = y(2131367309);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(aofw.a);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.fc.setOnClickListener(this);
    if (!this.jdField_a_of_type_Aytw.bxH) {
      this.fc.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Aytw.isTopic) || (this.jdField_a_of_type_Aytw.bxE))
    {
      this.fc.setVisibility(8);
      this.n.setVisibility(0);
      this.n.setOnCheckedChangeListener(new aytp(this));
      this.n.setChecked(true);
    }
    if (iT(QQStoryContext.a().mi())) {
      cvH();
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    int j = 0;
    int i = 0;
    if (paramInt == 7) {}
    for (boolean bool = true;; bool = false)
    {
      this.dAG = bool;
      switch (paramInt)
      {
      default: 
        this.iO.setVisibility(8);
        return;
      }
    }
    if (this.jdField_a_of_type_Aytw.bxD) {}
    for (paramInt = i;; paramInt = 8)
    {
      this.iO.setVisibility(paramInt);
      return;
    }
    if (this.eMM != 1)
    {
      if ((this.jdField_a_of_type_Aytw.bxD) && (!this.dAG)) {}
      for (paramInt = j;; paramInt = 8)
      {
        this.iO.setVisibility(paramInt);
        return;
      }
    }
    this.dAG = true;
    return;
    this.iO.setVisibility(8);
  }
  
  public void uy()
  {
    this.uN = awhu.gK(this.jdField_a_of_type_Aytw.mPriv);
    this.fc.setText(this.uN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayto
 * JD-Core Version:    0.7.0.1
 */