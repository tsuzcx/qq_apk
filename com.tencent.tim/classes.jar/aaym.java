import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
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

public class aaym
  extends aayt
  implements ExpandableListView.c
{
  private View.OnClickListener dl = new aayn(this);
  private View.OnClickListener dm = new aayo(this);
  private View.OnClickListener eJ;
  private LayoutInflater mLayoutInflater;
  
  public aaym(Context paramContext, QQAppInterface paramQQAppInterface, ExpandableListView paramExpandableListView, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramQQAppInterface, paramExpandableListView);
    this.eJ = paramOnClickListener;
    this.mLayoutInflater = LayoutInflater.from(paramContext);
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
      str = acfp.m(2131715645);
      i = this.tI.size();
      break;
      str = acfp.m(2131715649);
      i = this.tJ.size();
      break;
      str = acfp.m(2131715646);
      i = this.tK.size();
      break;
      str = acfp.m(2131715647);
      i = this.tL.size();
      break;
      str = acfp.m(2131715648);
      i = this.tM.size();
      break;
      str = acfp.m(2131715650);
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
    Object localObject;
    aayt.a locala;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (aaym.a)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      locala = a(paramInt1, paramInt2);
      if ((locala == null) || (locala.d == null)) {
        break label573;
      }
      if (!(locala.d instanceof TroopInfo)) {
        break label363;
      }
      localTroopInfo = (TroopInfo)locala.d;
      paramView.uin = localTroopInfo.troopuin;
      paramView.type = 4;
      if (TextUtils.isEmpty(localTroopInfo.getTroopName())) {
        break label340;
      }
      localObject = localTroopInfo.getTroopName();
      paramView.uin = localTroopInfo.troopuin;
      paramView.ON.setText((CharSequence)localObject);
      paramView.g = localTroopInfo;
      paramView.c = null;
      paramView.itemType = locala.itemType;
      if ((localTroopInfo.hasSetTroopName()) || (localTroopInfo.wMemberNumClient <= 0)) {
        break label350;
      }
      paramView.OO.setVisibility(0);
      paramView.OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(localTroopInfo.wMemberNumClient) }));
      a(paramView, null);
      paramViewGroup.setOnClickListener(this.eJ);
    }
    label340:
    label350:
    label363:
    while (!QLog.isColorLevel())
    {
      do
      {
        for (;;)
        {
          TroopInfo localTroopInfo;
          return paramViewGroup;
          paramViewGroup = this.mLayoutInflater.inflate(2131563070, this.jdField_b_of_type_ComTencentWidgetExpandableListView, false);
          paramView = new aaym.a();
          paramView.pQ = ((ImageView)paramViewGroup.findViewById(2131366624));
          paramView.wO = ((ImageView)paramViewGroup.findViewById(2131366652));
          paramView.ON = ((TextView)paramViewGroup.findViewById(2131380362));
          paramView.OO = ((TextView)paramViewGroup.findViewById(2131380351));
          paramView.arrow = ((ImageView)paramViewGroup.findViewById(2131362978));
          paramViewGroup.setTag(paramView);
          break;
          localObject = localTroopInfo.troopuin;
          continue;
          paramView.OO.setVisibility(8);
        }
        if ((locala.d instanceof DiscussionInfo))
        {
          localObject = (DiscussionInfo)locala.d;
          paramView.uin = ((DiscussionInfo)localObject).uin;
          paramView.type = 101;
          paramView.ON.setText(aqgv.a(this.mContext, (DiscussionInfo)localObject));
          if (!((DiscussionInfo)localObject).hasRenamed())
          {
            paramView.OO.setVisibility(0);
            paramView.OO.setText(String.format("(%d)", new Object[] { Integer.valueOf(this.jdField_b_of_type_Acdu.cn(((DiscussionInfo)localObject).uin)) }));
          }
          paramViewGroup.setOnClickListener(this.eJ);
          a(paramView, null);
          paramView.c = ((DiscussionInfo)localObject);
          paramView.g = null;
          paramView.itemType = locala.itemType;
          return paramViewGroup;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView data:" + locala.d + " groupPosition:" + paramInt1 + " childPosition:" + paramInt2);
      return paramViewGroup;
    }
    label573:
    QLog.d("TroopDiscussionMemSelectAdapter", 2, "getChildView itemInfo data null" + paramInt1 + " childPosition:" + paramInt2);
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
  
  public class a
    extends abeg.a
  {
    public TextView ON;
    public TextView OO;
    public ImageView arrow;
    public DiscussionInfo c;
    public TroopInfo g;
    public int itemType;
    public ImageView wO;
    
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaym
 * JD-Core Version:    0.7.0.1
 */