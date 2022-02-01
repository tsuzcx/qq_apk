package com.tencent.biz.qqstory.storyHome.memory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesReloadListView;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView.a;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import quc;
import qud;
import qud.a;
import ram;
import rar;

public class QQStoryMemoriesActivity
  extends QQStoryBaseActivity
  implements QQStoryPullToRefreshListView.a, qud.a
{
  private long Bl;
  private StoryMemoriesFragment jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment;
  private StoryMemoriesReloadListView jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView;
  private qud jdField_a_of_type_Qud;
  private int mFrom;
  private String mUid;
  
  private void E(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_Qud.sb(paramString);
      return;
    }
    this.jdField_a_of_type_Qud.fn(paramLong);
  }
  
  public static Intent a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, null, paramLong, true);
  }
  
  private static Intent a(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    if ((paramLong <= 0L) && (TextUtils.isEmpty(paramString))) {
      throw new IllegalArgumentException("start MemoriesActivity with illegal argument: uid = " + paramString + ", qq = " + paramLong);
    }
    int i;
    if (paramBoolean)
    {
      if ((!TextUtils.isEmpty(paramString)) || (!QQStoryContext.a().eV(String.valueOf(paramLong)))) {
        break label233;
      }
      i = 1;
    }
    for (;;)
    {
      rar.a("memory", "clk_entry", paramInt, 0, new String[] { i + "", "", "", "" });
      i = paramInt;
      if ((paramContext instanceof SplashActivity))
      {
        i = paramInt;
        switch (paramInt)
        {
        default: 
          i = paramInt;
        }
      }
      for (;;)
      {
        Intent localIntent = new Intent(paramContext, QQStoryMemoriesActivity.class);
        localIntent.putExtra("source", i);
        localIntent.putExtra("qq_number", paramLong);
        localIntent.putExtra("union_id", paramString);
        if (!(paramContext instanceof Activity)) {
          localIntent.addFlags(268435456);
        }
        return localIntent;
        label233:
        if (!QQStoryContext.a().eU(paramString)) {
          break label273;
        }
        i = 1;
        break;
        i = 1000;
        continue;
        i = 1001;
        continue;
        i = 1002;
      }
      label273:
      i = 2;
    }
  }
  
  private static void a(Context paramContext, int paramInt, String paramString, long paramLong, boolean paramBoolean)
  {
    paramContext.startActivity(a(paramContext, paramInt, paramString, paramLong, paramBoolean));
  }
  
  public static void a(Context paramContext, int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramContext, paramInt, paramString, -1L, paramBoolean);
  }
  
  public static Intent b(Context paramContext, int paramInt, String paramString)
  {
    return a(paramContext, paramInt, paramString, -1L, true);
  }
  
  private void bqv()
  {
    View localView1 = findViewById(2131370820);
    View localView2 = findViewById(2131375199);
    localView1.setVisibility(8);
    if (localView2 != null)
    {
      ram.d("Q.qqstory.memories.QQStoryMemoriesActivity", "get invalid uid. inflate reload list.");
      ((ViewStub)localView2).inflate();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView = ((StoryMemoriesReloadListView)findViewById(2131375198));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.bd(this);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.onCreate();
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.setPullToRefreshListener(this);
    }
  }
  
  public static void c(Context paramContext, int paramInt, long paramLong)
  {
    a(paramContext, paramInt, null, paramLong, true);
  }
  
  private void initData()
  {
    Intent localIntent = getIntent();
    this.mFrom = localIntent.getIntExtra("source", 1);
    this.Bl = localIntent.getLongExtra("qq_number", -1L);
    this.mUid = localIntent.getStringExtra("union_id");
    ram.w("Q.qqstory.memories.QQStoryMemoriesActivity", "get arguments. uid = %s, mQQ = %d, mFrom = %d.", new Object[] { this.mUid, Long.valueOf(this.Bl), Integer.valueOf(this.mFrom) });
    this.jdField_a_of_type_Qud = new qud();
    this.jdField_a_of_type_Qud.a(this);
    if (TextUtils.isEmpty(this.mUid))
    {
      this.jdField_a_of_type_Qud.fm(this.Bl);
      return;
    }
    if (!quc.fp(this.mUid))
    {
      E(this.Bl, this.mUid);
      return;
    }
    rY(this.mUid);
  }
  
  private void initView()
  {
    setContentViewNoTitle(2131561885);
  }
  
  private void rY(String paramString)
  {
    ram.b("Q.qqstory.memories.QQStoryMemoriesActivity", "get valid uid. start creating fragment. uid = %s.", paramString);
    findViewById(2131370820).setVisibility(8);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.setVisibility(8);
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment = StoryMemoriesFragment.a(this.mFrom, paramString);
    localFragmentTransaction.replace(2131365322, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment);
    localFragmentTransaction.commitAllowingStateLoss();
  }
  
  public void aB(String paramString, boolean paramBoolean)
  {
    if ((isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (isDestroyed())))
    {
      ram.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid back when activity has destroyed.");
      return;
    }
    if (quc.fp(this.mUid))
    {
      ram.e("Q.qqstory.memories.QQStoryMemoriesActivity", "uid is already valid on new uid back. current uid is %s, new uid is %s.", new Object[] { this.mUid, paramString });
      return;
    }
    ram.b("Q.qqstory.memories.QQStoryMemoriesActivity", "on uid back. uid = %s, fromNet = %s.", paramString, Boolean.valueOf(paramBoolean));
    if (quc.fp(paramString))
    {
      this.mUid = paramString;
      rY(this.mUid);
      return;
    }
    if (paramBoolean)
    {
      bqv();
      return;
    }
    E(this.Bl, this.mUid);
  }
  
  protected void bqu()
  {
    ImmersiveUtils.l(getActivity().getWindow());
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void doOnBackPressed()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment != null) {
      bool = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryStoryMemoriesFragment.Kz();
    }
    if (!bool) {
      super.doOnBackPressed();
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    this.mNeedStatusTrans = false;
    super.doOnCreate(paramBundle);
    initView();
    initData();
    return true;
  }
  
  public void doOnDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesReloadListView.onDestroy();
    }
    super.doOnDestroy();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    String str = Build.MANUFACTURER + Build.MODEL;
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.memories.QQStoryMemoriesActivity", 2, "MANUFACTURER = " + Build.MANUFACTURER + ", MODEL = " + Build.MODEL);
    }
    if ((str != null) && ((str.equals("MeizuPRO 7-S")) || (str.equalsIgnoreCase("MeizuM711C"))))
    {
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
      return;
    }
    bqu();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void finish()
  {
    super.finish();
  }
  
  public void pullToRefresh()
  {
    ram.b("Q.qqstory.memories.QQStoryMemoriesActivity", "pull to refresh. uid = %s, qq = %d.", this.mUid, Long.valueOf(this.Bl));
    E(this.Bl, this.mUid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity
 * JD-Core Version:    0.7.0.1
 */