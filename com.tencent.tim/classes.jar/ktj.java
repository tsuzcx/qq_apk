import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;

class ktj
  implements ausj.a
{
  ktj(kte paramkte, ausj paramausj, int[] paramArrayOfInt, Context paramContext) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.D.dismiss();
    if ((paramInt < 0) || (paramInt >= this.de.length)) {
      return;
    }
    paramView = this.val$context.getString(this.de[paramInt]);
    aqju localaqju = new aqju(this.val$context, 2131756467);
    localaqju.setContentView(2131559127);
    ViewGroup.LayoutParams localLayoutParams = localaqju.getMessageTextView().getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).leftMargin = aqnm.dip2px(12.0F);
      ((ViewGroup.MarginLayoutParams)localLayoutParams).rightMargin = aqnm.dip2px(12.0F);
      localaqju.getMessageTextView().setLayoutParams(localLayoutParams);
    }
    localaqju.setTag(paramView);
    localaqju.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ktj
 * JD-Core Version:    0.7.0.1
 */