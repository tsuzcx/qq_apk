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

public class unk
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
  
  public unk(VisitorsActivity paramVisitorsActivity, Context paramContext, QQAppInterface paramQQAppInterface, View.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean)
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
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130969106, null);
    unj localunj = new unj();
    localunj.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131365010));
    localunj.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localView.findViewById(2131363054));
    localunj.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131365199));
    localView.setTag(localunj);
    return localView;
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130969051, paramViewGroup, false);
    unh localunh = new unh();
    localunh.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131364890));
    localunh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131362724));
    localunh.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364891));
    localunh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363921));
    localunh.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131364893));
    localunh.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131363205));
    localunh.d = ((TextView)paramViewGroup.findViewById(2131364895));
    localunh.e = ((TextView)paramViewGroup.findViewById(2131364896));
    localunh.f = ((TextView)paramViewGroup.findViewById(2131364888));
    localunh.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131364894));
    localunh.g = ((TextView)paramViewGroup.findViewById(2131364892));
    paramViewGroup.setTag(localunh);
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
  
  private void a(Object paramObject, unh paramunh)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (CardProfile)paramObject;
    String str = String.valueOf(paramObject.lEctID);
    paramunh.jdField_a_of_type_JavaLangObject = paramObject;
    Object localObject = StringUtil.c(String.valueOf(paramObject.strNick));
    paramunh.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (paramObject.bAage > 0)
    {
      paramunh.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramObject.bAage));
      localObject = paramunh.jdField_b_of_type_AndroidWidgetTextView;
      if (paramObject.bSex != 1) {
        break label390;
      }
      i = 2130839262;
      label84:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (paramObject.bSex != 1) {
        break label397;
      }
      paramunh.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842916);
      label111:
      if ((paramObject.bConstellation != 0) && (paramObject.bConstellation <= 12)) {
        break label410;
      }
      paramunh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      label136:
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setTag(paramObject);
      if (paramObject.bAvailableCnt <= 0L) {
        break label445;
      }
      i = 0;
      label155:
      if ((i != 0) && (i != 2)) {
        break label550;
      }
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (paramObject.bTodayVotedCnt <= 0L) {
        break label537;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyLikeLimitManager.c(paramObject.lEctID)) {
        break label502;
      }
      if (paramObject.bAvailableCnt > 0L) {
        break label489;
      }
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840645);
      label214:
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity);
      label225:
      a(paramunh, paramObject);
      if (TextUtils.isEmpty(paramObject.strTime)) {
        break label594;
      }
      paramunh.f.setText(paramObject.strTime);
      paramunh.f.setVisibility(0);
      label260:
      VisitorsActivity.a(paramObject.stVipInfo, paramunh.jdField_b_of_type_AndroidWidgetImageView, paramunh.jdField_a_of_type_AndroidWidgetTextView);
      if (!RecentUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.app, str)) {
        break label606;
      }
      paramunh.g.setVisibility(0);
      label298:
      localObject = (RelativeLayout.LayoutParams)paramunh.e.getLayoutParams();
      if (paramunh.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label618;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      paramunh.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramunh.jdField_a_of_type_AndroidWidgetImageView);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, paramObject.wFace, paramunh.jdField_a_of_type_AndroidWidgetImageView);
      return;
      paramunh.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label390:
      i = 2130839267;
      break label84;
      label397:
      paramunh.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130842925);
      break label111;
      label410:
      paramunh.jdField_c_of_type_AndroidWidgetTextView.setText(ProfileCardUtil.a(paramObject.bConstellation));
      paramunh.jdField_c_of_type_AndroidWidgetTextView.setBackgroundResource(2130842926);
      paramunh.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
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
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840647);
      break label214;
      label502:
      if (paramObject.bAvailableCnt <= 0L)
      {
        paramunh.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843159);
        break label214;
      }
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843162);
      break label214;
      label537:
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130843158);
      break label214;
      label550:
      if (QLog.isColorLevel()) {
        QLog.i("VisitorsActivity", 2, "getChildView not show vote :" + i);
      }
      paramunh.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      break label225;
      label594:
      paramunh.f.setVisibility(8);
      break label260;
      label606:
      paramunh.g.setVisibility(8);
      break label298;
      label618:
      if (paramunh.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_c_of_type_AndroidWidgetTextView.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(unh paramunh, CardProfile paramCardProfile)
  {
    TextView localTextView = paramunh.e;
    Object localObject = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (paramunh.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = ((Integer)paramunh.jdField_c_of_type_AndroidWidgetImageView.getTag(2131364894)).intValue();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile, paramunh.d, false, i);
      if (paramCardProfile.payVoteCount <= 0) {
        break label213;
      }
      paramunh.jdField_a_of_type_Int = 0;
      paramunh.d.setText(TextUtils.concat(new CharSequence[] { localObject, "，" }));
      if (this.f != 0) {
        break label206;
      }
    }
    label206:
    for (paramunh = "贡献";; paramunh = "消耗")
    {
      localTextView.setText(String.format("%s%d金豆", new Object[] { paramunh, Integer.valueOf(paramCardProfile.payVoteCount * 2) }));
      localTextView.setVisibility(0);
      return;
      if (paramunh.jdField_c_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_c_of_type_AndroidWidgetTextView.getId());
        break;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, paramunh.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
    }
    label213:
    paramunh.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
    paramunh.d.setText((CharSequence)localObject);
  }
  
  private void a(unj paramunj)
  {
    int j = 8;
    Object localObject = paramunj.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131436558;
      ((TextView)localObject).setText(i);
      localObject = paramunj.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label74;
      }
      i = 0;
      label41:
      ((ProgressBar)localObject).setVisibility(i);
      paramunj = paramunj.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label80;
      }
    }
    label74:
    label80:
    for (int i = j;; i = 0)
    {
      paramunj.setVisibility(i);
      return;
      i = 2131433953;
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
        if ((paramView.getTag() instanceof unh)) {}
      }
      else
      {
        localView = a(paramViewGroup);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      paramView = (unh)localView.getTag();
      paramView.jdField_c_of_type_AndroidWidgetImageView.setTag(2131364894, Integer.valueOf(paramInt));
      a(a(paramInt), paramView);
      return localView;
    case 1: 
      if (paramView != null)
      {
        paramViewGroup = paramView;
        if ((paramView.getTag() instanceof unj)) {}
      }
      else
      {
        paramViewGroup = a();
        paramViewGroup.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
      a((unj)paramViewGroup.getTag());
      return paramViewGroup;
    case 2: 
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970505, null);
      if ((this.jdField_b_of_type_Boolean) && (this.e > this.d))
      {
        paramView.setMinimumHeight(this.e);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      }
      ((TextView)paramView.findViewById(2131370846)).setText(this.jdField_a_of_type_JavaLangString);
      return paramView;
    case 3: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView == null)
      {
        a();
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130971750, null);
        this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Int));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_AndroidViewView;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b == null)
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130970504, null);
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
 * Qualified Name:     unk
 * JD-Core Version:    0.7.0.1
 */