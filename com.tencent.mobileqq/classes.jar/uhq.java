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

public class uhq
  extends uoh
  implements ugt
{
  public uhq(Context paramContext, Activity paramActivity, int paramInt, unx paramunx, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramunx, paramBoolean);
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
    paramString = vms.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return ajjy.a(2131640741);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return ajjy.a(2131640743);
    }
    return paramString[1] + ajjy.a(2131640746) + paramString[2] + ajjy.a(2131640744);
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
      paramString1 = String.valueOf(vms.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = vms.a(paramString2);
      localObject = vms.a(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void T_()
  {
    super.T_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((ugr)this.jdField_a_of_type_Ujx).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((ugr)this.jdField_a_of_type_Ujx).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((ugr)this.jdField_a_of_type_Ujx).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramunw.a();
    }
    return super.a(paramInt, paramunw, paramViewGroup);
  }
  
  @NonNull
  protected ujx a(boolean paramBoolean)
  {
    return new ugr(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495700, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, unw paramunw, ukv paramukv, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramunw.a(2131307541);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramunw.a(2131307537);
    TextView localTextView = (TextView)paramunw.a(2131307536);
    paramQQUserUIItem = (TextView)paramunw.a(2131307527);
    paramunw = (Button)paramunw.a(2131296525);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((ukt)this.jdField_a_of_type_Ujx.a().get(paramInt)).a().date));
    localObject = a(paramukv.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramukv.a().type != 3) {
        break label258;
      }
      if (!paramukv.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramunw.setVisibility(8);
      paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vms.a(paramunw, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramukv.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = vms.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramunw.setText(ajjy.a(2131640749));
        paramunw.setVisibility(0);
        paramunw.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101260));
        paramunw.setBackgroundResource(2130845447);
        paramunw.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramunw.setVisibility(8);
    paramunw.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100742));
    paramunw.setBackgroundDrawable(null);
    paramInt = vms.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    vms.a(paramunw, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, unw paramunw, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramunw.a(2131307533);
    Object localObject2 = (TextView)paramunw.a(2131307551);
    TextView localTextView = (TextView)paramunw.a(2131307548);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Ujx.a();
    String str = ((ukt)localList.get(paramInt)).a().date;
    paramunw = null;
    if (paramInt > 0) {
      paramunw = ((ukt)localList.get(paramInt - 1)).a().date;
    }
    paramunw = a(str, paramunw);
    if (TextUtils.isEmpty(paramunw)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramunw);
        paramunw = vms.a(str);
        localObject1 = ((ugr)this.jdField_a_of_type_Ujx).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramunw[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(ajjy.a(2131640751), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected unw b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495653, paramViewGroup, false));
    paramViewGroup.a(2131296525).setOnClickListener(paramViewGroup);
    a(paramViewGroup);
    return paramViewGroup;
  }
  
  protected void b()
  {
    super.b();
    h();
  }
  
  protected int f_()
  {
    return super.f_() + 1;
  }
  
  public void f_(boolean paramBoolean)
  {
    super.f_(paramBoolean);
    if (paramBoolean) {
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uhq
 * JD-Core Version:    0.7.0.1
 */