package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qgy.b;
import qgy.c;
import qgy.d;
import qiw;
import qjk;
import qjl;
import qjp;
import qjq;
import qjr;
import ram;
import rom;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  private VideoViewVideoHolder.j a;
  private qiw jdField_c_of_type_Qiw;
  private qjk jdField_c_of_type_Qjk;
  private qiw d = new qjl(this);
  public Map<Integer, StoryPlayerGroupHolder> fU = new HashMap();
  private ArrayList<qgy.d> nc = new ArrayList();
  
  public StoryPlayerGroupAdapter(qjk paramqjk)
  {
    this.jdField_c_of_type_Qjk = paramqjk;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    qgy.d locald = (qgy.d)this.nc.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (locald.JA()) {
      if ((locald instanceof qgy.b)) {
        localArrayList.add(qjq.a("LoadingGroup-" + locald.d.groupId, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, locald, localArrayList);
      return;
      localArrayList.add(qjq.a("LoadingGroup-" + locald.d.groupId, null, ((qjr)locald).axz));
      continue;
      if (locald.Jz())
      {
        if ((locald instanceof qgy.b)) {
          localArrayList.add(qjq.a("ErrorGroup-" + locald.d.groupId, null, ((qgy.b)locald).i));
        } else {
          localArrayList.add(qjq.a("ErrorGroup-" + locald.d.groupId, null, ((qjr)locald).e));
        }
      }
      else if (locald.nv.isEmpty())
      {
        localArrayList.add(qjq.a("EmptyGroup-" + locald.d.groupId, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = locald.nv.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new qjq(str, (String)locald.fR.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_c_of_type_Qjk.a(paramInt);
  }
  
  public void a(qiw paramqiw, VideoViewVideoHolder.j paramj)
  {
    this.jdField_c_of_type_Qiw = paramqiw;
    this.a = paramj;
  }
  
  public List<qgy.d> be()
  {
    return Collections.unmodifiableList(this.nc);
  }
  
  public void cl(@NonNull ArrayList<qgy.d> paramArrayList)
  {
    this.nc.clear();
    this.nc.addAll(paramArrayList);
    this.fU.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    ram.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.bmu), paramObject);
    localStoryPlayerGroupHolder.boy();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.mItemView);
    this.jdField_c_of_type_Qjk.a().recycle(localStoryPlayerGroupHolder);
  }
  
  public int getCount()
  {
    return this.nc.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (StoryPlayerGroupHolder)paramObject;
    int i = 0;
    while (i < this.nc.size())
    {
      if (((qgy.d)this.nc.get(i)).d.equals(paramObject.d))
      {
        if (i == paramObject.bmu)
        {
          ram.b("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.bmu));
          this.fU.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        ram.b("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.bmu), Integer.valueOf(i));
        this.fU.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    ram.b("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.bmu), paramObject.d.groupId);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ram.b("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((qgy.d)this.nc.get(paramInt) == null)
    {
      rom.assertTrue(false, "can not get group info by position = " + paramInt + ", size = " + this.nc.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_c_of_type_Qjk.a().c(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_c_of_type_Qjk);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_c_of_type_Qjk);
      localStoryPlayerGroupHolder1.onCreate();
      localStoryPlayerGroupHolder1.a(this.d, this.a);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.mItemView);
    ram.b("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.mItemView);
    this.fU.put(Integer.valueOf(paramInt), localStoryPlayerGroupHolder1);
    a(paramInt, localStoryPlayerGroupHolder1);
    return localStoryPlayerGroupHolder1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof StoryPlayerGroupHolder))
    {
      bool1 = bool2;
      if (((StoryPlayerGroupHolder)paramObject).mItemView == paramView) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */