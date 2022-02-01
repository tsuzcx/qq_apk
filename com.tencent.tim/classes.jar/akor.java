import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.ocr.view.gesture.GestureFrameLayout;
import com.tencent.mobileqq.ocr.view.gesture.GestureProxy;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class akor
  extends akpf
  implements Handler.Callback
{
  private List<akoq> Ek;
  private akop jdField_a_of_type_Akop;
  private akor.a jdField_a_of_type_Akor$a;
  private akpb jdField_a_of_type_Akpb;
  private GestureFrameLayout c;
  private final float[] cQ = new float[2];
  private View.OnClickListener clickListener;
  private Context context;
  private boolean ctt;
  private boolean ctu;
  private boolean ctv;
  private boolean ctw;
  private int doj;
  private int dok;
  private int dol = -1;
  private Point l;
  private Matrix matrix = new Matrix();
  private Handler reportHandler;
  
  public akor(GestureFrameLayout paramGestureFrameLayout, List<akoq> paramList, View.OnClickListener paramOnClickListener, akor.a parama)
  {
    this.c = paramGestureFrameLayout;
    this.context = paramGestureFrameLayout.getContext();
    this.Ek = paramList;
    this.clickListener = paramOnClickListener;
    this.jdField_a_of_type_Akor$a = parama;
    paramGestureFrameLayout.a().a().getMatrix().invert(this.matrix);
    this.jdField_a_of_type_Akop = new akop();
    this.jdField_a_of_type_Akop.V(2131365509, this.context.getString(2131721060), 2130839077);
    this.jdField_a_of_type_Akop.V(2131367523, this.context.getString(2131721067), 2130839086);
    this.jdField_a_of_type_Akop.V(2131380147, this.context.getString(2131701474), 2130839086);
    this.jdField_a_of_type_Akop.setOnClickListener(this.clickListener);
    this.reportHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    if (akpb.ass()) {}
    for (paramGestureFrameLayout = new akpb();; paramGestureFrameLayout = null)
    {
      this.jdField_a_of_type_Akpb = paramGestureFrameLayout;
      return;
    }
  }
  
  public static int a(Point paramPoint1, Point paramPoint2)
  {
    return paramPoint1.x * paramPoint2.x + paramPoint1.y * paramPoint2.y;
  }
  
  public static Point a(Point paramPoint1, Point paramPoint2)
  {
    return new Point(paramPoint2.x - paramPoint1.x, paramPoint2.y - paramPoint1.y);
  }
  
  private void a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    int k;
    if (!this.ctt)
    {
      this.ctt = true;
      this.cQ[0] = paramMotionEvent1.getX();
      this.cQ[1] = paramMotionEvent1.getY();
      this.matrix.mapPoints(this.cQ);
      i = Math.round(this.cQ[0]);
      j = Math.round(this.cQ[1]);
      paramMotionEvent1 = this.Ek.iterator();
      while (paramMotionEvent1.hasNext())
      {
        akoq localakoq = (akoq)paramMotionEvent1.next();
        k = this.Ek.indexOf(localakoq);
        if (a(new Point(i, j), localakoq)) {
          a(localakoq, k);
        }
      }
    }
    this.cQ[0] = paramMotionEvent2.getX();
    this.cQ[1] = paramMotionEvent2.getY();
    this.matrix.mapPoints(this.cQ);
    int i = Math.round(this.cQ[0]);
    int j = Math.round(this.cQ[1]);
    if (this.l != null)
    {
      paramMotionEvent1 = this.Ek.iterator();
      while (paramMotionEvent1.hasNext())
      {
        paramMotionEvent2 = (akoq)paramMotionEvent1.next();
        k = this.Ek.indexOf(paramMotionEvent2);
        if (a(i, j, this.l.x, this.l.y, paramMotionEvent2)) {
          a(paramMotionEvent2, k);
        }
      }
    }
    this.l = new Point(i, j);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int i = (paramInt8 - paramInt6) * (paramInt3 - paramInt1) - (paramInt7 - paramInt5) * (paramInt4 - paramInt2);
    float f1 = ((paramInt7 - paramInt5) * (paramInt2 - paramInt6) - (paramInt8 - paramInt6) * (paramInt1 - paramInt5)) / i;
    float f2 = ((paramInt3 - paramInt1) * (paramInt2 - paramInt6) - (paramInt4 - paramInt2) * (paramInt1 - paramInt5)) / i;
    return (f1 >= 0.0F) && (f1 <= 1.0F) && (f2 >= 0.0F) && (f2 <= 1.0F);
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, akoq paramakoq)
  {
    Point localPoint1 = (Point)paramakoq.Ei.get(0);
    Point localPoint2 = (Point)paramakoq.Ei.get(1);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint1.x, localPoint1.y, localPoint2.x, localPoint2.y)) {
      return true;
    }
    Point localPoint3 = (Point)paramakoq.Ei.get(2);
    paramakoq = (Point)paramakoq.Ei.get(3);
    if (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint3.x, localPoint3.y, paramakoq.x, paramakoq.y)) {
      return true;
    }
    return (a(paramInt1, paramInt2, paramInt3, paramInt4, localPoint2.x, localPoint2.y, localPoint3.x, localPoint3.y)) || (a(paramInt1, paramInt2, paramInt3, paramInt4, paramakoq.x, paramakoq.y, localPoint1.x, localPoint1.y));
  }
  
  private static boolean a(Point paramPoint, akoq paramakoq)
  {
    if ((paramPoint.y > paramakoq.cbW) || (paramPoint.y < paramakoq.aLL) || (paramPoint.x > paramakoq.doe) || (paramPoint.x < paramakoq.dof)) {}
    int i;
    do
    {
      Point localPoint1;
      Point localPoint3;
      do
      {
        return false;
        if (paramakoq.dod % 90 < 1) {
          return true;
        }
        Point localPoint2 = (Point)paramakoq.Ei.get(0);
        localPoint1 = (Point)paramakoq.Ei.get(1);
        paramakoq = (Point)paramakoq.Ei.get(2);
        localPoint3 = a(localPoint2, localPoint1);
        i = a(localPoint3, a(localPoint2, paramPoint));
      } while ((i < 0) || (i > a(localPoint3, localPoint3)));
      paramakoq = a(localPoint1, paramakoq);
      i = a(paramakoq, a(localPoint1, paramPoint));
    } while (i < 0);
    if (i <= a(paramakoq, paramakoq)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(MotionEvent paramMotionEvent, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.cQ[0] = paramMotionEvent.getX();
    this.cQ[1] = paramMotionEvent.getY();
    this.matrix.mapPoints(this.cQ);
    int j = Math.round(this.cQ[0]);
    int k = Math.round(this.cQ[1]);
    paramMotionEvent = this.Ek.iterator();
    boolean bool = false;
    label124:
    int i;
    if (paramMotionEvent.hasNext())
    {
      akoq localakoq = (akoq)paramMotionEvent.next();
      if (!a(new Point(j, k), localakoq)) {
        break label218;
      }
      if (!paramBoolean2)
      {
        if ((paramBoolean1) || (!localakoq.isSelected))
        {
          bool = true;
          localakoq.isSelected = bool;
          this.c.P(this.c);
          if ((!paramBoolean1) && (!localakoq.isSelected)) {
            break label203;
          }
          i = 1;
          label157:
          this.dol = i;
          if (paramBoolean1) {
            a(localakoq);
          }
          if (!localakoq.isSelected) {
            break label209;
          }
          i = 1;
          label184:
          aklz.cN("0X800AAED", i);
        }
      }
      else {
        bool = true;
      }
    }
    label203:
    label209:
    label218:
    for (;;)
    {
      break;
      bool = false;
      break label124;
      i = 2;
      break label157;
      i = 2;
      break label184;
      return bool;
    }
  }
  
  public void a(akoq paramakoq)
  {
    if (!this.jdField_a_of_type_Akop.isShow())
    {
      Object localObject = (Point)paramakoq.Ei.get(0);
      paramakoq = (Point)paramakoq.Ei.get(1);
      Matrix localMatrix = new Matrix();
      this.matrix.invert(localMatrix);
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = ((Point)localObject).x;
      arrayOfFloat[1] = ((Point)localObject).y;
      localObject = new float[2];
      localObject[0] = paramakoq.x;
      localObject[1] = paramakoq.y;
      localMatrix.mapPoints(arrayOfFloat);
      localMatrix.mapPoints((float[])localObject);
      int i = (int)(arrayOfFloat[0] + localObject[0]) / 2;
      float f = arrayOfFloat[1];
      int j = (int)(localObject[1] + f) / 2;
      this.jdField_a_of_type_Akop.d(this.c, i, j);
    }
  }
  
  public void a(akoq paramakoq, int paramInt)
  {
    boolean bool = true;
    if (this.dol == -1)
    {
      if (paramakoq.isSelected)
      {
        paramInt = 2;
        this.dol = paramInt;
        this.ctu = true;
      }
    }
    else {
      if (this.dol != 1) {
        break label92;
      }
    }
    for (;;)
    {
      if (bool != paramakoq.isSelected)
      {
        this.doj += 1;
        paramakoq.isSelected = bool;
        this.c.P(this.c);
        this.c.a().a().a(false);
      }
      return;
      paramInt = 1;
      break;
      label92:
      bool = false;
    }
  }
  
  public void ab(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Akor$a.dBN();
    int i;
    if (this.ctu)
    {
      this.dok = 4;
      if (this.dol == 1)
      {
        i = 1;
        anot.a(null, "dc00898", "", "", "0X800AAEE", "0X800AAEE", i, 0, String.valueOf(this.doj), "0", "0", "");
      }
    }
    for (;;)
    {
      this.ctu = false;
      this.ctw = false;
      this.ctv = false;
      this.reportHandler.removeMessages(1);
      this.reportHandler.sendEmptyMessageDelayed(1, 500L);
      this.l = null;
      this.dol = -1;
      this.doj = 0;
      this.ctt = false;
      return;
      i = 2;
      break;
      if (this.ctw)
      {
        this.dok = 1;
        aklz.cN("0X800AAF6", 0);
      }
      else if (this.ctv)
      {
        this.dok = 3;
        aklz.cN("0X800AAF7", 0);
      }
    }
  }
  
  public boolean asg()
  {
    return ((OCRPerformFragment)this.clickListener).arX();
  }
  
  public void c(Matrix paramMatrix)
  {
    this.matrix.set(paramMatrix);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    paramMessage = new HashMap();
    paramMessage.put("actType", String.valueOf(this.dok));
    anpc.a(BaseApplication.getContext()).collectPerformance(null, "actOcrGestureType", true, 0L, 0L, paramMessage, null);
    QLog.d("OcrScroll", 1, new Object[] { "report ActOcrGestureType, type:", Integer.valueOf(this.dok) });
    return false;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    this.dok = 2;
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onDown(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Akop.dismiss();
    this.c.a().a().a(true);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    this.dok = 7;
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, true, false);
    this.dok = 5;
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Akpb.dCy();
    return super.onScale(paramScaleGestureDetector);
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Akpb.start(1);
    this.jdField_a_of_type_Akor$a.dbE();
    return super.onScaleBegin(paramScaleGestureDetector);
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_a_of_type_Akpb.stop();
    this.ctw = true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (paramMotionEvent2.getPointerCount() >= 2)
    {
      this.ctv = true;
      return false;
    }
    if ((this.ctv) || ((this.l == null) && (asg()) && (!a(paramMotionEvent1, false, true))))
    {
      this.ctv = true;
      return false;
    }
    a(paramMotionEvent1, paramMotionEvent2);
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent, false, false);
    this.dok = 6;
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void dBN();
    
    public abstract void dbE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akor
 * JD-Core Version:    0.7.0.1
 */