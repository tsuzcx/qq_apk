import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.ArrayList;
import java.util.List;

public class akhs
  extends BaseAdapter
{
  List<InterestTagInfo> DQ;
  int dmQ;
  int dmR;
  int dmS;
  Drawable fa;
  Context mContext;
  int mImgHeight;
  int mImgWidth;
  int mTagType;
  float sG;
  
  public akhs(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mContext = paramContext;
    this.DQ = new ArrayList(2);
    this.mImgWidth = paramInt1;
    this.mImgHeight = paramInt2;
    int i = this.mContext.getResources().getDimensionPixelSize(2131299330);
    this.dmR = paramInt1;
    this.dmQ = (i + paramInt2);
    this.fa = paramDrawable;
    this.dmS = 0;
    this.mTagType = paramInt3;
    this.sG = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int GQ()
  {
    return this.dmQ;
  }
  
  public void RQ(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((paramInt > 0) && (this.dmS == 0)) {
      if (this.DQ.size() > 0)
      {
        this.DQ.add(0, null);
        this.DQ.add(null);
      }
    }
    for (;;)
    {
      this.dmS = paramInt;
      notifyDataSetChanged();
      return;
      if ((paramInt == 0) && (this.dmS > 0) && (this.DQ.size() > 2))
      {
        this.DQ.remove(0);
        this.DQ.remove(this.DQ.size() - 1);
      }
    }
  }
  
  public int getCount()
  {
    return this.DQ.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.DQ.size()) {
        localObject1 = (InterestTagInfo)this.DQ.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.DQ.size()) {
        localObject1 = (InterestTagInfo)this.DQ.get(paramInt);
      }
    }
    if (localObject1 == null) {
      return 0L;
    }
    return ((InterestTagInfo)localObject1).tagId;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((InterestTagInfo)getItem(paramInt) != null) {
      return 0;
    }
    return 1;
  }
  
  /* Error */
  public android.view.View getView(int paramInt, android.view.View paramView, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokevirtual 120	akhs:getItemViewType	(I)I
    //   5: istore 4
    //   7: iload 4
    //   9: ifne +401 -> 410
    //   12: aload_0
    //   13: iload_1
    //   14: invokevirtual 114	akhs:getItem	(I)Ljava/lang/Object;
    //   17: checkcast 105	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo
    //   20: astore 8
    //   22: aload_2
    //   23: ifnonnull +195 -> 218
    //   26: aload_0
    //   27: getfield 30	akhs:mContext	Landroid/content/Context;
    //   30: invokestatic 126	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   33: ldc 127
    //   35: aconst_null
    //   36: invokevirtual 131	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   39: astore 5
    //   41: new 6	akhs$a
    //   44: dup
    //   45: invokespecial 132	akhs$a:<init>	()V
    //   48: astore 7
    //   50: aload 7
    //   52: aload 5
    //   54: ldc 133
    //   56: invokevirtual 139	android/view/View:findViewById	(I)Landroid/view/View;
    //   59: checkcast 141	com/tencent/image/URLImageView
    //   62: putfield 145	akhs$a:aw	Lcom/tencent/image/URLImageView;
    //   65: aload 7
    //   67: aload 5
    //   69: ldc 146
    //   71: invokevirtual 139	android/view/View:findViewById	(I)Landroid/view/View;
    //   74: checkcast 148	android/widget/TextView
    //   77: putfield 152	akhs$a:title	Landroid/widget/TextView;
    //   80: aload 5
    //   82: aload 7
    //   84: invokevirtual 156	android/view/View:setTag	(Ljava/lang/Object;)V
    //   87: aload 5
    //   89: new 158	android/view/ViewGroup$LayoutParams
    //   92: dup
    //   93: aload_0
    //   94: getfield 56	akhs:dmR	I
    //   97: aload_0
    //   98: getfield 58	akhs:dmQ	I
    //   101: invokespecial 161	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   104: invokevirtual 165	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   107: aload 8
    //   109: ifnull +90 -> 199
    //   112: aload 7
    //   114: ifnull +85 -> 199
    //   117: aload 8
    //   119: getfield 169	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:tagIconUrl	Ljava/lang/String;
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +109 -> 233
    //   127: aload_2
    //   128: ldc 171
    //   130: invokevirtual 176	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifeq +100 -> 233
    //   136: aload 7
    //   138: getfield 145	akhs$a:aw	Lcom/tencent/image/URLImageView;
    //   141: ldc 177
    //   143: invokevirtual 180	com/tencent/image/URLImageView:setImageResource	(I)V
    //   146: aload 8
    //   148: getfield 183	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:tagType	I
    //   151: bipush 10
    //   153: if_icmpeq +23 -> 176
    //   156: aload 8
    //   158: getfield 183	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:tagType	I
    //   161: bipush 11
    //   163: if_icmpeq +13 -> 176
    //   166: aload 8
    //   168: getfield 183	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:tagType	I
    //   171: bipush 9
    //   173: if_icmpne +13 -> 186
    //   176: aload 7
    //   178: getfield 145	akhs$a:aw	Lcom/tencent/image/URLImageView;
    //   181: ldc 184
    //   183: invokevirtual 180	com/tencent/image/URLImageView:setImageResource	(I)V
    //   186: aload 7
    //   188: getfield 152	akhs$a:title	Landroid/widget/TextView;
    //   191: aload 8
    //   193: getfield 187	com/tencent/mobileqq/nearby/interestTag/InterestTagInfo:tagName	Ljava/lang/String;
    //   196: invokevirtual 191	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   199: aload 5
    //   201: astore_2
    //   202: invokestatic 197	com/tencent/qqlive/module/videoreport/collect/EventCollector:getInstance	()Lcom/tencent/qqlive/module/videoreport/collect/EventCollector;
    //   205: iload_1
    //   206: aload_2
    //   207: aload_3
    //   208: aload_0
    //   209: iload_1
    //   210: invokevirtual 199	akhs:getItemId	(I)J
    //   213: invokevirtual 203	com/tencent/qqlive/module/videoreport/collect/EventCollector:onListGetView	(ILandroid/view/View;Landroid/view/ViewGroup;J)V
    //   216: aload_2
    //   217: areturn
    //   218: aload_2
    //   219: invokevirtual 207	android/view/View:getTag	()Ljava/lang/Object;
    //   222: checkcast 6	akhs$a
    //   225: astore 7
    //   227: aload_2
    //   228: astore 5
    //   230: goto -123 -> 107
    //   233: invokestatic 213	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   236: astore 6
    //   238: aload 6
    //   240: aload_0
    //   241: getfield 41	akhs:mImgHeight	I
    //   244: putfield 216	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   247: aload 6
    //   249: aload_0
    //   250: getfield 39	akhs:mImgWidth	I
    //   253: putfield 219	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   256: aload 6
    //   258: aload_0
    //   259: getfield 60	akhs:fa	Landroid/graphics/drawable/Drawable;
    //   262: putfield 222	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   265: aload 6
    //   267: aload 6
    //   269: getfield 222	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   272: putfield 225	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   275: aload 6
    //   277: ldc 227
    //   279: putfield 230	com/tencent/image/URLDrawable$URLDrawableOptions:mMemoryCacheKeySuffix	Ljava/lang/String;
    //   282: aload_2
    //   283: invokestatic 236	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   286: ifne +181 -> 467
    //   289: aload_2
    //   290: invokestatic 242	aomc:l	(Ljava/lang/String;)Ljava/net/URL;
    //   293: aload 6
    //   295: invokestatic 248	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   298: astore_2
    //   299: aload_0
    //   300: getfield 64	akhs:mTagType	I
    //   303: bipush 7
    //   305: if_icmpne +33 -> 338
    //   308: aload_2
    //   309: aload_0
    //   310: getfield 39	akhs:mImgWidth	I
    //   313: aload_0
    //   314: getfield 41	akhs:mImgHeight	I
    //   317: ldc 249
    //   319: aload_0
    //   320: getfield 75	akhs:sG	F
    //   323: fmul
    //   324: f2i
    //   325: invokestatic 255	aqbn:d	(III)[I
    //   328: invokevirtual 256	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   331: aload_2
    //   332: getstatic 259	aqbn:d	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   335: invokevirtual 263	com/tencent/image/URLDrawable:setDecodeHandler	(Lcom/tencent/image/DownloadParams$DecodeHandler;)V
    //   338: aload_2
    //   339: new 265	ajpe
    //   342: dup
    //   343: aload_0
    //   344: getfield 30	akhs:mContext	Landroid/content/Context;
    //   347: ldc_w 267
    //   350: invokespecial 270	ajpe:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   353: invokevirtual 274	com/tencent/image/URLDrawable:setDownloadListener	(Lcom/tencent/image/URLDrawable$DownloadListener;)V
    //   356: aload 6
    //   358: aconst_null
    //   359: putfield 222	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   362: aload 6
    //   364: aconst_null
    //   365: putfield 225	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   368: aload 7
    //   370: getfield 145	akhs$a:aw	Lcom/tencent/image/URLImageView;
    //   373: astore 9
    //   375: aload_2
    //   376: astore 6
    //   378: aload_2
    //   379: ifnonnull +9 -> 388
    //   382: aload_0
    //   383: getfield 60	akhs:fa	Landroid/graphics/drawable/Drawable;
    //   386: astore 6
    //   388: aload 9
    //   390: aload 6
    //   392: invokevirtual 278	com/tencent/image/URLImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   395: goto -209 -> 186
    //   398: astore 6
    //   400: aconst_null
    //   401: astore_2
    //   402: aload 6
    //   404: invokevirtual 281	java/lang/Exception:printStackTrace	()V
    //   407: goto -39 -> 368
    //   410: iload 4
    //   412: iconst_1
    //   413: if_icmpne +51 -> 464
    //   416: aload_2
    //   417: ifnonnull +47 -> 464
    //   420: new 135	android/view/View
    //   423: dup
    //   424: aload_0
    //   425: getfield 30	akhs:mContext	Landroid/content/Context;
    //   428: invokespecial 284	android/view/View:<init>	(Landroid/content/Context;)V
    //   431: astore_2
    //   432: aload_2
    //   433: new 158	android/view/ViewGroup$LayoutParams
    //   436: dup
    //   437: aload_0
    //   438: getfield 62	akhs:dmS	I
    //   441: aload_0
    //   442: getfield 58	akhs:dmQ	I
    //   445: invokespecial 161	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   448: invokevirtual 165	android/view/View:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   451: goto -249 -> 202
    //   454: astore 6
    //   456: goto -54 -> 402
    //   459: astore 6
    //   461: goto -59 -> 402
    //   464: goto -262 -> 202
    //   467: aconst_null
    //   468: astore_2
    //   469: goto -113 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	472	0	this	akhs
    //   0	472	1	paramInt	int
    //   0	472	2	paramView	android.view.View
    //   0	472	3	paramViewGroup	android.view.ViewGroup
    //   5	409	4	i	int
    //   39	190	5	localView	android.view.View
    //   236	155	6	localObject	Object
    //   398	5	6	localException1	java.lang.Exception
    //   454	1	6	localException2	java.lang.Exception
    //   459	1	6	localException3	java.lang.Exception
    //   48	321	7	locala	akhs.a
    //   20	172	8	localInterestTagInfo	InterestTagInfo
    //   373	16	9	localURLImageView	URLImageView
    // Exception table:
    //   from	to	target	type
    //   233	299	398	java/lang/Exception
    //   299	338	454	java/lang/Exception
    //   338	356	454	java/lang/Exception
    //   356	368	459	java/lang/Exception
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void setData(List<InterestTagInfo> paramList)
  {
    this.DQ.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.DQ.addAll(paramList);
    }
    if ((this.DQ.size() > 0) && (this.dmS > 0))
    {
      this.DQ.add(0, null);
      this.DQ.add(null);
    }
    notifyDataSetChanged();
  }
  
  static class a
  {
    URLImageView aw;
    TextView title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akhs
 * JD-Core Version:    0.7.0.1
 */