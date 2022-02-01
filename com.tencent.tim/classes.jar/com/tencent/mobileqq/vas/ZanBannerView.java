package com.tencent.mobileqq.vas;

import alem.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;

public class ZanBannerView
  extends FrameLayout
{
  private static String cwH = "spKeyZanBannerIndex";
  private List<alem.a> Jc;
  private alem.a jdField_a_of_type_Alem$a;
  private a jdField_a_of_type_ComTencentMobileqqVasZanBannerView$a;
  private int curIndex = -1;
  private RelativeLayout mw;
  
  public ZanBannerView(Context paramContext)
  {
    super(paramContext);
    fE(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    fE(paramContext);
  }
  
  public ZanBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    fE(paramContext);
  }
  
  private alem.a a()
  {
    if (aFz()) {
      return null;
    }
    List localList = this.Jc;
    int i = this.curIndex;
    this.curIndex = (i + 1);
    this.jdField_a_of_type_Alem$a = ((alem.a)localList.get(i % this.Jc.size()));
    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(cwH, this.curIndex).commit();
    return this.jdField_a_of_type_Alem$a;
  }
  
  private void a(a parama)
  {
    Object localObject = a();
    int i;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (localObject != null)
    {
      parama.title.setText(((alem.a)localObject).title);
      parama.xW.setText(((alem.a)localObject).subTitle);
      if (((alem.a)localObject).P != null)
      {
        i = ((alem.a)localObject).P.size();
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        int j = aqnm.dpToPx(36.0F);
        localURLDrawableOptions.mRequestWidth = j;
        localURLDrawableOptions.mRequestHeight = j;
        if (i != 1) {
          break label118;
        }
        localURLDrawable = URLDrawable.getDrawable((String)((alem.a)localObject).P.get(0), localURLDrawableOptions);
        parama.Fj.setImageDrawable(localURLDrawable);
        parama.Fk.setVisibility(8);
      }
    }
    label118:
    while (i <= 1) {
      return;
    }
    URLDrawable localURLDrawable = URLDrawable.getDrawable((String)((alem.a)localObject).P.get(0), localURLDrawableOptions);
    localObject = URLDrawable.getDrawable((String)((alem.a)localObject).P.get(1), localURLDrawableOptions);
    parama.Fj.setImageDrawable(localURLDrawable);
    parama.Fk.setImageDrawable((Drawable)localObject);
    parama.Fk.setVisibility(0);
  }
  
  private boolean aFz()
  {
    return (this.Jc == null) || (this.Jc.isEmpty());
  }
  
  private void fE(Context paramContext)
  {
    this.mw = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(2131562130, null));
    this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView$a = new a(this.mw);
    addView(this.mw);
    this.curIndex = BaseApplicationImpl.getApplication().getRuntime().getPreferences().getInt(cwH, 0);
    if (this.curIndex > 100) {
      this.curIndex = 0;
    }
  }
  
  public String Cv()
  {
    if (this.jdField_a_of_type_Alem$a != null) {
      return this.jdField_a_of_type_Alem$a.alE;
    }
    return null;
  }
  
  public String Cw()
  {
    if (this.jdField_a_of_type_Alem$a != null) {
      return this.jdField_a_of_type_Alem$a.Zp;
    }
    return "";
  }
  
  public void setInfoList(List<alem.a> paramList)
  {
    this.Jc = paramList;
    a(this.jdField_a_of_type_ComTencentMobileqqVasZanBannerView$a);
  }
  
  public static class a
  {
    ImageView Fj;
    ImageView Fk;
    RelativeLayout layout;
    TextView title;
    TextView xW;
    
    a(RelativeLayout paramRelativeLayout)
    {
      this.layout = paramRelativeLayout;
      this.title = ((TextView)paramRelativeLayout.findViewById(2131379769));
      this.xW = ((TextView)paramRelativeLayout.findViewById(2131378902));
      this.Fj = ((ImageView)paramRelativeLayout.findViewById(2131369566));
      this.Fk = ((ImageView)paramRelativeLayout.findViewById(2131369567));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ZanBannerView
 * JD-Core Version:    0.7.0.1
 */