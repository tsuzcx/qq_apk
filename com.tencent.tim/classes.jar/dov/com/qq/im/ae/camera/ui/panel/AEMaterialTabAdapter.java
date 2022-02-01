package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import android.view.ViewGroup;
import awzj;
import axbq;
import axbr;
import axov;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class AEMaterialTabAdapter
  extends PagerAdapter
{
  private List<axbq> Ft;
  private axbr a;
  private AEMaterialPanel.a b;
  private Context mContext;
  public HashMap<Integer, AEGridView> mF = new HashMap();
  
  public AEMaterialTabAdapter(Context paramContext, AEMaterialPanel.a parama)
  {
    this.mContext = paramContext;
    this.b = parama;
    this.a = ((axbr)axov.a(18));
  }
  
  private void a(awzj paramawzj, int paramInt)
  {
    this.a.a(paramawzj, 112);
    this.a.a(paramawzj, 113);
    this.a.a(paramawzj, 114);
    this.a.a(paramawzj, 111);
    this.a.a(paramawzj, 115);
    if (paramInt == 0) {
      this.a.a(paramawzj, 111);
    }
  }
  
  public axbq a(int paramInt)
  {
    if ((this.Ft != null) && (this.Ft.size() > paramInt) && (paramInt >= 0)) {
      return (axbq)this.Ft.get(paramInt);
    }
    return null;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.mF.get(Integer.valueOf(paramInt)));
    paramViewGroup = (AEGridView)this.mF.get(Integer.valueOf(paramInt));
    if (paramViewGroup != null)
    {
      paramViewGroup = (awzj)paramViewGroup.getAdapter();
      this.a.d(paramViewGroup);
    }
  }
  
  public int getCount()
  {
    return this.Ft.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEGridView localAEGridView = (AEGridView)this.mF.get(Integer.valueOf(paramInt));
    Object localObject;
    boolean bool;
    if (localAEGridView == null)
    {
      localAEGridView = new AEGridView(this.mContext);
      localObject = this.mContext;
      AEMaterialPanel.a locala = this.b;
      if (paramInt == 0)
      {
        bool = true;
        localObject = new awzj((Context)localObject, localAEGridView, locala, bool);
        a((awzj)localObject, paramInt);
        this.mF.put(Integer.valueOf(paramInt), localAEGridView);
      }
    }
    for (;;)
    {
      ((awzj)localObject).oC(((axbq)this.Ft.get(paramInt)).Mm);
      localAEGridView.setAdapter((RecyclerView.Adapter)localObject);
      paramViewGroup.addView(localAEGridView);
      if (QLog.isColorLevel()) {
        QLog.i("PtvTemplateViewPagerAdapter", 2, "instantiateItem: invoked. info: ptvTemplateAdapter = " + localObject);
      }
      return localAEGridView;
      bool = false;
      break;
      localObject = (awzj)localAEGridView.getAdapter();
      a((awzj)localObject, paramInt);
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void lV(List<axbq> paramList)
  {
    this.Ft = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialTabAdapter
 * JD-Core Version:    0.7.0.1
 */