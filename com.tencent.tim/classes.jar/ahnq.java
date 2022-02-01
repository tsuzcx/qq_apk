import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.NearbyHybridFragment;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahnq
  implements AdapterView.OnItemClickListener
{
  public ahnq(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    boolean bool = true;
    ajpu.a locala = (ajpu.a)this.this$0.a.getItem(paramInt);
    Object localObject;
    if (locala.id == 1)
    {
      this.this$0.a(this.this$0.a.a());
      localObject = this.this$0.b.a();
    }
    switch (locala.id)
    {
    default: 
      label100:
      ajrk.a(this.this$0.b, "click_op_button", locala.id);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("nearby.NearbyHybridFragment", 2, "onItemClick:" + locala.name + ", " + locala.jumpUrl);
      }
      if ((locala.dko == 1) && (!TextUtils.isEmpty(locala.packageName)) && (this.this$0.getActivity() != null) && (aqiz.isAppInstalled(this.this$0.getActivity(), locala.packageName)) && (this.this$0.b != null)) {
        if (TextUtils.isEmpty(locala.scheme)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        localObject = new Intent("android.intent.action.VIEW", Uri.parse(locala.scheme));
        ((Intent)localObject).setFlags(268435456);
        BaseApplicationImpl.getContext().startActivity((Intent)localObject);
        if (bool) {
          break;
        }
        this.this$0.a(locala);
      }
      catch (Exception localException)
      {
        QLog.d("nearby.NearbyHybridFragment", 2, "jump to app with scheme Excepyion e = " + localException.getMessage());
        bool = false;
        continue;
      }
      bool = aqiz.r(this.this$0.getActivity(), locala.packageName, this.this$0.b.getCurrentAccountUin());
      continue;
      localException.Ru(39);
      break label100;
      localException.Ru(25);
      break label100;
      localException.Ru(23);
      localException.Ru(26);
      break label100;
      localException.Ru(40);
      break label100;
      if (this.this$0.a == null) {
        break label100;
      }
      this.this$0.a.d(this.this$0.b);
      break label100;
      localException.Ru(41);
      break label100;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahnq
 * JD-Core Version:    0.7.0.1
 */