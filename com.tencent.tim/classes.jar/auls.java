import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.sso.cmd.TimDocSSOMsg.UinRightInfo;
import com.tencent.tim.teamwork.PadInfo;
import com.tencent.tim.teamwork.TeamWorkTransparentShareActivity;
import com.tencent.tim.teamwork.TeamWorkTransparentShareActivity.3.1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class auls
  extends aulm
{
  public auls(TeamWorkTransparentShareActivity paramTeamWorkTransparentShareActivity) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TeamWorkTransparentShareActivity", 2, "onCopyPad|suc=" + paramBoolean + ",padUrl=" + paramString1 + ",domain=" + paramInt1 + ",padId=" + paramString2 + "ret=" + paramInt2);
    }
    if (this.this$0.isFinishing()) {
      return;
    }
    paramString1 = new TeamWorkTransparentShareActivity.3.1(this, paramBoolean, paramInt2, paramString1);
    long l = System.currentTimeMillis() - TeamWorkTransparentShareActivity.a(this.this$0);
    if (l < 1500L)
    {
      this.this$0.mUIHandler.postDelayed(paramString1, 1500L - l);
      return;
    }
    paramString1.run();
  }
  
  public void e(boolean paramBoolean, String paramString, int paramInt, List<TimDocSSOMsg.UinRightInfo> paramList)
  {
    super.e(paramBoolean, paramString, paramInt, paramList);
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkTransparentShareActivity", 1, "onGetNewPadRightsInfo not success");
      }
    }
    do
    {
      do
      {
        return;
        if (paramString.equalsIgnoreCase(this.this$0.cjl)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mismatch");
      return;
      if ((this.this$0.dNK == paramInt) || (paramString.equalsIgnoreCase(this.this$0.cjl))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mismatch");
    return;
    TeamWorkTransparentShareActivity.a(this.this$0).clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    label125:
    int i;
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label387;
      }
      paramString = (TimDocSSOMsg.UinRightInfo)paramList.next();
      aukn.b localb = new aukn.b();
      localb.uin = String.valueOf(paramString.uint64_uin.get());
      localb.c = paramString;
      TeamWorkTransparentShareActivity.a(this.this$0).add(0, localb);
      this.this$0.mCache.put(localb.uin, localb);
      String str = String.valueOf(localb.c.uint64_uin.get());
      paramString = this.this$0.nO(str);
      i = localb.c.uint32_right.get();
      if (i != 1)
      {
        if (i != 2) {
          break label358;
        }
        if (this.this$0.getCurrentAccountUin().equals(str)) {
          paramString = "我";
        }
        if (paramString == null) {
          break;
        }
        localArrayList.add(paramString);
      }
    }
    label387:
    for (paramString = null;; paramString = localArrayList)
    {
      TeamWorkTransparentShareActivity.a(this.this$0, paramInt);
      if ((TeamWorkTransparentShareActivity.a(this.this$0) == null) || (TeamWorkTransparentShareActivity.a(this.this$0).cD() == null)) {
        break;
      }
      TeamWorkTransparentShareActivity.a(this.this$0, TeamWorkTransparentShareActivity.a(this.this$0));
      TeamWorkTransparentShareActivity.a(this.this$0, paramString, TeamWorkTransparentShareActivity.a(this.this$0));
      return;
      label358:
      QLog.e("TeamWorkTransparentShareActivity", 1, "team docs rights error:" + i);
      break label125;
    }
  }
  
  public void u(boolean paramBoolean, String paramString, int paramInt)
  {
    super.u(paramBoolean, paramString, paramInt);
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("TeamWorkTransparentShareActivity", 2, "onGetPadRightsInfo not success");
      }
    }
    do
    {
      return;
      if ((this.this$0.dNK == paramInt) || (paramString.equalsIgnoreCase(this.this$0.cjl))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("TeamWorkTransparentShareActivity", 2, "padInfo mismatch");
    return;
    Object localObject = (aull)this.this$0.app.getManager(372);
    if (localObject != null) {}
    for (paramString = ((aull)localObject).a(paramString, paramInt);; paramString = null)
    {
      if ((paramString == null) && (QLog.isDevelopLevel())) {
        QLog.i("TeamWorkTransparentShareActivity", 1, "padInfo is null, maybe is newpad");
      }
      TeamWorkTransparentShareActivity.a(this.this$0).clear();
      ArrayList localArrayList = new ArrayList();
      if (paramString == null) {
        break;
      }
      Iterator localIterator = paramString.getRightList().iterator();
      for (;;)
      {
        label150:
        if (!localIterator.hasNext()) {
          break label420;
        }
        localObject = (TimDocSSOMsg.UinRightInfo)localIterator.next();
        aukn.b localb = new aukn.b();
        localb.uin = String.valueOf(((TimDocSSOMsg.UinRightInfo)localObject).uint64_uin.get());
        localb.c = ((TimDocSSOMsg.UinRightInfo)localObject);
        TeamWorkTransparentShareActivity.a(this.this$0).add(0, localb);
        this.this$0.mCache.put(localb.uin, localb);
        String str = String.valueOf(localb.c.uint64_uin.get());
        localObject = this.this$0.nO(str);
        paramInt = localb.c.uint32_right.get();
        if (paramInt != 1)
        {
          if (paramInt != 2) {
            break label392;
          }
          if (this.this$0.getCurrentAccountUin().equals(str)) {
            localObject = "我";
          }
          if (localObject == null) {
            break;
          }
          localArrayList.add(localObject);
        }
      }
      label392:
      label420:
      for (localObject = null;; localObject = localArrayList)
      {
        TeamWorkTransparentShareActivity.a(this.this$0, paramString.policy);
        if ((TeamWorkTransparentShareActivity.a(this.this$0) == null) || (TeamWorkTransparentShareActivity.a(this.this$0).cD() == null)) {
          break;
        }
        TeamWorkTransparentShareActivity.a(this.this$0, TeamWorkTransparentShareActivity.a(this.this$0));
        TeamWorkTransparentShareActivity.a(this.this$0, (List)localObject, TeamWorkTransparentShareActivity.a(this.this$0));
        return;
        QLog.e("TeamWorkTransparentShareActivity", 1, "team docs rights error:" + paramInt);
        break label150;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auls
 * JD-Core Version:    0.7.0.1
 */