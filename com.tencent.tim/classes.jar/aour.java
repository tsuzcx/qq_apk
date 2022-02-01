import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.troop.activity.ExtendGridView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aour
  extends BaseAdapter
  implements View.OnClickListener
{
  protected List<String> Hl;
  protected boolean JN = true;
  protected CharSequence ay;
  protected CharSequence az;
  protected URLDrawable.URLDrawableOptions b;
  protected ExtendGridView b;
  protected int dRL;
  public Bitmap gr;
  protected Drawable mDefaultDrawable;
  protected LayoutInflater mInflater;
  protected int mMaxCount = 9;
  private HashMap<String, Drawable.ConstantState> oa;
  
  public aour(Context paramContext, ExtendGridView paramExtendGridView)
  {
    this.mInflater = LayoutInflater.from(paramContext);
    this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView = paramExtendGridView;
    this.mDefaultDrawable = paramContext.getResources().getDrawable(2130848704);
    this.ay = BaseApplication.getContext().getText(2131698468);
    this.oa = new HashMap();
    this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mUseMemoryCache = false;
    this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mFailedDrawable = this.mDefaultDrawable;
    this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mLoadingDrawable = this.mDefaultDrawable;
    fn(paramContext);
  }
  
  private void dWY()
  {
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.oa.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((this.Hl != null) && (this.Hl.contains(str))) {
        localHashMap.put(str, this.oa.get(str));
      }
    }
    this.oa.clear();
    this.oa.putAll(localHashMap);
    localHashMap.clear();
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "!!!clearDirtyCache time is " + (System.currentTimeMillis() - l));
    }
  }
  
  public void C(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.JN = paramBoolean1;
    if (paramBoolean2) {
      notifyDataSetChanged();
    }
  }
  
  public int KZ()
  {
    return this.dRL;
  }
  
  public void bF(List<String> paramList)
  {
    this.Hl = paramList;
    dWX();
  }
  
  public boolean bT(int paramInt)
  {
    return (this.JN) && (paramInt == getCount() - 1);
  }
  
  @TargetApi(16)
  public void dWX()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView == null) {
      return;
    }
    int j = getCount();
    int i = j;
    if (j == this.mMaxCount + 1) {
      i = j - 1;
    }
    i = (int)Math.ceil(i / this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.getNumColumns());
    Object localObject = getView(0, null, this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView);
    ((View)localObject).measure(0, 0);
    this.dRL = ((View)localObject).getMeasuredHeight();
    j = this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.getVerticalSpacing();
    int k = this.dRL;
    int m = this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingTop();
    int n = this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.getPaddingBottom();
    localObject = this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i * k + j * (i - 1) + m + n);
    this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  protected void fn(Context paramContext)
  {
    int i = (int)aqho.convertDpToPixel(paramContext, 60.0F);
    int j = (int)aqho.convertDpToPixel(paramContext, 5.0F);
    this.gr = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    paramContext = new Canvas(this.gr);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    RectF localRectF = new RectF(0.0F, 0.0F, i, i);
    localPaint.setAlpha(0);
    paramContext.drawRect(0.0F, 0.0F, i, i, localPaint);
    localPaint.setARGB(255, 255, 255, 255);
    Path localPath = new Path();
    localPath.addRoundRect(localRectF, j, j, Path.Direction.CW);
    localPath.setFillType(Path.FillType.INVERSE_WINDING);
    paramContext.drawPath(localPath, localPaint);
  }
  
  public int getCount()
  {
    int i = 0;
    if (this.Hl != null) {
      i = this.Hl.size();
    }
    int j = i;
    if (this.JN) {
      j = i + 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.Hl == null) || (bT(paramInt))) {
      return null;
    }
    return this.Hl.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (this.Hl != null) {
      return paramInt;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (bT(paramInt)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k = 2147483647;
    long l = System.currentTimeMillis();
    View localView;
    aour.a locala;
    int i;
    if (paramView == null)
    {
      localView = this.mInflater.inflate(2131560118, null);
      locala = new aour.a();
      locala.bQ = ((URLImageView)localView.findViewById(2131381359));
      locala.Ec = ((ImageView)localView.findViewById(2131369033));
      locala.Eb = ((ImageView)localView.findViewById(2131377580));
      localView.setTag(locala);
      i = this.jdField_b_of_type_ComTencentMobileqqTroopActivityExtendGridView.computeItemWidth();
      paramView = localView.getLayoutParams();
      if ((paramView != null) && ((paramView instanceof AbsListView.LayoutParams))) {
        break label260;
      }
      paramView = new AbsListView.LayoutParams(i, i);
      label129:
      localView.setLayoutParams((AbsListView.LayoutParams)paramView);
      if (!bT(paramInt)) {
        break label275;
      }
      locala.bQ.setScaleType(ImageView.ScaleType.FIT_XY);
      locala.bQ.setImageResource(2130843350);
      locala.bQ.setContentDescription(this.ay);
      locala.Ec.setVisibility(8);
    }
    label260:
    label275:
    String str;
    do
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "---getView time is " + (System.currentTimeMillis() - l));
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      locala = (aour.a)paramView.getTag();
      localView = paramView;
      break;
      paramView.width = i;
      paramView.height = i;
      break label129;
      str = (String)getItem(paramInt);
    } while (TextUtils.isEmpty(str));
    int j;
    if (i < 0)
    {
      j = 2147483647;
      label303:
      j = Math.min(100, j);
      if (i >= 0) {
        break label484;
      }
      i = k;
      label321:
      i = Math.min(100, i);
      locala.bQ.setAdjustViewBounds(false);
      paramView = new File(str);
      if (this.oa.size() >= 18) {
        dWY();
      }
      Drawable.ConstantState localConstantState = (Drawable.ConstantState)this.oa.get(str);
      if (((paramInt == 0) && (paramViewGroup.getChildCount() == 0)) || (localConstantState == null)) {
        break label487;
      }
      paramView = localConstantState.newDrawable();
    }
    for (;;)
    {
      paramView.setBounds(0, 0, j, i);
      locala.bQ.setImageDrawable(paramView);
      locala.bQ.setContentDescription(this.az);
      locala.Ec.setVisibility(0);
      locala.Ec.setTag(Integer.valueOf(paramInt));
      locala.Ec.setOnClickListener(this);
      locala.Eb.setImageBitmap(this.gr);
      break;
      j = i;
      break label303;
      label484:
      break label321;
      try
      {
        label487:
        this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestWidth = j;
        this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mRequestHeight = i;
        this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions.mPlayGifImage = true;
        if (paramView.exists()) {}
        for (paramView = URLDrawable.getDrawable(paramView.toURL(), this.jdField_b_of_type_ComTencentImageURLDrawable$URLDrawableOptions);; paramView = this.mDefaultDrawable)
        {
          if (paramView != null) {
            break label558;
          }
          paramView = this.mDefaultDrawable;
          break;
        }
      }
      catch (MalformedURLException paramView)
      {
        for (;;)
        {
          paramView = null;
        }
        label558:
        this.oa.put(str, paramView.getConstantState());
      }
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.JN) {
      return 2;
    }
    return 1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Integer localInteger = (Integer)paramView.getTag();
      Intent localIntent = new Intent("key_photo_delete_action");
      localIntent.putExtra("key_photo_delete_position", localInteger.intValue());
      BaseApplication.getContext().sendBroadcast(localIntent);
    }
  }
  
  public void onDestroy()
  {
    if ((this.gr != null) && (!this.gr.isRecycled())) {
      this.gr.recycle();
    }
  }
  
  static class a
  {
    ImageView Eb;
    ImageView Ec;
    URLImageView bQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aour
 * JD-Core Version:    0.7.0.1
 */