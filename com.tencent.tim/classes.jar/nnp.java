import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

final class nnp
  implements auud.b
{
  nnp(Context paramContext, BaseData paramBaseData, AdData paramAdData) {}
  
  public void a(View paramView, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    if ((this.val$context instanceof FastWebActivity)) {
      ((FastWebActivity)this.val$context).b(this.a);
    }
    if (((QQAppInterface)kxm.getAppRuntime() != null) && (paramArrayList != null))
    {
      paramView = "";
      paramInt = 0;
      if (paramInt < paramArrayList.size())
      {
        paramObject = (DislikeInfo)paramArrayList.get(paramInt);
        if (paramObject == null) {
          break label223;
        }
        paramObject = paramView + paramObject.vf;
        paramView = paramObject;
        if (paramInt != paramArrayList.size() - 1) {
          paramView = paramObject + ",";
        }
      }
    }
    label223:
    for (;;)
    {
      paramInt += 1;
      break;
      jzk.a(new kku.a().a(this.val$context).a(jzk.aEL).b(jzk.a(this.d)).a(kne.a(this.d)).a(paramView).d(jzk.a(this.d)).a());
      QQToast.a(this.val$context, -1, this.val$context.getString(2131701915), 0).show(((BaseActivity)this.val$context).getTitleBarHeight());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nnp
 * JD-Core Version:    0.7.0.1
 */