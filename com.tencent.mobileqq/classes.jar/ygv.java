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

public class ygv
  extends ynm
  implements yfy
{
  public ygv(Context paramContext, Activity paramActivity, int paramInt, ync paramync, boolean paramBoolean)
  {
    super(paramContext, paramActivity, paramInt, paramync, paramBoolean);
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
    paramString = zlx.a(paramString);
    if ((localCalendar1.get(1) + 0 == paramString[0]) && (localCalendar1.get(2) + 1 == paramString[1]) && (localCalendar1.get(5) + 0 == paramString[2])) {
      return anni.a(2131705312);
    }
    if ((localCalendar2.get(1) + 0 == paramString[0]) && (localCalendar2.get(2) + 1 == paramString[1]) && (localCalendar2.get(5) + 0 == paramString[2])) {
      return anni.a(2131705314);
    }
    return paramString[1] + anni.a(2131705317) + paramString[2] + anni.a(2131705315);
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
      paramString1 = String.valueOf(zlx.a(paramString1)[0]);
    }
    do
    {
      return paramString1;
      paramString2 = zlx.a(paramString2);
      localObject = zlx.a(paramString1);
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
      if (!((yfw)this.jdField_a_of_type_Yjc).jdField_a_of_type_Boolean) {
        return 1;
      }
      if (((yfw)this.jdField_a_of_type_Yjc).jdField_a_of_type_JavaUtilList.size() > 0) {
        return super.a();
      }
    }
    return 0;
  }
  
  protected int a(int paramInt)
  {
    if (((yfw)this.jdField_a_of_type_Yjc).jdField_a_of_type_Boolean) {
      return super.a(paramInt);
    }
    return 4;
  }
  
  public View a(int paramInt, ynb paramynb, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return paramynb.a();
    }
    return super.a(paramInt, paramynb, paramViewGroup);
  }
  
  @NonNull
  protected yjc a(boolean paramBoolean)
  {
    return new yfw(this.jdField_a_of_type_Int, this, this, paramBoolean);
  }
  
  public ynb a(int paramInt, ViewGroup paramViewGroup)
  {
    if (a(paramInt) == 4) {
      return new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561733, paramViewGroup, false));
    }
    return super.a(paramInt, paramViewGroup);
  }
  
  protected void a(int paramInt, ynb paramynb, yka paramyka, QQUserUIItem paramQQUserUIItem)
  {
    Object localObject = (RelativeLayout)paramynb.a(2131374459);
    RelativeLayout localRelativeLayout = (RelativeLayout)paramynb.a(2131374455);
    TextView localTextView = (TextView)paramynb.a(2131374454);
    paramQQUserUIItem = (TextView)paramynb.a(2131374445);
    paramynb = (Button)paramynb.a(2131362128);
    ((RelativeLayout)localObject).setVisibility(0);
    localRelativeLayout.setVisibility(0);
    localTextView.setText(a(((yjy)this.jdField_a_of_type_Yjc.a().get(paramInt)).a().date));
    localObject = a(paramyka.a());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQUserUIItem.setVisibility(0);
      paramQQUserUIItem.setText((CharSequence)localObject);
      if (paramyka.a().type != 3) {
        break label258;
      }
      if (!paramyka.a().getOwner().isSubscribe()) {
        break label188;
      }
      paramynb.setVisibility(8);
      paramInt = zlx.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      zlx.a(paramynb, paramInt, paramInt, paramInt, paramInt);
    }
    label188:
    while (paramyka.a().type != 1) {
      for (;;)
      {
        return;
        paramQQUserUIItem.setVisibility(8);
        break;
        paramInt = zlx.a(this.jdField_a_of_type_AndroidContentContext, 13.0F);
        int i = zlx.a(this.jdField_a_of_type_AndroidContentContext, 3.0F);
        paramynb.setText(anni.a(2131705320));
        paramynb.setVisibility(0);
        paramynb.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166986));
        paramynb.setBackgroundResource(2130846528);
        paramynb.setPadding(paramInt, i, paramInt, i);
      }
    }
    label258:
    paramynb.setVisibility(8);
    paramynb.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166458));
    paramynb.setBackgroundDrawable(null);
    paramInt = zlx.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
    zlx.a(paramynb, paramInt, paramInt, paramInt, paramInt);
  }
  
  protected void a(int paramInt, ynb paramynb, boolean paramBoolean)
  {
    Object localObject1 = (RelativeLayout)paramynb.a(2131374451);
    Object localObject2 = (TextView)paramynb.a(2131374469);
    TextView localTextView = (TextView)paramynb.a(2131374466);
    localTextView.setVisibility(8);
    List localList = this.jdField_a_of_type_Yjc.a();
    String str = ((yjy)localList.get(paramInt)).a().date;
    paramynb = null;
    if (paramInt > 0) {
      paramynb = ((yjy)localList.get(paramInt - 1)).a().date;
    }
    paramynb = a(str, paramynb);
    if (TextUtils.isEmpty(paramynb)) {
      ((RelativeLayout)localObject1).setVisibility(8);
    }
    do
    {
      return;
      while (!((Iterator)localObject1).hasNext())
      {
        ((RelativeLayout)localObject1).setVisibility(0);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(paramynb);
        paramynb = zlx.a(str);
        localObject1 = ((yfw)this.jdField_a_of_type_Yjc).jdField_a_of_type_JavaUtilList.iterator();
      }
      localObject2 = (MomeriesYearNode)((Iterator)localObject1).next();
    } while (((MomeriesYearNode)localObject2).year != paramynb[0]);
    localTextView.setVisibility(0);
    localTextView.setText(String.format(anni.a(2131705322), new Object[] { Integer.valueOf(((MomeriesYearNode)localObject2).videoCount) }));
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
  
  protected ynb b(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = new ynb(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561687, paramViewGroup, false));
    paramViewGroup.a(2131362128).setOnClickListener(paramViewGroup);
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
 * Qualified Name:     ygv
 * JD-Core Version:    0.7.0.1
 */