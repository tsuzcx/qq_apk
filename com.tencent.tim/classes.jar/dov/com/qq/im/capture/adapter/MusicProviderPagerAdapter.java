package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import axoz;
import axqd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.view.MusicProviderView;
import java.util.List;
import wja;

public class MusicProviderPagerAdapter
  extends PagerAdapter
{
  public static final int dyn = wja.dp2px(7.0F, BaseApplication.getContext().getResources());
  public static final int dyo = wja.dp2px(0.0F, BaseApplication.getContext().getResources());
  private List<axqd> Ay;
  MusicProviderView b;
  Drawable bY = new ColorDrawable(0);
  private SparseArray<GridView> jdField_do = new SparseArray();
  private AdapterView.c h;
  private Context mContext;
  
  public MusicProviderPagerAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.mContext = paramContext;
    this.b = paramMusicProviderView;
  }
  
  public GridView b(int paramInt)
  {
    paramInt = this.jdField_do.keyAt(paramInt);
    return (GridView)this.jdField_do.get(paramInt);
  }
  
  public void b(AdapterView.c paramc)
  {
    this.h = paramc;
  }
  
  public GridView c(int paramInt)
  {
    return (GridView)this.jdField_do.get(paramInt);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_do.get(paramInt));
  }
  
  public int getCount()
  {
    return this.Ay.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MusicProviderView", 2, "instantiateItem position = " + paramInt);
    }
    GridView localGridView = (GridView)this.jdField_do.get(paramInt);
    axoz localaxoz;
    if (localGridView == null)
    {
      localGridView = new GridView(this.mContext);
      localGridView.setNumColumns(4);
      localGridView.setSelector(this.bY);
      localGridView.setVerticalSpacing(dyo);
      localGridView.setHorizontalSpacing(dyo);
      localGridView.setVerticalScrollBarEnabled(false);
      localGridView.setPadding(dyn, dyn, dyn, dyn * 2 + wja.dp2px(36.0F, this.mContext.getResources()));
      localGridView.setClipToPadding(false);
      localaxoz = new axoz(this.mContext, this.b);
      localGridView.setOnItemClickListener(this.h);
      this.jdField_do.put(paramInt, localGridView);
    }
    for (;;)
    {
      localaxoz.setData(((axqd)this.Ay.get(paramInt)).Fv);
      localGridView.setAdapter(localaxoz);
      if (this.b.eIu == paramInt)
      {
        localGridView.setSelection(this.b.eIv);
        this.b.eIu = -1;
        this.b.eIv = -1;
      }
      paramViewGroup.addView(localGridView, -1, -1);
      return localGridView;
      localaxoz = (axoz)localGridView.getAdapter();
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void lV(List<axqd> paramList)
  {
    this.Ay = paramList;
  }
  
  public int wu()
  {
    return this.jdField_do.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.MusicProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */