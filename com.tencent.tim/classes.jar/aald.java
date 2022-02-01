import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.c;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.activity.recent.data.RecentTroopAssistantItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.ArrayList;
import java.util.List;

public class aald
  extends aakb
{
  private List<String> vo;
  
  public View a(int paramInt, Object paramObject, aajx paramaajx, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.c paramc)
  {
    paramc = null;
    paramViewGroup = paramc;
    if (paramView != null)
    {
      paramViewGroup = paramc;
      if (paramView.getTag() != null)
      {
        paramViewGroup = paramc;
        if ((paramView.getTag() instanceof aald.a)) {
          paramViewGroup = (aald.a)paramView.getTag();
        }
      }
    }
    if (paramViewGroup == null)
    {
      paramViewGroup = new aald.a();
      paramView = super.a(paramContext, 2131561637, paramViewGroup);
      paramViewGroup.icon = ((ImageView)paramView.findViewById(2131377656));
      paramViewGroup.title = ((TextView)paramView.findViewById(2131379402));
      paramViewGroup.j = ((DragTextView)paramView.findViewById(2131381288));
      paramViewGroup.B = ((SingleLineTextView)paramView.findViewById(2131365656));
      paramViewGroup.NX = ((TextView)paramView.findViewById(2131379700));
      paramViewGroup.wm = ((ImageView)paramView.findViewById(2131382023));
      paramViewGroup.Oi = ((TextView)paramView.findViewById(2131367941));
      paramViewGroup.Oj = ((TextView)paramView.findViewById(2131364332));
      paramViewGroup.Ok = ((TextView)paramView.findViewById(2131382392));
      paramViewGroup.Ol = ((TextView)paramView.findViewById(2131364453));
      paramViewGroup.Om = ((TextView)paramView.findViewById(2131365061));
      paramViewGroup.hX = ((LinearLayout)paramView.findViewById(2131377895));
      paramView.setTag(paramViewGroup);
      if (this.c != null) {
        paramViewGroup.j.setOnModeChangeListener(this.c.a());
      }
      paramViewGroup.B.setExtendTextSize(13.0F, 1);
    }
    for (;;)
    {
      paramViewGroup.j.setTag(Integer.valueOf(paramInt));
      if ((paramViewGroup != null) && ((paramObject instanceof RecentBaseData)))
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)paramObject;
        paramc = null;
        if (paramaajx != null) {
          paramc = paramaajx.a(localRecentBaseData);
        }
        a(paramView, localRecentBaseData, paramContext, paramc);
      }
      for (;;)
      {
        super.a(paramContext, paramView, paramInt, paramObject, paramViewGroup, paramOnClickListener);
        paramView.setOnClickListener(paramOnClickListener);
        paramView.setOnLongClickListener(paramOnLongClickListener);
        paramView.setTag(-1, Integer.valueOf(paramInt));
        return paramView;
        if (paramViewGroup != null)
        {
          paramViewGroup.icon.setImageDrawable(null);
          paramViewGroup.title.setText("");
          paramViewGroup.B.setText("");
        }
      }
    }
  }
  
  public List<String> a(RecentBaseData paramRecentBaseData, Context paramContext)
  {
    if ((paramRecentBaseData == null) || (paramContext == null)) {
      return null;
    }
    paramRecentBaseData = paramContext.getResources();
    if (this.vo == null) {
      this.vo = new ArrayList();
    }
    for (;;)
    {
      this.vo.add(paramRecentBaseData.getString(fy[0]));
      return this.vo;
      this.vo.clear();
    }
  }
  
  public void a(Context paramContext, aald.a parama, RecentSayHelloListItem paramRecentSayHelloListItem)
  {
    int k = 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRecentSayHelloListItem.mTitleName);
    int j;
    label113:
    Object localObject;
    switch (paramRecentSayHelloListItem.gender)
    {
    default: 
      i = 2130841206;
      parama.Oi.setBackgroundDrawable(apuh.k(parama.Oi.getResources(), Color.parseColor("#ff9cc4f7")));
      j = 0;
      if (paramRecentSayHelloListItem.age > 0)
      {
        parama.Oi.setText(String.valueOf(paramRecentSayHelloListItem.age));
        localStringBuilder.append(paramRecentSayHelloListItem.age).append("岁");
        parama.Oi.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (j == 0) {
          break label787;
        }
        parama.Oi.setVisibility(0);
        i = 1;
        label141:
        if ((paramRecentSayHelloListItem.career > 0) && (paramRecentSayHelloListItem.career < 14)) {
          break label802;
        }
        parama.Oj.setVisibility(8);
        label166:
        localObject = aqep.c((byte)paramRecentSayHelloListItem.constellation);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label877;
        }
        parama.Ok.setVisibility(8);
        label193:
        if (paramRecentSayHelloListItem.vip <= 0) {
          break label940;
        }
        parama.wm.setVisibility(0);
        if (paramRecentSayHelloListItem.vip != 1) {
          break label927;
        }
        parama.wm.setImageResource(2130842175);
        label226:
        parama.title.setTextColor(paramContext.getResources().getColorStateList(2131167439));
        i += 1;
        label249:
        if (!paramRecentSayHelloListItem.charmIcon) {
          break label969;
        }
        if (parama.Ol.getVisibility() != 0) {
          parama.Ol.setVisibility(0);
        }
        parama.Ol.setText("LV" + paramRecentSayHelloListItem.charmLevel);
        paramContext = parama.Ol.getContext().getResources().getDrawable(2130846424);
        localObject = ajpt.c(parama.Ol.getContext());
        int m = Color.parseColor("#FFCC59");
        j = m;
        if (localObject != null)
        {
          j = m;
          if (paramRecentSayHelloListItem.charmLevel < localObject.length) {
            j = localObject[paramRecentSayHelloListItem.charmLevel];
          }
        }
        parama.Ol.setBackgroundDrawable(apuh.a(parama.Ol.getContext().getResources(), j, paramContext));
        localStringBuilder.append(",").append("拥有魅力勋章");
        j = i + 1;
        label417:
        if ((paramRecentSayHelloListItem.commonId <= 0) || (TextUtils.isEmpty(paramRecentSayHelloListItem.common))) {
          break label1012;
        }
        j += 1;
        parama.Ok.setVisibility(8);
        parama.Om.setVisibility(0);
        parama.Om.setText(paramRecentSayHelloListItem.common);
        parama.Om.setTag(Integer.valueOf(paramRecentSayHelloListItem.commonId));
        localStringBuilder.append(",").append(paramRecentSayHelloListItem.common);
      }
      break;
    }
    label787:
    label802:
    label877:
    label1012:
    for (int i = k;; i = 0)
    {
      if (i == 0)
      {
        parama.Om.setVisibility(8);
        parama.Om.setTag(Integer.valueOf(0));
      }
      if (j > 0) {
        parama.hX.setVisibility(0);
      }
      for (;;)
      {
        if (AppSetting.enableTalkBack)
        {
          if (paramRecentSayHelloListItem.mUnreadNum > 0) {
            localStringBuilder.append(",").append(paramRecentSayHelloListItem.mUnreadNum).append("条未读消息");
          }
          localStringBuilder.append(",").append(parama.B.getText().toString());
          localStringBuilder.append(",").append(parama.NX.getText().toString());
          if (localStringBuilder.length() > 0) {
            paramRecentSayHelloListItem.mContentDesc = localStringBuilder.toString();
          }
          if (QLog.isColorLevel()) {
            QLog.i("Q.recent", 2, "talkback|" + localStringBuilder.toString());
          }
        }
        return;
        i = 2130842171;
        parama.Oi.setBackgroundDrawable(apuh.k(parama.Oi.getResources(), Color.parseColor("#ff9cc4f7")));
        localStringBuilder.append(",").append("男");
        j = 1;
        break;
        i = 2130842169;
        parama.Oi.setBackgroundDrawable(apuh.k(parama.Oi.getResources(), Color.parseColor("#ffffb4c8")));
        localStringBuilder.append(",").append("女");
        j = 1;
        break;
        parama.Oi.setText("");
        break label113;
        parama.Oi.setVisibility(8);
        i = 0;
        break label141;
        i += 1;
        parama.Oj.setText(aqek.cq[paramRecentSayHelloListItem.career]);
        parama.Oj.setBackgroundDrawable(apuh.k(parama.Oj.getResources(), Color.parseColor("#ff81d4f3")));
        parama.Oj.setVisibility(0);
        localStringBuilder.append(",").append(aqek.cq[paramRecentSayHelloListItem.career]);
        break label166;
        i += 1;
        parama.Ok.setText((CharSequence)localObject);
        parama.Ok.setBackgroundResource(2130846486);
        parama.Ok.setVisibility(0);
        localStringBuilder.append(",").append((String)localObject);
        break label193;
        parama.wm.setImageResource(2130842176);
        break label226;
        parama.title.setTextColor(paramContext.getResources().getColorStateList(2131167366));
        parama.wm.setVisibility(8);
        break label249;
        j = i;
        if (parama.Ol.getVisibility() == 8) {
          break label417;
        }
        parama.Ol.setVisibility(8);
        j = i;
        break label417;
        parama.hX.setVisibility(4);
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
    Object localObject = paramView.getTag();
    if ((localObject instanceof aald.a)) {}
    for (aald.a locala = (aald.a)localObject;; locala = null) {
      for (;;)
      {
        if (locala == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.recent", 2, "bindView|holder is null, tag = " + localObject);
          return;
        }
        locala.icon.setImageDrawable(paramDrawable);
        RecentSayHelloListItem localRecentSayHelloListItem;
        CharSequence localCharSequence;
        int i;
        if ((paramRecentBaseData instanceof RecentSayHelloListItem))
        {
          localRecentSayHelloListItem = (RecentSayHelloListItem)paramRecentBaseData;
          localObject = localRecentSayHelloListItem.mTitleName;
          localCharSequence = locala.title.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            locala.title.setText(paramDrawable);
          }
          i = paramRecentBaseData.mExtraInfoColor;
          paramDrawable = paramRecentBaseData.mMsgExtroInfo;
          if (paramDrawable == null) {
            break label489;
          }
          paramDrawable = paramDrawable.toString();
          if (!TextUtils.isEmpty(paramDrawable)) {
            locala.B.setExtendTextColor(ColorStateList.valueOf(i), 1);
          }
          locala.B.setExtendText(paramDrawable, 1);
          localObject = localRecentSayHelloListItem.mLastMsg;
          localCharSequence = locala.B.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (paramDrawable.equals(localCharSequence)) {}
        }
        try
        {
          locala.B.setText(paramDrawable);
          locala.B.setCompoundDrawables(null, null);
          if (paramRecentBaseData.mStatus == 4) {
            locala.B.setCompoundDrawables(paramContext.getResources().getDrawable(2130839799), null);
          }
          localObject = localRecentSayHelloListItem.mShowTime;
          localCharSequence = locala.NX.getText();
          paramDrawable = (Drawable)localObject;
          if (localObject == null) {
            paramDrawable = "";
          }
          if (!paramDrawable.equals(localCharSequence)) {
            locala.NX.setText(paramDrawable);
          }
          m = localRecentSayHelloListItem.mUnreadNum;
          i = localRecentSayHelloListItem.mUnreadFlag;
          if (m > 0) {
            if (i == 0)
            {
              locala.j.setDragViewType(-1);
              k = 99;
              m = 0;
              j = 0;
              i = 0;
              aute.updateCustomNoteTxt(locala.j, i, m, j, k, null);
              if (locala.NX.getVisibility() != 0) {
                locala.NX.setVisibility(0);
              }
              a(paramContext, locala, localRecentSayHelloListItem);
              if (!AppSetting.enableTalkBack) {
                break;
              }
              paramView.setContentDescription(paramRecentBaseData.mContentDesc);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("SayHelloListItemBuilder", 2, "data is not RecentSayHelloItem");
              }
              throw new RuntimeException("data is null");
              label489:
              paramDrawable = "";
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int m;
            int k;
            int j;
            localException.printStackTrace();
            locala.B.setText(paramDrawable + " ");
            continue;
            if (i == 2)
            {
              locala.j.setDragViewType(-1);
              m = 0;
              j = 0;
              i = 1;
              k = 99;
            }
            else if (i == 3)
            {
              j = 2130851408;
              if ((paramRecentBaseData instanceof RecentTroopAssistantItem)) {}
              locala.j.setDragViewType(1);
              locala.j.setTextColor(paramContext.getResources().getColor(2131167428));
              k = 99;
              i = 3;
            }
            else
            {
              j = 2130851404;
              locala.j.setDragViewType(0);
              locala.j.setTextColor(paramContext.getResources().getColor(2131167429));
              k = 99;
              i = 3;
              continue;
              k = 99;
              m = 0;
              j = 0;
              i = 0;
            }
          }
        }
      }
    }
  }
  
  public static class a
    extends aakb.a
  {
    public SingleLineTextView B;
    public TextView NX;
    public TextView Oi;
    public TextView Oj;
    public TextView Ok;
    public TextView Ol;
    public TextView Om;
    public LinearLayout hX;
    public ImageView icon;
    public DragTextView j;
    public TextView title;
    public ImageView wm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aald
 * JD-Core Version:    0.7.0.1
 */