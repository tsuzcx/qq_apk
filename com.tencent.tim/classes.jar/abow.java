import android.app.Activity;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLifeCycle.1;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class abow
{
  public static String TAG = "cmgame_process.CmGameLifeCycle";
  private aboa jdField_a_of_type_Aboa;
  private abon jdField_a_of_type_Abon;
  private WeakReference<Activity> aG;
  public int cpN;
  private CmGameStartChecker.StartCheckParam e;
  private int mGameId;
  
  public abow(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  private QQAppInterface getApp()
  {
    AppInterface localAppInterface = abmt.getAppInterface();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (QQAppInterface)localAppInterface;
    }
    return null;
  }
  
  private Activity p()
  {
    if (this.aG == null) {
      return null;
    }
    return (Activity)this.aG.get();
  }
  
  public void a(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    this.e = paramStartCheckParam;
    this.aG = new WeakReference(paramActivity);
  }
  
  public aboy b()
  {
    if (this.jdField_a_of_type_Aboa == null) {
      return null;
    }
    return this.jdField_a_of_type_Aboa.a();
  }
  
  public void cDJ()
  {
    if (this.jdField_a_of_type_Aboa != null)
    {
      aboy localaboy = this.jdField_a_of_type_Aboa.a();
      if ((localaboy != null) && (localaboy.bEx)) {
        ThreadManagerV2.getUIHandlerV2().post(new CmGameLifeCycle.1(this, localaboy));
      }
    }
  }
  
  public void cDK()
  {
    if (this.jdField_a_of_type_Aboa != null)
    {
      aboy localaboy = this.jdField_a_of_type_Aboa.a();
      if ((localaboy != null) && (localaboy.bEx)) {
        localaboy.cDQ();
      }
    }
  }
  
  public void gH(int paramInt1, int paramInt2)
  {
    QLog.i(TAG, 1, "[handleActLifeCycle], gameId:" + paramInt1 + ",status:" + paramInt2);
    Object localObject1 = getApp();
    if (localObject1 == null) {
      QLog.w(TAG, 1, "app is null.");
    }
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if ((2 == paramInt2) && (this.jdField_a_of_type_Aboa != null))
                {
                  localObject2 = this.jdField_a_of_type_Aboa.a();
                  if (localObject2 != null) {
                    ((aboy)localObject2).onActivityResume();
                  }
                }
                if (4 != paramInt2) {
                  break;
                }
              } while (this.jdField_a_of_type_Aboa == null);
              localObject1 = this.jdField_a_of_type_Aboa.a();
            } while (localObject1 == null);
            ((aboy)localObject1).onActivityStop();
            return;
            if (1 != paramInt2) {
              break;
            }
            localObject2 = p();
            if ((this.e == null) || (localObject2 == null))
            {
              QLog.w(TAG, 1, "null error.");
              return;
            }
            if (this.e.gameId != paramInt1)
            {
              QLog.w(TAG, 1, "not the same game.");
              return;
            }
            if (this.jdField_a_of_type_Aboa != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aboa);
            }
            if (this.jdField_a_of_type_Abon != null) {
              CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Abon);
            }
            this.jdField_a_of_type_Abon = new abon((Activity)localObject2, (QQAppInterface)localObject1, this.mGameId);
            CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Abon);
            if ((!abmt.hP(this.mGameId)) && (!abmt.hQ(this.mGameId)))
            {
              aboy localaboy = new aboy((Activity)localObject2, this.e);
              this.jdField_a_of_type_Aboa = new aboa((Activity)localObject2, localaboy, this.mGameId);
              CmGameCmdChannel.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_Aboa);
              localaboy.bM((Activity)localObject2);
              localaboy.cDO();
              localaboy.cDP();
              return;
            }
          } while (this.e.game != null);
          QLog.e(TAG, 1, "land or game box game data not exit");
          ApolloGameUtil.i((QQAppInterface)localObject1, 0L);
          return;
        } while (5 != paramInt2);
        if (this.jdField_a_of_type_Aboa != null)
        {
          localObject2 = this.jdField_a_of_type_Aboa.a();
          if (localObject2 != null) {
            ((aboy)localObject2).onDestroy();
          }
          this.jdField_a_of_type_Aboa.destroyHandler();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Aboa);
          this.jdField_a_of_type_Aboa = null;
        }
        if (this.jdField_a_of_type_Abon != null)
        {
          this.jdField_a_of_type_Abon.destroyHandler();
          CmGameCmdChannel.a((QQAppInterface)localObject1).b(this.jdField_a_of_type_Abon);
          this.jdField_a_of_type_Abon = null;
        }
      } while ((abmt.hP(this.mGameId)) || (abmt.hQ(this.mGameId)) || (getApp() == null));
      localObject1 = (abhh)getApp().getManager(153);
    } while ((localObject1 == null) || (!((abhh)localObject1).Yj()) || (abmt.B(null)) || (((abhh)localObject1).bCK) || (((abhh)localObject1).Yh()) || (((abhh)localObject1).Yi()) || (this.aG == null));
    ((abhh)localObject1).bCH = false;
    if ((this.e != null) && (this.e.src != 319) && (this.e.src != 318)) {
      abmt.bK((Activity)this.aG.get());
    }
    QLog.d(TAG, 1, "plus status first play goBackToPlus");
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public void o(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((this.e != null) && (paramStartCheckParam != null) && (paramStartCheckParam.game != null)) {
      this.e.game = paramStartCheckParam.game;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aboa != null) {
      this.jdField_a_of_type_Aboa.destroyHandler();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abow
 * JD-Core Version:    0.7.0.1
 */