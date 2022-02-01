import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenCardContainer.e;
import com.tencent.widget.SimpleTextView;

public class arsb
  extends auve
{
  public arsb(OpenCardContainer.e parame, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
  }
  
  public View a(int paramInt, Object paramObject, auvd.b paramb, View.OnClickListener paramOnClickListener)
  {
    paramb = super.a(paramInt, paramObject, paramb, paramOnClickListener);
    if ((paramb instanceof SimpleTextView)) {
      paramb.setTag(paramObject);
    }
    return paramb;
  }
  
  public void a(int paramInt, Object paramObject, auvd.b[] paramArrayOfb)
  {
    paramInt = 0;
    if ((paramArrayOfb == null) || (paramArrayOfb.length <= 0)) {}
    for (;;)
    {
      return;
      if (paramArrayOfb.length < 0)
      {
        paramArrayOfb[0].dOf = 0;
        paramArrayOfb[0].dOe = 0;
        paramInt = 1;
      }
      while (paramInt < paramArrayOfb.length)
      {
        paramArrayOfb[paramInt].dOf = -1;
        paramArrayOfb[paramInt].dOe = -1;
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arsb
 * JD-Core Version:    0.7.0.1
 */