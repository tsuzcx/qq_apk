package com.tencent.mobileqq.activity.contact.troop;

import acff;
import acnd;
import ahpp;
import ajdr;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import anot;
import aqdf;
import aqdf.a;
import arhz;
import com.tencent.biz.qqstory.widget.OverScrollRecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import yvp;
import yvx;
import yvy;
import yxc;
import yxd;
import yxe;
import yyp;
import yyq;
import yyr;
import yys;
import yyt;
import yyu;
import yyv;
import yyw;
import yyx;

public class TroopWithCommonFriendsFragment
  extends IphoneTitleBarFragment
  implements aqdf.a
{
  static int cbL;
  public static String mFriendUin = "";
  private arhz J;
  private ahpp jdField_a_of_type_Ahpp = new yyu(this);
  private OverScrollRecyclerView jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView;
  private yvp jdField_a_of_type_Yvp;
  protected yxd a;
  private acnd b;
  protected ajdr b;
  public int bPh;
  public aqdf d;
  View.OnClickListener ev = new yyr(this);
  View.OnClickListener ex = new yys(this);
  View.OnClickListener ey = new yyt(this);
  public MqqHandler g = new yyw(this);
  public BaseActivity k;
  private QQAppInterface mApp;
  public int mCurrentScrollState = 0;
  public List<yvy> mDataList = new ArrayList();
  public View yt;
  
  public TroopWithCommonFriendsFragment()
  {
    this.jdField_a_of_type_Yxd = new yxd();
    this.jdField_b_of_type_Acnd = new yyv(this);
  }
  
  private void J(ViewGroup paramViewGroup)
  {
    this.yt = LayoutInflater.from(getActivity()).inflate(2131560068, paramViewGroup, false);
    paramViewGroup = (ImageView)this.yt.findViewById(2131368952);
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20191206115411_QbbYvjs7gs.png", null);
    if ((localURLDrawable != null) && (1 != localURLDrawable.getStatus())) {
      localURLDrawable.restartDownload();
    }
    paramViewGroup.setImageDrawable(localURLDrawable);
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.mCurrentScrollState == 0)
    {
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < j)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(i);
        if ((localObject == null) || (!(localObject instanceof yxc))) {}
        yxc localyxc;
        do
        {
          i += 1;
          break;
          localyxc = (yxc)localObject;
          localObject = ((yxc)localObject).aZP;
        } while ((localyxc == null) || (!paramString.equals(localObject)));
        localyxc.uw.setImageBitmap(paramBitmap);
      }
    }
  }
  
  private void a(yvx paramyvx, yvy paramyvy, int paramInt)
  {
    yxc localyxc = (yxc)paramyvx;
    if ((paramyvy == null) || (paramyvy.mTroopUin.isEmpty()) || (paramyvy.b == null)) {
      return;
    }
    localyxc._id = paramInt;
    localyxc.nickname = paramyvy.b.troopname;
    localyxc.count = paramyvy.mCount;
    localyxc.aZP = paramyvy.mTroopUin;
    if (localyxc.nickname.isEmpty()) {
      localyxc.nickname = localyxc.aZP;
    }
    paramInt = localyxc.count;
    paramyvy = getString(2131701831);
    paramyvy = paramyvy + String.valueOf(paramInt) + getString(2131701830);
    String str1 = getString(2131701828);
    String str2 = getString(2131701829);
    if (yyx.ae(mFriendUin, localyxc.aZP))
    {
      localyxc.ej.setText(str1);
      localyxc.ej.setTextAppearance(this.k, 2131755597);
      localyxc.ej.setBackgroundResource(2130839559);
      localyxc.ej.setOnClickListener(this.ey);
    }
    for (;;)
    {
      localyxc.LW.setText(localyxc.nickname);
      localyxc.LX.setText(paramyvy);
      localyxc.ej.setTag(paramyvx);
      localyxc.LW.setTag(paramyvx);
      localyxc.hC.setTag(paramyvx);
      localyxc.uw.setTag(paramyvx);
      localyxc.LW.setOnClickListener(this.ex);
      localyxc.uw.setOnClickListener(this.ev);
      a(localyxc);
      return;
      localyxc.ej.setBackgroundDrawable(null);
      localyxc.ej.setText(str2);
      localyxc.ej.setClickable(false);
      localyxc.ej.setTextAppearance(this.k, 2131756687);
    }
  }
  
  private void a(yxc paramyxc)
  {
    if (paramyxc == null) {}
    do
    {
      return;
      localObject = paramyxc.aZP;
    } while (localObject == null);
    Object localObject = yxe.a(this.d, (String)localObject, 4);
    paramyxc.uw.setImageDrawable((Drawable)localObject);
  }
  
  public static void ac(Context paramContext, int paramInt)
  {
    cbL = paramInt;
    if (paramInt == 1) {
      anot.a(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 1, 0, "0", "0", "", "");
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 0, 0, "0", "0", "", "");
      PublicFragmentActivity.start(paramContext, new Intent(), TroopWithCommonFriendsFragment.class);
      return;
      if (paramInt == 2) {
        anot.a(null, "dc00898", "", "", "0X800AD25", "0X800AD25", 2, 0, "0", "0", "", "");
      }
    }
  }
  
  private void bpM()
  {
    if (this.mApp != null)
    {
      this.mApp.addObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.addObserver(this.jdField_b_of_type_Acnd);
    }
  }
  
  private void initAdapter()
  {
    this.jdField_a_of_type_Yvp = new yyq(this, getActivity(), 2131560069);
    this.jdField_a_of_type_Yvp.setEmptyView(this.yt);
    this.jdField_a_of_type_Yvp.a(2131561721);
  }
  
  private void initUI(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.J = new arhz(this.k, getTitleBarHeight());
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView = ((OverScrollRecyclerView)paramView.findViewById(2131365076));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.addOnScrollListener(new yyp(this));
    this.d = new aqdf(getActivity(), this.mApp);
    this.d.a(this);
  }
  
  private void removeObserver()
  {
    if (this.mApp != null)
    {
      this.mApp.removeObserver(this.jdField_a_of_type_Ahpp);
      this.mApp.removeObserver(this.jdField_b_of_type_Acnd);
    }
  }
  
  public static void zo(String paramString)
  {
    mFriendUin = paramString;
  }
  
  public String bd(long paramLong)
  {
    Friends localFriends = ((acff)this.mApp.getManager(51)).e(String.valueOf(paramLong));
    if (localFriends != null) {
      return localFriends.getFriendNickWithAlias();
    }
    return String.valueOf(paramLong);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.mApp.setHandler(getClass(), this.g);
    this.jdField_b_of_type_Ajdr = ((ajdr)this.mApp.getManager(37));
    this.k = getActivity();
    this.mDataList = yyx.a((ArrayList)yyx.ah(mFriendUin), this.mApp);
    initUI(this.mContentView);
    J(paramViewGroup);
    initAdapter();
    bpM();
    this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_Yvp);
    this.jdField_a_of_type_Yvp.gQ(this.mDataList);
    if (cbL == 1)
    {
      this.J.show();
      yyx.a(Long.parseLong(mFriendUin), 2, this.mApp);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561736;
  }
  
  public int getTitleBarHeight()
  {
    return getResources().getDimensionPixelSize(2131299627);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = getActivity();
    this.mApp = ((QQAppInterface)this.k.getAppInterface());
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    String str1 = getString(2131701832);
    if (!mFriendUin.isEmpty())
    {
      str1 = bd(Long.parseLong(mFriendUin));
      String str2 = getString(2131701834);
      String str3 = getString(2131701833);
      str1 = str2 + str1 + str3;
    }
    setTitle(str1);
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    a(this.jdField_a_of_type_ComTencentBizQqstoryWidgetOverScrollRecyclerView, paramString, paramBitmap);
  }
  
  public void onDestroy()
  {
    removeObserver();
    super.onDestroy();
    if (this.d != null) {
      this.d.a(null);
    }
    if (this.mDataList != null) {
      this.mDataList.clear();
    }
    if (this.mApp != null) {
      this.mApp.removeHandler(getClass());
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
    this.d.pause();
    this.d.edu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopWithCommonFriendsFragment
 * JD-Core Version:    0.7.0.1
 */