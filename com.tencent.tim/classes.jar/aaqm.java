import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.b;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;

public class aaqm
  extends aaqk
  implements PanelIconLinearLayout.b
{
  private View de;
  int panelType = -1;
  
  public aaqm(FlowActivity paramFlowActivity)
  {
    super(paramFlowActivity);
  }
  
  public void L(ViewGroup paramViewGroup)
  {
    PanelIconLinearLayout localPanelIconLinearLayout = new PanelIconLinearLayout(paramViewGroup.getContext(), null);
    localPanelIconLinearLayout.setPanelIconListener(this);
    int i = (int)(40.0F * paramViewGroup.getResources().getDisplayMetrics().density + 0.5F);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131367346);
    paramViewGroup.addView(localPanelIconLinearLayout, (ViewGroup.LayoutParams)localObject);
    localPanelIconLinearLayout.setCustomHeight(i);
    paramViewGroup = this.a.getIntent().getExtras();
    if ((paramViewGroup != null) && (paramViewGroup.containsKey("selected_item")))
    {
      this.panelType = paramViewGroup.getInt("selected_item");
      if (paramViewGroup.containsKey("selected_data"))
      {
        localObject = (ArrayList)paramViewGroup.getSerializable("selected_data");
        localPanelIconLinearLayout.qI.clear();
        localPanelIconLinearLayout.qI.addAll((Collection)localObject);
      }
      localPanelIconLinearLayout.ces();
      localPanelIconLinearLayout.setSelected(this.panelType);
      if (paramViewGroup.containsKey("flow_key_need_poke_red")) {
        localPanelIconLinearLayout.setShowRed(23, paramViewGroup.getBoolean("flow_key_need_poke_red"));
      }
      this.de = localPanelIconLinearLayout;
      return;
    }
    throw new RuntimeException("No pass args SELECTED_ITEM");
  }
  
  public void cwK()
  {
    this.de.setVisibility(0);
  }
  
  public void hidePanel()
  {
    this.de.setVisibility(4);
  }
  
  public void k(Object paramObject)
  {
    Intent localIntent = ((FlowActivity)getContext()).getIntent();
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      return;
    }
    int i = ((Integer)paramObject).intValue();
    QLog.d("XPanel", 2, " FlowPlusPanel  onPanelIconClick  i==" + i + "panelType===" + this.panelType);
    localIntent.putExtra("click_item", i);
    ((FlowActivity)getContext()).setResult(1000, localIntent);
    ((FlowActivity)getContext()).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaqm
 * JD-Core Version:    0.7.0.1
 */