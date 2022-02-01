package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqiz;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNickNameTextView;
import com.tencent.qphone.base.util.QLog;
import kvl;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import org.json.JSONException;
import org.json.JSONObject;
import wja;

public class ComponentInfo
  extends LinearLayout
  implements lwl
{
  public ComponentNotIntrest a;
  mas a;
  View kN;
  View kO;
  ReadInJoyNickNameTextView l;
  TextView ox;
  TextView qF;
  TextView qG;
  
  public ComponentInfo(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  @TargetApi(11)
  public ComponentInfo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  public ComponentInfo(Context paramContext, Object paramObject)
  {
    super(paramContext);
    b(paramContext, paramObject);
  }
  
  private void Ib()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    if (localArticleInfo == null) {
      return;
    }
    if (!TextUtils.isEmpty(localArticleInfo.mArticleSubscriptText))
    {
      if (AdvertisementInfo.isAdvertisementInfo(localArticleInfo))
      {
        switch (this.jdField_a_of_type_Mas.oP())
        {
        }
        for (;;)
        {
          this.qF.setTypeface(null, 0);
          this.qF.setText(localArticleInfo.mArticleSubscriptText);
          this.qF.setVisibility(0);
          return;
        }
      }
      if (TextUtils.isEmpty(localArticleInfo.mArticleSubscriptColor)) {}
      for (;;)
      {
        this.qF.setTypeface(null, 1);
        break;
        String str = localArticleInfo.mArticleSubscriptColor;
      }
    }
    this.qF.setVisibility(8);
  }
  
  public static ShapeDrawable a(int paramInt, Resources paramResources)
  {
    float f9 = wja.dp2px(1.0F, paramResources);
    float f1 = 6;
    float f2 = 6;
    float f3 = 6;
    float f4 = 6;
    float f5 = 6;
    float f6 = 6;
    float f7 = 6;
    float f8 = 6;
    paramResources = new RectF(f9, f9, f9, f9);
    f9 = 5;
    float f10 = 5;
    float f11 = 5;
    float f12 = 5;
    float f13 = 5;
    float f14 = 5;
    float f15 = 5;
    float f16 = 5;
    paramResources = new ShapeDrawable(new RoundRectShape(new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, paramResources, new float[] { f9, f10, f11, f12, f13, f14, f15, f16 }));
    LinearGradient localLinearGradient = new LinearGradient(50.0F, 50.0F, 50.0F, 50.0F, paramInt, paramInt, Shader.TileMode.REPEAT);
    paramResources.getPaint().setShader(localLinearGradient);
    return paramResources;
  }
  
  private void aFk()
  {
    Object localObject1 = this.jdField_a_of_type_Mas.a.a();
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_Mas.Dh()) || (((localObject1 instanceof AdvertisementInfo)) && (!TextUtils.isEmpty(((AdvertisementInfo)localObject1).mAdBtnTxt))))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.kR.setPadding(wja.dp2px(9.75F, getResources()), wja.dp2px(3.75F, getResources()), wja.dp2px(9.75F, getResources()), wja.dp2px(8.25F, getResources()));
      localObject2 = (AdvertisementInfo)localObject1;
      i = this.jdField_a_of_type_Mas.oP();
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(((AdvertisementInfo)localObject2).mAdExt);
        if (TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdBtnTxt)) {
          continue;
        }
        localObject2 = ((AdvertisementInfo)localObject2).mAdBtnTxt;
        m = -15550475;
        int n = wja.dp2px(2.0F, getResources());
        localObject2 = (LinearLayout.LayoutParams)this.ox.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(9.5F, getResources());
        ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(5.0F, getResources());
        switch (i)
        {
        case 1: 
          kvl.setBackground(this.ox, null);
          this.kN.setVisibility(0);
          this.kO.setVisibility(8);
          j = 0;
          f = 14.0F;
          localObject1 = null;
          i = 0;
          k = 0;
          this.ox.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, null, null);
          this.ox.setCompoundDrawablePadding(n);
          this.ox.setTextColor(m);
          this.ox.setTextSize(f);
          this.ox.setTypeface(null, 0);
          this.ox.setPadding(k, j, k, i);
          this.ox.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      catch (JSONException localJSONException)
      {
        int m;
        int j;
        float f;
        int k;
        continue;
      }
      this.ox.setVisibility(0);
      return;
      if (aqiz.isAppInstalled(getContext(), ((JSONObject)localObject1).optString("pkg_name")))
      {
        continue;
        if (aqiz.isAppInstalled(getContext(), ((JSONObject)localObject1).optString("pkg_name")))
        {
          localObject1 = getResources().getDrawable(2130843556);
          f = 11.0F;
          k = wja.dp2px(3.0F, getResources());
          j = wja.dp2px(1.7F, getResources());
          i = wja.dp2px(1.8F, getResources());
          kvl.setBackground(this.ox, a(-15550475, getResources()));
          this.kN.setVisibility(8);
          this.kO.setVisibility(0);
          ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(8.0F, getResources());
        }
        else
        {
          localObject1 = getResources().getDrawable(2130843555);
          continue;
          if (aqiz.isAppInstalled(getContext(), ((JSONObject)localObject1).optString("pkg_name")))
          {
            localObject1 = getResources().getDrawable(2130843556);
            f = 11.0F;
            k = wja.dp2px(3.0F, getResources());
            j = wja.dp2px(1.7F, getResources());
            i = wja.dp2px(1.8F, getResources());
            ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(3.5F, getResources());
            kvl.setBackground(this.ox, a(-15550475, getResources()));
            this.kN.setVisibility(0);
            this.kO.setVisibility(8);
          }
          else
          {
            localObject1 = getResources().getDrawable(2130843555);
            continue;
            kvl.setBackground(this.ox, null);
            this.kN.setVisibility(8);
            this.kO.setVisibility(0);
            f = 12.0F;
            m = -6447715;
            localObject1 = null;
            i = 0;
            j = 0;
            k = 0;
            continue;
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.kR.setPadding(wja.dp2px(9.75F, getResources()), wja.dp2px(8.25F, getResources()), wja.dp2px(9.75F, getResources()), wja.dp2px(8.25F, getResources()));
            this.ox.setVisibility(8);
            this.kN.setVisibility(0);
            this.kO.setVisibility(8);
            return;
          }
        }
      }
    }
  }
  
  private void aOq()
  {
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Mas.a.a();
    if ((AdvertisementInfo.isAdvertisementInfo(localArticleInfo)) && (this.jdField_a_of_type_Mas.oP() == 1)) {
      this.l.setVisibility(8);
    }
    do
    {
      return;
      String str = localArticleInfo.getSubscribeName();
      if (localArticleInfo.mSubscribeName.length() > 18) {
        str = localArticleInfo.mSubscribeName.substring(0, 17) + "…";
      }
      this.l.setVisibility(0);
      this.l.setText(str);
    } while (!kxm.F(this.jdField_a_of_type_Mas.a.a()));
    this.l.setNickNameByUin(this.jdField_a_of_type_Mas.cG());
  }
  
  private void aOr()
  {
    this.qG.setVisibility(8);
  }
  
  private void b(Context paramContext, Object paramObject)
  {
    bY(paramContext);
    if ((paramObject instanceof lie))
    {
      this.jdField_a_of_type_Mas.setModel((lie)paramObject);
      aNf();
    }
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.jdField_a_of_type_Mas.setModel((lie)paramObject);
      if (this.jdField_a_of_type_Mas.a.Cw())
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(8);
        if (((lie)paramObject).a() != null) {
          break label127;
        }
        QLog.e("ComponentInfo", 1, "bindData getArticleInfo null");
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.P(paramObject);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
    if (this.jdField_a_of_type_Mas.Dh()) {}
    for (localLayoutParams.gravity = 0;; localLayoutParams.gravity = 80)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams(localLayoutParams);
      break;
    }
    label127:
    Ib();
    aOq();
    aFk();
    aOr();
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.a(parama);
    }
  }
  
  public void aHq() {}
  
  public void aNf()
  {
    if (this.jdField_a_of_type_Mas.De())
    {
      if (this.jdField_a_of_type_Mas.CV())
      {
        this.qF.setVisibility(8);
        this.l.setVisibility(8);
        this.ox.setVisibility(8);
        localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = wja.dp2px(7.0F, getResources());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      localObject = (LinearLayout.LayoutParams)this.qF.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = wja.dp2px(0.0F, getResources());
      this.qF.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(18.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(11.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = wja.dp2px(0.0F, getResources());
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ox.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = wja.dp2px(2.25F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if ((this.jdField_a_of_type_Mas.CW()) || (this.jdField_a_of_type_Mas.CX()))
    {
      this.qF.setVisibility(8);
      this.l.setVisibility(0);
      this.ox.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(13.0F, getResources());
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_Mas.CY())
    {
      this.qF.setVisibility(8);
      this.l.setVisibility(0);
      this.ox.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.l.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(0.0F, getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(13.0F, getResources());
      this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    if (this.jdField_a_of_type_Mas.CV())
    {
      this.qF.setVisibility(8);
      this.l.setVisibility(8);
      this.ox.setVisibility(8);
      localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin = wja.dp2px(7.0F, getResources());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    Object localObject = (LinearLayout.LayoutParams)this.qF.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(26.0F, getResources());
    this.qF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)this.l.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).bottomMargin = wja.dp2px(26.0F, getResources());
    ((LinearLayout.LayoutParams)localObject).leftMargin = wja.dp2px(11.0F, getResources());
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = wja.dp2px(2.25F, getResources());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560323, this, true);
    this.qF = ((TextView)paramContext.findViewById(2131378995));
    this.l = ((ReadInJoyNickNameTextView)paramContext.findViewById(2131372190));
    this.ox = ((TextView)paramContext.findViewById(2131362826));
    this.qG = ((TextView)paramContext.findViewById(2131377159));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentNotIntrest = ((ComponentNotIntrest)paramContext.findViewById(2131372477));
    this.kN = paramContext.findViewById(2131372814);
    this.kO = paramContext.findViewById(2131372815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentInfo
 * JD-Core Version:    0.7.0.1
 */