import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class uhp
  extends uha
{
  uhp(uhk paramuhk) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    ude localude = uhk.a(this.a).a(uhk.a(this.a), uhk.b(this.a), paramInt);
    if (localude == null) {
      return false;
    }
    if (localude.jdField_a_of_type_Boolean)
    {
      this.a.b(localude.jdField_a_of_type_JavaLangString);
      return true;
    }
    switch (paramInt)
    {
    default: 
      this.a.b(localude.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      this.a.b(localude.jdField_a_of_type_JavaLangString);
      continue;
      uhk.a(this.a, paramActionSheetItem);
      continue;
      uhk.a(this.a).a(uhk.a(this.a).c);
      uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
      continue;
      uhk.a(this.a).b(uhk.a(this.a).c);
      uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
      continue;
      uhk.a(this.a).c();
      uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
      continue;
      uhk.a(this.a).a(this.a);
      uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
      continue;
      uhk.a(this.a);
      uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
      continue;
      if (!TextUtils.isEmpty(uhk.a(this.a).c))
      {
        bcua.a(1, 3);
        bcua.a(uhk.a(this.a).c, uhk.a(this.a).jdField_a_of_type_JavaLangString);
        uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
        continue;
        if (!TextUtils.isEmpty(uhk.a(this.a).c))
        {
          this.a.a.d(uhk.a(this.a).c, new uhq(this, localude));
          continue;
          uhk.a(this.a).c(uhk.a(this.a).c);
          uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
          continue;
          uhk.b(this.a);
          uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
          continue;
          this.a.b("not_care");
          continue;
          Intent localIntent;
          if (!TextUtils.isEmpty(uhk.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, uhk.a(this.a).e + "", null, 3096, 1, uhk.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
          continue;
          if (!TextUtils.isEmpty(uhk.a(this.a).e))
          {
            localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", uhk.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
            continue;
            if (!TextUtils.isEmpty(uhk.a(this.a).e))
            {
              localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
              localIntent.putExtra("uin", uhk.a(this.a).e);
              localIntent.putExtra("from_js", true);
              this.a.a().startActivity(localIntent);
              uhk.a(this.a, localude.jdField_a_of_type_JavaLangString, true);
              continue;
              this.a.b("unfollow");
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhp
 * JD-Core Version:    0.7.0.1
 */