import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class xkm
  extends xku
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<xkp> jdField_a_of_type_JavaUtilList;
  
  public xkm(Context paramContext, String paramString, int paramInt, @NonNull List<xkp> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private xkq a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new xkq(null);
      ((xkq)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (xkp)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new xkq(null);
        ((xkq)localObject2).jdField_a_of_type_Int = 2;
        ((xkq)localObject2).jdField_a_of_type_Xkp = ((xkp)localObject1);
        return localObject2;
      }
      if (!xkp.a((xkp)localObject1)) {
        break label253;
      }
      if (paramInt <= ((xkp)localObject1).a().size() + i)
      {
        localObject2 = (xko)((xkp)localObject1).a().get(paramInt - i - 1);
        xkq localxkq = new xkq(null);
        localxkq.jdField_a_of_type_Int = 3;
        localxkq.jdField_a_of_type_Xkp = ((xkp)localObject1);
        localxkq.jdField_a_of_type_Xko = ((xko)localObject2);
        return localxkq;
      }
      i = ((xkp)localObject1).a().size() + i;
    }
    label253:
    for (;;)
    {
      break;
      throw new IllegalStateException("can not find item with innerPos:" + paramInt);
    }
  }
  
  private void a(View paramView)
  {
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131364024);
    Object localObject = (ImageView)paramView.findViewById(2131364034);
    TextView localTextView = (TextView)paramView.findViewById(2131364031);
    paramView = paramView.findViewById(2131364025);
    localTextView.setText(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean)
    {
      ((ImageView)localObject).setVisibility(0);
      localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (!this.b) {
        break label138;
      }
      localCheckBox.setChecked(true);
    }
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      int i = -2170912;
      QQStoryContext.a();
      if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        i = -16444373;
      }
      paramView.setBackgroundColor(i);
      return;
      ((ImageView)localObject).setVisibility(4);
      break;
      label138:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, xkp paramxkp)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367351);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367353);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367324);
    paramView = (CheckBox)paramView.findViewById(2131367326);
    localTextView1.setText(paramxkp.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(paramxkp.a()), Integer.valueOf(paramxkp.b()) }));
    if (paramxkp.b() == 0)
    {
      paramView.setVisibility(4);
      if (!paramxkp.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!xkp.a(paramxkp)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new xkn(this, paramxkp));
      return;
      paramView.setVisibility(0);
      break;
      label146:
      paramView.setChecked(false);
      break label111;
      label154:
      localCheckBox.setChecked(false);
    }
  }
  
  private void a(View paramView, xkp paramxkp, xko paramxko)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131366914);
    Object localObject1 = (TextView)paramView.findViewById(2131366934);
    Object localObject2 = (CheckBox)paramView.findViewById(2131366897);
    paramView = paramView.findViewById(2131366896);
    ((TextView)localObject1).setText(paramxko.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (paramxko.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bdhj.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = bdbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramxko.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(paramxkp) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramxkp = paramxkp.a();
        if (paramxkp.indexOf(paramxko) == paramxkp.size() - 1)
        {
          int i = -2170912;
          QQStoryContext.a();
          if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
            i = -16444373;
          }
          paramView.setBackgroundColor(i);
          paramView.setVisibility(0);
        }
      }
      return;
      ((CheckBox)localObject2).setChecked(false);
      break;
      label207:
      wxe.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      wxe.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(xkq paramxkq)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean) {
      if (!this.b) {
        bool = true;
      }
    }
    for (this.b = bool;; this.b = true)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      bool = false;
      break;
    }
  }
  
  private void b(xkq paramxkq)
  {
    paramxkq.jdField_a_of_type_Xkp.a();
  }
  
  private int c()
  {
    if (!this.b) {
      return 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      xkp localxkp = (xkp)localIterator.next();
      List localList = localxkp.a();
      i += 1;
      if (!xkp.a(localxkp)) {
        break label72;
      }
      i = localList.size() + i;
    }
    label72:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private void c(xkq paramxkq)
  {
    paramxkq.jdField_a_of_type_Xkp.a(paramxkq.jdField_a_of_type_Xko);
  }
  
  public int a()
  {
    return c();
  }
  
  public int a(int paramInt)
  {
    return a(paramInt).jdField_a_of_type_Int;
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (a(paramInt).jdField_a_of_type_Int)
    {
    default: 
      return null;
    case 1: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561521, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561523, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561522, null);
  }
  
  @NonNull
  public List<xko> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((xkp)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    xkq localxkq = a(paramInt);
    switch (localxkq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localxkq);
      return;
    case 2: 
      b(localxkq);
      return;
    }
    c(localxkq);
  }
  
  public void a(int paramInt, View paramView)
  {
    xkq localxkq = a(paramInt);
    switch (localxkq.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localxkq.jdField_a_of_type_Xkp);
      return;
    }
    a(paramView, localxkq.jdField_a_of_type_Xkp, localxkq.jdField_a_of_type_Xko);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      xkp localxkp = (xkp)localIterator1.next();
      Iterator localIterator2 = localxkp.a().iterator();
      while (localIterator2.hasNext())
      {
        xko localxko = (xko)localIterator2.next();
        if (paramList.contains(localxko.a())) {
          localxkp.b(localxko);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xkm
 * JD-Core Version:    0.7.0.1
 */