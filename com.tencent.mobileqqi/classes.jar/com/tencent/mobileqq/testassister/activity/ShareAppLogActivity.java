package com.tencent.mobileqq.testassister.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Time;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.mobileqq.testassister.ShareAppLogHelper.OnGetLocalLogListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.widget.Switch;
import com.tencent.widget.TCWDatePickerDialogHelper;
import gmh;
import gmi;
import gmj;
import gmm;
import gmn;
import gmo;

public class ShareAppLogActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new gmh(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new gmi(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ShareAppLogHelper.OnGetLocalLogListener jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener = new gmj(this);
  private ShareAppLogHelper jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Switch jdField_a_of_type_ComTencentWidgetSwitch;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  
  private int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, ShareAppLogActivity.class);
  }
  
  private String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  private void a(TextView paramTextView)
  {
    Time localTime = ShareAppLogHelper.a(paramTextView.getEditableText().toString(), "-");
    if (localTime == null) {
      return;
    }
    int i = localTime.year;
    int j = localTime.month;
    int k = localTime.monthDay;
    try
    {
      TCWDatePickerDialogHelper.a(this, i, j + 1, k, new gmo(this, paramTextView));
      return;
    }
    catch (Exception paramTextView) {}
  }
  
  private void a(String paramString)
  {
    paramString = new FileInfo(paramString);
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramString);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(localFileManagerEntity.nSessionId);
    localForwardFileInfo.c(3);
    localForwardFileInfo.a(10000);
    localForwardFileInfo.a(paramString.c());
    localForwardFileInfo.d(paramString.d());
    localForwardFileInfo.d(paramString.a());
    a(localForwardFileInfo);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new gmm(this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new gmn(this));
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent(this, ChatActivity.class);
    localIntent.putExtras(new Bundle(paramBundle));
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    startActivity(localIntent);
    finish();
  }
  
  public void a(ForwardFileInfo paramForwardFileInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelable("fileinfo", paramForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    Intent localIntent = new Intent(this, ForwardRecentActivity.class);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_text", paramForwardFileInfo.d());
    localIntent.putExtra("forward_type", 0);
    startActivityForResult(localIntent, 103);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      return;
    } while ((paramIntent == null) || (paramIntent.getExtras() == null));
    a(paramIntent.getExtras());
  }
  
  /* Error */
  public void onClick(android.view.View paramView)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 257	android/view/View:getId	()I
    //   4: lookupswitch	default:+44->48, 2131233148:+279->283, 2131233152:+288->292, 2131233156:+45->49, 2131233158:+297->301
    //   49: aload_0
    //   50: getfield 259	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   53: invokevirtual 99	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   56: invokevirtual 102	java/lang/Object:toString	()Ljava/lang/String;
    //   59: astore 8
    //   61: aload_0
    //   62: getfield 261	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   65: invokevirtual 99	android/widget/TextView:getEditableText	()Landroid/text/Editable;
    //   68: invokevirtual 102	java/lang/Object:toString	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_0
    //   73: getfield 263	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   76: invokevirtual 266	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   79: invokevirtual 102	java/lang/Object:toString	()Ljava/lang/String;
    //   82: invokestatic 272	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   85: istore_2
    //   86: aload_0
    //   87: getfield 274	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetEditText	Landroid/widget/EditText;
    //   90: invokevirtual 266	android/widget/EditText:getEditableText	()Landroid/text/Editable;
    //   93: invokevirtual 102	java/lang/Object:toString	()Ljava/lang/String;
    //   96: invokestatic 272	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore_3
    //   100: iload_2
    //   101: iflt +19 -> 120
    //   104: iload_2
    //   105: bipush 24
    //   107: if_icmpge +13 -> 120
    //   110: iload_3
    //   111: iflt +9 -> 120
    //   114: iload_3
    //   115: bipush 24
    //   117: if_icmplt +18 -> 135
    //   120: aload_0
    //   121: invokevirtual 278	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   124: ldc_w 280
    //   127: iconst_0
    //   128: invokestatic 285	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   131: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()V
    //   134: return
    //   135: new 67	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   142: aload 8
    //   144: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 77
    //   149: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload_2
    //   153: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: ldc 77
    //   161: invokestatic 107	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   164: astore 8
    //   166: new 67	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   173: aload_1
    //   174: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc 77
    //   179: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload_3
    //   183: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: ldc 77
    //   191: invokestatic 107	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/text/format/Time;
    //   194: astore_1
    //   195: aload 8
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: ifnonnull +18 -> 219
    //   204: aload_0
    //   205: invokevirtual 278	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   208: ldc_w 289
    //   211: iconst_0
    //   212: invokestatic 285	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   215: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()V
    //   218: return
    //   219: aload_1
    //   220: aload 8
    //   222: invokevirtual 293	android/text/format/Time:before	(Landroid/text/format/Time;)Z
    //   225: ifeq +18 -> 243
    //   228: aload_0
    //   229: invokevirtual 278	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   232: ldc_w 280
    //   235: iconst_0
    //   236: invokestatic 285	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   239: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()V
    //   242: return
    //   243: aload_0
    //   244: getfield 60	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper	Lcom/tencent/mobileqq/testassister/ShareAppLogHelper;
    //   247: aload 8
    //   249: aload_1
    //   250: aload_0
    //   251: getfield 295	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_ComTencentWidgetSwitch	Lcom/tencent/widget/Switch;
    //   254: invokevirtual 301	com/tencent/widget/Switch:isChecked	()Z
    //   257: invokevirtual 304	com/tencent/mobileqq/testassister/ShareAppLogHelper:a	(Landroid/text/format/Time;Landroid/text/format/Time;Z)Z
    //   260: ifeq +8 -> 268
    //   263: aload_0
    //   264: invokespecial 168	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:d	()V
    //   267: return
    //   268: aload_0
    //   269: invokevirtual 278	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   272: ldc_w 306
    //   275: iconst_0
    //   276: invokestatic 285	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   279: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()V
    //   282: return
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 259	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   288: invokespecial 308	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   291: return
    //   292: aload_0
    //   293: aload_0
    //   294: getfield 261	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   297: invokespecial 308	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Landroid/widget/TextView;)V
    //   300: return
    //   301: new 310	java/io/File
    //   304: dup
    //   305: new 67	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   312: invokestatic 316	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   315: invokevirtual 319	java/io/File:getPath	()Ljava/lang/String;
    //   318: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 321
    //   324: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   333: astore 10
    //   335: aconst_null
    //   336: astore 9
    //   338: aconst_null
    //   339: astore_1
    //   340: aload 9
    //   342: astore 8
    //   344: aload 10
    //   346: invokevirtual 325	java/io/File:exists	()Z
    //   349: ifeq +133 -> 482
    //   352: aload 9
    //   354: astore 8
    //   356: aload 10
    //   358: invokevirtual 328	java/io/File:isDirectory	()Z
    //   361: ifeq +121 -> 482
    //   364: aload 10
    //   366: invokevirtual 332	java/io/File:listFiles	()[Ljava/io/File;
    //   369: astore 10
    //   371: aload 9
    //   373: astore 8
    //   375: aload 10
    //   377: ifnull +105 -> 482
    //   380: lconst_0
    //   381: lstore 4
    //   383: iconst_0
    //   384: istore_2
    //   385: aload_1
    //   386: astore 8
    //   388: iload_2
    //   389: aload 10
    //   391: arraylength
    //   392: if_icmpge +90 -> 482
    //   395: lload 4
    //   397: lstore 6
    //   399: aload_1
    //   400: astore 8
    //   402: aload 10
    //   404: iload_2
    //   405: aaload
    //   406: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   409: ldc_w 337
    //   412: invokevirtual 343	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   415: ifeq +96 -> 511
    //   418: lload 4
    //   420: lstore 6
    //   422: aload_1
    //   423: astore 8
    //   425: aload 10
    //   427: iload_2
    //   428: aaload
    //   429: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   432: ldc_w 345
    //   435: invokevirtual 348	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   438: ifeq +73 -> 511
    //   441: lload 4
    //   443: lstore 6
    //   445: aload_1
    //   446: astore 8
    //   448: aload 10
    //   450: iload_2
    //   451: aaload
    //   452: invokevirtual 351	java/io/File:lastModified	()J
    //   455: lload 4
    //   457: lcmp
    //   458: ifle +53 -> 511
    //   461: aload 10
    //   463: iload_2
    //   464: aaload
    //   465: invokevirtual 319	java/io/File:getPath	()Ljava/lang/String;
    //   468: astore 8
    //   470: aload 10
    //   472: iload_2
    //   473: aaload
    //   474: invokevirtual 351	java/io/File:lastModified	()J
    //   477: lstore 6
    //   479: goto +32 -> 511
    //   482: aload 8
    //   484: ifnull +10 -> 494
    //   487: aload_0
    //   488: aload 8
    //   490: invokespecial 124	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:a	(Ljava/lang/String;)V
    //   493: return
    //   494: aload_0
    //   495: invokevirtual 278	com/tencent/mobileqq/testassister/activity/ShareAppLogActivity:getApplicationContext	()Landroid/content/Context;
    //   498: ldc_w 353
    //   501: iconst_0
    //   502: invokestatic 285	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   505: invokevirtual 287	com/tencent/mobileqq/widget/QQToast:a	()V
    //   508: return
    //   509: astore_1
    //   510: return
    //   511: iload_2
    //   512: iconst_1
    //   513: iadd
    //   514: istore_2
    //   515: lload 6
    //   517: lstore 4
    //   519: aload 8
    //   521: astore_1
    //   522: goto -137 -> 385
    //   525: astore_1
    //   526: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	ShareAppLogActivity
    //   0	527	1	paramView	android.view.View
    //   85	430	2	i	int
    //   99	84	3	j	int
    //   381	137	4	l1	long
    //   397	119	6	l2	long
    //   59	461	8	localObject1	Object
    //   336	36	9	localObject2	Object
    //   333	138	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   72	100	509	java/lang/Exception
    //   301	335	525	java/lang/Exception
    //   344	352	525	java/lang/Exception
    //   356	371	525	java/lang/Exception
    //   388	395	525	java/lang/Exception
    //   402	418	525	java/lang/Exception
    //   425	441	525	java/lang/Exception
    //   448	479	525	java/lang/Exception
    //   487	493	525	java/lang/Exception
    //   494	508	525	java/lang/Exception
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903628);
    setTitle(2131562848);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233148));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233152));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131233147));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131233151));
    this.jdField_a_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setInputType(4);
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper = new ShareAppLogHelper(getApplicationContext());
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper$OnGetLocalLogListener);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis() - 7200000L));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(System.currentTimeMillis()));
    this.jdField_a_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis() - 7200000L)) }));
    this.jdField_b_of_type_AndroidWidgetEditText.setText(String.format("%02d", new Object[] { Integer.valueOf(a(System.currentTimeMillis())) }));
    this.jdField_a_of_type_ComTencentWidgetSwitch = ((Switch)findViewById(2131233154));
    this.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(true);
    this.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233156));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131233158));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqTestassisterShareAppLogHelper.a(null);
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.testassister.activity.ShareAppLogActivity
 * JD-Core Version:    0.7.0.1
 */