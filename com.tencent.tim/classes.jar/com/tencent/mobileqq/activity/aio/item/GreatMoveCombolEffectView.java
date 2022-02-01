package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import aqhu;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import wja;
import wki;
import xbu.a;
import xdv;

public class GreatMoveCombolEffectView
  extends View
  implements Runnable
{
  public static boolean mIsAnimating;
  DecodeRunnable jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable;
  a jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$a;
  private MessageForPoke b;
  int bTe = 0;
  boolean bgO = false;
  Handler by;
  private ChatXListView jdField_d_of_type_ComTencentMobileqqBubbleChatXListView;
  private wki jdField_d_of_type_Wki;
  Bitmap ea;
  private Context mContext;
  int mCurIndex = 0;
  Paint mPaint = new Paint(6);
  Handler mUiHandler;
  private Vector<Bitmap> p = new Vector();
  public ArrayList<Bitmap> qB = new ArrayList();
  ArrayList<b> qC = new ArrayList();
  
  public GreatMoveCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private xbu.a a()
  {
    View localView;
    if ((this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView != null) && (this.jdField_d_of_type_Wki != null))
    {
      int i = wja.a(this.b.uniseq, this.jdField_d_of_type_Wki);
      localView = wja.a(this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView, i + 1);
      if (localView != null) {}
    }
    else
    {
      return null;
    }
    return (xbu.a)wja.a(localView);
  }
  
  private void a(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$a = parama;
  }
  
  private void cdM()
  {
    String str = PokeBigResHandler.brt + "/dazhao_caidan/dazhao_caidan_";
    int i = 0;
    if (i < 37)
    {
      if (i + 1 < 10) {
        cB(str + "0" + (i + 1) + ".png", 30);
      }
      for (;;)
      {
        i += 1;
        break;
        cB(str + (i + 1) + ".png", 30);
      }
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    if ((this.mContext instanceof FragmentActivity))
    {
      paramContext = ((FragmentActivity)this.mContext).getChatFragment().a();
      this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView = paramContext.b;
      this.jdField_d_of_type_Wki = paramContext.a;
    }
    setOnTouchListener(new xdv(this));
    this.mUiHandler = new Handler(Looper.getMainLooper());
    cdM();
    paramContext = new HandlerThread("decode");
    paramContext.start();
    this.by = new Handler(paramContext.getLooper());
  }
  
  public void a(MessageForPoke paramMessageForPoke, a parama)
  {
    if ((mIsAnimating) && (paramMessageForPoke != this.b)) {
      return;
    }
    this.mCurIndex = 0;
    this.mUiHandler.removeCallbacks(this);
    this.mUiHandler.post(this);
    paramMessageForPoke = (b)this.qC.get(this.mCurIndex);
    try
    {
      this.ea = aqhu.d(paramMessageForPoke.path, null);
      return;
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
      }
      this.ea = null;
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, a parama)
  {
    if (mIsAnimating)
    {
      parama.cdN();
      return;
    }
    a(parama);
    setVisibility(0);
    this.b = paramMessageForPoke;
    this.bgO = paramBoolean;
    this.mUiHandler.removeCallbacks(this);
    this.mUiHandler.post(this);
    paramMessageForPoke = (b)this.qC.get(this.mCurIndex);
    try
    {
      this.ea = aqhu.d(paramMessageForPoke.path, null);
      mIsAnimating = true;
      return;
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
        }
        this.ea = null;
      }
    }
  }
  
  public Bitmap al()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.qB != null)
    {
      localObject1 = localObject2;
      if (this.qB.size() > 0) {
        localObject1 = (Bitmap)this.qB.remove(0);
      }
    }
    return localObject1;
  }
  
  public void cB(String paramString, int paramInt)
  {
    b localb = new b();
    localb.path = paramString;
    localb.aCm = paramInt;
    this.qC.add(localb);
  }
  
  public void clear()
  {
    if ((this.ea != null) && (!this.ea.isRecycled()))
    {
      this.ea.recycle();
      this.ea = null;
    }
    Iterator localIterator;
    if (this.qB.size() > 0)
    {
      localIterator = this.qB.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.qB.clear();
    }
    if (this.p.size() > 0)
    {
      localIterator = this.p.iterator();
      while (localIterator.hasNext()) {
        ((Bitmap)localIterator.next()).recycle();
      }
      this.p.clear();
    }
  }
  
  public void destory()
  {
    this.mContext = null;
    this.jdField_d_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_d_of_type_Wki = null;
    end();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.b == null) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        localObject1 = a();
        if (localObject1 == null)
        {
          end();
          return;
        }
        localObject2 = new int[2];
        ((xbu.a)localObject1).wE.getLocationOnScreen((int[])localObject2);
        i = localObject2[1];
        j = ((xbu.a)localObject1).wE.getLayoutParams().height / 2;
        super.draw(paramCanvas);
      } while ((this.ea == null) || (this.ea.isRecycled()));
      int k = this.ea.getWidth();
      int m = this.ea.getHeight();
      int n = getWidth();
      int i1 = getHeight();
      if (this.bgO)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, n / 2, i1 / 2);
      }
      float f = n * 1.0F / k;
      paramCanvas.translate(0.0F, -((int)(m * f / 2.0F - (j + i)) + 50));
      Object localObject1 = new Rect(0, 0, k, m);
      Object localObject2 = new Rect(0, 0, n, (int)(m * f));
      paramCanvas.drawBitmap(this.ea, (Rect)localObject1, (Rect)localObject2, this.mPaint);
    } while (!this.bgO);
    paramCanvas.restore();
  }
  
  public void end()
  {
    this.mCurIndex = 0;
    this.bTe = 0;
    mIsAnimating = false;
    this.mUiHandler.removeCallbacks(this);
    this.by.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable = null;
    setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$a != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$a.cdN();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$a = null;
    }
  }
  
  public void run()
  {
    int i = this.mCurIndex + 1;
    if ((i < 37) && (mIsAnimating))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable = new DecodeRunnable(this.qB);
      }
      b localb = (b)this.qC.get(i);
      this.by.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
      this.by.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemGreatMoveCombolEffectView$DecodeRunnable);
      this.mCurIndex += 1;
      Bitmap localBitmap;
      if ((this.ea != null) && (!this.ea.isRecycled()))
      {
        localBitmap = this.ea;
        if (this.p.size() > 2) {
          break label156;
        }
        this.p.add(localBitmap);
      }
      for (;;)
      {
        this.ea = al();
        invalidate();
        this.mUiHandler.postDelayed(this, localb.aCm);
        return;
        label156:
        localBitmap.recycle();
      }
    }
    end();
  }
  
  public class DecodeRunnable
    implements Runnable
  {
    BitmapFactory.Options d = new BitmapFactory.Options();
    ArrayList<Bitmap> qD;
    
    public DecodeRunnable()
    {
      Object localObject;
      this.qD = localObject;
    }
    
    public void run()
    {
      for (;;)
      {
        try
        {
          if ((this.qD.size() >= 2) || (GreatMoveCombolEffectView.this.bTe >= GreatMoveCombolEffectView.this.qC.size()) || (!GreatMoveCombolEffectView.mIsAnimating)) {
            break label209;
          }
          localObject1 = GreatMoveCombolEffectView.this.qC;
          localObject4 = GreatMoveCombolEffectView.this;
          int i = ((GreatMoveCombolEffectView)localObject4).bTe;
          ((GreatMoveCombolEffectView)localObject4).bTe = (i + 1);
          localObject4 = (GreatMoveCombolEffectView.b)((ArrayList)localObject1).get(i);
          if (localObject4 == null) {
            continue;
          }
          this.d.inSampleSize = 1;
          this.d.inPreferredConfig = Bitmap.Config.ARGB_4444;
          this.d.inMutable = true;
          if (GreatMoveCombolEffectView.a(GreatMoveCombolEffectView.this).size() <= 0) {
            break label225;
          }
          localObject1 = (Bitmap)GreatMoveCombolEffectView.a(GreatMoveCombolEffectView.this).remove(0);
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()) && (CustomFrameAnimationDrawable.Sx())) {
            this.d.inBitmap = ((Bitmap)localObject1);
          }
        }
        finally
        {
          try
          {
            Object localObject4;
            Object localObject1 = aqhu.d(((GreatMoveCombolEffectView.b)localObject4).path, this.d);
            if (localObject1 == null) {
              continue;
            }
            this.qD.add(localObject1);
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (!QLog.isColorLevel()) {
              break label230;
            }
          }
          localObject2 = finally;
        }
        QLog.d("GreatMove", 2, localOutOfMemoryError.toString());
        break label230;
        label209:
        if (!GreatMoveCombolEffectView.mIsAnimating) {
          GreatMoveCombolEffectView.this.clear();
        }
        return;
        label225:
        Object localObject3 = null;
        continue;
        label230:
        localObject3 = null;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void cdN();
  }
  
  public class b
  {
    int aCm;
    String path;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView
 * JD-Core Version:    0.7.0.1
 */