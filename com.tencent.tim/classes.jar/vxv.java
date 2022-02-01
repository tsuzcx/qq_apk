import android.view.View;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.concurrent.ConcurrentHashMap;

public class vxv
  implements ausj.a
{
  public vxv(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramInt = -1;
      if (this.bLs != paramInt)
      {
        if (!aqiw.isNetSupport(this.this$0.getActivity())) {
          break label218;
        }
        this.this$0.jdField_a_of_type_Aqlz.ja.clear();
        aizp.a().y(this.this$0.app, this.d.troopuin, paramInt);
        this.this$0.jdField_a_of_type_Aqlz.jb.put(this.d.troopuin, Boolean.valueOf(true));
        this.this$0.jdField_a_of_type_Abgi.notifyDataSetChanged();
        this.this$0.bWo();
        aizp.a().an(this.this$0.app, this.d.troopuin);
        anot.a(this.this$0.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.d.troopuin, String.valueOf(paramInt - 1), "", "");
      }
      break;
    }
    for (;;)
    {
      this.c.dismiss();
      return;
      paramInt = 1;
      break;
      paramInt = 4;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      label218:
      QQToast.a(this.this$0.getActivity(), 2131696272, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vxv
 * JD-Core Version:    0.7.0.1
 */