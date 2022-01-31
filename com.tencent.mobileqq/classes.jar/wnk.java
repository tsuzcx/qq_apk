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

public class wnk
  extends wub
  implements wmn
{
  public wnk(Context paramContext, Activity paramActivity, int paramInt, wtr paramwtr, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramwtr, paramBoolean);
  }
  
  private String a(String paramString)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.set(1, localCalendar1.get(1));
    localCalendar2.set(2, localCalendar1.get(2));
    localCalendar2.set(5, localCalendar1.get(5) - 1);
    localCalendar2.set(11, 0);
    localCalendar2.set(12, 0);
    localCalendar2.set(13, 0);
    paramString = xsm.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return alud.a(2131706921);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return alud.a(2131706923);
    }
    return paramString[1] + alud.a(2131706926) + paramString[2] + alud.a(2131706924);
  }
  
  private String a(String paramString1, String paramString2)
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
      paramString1 = String.valueOf(xsm.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = xsm.a(paramString2);
      localObject = xsm.a(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void W_()
  {
    super.W_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((wml)this.jdField_a_of_type_Wpr).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((wml)this.jdField_a_of_type_Wpr).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((wml)this.jdField_a_of_type_Wpr).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramwtq.a();
    }
    return super.a(paramInt, paramwtq, paramViewGroup);
  }
  
  @NonNull
  protected wpr a(boolean paramBoolean)
  {
    return new wml(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561498, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, wtq paramwtq, wqp paramwqp, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramwtq.a(2131373756);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwtq.a(2131373752);
    TextView localTextView = (TextView)paramwtq.a(2131373751);
    paramQQUserUIItem = (TextView)paramwtq.a(2131373742);
    paramwtq = (Button)paramwtq.a(2131362068);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((wqn)this.jdField_a_of_type_Wpr.a().get(paramInt)).a().date));
    localObject = a(paramwqp.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramwqp.a().type != 3) {
        break label258;
      }
      if (!paramwqp.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramwtq.setVisibility(8);
      paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      xsm.a(paramwtq, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramwqp.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = xsm.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramwtq.setText(alud.a(2131706929));
        paramwtq.setVisibility(0);
        paramwtq.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166903));
        paramwtq.setBackgroundResource(2130846089);
        paramwtq.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramwtq.setVisibility(8);
    paramwtq.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166384));
    paramwtq.setBackgroundDrawable(null);
    paramInt = xsm.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    xsm.a(paramwtq, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, wtq paramwtq, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramwtq.a(2131373748);
    Object localObject2 = (TextView)paramwtq.a(2131373766);
    TextView localTextView = (TextView)paramwtq.a(2131373763);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Wpr.a();
    String str = ((wqn)localList.get(paramInt)).a().date;
    paramwtq = null;
    if (paramInt > 0) {
      paramwtq = ((wqn)localList.get(paramInt - 1)).a().date;
    }
    paramwtq = a(str, paramwtq);
    if (TextUtils.isEmpty(paramwtq)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramwtq);
        paramwtq = xsm.a(str);
        localObject1 = ((wml)this.jdField_a_of_type_Wpr).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramwtq[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(alud.a(2131706931), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
  }
  
  public void a(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public boolean a()
  {
    if (c()) {
      return super.a();
    }
    return true;
  }
  
  protected wtq b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561451, paramViewGroup, false));
    paramViewGroup.a(2131362068).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  protected void b()
  {
    super.b();
    h();
  }
  
  public void e_(boolean paramBoolean)
  {
    super.e_(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  protected int f_()
  {
    return super.f_() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnk
 * JD-Core Version:    0.7.0.1
 */