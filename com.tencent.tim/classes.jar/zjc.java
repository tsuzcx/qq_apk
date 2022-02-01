import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.a;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.h;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zjc
  implements View.OnClickListener
{
  public aluf a;
  private aptw jdField_a_of_type_Aptw;
  private zjc.b jdField_a_of_type_Zjc$b;
  private QQAppInterface app;
  public ChatHistoryTroopMemberFragment.a b;
  private TroopInfo jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
  private zjc.a jdField_b_of_type_Zjc$a;
  private String bak;
  public boolean brp;
  public int cdr = 0;
  public final ArrayList<String> kN;
  private Context mContext;
  private acfd n = new zjd(this);
  private List<ChatHistoryTroopMemberFragment.a> pr;
  
  public zjc(Context paramContext, zjc.a parama, QQAppInterface paramQQAppInterface, TroopInfo paramTroopInfo, List<ChatHistoryTroopMemberFragment.a> paramList)
  {
    this.mContext = paramContext;
    this.kN = new ArrayList(5);
    this.jdField_a_of_type_Aluf = ((acff)paramQQAppInterface.getManager(51)).a();
    paramQQAppInterface.addObserver(this.n);
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_Aptw = ((aptw)paramQQAppInterface.getManager(203));
    this.jdField_b_of_type_Zjc$a = parama;
    this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo = paramTroopInfo;
    this.bak = paramQQAppInterface.getCurrentAccountUin();
    this.pr = paramList;
  }
  
  public void a(ChatHistoryTroopMemberFragment.h paramh, ChatHistoryTroopMemberFragment.a parama)
  {
    if (paramh == null) {}
    TroopInfo localTroopInfo;
    Button localButton;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramh.vD == null);
        localTroopInfo = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo;
        int i;
        if (parama == null) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0) {
            break label197;
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
        localButton.setText(acfp.m(2131716003));
        localButton.setVisibility(0);
        paramh.setVisibility(8);
      } while (this.brp);
      this.brp = true;
    } while (localTroopInfo == null);
    paramh = localTroopInfo.troopuin;
    long l = localTroopInfo.dwGroupClassExt;
    return;
    localButton.setVisibility(8);
    paramh.setVisibility(8);
    return;
    label197:
    paramh.vD.setVisibility(8);
  }
  
  public boolean a(TroopInfo paramTroopInfo)
  {
    if ((paramTroopInfo == null) || (paramTroopInfo.isQidianPrivateTroop())) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_Zjc$b == null) {
        cpy();
      }
    } while ((!this.jdField_a_of_type_Zjc$b.ug.contains(Long.valueOf(paramTroopInfo.dwGroupClassExt))) || (paramTroopInfo.wMemberNum > this.jdField_a_of_type_Zjc$b.cds));
    return true;
  }
  
  public void b(ChatHistoryTroopMemberFragment.a parama)
  {
    aluf localaluf = this.jdField_a_of_type_Aluf;
    if (parama == null) {
      return;
    }
    if (!a(this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo))
    {
      parama.bMc = 0;
      return;
    }
    if (localaluf != null)
    {
      if (this.jdField_a_of_type_Aptw.gM(parama.uin))
      {
        parama.bMc = 0;
        return;
      }
      parama.bMc = localaluf.e(parama.uin, this.app);
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
      } while (this.jdField_b_of_type_Zjc$a == null);
      this.jdField_b_of_type_Zjc$a.cpu();
    }
  }
  
  public void cpx()
  {
    ChatHistoryTroopMemberFragment.a locala;
    if (this.cdr == 1) {
      try
      {
        Iterator localIterator1 = this.pr.iterator();
        while (localIterator1.hasNext())
        {
          locala = (ChatHistoryTroopMemberFragment.a)localIterator1.next();
          if ((locala != null) && (this.kN.contains(locala.uin))) {
            b(locala);
          }
        }
        this.cdr = 0;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
        if (this.jdField_b_of_type_Zjc$a != null) {
          this.jdField_b_of_type_Zjc$a.cpv();
        }
      }
    }
    for (;;)
    {
      try
      {
        this.kN.clear();
        return;
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
      }
      if (this.cdr == 2)
      {
        try
        {
          Iterator localIterator2 = this.pr.iterator();
          if (localIterator2.hasNext())
          {
            locala = (ChatHistoryTroopMemberFragment.a)localIterator2.next();
            if (locala == null) {
              continue;
            }
            b(locala);
            continue;
          }
          if (this.jdField_b_of_type_Zjc$a == null) {
            continue;
          }
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
        this.jdField_b_of_type_Zjc$a.cpv();
      }
    }
  }
  
  protected void cpy()
  {
    if (this.jdField_a_of_type_Zjc$b == null) {
      this.jdField_a_of_type_Zjc$b = new zjc.b(this.bak);
    }
  }
  
  public void destroy()
  {
    this.app.removeObserver(this.n);
    this.jdField_a_of_type_Aluf = null;
    this.app = null;
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((this.mContext != null) && ((localObject instanceof ChatHistoryTroopMemberFragment.a)))
    {
      localObject = (ChatHistoryTroopMemberFragment.a)localObject;
      this.jdField_b_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$a = ((ChatHistoryTroopMemberFragment.a)localObject);
      String str = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.troopcode;
      localObject = AddFriendLogicActivity.a(this.mContext, 1, ((ChatHistoryTroopMemberFragment.a)localObject).uin, str, 3004, 13, ((ChatHistoryTroopMemberFragment.a)localObject).aRl, null, null, null, null);
      this.mContext.startActivity((Intent)localObject);
      if (this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo != null) {
        long l = this.jdField_b_of_type_ComTencentMobileqqDataTroopInfo.dwGroupClassExt;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onResume()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$a != null)
    {
      b(this.jdField_b_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$a);
      bz(1, this.jdField_b_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$a.uin);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$a = null;
      return;
      cpx();
    }
  }
  
  public static abstract interface a
  {
    public abstract void cpu();
    
    public abstract void cpv();
  }
  
  public static class b
  {
    int cds = 0;
    final List<Long> ug = new ArrayList(5);
    
    public b(String paramString)
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
          QLog.i("TroopMemberAddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", new Object[] { Integer.valueOf(this.cds), TextUtils.join(",", this.ug), paramString }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjc
 * JD-Core Version:    0.7.0.1
 */