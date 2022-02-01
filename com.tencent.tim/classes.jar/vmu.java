import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity.a;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity.b;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class vmu
  implements View.OnClickListener
{
  public vmu(ProfileLabelEditorActivity.b paramb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof ProfileLabelEditorActivity.a))
    {
      localObject = (ProfileLabelEditorActivity.a)localObject;
      if ((((ProfileLabelEditorActivity.a)localObject).index >= 0) && (((ProfileLabelEditorActivity.a)localObject).index < this.b.this$0.qV.size()))
      {
        localObject = (ProfileLabelInfo)this.b.this$0.qV.remove(((ProfileLabelEditorActivity.a)localObject).index);
        this.b.this$0.Bn(this.b.this$0.qV.size());
        this.b.notifyDataSetChanged();
        ProfileLabelEditorActivity.b.a(this.b, (ProfileLabelInfo)localObject);
        anot.a(this.b.this$0.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "2", "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmu
 * JD-Core Version:    0.7.0.1
 */