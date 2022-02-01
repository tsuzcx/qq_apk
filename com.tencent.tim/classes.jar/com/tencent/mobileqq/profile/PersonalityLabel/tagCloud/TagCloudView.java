package com.tencent.mobileqq.profile.PersonalityLabel.tagCloud;

import alci;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.ISkinSetTypeface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TagCloudView
  extends View
  implements ISkinSetTypeface
{
  public static final int drz = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
  List<alci> Ay = new ArrayList();
  List<a> EP = new ArrayList();
  b a;
  private boolean cwa;
  float density;
  int drA = drz;
  int drB = 42;
  int dry;
  private Bitmap fO;
  int mCurTextColor = -16777216;
  private Matrix mDrawMatrix;
  Drawable mDrawable;
  private Matrix mMatrix = new Matrix();
  int mMinHeight = 0;
  Paint mPaint = new Paint(7);
  Random mRandom = new Random();
  ColorStateList o;
  
  public TagCloudView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TagCloudView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TagCloudView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private int a(int paramInt1, int paramInt2, List<alci> paramList, int paramInt3)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramList.size())
    {
      alci localalci = (alci)paramList.get(paramInt2);
      for (int k = localalci.iC(paramInt1); (k > 1.0F * paramInt3) && (!localalci.bTQ); k = localalci.iC(paramInt1))
      {
        localalci.reset();
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "measureChildren too high " + localalci.text);
        }
        localalci.textSize *= 0.75F;
        localalci.e.setTextSize(localalci.textSize);
      }
      j = i;
      if (!localalci.bTQ) {
        j = Math.max(i, k);
      }
      paramInt2 += 1;
      i = j;
    }
    return i;
  }
  
  private int a(Rect paramRect)
  {
    int[] arrayOfInt1 = new int[3];
    int[] tmp7_5 = arrayOfInt1;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = -1;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = -1;
    tmp15_11;
    int[] arrayOfInt2 = new int[3];
    int[] tmp27_25 = arrayOfInt2;
    tmp27_25[0] = -1;
    int[] tmp31_27 = tmp27_25;
    tmp31_27[1] = -1;
    int[] tmp35_31 = tmp31_27;
    tmp35_31[2] = -1;
    tmp35_31;
    int i = 0;
    int k = 0;
    int j = -1;
    int m;
    if (i < this.Ay.size())
    {
      alci localalci = (alci)this.Ay.get(i);
      m = (int)(localalci.Hr() * 0.8F);
      int n = (int)(localalci.Hs() * 0.8F);
      if (m * n <= 0)
      {
        n = j;
        m = k;
      }
      int i1;
      for (;;)
      {
        i += 1;
        k = m;
        j = n;
        break;
        if ((m > paramRect.width()) || (n > paramRect.height())) {
          break label213;
        }
        i1 = (int)(localalci.textSize * 0.8F);
        m = k;
        n = j;
        if (i1 > j)
        {
          arrayOfInt2[k] = i1;
          arrayOfInt1[k] = i;
          m = a(arrayOfInt2, true);
          n = arrayOfInt2[m];
        }
      }
      label213:
      float f1 = paramRect.width() / localalci.Hr();
      float f2 = paramRect.height() / localalci.Hs();
      if (f1 < f2) {}
      for (;;)
      {
        i1 = (int)(localalci.textSize * f1);
        break;
        f1 = f2;
      }
    }
    paramRect = new int[3];
    Rect tmp268_267 = paramRect;
    tmp268_267[0] = -1;
    Rect tmp272_268 = tmp268_267;
    tmp272_268[1] = -1;
    Rect tmp276_272 = tmp272_268;
    tmp276_272[2] = -1;
    tmp276_272;
    if (arrayOfInt1[2] >= 0) {
      i = 3;
    }
    while (i == 0)
    {
      return -1;
      if (arrayOfInt1[1] >= 0) {
        i = 2;
      } else if (arrayOfInt1[0] >= 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
    k = 0;
    j = 0;
    if (k < i)
    {
      if (arrayOfInt2[k] < this.density * 12.0F) {
        break label416;
      }
      m = j + 1;
      paramRect[j] = arrayOfInt1[k];
      j = m;
    }
    label416:
    for (;;)
    {
      k += 1;
      break;
      if (j > 0) {
        return paramRect[this.mRandom.nextInt(j)];
      }
      return arrayOfInt1[a(arrayOfInt2, false)];
    }
  }
  
  private int a(List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = (int)(0.5F * paramInt2);
    paramInt1 = 0;
    if (paramInt1 < paramList.size())
    {
      Rect localRect = (Rect)paramList.get(paramInt1);
      if (localRect.top == 0) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        if ((localRect.centerY() >= i) || (localRect.bottom == paramInt2))
        {
          localRect.top += paramInt3;
          localRect.bottom += paramInt3;
        }
      }
    }
    return paramInt2 + paramInt3;
  }
  
  private int a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int k = paramArrayOfInt[0];
    int m = 0;
    int j = 0;
    if (j < paramArrayOfInt.length)
    {
      int i;
      if (paramBoolean) {
        if (paramArrayOfInt[j] < k) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          k = paramArrayOfInt[j];
          m = j;
        }
        j += 1;
        break;
        i = 0;
        continue;
        if (paramArrayOfInt[j] > k) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    return m;
  }
  
  private static Rect a(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y, paramPoint.x + paramInt3, paramPoint.y + paramInt3);
    if ((localRect.bottom > paramInt2) || (localRect.right > paramInt1) || (localRect.left < 0) || (localRect.top < 0) || (a(paramList, localRect, null))) {
      return null;
    }
    int i = paramInt1 - paramPoint.x;
    localRect.right = (localRect.left + i);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt3;
      }
    }
    else
    {
      for (;;)
      {
        label117:
        if (Math.abs(paramInt1 - i) <= 2) {
          break label194;
        }
        int j = (int)((i + paramInt1) * 0.5F);
        localRect.right = (localRect.left + j);
        if (!a(paramList, localRect, null)) {}
        for (int k = 1;; k = 0)
        {
          if (k == 0) {
            break label187;
          }
          paramInt1 = j;
          break label117;
          paramInt1 = 0;
          break;
        }
        label187:
        i = j;
      }
      label194:
      localRect.right = (localRect.left + paramInt1);
    }
    paramInt2 -= paramPoint.y;
    localRect.bottom = (localRect.top + paramInt2);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt2;
      }
    }
    else
    {
      for (;;)
      {
        label243:
        if (Math.abs(paramInt3 - paramInt1) <= 2) {
          break label316;
        }
        paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
        localRect.bottom = (localRect.top + paramInt2);
        if (!a(paramList, localRect, null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label311;
          }
          paramInt3 = paramInt2;
          break label243;
          paramInt1 = 0;
          break;
        }
        label311:
        paramInt1 = paramInt2;
      }
      label316:
      localRect.bottom = (localRect.top + paramInt3);
    }
    return localRect;
  }
  
  private Rect a(List<Rect> paramList, int paramInt1, int paramInt2)
  {
    int i = 0;
    Object localObject2;
    if (paramList == null)
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = (Rect)paramList.get(0);
    float f2 = -1.0F;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= paramList.size()) {
        break;
      }
      localObject2 = (Rect)paramList.get(i);
      float f3 = (float)Math.pow(Math.pow(((Rect)localObject2).exactCenterX() - paramInt1 * 0.5F, 2.0D) + Math.pow(((Rect)localObject2).centerY() - paramInt2 * 0.5F, 2.0D), 0.5D);
      float f1 = f2;
      if (f2 < 0.0F) {
        f1 = f3;
      }
      f2 = f1;
      if (f3 > f1)
      {
        f2 = f3;
        localObject1 = localObject2;
      }
      i += 1;
    }
  }
  
  private static List<Rect> a(alci paramalci, List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    while (i < paramList.size())
    {
      int j = ((Point)paramList.get(i)).x;
      int k = ((Point)paramList.get(i)).y;
      Rect localRect = new Rect(j, k, paramalci.o.x + j, paramalci.o.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramalci.o.x, k - paramalci.o.y, j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j, k - paramalci.o.y, paramalci.o.x + j, k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      localRect = new Rect(j - paramalci.o.x, k, j, paramalci.o.y + k);
      if (a(localRect, paramList1, paramInt1, paramInt2)) {
        localArrayList.add(localRect);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<Rect> a(List<Point> paramList, List<Rect> paramList1, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "findAllEmptyRect");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = paramList.size() - 1;
    Object localObject1;
    while (i >= 0)
    {
      localObject1 = (Point)paramList.get(i);
      Object localObject3 = a((Point)localObject1, paramList1, paramInt1, paramInt2, paramInt3);
      Point localPoint;
      int j;
      int k;
      int m;
      if (localObject3 != null)
      {
        localArrayList1.add(localObject3);
        paramList1.add(localObject3);
        localPoint = new Point(((Rect)localObject3).left + ((Rect)localObject3).width(), ((Rect)localObject3).top);
        localObject2 = new Point(((Rect)localObject3).left, ((Rect)localObject3).top + ((Rect)localObject3).height());
        j = ((Rect)localObject3).left;
        k = ((Rect)localObject3).width();
        m = ((Rect)localObject3).top;
        localObject3 = new Point(j + k, ((Rect)localObject3).height() + m);
        localArrayList2.add(localPoint);
        localArrayList2.add(localObject2);
        localArrayList2.add(localObject3);
      }
      Object localObject2 = b((Point)localObject1, paramList1, paramInt1, paramInt2, paramInt3);
      if (localObject2 != null)
      {
        localArrayList1.add(localObject2);
        paramList1.add(localObject2);
        localObject1 = new Point(((Rect)localObject2).left, ((Rect)localObject2).top);
        localPoint = new Point(((Rect)localObject2).left + ((Rect)localObject2).width(), ((Rect)localObject2).top);
        j = ((Rect)localObject2).left;
        k = ((Rect)localObject2).width();
        m = ((Rect)localObject2).top;
        localObject2 = new Point(j + k, ((Rect)localObject2).height() + m);
        localArrayList2.add(localObject1);
        localArrayList2.add(localPoint);
        localArrayList2.add(localObject2);
      }
      paramList.remove(i);
      i -= 1;
    }
    i = localArrayList2.size() - 1;
    while (i >= 0)
    {
      paramList = (Point)localArrayList2.get(i);
      localObject1 = a(paramList, paramList1, paramInt1, paramInt2, paramInt3);
      if (localObject1 != null)
      {
        localArrayList1.add(localObject1);
        paramList1.add(localObject1);
      }
      paramList = b(paramList, paramList1, paramInt1, paramInt2, paramInt3);
      if (paramList != null)
      {
        localArrayList1.add(paramList);
        paramList1.add(paramList);
      }
      localArrayList2.remove(i);
      i -= 1;
    }
    return localArrayList1;
  }
  
  private static void a(List<Point> paramList, alci paramalci, int paramInt1, int paramInt2)
  {
    if (!paramalci.valid()) {}
    do
    {
      return;
      Point localPoint1 = new Point(paramalci.n.x, paramalci.n.y);
      Point localPoint2 = new Point(paramalci.n.x + paramalci.o.x, paramalci.n.y);
      Point localPoint3 = new Point(paramalci.n.x, paramalci.n.y + paramalci.o.y);
      paramalci = new Point(paramalci.n.x + paramalci.o.x, paramalci.n.y + paramalci.o.y);
      if (!a(paramList, localPoint1)) {
        paramList.add(localPoint1);
      }
      if (!a(paramList, localPoint2)) {
        paramList.add(localPoint2);
      }
      if (!a(paramList, localPoint3)) {
        paramList.add(localPoint3);
      }
    } while (a(paramList, paramalci));
    paramList.add(paramalci);
  }
  
  private void a(List<Rect> paramList, Point paramPoint, int paramInt)
  {
    int m = 0;
    int i = 0;
    if ((m < this.Ay.size()) && (i < paramInt))
    {
      alci localalci = (alci)this.Ay.get(m);
      if (localalci.bTQ) {}
      for (;;)
      {
        m += 1;
        break;
        int n = (int)(paramPoint.x - (localalci.n.x + 0.5F * localalci.o.x));
        int i1 = (int)(paramPoint.y - (localalci.n.y + 0.5F * localalci.o.y));
        Rect localRect1 = (Rect)paramList.get(m);
        Rect localRect2 = new Rect(localRect1);
        localRect2.offset(n, 0);
        int j;
        if (a(paramList, localRect2, localRect1))
        {
          j = 0;
          for (;;)
          {
            k = j;
            if (Math.abs(n - j) <= 1) {
              break;
            }
            k = (int)(0.5F * (n + j));
            localRect2.set(localRect1);
            localRect2.offset(k, 0);
            if (!a(paramList, localRect2, localRect1)) {
              j = k;
            } else {
              n = k;
            }
          }
        }
        int k = n;
        n = k;
        if (Math.abs(k) < Math.abs(this.drB)) {
          n = 0;
        }
        localRect2 = new Rect(localRect1);
        localRect2.offset(n, i1);
        if (a(paramList, localRect2, localRect1))
        {
          j = 0;
          for (;;)
          {
            k = j;
            if (Math.abs(i1 - j) <= 1) {
              break;
            }
            k = (int)(0.5F * (i1 + j));
            localRect2.set(localRect1);
            localRect2.offset(n, k);
            if (!a(paramList, localRect2, localRect1)) {
              j = k;
            } else {
              i1 = k;
            }
          }
        }
        k = i1;
        i1 = k;
        if (Math.abs(k) < Math.abs(this.drB)) {
          i1 = 0;
        }
        if (n <= 0)
        {
          j = i;
          if (i1 <= 0) {}
        }
        else
        {
          j = i + 1;
          localRect1.offset(n, i1);
          localalci.n.x = localRect1.left;
          localalci.n.y = localRect1.top;
        }
        i = j;
      }
    }
  }
  
  private static boolean a(Rect paramRect, List<Rect> paramList, int paramInt1, int paramInt2)
  {
    if ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.right < 0) || (paramRect.bottom < 0) || (paramRect.right > paramInt1) || (paramRect.bottom > paramInt2)) {
      return false;
    }
    paramInt1 = 0;
    for (;;)
    {
      if (paramInt1 >= paramList.size()) {
        break label82;
      }
      if (Rect.intersects(paramRect, (Rect)paramList.get(paramInt1))) {
        break;
      }
      paramInt1 += 1;
    }
    label82:
    return true;
  }
  
  private static boolean a(List<Point> paramList, Point paramPoint)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList.size())
      {
        if (paramPoint.equals(paramList.get(i))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private static boolean a(List<Rect> paramList, Rect paramRect1, Rect paramRect2)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramList.size())
      {
        if ((!((Rect)paramList.get(i)).equals(paramRect2)) && (Rect.intersects((Rect)paramList.get(i), paramRect1))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int aG(int paramInt1, int paramInt2)
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "layoutChildren start w:" + paramInt1 + " h:" + paramInt2);
    }
    ArrayList localArrayList1 = new ArrayList(this.Ay.size());
    Object localObject1 = c(null, paramInt1, paramInt2);
    ArrayList localArrayList2 = new ArrayList(this.Ay.size());
    localArrayList2.addAll(this.Ay);
    int j = 0;
    Object localObject2;
    while (j < localArrayList2.size())
    {
      alci localalci = (alci)localArrayList2.get(j);
      if ((localalci.bTQ) || (localalci.o.x * localalci.o.y == 0))
      {
        localArrayList1.add(new Rect());
        j += 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "layoutChildren index:" + j + " tagW:" + localalci.o.x + " tagH:" + localalci.o.y + " " + localalci.text);
        }
        i = paramInt2;
        for (localObject2 = localObject1;; localObject2 = c(localArrayList2, paramInt1, i))
        {
          Object localObject3 = a(localalci, (List)localObject2, localArrayList1, paramInt1, i);
          if ((localObject3 != null) && (((List)localObject3).size() > 0))
          {
            localObject1 = localObject2;
            paramInt2 = i;
            if (localObject3 == null) {
              break;
            }
            localObject1 = localObject2;
            paramInt2 = i;
            if (((List)localObject3).size() <= 0) {
              break;
            }
            localObject3 = a((List)localObject3, paramInt1, i);
            localalci.n.x = ((Rect)localObject3).left;
            localalci.n.y = ((Rect)localObject3).top;
            localArrayList1.add(localObject3);
            a((List)localObject2, localalci, paramInt1, i);
            localObject1 = localObject2;
            paramInt2 = i;
            if (!QLog.isDevelopLevel()) {
              break;
            }
            QLog.i("TagCloudView", 4, "layoutChildren findTheFarest:" + localObject3);
            localObject1 = localObject2;
            paramInt2 = i;
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TagCloudView", 2, "layoutChildren enlarge");
          }
          i = a(localArrayList1, paramInt1, i, (int)(0.3F * localalci.o.y));
          paramInt2 = 0;
          while (paramInt2 < localArrayList1.size())
          {
            ((alci)localArrayList2.get(paramInt2)).n.x = ((Rect)localArrayList1.get(paramInt2)).left;
            ((alci)localArrayList2.get(paramInt2)).n.y = ((Rect)localArrayList1.get(paramInt2)).top;
            paramInt2 += 1;
          }
        }
      }
    }
    localObject1 = new Point((int)(paramInt1 * 0.5F), (int)(paramInt2 * 0.5F));
    Collections.sort(this.Ay, new e((Point)localObject1));
    Collections.sort(localArrayList1, new c((Point)localObject1));
    int i = this.Ay.size();
    if (this.Ay.size() >= 6) {
      i = 2;
    }
    for (;;)
    {
      a(localArrayList1, (Point)localObject1, i);
      localObject1 = a(c(localArrayList2, paramInt1, paramInt2), localArrayList1, paramInt1, paramInt2, this.drB);
      paramInt1 = k;
      label670:
      if (paramInt1 < ((List)localObject1).size())
      {
        localObject2 = (Rect)((List)localObject1).get(paramInt1);
        if (QLog.isColorLevel()) {
          QLog.i("TagCloudView", 2, "layoutChildren filltags:" + paramInt1 + " rect:" + ((Rect)localObject2).toString());
        }
        try
        {
          m((Rect)localObject2);
          paramInt1 += 1;
          break label670;
          if (this.Ay.size() >= 4) {
            i = 3;
          }
        }
        catch (StackOverflowError localStackOverflowError)
        {
          for (;;)
          {
            try
            {
              QLog.i("TagCloudView", 1, "get StackOverflowError " + localStackOverflowError.getMessage() + " rect:" + localObject2 + " tags:" + this.Ay.toString(), localStackOverflowError);
            }
            catch (Exception localException) {}
          }
        }
      }
    }
    return paramInt2;
  }
  
  private static int b(Point paramPoint1, Point paramPoint2)
  {
    return (int)(Math.pow(Math.abs(paramPoint1.x - paramPoint2.x), 2.0D) + Math.pow(Math.abs(paramPoint1.y - paramPoint2.y), 2.0D));
  }
  
  private static Rect b(Point paramPoint, List<Rect> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    Rect localRect = new Rect(paramPoint.x, paramPoint.y - paramInt3, paramPoint.x + paramInt3, paramPoint.y);
    if ((localRect.bottom > paramInt2) || (localRect.right > paramInt1) || (localRect.left < 0) || (localRect.top < 0) || (a(paramList, localRect, null))) {
      return null;
    }
    paramInt2 = paramInt1 - paramPoint.x;
    localRect.right = (localRect.left + paramInt2);
    label115:
    int i;
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt3;
      }
    }
    else
    {
      for (;;)
      {
        if (Math.abs(paramInt1 - paramInt2) <= 2) {
          break label189;
        }
        i = (int)((paramInt2 + paramInt1) * 0.5F);
        localRect.right = (localRect.left + i);
        if (!a(paramList, localRect, null)) {}
        for (int j = 1;; j = 0)
        {
          if (j == 0) {
            break label183;
          }
          paramInt1 = i;
          break label115;
          paramInt1 = 0;
          break;
        }
        label183:
        paramInt2 = i;
      }
      label189:
      localRect.right = (localRect.left + paramInt1);
    }
    paramInt2 = paramPoint.y;
    localRect.top = (localRect.bottom - paramInt2);
    if (!a(paramList, localRect, null))
    {
      paramInt1 = 1;
      if (paramInt1 == 0) {
        paramInt1 = paramInt2;
      }
    }
    else
    {
      for (;;)
      {
        label236:
        if (Math.abs(paramInt3 - paramInt1) <= 2) {
          break label309;
        }
        paramInt2 = (int)((paramInt1 + paramInt3) * 0.5F);
        localRect.top = (localRect.bottom - paramInt2);
        if (!a(paramList, localRect, null)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label304;
          }
          paramInt3 = paramInt2;
          break label236;
          paramInt1 = 0;
          break;
        }
        label304:
        paramInt1 = paramInt2;
      }
      label309:
      localRect.top = (localRect.bottom - paramInt3);
    }
    return localRect;
  }
  
  private static List<Point> c(List<alci> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Point(0, 0));
    localArrayList.add(new Point(paramInt1, 0));
    localArrayList.add(new Point(0, paramInt2));
    localArrayList.add(new Point(paramInt1, paramInt2));
    if (paramList == null) {
      return localArrayList;
    }
    paramInt1 = 0;
    if (paramInt1 < paramList.size())
    {
      Object localObject = (alci)paramList.get(paramInt1);
      if ((!((alci)localObject).valid()) && (((alci)localObject).bTQ)) {}
      for (;;)
      {
        paramInt1 += 1;
        break;
        Point localPoint1 = new Point(((alci)localObject).n.x, ((alci)localObject).n.y);
        Point localPoint2 = new Point(((alci)localObject).n.x + ((alci)localObject).o.x, ((alci)localObject).n.y);
        Point localPoint3 = new Point(((alci)localObject).n.x, ((alci)localObject).n.y + ((alci)localObject).o.y);
        paramInt2 = ((alci)localObject).n.x;
        int i = ((alci)localObject).o.x;
        int j = ((alci)localObject).n.y;
        localObject = new Point(paramInt2 + i, ((alci)localObject).o.y + j);
        if (!a(localArrayList, localPoint1)) {
          localArrayList.add(localPoint1);
        }
        if (!a(localArrayList, localPoint2)) {
          localArrayList.add(localPoint2);
        }
        if (!a(localArrayList, localPoint3)) {
          localArrayList.add(localPoint3);
        }
        if (!a(localArrayList, (Point)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  private void cnB()
  {
    int i = this.o.getColorForState(getDrawableState(), 0);
    if (i != this.mCurTextColor) {
      this.mCurTextColor = i;
    }
  }
  
  private void e(Canvas paramCanvas, int paramInt)
  {
    float f3 = 0.0F;
    int j = this.mDrawable.getIntrinsicWidth();
    int k = this.mDrawable.getIntrinsicHeight();
    int i;
    if (((j < 0) || (paramInt == j)) && ((k < 0) || (paramInt == k)))
    {
      i = 1;
      paramCanvas.save();
      paramCanvas.clipRect(0, 0, paramInt, paramInt);
      if (i == 0) {
        break label107;
      }
      this.mDrawMatrix = null;
      this.mDrawable.setBounds(0, 0, paramInt, paramInt);
      if (this.mDrawMatrix != null) {
        break label224;
      }
      this.mDrawable.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      i = 0;
      break;
      label107:
      this.mDrawable.setBounds(0, 0, j, k);
      this.mDrawMatrix = new Matrix(this.mMatrix);
      float f1;
      if (j * paramInt > paramInt * k)
      {
        f1 = paramInt / k;
        f3 = (paramInt - j * f1) * 0.5F;
      }
      for (float f2 = 0.0F;; f2 = (paramInt - k * f1) * 0.5F)
      {
        this.mDrawMatrix.setScale(f1, f1);
        this.mDrawMatrix.postTranslate(Math.round(f3), Math.round(f2));
        break;
        f1 = paramInt / j;
      }
      label224:
      paramCanvas.save();
      paramCanvas.concat(this.mDrawMatrix);
      this.mDrawable.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private void init()
  {
    this.density = getResources().getDisplayMetrics().density;
    alci.SG((int)(this.density * 4.0F));
    this.mDrawable = new ColorDrawable(-16777216);
  }
  
  public static void lN(List<alci> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ((alci)paramList.get(i)).reset();
      i += 1;
    }
  }
  
  private void m(Rect paramRect)
  {
    float f1 = this.drB * 0.5F;
    if ((paramRect.left < 0) || (paramRect.top < 0) || (paramRect.height() < f1) || (paramRect.width() < f1) || ((paramRect.width() < this.drB) && (paramRect.height() < this.drB)) || (paramRect.height() * paramRect.width() < this.drB * this.drB)) {}
    boolean bool;
    label170:
    int j;
    Object localObject;
    int i;
    int k;
    do
    {
      do
      {
        return;
        if (QLog.isDebugVersion()) {
          QLog.i("TagCloudView", 4, "fillWithTags rect:" + paramRect);
        }
        if (((paramRect.width() >= this.drB * 4) || (paramRect.height() >= this.drB * 4)) && (paramRect.width() > this.drB) && (paramRect.height() > this.drB)) {
          break;
        }
        bool = true;
        j = a(paramRect);
      } while (j < 0);
      localObject = (alci)this.Ay.get(j);
      i = (int)(((alci)localObject).Hr() * 0.8F);
      k = (int)(((alci)localObject).Hs() * 0.8F);
    } while (i * k <= 0);
    if ((i <= paramRect.width()) && (k <= paramRect.height())) {
      if (bool) {
        break label702;
      }
    }
    label434:
    label702:
    for (f1 = this.mRandom.nextFloat() * 0.45F + 0.5F;; f1 = 0.8F)
    {
      i = (int)(((alci)localObject).Hr() * f1);
      k = (int)(((alci)localObject).Hs() * f1);
      this.EP.add(new a(j, f1, paramRect.left, paramRect.top));
      localObject = new Rect(i + paramRect.left, paramRect.top, paramRect.right, paramRect.top + k);
      paramRect = new Rect(paramRect.left, k + paramRect.top, paramRect.right, paramRect.bottom);
      m((Rect)localObject);
      m(paramRect);
      return;
      bool = false;
      break label170;
      f1 = paramRect.width() / ((alci)localObject).Hr();
      float f2 = paramRect.height() / ((alci)localObject).Hs();
      int m;
      if (f1 < f2)
      {
        i = 1;
        if (i == 0) {
          break label664;
        }
        m = (int)(((alci)localObject).Hr() * f1 + 0.5F);
        int n = (int)(((alci)localObject).Hs() * f1 + 0.5F);
        k = Math.max(paramRect.width() / m, paramRect.height() / k);
        if (k > 30)
        {
          QLog.i("TagCloudView", 1, "fillWithTags WARNING!!! " + k + " w:" + paramRect.width() + " h:" + paramRect.height() + " tagW:" + ((alci)localObject).Hr() + " tagH:" + ((alci)localObject).Hr() + " small:" + bool);
          if (bool) {
            break;
          }
        }
        localObject = new Rect();
        if (i == 0) {
          break label669;
        }
        ((Rect)localObject).set(paramRect.left, paramRect.top + n, paramRect.right, paramRect.bottom);
        m((Rect)localObject);
      }
      for (;;)
      {
        this.EP.add(new a(j, f1, paramRect.left, paramRect.top));
        return;
        i = 0;
        break;
        f1 = f2;
        break label434;
        ((Rect)localObject).set(paramRect.left + m, paramRect.top, paramRect.right, paramRect.bottom);
        m((Rect)localObject);
      }
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.o != null) && (this.o.isStateful())) {
      cnB();
    }
  }
  
  public int getColor()
  {
    return this.mCurTextColor;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("TagCloudView", 4, "onDraw");
    }
    if (this.a != null) {
      if ((this.fO == null) || ((this.cwa) && ((this.fO.getWidth() != getMeasuredWidth()) || (this.fO.getHeight() != getMeasuredHeight())))) {
        if (this.fO != null)
        {
          this.fO.recycle();
          this.fO = null;
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      int m;
      Object localObject3;
      Object localObject4;
      try
      {
        this.fO = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_4444);
        if (this.fO == null) {
          break label1387;
        }
        Canvas localCanvas = new Canvas(this.fO);
        localObject2 = new Point(0, 0);
        m = getPaddingLeft();
        localObject3 = new ArrayList();
        ((List)localObject3).addAll(this.Ay);
        i = 0;
        if (i >= ((List)localObject3).size()) {
          break label1066;
        }
        localObject4 = (alci)((List)localObject3).get(i);
        if ((!((alci)localObject4).bTQ) && (((alci)localObject4).valid())) {
          break label255;
        }
        i += 1;
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("TagCloudView", 2, localOutOfMemoryError.getMessage());
        continue;
      }
      Object localObject1 = new Canvas(this.fO);
      ((Canvas)localObject1).drawColor(0, PorterDuff.Mode.CLEAR);
      continue;
      label255:
      Object localObject5 = ((alci)localObject4).e;
      Point localPoint1 = ((alci)localObject4).n;
      Point localPoint2 = ((alci)localObject4).o;
      if (((alci)localObject4).bgColor != 0)
      {
        ((Canvas)localObject1).save();
        ((Canvas)localObject1).clipRect(localPoint1.x + m, localPoint1.y, localPoint1.x + localPoint2.x + m, localPoint1.y + localPoint2.y);
        ((Canvas)localObject1).translate(localPoint1.x + m, localPoint1.y);
        ((Canvas)localObject1).scale(((alci)localObject4).scale, ((alci)localObject4).scale);
        ((Canvas)localObject1).drawColor(((alci)localObject4).bgColor);
        ((Canvas)localObject1).restore();
      }
      ((Point)localObject2).set(0, 0);
      int k = alci.drx;
      int j;
      if (((alci)localObject4).mode == 2)
      {
        ((Canvas)localObject1).save();
        if (((alci)localObject4).cvY)
        {
          boolean bool = ((alci)localObject4).cvX;
          j = localPoint2.y - k * 2;
          if (bool)
          {
            ((Point)localObject2).set(j + k + k, k);
            ((Canvas)localObject1).translate(localPoint1.x + k + m, k + localPoint1.y);
            label482:
            if (this.mDrawable != null) {
              e((Canvas)localObject1, j);
            }
            ((Canvas)localObject1).restore();
            label501:
            if ((((alci)localObject4).mode != 0) && (!((alci)localObject4).bTQ)) {
              break label969;
            }
            ((TextPaint)localObject5).setColor(this.mCurTextColor);
            if (!((alci)localObject4).bTQ) {
              break label962;
            }
            j = 64;
            label537:
            ((TextPaint)localObject5).setAlpha(j);
            j = 0;
            label545:
            ((TextPaint)localObject5).setFakeBoldText(((alci)localObject4).bold);
            ((Canvas)localObject1).save();
            ((Canvas)localObject1).translate(((Point)localObject2).x + localPoint1.x + m, ((Point)localObject2).y + localPoint1.y - (((alci)localObject4).scale * ((alci)localObject4).drw + 0.5F));
            if (!((alci)localObject4).cvY) {
              break label988;
            }
            ((Canvas)localObject1).scale(((alci)localObject4).scale, ((alci)localObject4).scale);
            ((alci)localObject4).layout.draw((Canvas)localObject1);
          }
        }
      }
      for (;;)
      {
        ((Canvas)localObject1).restore();
        if ((j == 0) || (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime()))) {
          break;
        }
        ((Canvas)localObject1).save();
        j = localPoint1.x;
        k = localPoint1.y;
        int n = localPoint1.x;
        int i1 = localPoint2.x;
        int i2 = localPoint1.y;
        ((Canvas)localObject1).clipRect(j + m, k, n + i1 + m, localPoint2.y + i2);
        ((Canvas)localObject1).translate(localPoint1.x + m, localPoint1.y);
        ((Canvas)localObject1).scale(((alci)localObject4).scale, ((alci)localObject4).scale);
        ((Canvas)localObject1).drawColor(Color.argb(127, 0, 0, 0));
        ((Canvas)localObject1).restore();
        break;
        ((Point)localObject2).set(k, k);
        ((Canvas)localObject1).translate(localPoint1.x + localPoint2.x - j - k + m, k + localPoint1.y);
        break label482;
        j = localPoint2.x - k * 2;
        if (((alci)localObject4).cvX)
        {
          ((Point)localObject2).set(k, j + k + k);
          ((Canvas)localObject1).translate(localPoint1.x + k + m, k + localPoint1.y);
          break label482;
        }
        ((Point)localObject2).set(k, k);
        ((Canvas)localObject1).translate(localPoint1.x + k + m, localPoint1.y + localPoint2.y - j - k);
        break label482;
        if (((alci)localObject4).mode != 1) {
          break label501;
        }
        ((Point)localObject2).set(k, k);
        break label501;
        label962:
        j = 255;
        break label537;
        label969:
        ((TextPaint)localObject5).setColor(-1);
        ((TextPaint)localObject5).setAlpha(255);
        j = 1;
        break label545;
        label988:
        ((Canvas)localObject1).scale(((alci)localObject4).scale, ((alci)localObject4).scale);
        k = 0;
        while (k < ((alci)localObject4).EO.size())
        {
          localObject5 = (Layout)((alci)localObject4).EO.get(k);
          ((Layout)localObject5).draw((Canvas)localObject1);
          ((Canvas)localObject1).translate(((Layout)localObject5).getWidth(), 0.0F);
          k += 1;
        }
      }
      label1066:
      int i = 0;
      if (i < this.EP.size())
      {
        localObject3 = (a)this.EP.get(i);
        localObject2 = (alci)this.Ay.get(((a)localObject3).index);
        localObject4 = ((alci)localObject2).e;
        ((TextPaint)localObject4).setColor(this.mCurTextColor);
        ((TextPaint)localObject4).setAlpha(64);
        ((TextPaint)localObject4).setFakeBoldText(false);
        localObject4 = new Point(((a)localObject3).drC, ((a)localObject3).drD);
        ((Canvas)localObject1).save();
        ((Canvas)localObject1).translate(((Point)localObject4).x + m, ((Point)localObject4).y - ((alci)localObject2).drw * ((a)localObject3).scale);
        ((Canvas)localObject1).scale(((a)localObject3).scale, ((a)localObject3).scale);
        if (((alci)localObject2).cvY) {
          ((alci)localObject2).layout.draw((Canvas)localObject1);
        }
        for (;;)
        {
          ((Canvas)localObject1).restore();
          i += 1;
          break;
          j = 0;
          while (j < ((alci)localObject2).EO.size())
          {
            localObject3 = (Layout)((alci)localObject2).EO.get(j);
            ((Layout)localObject3).draw((Canvas)localObject1);
            ((Canvas)localObject1).translate(((Layout)localObject3).getWidth(), 0.0F);
            j += 1;
          }
        }
      }
      localObject1 = new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight());
      if ((this.a != null) && (this.fO != null)) {
        paramCanvas.drawBitmap(this.fO, (Rect)localObject1, (Rect)localObject1, this.mPaint);
      }
      if ((this.cwa) && (this.a != null)) {
        this.a.ac(this.fO);
      }
      this.cwa = false;
      return;
      label1387:
      localObject1 = paramCanvas;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("TagCloudView", 2, "onMeasure, wSpec:" + i + " hSize:" + k);
    }
    paramInt2 = i;
    if (m == 0) {
      paramInt2 = 2147483647;
    }
    i = paramInt2 - (getPaddingLeft() + getPaddingRight());
    if (this.drA == paramInt1)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      if (QLog.isColorLevel()) {
        QLog.i("TagCloudView", 2, "onMeasure, use cache return.");
      }
      return;
    }
    this.drA = paramInt1;
    this.cwa = true;
    lN(this.Ay);
    this.EP.clear();
    paramInt2 = a(View.MeasureSpec.makeMeasureSpec(i, m), 0, this.Ay, this.mMinHeight);
    paramInt1 = paramInt2;
    if (paramInt2 < this.mMinHeight) {
      paramInt1 = this.mMinHeight;
    }
    Collections.sort(this.Ay, new d(this.mRandom, (int)(i * 0.7F), (int)(this.mMinHeight * 0.7F)));
    paramInt2 = aG(i, paramInt1);
    if (j == 1073741824) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TagCloudView", 2, "onMeasure, setDimension w:" + i + " h:" + paramInt1);
      }
      setMeasuredDimension(getPaddingRight() + i + getPaddingRight(), paramInt1);
      return;
      paramInt1 = paramInt2;
      if (j == -2147483648)
      {
        paramInt1 = paramInt2;
        if (k > 0) {
          paramInt1 = Math.min(k, paramInt2);
        }
      }
    }
  }
  
  public void setMaxEms(int paramInt)
  {
    this.dry = paramInt;
  }
  
  public void setMinHeight(int paramInt)
  {
    this.mMinHeight = paramInt;
  }
  
  public void setOnUpdateDrawingListener(b paramb)
  {
    if (paramb != this.a)
    {
      this.a = paramb;
      if (paramb != null) {
        break label46;
      }
      this.cwa = false;
      if (this.fO != null)
      {
        this.fO.recycle();
        this.fO = null;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      label46:
      this.cwa = true;
    }
  }
  
  public void setTagIcon(Drawable paramDrawable)
  {
    if (this.mDrawable != paramDrawable)
    {
      if (this.mDrawable != null)
      {
        this.mDrawable.setCallback(null);
        unscheduleDrawable(this.mDrawable);
      }
      this.mDrawable = paramDrawable;
      if (paramDrawable != null) {
        paramDrawable.setCallback(this);
      }
      invalidate();
    }
  }
  
  public void setTags(List<alci> paramList)
  {
    this.drA = drz;
    this.Ay.clear();
    this.EP.clear();
    this.Ay.addAll(paramList);
    requestLayout();
    invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.o = ColorStateList.valueOf(paramInt);
    cnB();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    this.o = paramColorStateList;
    cnB();
  }
  
  public void setThreshold(int paramInt)
  {
    this.drB = paramInt;
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (this.Ay != null)
    {
      Iterator localIterator = this.Ay.iterator();
      while (localIterator.hasNext())
      {
        alci localalci = (alci)localIterator.next();
        if ((localalci != null) && (localalci.e != null)) {
          localalci.e.setTypeface(paramTypeface);
        }
      }
      invalidate();
    }
  }
  
  static class a
  {
    int drC;
    int drD;
    int index;
    float scale;
    
    public a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
    {
      this.index = paramInt1;
      this.scale = paramFloat;
      this.drC = paramInt2;
      this.drD = paramInt3;
    }
    
    public String toString()
    {
      return super.toString();
    }
  }
  
  public static abstract interface b
  {
    public abstract void ac(Bitmap paramBitmap);
  }
  
  class c
    implements Comparator<Rect>
  {
    Point p;
    
    public c(Point paramPoint)
    {
      this.p = paramPoint;
    }
    
    public int a(Rect paramRect1, Rect paramRect2)
    {
      paramRect1 = new Point((int)(paramRect1.width() * 0.5F + paramRect1.left), (int)(paramRect1.height() * 0.5F + paramRect1.top));
      paramRect2 = new Point((int)(paramRect2.width() * 0.5F + paramRect2.left), (int)(paramRect2.height() * 0.5F + paramRect2.top));
      return TagCloudView.c(paramRect1, this.p) - TagCloudView.c(paramRect2, this.p);
    }
  }
  
  class d
    implements Comparator<alci>
  {
    Random mRandom;
    int minHeight;
    int minWidth;
    
    public d(Random paramRandom, int paramInt1, int paramInt2)
    {
      this.mRandom = paramRandom;
      this.minHeight = paramInt2;
      this.minWidth = paramInt1;
    }
    
    public int a(alci paramalci1, alci paramalci2)
    {
      if ((paramalci1.o.y > this.minHeight) || (paramalci2.o.y > this.minHeight)) {
        return -(paramalci1.o.y - paramalci2.o.y);
      }
      if ((paramalci1.o.x > this.minWidth) || (paramalci2.o.x > this.minWidth)) {
        return -(paramalci1.o.x - paramalci2.o.x);
      }
      return this.mRandom.nextInt(3) - 2;
    }
  }
  
  class e
    implements Comparator<alci>
  {
    Point p;
    
    public e(Point paramPoint)
    {
      this.p = paramPoint;
    }
    
    public int a(alci paramalci1, alci paramalci2)
    {
      return TagCloudView.c(paramalci1.c(), this.p) - TagCloudView.c(paramalci2.c(), this.p);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.TagCloudView
 * JD-Core Version:    0.7.0.1
 */