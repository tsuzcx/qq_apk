package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kwz;
import lie;
import lwk;
import lwm.a;
import mas;
import mdc;
import mdd;
import mih;
import mih.b;

public class ComponentTopicItemSingle
  extends RelativeLayout
  implements lwk
{
  KandianUrlImageView L;
  public mas a;
  TextView mDesc;
  TextView mTitle;
  
  public ComponentTopicItemSingle(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentTopicItemSingle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
      aNf();
      paramObject = paramObject.a();
      if ((paramObject != null) && (paramObject.mTopicRecommendFeedsInfo != null) && (paramObject.mTopicRecommendFeedsInfo.ld != null) && (paramObject.mTopicRecommendFeedsInfo.ld.size() != 0)) {}
    }
    else
    {
      return;
    }
    paramObject = (mih.b)paramObject.mTopicRecommendFeedsInfo.ld.get(0);
    try
    {
      URL localURL = new URL(paramObject.picUrl);
      kwz.a(this.L, localURL, getContext());
      this.mTitle.setText(paramObject.businessNamePrefix + paramObject.businessName);
      this.mDesc.setText("");
      if (!TextUtils.isEmpty(paramObject.businessUrl))
      {
        setOnClickListener(new mdc(this, paramObject));
        return;
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        kwz.a(this.L, null, getContext());
        localMalformedURLException.printStackTrace();
      }
      setOnClickListener(new mdd(this));
    }
  }
  
  public void a(lwm.a parama) {}
  
  public void aHq() {}
  
  public void aNf()
  {
    this.L.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void cG(View paramView)
  {
    this.L = ((KandianUrlImageView)findViewById(2131365477));
    this.mTitle = ((TextView)findViewById(2131379769));
    this.mDesc = ((TextView)findViewById(2131365721));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560331, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemSingle
 * JD-Core Version:    0.7.0.1
 */