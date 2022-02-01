import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.ScreenLayoutMultipleGrid.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class jdn
  extends jdl
{
  public static final int axl = l.length;
  public static final int axm = l[(l.length - 1)][0];
  public static final int axn = l[(l.length - 1)].length;
  static final int[] cL;
  static final int[] cM;
  static final int[][] l;
  private volatile ConcurrentHashMap<Long, jfj> aM;
  
  static
  {
    int[] arrayOfInt1 = { 1, 1 };
    int[] arrayOfInt2 = { 1, 2 };
    int[] arrayOfInt3 = { 2, 2 };
    int[] arrayOfInt4 = { 2, 2, 1 };
    int[] arrayOfInt5 = { 2, 2, 2 };
    int[] arrayOfInt6 = { 2, 3, 3 };
    int[] arrayOfInt7 = { 3, 3, 3, 3 };
    int[] arrayOfInt8 = { 3, 3, 3, 4 };
    int[] arrayOfInt9 = { 3, 3, 4, 4 };
    int[] arrayOfInt10 = { 3, 4, 4, 4 };
    int[] arrayOfInt11 = { 4, 4, 4, 4 };
    l = new int[][] { { 1 }, arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, { 2, 2, 3 }, arrayOfInt6, { 3, 3, 3 }, { 3, 3, 2, 2 }, { 3, 3, 3, 2 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11 };
    cL = new int[] { 0, 3, 4, 1, 6, 7, 8, 5, 2 };
    cM = new int[] { 0, 4, 5, 1, 8, 9, 12, 6, 2, 13, 10, 14, 15, 11, 7, 3 };
  }
  
  protected jdn(Context paramContext, VideoAppInterface paramVideoAppInterface)
  {
    super(paramContext, paramVideoAppInterface);
  }
  
  private List<Rect> a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 <= 0) {
      return null;
    }
    int[] arrayOfInt2 = l[(paramInt1 - 1)];
    int i5 = arrayOfInt2.length;
    int i4 = (paramInt3 + 0) / i5 + 0;
    ArrayList localArrayList = new ArrayList();
    int j;
    int i;
    label56:
    int k;
    Object localObject1;
    if (paramInt1 <= 9)
    {
      j = 1;
      if (paramInt1 != 5) {
        break label348;
      }
      i = 1;
      if (i == 0) {
        break label499;
      }
      k = paramInt3 / 10;
      localObject1 = new int[] { 0, k * 3, k * 6 };
    }
    for (Object localObject2 = { k * 3, k * 3, paramInt3 - k * 6 };; localObject2 = null)
    {
      int[] arrayOfInt1;
      if (j != 0)
      {
        arrayOfInt1 = cL;
        label130:
        if (j == 0) {
          break label362;
        }
        paramInt3 = 3;
        label137:
        if (j == 0) {
          break label367;
        }
        j = 3;
        label145:
        k = 0;
      }
      for (;;)
      {
        if (k >= paramInt3) {
          break label401;
        }
        int m;
        label166:
        int n;
        int i2;
        label199:
        Object localObject3;
        int i6;
        if (i != 0)
        {
          m = localObject1[k];
          int i1 = 0;
          n = 0;
          if (k < i5)
          {
            i1 = arrayOfInt2[k];
            n = (paramInt2 + 0) / i1 + 0;
          }
          i2 = 0;
          if (i2 >= j) {
            break label392;
          }
          Object localObject4 = null;
          localObject3 = localObject4;
          if (i1 > 0)
          {
            localObject3 = localObject4;
            if (i2 < i1)
            {
              i6 = i2 * (n + 0);
              if (i == 0) {
                break label385;
              }
            }
          }
        }
        label385:
        for (int i3 = localObject2[k];; i3 = i4)
        {
          localObject3 = new Rect(i6, m, i6 + n, i3 + m);
          if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, creat rect: [" + k + "|" + i2 + "] :" + localObject3);
          }
          localArrayList.add(localObject3);
          i2 += 1;
          break label199;
          j = 0;
          break;
          label348:
          i = 0;
          break label56;
          arrayOfInt1 = cM;
          break label130;
          label362:
          paramInt3 = 4;
          break label137;
          label367:
          j = 4;
          break label145;
          m = (i4 + 0) * k;
          break label166;
        }
        label392:
        k += 1;
      }
      label401:
      localObject1 = new ArrayList();
      paramInt2 = 0;
      if (paramInt2 < paramInt1)
      {
        paramInt3 = arrayOfInt1[paramInt2];
        localObject2 = (Rect)localArrayList.get(paramInt3);
        if (localObject2 != null) {
          ((ArrayList)localObject1).add(localObject2);
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          if (QLog.isDevelopLevel()) {
            QLog.w("ScreenLayoutMultipleGrid", 1, "getViewRects, sort rect has wrong: " + paramInt2 + "|" + paramInt3);
          }
        }
      }
      return localObject1;
      label499:
      localObject1 = null;
    }
  }
  
  public void a(int paramInt, Rect paramRect1, Rect paramRect2, ConcurrentHashMap<Long, jfj> paramConcurrentHashMap)
  {
    this.aM = paramConcurrentHashMap;
  }
  
  public void a(iiv paramiiv, izm[] paramArrayOfizm, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
  {
    if (this.mContext == null) {
      return;
    }
    paramInt3 = Math.min(paramiiv.jdField_if.size(), paramArrayOfizm.length);
    label35:
    float f1;
    float f2;
    if (paramInt3 > axl)
    {
      paramInt3 = axl;
      if ((paramInt3 >= 2) && (jll.cH(1))) {
        ThreadManager.getUIHandler().post(new ScreenLayoutMultipleGrid.1(this));
      }
      paramiiv = a(paramInt3, paramInt1, paramInt2);
      f1 = jll.dp2px(this.mContext, 12.0F);
      f2 = jll.dp2px(this.mContext, 18.0F);
      paramInt2 = 0;
      label98:
      if (paramInt2 < paramInt3)
      {
        Object localObject = (Rect)paramiiv.get(paramInt2);
        if (localObject == null) {
          break label356;
        }
        paramArrayOfizm[paramInt2].layout(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).right, ((Rect)localObject).bottom);
        paramArrayOfizm[paramInt2].setPaddings(0, 0, 0, 0);
        long l1 = AudioHelper.stringToLong(paramArrayOfizm[paramInt2].getUin());
        long l2 = paramArrayOfizm[paramInt2].getVideoSrcType();
        if ((TextUtils.isEmpty(paramArrayOfizm[paramInt2].getText())) && (l1 != 0L)) {
          paramArrayOfizm[paramInt2].setText(String.valueOf(l1));
        }
        if (l1 != 0L)
        {
          localObject = (jfj)this.aM.get(Long.valueOf(l1));
          if (localObject != null)
          {
            if (!((jfj)localObject).xc()) {
              break label320;
            }
            paramInt1 = 1;
            label254:
            if (paramInt1 != 0) {
              break label389;
            }
            if ((!((jfj)localObject).isSpeaking()) || (l2 == 2L)) {
              break label325;
            }
            paramInt1 = 2;
          }
        }
      }
    }
    label389:
    for (;;)
    {
      label277:
      paramArrayOfizm[paramInt2].ms(paramInt1);
      if (paramInt3 == 1)
      {
        paramArrayOfizm[paramInt2].jL(false);
        paramArrayOfizm[paramInt2].setTextSize(f2);
      }
      for (;;)
      {
        paramInt2 += 1;
        break label98;
        break;
        break label35;
        label320:
        paramInt1 = 0;
        break label254;
        label325:
        paramInt1 = 3;
        break label277;
        if (paramInt3 >= 2)
        {
          paramArrayOfizm[paramInt2].jL(true);
          paramArrayOfizm[paramInt2].setTextSize(f1);
        }
      }
      label356:
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("ScreenLayoutMultipleGrid", 1, "layoutMulti, layout rect has wrong: " + paramInt2);
      return;
    }
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ScreenLayoutMultipleGrid", 1, "setSmallVideoViewLayout, wrong call！ " + new Throwable());
    }
  }
  
  public void a(izm[] paramArrayOfizm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ScreenLayoutMultipleGrid", 1, "layoutCommon, wrong call！ " + new Throwable());
    }
    paramArrayOfizm[0].setPaddings(0, 0, 0, 0);
    paramArrayOfizm[0].layout(0, 0, paramInt1, paramInt2);
    paramArrayOfizm[0].setBackgroundColor(-15197410);
    paramArrayOfizm[1].setPaddings(3, 3, 3, 3);
    paramArrayOfizm[1].setBackgroundColor(-15197410);
    a(paramArrayOfizm, paramInt3, paramInt1, paramInt2, paramInt4, paramInt5);
  }
  
  public int getStyle()
  {
    return 3;
  }
  
  public boolean wD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jdn
 * JD-Core Version:    0.7.0.1
 */