import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.PacmanParcelItem;
import com.tencent.mobileqq.activity.richmedia.subtitles.WordingItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class aaua
  extends aatn
{
  private LinkedList<aatr> H = new LinkedList();
  private int MARGIN_TOP = 136;
  private aaud a;
  private float[] aR;
  private final int cjP = 4;
  private int cjR = 102;
  private int cjT = 30;
  private int cjU = 25;
  private int cjV = 6;
  private int cku = 150;
  private aaud d;
  private aaud e;
  private Bitmap ew;
  private Bitmap ex;
  private Map<Long, ArrayList<aauc>> iI = new HashMap();
  private Map<Integer, LinkedList<aauc>> iJ = new HashMap();
  private Random mRandom = new Random();
  Typeface mTypeface = null;
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString, ArrayList<aauc> paramArrayList, int paramInt1, int paramInt2, float paramFloat)
  {
    LinkedList localLinkedList = (LinkedList)this.iJ.get(Integer.valueOf(paramInt2));
    if (localLinkedList == null)
    {
      localLinkedList = new LinkedList();
      this.iJ.put(Integer.valueOf(paramInt2), localLinkedList);
    }
    for (;;)
    {
      int i;
      if (paramInt1 >= 0)
      {
        i = paramInt1;
        if (paramInt1 <= this.H.size()) {}
      }
      else
      {
        i = 0;
      }
      aatr localaatr = (aatr)this.H.get(i);
      float f4 = p(paramInt2);
      float f2 = (int)a(true);
      float f1;
      if (localLinkedList.size() == 0) {
        f1 = f2;
      }
      for (;;)
      {
        paramString = new aauc(paramLong1, L(paramLong2), aP(), aQ(), paramFloat, Xm(), paramString, localaatr, f1, f4, this.ew, this.ex, this.mTypeface);
        paramArrayList.add(paramString);
        localLinkedList.add(paramString);
        return;
        aauc localaauc = (aauc)localLinkedList.getLast();
        f1 = localaauc.q(6);
        float f3 = localaauc.q(3) + f1 + this.cku;
        f1 = f2;
        if (f3 > f2) {
          f1 = f3;
        }
      }
    }
  }
  
  private byte[] a(ArrayList<PacmanParcelItem> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.writeTypedList(paramArrayList);
      paramArrayList = localParcel.marshall();
      localParcel.recycle();
      return paramArrayList;
    }
    return null;
  }
  
  private float aO()
  {
    if (this.d == null) {
      this.d = new aaud(this.cjV, 2);
    }
    int i = this.d.nextInt();
    if ((this.aR != null) && (i >= 0) && (i < this.aR.length)) {
      return this.aR[i] * ze() / 1000.0F;
    }
    return (i + this.cjU) * this.cjT * ze() / 1000.0F;
  }
  
  private ArrayList<PacmanParcelItem> b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = new ArrayList();
      localParcel.readTypedList(paramArrayOfByte, PacmanParcelItem.CREATOR);
      if (localParcel != null) {
        localParcel.recycle();
      }
      return paramArrayOfByte;
    }
    return new ArrayList();
  }
  
  private int fO(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < 4) && (this.iJ.size() < 4)) {
      while (paramInt < 4)
      {
        List localList = (List)this.iJ.get(Integer.valueOf(paramInt));
        if ((localList != null) && (localList.size() > 0)) {
          paramInt += 1;
        } else {
          return paramInt;
        }
      }
    }
    return -1;
  }
  
  private int getRandomIndex()
  {
    if ((this.H == null) || (this.H.size() == 0)) {
      return 0;
    }
    if (this.e == null) {
      this.e = new aaud(this.H.size(), 2);
    }
    return this.e.nextInt();
  }
  
  private float p(int paramInt)
  {
    return this.cjR * paramInt + this.MARGIN_TOP;
  }
  
  private int zb()
  {
    if (this.a == null) {
      this.a = new aaud(4, 2);
    }
    return this.a.nextInt();
  }
  
  public boolean Xk()
  {
    Iterator localIterator1 = this.iI.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((aauc)localIterator2.next()).cyx();
      }
    }
    return true;
  }
  
  public boolean Xl()
  {
    apk();
    return true;
  }
  
  public void a(WordingItem paramWordingItem)
  {
    if (paramWordingItem == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseAnimDrawer", 2, "setText ：" + paramWordingItem.beq + " time:" + paramWordingItem.qB + "-" + paramWordingItem.MH);
    }
    ArrayList localArrayList = b(paramWordingItem.cE);
    Object localObject = (ArrayList)this.iI.get(Long.valueOf(paramWordingItem.mID));
    if (localObject == null)
    {
      localObject = new ArrayList();
      this.iI.put(Long.valueOf(paramWordingItem.mID), localObject);
    }
    for (;;)
    {
      int i;
      float f1;
      int m;
      int n;
      float f2;
      int i1;
      int k;
      float f3;
      if ((localArrayList != null) && (localArrayList.size() >= 3))
      {
        i = ((PacmanParcelItem)localArrayList.get(0)).mIndex;
        j = ((PacmanParcelItem)localArrayList.get(0)).cjX;
        f1 = ((PacmanParcelItem)localArrayList.get(0)).mSpeed;
        m = ((PacmanParcelItem)localArrayList.get(1)).mIndex;
        n = ((PacmanParcelItem)localArrayList.get(1)).cjX;
        f2 = ((PacmanParcelItem)localArrayList.get(1)).mSpeed;
        i1 = ((PacmanParcelItem)localArrayList.get(2)).mIndex;
        k = ((PacmanParcelItem)localArrayList.get(2)).cjX;
        f3 = ((PacmanParcelItem)localArrayList.get(2)).mSpeed;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "itemlist size：" + ((ArrayList)localObject).size());
        }
        if (((ArrayList)localObject).size() <= 0) {
          break label544;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((aauc)((Iterator)localObject).next()).setText(paramWordingItem.beq);
        }
        break;
      }
      if (this.a == null) {
        this.a = new aaud(4, 2);
      }
      int j = fO(0);
      if (j >= 0)
      {
        this.a.Gx(j);
        i = j;
        label393:
        i1 = getRandomIndex();
        f1 = aO();
        k = fO(j + 1);
        if (k < 0) {
          break label518;
        }
        this.a.Gx(k);
        m = k;
        j = k;
        k = m;
        label440:
        m = getRandomIndex();
        f2 = aO();
        k = fO(k + 1);
        if (k < 0) {
          break label535;
        }
        this.a.Gx(k);
      }
      for (;;)
      {
        int i2 = getRandomIndex();
        f3 = aO();
        n = j;
        j = i;
        i = i1;
        i1 = i2;
        break;
        i = zb();
        j = 0;
        break label393;
        label518:
        m = zb();
        k = j;
        j = m;
        break label440;
        label535:
        k = zb();
      }
      label544:
      long l1 = paramWordingItem.mID;
      long l2 = paramWordingItem.qB;
      a(l1, this.mRandom.nextInt(300) + l2, paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, i, j, f1);
      a(paramWordingItem.mID, paramWordingItem.qB + this.mRandom.nextInt(200), paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, m, n, f2);
      a(paramWordingItem.mID, paramWordingItem.qB, paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, i1, k, f3);
      if ((localArrayList == null) || (localArrayList.size() != 0)) {
        break;
      }
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).cjX = j;
      ((PacmanParcelItem)localObject).mIndex = i;
      ((PacmanParcelItem)localObject).mSpeed = f1;
      localArrayList.add(localObject);
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).cjX = n;
      ((PacmanParcelItem)localObject).mIndex = m;
      ((PacmanParcelItem)localObject).mSpeed = f2;
      localArrayList.add(localObject);
      localObject = new PacmanParcelItem();
      ((PacmanParcelItem)localObject).cjX = k;
      ((PacmanParcelItem)localObject).mIndex = i1;
      ((PacmanParcelItem)localObject).mSpeed = f3;
      localArrayList.add(localObject);
      paramWordingItem.cE = a(localArrayList);
      return;
    }
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (this.iI.size() == 0)
    {
      bool2 = false;
      return bool2;
    }
    Iterator localIterator1 = this.iJ.values().iterator();
    boolean bool1 = false;
    for (;;)
    {
      bool2 = bool1;
      if (!localIterator1.hasNext()) {
        break;
      }
      LinkedList localLinkedList = (LinkedList)localIterator1.next();
      if ((localLinkedList != null) && (localLinkedList.size() != 0))
      {
        Iterator localIterator2 = localLinkedList.iterator();
        label489:
        while (localIterator2.hasNext())
        {
          aauc localaauc = (aauc)localIterator2.next();
          if ((localaauc.z(2) != paramLong1) || (localLinkedList.size() <= 1)) {}
          int i;
          for (;;)
          {
            i = 1;
            if ((localaauc.q(6) > a(true)) || (localaauc.q(6) + localaauc.q(3) < 0.0F) || (localaauc.z(2) > paramLong1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("BaseAnimDrawer", 2, "invisible: posx:" + localaauc.q(6) + "  width:" + localaauc.q(3) + "  index:" + localaauc.z(2) + " curindex:" + paramLong1);
              }
              i = 0;
            }
            if ((i != 0) || (localaauc.q(6) >= 0.0F)) {
              break label363;
            }
            ArrayList localArrayList = (ArrayList)this.iI.get(Long.valueOf(localaauc.z(1)));
            if (localArrayList != null)
            {
              localArrayList.remove(localaauc);
              if (localArrayList.size() == 0) {
                this.iI.remove(Long.valueOf(localaauc.z(1)));
              }
            }
            localIterator2.remove();
            localaauc.unInit();
            break;
            localaauc.az(a(true));
          }
          label363:
          if (localaauc.z(2) <= paramLong1)
          {
            if (localaauc.mState == 1)
            {
              if (!isPause()) {
                localaauc.ay(-1.0F * localaauc.q(5) / 2.0F);
              }
              bool2 = bool1;
              if (i != 0)
              {
                if (paramCanvas == null) {
                  break label489;
                }
                localaauc.draw(paramCanvas);
              }
              for (;;)
              {
                bool2 = true;
                bool1 = bool2;
                if (i == 0) {
                  break;
                }
                bool1 = bool2;
                if (localaauc.q(6) >= a(true) / 2.0F) {
                  break;
                }
                bool1 = bool2;
                if (localaauc.q(6) <= 0.0F) {
                  break;
                }
                localaauc.mState = 2;
                bool1 = bool2;
                break;
                localaauc.a(paramRenderBuffer);
              }
            }
            if (!isPause()) {
              localaauc.ay(-1.0F * localaauc.q(5) / 2.0F);
            }
            if (i != 0)
            {
              if (paramCanvas != null) {
                localaauc.draw(paramCanvas);
              }
              for (;;)
              {
                bool1 = true;
                break;
                localaauc.a(paramRenderBuffer);
              }
            }
          }
        }
      }
    }
  }
  
  public void apk()
  {
    this.iI.clear();
    this.iJ.clear();
  }
  
  public void bn(Context paramContext, String paramString)
  {
    float f = 1.0F;
    if (paramContext != null) {
      f = paramContext.getResources().getDisplayMetrics().density;
    }
    try
    {
      this.ew = BitmapFactory.decodeResource(paramContext.getResources(), 2130843162);
      this.ex = BitmapFactory.decodeResource(paramContext.getResources(), 2130843163);
      f = f / 2.0F * aP();
      this.H.add(new aatr(28.0F * f, 72.0F * f, 42.0F * f, 10.0F * f, 8.0F * f, 4.0F * f));
      this.H.add(new aatr(34.0F * f, 76.0F * f, 52.0F * f, 10.0F * f, 8.0F * f, 4.0F * f));
      this.H.add(new aatr(38.0F * f, 90.0F * f, 58.0F * f, 10.0F * f, 8.0F * f, 4.0F * f));
      this.H.add(new aatr(48.0F * f, 102.0F * f, 70.0F * f, 10.0F * f, 8.0F * f, 4.0F * f));
      this.cjR = ((int)(this.cjR * f));
      this.MARGIN_TOP = ((int)(this.MARGIN_TOP * f));
      this.cku = ((int)(this.cku * f));
      this.cjT = ((int)(this.cjT * f));
      f = paramContext.getResources().getDisplayMetrics().widthPixels * 60 * f / 375.0F;
      this.aR = new float[] { 0.5F * f, 1.0F * f, 1.5F * f, 2.0F * f, 2.5F * f, f * 3.0F };
      this.mTypeface = b(paramString);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void cbt()
  {
    Iterator localIterator1 = this.iI.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((aauc)localIterator2.next()).unInit();
      }
    }
    this.iI.clear();
    this.iJ.clear();
    this.H.clear();
  }
  
  public int za()
  {
    Iterator localIterator = this.iI.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      if (localList == null) {
        break label54;
      }
      i = localList.size() + i;
    }
    label54:
    for (;;)
    {
      break;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaua
 * JD-Core Version:    0.7.0.1
 */