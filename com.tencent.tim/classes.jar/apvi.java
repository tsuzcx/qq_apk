import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class apvi
  extends auvd
{
  protected final int dXp;
  protected final int[] fA;
  protected final int[] fy;
  protected final int[] fz;
  protected final int[] oO;
  
  public apvi(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.oO = paramArrayOfInt1;
    this.dXp = paramInt3;
    this.fA = paramArrayOfInt2;
    this.fy = paramArrayOfInt3;
    this.fz = paramArrayOfInt4;
  }
  
  public View a(int paramInt, Object paramObject, auvd.b paramb, View.OnClickListener paramOnClickListener)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length != 2) || (!(paramObject[1] instanceof apbr))) {
        break label229;
      }
    }
    label90:
    label229:
    for (apbr localapbr = (apbr)paramObject[1];; localapbr = null)
    {
      localObject1 = localObject2;
      if (paramb != null)
      {
        localObject1 = localObject2;
        if (paramb.dOe >= 0)
        {
          localObject1 = localObject2;
          if (paramb.dOf >= 0)
          {
            if (localapbr != null) {
              break label90;
            }
            localObject1 = localObject2;
          }
        }
      }
      do
      {
        return localObject1;
        paramObject = localObject3;
        if ((paramb.LA instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)paramb.LA;
        }
        localObject1 = paramObject;
      } while (paramObject == null);
      paramInt = this.fy[paramb.dOf];
      int i = this.fz[paramb.dOf];
      int j = this.fA[paramb.dOf];
      paramObject.setVisibility(0);
      paramObject.setText(paramObject.getContext().getResources().getString(paramInt));
      paramObject.setBackgroundResource(i);
      paramObject.setId(j);
      paramObject.setTag(localapbr);
      paramObject.setContentDescription(paramObject.getResources().getString(paramInt));
      paramObject.setOnClickListener(paramOnClickListener);
      paramb.euH = this.oO[paramb.dOe];
      paramb.euI = this.dXp;
      return paramObject;
    }
  }
  
  public View a(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.oO[paramInt], this.dXp));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apvi
 * JD-Core Version:    0.7.0.1
 */