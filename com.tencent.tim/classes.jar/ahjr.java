import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ahjr
  extends ahjc
{
  public ahjr(Intent paramIntent)
  {
    super(paramIntent);
    this.cgR = true;
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected void dnv()
  {
    dos();
    super.dnv();
  }
  
  public void dos()
  {
    Object localObject1 = anre.a(this.bf);
    if ((localObject1 == null) || (TextUtils.isEmpty(((AbsStructMsg)localObject1).mMsg_A_ActionData))) {}
    for (;;)
    {
      return;
      Object localObject2 = aqik.c(this.app, this.mAppContext, ((AbsStructMsg)localObject1).mMsg_A_ActionData);
      if (localObject2 == null) {
        continue;
      }
      localObject1 = ((aqhv)localObject2).getAttribute("usertype");
      localObject2 = ((aqhv)localObject2).getAttribute("unionid");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        continue;
      }
      try
      {
        i = Integer.parseInt((String)localObject1);
        rar.a("share_uin", "qq_suc", apuh.jP(this.bf.getInt("uintype")), i, new String[] { localObject2 });
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqstory.shareAccount", 2, "shareToQQ success userType:" + i + ",userUnionId:" + (String)localObject2);
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjr
 * JD-Core Version:    0.7.0.1
 */