import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;

final class aoah
  implements ausj.a
{
  aoah(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ausj paramausj, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aoag.a parama) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        this.c.dNR = 2;
        this.b.dismiss();
        paramView = aoag.a(this.val$app, this.c, this.val$context, this.val$tag, this.val$context.getString(2131720932), true);
        if (this.a != null) {
          this.a.c(paramView);
        }
      } while (!this.c.azu());
      aodb.aN(this.val$app, "0X8009ED1");
      return;
      this.c.dNR = 0;
      ((aoar)this.val$app.getBusinessHandler(120)).n(this.c);
      this.b.dismiss();
      paramView = aoag.a(this.val$app, this.c, this.val$context, this.val$tag, this.val$context.getString(2131720932), true);
      if (this.a != null) {
        this.a.c(paramView);
      }
    } while (!this.c.azu());
    aodb.aN(this.val$app, "0X8009ED2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aoah
 * JD-Core Version:    0.7.0.1
 */