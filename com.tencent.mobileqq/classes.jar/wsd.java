import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.base.CardViewController;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class wsd
  extends AsyncTask
{
  public wsd(CardViewController paramCardViewController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected List a(Void... paramVarArgs)
  {
    int j = 0;
    int i = 0;
    Object localObject = ((MayknowRecommendManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(158)).a();
    paramVarArgs = new ArrayList();
    if (this.b)
    {
      localObject = CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, (List)localObject);
      j = CardViewController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController);
      int k = ((List)localObject).size();
      while (i < k - j)
      {
        paramVarArgs.add(((List)localObject).get(i));
        i += 1;
      }
    }
    String[] arrayOfString = CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, "card_displaying_list_sp");
    if (arrayOfString != null)
    {
      i = j;
      while (i < ((List)localObject).size())
      {
        String str = ((MayKnowRecommend)((List)localObject).get(i)).uin;
        if (CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, str, arrayOfString)) {
          paramVarArgs.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    return paramVarArgs;
  }
  
  protected void a(List paramList)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Object localObject = new StringBuilder();
      int i = 0;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append(((MayKnowRecommend)paramList.get(i)).uin);
        ((StringBuilder)localObject).append(";");
        i += 1;
      }
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("CardViewController", 2, "getDisplayList 更新配置后保存显示列表 displayingStr ");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label109;
      }
      CardViewController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, (String)localObject);
    }
    for (;;)
    {
      CardViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, paramList);
      CardViewController.d(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController);
      return;
      label109:
      CardViewController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseCardViewController, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsd
 * JD-Core Version:    0.7.0.1
 */