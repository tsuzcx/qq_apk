import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atjt
  extends auve
{
  atjt(atjr paramatjr, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, auvd.b paramb, View.OnClickListener paramOnClickListener)
  {
    paramb = super.a(paramInt, paramObject, paramb, paramOnClickListener);
    if (paramb != null) {
      paramb.setTag(-10, paramObject);
    }
    return paramb;
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    paramInt = 0;
    Object localObject = this.a.a((atiu)paramObject);
    int i = ((List)localObject).size();
    paramObject = localObject;
    if (i > 3)
    {
      paramObject = ((List)localObject).subList(i - 2, i);
      paramObject.add(0, atjr.a);
    }
    i = Math.min(paramObject.size(), 3);
    if (paramInt < paramArrayOfb.length)
    {
      int j;
      if (paramInt < i)
      {
        localObject = (atiw)paramObject.get(paramInt);
        j = this.GU.indexOf(localObject);
        if (j < 0)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 1, "getRightMenuItemInfo error, can not find the menu， menuId[" + ((atiw)localObject).hF() + "]");
          }
          paramArrayOfb[paramInt].dOf = -1;
          paramArrayOfb[paramInt].dOe = -1;
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        paramArrayOfb[paramInt].dOf = j;
        paramArrayOfb[paramInt].dOe = this.ok[j];
        continue;
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atjt
 * JD-Core Version:    0.7.0.1
 */