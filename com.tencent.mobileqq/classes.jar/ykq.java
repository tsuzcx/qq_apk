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

public class ykq
  extends yrh
  implements yjt
{
  public ykq(Context paramContext, Activity paramActivity, int paramInt, yqx paramyqx, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramyqx, paramBoolean);
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
    paramString = zps.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return anzj.a(2131705419);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return anzj.a(2131705421);
    }
    return paramString[1] + anzj.a(2131705424) + paramString[2] + anzj.a(2131705422);
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
      paramString1 = String.valueOf(zps.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = zps.a(paramString2);
      localObject = zps.a(paramString1);
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
      if (!((yjr)this.jdField_a_of_type_Ymx).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((yjr)this.jdField_a_of_type_Ymx).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((yjr)this.jdField_a_of_type_Ymx).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramyqw.a();
    }
    return super.a(paramInt, paramyqw, paramViewGroup);
  }
  
  @NonNull
  protected ymx a(boolean paramBoolean)
  {
    return new yjr(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561774, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, yqw paramyqw, ynv paramynv, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramyqw.a(2131374596);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramyqw.a(2131374592);
    TextView localTextView = (TextView)paramyqw.a(2131374591);
    paramQQUserUIItem = (TextView)paramyqw.a(2131374582);
    paramyqw = (Button)paramyqw.a(2131362134);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((ynt)this.jdField_a_of_type_Ymx.a().get(paramInt)).a().date));
    localObject = a(paramynv.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramynv.a().type != 3) {
        break label258;
      }
      if (!paramynv.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramyqw.setVisibility(8);
      paramInt = zps.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      zps.a(paramyqw, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramynv.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = zps.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = zps.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramyqw.setText(anzj.a(2131705427));
        paramyqw.setVisibility(0);
        paramyqw.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166990));
        paramyqw.setBackgroundResource(2130846545);
        paramyqw.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramyqw.setVisibility(8);
    paramyqw.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166462));
    paramyqw.setBackgroundDrawable(null);
    paramInt = zps.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    zps.a(paramyqw, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, yqw paramyqw, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramyqw.a(2131374588);
    Object localObject2 = (TextView)paramyqw.a(2131374606);
    TextView localTextView = (TextView)paramyqw.a(2131374603);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Ymx.a();
    String str = ((ynt)localList.get(paramInt)).a().date;
    paramyqw = null;
    if (paramInt > 0) {
      paramyqw = ((ynt)localList.get(paramInt - 1)).a().date;
    }
    paramyqw = a(str, paramyqw);
    if (TextUtils.isEmpty(paramyqw)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramyqw);
        paramyqw = zps.a(str);
        localObject1 = ((yjr)this.jdField_a_of_type_Ymx).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramyqw[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(anzj.a(2131705429), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected yqw b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561728, paramViewGroup, false));
    paramViewGroup.a(2131362134).setOnClickListener(paramViewGroup);
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
  
  protected int h_()
  {
    return super.h_() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykq
 * JD-Core Version:    0.7.0.1
 */