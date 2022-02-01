import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ajui
  implements View.OnClickListener
{
  public ajui(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == ChooseInterestTagActivity.b(this.this$0)) {
      if (TextUtils.isEmpty(ChooseInterestTagActivity.a(this.this$0)))
      {
        ChooseInterestTagActivity.a(this.this$0).e(ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.b(this.this$0), 30, 0, 0);
        ChooseInterestTagActivity.a(this.this$0, true, true);
      }
    }
    label394:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ChooseInterestTagActivity.a(this.this$0).e(ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.c(this.this$0), 30, 0, 0);
        break;
        Object localObject2;
        if (paramView == this.this$0.leftView)
        {
          aurd.hide(ChooseInterestTagActivity.a(this.this$0));
          if (ChooseInterestTagActivity.a(this.this$0))
          {
            this.this$0.finish();
          }
          else
          {
            localObject2 = this.this$0.getIntent();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Intent();
            }
            Collections.reverse(ChooseInterestTagActivity.a(this.this$0));
            ((Intent)localObject1).putParcelableArrayListExtra("choosed_interest_tags", ChooseInterestTagActivity.a(this.this$0));
            ((Intent)localObject1).putExtra("interest_tag_type", ChooseInterestTagActivity.a(this.this$0));
            this.this$0.setResult(-1, (Intent)localObject1);
            this.this$0.finish();
          }
        }
        else
        {
          if (paramView != this.this$0.rightViewText) {
            break label394;
          }
          aurd.hide(ChooseInterestTagActivity.a(this.this$0));
          if (ChooseInterestTagActivity.a(this.this$0)) {
            if (ChooseInterestTagActivity.a(this.this$0).isEmpty())
            {
              ChooseInterestTagActivity.a(this.this$0, acfp.m(2131703821));
            }
            else
            {
              ChooseInterestTagActivity.a(this.this$0, 0, acfp.m(2131703815), 0);
              Collections.reverse(ChooseInterestTagActivity.a(this.this$0));
              localObject1 = new ajuu(ChooseInterestTagActivity.a(this.this$0));
              ((ajuu)localObject1).tagInfos.addAll(ChooseInterestTagActivity.a(this.this$0));
              localObject2 = new ArrayList(1);
              ((List)localObject2).add(localObject1);
              ChooseInterestTagActivity.a(this.this$0).e((List)localObject2, 0, 1);
            }
          }
        }
      }
    } while (paramView != ChooseInterestTagActivity.a(this.this$0));
    ChooseInterestTagActivity.a(this.this$0).setText(acfp.m(2131703838));
    Object localObject1 = ChooseInterestTagActivity.a(this.this$0);
    int j = ChooseInterestTagActivity.a(this.this$0);
    int k = ChooseInterestTagActivity.b(this.this$0);
    if (ChooseInterestTagActivity.a(this.this$0)) {}
    for (int i = 1;; i = 0)
    {
      ((ajrs)localObject1).e("", j, k, 30, 0, i);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajui
 * JD-Core Version:    0.7.0.1
 */