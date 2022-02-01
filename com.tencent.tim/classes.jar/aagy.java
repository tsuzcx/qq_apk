import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager.2;
import com.tencent.mobileqq.applets.data.AppletItem.a;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class aagy
  implements ausj.a
{
  public aagy(AppletsFolderManager.2 param2) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (aagv.a(this.a.this$0)) {
      return;
    }
    aagv.a(this.a.this$0, true);
    switch (paramInt)
    {
    }
    for (;;)
    {
      aagv.a(this.a.this$0).dismiss();
      return;
      paramView = new ArrayList();
      AppletItem.a locala = new AppletItem.a();
      locala.a(Integer.valueOf(this.a.val$uin).intValue());
      locala.a(Integer.valueOf(this.a.val$type).intValue());
      locala.b(0);
      paramView.add(locala.a());
      aagv.a(this.a.this$0).dS(paramView);
      QQToast.a(BaseApplicationImpl.getApplication(), acfp.m(2131702753), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aagy
 * JD-Core Version:    0.7.0.1
 */