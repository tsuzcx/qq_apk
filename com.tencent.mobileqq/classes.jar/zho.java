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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class zho
  extends BaseAdapter
{
  protected static int a;
  protected static int b;
  protected static int c;
  protected Context a;
  protected GridView a;
  protected ArrayList<zhr> a;
  protected zhr a;
  protected boolean a;
  protected ArrayList<zhr> b;
  
  public zho(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    jdField_a_of_type_Int = agej.a(80.0F, paramContext);
    jdField_b_of_type_Int = agej.a(10.0F, paramContext);
    c = agej.a(5.0F, paramContext);
    this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList.add(zhr.jdField_a_of_type_Zhr);
    if (!paramBoolean1) {
      this.jdField_b_of_type_JavaUtilArrayList.add(zhr.jdField_b_of_type_Zhr);
    }
    if (paramBoolean2) {
      this.jdField_b_of_type_JavaUtilArrayList.add(zhr.c);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public int a(zhr paramzhr)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      return this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramzhr);
    }
    return -1;
  }
  
  public zhr a()
  {
    return this.jdField_a_of_type_Zhr;
  }
  
  public void a()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      i = j;
      if (this.jdField_a_of_type_JavaUtilArrayList.contains(zhr.c))
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(zhr.c);
        this.jdField_b_of_type_JavaUtilArrayList.remove(zhr.c);
        i = 1;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void a(ArrayList<zhr> paramArrayList)
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
  
  public void a(zhr paramzhr)
  {
    this.jdField_a_of_type_Zhr = paramzhr;
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
    zhr localzhr = (zhr)getItem(paramInt);
    Object localObject1;
    if (localzhr == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(12.0F);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(jdField_a_of_type_Int, jdField_a_of_type_Int));
      localTextView.setPadding(c, jdField_b_of_type_Int, c, 0);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject1 = localTextView;
      label116:
      localTextView.setText(localzhr.jdField_b_of_type_JavaLangString);
      if (localzhr.jdField_b_of_type_Int != 0) {
        break label234;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846663, 0, 0);
      if (localzhr.equals(this.jdField_a_of_type_Zhr)) {
        localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472), PorterDuff.Mode.MULTIPLY);
      }
      localTextView.setTag(null);
      label187:
      if (!localzhr.equals(this.jdField_a_of_type_Zhr)) {
        break label786;
      }
      localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
    }
    for (;;)
    {
      paramView = (View)localObject1;
      break;
      localTextView = (TextView)paramView;
      localObject1 = paramView;
      break label116;
      label234:
      if (localzhr.jdField_b_of_type_Int == 1)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846667, 0, 0);
        if (localzhr.equals(this.jdField_a_of_type_Zhr)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      if (localzhr.jdField_b_of_type_Int == 2)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846660, 0, 0);
        if ((this.jdField_a_of_type_Zhr != null) && (this.jdField_a_of_type_Zhr.jdField_b_of_type_Int == 2)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      Resources localResources;
      if (localzhr.jdField_b_of_type_Int == 4)
      {
        paramView = null;
        int i = (int)bhmg.a(this.jdField_a_of_type_AndroidContentContext, 36.0F);
        if (localzhr.jdField_a_of_type_Int > 0)
        {
          paramView = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(localzhr.jdField_a_of_type_Int);
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        for (;;)
        {
          if (!localzhr.equals(this.jdField_a_of_type_Zhr)) {
            break label681;
          }
          localTextView.getCompoundDrawables()[1].setColorFilter(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166473), PorterDuff.Mode.SRC_ATOP);
          break;
          localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
          for (;;)
          {
            try
            {
              localObject2 = localzhr.g;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              localFile = new File((String)localObject2);
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
              Object localObject2;
              File localFile;
              byte[] arrayOfByte;
              View localView;
              paramView = localResources.getDrawable(2130847482);
              continue;
              boolean bool = false;
              continue;
              paramView = localResources.getDrawable(2130847482);
              continue;
              paramView = localResources.getDrawable(2130847482);
              continue;
            }
            try
            {
              arrayOfByte = bhmi.b(localFile);
              localObject2 = paramView;
              if (arrayOfByte != null) {
                localObject2 = Drawable.createFromStream(new ByteArrayInputStream(arrayOfByte), "voiceChangeIcon");
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localView = paramView;
            }
          }
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mFailedDrawable = localResources.getDrawable(2130847482);
            paramView.mLoadingDrawable = localResources.getDrawable(2130847482);
            paramView = URLDrawable.getDrawable(localFile, paramView);
            if ("drawable not null: " + paramView == null) {
              break label709;
            }
            bool = true;
            QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
          }
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        label681:
        break label187;
      }
      label709:
      if (localzhr.equals(this.jdField_a_of_type_Zhr)) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846662, 0, 0);
      }
      for (;;)
      {
        localTextView.setTag(localzhr);
        break;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130846661, 0, 0);
      }
      label786:
      if ((localzhr.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_Zhr != null) && (this.jdField_a_of_type_Zhr.jdField_b_of_type_Int == 2))
      {
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166472));
      }
      else
      {
        localTextView.setTextColor(-1);
        localTextView.getCompoundDrawables()[1].clearColorFilter();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zho
 * JD-Core Version:    0.7.0.1
 */