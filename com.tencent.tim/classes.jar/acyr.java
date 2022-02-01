import android.view.View;
import com.tencent.ark.ArkViewModel;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;
import com.tencent.mobileqq.app.qqdaily.WrappedArkView.a;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;

public class acyr
  implements WrappedArkView.a
{
  public acyr(QQDailyArkView paramQQDailyArkView) {}
  
  public void a(String paramString, int paramInt, boolean paramBoolean, ArkViewModel paramArkViewModel)
  {
    if (QQDailyArkView.a(this.this$0) == null) {
      return;
    }
    if ((paramArkViewModel != null) && (paramArkViewModel.GetAppScriptType() == 2) && (!ArkAppCenter.afv()))
    {
      QLog.i("QQDailyArkView", 2, "onLoadFailed.ARKAPP_TYPE_RELOAD");
      onLoading();
      return;
    }
    paramString = QQDailyArkView.a(this.this$0);
    if (paramBoolean) {
      paramString.setOnClickListener(new acys(this, paramArkViewModel));
    }
    for (;;)
    {
      QQDailyArkView.b(this.this$0);
      paramString.setVisibility(0);
      paramArkViewModel = paramString.findViewById(2131370787);
      QQDailyArkView.a(this.this$0, paramString, 0);
      this.this$0.requestLayout();
      if (paramArkViewModel == null) {
        break;
      }
      paramArkViewModel.setVisibility(4);
      return;
      paramString.setOnClickListener(null);
    }
  }
  
  public void onLoadSuccess()
  {
    if (QQDailyArkView.a(this.this$0) == null) {
      return;
    }
    QQDailyArkView.a(this.this$0).setVisibility(8);
    QQDailyArkView.a(this.this$0, QQDailyArkView.a(this.this$0), 8);
  }
  
  public void onLoading()
  {
    if (QQDailyArkView.a(this.this$0) == null) {}
    View localView;
    do
    {
      return;
      QQDailyArkView.b(this.this$0);
      QQDailyArkView.a(this.this$0).setVisibility(0);
      localView = QQDailyArkView.a(this.this$0).findViewById(2131370787);
      QQDailyArkView.a(this.this$0, QQDailyArkView.a(this.this$0), 0);
      this.this$0.requestLayout();
    } while (localView == null);
    localView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acyr
 * JD-Core Version:    0.7.0.1
 */