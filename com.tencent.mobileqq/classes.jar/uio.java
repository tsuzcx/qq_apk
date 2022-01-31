import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.NearbyLikeLimitManager;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class uio
  extends BaseAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected NearbyLikeLimitManager a;
  public String a;
  public List a;
  public boolean a;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  private int f;
  private int g;
  private int h;
  
  public uio(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramContext = paramVisitorsActivity.getResources();
    this.g = AIOUtils.a(17.0F, paramContext);
    this.h = AIOUtils.a(15.0F, paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.f = paramInt;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = AIOUtils.a(38.0F, paramContext);
    this.jdField_c_of_type_Int = AIOUtils.a(86.0F, paramContext);
    this.d = AIOUtils.a(60.0F, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager = ((NearbyLikeLimitManager)paramVisitorsActivity.app.getManager(206));
  }
  
  private View a()
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130969103, null);
    uin localuin = new uin();
    localuin.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131364983));
    localuin.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131363049));
    localuin.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365172));
    localView.setTag(localuin);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130969048, paramViewGroup, false);
    uil localuil = new uil();
    localuil.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131364863));
    localuil.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362719));
    localuil.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364864));
    localuil.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363896));
    localuil.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364866));
    localuil.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363201));
    localuil.d = ((TextView)paramViewGroup.findViewById(2131364868));
    localuil.e = ((TextView)paramViewGroup.findViewById(2131364869));
    localuil.f = ((TextView)paramViewGroup.findViewById(2131364861));
    localuil.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364867));
    localuil.g = ((TextView)paramViewGroup.findViewById(2131364865));
    paramViewGroup.setTag(localuil);
    return paramViewGroup;
  }
  
  private void a()
  {
    Rect localRect;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int == 0)
    {
      localRect = new Rect();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c.getVisibility() != 0)) {
        break label138;
      }
    }
    label138:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c;; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView)
    {
      ((View)localObject).getGlobalVisibleRect(localRect);
      int i = localRect.bottom;
      int j = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getDisplayMetrics().heightPixels;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "init empty h " + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int = (j - i - AIOUtils.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources()));
      return;
    }
  }
  
  private void a(Object paramObject, uil paramuil)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramuil.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = StringUtil.c(String.valueOf(paramObject.strNick));
    paramuil.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramuil.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramuil.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130839243;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramuil.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842886);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramuil.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      if (paramObject.bAvailableCnt <= 0L) {
        break label445;
      }
      i = 0;
      label155:
      if ((i != 0) && (i != 2)) {
        break label550;
      }
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label537;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.c(paramObject.lEctID)) {
        break label502;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label489;
      }
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840630);
      label214:
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramuil, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label594;
      }
      paramuil.f.setText(paramObject.strTime);
      paramuil.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramuil.jdField_b_of_type_AndroidWidgetImageView, paramuil.jdField_a_of_type_AndroidWidgetTextView);
      if (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label606;
      }
      paramuil.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramuil.e.getLayoutParams();
      if (paramuil.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label618;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramuil.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramuil.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramuil.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramuil.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130839248;
      break label84;
      label397:
      paramuil.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842895);
      break label111;
      label410:
      paramuil.jdField_c_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(paramObject.bConstellation));
      paramuil.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130842896);
      paramuil.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      break label136;
      label445:
      if (paramObject.bTodayVotedCnt > 0L)
      {
        if (paramObject.bCloseNeighborVote == 1)
        {
          i = 1;
          break label155;
        }
        i = 2;
        break label155;
      }
      if (paramObject.bCloseNeighborVote == 0)
      {
        i = 3;
        break label155;
      }
      i = 4;
      break label155;
      label489:
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840632);
      break label214;
      label502:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramuil.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843127);
        break label214;
      }
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843130);
      break label214;
      label537:
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843126);
      break label214;
      label550:
      if (QLog.isColorLevel()) {
        QLog.i("VisitorsActivity", 2, "getChildView not show vote :" + i);
      }
      paramuil.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label594:
      paramuil.f.setVisibility(8);
      break label260;
      label606:
      paramuil.g.setVisibility(8);
      break label298;
      label618:
      if (paramuil.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(uil paramuil, CardProfile paramCardProfile)
  {
    TextView localTextView = paramuil.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramuil.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramuil.jdField_c_of_type_AndroidWidgetImageView.getTag(2131364867)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramuil.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label213;
      }
      paramuil.jdField_a_of_type_Int = 0;
      paramuil.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label206;
      }
    }
    label206:
    for (paramuil = "贡献";; paramuil = "消耗")
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramuil, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramuil.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramuil.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label213:
    paramuil.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramuil.d.setText((CharSequence)localObject);
  }
  
  private void a(uin paramuin)
  {
    int j = 8;
    Object localObject = paramuin.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131436538;
      ((TextView)localObject).setText(i);
      localObject = paramuin.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramuin = paramuin.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramuin.setVisibility(i);
      return;
      i = 2131433937;
      break;
      i = 8;
      break label41;
    }
  }
  
  public CardProfile a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() < 1)) {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorsActivity", 2, "setDataSet profiles empty:" + paramArrayList);
      }
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll((ArrayList)paramArrayList.clone());
      i = this.jdField_c_of_type_Int * this.jdField_a_of_type_JavaUtilList.size();
    } while (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g);
    this.e = (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g - this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getTitleBarHeight() - i);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.jdField_a_of_type_JavaUtilList.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = 0;
    int i = j;
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
        break label54;
      }
      if (this.f != 0) {
        break label42;
      }
      i = 3;
    }
    label42:
    do
    {
      return i;
      i = j;
    } while (this.f != 1);
    return 4;
    label54:
    if (this.jdField_c_of_type_Boolean) {
      return 1;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if ((paramView.getTag() instanceof uil)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView = (uil)localView.getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131364867, Integer.valueOf(paramInt));
      a(a(paramInt), paramView);
      return localView;
    case 1: 
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof uin)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      a((uin)paramViewGroup.getTag());
      return paramViewGroup;
    case 2: 
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970493, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131370859)).setText(this.jdField_a_of_type_JavaLangString);
      return paramView;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130971720, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130970492, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size() - 1) {
      return !this.jdField_a_of_type_Boolean;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     uio
 * JD-Core Version:    0.7.0.1
 */