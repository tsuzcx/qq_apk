import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel.a;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class aboa
  implements CmGameCmdChannel.a
{
  private aboy a;
  public WeakReference<Context> mContextRef;
  private int mGameId;
  
  public aboa(Activity paramActivity, aboy paramaboy, int paramInt)
  {
    this.mContextRef = new WeakReference(paramActivity);
    this.a = paramaboy;
    this.mGameId = paramInt;
  }
  
  public abjp a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    aboy localaboy = this.a;
    if ((!(localAppRuntime instanceof QQAppInterface)) || (localaboy == null)) {}
    do
    {
      do
      {
        return null;
        if (this.mGameId == paramInt2) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("CmGameHandler", 2, new Object[] { "not the same gameId, self:", Integer.valueOf(this.mGameId), "cmd gameId:", Integer.valueOf(paramInt2), ",cmd:", paramString1 });
      return null;
      if ("cs.first_frame_drawn.local".equals(paramString1))
      {
        localaboy.CF(paramString2);
        return null;
      }
      if ("cs.create_room.local".equals(paramString1))
      {
        localaboy.CG(paramString2);
        return null;
      }
      if ("cs.join_room.local".equals(paramString1))
      {
        localaboy.CH(paramString2);
        return null;
      }
      if ("cs.game_start.local".equals(paramString1))
      {
        localaboy.CI(paramString2);
        return null;
      }
      if ("cs.make_room_min.local".equals(paramString1))
      {
        localaboy.cDM();
        return null;
      }
      if ("cs.close_room.local".equals(paramString1))
      {
        localaboy.cDN();
        return null;
      }
      if ("cs.game_tips.local".equals(paramString1))
      {
        localaboy.CJ(ApolloUtil.aI(paramString2, "tips"));
        return null;
      }
      if ("cs.check_pubAccount_state.local".equals(paramString1))
      {
        localaboy.dh(paramString2, paramInt1);
        return null;
      }
    } while (!"cs.on_get_open_key.local".equals(paramString1));
    localaboy.di(paramString2, paramInt1);
    return null;
  }
  
  public aboy a()
  {
    return this.a;
  }
  
  public void destroyHandler()
  {
    QLog.i("CmGameHandler", 1, "[destroyHandler]");
    this.a = null;
  }
  
  public int zz()
  {
    return 200;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboa
 * JD-Core Version:    0.7.0.1
 */