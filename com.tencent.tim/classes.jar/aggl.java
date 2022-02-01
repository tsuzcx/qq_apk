import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aggl
  implements View.OnClickListener
{
  public aggl(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    Object localObject2;
    FileManagerEntity localFileManagerEntity;
    int i;
    if ((localObject1 instanceof aggw.b))
    {
      localObject2 = (aggw.b)paramView.getTag();
      localObject1 = ((aggw.b)localObject2).a;
      localFileManagerEntity = (FileManagerEntity)((aggw.b)localObject2).entity;
      i = ((aggw.b)localObject2).ccW;
      i = ((aggw.b)localObject2).cWL;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131367020) && (QfileBaseRecentFileTabView.b(this.this$0))) {
        anot.a(QfileBaseRecentFileTabView.s(this.this$0), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      if (localFileManagerEntity != null)
      {
        localObject2 = this.this$0;
        if (paramView.getId() != 2131367020) {
          break label190;
        }
      }
      label190:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseRecentFileTabView)localObject2).a(localFileManagerEntity, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof agdp)) {
          break label195;
        }
        localObject2 = (agdp)paramView.getTag();
        localObject1 = ((agdp)localObject2).b;
        localFileManagerEntity = (FileManagerEntity)((agdp)localObject2).entity;
        i = ((agdp)localObject2).cWI;
        i = ((agdp)localObject2).position;
        break;
      }
      label195:
      localObject1 = null;
      localFileManagerEntity = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aggl
 * JD-Core Version:    0.7.0.1
 */