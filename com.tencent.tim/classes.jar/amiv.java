import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.pic.PicShareToWX;
import com.tencent.mobileqq.screendetect.ScreenShotFragment;
import com.tencent.mobileqq.screendetect.ScreenShotFragment.b;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class amiv
  implements AdapterView.c
{
  public amiv(ScreenShotFragment paramScreenShotFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShotFragment", 2, "OnItemClickListener : position = " + paramInt + ", view = " + paramView + ", id = " + paramLong);
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null) {
      return;
    }
    int i = ((ScreenShotFragment.b)paramAdapterView).b.action;
    paramAdapterView = null;
    switch (i)
    {
    default: 
      if ((ScreenShotFragment.a(this.this$0)) && (paramAdapterView != null)) {
        amiw.aS("0X800A9A9", paramAdapterView, "1");
      }
      if ((i != 9) && (i != 10)) {
        break label300;
      }
      paramInt = -1;
      if (!WXShareHelper.a().isWXinstalled()) {
        paramInt = 2131721935;
      }
      break;
    }
    for (;;)
    {
      if (paramInt == -1) {
        break label300;
      }
      QQToast.a(this.this$0.getActivity(), this.this$0.getActivity().getString(paramInt), 0).show(this.this$0.getActivity().getResources().getDimensionPixelSize(2131299627));
      return;
      amiw.cN("0X8009FF0", 0);
      paramAdapterView = "1";
      break;
      amiw.cN("0X8009FF1", 0);
      paramAdapterView = "2";
      break;
      amiw.cN("0X8009FF2", 0);
      paramAdapterView = "3";
      break;
      amiw.cN("0X8009FF3", 0);
      paramAdapterView = "4";
      break;
      amiw.cN("0X800A77D", 0);
      paramAdapterView = "5";
      break;
      if (!WXShareHelper.a().isWXsupportApi()) {
        paramInt = 2131721936;
      }
    }
    switch (i)
    {
    default: 
      return;
    case 2: 
      ScreenShotFragment.K(this.this$0.getActivity(), ScreenShotFragment.a(this.this$0));
      return;
    case 3: 
      ScreenShotFragment.a(this.this$0, this.this$0.getActivity(), ScreenShotFragment.a(this.this$0));
      return;
    case 9: 
      if ((PicShareToWX.a().isEnable()) && (PicShareToWX.a().nQ(ScreenShotFragment.a(this.this$0))))
      {
        PicShareToWX.a().b(this.this$0.getActivity(), ScreenShotFragment.a(this.this$0), ScreenShotFragment.a(this.this$0), 3);
        anot.a(null, "dc00898", "", "", "0X800A505", "0X800A505", 0, 0, "", "", "", "");
        return;
      }
      ScreenShotFragment.a(this.this$0, ScreenShotFragment.a(this.this$0), ScreenShotFragment.a(this.this$0));
      return;
    case 10: 
      label300:
      ScreenShotFragment.b(this.this$0, ScreenShotFragment.a(this.this$0), ScreenShotFragment.a(this.this$0));
      return;
    }
    ScreenShotFragment.a(this.this$0, ScreenShotFragment.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amiv
 * JD-Core Version:    0.7.0.1
 */