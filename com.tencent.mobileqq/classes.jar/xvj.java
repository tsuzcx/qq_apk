import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class xvj
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private final Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private final List<yml> jdField_a_of_type_JavaUtilList;
  private xvn jdField_a_of_type_Xvn;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "来自微视APP";
  private List<yml> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public xvj(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(boolean paramBoolean)
  {
    int n = 0;
    this.jdField_b_of_type_JavaUtilList.clear();
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    int i1 = UIUtils.getWindowScreenWidth(this.jdField_a_of_type_AndroidContentContext) - UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F) * 2;
    int i2 = UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 23.0F);
    float f1;
    int k;
    label103:
    int j;
    int i;
    float f2;
    int m;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = localTextPaint.measureText(this.jdField_b_of_type_JavaLangString) + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      if (!paramBoolean) {
        break label319;
      }
      k = 2;
      j = 1;
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label475;
      }
      f2 = localTextPaint.measureText(b((yml)this.jdField_a_of_type_JavaUtilList.get(i))) + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      if (f1 + f2 <= i1) {
        break label432;
      }
      m = j + 1;
      if (m <= k) {
        break label417;
      }
      if (!paramBoolean) {
        break label326;
      }
      if (i2 + f1 <= i1) {
        break label468;
      }
      i -= 1;
      j = m;
    }
    for (;;)
    {
      label206:
      if (j <= k)
      {
        i = this.jdField_a_of_type_JavaUtilList.size();
        this.jdField_a_of_type_Int = 1;
        j = n;
      }
      for (;;)
      {
        if (j >= i) {
          break label467;
        }
        this.jdField_b_of_type_JavaUtilList.add(this.jdField_a_of_type_JavaUtilList.get(j));
        j += 1;
        continue;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_Boolean = true;
          f1 = localTextPaint.measureText(this.jdField_a_of_type_JavaLangString) + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 18.0F);
          break;
        }
        this.jdField_a_of_type_Boolean = false;
        f1 = 0.0F;
        break;
        label319:
        k = 6;
        break label103;
        label326:
        i2 = this.jdField_a_of_type_JavaUtilList.size();
        j = i;
        if (localTextPaint.measureText(amtj.a(2131713757) + (i2 - i) + amtj.a(2131713760)) + UIUtils.dip2px(this.jdField_a_of_type_AndroidContentContext, 18.0F) + f1 > i1) {
          j = i - 1;
        }
        i = j;
        j = m;
        break label206;
        label417:
        f1 = f2;
        j = m;
        for (;;)
        {
          i += 1;
          break;
          label432:
          f1 += f2;
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_Int = 2;
          j = n;
        }
        else
        {
          this.jdField_a_of_type_Int = 3;
          j = n;
        }
      }
      label467:
      return;
      label468:
      j = m;
      continue;
      label475:
      i = 0;
    }
  }
  
  private static String b(yml paramyml)
  {
    String str = paramyml.jdField_a_of_type_JavaLangString;
    paramyml = str;
    if (StringUtil.getWordCount(str) > 20) {
      paramyml = StringUtil.substring(str, 0, 20) + "...";
    }
    return "#" + paramyml;
  }
  
  private static void b(TextView paramTextView)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if ("2040".equals(str))
    {
      paramTextView.setBackgroundResource(2130846757);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130846758);
      return;
    }
    paramTextView.setBackgroundResource(2130846759);
  }
  
  public void a(List<yml> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if (paramList == null)
    {
      xvv.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    xvv.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString1, Boolean.valueOf(paramBoolean1), paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public void a(xvn paramxvn)
  {
    this.jdField_a_of_type_Xvn = paramxvn;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
        return this.jdField_b_of_type_JavaUtilList.size() + 1;
      }
      return this.jdField_b_of_type_JavaUtilList.size();
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      return this.jdField_b_of_type_JavaUtilList.size() + 2;
    }
    return this.jdField_b_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) && (paramInt == 0)) {
        if (!this.jdField_b_of_type_Boolean) {}
      }
    }
    label95:
    label116:
    do
    {
      do
      {
        return 4;
        return 3;
        return 0;
        if (this.jdField_a_of_type_Int != 2) {
          break label116;
        }
        if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
          break label95;
        }
        if (paramInt != 0) {
          break;
        }
      } while (this.jdField_b_of_type_Boolean);
      return 3;
      if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 1;
      if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
        return 0;
      }
      return 1;
      if (this.jdField_a_of_type_Int != 3) {
        break label193;
      }
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label172;
      }
      if (paramInt != 0) {
        break;
      }
    } while (this.jdField_b_of_type_Boolean);
    return 3;
    if ((paramInt > 0) && (paramInt <= this.jdField_b_of_type_JavaUtilList.size())) {
      return 0;
    }
    return 2;
    label172:
    if ((paramInt >= 0) && (paramInt < this.jdField_b_of_type_JavaUtilList.size())) {
      return 0;
    }
    return 2;
    label193:
    xvv.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    if (i == 1)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561741, null);
      ((ImageView)localView.findViewById(2131371368)).setOnClickListener(new xvk(this));
      localView.setTag(2131374488, Integer.valueOf(i));
    }
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localView;
      if (i == 2)
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561739, null);
        localObject1 = (TextView)localView.findViewById(2131368078);
        int j = this.jdField_a_of_type_JavaUtilList.size();
        int k = this.jdField_b_of_type_JavaUtilList.size();
        ((TextView)localObject1).setText(amtj.a(2131713758) + (j - k) + amtj.a(2131713759));
        localView.setTag(2131374488, Integer.valueOf(i));
      }
      else if (i == 3)
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561737, null);
        localObject1 = (TextView)localView.findViewById(2131378151);
        ((TextView)localObject1).setText(this.jdField_a_of_type_JavaLangString);
        ((TextView)localObject1).setOnClickListener(new xvl(this));
        b((TextView)localObject1);
        localView.setTag(2131374488, Integer.valueOf(i));
      }
      else
      {
        if (i != 4) {
          break;
        }
        localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561737, null);
        localObject1 = (TextView)localView.findViewById(2131378151);
        float f = ((TextView)localObject1).getPaint().measureText(this.jdField_b_of_type_JavaLangString);
        Object localObject2 = Shader.TileMode.CLAMP;
        localObject2 = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -15289095, -8753934, -1161312 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject2);
        ((TextView)localObject1).getPaint().setShader((Shader)localObject2);
        ((TextView)localObject1).setText(this.jdField_b_of_type_JavaLangString);
        ((TextView)localObject1).setOnClickListener(new xvm(this));
        b((TextView)localObject1);
        localView.setTag(2131374488, Integer.valueOf(i));
      }
    }
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561737, null);
      localObject1 = new xvo(localView);
      localView.setTag(localObject1);
      label467:
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label540;
      }
    }
    label540:
    for (paramView = (yml)this.jdField_b_of_type_JavaUtilList.get(paramInt - 1);; paramView = (yml)this.jdField_b_of_type_JavaUtilList.get(paramInt))
    {
      ((xvo)localObject1).a(paramView, this.jdField_a_of_type_Xvn);
      localView.setTag(2131374488, Integer.valueOf(i));
      paramView = localView;
      break;
      localObject1 = (xvo)paramView.getTag();
      localView = paramView;
      break label467;
    }
  }
  
  public int getViewTypeCount()
  {
    int i = 2;
    int j = 1;
    if (this.jdField_a_of_type_Int == 1)
    {
      if (!this.jdField_b_of_type_Boolean)
      {
        i = j;
        if (!this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        i = 2;
      }
      return i;
    }
    if ((this.jdField_b_of_type_Boolean) || (this.jdField_a_of_type_Boolean)) {
      i = 3;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvj
 * JD-Core Version:    0.7.0.1
 */