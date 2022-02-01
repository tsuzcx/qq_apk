package com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import qwh;
import rom;
import rpq;

public class ThumbSlideShowView
  extends ImageSwitcher
  implements Handler.Callback, ViewSwitcher.ViewFactory
{
  private long BA;
  private qwh jdField_b_of_type_Qwh;
  private BitmapDrawable[] jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable;
  private int index;
  private Handler mHandler;
  private Handler mWorkHandler;
  private ArrayList<LocalMediaInfo> nr;
  
  public ThumbSlideShowView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public ThumbSlideShowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private Bitmap a(Context paramContext, LocalMediaInfo paramLocalMediaInfo, int paramInt, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap = null;
    rom.bvL();
    if (paramContext == null)
    {
      rom.fail("Need the context to get thumbnail!", new Object[0]);
      paramContext = localBitmap;
    }
    do
    {
      return paramContext;
      if ((paramInt != 1) && (paramInt != 3))
      {
        rom.fail("kind is illegal", new Object[0]);
        return null;
      }
      long l = paramLocalMediaInfo._id;
      localBitmap = MediaStore.Images.Thumbnails.getThumbnail(paramContext.getContentResolver(), l, paramInt, paramOptions);
      paramContext = localBitmap;
    } while (localBitmap != null);
    return BitmapFactory.decodeFile(paramLocalMediaInfo.path, paramOptions);
  }
  
  private void init()
  {
    super.setFactory(this);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130772077);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130772079);
    localAnimation1.setDuration(800L);
    localAnimation2.setDuration(800L);
    super.setInAnimation(localAnimation1);
    super.setOutAnimation(localAnimation2);
    super.setAnimateFirstView(true);
    this.mHandler = new Handler(Looper.getMainLooper(), this);
    this.mWorkHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_Qwh = new qwh(rpq.c(getContext(), 8.0F), 0, 1.418182F, null, null);
  }
  
  public void brW()
  {
    if (this.mWorkHandler != null) {
      this.mWorkHandler.removeMessages(2);
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(1);
      this.mHandler.removeMessages(3);
    }
  }
  
  public void co(ArrayList<LocalMediaInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    brW();
    this.BA = System.currentTimeMillis();
    this.index = 0;
    this.nr = new ArrayList(paramArrayList);
    this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable[paramArrayList.size()];
    this.mWorkHandler.sendEmptyMessage(2);
    this.mHandler.sendEmptyMessage(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return true;
        paramMessage = this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[this.index];
        if (paramMessage == null) {
          break;
        }
        super.setImageDrawable(paramMessage);
      } while (this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length == 1);
      this.index += 1;
      if (this.index >= this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length) {
        this.index = 0;
      }
      this.mHandler.sendEmptyMessageDelayed(1, 2000L);
      return true;
      this.index += 1;
      if (this.index >= this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable.length) {
        this.index = 0;
      }
      this.mHandler.sendEmptyMessageDelayed(1, 100L);
      return true;
    }
    long l = System.currentTimeMillis();
    int i = 0;
    label146:
    if (i < this.nr.size())
    {
      paramMessage = (LocalMediaInfo)this.nr.get(i);
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inMutable = true;
      paramMessage = a(getContext(), paramMessage, 1, (BitmapFactory.Options)localObject);
      if (paramMessage == null) {}
      for (;;)
      {
        i += 1;
        break label146;
        localObject = new Canvas(paramMessage);
        Paint localPaint = new Paint();
        localPaint.setColor(-16777216);
        localPaint.setAlpha(100);
        ((Canvas)localObject).drawRect(0.0F, 0.0F, paramMessage.getWidth(), paramMessage.getHeight(), localPaint);
        ((Canvas)localObject).save();
        ((Canvas)localObject).restore();
        if (this.BA > l) {
          break;
        }
        if (paramMessage != null)
        {
          this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableBitmapDrawable[i] = new BitmapDrawable(getContext().getResources(), this.jdField_b_of_type_Qwh.z(paramMessage));
          paramMessage.recycle();
        }
      }
    }
    this.mHandler.sendEmptyMessage(3);
    return true;
  }
  
  public View makeView()
  {
    ImageView localImageView = new ImageView(getContext());
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localImageView;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    brW();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.ThumbSlideShowView
 * JD-Core Version:    0.7.0.1
 */