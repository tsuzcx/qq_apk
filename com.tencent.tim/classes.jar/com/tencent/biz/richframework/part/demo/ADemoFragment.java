package com.tencent.biz.richframework.part.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import java.util.ArrayList;
import java.util.List;
import rxj;
import rxk;
import ryb;
import ryc;
import rye;
import ryf;

public class ADemoFragment
  extends QCircleBaseFragment
{
  private rxj b()
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new ryc(new Bundle()));
    ((ArrayList)localObject).add(new rye(new Bundle()));
    ((ArrayList)localObject).add(new ryf(new Bundle()));
    localObject = new rxj(0, (List)localObject, 3, 2);
    ((rxj)localObject).a().setEnableLoadMore(true);
    ((rxj)localObject).a().setEnableRefresh(true);
    ExtraTypeInfo localExtraTypeInfo = new ExtraTypeInfo();
    ((rxj)localObject).a().setExtraTypeInfo(localExtraTypeInfo);
    return localObject;
  }
  
  public List<rxk> bw()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ryb());
    localArrayList.add(b());
    return localArrayList;
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public int getContentLayoutId()
  {
    return 0;
  }
  
  public String getLogTag()
  {
    return "Demo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.demo.ADemoFragment
 * JD-Core Version:    0.7.0.1
 */