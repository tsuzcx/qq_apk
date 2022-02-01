import android.app.Activity;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class amoh
  extends ampt
{
  List<ampt> FT;
  String keyword;
  private long lastClickTime;
  
  public amoh(QQAppInterface paramQQAppInterface, int paramInt, String paramString, List<ampt> paramList)
  {
    super(paramQQAppInterface, paramInt, 0L);
    this.keyword = paramString;
    this.FT = paramList;
  }
  
  private CharSequence x()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append("邀请:");
    int i = 0;
    while (i < this.FT.size())
    {
      if (i != 0) {
        localSpannableStringBuilder.append("、");
      }
      localSpannableStringBuilder.append(((ampt)this.FT.get(i)).y());
      i += 1;
    }
    return localSpannableStringBuilder;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public Object S()
  {
    return Integer.valueOf(9889987);
  }
  
  protected long au(String paramString)
  {
    return 0L;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    long l = System.currentTimeMillis();
    if (l - this.lastClickTime < 1500L) {
      return;
    }
    if ((paramView.getContext() instanceof UniteSearchActivity)) {
      amxk.b("all_result", "clk_discuss", new String[] { "" + this.keyword });
    }
    this.lastClickTime = l;
    Intent localIntent = new Intent(paramView.getContext(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_min", 2);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 28);
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    Object localObject;
    String str1;
    String str2;
    int i;
    if (j < this.FT.size())
    {
      localObject = (ampt)this.FT.get(j);
      str1 = ((ampt)localObject).getUin();
      str2 = ((ampt)localObject).y().toString();
      if ((localObject instanceof amoj))
      {
        localObject = ((amoj)localObject).zc();
        i = 2;
      }
    }
    for (;;)
    {
      localArrayList.add(SelectMemberActivity.a(str1, str2, i, (String)localObject));
      j += 1;
      break;
      if ((localObject instanceof amoo))
      {
        localObject = ((amoo)localObject).mTroopUin;
        i = 2;
      }
      else if ((localObject instanceof amok))
      {
        localObject = "-1";
        i = 0;
        continue;
        localIntent.putExtra("param_done_button_wording", this.app.getApp().getString(2131719439));
        localIntent.putExtra("param_done_button_highlight_wording", this.app.getApp().getString(2131719440));
        localIntent.putExtra("param_title", acfp.m(2131704443));
        localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
        ((Activity)paramView.getContext()).startActivityForResult(localIntent, 1300);
        anot.a(this.app, "CliOper", "", "", "0X800635F", "0X800635F", 0, 0, "", "", "", "");
      }
      else
      {
        localObject = "-1";
        i = 0;
      }
    }
  }
  
  public CharSequence f()
  {
    return "";
  }
  
  public CharSequence g()
  {
    return null;
  }
  
  public CharSequence getDescription()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (this.FT != null) {}
    for (int i = this.FT.size();; i = 0)
    {
      localSpannableStringBuilder.append("已选择").append("" + i).append("人");
      return localSpannableStringBuilder;
    }
  }
  
  public String getKeyword()
  {
    return this.keyword;
  }
  
  public CharSequence getTitle()
  {
    return x();
  }
  
  public String getUin()
  {
    return String.valueOf(9889987);
  }
  
  public int lk()
  {
    return 9889987;
  }
  
  public int pG()
  {
    return 9889987;
  }
  
  public String za()
  {
    return x().toString();
  }
  
  public String zb()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amoh
 * JD-Core Version:    0.7.0.1
 */