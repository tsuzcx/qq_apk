package com.tencent.mobileqq.hiboom;

import afhe;
import afnm;
import afoa;
import afos;
import ahyb;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqmr;
import aqnm;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private afhe jdField_a_of_type_Afhe;
  private ahyb jdField_a_of_type_Ahyb;
  private afoa b;
  private EmotionPanelListView d;
  private BaseChatPie mBaseChatPie;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, ahyb paramahyb)
  {
    super(paramContext);
    this.mBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Ahyb = paramahyb;
    this.jdField_a_of_type_Afhe = new afhe(this.mBaseChatPie.app, paramContext, paramahyb);
    init();
  }
  
  private void init()
  {
    this.d = new EmotionPanelListView(getContext());
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    View localView = View.inflate(getContext(), 2131558648, null);
    localRelativeLayout.addView(localView, localLayoutParams);
    this.b = new afoa(this.mBaseChatPie.app, getContext(), 4, 14, 12, this.mBaseChatPie, this.mBaseChatPie);
    this.d.setDivider(null);
    this.d.setEdgeEffectEnabled(false);
    this.d.setSelector(2130851773);
    this.b.widthPixels = aqnm.getScreenWidth();
    this.b.a(this.d);
    this.jdField_a_of_type_Afhe.a(this.d, this.b);
    this.jdField_a_of_type_Afhe.setEmptyView(localView);
    this.d.setAdapter(this.b);
    this.d.setEnableExtendPanle(true);
    this.d.setPullAndFastScrollListener(this.jdField_a_of_type_Ahyb);
    this.d.setOnScrollListener(new afnm(this.d, this.jdField_a_of_type_Ahyb, null));
    this.d.addOnScrollListener(this.jdField_a_of_type_Afhe);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.mBaseChatPie.a != null) && (this.mBaseChatPie.a.getText() != null)) {
      this.jdField_a_of_type_Afhe.Id(this.mBaseChatPie.a.getText().toString());
    }
  }
  
  public String getName()
  {
    return getContext().getString(2131690142);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    afos.a().destory();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    if ((this.b != null) && (this.b.widthPixels != paramInt1))
    {
      this.b.widthPixels = paramInt1;
      this.d.setAdapter(this.b);
    }
  }
  
  public void onShow()
  {
    String str2;
    if ((this.mBaseChatPie.a != null) && (this.mBaseChatPie.a.getText() != null))
    {
      String str1 = this.jdField_a_of_type_Afhe.ut();
      str2 = this.mBaseChatPie.a.getText().toString();
      if ((aqmr.isEmpty(str1)) || (!str1.equals(str2))) {}
    }
    else
    {
      return;
    }
    this.b.setData(new ArrayList());
    this.jdField_a_of_type_Afhe.HT(str2);
    this.jdField_a_of_type_Afhe.onShow();
  }
  
  public void yQ(boolean paramBoolean)
  {
    this.jdField_a_of_type_Afhe.yQ(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */