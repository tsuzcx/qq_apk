package com.tencent.qqmail.card.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class AvatarListView
  extends ViewGroup
  implements Recyclable
{
  private static final String TAG = "AvatarListView";
  private int mAvatarBorderColor;
  private int mAvatarBorderWidth;
  private int mAvatarGap;
  private QMAvatar mAvatarTool;
  private int mAvatarWidth;
  private Context mContext;
  private List<Drawable> mDrawableList = Lists.newArrayList();
  private ArrayDeque<CircularDrawable> mDrawablePool = new ArrayDeque();
  
  public AvatarListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AvatarListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AvatarListView, paramInt, 0);
    try
    {
      paramInt = paramContext.getInt(R.styleable.AvatarListView_avatar_size_type, 1);
      this.mAvatarTool = new QMAvatar(paramInt);
      this.mAvatarWidth = QMAvatar.getIconSize(paramInt);
      paramInt = (int)getResources().getDimension(2131296640);
      this.mAvatarGap = paramContext.getDimensionPixelOffset(R.styleable.AvatarListView_avatar_gap, paramInt);
      paramInt = (int)getResources().getDimension(2131296641);
      this.mAvatarBorderWidth = paramContext.getDimensionPixelOffset(R.styleable.AvatarListView_avatar_border_width, paramInt);
      paramInt = getContext().getResources().getColor(2131165367);
      this.mAvatarBorderColor = paramContext.getColor(R.styleable.AvatarListView_avatar_border_color, paramInt);
      paramContext.recycle();
      setWillNotDraw(false);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private CircularDrawable createCircularDrawable(Bitmap paramBitmap)
  {
    return new CircularDrawable(paramBitmap, this.mAvatarBorderWidth, this.mAvatarBorderColor);
  }
  
  private CircularDrawable getCircularDrawable(Bitmap paramBitmap)
  {
    if (this.mDrawablePool.isEmpty()) {
      return createCircularDrawable(paramBitmap);
    }
    CircularDrawable localCircularDrawable = (CircularDrawable)this.mDrawablePool.pop();
    localCircularDrawable.setBitmap(paramBitmap);
    return localCircularDrawable;
  }
  
  private int getHeightMeasureSpec(int paramInt)
  {
    switch (View.MeasureSpec.getMode(paramInt))
    {
    case 0: 
    case 1073741824: 
    default: 
      return paramInt;
    }
    return View.MeasureSpec.makeMeasureSpec(getPaddingTop() + getPaddingBottom() + this.mAvatarWidth, 1073741824);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getWidth();
    int i = getHeight();
    int k = this.mDrawableList.size();
    if ((j <= 0) || (i <= 0) || (k <= 0)) {}
    for (;;)
    {
      return;
      j = (j - (this.mAvatarWidth + this.mAvatarGap) * k + this.mAvatarGap) / 2;
      int m = (i - this.mAvatarWidth) / 2;
      i = 0;
      while (i < k)
      {
        Drawable localDrawable = (Drawable)this.mDrawableList.get(i);
        localDrawable.setBounds(j, m, this.mAvatarWidth + j, this.mAvatarWidth + m);
        localDrawable.draw(paramCanvas);
        j += this.mAvatarWidth + this.mAvatarGap;
        i += 1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, getHeightMeasureSpec(paramInt2));
  }
  
  public void recycle()
  {
    if (this.mDrawableList.isEmpty()) {
      return;
    }
    Iterator localIterator = this.mDrawableList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Drawable)localIterator.next();
      if ((localObject instanceof CircularDrawable))
      {
        localObject = (CircularDrawable)localObject;
        ((CircularDrawable)localObject).recycle();
        this.mDrawablePool.add(localObject);
      }
    }
    this.mDrawableList.clear();
  }
  
  public void setAvatars(List<MailContact> paramList, int paramInt)
  {
    recycle();
    if (paramList == null) {}
    int i;
    do
    {
      return;
      i = Math.min(paramInt, paramList.size());
    } while (i <= 0);
    paramInt = 0;
    while (paramInt < i)
    {
      MailContact localMailContact = (MailContact)paramList.get(paramInt);
      CircularDrawable localCircularDrawable = getCircularDrawable(null);
      this.mDrawableList.add(localCircularDrawable);
      String str2 = localMailContact.getName();
      String str1 = str2;
      if (Strings.isNullOrEmpty(str2)) {
        str1 = this.mContext.getString(2131692061);
      }
      localCircularDrawable.setBitmap(ListViewHelper.generateAvatar(this.mAvatarTool, QMPrivateProtocolManager.getPhotoBitmapByEmail(localMailContact.getAddress(), 3), str1));
      paramInt += 1;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.AvatarListView
 * JD-Core Version:    0.7.0.1
 */