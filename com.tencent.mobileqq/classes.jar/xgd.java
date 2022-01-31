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

public class xgd
  extends xgl
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<xgg> jdField_a_of_type_JavaUtilList;
  
  public xgd(Context paramContext, String paramString, int paramInt, @NonNull List<xgg> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private xgh a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new xgh(null);
      ((xgh)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (xgg)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new xgh(null);
        ((xgh)localObject2).jdField_a_of_type_Int = 2;
        ((xgh)localObject2).jdField_a_of_type_Xgg = ((xgg)localObject1);
        return localObject2;
      }
      if (!xgg.a((xgg)localObject1)) {
        break label253;
      }
      if (paramInt <= ((xgg)localObject1).a().size() + i)
      {
        localObject2 = (xgf)((xgg)localObject1).a().get(paramInt - i - 1);
        xgh localxgh = new xgh(null);
        localxgh.jdField_a_of_type_Int = 3;
        localxgh.jdField_a_of_type_Xgg = ((xgg)localObject1);
        localxgh.jdField_a_of_type_Xgf = ((xgf)localObject2);
        return localxgh;
      }
      i = ((xgg)localObject1).a().size() + i;
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
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131364022);
    Object localObject = (ImageView)paramView.findViewById(2131364032);
    TextView localTextView = (TextView)paramView.findViewById(2131364029);
    paramView = paramView.findViewById(2131364023);
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
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = xod.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
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
  
  private void a(View paramView, xgg paramxgg)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367341);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367343);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367314);
    paramView = (CheckBox)paramView.findViewById(2131367316);
    localTextView1.setText(paramxgg.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(paramxgg.a()), Integer.valueOf(paramxgg.b()) }));
    if (paramxgg.b() == 0)
    {
      paramView.setVisibility(4);
      if (!paramxgg.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!xgg.a(paramxgg)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new xge(this, paramxgg));
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
  
  private void a(View paramView, xgg paramxgg, xgf paramxgf)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131366904);
    Object localObject1 = (TextView)paramView.findViewById(2131366924);
    Object localObject2 = (CheckBox)paramView.findViewById(2131366887);
    paramView = paramView.findViewById(2131366886);
    ((TextView)localObject1).setText(paramxgf.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (paramxgf.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bdda.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = bcxb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramxgf.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(paramxgg) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramxgg = paramxgg.a();
        if (paramxgg.indexOf(paramxgf) == paramxgg.size() - 1)
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
      wsv.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      wsv.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(xgh paramxgh)
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
  
  private void b(xgh paramxgh)
  {
    paramxgh.jdField_a_of_type_Xgg.a();
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
      xgg localxgg = (xgg)localIterator.next();
      List localList = localxgg.a();
      i += 1;
      if (!xgg.a(localxgg)) {
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
  
  private void c(xgh paramxgh)
  {
    paramxgh.jdField_a_of_type_Xgg.a(paramxgh.jdField_a_of_type_Xgf);
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
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561503, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561505, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561504, null);
  }
  
  @NonNull
  public List<xgf> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((xgg)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    xgh localxgh = a(paramInt);
    switch (localxgh.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localxgh);
      return;
    case 2: 
      b(localxgh);
      return;
    }
    c(localxgh);
  }
  
  public void a(int paramInt, View paramView)
  {
    xgh localxgh = a(paramInt);
    switch (localxgh.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localxgh.jdField_a_of_type_Xgg);
      return;
    }
    a(paramView, localxgh.jdField_a_of_type_Xgg, localxgh.jdField_a_of_type_Xgf);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      xgg localxgg = (xgg)localIterator1.next();
      Iterator localIterator2 = localxgg.a().iterator();
      while (localIterator2.hasNext())
      {
        xgf localxgf = (xgf)localIterator2.next();
        if (paramList.contains(localxgf.a())) {
          localxgg.b(localxgf);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xgd
 * JD-Core Version:    0.7.0.1
 */