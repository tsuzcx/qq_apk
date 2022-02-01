package com.tencent.qqmail.utilities.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.utilities.QMMath;
import com.tencent.qqmail.utilities.draw.DrawIcon;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;

public class QMAvatar
{
  public static final int TYPE_CARD = 6;
  public static final int TYPE_EXTRA_LARGE = 4;
  public static final int TYPE_LARGE = 2;
  public static final int TYPE_MIDDLE = 1;
  public static final int TYPE_PHONEBOOK = 5;
  public static final int TYPE_SMALL = 0;
  public static final int TYPE_SQUARE = 3;
  private int avatarType;
  private int avatarWidth;
  private Bitmap bitmapMask;
  private Rect centerArea;
  private int imageID = 2130838764;
  private boolean isTextAvatar = false;
  private int maskID;
  private int offset;
  private Bitmap userAvatar;
  
  public QMAvatar()
  {
    this(1);
  }
  
  public QMAvatar(int paramInt)
  {
    init(paramInt, null);
  }
  
  public QMAvatar(int paramInt, Bitmap paramBitmap)
  {
    init(paramInt, paramBitmap);
  }
  
  public QMAvatar(int paramInt, String paramString)
  {
    init(paramInt, drawTextAvatar(paramString, paramInt));
    if (this.userAvatar == null) {
      this.isTextAvatar = false;
    }
    while (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    this.isTextAvatar = true;
  }
  
  private Bitmap drawTextAvatar(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return null;
      paramString = DrawIcon.getDrawString(paramString);
    } while ((paramString == null) || ("".equals(paramString)));
    String str = String.valueOf(QMMath.hashPositivetInt(paramString));
    File localFile = new File(FileUtil.getNickIconDirPath() + File.separator + str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = FileUtil.getNickIconDirPath() + File.separator + str + File.separator + getIconSizeString(paramInt);
    if (new File(str).exists()) {
      try
      {
        paramString = ImageDownloadManager.shareInstance().getAvatarBitmapFromDisk(str);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    if (paramInt == 3) {
      return DrawIcon.drawRoundRectIcon(getIconSize(paramInt), QMUIKit.DENSITY, str, paramString);
    }
    return DrawIcon.drawCircleIcon(getIconSize(paramInt), QMUIKit.DENSITY, str, paramString);
  }
  
  public static int getIconSize(int paramInt)
  {
    int i = 30;
    switch (paramInt)
    {
    case 1: 
    default: 
      i = 40;
    case 0: 
    case 3: 
      return i;
    case 2: 
      return 68;
    case 4: 
      return 96;
    case 5: 
      return 120;
    }
    return 24;
  }
  
  public static String getIconSizeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "TYPE_SMALL";
    case 1: 
      return "TYPE_MIDDLE";
    case 2: 
      return "TYPE_LARGE";
    case 3: 
      return "TYPE_SQUARE";
    case 4: 
      return "TYPE_EXTRA_LARGE";
    case 5: 
      return "TYPE_PHONEBOOK";
    }
    return "TYPE_CARD";
  }
  
  private void init(int paramInt, Bitmap paramBitmap)
  {
    this.avatarType = paramInt;
    this.userAvatar = paramBitmap;
    paramBitmap = QMApplicationContext.sharedInstance();
    switch (this.avatarType)
    {
    case 1: 
    case 4: 
    default: 
      this.imageID = 2130838764;
      this.maskID = 2130838769;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
    }
    for (;;)
    {
      this.avatarWidth = ((int)(this.avatarWidth * QMUIKit.DENSITY + 0.5D));
      this.centerArea = new Rect(this.offset, this.offset, this.avatarWidth + this.offset, this.avatarWidth + this.offset);
      paramBitmap = (BitmapDrawable)paramBitmap.getResources().getDrawable(this.maskID);
      if (paramBitmap != null) {
        this.bitmapMask = paramBitmap.getBitmap();
      }
      if (this.userAvatar != null)
      {
        if (this.avatarType == 3) {
          break;
        }
        this.userAvatar = roundImage(this.userAvatar);
      }
      return;
      this.imageID = 2130838767;
      this.maskID = 2130838770;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
      continue;
      this.imageID = 2130838763;
      this.maskID = 2130838768;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
      continue;
      this.imageID = 2130838763;
      this.maskID = 2130838771;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
      continue;
      this.imageID = 2130838773;
      this.maskID = 2130838771;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
      continue;
      this.imageID = 2130838764;
      this.maskID = 2130838769;
      this.avatarWidth = getIconSize(this.avatarType);
      this.offset = 0;
    }
    this.userAvatar = roundSquareImage(this.userAvatar);
  }
  
  private Bitmap roundImage(Bitmap paramBitmap)
  {
    Rect localRect = new Rect(0, 0, this.avatarWidth, this.avatarWidth);
    Bitmap localBitmap = Bitmap.createBitmap(this.avatarWidth, this.avatarWidth, Bitmap.Config.ARGB_8888);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawCircle(this.avatarWidth / 2, this.avatarWidth / 2, this.avatarWidth / 2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
    return localBitmap;
  }
  
  private Bitmap roundSquareImage(Bitmap paramBitmap)
  {
    RectF localRectF = new RectF(0.0F, 0.0F, this.avatarWidth, this.avatarWidth);
    Bitmap localBitmap = Bitmap.createBitmap(this.avatarWidth, this.avatarWidth, Bitmap.Config.ARGB_8888);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawRoundRect(localRectF, QMUIKit.dpToPx(3), QMUIKit.dpToPx(3), localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
    }
    return localBitmap;
  }
  
  private void setDefaultAvatar()
  {
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)QMApplicationContext.sharedInstance().getResources().getDrawable(this.imageID);
    if (localBitmapDrawable != null) {
      this.userAvatar = localBitmapDrawable.getBitmap();
    }
    if (this.avatarType != 3)
    {
      this.userAvatar = roundImage(this.userAvatar);
      return;
    }
    this.userAvatar = roundSquareImage(this.userAvatar);
  }
  
  public Bitmap getBitmap()
  {
    if ((this.userAvatar == null) || (this.userAvatar.isRecycled()))
    {
      setDefaultAvatar();
      this.isTextAvatar = false;
    }
    int i = this.bitmapMask.getWidth();
    if (this.avatarType == 5) {
      i = QMApplicationContext.sharedInstance().getResources().getDimensionPixelSize(2131299550);
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(this.userAvatar, null, this.centerArea, null);
    if (this.avatarType != 5) {
      localCanvas.drawBitmap(this.bitmapMask, 0.0F, 0.0F, null);
    }
    return localBitmap;
  }
  
  public String getSizeStringHash()
  {
    return String.valueOf(getIconSizeString(this.avatarType).hashCode());
  }
  
  public Bitmap setAvatar(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      if (this.avatarType != 3) {
        this.userAvatar = roundImage(paramBitmap);
      }
    }
    for (;;)
    {
      this.isTextAvatar = false;
      return getBitmap();
      this.userAvatar = roundSquareImage(paramBitmap);
      continue;
      setDefaultAvatar();
    }
  }
  
  public Bitmap setAvatar(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap != null) {
      if (this.avatarType != 3) {
        this.userAvatar = roundImage(paramBitmap);
      }
    }
    for (this.isTextAvatar = false;; this.isTextAvatar = true)
    {
      return getBitmap();
      this.userAvatar = roundSquareImage(paramBitmap);
      break;
      this.userAvatar = drawTextAvatar(paramString, this.avatarType);
    }
  }
  
  public Bitmap setAvatar(String paramString)
  {
    this.userAvatar = drawTextAvatar(paramString, this.avatarType);
    this.isTextAvatar = true;
    return getBitmap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMAvatar
 * JD-Core Version:    0.7.0.1
 */