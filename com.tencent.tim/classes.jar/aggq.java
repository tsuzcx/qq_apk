import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.a;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggq
  implements View.OnClickListener
{
  public aggq(QfileBaseRecentFileTabView.a parama, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.val$view.getTag();
    if ((localObject instanceof agdp))
    {
      localObject = (FileManagerEntity)((agdp)localObject).entity;
      if (paramView.getId() != 2131365679) {
        break label121;
      }
      ausj localausj = (ausj)auss.a(this.a.this$0.a, null);
      localausj.setMainTitle(acfp.m(2131711036));
      localausj.addButton(acfp.m(2131711040), 3);
      localausj.addCancelButton(acfp.m(2131711038));
      localausj.a(new aggr(this, (FileManagerEntity)localObject, localausj));
      localausj.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (FileManagerEntity)((aggw.b)localObject).entity;
      break;
      label121:
      if (paramView.getId() == 2131367525) {
        this.a.this$0.h((FileManagerEntity)localObject);
      } else if (paramView.getId() == 2131378010) {
        ApolloUtil.a(paramView, (FileManagerEntity)localObject, QfileBaseRecentFileTabView.r(this.a.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggq
 * JD-Core Version:    0.7.0.1
 */