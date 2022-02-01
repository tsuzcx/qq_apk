import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

class aabq
  implements AdapterView.OnItemClickListener
{
  aabq(aabn paramaabn) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject4 = null;
    Object localObject1 = aabn.a(this.b).getList();
    aabl localaabl = (aabl)((List)localObject1).get(paramInt);
    if (0L != localaabl.a.skin_permission_state)
    {
      aabl.cfZ = ((aabl)((List)localObject1).get(paramInt)).a.skin_id;
      aabn.a(this.b).notifyDataSetChanged();
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    String str1 = localaabl.a.pop_dialog.dialog_title;
    String str2 = localaabl.a.pop_dialog.dialog_tips;
    Object localObject2 = localaabl.a.pop_dialog.left_tips;
    Object localObject3 = localaabl.a.pop_dialog.right_tips;
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = null;
    }
    localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = null;
    }
    if ((localObject1 == null) && (localObject2 == null)) {
      localObject1 = acfp.m(2131707113);
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = null;
        label193:
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label263;
        }
      }
      for (;;)
      {
        localObject1 = aqha.a(aabn.a(this.b), 230, str1, str2, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)localObject4, (DialogInterface.OnClickListener)localObject3);
        ((Dialog)localObject1).setCancelable(false);
        ((Dialog)localObject1).setCanceledOnTouchOutside(false);
        ((Dialog)localObject1).show();
        break;
        localObject3 = new aabr(this, localaabl);
        break label193;
        label263:
        localObject4 = new aabs(this, localaabl);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabq
 * JD-Core Version:    0.7.0.1
 */