import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class mdy
  implements View.OnClickListener
{
  mdy(mdx parammdx, boolean paramBoolean, skj paramskj, String paramString, int paramInt1, int paramInt2, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    Object localObject;
    if ((this.ame) && (this.d != null))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("from", String.valueOf(16));
      ((Bundle)localObject).putString("redpackid", this.agm);
      ((Bundle)localObject).putInt("redpack_type", this.aQC);
      ((Bundle)localObject).putInt("plat_source", this.aQD);
      ((Bundle)localObject).putBoolean("open_readinjoy_tab", true);
      this.d.i(127, (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      awit.acy(1);
      awit.bP(true);
      awit.Xg(true);
      localObject = this.val$parent.getContext();
      Intent localIntent = kgw.a((Context)localObject, 16);
      localIntent.putExtra("redpackid", this.agm);
      localIntent.putExtra("redpack_type", this.aQC);
      localIntent.putExtra("plat_source", this.aQD);
      ((Context)localObject).startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mdy
 * JD-Core Version:    0.7.0.1
 */