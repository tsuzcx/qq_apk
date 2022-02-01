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

public class zhs
  extends zia
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<zhv> jdField_a_of_type_JavaUtilList;
  
  public zhs(Context paramContext, String paramString, int paramInt, @NonNull List<zhv> paramList, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramString, paramInt);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private zhw a(int paramInt)
  {
    int i = c();
    if ((paramInt < 0) || (paramInt >= i)) {
      throw new IllegalStateException("getViewType Exception, innerPos:" + paramInt + ",LineCount:" + i);
    }
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new zhw(null);
      ((zhw)localObject1).jdField_a_of_type_Int = 1;
      return localObject1;
    }
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    i = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (zhv)((Iterator)localObject2).next();
      i += 1;
      if (i == paramInt)
      {
        localObject2 = new zhw(null);
        ((zhw)localObject2).jdField_a_of_type_Int = 2;
        ((zhw)localObject2).jdField_a_of_type_Zhv = ((zhv)localObject1);
        return localObject2;
      }
      if (!zhv.a((zhv)localObject1)) {
        break label253;
      }
      if (paramInt <= ((zhv)localObject1).a().size() + i)
      {
        localObject2 = (zhu)((zhv)localObject1).a().get(paramInt - i - 1);
        zhw localzhw = new zhw(null);
        localzhw.jdField_a_of_type_Int = 3;
        localzhw.jdField_a_of_type_Zhv = ((zhv)localObject1);
        localzhw.jdField_a_of_type_Zhu = ((zhu)localObject2);
        return localzhw;
      }
      i = ((zhv)localObject1).a().size() + i;
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
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131364270);
    Object localObject = (ImageView)paramView.findViewById(2131364280);
    TextView localTextView = (TextView)paramView.findViewById(2131364277);
    paramView = paramView.findViewById(2131364271);
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
    for (((RelativeLayout.LayoutParams)localObject).leftMargin = zps.a(this.jdField_a_of_type_AndroidContentContext, 32.0F);; ((RelativeLayout.LayoutParams)localObject).leftMargin = 0)
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
  
  private void a(View paramView, zhv paramzhv)
  {
    TextView localTextView1 = (TextView)paramView.findViewById(2131367726);
    TextView localTextView2 = (TextView)paramView.findViewById(2131367728);
    CheckBox localCheckBox = (CheckBox)paramView.findViewById(2131367699);
    paramView = (CheckBox)paramView.findViewById(2131367701);
    localTextView1.setText(paramzhv.a.group_name);
    localTextView2.setText(String.format("(%s/%s)", new Object[] { Integer.valueOf(paramzhv.a()), Integer.valueOf(paramzhv.b()) }));
    if (paramzhv.b() == 0)
    {
      paramView.setVisibility(4);
      if (!paramzhv.a()) {
        break label146;
      }
      paramView.setChecked(true);
      label111:
      if (!zhv.a(paramzhv)) {
        break label154;
      }
      localCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramView.setOnClickListener(new zht(this, paramzhv));
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
  
  private void a(View paramView, zhv paramzhv, zhu paramzhu)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131367233);
    Object localObject1 = (TextView)paramView.findViewById(2131367253);
    Object localObject2 = (CheckBox)paramView.findViewById(2131367216);
    paramView = paramView.findViewById(2131367215);
    ((TextView)localObject1).setText(paramzhu.jdField_a_of_type_ComTencentMobileqqDataFriends.remark);
    if (paramzhu.jdField_a_of_type_Boolean)
    {
      ((CheckBox)localObject2).setChecked(true);
      localObject1 = bhmq.b();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label226;
      }
      localObject2 = aoot.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramzhu.jdField_a_of_type_ComTencentMobileqqDataFriends.uin, 3, (Drawable)localObject1, (Drawable)localObject1);
      if (localObject2 == null) {
        break label207;
      }
      localImageView.setImageDrawable((Drawable)localObject2);
    }
    for (;;)
    {
      paramView.setVisibility(4);
      if (this.jdField_a_of_type_JavaUtilList.indexOf(paramzhv) == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramzhv = paramzhv.a();
        if (paramzhv.indexOf(paramzhu) == paramzhv.size() - 1)
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
      yuk.e("Q.qqstory.publish.edit.ComplexPart", "FaceDrawable is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
      continue;
      label226:
      yuk.e("Q.qqstory.publish.edit.ComplexPart", "QQAppInterface is null.");
      localImageView.setImageDrawable((Drawable)localObject1);
    }
  }
  
  private void a(zhw paramzhw)
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
  
  private void b(zhw paramzhw)
  {
    paramzhw.jdField_a_of_type_Zhv.a();
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
      zhv localzhv = (zhv)localIterator.next();
      List localList = localzhv.a();
      i += 1;
      if (!zhv.a(localzhv)) {
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
  
  private void c(zhw paramzhw)
  {
    paramzhw.jdField_a_of_type_Zhv.a(paramzhw.jdField_a_of_type_Zhu);
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
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561797, null);
    case 2: 
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561799, null);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561798, null);
  }
  
  @NonNull
  public List<zhu> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((zhv)localIterator.next()).b());
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    zhw localzhw = a(paramInt);
    switch (localzhw.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(localzhw);
      return;
    case 2: 
      b(localzhw);
      return;
    }
    c(localzhw);
  }
  
  public void a(int paramInt, View paramView)
  {
    zhw localzhw = a(paramInt);
    switch (localzhw.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      a(paramView);
      return;
    case 2: 
      a(paramView, localzhw.jdField_a_of_type_Zhv);
      return;
    }
    a(paramView, localzhw.jdField_a_of_type_Zhv, localzhw.jdField_a_of_type_Zhu);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator1.hasNext())
    {
      zhv localzhv = (zhv)localIterator1.next();
      Iterator localIterator2 = localzhv.a().iterator();
      while (localIterator2.hasNext())
      {
        zhu localzhu = (zhu)localIterator2.next();
        if (paramList.contains(localzhu.a())) {
          localzhv.b(localzhu);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zhs
 * JD-Core Version:    0.7.0.1
 */