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

public class uum
  extends vbd
  implements utp
{
  public uum(Context paramContext, Activity paramActivity, int paramInt, vat paramvat, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramvat, paramBoolean);
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
    paramString = vzo.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return ajyc.a(2131706526);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return ajyc.a(2131706528);
    }
    return paramString[1] + ajyc.a(2131706531) + paramString[2] + ajyc.a(2131706529);
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
      paramString1 = String.valueOf(vzo.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = vzo.a(paramString2);
      localObject = vzo.a(paramString1);
      paramString1 = localCalendar;
    } while (paramString2[0] == localObject[0]);
    return String.valueOf(localObject[0]);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void R_()
  {
    super.R_();
    n();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (!((utn)this.jdField_a_of_type_Uwt).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((utn)this.jdField_a_of_type_Uwt).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((utn)this.jdField_a_of_type_Uwt).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, vas paramvas, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramvas.a();
    }
    return super.a(paramInt, paramvas, paramViewGroup);
  }
  
  @NonNull
  protected uwt a(boolean paramBoolean)
  {
    return new utn(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public vas a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561291, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, vas paramvas, uxr paramuxr, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramvas.a(2131373254);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvas.a(2131373250);
    TextView localTextView = (TextView)paramvas.a(2131373249);
    paramQQUserUIItem = (TextView)paramvas.a(2131373240);
    paramvas = (Button)paramvas.a(2131362066);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((uxp)this.jdField_a_of_type_Uwt.a().get(paramInt)).a().date));
    localObject = a(paramuxr.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramuxr.a().type != 3) {
        break label258;
      }
      if (!paramuxr.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramvas.setVisibility(8);
      paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vzo.a(paramvas, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramuxr.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = vzo.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramvas.setText(ajyc.a(2131706534));
        paramvas.setVisibility(0);
        paramvas.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
        paramvas.setBackgroundResource(2130845631);
        paramvas.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramvas.setVisibility(8);
    paramvas.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166335));
    paramvas.setBackgroundDrawable(null);
    paramInt = vzo.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    vzo.a(paramvas, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, vas paramvas, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramvas.a(2131373246);
    Object localObject2 = (TextView)paramvas.a(2131373264);
    TextView localTextView = (TextView)paramvas.a(2131373261);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Uwt.a();
    String str = ((uxp)localList.get(paramInt)).a().date;
    paramvas = null;
    if (paramInt > 0) {
      paramvas = ((uxp)localList.get(paramInt - 1)).a().date;
    }
    paramvas = a(str, paramvas);
    if (TextUtils.isEmpty(paramvas)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramvas);
        paramvas = vzo.a(str);
        localObject1 = ((utn)this.jdField_a_of_type_Uwt).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramvas[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(ajyc.a(2131706536), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected vas b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vas(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561244, paramViewGroup, false));
    paramViewGroup.a(2131362066).setOnClickListener(paramViewGroup);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uum
 * JD-Core Version:    0.7.0.1
 */