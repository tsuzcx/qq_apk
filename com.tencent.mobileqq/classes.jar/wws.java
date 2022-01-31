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
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;

public class wws
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 1;
  private final Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  private final List<xof> jdField_a_of_type_JavaUtilList;
  private www jdField_a_of_type_Www;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "来自微视APP";
  private List<xof> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  
  public wws(Context paramContext)
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
    localTextPaint.setTextSize(xsm.a(this.jdField_a_of_type_AndroidContentContext, 12.0F));
    int i1 = xsm.a(this.jdField_a_of_type_AndroidContentContext) - xsm.a(this.jdField_a_of_type_AndroidContentContext, 10.0F) * 2;
    int i2 = xsm.a(this.jdField_a_of_type_AndroidContentContext, 23.0F);
    float f1;
    int k;
    label103:
    int j;
    int i;
    float f2;
    int m;
    if (this.jdField_b_of_type_Boolean)
    {
      f1 = localTextPaint.measureText(this.jdField_b_of_type_JavaLangString) + xsm.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
      if (!paramBoolean) {
        break label319;
      }
      k = 2;
      j = 1;
      i = 0;
      if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label475;
      }
      f2 = localTextPaint.measureText(b((xof)this.jdField_a_of_type_JavaUtilList.get(i))) + xsm.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
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
          f1 = localTextPaint.measureText(this.jdField_a_of_type_JavaLangString) + xsm.a(this.jdField_a_of_type_AndroidContentContext, 18.0F);
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
        if (localTextPaint.measureText(alud.a(2131715116) + (i2 - i) + alud.a(2131715119)) + xsm.a(this.jdField_a_of_type_AndroidContentContext, 18.0F) + f1 > i1) {
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
  
  private static String b(xof paramxof)
  {
    String str = paramxof.jdField_a_of_type_JavaLangString;
    paramxof = str;
    if (bdnn.a(str) > 20) {
      paramxof = bdnn.a(str, 0, 20) + "...";
    }
    return "#" + paramxof;
  }
  
  private static void b(TextView paramTextView)
  {
    String str = ThemeUtil.getCurrentThemeId();
    if ("2040".equals(str))
    {
      paramTextView.setBackgroundResource(2130846394);
      return;
    }
    if ("1103".equals(str))
    {
      paramTextView.setBackgroundResource(2130846395);
      return;
    }
    paramTextView.setBackgroundResource(2130846396);
  }
  
  public void a(List<xof> paramList, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    if (paramList == null)
    {
      wxe.e("Q.qqstory.tag.TagAdapter", "TagList is null.");
      return;
    }
    wxe.a("Q.qqstory.tag.TagAdapter", "qimWording:%s, isTagFold:%s, tagList:%s,", paramString1, Boolean.valueOf(paramBoolean1), paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_b_of_type_JavaLangString = paramString2;
    a(paramBoolean1);
    notifyDataSetChanged();
  }
  
  public void a(www paramwww)
  {
    this.jdField_a_of_type_Www = paramwww;
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
    wxe.e("Q.qqstory.tag.TagAdapter", "mode error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 1)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561588, null);
      ((ImageView)paramView.findViewById(2131370737)).setOnClickListener(new wwt(this));
      paramView.setTag(2131373881, Integer.valueOf(i));
      return paramView;
    }
    if (i == 2)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561586, null);
      paramViewGroup = (TextView)paramView.findViewById(2131367664);
      paramInt = this.jdField_a_of_type_JavaUtilList.size();
      int j = this.jdField_b_of_type_JavaUtilList.size();
      paramViewGroup.setText(alud.a(2131715117) + (paramInt - j) + alud.a(2131715118));
      paramView.setTag(2131373881, Integer.valueOf(i));
      return paramView;
    }
    if (i == 3)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561584, null);
      paramViewGroup = (TextView)paramView.findViewById(2131377403);
      paramViewGroup.setText(this.jdField_a_of_type_JavaLangString);
      paramViewGroup.setOnClickListener(new wwu(this));
      b(paramViewGroup);
      paramView.setTag(2131373881, Integer.valueOf(i));
      return paramView;
    }
    if (i == 4)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561584, null);
      paramViewGroup = (TextView)paramView.findViewById(2131377403);
      float f = paramViewGroup.getPaint().measureText(this.jdField_b_of_type_JavaLangString);
      localObject = Shader.TileMode.CLAMP;
      localObject = new LinearGradient(0.0F, 0.0F, f, 0.0F, new int[] { -15289095, -8753934, -1161312 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject);
      paramViewGroup.getPaint().setShader((Shader)localObject);
      paramViewGroup.setText(this.jdField_b_of_type_JavaLangString);
      paramViewGroup.setOnClickListener(new wwv(this));
      b(paramViewGroup);
      paramView.setTag(2131373881, Integer.valueOf(i));
      return paramView;
    }
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561584, null);
      paramViewGroup = new wwx(paramView);
      paramView.setTag(paramViewGroup);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        break label476;
      }
    }
    label476:
    for (Object localObject = (xof)this.jdField_b_of_type_JavaUtilList.get(paramInt - 1);; localObject = (xof)this.jdField_b_of_type_JavaUtilList.get(paramInt))
    {
      paramViewGroup.a((xof)localObject, this.jdField_a_of_type_Www);
      paramView.setTag(2131373881, Integer.valueOf(i));
      return paramView;
      paramViewGroup = (wwx)paramView.getTag();
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wws
 * JD-Core Version:    0.7.0.1
 */