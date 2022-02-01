import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;

public class axqc
  extends axpw
{
  public axqc(Object paramObject)
  {
    super(paramObject);
  }
  
  public void A(Activity paramActivity, int paramInt)
  {
    super.A(paramActivity, paramInt);
    ayva localayva = ayva.a();
    axqc localaxqc = localayva.a[paramInt];
    if ((localaxqc != null) && (localaxqc.getUniqueId().equals(getUniqueId()))) {
      localayva.a(null, paramActivity, paramInt);
    }
  }
  
  public void B(Activity paramActivity, int paramInt)
  {
    super.B(paramActivity, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QCombo", 2, "select " + toString());
    }
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.target;
    ayva.a().a(localQIMFilterCategoryItem, paramActivity, paramInt);
    ((axpr)axov.a(5)).a[paramInt].c(this);
  }
  
  public int b(Activity paramActivity, int paramInt)
  {
    return super.b(paramActivity, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    return paramObject.hashCode() == hashCode();
  }
  
  public int hashCode()
  {
    return ((QIMFilterCategoryItem)this.target).id.hashCode();
  }
  
  public String toString()
  {
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.target;
    return localQIMFilterCategoryItem.id + localQIMFilterCategoryItem.hashCode() + localQIMFilterCategoryItem.ceV + this.target;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axqc
 * JD-Core Version:    0.7.0.1
 */