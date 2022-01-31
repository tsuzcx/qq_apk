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

public class uuj
  extends vba
  implements utm
{
  public uuj(Context paramContext, Activity paramActivity, int paramInt, vaq paramvaq, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramvaq, paramBoolean);
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
    paramString = vzl.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return ajya.a(2131706537);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return ajya.a(2131706539);
    }
    return paramString[1] + ajya.a(2131706542) + paramString[2] + ajya.a(2131706540);
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
      paramString1 = String.valueOf(vzl.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = vzl.a(paramString2);
      localObject = vzl.a(paramString1);
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
      if (!((utk)this.jdField_a_of_type_Uwq).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((utk)this.jdField_a_of_type_Uwq).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((utk)this.jdField_a_of_type_Uwq).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramvap.a();
    }
    return super.a(paramInt, paramvap, paramViewGroup);
  }
  
  @NonNull
  protected uwq a(boolean paramBoolean)
  {
    return new utk(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561290, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, vap paramvap, uxo paramuxo, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramvap.a(2131373256);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramvap.a(2131373252);
    TextView localTextView = (TextView)paramvap.a(2131373251);
    paramQQUserUIItem = (TextView)paramvap.a(2131373242);
    paramvap = (Button)paramvap.a(2131362065);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((uxm)this.jdField_a_of_type_Uwq.a().get(paramInt)).a().date));
    localObject = a(paramuxo.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramuxo.a().type != 3) {
        break label258;
      }
      if (!paramuxo.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramvap.setVisibility(8);
      paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      vzl.a(paramvap, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramuxo.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = vzl.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramvap.setText(ajya.a(2131706545));
        paramvap.setVisibility(0);
        paramvap.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166854));
        paramvap.setBackgroundResource(2130845637);
        paramvap.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramvap.setVisibility(8);
    paramvap.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166335));
    paramvap.setBackgroundDrawable(null);
    paramInt = vzl.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    vzl.a(paramvap, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, vap paramvap, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramvap.a(2131373248);
    Object localObject2 = (TextView)paramvap.a(2131373266);
    TextView localTextView = (TextView)paramvap.a(2131373263);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Uwq.a();
    String str = ((uxm)localList.get(paramInt)).a().date;
    paramvap = null;
    if (paramInt > 0) {
      paramvap = ((uxm)localList.get(paramInt - 1)).a().date;
    }
    paramvap = a(str, paramvap);
    if (TextUtils.isEmpty(paramvap)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramvap);
        paramvap = vzl.a(str);
        localObject1 = ((utk)this.jdField_a_of_type_Uwq).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramvap[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(ajya.a(2131706547), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected vap b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561243, paramViewGroup, false));
    paramViewGroup.a(2131362065).setOnClickListener(paramViewGroup);
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
 * Qualified Name:     uuj
 * JD-Core Version:    0.7.0.1
 */