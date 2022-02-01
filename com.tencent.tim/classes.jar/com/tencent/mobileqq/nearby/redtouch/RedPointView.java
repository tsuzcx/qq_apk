package com.tencent.mobileqq.nearby.redtouch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import java.util.ArrayList;
import java.util.List;

public class RedPointView
  extends FrameLayout
{
  protected static int id = 1;
  protected List<BusinessInfoCheckUpdate.RedTypeInfo> DY;
  protected View Fs;
  protected Context context;
  protected boolean csu = true;
  protected int dnb;
  protected int dnc;
  protected int dnd;
  protected int dne = 21;
  protected int dnf;
  protected int dng;
  protected int dnh;
  protected int dni;
  protected int dnj;
  protected int gravity;
  protected Handler handler;
  protected int leftMargin;
  protected int maxNum;
  protected int redPointId;
  protected int rightMargin;
  protected int topMargin;
  
  public RedPointView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedPointView(Context paramContext, View paramView)
  {
    super(paramContext);
    this.context = paramContext;
    this.Fs = paramView;
    init();
  }
  
  private void init()
  {
    this.gravity = this.dne;
    this.leftMargin = this.dnf;
    this.rightMargin = this.dng;
    this.topMargin = this.dnh;
    this.dnj = this.dni;
    this.maxNum = 99;
    this.DY = new ArrayList();
    this.handler = new Handler(Looper.getMainLooper());
    this.redPointId = 10;
    this.dnb = 20;
    this.dnc = 30;
    this.dnd = 40;
  }
  
  public void setMaxNum(int paramInt)
  {
    this.maxNum = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.RedPointView
 * JD-Core Version:    0.7.0.1
 */