import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;

class akgj
  implements ausj.a
{
  akgj(akgi paramakgi, View paramView, PicInfo paramPicInfo, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (this.a.val$pos == 0) {
      i = paramInt + 1;
    }
    switch (i)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      this.a.this$0.jF.removeView(this.val$v);
      this.a.this$0.jF.addView(this.val$v, 0);
      akfk.a(this.a.this$0);
      akfk.b(this.a.this$0);
      continue;
      paramView = sxx.getViewRect(this.val$v);
      this.a.this$0.a.a(this.a.val$pos, paramView, this.a.this$0.yi);
      continue;
      akfk.a(this.a.this$0, this.d, this.val$v);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akgj
 * JD-Core Version:    0.7.0.1
 */