import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arbq
  implements View.OnClickListener
{
  arbq(arbo paramarbo) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = "";
    Object localObject2 = Uri.parse(arbo.a(this.this$0).getUrl());
    try
    {
      localObject2 = ((Uri)localObject2).getQueryParameter("article_id");
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        this.this$0.pn(this.this$0.czg);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    anot.a(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1D", "0X8006A1D", 0, 0, "", (String)localObject2, "", "");
    kbp.d("0X8006A1D", "", "", (String)localObject2, "", "");
    if (this.this$0.cXB)
    {
      this.this$0.cXC = true;
      QQToast.a(BaseApplicationImpl.getContext(), 0, 2131697454, 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbq
 * JD-Core Version:    0.7.0.1
 */