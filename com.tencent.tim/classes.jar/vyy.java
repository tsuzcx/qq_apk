import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.activity.TroopGagActivity;
import com.tencent.mobileqq.activity.TroopGagActivity.2.1;
import com.tencent.mobileqq.activity.TroopGagActivity.a;
import com.tencent.mobileqq.activity.TroopGagActivity.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class vyy
  extends accd
{
  public vyy(TroopGagActivity paramTroopGagActivity) {}
  
  protected void a(apsw.b paramb)
  {
    if ((paramb == null) || (!paramb.uin.equals(this.this$0.troopCode))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGagActivity", 2, "onTroopGagStatusChange, statuCode=" + paramb.dVM);
    }
    TroopManager.d locald;
    TroopGagActivity.a locala;
    if (paramb.dVM == 3)
    {
      this.this$0.rl.clear();
      if (paramb.Cn != null)
      {
        paramb = paramb.Cn.iterator();
        while (paramb.hasNext())
        {
          locald = (TroopManager.d)paramb.next();
          locala = new TroopGagActivity.a();
          locala.uin = locald.sUin;
          locala.Hc = locald.QU;
          this.this$0.rl.add(locala);
        }
      }
      this.this$0.a.notifyDataSetChanged();
    }
    while (this.this$0.rl.size() == 0)
    {
      this.this$0.vp.setVisibility(8);
      return;
      if (paramb.dVM == 1)
      {
        paramb = paramb.jdField_a_of_type_Apsw$f;
        this.this$0.d.setOnCheckedChangeListener(null);
        if (paramb.gagTimeStamp != 0L) {
          this.this$0.d.setChecked(true);
        }
        for (;;)
        {
          this.this$0.d.setOnCheckedChangeListener(this.this$0);
          break;
          this.this$0.d.setChecked(false);
        }
      }
      if (paramb.dVM == 5)
      {
        if (!paramb.jdField_a_of_type_Apsw$c.cSj)
        {
          ThreadManager.post(new TroopGagActivity.2.1(this, new Handler(Looper.getMainLooper())), 8, null, false);
        }
        else
        {
          this.this$0.rl.clear();
          if (paramb.Cn != null)
          {
            paramb = paramb.Cn.iterator();
            while (paramb.hasNext())
            {
              locald = (TroopManager.d)paramb.next();
              locala = new TroopGagActivity.a();
              locala.uin = locald.sUin;
              locala.Hc = locald.QU;
              this.this$0.rl.add(locala);
            }
          }
          this.this$0.a.notifyDataSetChanged();
        }
      }
      else if (paramb.dVM == 4)
      {
        paramb = paramb.jdField_a_of_type_Apsw$d;
        if (!paramb.cSj)
        {
          this.this$0.d.setOnCheckedChangeListener(null);
          if (paramb.timeStamp != 0L) {
            this.this$0.d.setChecked(false);
          }
          for (;;)
          {
            this.this$0.d.setOnCheckedChangeListener(this.this$0);
            break;
            this.this$0.d.setChecked(true);
          }
        }
      }
    }
    this.this$0.vp.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vyy
 * JD-Core Version:    0.7.0.1
 */