import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.b;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.trooponline.widget.RoundTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class apyo
  extends BaseAdapter
{
  protected List<String> IA = new ArrayList(15);
  protected List<apyr> Iz = new ArrayList(15);
  protected QQAppInterface mApp;
  protected String mTroopUin;
  
  public apyo(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.mApp = paramQQAppInterface;
    this.mTroopUin = paramString;
  }
  
  private void a(apyo.b paramb)
  {
    if (paramb.E.length() > 0) {
      paramb.E.delete(0, paramb.E.length());
    }
    paramb.E.append(paramb.nameView.getText().toString()).append(",").append(paramb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.getText().toString());
    paramb.convertView.setContentDescription(paramb.E.toString());
  }
  
  public void clearData()
  {
    this.Iz.clear();
  }
  
  public int getCount()
  {
    return this.Iz.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.Iz.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    apyo.b localb;
    if (paramView == null)
    {
      localObject = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131560852, paramViewGroup, false);
      localb = new apyo.b();
      localb.convertView = ((View)localObject);
      localb.ES = ((ImageView)((View)localObject).findViewById(2131369739));
      localb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView = ((RoundTextView)((View)localObject).findViewById(2131380958));
      localb.nameView = ((TextView)((View)localObject).findViewById(2131380814));
      ((View)localObject).setTag(localb);
      paramView = (View)localObject;
      if (AppSetting.enableTalkBack)
      {
        ((View)localObject).setFocusable(true);
        localb.E = new StringBuilder();
        paramView = (View)localObject;
      }
    }
    for (;;)
    {
      localb = (apyo.b)paramView.getTag();
      apyr localapyr = (apyr)this.Iz.get(paramInt);
      localb.jdField_a_of_type_Apyr = localapyr;
      localb.ES.setImageDrawable(aqdj.a(this.mApp, 1, localapyr.uin));
      if ((localapyr.tag != null) && (localapyr.tag.startsWith("LV")))
      {
        localb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(8);
        localb.memberUin = localapyr.uin;
        localObject = (apyo.a)localb.nameView.getTag();
        localb.nameView.setText(localapyr.name);
        if (localObject != null) {
          break label451;
        }
        localObject = new apyo.a(null);
        localb.nameView.setTag(localObject);
      }
      label451:
      for (;;)
      {
        if (AppSetting.enableTalkBack) {
          a(localb);
        }
        ((apyo.a)localObject).a = localb;
        ((TroopManager)this.mApp.getManager(52)).a(this.mTroopUin, localb.memberUin, (TroopManager.b)localObject);
        if (!this.IA.contains(localb.memberUin))
        {
          new anov(this.mApp).a("dc00899").b("Grp_online").c("online_box").d("exp_mberHead").a(new String[] { this.mTroopUin, localapyr.tag }).report();
          this.IA.add(localb.memberUin);
        }
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        localb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setVisibility(0);
        localb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setText(localapyr.tag);
        localb.jdField_a_of_type_ComTencentMobileqqTrooponlineWidgetRoundTextView.setRoundBgColor(localapyr.tagColor);
        break;
      }
    }
  }
  
  public void setData(List<apyr> paramList)
  {
    this.Iz.clear();
    this.Iz.addAll(paramList);
  }
  
  class a
    implements TroopManager.b
  {
    public apyo.b a;
    
    private a() {}
    
    public void b(TroopMemberInfo paramTroopMemberInfo)
    {
      if ((this.a != null) && (paramTroopMemberInfo != null) && (TextUtils.equals(this.a.memberUin, paramTroopMemberInfo.memberuin)))
      {
        paramTroopMemberInfo = new aofe(((TroopManager)apyo.this.mApp.getManager(52)).getTroopMemberName(paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin), 13).k();
        this.a.nameView.setText(paramTroopMemberInfo);
        if (AppSetting.enableTalkBack) {
          apyo.a(apyo.this, this.a);
        }
      }
    }
  }
  
  public class b
  {
    public StringBuilder E;
    public ImageView ES;
    public apyr a;
    public RoundTextView a;
    public View convertView;
    public String memberUin;
    public TextView nameView;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apyo
 * JD-Core Version:    0.7.0.1
 */