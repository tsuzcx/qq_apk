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
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.cloudfile.CloudFile;
import com.tencent.cloudfile.CloudOnlineFileExt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.troop.widget.SingleLineHotwordTextView;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamworkforgroup.GPadInfo;
import com.tencent.tim.teamworkforgroup.GroupTeamWorkListActivity;
import java.util.ArrayList;
import java.util.List;

public class atkm
  extends atjr
{
  private Context mContext;
  
  public atkm(QQAppInterface paramQQAppInterface, Context paramContext, BaseAdapter paramBaseAdapter, int paramInt)
  {
    super(paramQQAppInterface, paramContext, paramBaseAdapter, paramInt);
    this.mContext = paramContext;
  }
  
  private String bu(String paramString1, String paramString2)
  {
    if (this.app.getCurrentAccountUin().equals(paramString1)) {
      paramString1 = "我";
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
  
  public View a(int paramInt1, atiu paramatiu, View paramView, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, boolean paramBoolean3, int paramInt2)
  {
    View localView;
    PadInfo localPadInfo;
    label187:
    label227:
    label246:
    long l2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.context).inflate(2131558991, paramViewGroup, false);
      paramViewGroup = new atkm.a(null);
      paramViewGroup.ab = ((CheckBox)localView.findViewById(2131369420));
      paramViewGroup.zL = ((ImageView)localView.findViewById(2131364710));
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView = ((SingleLineHotwordTextView)localView.findViewById(2131364718));
      paramViewGroup.ZT = ((TextView)localView.findViewById(2131364721));
      paramViewGroup.ZS = ((TextView)localView.findViewById(2131364804));
      paramViewGroup.ZR = ((TextView)localView.findViewById(2131364814));
      paramViewGroup.GY = ((ImageView)localView.findViewById(2131378316));
      paramViewGroup.GZ = ((ImageView)localView.findViewById(2131377338));
      paramViewGroup.ev = localView.findViewById(2131364722);
      localView.setTag(paramViewGroup);
      if (!(paramatiu instanceof FileManagerEntity)) {
        break label691;
      }
      localPadInfo = athu.a((FileManagerEntity)paramatiu);
      if (!paramBoolean1) {
        break label725;
      }
      paramViewGroup.ab.setVisibility(0);
      paramViewGroup.position = paramInt1;
      if (!paramBoolean3) {
        break label712;
      }
      if (paramInt2 != paramInt1) {
        break label700;
      }
      paramViewGroup.ab.setChecked(true);
      if (localPadInfo.type != 1) {
        break label738;
      }
      paramViewGroup.zL.setImageResource(2130851565);
      if (((localPadInfo instanceof GPadInfo)) && (((GPadInfo)localPadInfo).searchKeyWordList.size() > 0))
      {
        paramView = (ArrayList)((GPadInfo)localPadInfo).searchKeyWordList;
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setHotwords(paramView);
      }
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqTroopWidgetSingleLineHotwordTextView.setText(localPadInfo.title);
      if ((localPadInfo.policy != 0) || (!this.app.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
        break label807;
      }
      paramViewGroup.GZ.setVisibility(0);
      label357:
      paramInt2 = localPadInfo.type_list;
      if ((paramInt2 != 1) && (!this.app.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) {
        break label820;
      }
      paramView = this.context.getResources().getString(2131720888);
      label419:
      paramViewGroup.ZT.setText(paramView);
      l2 = 0L;
      if (!(paramatiu instanceof FileManagerEntity)) {
        break label966;
      }
      if (((FileManagerEntity)paramatiu).cloudFile.onlineFileExt == null) {
        break label1219;
      }
    }
    label568:
    label700:
    label1219:
    for (paramInt2 = ((FileManagerEntity)paramatiu).cloudFile.onlineFileExt.createSrcType;; paramInt2 = 0)
    {
      long l1;
      label487:
      Object localObject;
      if (paramInt2 == 0)
      {
        l1 = ((FileManagerEntity)paramatiu).cloudFile.createTime;
        l2 = l1;
        localObject = null;
        paramView = localObject;
        if (l1 > 0L)
        {
          if (l1 != localPadInfo.lastEditTime) {
            break label1018;
          }
          paramView = bu("" + localPadInfo.lastEditorUin, localPadInfo.lastEditorNick);
          paramView = String.format(this.context.getResources().getString(2131720944), new Object[] { paramView });
        }
        if (paramView == null) {
          break label1098;
        }
        paramViewGroup.ev.setVisibility(0);
        paramViewGroup.ZS.setText(paramView);
        paramView = auqb.bG(l1);
        paramViewGroup.ZR.setText(paramView);
        label605:
        if (!localPadInfo.isHighlight) {
          break label1131;
        }
        localView.setBackgroundResource(2130851584);
      }
      for (;;)
      {
        localView.setOnClickListener(paramOnClickListener);
        localView.setOnLongClickListener(paramOnLongClickListener);
        paramViewGroup.jdField_a_of_type_Atiu = paramatiu;
        paramViewGroup.isSelected = paramBoolean2;
        paramViewGroup.checkBox = ((CheckBox)localView.findViewById(2131369420));
        localView.setTag(-1, Integer.valueOf(paramInt1));
        return localView;
        paramViewGroup = (atkm.a)paramView.getTag();
        localView = paramView;
        break;
        localPadInfo = (PadInfo)paramatiu;
        break label187;
        paramViewGroup.ab.setChecked(false);
        break label227;
        label712:
        paramViewGroup.ab.setChecked(paramBoolean2);
        break label227;
        label725:
        paramViewGroup.ab.setVisibility(8);
        break label227;
        label738:
        if (localPadInfo.type == 2)
        {
          paramViewGroup.zL.setImageResource(2130851566);
          break label246;
        }
        if (localPadInfo.type == 3)
        {
          paramViewGroup.zL.setImageResource(2130851567);
          break label246;
        }
        if (localPadInfo.type != 4) {
          break label246;
        }
        paramViewGroup.zL.setImageResource(2130851577);
        break label246;
        paramViewGroup.GZ.setVisibility(8);
        break label357;
        if (paramInt2 == 3)
        {
          paramView = bu("" + localPadInfo.creatorUin, localPadInfo.shardNick);
          paramView = String.format(this.context.getResources().getString(2131720946), new Object[] { paramView });
          break label419;
        }
        paramView = bu("" + localPadInfo.creatorUin, localPadInfo.creatorNick);
        paramView = String.format(this.context.getResources().getString(2131720943), new Object[] { paramView });
        break label419;
        l1 = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
        break label487;
        label966:
        if (paramInt2 == 3)
        {
          l1 = localPadInfo.lastEditTime;
          break label487;
        }
        if ((localPadInfo instanceof GPadInfo))
        {
          l1 = localPadInfo.lastEditTime;
          break label487;
        }
        l1 = Math.max(localPadInfo.lastEditTime, localPadInfo.currentUserBrowseTime);
        break label487;
        label1018:
        if (l1 == l2)
        {
          paramView = String.format(this.context.getResources().getString(2131720942), new Object[] { "我" });
          break label568;
        }
        paramView = localObject;
        if (l1 != localPadInfo.currentUserBrowseTime) {
          break label568;
        }
        paramView = String.format(this.context.getResources().getString(2131720947), new Object[] { "我" });
        break label568;
        label1098:
        paramViewGroup.ev.setVisibility(8);
        paramViewGroup.ZS.setText("");
        paramViewGroup.ZR.setText("");
        break label605;
        label1131:
        if (this.entrance == 1)
        {
          if (localPadInfo.type_list == 4)
          {
            if (localPadInfo.pinInAllList) {
              localView.setBackgroundResource(2130839765);
            } else {
              localView.setBackgroundResource(2130839764);
            }
          }
          else if (localPadInfo.pinedFlag) {
            localView.setBackgroundResource(2130839765);
          } else {
            localView.setBackgroundResource(2130839764);
          }
        }
        else {
          localView.setBackgroundResource(2130839764);
        }
      }
    }
  }
  
  public List<atiw> a(atiu paramatiu)
  {
    ArrayList localArrayList = new ArrayList();
    PadInfo localPadInfo;
    boolean bool;
    int i;
    if ((paramatiu instanceof FileManagerEntity))
    {
      localPadInfo = athu.a((FileManagerEntity)paramatiu);
      if (!(localPadInfo instanceof GPadInfo)) {
        break label185;
      }
      paramatiu = (GPadInfo)localPadInfo;
      if ((this.mContext == null) || (!(this.mContext instanceof GroupTeamWorkListActivity))) {
        break label404;
      }
      bool = apuh.a(this.app, ((GroupTeamWorkListActivity)this.mContext).aoW, this.app.getCurrentAccountUin());
      if (paramatiu.creatorUin != this.app.getLongAccountUin()) {
        break label166;
      }
      i = 1;
    }
    for (;;)
    {
      label98:
      if ((i == 0) || (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false))) {}
      for (;;)
      {
        localArrayList.add(h);
        if ((i != 0) || (bool)) {
          localArrayList.add(b);
        }
        return localArrayList;
        localPadInfo = (PadInfo)paramatiu;
        break;
        label166:
        i = 0;
        break label98;
        localArrayList.add(i);
      }
      label185:
      if ((this.entrance == 1) && (!(localPadInfo instanceof GPadInfo))) {
        if (((paramatiu instanceof PadInfo)) && ((((PadInfo)paramatiu).pinedFlag) || ((((PadInfo)paramatiu).pinInAllList) && (((PadInfo)paramatiu).type_list == 4))))
        {
          localArrayList.add(g);
          if (((localPadInfo.type_list == 1) || (this.app.getCurrentAccountUin().equals("" + localPadInfo.creatorUin))) && (!BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getBoolean("TIMDocLimitSettingFlag", false))) {
            break label390;
          }
        }
      }
      for (;;)
      {
        localArrayList.add(h);
        localArrayList.add(b);
        return localArrayList;
        localArrayList.add(f);
        break;
        if (this.entrance != 6) {
          break;
        }
        localArrayList.add(c);
        localArrayList.add(j);
        break;
        label390:
        localArrayList.add(i);
      }
      label404:
      i = 0;
      bool = false;
    }
  }
  
  public void destroy() {}
  
  public List<atiw> gt()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(f);
    localArrayList.add(g);
    localArrayList.add(j);
    localArrayList.add(i);
    localArrayList.add(c);
    localArrayList.add(h);
    localArrayList.add(b);
    return localArrayList;
  }
  
  class a
    extends atjv.a
  {
    ImageView GY;
    ImageView GZ;
    TextView ZR;
    TextView ZS;
    TextView ZT;
    SingleLineHotwordTextView a;
    CheckBox ab;
    View ev;
    ImageView zL;
    
    private a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atkm
 * JD-Core Version:    0.7.0.1
 */