import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class veo
  extends BaseAdapter
{
  protected static int a;
  protected static int b;
  protected static int c;
  protected Context a;
  protected GridView a;
  protected ArrayList<ver> a;
  protected ver a;
  protected boolean a;
  protected ArrayList<ver> b;
  
  public veo(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    jdField_a_of_type_Int = aciy.a(80.0F, paramContext);
    jdField_b_of_type_Int = aciy.a(10.0F, paramContext);
    c = aciy.a(5.0F, paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.add(ver.jdField_a_of_type_Ver);
    if (!paramBoolean1) {
      this.jdField_b_of_type_JavaUtilArrayList.add(ver.jdField_b_of_type_Ver);
    }
    if (paramBoolean2) {
      this.jdField_b_of_type_JavaUtilArrayList.add(ver.c);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public int a(ver paramver)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramver);
    }
    return -1;
  }
  
  public ver a()
  {
    return this.jdField_a_of_type_Ver;
  }
  
  public void a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(ver.c))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(ver.c);
        this.jdField_b_of_type_JavaUtilArrayList.remove(ver.c);
        i = 1;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void a(ArrayList<ver> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(0, this.jdField_b_of_type_JavaUtilArrayList);
    int i = getCount();
    this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(i);
    paramArrayList = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetGridView.getLayoutParams();
    int j = jdField_a_of_type_Int;
    paramArrayList.width = ((i - 1) * jdField_b_of_type_Int + j * i + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() + this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight());
    this.jdField_a_of_type_AndroidWidgetGridView.setLayoutParams(paramArrayList);
  }
  
  public void a(ver paramver)
  {
    this.jdField_a_of_type_Ver = paramver;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ver localver = (ver)getItem(paramInt);
    if (localver == null) {
      return null;
    }
    TextView localTextView;
    Object localObject;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(12.0F);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(jdField_a_of_type_Int, jdField_a_of_type_Int));
      localTextView.setPadding(c, jdField_b_of_type_Int, c, 0);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject = localTextView;
      localTextView.setText(localver.jdField_b_of_type_JavaLangString);
      if (localver.jdField_b_of_type_Int != 0) {
        break label213;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845566, 0, 0);
      if (localver.equals(this.jdField_a_of_type_Ver)) {
        localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100752), PorterDuff.Mode.MULTIPLY);
      }
      localTextView.setTag(null);
    }
    for (;;)
    {
      label648:
      label673:
      if (localver.equals(this.jdField_a_of_type_Ver))
      {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100752));
        return localObject;
        localTextView = (TextView)paramView;
        localObject = paramView;
        break;
        label213:
        if (localver.jdField_b_of_type_Int == 1)
        {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845570, 0, 0);
          if (localver.equals(this.jdField_a_of_type_Ver)) {
            localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100752), PorterDuff.Mode.MULTIPLY);
          }
          localTextView.setTag(null);
        }
        else if (localver.jdField_b_of_type_Int == 2)
        {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845563, 0, 0);
          if ((this.jdField_a_of_type_Ver != null) && (this.jdField_a_of_type_Ver.jdField_b_of_type_Int == 2)) {
            localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100752), PorterDuff.Mode.MULTIPLY);
          }
          localTextView.setTag(null);
        }
        else
        {
          Resources localResources;
          if (localver.jdField_b_of_type_Int == 4)
          {
            paramView = null;
            paramInt = (int)bacc.a(this.jdField_a_of_type_AndroidContentContext, 36.0F);
            if (localver.jdField_a_of_type_Int > 0)
            {
              paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localver.jdField_a_of_type_Int);
              paramView.setBounds(0, 0, paramInt, paramInt);
              localTextView.setCompoundDrawables(null, paramView, null, null);
            }
            for (;;)
            {
              if (!localver.equals(this.jdField_a_of_type_Ver)) {
                break label648;
              }
              localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100753), PorterDuff.Mode.SRC_ATOP);
              break;
              localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
              for (;;)
              {
                try
                {
                  paramViewGroup = localver.g;
                  if (TextUtils.isEmpty(paramViewGroup)) {
                    continue;
                  }
                  localFile = new File(paramViewGroup);
                  if ((!localFile.exists()) || (!localFile.isFile())) {
                    continue;
                  }
                  long l = localFile.length();
                  if (l <= 0L) {
                    continue;
                  }
                }
                catch (Exception paramView)
                {
                  File localFile;
                  byte[] arrayOfByte;
                  paramView = localResources.getDrawable(2130846376);
                  continue;
                  boolean bool = false;
                  continue;
                  paramView = localResources.getDrawable(2130846376);
                  continue;
                  paramView = localResources.getDrawable(2130846376);
                  continue;
                }
                try
                {
                  arrayOfByte = bace.b(localFile);
                  paramViewGroup = paramView;
                  if (arrayOfByte != null) {
                    paramViewGroup = Drawable.createFromStream(new ByteArrayInputStream(arrayOfByte), "voiceChangeIcon");
                  }
                }
                catch (Exception paramViewGroup)
                {
                  paramViewGroup.printStackTrace();
                  paramViewGroup = paramView;
                }
              }
              paramView = paramViewGroup;
              if (paramViewGroup == null)
              {
                paramView = URLDrawable.URLDrawableOptions.obtain();
                paramView.mFailedDrawable = localResources.getDrawable(2130846376);
                paramView.mLoadingDrawable = localResources.getDrawable(2130846376);
                paramView = URLDrawable.getDrawable(localFile, paramView);
                if ("drawable not null: " + paramView == null) {
                  break label673;
                }
                bool = true;
                QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
              }
              paramView.setBounds(0, 0, paramInt, paramInt);
              localTextView.setCompoundDrawables(null, paramView, null, null);
            }
          }
          else
          {
            if (localver.equals(this.jdField_a_of_type_Ver)) {
              localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845565, 0, 0);
            }
            for (;;)
            {
              localTextView.setTag(localver);
              break;
              localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130845564, 0, 0);
            }
          }
        }
      }
    }
    if ((localver.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Ver != null) && (this.jdField_a_of_type_Ver.jdField_b_of_type_Int == 2))
    {
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131100752));
      return localObject;
    }
    localTextView.setTextColor(-1);
    localTextView.getCompoundDrawables()[1].clearColorFilter();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     veo
 * JD-Core Version:    0.7.0.1
 */