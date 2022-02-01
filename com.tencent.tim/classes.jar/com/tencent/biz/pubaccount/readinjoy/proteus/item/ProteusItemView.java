package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeMiddleBodyView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeVideoView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.ProteusRecycleView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lfo;
import lie;
import lpj;
import lsd;
import lso;
import lta;
import ltp;
import ndi.c;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusItemView
  extends RelativeLayout
  implements lfo
{
  private ComponentLastRead jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead;
  private final lta jdField_a_of_type_Lta = new lta(this);
  public final int aPv = 1;
  private Container f;
  private ViewBase h;
  private List<a> io = new ArrayList();
  
  public ProteusItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(lie paramlie, View paramView)
  {
    if (paramView == null) {
      QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, view is null.");
    }
    for (;;)
    {
      return;
      if ((paramlie != null) && (paramlie.a() != null))
      {
        paramlie = paramlie.a();
        if (TextUtils.isEmpty(paramlie.proteusItemsData)) {
          continue;
        }
        try
        {
          paramlie = new JSONObject(paramlie.proteusItemsData);
          Iterator localIterator = paramlie.keys();
          String str;
          Object localObject;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localObject = paramlie.opt(str);
          } while (!"guide_card_type".equals(str));
          if ("1".equals(String.valueOf(localObject)))
          {
            QLog.d("ProteusItemView", 1, "one class flow guide card, show separator.");
            paramView.setVisibility(0);
            return;
          }
        }
        catch (JSONException paramlie)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator JSONException, e = ", paramlie);
          return;
          QLog.d("ProteusItemView", 1, "flow guide card, hide separator.");
          paramView.setVisibility(8);
          return;
        }
        catch (Exception paramlie)
        {
          QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, e = ", paramlie);
          return;
        }
      }
    }
    QLog.d("ProteusItemView", 1, "dealFlowGuideSeparator, model of articleInfo is null.");
  }
  
  private void a(boolean paramBoolean, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      for (;;)
      {
        return;
        if (!(paramViewBase instanceof Layout)) {
          break;
        }
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
        {
          paramViewBase = paramViewBase.iterator();
          while (paramViewBase.hasNext()) {
            a(paramBoolean, (ViewBase)paramViewBase.next());
          }
        }
      }
      str = paramViewBase.getViewId();
    } while ((str == null) || ((!str.startsWith("id_top_left_mask")) && (!str.startsWith("id_bottom_left_mask")) && (!str.startsWith("id_top_right_mask")) && (!str.startsWith("id_bottom_right_mask"))));
    m(paramViewBase.getNativeView(), paramBoolean);
  }
  
  private boolean dL(int paramInt)
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Lta != null) && (this.jdField_a_of_type_Lta.a() != null))
    {
      QLog.d("gifvideo.ProteusItemView", 2, " proteusitemhelper celltype: " + this.jdField_a_of_type_Lta.a().getCellType());
      if (this.f == null) {
        break label841;
      }
      QLog.d("ProteusItemView", 1, "type pgc gif");
      localObject1 = this.f.getVirtualView().findViewBaseByName("id_middle_body_content");
      if ((localObject1 != null) && ((localObject1 instanceof lsd)))
      {
        QLog.d("ProteusItemView", 2, "ReadInJoyMiddleBodyView");
        localObject1 = ((ViewBase)localObject1).getNativeView();
        if (!(localObject1 instanceof NativeMiddleBodyView)) {
          break label390;
        }
        QLog.d("ProteusItemView", 2, "NativeMiddleBodyView");
        localObject1 = ((NativeMiddleBodyView)localObject1).getContent();
        if (!(localObject1 instanceof ComponentPGCShortContentBig)) {
          break label360;
        }
        QLog.d("ProteusItemView", 2, "ComponentPGCShortContentBig");
      }
      switch (paramInt)
      {
      default: 
        label184:
        localObject1 = this.f.getViewIdMapping().entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label841;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof lso))
      {
        localObject2 = (lso)((Map.Entry)localObject2).getValue();
        if (((lso)localObject2).a() == null) {
          continue;
        }
        switch (paramInt)
        {
        default: 
          break;
        case 1: 
          return ((lso)localObject2).a().kH();
          QLog.d("gifvideo.ProteusItemView", 2, "proteusitemhelper celltype: null");
          break;
          QLog.d("gifvideo.ProteusItemView", 2, "shortcontent to play");
          return ((ComponentPGCShortContentBig)localObject1).kH();
          ((ComponentPGCShortContentBig)localObject1).stopPlay();
          return false;
          ((ComponentPGCShortContentBig)localObject1).pausePlay();
          return false;
          ((ComponentPGCShortContentBig)localObject1).aOu();
          return false;
          QLog.d("gifvideo.ProteusItemView", 2, localObject1 + " is not ComponentPGCShortContentBig");
          break label184;
          QLog.d("gifvideo.ProteusItemView", 2, localObject1 + " is not NativeMiddleBodyView");
          break;
        case 2: 
          ((lso)localObject2).a().stop();
          return false;
        case 3: 
          ((lso)localObject2).a().pause();
          return false;
        case 4: 
          label360:
          ((lso)localObject2).a().destroy();
          label390:
          return false;
        }
      }
      if ((((Map.Entry)localObject2).getValue() instanceof ltp))
      {
        localObject2 = (ltp)((Map.Entry)localObject2).getValue();
        if ((((ltp)localObject2).getNativeView() instanceof RelativeLayout))
        {
          localObject2 = (RelativeLayout)((ltp)localObject2).getNativeView();
          if ((((RelativeLayout)localObject2).getChildCount() > 0) && ((((RelativeLayout)localObject2).getChildAt(0) instanceof ProteusRecycleView)))
          {
            localObject2 = (ProteusRecycleView)((RelativeLayout)localObject2).getChildAt(0);
            int j = ((ProteusRecycleView)localObject2).getChildCount();
            int i = 0;
            while (i < j)
            {
              if ((((ProteusRecycleView)localObject2).getChildAt(i) instanceof Container))
              {
                Iterator localIterator = ((Container)((ProteusRecycleView)localObject2).getChildAt(i)).getViewIdMapping().entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Object localObject3 = (Map.Entry)localIterator.next();
                  if ((((Map.Entry)localObject3).getValue() instanceof lso))
                  {
                    localObject3 = (lso)((Map.Entry)localObject3).getValue();
                    if (((lso)localObject3).a() != null) {
                      switch (paramInt)
                      {
                      default: 
                        break;
                      case 1: 
                        return ((lso)localObject3).a().kH();
                      case 2: 
                        ((lso)localObject3).a().stop();
                        return false;
                      case 3: 
                        ((lso)localObject3).a().pause();
                        return false;
                      case 4: 
                        ((lso)localObject3).a().destroy();
                        return false;
                      }
                    }
                  }
                  else if ((((Map.Entry)localObject3).getValue() instanceof lsd))
                  {
                    localObject3 = ((ViewBase)((Map.Entry)localObject3).getValue()).getNativeView();
                    if ((localObject3 instanceof NativeMiddleBodyView))
                    {
                      localObject3 = ((NativeMiddleBodyView)localObject3).getContent();
                      if ((localObject3 instanceof ComponentPGCShortContentBig)) {
                        switch (paramInt)
                        {
                        default: 
                          break;
                        case 1: 
                          return ((ComponentPGCShortContentBig)localObject3).kH();
                        case 2: 
                          ((ComponentPGCShortContentBig)localObject3).stopPlay();
                          return false;
                        case 3: 
                          ((ComponentPGCShortContentBig)localObject3).pausePlay();
                          return false;
                        case 4: 
                          ((ComponentPGCShortContentBig)localObject3).aOu();
                          return false;
                        }
                      }
                    }
                  }
                }
              }
              i += 1;
            }
          }
        }
      }
    }
    label841:
    return false;
  }
  
  private void m(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {}
    while (!(paramView instanceof ImageView)) {
      return;
    }
    paramView = (ImageView)paramView;
    if (paramBoolean)
    {
      paramView.setColorFilter(Color.parseColor("#e5e6e7"));
      return;
    }
    paramView.clearColorFilter();
  }
  
  public Container a()
  {
    return this.f;
  }
  
  public lta a()
  {
    return this.jdField_a_of_type_Lta;
  }
  
  public void a(a parama)
  {
    this.io.add(parama);
  }
  
  public void aMU()
  {
    removeAllViews();
    this.f = null;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = null;
    this.f = null;
  }
  
  public void destroy()
  {
    dL(4);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.io != null) && (!this.io.isEmpty()))
    {
      paramCanvas = this.io.iterator();
      while (paramCanvas.hasNext()) {
        ((a)paramCanvas.next()).aDi();
      }
    }
  }
  
  public void e(Container paramContainer)
  {
    Object localObject = paramContainer.getVirtualView().getComLayoutParams();
    localObject = new RelativeLayout.LayoutParams(((Layout.Params)localObject).mLayoutWidth, ((Layout.Params)localObject).mLayoutHeight);
    this.f = paramContainer;
    paramContainer.setId(1);
    setBackgroundColor(getResources().getColor(2131167595));
    addView(paramContainer, (ViewGroup.LayoutParams)localObject);
  }
  
  public TemplateBean getTemplateBean()
  {
    if (this.f != null) {
      return (TemplateBean)this.f.getTag(2131376767);
    }
    return null;
  }
  
  public void pause()
  {
    dL(3);
  }
  
  public void setModel(lie paramlie, ndi.c paramc)
  {
    this.jdField_a_of_type_Lta.setModel(paramlie);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead = new ComponentLastRead(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 1);
      addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead, localLayoutParams);
    }
    if (this.h == null) {
      this.h = this.f.getVirtualView().findViewBaseByName("id_separator");
    }
    if ((this.h != null) && (this.h.getNativeView() != null))
    {
      if (!paramlie.Cv()) {
        break label144;
      }
      this.h.getNativeView().setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.P(paramlie);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead.a(new lpj(this, paramc));
      return;
      label144:
      this.h.getNativeView().setVisibility(0);
      a(paramlie, this.h.getNativeView());
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (this.f == null) {
      return;
    }
    a(paramBoolean, this.f.getVirtualView());
    super.setPressed(paramBoolean);
  }
  
  public void setTemplateBean(TemplateBean paramTemplateBean)
  {
    if (this.f != null)
    {
      this.f.setTag(2131376767, paramTemplateBean);
      setPressed(false);
      return;
    }
    QLog.d("TemplateFactory", 2, "setTemplateBean : " + paramTemplateBean);
  }
  
  public boolean start()
  {
    return dL(1);
  }
  
  public void stop()
  {
    dL(2);
  }
  
  public static abstract interface a
  {
    public abstract void aDi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView
 * JD-Core Version:    0.7.0.1
 */