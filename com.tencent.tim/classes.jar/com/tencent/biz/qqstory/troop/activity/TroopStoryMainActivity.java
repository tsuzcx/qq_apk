package com.tencent.biz.qqstory.troop.activity;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.view.widget.FullScreenEmptyView;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Map;
import mqq.os.MqqHandler;
import psx;
import qrj;
import qvf;
import qye;
import rsd;

public class TroopStoryMainActivity
  extends QQStoryBaseActivity
  implements qye
{
  public static final String TAG = TroopStoryMainActivity.class.getName();
  protected StoryInputBarView a;
  public TroopStoryListView a;
  public FullScreenEmptyView a;
  public qvf a;
  protected Runnable dw = new TroopStoryMainActivity.1(this);
  
  public static void bg(Activity paramActivity)
  {
    paramActivity.startActivity(new Intent(paramActivity, TroopStoryMainActivity.class));
  }
  
  public boolean Kh()
  {
    return isResume();
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public rsd a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(paramString);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString) {}
  
  public void bpI() {}
  
  public void bpJ() {}
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0)
    {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mUseOptimizMode = true;
    super.doOnCreate(paramBundle);
    super.setContentView(2131561985);
    super.setTitle(acfp.m(2131716148));
    this.jdField_a_of_type_Qvf = ((qvf)psx.a(11));
    this.jdField_a_of_type_Qvf.gb.clear();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)super.findViewById(2131375191));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView = ((TroopStoryListView)super.findViewById(2131370584));
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.a(this, this);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setDivider(null);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setContentBackground(2130839637);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.getParent()).setBackgroundColor(getResources().getColor(2131167363));
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView = new FullScreenEmptyView(this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView.setVisibility(8);
    ((ViewGroup)this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.getParent()).addView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.setEmptyView(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetFullScreenEmptyView);
    this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.onCreate();
    this.rightViewText.setVisibility(8);
    this.rightViewImg.setVisibility(8);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.onDestroy();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.destroy();
    this.jdField_a_of_type_Qvf.gb.clear();
    ThreadManager.getUIHandler().removeCallbacks(this.dw);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.onPause();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.onResume();
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.azy();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTroopActivityTroopStoryListView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 == -1) {}
    switch (paramInt1)
    {
    default: 
      return;
    }
    qrj.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.b, paramIntent);
    ThreadManager.getUIHandler().postDelayed(this.dw, 100L);
  }
  
  public void te(boolean paramBoolean) {}
  
  public void tf(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.activity.TroopStoryMainActivity
 * JD-Core Version:    0.7.0.1
 */