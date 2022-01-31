import android.os.Bundle;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicLong;

public class yhl
  implements Observer
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  
  public yhl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      int i;
      do
      {
        do
        {
          return;
          paramObservable = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((paramObservable == null) || (paramObject == null) || (!(paramObject instanceof Bundle)));
        i = ((Bundle)paramObject).getInt("TO");
        if ((i == 5) || (i == 4))
        {
          long l = System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
          paramObject = CmGameMainManager.a();
          if ((paramObject != null) && (paramObject.a != null))
          {
            if (paramObservable != null)
            {
              VipUtils.a(paramObservable, "cmshow", "Apollo", "game_time", 0, 0, new String[] { paramObject.a.game.gameId + "", String.valueOf(paramObject.a.gameMode), String.valueOf(l), String.valueOf(paramObject.a.roomId) });
              if (QLog.isColorLevel()) {
                QLog.d("ApolloManager", 2, new Object[] { "[update] mGameTimeObserver report: id:", Integer.valueOf(paramObject.a.game.gameId), "# roomId:", Long.valueOf(paramObject.a.roomId), "# mode:", Integer.valueOf(paramObject.a.gameMode), "# [", Long.valueOf(l), "] #", Long.valueOf(System.currentTimeMillis()) });
              }
            }
            for (;;)
            {
              this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
              return;
              QLog.e("ApolloManager", 1, "[update] mGameTimeObserver no app");
            }
          }
          QLog.e("ApolloManager", 1, "[update] mGameTimeObserver para invalid ");
          return;
        }
      } while (i != 3);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(System.currentTimeMillis());
    } while (!QLog.isColorLevel());
    QLog.d("ApolloManager", 2, new Object[] { "[update] mGameTimeObserver set time to ", Long.valueOf(this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yhl
 * JD-Core Version:    0.7.0.1
 */