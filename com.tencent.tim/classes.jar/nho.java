import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class nho
  implements AdapterView.OnItemClickListener
{
  nho(nhn paramnhn, Context paramContext) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    liw.a locala = (liw.a)this.b.getItem(paramInt);
    Object localObject;
    if ((locala != null) && (!TextUtils.isEmpty(locala.jumpUrl)))
    {
      if (!locala.jumpUrl.startsWith("mqq://")) {
        break label178;
      }
      localObject = aqik.c((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.val$context, locala.jumpUrl);
      if (localObject != null) {
        ((aqhv)localObject).ace();
      }
    }
    for (;;)
    {
      localObject = new kxm.b().c().build();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        kbp.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + locala.fansCount, "" + locala.businessId, "", (String)localObject, false);
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label178:
      kxm.aK(nhn.a(this.b), locala.jumpUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nho
 * JD-Core Version:    0.7.0.1
 */