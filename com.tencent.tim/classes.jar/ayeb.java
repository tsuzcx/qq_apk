import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.io.File;
import mqq.app.AppRuntime;

class ayeb
  implements ausj.a
{
  ayeb(aydy paramaydy, ausj paramausj, Intent paramIntent, String paramString, Activity paramActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    Object localObject = this.val$actionSheet.getContent(paramInt);
    if (localObject == null)
    {
      this.val$actionSheet.dismiss();
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.val$actionSheet.dismiss();
      return;
    }
    if (((String)localObject).equals(paramView.getResources().getString(2131694752)))
    {
      int i = 1;
      paramInt = i;
      if (this.this$0.a.th() == 130)
      {
        paramInt = i;
        if (!this.r.getBooleanExtra("extra_is_edited_pic", false)) {
          paramInt = 0;
        }
      }
      this.r.putExtra("forward_type", paramInt);
      this.r.putExtra("forward_filepath", this.val$path);
      ahgq.f(this.val$activity, this.r, 19003);
      anot.a(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      if (((String)localObject).equals(paramView.getResources().getString(2131694762)))
      {
        localObject = new File(this.val$path);
        String str = ((File)localObject).getAbsolutePath();
        amdf.a((Activity)paramView.getContext(), (File)localObject, Utils.Crc64String(str), this.this$0);
        anot.a(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
      }
      else if (((String)localObject).equals(paramView.getResources().getString(2131694750)))
      {
        paramView = BaseApplicationImpl.getApplication();
        aviz.b(this.val$path).a(this.val$activity, paramView.getRuntime().getAccount(), 2131696959, this.this$0);
        anot.a(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayeb
 * JD-Core Version:    0.7.0.1
 */