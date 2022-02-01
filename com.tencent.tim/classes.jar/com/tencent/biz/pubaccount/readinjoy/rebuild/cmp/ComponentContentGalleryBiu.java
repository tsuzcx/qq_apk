package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.f;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.m;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.n;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kvp;
import kwz;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import max;
import may;
import mde;
import ndi;
import ndi.a;
import wja;

public class ComponentContentGalleryBiu
  extends FrameLayout
  implements lwk
{
  private KandianUrlImageView A;
  private KandianUrlImageView B;
  private KandianUrlImageView C;
  private KandianUrlImageView D;
  private KandianUrlImageView E;
  private mas a;
  private boolean alQ;
  private boolean alR;
  private ndi b;
  private float jr = 3.0F;
  private Context mContext;
  private List<KandianUrlImageView> mImageViewList;
  private int mPosition;
  private LinearLayout mRootView;
  private KandianUrlImageView w;
  private KandianUrlImageView x;
  private KandianUrlImageView y;
  private KandianUrlImageView z;
  
  public ComponentContentGalleryBiu(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentGalleryBiu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  private void A(ArticleInfo paramArticleInfo)
  {
    if ((this.b == null) || (paramArticleInfo == null)) {}
    ndi.a locala;
    do
    {
      return;
      locala = this.b.a();
    } while (locala == null);
    locala.a(getContext(), paramArticleInfo, 0, paramArticleInfo.innerUniqueID, 5, this.mPosition, 0);
  }
  
  private int P(int paramInt1, int paramInt2)
  {
    int j = 9;
    int i = paramInt2;
    if (paramInt2 == 9)
    {
      paramInt2 = j;
      if (paramInt1 < 9) {
        i = 3;
      }
    }
    else
    {
      if ((i != 3) || (paramInt1 < 3)) {
        break label37;
      }
      paramInt2 = 3;
    }
    return paramInt2;
    label37:
    return 1;
  }
  
  public static int a(ArticleInfo paramArticleInfo, ndi paramndi)
  {
    return kvp.M(paramndi.nh(), kxm.a(paramArticleInfo));
  }
  
  private void a(KandianUrlImageView paramKandianUrlImageView)
  {
    Object localObject = d();
    int i = ((Integer)((Pair)localObject).first).intValue();
    int j = ((Integer)((Pair)localObject).second).intValue();
    ViewGroup.LayoutParams localLayoutParams = paramKandianUrlImageView.getLayoutParams();
    localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new LinearLayout.LayoutParams(i, j);
    }
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = j;
    paramKandianUrlImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramKandianUrlImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  private void a(List<KandianUrlImageView> paramList, ArticleInfo paramArticleInfo, long[] paramArrayOfLong, String paramString)
  {
    if ((paramList == null) || (paramArrayOfLong == null) || (paramList.size() != paramArrayOfLong.length)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(i)).setOnClickListener(new may(this, paramArticleInfo, paramArrayOfLong[i], paramString, i));
        i += 1;
      }
    }
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    this.mContext = paramContext;
    init(paramContext);
    aHq();
  }
  
  private Pair<Integer, Integer> d()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int j = (localResources.getDisplayMetrics().widthPixels - wja.dp2px(this.jr * 2.0F, localResources) - wja.dp2px(22.0F, localResources)) / 3;
    int i = localResources.getDimensionPixelSize(2131299185);
    if (this.alQ) {
      i = j;
    }
    return new Pair(Integer.valueOf(j), Integer.valueOf(i));
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.a.setModel(paramObject);
      setContent(paramObject);
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void a(KandianUrlImageView... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      KandianUrlImageView localKandianUrlImageView = paramVarArgs[i];
      if (localKandianUrlImageView != null)
      {
        a(localKandianUrlImageView);
        ((LinearLayout.LayoutParams)localKandianUrlImageView.getLayoutParams()).setMargins(0, 0, wja.dp2px(this.jr, getResources()), 0);
      }
      i += 1;
    }
  }
  
  public void aHq() {}
  
  public void b(KandianUrlImageView... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      a(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public void cG(View paramView)
  {
    this.mRootView = ((LinearLayout)paramView);
  }
  
  public View f(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    addView(paramContext);
    return paramContext;
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void setAdapter(ndi paramndi)
  {
    this.b = paramndi;
  }
  
  public void setContent(lie paramlie)
  {
    this.mRootView.removeAllViews();
    Object localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ArticleInfo localArticleInfo = paramlie.a();
    if ((localArticleInfo == null) || (localArticleInfo.mSocialFeedInfo == null) || (localArticleInfo.mSocialFeedInfo.a == null) || (localArticleInfo.mSocialFeedInfo.a.a == null)) {}
    String str;
    Object localObject2;
    Object localObject3;
    int i;
    do
    {
      do
      {
        return;
        if (this.alR)
        {
          paramlie = new TextView(getContext());
          paramlie.setPadding(0, 0, 0, wja.dp2px(11.0F, getContext().getResources()));
          paramlie.setMaxLines(2);
          paramlie.setEllipsize(TextUtils.TruncateAt.END);
          paramlie.setTextColor(Color.parseColor("#000000"));
          paramlie.setTextSize(1, 17.0F);
          paramlie.setIncludeFontPadding(false);
          paramlie.setText(localArticleInfo.mTitle);
          paramlie.setOnClickListener(new max(this, localArticleInfo));
          this.mRootView.addView(paramlie);
        }
        str = localArticleInfo.innerUniqueID;
        paramlie = localArticleInfo.mSocialFeedInfo.a;
        localObject2 = localArticleInfo.mSocialFeedInfo.a.a;
        localObject3 = paramlie.kY;
      } while ((localObject3 == null) || (((ArrayList)localObject3).size() == 0));
      i = ((ArrayList)localObject3).size();
    } while (i <= 0);
    int j = P(i, localArticleInfo.mSocialFeedInfo.aSG);
    long[] arrayOfLong = new long[j];
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    Object localObject4;
    if ((j == 9) || (j == 3))
    {
      bool = true;
      this.alQ = bool;
      localObject4 = d();
      i = 0;
      label286:
      if (i >= j) {
        break label374;
      }
      paramlie = (SocializeFeedsInfo.n)((ArrayList)localObject3).get(i);
      arrayOfLong[i] = paramlie.vP;
      paramlie = paramlie.pic_url;
      if (!kxm.dA(paramlie)) {
        break label1239;
      }
      paramlie = kxm.a(paramlie, ((Integer)((Pair)localObject4).second).intValue(), ((Integer)((Pair)localObject4).first).intValue(), 1);
    }
    label1239:
    for (;;)
    {
      localArrayList.add(kxm.b(paramlie));
      i += 1;
      break label286;
      bool = false;
      break;
      label374:
      long l = ((SocializeFeedsInfo.f)localObject2).vN;
      if ((j == 1) || (j == 3))
      {
        paramlie = new LinearLayout(getContext());
        paramlie.setOrientation(0);
        paramlie.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131560297, null);
        localObject2 = (TextView)((View)localObject1).findViewById(2131380841);
        if (j == 1)
        {
          paramlie.addView((View)localObject1);
          this.w = ((KandianUrlImageView)((View)localObject1).findViewById(2131368820));
          this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.w });
          mde.a(getContext(), this.w);
          kwz.a(this.w, localArticleInfo.mSinglePicture, getContext());
          this.mRootView.addView(paramlie);
        }
      }
      for (;;)
      {
        a(this.mImageViewList, localArticleInfo, arrayOfLong, str);
        return;
        this.w = new KandianUrlImageView(getContext());
        this.x = new KandianUrlImageView(getContext());
        this.y = ((KandianUrlImageView)((View)localObject1).findViewById(2131368820));
        paramlie.addView(this.w);
        paramlie.addView(this.x);
        paramlie.addView((View)localObject1);
        a(new KandianUrlImageView[] { this.w, this.x });
        b(new KandianUrlImageView[] { this.y });
        this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.w, this.x, this.y });
        kwz.a(this.mImageViewList, localArrayList, getContext());
        this.mRootView.addView(paramlie);
        continue;
        if (j == 9)
        {
          paramlie = new LinearLayout(getContext());
          localObject2 = new LinearLayout(getContext());
          localObject3 = new LinearLayout(getContext());
          paramlie.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((LinearLayout)localObject2).setPadding(0, wja.dp2px(this.jr, getResources()), 0, 0);
          ((LinearLayout)localObject3).setPadding(0, wja.dp2px(this.jr, getResources()), 0, 0);
          this.w = new KandianUrlImageView(getContext());
          this.x = new KandianUrlImageView(getContext());
          this.y = new KandianUrlImageView(getContext());
          paramlie.addView(this.w);
          paramlie.addView(this.x);
          paramlie.addView(this.y);
          this.z = new KandianUrlImageView(getContext());
          this.A = new KandianUrlImageView(getContext());
          this.B = new KandianUrlImageView(getContext());
          ((LinearLayout)localObject2).addView(this.z);
          ((LinearLayout)localObject2).addView(this.A);
          ((LinearLayout)localObject2).addView(this.B);
          localObject1 = LayoutInflater.from(getContext()).inflate(2131560297, null);
          localObject4 = (TextView)((View)localObject1).findViewById(2131380841);
          this.C = new KandianUrlImageView(getContext());
          this.D = new KandianUrlImageView(getContext());
          this.E = ((KandianUrlImageView)((View)localObject1).findViewById(2131368820));
          ((LinearLayout)localObject3).addView(this.C);
          ((LinearLayout)localObject3).addView(this.D);
          ((LinearLayout)localObject3).addView((View)localObject1);
          a(new KandianUrlImageView[] { this.w, this.x, this.z, this.A, this.C, this.D });
          b(new KandianUrlImageView[] { this.y, this.B, this.E });
          this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E });
          kwz.a(this.mImageViewList, localArrayList, getContext());
          this.mRootView.addView(paramlie);
          this.mRootView.addView((View)localObject2);
          this.mRootView.addView((View)localObject3);
        }
      }
    }
  }
  
  public void setIsNeedAddTitle(boolean paramBoolean)
  {
    this.alR = paramBoolean;
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGalleryBiu
 * JD-Core Version:    0.7.0.1
 */