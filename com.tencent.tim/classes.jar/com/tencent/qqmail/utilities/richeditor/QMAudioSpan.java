package com.tencent.qqmail.utilities.richeditor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.util.DisplayMetrics;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.stringextention.StringExtention;

public class QMAudioSpan
  extends DynamicDrawableSpan
{
  private float density = QMApplicationContext.sharedInstance().getResources().getDisplayMetrics().density;
  private int height = 100;
  boolean isPlaying = false;
  private String mClass;
  private Context mContext;
  private String mControls;
  private String mName;
  private String mPreload;
  private String mQmduration;
  private String mShortenName;
  private long mSize;
  private String mSizeString;
  private String mSource;
  private int width = 400;
  
  public QMAudioSpan(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    this(paramString1, paramLong, paramString2, paramInt, 0);
  }
  
  public QMAudioSpan(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    this.mSource = paramString2;
    this.mName = paramString1;
    this.mContext = QMApplicationContext.sharedInstance();
    this.mSize = paramLong;
    this.isPlaying = false;
    this.width = paramInt1;
    this.height = BitmapFactory.decodeResource(this.mContext.getResources(), 2130842228).getHeight();
    this.mShortenName = paramString1;
    this.mSizeString = StringExtention.getHumanReadableSizeString(paramLong);
    this.mClass = "ios-upload-audio";
    this.mControls = "true";
    this.mPreload = "metadata";
    this.mQmduration = "0";
  }
  
  public QMAudioSpan(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, paramString3, paramInt, 0);
  }
  
  public QMAudioSpan(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    super(paramInt2);
    this.mSource = paramString3;
    this.mName = paramString1;
    this.mContext = QMApplicationContext.sharedInstance();
    this.mSizeString = paramString2;
    this.mSize = StringExtention.sizeStrToLong(paramString2);
    this.isPlaying = false;
    this.width = paramInt1;
    this.height = BitmapFactory.decodeResource(this.mContext.getResources(), 2130842228).getHeight();
    this.mShortenName = paramString1;
  }
  
  public static String calculateFileName(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 20) {
      str = paramString.substring(0, 20) + "...";
    }
    return str;
  }
  
  public String getClassString()
  {
    return this.mClass;
  }
  
  public String getControls()
  {
    return this.mControls;
  }
  
  public Drawable getDrawable()
  {
    AudioDrawable localAudioDrawable = new AudioDrawable(this.mShortenName);
    localAudioDrawable.setBounds(0, 0, this.width, (int)(this.height + 12.0F * this.density));
    return localAudioDrawable;
  }
  
  public int getHeigh()
  {
    return this.height;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public boolean getPlayState()
  {
    return this.isPlaying;
  }
  
  public String getPreload()
  {
    return this.mPreload;
  }
  
  public String getQmduration()
  {
    return this.mQmduration;
  }
  
  public long getSize()
  {
    return this.mSize;
  }
  
  public String getSizeString()
  {
    return this.mSizeString;
  }
  
  public String getSource()
  {
    return this.mSource;
  }
  
  public void setClassString(String paramString)
  {
    this.mClass = paramString;
  }
  
  public void setControls(String paramString)
  {
    this.mControls = paramString;
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.isPlaying = paramBoolean;
  }
  
  public void setPreload(String paramString)
  {
    this.mPreload = paramString;
  }
  
  public void setQmduration(String paramString)
  {
    this.mQmduration = paramString;
  }
  
  class AudioDrawable
    extends Drawable
  {
    private int mHeight;
    private final Paint paint;
    private final String text;
    
    public AudioDrawable(String paramString)
    {
      this.text = paramString;
      this.paint = new Paint();
      this.paint.setTextSize(22.0F);
      this.paint.setAntiAlias(true);
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setTextAlign(Paint.Align.LEFT);
      this.paint.setColor(-16777216);
    }
    
    private void drawBackGround(Canvas paramCanvas)
    {
      Object localObject;
      Bitmap localBitmap2;
      if (QMAudioSpan.this.isPlaying)
      {
        localObject = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842230);
        localBitmap2 = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842228);
      }
      for (Bitmap localBitmap1 = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842232);; localBitmap1 = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842231))
      {
        this.mHeight = localBitmap2.getHeight();
        paramCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
        int i = ((Bitmap)localObject).getWidth();
        localObject = new Rect();
        Rect localRect = new Rect();
        ((Rect)localObject).left = 0;
        ((Rect)localObject).top = 0;
        ((Rect)localObject).right = localBitmap2.getWidth();
        ((Rect)localObject).bottom = localBitmap2.getHeight();
        localRect.left = i;
        localRect.top = 0;
        localRect.right = (QMAudioSpan.this.width - i);
        localRect.bottom = localBitmap2.getHeight();
        paramCanvas.drawBitmap(localBitmap2, (Rect)localObject, localRect, null);
        paramCanvas.drawBitmap(localBitmap1, QMAudioSpan.this.width - i, 0.0F, this.paint);
        return;
        localObject = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842229);
        localBitmap2 = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130842227);
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      drawBackGround(paramCanvas);
      int i = (int)(this.mHeight * 0.2D);
      int j = (int)(this.mHeight * 0.26D);
      int k = (int)(this.mHeight * 0.43D);
      int m = this.mHeight;
      int n = (int)(this.mHeight * 0.74D);
      int i1 = this.mHeight;
      Bitmap localBitmap;
      if (QMAudioSpan.this.mContext != null)
      {
        if (QMAudioSpan.this.isPlaying)
        {
          localBitmap = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130841041);
          paramCanvas.drawBitmap(localBitmap, j, i, this.paint);
        }
      }
      else
      {
        this.paint.setTextSize(15.0F * QMAudioSpan.this.density);
        this.paint.setFakeBoldText(true);
        if (!QMAudioSpan.this.isPlaying) {
          break label252;
        }
        this.paint.setColor(-4671304);
      }
      for (;;)
      {
        paramCanvas.drawText(this.text, m, k, this.paint);
        this.paint.setTextSize(13.0F * QMAudioSpan.this.density);
        this.paint.setFakeBoldText(false);
        this.paint.setColor(-4671304);
        paramCanvas.drawText(QMAudioSpan.this.mSizeString, i1, n, this.paint);
        return;
        localBitmap = BitmapFactory.decodeResource(QMAudioSpan.this.mContext.getResources(), 2130841040);
        break;
        label252:
        this.paint.setColor(-16777216);
      }
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public void setAlpha(int paramInt)
    {
      this.paint.setAlpha(paramInt);
    }
    
    public void setColorFilter(ColorFilter paramColorFilter)
    {
      this.paint.setColorFilter(paramColorFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMAudioSpan
 * JD-Core Version:    0.7.0.1
 */