import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.base.CardViewController;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class wms
  extends AsyncTask
{
  public wms(CardViewController paramCardViewController) {}
  
  protected List a(Void... paramVarArgs)
  {
    paramVarArgs = ((MayknowRecommendManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(158)).a();
    return CardViewController.a(this.a, paramVarArgs);
  }
  
  protected void a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      CardViewController.c(this.a, false);
      CardViewController.d(this.a);
      return;
    }
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      ((StringBuilder)localObject).append(((MayKnowRecommend)paramList.get(i)).uin);
      ((StringBuilder)localObject).append(";");
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      CardViewController.b(this.a, (String)localObject);
    }
    for (;;)
    {
      CardViewController.a(this.a, paramList);
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "dealSourceList set isRefreshingRemote = false");
      }
      CardViewController.c(this.a, false);
      CardViewController.d(this.a);
      return;
      CardViewController.b(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */