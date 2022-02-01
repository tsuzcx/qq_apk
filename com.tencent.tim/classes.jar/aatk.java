import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.activity.richmedia.subtitles.BarrageParcelItem;
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

public class aatk
  extends aatn
{
  private LinkedList<Integer> G = new LinkedList();
  private int MARGIN_TOP = 136;
  private aaud a;
  private float[] aQ;
  private aaud b;
  private aaud c;
  private final int cjP = 4;
  private int cjQ = 150;
  private int cjR = 92;
  private int cjS = 5;
  private int cjT = 15;
  private int cjU = 25;
  private int cjV = 6;
  private aaud d;
  private Map<Long, ArrayList<aatm>> iI = new HashMap();
  private Map<Integer, LinkedList<aatm>> iJ = new HashMap();
  private Random mRandom = new Random();
  private Typeface mTypeface;
  private ArrayList<Float> sg = new ArrayList();
  private ArrayList<Integer> sh = new ArrayList();
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString, ArrayList<aatm> paramArrayList, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2)
  {
    LinkedList localLinkedList2 = (LinkedList)this.iJ.get(Integer.valueOf(paramInt2));
    LinkedList localLinkedList1 = localLinkedList2;
    if (localLinkedList2 == null)
    {
      localLinkedList1 = new LinkedList();
      this.iJ.put(Integer.valueOf(paramInt2), localLinkedList1);
    }
    float f1 = p(paramInt2);
    float f2 = (int)a(true);
    paramString = new aatm(paramLong1, L(paramLong2), aP(), aQ(), paramFloat2, Xm(), paramString, paramFloat1, paramInt1, f2, f1, -1.0F, this.cjR, this.cjS, this.mTypeface);
    paramArrayList.add(paramString);
    localLinkedList1.add(paramString);
  }
  
  private byte[] a(ArrayList<BarrageParcelItem> paramArrayList)
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
    if ((this.aQ != null) && (i >= 0) && (i < this.aQ.length)) {
      return this.aQ[i] * ze() / 1000.0F;
    }
    return (i + this.cjU) * this.cjT * ze() / 1000.0F;
  }
  
  private ArrayList<BarrageParcelItem> b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      Parcel localParcel = Parcel.obtain();
      localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      localParcel.setDataPosition(0);
      paramArrayOfByte = new ArrayList();
      localParcel.readTypedList(paramArrayOfByte, BarrageParcelItem.CREATOR);
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
  
  private int zc()
  {
    if ((this.sh == null) || (this.sh.size() == 0)) {
      return 0;
    }
    if (this.c == null) {
      this.c = new aaud(this.sh.size(), 1);
    }
    int i = this.c.nextInt();
    return ((Integer)this.sh.get(i)).intValue() | 0xFF000000;
  }
  
  private int zd()
  {
    if ((this.sg == null) || (this.sg.size() == 0)) {
      return 0;
    }
    if (this.b == null) {
      this.b = new aaud(this.sg.size(), 2);
    }
    return this.b.nextInt();
  }
  
  public boolean Xk()
  {
    Iterator localIterator1 = this.iI.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((aatm)localIterator2.next()).cyx();
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
    if (paramWordingItem == null) {}
    ArrayList localArrayList;
    int j;
    int m;
    float f1;
    int i1;
    int i3;
    int i2;
    float f2;
    int i4;
    int i;
    int k;
    float f3;
    int n;
    label415:
    label460:
    label611:
    label628:
    label637:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "barrage setText id：" + paramWordingItem.mID + "  text: " + paramWordingItem.beq + " time:" + paramWordingItem.qB + "-" + paramWordingItem.MH);
      }
      localArrayList = b(paramWordingItem.cE);
      localObject = (ArrayList)this.iI.get(Long.valueOf(paramWordingItem.mID));
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.iI.put(Long.valueOf(paramWordingItem.mID), localObject);
      }
      int i5;
      for (;;)
      {
        if ((localArrayList == null) || (localArrayList.size() < 3)) {
          break label415;
        }
        i5 = ((BarrageParcelItem)localArrayList.get(0)).mColor;
        j = ((BarrageParcelItem)localArrayList.get(0)).cjW;
        m = ((BarrageParcelItem)localArrayList.get(0)).cjX;
        f1 = ((BarrageParcelItem)localArrayList.get(0)).mSpeed;
        i1 = ((BarrageParcelItem)localArrayList.get(1)).mColor;
        i3 = ((BarrageParcelItem)localArrayList.get(1)).cjW;
        i2 = ((BarrageParcelItem)localArrayList.get(1)).cjX;
        f2 = ((BarrageParcelItem)localArrayList.get(1)).mSpeed;
        i4 = ((BarrageParcelItem)localArrayList.get(2)).mColor;
        i = ((BarrageParcelItem)localArrayList.get(2)).cjW;
        k = ((BarrageParcelItem)localArrayList.get(2)).cjX;
        f3 = ((BarrageParcelItem)localArrayList.get(2)).mSpeed;
        n = i;
        i = i5;
        if (((ArrayList)localObject).size() <= 0) {
          break label637;
        }
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((aatm)((Iterator)localObject).next()).setText(paramWordingItem.beq);
        }
        break;
        if (QLog.isColorLevel()) {
          QLog.d("BaseAnimDrawer", 2, "item exsit, update ,size：" + ((ArrayList)localObject).size());
        }
      }
      if (this.a == null) {
        this.a = new aaud(4, 2);
      }
      j = fO(0);
      int i6;
      if (j >= 0)
      {
        this.a.Gx(j);
        i = j;
        i1 = zc();
        i6 = zd();
        f1 = aO();
        k = fO(j + 1);
        if (k < 0) {
          break label611;
        }
        this.a.Gx(k);
        m = k;
        j = k;
        k = m;
        i4 = zc();
        i3 = zd();
        f2 = aO();
        k = fO(k + 1);
        if (k < 0) {
          break label628;
        }
        this.a.Gx(k);
      }
      for (;;)
      {
        i5 = zc();
        n = zd();
        f3 = aO();
        i2 = j;
        j = i6;
        m = i;
        i = i1;
        i1 = i4;
        i4 = i5;
        break;
        i = zb();
        j = 0;
        break label460;
        m = zb();
        k = j;
        j = m;
        break label513;
        k = zb();
      }
      a(paramWordingItem.mID, 300L + paramWordingItem.qB, paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, i, ((Float)this.sg.get(j)).floatValue(), m, f1);
      a(paramWordingItem.mID, paramWordingItem.qB + 200L, paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, i1, ((Float)this.sg.get(i3)).floatValue(), i2, f2);
      a(paramWordingItem.mID, paramWordingItem.qB, paramWordingItem.MH, paramWordingItem.beq, (ArrayList)localObject, i4, ((Float)this.sg.get(n)).floatValue(), k, f3);
    } while ((localArrayList == null) || (localArrayList.size() != 0));
    label513:
    Object localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).mColor = i;
    ((BarrageParcelItem)localObject).cjX = m;
    ((BarrageParcelItem)localObject).cjW = j;
    ((BarrageParcelItem)localObject).mSpeed = f1;
    localArrayList.add(localObject);
    localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).mColor = i1;
    ((BarrageParcelItem)localObject).cjX = i2;
    ((BarrageParcelItem)localObject).cjW = i3;
    ((BarrageParcelItem)localObject).mSpeed = f2;
    localArrayList.add(localObject);
    localObject = new BarrageParcelItem();
    ((BarrageParcelItem)localObject).mColor = i4;
    ((BarrageParcelItem)localObject).cjX = k;
    ((BarrageParcelItem)localObject).cjW = n;
    ((BarrageParcelItem)localObject).mSpeed = f3;
    localArrayList.add(localObject);
    paramWordingItem.cE = a(localArrayList);
  }
  
  public boolean a(Canvas paramCanvas, RenderBuffer paramRenderBuffer, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (this.iI.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BaseAnimDrawer", 2, "mID2ItemsMap size is 0.");
      }
      bool2 = false;
      return bool2;
    }
    Iterator localIterator = this.iJ.values().iterator();
    boolean bool1 = false;
    Object localObject1;
    do
    {
      bool2 = bool1;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (LinkedList)localIterator.next();
    } while ((localObject1 == null) || (((LinkedList)localObject1).size() == 0));
    Object localObject2 = ((LinkedList)localObject1).iterator();
    int i = 0;
    label101:
    if (((Iterator)localObject2).hasNext())
    {
      if (((aatm)((Iterator)localObject2).next()).z(2) > paramLong1) {
        break label498;
      }
      i += 1;
    }
    label498:
    for (;;)
    {
      break label101;
      localObject1 = ((LinkedList)localObject1).iterator();
      bool2 = bool1;
      for (;;)
      {
        bool1 = bool2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (aatm)((Iterator)localObject1).next();
        if (((aatm)localObject2).z(2) == paramLong1) {
          ((aatm)localObject2).p(6, a(true));
        }
        int j = 1;
        if ((((aatm)localObject2).q(6) > a(true)) || (((aatm)localObject2).q(6) + ((aatm)localObject2).q(3) < 0.0F) || (((aatm)localObject2).z(2) > paramLong1))
        {
          int k = 0;
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.d("BaseAnimDrawer", 2, "barrage invisible: posx:" + ((aatm)localObject2).q(6) + "  width:" + ((aatm)localObject2).q(3) + "  index:" + ((aatm)localObject2).z(2) + " curindex:" + paramLong1);
            j = k;
          }
        }
        if ((j == 0) && (((aatm)localObject2).q(6) < 0.0F))
        {
          if (i > 1)
          {
            ArrayList localArrayList = (ArrayList)this.iI.get(Long.valueOf(((aatm)localObject2).z(1)));
            if (localArrayList != null)
            {
              localArrayList.remove(localObject2);
              if (localArrayList.size() == 0) {
                this.iI.remove(Long.valueOf(((aatm)localObject2).z(1)));
              }
            }
            ((Iterator)localObject1).remove();
            ((aatm)localObject2).unInit();
            i -= 1;
          }
          else
          {
            ((aatm)localObject2).reset();
          }
        }
        else if (((aatm)localObject2).z(2) <= paramLong1)
        {
          if (!isPause()) {
            ((aatm)localObject2).cyv();
          }
          if (paramCanvas != null) {
            ((aatm)localObject2).draw(paramCanvas);
          }
          if (paramRenderBuffer != null) {
            ((aatm)localObject2).a(paramRenderBuffer);
          }
          bool2 = true;
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
    if (paramContext != null) {}
    for (float f = paramContext.getResources().getDisplayMetrics().density;; f = 1.0F)
    {
      f = f / 2.0F * aP();
      this.sg.add(Float.valueOf(32.0F * f));
      this.sg.add(Float.valueOf(44.0F * f));
      this.sg.add(Float.valueOf(56.0F * f));
      this.sg.add(Float.valueOf(60.0F * f));
      this.sg.add(Float.valueOf(86.0F * f));
      this.sh.add(Integer.valueOf(13405665));
      this.sh.add(Integer.valueOf(5756121));
      this.sh.add(Integer.valueOf(16763139));
      this.cjR = ((int)(this.cjR * f));
      this.MARGIN_TOP = ((int)(this.MARGIN_TOP * f));
      this.cjS = ((int)(this.cjS * f));
      this.cjQ = ((int)(this.cjQ * f));
      this.cjT = ((int)(this.cjT * f));
      f = f * (paramContext.getResources().getDisplayMetrics().widthPixels * 60) / 375.0F;
      this.aQ = new float[] { 1.0F * f, 1.2F * f, 1.4F * f, 1.6F * f, 1.8F * f, f * 2.0F };
      this.mTypeface = b(paramString);
      return;
    }
  }
  
  public void cbt()
  {
    Iterator localIterator1 = this.iI.values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        ((aatm)localIterator2.next()).unInit();
      }
    }
    this.iI.clear();
    this.iJ.clear();
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
 * Qualified Name:     aatk
 * JD-Core Version:    0.7.0.1
 */