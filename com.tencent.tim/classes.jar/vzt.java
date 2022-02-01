import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vzt
  implements View.OnClickListener
{
  public vzt(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.a == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.this$0.a.tribeId != 0L) || (this.this$0.Hf != 0L)) {
        this.this$0.bWz();
      } else {
        switch (this.this$0.a.troopTypeExt)
        {
        default: 
          break;
        case 0: 
        case 1: 
          this.this$0.bWG();
          break;
        case 2: 
        case 3: 
        case 4: 
          Object localObject;
          if ((this.this$0.Hd > 0L) && (this.this$0.Hd <= this.this$0.He) && (this.this$0.bFL == 0))
          {
            localObject = aqha.a(this.this$0, 230);
            ((aqju)localObject).setTitle(null);
            ((aqju)localObject).setMessage(this.this$0.getString(2131694883, new Object[] { this.this$0.Hd + "" }));
            ((aqju)localObject).setPositiveButton(this.this$0.getString(2131694860), new aqha.a());
            ((aqju)localObject).setPositiveButtonContentDescription(this.this$0.getString(2131694860));
            ((aqju)localObject).show();
          }
          else
          {
            localObject = TroopInfoActivity.a(this.this$0);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              this.this$0.wL((String)localObject);
            } else {
              TroopInfoActivity.a(this.this$0);
            }
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzt
 * JD-Core Version:    0.7.0.1
 */