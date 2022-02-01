import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.mobileqq.troop.activity.PublicCommentWindow.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class aost
  extends ReportDialog
  implements afmf, View.OnClickListener, InputMethodRelativeLayout.a
{
  protected long Ap;
  protected ArrayList<String> By;
  public ImageView Ea;
  protected Button X;
  protected aost.a a;
  public SystemAndEmojiEmoticonPanel a;
  protected String aEt;
  protected EditText ai;
  protected JSONObject bO;
  protected FrameLayout bW;
  protected String bwy;
  protected InputMethodRelativeLayout c;
  protected boolean cOn;
  public boolean cOy;
  protected int dRF;
  protected int dRG;
  public BaseActivity mActivity;
  protected Handler mHandler;
  protected String uP;
  
  public aost(BaseActivity paramBaseActivity, Bundle paramBundle)
  {
    super(paramBaseActivity);
    requestWindowFeature(1);
    this.mActivity = paramBaseActivity;
    initData(paramBundle);
  }
  
  protected void Si(String paramString)
  {
    try
    {
      aija.a("qbrowserCommentOnSend", new JSONObject(TroopBarPublishUtils.a(paramString, null, null)), this.By, null);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("PublicCommentPopupWindow", 2, QLog.getStackTraceString(paramString));
    }
  }
  
  protected void T(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString1)) && ((this.mActivity instanceof aqzs)))
    {
      localObject = ((aqzs)this.mActivity).c();
      if (localObject != null)
      {
        localObject = ((WebViewFragment)localObject).getWebView();
        if (localObject != null)
        {
          if (!paramBoolean) {
            break label90;
          }
          ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":0,\"data\":{\"retcode\":0,\"result\":" + paramString2 + "}}" });
        }
      }
    }
    return;
    label90:
    ((CustomWebView)localObject).callJs(paramString1, new String[] { "{\"code\":-1}" });
  }
  
  public void a(afmi paramafmi)
  {
    paramafmi.a(null, this.mActivity, this.ai, null);
  }
  
  public void a(afmi paramafmi1, afmi paramafmi2, Drawable paramDrawable) {}
  
  public boolean a(afmi paramafmi)
  {
    return false;
  }
  
  protected boolean aAy()
  {
    String str = (String)aprv.ov.get(this.uP);
    aprv.ov.clear();
    if (!TextUtils.isEmpty(str))
    {
      this.ai.setText(str);
      this.ai.setSelection(str.length());
      return true;
    }
    return false;
  }
  
  public void b(afmi paramafmi) {}
  
  public void cj(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    paramActivity = LayoutInflater.from(paramActivity).inflate(2131560109, null);
    setContentView(paramActivity);
    gz(paramActivity);
    aAy();
    super.show();
    paramActivity = getWindow().getAttributes();
    paramActivity.x = 0;
    paramActivity.y = 0;
    paramActivity.width = -1;
    paramActivity.windowAnimations = 16973824;
    paramActivity.gravity = 83;
    paramActivity.softInputMode = 21;
    getWindow().setBackgroundDrawable(new ColorDrawable());
    if (QLog.isColorLevel()) {
      QLog.d("PublicCommentPopupWindow", 2, "PublicCommentWindow show time = " + (System.currentTimeMillis() - l));
    }
  }
  
  protected void dJN()
  {
    String str = this.ai.getEditableText().toString();
    if (!TextUtils.isEmpty(str)) {
      aprv.ov.put(this.uP, str);
    }
  }
  
  public void delete()
  {
    aofy.g(this.ai);
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Aost$a != null)
    {
      this.mActivity.unregisterReceiver(this.jdField_a_of_type_Aost$a);
      this.jdField_a_of_type_Aost$a = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = null;
    }
    aurd.hide(this.ai);
    if (!this.cOn) {
      dJN();
    }
    aija.a("qbrowserCommentOnClose", null, this.By, null);
    super.dismiss();
  }
  
  public void gq() {}
  
  protected void gz(View paramView)
  {
    this.c = ((InputMethodRelativeLayout)paramView.findViewById(2131377546));
    this.Ea = ((ImageView)paramView.findViewById(2131366307));
    this.ai = ((EditText)paramView.findViewById(2131369276));
    this.X = ((Button)paramView.findViewById(2131377990));
    this.bW = ((FrameLayout)paramView.findViewById(2131370190));
    this.Ea.setOnClickListener(this);
    this.X.setSelected(true);
    this.X.setEnabled(true);
    this.X.setOnClickListener(this);
    paramView.findViewById(2131380165).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel = TroopBarPublishUtils.a(this.mActivity, this.bW, this.ai, this);
    this.c.setOnSizeChangedListenner(this);
    this.mHandler = new Handler();
    this.ai.setHint(this.bwy);
  }
  
  /* Error */
  protected void initData(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 371
    //   4: invokevirtual 377	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_2
    //   8: aload_0
    //   9: aload_1
    //   10: ldc_w 379
    //   13: invokevirtual 377	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   16: putfield 381	aost:aEt	Ljava/lang/String;
    //   19: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +29 -> 51
    //   25: ldc 92
    //   27: iconst_2
    //   28: new 123	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 383
    //   38: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_2
    //   42: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: new 70	org/json/JSONObject
    //   55: dup
    //   56: aload_2
    //   57: invokespecial 77	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: putfield 385	aost:bO	Lorg/json/JSONObject;
    //   63: aload_0
    //   64: aload_0
    //   65: getfield 385	aost:bO	Lorg/json/JSONObject;
    //   68: ldc_w 387
    //   71: invokevirtual 390	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   74: putfield 165	aost:uP	Ljava/lang/String;
    //   77: aload_0
    //   78: aload_0
    //   79: getfield 385	aost:bO	Lorg/json/JSONObject;
    //   82: ldc_w 392
    //   85: invokevirtual 396	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   88: putfield 398	aost:dRF	I
    //   91: aload_0
    //   92: aload_0
    //   93: getfield 385	aost:bO	Lorg/json/JSONObject;
    //   96: ldc_w 400
    //   99: invokevirtual 396	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   102: putfield 402	aost:dRG	I
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 385	aost:bO	Lorg/json/JSONObject;
    //   110: ldc_w 404
    //   113: invokevirtual 390	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: putfield 364	aost:bwy	Ljava/lang/String;
    //   119: aload_0
    //   120: new 406	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 407	java/util/ArrayList:<init>	()V
    //   127: putfield 79	aost:By	Ljava/util/ArrayList;
    //   130: aload_0
    //   131: getfield 385	aost:bO	Lorg/json/JSONObject;
    //   134: ldc_w 409
    //   137: invokevirtual 390	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 415	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   143: astore_1
    //   144: aload_0
    //   145: getfield 79	aost:By	Ljava/util/ArrayList;
    //   148: aload_1
    //   149: invokevirtual 418	android/net/Uri:getHost	()Ljava/lang/String;
    //   152: invokevirtual 422	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   155: pop
    //   156: aload_0
    //   157: new 12	aost$a
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 425	aost$a:<init>	(Laost;)V
    //   165: putfield 287	aost:jdField_a_of_type_Aost$a	Laost$a;
    //   168: new 427	android/content/IntentFilter
    //   171: dup
    //   172: ldc_w 429
    //   175: invokespecial 430	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   178: astore_1
    //   179: aload_0
    //   180: getfield 57	aost:mActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   183: aload_0
    //   184: getfield 287	aost:jdField_a_of_type_Aost$a	Laost$a;
    //   187: aload_1
    //   188: invokevirtual 434	com/tencent/mobileqq/app/BaseActivity:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   191: pop
    //   192: return
    //   193: astore_1
    //   194: aload_0
    //   195: invokevirtual 435	aost:dismiss	()V
    //   198: return
    //   199: astore_1
    //   200: aload_0
    //   201: invokevirtual 435	aost:dismiss	()V
    //   204: return
    //   205: astore_1
    //   206: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -53 -> 156
    //   212: ldc 92
    //   214: iconst_2
    //   215: aload_1
    //   216: invokestatic 96	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   219: invokestatic 100	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: goto -66 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	aost
    //   0	225	1	paramBundle	Bundle
    //   7	50	2	str	String
    // Exception table:
    //   from	to	target	type
    //   51	63	193	org/json/JSONException
    //   51	63	199	java/lang/NullPointerException
    //   130	156	205	java/lang/NullPointerException
  }
  
  public void l(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        aija.a("qbrowserCommentOnCreate", null, this.By, null);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
        }
        this.Ea.setImageResource(2130848765);
        this.Ea.setContentDescription(this.mActivity.getString(2131698477));
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() != 8) || (this.cOy));
    dismiss();
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
      dismiss();
      continue;
      if (System.currentTimeMillis() - this.Ap >= 500L)
      {
        this.Ap = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.getVisibility() == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemAndEmojiEmoticonPanel.setVisibility(8);
          aurd.aO(this.ai);
          this.Ea.setImageResource(2130848765);
          this.Ea.setContentDescription(this.mActivity.getString(2131698477));
        }
        else
        {
          this.cOy = true;
          aurd.hide(this.ai);
          this.mHandler.postDelayed(new PublicCommentWindow.1(this), 200L);
          continue;
          send();
        }
      }
    }
  }
  
  public void send()
  {
    String str = aprv.f(this.ai);
    if (!TextUtils.isEmpty(str)) {
      str = str.trim();
    }
    for (int i = str.length();; i = 0)
    {
      if (i == 0)
      {
        QQToast.a(this.mActivity, 2131698495, 0).show(this.mActivity.getTitleBarHeight());
        return;
      }
      if (i < this.dRG)
      {
        QQToast.a(this.mActivity, this.mActivity.getString(2131698493, new Object[] { Integer.valueOf(this.dRG) }), 0).show(this.mActivity.getTitleBarHeight());
        return;
      }
      if (i > this.dRF)
      {
        QQToast.a(this.mActivity, this.mActivity.getString(2131698494, new Object[] { Integer.valueOf(this.dRF) }), 0).show(this.mActivity.getTitleBarHeight());
        return;
      }
      if (!jqc.ak(this.mActivity))
      {
        QQToast.a(this.mActivity, 2131696206, 0).show(this.mActivity.getTitleBarHeight());
        return;
      }
      Si(str);
      return;
    }
  }
  
  public void setting() {}
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramIntent.getAction())) && ("CommentSendSuccess".equals(paramIntent.getStringExtra("event"))))
      {
        aost.this.cOn = true;
        aost.this.dismiss();
        if (QLog.isColorLevel()) {
          QLog.d("PublicCommentPopupWindow", 2, "web call finish----------------");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aost
 * JD-Core Version:    0.7.0.1
 */