package com.tencent.biz.qqstory.storyHome.memory;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import anot;
import ausj;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.storyHome.memory.view.StoryMemoriesListView;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.os.MqqHandler;
import plr;
import ppf;
import qbc;
import qem;
import qqy;
import qrj;
import qtj;
import qtm;
import qty;
import qub;
import quc;
import quj;
import qye;
import ram;
import rar;
import riw;
import rnq;
import rpo;
import rpw;
import rsd;

public class StoryMemoriesFragment
  extends ReportV4Fragment
  implements View.OnClickListener, qye
{
  public static final String ayA;
  public static final String ayB;
  public static final String ayC = acfp.m(2131714911);
  public static final String ayr;
  public static final String ayw = acfp.m(2131714908);
  public static final String ayx = plr.asY + acfp.m(2131714914);
  public static final String ayy = acfp.m(2131714907);
  public static final String ayz = acfp.m(2131714920);
  private StoryInputBarView jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  public StoryMemoriesListView a;
  private qbc jdField_a_of_type_Qbc;
  private qty jdField_a_of_type_Qty;
  private boolean aEE;
  private boolean aFr;
  private ImageButton ab;
  private View mRootView;
  private View ou;
  private TextView xP;
  
  static
  {
    ayA = acfp.m(2131714919);
    ayB = acfp.m(2131714912);
    ayr = acfp.m(2131714918);
  }
  
  public static StoryMemoriesFragment a(int paramInt, String paramString)
  {
    StoryMemoriesFragment localStoryMemoriesFragment = new StoryMemoriesFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("union_id", paramString);
    localBundle.putInt("source", paramInt);
    localStoryMemoriesFragment.setArguments(localBundle);
    return localStoryMemoriesFragment;
  }
  
  public static String a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
      return "";
    case 1: 
      return "1";
    case 2: 
      if (paramBoolean1) {
        return "2";
      }
      return "6";
    case 3: 
      if (paramBoolean2) {
        return "4";
      }
      return "3";
    case 4: 
      return "5";
    case 5: 
      return "7";
    }
    return "8";
  }
  
  private int bg(String paramString)
  {
    if (TextUtils.equals(paramString, ayw)) {
      return 1;
    }
    if ((TextUtils.equals(paramString, ayx)) || (TextUtils.equals(paramString, ayy))) {
      return 2;
    }
    if ((TextUtils.equals(paramString, ayz)) || (TextUtils.equals(paramString, ayA))) {
      return 3;
    }
    if (TextUtils.equals(paramString, ayB)) {
      return 4;
    }
    if (TextUtils.equals(paramString, ayr)) {
      return 5;
    }
    if (TextUtils.equals(paramString, getString(2131721058))) {
      return 7;
    }
    if (TextUtils.equals(paramString, ayC)) {
      return 8;
    }
    throw new IllegalArgumentException("get action id with unidentifiable action content.");
  }
  
  private void bpz()
  {
    ausj localausj = ausj.b(getActivity());
    if (this.jdField_a_of_type_Qty.mUserUIItem.isMe())
    {
      localausj.addButton(ayC, 5);
      localausj.addButton(ayw, 5);
      localausj.addButton(ayx, 5);
    }
    for (;;)
    {
      localausj.addCancelButton(2131721058);
      localausj.a(new qtj(this, localausj));
      if (!localausj.isShowing()) {
        localausj.show();
      }
      return;
      if (!this.jdField_a_of_type_Qty.mUserUIItem.isFriend()) {
        break;
      }
      localausj.addButton(ayC, 5);
      localausj.addButton(ayB, 5);
      localausj.addButton(ayy, 5);
      localausj.addButton(ayr, 5);
    }
    if (quc.a(this.jdField_a_of_type_Qty.mUserUIItem)) {
      localausj.addButton(ayz, 5);
    }
    for (;;)
    {
      localausj.addButton(ayC, 5);
      localausj.addButton(ayr, 5);
      break;
      if (this.jdField_a_of_type_Qty.mUserUIItem.isSubscribe()) {
        localausj.addButton(ayA, 5);
      }
    }
  }
  
  private void bqA()
  {
    Intent localIntent = new Intent(getActivity(), StoryMessageListActivity.class);
    localIntent.putExtra("qqstory_message_list_source", 1);
    localIntent.putExtra("qqstory_jump_source", "3");
    localIntent.putExtra("leftViewText", acfp.m(2131714913));
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131714905));
    startActivity(localIntent);
  }
  
  private void bqB()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryShieldActivity.class);
    localIntent.putExtra("uin", String.valueOf(this.jdField_a_of_type_Qty.mUserUIItem.qq));
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", acfp.m(2131714903));
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131714902));
    startActivity(localIntent);
  }
  
  private void bqC()
  {
    Intent localIntent = new Intent(getActivity(), QQStoryFriendSettings.class);
    localIntent.putExtra("from", 2);
    localIntent.putExtra("leftViewText", acfp.m(2131714915));
    localIntent.putExtra("selfSet_leftViewText", acfp.m(2131714917));
    startActivity(localIntent);
  }
  
  public static int dX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1000: 
      return 1;
    case 1002: 
      return 4;
    }
    return 3;
  }
  
  public boolean KA()
  {
    if (ShortVideoUtils.awI()) {}
    do
    {
      return true;
      ShortVideoUtils.B(qem.getQQAppInterface());
    } while (ShortVideoUtils.awI());
    return false;
  }
  
  public boolean Kh()
  {
    return getActivity().isResume();
  }
  
  public boolean Kz()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView != null) && (this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getVisibility() == 0))
    {
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.getWindowToken(), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.clearFocus();
      this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setVisibility(8);
      bqz();
      return true;
    }
    return false;
  }
  
  public StoryInputBarView a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView;
  }
  
  public rsd a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.a(paramString);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    paramString = rnq.a();
    if (paramString.isSupport())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("entrance_type", paramInt);
      paramString.a(getActivity(), localBundle, 1200);
      getActivity().overridePendingTransition(2130772306, 2130772079);
      return;
    }
    long l = SystemClock.uptimeMillis();
    boolean bool;
    if ((!paramBoolean2) || (KA()))
    {
      bool = true;
      paramString = new qqy(qem.getQQAppInterface()).a(getActivity(), paramBoolean1, bool);
      paramString.putExtra("entrance_type", paramInt);
      if (!bool) {
        break label223;
      }
      paramString.putExtra("extra_memories_from", this.jdField_a_of_type_Qty.mFrom);
      paramString.putExtra("extra_now_tab", ppf.IC());
      paramString.putExtra("start_origin", 3);
      paramString.putExtra("start_time", l);
      startActivityForResult(paramString, 1200);
      if (!paramBoolean2) {
        break label211;
      }
      getActivity().overridePendingTransition(2130772306, 2130772079);
    }
    for (;;)
    {
      ram.d("Q.qqstory.memories.StoryMemoriesFragment", "launchNewVideoTakeActivity end");
      this.aEE = true;
      return;
      bool = false;
      break;
      label211:
      getActivity().overridePendingTransition(0, 0);
    }
    label223:
    startActivityForResult(paramString, 20001);
  }
  
  public void bpI()
  {
    this.ab.setVisibility(8);
  }
  
  public void bpJ()
  {
    ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.3(this), 300L);
  }
  
  public void bqw()
  {
    if (this.ou == null) {
      return;
    }
    QQUserUIItem localQQUserUIItem = this.jdField_a_of_type_Qty.mUserUIItem;
    if ((localQQUserUIItem != null) && (localQQUserUIItem.sourceTagType == 1))
    {
      this.ou.setVisibility(0);
      bqx();
      rar.a("weishi_share", "person_data_exp", 0, 0, new String[] { "", this.jdField_a_of_type_Qty.mUserUIItem.uid });
      anot.a(null, "dc00898", "", "", "weishi_share_prof", "story_entry_exp", 0, 0, "", "", "", "");
      return;
    }
    this.ou.setVisibility(8);
  }
  
  public void bqx()
  {
    boolean bool = rpw.isWeishiInstalled(getActivity());
    if (bool != this.aFr)
    {
      this.aFr = bool;
      String str = acfp.m(2131714910);
      if (bool) {
        str = acfp.m(2131714909);
      }
      this.xP.setText(str);
    }
  }
  
  public void bqy()
  {
    quj localquj = (quj)a("MemoriesProfileSegment");
    if (localquj != null) {
      localquj.to(true);
    }
  }
  
  public void bqz()
  {
    if ((this.jdField_a_of_type_Qty.mUserUIItem != null) && (this.jdField_a_of_type_Qty.mUserUIItem.isMe()))
    {
      this.ab.setVisibility(0);
      this.ab.setOnClickListener(this);
      return;
    }
    this.ab.setVisibility(8);
    this.ab.setOnClickListener(null);
  }
  
  public void d(QQUserUIItem paramQQUserUIItem)
  {
    Intent localIntent = new Intent(getActivity(), FriendProfileCardActivity.class);
    localIntent.putExtra("AllInOne", new ProfileActivity.AllInOne(paramQQUserUIItem.qq, 59));
    startActivity(localIntent);
  }
  
  protected void initView()
  {
    Object localObject = new rpo(getActivity(), 155);
    ((rpo)localObject).u(this.mRootView);
    ((rpo)localObject).aw(false, false);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setOnScrollListener(new qtm(this, (rpo)localObject));
    if (QQStoryContext.a().eU(this.jdField_a_of_type_Qty.mUid)) {}
    for (localObject = new qub(getActivity(), this.jdField_a_of_type_Qty.mFrom, this.jdField_a_of_type_Qty.mUid, qub.boc, this);; localObject = new qub(getActivity(), this.jdField_a_of_type_Qty.mFrom, this.jdField_a_of_type_Qty.mUid, qub.bod, this))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setConfig((qub)localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.onCreate();
      if (this.jdField_a_of_type_Qty.mUserUIItem != null)
      {
        su();
        bqy();
        bqz();
      }
      return;
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Qty.create();
    if (quc.fp(this.jdField_a_of_type_Qty.mUid)) {
      initView();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.setContentBackground(2130839637);
    if ((this.jdField_a_of_type_Qty.mFrom == 2) && (FrameHelperActivity.ZW()))
    {
      FrameHelperActivity.EO(true);
      FrameHelperActivity.cuA();
    }
    bqw();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {
      ram.e("Q.qqstory.memories.StoryMemoriesFragment", "onActivityResult, data is null.");
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      switch (paramInt1)
      {
      default: 
        if (this.jdField_a_of_type_Qbc != null)
        {
          this.jdField_a_of_type_Qbc.onActivityResult(paramInt1, paramInt2, paramIntent);
          return;
        }
        break;
      case 20001: 
        b(false, false, paramIntent.getIntExtra("entrance_type", 99), null);
        return;
      case 1200: 
      case 1300: 
      case 20002: 
        paramIntent = paramIntent.getStringExtra("new_video_extra_info");
        Intent localIntent;
        if (ppf.IC())
        {
          localIntent = new Intent(getActivity(), SplashActivity.class);
          localIntent.putExtra("fragment_id", 1);
          localIntent.putExtra("main_tab_id", 6);
          localIntent.putExtra("open_now_tab_fragment", true);
          localIntent.putExtra("extra_from_share", true);
          localIntent.putExtra("new_video_extra_info", paramIntent);
          localIntent.setFlags(335544320);
          startActivity(localIntent);
        }
        for (;;)
        {
          getActivity().finish();
          getActivity().overridePendingTransition(0, 0);
          return;
          localIntent = new Intent(getActivity(), QQStoryMainActivity.class);
          localIntent.putExtra("new_video_extra_info", paramIntent);
          startActivity(localIntent);
        }
      case 20004: 
        qrj.a(this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.b, paramIntent);
        ThreadManager.getUIHandler().postDelayed(new StoryMemoriesFragment.1(this), 100L);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView == null);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView)
  {
    int i = 4;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bqx();
      if (this.aFr)
      {
        rpw.p(getActivity(), "biz_src_jc_hyws", this.jdField_a_of_type_Qty.mUserUIItem.wsScahema);
        label95:
        if (!this.aFr) {
          break label207;
        }
        i = 2;
        label104:
        rar.a("weishi_share", "person_data_clk", 0, i, new String[] { "", this.jdField_a_of_type_Qty.mUserUIItem.uid });
        if (!this.aFr) {
          break label212;
        }
      }
      label207:
      label212:
      for (Object localObject = "story_clk_ws";; localObject = "story_dl_ws")
      {
        anot.a(null, "dc00898", "", "", "weishi_share_prof", (String)localObject, 0, 0, "", "", "", "");
        break;
        QQToast.a(getActivity(), acfp.m(2131714906), 0).show();
        rpw.aU(getActivity(), "biz_src_jc_hyws");
        break label95;
        i = 1;
        break label104;
      }
      if (this.jdField_a_of_type_Qty.mFrom == 2) {}
      for (;;)
      {
        b(false, true, i, null);
        rar.a("memory", "clk_shoot", dX(this.jdField_a_of_type_Qty.mFrom), 0, new String[0]);
        break;
        i = 3;
      }
      if (ppf.IC()) {}
      for (i = 1;; i = 0)
      {
        ram.d("Q.qqstory.memories.StoryMemoriesFragment", "startStoryMainActivity, isNowTabShow==%d", Integer.valueOf(i));
        localObject = new Intent(getActivity(), QQStoryMainActivity.class);
        ((Intent)localObject).putExtra("from_memeories", true);
        ((Intent)localObject).putExtra("leftViewText", acfp.m(2131714916));
        ((Intent)localObject).putExtra("selfSet_leftViewText", acfp.m(2131714904));
        startActivity((Intent)localObject);
        rar.a("memory", "enter_story", dX(this.jdField_a_of_type_Qty.mFrom), 0, new String[] { "", "", "", "" });
        this.aEE = true;
        break;
      }
      bpz();
      i = dX(this.jdField_a_of_type_Qty.mFrom);
      if (this.jdField_a_of_type_Qty.mUserUIItem.isMe()) {}
      for (localObject = "1";; localObject = "2")
      {
        rar.a("memory", "clk_more", i, 0, new String[] { localObject });
        break;
      }
      getActivity().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Qty = new qty(paramBundle.getInt("source", 1), paramBundle.getString("union_id"), this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = paramLayoutInflater.inflate(2131561887, paramViewGroup, false);
    this.mRootView.setFitsSystemWindows(true);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView = ((StoryMemoriesListView)this.mRootView.findViewById(2131371260));
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = ((StoryInputBarView)this.mRootView.findViewById(2131371259));
    this.ab = ((ImageButton)this.mRootView.findViewById(2131371263));
    this.xP = ((TextView)this.mRootView.findViewById(2131379473));
    this.ou = this.mRootView.findViewById(2131364669);
    paramLayoutInflater = (TextView)this.mRootView.findViewById(2131369579);
    this.ou.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.onDestroy();
    }
    this.jdField_a_of_type_Qty.destroy();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.destroy();
    this.mRootView.setFitsSystemWindows(false);
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.hide();
    bqz();
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.aEE)
    {
      this.aEE = false;
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.brD();
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewStoryMemoriesListView.onResume();
    }
    Object localObject = this.jdField_a_of_type_Qty.mUserUIItem;
    int i = dX(this.jdField_a_of_type_Qty.mFrom);
    int j = ppf.getInteger(2131427369);
    String str;
    if ((localObject != null) && (((QQUserUIItem)localObject).isMe()))
    {
      str = "1";
      if ((localObject == null) || (!((QQUserUIItem)localObject).isVip())) {
        break label138;
      }
    }
    label138:
    for (localObject = "1";; localObject = "2")
    {
      rar.a("memory", "exp", i, j, new String[] { str, localObject, "", "" });
      return;
      str = "2";
      break;
    }
  }
  
  public void su()
  {
    if (getActivity() == null)
    {
      ram.e("Q.qqstory.memories.StoryMemoriesFragment", "update title bar failed because activity is null.");
      return;
    }
    ImageView localImageView = (ImageView)getActivity().findViewById(2131369594);
    TextView localTextView1 = (TextView)getActivity().findViewById(2131369612);
    TextView localTextView2 = (TextView)getActivity().findViewById(2131369627);
    localTextView1.setGravity(16);
    if (this.jdField_a_of_type_Qty.mFrom == 2)
    {
      localImageView.setVisibility(8);
      localTextView1.setVisibility(0);
      localTextView1.setText(2131701750);
      localTextView1.setOnClickListener(this);
      return;
    }
    localTextView2.setText(qem.getNickName(this.jdField_a_of_type_Qty.mUserUIItem.uid));
    localTextView1.setVisibility(8);
    localImageView.setVisibility(0);
    localImageView.setContentDescription(acfp.m(2131714921));
    localImageView.getLayoutParams().width = -2;
    localImageView.setPadding(0, 0, riw.dip2px(getActivity(), 5.0F), 0);
    localImageView.setOnClickListener(this);
  }
  
  public void te(boolean paramBoolean) {}
  
  public void tf(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment
 * JD-Core Version:    0.7.0.1
 */