import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.tim.filemanager.activity.FMActivity;
import com.tencent.tim.filemanager.activity.localfile.QfileBaseLocalFileTabView;

public class atrh
  implements View.OnLongClickListener
{
  public atrh(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((paramView == null) || (QfileBaseLocalFileTabView.a(this.this$0))) {
      return false;
    }
    this.this$0.b.eum();
    Object localObject2;
    Object localObject1;
    if (QfileBaseLocalFileTabView.b(this.this$0))
    {
      localObject2 = paramView.getTag();
      localObject1 = null;
      if (!(localObject2 instanceof atrj.a)) {
        break label78;
      }
      localObject1 = (FileInfo)((atrj.a)paramView.getTag()).entity;
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.this$0.f((FileInfo)localObject1);
      }
      return true;
      label78:
      if ((localObject2 instanceof atpn))
      {
        localObject2 = (atpn)paramView.getTag();
        paramView = (FileInfo)((atpn)localObject2).entity;
        if (!this.this$0.b.akM())
        {
          localObject1 = paramView;
          if (!this.this$0.b.akN()) {}
        }
        else
        {
          localObject1 = this.this$0.b.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          ((SharedPreferences.Editor)localObject1).putInt("GROUP", ((atpn)localObject2).cWI);
          ((SharedPreferences.Editor)localObject1).putInt("CHILD", (((atpn)localObject2).position + 1) / 4);
          ((SharedPreferences.Editor)localObject1).commit();
          localObject1 = paramView;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atrh
 * JD-Core Version:    0.7.0.1
 */