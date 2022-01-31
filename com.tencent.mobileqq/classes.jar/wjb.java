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

public class wjb
  extends wps
  implements wie
{
  public wjb(Context paramContext, Activity paramActivity, int paramInt, wpi paramwpi, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramwpi, paramBoolean);
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
    paramString = xod.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return alpo.a(2131706909);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return alpo.a(2131706911);
    }
    return paramString[1] + alpo.a(2131706914) + paramString[2] + alpo.a(2131706912);
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
      paramString1 = String.valueOf(xod.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = xod.a(paramString2);
      localObject = xod.a(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void Z_()
  {
    super.Z_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((wic)this.jdField_a_of_type_Wli).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((wic)this.jdField_a_of_type_Wli).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((wic)this.jdField_a_of_type_Wli).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, wph paramwph, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramwph.a();
    }
    return super.a(paramInt, paramwph, paramViewGroup);
  }
  
  @NonNull
  protected wli a(boolean paramBoolean)
  {
    return new wic(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public wph a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561480, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, wph paramwph, wmg paramwmg, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramwph.a(2131373705);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramwph.a(2131373701);
    TextView localTextView = (TextView)paramwph.a(2131373700);
    paramQQUserUIItem = (TextView)paramwph.a(2131373691);
    paramwph = (Button)paramwph.a(2131362068);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((wme)this.jdField_a_of_type_Wli.a().get(paramInt)).a().date));
    localObject = a(paramwmg.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramwmg.a().type != 3) {
        break label258;
      }
      if (!paramwmg.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramwph.setVisibility(8);
      paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      xod.a(paramwph, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramwmg.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = xod.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramwph.setText(alpo.a(2131706917));
        paramwph.setVisibility(0);
        paramwph.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166901));
        paramwph.setBackgroundResource(2130846016);
        paramwph.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramwph.setVisibility(8);
    paramwph.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166382));
    paramwph.setBackgroundDrawable(null);
    paramInt = xod.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    xod.a(paramwph, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, wph paramwph, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramwph.a(2131373697);
    Object localObject2 = (TextView)paramwph.a(2131373715);
    TextView localTextView = (TextView)paramwph.a(2131373712);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Wli.a();
    String str = ((wme)localList.get(paramInt)).a().date;
    paramwph = null;
    if (paramInt > 0) {
      paramwph = ((wme)localList.get(paramInt - 1)).a().date;
    }
    paramwph = a(str, paramwph);
    if (TextUtils.isEmpty(paramwph)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramwph);
        paramwph = xod.a(str);
        localObject1 = ((wic)this.jdField_a_of_type_Wli).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramwph[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(alpo.a(2131706919), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected wph b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new wph(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561433, paramViewGroup, false));
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
 * Qualified Name:     wjb
 * JD-Core Version:    0.7.0.1
 */