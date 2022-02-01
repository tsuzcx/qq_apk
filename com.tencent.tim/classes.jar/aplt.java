import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.b;
import java.util.List;
import org.json.JSONObject;

public class aplt
  extends aplw
{
  private TextView aaR;
  private TextView aaS;
  
  public aplt(View paramView)
  {
    super(paramView);
    this.aaR = ((TextView)paramView.findViewById(2131380880));
    this.aaS = ((TextView)paramView.findViewById(2131380744));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, HWReciteItem.b paramb)
  {
    paramHWReciteItem = (apkp)paramb.a;
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      ReciteFragment.x(paramView.getContext(), paramHWReciteItem.af().toString(), paramHWReciteItem.mPosition);
      paramView = BaseApplicationImpl.getApplication().getRuntime();
    } while (!(paramView instanceof QQAppInterface));
    aqfr.a((QQAppInterface)paramView, paramHWReciteItem.mTroopUin, "Grp_recite", "Recite_Clk", 0, 0, new String[] { paramHWReciteItem.mTroopUin, "", paramHWReciteItem.cpO, "" });
  }
  
  public void a(HWReciteItem paramHWReciteItem, HWReciteItem.b paramb, apkp paramapkp, int paramInt)
  {
    this.mItemView.setVisibility(0);
    if (TextUtils.isEmpty(paramapkp.mDesc))
    {
      StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131706995)).append(paramapkp.cpO);
      if ((paramapkp.HW != null) && (!paramapkp.HW.isEmpty())) {
        localStringBuilder.append(apka.R(paramapkp.HW));
      }
      paramapkp.mDesc = localStringBuilder.toString();
    }
    this.aaR.setText(paramapkp.mDesc);
    paramHWReciteItem.b(this.mItemView, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplt
 * JD-Core Version:    0.7.0.1
 */