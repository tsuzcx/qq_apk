import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.filemanager.activity.recentfile.QfileBaseRecentFileTabView;

class atrx
  implements View.OnClickListener
{
  atrx(atrw paramatrw, View paramView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.val$view.getTag();
    if ((localObject instanceof atpn)) {}
    for (localObject = (FileManagerEntity)((atpn)localObject).entity;; localObject = (FileManagerEntity)((atse.b)localObject).entity)
    {
      if (paramView.getId() == 2131365679)
      {
        ausj localausj = (ausj)auss.a(this.a.this$0.b, null);
        localausj.setMainTitle("删除文件记录及云端记录");
        localausj.addButton("删除", 3);
        localausj.addCancelButton("取消");
        localausj.a(new atry(this, (FileManagerEntity)localObject, localausj));
        localausj.show();
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrx
 * JD-Core Version:    0.7.0.1
 */