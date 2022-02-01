import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.RecentDynamicAvatarView;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;

public class znz
  extends aakb
{
  protected int mListItemLayout = 2131559622;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof zny.a)))
    {
      paramViewGroup = (zny.a)paramView.getTag();
      paramViewGroup.g.setTag(Integer.valueOf(paramInt));
      paramView.setOnClickListener(paramOnClickListener);
      if (!(paramObject instanceof RecentBaseData)) {
        break label384;
      }
      paramViewGroup = (RecentBaseData)paramObject;
      paramObject = null;
      if (paramaajx != null) {
        paramObject = paramaajx.a(paramViewGroup);
      }
      a(paramView, paramViewGroup, paramContext, paramObject);
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = new zny.a();
      paramView = LayoutInflater.from(paramContext).inflate(this.mListItemLayout, null);
      paramViewGroup.a = ((RecentDynamicAvatarView)paramView.findViewById(2131368698));
      paramViewGroup.g = ((DragTextView)paramView.findViewById(2131381288));
      paramViewGroup.x = ((SingleLineTextView)paramView.findViewById(2131379769));
      paramViewGroup.y = ((SingleLineTextView)paramView.findViewById(2131365748));
      paramViewGroup.y.setGravity(16);
      paramContext.getResources();
      float f = aqgz.getDesity();
      paramViewGroup.x.setTextColor(paramContext.getResources().getColor(2131166077));
      paramViewGroup.x.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131166076)), 0);
      paramViewGroup.x.setExtendTextSize(12.0F, 0);
      paramViewGroup.x.setCompoundDrawablePadding((int)(3.0F * f));
      paramViewGroup.x.setIconDrawablePadding((int)(2.0F * f), (int)(1.0F * f));
      paramViewGroup.x.setExtendTextPadding((int)(5.0F * f), 2);
      paramViewGroup.x.setExtendTextColor(ColorStateList.valueOf(paramContext.getResources().getColor(2131166076)), 2);
      paramViewGroup.x.setExtendTextSize(17.0F, 2);
      paramViewGroup.y.setTextColor(paramContext.getResources().getColor(2131166076));
      paramViewGroup.y.setExtendTextPadding((int)(f * 2.0F), 1);
      paramViewGroup.y.setExtendTextSize(14.0F, 1);
      paramView.setTag(paramViewGroup);
      break;
      label384:
      paramViewGroup.x.setText("");
      paramViewGroup.y.setText("");
      paramViewGroup.g.setVisibility(4);
    }
  }
  
  public void a(View paramView, RecentBaseData paramRecentBaseData, Context paramContext, Drawable paramDrawable)
  {
    if ((paramView == null) || (paramRecentBaseData == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|param invalidate");
      }
      return;
    }
    if ((paramView.getTag() instanceof zny.a)) {}
    for (zny.a locala = (zny.a)paramView.getTag();; locala = null)
    {
      if (locala == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("MiniMsgTabDafultItemBulder", 2, "bindView|holder is null, tag = " + paramView.getTag());
        return;
      }
      Object localObject = paramRecentBaseData.qx();
      int k = paramRecentBaseData.ng();
      boolean bool2 = needDynamic(paramRecentBaseData);
      QQAppInterface localQQAppInterface;
      int j;
      int i;
      RecentDynamicAvatarView localRecentDynamicAvatarView;
      boolean bool1;
      if (bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("MiniMsgTabDafultItemBulder", 2, "bindview user:" + (String)localObject);
        }
        localQQAppInterface = ((BaseActivity)paramContext).app;
        j = ((Integer)aajx.a(localQQAppInterface, k, (String)localObject).first).intValue();
        i = j;
        if (j == 103) {
          i = 1;
        }
        localRecentDynamicAvatarView = locala.a;
        if (localQQAppInterface.a.Bd() == 1) {
          bool1 = true;
        }
      }
      for (;;)
      {
        localRecentDynamicAvatarView.setFaceDrawable(localQQAppInterface, paramDrawable, i, (String)localObject, 100, false, bool1, 0);
        label222:
        float f = aqgz.getDesity();
        if (paramRecentBaseData.mAuthenIconId != 0)
        {
          locala.x.setCompoundDrawablePadding((int)(3.0F * f));
          locala.x.setCompoundDrawablesWithIntrinsicBounds(0, paramRecentBaseData.mAuthenIconId);
          if (QLog.isColorLevel()) {
            QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: item.authId=" + paramRecentBaseData.mAuthenIconId);
          }
          label295:
          paramDrawable = paramRecentBaseData.mExtraInfo;
          if (paramDrawable == null) {
            break label869;
          }
          paramDrawable = paramDrawable.toString();
          label315:
          locala.x.setExtendText(paramDrawable, 2);
          locala.x.setExtendText(paramRecentBaseData.mShowTime, 0);
          locala.x.setText(paramRecentBaseData.mTitleName);
          if (!TextUtils.isEmpty(paramRecentBaseData.mTitleName_cs)) {
            locala.x.setText(paramRecentBaseData.mTitleName_cs);
          }
          if ((k != 0) || (!(paramRecentBaseData instanceof RecentItemChatMsgData))) {
            break label876;
          }
          paramDrawable = (RecentItemChatMsgData)paramRecentBaseData;
          paramContext = ((BaseActivity)paramContext).app;
          localObject = ajnn.a(paramContext, paramDrawable.mUser.uin, false, 5);
          paramContext = ajnn.a(paramContext, paramDrawable.mUser.uin, (ArrayList)localObject);
          locala.x.setIconDrawablesWithIntrinsicBounds(paramContext);
          locala.x.setIconDrawablePadding(0, (int)(f * 1.0F));
          label453:
          switch (paramRecentBaseData.mStatus)
          {
          default: 
            i = 0;
            label495:
            locala.y.setCompoundDrawablesWithIntrinsicBounds(i, 0);
            i = paramRecentBaseData.mExtraInfoColor;
            paramContext = paramRecentBaseData.mMsgExtroInfo;
            if (paramContext != null)
            {
              paramContext = paramContext.toString();
              paramDrawable = paramContext;
              if (paramContext != null)
              {
                paramDrawable = paramContext;
                if (paramContext.length() > 0)
                {
                  paramDrawable = paramContext;
                  if (!paramContext.endsWith(" ")) {
                    paramDrawable = paramContext + " ";
                  }
                }
              }
              if ((!TextUtils.isEmpty(paramDrawable)) && (i != 0)) {
                locala.y.setExtendTextColor(ColorStateList.valueOf(i), 1);
              }
              locala.y.setExtendText(paramDrawable, 1);
            }
            break;
          }
        }
        try
        {
          locala.y.setText(paramRecentBaseData.mLastMsg);
          k = paramRecentBaseData.mUnreadNum;
          i = 0;
          j = 0;
          m = paramRecentBaseData.mUnreadFlag;
          if (k > 0) {
            if (m == 0)
            {
              i = 0;
              j = 0;
              k = 0;
              locala.g.setDragViewType(-1, paramView);
              aute.updateCustomNoteTxt(locala.g, i, k, j, 99, null);
              if (AppSetting.enableTalkBack) {
                paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              }
              locala.a.nx(paramRecentBaseData.eK());
              return;
              bool1 = false;
              continue;
              locala.a.setImageDrawable(paramDrawable);
              break label222;
              if (bool2)
              {
                i = VipUtils.g(((BaseActivity)paramContext).app, (String)localObject, false);
                if (QLog.isColorLevel()) {
                  QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: vip=" + i);
                }
                if (i == 3)
                {
                  locala.x.setCompoundDrawablePadding((int)(5.0F * f));
                  locala.x.setCompoundDrawablesWithIntrinsicBounds(0, 2130847936);
                  break label295;
                }
                locala.x.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                break label295;
              }
              if (QLog.isColorLevel()) {
                QLog.d("MiniMsgTabDafultItemBulder", 2, "bindView: drawable is null");
              }
              locala.x.setCompoundDrawablesWithIntrinsicBounds(0, 0);
              break label295;
              label869:
              paramDrawable = "";
              break label315;
              label876:
              if ((k == 1) && ((paramRecentBaseData instanceof RecentItemTroopMsgData)))
              {
                paramDrawable = (RecentItemTroopMsgData)paramRecentBaseData;
                paramContext = apmc.c(((BaseActivity)paramContext).app, paramDrawable.troopHonorStr);
                locala.x.setIconDrawablesWithIntrinsicBounds(paramContext);
                locala.x.setIconDrawablePadding(0, (int)(f * 1.0F));
                break label453;
              }
              locala.x.setIconDrawablesWithIntrinsicBounds(null);
              locala.x.setIconDrawablePadding((int)(2.0F * f), (int)(f * 1.0F));
              break label453;
              i = 2130842967;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130842977;
                break label495;
              }
              i = 2130842967;
              break label495;
              if (paramRecentBaseData.mIsGroupVideo)
              {
                i = 2130842977;
                break label495;
              }
              i = 2130842978;
              break label495;
              i = 2130842978;
              break label495;
              i = 2130839799;
              break label495;
              paramContext = "";
            }
          }
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            int m;
            paramContext.printStackTrace();
            locala.y.setText(paramRecentBaseData.mLastMsg + " ");
            continue;
            if (m == 2)
            {
              i = 1;
              j = 0;
              k = 0;
              locala.g.setDragViewType(-1, paramView);
            }
            else if (m == 3)
            {
              i = 3;
              j = 2130851408;
              locala.g.setDragViewType(1, paramView);
            }
            else
            {
              i = 3;
              j = 2130851404;
              locala.g.setDragViewType(0, paramView);
              continue;
              k = 0;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     znz
 * JD-Core Version:    0.7.0.1
 */