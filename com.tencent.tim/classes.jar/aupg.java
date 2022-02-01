import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

class aupg
  extends auve
{
  aupg(aupf paramaupf, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, List paramList, int[] paramArrayOfInt5)
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
    paramObject = this.a.b(paramObject);
    int i = Math.min(paramObject.size(), 3);
    paramInt = 0;
    if (paramInt < paramArrayOfb.length)
    {
      int j;
      if (paramInt < i)
      {
        atiw localatiw = (atiw)paramObject.get(paramInt);
        j = this.GU.indexOf(localatiw);
        paramArrayOfb[paramInt].dOf = j;
      }
      for (paramArrayOfb[paramInt].dOe = this.ok[j];; paramArrayOfb[paramInt].dOe = -1)
      {
        paramInt += 1;
        break;
        paramArrayOfb[paramInt].dOf = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aupg
 * JD-Core Version:    0.7.0.1
 */