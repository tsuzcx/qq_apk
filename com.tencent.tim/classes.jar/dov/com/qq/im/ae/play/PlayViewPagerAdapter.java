package dov.com.qq.im.ae.play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import axbq;
import axbu;
import axgi;
import axip;
import axiy;
import java.util.LinkedList;
import java.util.List;

public class PlayViewPagerAdapter
  extends PagerAdapter
{
  private List<axbq> MG;
  private AEPlayShowPageView a;
  private int baD = -1;
  private axgi c;
  private Context mContext;
  
  public PlayViewPagerAdapter(@NonNull Context paramContext, @NonNull axgi paramaxgi, @NonNull List<axbq> paramList)
  {
    this.mContext = paramContext;
    this.c = paramaxgi;
    this.MG = paramList;
  }
  
  private List<axbu> as(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.MG != null)
    {
      localObject1 = localObject2;
      if (this.MG.size() > paramInt) {
        localObject1 = (axbq)this.MG.get(paramInt);
      }
    }
    if ((localObject1 == null) || (((axbq)localObject1).Mm == null)) {
      return new LinkedList();
    }
    return ((axbq)localObject1).Mm;
  }
  
  private String gS(int paramInt)
  {
    if ((this.MG != null) && (this.MG.size() > paramInt)) {
      return ((axbq)this.MG.get(paramInt)).cTw;
    }
    return "-1";
  }
  
  private int lG(int paramInt)
  {
    axbq localaxbq = (axbq)this.MG.get(paramInt);
    if (localaxbq == null) {
      return 2;
    }
    return localaxbq.eEw;
  }
  
  public String HN()
  {
    if (this.baD <= 0) {
      return "-1";
    }
    return gS(this.baD);
  }
  
  public AEPlayShowPageView a()
  {
    return this.a;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof AEPlayShowPageView)) {
      ((AEPlayShowPageView)paramObject).onDestroy();
    }
    axiy.d("AEPlayShowPart", "page destroy.......");
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.MG == null) {
      return 0;
    }
    return this.MG.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public List<axbq> hQ()
  {
    return this.MG;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AEPlayShowPageView localAEPlayShowPageView = new AEPlayShowPageView(this.mContext, this.c, lG(paramInt), as(paramInt));
    paramViewGroup.addView(localAEPlayShowPageView);
    return localAEPlayShowPageView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void oF(List<axbq> paramList)
  {
    this.MG = paramList;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    if ((paramObject instanceof AEPlayShowPageView)) {
      this.a = ((AEPlayShowPageView)paramObject);
    }
    if (this.baD != paramInt)
    {
      this.baD = paramInt;
      if ((this.MG != null) && (this.MG.size() > paramInt))
      {
        paramViewGroup = (axbq)this.MG.get(paramInt);
        if (paramViewGroup != null) {
          axip.a().acV(paramViewGroup.cTw + "");
        }
      }
      if ((paramObject instanceof AEPlayShowPageView))
      {
        this.a.post(new PlayViewPagerAdapter.1(this, paramInt));
        this.a.eJF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayViewPagerAdapter
 * JD-Core Version:    0.7.0.1
 */