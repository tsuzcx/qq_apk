import android.graphics.Bitmap;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.1;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2;
import com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class alcg
  implements AdapterView.OnItemClickListener
{
  alcg(alcf paramalcf) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.b.mShareActionSheet.getActionSheet().isShowing()) {
      this.b.mShareActionSheet.getActionSheet().dismiss();
    }
    int i;
    if ((paramLong == 2L) || (paramLong == 3L)) {
      if (!WXShareHelper.a().isWXinstalled()) {
        i = 2131721935;
      }
    }
    for (;;)
    {
      if (i != -1) {
        rwt.ez(1, i);
      }
      for (;;)
      {
        EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
        return;
        if (WXShareHelper.a().isWXsupportApi()) {
          break label233;
        }
        i = 2131721936;
        break;
        if ((this.b.N == null) || (this.b.N.isRecycled()))
        {
          rwt.ez(1, 2131701502);
        }
        else
        {
          this.b.a.iW(true);
          switch ((int)paramLong)
          {
          default: 
            break;
          case 0: 
            ThreadManager.postImmediately(new ShareHelper.1.1(this), null, true);
            break;
          case 1: 
            ThreadManager.postImmediately(new ShareHelper.1.2(this), null, true);
            break;
          case 2: 
          case 3: 
            ThreadManager.postImmediately(new ShareHelper.1.3(this, paramLong), null, true);
          }
        }
      }
      label233:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alcg
 * JD-Core Version:    0.7.0.1
 */