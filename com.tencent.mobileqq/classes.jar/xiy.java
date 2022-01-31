import Wallet.PopDialog;
import Wallet.SkinInfo;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.qwallet.fragment.CommonHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.HbSkinInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.utils.DialogUtil;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.List;

public class xiy
  implements AdapterView.OnItemClickListener
{
  public xiy(CommonHbFragment paramCommonHbFragment) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject2 = null;
    paramAdapterView = CommonHbFragment.a(this.a).getList();
    HbSkinInfo localHbSkinInfo = (HbSkinInfo)paramAdapterView.get(paramInt);
    if (0L != localHbSkinInfo.a.skin_permission_state)
    {
      HbSkinInfo.c = ((HbSkinInfo)paramAdapterView.get(paramInt)).a.skin_id;
      CommonHbFragment.a(this.a).notifyDataSetChanged();
      if (CommonHbFragment.c(this.a))
      {
        if (CommonHbFragment.a(this.a) != null) {
          CommonHbFragment.a(this.a).a(0, 0, true);
        }
        CommonHbFragment.a(this.a, false);
        CommonHbFragment.b(this.a);
      }
      return;
    }
    String str1 = localHbSkinInfo.a.pop_dialog.dialog_title;
    String str2 = localHbSkinInfo.a.pop_dialog.dialog_tips;
    paramView = localHbSkinInfo.a.pop_dialog.left_tips;
    Object localObject1 = localHbSkinInfo.a.pop_dialog.right_tips;
    paramAdapterView = paramView;
    if (TextUtils.isEmpty(paramView)) {
      paramAdapterView = null;
    }
    paramView = (View)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramView = null;
    }
    if ((paramAdapterView == null) && (paramView == null)) {
      paramAdapterView = "确定";
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramAdapterView))
      {
        localObject1 = null;
        if (!TextUtils.isEmpty(paramView)) {
          break label275;
        }
      }
      for (;;)
      {
        paramAdapterView = DialogUtil.a(this.a.getActivity(), 230, str1, str2, paramAdapterView, paramView, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject1);
        paramAdapterView.setCancelable(false);
        paramAdapterView.setCanceledOnTouchOutside(false);
        paramAdapterView.show();
        return;
        localObject1 = new xiz(this, localHbSkinInfo);
        break;
        label275:
        localObject2 = new xja(this, localHbSkinInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xiy
 * JD-Core Version:    0.7.0.1
 */