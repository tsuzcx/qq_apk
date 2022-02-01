package dov.com.qq.im.aeeditor.module.edit;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import axiy;
import axjm;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.tavcut.session.TAVCutImageSession;
import com.tencent.tavcut.view.TAVCutImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AEEditorImagePagerAdapter
  extends PagerAdapter
{
  private static final String TAG = AEEditorImagePagerAdapter.class.getSimpleName();
  private a a;
  private int aNF;
  private TAVCutImageSession b;
  private List<String> imagePaths = new ArrayList();
  private HashMap<String, axjm> rj = new HashMap();
  private HashMap<Integer, Boolean> rk = new HashMap();
  
  public AEEditorImagePagerAdapter(TAVCutImageSession paramTAVCutImageSession, List<String> paramList, List<axjm> paramList1, a parama)
  {
    this.b = paramTAVCutImageSession;
    this.a = parama;
    if (paramList != null) {
      this.imagePaths = paramList;
    }
    paramTAVCutImageSession = paramList1.iterator();
    while (paramTAVCutImageSession.hasNext())
    {
      paramList = (axjm)paramTAVCutImageSession.next();
      this.rj.put(paramList.path, paramList);
    }
  }
  
  private void a(ViewGroup paramViewGroup, int paramInt, TAVCutImageView paramTAVCutImageView)
  {
    Object localObject = (String)this.imagePaths.get(paramInt);
    localObject = (axjm)this.rj.get(localObject);
    int i = ((axjm)localObject).width;
    int j = ((axjm)localObject).height;
    double d1 = i * ((axjm)localObject).cropConfig.getWidth();
    float f = j;
    double d2 = ((axjm)localObject).cropConfig.getHeight() * f;
    localObject = paramTAVCutImageView.getLayoutParams();
    this.aNF = paramViewGroup.getHeight();
    i = paramViewGroup.getWidth();
    j = paramViewGroup.getHeight();
    double d3;
    if (d1 / d2 > i * 1.0D / j)
    {
      ((ViewGroup.LayoutParams)localObject).width = i;
      d3 = ((ViewGroup.LayoutParams)localObject).width;
      ((ViewGroup.LayoutParams)localObject).height = ((int)(d2 / d1 * d3));
    }
    for (;;)
    {
      paramTAVCutImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setTAVCutImageView(paramInt, paramTAVCutImageView);
      if (this.a != null) {
        this.a.aem(paramInt);
      }
      axiy.i(TAG, "render position = " + paramInt);
      return;
      ((ViewGroup.LayoutParams)localObject).height = j;
      d3 = ((ViewGroup.LayoutParams)localObject).height;
      ((ViewGroup.LayoutParams)localObject).width = ((int)(d1 / d2 * d3));
    }
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
    this.rk.put(Integer.valueOf(paramInt), Boolean.valueOf(false));
    this.b.releaseTAVCutImageView(paramInt);
  }
  
  public void eMG()
  {
    Iterator localIterator = this.rk.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if (((Boolean)this.rk.get(localInteger)).booleanValue() == true) {
        this.b.releaseTAVCutImageView(localInteger.intValue());
      }
    }
  }
  
  public int getCount()
  {
    return this.imagePaths.size();
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558612, null);
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)localView.findViewById(2131379259);
    this.rk.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    AEEditorImagePagerAdapter.1 local1 = new AEEditorImagePagerAdapter.1(this, paramViewGroup, paramInt, localTAVCutImageView);
    if (this.aNF == 0) {
      localTAVCutImageView.post(local1);
    }
    for (;;)
    {
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
      return localView;
      local1.run();
    }
  }
  
  public boolean isViewFromObject(@NonNull View paramView, @NonNull Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public static abstract interface a
  {
    public abstract void aem(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImagePagerAdapter
 * JD-Core Version:    0.7.0.1
 */