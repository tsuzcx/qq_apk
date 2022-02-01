import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

final class aljy
  implements ausj.a
{
  aljy(ausj paramausj, int[] paramArrayOfInt, String paramString, Context paramContext, QQAppInterface paramQQAppInterface) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.t.dismiss();
    switch (this.mJ[paramInt])
    {
    default: 
      return;
    }
    paramView = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.bwr));
    if ((!aqoq.cVe) && (aqoo.a().aFs())) {
      aqoo.a().k(paramView);
    }
    this.val$context.startActivity(paramView);
    paramView = this.val$app.a();
    long l = anaz.gQ();
    paramView.b(this.bwr, 26, -1, l, this.bwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljy
 * JD-Core Version:    0.7.0.1
 */