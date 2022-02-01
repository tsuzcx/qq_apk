import android.app.Activity;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axqf
  extends axpw
{
  public axqf(Object paramObject)
  {
    super(paramObject);
  }
  
  public void B(Activity paramActivity, int paramInt)
  {
    super.B(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.target;
    ayva.a().b(localQIMFilterCategoryItem, paramActivity, paramInt);
  }
  
  public int Rs()
  {
    int k = 0;
    Iterator localIterator = this.FV.iterator();
    int i = 0;
    int j = k;
    if (localIterator.hasNext())
    {
      j = ((axpn)localIterator.next()).outState;
      if (j == 2) {
        j = 1;
      }
    }
    else
    {
      if (j == 0) {
        break label67;
      }
      aeE(2);
      return 2;
    }
    if (j == 1) {
      i = 1;
    }
    for (;;)
    {
      break;
      label67:
      if (i != 0)
      {
        aeE(2);
        return 1;
      }
      aeE(3);
      return 3;
    }
  }
  
  public boolean aPw()
  {
    Iterator localIterator = this.FV.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (axpn)localIterator.next();
      if ((localObject instanceof axpp))
      {
        localObject = ((axpp)localObject).d;
        if ((localObject != null) && (((FilterDesc)localObject).predownload == 0)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "apply " + toString());
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.FV.iterator();
    while (((Iterator)localObject).hasNext())
    {
      axpn localaxpn = (axpn)((Iterator)localObject).next();
      if ((localaxpn instanceof axpp)) {
        localArrayList.add(((axpp)localaxpn).d);
      }
    }
    ((axpr)axov.a(5)).a[paramInt].a(this);
    localObject = (QIMFilterCategoryItem)this.target;
    ayva.a().a((QIMFilterCategoryItem)localObject, paramInt);
    if ((QLog.isColorLevel()) && (localObject != null)) {
      QLog.i("QCombo", 2, "setApplyedFilterGroup" + ((QIMFilterCategoryItem)localObject).name);
    }
    axpp.a(paramActivity, localArrayList, this, paramInt);
    return 0;
  }
  
  public String toString()
  {
    return "Filter" + this.target;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqf
 * JD-Core Version:    0.7.0.1
 */