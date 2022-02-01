package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.androidqqmail.R.styleable;
import com.tencent.qqmail.utilities.ui.QMAvatar;

public class QMAvatarView
  extends View
{
  private QMAvatar avatar;
  private Bitmap avatarBitmap = null;
  private int imageSize;
  
  public QMAvatarView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QMAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QMAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    getImageSize(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void getImageSize(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.QMAvatarView);
    this.imageSize = paramContext.getInt(R.styleable.QMAvatarView_avatar_view_type, 1);
    paramContext.recycle();
  }
  
  private void init(Context paramContext)
  {
    this.avatar = new QMAvatar(this.imageSize);
    storeAvatar();
  }
  
  private void storeAvatar()
  {
    Bitmap localBitmap = this.avatar.getBitmap();
    if ((this.avatarBitmap != null) && (this.avatarBitmap != localBitmap)) {
      this.avatarBitmap.recycle();
    }
    this.avatarBitmap = localBitmap;
  }
  
  public Bitmap generateAvatar(Bitmap paramBitmap, String paramString)
  {
    this.avatar.setAvatar(paramBitmap, paramString);
    return this.avatar.getBitmap();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.avatarBitmap != null) && (!this.avatarBitmap.isRecycled())) {
      paramCanvas.drawBitmap(this.avatarBitmap, 0.0F, 0.0F, null);
    }
  }
  
  public void setAvatar(Bitmap paramBitmap, String paramString)
  {
    this.avatar.setAvatar(paramBitmap, paramString);
    storeAvatar();
    invalidate();
  }
  
  public void setAvatarBitmap(Bitmap paramBitmap)
  {
    this.avatarBitmap = paramBitmap;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMAvatarView
 * JD-Core Version:    0.7.0.1
 */