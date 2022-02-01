import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.leba.QzoneFrame;
import com.tencent.mobileqq.activity.leba.QzoneFrame.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class zjs
  extends QzoneFrame.a
{
  public zjs(QzoneFrame paramQzoneFrame)
  {
    super(paramQzoneFrame);
  }
  
  public void Fn(int paramInt)
  {
    QLog.d("QzoneFrame", 1, "onSwitch: " + paramInt);
    Fragment localFragment = QzoneFrame.b(this.this$0);
    if ((QzoneFrame.b(this.this$0) == QzoneFrame.a(this.this$0)) && (paramInt == 1)) {
      return;
    }
    String str;
    Drawable localDrawable;
    if (QzoneFrame.c(this.this$0) == null)
    {
      QzoneFrame.a(this.this$0, avsn.a(this.this$0.a(), this.this$0.app, "com.qzone.feed.ui.activity.QQLebaExtendFeedFragment"));
      if (QzoneFrame.a(this.this$0) == null) {
        QzoneFrame.a(this.this$0, (TextView)QzoneFrame.a(this.this$0).findViewById(2131369627));
      }
      if (QzoneFrame.b(this.this$0) != QzoneFrame.c(this.this$0)) {
        break label490;
      }
      QzoneFrame.b(this.this$0, QzoneFrame.a(this.this$0));
      ((avsr)QzoneFrame.a(this.this$0)).setTitleAlphaAndGetLastValue(QzoneFrame.a(this.this$0));
      str = "动态";
      localDrawable = null;
      if (QzoneFrame.b(this.this$0) != null)
      {
        QzoneFrame.b(this.this$0).onAttach(this.this$0.a());
        QzoneFrame.b(this.this$0).onCreate(null);
        if (QzoneFrame.b(this.this$0).getView() == null)
        {
          QzoneFrame.b(this.this$0).onCreateView(LayoutInflater.from(this.this$0.a()), null, null);
          QzoneFrame.b(this.this$0).onActivityCreated(null);
        }
      }
      if ((QzoneFrame.b(this.this$0) == QzoneFrame.c(this.this$0)) && ((QzoneFrame.c(this.this$0) instanceof avsr)))
      {
        if (!QzoneFrame.a(this.this$0)) {
          break label607;
        }
        QzoneFrame.a(this.this$0, false);
      }
      label321:
      localFragment.onPause();
      localFragment.onStop();
      QzoneFrame.b(this.this$0).onStart();
      ((avsr)QzoneFrame.b(this.this$0)).resetReportFlag();
      QzoneFrame.b(this.this$0).onResume();
      QzoneFrame.b(this.this$0).removeView(localFragment.getView());
      QzoneFrame.b(this.this$0).addView(QzoneFrame.b(this.this$0).getView());
      if (Build.VERSION.SDK_INT <= 15) {
        break label625;
      }
      QzoneFrame.b(this.this$0).setBackground(localDrawable);
    }
    for (;;)
    {
      QzoneFrame.a(this.this$0).setText(str);
      if (QzoneFrame.b(this.this$0) != QzoneFrame.a(this.this$0)) {
        break label639;
      }
      ((avsr)QzoneFrame.a(this.this$0)).setRightButtonType(QzoneFrame.cdx);
      return;
      if ((QzoneFrame.b(this.this$0) != QzoneFrame.c(this.this$0)) || (paramInt != 2)) {
        break;
      }
      return;
      label490:
      QzoneFrame.b(this.this$0, QzoneFrame.c(this.this$0));
      if (QzoneFrame.a(this.this$0) == null)
      {
        if (Build.VERSION.SDK_INT <= 20) {
          break label581;
        }
        QzoneFrame.a(this.this$0, this.this$0.a().getDrawable(2130845996));
      }
      for (;;)
      {
        QzoneFrame.a(this.this$0, ((avsr)QzoneFrame.a(this.this$0)).setTitleAlphaAndGetLastValue(0));
        localDrawable = QzoneFrame.a(this.this$0);
        str = "暖说说";
        break;
        label581:
        QzoneFrame.a(this.this$0, this.this$0.a().getResources().getDrawable(2130845996));
      }
      label607:
      ((avsr)QzoneFrame.c(this.this$0)).forceRefresh();
      break label321;
      label625:
      QzoneFrame.b(this.this$0).setBackgroundDrawable(localDrawable);
    }
    label639:
    ((avsr)QzoneFrame.a(this.this$0)).setRightButtonType(QzoneFrame.cdy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjs
 * JD-Core Version:    0.7.0.1
 */