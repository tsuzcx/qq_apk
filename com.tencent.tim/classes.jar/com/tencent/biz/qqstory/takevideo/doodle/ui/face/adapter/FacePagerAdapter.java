package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel.a;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import rik;
import rir;
import ris;

public class FacePagerAdapter
  extends PagerAdapter
  implements FaceViewPager.a
{
  private rir a;
  private FaceListPage.a b;
  private FacePanel.a c;
  private Context mContext;
  private List<FaceListPage> oU = new LinkedList();
  private Queue<FaceListPage> v = new LinkedList();
  
  public FacePagerAdapter(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void a(FaceListPage.a parama)
  {
    this.b = parama;
  }
  
  public void a(ris paramris)
  {
    this.a = paramris;
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.mPosition = -1;
    paramObject.b(null);
    this.v.offer(paramObject);
    this.oU.remove(paramObject);
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.getCount();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.a == null) {
      return null;
    }
    rik localrik = this.a.a(paramInt);
    FaceListPage localFaceListPage2 = (FaceListPage)this.v.poll();
    FaceListPage localFaceListPage1 = localFaceListPage2;
    if (localFaceListPage2 == null) {
      localFaceListPage1 = new FaceListPage(this.mContext, this.c, this.b);
    }
    paramViewGroup.addView(localFaceListPage1);
    localFaceListPage1.mPosition = paramInt;
    localFaceListPage1.b(localrik);
    this.oU.add(localFaceListPage1);
    return localFaceListPage1;
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
    rik localrik = this.a.a(paramInt);
    if (localrik != null)
    {
      Iterator localIterator = this.oU.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if (localFaceListPage.mPosition == paramInt) {
          localFaceListPage.b(localrik);
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
      if (localFaceListPage.mPosition == paramInt) {
        localFaceListPage.onShow();
      }
    }
  }
  
  public void setOnFaceSelectedListener(FacePanel.a parama)
  {
    this.c = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */