import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.EditInfoActivity;
import com.tencent.mobileqq.activity.EditInfoActivity.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.ColorClearableEditText;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

public class uvz
  implements View.OnClickListener
{
  public uvz(EditInfoActivity paramEditInfoActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.this$0.aA.getText();
    if (localObject1 != null) {}
    for (localObject1 = new aofk(localObject1.toString(), 3);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 == null)
      {
        localObject2 = "";
        if (localObject1 != null) {
          break label100;
        }
        localObject1 = "";
        label43:
        if (this.this$0.aVN) {
          break label302;
        }
        if (this.this$0.bGI != 0) {
          break label292;
        }
        this.this$0.gR();
        if (this.this$0.Z((String)localObject2, (String)localObject1)) {
          break label108;
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject2 = ((aofk)localObject1).toString();
        break;
        label100:
        localObject1 = ((aofk)localObject1).trim();
        break label43;
        label108:
        if ((this.this$0.AH == null) || (this.this$0.AH.length() == 0))
        {
          if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
            EditInfoActivity.a(this.this$0);
          }
        }
        else {
          if ((localObject1 != null) && (((String)localObject1).length() != 0)) {
            break label246;
          }
        }
        label246:
        while (!this.this$0.AH.equals(localObject1))
        {
          localObject3 = localObject1;
          if (this.this$0.mFromFlag != 3) {
            break label270;
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() >= 1) {}
          }
          else
          {
            localObject2 = "";
          }
          localObject3 = localObject2;
          if (!this.this$0.hi((String)localObject2)) {
            break label270;
          }
          QQToast.a(this.this$0, this.this$0.getString(2131694968), 0).show(this.this$0.getTitleBarHeight());
          break;
        }
        EditInfoActivity.b(this.this$0);
        continue;
        label270:
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        this.this$0.doAction((String)localObject1);
        continue;
        label292:
        this.this$0.bsq();
        continue;
        label302:
        VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "group_nickname", "group_nickname_7", "", 1, 0, 0, "", "", "");
        if (aqiw.isNetSupport(this.this$0.app.getApplication().getApplicationContext())) {
          break label374;
        }
        QQToast.a(this.this$0, 1, 2131696272, 0).show(this.this$0.getTitleBarHeight());
      }
      label374:
      Object localObject3 = localObject1;
      EditInfoActivity.c localc;
      if (EditInfoActivity.a(this.this$0))
      {
        localc = new EditInfoActivity.c(null);
        if (EditInfoActivity.a(this.this$0, localc))
        {
          this.this$0.xa(true);
          localObject1 = (aqrb)this.this$0.app.getBusinessHandler(71);
          localObject2 = ((ColorClearableEditText)this.this$0.aA).ee().iterator();
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
          } while (((ColorClearableEditText.a)((Iterator)localObject2).next()).type != 1);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0)
        {
          QQToast.a(this.this$0, acfp.m(2131705396), 0).show(this.this$0.getTitleBarHeight());
          break;
        }
        ((aqrb)localObject1).B(this.this$0.mTroopUin, ((ColorClearableEditText)this.this$0.aA).ee());
        this.this$0.aVP = true;
        break;
        localObject3 = localObject1;
        if (localc.aVS)
        {
          localObject3 = localObject1;
          if (!localc.hasText) {
            localObject3 = "";
          }
        }
        if (((this.this$0.mAction == 3) || (this.this$0.mAction == 4)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          QQToast.a(this.this$0, this.this$0.getString(2131694844), 0).show(this.this$0.getTitleBarHeight());
          break;
        }
        if (((TextUtils.isEmpty(this.this$0.AH)) && (TextUtils.isEmpty((CharSequence)localObject3))) || ((!TextUtils.isEmpty(this.this$0.AH)) && (this.this$0.AH.equals(localObject3))))
        {
          EditInfoActivity.c(this.this$0);
          break;
        }
        localObject2 = new TroopMemberCardInfo();
        ((TroopMemberCardInfo)localObject2).name = ((String)localObject3);
        ((TroopMemberCardInfo)localObject2).memberuin = this.this$0.uin;
        ((TroopMemberCardInfo)localObject2).troopuin = this.this$0.mTroopUin;
        ((TroopMemberCardInfo)localObject2).email = "";
        ((TroopMemberCardInfo)localObject2).memo = "";
        ((TroopMemberCardInfo)localObject2).sex = -1;
        ((TroopMemberCardInfo)localObject2).tel = "";
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(localObject2);
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Integer.valueOf(1));
        localObject3 = (acms)this.this$0.app.getBusinessHandler(20);
        if ((localObject3 != null) && (!TextUtils.isEmpty(this.this$0.mTroopUin)))
        {
          this.this$0.xa(true);
          ((acms)localObject3).b(this.this$0.mTroopUin, (ArrayList)localObject1, (ArrayList)localObject2);
        }
        localObject1 = (TroopManager)this.this$0.app.getManager(52);
        if (localObject1 != null)
        {
          localObject1 = ((TroopManager)localObject1).b(this.this$0.mTroopUin);
          if (localObject1 != null) {
            if ((!TextUtils.isEmpty(((TroopInfo)localObject1).troopowneruin)) && (((TroopInfo)localObject1).troopowneruin.equalsIgnoreCase(this.this$0.app.getAccount()))) {
              i = 0;
            }
          }
        }
        for (;;)
        {
          this.this$0.aVP = true;
          anot.a(this.this$0.app, "P_CliOper", "Grp_manage", "", "modify_name", "complete", 0, 0, this.this$0.mTroopUin, i + "", "" + this.this$0.mFromFlag, "");
          break;
          if ((!TextUtils.isEmpty(((TroopInfo)localObject1).Administrator)) && (((TroopInfo)localObject1).Administrator.contains(this.this$0.app.getAccount()))) {
            i = 1;
          } else {
            i = 2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uvz
 * JD-Core Version:    0.7.0.1
 */