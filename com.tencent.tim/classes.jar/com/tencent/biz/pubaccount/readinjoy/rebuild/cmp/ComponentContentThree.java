package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import kwz;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import mde;
import ndi;
import org.json.JSONArray;
import org.json.JSONObject;
import wja;

public class ComponentContentThree
  extends FrameLayout
  implements lwk
{
  KandianUrlImageView F;
  KandianUrlImageView G;
  KandianUrlImageView H;
  mas a;
  LinearLayout dS;
  List<KandianUrlImageView> mImageViewList;
  
  public ComponentContentThree(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentContentThree(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
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
  
  public void aHq() {}
  
  public void aNf()
  {
    mde.a(getContext(), this.F, true);
    mde.a(getContext(), this.G, true);
    mde.a(getContext(), this.H, true);
    ((LinearLayout.LayoutParams)this.F.getLayoutParams()).setMargins(0, 0, wja.dp2px(1.5F, getResources()), 0);
    ((LinearLayout.LayoutParams)this.G.getLayoutParams()).setMargins(0, 0, wja.dp2px(1.5F, getResources()), 0);
  }
  
  public void cG(View paramView)
  {
    this.dS = ((LinearLayout)paramView.findViewById(2131376733));
    this.F = ((KandianUrlImageView)paramView.findViewById(2131370343));
    this.G = ((KandianUrlImageView)paramView.findViewById(2131364377));
    this.H = ((KandianUrlImageView)paramView.findViewById(2131377270));
    this.mImageViewList = Arrays.asList(new KandianUrlImageView[] { this.F, this.G, this.H });
    aNf();
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560309, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void setContent(lie paramlie)
  {
    Object localObject2 = paramlie.a();
    if (localObject2 == null) {}
    Object localObject3;
    do
    {
      return;
      if ((((ArticleInfo)localObject2).mPictures != null) && (((ArticleInfo)localObject2).mPictures.length > 0)) {
        break;
      }
      localObject3 = ndi.a(((ArticleInfo)localObject2).mJsonPictureList, "pictures");
    } while ((localObject3 == null) || (((JSONArray)localObject3).length() <= 0));
    paramlie = ((JSONArray)localObject3).optJSONObject(0);
    Object localObject1;
    if (paramlie == null)
    {
      paramlie = ((ArticleInfo)localObject2).mFirstPagePicUrl;
      localObject1 = ((JSONArray)localObject3).optJSONObject(1);
      if (localObject1 != null) {
        break label151;
      }
      localObject1 = ((ArticleInfo)localObject2).mFirstPagePicUrl;
      label83:
      localObject3 = ((JSONArray)localObject3).optJSONObject(2);
      if (localObject3 != null) {
        break label161;
      }
    }
    label151:
    label161:
    for (localObject2 = ((ArticleInfo)localObject2).mFirstPagePicUrl;; localObject2 = ((JSONObject)localObject3).optString("picture"))
    {
      kwz.a(this.mImageViewList, Arrays.asList(new URL[] { kxm.b(paramlie), kxm.b((String)localObject1), kxm.b((String)localObject2) }), getContext());
      return;
      paramlie = paramlie.optString("picture");
      break;
      localObject1 = ((JSONObject)localObject1).optString("picture");
      break label83;
    }
    if ((((ArticleInfo)localObject2).mPictures.length < 1) || (localObject2.mPictures[0] == null))
    {
      paramlie = ((ArticleInfo)localObject2).mSinglePicture;
      if ((((ArticleInfo)localObject2).mPictures.length >= 2) && (localObject2.mPictures[1] != null)) {
        break label282;
      }
      localObject1 = ((ArticleInfo)localObject2).mSinglePicture;
      label218:
      if ((((ArticleInfo)localObject2).mPictures.length >= 3) && (localObject2.mPictures[2] != null)) {
        break label292;
      }
    }
    label282:
    label292:
    for (localObject2 = ((ArticleInfo)localObject2).mSinglePicture;; localObject2 = localObject2.mPictures[2])
    {
      kwz.a(this.mImageViewList, Arrays.asList(new URL[] { paramlie, localObject1, localObject2 }), getContext());
      return;
      paramlie = localObject2.mPictures[0];
      break;
      localObject1 = localObject2.mPictures[1];
      break label218;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentThree
 * JD-Core Version:    0.7.0.1
 */