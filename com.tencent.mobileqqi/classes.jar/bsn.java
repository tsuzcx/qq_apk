import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountDataControll;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class bsn
  extends FriendListObserver
{
  public bsn(AccountManageActivity paramAccountManageActivity) {}
  
  void a(String paramString, int paramInt)
  {
    ThreadManager.a().post(new bso(this, paramString, paramInt));
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = SubAccountDataControll.a().a(this.a.b);
      Object localObject2;
      if ((localObject1 != null) && (((SubAccountInfo)localObject1).subuin != null) && (((SubAccountInfo)localObject1).subuin.equals(paramString)))
      {
        localObject2 = ContactUtils.b(this.a.b, ((SubAccountInfo)localObject1).subuin, false);
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ((TextUtils.isEmpty(((SubAccountInfo)localObject1).subname)) || (!((String)localObject2).equals(((SubAccountInfo)localObject1).subname))))
        {
          ((SubAccountInfo)localObject1).subname = ((String)localObject2);
          AccountManageActivity.a(this.a).setRightText((CharSequence)localObject2);
          AccountManageActivity.a(this.a).setContentDescription("关联QQ号" + (String)localObject2);
        }
      }
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          localObject1 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131231000);
          localObject2 = (TextView)this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j).findViewById(2131231001);
          ((TextView)localObject1).setText(ContactUtils.g(this.a.b, paramString));
          ((TextView)localObject2).setText(this.a.b.b(paramString));
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    int j = 0;
    if ((!paramBoolean) || (paramString == null)) {}
    for (;;)
    {
      return;
      int i;
      if (this.a.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        i = this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      }
      while (j < this.a.jdField_a_of_type_JavaUtilList.size())
      {
        if ((i > j) && (this.a.jdField_a_of_type_JavaUtilList.get(j) != null) && (paramString.equals(((SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(j)).getUin())))
        {
          a(paramString, j);
          return;
        }
        j += 1;
        continue;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     bsn
 * JD-Core Version:    0.7.0.1
 */