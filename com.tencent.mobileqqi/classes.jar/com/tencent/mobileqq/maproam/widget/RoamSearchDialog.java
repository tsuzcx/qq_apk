package com.tencent.mobileqq.maproam.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.maproam.data.LocationDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import gcc;
import gcd;
import gce;
import gcf;
import gci;
import gck;
import java.util.ArrayList;
import java.util.List;

public class RoamSearchDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static final int a = 10;
  public static final String a;
  public static final int b = 20000;
  public static final int c = 10000;
  public static final int d = 8192;
  public static final int e = 10;
  public static final int f = 20000;
  public static final int g = 10000;
  public static final int h = 0;
  public static final int i = 1;
  public static final int j = 10;
  public long a;
  public Context a;
  public Button a;
  public EditText a;
  public ImageButton a;
  public TextView a;
  public QQAppInterface a;
  public RoamSearchDialog.OnRoamResultObserver a;
  public RoamSearchDialog.OnSearchResultItemClick a;
  public XListView a;
  public gck a;
  public List a;
  public String b;
  public int k = 1;
  
  static
  {
    jdField_a_of_type_JavaLangString = RoamSearchDialog.class.getSimpleName();
  }
  
  public RoamSearchDialog(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = "北京";
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    requestWindowFeature(1);
    getWindow().setSoftInputMode(36);
    getWindow().setBackgroundDrawable(new ColorDrawable());
    setContentView(2130903279);
    paramContext = getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.windowAnimations = 16973824;
    paramContext.gravity = 51;
    a();
    b();
    c();
    d();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131231401));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_Gck = new gck(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Gck);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new gcc(this));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new gcd(this));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131231402));
    this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131562494);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131233086));
    this.jdField_a_of_type_AndroidWidgetEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(15) });
    this.jdField_a_of_type_AndroidWidgetEditText.setHint(2131563055);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new gce(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setImeOptions(3);
    gci localgci = new gci(this, null);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(localgci);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(localgci);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)findViewById(2131233087));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233085));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void e()
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_Long = l;
      this.k = 1;
      a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString(), this.jdField_b_of_type_JavaLangString, 10, this.k);
    }
  }
  
  public void a(RoamSearchDialog.OnRoamResultObserver paramOnRoamResultObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnRoamResultObserver = paramOnRoamResultObserver;
  }
  
  public void a(RoamSearchDialog.OnSearchResultItemClick paramOnSearchResultItemClick)
  {
    this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick = paramOnSearchResultItemClick;
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetXListView.a() != this.jdField_a_of_type_Gck) || (this.jdField_a_of_type_Gck.getItemViewType(paramInt) == 1)) {}
    LocationDetail localLocationDetail;
    do
    {
      return;
      localLocationDetail = (LocationDetail)this.jdField_a_of_type_Gck.getItem(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqMaproamWidgetRoamSearchDialog$OnSearchResultItemClick.a(paramAdapterView, paramView, paramInt, localLocationDetail);
    } while (!QLog.isColorLevel());
    QLog.i(jdField_a_of_type_JavaLangString, 2, "current click location, lat = " + localLocationDetail.jdField_a_of_type_Double + ", lon = " + localLocationDetail.jdField_b_of_type_Double);
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "search poi, currentKeyword = " + paramString1 + ", region = " + paramString2);
    }
    if (paramInt2 == 1) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new gcf(this, paramString1, paramString2, paramInt1, paramInt2));
  }
  
  /* Error */
  public void b(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: astore 6
    //   3: aload_2
    //   4: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +7 -> 14
    //   10: ldc 63
    //   12: astore 6
    //   14: new 300	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 353
    //   24: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokestatic 359	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 361
    //   37: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 6
    //   42: invokestatic 359	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   45: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 363
    //   51: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 365
    //   57: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_3
    //   61: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 370
    //   67: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: iload 4
    //   72: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: astore_1
    //   79: new 372	org/apache/http/params/BasicHttpParams
    //   82: dup
    //   83: invokespecial 373	org/apache/http/params/BasicHttpParams:<init>	()V
    //   86: astore_2
    //   87: aload_2
    //   88: ldc2_w 374
    //   91: invokestatic 381	org/apache/http/conn/params/ConnManagerParams:setTimeout	(Lorg/apache/http/params/HttpParams;J)V
    //   94: aload_2
    //   95: new 383	org/apache/http/conn/params/ConnPerRouteBean
    //   98: dup
    //   99: bipush 10
    //   101: invokespecial 384	org/apache/http/conn/params/ConnPerRouteBean:<init>	(I)V
    //   104: invokestatic 388	org/apache/http/conn/params/ConnManagerParams:setMaxConnectionsPerRoute	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V
    //   107: aload_2
    //   108: bipush 10
    //   110: invokestatic 392	org/apache/http/conn/params/ConnManagerParams:setMaxTotalConnections	(Lorg/apache/http/params/HttpParams;I)V
    //   113: aload_2
    //   114: sipush 10000
    //   117: invokestatic 397	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   120: aload_2
    //   121: sipush 20000
    //   124: invokestatic 400	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   127: aload_2
    //   128: iconst_1
    //   129: invokestatic 404	org/apache/http/params/HttpConnectionParams:setTcpNoDelay	(Lorg/apache/http/params/HttpParams;Z)V
    //   132: aload_2
    //   133: sipush 8192
    //   136: invokestatic 407	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   139: aload_2
    //   140: getstatic 413	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   143: invokestatic 419	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   146: aload_2
    //   147: ldc_w 421
    //   150: invokestatic 425	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   153: new 427	org/apache/http/impl/client/DefaultHttpClient
    //   156: dup
    //   157: aload_2
    //   158: invokespecial 430	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 71	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   166: aload_2
    //   167: invokestatic 435	com/tencent/mobileqq/utils/ReverseGeocode:a	(Landroid/content/Context;Lorg/apache/http/client/HttpClient;)V
    //   170: new 437	java/io/BufferedReader
    //   173: dup
    //   174: new 439	java/io/InputStreamReader
    //   177: dup
    //   178: aload_2
    //   179: new 441	org/apache/http/client/methods/HttpGet
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 443	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   187: invokeinterface 449 2 0
    //   192: invokeinterface 455 1 0
    //   197: invokeinterface 461 1 0
    //   202: invokespecial 464	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   205: invokespecial 467	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   208: astore 6
    //   210: ldc_w 469
    //   213: astore_1
    //   214: aload 6
    //   216: invokevirtual 472	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   219: astore 7
    //   221: aload_1
    //   222: astore_2
    //   223: aload 7
    //   225: ifnull +39 -> 264
    //   228: new 300	java/lang/StringBuilder
    //   231: dup
    //   232: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   235: aload_1
    //   236: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload 7
    //   241: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: astore_2
    //   248: aload_2
    //   249: astore_1
    //   250: goto -36 -> 214
    //   253: astore_2
    //   254: ldc_w 469
    //   257: astore_1
    //   258: aload_2
    //   259: invokevirtual 475	java/io/IOException:printStackTrace	()V
    //   262: aload_1
    //   263: astore_2
    //   264: new 477	org/json/JSONObject
    //   267: dup
    //   268: aload_2
    //   269: invokespecial 478	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload_2
    //   274: ldc_w 480
    //   277: invokevirtual 484	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   280: istore_3
    //   281: aload_2
    //   282: ldc_w 486
    //   285: invokevirtual 489	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 6
    //   290: new 491	android/os/Handler
    //   293: dup
    //   294: invokestatic 497	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   297: invokespecial 500	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   300: astore_1
    //   301: iload_3
    //   302: ifeq +64 -> 366
    //   305: invokestatic 298	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   308: ifeq +41 -> 349
    //   311: getstatic 49	com/tencent/mobileqq/maproam/widget/RoamSearchDialog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   314: iconst_2
    //   315: new 300	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 301	java/lang/StringBuilder:<init>	()V
    //   322: ldc_w 502
    //   325: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: iload_3
    //   329: invokevirtual 368	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 504
    //   335: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 6
    //   340: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 318	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 321	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_1
    //   350: new 506	gcg
    //   353: dup
    //   354: aload_0
    //   355: iload_3
    //   356: aload 6
    //   358: invokespecial 509	gcg:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;ILjava/lang/String;)V
    //   361: invokevirtual 513	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   364: pop
    //   365: return
    //   366: aload_2
    //   367: ldc_w 515
    //   370: invokevirtual 484	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   373: istore 4
    //   375: aload_2
    //   376: ldc_w 517
    //   379: invokevirtual 521	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   382: astore_2
    //   383: new 57	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 59	java/util/ArrayList:<init>	()V
    //   390: astore 6
    //   392: iconst_0
    //   393: istore_3
    //   394: aload_2
    //   395: invokevirtual 527	org/json/JSONArray:length	()I
    //   398: istore 5
    //   400: iload_3
    //   401: iload 5
    //   403: if_icmpge +201 -> 604
    //   406: aload_2
    //   407: iload_3
    //   408: invokevirtual 531	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   411: astore 8
    //   413: new 288	com/tencent/mobileqq/maproam/data/LocationDetail
    //   416: dup
    //   417: invokespecial 532	com/tencent/mobileqq/maproam/data/LocationDetail:<init>	()V
    //   420: astore 7
    //   422: aload 8
    //   424: ldc_w 534
    //   427: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   430: ifeq +16 -> 446
    //   433: aload 7
    //   435: aload 8
    //   437: ldc_w 534
    //   440: invokevirtual 489	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   443: putfield 539	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   446: aload 8
    //   448: ldc_w 541
    //   451: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   454: ifeq +16 -> 470
    //   457: aload 7
    //   459: aload 8
    //   461: ldc_w 541
    //   464: invokevirtual 489	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   467: putfield 542	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   470: aload 8
    //   472: ldc_w 544
    //   475: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   478: ifeq +16 -> 494
    //   481: aload 7
    //   483: aload 8
    //   485: ldc_w 544
    //   488: invokevirtual 489	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: putfield 546	com/tencent/mobileqq/maproam/data/LocationDetail:c	Ljava/lang/String;
    //   494: aload 8
    //   496: ldc_w 548
    //   499: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   502: ifeq +16 -> 518
    //   505: aload 7
    //   507: aload 8
    //   509: ldc_w 548
    //   512: invokevirtual 489	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   515: putfield 550	com/tencent/mobileqq/maproam/data/LocationDetail:d	Ljava/lang/String;
    //   518: aload 8
    //   520: ldc_w 552
    //   523: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   526: ifeq +61 -> 587
    //   529: aload 8
    //   531: ldc_w 552
    //   534: invokevirtual 556	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   537: astore 8
    //   539: aload 8
    //   541: ldc_w 558
    //   544: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   547: ifeq +16 -> 563
    //   550: aload 7
    //   552: aload 8
    //   554: ldc_w 558
    //   557: invokevirtual 562	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   560: putfield 310	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_a_of_type_Double	D
    //   563: aload 8
    //   565: ldc_w 564
    //   568: invokevirtual 538	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   571: ifeq +16 -> 587
    //   574: aload 7
    //   576: aload 8
    //   578: ldc_w 564
    //   581: invokevirtual 562	org/json/JSONObject:getDouble	(Ljava/lang/String;)D
    //   584: putfield 317	com/tencent/mobileqq/maproam/data/LocationDetail:jdField_b_of_type_Double	D
    //   587: aload 6
    //   589: aload 7
    //   591: invokeinterface 568 2 0
    //   596: pop
    //   597: iload_3
    //   598: iconst_1
    //   599: iadd
    //   600: istore_3
    //   601: goto -201 -> 400
    //   604: aload_1
    //   605: new 570	gch
    //   608: dup
    //   609: aload_0
    //   610: aload 6
    //   612: iload 4
    //   614: invokespecial 573	gch:<init>	(Lcom/tencent/mobileqq/maproam/widget/RoamSearchDialog;Ljava/util/List;I)V
    //   617: invokevirtual 513	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   620: pop
    //   621: return
    //   622: astore_1
    //   623: return
    //   624: astore_2
    //   625: goto -367 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	RoamSearchDialog
    //   0	628	1	paramString1	String
    //   0	628	2	paramString2	String
    //   0	628	3	paramInt1	int
    //   0	628	4	paramInt2	int
    //   398	6	5	m	int
    //   1	610	6	localObject1	Object
    //   219	371	7	localObject2	Object
    //   411	166	8	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   170	210	253	java/io/IOException
    //   264	301	622	org/json/JSONException
    //   305	349	622	org/json/JSONException
    //   349	365	622	org/json/JSONException
    //   366	392	622	org/json/JSONException
    //   394	400	622	org/json/JSONException
    //   406	446	622	org/json/JSONException
    //   446	470	622	org/json/JSONException
    //   470	494	622	org/json/JSONException
    //   494	518	622	org/json/JSONException
    //   518	563	622	org/json/JSONException
    //   563	587	622	org/json/JSONException
    //   587	597	622	org/json/JSONException
    //   604	621	622	org/json/JSONException
    //   214	221	624	java/io/IOException
    //   228	248	624	java/io/IOException
  }
  
  public void dismiss()
  {
    ((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131233086: 
    default: 
    case 2131233087: 
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidWidgetEditText == null);
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.maproam.widget.RoamSearchDialog
 * JD-Core Version:    0.7.0.1
 */