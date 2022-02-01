package com.tencent.mobileqq.emoticonview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import foa;
import fob;
import foc;
import java.util.List;

public class EmoticonGridViewAdapter
  extends BaseAdapter
{
  private static Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new foa(this);
  public View.OnLongClickListener a;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new foc(this);
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private GridView jdField_a_of_type_AndroidWidgetGridView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  private List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private FrameLayout jdField_b_of_type_AndroidWidgetFrameLayout;
  private int c;
  private int d = 6;
  
  public EmoticonGridViewAdapter(GridView paramGridView, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new fob(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_Int = ((int)(46.0F * this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Int = ((int)(82.0F * this.jdField_a_of_type_Float));
    this.jdField_a_of_type_AndroidWidgetGridView = paramGridView;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  private int a()
  {
    int i = (((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).getDefaultDisplay().getWidth() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingLeft() - this.jdField_a_of_type_AndroidWidgetGridView.getPaddingRight()) / this.jdField_a_of_type_Int;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  private void a(View paramView)
  {
    paramView = (EmoticonInfo)paramView.getTag();
    if ((paramView != null) && (!"delete".equals(paramView.a)) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramView);
    }
  }
  
  private void a(View paramView, EmoticonInfo paramEmoticonInfo)
  {
    Drawable localDrawable = paramEmoticonInfo.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
    if (localDrawable == null) {
      return;
    }
    paramView.getGlobalVisibleRect(jdField_a_of_type_AndroidGraphicsRect);
    int i = paramEmoticonInfo.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_AndroidWidgetFrameLayout == null)
    {
      this.jdField_b_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetImageView.setAdjustViewBounds(false);
      this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_b_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (localDrawable != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    }
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    int k = (int)(5.0F * f);
    paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    int j;
    if ((1 == i) || (2 == i) || (7 == i))
    {
      j = (int)(64.0F * f);
      i = (int)(71.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837635);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.width = ((int)(28.0F * f));
      paramView.height = ((int)(28.0F * f));
      paramView.bottomMargin = ((int)(6.0F * f));
      paramView.gravity = 17;
      label262:
      paramView = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      paramView.gravity = 51;
      paramView.leftMargin = (jdField_a_of_type_AndroidGraphicsRect.left - (j - jdField_a_of_type_AndroidGraphicsRect.width()) / 2);
      paramView.topMargin = (jdField_a_of_type_AndroidGraphicsRect.top - i - (int)(f * 15.0F));
      paramView.width = j;
      paramView.height = i;
      if (!this.jdField_a_of_type_Boolean) {
        break label580;
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.requestLayout();
    }
    for (;;)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
      if ((paramView != null) && (paramView.jdField_b_of_type_Int == 6) && ((paramView instanceof PicEmoticonInfo)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      }
      if ((paramEmoticonInfo.jdField_b_of_type_Int == 6) && ((paramEmoticonInfo instanceof PicEmoticonInfo)) && ((localDrawable instanceof URLDrawable)))
      {
        localObject = (PicEmoticonInfo)paramEmoticonInfo;
        if (((PicEmoticonInfo)localObject).a())
        {
          localObject = EmosmUtils.getEmoticonSoundPath(((PicEmoticonInfo)localObject).a.epId, ((PicEmoticonInfo)localObject).a.eId);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(this.jdField_a_of_type_AndroidContentContext, null);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a((String)localObject);
          PicEmoticonInfo.a((URLDrawable)localDrawable);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.a(paramView, paramEmoticonInfo, localDrawable);
      return;
      j = (int)(110.0F * f);
      i = (int)(110.0F * f);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130837634);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setPadding(k, k, k, k);
      paramView.bottomMargin = 0;
      paramView.width = ((int)(100.0F * f));
      paramView.height = ((int)(100.0F * f));
      break label262;
      label580:
      paramView = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      Object localObject = new WindowManager.LayoutParams(-1, -1, 2, 24, -3);
      paramView.addView(this.jdField_b_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  @SuppressLint({"NewApi"})
  private int b()
  {
    return this.jdField_a_of_type_AndroidWidgetGridView.getNumColumns();
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidWidgetFrameLayout != null) && (this.jdField_a_of_type_Boolean))
    {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeViewImmediate(this.jdField_b_of_type_AndroidWidgetFrameLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo);
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.d = paramInt;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    int i = a();
    if ((this.d == 2011) || (this.d == 2007)) {
      if (paramInt < i) {
        paramViewGroup = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    for (;;)
    {
      EmoticonGridViewAdapter.ViewHolder localViewHolder;
      label110:
      Object localObject;
      if (paramView == null)
      {
        localViewHolder = new EmoticonGridViewAdapter.ViewHolder(this);
        paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903211, null);
        localViewHolder.a = ((URLImageView)paramView.findViewById(2131231628));
        paramView.setTag(localViewHolder);
        localViewHolder.a.setTag(paramViewGroup);
        if (paramViewGroup == null) {
          break label653;
        }
        if (this.d != 2009) {
          break label469;
        }
        this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
        if ((paramViewGroup.jdField_b_of_type_Int != 1) && (paramViewGroup.jdField_b_of_type_Int != 2) && (paramViewGroup.jdField_b_of_type_Int != 7)) {
          break label420;
        }
        localObject = new AbsListView.LayoutParams(-2, -2);
        ((AbsListView.LayoutParams)localObject).width = this.jdField_b_of_type_Int;
        ((AbsListView.LayoutParams)localObject).height = this.jdField_b_of_type_Int;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        int j = (int)(16.5D * this.jdField_a_of_type_Float);
        ((RelativeLayout.LayoutParams)localObject).setMargins(j, j, j, j);
        localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
        label258:
        if (paramViewGroup.jdField_b_of_type_Int == -1) {
          break label641;
        }
        localObject = paramViewGroup.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Float);
        if (localObject == null) {
          break label629;
        }
        localViewHolder.a.setVisibility(0);
        if (((paramViewGroup.jdField_b_of_type_Int != 7) && (this.d != 2011)) || (paramInt != i - 1)) {
          break label616;
        }
        localViewHolder.a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837980));
        localViewHolder.a.setTag(null);
      }
      for (;;)
      {
        localViewHolder.a.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        localViewHolder.a.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localViewHolder.a.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        return paramView;
        paramViewGroup = (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt - 1);
        break;
        localViewHolder = (EmoticonGridViewAdapter.ViewHolder)paramView.getTag();
        break label110;
        label420:
        if (paramViewGroup.jdField_b_of_type_Int != 5) {
          break label258;
        }
        localObject = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
        break label258;
        label469:
        if (this.d == 2006)
        {
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
          break label258;
        }
        if ((this.d == 2007) || (this.d == 2011))
        {
          localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
          localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
          this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_a_of_type_Int);
          break label258;
        }
        if (this.d != 2010) {
          break label258;
        }
        this.jdField_a_of_type_AndroidWidgetGridView.setColumnWidth(this.jdField_b_of_type_Int);
        localObject = new RelativeLayout.LayoutParams(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int);
        localViewHolder.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localViewHolder.a.setScaleType(ImageView.ScaleType.FIT_XY);
        break label258;
        label616:
        localViewHolder.a.setImageDrawable((Drawable)localObject);
        continue;
        label629:
        localViewHolder.a.setVisibility(4);
        continue;
        label641:
        localViewHolder.a.setImageDrawable(null);
        continue;
        label653:
        localViewHolder.a.setImageDrawable(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonGridViewAdapter
 * JD-Core Version:    0.7.0.1
 */