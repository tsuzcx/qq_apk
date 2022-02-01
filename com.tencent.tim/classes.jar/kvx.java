import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyAdLocationView.a;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyBiuButton.a;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.valueitem.SizeValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLayoutImpl;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class kvx
{
  private static int aMf;
  private static double aU;
  private static final Map<Integer, lpi> dV = new HashMap();
  
  static
  {
    if (dV.isEmpty())
    {
      a(3, new lpq());
      a(72, new lmf());
      a(73, new lmm());
      a(74, new lpl());
      a(90, new lpk());
      a(91, new lpk());
      a(75, new lpl());
      a(21, new lps());
      a(22, new lps());
      a(36, new lps());
      a(23, new lps());
      a(120, new lps());
      a(80, new lps());
      a(34, new lom());
      a(16, new lom());
      a(17, new lom());
      a(19, new lom());
      a(18, new lom());
      a(20, new lom());
      a(65, new lom());
      a(64, new lom());
      a(48, new lom());
      a(25, new lmx());
      a(24, new lmx());
      a(26, new lmx());
      a(107, new lps());
      a(108, new lmx());
      a(37, new lmx());
      a(81, new lmx());
      a(35, new lmp());
      a(12, new lmp());
      a(10, new lmp());
      a(11, new lmp());
      a(28, new lmp());
      a(27, new lmp());
      a(49, new lmp());
      a(62, new lmp());
      a(63, new lmp());
      a(33, new lmp());
      a(31, new lom());
      a(32, new lom());
      a(79, new loj());
      a(76, new loj());
      a(77, new loj());
      a(78, new loj());
      a(83, new lom());
      a(84, new lom());
      a(85, new lom());
      a(86, new lom());
      a(89, new llv());
      a(92, new lmx());
      a(94, new lmp());
      a(95, new lmp());
      a(101, new lnp());
      a(102, new lnp());
      a(103, new lnp());
      a(105, new lme());
      a(66, new llx());
      a(115, new llx());
      a(39, new llw());
      a(116, new llz());
      a(117, new lmd());
      a(106, new lmc());
      a(140, new lma());
      a(141, new lmb());
      a(109, new lot());
      a(110, new lot());
      a(111, new lot());
      a(132, new lot());
      a(133, new lot());
      a(134, new lot());
      a(112, new lmp());
      a(113, new lmp());
      a(114, new lmp());
      a(126, new lmj());
      a(2, new lmi());
      a(1, new lpo());
      a(121, new lng());
      a(122, new llw());
      a(124, new lnv());
      a(125, new lnv());
      a(127, new lly());
      a(129, new lnu());
      a(130, new lnt());
      a(131, new loa());
      a(46, new lni());
      a(123, new loe());
      a(135, new lnr());
      a(137, new lnb());
      a(139, new lnb());
      a(138, new lnb());
    }
  }
  
  public static boolean V(int paramInt1, int paramInt2)
  {
    auvk.traceBegin("configDivider.isDividerNormal");
    if ((dp(paramInt1)) && (dp(paramInt2))) {}
    for (boolean bool = true;; bool = false)
    {
      auvk.traceEnd();
      return bool;
    }
  }
  
  private static double a(TemplateBean paramTemplateBean)
  {
    auvk.traceBegin("getProteusSeparatorMarginLeftPx");
    if ((aU > 0.0D) && (paramTemplateBean != null))
    {
      npi localnpi = npi.a("default_feeds", false);
      if ((localnpi != null) && (!localnpi.a(paramTemplateBean)))
      {
        auvk.traceEnd();
        return aU;
      }
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    try
    {
      paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
      if (paramTemplateBean != null) {
        aU = Float.valueOf((String)paramTemplateBean.valueBean.normalValue.get("margin_left")).floatValue();
      }
    }
    catch (Exception paramTemplateBean)
    {
      for (;;)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorMarginLeft exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorMarginLeft = ", Double.valueOf(aU) });
    }
    auvk.traceEnd();
    return aU;
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (lrl.shouldLog()) {
      lrl.d("ProteusSupportUtil", "[getView] " + paramBaseArticleInfo + " adapterViewType: " + paramInt);
    }
    long l1 = System.currentTimeMillis();
    auvk.traceBegin("ProteusSupportUtil.getView");
    Object localObject1 = null;
    auvk.traceBegin("ProteusSupportUtil#getView#getTemplateBean");
    TemplateBean localTemplateBean = a(paramVafContext, paramInt, paramBaseArticleInfo);
    auvk.traceEnd();
    Object localObject2 = "";
    label209:
    label225:
    long l2;
    if (localTemplateBean != null)
    {
      localObject2 = "[" + localTemplateBean.getStyleName() + "]";
      paramBaseArticleInfo = localObject1;
      localObject1 = localObject2;
      auvk.traceBegin(localObject1 + "#inflate");
      localObject2 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      lrk.log("ProteusSupportUtil", "[getView] inflate");
      auvk.traceEnd();
      if (localObject2 != null)
      {
        auvk.traceBegin(localObject1 + "#setBackgroundDrawable");
        if ((!kxm.AV()) || (!awit.Vs())) {
          break label399;
        }
        paramInt = 1;
        paramBaseArticleInfo = paramVafContext.getContext().getResources();
        if (paramInt == 0) {
          break label404;
        }
        paramInt = 2130842543;
        ((Container)localObject2).setBackgroundDrawable(paramBaseArticleInfo.getDrawable(paramInt));
        paramBaseArticleInfo = new ProteusItemView(paramVafContext.getContext());
        paramBaseArticleInfo.e((Container)localObject2);
        auvk.traceEnd();
        lrk.log("ProteusSupportUtil", "[getView]  add Container ");
      }
      if (QLog.isColorLevel()) {
        lrl.e((View)localObject2, "ProteusSupportUtil");
      }
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label411;
      }
    }
    label399:
    label404:
    label411:
    for (paramVafContext = localTemplateBean.getStyleName();; paramVafContext = "templateBean is null")
    {
      nxr.a("ProteusSupportUtil", paramVafContext, "ProteusSupportUtil.getView", l2 - l1);
      auvk.traceEnd();
      return paramBaseArticleInfo;
      lrk.log("ProteusSupportUtil", "[getView]  new proteusItemView ");
      ProteusItemView localProteusItemView = new ProteusItemView(paramVafContext.getContext());
      localProteusItemView.setVisibility(8);
      QLog.i("ProteusSupportUtil", 1, "[getView] 未找到样式,请确认是否下发该卡片的样式:" + paramBaseArticleInfo + " adapterViewType: " + paramInt + "  " + paramVafContext.getTemplateFactory());
      localObject1 = localObject2;
      paramBaseArticleInfo = localProteusItemView;
      break;
      paramInt = 0;
      break label209;
      paramInt = 2130842544;
      break label225;
    }
  }
  
  /* Error */
  public static TemplateBean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +16 -> 17
    //   4: ldc 159
    //   6: iconst_0
    //   7: invokestatic 164	npi:a	(Ljava/lang/String;Z)Lnpi;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnonnull +516 -> 528
    //   15: aconst_null
    //   16: areturn
    //   17: aload_0
    //   18: invokevirtual 377	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getTemplateFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/factory/BaseTemplateFactory;
    //   21: checkcast 161	npi
    //   24: astore_3
    //   25: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +39 -> 67
    //   31: ldc 231
    //   33: iconst_2
    //   34: new 244	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   41: ldc_w 387
    //   44: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc_w 389
    //   54: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: iload_1
    //   58: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   61: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_2
    //   68: getfield 395	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   71: ifnull +19 -> 90
    //   74: aload_3
    //   75: aload_2
    //   76: getfield 395	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   79: invokevirtual 167	npi:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Z
    //   82: ifne +8 -> 90
    //   85: aload_2
    //   86: getfield 395	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   89: areturn
    //   90: getstatic 20	kvx:dV	Ljava/util/Map;
    //   93: iload_1
    //   94: invokestatic 400	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: invokeinterface 196 2 0
    //   102: checkcast 402	lpi
    //   105: astore 4
    //   107: aload 4
    //   109: ifnull +165 -> 274
    //   112: aload 4
    //   114: iload_1
    //   115: aload_2
    //   116: invokeinterface 405 3 0
    //   121: astore_0
    //   122: invokestatic 410	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	()Lcom/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager;
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 413	com/tencent/biz/pubaccount/readinjoy/redpacket/RIJRedPacketManager:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   130: astore 5
    //   132: aload 4
    //   134: ifnull +389 -> 523
    //   137: aload 4
    //   139: iload_1
    //   140: aload 5
    //   142: invokeinterface 416 3 0
    //   147: astore_0
    //   148: aload_0
    //   149: ifnonnull +371 -> 520
    //   152: aload_3
    //   153: ifnull +307 -> 460
    //   156: aload_3
    //   157: aload 5
    //   159: invokevirtual 420	npi:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   162: astore_3
    //   163: aload_3
    //   164: astore_0
    //   165: aload_2
    //   166: aload_0
    //   167: putfield 395	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   170: new 244	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 422
    //   180: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore_3
    //   184: aload 5
    //   186: ifnull +279 -> 465
    //   189: new 244	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   196: aload 5
    //   198: ldc_w 424
    //   201: invokevirtual 430	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc_w 432
    //   210: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 433	org/json/JSONObject:toString	()Ljava/lang/String;
    //   218: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 435
    //   224: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_2
    //   231: ldc 231
    //   233: iconst_2
    //   234: aload_3
    //   235: aload_2
    //   236: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: ldc 231
    //   247: iconst_1
    //   248: new 244	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 437
    //   258: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload 5
    //   263: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_0
    //   273: areturn
    //   274: iload_1
    //   275: lookupswitch	default:+97->372, 1:+113->388, 5:+105->380, 29:+129->404, 34:+153->428, 40:+169->444, 41:+177->452, 42:+161->436, 47:+137->412, 60:+145->420, 96:+145->420, 104:+121->396
    //   373: invokestatic 442	lll:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   376: astore_0
    //   377: goto -255 -> 122
    //   380: aload_2
    //   381: invokestatic 445	llp:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   384: astore_0
    //   385: goto -263 -> 122
    //   388: aload_2
    //   389: invokestatic 448	llo:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   392: astore_0
    //   393: goto -271 -> 122
    //   396: aload_2
    //   397: invokestatic 451	llc:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   400: astore_0
    //   401: goto -279 -> 122
    //   404: aload_2
    //   405: invokestatic 454	lln:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   408: astore_0
    //   409: goto -287 -> 122
    //   412: aload_2
    //   413: invokestatic 457	lkv:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   416: astore_0
    //   417: goto -295 -> 122
    //   420: aload_2
    //   421: invokestatic 460	lli:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   424: astore_0
    //   425: goto -303 -> 122
    //   428: aload_2
    //   429: invokestatic 463	llm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   432: astore_0
    //   433: goto -311 -> 122
    //   436: aload_2
    //   437: invokestatic 466	llr:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   440: astore_0
    //   441: goto -319 -> 122
    //   444: aload_2
    //   445: invokestatic 469	llq:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   448: astore_0
    //   449: goto -327 -> 122
    //   452: aload_2
    //   453: invokestatic 472	lls:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lorg/json/JSONObject;
    //   456: astore_0
    //   457: goto -335 -> 122
    //   460: aconst_null
    //   461: astore_0
    //   462: goto -297 -> 165
    //   465: ldc_w 281
    //   468: astore_2
    //   469: goto -238 -> 231
    //   472: astore_2
    //   473: aconst_null
    //   474: astore_0
    //   475: ldc 231
    //   477: iconst_1
    //   478: ldc_w 474
    //   481: aload_2
    //   482: invokestatic 477	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   485: goto -213 -> 272
    //   488: astore_2
    //   489: aconst_null
    //   490: astore_0
    //   491: ldc 231
    //   493: iconst_1
    //   494: ldc_w 479
    //   497: aload_2
    //   498: invokestatic 477	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   501: goto -229 -> 272
    //   504: astore_2
    //   505: goto -14 -> 491
    //   508: astore_2
    //   509: goto -18 -> 491
    //   512: astore_2
    //   513: goto -38 -> 475
    //   516: astore_2
    //   517: goto -42 -> 475
    //   520: goto -355 -> 165
    //   523: aconst_null
    //   524: astore_0
    //   525: goto -377 -> 148
    //   528: goto -503 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramVafContext	VafContext
    //   0	531	1	paramInt	int
    //   0	531	2	paramBaseArticleInfo	BaseArticleInfo
    //   10	225	3	localObject	Object
    //   105	33	4	locallpi	lpi
    //   130	132	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   67	90	472	org/json/JSONException
    //   90	107	472	org/json/JSONException
    //   112	122	472	org/json/JSONException
    //   122	132	472	org/json/JSONException
    //   137	148	472	org/json/JSONException
    //   372	377	472	org/json/JSONException
    //   380	385	472	org/json/JSONException
    //   388	393	472	org/json/JSONException
    //   396	401	472	org/json/JSONException
    //   404	409	472	org/json/JSONException
    //   412	417	472	org/json/JSONException
    //   420	425	472	org/json/JSONException
    //   428	433	472	org/json/JSONException
    //   436	441	472	org/json/JSONException
    //   444	449	472	org/json/JSONException
    //   452	457	472	org/json/JSONException
    //   67	90	488	java/lang/Exception
    //   90	107	488	java/lang/Exception
    //   112	122	488	java/lang/Exception
    //   122	132	488	java/lang/Exception
    //   137	148	488	java/lang/Exception
    //   372	377	488	java/lang/Exception
    //   380	385	488	java/lang/Exception
    //   388	393	488	java/lang/Exception
    //   396	401	488	java/lang/Exception
    //   404	409	488	java/lang/Exception
    //   412	417	488	java/lang/Exception
    //   420	425	488	java/lang/Exception
    //   428	433	488	java/lang/Exception
    //   436	441	488	java/lang/Exception
    //   444	449	488	java/lang/Exception
    //   452	457	488	java/lang/Exception
    //   156	163	504	java/lang/Exception
    //   165	184	508	java/lang/Exception
    //   189	231	508	java/lang/Exception
    //   231	272	508	java/lang/Exception
    //   156	163	512	org/json/JSONException
    //   165	184	516	org/json/JSONException
    //   189	231	516	org/json/JSONException
    //   231	272	516	org/json/JSONException
  }
  
  public static void a(int paramInt, ProteusItemView paramProteusItemView, VafContext paramVafContext, aqdf paramaqdf, ndi paramndi, lie paramlie, BaseArticleInfo paramBaseArticleInfo)
  {
    Container localContainer = paramProteusItemView.a();
    ViewFactory.findClickableViewListener(localContainer.getVirtualView(), new kwc(paramInt, localContainer, paramlie, paramVafContext, paramaqdf, paramndi, paramBaseArticleInfo, paramProteusItemView));
  }
  
  private static void a(int paramInt1, Container paramContainer, lie paramlie, int paramInt2)
  {
    auvk.traceBegin("ProteusSupportUtil.bindView");
    if (paramContainer == null)
    {
      auvk.traceEnd();
      return;
    }
    lrk.log("ProteusSupportUtil", "[bindView]");
    Object localObject = (lpi)dV.get(Integer.valueOf(paramInt1));
    if (localObject != null)
    {
      ((lpi)localObject).a(paramInt1, paramContainer, paramlie, paramInt2);
      auvk.traceEnd();
    }
    for (;;)
    {
      auvk.traceEnd();
      return;
      paramContainer = paramContainer.getVirtualView();
      switch (paramInt1)
      {
      default: 
        break;
      case 10: 
        localObject = (lro)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((lro)localObject).setModel(paramlie);
        }
        localObject = (lsw)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((lsw)localObject).setModel(paramlie);
        }
        localObject = (lrp)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((lrp)localObject).setModel(paramlie);
        }
        paramContainer = (lrq)paramContainer.findViewBaseByName("id_corner_text_image");
        if (paramContainer != null) {
          paramContainer.setModel(paramlie);
        }
        break;
      case 34: 
      case 40: 
      case 41: 
      case 42: 
        localObject = (lro)paramContainer.findViewBaseByName("id_info_avator");
        if (localObject != null) {
          ((lro)localObject).setModel(paramlie);
        }
        localObject = (lsw)paramContainer.findViewBaseByName("id_summary");
        if (localObject != null) {
          ((lsw)localObject).setModel(paramlie);
        }
        localObject = (lrp)paramContainer.findViewBaseByName("id_biu_comment");
        if (localObject != null) {
          ((lrp)localObject).setModel(paramlie);
        }
        paramContainer = (lrr)paramContainer.findViewBaseByName("id_multi_image");
        if (paramContainer != null) {
          paramContainer.b(paramlie.a());
        }
        break;
      }
    }
  }
  
  private static void a(int paramInt, lpi paramlpi)
  {
    if (paramlpi == null) {
      throw new NullPointerException();
    }
    dV.put(Integer.valueOf(paramInt), paramlpi);
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, aqdf paramaqdf, ndi paramndi, lie paramlie, int paramInt2, String paramString)
  {
    if (lrl.shouldLog())
    {
      lrl.d("ProteusSupportUtil", "[bindData]  adapterViewType: " + paramInt1);
      if (paramBaseArticleInfo != null) {
        lrl.d("ProteusSupportUtil", " reportViewType: " + kxm.a(paramBaseArticleInfo));
      }
      lrl.d("ProteusSupportUtil", "[bindData] " + paramBaseArticleInfo);
    }
    lrk.log("ProteusSupportUtil", "[bindData] adapterViewType: " + paramInt1);
    auvk.traceBegin("ProteusSupportUtil.bindData");
    long l1 = System.currentTimeMillis();
    if ((paramProteusItemView == null) || (paramProteusItemView.a() == null))
    {
      auvk.traceEnd();
      return;
    }
    b(paramVafContext, paramString);
    Object localObject = paramProteusItemView.getTemplateBean();
    TemplateBean localTemplateBean = a(paramVafContext, paramInt1, paramBaseArticleInfo);
    int i;
    int j;
    if ((!a(paramProteusItemView.a(), paramInt1)) && ((localObject == null) || (localTemplateBean == null) || (localTemplateBean.getId() == ((TemplateBean)localObject).getId())))
    {
      paramString = (String)localObject;
      if (localObject != null)
      {
        paramString = (String)localObject;
        if (localTemplateBean != null)
        {
          paramString = (String)localObject;
          if (((TemplateBean)localObject).getStyleName() != null)
          {
            paramString = (String)localObject;
            if (localTemplateBean.getStyleName() != null)
            {
              paramString = (String)localObject;
              if (localTemplateBean.getStyleName().equals(((TemplateBean)localObject).getStyleName())) {}
            }
          }
        }
      }
    }
    else
    {
      if (localTemplateBean == null) {
        break label614;
      }
      i = localTemplateBean.getId();
      if (localObject == null) {
        break label620;
      }
      j = ((TemplateBean)localObject).getId();
      label279:
      QLog.i("ProteusSupportUtil", 1, "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      lrk.log("ProteusSupportUtil", "[bindData] trigger re-inflation, adapterViewType: " + paramInt1 + " new id: " + i + " old id: " + j);
      paramString = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
      if (paramString != null)
      {
        paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842544));
        paramProteusItemView.aMU();
        paramProteusItemView.e(paramString);
        lrl.logViewBaseHierarchy(paramString.getVirtualView(), "ProteusSupportUtil");
        lrl.e(paramString, "ProteusSupportUtil");
      }
      paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      aHC();
      paramString = null;
    }
    kni.a(paramBaseArticleInfo, localTemplateBean, paramInt2);
    localObject = paramProteusItemView.a();
    paramProteusItemView.setTemplateBean(localTemplateBean);
    paramProteusItemView.setModel(paramlie, paramndi.a());
    auvk.traceBegin("ProteusSupportUtil.bindDataImpl");
    label529:
    long l2;
    if (localTemplateBean != null)
    {
      QLog.i("ProteusSupportUtil", 1, "[bindData] bind data for " + localTemplateBean.getStyleName());
      bindDynamicValueWithoutRecursion((Container)localObject, paramString, localTemplateBean);
      auvk.traceEnd();
      a(paramInt1, (Container)localObject, paramlie, paramInt2);
      a(paramInt1, paramProteusItemView, paramVafContext, paramaqdf, paramndi, paramlie, paramBaseArticleInfo);
      auvk.traceBegin("ProteusSupportUtil.configDivider");
      a(paramlie, paramVafContext);
      a((Container)localObject, paramlie, localTemplateBean);
      auvk.traceEnd();
      l2 = System.currentTimeMillis();
      if (localTemplateBean == null) {
        break label638;
      }
    }
    label614:
    label620:
    label638:
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      nxr.a("ProteusSupportUtil", paramProteusItemView, " ProteusSupportUtil.bindData", l2 - l1);
      auvk.traceEnd();
      return;
      i = -1;
      break;
      j = -1;
      break label279;
      QLog.d("ProteusSupportUtil", 2, "[bindData] newTemplateBean is null");
      break label529;
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((!(paramBaseArticleInfo instanceof ArticleInfo)) || (paramTemplateBean == null)) {
      return;
    }
    String str = odv.aB(paramBaseArticleInfo.mChannelID);
    HashMap localHashMap = new HashMap();
    Map localMap = paramTemplateBean.getDataAttribute(null);
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getViewId());
    if (localMap != null) {
      localHashMap.putAll(localMap);
    }
    if (paramTemplateBean != null) {
      localHashMap.putAll(paramTemplateBean);
    }
    obr.a((ArticleInfo)paramBaseArticleInfo, str, str, (int)paramBaseArticleInfo.mChannelID, localHashMap);
    obr.K(paramTemplateBean);
    awit.o(paramBaseArticleInfo);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, ViewBase paramViewBase, TemplateBean paramTemplateBean)
  {
    if ((paramBaseArticleInfo == null) || (paramViewBase == null) || (paramTemplateBean == null)) {}
    do
    {
      do
      {
        return;
        paramViewBase = paramTemplateBean.getDataAttribute(paramViewBase.getViewId()).get("rowkey");
      } while (!(paramViewBase instanceof String));
      paramViewBase = (String)paramViewBase;
    } while (TextUtils.isEmpty(paramViewBase));
    paramBaseArticleInfo.viewRowkey = paramViewBase;
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    a(paramTemplateBean, paramViewBase, "click_T");
  }
  
  public static void a(TemplateBean paramTemplateBean, ViewBase paramViewBase, String paramString)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return;
    }
    kxm.b localb = new kxm.b();
    String str = (String)paramTemplateBean.getDataAttribute(paramViewBase.getName(), paramString);
    if (str == null)
    {
      QLog.d("ProteusSupportUtil", 2, "reportDataAttrInfo bigT is null");
      return;
    }
    paramTemplateBean = paramTemplateBean.getDataAttribute(paramViewBase.getName());
    if (paramTemplateBean != null)
    {
      paramTemplateBean = paramTemplateBean.entrySet().iterator();
      while (paramTemplateBean.hasNext())
      {
        Object localObject = (Map.Entry)paramTemplateBean.next();
        paramViewBase = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if (!TextUtils.equals(paramViewBase, paramString)) {
          localb.b(paramViewBase, localObject.toString());
        }
      }
    }
    kbp.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", localb.build(), false);
  }
  
  private static void a(ViewBean paramViewBean)
  {
    if (paramViewBean == null) {}
    do
    {
      return;
      paramViewBean = paramViewBean.getDynamicValue("setProteusReportInfo:");
    } while (!(paramViewBean instanceof JSONObject));
    try
    {
      JSONObject localJSONObject = (JSONObject)paramViewBean;
      paramViewBean = localJSONObject.getString("click_T");
      localJSONObject = localJSONObject.getJSONObject("info");
      kxm.b localb = new kxm.b();
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localb.b(str, localJSONObject.get(str).toString());
      }
      kbp.a(null, "CliOper", "", "", paramViewBean, paramViewBean, 0, 0, "", "", "", localb.build(), false);
    }
    catch (Exception paramViewBean)
    {
      QLog.d("ProteusSupportUtil", 1, paramViewBean, new Object[] { "" });
      return;
    }
  }
  
  public static void a(Container paramContainer, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new kvy(paramVafContext, paramTemplateBean));
  }
  
  public static void a(Container paramContainer, lie paramlie, TemplateBean paramTemplateBean)
  {
    if (kvo.a(paramContainer, paramlie)) {
      return;
    }
    ViewBase localViewBase1 = paramContainer.getVirtualView();
    ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_separator");
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo == null) || (localViewBase2 == null))
    {
      QLog.d("ProteusSupportUtil", 1, "configDivider failed, articleInfo is null or divider is null.");
      return;
    }
    Layout.Params localParams = localViewBase2.getComLayoutParams();
    int m = localParams.mLayoutHeight;
    int j = Utils.dp2px(5.0D);
    double d = Utils.dp2px(6.0D);
    int i = paramlie.getCellType();
    int k = paramlie.oE();
    if (localArticleInfo.mChannelID == 70L)
    {
      auvk.traceBegin("configDivider.FollowFeeds");
      localParams.mLayoutMarginLeft = 0;
      localParams.mLayoutMarginRight = 0;
      localParams.mLayoutWidth = -1;
      i = Utils.dp2px(5.0D);
      auvk.traceEnd();
    }
    for (;;)
    {
      localParams.mLayoutHeight = i;
      localViewBase2.setComLayoutParams(localParams);
      paramlie = localViewBase1.getComLayoutParams();
      if (paramlie.mLayoutHeight >= 0) {
        paramlie.mLayoutHeight = (i - m + paramlie.mLayoutHeight);
      }
      paramlie = localViewBase1.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramlie.mLayoutWidth, paramlie.mLayoutHeight));
      return;
      if (kys.dv((int)localArticleInfo.mChannelID))
      {
        auvk.traceBegin("configDivider.DailyFeeds");
        paramlie = paramlie.b();
        j = 0;
        k = 0;
        i = k;
        if (paramlie != null)
        {
          i = k;
          if (paramlie.mProteusTemplateBean != null)
          {
            if (paramlie.mProteusTemplateBean.getDataAttribute(null, "position_jump") == null) {
              break label344;
            }
            i = 1;
          }
        }
        label279:
        if (localArticleInfo.mProteusTemplateBean != null)
        {
          if (localArticleInfo.mProteusTemplateBean.getDataAttribute(null, "position_jump") != null) {
            j = 1;
          }
        }
        else
        {
          label305:
          if (j == i) {
            break label356;
          }
          localParams.mLayoutMarginLeft = 0;
          localParams.mLayoutMarginRight = 0;
          localParams.mLayoutWidth = -1;
          i = Utils.dp2px(5.0D);
        }
        for (;;)
        {
          auvk.traceEnd();
          break;
          label344:
          i = 0;
          break label279;
          j = 0;
          break label305;
          label356:
          j = c(paramTemplateBean);
          i = j;
          if (j == b(paramTemplateBean))
          {
            i = b(paramTemplateBean);
            j = Utils.dp2px(a(paramTemplateBean));
            localParams.mLayoutMarginRight = j;
            localParams.mLayoutMarginLeft = j;
            localParams.mLayoutWidth = -1;
          }
        }
      }
      if ((i == 29) || (i == 30) || (k == 29) || (k == 30))
      {
        i = b(paramTemplateBean);
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if ((f(paramlie.b())) || (b(paramlie)))
      {
        i = 0;
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
      }
      else if (V(i, k))
      {
        auvk.traceBegin("configDivider.normal");
        auvk.traceBegin("configDivider.normal.getProteusSeparatorHeightPx");
        i = b(paramTemplateBean);
        auvk.traceEnd();
        auvk.traceBegin("configDivider.normal.getProteusSeparatorMarginLeftPx");
        d = a(paramTemplateBean);
        auvk.traceEnd();
        j = Utils.dp2px(d);
        localParams.mLayoutMarginRight = j;
        localParams.mLayoutMarginLeft = j;
        localParams.mLayoutWidth = -1;
        auvk.traceEnd();
      }
      else
      {
        localParams.mLayoutMarginLeft = 0;
        localParams.mLayoutMarginRight = 0;
        localParams.mLayoutWidth = -1;
        i = j;
        if (!dp(k))
        {
          a(paramlie, localViewBase2);
          i = j;
        }
      }
    }
  }
  
  public static void a(VafContext paramVafContext, String paramString)
  {
    paramVafContext.setTemplateFactory(npi.a(paramString, true));
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLikeButton", new lry.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAvatarView", new lro.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVariableImageContentView", new lrr.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySummaryView", new lsw.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCommentView", new lrn.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuCommentView", new lrp.a());
    paramVafContext.getViewFactory().registerViewBuilder("CornerTextImageView", new lrq.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyMiddleBodyView", new lsd.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyUsersCommentView", new lsx.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyFriendsBiu", new lrw.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyQARichView", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyBiuButton", new ReadInJoyBiuButton.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyCoordinateView", new lrv.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoySocializeRecommendFollowView", new lsf.a());
    paramVafContext.getViewFactory().registerViewBuilder("UILabel", new lst.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageView", new lsr.a());
    paramVafContext.getViewFactory().registerViewBuilder("UIImageView", new lsr.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyAsynImageIcon", new lsq.a());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusCollectionView", new ltp.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdVideoGuide", new lrt.a());
    paramVafContext.getViewFactory().registerViewBuilder("PTSAvatarView", new kve.a());
    paramVafContext.getViewFactory().registerViewBuilder("QQAvatarView", new kve.a());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentEmotioinLabel", new kvf.a());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJRichTextView", new kvf.a());
    paramVafContext.getViewFactory().registerViewBuilder("QQRIJCommentLikeButton", new kvg.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyExposeReplyCommentView", new kvh.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAwesomeCommentView", new lru.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdDownloadView", new koh.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdLocationView", new ReadInJoyAdLocationView.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyIconText", new kop.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyDoubleImageView", new kos.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyTripleImageInteractView", new kow.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdInnerOperateView", new koi.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadinjoyNativeArticleAdDownloadView", new kox.a());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusTickerView", new lrs.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyShareView", new lse.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyApngImageView", new lsp.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyAdBrandOptimizationView", new kod.b());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInjoyProgressView", new lss.a());
    aHC();
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyVideoView", new lso.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyGifView", new lrx.a());
    paramVafContext.getViewFactory().registerViewBuilder("ProteusMarqueeLabel", new NativeText.Builder());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLinkClickableLabel", new lst.a());
    paramVafContext.getViewFactory().registerViewBuilder("ReadInJoyLottieView", new lsb.a());
  }
  
  public static void a(ViewBase paramViewBase, ViewBean paramViewBean)
  {
    if (paramViewBase != null)
    {
      paramViewBase.bindDynamicValue(paramViewBean);
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (paramViewBean.children != null))
        {
          List localList = Arrays.asList(paramViewBean.children);
          int j = paramViewBase.size();
          if (localList.size() == j)
          {
            int i = 0;
            while (i < j)
            {
              a((ViewBase)paramViewBase.get(i), (ViewBean)localList.get(i));
              i += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProteusSupportUtil", 2, "bindDataImpl: fail to bind data for " + paramViewBean.viewId + "due to ViewBean - ViewBase count mismatch");
          }
        }
      }
      lrk.log("ProteusSupportUtil", "[bindDynamicValue]");
    }
  }
  
  private static void a(lie paramlie, VafContext paramVafContext)
  {
    Object localObject = paramlie.b();
    if (localObject != null)
    {
      localObject = ((ndi)localObject).c(paramlie.getPosition() + 1);
      if ((localObject != null) && (((BaseArticleInfo)localObject).mProteusTemplateBean == null))
      {
        QLog.d("ProteusSupportUtil", 2, "next.mProteusTemplateBean == null " + localObject);
        ((BaseArticleInfo)localObject).mProteusTemplateBean = a(paramVafContext, paramlie.oE(), (BaseArticleInfo)localObject);
      }
    }
  }
  
  private static void a(lie paramlie, ViewBase paramViewBase)
  {
    if ((paramlie != null) && (paramViewBase != null) && (paramViewBase.getNativeView() != null))
    {
      paramlie = paramlie.b();
      if ((paramlie != null) && (paramlie.mProteusTemplateBean != null))
      {
        paramlie = (ViewBean)paramlie.mProteusTemplateBean.getViewDataBinding().get("id_separator");
        if ((paramlie != null) && (paramlie.valueBean != null) && (paramlie.valueBean.normalValue != null))
        {
          paramlie = paramlie.valueBean.normalValue.get("setBackgroundColorString:");
          if (!(paramlie instanceof String)) {}
        }
      }
    }
    try
    {
      paramViewBase.getNativeView().setBackgroundColor(Color.parseColor((String)paramlie));
      return;
    }
    catch (Exception paramlie)
    {
      QLog.d("ProteusSupportUtil", 1, paramlie.getMessage());
    }
  }
  
  private static boolean a(Container paramContainer, int paramInt)
  {
    if (paramContainer != null) {}
    for (;;)
    {
      int i;
      try
      {
        int j = paramContainer.getChildCount();
        i = 0;
        if (i < j)
        {
          View localView = paramContainer.getChildAt(i);
          Object localObject;
          if ((localView instanceof NativeLayoutImpl))
          {
            localObject = (NativeLayoutImpl)localView;
            if ((((NativeLayoutImpl)localObject).getChildCount() == 0) && (((NativeLayoutImpl)localObject).getBackgroundColor() == 0))
            {
              QQAppInterface localQQAppInterface = kxm.a();
              if (((NativeLayoutImpl)localObject).getContentDescription() == null) {
                continue;
              }
              localObject = ((NativeLayoutImpl)localObject).getContentDescription().toString();
              kbp.a(localQQAppInterface, "CliOper", "", "", "0X8009AC1", "0X8009AC1", 0, 0, "", "", "", (String)localObject, false);
              lrl.logViewBaseHierarchy(paramContainer.getVirtualView(), "ProteusSupportUtil");
              lrl.e(paramContainer, "ProteusSupportUtil");
              QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] empty native layout " + paramInt);
            }
          }
          if ((QLog.isColorLevel()) && ((localView instanceof ViewGroup)))
          {
            localObject = (ViewGroup)localView;
            QLog.e("ProteusSupportUtil", 1, "ChildCount " + ((ViewGroup)localObject).getChildCount());
            break label229;
            localObject = "";
            continue;
          }
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramContainer)
      {
        QLog.e("ProteusSupportUtil", 1, "[nativeLayoutImplError] ", paramContainer);
      }
      label229:
      i += 1;
    }
  }
  
  public static boolean a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return a(paramVafContext, paramInt, paramBaseArticleInfo) != null;
  }
  
  public static boolean a(VafContext paramVafContext, String paramString)
  {
    paramString = npi.a(paramString, true);
    if (paramVafContext.getTemplateFactory() == null)
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    if ((paramString != null) && (paramString.getTemplateId() != paramVafContext.getTemplateFactory().getTemplateId()))
    {
      paramVafContext.setTemplateFactory(paramString);
      return true;
    }
    return false;
  }
  
  private static void aHC()
  {
    lrk.log("ProteusSupportUtil", "resetProteusSeparatorHeightPx ");
    QLog.d("TemplateFactory", 4, "resetProteusSeparatorHeightPx");
    aMf = 0;
  }
  
  private static int b(TemplateBean paramTemplateBean)
  {
    auvk.traceBegin("getProteusSeparatorHeightPx");
    if ((aMf > 0) && (paramTemplateBean != null))
    {
      localnpi = npi.a("default_feeds", false);
      if ((localnpi != null) && (!localnpi.a(paramTemplateBean)))
      {
        auvk.traceEnd();
        lrk.log("ProteusSupportUtil", "[getProteusSeparatorHeightPx] SeparatorHeight : " + aMf);
        return aMf;
      }
    }
    npi localnpi = npi.a("default_feeds", false);
    paramTemplateBean = null;
    if (localnpi != null) {
      paramTemplateBean = localnpi.getTemplate("ReadInjoy_triple_img_cell");
    }
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    for (;;)
    {
      try
      {
        paramTemplateBean = paramTemplateBean.getViewBean().findViewById("id_separator");
        if (paramTemplateBean == null) {
          continue;
        }
        paramTemplateBean = (SizeValue)paramTemplateBean.valueBean.normalValue.get("height");
        if (paramTemplateBean != null) {
          aMf = paramTemplateBean.getLayoutSize();
        }
        lrk.log("ProteusSupportUtil", "[getProteusSeparatorHeightPx] getSeparatorHeightPx");
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TemplateFactory", 2, new Object[] { "sProteusSeparatorHeight = ", Integer.valueOf(aMf) });
      }
      auvk.traceEnd();
      return aMf;
      aMf = Utils.dp2px(0.5D);
    }
  }
  
  public static String b(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = null;
    if (!mgn.Z(paramBaseArticleInfo))
    {
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema is not ugCard");
      return null;
    }
    int i = mgk.aRi;
    mgk localmgk = mgk.a();
    boolean bool = localmgk.a(paramBaseArticleInfo, true, i);
    if (bool)
    {
      str = localmgk.a(paramBaseArticleInfo, i, null, null);
      QLog.d("ProteusSupportUtil", 1, "UGRuleManager getUGSchema ugUrl is " + str);
    }
    localmgk.a(paramBaseArticleInfo, bool, true, i);
    return str;
  }
  
  private static void b(VafContext paramVafContext, String paramString)
  {
    paramString = npi.a(paramString, false);
    if ((paramString != null) && (paramVafContext.getTemplateFactory() != paramString)) {
      paramVafContext.setTemplateFactory(paramString);
    }
  }
  
  public static boolean b(lie paramlie)
  {
    if (paramlie != null) {
      try
      {
        int i = paramlie.oE();
        if ((i == 66) || (i == 39))
        {
          paramlie = paramlie.b();
          if ((paramlie != null) && (AdvertisementInfo.isAdvertisementInfo(paramlie)))
          {
            paramlie = ((AdvertisementInfo)paramlie).mAdExtInfo;
            if (paramlie != null)
            {
              i = new JSONObject(paramlie).optInt("is_video_new");
              return i == 1;
            }
          }
        }
      }
      catch (Exception paramlie)
      {
        QLog.d("ProteusSupportUtil", 1, "isNextCardAdBigImgOrAdVideo JSONException, e = ", paramlie);
      }
    }
    return false;
  }
  
  public static void bindDynamicValueWithoutRecursion(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    auvk.traceBegin("ProteusSupportUtil.bindDynamicValueWithoutRecursion");
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      lrk.log("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] map");
      if ((localHashSet != null) && (localMap1 != null)) {
        localHashSet.addAll(localMap1.keySet());
      }
      Iterator localIterator = localMap2.keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        label138:
        long l2;
        ViewBean localViewBean;
        Object localObject;
        label178:
        label211:
        int i;
        if ("[ " + paramTemplateBean2 != null)
        {
          paramTemplateBean1 = paramTemplateBean2.getStyleName();
          auvk.traceBegin(paramTemplateBean1);
          l2 = System.currentTimeMillis();
          localViewBean = (ViewBean)localMap2.get(str);
          if (paramContainer == null) {
            break label474;
          }
          localObject = (ViewBean)paramContainer.get(str);
          if (localHashSet != null) {
            localHashSet.remove(str);
          }
          if (localMap1 == null) {
            break label480;
          }
          paramTemplateBean1 = (ViewBase)localMap1.get(str);
          auvk.traceBegin("bindDynamicValueWithoutRecursion.bindDynamicVal.check");
          if ((str == null) || (paramTemplateBean1 == null) || (localViewBean == null) || ((localObject != null) && (localViewBean.valueBean.dynamicValue.equals(((ViewBean)localObject).valueBean.dynamicValue)))) {
            break label485;
          }
          i = 1;
          label262:
          auvk.traceEnd();
          if (i == 0) {
            break label498;
          }
          if ("[ " + paramTemplateBean2 == null) {
            break label490;
          }
          localObject = paramTemplateBean2.getStyleName();
          label298:
          auvk.traceBegin((String)localObject);
          localViewBean.setVisible(true);
          paramTemplateBean1.bindDynamicValue(localViewBean);
          QLog.d("ProteusSupportUtil", 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
          auvk.traceEnd();
          if (QLog.isColorLevel()) {
            QLog.i("ProteusSupportUtil", 2, "[bindDynamicValueWithoutRecursion] bind dynamicValue: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
          }
        }
        for (;;)
        {
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(0);
          }
          auvk.traceEnd();
          break;
          paramTemplateBean1 = "]" + str;
          break label138;
          label474:
          localObject = null;
          break label178;
          label480:
          paramTemplateBean1 = null;
          break label211;
          label485:
          i = 0;
          break label262;
          label490:
          localObject = "]_bindDynamicValue";
          break label298;
          label498:
          if ((QLog.isColorLevel()) && (localViewBean != null))
          {
            QLog.i("ProteusSupportUtil", 1, "[bindDynamicValueWithoutRecursion] skip: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
            QLog.d("ProteusSupportUtil", 2, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value not changed ] cost " + (System.currentTimeMillis() - l2) + "ms");
          }
        }
      }
      lrk.log("ProteusSupportUtil", "[bindDynamicValueWithoutRecursion] recur");
      if (localHashSet != null)
      {
        paramContainer = localHashSet.iterator();
        while (paramContainer.hasNext())
        {
          paramTemplateBean1 = (ViewBase)localMap1.get((String)paramContainer.next());
          if (paramTemplateBean1 != null) {
            paramTemplateBean1.setVisibility(8);
          }
        }
      }
      if (paramTemplateBean2 != null)
      {
        paramContainer = paramTemplateBean2.getStyleName();
        nxr.a("ProteusSupportUtil", paramContainer, "bindDynamicValueWithoutRecursion", System.currentTimeMillis() - l1);
        if ("bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2 == null) {
          break label738;
        }
      }
      label738:
      for (paramContainer = paramTemplateBean2.getStyleName();; paramContainer = " cost " + (System.currentTimeMillis() - l1) + "ms")
      {
        QLog.d("ProteusSupportUtil", 2, paramContainer);
        auvk.traceEnd();
        return;
        paramContainer = "";
        break;
      }
    }
  }
  
  private static int c(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {
      try
      {
        paramTemplateBean = (SizeValue)paramTemplateBean.getViewBean().findViewById("id_separator").valueBean.normalValue.get("height");
        lrk.log("ProteusSupportUtil", "[getSepatatorHeight] getSepatatorHeight");
        int i = paramTemplateBean.getLayoutSize();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        paramTemplateBean.printStackTrace();
        QLog.d("ProteusSupportUtil", 1, "getProteusSeparatorHeight exception.");
      }
    }
    return 0;
  }
  
  public static void d(ArticleInfo paramArticleInfo)
  {
    a(null, ndi.k(paramArticleInfo), paramArticleInfo);
  }
  
  public static boolean jdMethod_do(int paramInt)
  {
    if (!kvw.AF()) {}
    do
    {
      return false;
      switch (paramInt)
      {
      }
    } while (kmz.dg(paramInt));
    return dV.containsKey(Integer.valueOf(paramInt));
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
    return true;
  }
  
  private static boolean dp(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 47) || (paramInt == 60) || (paramInt == 39) || (paramInt == 66) || (paramInt == 50) || (paramInt == 51) || (paramInt == 52) || (paramInt == 53) || (paramInt == 96) || (paramInt == 103) || (paramInt == 102) || (paramInt == 101) || (paramInt == 104) || (paramInt == 105) || (paramInt == 106) || (paramInt == 116) || (paramInt == 122) || (paramInt == 117) || (paramInt >= 142) || (paramInt == 121) || (paramInt == 126) || (paramInt == 115) || (paramInt == 124) || (paramInt == 125) || (paramInt == 127) || (paramInt == 140) || (paramInt == 141) || (paramInt == 129) || (paramInt == 130) || (paramInt == 136) || (paramInt == 46);
  }
  
  /* Error */
  public static boolean f(ArticleInfo paramArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 1367
    //   3: invokestatic 143	auvk:traceBegin	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: ifnull +154 -> 161
    //   10: aload_0
    //   11: getfield 1370	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   14: invokestatic 683	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +144 -> 161
    //   20: aload_0
    //   21: getfield 1373	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mFeedType	I
    //   24: bipush 29
    //   26: if_icmpeq +8 -> 34
    //   29: invokestatic 150	auvk:traceEnd	()V
    //   32: iconst_0
    //   33: ireturn
    //   34: new 426	org/json/JSONObject
    //   37: dup
    //   38: aload_0
    //   39: getfield 1370	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:proteusItemsData	Ljava/lang/String;
    //   42: invokespecial 1275	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore_0
    //   46: aload_0
    //   47: invokevirtual 764	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   50: astore_2
    //   51: aload_2
    //   52: invokeinterface 719 1 0
    //   57: ifeq +104 -> 161
    //   60: aload_2
    //   61: invokeinterface 723 1 0
    //   66: checkcast 198	java/lang/String
    //   69: astore_3
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 1376	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: astore 4
    //   77: ldc_w 1378
    //   80: aload_3
    //   81: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   84: ifeq -33 -> 51
    //   87: ldc 231
    //   89: iconst_1
    //   90: iconst_2
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: ldc_w 1380
    //   99: aastore
    //   100: dup
    //   101: iconst_1
    //   102: aload 4
    //   104: aastore
    //   105: invokestatic 226	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   108: invokestatic 150	auvk:traceEnd	()V
    //   111: ldc_w 1382
    //   114: aload 4
    //   116: invokestatic 1385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +19 -> 141
    //   125: ldc_w 1387
    //   128: aload 4
    //   130: invokestatic 1385	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 583	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   136: istore_1
    //   137: iload_1
    //   138: ifeq +7 -> 145
    //   141: iconst_1
    //   142: istore_1
    //   143: iload_1
    //   144: ireturn
    //   145: iconst_0
    //   146: istore_1
    //   147: goto -4 -> 143
    //   150: astore_0
    //   151: ldc 231
    //   153: iconst_1
    //   154: ldc_w 1389
    //   157: aload_0
    //   158: invokestatic 1284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   161: invokestatic 150	auvk:traceEnd	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_0
    //   167: ldc 231
    //   169: iconst_1
    //   170: ldc_w 1391
    //   173: aload_0
    //   174: invokestatic 1284	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -16 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramArticleInfo	ArticleInfo
    //   136	11	1	bool	boolean
    //   50	11	2	localIterator	Iterator
    //   69	12	3	str	String
    //   75	54	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	51	150	org/json/JSONException
    //   51	137	150	org/json/JSONException
    //   34	51	166	java/lang/Exception
    //   51	137	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kvx
 * JD-Core Version:    0.7.0.1
 */