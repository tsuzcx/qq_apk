import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class agfr
  implements View.OnClickListener
{
  agfr(agfq paramagfq, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.val$view.getTag();
    if ((localObject instanceof agdp))
    {
      localObject = (FileInfo)((agdp)this.val$view.getTag()).entity;
      if (paramView.getId() != 2131365679) {
        break label158;
      }
      ausj localausj = (ausj)auss.a(this.a.this$0.a, null);
      localausj.setMainTitle(acfp.m(2131711035));
      localausj.addButton(acfp.m(2131711031), 3);
      localausj.addCancelButton(acfp.m(2131711032));
      localausj.a(new agfs(this, (FileInfo)localObject, localausj));
      localausj.show();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((localObject instanceof agga.a))
      {
        localObject = (FileInfo)((agga.a)this.val$view.getTag()).entity;
        break;
      }
      if (QLog.isColorLevel())
      {
        QLog.e(QfileBaseLocalFileTabView.TAG, 2, "unknow Object");
        continue;
        label158:
        if (paramView.getId() == 2131367525)
        {
          localObject = ahav.a((FileInfo)localObject);
          ahbr.b(QfileBaseLocalFileTabView.a(this.a.this$0), this.a.this$0.a, (FileManagerEntity)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfr
 * JD-Core Version:    0.7.0.1
 */