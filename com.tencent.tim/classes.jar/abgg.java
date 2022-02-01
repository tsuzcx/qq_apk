import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abgg
  implements View.OnClickListener
{
  abgg(abge paramabge) {}
  
  public void onClick(View paramView)
  {
    this.this$0.k.eiZ();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).eiW();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof TroopInfo))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)localObject;
    boolean bool = ((TroopManager)this.this$0.app.getManager(52)).kv(localTroopInfo.troopuin);
    localObject = (accc)this.this$0.app.getBusinessHandler(22);
    int i;
    label111:
    anov localanov;
    label133:
    label205:
    String str;
    if (bool)
    {
      i = 1;
      if (!((accc)localObject).N(localTroopInfo.troopcode, i)) {
        break label261;
      }
      if (!bool) {
        break label263;
      }
      localObject = "Clk_uncommgrp";
      anot.a(this.this$0.app, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject, 0, 0, localTroopInfo.troopuin, "", "", "");
      localanov = new anov(this.this$0.app).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label270;
      }
      localObject = "Clk_unstick";
      localanov = localanov.d((String)localObject);
      str = localTroopInfo.troopuin;
      if (!localTroopInfo.hasSetTroopHead()) {
        break label277;
      }
    }
    label261:
    label263:
    label270:
    label277:
    for (localObject = "1";; localObject = "0")
    {
      localanov.a(new String[] { str, localObject }).report();
      break;
      i = 0;
      break label111;
      break;
      localObject = "Clk_setcommgrp";
      break label133;
      localObject = "Clk_stick";
      break label205;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abgg
 * JD-Core Version:    0.7.0.1
 */