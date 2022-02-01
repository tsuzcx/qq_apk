package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import awii;

public class RedTouchExtendButton
  extends ExtendButton
{
  private RedInfo b;
  private int bHY = 100;
  private String bPN = "";
  private int dxq = iJ(24);
  private int dxr = iJ(10);
  private int dxs = iJ(10);
  public Drawable fs;
  public String imgUrl = "";
  private Rect mTextBounds = new Rect();
  private Handler mUiHandler;
  
  public RedTouchExtendButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RedTouchExtendButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int Qc()
  {
    return getHeight();
  }
  
  private int Qd()
  {
    int i = getStartX();
    return getWidth() - i - iJ(0);
  }
  
  private boolean a(RedInfo paramRedInfo)
  {
    if (paramRedInfo == null) {}
    do
    {
      do
      {
        return false;
      } while (!paramRedInfo.isNew);
      a(a(), paramRedInfo);
      if (paramRedInfo.bHY == 3)
      {
        if (aMw())
        {
          this.dxs = this.dxq;
          this.imgUrl = paramRedInfo.resUrl;
          this.bHY = 3;
          return true;
        }
        if (aMx())
        {
          this.dxs = this.dxr;
          this.bHY = 0;
          return true;
        }
        this.dxs = 0;
        this.bHY = 100;
        return false;
      }
      if (paramRedInfo.bHY == 4)
      {
        this.bPN = paramRedInfo.bPN;
        if (tY(this.bPN))
        {
          paramRedInfo = new TextPaint();
          paramRedInfo.setTextSize(iJ(11));
          int i = (int)paramRedInfo.measureText(this.bPN);
          paramRedInfo = paramRedInfo.getFontMetrics();
          this.dxs = Math.max(i, (int)(paramRedInfo.bottom - paramRedInfo.top));
          this.bHY = 4;
          return true;
        }
        if (aMx())
        {
          this.dxs = this.dxr;
          this.bHY = 0;
          return true;
        }
        this.dxs = 0;
        this.bHY = 100;
        return false;
      }
    } while (paramRedInfo.bHY != 0);
    if (aMx())
    {
      this.dxs = this.dxr;
      this.bHY = 0;
      return true;
    }
    this.dxs = 0;
    this.bHY = 100;
    return false;
  }
  
  private boolean a(RedInfo paramRedInfo1, RedInfo paramRedInfo2)
  {
    return equals(paramRedInfo1, paramRedInfo2);
  }
  
  private boolean aMw()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Qc() >= this.dxq)
    {
      bool1 = bool2;
      if (Qd() >= this.dxq + iJ(2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean aMx()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Qc() >= this.dxr)
    {
      bool1 = bool2;
      if (Qd() + iJ(2) >= this.dxr) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void bT(Canvas paramCanvas)
  {
    if (a(this.b)) {}
    try
    {
      int j = getStartY() - iJ(4);
      int i = getStartX() - iJ(2);
      if (this.bHY == 0)
      {
        this.fs = getResources().getDrawable(2130851400);
        this.fs.setBounds(i, j, this.dxs + i, this.dxs + j);
        this.fs.draw(paramCanvas);
      }
      Object localObject1;
      if (this.bHY == 4)
      {
        localObject1 = this.b.bPN;
        Paint localPaint = new Paint(1);
        localPaint.setTextSize(iJ(11));
        localPaint.setTextAlign(Paint.Align.CENTER);
        Object localObject2 = localPaint.getFontMetrics();
        j = iJ(2) + i;
        int k = getHeight() / 2 - (this.dxs + iJ(0) * 2) / 2;
        Rect localRect = new Rect();
        localRect.left = j;
        localRect.top = k;
        int m = this.dxs + iJ(0) * 2;
        localRect.bottom = (k + m);
        localRect.right = (m + j);
        float f1 = iJ(0) + k;
        float f2 = ((Paint.FontMetrics)localObject2).top;
        localObject2 = getResources().getDrawable(2130851400);
        ((Drawable)localObject2).getBounds();
        ((Drawable)localObject2).setBounds(j, k, localRect.right, localRect.bottom);
        ((Drawable)localObject2).draw(paramCanvas);
        localPaint.setColor(-1);
        paramCanvas.drawText((String)localObject1, localRect.left + localRect.width() / 2, f1 - f2, localPaint);
      }
      if (this.bHY == 3)
      {
        localObject1 = getResources().getDrawable(2130849360);
        i += iJ(2);
        j = getHeight() / 2 - ((Drawable)localObject1).getIntrinsicHeight() / 2;
        ((Drawable)localObject1).setBounds(i, j, ((Drawable)localObject1).getIntrinsicWidth() + i, ((Drawable)localObject1).getIntrinsicHeight() + j);
        ((Drawable)localObject1).draw(paramCanvas);
      }
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  private boolean equals(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) && (paramObject2 == null)) {}
    while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
      return true;
    }
    return false;
  }
  
  private int getStartX()
  {
    return (int)getLayout().getLineRight(0);
  }
  
  private int getStartY()
  {
    Rect localRect = new Rect();
    getLineBounds(0, localRect);
    int i = localRect.top;
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  private boolean tY(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return false;
      TextPaint localTextPaint = new TextPaint();
      localTextPaint.setTextSize(iJ(11));
      i = (int)localTextPaint.measureText(paramString);
      paramString = localTextPaint.getFontMetrics();
      i = Math.max(i, (int)(paramString.bottom - paramString.top));
    } while (Qd() < i + iJ(0) * 2 + iJ(2));
    return true;
  }
  
  public RedInfo a()
  {
    return this.b;
  }
  
  public void dJJ()
  {
    if (this.mUiHandler == null) {
      this.mUiHandler = new Handler(Looper.getMainLooper());
    }
    this.mUiHandler.post(new RedTouchExtendButton.1(this));
  }
  
  protected int iJ(int paramInt)
  {
    Resources localResources = getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    this.fs = paramDrawable;
    dJJ();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    bT(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setAppInfo(RedInfo paramRedInfo)
  {
    this.b = paramRedInfo;
    invalidate();
  }
  
  public static class RedInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<RedInfo> CREATOR = new awii();
    public int bHY;
    public String bPN;
    public String desc;
    public boolean isNew;
    public int resId;
    public String resUrl;
    
    public RedInfo() {}
    
    public RedInfo(Parcel paramParcel)
    {
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.isNew = bool;
        this.bHY = paramParcel.readInt();
        this.resId = paramParcel.readInt();
        this.bPN = paramParcel.readString();
        this.resUrl = paramParcel.readString();
        this.desc = paramParcel.readString();
        return;
        bool = false;
      }
    }
    
    private boolean equals(Object paramObject1, Object paramObject2)
    {
      if ((paramObject1 == null) && (paramObject2 == null)) {}
      while ((paramObject1 != null) && (paramObject1.equals(paramObject2))) {
        return true;
      }
      return false;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof RedInfo));
        paramObject = (RedInfo)paramObject;
      } while ((!equals(Boolean.valueOf(paramObject.isNew), Boolean.valueOf(this.isNew))) || (!equals(paramObject.bPN, this.bPN)) || (!equals(Integer.valueOf(paramObject.bHY), Integer.valueOf(this.bHY))) || (!equals(paramObject.resUrl, this.resUrl)) || (!equals(paramObject.desc, this.desc)) || (!equals(Integer.valueOf(paramObject.resId), Integer.valueOf(this.resId))));
      return true;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      if (this.isNew) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeInt(this.bHY);
        paramParcel.writeInt(this.resId);
        paramParcel.writeString(this.bPN);
        paramParcel.writeString(this.resUrl);
        paramParcel.writeString(this.desc);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.widget.RedTouchExtendButton
 * JD-Core Version:    0.7.0.1
 */