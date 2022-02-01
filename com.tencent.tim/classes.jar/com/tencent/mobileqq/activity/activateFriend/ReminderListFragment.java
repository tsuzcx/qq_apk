package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqiw;
import aqmr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.c;
import com.tencent.mobileqq.extendfriend.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import whn;
import whv;
import whw;
import whx;
import why;
import wia;
import wib;
import wih;
import wii;
import wim;
import wja;

public class ReminderListFragment
  extends PublicBaseFragment
  implements PullToRefreshBase.c<RecyclerView>
{
  private static final String TAG = ReminderListFragment.class.getSimpleName();
  long HH;
  private TextView HJ;
  private a jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$a;
  private PullToRefreshRecyclerView jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView;
  private String aSj;
  private int bNr;
  private int bNs;
  private boolean bcr;
  private boolean bcs;
  private boolean bct;
  private boolean hasMore = true;
  private RelativeLayout hn;
  private QQAppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private PopupWindow mPopupWindow;
  private RecyclerView mRecyclerView;
  private wii mReminderDataManager;
  private TextView mTitleView;
  private ImageView rW;
  
  private void BY(int paramInt)
  {
    if (paramInt == 0)
    {
      this.bcr = false;
      this.bcs = false;
      this.bNr = 0;
    }
    if (!this.hasMore)
    {
      showToast(acfp.m(2131713872));
      this.mHandler.post(new ReminderListFragment.8(this));
      return;
    }
    wih.a(paramInt, 10, new wib(this, paramInt));
  }
  
  private boolean QY()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Intent localIntent = getActivity().getIntent();
    if (localIntent != null)
    {
      bool1 = bool2;
      if (!aqmr.isEmpty(localIntent.getStringExtra("notice_time"))) {
        bool1 = true;
      }
      this.bct = bool1;
      if (this.bct) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setMode(PullToRefreshBase.Mode.DISABLED);
      }
      bool1 = this.bct;
    }
    return bool1;
  }
  
  public static void bx(Activity paramActivity)
  {
    PublicFragmentActivity.b.startForResult(paramActivity, new Intent(paramActivity, ReminderListFragment.class), PublicFragmentActivity.class, ReminderListFragment.class, 2000);
  }
  
  private void c(AcsMsg paramAcsMsg)
  {
    if (paramAcsMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "---deleMsg--- acsMsg is null");
      }
      showToast(acfp.m(2131713864));
      return;
    }
    String str = paramAcsMsg.msg_id;
    wih.a(str, new why(this, paramAcsMsg, str));
  }
  
  private void c(ArrayList<AcsMsg> paramArrayList, ArrayList<wim> paramArrayList1, boolean paramBoolean)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      AcsMsg localAcsMsg = (AcsMsg)paramArrayList.next();
      wim localwim = new wim();
      localwim.d = localAcsMsg;
      if (localAcsMsg.notice_time * 1000L >= this.HH)
      {
        localwim.type = 0;
        if (!this.bcr)
        {
          localwim.title = acfp.m(2131713870);
          this.bcr = true;
        }
      }
      for (;;)
      {
        paramArrayList1.add(localwim);
        break;
        localwim.type = 1;
        if (!this.bcs)
        {
          localwim.title = acfp.m(2131713875);
          this.bcs = true;
        }
      }
    }
    this.mHandler.post(new ReminderListFragment.7(this, paramArrayList1, paramBoolean));
  }
  
  private View e(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561171, paramViewGroup, false);
    this.hn = ((RelativeLayout)paramLayoutInflater.findViewById(2131364298));
    this.rW = ((ImageView)paramLayoutInflater.findViewById(2131366439));
    this.mTitleView = ((TextView)paramLayoutInflater.findViewById(2131369627));
    this.mTitleView.setText(getResources().getString(2131689680));
    this.HJ = ((TextView)paramLayoutInflater.findViewById(2131369579));
    this.HJ.setOnClickListener(new whv(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131373844));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.setOnRefreshListener(this);
    this.mRecyclerView = ((RecyclerView)this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshExtrasPullToRefreshRecyclerView.bX());
    this.mRecyclerView.setId(2131376994);
    this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.mRecyclerView.addItemDecoration(new b(null));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$a = new a(null);
    this.mRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$a);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendReminderListFragment$a.notifyDataSetChanged();
    if (this.mPopupWindow == null) {
      this.mPopupWindow = new PopupWindow(h(getActivity()), -1, -1);
    }
    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable());
    this.mPopupWindow.setOutsideTouchable(true);
    this.mPopupWindow.setFocusable(true);
    return paramLayoutInflater;
  }
  
  private QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void getList()
  {
    if (!aqiw.isNetworkAvailable(getActivity()))
    {
      showToast(acfp.m(2131713867));
      if (this.bNs == 0) {
        showEmptyView();
      }
      return;
    }
    if (QY())
    {
      String str = getActivity().getIntent().getStringExtra("notice_time");
      try
      {
        xh(whn.h(Long.parseLong(str) * 1000L, "yyyyMMdd"));
        return;
      }
      catch (Exception localException)
      {
        this.bNs = 0;
        this.bNr = 0;
        this.hasMore = true;
        BY(this.bNs);
        return;
      }
    }
    this.bNs = 0;
    this.bNr = 0;
    this.hasMore = true;
    BY(this.bNs);
  }
  
  private View h(Context paramContext)
  {
    FrameLayout localFrameLayout = new FrameLayout(paramContext);
    localFrameLayout.setOnClickListener(new whw(this));
    localFrameLayout.setBackgroundColor(Color.parseColor("#1A000000"));
    Button localButton = new Button(paramContext);
    localButton.setText(acfp.m(2131713871));
    localButton.setTextColor(Color.parseColor("#000000"));
    localButton.setTextSize(1, 16.0F);
    localButton.setBackgroundDrawable(paramContext.getResources().getDrawable(2130845642));
    localButton.setOnClickListener(new whx(this));
    localFrameLayout.addView(localButton);
    paramContext = (FrameLayout.LayoutParams)localButton.getLayoutParams();
    paramContext.width = wja.dp2px(80.0F, getResources());
    paramContext.height = -2;
    paramContext.gravity = 53;
    return localFrameLayout;
  }
  
  private void handleBack()
  {
    if (getActivity() != null)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("msg_id", this.aSj);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
    }
  }
  
  private void initData()
  {
    this.mApp = getApp();
    this.mReminderDataManager = new wii(this.mApp);
    wih.e(this.mApp);
    getList();
  }
  
  public static void launch(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ReminderListFragment.class);
    localIntent.putExtra("notice_time", paramString);
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivity.class, ReminderListFragment.class);
  }
  
  private void showEmptyView()
  {
    this.mHandler.post(new ReminderListFragment.4(this));
  }
  
  private void showToast(String paramString)
  {
    this.mHandler.post(new ReminderListFragment.10(this, paramString));
  }
  
  private void xh(String paramString)
  {
    this.mReminderDataManager.a(paramString, new wia(this));
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "----onPullDownToRefresh----");
    }
    getList();
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "----onPullUpToRefresh----");
    }
    if (!this.bct) {
      BY(this.bNs);
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      handleBack();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = e(paramLayoutInflater, paramViewGroup);
    initData();
    this.HH = NetConnInfoCenter.getServerTimeMillis();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mHandler != null) {
      this.mHandler.removeCallbacksAndMessages(null);
    }
    wih.clear();
  }
  
  class a
    extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  {
    private ArrayList<wim> qa = new ArrayList();
    
    private a() {}
    
    public int getItemCount()
    {
      if ((this.qa == null) || (this.qa.isEmpty())) {
        return 0;
      }
      return this.qa.size();
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if ((paramViewHolder instanceof ReminderListFragment.c))
      {
        ReminderListFragment.c localc = (ReminderListFragment.c)paramViewHolder;
        if ((this.qa != null) && (!this.qa.isEmpty())) {
          localc.a((wim)this.qa.get(paramInt));
        }
      }
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
    }
    
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      paramViewGroup = (ViewGroup)LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561172, null, false);
      return new ReminderListFragment.c(ReminderListFragment.this, paramViewGroup);
    }
    
    public void w(ArrayList<wim> paramArrayList, boolean paramBoolean)
    {
      if (paramBoolean) {
        this.qa.clear();
      }
      this.qa.addAll(paramArrayList);
      notifyDataSetChanged();
    }
    
    public void xi(String paramString)
    {
      if ((this.qa == null) || (this.qa.isEmpty())) {
        return;
      }
      int j = 0;
      wim localwim;
      int i;
      if (j < this.qa.size())
      {
        localwim = (wim)this.qa.get(j);
        if (paramString.equals(localwim.d.msg_id))
        {
          i = j;
          if (!aqmr.isEmpty(localwim.title))
          {
            i = j;
            if (j + 1 < this.qa.size())
            {
              if ((localwim.type != 1) || (((wim)this.qa.get(j + 1)).type != 1)) {
                break label206;
              }
              ((wim)this.qa.get(j + 1)).title = acfp.m(2131713876);
              i = j;
            }
          }
        }
      }
      for (;;)
      {
        j = i;
        if (i == this.qa.size()) {
          j = i - 1;
        }
        this.qa.remove(j);
        notifyItemRemoved(j);
        notifyItemRangeChanged(j, this.qa.size());
        if (getItemCount() == 0) {
          ReminderListFragment.b(ReminderListFragment.this);
        }
        ReminderListFragment.a(ReminderListFragment.this, paramString);
        return;
        label206:
        i = j;
        if (localwim.type == 0)
        {
          i = j;
          if (((wim)this.qa.get(j + 1)).type == 0)
          {
            ((wim)this.qa.get(j + 1)).title = acfp.m(2131713865);
            i = j;
            continue;
            j += 1;
            break;
            i = 0;
          }
        }
      }
    }
  }
  
  class b
    extends RecyclerView.ItemDecoration
  {
    private b() {}
    
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      super.getItemOffsets(paramRect, paramView, paramRecyclerView, paramState);
      paramRect.left = wja.dp2px(16.0F, ReminderListFragment.this.getResources());
      paramRect.right = wja.dp2px(16.0F, ReminderListFragment.this.getResources());
      int i = paramRecyclerView.getChildAdapterPosition(paramView);
      int j = ReminderListFragment.a(ReminderListFragment.this).getItemCount();
      if (QLog.isColorLevel()) {
        QLog.i(ReminderListFragment.el(), 2, "position: " + i + ", totalCnt: " + j);
      }
      paramRect.top = wja.dp2px(12.0F, ReminderListFragment.this.getResources());
      if (i == j - 1) {
        paramRect.bottom = wja.dp2px(12.0F, ReminderListFragment.this.getResources());
      }
    }
  }
  
  class c
    extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    TextView HK;
    TextView HL;
    TextView HM;
    FrameLayout aZ;
    RelativeLayout hp;
    RelativeLayout hq;
    ImageView rX;
    ImageView rY;
    
    public c(View paramView)
    {
      super();
      this.hp = ((RelativeLayout)paramView.findViewById(2131377114));
      this.hq = ((RelativeLayout)paramView.findViewById(2131377113));
      this.hq.setOnClickListener(this);
      this.HM = ((TextView)paramView.findViewById(2131377118));
      this.rY = ((ImageView)paramView.findViewById(2131377115));
      this.HK = ((TextView)paramView.findViewById(2131370559));
      this.HL = ((TextView)paramView.findViewById(2131370558));
      this.rX = ((ImageView)paramView.findViewById(2131377116));
      this.aZ = ((FrameLayout)paramView.findViewById(2131377117));
      this.aZ.setOnClickListener(this);
    }
    
    private void a(View paramView, AcsMsg paramAcsMsg)
    {
      if ((paramView instanceof FrameLayout))
      {
        paramView = ((FrameLayout)paramView).getChildAt(0);
        if ((paramView instanceof Button))
        {
          paramView = (Button)paramView;
          paramView.setTag(paramAcsMsg);
          paramView = (FrameLayout.LayoutParams)paramView.getLayoutParams();
          paramAcsMsg = new Rect();
          this.rX.getLocalVisibleRect(paramAcsMsg);
          paramView.rightMargin = paramAcsMsg.right;
          this.rX.getGlobalVisibleRect(paramAcsMsg);
          paramView.topMargin = (paramAcsMsg.top - paramView.width);
        }
      }
    }
    
    public void a(wim paramwim)
    {
      this.aZ.setTag(paramwim.d);
      this.HK.setText(paramwim.d.title);
      this.hq.setTag(paramwim.d.jump_url);
      Object localObject1 = paramwim.d.busi_icon;
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.rY.getHeight();
      ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.rY.getWidth();
      localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      if (localObject1 != null) {
        this.rY.setImageDrawable((Drawable)localObject1);
      }
      String str = whn.h(paramwim.d.notice_time * 1000L, "yyyy.MM.dd");
      localObject2 = whn.h(paramwim.d.notice_time * 1000L, "HH:mm");
      localObject1 = localObject2;
      if (paramwim.type == 0) {
        localObject1 = (String)localObject2 + "　　　开启时提醒";
      }
      localObject1 = str + "　　　" + (String)localObject1;
      this.HL.setText((CharSequence)localObject1);
      localObject1 = this.HM;
      if (!aqmr.isEmpty(paramwim.title))
      {
        ((TextView)localObject1).setText(paramwim.title);
        ((TextView)localObject1).setVisibility(0);
        return;
      }
      ((TextView)localObject1).setVisibility(8);
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!aqmr.isEmpty((String)paramView.getTag()))
        {
          Intent localIntent = new Intent(ReminderListFragment.this.getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", (String)paramView.getTag());
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          ReminderListFragment.this.startActivity(localIntent);
          continue;
          if (ReminderListFragment.a(ReminderListFragment.this) != null)
          {
            a(ReminderListFragment.a(ReminderListFragment.this).getContentView(), (AcsMsg)this.aZ.getTag());
            ReminderListFragment.a(ReminderListFragment.this).showAtLocation(ReminderListFragment.a(ReminderListFragment.this), 17, 0, 0);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ReminderListFragment
 * JD-Core Version:    0.7.0.1
 */