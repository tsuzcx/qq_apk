package com.tencent.av.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;
import wja;

public class MutiMemberThumbList
  extends FrameLayout
{
  private final String RA = "%d+";
  private final String Rz = "%d名成员被邀请";
  private boolean Xq;
  private VideoController a;
  private int aqx;
  private GradientDrawable b;
  private final int[] cI = { 2131374111, 2131374112, 2131374113, 2131374114, 2131374115, 2131374116, 2131374117 };
  private View hV;
  private final ArrayList<VideoController.b> iN = new ArrayList();
  private volatile boolean mDestroyed;
  private int mTextColor = -1;
  private long md;
  private long oG = -1L;
  
  public MutiMemberThumbList(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MutiMemberThumbList(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private void f(int paramInt, ArrayList<VideoController.b> paramArrayList)
  {
    QLog.d("MutiMemberThumbList", 1, "doDisplay " + paramInt);
    ThreadManager.getSubThreadHandler().post(new MutiMemberThumbList.1(this, paramInt, paramArrayList));
  }
  
  private void initUI()
  {
    addView(LayoutInflater.from(getContext()).inflate(2131559934, null));
    this.mDestroyed = false;
  }
  
  public void atv()
  {
    this.mDestroyed = true;
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("MutiMemberThumbList", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    this.mDestroyed = true;
  }
  
  public void setBitMapFetcher(VideoController paramVideoController)
  {
    this.a = paramVideoController;
  }
  
  public void setDisPlayList(ArrayList<VideoController.b> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      setVisibility(4);
      this.oG = System.currentTimeMillis();
      QLog.d("MutiMemberThumbList", 1, "setDisPlayList " + this.oG);
      return;
    }
    QLog.d("MutiMemberThumbList", 1, "setDisPlayList cost" + (System.currentTimeMillis() - this.oG));
    this.iN.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      VideoController.b localb = (VideoController.b)paramArrayList.next();
      this.iN.add(localb);
    }
    f(this.iN.size(), (ArrayList)this.iN.clone());
  }
  
  public void setHeadImgMask(boolean paramBoolean)
  {
    this.Xq = paramBoolean;
  }
  
  public void setMoreInfoDrawableColor(String paramString)
  {
    int i = wja.dp2px(32.0F, getResources());
    this.b = new GradientDrawable();
    this.b.setShape(1);
    this.b.setColor(Color.parseColor(paramString));
    this.b.setSize(i, i);
  }
  
  public void setRelatedView(View paramView)
  {
    this.hV = paramView;
    this.hV.setVisibility(4);
  }
  
  public void setRelationShipInfo(long paramLong, int paramInt)
  {
    this.md = paramLong;
    this.aqx = paramInt;
  }
  
  public void setTextColor(String paramString)
  {
    this.mTextColor = Color.parseColor(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MutiMemberThumbList
 * JD-Core Version:    0.7.0.1
 */