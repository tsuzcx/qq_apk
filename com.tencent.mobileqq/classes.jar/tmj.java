import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.ApolloManager.IDrawerGameBoxStatus;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;

public class tmj
  implements ApolloManager.IDrawerGameBoxStatus
{
  public tmj(QQSettingMe paramQQSettingMe) {}
  
  public void a(boolean paramBoolean)
  {
    if ((QQSettingMe.a(this.a) != null) && (QQSettingMe.a(this.a).a() != null)) {
      QQSettingMe.a(this.a).a().a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tmj
 * JD-Core Version:    0.7.0.1
 */