import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.adapter.ForwardRecentItemView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.c;
import com.tencent.widget.SingleLineTextView;
import java.util.HashSet;
import java.util.List;

public class uyb
  extends aayt
  implements ExpandableListView.c
{
  private uyb.a a;
  private View.OnClickListener dl = new uyc(this);
  private View.OnClickListener dm = new uyd(this);
  
  public uyb(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, uyb.a parama)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.a = parama;
  }
  
  private void a(zam.a parama)
  {
    if (this.oW.size() == 1) {}
    for (int i = 0; this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(i); i = parama.aTO)
    {
      this.jdField_b_of_type_ComTencentWidgetExpandableListView.collapseGroup(i);
      this.aJ.remove(this.oW.get(i));
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetExpandableListView.expandGroup(i);
    this.aJ.add(this.oW.get(i));
  }
  
  private void a(zam.a parama, int paramInt, boolean paramBoolean)
  {
    String str;
    int i;
    StringBuilder localStringBuilder;
    if (parama != null)
    {
      str = "";
      if ((paramInt >= 0) && (paramInt < this.oW.size())) {}
      switch (((Integer)this.oW.get(paramInt)).intValue())
      {
      case 1: 
      case 3: 
      case 5: 
      case 7: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        i = 0;
        localStringBuilder = parama.H;
        if (AppSetting.enableTalkBack)
        {
          if (localStringBuilder != null) {
            break label356;
          }
          localStringBuilder = new StringBuilder(24);
        }
        break;
      }
    }
    for (;;)
    {
      localStringBuilder.append(str + " 分组");
      parama.aTO = paramInt;
      parama.n.setText(str);
      parama.o.setVisibility(8);
      parama.k.setVisibility(8);
      parama.c.setText(String.valueOf(i));
      parama.C.setVisibility(0);
      parama.C.setChecked(paramBoolean);
      return;
      str = acfp.m(2131706553);
      i = this.tI.size();
      break;
      str = acfp.m(2131706549);
      i = this.tJ.size();
      break;
      str = acfp.m(2131706554);
      i = this.tK.size();
      break;
      str = acfp.m(2131706560);
      i = this.tL.size();
      break;
      str = acfp.m(2131706556);
      i = this.tM.size();
      break;
      str = acfp.m(2131706550);
      i = this.vI.size();
      break;
      label356:
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public boolean Pw()
  {
    return true;
  }
  
  public boolean a(ExpandableListView paramExpandableListView, View paramView, int paramInt, long paramLong)
  {
    paramExpandableListView = paramView.getTag();
    if ((paramExpandableListView instanceof zam.a)) {
      a((zam.a)paramExpandableListView);
    }
    return true;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    Object localObject1;
    if (paramView == null)
    {
      paramViewGroup = new ForwardRecentItemView(this.mContext);
      paramView = new abeg.a();
      paramViewGroup.setTag(paramView);
      paramView.pQ = paramViewGroup.xl;
      localObject2 = paramViewGroup.b;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ResultRecord();
      }
      localObject2 = a(paramInt1, paramInt2);
      if ((localObject2 == null) || (((aayt.a)localObject2).d == null)) {
        break label436;
      }
      if (!(((aayt.a)localObject2).d instanceof TroopInfo)) {
        break label247;
      }
      localTroopInfo = (TroopInfo)((aayt.a)localObject2).d;
      paramView.uin = localTroopInfo.troopuin;
      paramView.type = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
        break label237;
      }
      localObject2 = localTroopInfo.getTroopName();
      ((ResultRecord)localObject1).b(localTroopInfo.troopuin, (String)localObject2, 1, "", "");
      paramBoolean = this.a.F(localTroopInfo.troopuin, 1);
      paramViewGroup.a((String)localObject2, String.valueOf(localTroopInfo.wMemberNumClient), null, (ResultRecord)localObject1, true, paramBoolean);
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.dm);
    }
    label237:
    label247:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = (ForwardRecentItemView)paramView;
          paramView = (abeg.a)paramView.getTag();
          break;
          localObject2 = localTroopInfo.troopuin;
        }
        if ((((aayt.a)localObject2).d instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((aayt.a)localObject2).d;
          paramView.uin = ((DiscussionInfo)localObject2).uin;
          paramView.type = 101;
          ((ResultRecord)localObject1).b(((DiscussionInfo)localObject2).uin, ((DiscussionInfo)localObject2).discussionName, 3000, "", "");
          paramBoolean = this.a.F(((DiscussionInfo)localObject2).uin, 3000);
          paramInt1 = this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject2).uin);
          paramViewGroup.a(((DiscussionInfo)localObject2).discussionName, String.valueOf(paramInt1), null, (ResultRecord)localObject1, true, paramBoolean);
          a(paramView, null);
          paramViewGroup.setOnClickListener(this.dm);
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ContactsTroopAdapter", 2, "getChildView data:" + ((aayt.a)localObject2).d + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label436:
    QLog.d("ContactsTroopAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
    return paramViewGroup;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.mContext).inflate(2131559068, paramViewGroup, false);
      paramViewGroup = new zam.a();
      paramViewGroup.n = ((SingleLineTextView)paramView.findViewById(2131368187));
      paramViewGroup.n.setDefaultTextColor(-8355712);
      paramViewGroup.C = ((CheckBox)paramView.findViewById(2131369742));
      paramViewGroup.c = ((SimpleTextView)paramView.findViewById(2131365243));
      paramViewGroup.c.setDefaultTextColor(1711276032);
      paramViewGroup.k = ((ProgressBar)paramView.findViewById(2131369847));
      paramViewGroup.o = ((SingleLineTextView)paramView.findViewById(2131380888));
      paramView.setTag(paramViewGroup);
    }
    while (this.oW.size() == 1)
    {
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
      return paramView;
      paramViewGroup = (zam.a)paramView.getTag();
    }
    paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.ccY));
    if (ThemeUtil.isNowThemeIsDefaultCache(this.mApp, false)) {
      paramViewGroup.c.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, paramBoolean);
      paramView.setOnClickListener(this.dl);
      return paramView;
      ColorStateList localColorStateList = this.mContext.getResources().getColorStateList(2131167383);
      paramViewGroup.c.setTextColor(localColorStateList);
    }
  }
  
  public int gj()
  {
    return 2131559068;
  }
  
  public void j(View paramView, int paramInt)
  {
    if (paramView == null) {}
    while (this.oW.size() == 1) {
      return;
    }
    Object localObject;
    if (!(paramView.getTag() instanceof zam.a))
    {
      localObject = new zam.a();
      ((zam.a)localObject).C = ((CheckBox)paramView.findViewById(2131369742));
      ((zam.a)localObject).n = ((SingleLineTextView)paramView.findViewById(2131368187));
      ((zam.a)localObject).n.setDefaultTextColor(-8355712);
      ((zam.a)localObject).o = ((SingleLineTextView)paramView.findViewById(2131380888));
      ((zam.a)localObject).c = ((SimpleTextView)paramView.findViewById(2131365243));
      ((zam.a)localObject).c.setDefaultTextColor(1711276032);
      ((zam.a)localObject).k = ((ProgressBar)paramView.findViewById(2131369847));
      paramView.setTag(localObject);
      paramView = (View)localObject;
      if (!ThemeUtil.isNowThemeIsDefaultCache(this.mApp, false)) {
        break label180;
      }
      paramView.c.setTextColor(-5196865);
    }
    for (;;)
    {
      a(paramView, paramInt, this.jdField_b_of_type_ComTencentWidgetExpandableListView.isGroupExpanded(paramInt));
      return;
      paramView = (zam.a)paramView.getTag();
      break;
      label180:
      localObject = this.mContext.getResources().getColorStateList(2131167383);
      paramView.c.setTextColor((ColorStateList)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean F(String paramString, int paramInt);
    
    public abstract void eK(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyb
 * JD-Core Version:    0.7.0.1
 */