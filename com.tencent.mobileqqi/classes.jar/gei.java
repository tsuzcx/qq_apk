import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class gei
  extends CardObserver
{
  public gei(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void b(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "CardObserver onSetCardTemplateReturn isSuccess : " + paramBoolean + ", obj : " + paramObject);
    }
    if ((paramBoolean) && (paramObject != null))
    {
      Object localObject;
      if ((paramObject instanceof Card))
      {
        paramObject = (Card)paramObject;
        localObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(5);
        String str = (String)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramObject.lCurrentTemplateId));
        if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str)))
        {
          ((Message)localObject).arg1 = Integer.parseInt(str);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "CardObserver onSetCardTemplateReturn cardId : " + paramObject.lCurrentTemplateId);
          }
          this.a.a((int)paramObject.lCurrentTemplateId);
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
        }
      }
      for (;;)
      {
        this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
        return;
        if ((paramObject instanceof Pair))
        {
          paramObject = (Pair)paramObject;
          localObject = (String)this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(String.valueOf(paramObject.first));
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isDigitsOnly((CharSequence)localObject))) {}
          for (int i = Integer.parseInt((String)localObject);; i = 0)
          {
            if (((Integer)paramObject.second).intValue() != 101107) {
              break label317;
            }
            this.a.z = 1;
            this.a.F = 2;
            paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
            paramObject.arg1 = i;
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
            break;
          }
          label317:
          if (((Integer)paramObject.second).intValue() == 101108)
          {
            this.a.z = 2;
            this.a.F = 5;
            paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
            paramObject.arg1 = i;
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
          }
          else
          {
            paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
            paramObject.arg1 = i;
            this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
          }
        }
      }
    }
    paramObject = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(6);
    if ((this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference != null) && (this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get() != null)) {}
    for (paramObject.arg1 = ((Integer)((Pair)this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get()).second).intValue();; paramObject.arg1 = -1)
    {
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gei
 * JD-Core Version:    0.7.0.1
 */