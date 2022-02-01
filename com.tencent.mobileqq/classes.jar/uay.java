import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class uay
  extends uaj
{
  uay(uat paramuat) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    twm localtwm = uat.a(this.a).a(uat.a(this.a), uat.b(this.a), paramInt);
    if (localtwm == null) {
      return false;
    }
    if (localtwm.jdField_a_of_type_Boolean)
    {
      this.a.b(localtwm.jdField_a_of_type_JavaLangString);
      return true;
    }
    switch (paramInt)
    {
    default: 
      this.a.b(localtwm.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      this.a.b(localtwm.jdField_a_of_type_JavaLangString);
      continue;
      uat.a(this.a, paramActionSheetItem);
      continue;
      uat.a(this.a).a(uat.a(this.a).c);
      uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
      continue;
      uat.a(this.a).b(uat.a(this.a).c);
      uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
      continue;
      uat.a(this.a).c();
      uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
      continue;
      uat.a(this.a).a(this.a);
      uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
      continue;
      uat.a(this.a);
      uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
      continue;
      if (!TextUtils.isEmpty(uat.a(this.a).c))
      {
        bdho.a(1, 3);
        bdho.a(uat.a(this.a).c, uat.a(this.a).jdField_a_of_type_JavaLangString);
        uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
        continue;
        if (!TextUtils.isEmpty(uat.a(this.a).c))
        {
          this.a.a.d(uat.a(this.a).c, new uaz(this, localtwm));
          continue;
          uat.a(this.a).c(uat.a(this.a).c);
          uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
          continue;
          uat.b(this.a);
          uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
          continue;
          this.a.b("not_care");
          continue;
          Intent localIntent;
          if (!TextUtils.isEmpty(uat.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, uat.a(this.a).e + "", null, 3096, 1, uat.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
          continue;
          if (!TextUtils.isEmpty(uat.a(this.a).e))
          {
            localIntent = afur.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", uat.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
            continue;
            if (!TextUtils.isEmpty(uat.a(this.a).e))
            {
              localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
              localIntent.putExtra("uin", uat.a(this.a).e);
              localIntent.putExtra("from_js", true);
              this.a.a().startActivity(localIntent);
              uat.a(this.a, localtwm.jdField_a_of_type_JavaLangString, true);
              continue;
              this.a.b("unfollow");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uay
 * JD-Core Version:    0.7.0.1
 */