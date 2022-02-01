import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.jetbrains.annotations.NotNull;

class uvm
  extends uux
{
  uvm(uvh paramuvh) {}
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    urb localurb = uvh.a(this.a).a(uvh.a(this.a), uvh.b(this.a), paramInt);
    if (localurb == null) {
      return false;
    }
    if (localurb.jdField_a_of_type_Boolean)
    {
      this.a.b(localurb.jdField_a_of_type_JavaLangString);
      return true;
    }
    switch (paramInt)
    {
    default: 
      this.a.b(localurb.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      return super.a(paramInt, paramActionSheetItem);
      this.a.b(localurb.jdField_a_of_type_JavaLangString);
      continue;
      uvh.a(this.a, paramActionSheetItem);
      continue;
      uvh.a(this.a).a(uvh.a(this.a).c);
      uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
      continue;
      uvh.a(this.a).b(uvh.a(this.a).c);
      uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
      continue;
      uvh.a(this.a).c();
      uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
      continue;
      uvh.a(this.a).a(this.a);
      uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
      continue;
      uvh.a(this.a);
      uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
      continue;
      if (!TextUtils.isEmpty(uvh.a(this.a).c))
      {
        beaz.a(1, 3);
        beaz.a(uvh.a(this.a).c, uvh.a(this.a).jdField_a_of_type_JavaLangString);
        uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
        continue;
        if (!TextUtils.isEmpty(uvh.a(this.a).c))
        {
          this.a.a.d(uvh.a(this.a).c, new uvn(this, localurb));
          continue;
          uvh.a(this.a).c(uvh.a(this.a).c);
          uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
          continue;
          uvh.b(this.a);
          uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
          continue;
          this.a.b("not_care");
          continue;
          Intent localIntent;
          if (!TextUtils.isEmpty(uvh.a(this.a).e))
          {
            localIntent = AddFriendLogicActivity.a(this.a.a(), 1, uvh.a(this.a).e + "", null, 3096, 1, uvh.a(this.a).f, null, null, null, null);
            this.a.a().startActivity(localIntent);
          }
          uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
          continue;
          if (!TextUtils.isEmpty(uvh.a(this.a).e))
          {
            localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.a.a(), SplashActivity.class), null);
            localIntent.putExtra("uin", uvh.a(this.a).e);
            localIntent.putExtra("uintype", 0);
            this.a.a().startActivity(localIntent);
            uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
            continue;
            if (!TextUtils.isEmpty(uvh.a(this.a).e))
            {
              localIntent = new Intent(this.a.a(), AccountDetailActivity.class);
              localIntent.putExtra("uin", uvh.a(this.a).e);
              localIntent.putExtra("from_js", true);
              this.a.a().startActivity(localIntent);
              uvh.a(this.a, localurb.jdField_a_of_type_JavaLangString, true);
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
 * Qualified Name:     uvm
 * JD-Core Version:    0.7.0.1
 */