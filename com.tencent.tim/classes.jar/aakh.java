import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.data.RecentItemMayKnowFriendVerticalListData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class aakh
  extends aakb
{
  View.OnTouchListener j = new aaki(this);
  protected int mListItemLayout = 2131562960;
  private List<String> vo;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    Object localObject1;
    label71:
    Object localObject2;
    if ((paramView != null) && ((paramView.getTag() instanceof aakh.a)))
    {
      paramViewGroup = (aakh.a)paramView.getTag();
      localObject1 = paramContext.getResources();
      paramc = ((Resources)localObject1).getColorStateList(2131167383);
      localObject1 = ((Resources)localObject1).getColorStateList(2131167384);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label636;
      }
      paramViewGroup.g.setExtendTextColor((ColorStateList)localObject1, 0);
      paramViewGroup.Oe.setOnClickListener(paramOnClickListener);
      paramViewGroup.Oe.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.Oe.setOnTouchListener(this.j);
      paramViewGroup.iM.setOnClickListener(paramOnClickListener);
      paramViewGroup.iM.setTag(-1, Integer.valueOf(paramInt));
      paramViewGroup.ej.setOnClickListener(paramOnClickListener);
      paramViewGroup.ej.setTag(-1, Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label980;
      }
      localObject1 = (RecentBaseData)paramObject;
      if ((paramObject instanceof RecentItemMayKnowFriendVerticalListData))
      {
        localObject2 = ((RecentItemMayKnowFriendVerticalListData)paramObject).mUser;
        if (!((RecentUser)localObject2).uin.equals("sp_uin_for_title")) {
          break label650;
        }
        paramViewGroup.iL.setVisibility(0);
        paramViewGroup.iM.setVisibility(8);
      }
    }
    for (;;)
    {
      a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
      paramView.setOnClickListener(paramOnClickListener);
      paramView.setOnLongClickListener(paramOnLongClickListener);
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = new aakh.a();
      paramView = a(paramContext, this.mListItemLayout, paramViewGroup);
      paramViewGroup.b = ((RecentDynamicAvatarView)paramView.findViewById(2131361802));
      paramViewGroup.g = ((SingleLineTextView)paramView.findViewById(2131372384));
      paramViewGroup.LA = ((TextView)paramView.findViewById(2131377211));
      paramViewGroup.Oc = ((TextView)paramView.findViewById(2131362339));
      paramViewGroup.Od = ((TextView)paramView.findViewById(2131377214));
      paramViewGroup.ej = ((Button)paramView.findViewById(2131377201));
      paramViewGroup.Oe = ((TextView)paramView.findViewById(2131376924));
      paramViewGroup.iL = ((RelativeLayout)paramView.findViewById(2131376937));
      paramViewGroup.iM = ((RelativeLayout)paramView.findViewById(2131376925));
      paramViewGroup.a = ((TroopLabelLayout)paramView.findViewById(2131380324));
      paramViewGroup.a.setLabelType(1);
      paramViewGroup.LG = ((TextView)paramView.findViewById(2131371194));
      localObject2 = paramContext.getResources();
      float f = aqgz.getDesity();
      paramc = ((Resources)localObject2).getColorStateList(2131167383);
      localObject1 = ((Resources)localObject2).getColorStateList(2131167311);
      localObject2 = ((Resources)localObject2).getColorStateList(2131167384);
      paramViewGroup.g.setTextColor((ColorStateList)localObject1);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramViewGroup.g.setExtendTextColor((ColorStateList)localObject2, 0);
      }
      for (;;)
      {
        paramViewGroup.g.setExtendTextSize(12.0F, 0);
        paramViewGroup.g.setCompoundDrawablePadding((int)(3.0F * f));
        paramViewGroup.g.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramViewGroup.g.setExtendTextPadding((int)(f * 5.0F), 2);
        paramViewGroup.g.setExtendTextColor(paramc, 2);
        paramViewGroup.g.setExtendTextSize(17.0F, 2);
        paramView.setTag(paramViewGroup);
        break;
        paramViewGroup.g.setExtendTextColor(paramc, 0);
      }
      label636:
      paramViewGroup.g.setExtendTextColor(paramc, 0);
      break label71;
      label650:
      paramViewGroup.iL.setVisibility(8);
      paramViewGroup.iM.setVisibility(0);
      ((RecentBaseData)localObject1).qx();
      ((RecentBaseData)localObject1).ng();
      paramc = null;
      if (paramaajx != null) {
        paramc = paramaajx.a((RecentBaseData)localObject1);
      }
      if ((((RecentUser)localObject2).extraInfo instanceof MayKnowRecommend))
      {
        paramaajx = (MayKnowRecommend)((RecentUser)localObject2).extraInfo;
        a(paramView, (RecentBaseData)localObject1, paramContext, paramc, paramaajx);
        if (paramaajx != null) {
          if (paramaajx.friendStatus == 0)
          {
            paramViewGroup.ej.setOnClickListener(paramOnClickListener);
            paramViewGroup.ej.setVisibility(0);
            paramViewGroup.ej.setText(acfp.m(2131721053));
            paramViewGroup.ej.setTag(paramaajx);
            paramaajx = paramContext.getResources().getColorStateList(2131167337);
            if (paramaajx != null) {
              paramViewGroup.ej.setTextColor(paramaajx);
            }
            paramViewGroup.ej.setBackgroundResource(2130839559);
            paramViewGroup.LA.setVisibility(8);
            if (AppSetting.enableTalkBack) {
              paramViewGroup.ej.setContentDescription(acfp.m(2131721053));
            }
          }
          else if (paramaajx.friendStatus == 1)
          {
            paramViewGroup.ej.setVisibility(8);
            paramViewGroup.LA.setVisibility(0);
            paramViewGroup.LA.setText(2131718834);
            if (AppSetting.enableTalkBack) {
              paramViewGroup.LA.setContentDescription(acfp.m(2131713704));
            }
          }
          else
          {
            paramViewGroup.ej.setVisibility(8);
            paramViewGroup.LA.setVisibility(0);
            paramViewGroup.LA.setText(2131690291);
            if (AppSetting.enableTalkBack) {
              paramViewGroup.LA.setContentDescription(acfp.m(2131713703));
            }
          }
        }
      }
      else
      {
        a(paramView, (RecentBaseData)localObject1, paramContext, paramc);
        continue;
        label980:
        paramViewGroup.g.setText("");
        paramViewGroup.Od.setText("");
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int i = paramRecentBaseData.mMenuFlag;
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      if ((i & 0xF) == 1) {
        this.vo.add(paramRecentBaseData.getString(fy[0]));
      }
      return this.vo;
      this.vo.clear();
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof aakh.a)) {}
    for (aakh.a locala = (aakh.a)paramView.getTag();; locala = null) {
      for (;;)
      {
        if (locala == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        int i;
        boolean bool;
        label205:
        label224:
        float f;
        if (needDynamic(paramRecentBaseData))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.qx());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int k = ((Integer)aajx.a(localQQAppInterface, paramRecentBaseData.ng(), paramRecentBaseData.qx()).first).intValue();
          i = k;
          if (k == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = locala.b;
          String str = paramRecentBaseData.qx();
          if (localQQAppInterface.a.Bd() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            fN(locala.b);
            f = aqgz.getDesity();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label459;
            }
            locala.g.setCompoundDrawablePadding((int)(f * 3.0F));
            locala.g.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label595;
            }
            paramContext = paramContext.toString();
            locala.g.setExtendText(paramContext, 2);
            locala.g.setExtendText(paramRecentBaseData.mShowTime, 0);
            locala.g.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
              locala.g.setText(paramRecentBaseData.mTitleName_cs);
            }
            locala.g.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          locala.Od.setText(paramRecentBaseData.mLastMsg);
          ysa.a(locala.Oc, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).gender, ((RecentItemMayKnowFriendVerticalListData)paramRecentBaseData).age, null);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          locala.b.setImageDrawable(paramDrawable);
          break label224;
          label459:
          if (needDynamic(paramRecentBaseData))
          {
            i = VipUtils.g(((BaseActivity)paramContext).app, paramRecentBaseData.qx(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              locala.g.setCompoundDrawablePadding((int)(f * 5.0F));
              locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 2130847936);
              break label308;
            }
            locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          break label308;
          label595:
          paramContext = "";
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable, MayKnowRecommend paramMayKnowRecommend)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof aakh.a)) {}
    for (aakh.a locala = (aakh.a)paramView.getTag();; locala = null) {
      for (;;)
      {
        if (locala == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
          return;
        }
        int i;
        boolean bool;
        label205:
        label224:
        float f;
        if (needDynamic(paramRecentBaseData))
        {
          if (QLog.isColorLevel()) {
            QLog.i("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindview user:" + paramRecentBaseData.qx());
          }
          QQAppInterface localQQAppInterface = ((BaseActivity)paramContext).app;
          int k = ((Integer)aajx.a(localQQAppInterface, paramRecentBaseData.ng(), paramRecentBaseData.qx()).first).intValue();
          i = k;
          if (k == 103) {
            i = 1;
          }
          RecentDynamicAvatarView localRecentDynamicAvatarView = locala.b;
          String str = paramRecentBaseData.qx();
          if (localQQAppInterface.a.Bd() == 1)
          {
            bool = true;
            localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, str, 100, false, bool, 0);
            fN(locala.b);
            f = aqgz.getDesity();
            if (paramRecentBaseData.mAuthenIconId == 0) {
              break label447;
            }
            locala.g.setCompoundDrawablePadding((int)(f * 3.0F));
            locala.g.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
            }
            label308:
            paramContext = paramRecentBaseData.mExtraInfo;
            if (paramContext == null) {
              break label583;
            }
            paramContext = paramContext.toString();
            locala.g.setExtendText(paramContext, 2);
            locala.g.setExtendText(paramRecentBaseData.mShowTime, 0);
            locala.g.setText(paramRecentBaseData.mTitleName);
            if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
              locala.g.setText(paramRecentBaseData.mTitleName_cs);
            }
            locala.g.setIconDrawablesWithIntrinsicBounds(null);
          }
        }
        try
        {
          locala.LG.setText(paramRecentBaseData.mLastMsg);
          locala.a.b(paramMayKnowRecommend);
          if (!AppSetting.enableTalkBack) {
            break;
          }
          paramView.setContentDescription(paramRecentBaseData.mContentDesc);
          return;
          bool = false;
          break label205;
          locala.b.setImageDrawable(paramDrawable);
          break label224;
          label447:
          if (needDynamic(paramRecentBaseData))
          {
            i = VipUtils.g(((BaseActivity)paramContext).app, paramRecentBaseData.qx(), false);
            if (QLog.isColorLevel()) {
              QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: vip=" + i);
            }
            if (i == 3)
            {
              locala.g.setCompoundDrawablePadding((int)(f * 5.0F));
              locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 2130847936);
              break label308;
            }
            locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            break label308;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RecentMayKnowFriendVerticalListItemBuilder", 2, "bindView: drawable is null");
          }
          locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
          break label308;
          label583:
          paramContext = "";
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
          }
        }
      }
    }
  }
  
  protected boolean needDynamic(RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentBaseData.ng();
    return (i == 0) || (i == 1000) || (i == 1004) || (i == 1003) || (i == 10004) || (i == 1021) || (i == 1022) || (i == 1023) || (i == 10008);
  }
  
  public int xV()
  {
    return 1;
  }
  
  public static class a
    extends aakb.a
  {
    public TextView LA;
    public TextView LG;
    public TextView Oc;
    public TextView Od;
    public TextView Oe;
    public TroopLabelLayout a;
    public RecentDynamicAvatarView b;
    public Button ej;
    public SingleLineTextView g;
    public RelativeLayout iL;
    public RelativeLayout iM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aakh
 * JD-Core Version:    0.7.0.1
 */