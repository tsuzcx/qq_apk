package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kko;
import kkp;
import kkw;
import nlg;
import org.json.JSONException;
import org.json.JSONObject;

public class AdData
  extends ProteusItemData
  implements Parcelable
{
  public static final Parcelable.Creator<AdData> CREATOR = new nlg();
  public kko a;
  public kkp a;
  public JSONObject aB;
  public JSONObject aC;
  public int aZS;
  public int aZT;
  public int aZU;
  public int aZV;
  public int aZW;
  public int aZX;
  public int aZY;
  public int aZZ;
  public String aaL;
  public String abq;
  public String abr;
  public String abt;
  public long aid;
  public String ajH;
  public String alD;
  public String alE;
  public String alF;
  public String alG;
  public String alH = "1";
  public String alI;
  public String alJ;
  public String alK;
  public String alL;
  public String alM;
  public String alN;
  public String alO;
  public String alP;
  public String alQ;
  public String alR;
  public String alS;
  public String alT;
  public String alU;
  public String alV = "";
  public String alW;
  public String alX;
  public long appId;
  public String appName = "";
  public boolean atj;
  public boolean atk;
  public int baa;
  public int bab;
  public int bac;
  public String channelId;
  public String content;
  public int downloadState = 0;
  public int imgType;
  public String imgUrl;
  public String jumpUrl;
  public ArrayList<String> lH;
  public ArrayList<String> lI;
  public ArrayList<String> lJ;
  public String mAdExt;
  public String mAdExtInfo;
  public kkw mAdvertisementExtInfo;
  public ArrayList<DislikeInfo> mDislikeInfos;
  public String mPopFormH5Url;
  public boolean mShowAdButton = true;
  public int miniProgramType;
  public String pkgName;
  public String productId;
  public int productType;
  public int progress;
  public int req_type;
  public String rowkey;
  public String title;
  public String via;
  public String videoUrl;
  public long xF;
  public long xG;
  public long xH;
  
  public AdData(int paramInt)
  {
    super(paramInt);
  }
  
  public AdData(Parcel paramParcel)
  {
    super(paramParcel);
    this.alD = paramParcel.readString();
    this.title = paramParcel.readString();
    this.content = paramParcel.readString();
    this.imgUrl = paramParcel.readString();
    this.imgType = paramParcel.readInt();
    this.alE = paramParcel.readString();
    this.jumpUrl = paramParcel.readString();
    this.alF = paramParcel.readString();
    this.productType = paramParcel.readInt();
    this.pkgName = paramParcel.readString();
    this.appName = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (;;)
    {
      this.atj = bool;
      this.alG = paramParcel.readString();
      this.alH = paramParcel.readString();
      this.aZS = paramParcel.readInt();
      this.lH = new ArrayList();
      paramParcel.readList(this.lH, String.class.getClassLoader());
      this.alI = paramParcel.readString();
      this.alJ = paramParcel.readString();
      this.mDislikeInfos = new ArrayList();
      paramParcel.readList(this.mDislikeInfos, DislikeInfo.class.getClassLoader());
      this.alK = paramParcel.readString();
      this.videoUrl = paramParcel.readString();
      this.alL = paramParcel.readString();
      this.alM = paramParcel.readString();
      this.aid = paramParcel.readLong();
      this.productId = paramParcel.readString();
      this.via = paramParcel.readString();
      this.alN = paramParcel.readString();
      this.alO = paramParcel.readString();
      this.aZT = paramParcel.readInt();
      this.alP = paramParcel.readString();
      this.alQ = paramParcel.readString();
      this.appId = paramParcel.readLong();
      this.alR = paramParcel.readString();
      this.alS = paramParcel.readString();
      this.channelId = paramParcel.readString();
      this.xF = paramParcel.readLong();
      this.aZU = paramParcel.readInt();
      this.alT = paramParcel.readString();
      this.xG = paramParcel.readLong();
      this.xH = paramParcel.readLong();
      this.aZV = paramParcel.readInt();
      this.alV = paramParcel.readString();
      this.abq = paramParcel.readString();
      this.rowkey = paramParcel.readString();
      this.abt = paramParcel.readString();
      this.abr = paramParcel.readString();
      this.miniProgramType = paramParcel.readInt();
      this.aZX = paramParcel.readInt();
      this.mAdExtInfo = paramParcel.readString();
      this.mAdExt = paramParcel.readString();
      return;
      bool = false;
    }
  }
  
  public static boolean b(BaseData paramBaseData)
  {
    switch (paramBaseData.type)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public boolean FK()
  {
    if (this.aC != null)
    {
      Object localObject = this.aC.opt("extendInfo");
      if ((localObject instanceof JSONObject)) {
        return !TextUtils.isEmpty(((JSONObject)localObject).optString("game_pkg_name"));
      }
    }
    return false;
  }
  
  public boolean a(JSONObject paramJSONObject, int paramInt)
  {
    return true;
  }
  
  public void aDY() {}
  
  /* Error */
  public void d(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_1
    //   4: istore 7
    //   6: aload_1
    //   7: ifnull +2255 -> 2262
    //   10: aload_0
    //   11: aload_2
    //   12: putfield 190	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alK	Ljava/lang/String;
    //   15: aload_0
    //   16: aload_1
    //   17: ldc_w 291
    //   20: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   23: putfield 228	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZU	I
    //   26: aload_0
    //   27: aload_1
    //   28: ldc_w 297
    //   31: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   34: putfield 192	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:videoUrl	Ljava/lang/String;
    //   37: aload_0
    //   38: aload_1
    //   39: ldc_w 299
    //   42: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   45: putfield 194	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alL	Ljava/lang/String;
    //   48: aload_0
    //   49: aload_1
    //   50: ldc_w 301
    //   53: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 196	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alM	Ljava/lang/String;
    //   59: aload_0
    //   60: aload_1
    //   61: ldc_w 303
    //   64: invokevirtual 307	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   67: putfield 202	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aid	J
    //   70: aload_0
    //   71: aload_1
    //   72: ldc_w 309
    //   75: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 204	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:productId	Ljava/lang/String;
    //   81: aload_0
    //   82: aload_1
    //   83: ldc_w 311
    //   86: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: putfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:via	Ljava/lang/String;
    //   92: aload_0
    //   93: aload_1
    //   94: ldc_w 313
    //   97: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: putfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alN	Ljava/lang/String;
    //   103: aload_0
    //   104: aload_1
    //   105: ldc_w 315
    //   108: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 210	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alO	Ljava/lang/String;
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 317
    //   119: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   122: putfield 212	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZT	I
    //   125: aload_0
    //   126: aload_1
    //   127: ldc_w 319
    //   130: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   133: putfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alP	Ljava/lang/String;
    //   136: aload_0
    //   137: aload_1
    //   138: ldc_w 321
    //   141: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   144: putfield 216	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alQ	Ljava/lang/String;
    //   147: aload_0
    //   148: aload_1
    //   149: ldc_w 323
    //   152: invokevirtual 307	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   155: putfield 218	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:appId	J
    //   158: aload_0
    //   159: aload_1
    //   160: ldc_w 325
    //   163: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: putfield 220	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alR	Ljava/lang/String;
    //   169: aload_0
    //   170: aload_1
    //   171: ldc_w 327
    //   174: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 222	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alS	Ljava/lang/String;
    //   180: aload_0
    //   181: aload_1
    //   182: ldc_w 329
    //   185: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   188: putfield 224	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:channelId	Ljava/lang/String;
    //   191: aload_0
    //   192: aload_1
    //   193: ldc_w 331
    //   196: invokevirtual 307	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   199: putfield 226	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:xF	J
    //   202: aload_0
    //   203: aload_1
    //   204: ldc_w 333
    //   207: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   210: putfield 230	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alT	Ljava/lang/String;
    //   213: aload_0
    //   214: aload_1
    //   215: ldc_w 335
    //   218: invokevirtual 307	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   221: putfield 232	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:xG	J
    //   224: aload_0
    //   225: aload_1
    //   226: ldc_w 337
    //   229: invokevirtual 307	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   232: putfield 234	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:xH	J
    //   235: aload_0
    //   236: aload_1
    //   237: ldc_w 339
    //   240: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   243: putfield 159	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:atj	Z
    //   246: aload_0
    //   247: getfield 159	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:atj	Z
    //   250: ifeq +14 -> 264
    //   253: aload_0
    //   254: aload_1
    //   255: ldc_w 339
    //   258: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   261: putfield 161	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alG	Ljava/lang/String;
    //   264: aload_1
    //   265: ldc_w 345
    //   268: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   271: ifeq +14 -> 285
    //   274: aload_0
    //   275: aload_1
    //   276: ldc_w 345
    //   279: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   282: putfield 131	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alD	Ljava/lang/String;
    //   285: aload_1
    //   286: ldc_w 346
    //   289: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   292: ifeq +14 -> 306
    //   295: aload_0
    //   296: aload_1
    //   297: ldc_w 346
    //   300: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   303: putfield 133	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:title	Ljava/lang/String;
    //   306: aload_1
    //   307: ldc_w 347
    //   310: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   313: ifeq +14 -> 327
    //   316: aload_0
    //   317: aload_1
    //   318: ldc_w 347
    //   321: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 135	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:content	Ljava/lang/String;
    //   327: aload_1
    //   328: ldc_w 349
    //   331: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   334: ifeq +14 -> 348
    //   337: aload_0
    //   338: aload_1
    //   339: ldc_w 349
    //   342: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   345: putfield 143	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:imgType	I
    //   348: aload_1
    //   349: ldc_w 351
    //   352: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   355: ifeq +39 -> 394
    //   358: aload_1
    //   359: ldc_w 351
    //   362: invokevirtual 355	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   365: astore_2
    //   366: aload_2
    //   367: invokevirtual 360	org/json/JSONArray:length	()I
    //   370: ifle +24 -> 394
    //   373: aload_0
    //   374: getfield 143	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:imgType	I
    //   377: iconst_1
    //   378: if_icmpne +1007 -> 1385
    //   381: aload_0
    //   382: aload_2
    //   383: iconst_0
    //   384: invokevirtual 363	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   387: iconst_1
    //   388: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   391: putfield 137	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:imgUrl	Ljava/lang/String;
    //   394: aload_1
    //   395: ldc_w 371
    //   398: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   401: ifeq +18 -> 419
    //   404: aload_0
    //   405: aload_1
    //   406: ldc_w 371
    //   409: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   412: iconst_1
    //   413: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   416: putfield 145	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alE	Ljava/lang/String;
    //   419: aload_1
    //   420: ldc_w 373
    //   423: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   426: ifeq +18 -> 444
    //   429: aload_0
    //   430: aload_1
    //   431: ldc_w 373
    //   434: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   437: iconst_1
    //   438: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   441: putfield 147	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jumpUrl	Ljava/lang/String;
    //   444: aload_1
    //   445: ldc_w 375
    //   448: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   451: ifeq +18 -> 469
    //   454: aload_0
    //   455: aload_1
    //   456: ldc_w 375
    //   459: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: iconst_1
    //   463: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   466: putfield 149	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alF	Ljava/lang/String;
    //   469: aload_1
    //   470: ldc_w 377
    //   473: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   476: ifeq +14 -> 490
    //   479: aload_0
    //   480: aload_1
    //   481: ldc_w 377
    //   484: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   487: putfield 151	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:productType	I
    //   490: aload_1
    //   491: ldc_w 319
    //   494: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   497: ifeq +14 -> 511
    //   500: aload_0
    //   501: aload_1
    //   502: ldc_w 319
    //   505: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   508: putfield 153	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:pkgName	Ljava/lang/String;
    //   511: aload_1
    //   512: ldc_w 379
    //   515: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   518: ifeq +14 -> 532
    //   521: aload_0
    //   522: aload_1
    //   523: ldc_w 379
    //   526: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   529: putfield 110	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:appName	Ljava/lang/String;
    //   532: aload_1
    //   533: ldc_w 381
    //   536: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   539: ifeq +14 -> 553
    //   542: aload_0
    //   543: aload_1
    //   544: ldc_w 381
    //   547: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   550: putfield 114	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alH	Ljava/lang/String;
    //   553: aload_1
    //   554: ldc_w 383
    //   557: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   560: ifeq +14 -> 574
    //   563: aload_0
    //   564: aload_1
    //   565: ldc_w 383
    //   568: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   571: putfield 163	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZS	I
    //   574: aload_1
    //   575: ldc_w 385
    //   578: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   581: ifeq +14 -> 595
    //   584: aload_0
    //   585: aload_1
    //   586: ldc_w 385
    //   589: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   592: putfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alJ	Ljava/lang/String;
    //   595: aload_1
    //   596: ldc_w 387
    //   599: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   602: ifeq +14 -> 616
    //   605: aload_0
    //   606: aload_1
    //   607: ldc_w 387
    //   610: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   613: putfield 182	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alI	Ljava/lang/String;
    //   616: aload_1
    //   617: ldc_w 389
    //   620: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   623: ifeq +14 -> 637
    //   626: aload_0
    //   627: aload_1
    //   628: ldc_w 389
    //   631: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   634: putfield 163	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZS	I
    //   637: aload_1
    //   638: ldc_w 391
    //   641: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   644: ifeq +14 -> 658
    //   647: aload_0
    //   648: aload_1
    //   649: ldc_w 391
    //   652: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   655: putfield 393	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alU	Ljava/lang/String;
    //   658: aload_1
    //   659: ldc_w 395
    //   662: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   665: ifeq +14 -> 679
    //   668: aload_0
    //   669: aload_1
    //   670: ldc_w 395
    //   673: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   676: putfield 118	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alV	Ljava/lang/String;
    //   679: aload_1
    //   680: ldc_w 397
    //   683: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   686: ifeq +14 -> 700
    //   689: aload_0
    //   690: aload_1
    //   691: ldc_w 397
    //   694: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   697: putfield 242	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:abt	Ljava/lang/String;
    //   700: aload_1
    //   701: ldc_w 399
    //   704: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   707: ifeq +14 -> 721
    //   710: aload_0
    //   711: aload_1
    //   712: ldc_w 399
    //   715: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   718: putfield 238	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:abq	Ljava/lang/String;
    //   721: aload_1
    //   722: ldc_w 400
    //   725: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   728: ifeq +14 -> 742
    //   731: aload_0
    //   732: aload_1
    //   733: ldc_w 400
    //   736: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   739: putfield 240	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:rowkey	Ljava/lang/String;
    //   742: aload_1
    //   743: ldc_w 402
    //   746: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   749: ifeq +14 -> 763
    //   752: aload_0
    //   753: aload_1
    //   754: ldc_w 402
    //   757: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   760: putfield 244	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:abr	Ljava/lang/String;
    //   763: aload_0
    //   764: aload_1
    //   765: ldc_w 404
    //   768: iconst_0
    //   769: invokevirtual 407	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   772: putfield 409	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZZ	I
    //   775: aload_1
    //   776: ldc_w 411
    //   779: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   782: ifeq +14 -> 796
    //   785: aload_0
    //   786: aload_1
    //   787: ldc_w 411
    //   790: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   793: putfield 413	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZW	I
    //   796: aload_0
    //   797: new 415	kko
    //   800: dup
    //   801: invokespecial 416	kko:<init>	()V
    //   804: putfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   807: aload_1
    //   808: ldc_w 420
    //   811: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   814: ifeq +703 -> 1517
    //   817: aload_1
    //   818: ldc_w 420
    //   821: invokevirtual 424	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   824: astore_2
    //   825: aload_0
    //   826: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   829: aload_2
    //   830: invokevirtual 428	kko:N	(Lorg/json/JSONObject;)V
    //   833: aload_0
    //   834: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   837: getfield 429	kko:pkgName	Ljava/lang/String;
    //   840: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   843: ifne +25 -> 868
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   851: getfield 429	kko:pkgName	Ljava/lang/String;
    //   854: putfield 153	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:pkgName	Ljava/lang/String;
    //   857: aload_0
    //   858: aload_0
    //   859: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   862: getfield 429	kko:pkgName	Ljava/lang/String;
    //   865: putfield 214	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alP	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   872: aload_0
    //   873: getfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:via	Ljava/lang/String;
    //   876: putfield 430	kko:via	Ljava/lang/String;
    //   879: aload_0
    //   880: aload_1
    //   881: ldc_w 432
    //   884: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   887: putfield 434	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZY	I
    //   890: aload_0
    //   891: aload_1
    //   892: ldc_w 436
    //   895: ldc 108
    //   897: invokevirtual 439	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   900: putfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExt	Ljava/lang/String;
    //   903: aload_0
    //   904: getfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExt	Ljava/lang/String;
    //   907: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   910: ifeq +17 -> 927
    //   913: aload_0
    //   914: new 267	org/json/JSONObject
    //   917: dup
    //   918: invokespecial 440	org/json/JSONObject:<init>	()V
    //   921: invokevirtual 443	org/json/JSONObject:toString	()Ljava/lang/String;
    //   924: putfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExt	Ljava/lang/String;
    //   927: aload_0
    //   928: new 445	kkp
    //   931: dup
    //   932: invokespecial 446	kkp:<init>	()V
    //   935: putfield 448	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kkp	Lkkp;
    //   938: aload_0
    //   939: getfield 448	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kkp	Lkkp;
    //   942: aload_1
    //   943: aload_0
    //   944: getfield 448	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kkp	Lkkp;
    //   947: aload_0
    //   948: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   951: invokevirtual 451	kkp:a	(Lorg/json/JSONObject;Lkkp;Lkko;)V
    //   954: aload_1
    //   955: ldc_w 453
    //   958: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   961: ifeq +14 -> 975
    //   964: aload_0
    //   965: aload_1
    //   966: ldc_w 453
    //   969: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   972: putfield 455	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alW	Ljava/lang/String;
    //   975: aload_1
    //   976: ldc_w 457
    //   979: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   982: ifeq +14 -> 996
    //   985: aload_0
    //   986: aload_1
    //   987: ldc_w 457
    //   990: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   993: putfield 459	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alX	Ljava/lang/String;
    //   996: aload_1
    //   997: ldc_w 461
    //   1000: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1003: ifeq +26 -> 1029
    //   1006: aload_1
    //   1007: ldc_w 461
    //   1010: invokevirtual 271	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   1013: astore_2
    //   1014: aload_2
    //   1015: instanceof 267
    //   1018: ifeq +11 -> 1029
    //   1021: aload_0
    //   1022: aload_2
    //   1023: invokevirtual 464	java/lang/Object:toString	()Ljava/lang/String;
    //   1026: putfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1029: aload_0
    //   1030: getfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1033: invokestatic 283	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1036: ifeq +17 -> 1053
    //   1039: aload_0
    //   1040: new 267	org/json/JSONObject
    //   1043: dup
    //   1044: invokespecial 440	org/json/JSONObject:<init>	()V
    //   1047: invokevirtual 443	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1050: putfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1053: new 267	org/json/JSONObject
    //   1056: dup
    //   1057: aload_0
    //   1058: getfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1061: invokespecial 467	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1064: astore_2
    //   1065: aload_2
    //   1066: ldc_w 469
    //   1069: aload_0
    //   1070: getfield 190	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alK	Ljava/lang/String;
    //   1073: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1076: pop
    //   1077: aload_1
    //   1078: ldc_w 475
    //   1081: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1084: ifeq +18 -> 1102
    //   1087: aload_2
    //   1088: ldc_w 475
    //   1091: aload_1
    //   1092: ldc_w 475
    //   1095: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1098: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1101: pop
    //   1102: aload_1
    //   1103: ldc_w 477
    //   1106: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1109: ifeq +18 -> 1127
    //   1112: aload_2
    //   1113: ldc_w 477
    //   1116: aload_1
    //   1117: ldc_w 477
    //   1120: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1123: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1126: pop
    //   1127: aload_1
    //   1128: ldc_w 479
    //   1131: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1134: ifeq +18 -> 1152
    //   1137: aload_2
    //   1138: ldc_w 479
    //   1141: aload_1
    //   1142: ldc_w 479
    //   1145: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1148: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1151: pop
    //   1152: aload_1
    //   1153: ldc_w 481
    //   1156: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1159: ifeq +18 -> 1177
    //   1162: aload_2
    //   1163: ldc_w 481
    //   1166: aload_1
    //   1167: ldc_w 481
    //   1170: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1173: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1176: pop
    //   1177: aload_1
    //   1178: ldc_w 483
    //   1181: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1184: ifeq +18 -> 1202
    //   1187: aload_2
    //   1188: ldc_w 483
    //   1191: aload_1
    //   1192: ldc_w 483
    //   1195: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1198: invokevirtual 473	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1201: pop
    //   1202: aload_0
    //   1203: aload_2
    //   1204: invokevirtual 443	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1207: putfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1210: aload_0
    //   1211: new 485	kkw
    //   1214: dup
    //   1215: aload_0
    //   1216: getfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdExtInfo	Ljava/lang/String;
    //   1219: invokespecial 486	kkw:<init>	(Ljava/lang/String;)V
    //   1222: putfield 488	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdvertisementExtInfo	Lkkw;
    //   1225: aload_1
    //   1226: ldc_w 490
    //   1229: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1232: ifeq +14 -> 1246
    //   1235: aload_0
    //   1236: aload_1
    //   1237: ldc_w 490
    //   1240: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1243: putfield 246	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:miniProgramType	I
    //   1246: aload_1
    //   1247: ldc_w 492
    //   1250: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1253: ifeq +25 -> 1278
    //   1256: aload_0
    //   1257: aload_1
    //   1258: ldc_w 492
    //   1261: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1264: putfield 494	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:baa	I
    //   1267: aload_0
    //   1268: getfield 488	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mAdvertisementExtInfo	Lkkw;
    //   1271: aload_0
    //   1272: getfield 494	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:baa	I
    //   1275: putfield 497	kkw:aJA	I
    //   1278: aload_1
    //   1279: ldc_w 499
    //   1282: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1285: ifeq +328 -> 1613
    //   1288: aload_1
    //   1289: ldc_w 499
    //   1292: invokevirtual 355	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1295: astore_2
    //   1296: new 165	java/util/ArrayList
    //   1299: dup
    //   1300: invokespecial 166	java/util/ArrayList:<init>	()V
    //   1303: astore 8
    //   1305: aload_2
    //   1306: ifnull +307 -> 1613
    //   1309: new 165	java/util/ArrayList
    //   1312: dup
    //   1313: invokespecial 166	java/util/ArrayList:<init>	()V
    //   1316: pop
    //   1317: iconst_0
    //   1318: istore_3
    //   1319: iload_3
    //   1320: aload_2
    //   1321: invokevirtual 360	org/json/JSONArray:length	()I
    //   1324: if_icmpge +283 -> 1607
    //   1327: new 188	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo
    //   1330: dup
    //   1331: invokespecial 500	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:<init>	()V
    //   1334: astore 9
    //   1336: aload_2
    //   1337: iload_3
    //   1338: invokevirtual 504	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   1341: astore 10
    //   1343: aload 9
    //   1345: aload 10
    //   1347: ldc_w 506
    //   1350: invokevirtual 509	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1353: i2l
    //   1354: putfield 512	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:vf	J
    //   1357: aload 9
    //   1359: aload 10
    //   1361: ldc_w 514
    //   1364: invokevirtual 517	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1367: putfield 520	com/tencent/biz/pubaccount/readinjoy/struct/DislikeInfo:agQ	Ljava/lang/String;
    //   1370: aload 8
    //   1372: aload 9
    //   1374: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1377: pop
    //   1378: iload_3
    //   1379: iconst_1
    //   1380: iadd
    //   1381: istore_3
    //   1382: goto -63 -> 1319
    //   1385: aload_0
    //   1386: getfield 143	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:imgType	I
    //   1389: iconst_3
    //   1390: if_icmpne -996 -> 394
    //   1393: aload_0
    //   1394: new 165	java/util/ArrayList
    //   1397: dup
    //   1398: invokespecial 166	java/util/ArrayList:<init>	()V
    //   1401: putfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lH	Ljava/util/ArrayList;
    //   1404: aload_2
    //   1405: invokevirtual 360	org/json/JSONArray:length	()I
    //   1408: istore 5
    //   1410: iconst_0
    //   1411: istore_3
    //   1412: iload_3
    //   1413: iload 5
    //   1415: if_icmpge +27 -> 1442
    //   1418: aload_0
    //   1419: getfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lH	Ljava/util/ArrayList;
    //   1422: aload_2
    //   1423: iload_3
    //   1424: invokevirtual 363	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1427: iconst_1
    //   1428: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1431: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1434: pop
    //   1435: iload_3
    //   1436: iconst_1
    //   1437: iadd
    //   1438: istore_3
    //   1439: goto -27 -> 1412
    //   1442: iload 5
    //   1444: iconst_3
    //   1445: if_icmpge -1051 -> 394
    //   1448: iload 5
    //   1450: iconst_2
    //   1451: if_icmpne +23 -> 1474
    //   1454: aload_0
    //   1455: getfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lH	Ljava/util/ArrayList;
    //   1458: aload_2
    //   1459: iconst_0
    //   1460: invokevirtual 363	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1463: iconst_1
    //   1464: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1467: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1470: pop
    //   1471: goto -1077 -> 394
    //   1474: iload 5
    //   1476: iconst_1
    //   1477: if_icmpne -1083 -> 394
    //   1480: aload_0
    //   1481: getfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lH	Ljava/util/ArrayList;
    //   1484: aload_2
    //   1485: iconst_0
    //   1486: invokevirtual 363	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1489: iconst_1
    //   1490: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1493: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1496: pop
    //   1497: aload_0
    //   1498: getfield 168	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lH	Ljava/util/ArrayList;
    //   1501: aload_2
    //   1502: iconst_0
    //   1503: invokevirtual 363	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   1506: iconst_1
    //   1507: invokestatic 369	nnc:f	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1510: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1513: pop
    //   1514: goto -1120 -> 394
    //   1517: aload_0
    //   1518: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   1521: aload_0
    //   1522: getfield 153	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:pkgName	Ljava/lang/String;
    //   1525: putfield 429	kko:pkgName	Ljava/lang/String;
    //   1528: aload_0
    //   1529: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   1532: aload_0
    //   1533: getfield 206	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:via	Ljava/lang/String;
    //   1536: putfield 430	kko:via	Ljava/lang/String;
    //   1539: aload_0
    //   1540: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   1543: aload_0
    //   1544: getfield 216	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alQ	Ljava/lang/String;
    //   1547: putfield 527	kko:ZK	Ljava/lang/String;
    //   1550: aload_0
    //   1551: getfield 418	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:jdField_a_of_type_Kko	Lkko;
    //   1554: aload_0
    //   1555: getfield 218	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:appId	J
    //   1558: invokestatic 531	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1561: putfield 533	kko:appid	Ljava/lang/String;
    //   1564: goto -685 -> 879
    //   1567: astore_2
    //   1568: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1571: ifeq -361 -> 1210
    //   1574: ldc_w 540
    //   1577: iconst_2
    //   1578: new 542	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1585: ldc_w 545
    //   1588: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1591: aload_2
    //   1592: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   1595: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1598: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1601: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1604: goto -394 -> 1210
    //   1607: aload_0
    //   1608: aload 8
    //   1610: putfield 186	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mDislikeInfos	Ljava/util/ArrayList;
    //   1613: aload_1
    //   1614: ldc_w 556
    //   1617: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1620: ifeq +23 -> 1643
    //   1623: aload_1
    //   1624: ldc_w 556
    //   1627: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1630: iconst_1
    //   1631: if_icmpne +298 -> 1929
    //   1634: iconst_1
    //   1635: istore 6
    //   1637: aload_0
    //   1638: iload 6
    //   1640: putfield 558	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:atk	Z
    //   1643: aload_1
    //   1644: ldc_w 560
    //   1647: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1650: ifeq +74 -> 1724
    //   1653: new 267	org/json/JSONObject
    //   1656: dup
    //   1657: aload_1
    //   1658: ldc_w 560
    //   1661: invokevirtual 277	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1664: invokespecial 467	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1667: astore_2
    //   1668: aload_2
    //   1669: ldc_w 562
    //   1672: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1675: ifeq +49 -> 1724
    //   1678: aload_2
    //   1679: ldc_w 562
    //   1682: invokevirtual 517	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1685: astore_2
    //   1686: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1689: ifeq +30 -> 1719
    //   1692: ldc_w 540
    //   1695: iconst_2
    //   1696: new 542	java/lang/StringBuilder
    //   1699: dup
    //   1700: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1703: ldc_w 564
    //   1706: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: aload_2
    //   1710: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1716: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1719: aload_0
    //   1720: aload_2
    //   1721: putfield 566	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mPopFormH5Url	Ljava/lang/String;
    //   1724: aload_1
    //   1725: ldc_w 568
    //   1728: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1731: ifeq +66 -> 1797
    //   1734: aload_1
    //   1735: ldc_w 568
    //   1738: ldc 112
    //   1740: invokevirtual 439	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1743: astore_2
    //   1744: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1747: ifeq +30 -> 1777
    //   1750: ldc_w 540
    //   1753: iconst_2
    //   1754: new 542	java/lang/StringBuilder
    //   1757: dup
    //   1758: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1761: ldc_w 570
    //   1764: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: aload_2
    //   1768: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1774: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1777: aload_2
    //   1778: ldc_w 572
    //   1781: invokevirtual 575	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1784: ifne +191 -> 1975
    //   1787: iload 7
    //   1789: istore 6
    //   1791: aload_0
    //   1792: iload 6
    //   1794: putfield 116	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:mShowAdButton	Z
    //   1797: aload_1
    //   1798: ldc_w 577
    //   1801: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1804: ifeq +14 -> 1818
    //   1807: aload_0
    //   1808: aload_1
    //   1809: ldc_w 577
    //   1812: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1815: putfield 236	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZV	I
    //   1818: aload_1
    //   1819: ldc_w 579
    //   1822: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   1825: ifeq +202 -> 2027
    //   1828: aload_1
    //   1829: ldc_w 579
    //   1832: invokevirtual 355	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   1835: astore_2
    //   1836: aload_2
    //   1837: ifnull +190 -> 2027
    //   1840: aload_2
    //   1841: invokevirtual 360	org/json/JSONArray:length	()I
    //   1844: ifle +183 -> 2027
    //   1847: aload_2
    //   1848: invokevirtual 360	org/json/JSONArray:length	()I
    //   1851: istore 5
    //   1853: new 165	java/util/ArrayList
    //   1856: dup
    //   1857: invokespecial 166	java/util/ArrayList:<init>	()V
    //   1860: astore 8
    //   1862: iconst_0
    //   1863: istore_3
    //   1864: iload_3
    //   1865: iload 5
    //   1867: if_icmpge +154 -> 2021
    //   1870: aload_2
    //   1871: iload_3
    //   1872: invokevirtual 582	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   1875: checkcast 170	java/lang/String
    //   1878: astore 9
    //   1880: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1883: ifeq +31 -> 1914
    //   1886: ldc_w 584
    //   1889: iconst_2
    //   1890: new 542	java/lang/StringBuilder
    //   1893: dup
    //   1894: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1897: ldc_w 586
    //   1900: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: aload 9
    //   1905: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1914: aload 8
    //   1916: aload 9
    //   1918: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1921: pop
    //   1922: iload_3
    //   1923: iconst_1
    //   1924: iadd
    //   1925: istore_3
    //   1926: goto -62 -> 1864
    //   1929: iconst_0
    //   1930: istore 6
    //   1932: goto -295 -> 1637
    //   1935: astore_2
    //   1936: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1939: ifeq -215 -> 1724
    //   1942: ldc_w 540
    //   1945: iconst_2
    //   1946: new 542	java/lang/StringBuilder
    //   1949: dup
    //   1950: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1953: ldc_w 588
    //   1956: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: aload_2
    //   1960: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   1963: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: goto -248 -> 1724
    //   1975: iconst_0
    //   1976: istore 6
    //   1978: goto -187 -> 1791
    //   1981: astore_2
    //   1982: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1985: ifeq -188 -> 1797
    //   1988: ldc_w 540
    //   1991: iconst_2
    //   1992: new 542	java/lang/StringBuilder
    //   1995: dup
    //   1996: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   1999: ldc_w 588
    //   2002: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2005: aload_2
    //   2006: invokevirtual 550	java/lang/Exception:toString	()Ljava/lang/String;
    //   2009: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2015: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2018: goto -221 -> 1797
    //   2021: aload_0
    //   2022: aload 8
    //   2024: putfield 590	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lI	Ljava/util/ArrayList;
    //   2027: aload_1
    //   2028: ldc_w 592
    //   2031: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2034: ifeq +111 -> 2145
    //   2037: aload_1
    //   2038: ldc_w 592
    //   2041: invokevirtual 355	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   2044: astore_2
    //   2045: aload_2
    //   2046: ifnull +99 -> 2145
    //   2049: aload_2
    //   2050: invokevirtual 360	org/json/JSONArray:length	()I
    //   2053: ifle +92 -> 2145
    //   2056: aload_2
    //   2057: invokevirtual 360	org/json/JSONArray:length	()I
    //   2060: istore 5
    //   2062: new 165	java/util/ArrayList
    //   2065: dup
    //   2066: invokespecial 166	java/util/ArrayList:<init>	()V
    //   2069: astore 8
    //   2071: iload 4
    //   2073: istore_3
    //   2074: iload_3
    //   2075: iload 5
    //   2077: if_icmpge +62 -> 2139
    //   2080: aload_2
    //   2081: iload_3
    //   2082: invokevirtual 582	org/json/JSONArray:opt	(I)Ljava/lang/Object;
    //   2085: checkcast 170	java/lang/String
    //   2088: astore 9
    //   2090: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2093: ifeq +31 -> 2124
    //   2096: ldc_w 584
    //   2099: iconst_2
    //   2100: new 542	java/lang/StringBuilder
    //   2103: dup
    //   2104: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2107: ldc_w 594
    //   2110: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2113: aload 9
    //   2115: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2118: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2121: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2124: aload 8
    //   2126: aload 9
    //   2128: invokevirtual 524	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2131: pop
    //   2132: iload_3
    //   2133: iconst_1
    //   2134: iadd
    //   2135: istore_3
    //   2136: goto -62 -> 2074
    //   2139: aload_0
    //   2140: aload 8
    //   2142: putfield 596	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:lJ	Ljava/util/ArrayList;
    //   2145: aload_1
    //   2146: ldc_w 598
    //   2149: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2152: ifeq +14 -> 2166
    //   2155: aload_0
    //   2156: aload_1
    //   2157: ldc_w 598
    //   2160: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2163: putfield 248	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZX	I
    //   2166: aload_1
    //   2167: ldc_w 600
    //   2170: invokevirtual 343	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   2173: ifeq +14 -> 2187
    //   2176: aload_0
    //   2177: aload_1
    //   2178: ldc_w 600
    //   2181: invokevirtual 295	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   2184: putfield 602	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:bab	I
    //   2187: invokestatic 538	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2190: ifeq +72 -> 2262
    //   2193: ldc_w 584
    //   2196: iconst_2
    //   2197: new 542	java/lang/StringBuilder
    //   2200: dup
    //   2201: invokespecial 543	java/lang/StringBuilder:<init>	()V
    //   2204: ldc_w 604
    //   2207: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2210: aload_0
    //   2211: getfield 230	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alT	Ljava/lang/String;
    //   2214: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2217: ldc_w 606
    //   2220: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2223: aload_0
    //   2224: getfield 184	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:alJ	Ljava/lang/String;
    //   2227: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2230: ldc_w 608
    //   2233: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: aload_0
    //   2237: getfield 236	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:aZV	I
    //   2240: invokevirtual 611	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2243: ldc_w 613
    //   2246: invokevirtual 549	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2249: aload_0
    //   2250: getfield 602	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/AdData:bab	I
    //   2253: invokevirtual 611	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2256: invokevirtual 551	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2259: invokestatic 554	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2262: return
    //   2263: astore_1
    //   2264: return
    //   2265: astore_2
    //   2266: goto -653 -> 1613
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2269	0	this	AdData
    //   0	2269	1	paramJSONObject	JSONObject
    //   0	2269	2	paramString	String
    //   1318	818	3	i	int
    //   1	2071	4	j	int
    //   1408	670	5	k	int
    //   1635	342	6	bool1	boolean
    //   4	1784	7	bool2	boolean
    //   1303	838	8	localArrayList	ArrayList
    //   1334	793	9	localObject	Object
    //   1341	19	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   1053	1102	1567	java/lang/Exception
    //   1102	1127	1567	java/lang/Exception
    //   1127	1152	1567	java/lang/Exception
    //   1152	1177	1567	java/lang/Exception
    //   1177	1202	1567	java/lang/Exception
    //   1202	1210	1567	java/lang/Exception
    //   1643	1719	1935	java/lang/Exception
    //   1719	1724	1935	java/lang/Exception
    //   1724	1777	1981	java/lang/Exception
    //   1777	1787	1981	java/lang/Exception
    //   1791	1797	1981	java/lang/Exception
    //   1797	1818	2263	java/lang/Exception
    //   1818	1836	2263	java/lang/Exception
    //   1840	1862	2263	java/lang/Exception
    //   1870	1914	2263	java/lang/Exception
    //   1914	1922	2263	java/lang/Exception
    //   2021	2027	2263	java/lang/Exception
    //   2027	2045	2263	java/lang/Exception
    //   2049	2071	2263	java/lang/Exception
    //   2080	2124	2263	java/lang/Exception
    //   2124	2132	2263	java/lang/Exception
    //   2139	2145	2263	java/lang/Exception
    //   2145	2166	2263	java/lang/Exception
    //   2166	2187	2263	java/lang/Exception
    //   2187	2262	2263	java/lang/Exception
    //   1278	1305	2265	java/lang/Exception
    //   1309	1317	2265	java/lang/Exception
    //   1319	1378	2265	java/lang/Exception
    //   1607	1613	2265	java/lang/Exception
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void j(String paramString, Object paramObject)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramObject == null)) {}
    do
    {
      return;
      if (this.aB == null) {
        this.aB = new JSONObject();
      }
      try
      {
        this.aB.put(paramString, paramObject);
        return;
      }
      catch (JSONException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("addArticleExt", 2, "e:" + paramString.toString());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.alD);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.content);
    paramParcel.writeString(this.imgUrl);
    paramParcel.writeInt(this.imgType);
    paramParcel.writeString(this.alE);
    paramParcel.writeString(this.jumpUrl);
    paramParcel.writeString(this.alF);
    paramParcel.writeInt(this.productType);
    paramParcel.writeString(this.pkgName);
    paramParcel.writeString(this.appName);
    if (this.atj) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.alG);
      paramParcel.writeString(this.alH);
      paramParcel.writeInt(this.aZS);
      paramParcel.writeList(this.lH);
      paramParcel.writeString(this.alI);
      paramParcel.writeString(this.alJ);
      paramParcel.writeList(this.mDislikeInfos);
      paramParcel.writeString(this.alK);
      paramParcel.writeString(this.videoUrl);
      paramParcel.writeString(this.alL);
      paramParcel.writeString(this.alM);
      paramParcel.writeLong(this.aid);
      paramParcel.writeString(this.productId);
      paramParcel.writeString(this.via);
      paramParcel.writeString(this.alN);
      paramParcel.writeString(this.alO);
      paramParcel.writeInt(this.aZT);
      paramParcel.writeString(this.alP);
      paramParcel.writeString(this.alQ);
      paramParcel.writeLong(this.appId);
      paramParcel.writeString(this.alR);
      paramParcel.writeString(this.alS);
      paramParcel.writeString(this.channelId);
      paramParcel.writeLong(this.xF);
      paramParcel.writeInt(this.aZU);
      paramParcel.writeString(this.alT);
      paramParcel.writeLong(this.xG);
      paramParcel.writeLong(this.xH);
      paramParcel.writeInt(this.aZV);
      paramParcel.writeString(this.alV);
      paramParcel.writeString(this.abq);
      paramParcel.writeString(this.rowkey);
      paramParcel.writeString(this.abt);
      paramParcel.writeString(this.abr);
      paramParcel.writeInt(this.miniProgramType);
      paramParcel.writeInt(this.aZX);
      paramParcel.writeString(this.mAdExtInfo);
      paramParcel.writeString(this.mAdExt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData
 * JD-Core Version:    0.7.0.1
 */