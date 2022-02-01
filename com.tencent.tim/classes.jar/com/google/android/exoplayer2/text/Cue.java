package com.google.android.exoplayer2.text;

import android.graphics.Bitmap;
import android.text.Layout.Alignment;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Cue
{
  public static final int ANCHOR_TYPE_END = 2;
  public static final int ANCHOR_TYPE_MIDDLE = 1;
  public static final int ANCHOR_TYPE_START = 0;
  public static final float DIMEN_UNSET = 1.4E-45F;
  public static final int LINE_TYPE_FRACTION = 0;
  public static final int LINE_TYPE_NUMBER = 1;
  public static final int TYPE_UNSET = -2147483648;
  public final Bitmap bitmap;
  public final float bitmapHeight;
  public final float line;
  public final int lineAnchor;
  public final int lineType;
  public final float position;
  public final int positionAnchor;
  public final float size;
  public final CharSequence text;
  public final Layout.Alignment textAlignment;
  public final int windowColor;
  public final boolean windowColorSet;
  
  public Cue(Bitmap paramBitmap, float paramFloat1, int paramInt1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4)
  {
    this(null, null, paramBitmap, paramFloat2, 0, paramInt2, paramFloat1, paramInt1, paramFloat3, paramFloat4, false, -16777216);
  }
  
  public Cue(CharSequence paramCharSequence)
  {
    this(paramCharSequence, null, 1.4E-45F, -2147483648, -2147483648, 1.4E-45F, -2147483648, 1.4E-45F);
  }
  
  public Cue(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3)
  {
    this(paramCharSequence, paramAlignment, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, false, -16777216);
  }
  
  public Cue(CharSequence paramCharSequence, Layout.Alignment paramAlignment, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, boolean paramBoolean, int paramInt4)
  {
    this(paramCharSequence, paramAlignment, null, paramFloat1, paramInt1, paramInt2, paramFloat2, paramInt3, paramFloat3, 1.4E-45F, paramBoolean, paramInt4);
  }
  
  private Cue(CharSequence paramCharSequence, Layout.Alignment paramAlignment, Bitmap paramBitmap, float paramFloat1, int paramInt1, int paramInt2, float paramFloat2, int paramInt3, float paramFloat3, float paramFloat4, boolean paramBoolean, int paramInt4)
  {
    this.text = paramCharSequence;
    this.textAlignment = paramAlignment;
    this.bitmap = paramBitmap;
    this.line = paramFloat1;
    this.lineType = paramInt1;
    this.lineAnchor = paramInt2;
    this.position = paramFloat2;
    this.positionAnchor = paramInt3;
    this.size = paramFloat3;
    this.bitmapHeight = paramFloat4;
    this.windowColorSet = paramBoolean;
    this.windowColor = paramInt4;
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface AnchorType {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface LineType {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.text.Cue
 * JD-Core Version:    0.7.0.1
 */