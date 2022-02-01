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
import kwz;
import lwk;
import lwm.a;
import mda;
import mdb;
import mih.b;

public class ComponentTopicItemMulti
  extends RelativeLayout
  implements lwk
{
  KandianUrlImageView L;
  private ArticleInfo b;
  public mih.b b;
  private int mChannelId;
  TextView mDesc;
  TextView mTitle;
  
  public ComponentTopicItemMulti(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentTopicItemMulti(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof mih.b))
    {
      this.jdField_b_of_type_Mih$b = ((mih.b)paramObject);
      aNf();
    }
    try
    {
      paramObject = new URL(this.jdField_b_of_type_Mih$b.picUrl);
      kwz.a(this.L, paramObject, getContext());
      this.mTitle.setText(this.jdField_b_of_type_Mih$b.businessNamePrefix + this.jdField_b_of_type_Mih$b.businessName);
      this.mDesc.setText("");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_Mih$b.businessUrl))
      {
        setOnClickListener(new mda(this));
        return;
      }
    }
    catch (MalformedURLException paramObject)
    {
      for (;;)
      {
        kwz.a(this.L, null, getContext());
        paramObject.printStackTrace();
      }
      setOnClickListener(new mdb(this));
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
    return LayoutInflater.from(paramContext).inflate(2131560330, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void setArticleInfo(ArticleInfo paramArticleInfo, int paramInt)
  {
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
    this.mChannelId = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentTopicItemMulti
 * JD-Core Version:    0.7.0.1
 */