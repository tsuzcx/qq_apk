import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamworkforgroup.GPadInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import java.util.ArrayList;
import java.util.List;

public class aoel
  extends aodc
{
  private Context mContext;
  
  public aoel(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.mContext = paramContext;
  }
  
  private String bu(String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {
      paramString1 = acfp.m(2131715164);
    }
    String str;
    do
    {
      return paramString1;
      str = aqgv.b(this.app, paramString1, true);
      if ((str != null) && (!str.equals(paramString1))) {
        break;
      }
      paramString1 = paramString2;
    } while (!TextUtils.isEmpty(paramString2));
    return str;
  }
  
  public List<aoeg> a(aoef paramaoef)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool;
    int i;
    if ((paramaoef instanceof GPadInfo))
    {
      paramaoef = (GPadInfo)paramaoef;
      if ((this.mContext == null) || (!(this.mContext instanceof GroupTeamWorkListActivity))) {
        break label142;
      }
      bool = apuh.a(this.app, ((GroupTeamWorkListActivity)this.mContext).aoW, this.app.getCurrentAccountUin());
      if (paramaoef.creatorUin != this.app.getLongAccountUin()) {
        break label137;
      }
      i = 1;
    }
    for (;;)
    {
      if ((i != 0) && (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false))) {}
      localArrayList.add(c);
      if ((i != 0) || (bool)) {
        localArrayList.add(b);
      }
      return localArrayList;
      label137:
      i = 0;
      continue;
      label142:
      i = 0;
      bool = false;
    }
  }
  
  public View b(int paramInt1, aoef paramaoef, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    View localView;
    PadInfo localPadInfo;
    label151:
    long l;
    label271:
    label295:
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131563172, paramViewGroup, false);
      paramViewGroup = new aoel.a(null);
      paramViewGroup.zL = ((ImageView)localView.findViewById(2131364710));
      paramViewGroup.a = ((SingleLineHotwordTextView)localView.findViewById(2131364718));
      paramViewGroup.ZT = ((TextView)localView.findViewById(2131364721));
      paramViewGroup.ZS = ((TextView)localView.findViewById(2131364804));
      paramViewGroup.ZR = ((TextView)localView.findViewById(2131364814));
      paramViewGroup.ev = localView.findViewById(2131364722);
      localView.setTag(paramViewGroup);
      localPadInfo = (PadInfo)paramaoef;
      if (localPadInfo.type != 1) {
        break label494;
      }
      paramViewGroup.zL.setImageResource(2130851582);
      if (((localPadInfo instanceof GPadInfo)) && (((GPadInfo)localPadInfo).searchKeyWordList.size() > 0))
      {
        paramView = (ArrayList)((GPadInfo)localPadInfo).searchKeyWordList;
        paramViewGroup.a.setHotwords(paramView);
      }
      paramViewGroup.a.setText(localPadInfo.title);
      paramInt2 = localPadInfo.type_list;
      if ((paramInt2 != 1) && (!this.app.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
        break label531;
      }
      paramView = this.context.getResources().getString(2131720888);
      paramViewGroup.ZT.setText(paramView);
      if (!(localPadInfo instanceof GPadInfo)) {
        break label659;
      }
      l = localPadInfo.lastEditTime;
      localObject = null;
      paramView = localObject;
      if (l > 0L)
      {
        if (l != localPadInfo.lastEditTime) {
          break label677;
        }
        paramView = bu("" + localPadInfo.lastEditorUin, localPadInfo.lastEditorNick);
        paramView = String.format(this.context.getResources().getString(2131720944), new Object[] { paramView });
      }
      label376:
      if (paramView == null) {
        break label768;
      }
      paramViewGroup.ev.setVisibility(0);
      paramViewGroup.ZS.setText(paramView);
      paramView = aobw.bG(l);
      paramViewGroup.ZR.setText(paramView);
      label413:
      if (this.entrance != 1) {
        break label842;
      }
      if (localPadInfo.type_list != 4) {
        break label812;
      }
      if (!localPadInfo.pinInAllList) {
        break label801;
      }
      localView.setBackgroundResource(2130839765);
    }
    for (;;)
    {
      localView.setOnClickListener(paramOnClickListener);
      localView.setOnLongClickListener(paramOnLongClickListener);
      paramViewGroup.b = paramaoef;
      localView.setTag(-1, Integer.valueOf(paramInt1));
      return localView;
      paramViewGroup = (aoel.a)paramView.getTag();
      localView = paramView;
      break;
      label494:
      if (localPadInfo.type == 3)
      {
        paramViewGroup.zL.setImageResource(2130851583);
        break label151;
      }
      paramViewGroup.zL.setImageResource(2130851591);
      break label151;
      label531:
      if (paramInt2 == 3)
      {
        paramView = bu("" + localPadInfo.creatorUin, localPadInfo.shardNick);
        paramView = String.format(this.context.getResources().getString(2131720946), new Object[] { paramView });
        break label271;
      }
      paramView = bu("" + localPadInfo.creatorUin, localPadInfo.creatorNick);
      paramView = String.format(this.context.getResources().getString(2131720943), new Object[] { paramView });
      break label271;
      label659:
      l = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
      break label295;
      label677:
      if (l == 0L)
      {
        paramView = acfp.m(2131715169);
        paramView = String.format(this.context.getResources().getString(2131720942), new Object[] { paramView });
        break label376;
      }
      paramView = localObject;
      if (l != localPadInfo.currentUserBrowseTime) {
        break label376;
      }
      paramView = acfp.m(2131715148);
      paramView = String.format(this.context.getResources().getString(2131720947), new Object[] { paramView });
      break label376;
      label768:
      paramViewGroup.ev.setVisibility(8);
      paramViewGroup.ZS.setText("");
      paramViewGroup.ZR.setText("");
      break label413;
      label801:
      localView.setBackgroundResource(2130839764);
      continue;
      label812:
      if (localPadInfo.pinedFlag)
      {
        localView.setBackgroundResource(2130839765);
      }
      else
      {
        localView.setBackgroundResource(2130839764);
        continue;
        label842:
        localView.setBackgroundResource(2130839764);
      }
    }
  }
  
  public List<aoeg> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(c);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends aodg.a
  {
    TextView ZR;
    TextView ZS;
    TextView ZT;
    SingleLineHotwordTextView a;
    View ev;
    ImageView zL;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoel
 * JD-Core Version:    0.7.0.1
 */