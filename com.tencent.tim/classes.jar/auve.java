import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.widget.SimpleTextView;

public abstract class auve
  extends auvd
{
  protected final int dXp;
  protected final int[] fA;
  protected final int[] fy;
  protected final int[] fz;
  protected final int[] oO;
  
  public auve(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
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
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = paramObject;
    if (paramb != null)
    {
      localObject1 = paramObject;
      if (paramb.dOe >= 0)
      {
        if (paramb.dOf >= 0) {
          break label35;
        }
        localObject1 = paramObject;
      }
    }
    label35:
    int i;
    int j;
    int k;
    do
    {
      return localObject1;
      paramObject = localObject2;
      if ((paramb.LA instanceof SimpleTextView)) {
        paramObject = (SimpleTextView)paramb.LA;
      }
      i = this.fy[paramb.dOf];
      j = this.fz[paramb.dOf];
      k = this.fA[paramb.dOf];
      localObject1 = paramObject;
    } while (paramObject == null);
    paramObject.setVisibility(0);
    paramObject.setText(paramObject.getContext().getResources().getString(i));
    paramObject.setBackgroundResource(j);
    paramObject.setId(k);
    paramObject.setTag("tag_swip_icon_menu_item");
    paramObject.setTag(-2, Integer.valueOf(i));
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    paramObject.setContentDescription(paramObject.getResources().getString(i));
    paramObject.setOnClickListener(paramOnClickListener);
    paramb.euH = this.oO[paramb.dOe];
    paramb.euI = this.dXp;
    return paramObject;
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
 * Qualified Name:     auve
 * JD-Core Version:    0.7.0.1
 */