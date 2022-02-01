import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atri
  implements View.OnClickListener
{
  public atri(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    Object localObject1 = null;
    Object localObject3;
    if ((localObject2 instanceof atrj.a))
    {
      localObject3 = (atrj.a)paramView.getTag();
      localObject2 = (FileInfo)((atrj.a)localObject3).entity;
      if (!this.this$0.b.aWg)
      {
        localObject1 = localObject2;
        if (!this.this$0.b.akN()) {}
      }
      else
      {
        localObject1 = localObject2;
        if (this.this$0.b.app != null)
        {
          localObject1 = new atsl();
          ((atsl)localObject1).kR(((atrj.a)localObject3).ccW, ((atrj.a)localObject3).cWL);
          QfileBaseLocalFileTabView.a(this.this$0).a().a(1, (atsk)localObject1);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.this$0.f((FileInfo)localObject1);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject2 instanceof atpn))
      {
        localObject3 = (atpn)paramView.getTag();
        localObject2 = (FileInfo)((atpn)localObject3).entity;
        if (!this.this$0.b.aWg)
        {
          localObject1 = localObject2;
          if (!this.this$0.b.akN()) {}
        }
        else
        {
          localObject1 = localObject2;
          if (this.this$0.b.app != null)
          {
            localObject1 = new atsl();
            ((atsl)localObject1).kS(((atpn)localObject3).cWI, (((atpn)localObject3).position + 1) / 4);
            QfileBaseLocalFileTabView.b(this.this$0).a().a(1, (atsk)localObject1);
            localObject1 = localObject2;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atri
 * JD-Core Version:    0.7.0.1
 */