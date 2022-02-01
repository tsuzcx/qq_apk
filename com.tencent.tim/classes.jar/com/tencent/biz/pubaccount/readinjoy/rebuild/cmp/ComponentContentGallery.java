package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
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
import aqcx;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.common.app.BaseApplicationImpl;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kwz;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import maw;
import mde;
import ndi;
import org.json.JSONArray;
import org.json.JSONObject;
import wja;

public class ComponentContentGallery
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
  private ndi b;
  private float jr = 1.5F;
  private Context mContext;
  private List<KandianUrlImageView> mImageViewList;
  private int mPosition;
  private LinearLayout mRootView;
  private KandianUrlImageView w;
  private KandianUrlImageView x;
  private KandianUrlImageView y;
  private KandianUrlImageView z;
  
  public ComponentContentGallery(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
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
  
  private void a(List<KandianUrlImageView> paramList, ArticleInfo paramArticleInfo, int[] paramArrayOfInt, String paramString)
  {
    if ((paramList == null) || (paramArrayOfInt == null) || (paramList.size() != paramArrayOfInt.length)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        ((KandianUrlImageView)paramList.get(i)).setOnClickListener(new maw(this, paramArticleInfo, paramArrayOfInt[i], paramString, i));
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
    int i = localResources.getDisplayMetrics().widthPixels;
    int j;
    if (this.alQ)
    {
      i = (i - wja.dp2px(this.jr * 2.0F, localResources) - wja.dp2px(22.0F, localResources)) / 3;
      j = i;
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(j), Integer.valueOf(i));
      j = (i - wja.dp2px(this.jr * 2.0F, localResources)) / 3;
      i = localResources.getDimensionPixelSize(2131299185);
    }
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
  
  public int a(JSONArray paramJSONArray, int paramInt)
  {
    if ((paramInt == 5) && (paramJSONArray.length() < 9)) {
      paramInt = 4;
    }
    for (;;)
    {
      if ((paramInt == 4) && (paramJSONArray.length() < 3)) {
        return 3;
      }
      return paramInt;
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
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
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
    Object localObject2 = paramlie.a();
    if (localObject2 == null) {}
    Object localObject1;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    label489:
    label623:
    do
    {
      do
      {
        return;
        localObject1 = ((ArticleInfo)localObject2).innerUniqueID;
        localObject5 = new LinearLayout.LayoutParams(-2, -2);
        localObject4 = ndi.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
      } while ((localObject4 == null) || (((JSONArray)localObject4).length() <= 0));
      i = a((JSONArray)localObject4, ((ArticleInfo)localObject2).articleStyle);
      localObject3 = new int[((JSONArray)localObject4).length()];
      if ((i == 5) || (i == 4)) {}
      for (boolean bool = true;; bool = false)
      {
        this.alQ = bool;
        if (this.alQ) {
          this.jr = 3.0F;
        }
        if (i != 3) {
          break;
        }
        paramlie = new LinearLayout(getContext());
        paramlie.setOrientation(0);
        paramlie.setLayoutParams((ViewGroup.LayoutParams)localObject5);
        localObject1 = LayoutInflater.from(getContext()).inflate(2131560297, null);
        localObject3 = (TextView)((View)localObject1).findViewById(2131380841);
        this.w = ((KandianUrlImageView)((View)localObject1).findViewById(2131368820));
        mde.a(getContext(), this.w);
        paramlie.addView((View)localObject1);
        kwz.a(this.w, ((ArticleInfo)localObject2).mSinglePicture, getContext());
        this.mRootView.addView(paramlie);
        return;
      }
      if (i == 4)
      {
        localObject3 = new LinearLayout(getContext());
        ((LinearLayout)localObject3).setOrientation(0);
        ((LinearLayout)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        paramlie = LayoutInflater.from(getContext()).inflate(2131560297, null);
        localObject1 = (TextView)paramlie.findViewById(2131380841);
        this.w = new KandianUrlImageView(getContext());
        this.x = new KandianUrlImageView(getContext());
        this.y = ((KandianUrlImageView)paramlie.findViewById(2131368820));
        ((LinearLayout)localObject3).addView(this.w);
        ((LinearLayout)localObject3).addView(this.x);
        ((LinearLayout)localObject3).addView(paramlie);
        a(new KandianUrlImageView[] { this.w, this.x });
        b(new KandianUrlImageView[] { this.y });
        this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.w, this.x, this.y });
        if ((((ArticleInfo)localObject2).mPictures == null) || (((ArticleInfo)localObject2).mPictures.length <= 0))
        {
          paramlie = ((JSONArray)localObject4).optJSONObject(0);
          if (paramlie == null)
          {
            paramlie = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject1 = ((JSONArray)localObject4).optJSONObject(1);
            if (localObject1 != null) {
              break label571;
            }
            localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
            localObject4 = ((JSONArray)localObject4).optJSONObject(2);
            if (localObject4 != null) {
              break label584;
            }
          }
          for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject4).optString("picture"))
          {
            kwz.a(this.mImageViewList, Arrays.asList(new URL[] { kxm.b(paramlie), kxm.b((String)localObject1), kxm.b((String)localObject2) }), getContext());
            this.mRootView.addView((View)localObject3);
            return;
            paramlie = paramlie.optString("picture");
            break;
            localObject1 = ((JSONObject)localObject1).optString("picture");
            break label489;
          }
        }
        if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
        {
          paramlie = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
            break label723;
          }
          localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
          if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
            break label735;
          }
        }
        for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
        {
          kwz.a(this.mImageViewList, Arrays.asList(new URL[] { paramlie, localObject1, localObject2 }), getContext());
          break;
          paramlie = localObject2.mPictures[0];
          break label623;
          localObject1 = localObject2.mPictures[1];
          break label650;
        }
      }
    } while (i != 5);
    label571:
    label584:
    label723:
    label735:
    ArrayList localArrayList = new ArrayList();
    label650:
    Object localObject6 = d();
    int i = 0;
    Object localObject7;
    label794:
    int j;
    if (i < 9)
    {
      localObject7 = ((JSONArray)localObject4).optJSONObject(i);
      if (localObject7 == null)
      {
        paramlie = ((ArticleInfo)localObject2).mFirstPagePicUrl;
        if (localObject7 != null) {
          break label872;
        }
        j = 0;
        label801:
        localObject3[i] = j;
        if (!kxm.dA(paramlie)) {
          break label1476;
        }
        paramlie = kxm.a(paramlie, ((Integer)((Pair)localObject6).second).intValue(), ((Integer)((Pair)localObject6).first).intValue(), 1);
      }
    }
    label1476:
    for (;;)
    {
      localArrayList.add(kxm.b(paramlie));
      i += 1;
      break;
      paramlie = ((JSONObject)localObject7).optString("picture");
      break label794;
      label872:
      j = ((JSONObject)localObject7).optInt("galleryIndex");
      break label801;
      paramlie = new LinearLayout(getContext());
      localObject4 = new LinearLayout(getContext());
      localObject6 = new LinearLayout(getContext());
      ((LinearLayout.LayoutParams)localObject5).setMargins(aqcx.dip2px(getContext(), 11.0F), 0, aqcx.dip2px(getContext(), 11.0F), 0);
      paramlie.setOrientation(0);
      paramlie.setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((LinearLayout)localObject4).setOrientation(0);
      ((LinearLayout)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((LinearLayout)localObject6).setOrientation(0);
      ((LinearLayout)localObject6).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((LinearLayout)localObject4).setPadding(0, wja.dp2px(this.jr, getResources()), 0, 0);
      ((LinearLayout)localObject6).setPadding(0, wja.dp2px(this.jr, getResources()), 0, 0);
      this.w = new KandianUrlImageView(getContext());
      this.x = new KandianUrlImageView(getContext());
      this.y = new KandianUrlImageView(getContext());
      paramlie.addView(this.w);
      paramlie.addView(this.x);
      paramlie.addView(this.y);
      this.z = new KandianUrlImageView(getContext());
      this.A = new KandianUrlImageView(getContext());
      this.B = new KandianUrlImageView(getContext());
      ((LinearLayout)localObject4).addView(this.z);
      ((LinearLayout)localObject4).addView(this.A);
      ((LinearLayout)localObject4).addView(this.B);
      localObject5 = LayoutInflater.from(getContext()).inflate(2131560297, null);
      localObject7 = (TextView)((View)localObject5).findViewById(2131380841);
      this.C = new KandianUrlImageView(getContext());
      this.D = new KandianUrlImageView(getContext());
      this.E = ((KandianUrlImageView)((View)localObject5).findViewById(2131368820));
      ((LinearLayout)localObject6).addView(this.C);
      ((LinearLayout)localObject6).addView(this.D);
      ((LinearLayout)localObject6).addView((View)localObject5);
      a(new KandianUrlImageView[] { this.w, this.x, this.z, this.A, this.C, this.D });
      b(new KandianUrlImageView[] { this.y, this.B, this.E });
      this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E });
      kwz.a(this.mImageViewList, localArrayList, getContext());
      a(this.mImageViewList, (ArticleInfo)localObject2, (int[])localObject3, (String)localObject1);
      this.mRootView.addView(paramlie);
      this.mRootView.addView((View)localObject4);
      this.mRootView.addView((View)localObject6);
      return;
    }
  }
  
  public void setPosition(int paramInt)
  {
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGallery
 * JD-Core Version:    0.7.0.1
 */