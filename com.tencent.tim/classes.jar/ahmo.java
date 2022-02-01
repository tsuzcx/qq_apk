import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.applets.data.AppletItem;
import com.tencent.mobileqq.fragment.AppletsSettingFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahmo
  extends adah
{
  public ahmo(AppletsSettingFragment paramAppletsSettingFragment) {}
  
  protected void onGetAppletsSettingSwitch(boolean paramBoolean, List<adao> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onGetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramBoolean)
    {
      HashSet localHashSet = new HashSet();
      if ((paramList != null) && (paramBoolean) && (paramList.size() > 0))
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (adao)paramList.next();
          Object localObject2;
          if ((((adao)localObject1).items != null) && (((adao)localObject1).items.size() > 0) && (((adao)localObject1).items.get(0) != null) && (((AppletItem)((adao)localObject1).items.get(0)).getId() == 1L))
          {
            AppletsSettingFragment.a(this.this$0, (AppletItem)((adao)localObject1).items.get(0));
            if (!TextUtils.isEmpty(AppletsSettingFragment.a(this.this$0).getName()))
            {
              AppletsSettingFragment.a(this.this$0).setText(AppletsSettingFragment.a(this.this$0).getName());
              this.this$0.a.Ar(AppletsSettingFragment.a(this.this$0).getName());
            }
            localObject2 = AppletsSettingFragment.a(this.this$0);
            if (AppletsSettingFragment.a(this.this$0).getValue() == 1)
            {
              paramBoolean = true;
              label247:
              ((Switch)localObject2).setChecked(paramBoolean);
              localObject2 = this.this$0.a;
              if (AppletsSettingFragment.a(this.this$0).getValue() != 1) {
                break label333;
              }
            }
            label333:
            for (paramBoolean = true;; paramBoolean = false)
            {
              ((aagv)localObject2).Ci(paramBoolean);
              if (TextUtils.isEmpty(((adao)localObject1).des)) {
                break;
              }
              AppletsSettingFragment.b(this.this$0).setText(((adao)localObject1).des);
              this.this$0.a.An(((adao)localObject1).des);
              break;
              paramBoolean = false;
              break label247;
            }
          }
          if (!TextUtils.isEmpty(((adao)localObject1).des))
          {
            AppletsSettingFragment.c(this.this$0).setText(((adao)localObject1).des);
            this.this$0.a.Ao(((adao)localObject1).des);
          }
          if ((((adao)localObject1).items != null) && (((adao)localObject1).items.size() > 0))
          {
            AppletsSettingFragment.a(this.this$0).clear();
            localObject1 = ((adao)localObject1).items.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AppletItem)((Iterator)localObject1).next();
              AppletsSettingFragment.a(this.this$0).put(AppletsSettingFragment.a(this.this$0, (AppletItem)localObject2), localObject2);
              if ((((AppletItem)localObject2).getId() != 1L) && (((AppletItem)localObject2).getValue() != 1)) {
                localHashSet.add(String.valueOf(((AppletItem)localObject2).getId()));
              }
            }
            AppletsSettingFragment.a(this.this$0, new ArrayList(AppletsSettingFragment.a(this.this$0).values()));
          }
        }
      }
      this.this$0.a.l(localHashSet);
      return;
    }
    this.this$0.oh(2131690431);
  }
  
  protected void onSetAppletsSettingSwitch(boolean paramBoolean, List<AppletItem> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppletsSettingFragment", 2, "onSetAppletsSettingSwitch:  isSuccess: " + paramBoolean);
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (AppletItem)paramList.next();
        this.this$0.showProgressBar(false);
        if (!paramBoolean) {
          this.this$0.oh(2131690432);
        }
        Object localObject2;
        int i;
        if (((AppletItem)localObject1).getId() == 1L)
        {
          localObject2 = AppletsSettingFragment.a(this.this$0);
          if (paramBoolean)
          {
            i = ((AppletItem)localObject1).getValue();
            label112:
            ((AppletItem)localObject2).setValue(i);
            localObject1 = AppletsSettingFragment.a(this.this$0);
            if (AppletsSettingFragment.a(this.this$0).getValue() != 1) {
              break label216;
            }
            bool = true;
            label144:
            ((Switch)localObject1).setChecked(bool);
            if (this.this$0.a == null) {
              continue;
            }
            localObject1 = this.this$0.a;
            if (AppletsSettingFragment.a(this.this$0).getValue() != 1) {
              break label222;
            }
          }
          label216:
          label222:
          for (boolean bool = true;; bool = false)
          {
            ((aagv)localObject1).Ci(bool);
            break;
            if (((AppletItem)localObject1).getValue() == 1)
            {
              i = 0;
              break label112;
            }
            i = 1;
            break label112;
            bool = false;
            break label144;
          }
        }
        else
        {
          localObject2 = AppletsSettingFragment.a(this.this$0, (AppletItem)localObject1);
          localObject2 = (AppletItem)AppletsSettingFragment.a(this.this$0).get(localObject2);
          if (localObject2 != null)
          {
            if (!paramBoolean) {
              break label347;
            }
            i = ((AppletItem)localObject1).getValue();
          }
          for (;;)
          {
            ((AppletItem)localObject2).setValue(i);
            AppletsSettingFragment.a(this.this$0);
            AppletsSettingFragment.a(this.this$0, new ArrayList(AppletsSettingFragment.a(this.this$0).values()));
            if (this.this$0.a == null) {
              break;
            }
            if (((AppletItem)localObject2).getValue() != 0) {
              break label366;
            }
            this.this$0.a.Ap(String.valueOf(((AppletItem)localObject2).getId()));
            break;
            label347:
            if (((AppletItem)localObject1).getValue() == 1) {
              i = 0;
            } else {
              i = 1;
            }
          }
          label366:
          this.this$0.a.Aq(String.valueOf(((AppletItem)localObject2).getId()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahmo
 * JD-Core Version:    0.7.0.1
 */