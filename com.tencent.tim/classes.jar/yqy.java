import com.tencent.mobileqq.activity.contact.addfriendverifi.AddFriendBlockedInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class yqy
  implements acci
{
  protected void P(boolean paramBoolean, Object paramObject) {}
  
  protected void Q(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, List<AddFriendBlockedInfo> paramList, String paramString) {}
  
  protected void ak(boolean paramBoolean, String paramString) {}
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendVerification.obsever", 2, " onUpdate() type =" + paramInt + " isSuccess = " + paramBoolean);
    }
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.obsever", 2, " default type =" + paramInt);
      }
      return;
    case 1: 
      Q(paramBoolean, null);
      return;
    case 2: 
      P(paramBoolean, null);
      return;
    case 3: 
      paramObject = (Object[])paramObject;
      boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
      boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
      paramObject = (String)paramObject[2];
      if (QLog.isColorLevel()) {
        QLog.d("NewFriendVerification.obsever", 2, " isShowEntrance =" + bool1 + " isShowRedPoint =" + bool2);
      }
      d(paramBoolean, bool1, bool2, paramObject);
      return;
    case 4: 
      paramObject = (Object[])paramObject;
      List localList = (List)paramObject[0];
      String str = (String)paramObject[1];
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append(" blockedInfos =");
        if (localList == null) {
          break label297;
        }
      }
      label297:
      for (paramObject = Integer.valueOf(localList.size());; paramObject = " is null")
      {
        QLog.d("NewFriendVerification.obsever", 2, paramObject);
        a(paramBoolean, localList, str);
        return;
      }
    }
    paramObject = (Object[])paramObject;
    ak(((Boolean)paramObject[0]).booleanValue(), (String)paramObject[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yqy
 * JD-Core Version:    0.7.0.1
 */