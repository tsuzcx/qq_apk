import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.GridListAdapter.1;
import com.tencent.biz.troopgift.GridListAdapter.2;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class yqm
  extends BaseAdapter
{
  protected int a;
  public Context a;
  protected Drawable a;
  protected LayoutInflater a;
  protected TroopGiftPanel a;
  protected String a;
  protected ArrayList<Object> a;
  protected int b;
  
  public yqm(Context paramContext, TroopGiftPanel paramTroopGiftPanel)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130848725);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = aekt.a(9.0F, paramContext.getResources());
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, int paramInt4)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Canvas(localBitmap);
      Object localObject2 = new Paint();
      ((Paint)localObject2).setColor(paramInt4);
      ((Paint)localObject2).setStyle(Paint.Style.STROKE);
      ((Paint)localObject2).setStrokeWidth(paramFloat2);
      ((Paint)localObject2).setAntiAlias(true);
      ((Canvas)localObject1).drawRoundRect(new RectF(paramFloat2 / 2.0F, paramFloat2 / 2.0F, paramInt1 - paramFloat2 / 2.0F, paramInt2 - paramFloat2 / 2.0F), paramInt3, paramInt3, (Paint)localObject2);
      localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
      paramFloat1 = (paramInt1 - paramFloat1) / 2.0F;
      ((Canvas)localObject2).drawRect(paramFloat1, 0.0F, paramInt1 - paramFloat1, paramInt3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      ((Canvas)localObject2).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localBitmap.recycle();
      return localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(ArrayList<Object> paramArrayList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("GridListAdapter setData items = ");
      if (paramArrayList != null) {
        break label51;
      }
    }
    label51:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramArrayList.size()))
    {
      QLog.d("zivonchen", 2, localObject);
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      return;
    }
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
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new yqn();
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
        break label724;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559805, null);
      if (getCount() < 5) {
        break label1553;
      }
      localObject = new RelativeLayout.LayoutParams(-2, -1);
      ((ViewGroup.LayoutParams)localObject).width = (azgq.jdField_a_of_type_Int / 5 + 30);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    label399:
    label1168:
    label1553:
    for (;;)
    {
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366815));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367210));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367216));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367221));
      paramViewGroup.g = ((TextView)paramView.findViewById(2131366816));
      paramViewGroup.f = ((TextView)paramView.findViewById(2131377800));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131367222));
      paramViewGroup.d = ((TextView)paramView.findViewById(2131367213));
      paramViewGroup.e = ((TextView)paramView.findViewById(2131367215));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363120);
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131367211));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367224));
      paramView.setTag(paramViewGroup);
      paramViewGroup = paramView;
      localObject = (yqn)paramViewGroup.getTag();
      yqu localyqu = (yqu)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      ((yqn)localObject).jdField_a_of_type_Yqu = localyqu;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b())
      {
        ((yqn)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        ((yqn)localObject).jdField_a_of_type_AndroidWidgetTextView.setText(localyqu.jdField_a_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((yqn)localObject).jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
        }
        label327:
        if (((yqn)localObject).jdField_c_of_type_AndroidWidgetImageView != null)
        {
          if ((localyqu.j != 1) || (TextUtils.isEmpty(localyqu.jdField_e_of_type_JavaLangString))) {
            break label752;
          }
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mPlayGifImage = false;
          paramView.mLoadingDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          paramView = URLDrawable.getDrawable(localyqu.jdField_e_of_type_JavaLangString, paramView);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        }
        if ((!localyqu.jdField_c_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c() <= 0)) {
          break label765;
        }
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        ((yqn)localObject).g.setVisibility(0);
        ((yqn)localObject).g.setText("免费x" + this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c());
        label470:
        if (localyqu.jdField_b_of_type_Int != 0) {
          break label1296;
        }
        ((yqn)localObject).e.setVisibility(0);
        label487:
        paramView = URLDrawable.URLDrawableOptions.obtain();
        if (!localyqu.jdField_a_of_type_Boolean) {
          break label1435;
        }
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
          break label1309;
        }
        ((yqn)localObject).jdField_a_of_type_AndroidViewView.setVisibility(4);
        ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        ((yqn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.post(new GridListAdapter.1(this, (yqn)localObject));
        paramView.mPlayGifImage = true;
        paramView.mLoadingDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramView = URLDrawable.getDrawable(localyqu.jdField_b_of_type_JavaLangString, paramView);
        if (!localyqu.jdField_c_of_type_Boolean) {
          break label1528;
        }
        if (!localyqu.jdField_a_of_type_Boolean) {
          break label1502;
        }
        ((yqn)localObject).d.setVisibility(0);
        ((yqn)localObject).d.setText(alpo.a(2131705714) + localyqu.i + alpo.a(2131705716));
        label639:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.c()) {
          break label1515;
        }
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      for (;;)
      {
        ((yqn)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramView);
        if ((this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) || (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) || (TextUtils.isEmpty(localyqu.jdField_d_of_type_JavaLangString))) {
          break label1541;
        }
        ((yqn)localObject).f.setVisibility(0);
        ((yqn)localObject).f.setText(localyqu.jdField_d_of_type_JavaLangString);
        return paramViewGroup;
        label724:
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560445, null);
        break;
        ((yqn)localObject).jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        break label327;
        label752:
        ((yqn)localObject).jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        break label399;
        label765:
        if (localyqu.jdField_d_of_type_Boolean)
        {
          if (((yqn)localObject).g != null) {
            ((yqn)localObject).g.setVisibility(8);
          }
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
          paramView = (bckf)this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.b.get(localyqu.jdField_a_of_type_Int);
          if (paramView == null)
          {
            paramView = alpo.a(2131705717);
            ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
            break label470;
          }
          paramView = "×" + paramView.jdField_b_of_type_Int;
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(paramView);
          break label470;
        }
        if (((yqn)localObject).g != null) {
          ((yqn)localObject).g.setVisibility(8);
        }
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_AndroidUtilSparseArray;
        if (localyqu.jdField_e_of_type_Int != 0)
        {
          paramInt = localyqu.jdField_e_of_type_Int;
          label947:
          paramView = (bcke)paramView.get(paramInt);
          if ((paramView != null) && (paramView.jdField_b_of_type_Int + paramView.c != 0)) {
            break label1185;
          }
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localyqu.f));
          if ((!localyqu.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Yqw.jdField_d_of_type_JavaLangString))) {
            break label1140;
          }
          paramView = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a.jdField_a_of_type_Yqw.jdField_d_of_type_JavaLangString;
          if (TextUtils.isEmpty(paramView)) {
            break label1148;
          }
        }
        label1140:
        label1148:
        for (paramView = URLDrawable.getDrawable(paramView, URLDrawable.URLDrawableOptions.obtain());; paramView = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          paramView.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawables(paramView, null, null, null);
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
            ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(8);
          }
          if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() != 20) {
            break label1168;
          }
          if (!this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b()) {
            break label1156;
          }
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#c3c3c3"));
          break;
          paramInt = localyqu.jdField_a_of_type_Int;
          break label947;
          paramView = this.jdField_a_of_type_JavaLangString;
          break label1029;
        }
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
        break label470;
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#bbbbbb"));
        break label470;
        label1185:
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#fe6387"));
        if (paramView.c > 0)
        {
          ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131705719) + paramView.c + alpo.a(2131705715));
          break label470;
        }
        if (paramView.jdField_b_of_type_Int <= 0) {
          break label470;
        }
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetTextView.setText(alpo.a(2131705718) + paramView.jdField_b_of_type_Int);
        break label470;
        ((yqn)localObject).e.setVisibility(8);
        break label487;
        label1309:
        if (localyqu.jdField_d_of_type_Int < 0)
        {
          paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166158);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setText(localyqu.jdField_d_of_type_JavaLangString);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        }
        for (;;)
        {
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          ((yqn)localObject).jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((yqn)localObject).jdField_a_of_type_AndroidViewView.post(new GridListAdapter.2(this, (yqn)localObject, localyqu, paramInt));
          break;
          paramInt = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166157);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setText(localyqu.jdField_d_of_type_JavaLangString);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
        }
        label1435:
        if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a() == 20) {
          ((yqn)localObject).jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
        }
        for (;;)
        {
          paramView.mPlayGifImage = false;
          paramView.mLoadingDrawable = baul.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          paramView = URLDrawable.getDrawable(localyqu.jdField_c_of_type_JavaLangString, paramView);
          break;
          ((yqn)localObject).jdField_a_of_type_AndroidViewView.setVisibility(4);
          ((yqn)localObject).jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
        }
        label1502:
        ((yqn)localObject).d.setVisibility(8);
        break label639;
        label1515:
        ((yqn)localObject).jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        label1528:
        ((yqn)localObject).d.setVisibility(8);
      }
      ((yqn)localObject).f.setVisibility(8);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yqm
 * JD-Core Version:    0.7.0.1
 */