import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import dov.com.tencent.mobileqq.activity.richmedia.view.ExtendEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class aytz
  extends aygy
  implements View.OnClickListener
{
  private ayub jdField_a_of_type_Ayub;
  private ExtendEditText jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText;
  private int eMM;
  private Button fc;
  private RelativeLayout iO;
  private CheckBox n;
  private String uN = awhu.gK(1);
  private View zI;
  
  public aytz(@NonNull ayub paramayub)
  {
    super(paramayub);
    this.jdField_a_of_type_Ayub = paramayub;
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
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTextEffect(this.jdField_a_of_type_Ayub.bdK);
    String str = avtz.a(this.jdField_a_of_type_Ayub.fontId, null, null, null);
    if (TextUtils.isEmpty(str)) {
      this.jdField_a_of_type_Ayub.fontId = -1;
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setTypeface(localTypeface);
      return;
      localTypeface = Typeface.createFromFile(str);
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
      this.jdField_a_of_type_Ayub.fontId = paramString.fontId;
      this.jdField_a_of_type_Ayub.cig = paramString.eyB;
      this.jdField_a_of_type_Ayub.mFontUrl = paramString.fontUrl;
      int i = this.jdField_a_of_type_Ayub.fontId;
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
    //   0: invokestatic 152	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 158	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 121	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   15: ldc 160
    //   17: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 166	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   30: aconst_null
    //   31: ldc 168
    //   33: iconst_1
    //   34: anewarray 170	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: invokestatic 176	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +208 -> 255
    //   50: aload_1
    //   51: invokeinterface 182 1 0
    //   56: ifeq +199 -> 255
    //   59: aload_1
    //   60: aload_1
    //   61: ldc 184
    //   63: invokeinterface 188 2 0
    //   68: invokeinterface 191 2 0
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 71	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifne +171 -> 249
    //   81: new 170	java/lang/String
    //   84: dup
    //   85: aload_2
    //   86: invokevirtual 195	java/lang/String:getBytes	()[B
    //   89: ldc 197
    //   91: invokespecial 200	java/lang/String:<init>	([BLjava/lang/String;)V
    //   94: invokestatic 205	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_2
    //   98: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +28 -> 129
    //   104: ldc 210
    //   106: iconst_2
    //   107: new 121	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   114: ldc 212
    //   116: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_2
    //   120: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 215	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_2
    //   130: astore_3
    //   131: aload_1
    //   132: ifnull +11 -> 143
    //   135: aload_1
    //   136: invokeinterface 218 1 0
    //   141: aload_2
    //   142: astore_3
    //   143: aload_3
    //   144: areturn
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_2
    //   148: ldc 220
    //   150: astore_1
    //   151: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +31 -> 185
    //   157: ldc 210
    //   159: iconst_2
    //   160: new 121	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   167: ldc 222
    //   169: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_3
    //   173: invokestatic 226	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   176: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: aload_1
    //   186: astore_3
    //   187: aload_2
    //   188: ifnull -45 -> 143
    //   191: aload_2
    //   192: invokeinterface 218 1 0
    //   197: aload_1
    //   198: areturn
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +9 -> 212
    //   206: aload_1
    //   207: invokeinterface 218 1 0
    //   212: aload_2
    //   213: athrow
    //   214: astore_2
    //   215: goto -13 -> 202
    //   218: astore_3
    //   219: aload_2
    //   220: astore_1
    //   221: aload_3
    //   222: astore_2
    //   223: goto -21 -> 202
    //   226: astore_3
    //   227: aload_1
    //   228: astore_2
    //   229: ldc 220
    //   231: astore_1
    //   232: goto -81 -> 151
    //   235: astore 4
    //   237: aload_2
    //   238: astore_3
    //   239: aload_1
    //   240: astore_2
    //   241: aload_3
    //   242: astore_1
    //   243: aload 4
    //   245: astore_3
    //   246: goto -95 -> 151
    //   249: ldc 220
    //   251: astore_2
    //   252: goto -154 -> 98
    //   255: ldc 220
    //   257: astore_2
    //   258: goto -129 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	aytz
    //   0	261	1	paramString	String
    //   6	186	2	localObject1	Object
    //   199	14	2	localObject2	Object
    //   214	6	2	localObject3	Object
    //   222	36	2	localObject4	Object
    //   130	14	3	localObject5	Object
    //   145	28	3	localException1	java.lang.Exception
    //   186	1	3	str	String
    //   218	4	3	localObject6	Object
    //   226	1	3	localException2	java.lang.Exception
    //   238	8	3	localObject7	Object
    //   235	9	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   7	46	145	java/lang/Exception
    //   7	46	199	finally
    //   50	98	214	finally
    //   98	129	214	finally
    //   151	185	218	finally
    //   50	98	226	java/lang/Exception
    //   98	129	235	java/lang/Exception
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
        this.iO.setVisibility(8);
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
        QLog.d("EditPicQzComment", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
      }
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent.containsKey("permission_code")) {
          this.jdField_a_of_type_Ayub.mPriv = paramIntent.getInt("permission_code");
        }
        if (paramIntent.containsKey("uin_list"))
        {
          if (this.jdField_a_of_type_Ayub.eo == null) {
            this.jdField_a_of_type_Ayub.eo = new ArrayList();
          }
          this.jdField_a_of_type_Ayub.eo.clear();
          localObject = paramIntent.getStringArrayList("uin_list");
          if (localObject != null) {
            this.jdField_a_of_type_Ayub.eo.addAll((Collection)localObject);
          }
        }
        if (bg(this.jdField_a_of_type_Ayub.mPriv))
        {
          this.jdField_a_of_type_Ayub.pO = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Ayub.uO = paramIntent.getString("key_selected_tag");
        }
        uy();
      }
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 1009);
      if (this.jdField_a_of_type_Ayub.zJ != null) {
        this.jdField_a_of_type_Ayub.zJ.setVisibility(8);
      }
    } while ((paramIntent == null) || (paramIntent.getExtras() == null));
    Bundle localBundle = paramIntent.getExtras();
    if (localBundle.containsKey("extra_key_bundle_priv_key"))
    {
      paramIntent = localBundle.getBundle("extra_key_bundle_priv_key");
      if (paramIntent != null)
      {
        this.jdField_a_of_type_Ayub.mPriv = paramIntent.getInt("permission_code");
        if (this.jdField_a_of_type_Ayub.eo == null) {
          this.jdField_a_of_type_Ayub.eo = new ArrayList();
        }
        this.jdField_a_of_type_Ayub.eo.clear();
        localObject = paramIntent.getStringArrayList("uin_list");
        if (localObject != null) {
          this.jdField_a_of_type_Ayub.eo.addAll((Collection)localObject);
        }
        if (bg(this.jdField_a_of_type_Ayub.mPriv))
        {
          this.jdField_a_of_type_Ayub.pO = paramIntent.getString("key_setting_raw_json");
          this.jdField_a_of_type_Ayub.uO = paramIntent.getString("key_selected_tag");
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
      this.jdField_a_of_type_Ayub.mContent = paramIntent;
    }
    if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
    {
      paramIntent = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setText(paramIntent);
    }
    this.jdField_a_of_type_Ayub.fontId = localBundle.getInt("extra_key_font_id", -1);
    this.jdField_a_of_type_Ayub.cig = localBundle.getInt("extra_key_font_format_type");
    this.jdField_a_of_type_Ayub.mFontUrl = localBundle.getString("extra_key_font_url");
    this.jdField_a_of_type_Ayub.superFontId = localBundle.getInt("extra_key_super_font_id", -1);
    this.jdField_a_of_type_Ayub.bdK = localBundle.getString("extra_key_super_font_info");
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
        ((ayub)this.b).afJ(3004);
        localBundle = new Bundle();
        localBundle.putInt("permission_code", this.jdField_a_of_type_Ayub.mPriv);
        if ((this.jdField_a_of_type_Ayub.eo != null) && (this.jdField_a_of_type_Ayub.eo.size() > 0))
        {
          localBundle.putStringArrayList("uin_list", this.jdField_a_of_type_Ayub.eo);
          localObject2 = new ArrayList(this.jdField_a_of_type_Ayub.eo.size());
          localObject3 = this.jdField_a_of_type_Ayub.eo.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((ArrayList)localObject2).add(bj((String)((Iterator)localObject3).next()));
          }
          localBundle.putStringArrayList("key_nicknames", (ArrayList)localObject2);
        }
        if ((bg(this.jdField_a_of_type_Ayub.mPriv)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayub.pO))) {
          localBundle.putString("key_setting_raw_json", this.jdField_a_of_type_Ayub.pO);
        }
        avpw.forwardToBrowser((BaseActivity)this.jdField_a_of_type_Ayii, (String)localObject1, 1, localBundle, "");
      }
    } while (i != 2131367261);
    ((ayub)this.b).afJ(3001);
    Object localObject1 = avpw.d.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("permission_code", this.jdField_a_of_type_Ayub.mPriv);
    if ((this.jdField_a_of_type_Ayub.eo != null) && (this.jdField_a_of_type_Ayub.eo.size() > 0))
    {
      localBundle.putStringArrayList("uin_list", this.jdField_a_of_type_Ayub.eo);
      localObject2 = new ArrayList(this.jdField_a_of_type_Ayub.eo.size());
      localObject3 = this.jdField_a_of_type_Ayub.eo.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(bj((String)((Iterator)localObject3).next()));
      }
      localBundle.putStringArrayList("key_nicknames", (ArrayList)localObject2);
    }
    if ((bg(this.jdField_a_of_type_Ayub.mPriv)) && (!TextUtils.isEmpty(this.jdField_a_of_type_Ayub.pO))) {
      localBundle.putString("key_setting_raw_json", this.jdField_a_of_type_Ayub.pO);
    }
    if (this.jdField_a_of_type_Ayub.zJ != null) {
      this.jdField_a_of_type_Ayub.zJ.setVisibility(0);
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putBoolean("key_at_click_hide_keyboard", true);
    Object localObject3 = (BaseActivity)this.jdField_a_of_type_Ayii;
    String str = this.jdField_a_of_type_Ayub.mContent;
    if (this.jdField_a_of_type_Ayub.isTopic) {}
    for (int i = 0;; i = 1)
    {
      avpw.a((Activity)localObject3, (avpw.d)localObject1, 1009, "", str, "", "", 0, i, 1, 0, 0, 0, "", 10000, localBundle, this.jdField_a_of_type_Ayub.isTopic, this.jdField_a_of_type_Ayub.topicSyncQzone, this.jdField_a_of_type_Ayub.fontId, this.jdField_a_of_type_Ayub.superFontId, true, (Bundle)localObject2);
      break;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.iO = ((RelativeLayout)y(2131367260));
    this.n = ((CheckBox)y(2131367310));
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText = ((ExtendEditText)y(2131367261));
    this.fc = ((Button)y(2131367304));
    this.zI = y(2131367309);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setEditableFactory(aofw.a);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaViewExtendEditText.setOnClickListener(this);
    this.fc.setOnClickListener(this);
    if (!this.jdField_a_of_type_Ayub.bxH) {
      this.fc.setVisibility(8);
    }
    if ((this.jdField_a_of_type_Ayub.isTopic) || (this.jdField_a_of_type_Ayub.bxE))
    {
      this.fc.setVisibility(8);
      this.n.setVisibility(0);
      this.n.setOnCheckedChangeListener(new ayua(this));
      this.n.setChecked(true);
    }
    if (iT(QQStoryContext.a().mi())) {
      cvH();
    }
  }
  
  public void p(int paramInt, Object paramObject)
  {
    int i = 8;
    switch (paramInt)
    {
    default: 
      this.iO.setVisibility(8);
      return;
    case 0: 
      paramObject = this.iO;
      paramInt = i;
      if (this.jdField_a_of_type_Ayub.bxD) {
        paramInt = 0;
      }
      paramObject.setVisibility(paramInt);
      return;
    case 7: 
      this.iO.setVisibility(8);
      return;
    }
    this.iO.setVisibility(8);
  }
  
  public void uy()
  {
    this.uN = awhu.gK(this.jdField_a_of_type_Ayub.mPriv);
    this.fc.setText(this.uN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aytz
 * JD-Core Version:    0.7.0.1
 */