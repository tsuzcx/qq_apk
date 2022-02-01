import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.a;
import com.tencent.mobileqq.activity.TroopMemberListActivity.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.relationx.addFrd.AddFrdHelper.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class alud
  implements View.OnClickListener
{
  private alud.a a;
  public aluf a;
  public TroopMemberListActivity a;
  public TroopMemberListActivity.a b;
  public boolean brp;
  public int cdr = 0;
  public final ArrayList<String> kN;
  private acfd n = new alue(this);
  
  public alud(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = paramTroopMemberListActivity;
    this.kN = new ArrayList(5);
    this.jdField_a_of_type_Aluf = ((acff)paramTroopMemberListActivity.app.getManager(51)).a();
    paramTroopMemberListActivity.app.addObserver(this.n);
  }
  
  public void a(TroopMemberListActivity.h paramh, TroopMemberListActivity.a parama)
  {
    if (paramh == null) {}
    Object localObject;
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramh.vD == null) || (localObject == null));
      localTroopInfo = ((TroopMemberListActivity)localObject).b;
      localObject = ((TroopMemberListActivity)localObject).app;
      int i;
      if (parama == null) {
        i = 0;
      }
      for (;;)
      {
        if (i == 0) {
          break label266;
        }
        paramh.vD.setVisibility(0);
        localButton = (Button)paramh.vD.findViewById(2131362204);
        paramh = (TextView)paramh.vD.findViewById(2131362206);
        if (parama.bMc != 2) {
          break;
        }
        localButton.setVisibility(8);
        paramh.setVisibility(0);
        return;
        if ((parama.bMc == 3) || (parama.bMc == 2)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      if (parama.bMc != 3) {
        break;
      }
      localButton.setTag(parama);
      localButton.setOnClickListener(this);
      localButton.setText(acfp.m(2131702047));
      localButton.setVisibility(0);
      paramh.setVisibility(8);
    } while (this.brp);
    this.brp = true;
    parama = "";
    paramh = "";
    if (localTroopInfo != null)
    {
      paramh = localTroopInfo.troopuin;
      parama = String.valueOf(localTroopInfo.dwGroupClassExt);
    }
    new anov((QQAppInterface)localObject).b("Grp_mber").c("mber_list").d("add_exp").a(new String[] { paramh, parama }).report();
    return;
    localButton.setVisibility(8);
    paramh.setVisibility(8);
    return;
    label266:
    paramh.vD.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Alud$a == null) {
        cpy();
      }
    } while ((!this.jdField_a_of_type_Alud$a.ug.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Alud$a.cds));
    return true;
  }
  
  public void b(TroopMemberListActivity.a parama)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    aluf localaluf = this.jdField_a_of_type_Aluf;
    if ((parama == null) || (localTroopMemberListActivity == null)) {
      return;
    }
    if (!a(localTroopMemberListActivity.b))
    {
      parama.bMc = 0;
      return;
    }
    if (localaluf != null)
    {
      if (((aptw)localTroopMemberListActivity.app.getManager(203)).gM(parama.uin))
      {
        parama.bMc = 0;
        return;
      }
      parama.bMc = localaluf.e(parama.uin, localTroopMemberListActivity.app);
      return;
    }
    parama.bMc = 0;
  }
  
  public void bz(int paramInt, String paramString)
  {
    if (paramInt > this.cdr) {
      this.cdr = paramInt;
    }
    if ((this.cdr < 2) && (!TextUtils.isEmpty(paramString))) {}
    try
    {
      this.kN.add(paramString);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        cpx();
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      } while ((paramString == null) || (!paramString.isResume()));
      paramString.runOnUiThread(new AddFrdHelper.1(this));
    }
  }
  
  public void cpx()
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if ((localTroopMemberListActivity == null) || (localTroopMemberListActivity.isFinishing()) || (!localTroopMemberListActivity.isResume())) {
      if (QLog.isColorLevel()) {
        QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
      }
    }
    do
    {
      return;
      if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
    return;
    TroopMemberListActivity.a locala;
    if (this.cdr == 1) {
      try
      {
        Iterator localIterator1 = localTroopMemberListActivity.pr.iterator();
        while (localIterator1.hasNext())
        {
          locala = (TroopMemberListActivity.a)localIterator1.next();
          if ((locala != null) && (this.kN.contains(locala.uin))) {
            b(locala);
          }
        }
        this.cdr = 0;
      }
      catch (Throwable localThrowable2)
      {
        localThrowable2.printStackTrace();
        localTroopMemberListActivity.bXo();
      }
    }
    for (;;)
    {
      try
      {
        this.kN.clear();
        return;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        return;
      }
      if (this.cdr != 2) {
        continue;
      }
      try
      {
        Iterator localIterator2 = localThrowable1.pr.iterator();
        while (localIterator2.hasNext())
        {
          locala = (TroopMemberListActivity.a)localIterator2.next();
          if (locala != null) {
            b(locala);
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
        localThrowable1.bXo();
      }
    }
  }
  
  protected void cpy()
  {
    if (this.jdField_a_of_type_Alud$a == null)
    {
      TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (localTroopMemberListActivity != null)
      {
        localObject1 = localObject2;
        if (localTroopMemberListActivity.app != null) {
          localObject1 = localTroopMemberListActivity.app.getCurrentAccountUin();
        }
      }
      this.jdField_a_of_type_Alud$a = new alud.a((String)localObject1);
    }
  }
  
  public void destroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    if (localObject != null)
    {
      localObject = ((TroopMemberListActivity)localObject).app;
      if (localObject != null) {
        ((QQAppInterface)localObject).removeObserver(this.n);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity = null;
    this.jdField_a_of_type_Aluf = null;
  }
  
  public void onClick(View paramView)
  {
    TroopMemberListActivity localTroopMemberListActivity = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity;
    Object localObject = paramView.getTag();
    if ((localTroopMemberListActivity != null) && ((localObject instanceof TroopMemberListActivity.a)))
    {
      TroopMemberListActivity.a locala = (TroopMemberListActivity.a)localObject;
      this.b = locala;
      String str = localTroopMemberListActivity.aKI;
      localObject = str;
      if (str == null)
      {
        localObject = str;
        if (localTroopMemberListActivity.b != null) {
          localObject = localTroopMemberListActivity.b.troopcode;
        }
      }
      localTroopMemberListActivity.startActivity(AddFriendLogicActivity.a(localTroopMemberListActivity, 1, locala.uin, (String)localObject, 3004, 13, locala.aRl, null, null, null, null));
      localObject = "";
      if (localTroopMemberListActivity.b != null) {
        localObject = String.valueOf(localTroopMemberListActivity.b.dwGroupClassExt);
      }
      new anov(localTroopMemberListActivity.app).b("Grp_mber").c("mber_list").d("add_clk").a(new String[] { "", localObject }).report();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onResume()
  {
    if (this.b != null)
    {
      b(this.b);
      bz(1, this.b.uin);
    }
    for (;;)
    {
      this.b = null;
      return;
      cpx();
    }
  }
  
  public static class a
  {
    int cds = 0;
    final List<Long> ug = new ArrayList(5);
    
    public a(String paramString)
    {
      try
      {
        paramString = aehn.aS(paramString, "troop_member_list_config");
        if (paramString != null)
        {
          Object localObject = new JSONObject(paramString);
          this.cds = ((JSONObject)localObject).optInt("maxTroopMemberSize");
          localObject = ((JSONObject)localObject).optJSONArray("troopClassIdList");
          while ((localObject != null) && (i < ((JSONArray)localObject).length()))
          {
            this.ug.add(Long.valueOf(((JSONArray)localObject).optLong(i)));
            i += 1;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("AddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", new Object[] { Integer.valueOf(this.cds), TextUtils.join(",", this.ug), paramString }));
        }
        return;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alud
 * JD-Core Version:    0.7.0.1
 */