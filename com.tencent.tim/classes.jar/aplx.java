import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.recite.HWReciteItem.b;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class aplx
  extends aplw
{
  private View IF;
  private TextView aaV;
  
  public aplx(View paramView)
  {
    super(paramView);
    this.aaV = ((TextView)paramView.findViewById(2131380880));
    this.IF = ((ImageView)paramView.findViewById(2131369705));
  }
  
  public void a(View paramView, HWReciteItem paramHWReciteItem, HWReciteItem.b paramb)
  {
    boolean bool2 = false;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131380880: 
      paramHWReciteItem = (InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method");
      if ((paramHWReciteItem != null) && (paramHWReciteItem.isActive())) {
        paramHWReciteItem.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      }
      paramHWReciteItem = (apkp)paramb.a;
      boolean bool1 = bool2;
      if (paramHWReciteItem.HW != null)
      {
        bool1 = bool2;
        if (!paramHWReciteItem.HW.isEmpty()) {
          bool1 = true;
        }
      }
      paramView = ausj.e(paramView.getContext());
      paramView.a(new aply(this, paramView, bool1, paramHWReciteItem));
      if (bool1) {
        paramView.addButton(acfp.m(2131713753));
      }
      paramView.addButton(acfp.m(2131713752));
      paramView.addCancelButton(acfp.m(2131713750));
      paramView.show();
      return;
    }
    paramHWReciteItem.a().h(paramb);
  }
  
  public void a(HWReciteItem paramHWReciteItem, HWReciteItem.b paramb, apkp paramapkp, int paramInt)
  {
    this.mItemView.setVisibility(0);
    if (TextUtils.isEmpty(paramapkp.mDesc))
    {
      StringBuilder localStringBuilder = new StringBuilder(acfp.m(2131713751)).append(paramapkp.cpO);
      if ((paramapkp.HW != null) && (!paramapkp.HW.isEmpty())) {
        localStringBuilder.append(apka.R(paramapkp.HW));
      }
      paramapkp.mDesc = localStringBuilder.toString();
    }
    this.aaV.setText(paramapkp.mDesc);
    if (paramInt != 1)
    {
      paramHWReciteItem.b(this.aaV, paramb);
      paramHWReciteItem.b(this.IF, paramb);
      this.IF.setVisibility(0);
      return;
    }
    this.IF.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aplx
 * JD-Core Version:    0.7.0.1
 */