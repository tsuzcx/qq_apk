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

public class xmb
  extends xss
  implements xle
{
  public xmb(Context paramContext, Activity paramActivity, int paramInt, xsi paramxsi, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramxsi, paramBoolean);
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
      return amtj.a(2131705649);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return amtj.a(2131705651);
    }
    return paramString[1] + amtj.a(2131705654) + paramString[2] + amtj.a(2131705652);
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
  
  public void N_()
  {
    super.N_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((xlc)this.jdField_a_of_type_Xoi).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((xlc)this.jdField_a_of_type_Xoi).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((xlc)this.jdField_a_of_type_Xoi).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, xsh paramxsh, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramxsh.a();
    }
    return super.a(paramInt, paramxsh, paramViewGroup);
  }
  
  @NonNull
  protected xoi a(boolean paramBoolean)
  {
    return new xlc(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public xsh a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561652, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, xsh paramxsh, xpg paramxpg, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramxsh.a(2131374364);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramxsh.a(2131374360);
    TextView localTextView = (TextView)paramxsh.a(2131374359);
    paramQQUserUIItem = (TextView)paramxsh.a(2131374350);
    paramxsh = (Button)paramxsh.a(2131362134);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((xpe)this.jdField_a_of_type_Xoi.a().get(paramInt)).a().date));
    localObject = a(paramxpg.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramxpg.a().type != 3) {
        break label258;
      }
      if (!paramxpg.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramxsh.setVisibility(8);
      paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      UIUtils.expandViewTouchArea(paramxsh, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramxpg.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramxsh.setText(amtj.a(2131705657));
        paramxsh.setVisibility(0);
        paramxsh.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167012));
        paramxsh.setBackgroundResource(2130846453);
        paramxsh.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramxsh.setVisibility(8);
    paramxsh.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166481));
    paramxsh.setBackgroundDrawable(null);
    paramInt = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    UIUtils.expandViewTouchArea(paramxsh, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, xsh paramxsh, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramxsh.a(2131374356);
    Object localObject2 = (TextView)paramxsh.a(2131374374);
    TextView localTextView = (TextView)paramxsh.a(2131374371);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Xoi.a();
    String str = ((xpe)localList.get(paramInt)).a().date;
    paramxsh = null;
    if (paramInt > 0) {
      paramxsh = ((xpe)localList.get(paramInt - 1)).a().date;
    }
    paramxsh = a(str, paramxsh);
    if (TextUtils.isEmpty(paramxsh)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramxsh);
        paramxsh = UIUtils.parseDate(str);
        localObject1 = ((xlc)this.jdField_a_of_type_Xoi).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramxsh[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(amtj.a(2131705659), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected xsh b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new xsh(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561606, paramViewGroup, false));
    paramViewGroup.a(2131362134).setOnClickListener(paramViewGroup);
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
  
  protected int g_()
  {
    return super.g_() + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmb
 * JD-Core Version:    0.7.0.1
 */