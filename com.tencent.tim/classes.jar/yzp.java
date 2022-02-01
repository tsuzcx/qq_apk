import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class yzp
  implements View.OnClickListener
{
  public static final String TAG = yzp.class.getSimpleName();
  private TextView DY;
  private EditText I;
  private long KR;
  private int mFrom;
  private WeakReference<BaseActivity> mRef;
  
  public yzp(BaseActivity paramBaseActivity, int paramInt, View paramView)
  {
    this.mRef = new WeakReference(paramBaseActivity);
    this.mFrom = paramInt;
    paramBaseActivity = paramView.findViewById(2131377813);
    IphoneTitleBarActivity.setLayerType(paramBaseActivity);
    paramView = paramBaseActivity.findViewById(2131363801);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    this.I = ((EditText)paramBaseActivity.findViewById(2131366542));
    this.DY = ((TextView)paramBaseActivity.findViewById(2131380917));
    this.I.setFocusableInTouchMode(false);
    this.I.setCursorVisible(false);
    this.I.setOnClickListener(this);
  }
  
  public void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getCurrentUin();
    } while ((TextUtils.isEmpty(paramQQAppInterface)) || (paramQQAppInterface.equals(SearchConfigManager.curUin)));
    SearchConfigManager.isConfigLoaded = false;
  }
  
  public void onClick(View paramView)
  {
    int i = 2;
    switch (paramView.getId())
    {
    }
    long l;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "onClick() time stamp = " + (l - this.KR));
      }
    } while (Math.abs(l - this.KR) < 1500L);
    if (this.mFrom == 2) {}
    for (;;)
    {
      this.KR = l;
      FrameHelperActivity.EO(false);
      BaseActivity localBaseActivity = (BaseActivity)this.mRef.get();
      if (localBaseActivity == null) {
        break;
      }
      amub.a(null, i, 0, "0X8009D15", 0, 0, null, null);
      UniteSearchActivity.b(localBaseActivity, null, this.mFrom, i);
      break;
      if (this.mFrom == 1) {
        anpc.report("tim_msg_tab_search_click");
      }
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.mFrom == 1) {
      obg.a().bdc();
    }
  }
  
  public void onResume()
  {
    this.DY.setText(amkd.yZ());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yzp
 * JD-Core Version:    0.7.0.1
 */