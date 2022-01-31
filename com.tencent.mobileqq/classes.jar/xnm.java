import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager;
import com.tencent.mobileqq.activity.qwallet.red.QWalletRedManager.ShowInfo;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.lang.ref.WeakReference;

public final class xnm
  implements Runnable
{
  public xnm(WeakReference paramWeakReference1, WeakReference paramWeakReference2, int paramInt) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    RedDotImageView localRedDotImageView = (RedDotImageView)this.b.get();
    if ((localObject != null) && (localRedDotImageView != null))
    {
      localObject = (QWalletRedManager)((QQAppInterface)localObject).getManager(272);
      QWalletRedManager.ShowInfo localShowInfo = ((QWalletRedManager)localObject).a("2001");
      if ((localShowInfo.a) && (QWalletTools.a(localShowInfo.b, this.jdField_a_of_type_Int)))
      {
        ((QWalletRedManager)localObject).b("2001");
        localRedDotImageView.post(new xnn(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnm
 * JD-Core Version:    0.7.0.1
 */