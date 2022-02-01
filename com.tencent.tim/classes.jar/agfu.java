import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class agfu
  implements View.OnClickListener
{
  public agfu(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    FileInfo localFileInfo;
    if ((localObject1 instanceof agga.a))
    {
      localObject1 = (agga.a)paramView.getTag();
      localFileInfo = (FileInfo)((agga.a)localObject1).entity;
      localObject1 = ((agga.a)localObject1).a;
    }
    for (;;)
    {
      if ((paramView.getId() == 2131367020) && (QfileBaseLocalFileTabView.b(this.this$0))) {
        anot.a(QfileBaseLocalFileTabView.b(this.this$0), "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
      }
      Object localObject2;
      if (localFileInfo != null)
      {
        localObject2 = this.this$0;
        if (paramView.getId() != 2131367020) {
          break label245;
        }
      }
      label245:
      for (boolean bool = true;; bool = false)
      {
        ((QfileBaseLocalFileTabView)localObject2).a(localFileInfo, (View)localObject1, bool);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (!(localObject1 instanceof agdp)) {
          break label250;
        }
        localObject2 = (agdp)paramView.getTag();
        localFileInfo = (FileInfo)((agdp)localObject2).entity;
        localObject1 = ((agdp)localObject2).b;
        if ((this.this$0.a.akM()) || (this.this$0.a.akN()))
        {
          SharedPreferences.Editor localEditor = this.this$0.a.getSharedPreferences("LAST_CHOOSE_", 0).edit();
          localEditor.putInt("GROUP", ((agdp)localObject2).cWI);
          localEditor.putInt("CHILD", (((agdp)localObject2).position + 1) / 4);
          localEditor.commit();
        }
        break;
      }
      label250:
      localObject1 = null;
      localFileInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agfu
 * JD-Core Version:    0.7.0.1
 */