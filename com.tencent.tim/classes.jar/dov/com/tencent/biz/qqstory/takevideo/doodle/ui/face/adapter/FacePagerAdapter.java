package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import axqg;
import aymz;
import aynj;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FacePagerAdapter
  extends PagerAdapter
{
  private FaceListPage.a a;
  private aynj b;
  private axqg g;
  private Context mContext;
  private List<FaceListPage> oU = new LinkedList();
  
  public FacePagerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public FaceListPage a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (this.oU != null)
    {
      Iterator localIterator = this.oU.iterator();
      localObject2 = localObject1;
      if (localIterator.hasNext())
      {
        localObject2 = (FaceListPage)localIterator.next();
        if (((FaceListPage)localObject2).mPosition != paramInt) {
          break label60;
        }
        localObject1 = localObject2;
      }
    }
    label60:
    for (;;)
    {
      break;
      return localObject2;
    }
  }
  
  public void a(aynj paramaynj)
  {
    this.b = paramaynj;
    notifyDataSetChanged();
  }
  
  public void a(FaceListPage.a parama)
  {
    this.a = parama;
  }
  
  public void afp(int paramInt)
  {
    boolean bool = true;
    FaceListPage localFaceListPage = a(paramInt);
    if ((localFaceListPage == null) || (localFaceListPage.isShowing))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("notifyNextPageShow loaded position:").append(paramInt).append(", page:");
        if (localFaceListPage == null) {
          break label68;
        }
      }
      for (;;)
      {
        QLog.i("FacePagerAdapter", 2, bool);
        return;
        label68:
        bool = false;
      }
    }
    Object localObject = this.b.a(paramInt);
    localFaceListPage.isShowing = true;
    localFaceListPage.b((aymz)localObject);
  }
  
  public void afq(int paramInt)
  {
    if ((this.oU != null) && (this.oU.size() > 0))
    {
      Iterator localIterator = this.oU.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.mPosition != paramInt) && (localFaceListPage.isShowing))
        {
          localFaceListPage.isShowing = false;
          localFaceListPage.b(this.b.a(localFaceListPage.mPosition));
          if (QLog.isColorLevel()) {
            QLog.i("FacePagerAdapter", 2, "clearOtherView position:" + localFaceListPage.mPosition + ", current:" + paramInt);
          }
        }
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.mPosition = -1;
    paramObject.b(null);
    this.oU.remove(paramObject);
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.getCount();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    aymz localaymz = this.b.a(paramInt);
    FaceListPage localFaceListPage = new FaceListPage(this.mContext, this.g, this.a);
    paramViewGroup.addView(localFaceListPage);
    localFaceListPage.mPosition = paramInt;
    if (((ViewPager)paramViewGroup).getCurrentItem() == paramInt) {}
    for (localFaceListPage.isShowing = true;; localFaceListPage.isShowing = false)
    {
      localFaceListPage.b(localaymz);
      this.oU.add(localFaceListPage);
      return localFaceListPage;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void onChange()
  {
    notifyDataSetChanged();
  }
  
  public void onChange(int paramInt)
  {
    aymz localaymz = this.b.a(paramInt);
    if (localaymz != null)
    {
      Iterator localIterator = this.oU.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if ((localFaceListPage.mPosition == paramInt) && (localFaceListPage.isShowing)) {
          localFaceListPage.b(localaymz);
        }
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Iterator localIterator = this.oU.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.mPosition == paramInt)
      {
        if (!localFaceListPage.isShowing)
        {
          aymz localaymz = this.b.a(paramInt);
          localFaceListPage.isShowing = true;
          localFaceListPage.b(localaymz);
        }
        localFaceListPage.onShow();
      }
    }
  }
  
  public void setOnFaceSelectedListener(axqg paramaxqg)
  {
    this.g = paramaxqg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */