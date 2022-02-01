package com.tencent.qqmail.card.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class CollapsingAvatarsView
  extends FrameLayout
{
  private static final int MAX_COLLAPSING = 2;
  private static Map<String, Bitmap> mDrawableBitmap = Collections.synchronizedMap(new WeakHashMap());
  private int mAvatarSize;
  private int mAvatarSpacing = QMUIKit.dpToPx(7);
  private QMAvatar mAvatarTool;
  private int mCollapsingAvatarWidth;
  private int mCollapsingSpacing = QMUIKit.dpToPx(2);
  
  public CollapsingAvatarsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CollapsingAvatarsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CollapsingAvatarsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CollapsingAvatarsView, paramInt, 0);
    paramInt = paramContext.getInt(R.styleable.CollapsingAvatarsView_avatar_type, 1);
    this.mAvatarTool = new QMAvatar(paramInt);
    updateAvatarAndCollapsingAvatarSize(paramInt);
    paramContext.recycle();
  }
  
  private void addAndLocateAvatars(ArrayList<String> paramArrayList, float paramFloat)
  {
    int m = paramArrayList.size();
    int i = Math.min((int)((this.mAvatarSpacing + paramFloat) / (this.mAvatarSize + this.mAvatarSpacing)), m);
    int j = 0;
    int k = 0;
    while ((i + k < m) && (k < 2) && (j < paramFloat))
    {
      k += 1;
      j = (this.mCollapsingAvatarWidth + this.mCollapsingSpacing) * k;
      i = (int)((paramFloat - j + this.mAvatarSpacing) / (this.mAvatarSize + this.mAvatarSpacing));
    }
    m = 0;
    j = 0;
    while (m < i)
    {
      renderAvatar(getAvatarView(m, (this.mAvatarSize + this.mAvatarSpacing) * m), paramArrayList, m);
      m += 1;
      j += 1;
    }
    int n = i;
    m = j;
    j = n;
    if (j < i + k)
    {
      if (i == 0) {}
      for (n = (j - i) * (this.mCollapsingSpacing + this.mCollapsingAvatarWidth) + 0;; n = (i - 1) * (this.mAvatarSize + this.mAvatarSpacing) - this.mCollapsingSpacing + (j - i) * (this.mCollapsingSpacing + this.mCollapsingAvatarWidth))
      {
        getMaskView(m, n);
        m += 1;
        renderAvatar(getAvatarView(m, n + this.mCollapsingSpacing * 2 + this.mCollapsingAvatarWidth), paramArrayList, j);
        m += 1;
        j += 1;
        break;
      }
    }
    i = getChildCount();
    if (m < i) {
      removeViews(0, i - m);
    }
  }
  
  public static Bitmap generateAvatar(QMAvatar paramQMAvatar, Bitmap paramBitmap, String paramString)
  {
    Object localObject;
    if (paramBitmap == null) {
      localObject = paramQMAvatar.setAvatar(null, paramString);
    }
    String str;
    Bitmap localBitmap;
    do
    {
      return localObject;
      str = String.valueOf(paramBitmap.hashCode()) + paramQMAvatar.getSizeStringHash();
      localBitmap = (Bitmap)mDrawableBitmap.get(str);
      localObject = localBitmap;
    } while (localBitmap != null);
    paramQMAvatar = paramQMAvatar.setAvatar(paramBitmap, paramString);
    mDrawableBitmap.put(str, paramQMAvatar);
    return paramQMAvatar;
  }
  
  private CircularImageView generateCircularImageView(int paramInt)
  {
    CircularImageView localCircularImageView = new CircularImageView(getContext());
    localCircularImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mAvatarSize, this.mAvatarSize, 16);
    localLayoutParams.leftMargin = paramInt;
    localCircularImageView.setLayoutParams(localLayoutParams);
    return localCircularImageView;
  }
  
  private View generateMaskView(int paramInt)
  {
    View localView = new View(getContext());
    localView.setBackgroundResource(2130838774);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mAvatarSize + this.mCollapsingSpacing * 2, this.mAvatarSize + this.mCollapsingSpacing * 2, 16);
    localLayoutParams.leftMargin = paramInt;
    localView.setLayoutParams(localLayoutParams);
    return localView;
  }
  
  private CircularImageView getAvatarView(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (paramInt1 < i)
    {
      paramInt1 = i - paramInt1 - 1;
      localObject = getChildAt(paramInt1);
      if (!(localObject instanceof CircularImageView)) {}
    }
    for (Object localObject = (CircularImageView)localObject; localObject == null; localObject = null)
    {
      localObject = generateCircularImageView(paramInt2);
      addView((View)localObject, 0);
      return localObject;
      removeViews(0, paramInt1 + 1);
    }
    ((CircularImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.mAvatarSize, this.mAvatarSize, 16);
    localLayoutParams.leftMargin = paramInt2;
    ((CircularImageView)localObject).setLayoutParams(localLayoutParams);
    return localObject;
  }
  
  private View getMaskView(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    FrameLayout.LayoutParams localLayoutParams = null;
    Object localObject = localLayoutParams;
    if (paramInt1 < i)
    {
      paramInt1 = i - paramInt1 - 1;
      localObject = getChildAt(paramInt1);
      if (!(localObject instanceof ImageView)) {
        break label72;
      }
      removeViews(0, paramInt1 + 1);
      localObject = localLayoutParams;
    }
    label72:
    while (localObject == null)
    {
      localObject = generateMaskView(paramInt2);
      addView((View)localObject, 0);
      return localObject;
    }
    localLayoutParams = new FrameLayout.LayoutParams(this.mAvatarSize + this.mCollapsingSpacing * 2, this.mAvatarSize + this.mCollapsingSpacing * 2, 16);
    localLayoutParams.leftMargin = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    return localObject;
  }
  
  private void renderAvatar(CircularImageView paramCircularImageView, ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramInt > paramArrayList.size()) {}
    do
    {
      return;
      paramArrayList = (String)paramArrayList.get(paramInt);
    } while (StringExtention.isNullOrEmpty(paramArrayList));
    Object localObject = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(paramArrayList);
    if (localObject != null)
    {
      paramCircularImageView.setImageBitmap((Bitmap)localObject);
      return;
    }
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).setUrl(paramArrayList);
    ((DownloadInfo)localObject).setImageDownloadListener(new CollapsingAvatarsView.1(this, paramArrayList, paramCircularImageView));
    ImageDownloadManager.shareInstance().fetchImage((DownloadInfo)localObject);
  }
  
  private void updateAvatarAndCollapsingAvatarSize(int paramInt)
  {
    this.mAvatarSize = QMUIKit.dpToPx(QMAvatar.getIconSize(paramInt));
    this.mCollapsingAvatarWidth = (this.mAvatarSize / 2 - this.mCollapsingSpacing);
  }
  
  public void setAvatarType(int paramInt)
  {
    updateAvatarAndCollapsingAvatarSize(paramInt);
  }
  
  public void setAvatars(ArrayList<String> paramArrayList, float paramFloat)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return;
    }
    addAndLocateAvatars(paramArrayList, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.CollapsingAvatarsView
 * JD-Core Version:    0.7.0.1
 */