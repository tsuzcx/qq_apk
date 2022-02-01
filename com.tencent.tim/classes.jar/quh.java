import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class quh
  extends qyk
  implements qtw.a
{
  public quh(Context paramContext, Activity paramActivity, int paramInt, qye paramqye, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramqye, paramBoolean);
  }
  
  private String ag(String paramString1, String paramString2)
  {
    Calendar localCalendar = Calendar.getInstance();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(1, localCalendar.get(1));
    ((Calendar)localObject).set(2, localCalendar.get(2));
    ((Calendar)localObject).set(5, localCalendar.get(5) - 1);
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    localCalendar = null;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = String.valueOf(rpq.g(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = rpq.g(paramString2);
      localObject = rpq.g(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void bqN()
  {
    this.isDisplay = true;
  }
  
  private String ga(String paramString)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, localCalendar1.get(1));
    localCalendar2.set(2, localCalendar1.get(2));
    localCalendar2.set(5, localCalendar1.get(5) - 1);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    paramString = rpq.g(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return acfp.m(2131708104);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return acfp.m(2131708106);
    }
    return paramString[1] + acfp.m(2131708109) + paramString[2] + acfp.m(2131708107);
  }
  
  protected int J(int paramInt)
  {
    if (((qtw)this.a).aFs) {
      return super.J(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, qyd paramqyd, ViewGroup paramViewGroup)
  {
    if (J(paramInt) == 4) {
      return paramqyd.getItemView();
    }
    return super.a(paramInt, paramqyd, paramViewGroup);
  }
  
  @NonNull
  protected qvt a(boolean paramBoolean)
  {
    return new qtw(this.mFeedType, this, this, paramBoolean);
  }
  
  public qyd a(int paramInt, ViewGroup paramViewGroup)
  {
    if (J(paramInt) == 4) {
      return new qyd(LayoutInflater.from(this.context).inflate(2131561891, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, qyd paramqyd, qwc paramqwc, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramqyd.get(2131375138);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramqyd.get(2131375134);
    TextView localTextView = (TextView)paramqyd.get(2131375133);
    paramQQUserUIItem = (TextView)paramqyd.get(2131375124);
    paramqyd = (Button)paramqyd.get(2131362166);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(ga(((qwa)this.a.bY().get(paramInt)).a().date));
    localObject = t(paramqwc.bS());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramqwc.c().type != 3) {
        break label258;
      }
      if (!paramqwc.c().getOwner().isSubscribe()) {
        break label188;
      }
      paramqyd.setVisibility(8);
      paramInt = rpq.dip2px(this.context, 20.0F);
      rpq.h(paramqyd, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramqwc.c().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = rpq.dip2px(this.context, 13.0F);
        int i = rpq.dip2px(this.context, 3.0F);
        paramqyd.setText(acfp.m(2131708112));
        paramqyd.setVisibility(0);
        paramqyd.setTextColor(this.context.getResources().getColor(2131167304));
        paramqyd.setBackgroundResource(2130847410);
        paramqyd.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramqyd.setVisibility(8);
    paramqyd.setTextColor(this.context.getResources().getColor(2131166745));
    paramqyd.setBackgroundDrawable(null);
    paramInt = rpq.dip2px(this.context, 20.0F);
    rpq.h(paramqyd, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, qyd paramqyd, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramqyd.get(2131375130);
    Object localObject2 = (TextView)paramqyd.get(2131375148);
    TextView localTextView = (TextView)paramqyd.get(2131375145);
    localTextView.setVisibility(8);
    List localList = this.a.bY();
    String str = ((qwa)localList.get(paramInt)).a().date;
    paramqyd = null;
    if (paramInt > 0) {
      paramqyd = ((qwa)localList.get(paramInt - 1)).a().date;
    }
    paramqyd = ag(str, paramqyd);
    if (TextUtils.isEmpty(paramqyd)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramqyd);
        paramqyd = rpq.g(str);
        localObject1 = ((qtw)this.a).om.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramqyd[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(acfp.m(2131708114), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
  }
  
  public void bqo()
  {
    super.bqo();
    bqN();
  }
  
  protected qyd c(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new qyd(LayoutInflater.from(this.context).inflate(2131561844, paramViewGroup, false));
    paramViewGroup.get(2131362166).setOnClickListener(paramViewGroup);
    c(paramViewGroup);
    return paramViewGroup;
  }
  
  public int getCount()
  {
    if (this.isDisplay)
    {
      if (!((qtw)this.a).aFs) {
        return 1;
      }
      if (((qtw)this.a).om.size() > 0) {
        return super.getCount();
      }
    }
    return 0;
  }
  
  protected int getViewTypeCount()
  {
    return super.getViewTypeCount() + 1;
  }
  
  public boolean isEnd()
  {
    if (isDisplay()) {
      return super.isEnd();
    }
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    bqW();
  }
  
  public void setDisplay(boolean paramBoolean)
  {
    super.setDisplay(paramBoolean);
    if (paramBoolean) {
      bqW();
    }
  }
  
  public void ts(boolean paramBoolean)
  {
    notifyDataSetChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     quh
 * JD-Core Version:    0.7.0.1
 */