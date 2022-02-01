package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.widget.BorderTextView;
import java.util.List;
import kwz;
import lie;
import lwk;
import lwm.a;
import mas;
import mba;
import mhr;
import mhr.a;
import mhr.b;
import mhr.c;
import wja;

public class ComponentContentHotQuestion
  extends RelativeLayout
  implements lwk
{
  BorderTextView a;
  public mas a;
  View.OnClickListener listener = new mba(this);
  public Context mContext;
  TextView mTitle;
  TextView qk;
  KandianUrlImageView v;
  
  public ComponentContentHotQuestion(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentContentHotQuestion(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.jdField_a_of_type_Mas = new mas();
    this.mContext = paramContext;
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    aNf();
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.jdField_a_of_type_Mas.setModel(paramObject);
      paramObject = paramObject.a();
      mhr.a locala = (mhr.a)paramObject.mNewPolymericInfo.iP.get(0);
      kwz.a(this.v, paramObject.mSinglePicture, getContext());
      if (!TextUtils.isEmpty(locala.articleTitle))
      {
        this.mTitle.setVisibility(0);
        this.mTitle.setText(locala.articleTitle);
      }
      if ((locala.jdField_a_of_type_Mhr$b != null) && (!TextUtils.isEmpty(locala.jdField_a_of_type_Mhr$b.description)))
      {
        this.mTitle.setVisibility(0);
        this.mTitle.setText(locala.jdField_a_of_type_Mhr$b.description);
      }
      if ((locala.jdField_a_of_type_Mhr$c != null) && (locala.jdField_a_of_type_Mhr$c.joinCount >= 0)) {
        this.qk.setVisibility(0);
      }
      if (TextUtils.isEmpty(locala.buttonWording)) {
        break label181;
      }
      this.jdField_a_of_type_ComTencentWidgetBorderTextView.setText(locala.buttonWording);
    }
    label181:
    while ((paramObject.mNewPolymericInfo.aRX == 12) || (paramObject.mNewPolymericInfo.aRX != 13)) {
      return;
    }
  }
  
  public void a(lwm.a parama)
  {
    this.jdField_a_of_type_Mas.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf()
  {
    ViewGroup.LayoutParams localLayoutParams = this.v.getLayoutParams();
    localLayoutParams.width = wja.dp2px(150.0F, getResources());
    localLayoutParams.height = wja.dp2px(150.0F, getResources());
    this.v.setLayoutParams(localLayoutParams);
    this.v.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void cG(View paramView)
  {
    this.v = ((KandianUrlImageView)paramView.findViewById(2131368896));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView = ((BorderTextView)paramView.findViewById(2131366467));
    this.mTitle = ((TextView)paramView.findViewById(2131379769));
    this.qk = ((TextView)paramView.findViewById(2131372578));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setBorderWidth(2);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setRadius(4.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextColor(Color.parseColor("#12B7F5"));
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setOnClickListener(this.listener);
    this.jdField_a_of_type_ComTencentWidgetBorderTextView.setGravity(17);
    this.mTitle.setVisibility(8);
    this.qk.setVisibility(8);
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560299, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion
 * JD-Core Version:    0.7.0.1
 */