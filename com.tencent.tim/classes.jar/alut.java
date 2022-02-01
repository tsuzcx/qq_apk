import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class alut
  extends acnd
{
  alut(alur paramalur) {}
  
  protected void E(String paramString, List<Pair<String, String>> paramList)
  {
    Object localObject = new StringBuilder().append("onGetTroopMemberListBy0x787 uin: ").append(paramString).append(" memberList size: ");
    if (paramList == null)
    {
      i = 0;
      QLog.i("IceBreak.HotPic", 2, i);
      if ((paramString != null) && (paramList != null) && (paramList.size() > 1)) {
        break label76;
      }
    }
    label76:
    while (!paramString.equals(alur.a(this.this$0)))
    {
      return;
      i = paramList.size();
      break;
    }
    localObject = (acff)this.this$0.app.getManager(51);
    String str1 = this.this$0.app.getCurrentAccountUin();
    int k = paramList.size();
    int j = 0;
    int i = 0;
    label133:
    if (j < k)
    {
      String str2 = (String)((Pair)paramList.get(j)).first;
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1)) || (((acff)localObject).isFriend(str2))) {
        break label283;
      }
      i += 1;
    }
    label283:
    for (;;)
    {
      j += 1;
      break label133;
      float f = alur.a(this.this$0) / 100.0F;
      QLog.i("IceBreak.HotPic", 1, "friendCount: " + i + " total count: " + paramList.size());
      if (1.0F * i / (paramList.size() - 1) <= f) {
        break;
      }
      this.this$0.Pd(paramString);
      return;
    }
  }
  
  protected void cG(String paramString, int paramInt)
  {
    this.this$0.Pe(paramString);
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt2 == 0) && ((paramInt1 == 9) || (paramInt1 == 2))) {
      this.this$0.Pe(paramString);
    }
  }
  
  protected void v(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard: isSuccess " + paramBoolean);
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        long l = ((Long)paramObject[0]).longValue();
        paramObject = (TroopMemberCard)paramObject[2];
        if (String.valueOf(l).equals(alur.a(this.this$0)))
        {
          QLog.i("IceBreak.HotPic", 1, " onGetTroopMemberCard last_active_time: " + paramObject.lastSpeak + " join_time: " + paramObject.joinTime);
          if (paramObject.lastSpeak > paramObject.joinTime) {
            return;
          }
          alur.a(this.this$0, String.valueOf(l));
          return;
        }
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.i("IceBreak.HotPic", 2, "onGetTroopMemberCard:" + paramObject.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alut
 * JD-Core Version:    0.7.0.1
 */