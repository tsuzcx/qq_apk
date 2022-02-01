import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class uba
  extends ual
{
  uba(uav paramuav) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    two localtwo = uav.a(this.a).a(uav.a(this.a), uav.b(this.a), paramInt);
    if (localtwo == null) {
      return false;
    }
    if (localtwo.jdField_a_of_type_Boolean)
    {
      this.a.b(localtwo.jdField_a_of_type_JavaLangString);
      return true;
    }
    switch (paramInt)
    {
    default: 
      this.a.b(localtwo.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      this.a.b(localtwo.jdField_a_of_type_JavaLangString);
      continue;
      uav.a(this.a, paramActionSheetItem);
      continue;
      uav.a(this.a).a(uav.a(this.a).c);
      uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
      continue;
      uav.a(this.a).b(uav.a(this.a).c);
      uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
      continue;
      uav.a(this.a).c();
      uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
      continue;
      uav.a(this.a).a(this.a);
      uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
      continue;
      uav.a(this.a);
      uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
      continue;
      if (!TextUtils.isEmpty(uav.a(this.a).c))
      {
        beaj.a(1, 3);
        beaj.a(uav.a(this.a).c, uav.a(this.a).jdField_a_of_type_JavaLangString);
        uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
        continue;
        if (!TextUtils.isEmpty(uav.a(this.a).c))
        {
          this.a.a.d(uav.a(this.a).c, new ubb(this, localtwo));
          continue;
          uav.a(this.a).c(uav.a(this.a).c);
          uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
          continue;
          uav.b(this.a);
          uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
          continue;
          this.a.b("not_care");
          continue;
          Intent localIntent;
          if (!TextUtils.isEmpty(uav.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, uav.a(this.a).e + "", null, 3096, 1, uav.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
          continue;
          if (!TextUtils.isEmpty(uav.a(this.a).e))
          {
            localIntent = agej.a(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", uav.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
            continue;
            if (!TextUtils.isEmpty(uav.a(this.a).e))
            {
              localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
              localIntent.putExtra("uin", uav.a(this.a).e);
              localIntent.putExtra("from_js", true);
              this.a.a().startActivity(localIntent);
              uav.a(this.a, localtwo.jdField_a_of_type_JavaLangString, true);
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
 * Qualified Name:     uba
 * JD-Core Version:    0.7.0.1
 */