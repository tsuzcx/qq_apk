import SummaryCardTaf.SSummaryCardRsp;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class afix
  extends accn
{
  public afix(MessengerService paramMessengerService) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
    }
    Object localObject;
    long l1;
    int i;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      localObject = (QQAppInterface)MessengerService.h(this.a);
      if ((localObject != null) && (aqft.equalsWithNullCheck(((QQAppInterface)localObject).getCurrentAccountUin(), paramObject.uin))) {
        if ((paramObject.templateRet == 0) || (paramObject.templateRet == 101107) || (paramObject.templateRet == 101108))
        {
          l1 = paramObject.lCurrentBgId;
          l2 = paramObject.lCurrentStyleId;
          if (alcs.cy(l2)) {
            l1 = paramObject.cardId;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramObject = new Bundle();
      paramObject.putLong("currentId", l1);
      paramObject.putLong("styleId", l2);
      paramObject.putInt("result", i);
      if ((this.a.zN != null) && (this.a.zN.size() > 0))
      {
        localObject = (Bundle)this.a.zN.remove(0);
        ((Bundle)localObject).putBundle("response", paramObject);
        this.a.cp((Bundle)localObject);
      }
      return;
      i = -1;
      l1 = 0L;
      continue;
      i = -1;
      l1 = 0L;
      continue;
      QLog.e("Q.emoji.web.MessengerService", 1, "onCardDownload fail isSuccess = " + paramBoolean + "data = " + paramObject);
      i = -1;
      l1 = 0L;
    }
  }
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    int i = -1;
    String str2 = "";
    String str1 = "";
    if ((paramBoolean) && (paramObject != null)) {
      if ((paramObject instanceof Card)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (this.a.aC != null)
      {
        paramObject = new Bundle();
        this.a.aC.putString("cmd", "card_setSummaryCard");
        paramObject.putInt("result", i);
        paramObject.putString("message", str2);
        if (TextUtils.isEmpty(str1)) {
          paramObject.putString("aid", str1);
        }
        paramObject.putInt("payType", j);
        this.a.aC.putBundle("response", paramObject);
        this.a.cp(this.a.aC);
        this.a.aC = null;
      }
      return;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str2 = ((SSummaryCardRsp)paramObject.second).emsg;
        j = ((SSummaryCardRsp)paramObject.second).payType;
        str1 = ((SSummaryCardRsp)paramObject.second).aid;
        continue;
        QLog.e("Q.emoji.web.MessengerService", 1, "onSetCardTemplateReturn fail isSuccess = " + paramBoolean + "obj = " + paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afix
 * JD-Core Version:    0.7.0.1
 */