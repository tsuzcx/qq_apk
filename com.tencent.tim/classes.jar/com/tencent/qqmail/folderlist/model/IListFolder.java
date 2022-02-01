package com.tencent.qqmail.folderlist.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIHelper;

public class IListFolder
  extends IListItem<QMFolder>
{
  private boolean isReserve = false;
  private boolean mDrawCheckbox = false;
  private boolean mMultiAccount = false;
  private int mSequence = 0;
  private boolean mShouldShow = false;
  private String name = "";
  
  public IListFolder(IListItem.ItemType paramItemType, QMFolder paramQMFolder, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    super(paramItemType, paramQMFolder);
    this.mMultiAccount = paramBoolean1;
    this.mDrawCheckbox = paramBoolean2;
    this.mShouldShow = paramBoolean3;
    this.mSequence = paramInt;
    this.name = paramQMFolder.getName();
  }
  
  public IListFolder(IListItem.ItemType paramItemType, String paramString)
  {
    super(paramItemType, null, paramString);
  }
  
  public static int getSystemFolderDrawableResId(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    case 7: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
      return 0;
    case 1: 
      return 2130841293;
    case 3: 
      return 2130841299;
    case 5: 
      return 2130841303;
    case 6: 
      return 2130841300;
    case 16: 
      return 2130841301;
    case 4: 
      return 2130841289;
    }
    return 2130840960;
  }
  
  public Drawable getIcon()
  {
    int k = 2130841294;
    Object localObject1 = QMApplicationContext.sharedInstance().getResources();
    Object localObject2;
    if (((QMFolder)this.mData).getType() == 14)
    {
      localObject2 = ((QMFolder)this.mData).getColorId();
      if (localObject2 != null)
      {
        float f = ((Resources)localObject1).getDimensionPixelSize(2131297650);
        localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
        ((ShapeDrawable)localObject1).getPaint().setColor(QMUIHelper.getMailTagColorByColorId(QMApplicationContext.sharedInstance(), (String)localObject2));
        ((ShapeDrawable)localObject1).getPaint().setStyle(Paint.Style.FILL);
        return localObject1;
      }
    }
    int i = getSystemFolderDrawableResId(((QMFolder)this.mData).getType());
    int j;
    if (!this.mMultiAccount) {
      if (i == 0)
      {
        j = 2130840960;
        i = j;
        switch (((QMFolder)this.mData).getId())
        {
        default: 
          i = j;
        case -21: 
        case -17: 
        case -15: 
        case -14: 
        case -13: 
        case -12: 
        case -11: 
        case -10: 
        case -8: 
        case -7: 
        case -6: 
          if (((QMFolder)this.mData).getType() == 1) {
            j = 2130841292;
          }
          break;
        }
      }
    }
    for (;;)
    {
      label299:
      if (((QMFolder)this.mData).getType() == 13)
      {
        localObject2 = ((QMFolder)this.mData).getPopEmail().split("@");
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (localObject2.length == 2) {
            i = QMUIHelper.getDrawableByDomain(localObject2[1]);
          }
        }
      }
      for (;;)
      {
        if (i <= 0) {
          break label517;
        }
        return ((Resources)localObject1).getDrawable(i);
        i = 2130841280;
        break;
        i = 2130841285;
        break;
        i = 2130841296;
        break;
        i = 2130841294;
        break;
        i = 2130841291;
        break;
        i = 2130841286;
        break;
        i = 2130841287;
        break;
        i = 2130841295;
        break;
        i = 2130841279;
        break;
        i = 2130841284;
        break;
        i = 2130841288;
        break;
        j = k;
        if (((QMFolder)this.mData).getType() == 17) {
          break label299;
        }
        if (((QMFolder)this.mData).getType() == 18)
        {
          j = 2130841285;
          break label299;
        }
        if (((QMFolder)this.mData).getType() != 140) {
          break label519;
        }
        j = 2130841295;
        break label299;
        i = j;
        if (((QMFolder)this.mData).getType() == 130) {
          i = 2130841297;
        }
      }
      label517:
      return null;
      label519:
      j = i;
      continue;
      j = i;
      break;
      j = i;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getSequence()
  {
    return this.mSequence;
  }
  
  public Drawable getSubIcon()
  {
    if (((QMFolder)this.mData).getType() == 130)
    {
      Bitmap localBitmap = PopularizeUIHelper.getPopularizeItemSubImage(((QMFolder)this.mData).getId());
      if (localBitmap != null) {
        return new BitmapDrawable(QMApplicationContext.sharedInstance().getResources(), localBitmap);
      }
      return null;
    }
    return null;
  }
  
  public double getSubIconPosition()
  {
    if (((QMFolder)this.mData).getType() == 130) {
      return PopularizeUIHelper.getPopularizeItemSubImagePosition(((QMFolder)this.mData).getId());
    }
    return 0.0D;
  }
  
  public String getSubInfo()
  {
    if (((QMFolder)this.mData).getType() == 130) {
      return PopularizeUIHelper.getPopularizeItemSubInfoData(((QMFolder)this.mData).getId());
    }
    return null;
  }
  
  public int getUnreadCnt()
  {
    return 0;
  }
  
  public boolean isMultiAccount()
  {
    return this.mMultiAccount;
  }
  
  public boolean isReserve()
  {
    return this.isReserve;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setReserve(boolean paramBoolean)
  {
    this.isReserve = paramBoolean;
  }
  
  public void setSequence(int paramInt)
  {
    this.mSequence = paramInt;
  }
  
  public void setShouldShow(boolean paramBoolean)
  {
    this.mShouldShow = paramBoolean;
  }
  
  public boolean shouldDrawArrow()
  {
    return false;
  }
  
  public boolean shouldDrawCheckbox()
  {
    return this.mDrawCheckbox;
  }
  
  public boolean shouldDrawIcon()
  {
    return false;
  }
  
  public boolean shouldShow()
  {
    return this.mShouldShow;
  }
  
  public String toString()
  {
    return "[" + this.name + "/" + this.mSequence + "/" + this.mShouldShow + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.folderlist.model.IListFolder
 * JD-Core Version:    0.7.0.1
 */