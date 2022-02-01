import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.RecentItemEcShop;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemServiceAccountFolderData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopNotification;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleManager.b;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.mini.report.MiniAppBusiReport;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class aajv
  extends aakb
{
  protected boolean bvX;
  protected int mListItemLayout = 2131562955;
  private List<String> vo;
  
  private void a(aajv.a parama, Context paramContext)
  {
    if ((parama == null) || (parama.b == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder icon is null. ");
      }
    }
    do
    {
      RelativeLayout.LayoutParams localLayoutParams;
      do
      {
        return;
        localLayoutParams = (RelativeLayout.LayoutParams)parama.b.getLayoutParams();
      } while (localLayoutParams == null);
      int i = (int)paramContext.getResources().getDimension(2131297816);
      localLayoutParams.height = i;
      localLayoutParams.width = i;
      localLayoutParams.setMargins((int)jll.dp2px(paramContext, 16.0F), localLayoutParams.topMargin, localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
      if (parama.wi != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RecentEfficientItemBuilder", 2, "decorateVanishHalo: failed.  exception: holder story halo is null. ");
    return;
    parama.wi.setVisibility(8);
  }
  
  private void a(aajv.a parama, Context paramContext, RecentItemChatMsgData paramRecentItemChatMsgData, int paramInt)
  {
    if ((parama == null) || (paramRecentItemChatMsgData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateHaloResource: failed.  exception:  holder: " + parama + " msgItem: " + paramRecentItemChatMsgData);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentEfficientItemBuilder", 2, "decorateHaloResource: invoked. Message:  msgItem.haloState : " + paramRecentItemChatMsgData.haloState + " msgItem.getRecentUserUin() : " + paramRecentItemChatMsgData.qx());
    }
    parama.wi.setVisibility(0);
    parama.wi.setImageResource(paramInt);
    paramRecentItemChatMsgData = (RelativeLayout.LayoutParams)parama.wi.getLayoutParams();
    paramRecentItemChatMsgData.setMargins((int)paramContext.getResources().getDimension(2131297446), paramRecentItemChatMsgData.topMargin, paramRecentItemChatMsgData.rightMargin, paramRecentItemChatMsgData.bottomMargin);
    parama = (RelativeLayout.LayoutParams)parama.b.getLayoutParams();
    paramInt = (int)paramContext.getResources().getDimension(2131299336);
    parama.height = paramInt;
    parama.width = paramInt;
    parama.setMargins((int)jll.dp2px(paramContext, 15.5F), parama.topMargin, parama.rightMargin, parama.bottomMargin);
  }
  
  private void a(RecentBaseData paramRecentBaseData, aajv.a parama, Context paramContext)
  {
    if ((this.c == null) || (this.c.app == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("RecentEfficientItemBuilder", 2, "decorateStoryHalo: failed. Message: empty adapter. ");
      }
    }
    pmj localpmj;
    do
    {
      return;
      localpmj = (pmj)this.c.app.getManager(197);
    } while (!localpmj.r(paramRecentBaseData));
    paramRecentBaseData = (RecentItemChatMsgData)paramRecentBaseData;
    localpmj.b(paramRecentBaseData);
    switch (paramRecentBaseData.haloState)
    {
    default: 
      return;
    case -3: 
      a(parama, paramContext);
      return;
    case -1: 
      a(parama, paramContext, paramRecentBaseData, 2130847416);
      return;
    }
    a(parama, paramContext, paramRecentBaseData, 2130847415);
  }
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    label66:
    Object localObject;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof aajv.a)))
    {
      paramc = (aajv.a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = paramc;
      paramc = paramContext.getResources().getColorStateList(2131167383);
      if (!ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        break label750;
      }
      paramView.g.setExtendTextColor(paramc, 0);
      paramView.d.setTag(Integer.valueOf(paramInt));
      if (AppSetting.enableTalkBack) {
        paramViewGroup.setContentDescription(null);
      }
      if (!(paramObject instanceof RecentBaseData)) {
        break label764;
      }
      RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
      localObject = localRecentBaseData.qx();
      i = localRecentBaseData.ng();
      paramc = null;
      if (paramaajx != null) {
        paramc = paramaajx.a(localRecentBaseData);
      }
      a(paramViewGroup, localRecentBaseData, paramContext, paramc);
      if (((pmj)this.c.app.getManager(197)).s(paramObject))
      {
        paramView.wi.setTag(-22, paramObject);
        paramView.wi.setOnClickListener(paramOnClickListener);
      }
      if ((paramObject instanceof RecentItemEcShop))
      {
        paramView.b.setOnClickListener(paramOnClickListener);
        paramView.b.setTag(-1, Integer.valueOf(paramInt));
        if (AppSetting.enableTalkBack) {
          paramView.b.setContentDescription(String.format(acfp.m(2131713662), new Object[] { localRecentBaseData.mTitleName }));
        }
      }
      if (String.valueOf(9970L).equals(localRecentBaseData.qx())) {
        MiniAppBusiReport.reportEshopExpo("message", String.valueOf(localRecentBaseData.mUnreadNum));
      }
    }
    for (paramaajx = (aajx)localObject;; paramaajx = "")
    {
      if ((obt.adS) && ((paramObject instanceof RecentItemServiceAccountFolderData))) {
        paramView.d.setDragViewType(4, paramViewGroup);
      }
      a(paramContext, paramViewGroup, paramInt, paramObject, paramView, paramOnClickListener);
      paramViewGroup.setOnClickListener(paramOnClickListener);
      paramViewGroup.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
      if ("2290230341".equals(paramaajx)) {
        anor.Vk(1);
      }
      if (1008 == i) {
        ocp.pl(paramaajx);
      }
      return paramViewGroup;
      paramc = new aajv.a();
      localObject = a(paramContext, this.mListItemLayout, paramc);
      paramc.b = ((RecentDynamicAvatarView)((View)localObject).findViewById(2131368698));
      paramc.d = ((DragTextView)((View)localObject).findViewById(2131381288));
      paramc.g = ((SingleLineTextView)((View)localObject).findViewById(2131379769));
      paramc.wh = ((ImageView)((View)localObject).findViewById(2131374690));
      paramc.wi = ((ImageView)((View)localObject).findViewById(2131369914));
      paramc.h = ((SingleLineTextView)((View)localObject).findViewById(2131365748));
      paramc.h.setGravity(16);
      paramViewGroup = paramContext.getResources();
      float f = aqgz.getDesity();
      paramView = paramViewGroup.getColorStateList(2131167383);
      paramViewGroup = paramViewGroup.getColorStateList(2131167311);
      paramc.g.setTextColor(paramViewGroup);
      if (ThemeUtil.isNowThemeIsDefault(null, false, null)) {
        paramc.g.setExtendTextColor(paramView, 0);
      }
      for (;;)
      {
        paramc.g.setExtendTextSize(12.0F, 0);
        paramc.g.setCompoundDrawablePadding((int)(3.0F * f));
        paramc.g.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
        paramc.g.setExtendTextPadding((int)(5.0F * f), 2);
        paramc.g.setExtendTextColor(paramView, 2);
        paramc.g.setExtendTextSize(17.0F, 2);
        paramc.h.setTextColor(paramView);
        paramc.h.setExtendTextPadding((int)(f * 2.0F), 1);
        paramc.h.setExtendTextSize(14.0F, 1);
        ((View)localObject).setTag(paramc);
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramc;
        if (this.c == null) {
          break;
        }
        paramc.d.setOnModeChangeListener(this.c.a());
        paramViewGroup = (ViewGroup)localObject;
        paramView = paramc;
        break;
        paramc.g.setExtendTextColor(paramView, 0);
      }
      label750:
      paramView.g.setExtendTextColor(paramc, 0);
      break label66;
      label764:
      paramView.g.setText("");
      paramView.h.setText("");
      paramView.d.setVisibility(4);
      i = 0;
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    int k = paramRecentBaseData.mMenuFlag;
    paramContext = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    while ((paramRecentBaseData.ng() == 1008) || (paramRecentBaseData.ng() == 7220))
    {
      if ((aakp.iO(paramRecentBaseData.qx())) && (aaku.a().WB()) && (!aaku.a().ew(paramRecentBaseData.qx()))) {
        this.vo.add(paramContext.getString(fy[6]));
      }
      this.vo.add(paramContext.getString(fy[0]));
      return this.vo;
      this.vo.clear();
    }
    int m = k & 0xF0;
    int j = 2;
    int i = 3;
    if ((paramRecentBaseData.ng() == 3000) || (paramRecentBaseData.ng() == 1))
    {
      j = 8;
      i = 7;
    }
    if (m == 32) {
      this.vo.add(paramContext.getString(fy[j]));
    }
    for (;;)
    {
      if ((0xF000000 & k) == 16777216) {
        this.vo.add(paramContext.getString(fy[9]));
      }
      if ((k & 0xF) != 1) {
        break;
      }
      this.vo.add(paramContext.getString(fy[0]));
      break;
      if (m == 16) {
        this.vo.add(paramContext.getString(fy[i]));
      }
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
    if ((paramView.getTag() instanceof aajv.a)) {}
    label409:
    label1178:
    label1584:
    for (aajv.a locala = (aajv.a)paramView.getTag();; locala = null)
    {
      if (locala == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject;
      int j;
      boolean bool;
      if (needDynamic(paramRecentBaseData))
      {
        if (QLog.isColorLevel()) {
          QLog.i("RecentEfficientItemBuilder", 2, "bindview user:" + paramRecentBaseData.qx());
        }
        localObject = ((BaseActivity)paramContext).app;
        j = ((Integer)aajx.a((QQAppInterface)localObject, paramRecentBaseData.ng(), paramRecentBaseData.qx()).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        RecentDynamicAvatarView localRecentDynamicAvatarView = locala.b;
        String str = paramRecentBaseData.qx();
        if (((QQAppInterface)localObject).a.Bd() == 1)
        {
          bool = true;
          label204:
          localRecentDynamicAvatarView.setFaceDrawable((AppInterface)localObject, paramDrawable, i, str, 100, false, bool, 0);
          label223:
          fN(locala.b);
          VipUtils.it(paramView);
          float f = aqgz.getDesity();
          if (paramRecentBaseData.mAuthenIconId == 0) {
            break label1119;
          }
          locala.g.setTextColor(paramContext.getResources().getColor(2131167311));
          locala.g.setCompoundDrawablePadding((int)(3.0F * f));
          locala.g.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("RecentEfficientItemBuilder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label329:
          if (locala.wh != null)
          {
            locala.wh.setVisibility(8);
            if (((paramRecentBaseData instanceof RecentItemChatMsgData)) && (((RecentItemChatMsgData)paramRecentBaseData).mQimOnline == 1))
            {
              locala.wh.setBackgroundDrawable(xva.a().o(3));
              locala.wh.setVisibility(0);
            }
          }
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label1178;
          }
          paramDrawable = paramDrawable.toString();
          locala.g.setExtendText(paramDrawable, 2);
          locala.g.setExtendText(paramRecentBaseData.mShowTime, 0);
          locala.g.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            locala.g.setText(paramRecentBaseData.mTitleName_cs);
          }
          locala.g.setIconDrawablesWithIntrinsicBounds(null);
          locala.g.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
          if ((paramRecentBaseData instanceof RecentMatchChatListItem)) {
            if (!((RecentMatchChatListItem)paramRecentBaseData).mExtendFriendOnline) {
              break label1609;
            }
          }
        }
      }
      label1468:
      label1609:
      for (int i = 2130846051;; i = 0) {
        for (;;)
        {
          locala.g.setCompoundDrawablesWithIntrinsicBounds(0, i);
          i = 0;
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
          case 6: 
          case 7: 
          case 9: 
            label587:
            locala.h.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.mExtraInfoColor;
            paramDrawable = paramRecentBaseData.mMsgExtroInfo;
            if (paramDrawable != null)
            {
              paramDrawable = paramDrawable.toString();
              label624:
              localObject = paramDrawable;
              if (paramDrawable != null)
              {
                localObject = paramDrawable;
                if (paramDrawable.length() > 0)
                {
                  localObject = paramDrawable;
                  if (!paramDrawable.endsWith(" ")) {
                    localObject = paramDrawable + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i != 0)) {
                locala.h.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              locala.h.setExtendText((String)localObject, 1);
            }
            break;
          }
          try
          {
            locala.h.setText(paramRecentBaseData.mLastMsg);
            i1 = paramRecentBaseData.mUnreadNum;
            i = paramRecentBaseData.mUnreadFlag;
            if (((paramRecentBaseData instanceof RecentItemTroopNotification)) && (((RecentItemTroopNotification)paramRecentBaseData).unDealMsgCountNunFlag))
            {
              i = 2;
              if (i1 > 0) {
                if (i == 0)
                {
                  n = 0;
                  locala.d.setDragViewType(-1, paramView);
                  m = 0;
                  j = 0;
                  i = 0;
                  k = 99;
                  aute.updateCustomNoteTxt(locala.d, i, j, n, k, null);
                  if (m != 0)
                  {
                    paramDrawable = ThemeUtil.getCurrentThemeId();
                    if ((!ThemeUtil.isNowThemeIsSimple(this.c.app, false, paramDrawable)) && ((paramRecentBaseData instanceof RecentItemChatMsgData)))
                    {
                      i = ((RecentItemChatMsgData)paramRecentBaseData).mBubbleID;
                      if (i > 0)
                      {
                        localObject = (BubbleManager)this.c.app.getManager(44);
                        if (localObject != null)
                        {
                          paramDrawable = ((BubbleManager)localObject).a(this.c.app, locala.d, i, i1, paramDrawable);
                          if (paramDrawable != null)
                          {
                            if (Build.VERSION.SDK_INT < 16) {
                              break label1468;
                            }
                            locala.d.setBackground(paramDrawable.drawable);
                            locala.d.setTextColor(paramDrawable.textColor);
                            paramDrawable = paramDrawable.bO;
                            locala.d.setPadding(paramDrawable.left, paramDrawable.top, paramDrawable.right, paramDrawable.bottom);
                          }
                        }
                      }
                    }
                  }
                  i = paramRecentBaseData.mMenuFlag & 0xF0;
                  if (i != 32) {
                    break label1484;
                  }
                }
              }
            }
          }
          catch (Exception paramDrawable)
          {
            for (;;)
            {
              try
              {
                locala.Lz.setBackgroundResource(2130839643);
                if (QLog.isColorLevel()) {
                  QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set top color, uin=", paramRecentBaseData.qx() });
                }
                if (AppSetting.enableTalkBack) {
                  paramView.setContentDescription(paramRecentBaseData.mContentDesc);
                }
                locala.b.nx(paramRecentBaseData.eK());
                a(locala, paramContext);
                a(paramRecentBaseData, locala, paramContext);
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("RecentEfficientItemBuilder", 2, "bindView end");
                return;
                bool = false;
                break label204;
                locala.b.setImageDrawable(paramDrawable);
                break label223;
                label1119:
                if (((paramRecentBaseData.ng() != 0) || (anlm.ayn())) || (QLog.isColorLevel())) {
                  QLog.d("RecentEfficientItemBuilder", 2, "bindView: drawable is null");
                }
                locala.g.setTextColor(paramContext.getResources().getColor(2131167311));
                locala.g.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label329;
                paramDrawable = "";
                break label409;
                i = 2130842967;
                break label587;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130842977;
                  break label587;
                }
                i = 2130842967;
                break label587;
                if (paramRecentBaseData.mIsGroupVideo)
                {
                  i = 2130842977;
                  break label587;
                }
                i = 2130842978;
                break label587;
                i = 2130842978;
                break label587;
                i = 2130839799;
                break label587;
                i = 2130842133;
                break label587;
                paramDrawable = "";
                break label624;
                paramDrawable = paramDrawable;
                paramDrawable.printStackTrace();
                locala.h.setText(paramRecentBaseData.mLastMsg + " ");
                continue;
                if (i == 2)
                {
                  n = 0;
                  locala.d.setDragViewType(-1, paramView);
                  m = 0;
                  j = 0;
                  i = 1;
                  k = 99;
                  continue;
                }
                if (i == 3)
                {
                  n = 2130851408;
                  if (!(paramRecentBaseData instanceof RecentTroopAssistantItem)) {
                    break label1584;
                  }
                  locala.d.setDragViewType(1, paramView);
                  locala.d.setTextColor(paramContext.getResources().getColor(2131167428));
                  m = 0;
                  i = 3;
                  j = i1;
                  k = 99;
                  continue;
                }
                n = 2130851404;
                locala.d.setDragViewType(0, paramView);
                locala.d.setTextColor(paramContext.getResources().getColor(2131167429));
                if (this.bvX)
                {
                  m = 1;
                  j = i1;
                  i = 3;
                  k = 99;
                  continue;
                  locala.d.setBackgroundDrawable(paramDrawable.drawable);
                  continue;
                  label1484:
                  locala.Lz.setBackgroundResource(2130839642);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("RecentEfficientItemBuilder", 2, new Object[] { "bindView: leftView set normal color,uin=", paramRecentBaseData.qx() });
                  continue;
                }
              }
              catch (Throwable paramDrawable)
              {
                int i1;
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("RecentEfficientItemBuilder", 2, "bindView setBackground error with flag: " + i, paramDrawable);
                continue;
                m = 0;
                j = i1;
                i = 3;
                k = 99;
              }
              continue;
              continue;
              int m = 0;
              j = 0;
              int n = 0;
              int k = 99;
              i = 0;
            }
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
    return 3;
  }
  
  public static class a
    extends aakb.a
  {
    public RecentDynamicAvatarView b;
    public DragTextView d;
    public SingleLineTextView g;
    public SingleLineTextView h;
    public ImageView wh;
    public ImageView wi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aajv
 * JD-Core Version:    0.7.0.1
 */