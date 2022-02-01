package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqgz;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable;
import com.tencent.biz.pubaccount.readinjoy.notecard.SoundCheckRunnable.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.e;
import jll;
import lae;
import lie;
import ljp;
import lwk;
import lwm.a;
import mbc;
import mbd;
import mbe;
import mhz;
import mqq.app.AppRuntime;
import ndc;
import ndi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComponentContentNoteCard
  extends RelativeLayout
  implements SoundCheckRunnable.a, AbsListView.e, lwk, ndc
{
  private SoundCheckRunnable jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable;
  private ComponentNotIntrest jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest;
  private ReadInJoyXListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  private mhz jdField_a_of_type_Mhz;
  private Object aP;
  private boolean akI;
  private LottieDrawable b;
  private RelativeLayout i;
  private ImageView jf;
  private ImageView jg;
  private ImageView jh;
  private ImageView ji;
  private TextView km;
  private TextView kn;
  private boolean mIsResume;
  private int mScrollState = 0;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private TextView qm;
  private TextView qn;
  
  public ComponentContentNoteCard(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentNoteCard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public ComponentContentNoteCard(Context paramContext, ndi paramndi)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)paramndi.b());
    init(paramContext);
  }
  
  private SpannableStringBuilder a(JSONArray paramJSONArray)
    throws Exception
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    int j = 0;
    while (j < paramJSONArray.length())
    {
      Object localObject = new JSONObject(paramJSONArray.get(j).toString());
      String str = ((JSONObject)localObject).optString("word", "    ");
      int k = Color.parseColor(((JSONObject)localObject).optString("color", "#C3C0D6"));
      int m = Integer.valueOf(((JSONObject)localObject).optString("size", "15")).intValue();
      localObject = new SpannableString(str);
      ((SpannableString)localObject).setSpan(new ForegroundColorSpan(k), 0, str.length(), 33);
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(m, true), 0, str.length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject);
      j += 1;
    }
    return localSpannableStringBuilder;
  }
  
  /* Error */
  private void a(TextView paramTextView, JSONObject paramJSONObject, float paramFloat)
  {
    // Byte code:
    //   0: ldc 171
    //   2: fstore 5
    //   4: fconst_0
    //   5: fstore 7
    //   7: aload_1
    //   8: ifnull +7 -> 15
    //   11: aload_2
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: new 89	org/json/JSONArray
    //   19: dup
    //   20: invokespecial 172	org/json/JSONArray:<init>	()V
    //   23: astore 11
    //   25: aload_2
    //   26: ldc 174
    //   28: invokevirtual 178	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   31: astore 10
    //   33: aload 10
    //   35: astore 11
    //   37: aload_0
    //   38: aload_2
    //   39: ldc 180
    //   41: invokespecial 184	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:c	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 10
    //   46: aload_0
    //   47: aload_2
    //   48: ldc 186
    //   50: invokespecial 184	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:c	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 12
    //   55: aload_0
    //   56: aload_2
    //   57: ldc 188
    //   59: invokespecial 184	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:c	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 193	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   65: invokevirtual 197	java/lang/Float:floatValue	()F
    //   68: fstore 6
    //   70: fload 6
    //   72: fstore 4
    //   74: aload_0
    //   75: aload_2
    //   76: ldc 199
    //   78: invokespecial 184	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:c	(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 193	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   84: invokevirtual 197	java/lang/Float:floatValue	()F
    //   87: fstore 8
    //   89: fload 8
    //   91: fstore 5
    //   93: fload 6
    //   95: fstore 4
    //   97: aload_0
    //   98: invokevirtual 203	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   101: fload 6
    //   103: invokestatic 209	riw:dip2px	(Landroid/content/Context;F)I
    //   106: i2f
    //   107: fstore 6
    //   109: fload 8
    //   111: fstore 5
    //   113: fload 6
    //   115: fstore 4
    //   117: aload_0
    //   118: invokevirtual 203	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:getContext	()Landroid/content/Context;
    //   121: fload 8
    //   123: invokestatic 209	riw:dip2px	(Landroid/content/Context;F)I
    //   126: istore 9
    //   128: iload 9
    //   130: i2f
    //   131: fstore 5
    //   133: fload 6
    //   135: fstore 4
    //   137: aload 10
    //   139: astore_2
    //   140: aload 12
    //   142: astore 10
    //   144: aload_1
    //   145: aload_0
    //   146: aload 11
    //   148: invokespecial 211	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentNoteCard:a	(Lorg/json/JSONArray;)Landroid/text/SpannableStringBuilder;
    //   151: invokevirtual 216	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   154: new 218	android/widget/RelativeLayout$LayoutParams
    //   157: dup
    //   158: bipush 254
    //   160: bipush 254
    //   162: invokespecial 221	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   165: astore 11
    //   167: aload_2
    //   168: ldc 223
    //   170: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   173: ifeq +135 -> 308
    //   176: aload 11
    //   178: bipush 9
    //   180: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   183: fconst_0
    //   184: fstore 8
    //   186: fload 4
    //   188: fstore 6
    //   190: fload 8
    //   192: fstore 4
    //   194: aload 10
    //   196: ldc 232
    //   198: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +165 -> 366
    //   204: aload 11
    //   206: bipush 10
    //   208: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   211: fload 5
    //   213: fstore 8
    //   215: aload_1
    //   216: aload 11
    //   218: invokevirtual 236	android/widget/TextView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   221: aload_1
    //   222: fload 6
    //   224: f2i
    //   225: fload 8
    //   227: f2i
    //   228: fload 4
    //   230: f2i
    //   231: fload 7
    //   233: f2i
    //   234: invokevirtual 240	android/widget/TextView:setPadding	(IIII)V
    //   237: aload_1
    //   238: fload_3
    //   239: invokevirtual 244	android/widget/TextView:setTextSize	(F)V
    //   242: return
    //   243: astore_2
    //   244: ldc 223
    //   246: astore 10
    //   248: ldc 232
    //   250: astore_2
    //   251: ldc 171
    //   253: fstore 4
    //   255: ldc 246
    //   257: iconst_1
    //   258: ldc 248
    //   260: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_2
    //   264: astore 12
    //   266: aload 10
    //   268: astore_2
    //   269: aload 12
    //   271: astore 10
    //   273: goto -129 -> 144
    //   276: astore 12
    //   278: ldc 246
    //   280: iconst_1
    //   281: new 256	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 257	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 259
    //   291: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload 11
    //   296: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 266	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 254	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: goto -151 -> 154
    //   308: aload_2
    //   309: ldc_w 268
    //   312: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +16 -> 331
    //   318: aload 11
    //   320: bipush 11
    //   322: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   325: fconst_0
    //   326: fstore 6
    //   328: goto -134 -> 194
    //   331: aload 11
    //   333: bipush 14
    //   335: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   338: fload 4
    //   340: fconst_0
    //   341: fcmpl
    //   342: ifle +13 -> 355
    //   345: fload 4
    //   347: fstore 6
    //   349: fconst_0
    //   350: fstore 4
    //   352: goto -158 -> 194
    //   355: fload 4
    //   357: fneg
    //   358: fstore 4
    //   360: fconst_0
    //   361: fstore 6
    //   363: goto -169 -> 194
    //   366: aload 10
    //   368: ldc_w 270
    //   371: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   374: ifeq +20 -> 394
    //   377: aload 11
    //   379: bipush 12
    //   381: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   384: fconst_0
    //   385: fstore 8
    //   387: fload 5
    //   389: fstore 7
    //   391: goto -176 -> 215
    //   394: aload 11
    //   396: bipush 15
    //   398: invokevirtual 230	android/widget/RelativeLayout$LayoutParams:addRule	(I)V
    //   401: fload 5
    //   403: fstore 8
    //   405: fload 5
    //   407: fconst_0
    //   408: fcmpl
    //   409: ifgt -194 -> 215
    //   412: fload 5
    //   414: fneg
    //   415: fstore 7
    //   417: fconst_0
    //   418: fstore 8
    //   420: goto -205 -> 215
    //   423: astore_2
    //   424: ldc 223
    //   426: astore 10
    //   428: ldc 232
    //   430: astore_2
    //   431: ldc 171
    //   433: fstore 4
    //   435: goto -180 -> 255
    //   438: astore_2
    //   439: ldc 232
    //   441: astore_2
    //   442: ldc 171
    //   444: fstore 4
    //   446: goto -191 -> 255
    //   449: astore_2
    //   450: ldc 171
    //   452: fstore 4
    //   454: aload 12
    //   456: astore_2
    //   457: goto -202 -> 255
    //   460: astore_2
    //   461: aload 12
    //   463: astore_2
    //   464: goto -209 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	ComponentContentNoteCard
    //   0	467	1	paramTextView	TextView
    //   0	467	2	paramJSONObject	JSONObject
    //   0	467	3	paramFloat	float
    //   72	381	4	f1	float
    //   2	411	5	f2	float
    //   68	294	6	f3	float
    //   5	411	7	f4	float
    //   87	332	8	f5	float
    //   126	3	9	j	int
    //   31	396	10	localObject1	Object
    //   23	372	11	localObject2	Object
    //   53	217	12	localObject3	Object
    //   276	186	12	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   25	33	243	java/lang/Exception
    //   144	154	276	java/lang/Exception
    //   37	46	423	java/lang/Exception
    //   46	55	438	java/lang/Exception
    //   55	70	449	java/lang/Exception
    //   74	89	460	java/lang/Exception
    //   97	109	460	java/lang/Exception
    //   117	128	460	java/lang/Exception
  }
  
  private void a(mhz parammhz)
  {
    for (;;)
    {
      try
      {
        a(this.km, new JSONObject(parammhz.py), 18.0F);
        a(this.kn, new JSONObject(parammhz.subTitle), 15.0F);
        this.jf.setVisibility(0);
        this.qm.setVisibility(0);
        this.qn.setVisibility(0);
        this.qm.setText(parammhz.ahF);
        String str = ljp.jx();
        Context localContext = getContext();
        if ((Build.VERSION.SDK_INT >= 23) && (localContext != null)) {
          if (localContext.checkSelfPermission("android.permission.RECORD_AUDIO") == 0)
          {
            j = 1;
            if ((j != 0) || (ljp.oH() != 1)) {
              continue;
            }
            this.qn.setText(getContext().getString(2131718455));
            this.qn.setOnClickListener(new mbc(this));
            b(this.jf, parammhz.ahG);
            b(this.jg, parammhz.backgroundUrl);
            this.ji.setOnClickListener(new mbd(this));
            this.jh.setVisibility(0);
            if (this.b != null) {
              this.b.stop();
            }
            if (TextUtils.isEmpty(parammhz.ahH)) {}
          }
        }
      }
      catch (JSONException localJSONException)
      {
        try
        {
          this.b = lae.a(parammhz.ahH);
          this.jh.setImageDrawable(this.b);
          return;
          localJSONException = localJSONException;
          localJSONException.printStackTrace();
          QLog.e("ComponentContentNoteCard", 1, "json error: " + parammhz.py + "\n" + parammhz.subTitle);
          continue;
          j = 0;
          continue;
          this.qn.setText(localJSONException);
        }
        catch (Exception parammhz)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ComponentContentNoteCard", 1, parammhz, new Object[0]);
          return;
        }
      }
      int j = 1;
    }
  }
  
  private void aMO()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.isRecording()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = new SoundCheckRunnable();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(this);
      ThreadManager.excute(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable, 16, null, true);
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler.postDelayed(new ComponentContentNoteCard.5(this), 60000L);
    }
  }
  
  private void aMP()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.stop();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.a(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable = null;
    }
    this.mUIHandler.removeCallbacksAndMessages(null);
  }
  
  private void aNV()
  {
    try
    {
      jll.openPermissionActivity((Activity)getContext());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ComponentContentNoteCard", 1, localException, new Object[0]);
    }
  }
  
  private void aNW()
  {
    ViewGroup.LayoutParams localLayoutParams = this.i.getLayoutParams();
    localLayoutParams.width = ((int)aqgz.getWidth());
    localLayoutParams.height = ((int)(aqgz.getWidth() * 0.5625D));
    if (this.i != null) {
      this.i.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    Object localObject = null;
    try
    {
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramString != null) {
        paramImageView.setImageDrawable(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  private void b(mhz parammhz)
  {
    parammhz.ahI = parammhz.ahI.replace("#$%", ljp.jv());
    Object localObject = getContext();
    if ((Build.VERSION.SDK_INT >= 23) && (localObject != null)) {
      if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {}
    }
    for (int j = 1;; j = 1) {
      for (;;)
      {
        if ((j == 0) && (ljp.oH() == 1))
        {
          localObject = parammhz.ahJ.replace("#$%", getContext().getString(2131718454));
          this.kn.setOnClickListener(new mbe(this));
        }
        try
        {
          for (;;)
          {
            a(this.km, new JSONObject(parammhz.ahI), 18.0F);
            a(this.kn, new JSONObject((String)localObject), 15.0F);
            b(this.jg, parammhz.ahK);
            this.jf.setVisibility(8);
            this.qm.setVisibility(8);
            this.qn.setVisibility(8);
            this.jh.setVisibility(8);
            return;
            j = 0;
            break;
            localObject = parammhz.ahJ.replace("#$%", ljp.jw());
          }
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            QLog.e("ComponentContentNoteCard", 1, "json error: " + parammhz.ahI + "\n" + parammhz.ahJ);
          }
        }
      }
    }
  }
  
  private String c(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    return paramJSONObject.get(paramString).toString();
  }
  
  public void P(Object paramObject)
  {
    this.aP = paramObject;
    if ((paramObject instanceof lie))
    {
      paramObject = ((lie)paramObject).a().scripCmsInfo;
      this.jdField_a_of_type_Mhz = paramObject;
      if (paramObject != null)
      {
        if ((paramObject.JP != 1) && ((!TextUtils.isEmpty(paramObject.ahI)) || (!TextUtils.isEmpty(paramObject.ahJ)))) {
          break label68;
        }
        a(paramObject);
      }
    }
    return;
    label68:
    b(paramObject);
  }
  
  public void a(lwm.a parama)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parama);
    }
  }
  
  public void aMH()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ljp.n(getContext(), str) < mhz.aSF)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.tx(7);
      return;
    }
    QQToast.a(getContext(), 0, getContext().getString(2131718541), 0).show();
  }
  
  public void aMQ()
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemResume");
    }
    this.mIsResume = true;
    if (this.b != null) {
      this.b.resumeAnimation();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyNotecardSoundCheckRunnable.stop();
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((this.akI) && (ljp.oH() != 0))
    {
      j = ljp.o(getContext(), (String)localObject);
      int m = ljp.p(getContext(), (String)localObject);
      if ((j < ljp.oI()) && (m < ljp.oJ()))
      {
        this.jdField_a_of_type_Mhz.JP = 2;
        ljp.g(getContext(), (String)localObject, j + 1);
        ljp.j(getContext(), (String)localObject, m + 1);
      }
    }
    P(this.aP);
    if ((ljp.oH() == 1) && (ljp.o(getContext(), (String)localObject) > 0))
    {
      localObject = getContext();
      j = k;
      if (Build.VERSION.SDK_INT >= 23)
      {
        j = k;
        if (localObject != null) {
          if (((Context)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break label241;
          }
        }
      }
    }
    label241:
    for (int j = k;; j = 0)
    {
      if (j != 0) {
        this.mUIHandler.postDelayed(new ComponentContentNoteCard.4(this), 1000L);
      }
      this.akI = false;
      return;
    }
  }
  
  public void aMR()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentNoteCard", 2, "onItemPause");
    }
    this.mIsResume = false;
    if (this.b != null) {
      this.b.pauseAnimation();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.b(this);
    aMP();
  }
  
  public void aNX()
  {
    this.akI = true;
  }
  
  public void cG(View paramView)
  {
    this.i = ((RelativeLayout)paramView.findViewById(2131372486));
    this.km = ((TextView)paramView.findViewById(2131371106));
    this.kn = ((TextView)paramView.findViewById(2131378924));
    this.jg = ((ImageView)paramView.findViewById(2131372483));
    this.qm = ((TextView)paramView.findViewById(2131370357));
    this.jf = ((ImageView)paramView.findViewById(2131370355));
    this.qn = ((TextView)paramView.findViewById(2131377293));
    this.jh = ((ImageView)paramView.findViewById(2131370919));
    this.ji = ((ImageView)paramView.findViewById(2131372485));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131372477));
    aNW();
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560301, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.b != null) && (this.b.isAnimating()) && (this.mScrollState != 0)) {
      this.b.pauseAnimation();
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.mScrollState = paramInt;
    if (this.b != null)
    {
      if (paramInt == 0) {
        this.b.resumeAnimation();
      }
    }
    else {
      return;
    }
    this.b.pauseAnimation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentNoteCard
 * JD-Core Version:    0.7.0.1
 */