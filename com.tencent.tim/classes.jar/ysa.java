import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ThemeImageView;

public abstract class ysa
{
  public static final int[] fA = { 2131371284 };
  public static final int[] fy = { 2131692505 };
  public static final int[] fz = { 2130839769 };
  protected auvd a;
  public ytd a;
  public ytv a;
  public QQAppInterface mApp;
  protected Context mContext;
  protected int mItemHeight;
  
  public ysa(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    this.mContext = paramContext;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_Ytd = paramytd;
    this.jdField_a_of_type_Ytv = paramytv;
    this.mItemHeight = paramContext.getResources().getDimensionPixelSize(2131297807);
  }
  
  public static void C(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramView.setBackgroundResource(2130839644);
      return;
    }
    if (ThemeUtil.isDefaultTheme())
    {
      paramView.setBackgroundResource(2130839642);
      return;
    }
    paramView.setBackgroundResource(2130839639);
  }
  
  public static void D(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getPaddingBottom();
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingLeft();
    if (paramBoolean) {
      paramView.setBackgroundResource(2130839644);
    }
    for (;;)
    {
      paramView.setPadding(m, j, k, i);
      return;
      if (ThemeUtil.isDefaultTheme()) {
        paramView.setBackgroundResource(2130839642);
      } else {
        paramView.setBackgroundResource(2130839639);
      }
    }
  }
  
  public static void Z(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new AbsListView.LayoutParams(-1, paramInt);
    }
    for (;;)
    {
      paramView.setMinimumHeight(paramInt);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      ((ViewGroup.LayoutParams)localObject).width = -1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int k = 1;
    int j;
    int i;
    switch (paramInt1)
    {
    default: 
      paramTextView.setBackgroundResource(2130846773);
      j = 0;
      i = 0;
    }
    for (;;)
    {
      if ((paramInt2 > 0) && ((paramInt1 == 0) || (paramInt1 == 1)))
      {
        paramTextView.setText(String.valueOf(paramInt2));
        paramInt1 = k;
        if (paramStringBuilder != null)
        {
          paramInt1 = k;
          if (AppSetting.enableTalkBack) {
            paramStringBuilder.append(",").append(String.valueOf(paramInt2));
          }
        }
      }
      for (paramInt1 = k;; paramInt1 = i)
      {
        paramTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
        if (paramInt1 != 0) {}
        paramTextView.setVisibility(8);
        return;
        j = 2130846772;
        paramTextView.setBackgroundResource(2130846773);
        i = j;
        if (paramStringBuilder == null) {
          break label216;
        }
        i = j;
        if (!AppSetting.enableTalkBack) {
          break label216;
        }
        paramStringBuilder.append(",男");
        j = 2130846772;
        i = 1;
        break;
        j = 2130846770;
        paramTextView.setBackgroundResource(2130846771);
        i = j;
        if (paramStringBuilder == null) {
          break label216;
        }
        i = j;
        if (!AppSetting.enableTalkBack) {
          break label216;
        }
        paramStringBuilder.append(",女");
        j = 2130846770;
        i = 1;
        break;
        paramTextView.setText("");
      }
      label216:
      j = i;
      i = 1;
    }
  }
  
  public void Y(View paramView, int paramInt)
  {
    if (paramView == null) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(2131377370);
      if ((localView == paramView) || (localView == null))
      {
        Z(paramView, paramInt);
        return;
      }
      paramView = localView.getLayoutParams();
    } while (paramView == null);
    paramView.width = -1;
    paramView.height = paramInt;
    localView.setLayoutParams(paramView);
  }
  
  public abstract View a(int paramInt, View paramView);
  
  protected View a(Context paramContext, int paramInt, ysa.a parama)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    if (this.jdField_a_of_type_Ytd != null) {
      return this.jdField_a_of_type_Auvd.a(paramContext, localView, parama, -1);
    }
    parama.Lz = localView;
    parama.b = null;
    return localView;
  }
  
  protected auvd a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131299263);
    int j = paramContext.getResources().getDimensionPixelSize(2131299264);
    paramContext = fA;
    int[] arrayOfInt1 = fy;
    int[] arrayOfInt2 = fz;
    return new ysb(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  protected void a(Context paramContext, View paramView, int paramInt, Object paramObject, auvd.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Auvd != null) {}
    for (int i = this.jdField_a_of_type_Auvd.a(paramContext, paramView, paramInt, paramObject, parama, paramOnClickListener);; i = 0)
    {
      if ((this.jdField_a_of_type_Ytd != null) && (this.jdField_a_of_type_Ytd.bKH != -1))
      {
        if (paramInt != this.jdField_a_of_type_Ytd.bKH) {
          paramView.scrollTo(0, 0);
        }
      }
      else {
        return;
      }
      paramView.scrollTo(i, 0);
      return;
    }
  }
  
  public void a(ytv paramytv)
  {
    this.jdField_a_of_type_Ytv = paramytv;
  }
  
  protected void clg() {}
  
  public void fI(View paramView)
  {
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
  }
  
  protected void fJ(View paramView)
  {
    if (!aqft.equalsWithNullCheck("tag_swip_icon_menu_item", paramView.getTag())) {}
    for (;;)
    {
      return;
      if (!aqiw.isNetworkAvailable(this.mContext))
      {
        QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
        return;
      }
      Object localObject1 = paramView.getTag(-1);
      Object localObject2 = paramView.getTag(-2);
      if ((!(localObject1 instanceof Integer)) || (!(localObject2 instanceof Integer)))
      {
        if (!QLog.isDevelopLevel()) {
          continue;
        }
        QLog.i("Q.newfriend", 4, "SystemMsgListAdpater onClick tag is not int");
        return;
      }
      int i = ((Integer)localObject1).intValue();
      int j = ((Integer)localObject2).intValue();
      localObject1 = null;
      if (QLog.isColorLevel()) {
        QLog.i("Q.newfriend", 2, "SystemMsgListAdpater onClick position = " + i + "nMenuStrId = " + j + "v.getId() = " + paramView.getId());
      }
      try
      {
        paramView = this.mContext.getResources().getString(j);
        if (!aqft.equalsWithNullCheck(paramView, this.mContext.getResources().getString(fy[0]))) {
          continue;
        }
        clg();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramView = localObject1;
          if (QLog.isDevelopLevel())
          {
            QLog.i("Q.newfriend", 4, localException.toString());
            paramView = localObject1;
          }
        }
      }
    }
  }
  
  public int getTitleBarHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131299627);
  }
  
  protected int xl()
  {
    return 0;
  }
  
  public static class a
    extends auvd.a
  {
    public TextView LA;
    public TextView LB;
    public TextView LG;
    public TextView LR;
    public TextView Lx;
    public TextView Ly;
    public TextView Lz;
    public TroopLabelLayout a;
    public String aZH;
    public Button ej;
    public ImageView uw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysa
 * JD-Core Version:    0.7.0.1
 */