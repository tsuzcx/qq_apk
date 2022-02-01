import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public abstract class amjh<T extends View>
{
  public long aiL;
  protected int bms;
  
  public amjh(int paramInt)
  {
    this.bms = paramInt;
  }
  
  public static amjh a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    case 2: 
    case 4: 
    case 5: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("BaseSearchEntryModel", 2, "createSearchEntryModel, modelType = " + paramInt1 + ", tabType = " + paramInt2);
      }
    case 1: 
      return null;
    case 0: 
      return new amjp(paramInt2);
    case 3: 
      return new amji(paramInt2, paramBoolean);
    }
    return new amkn(paramInt2);
  }
  
  public abstract T a(Context paramContext, QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, Bundle paramBundle);
  
  public void a(amrb paramamrb) {}
  
  public void b(amrb paramamrb) {}
  
  public void initData() {}
  
  public void onDestroyView() {}
  
  public void refresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amjh
 * JD-Core Version:    0.7.0.1
 */