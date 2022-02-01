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
import com.tencent.biz.qqstory.utils.UIUtils;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class yaw
  extends yhn
  implements xzz
{
  public yaw(Context paramContext, Activity paramActivity, int paramInt, yhd paramyhd, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramyhd, paramBoolean);
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
    paramString = UIUtils.parseDate(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return anvx.a(2131706000);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return anvx.a(2131706002);
    }
    return paramString[1] + anvx.a(2131706005) + paramString[2] + anvx.a(2131706003);
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
      paramString1 = String.valueOf(UIUtils.parseDate(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = UIUtils.parseDate(paramString2);
      localObject = UIUtils.parseDate(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void P_()
  {
    super.P_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((xzx)this.jdField_a_of_type_Ydd).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((xzx)this.jdField_a_of_type_Ydd).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((xzx)this.jdField_a_of_type_Ydd).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramyhc.a();
    }
    return super.a(paramInt, paramyhc, paramViewGroup);
  }
  
  @NonNull
  protected ydd a(boolean paramBoolean)
  {
    return new xzx(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561720, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, yhc paramyhc, yeb paramyeb, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramyhc.a(2131374602);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyhc.a(2131374598);
    TextView localTextView = (TextView)paramyhc.a(2131374597);
    paramQQUserUIItem = (TextView)paramyhc.a(2131374588);
    paramyhc = (Button)paramyhc.a(2131362138);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((ydz)this.jdField_a_of_type_Ydd.a().get(paramInt)).a().date));
    localObject = a(paramyeb.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramyeb.a().type != 3) {
        break label258;
      }
      if (!paramyeb.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramyhc.setVisibility(8);
      paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.expandViewTouchArea(paramyhc, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramyeb.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramyhc.setText(anvx.a(2131706008));
        paramyhc.setVisibility(0);
        paramyhc.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167026));
        paramyhc.setBackgroundResource(2130846549);
        paramyhc.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramyhc.setVisibility(8);
    paramyhc.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166495));
    paramyhc.setBackgroundDrawable(null);
    paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    UIUtils.expandViewTouchArea(paramyhc, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, yhc paramyhc, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramyhc.a(2131374594);
    Object localObject2 = (TextView)paramyhc.a(2131374612);
    TextView localTextView = (TextView)paramyhc.a(2131374609);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Ydd.a();
    String str = ((ydz)localList.get(paramInt)).a().date;
    paramyhc = null;
    if (paramInt > 0) {
      paramyhc = ((ydz)localList.get(paramInt - 1)).a().date;
    }
    paramyhc = a(str, paramyhc);
    if (TextUtils.isEmpty(paramyhc)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramyhc);
        paramyhc = UIUtils.parseDate(str);
        localObject1 = ((xzx)this.jdField_a_of_type_Ydd).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramyhc[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(anvx.a(2131706010), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected yhc b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561674, paramViewGroup, false));
    paramViewGroup.a(2131362138).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  protected void b()
  {
    super.b();
    h();
  }
  
  public void d_(boolean paramBoolean)
  {
    super.d_(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
  
  protected int f_()
  {
    return super.f_() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaw
 * JD-Core Version:    0.7.0.1
 */