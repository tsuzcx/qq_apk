import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ajuq
  extends ajrw
{
  public ajuq(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, List<InterestTagInfo> paramList1, List<InterestTagInfo> paramList2, String paramString1, int paramInt3, int paramInt4, String paramString2)
  {
    if (!paramBoolean) {
      if (ChooseInterestTagActivity.a(this.this$0).getVisibility() == 0)
      {
        paramList1 = paramString2;
        if (TextUtils.isEmpty(paramString2)) {
          paramList1 = acfp.m(2131703803);
        }
        ChooseInterestTagActivity.a(this.this$0).setText(paramList1);
        ChooseInterestTagActivity.a(this.this$0).setOnClickListener(ChooseInterestTagActivity.a(this.this$0));
      }
    }
    label441:
    label587:
    label608:
    do
    {
      do
      {
        return;
        if (ChooseInterestTagActivity.b(this.this$0).getVisibility() == 0)
        {
          paramList1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramList1 = acfp.m(2131703822);
          }
          ChooseInterestTagActivity.b(this.this$0).setText(paramList1);
          ChooseInterestTagActivity.c(this.this$0).setVisibility(8);
          return;
        }
        paramList1 = this.this$0;
        if (paramInt3 != -1) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
          return;
        }
        if (paramInt1 == ChooseInterestTagActivity.a(this.this$0)) {
          break;
        }
        if (ChooseInterestTagActivity.a(this.this$0).getVisibility() == 0)
        {
          ChooseInterestTagActivity.a(this.this$0).setText(acfp.m(2131703830));
          ChooseInterestTagActivity.a(this.this$0).setOnClickListener(null);
          return;
        }
      } while (ChooseInterestTagActivity.b(this.this$0).getVisibility() != 0);
      ChooseInterestTagActivity.b(this.this$0).setText(acfp.m(2131703794));
      ChooseInterestTagActivity.c(this.this$0).setVisibility(8);
      return;
      if ((paramList1 == null) || (paramList1.isEmpty()))
      {
        if (ChooseInterestTagActivity.a(this.this$0).getVisibility() == 0)
        {
          ChooseInterestTagActivity.a(this.this$0).setText(acfp.m(2131703808));
          ChooseInterestTagActivity.a(this.this$0).setOnClickListener(null);
          return;
        }
        if (ChooseInterestTagActivity.b(this.this$0).getVisibility() == 0)
        {
          ChooseInterestTagActivity.b(this.this$0).setText(acfp.m(2131703816));
          ChooseInterestTagActivity.c(this.this$0).setVisibility(0);
          return;
        }
        paramList1 = this.this$0;
        if (paramInt2 != -1) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
          return;
        }
      }
      if (paramInt4 == 1)
      {
        if (paramList2 == null)
        {
          ChooseInterestTagActivity.a(this.this$0).clear();
          ChooseInterestTagActivity.a(this.this$0);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (ChooseInterestTagActivity.a(this.this$0).getVisibility() == 0) {
          ChooseInterestTagActivity.a(this.this$0).setVisibility(8);
        }
        if (paramInt3 != 0) {
          break label569;
        }
        ChooseInterestTagActivity.a(this.this$0).clear();
        ChooseInterestTagActivity.a(this.this$0).addAll(paramList1);
        if (ChooseInterestTagActivity.a(this.this$0) != null) {
          break label587;
        }
        ChooseInterestTagActivity.a(this.this$0, new ajuv(this.this$0, ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.a(this.this$0)));
        ChooseInterestTagActivity.a(this.this$0).setAdapter(ChooseInterestTagActivity.a(this.this$0));
        ChooseInterestTagActivity.a(this.this$0, paramInt2);
        paramList1 = this.this$0;
        if (paramInt2 == -1) {
          break label608;
        }
      }
      for (paramBoolean = true;; paramBoolean = false)
      {
        ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
        return;
        ChooseInterestTagActivity.a(this.this$0, (ArrayList)paramList2);
        break;
        ChooseInterestTagActivity.a(this.this$0).removeAll(paramList1);
        break label441;
        ChooseInterestTagActivity.a(this.this$0).aw(ChooseInterestTagActivity.a(this.this$0), true);
        break label523;
      }
    } while ((TextUtils.isEmpty(ChooseInterestTagActivity.a(this.this$0))) || (!ChooseInterestTagActivity.a(this.this$0).equals(paramString1)));
    label523:
    label569:
    if (ChooseInterestTagActivity.b(this.this$0).getVisibility() == 0) {
      ChooseInterestTagActivity.b(this.this$0).setVisibility(8);
    }
    if (paramInt3 == 0)
    {
      ChooseInterestTagActivity.b(this.this$0).clear();
      ChooseInterestTagActivity.b(this.this$0).addAll(paramList1);
      if (ChooseInterestTagActivity.a(this.this$0) != null) {
        break label813;
      }
      ChooseInterestTagActivity.a(this.this$0, new ajuv(this.this$0, ChooseInterestTagActivity.a(this.this$0), ChooseInterestTagActivity.b(this.this$0), ChooseInterestTagActivity.a(this.this$0)));
      ChooseInterestTagActivity.a(this.this$0).setAdapter(ChooseInterestTagActivity.a(this.this$0));
      label765:
      ChooseInterestTagActivity.b(this.this$0, paramInt2);
      paramList1 = this.this$0;
      if (paramInt2 == -1) {
        break label834;
      }
    }
    label813:
    label834:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ChooseInterestTagActivity.a(paramList1, false, paramBoolean);
      return;
      ChooseInterestTagActivity.b(this.this$0).removeAll(paramList1);
      break;
      ChooseInterestTagActivity.a(this.this$0).aw(ChooseInterestTagActivity.b(this.this$0), true);
      break label765;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, List<ajuu> paramList, String paramString2, int paramInt1, int paramInt2)
  {
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString2))
      {
        ChooseInterestTagActivity.a(this.this$0, 2, acfp.m(2131703820), 500);
        return;
      }
      ChooseInterestTagActivity.a(this.this$0, 0, acfp.m(2131703793) + paramString2, 500);
      return;
    }
    if ((paramInt2 == 1) && (!TextUtils.isEmpty(paramString1)))
    {
      ChooseInterestTagActivity.b(this.this$0);
      paramList = new Intent(this.this$0, QQBrowserActivity.class);
      paramList.putExtra("isShowAd", false);
      paramList.putExtra("url", paramString1);
      paramList.putExtra("selfSet_leftViewText", acfp.m(2131703809));
      paramList.putExtra("title", acfp.m(2131703831));
      if (QLog.isColorLevel()) {
        QLog.d("choose_interest_tag", 2, "url = " + paramString1);
      }
      this.this$0.startActivity(paramList);
      this.this$0.finish();
      return;
    }
    ChooseInterestTagActivity.a(this.this$0, 1, acfp.m(2131703810), 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajuq
 * JD-Core Version:    0.7.0.1
 */