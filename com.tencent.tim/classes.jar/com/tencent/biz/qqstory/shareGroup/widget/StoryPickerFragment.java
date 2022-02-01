package com.tencent.biz.qqstory.shareGroup.widget;

import acfp;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import aqha;
import aqju;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseFragment;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.b;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.QQUIEventReceiver;
import com.tribe.async.dispatch.Subscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import plr;
import pxg.b;
import pye.a;
import qje.a;
import qqf;
import qqg;
import qqh;
import qqi;
import qqj;
import qqk;
import qqo;
import qts;
import ram;
import rar;
import rsn;

public class StoryPickerFragment
  extends QQStoryBaseFragment
  implements View.OnClickListener, StoryPickerHorizontalListView.a, StoryPickerHorizontalListView.b
{
  QQStoryPullToRefreshListView a;
  public LinkedHashSet<String> a;
  public qqo a;
  public qts a;
  boolean aEL = false;
  String ayc;
  String ayd;
  int bnC;
  private long currentActivityStayTime;
  View or;
  
  public StoryPickerFragment()
  {
    this.jdField_a_of_type_JavaUtilLinkedHashSet = new LinkedHashSet();
  }
  
  static Intent a(Activity paramActivity, LinkedHashSet<String> paramLinkedHashSet, String paramString, boolean paramBoolean, int paramInt)
  {
    paramActivity = new Intent(paramActivity, StoryPickerFragment.class);
    paramActivity.putExtra("extra_alert_for_result", paramBoolean);
    if (!TextUtils.isEmpty(paramString)) {
      paramActivity.putExtra("extra_sharegroup_name", paramString);
    }
    if ((paramLinkedHashSet != null) && (!paramLinkedHashSet.isEmpty())) {
      paramActivity.putExtra("extra_checked_vidset", paramLinkedHashSet);
    }
    paramActivity.putExtra("extra_from", paramInt);
    return paramActivity;
  }
  
  public static void a(Activity paramActivity, LinkedHashSet<String> paramLinkedHashSet, String paramString, int paramInt1, int paramInt2)
  {
    PublicFragmentActivity.startForResult(paramActivity, a(paramActivity, paramLinkedHashSet, paramString, true, paramInt2), StoryPickerFragment.class, paramInt1);
  }
  
  void Ad()
  {
    int i = 0;
    this.leftView.setText(getString(2131691039));
    super.setTitle(acfp.m(2131714955) + plr.asY);
    super.e(String.format(acfp.m(2131714957), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1) {}
    for (;;)
    {
      super.setRightViewTextDisable(i);
      this.or = super.$(2131366438);
      this.jdField_a_of_type_Qqo = new qqo(getActivity());
      this.jdField_a_of_type_Qqo.setOnHorizontalScrollListener(new qqf(this));
      this.jdField_a_of_type_Qqo.a(this);
      this.jdField_a_of_type_Qqo.a(this);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)super.$(2131370573));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Qqo);
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new qqg(this));
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a.setOnLoadMoreListener(new qqh(this));
      return;
      i = 1;
    }
  }
  
  public void O(@NonNull Map<Subscriber, String> paramMap)
  {
    super.O(paramMap);
    paramMap.put(new b(this), "");
    paramMap.put(new c(this), "");
    paramMap.put(new a(this), "");
  }
  
  public void a(View paramView, VideoCollectionItem.b paramb)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) && (!paramb.aFx))
    {
      paramView = aqha.a(getActivity(), 230);
      paramView.setMessage(String.format(acfp.m(2131714959), new Object[] { Integer.valueOf(20), plr.asY }));
      paramView.setPositiveButton(acfp.m(2131714958), new qqi(this));
      paramView.show();
      return;
    }
    int i;
    if (!paramb.checked)
    {
      paramb.checked = bool;
      paramView = (ImageView)paramView;
      if (!paramb.checked) {
        break label152;
      }
      i = 2130841267;
      label117:
      paramView.setImageResource(i);
      if (!paramb.checked) {
        break label159;
      }
      this.jdField_a_of_type_JavaUtilLinkedHashSet.add(paramb.mVid);
    }
    for (;;)
    {
      bpE();
      return;
      bool = false;
      break;
      label152:
      i = 2130841263;
      break label117;
      label159:
      this.jdField_a_of_type_JavaUtilLinkedHashSet.remove(paramb.mVid);
    }
  }
  
  public void a(String paramString, int paramInt, View paramView, VideoCollectionItem.b paramb)
  {
    if (paramb.aFx) {
      Bosses.get().postJob(new qqk(this, "StoryPickerFragment", paramString, paramb, paramInt, paramView));
    }
  }
  
  void biW()
  {
    this.ayc = String.valueOf(System.currentTimeMillis());
    this.jdField_a_of_type_Qts = new qts(QQStoryContext.a().getCurrentUid(), this.ayc);
    this.jdField_a_of_type_Qts.onStart();
    super.startTitleProgress();
    this.jdField_a_of_type_Qts.bqE();
  }
  
  void bpE()
  {
    super.e(String.format(acfp.m(2131714956), new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()) }), this);
    int i;
    List localList;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 1)
    {
      i = 0;
      setRightViewTextDisable(i);
      if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20)
      {
        localList = this.jdField_a_of_type_Qqo.getData();
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (i >= localList.size()) {
          break label174;
        }
        Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label151;
          }
          VideoCollectionItem.b localb = (VideoCollectionItem.b)localIterator.next();
          if (localb.checked)
          {
            localb.aFx = true;
            continue;
            i = 1;
            break;
          }
          localb.aFx = false;
        }
        label151:
        i += 1;
      }
    }
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() < 20) {
      bpF();
    }
    label174:
    this.jdField_a_of_type_Qqo.notifyDataSetChanged();
  }
  
  void bpF()
  {
    List localList = this.jdField_a_of_type_Qqo.getData();
    int i = 0;
    while (i < localList.size())
    {
      Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
      while (localIterator.hasNext())
      {
        VideoCollectionItem.b localb = (VideoCollectionItem.b)localIterator.next();
        if (!localb.aFx) {
          localb.aFx = true;
        }
      }
      i += 1;
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    Ad();
    biW();
  }
  
  public int getContentLayoutId()
  {
    return 2131561968;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    this.aEL = paramBundle.getBoolean("extra_alert_for_result", false);
    this.ayd = paramBundle.getString("extra_sharegroup_name");
    this.bnC = paramBundle.getInt("extra_from");
    paramBundle = (LinkedHashSet)paramBundle.getSerializable("extra_checked_vidset");
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      this.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(paramBundle);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilLinkedHashSet.size() > 0)
    {
      if (!this.aEL) {
        break label106;
      }
      localObject = new qqj(this);
      aqju localaqju = aqha.a(getActivity(), 230);
      localaqju.setMessage(getString(2131701947, new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedHashSet.size()), this.ayd }));
      localaqju.setNegativeButton(2131721058, (DialogInterface.OnClickListener)localObject);
      localaqju.setPositiveButton(acfp.m(2131721053), (DialogInterface.OnClickListener)localObject);
      localaqju.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label106:
      localObject = new Intent();
      ((Intent)localObject).putExtra("extra_checked_vidset", this.jdField_a_of_type_JavaUtilLinkedHashSet);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Qts != null) {
      this.jdField_a_of_type_Qts.onStop();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    rar.R(18, this.currentActivityStayTime);
  }
  
  public void onResume()
  {
    super.onResume();
    this.currentActivityStayTime = SystemClock.uptimeMillis();
    rar.a("share_story", "exp_all_story", this.bnC, 0, new String[0]);
  }
  
  static class a
    extends QQUIEventReceiver<StoryPickerFragment, qje.a>
  {
    public a(@NonNull StoryPickerFragment paramStoryPickerFragment)
    {
      super();
    }
    
    public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull qje.a parama)
    {
      paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.clear();
      paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.addAll(parama.mZ);
      List localList = paramStoryPickerFragment.jdField_a_of_type_Qqo.getData();
      int i = 0;
      while (i < localList.size())
      {
        Iterator localIterator = ((VideoCollectionItem)localList.get(i)).collectionVideoUIItemList.iterator();
        while (localIterator.hasNext())
        {
          VideoCollectionItem.b localb = (VideoCollectionItem.b)localIterator.next();
          if (parama.mZ.contains(localb.mVid)) {
            localb.checked = true;
          } else {
            localb.checked = false;
          }
        }
        i += 1;
      }
      paramStoryPickerFragment.bpE();
      if (parama.isConfirmed) {
        paramStoryPickerFragment.rightViewText.performClick();
      }
    }
    
    public Class acceptEventClass()
    {
      return qje.a.class;
    }
  }
  
  static class b
    extends QQUIEventReceiver<StoryPickerFragment, pxg.b>
  {
    public b(@NonNull StoryPickerFragment paramStoryPickerFragment)
    {
      super();
    }
    
    public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull pxg.b paramb)
    {
      boolean bool1 = false;
      if (!TextUtils.equals(paramStoryPickerFragment.ayc, paramb.context)) {
        return;
      }
      boolean bool2 = paramb.b.isSuccess();
      Object localObject = new ArrayList(paramb.mL.size());
      List localList = paramb.mL;
      int i = 0;
      while (i < localList.size())
      {
        VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)localList.get(i);
        if (localVideoCollectionItem.collectionType == 1)
        {
          int j = 0;
          if (j < localVideoCollectionItem.collectionVideoUIItemList.size())
          {
            VideoCollectionItem.b localb = (VideoCollectionItem.b)localVideoCollectionItem.collectionVideoUIItemList.get(j);
            if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localb.mVid))
            {
              localb.checked = true;
              if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
                localb.aFx = true;
              }
            }
            for (;;)
            {
              j += 1;
              break;
              localb.checked = false;
              if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.size() >= 20) {
                localb.aFx = false;
              } else {
                localb.aFx = true;
              }
            }
          }
          ((List)localObject).add(localVideoCollectionItem);
        }
        i += 1;
      }
      if ((bool2) && (paramb.isUpdated))
      {
        if (!((List)localObject).isEmpty()) {
          break label327;
        }
        paramStoryPickerFragment.or.setVisibility(0);
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
        if (!paramb.isFirstPage) {
          break label347;
        }
        paramStoryPickerFragment.jdField_a_of_type_Qqo.setData((List)localObject);
      }
      for (;;)
      {
        if (paramb.isFirstPage) {
          paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.pn(bool2);
        }
        localObject = paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.a;
        if (!paramb.isEnd) {
          bool1 = true;
        }
        ((rsn)localObject).ax(bool2, bool1);
        paramStoryPickerFragment.stopTitleProgress();
        return;
        label327:
        paramStoryPickerFragment.or.setVisibility(8);
        paramStoryPickerFragment.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
        break;
        label347:
        paramStoryPickerFragment.jdField_a_of_type_Qqo.ca((List)localObject);
      }
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
  }
  
  static class c
    extends QQUIEventReceiver<StoryPickerFragment, pye.a>
  {
    public c(@NonNull StoryPickerFragment paramStoryPickerFragment)
    {
      super();
    }
    
    public void a(@NonNull StoryPickerFragment paramStoryPickerFragment, @NonNull pye.a parama)
    {
      ram.d(this.TAG, "GetSimpleInfoListEventReceiver. event=%s", parama.toString());
      if ((parama.b.isSuccess()) && (parama.nb != null) && (!parama.nb.isEmpty()))
      {
        Iterator localIterator = parama.nb.iterator();
        while (localIterator.hasNext())
        {
          VideoCollectionItem.b localb = (VideoCollectionItem.b)localIterator.next();
          if (paramStoryPickerFragment.jdField_a_of_type_JavaUtilLinkedHashSet.contains(localb.mVid)) {
            localb.checked = true;
          }
        }
        paramStoryPickerFragment.jdField_a_of_type_Qqo.l(parama.collectionId, parama.nb);
      }
    }
    
    public Class acceptEventClass()
    {
      return pye.a.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment
 * JD-Core Version:    0.7.0.1
 */