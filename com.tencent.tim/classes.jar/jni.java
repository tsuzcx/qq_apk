import android.app.Dialog;
import android.view.View;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import java.util.List;

public class jni
  implements AdapterView.c
{
  public jni(PoiMapActivity paramPoiMapActivity, Dialog paramDialog) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PoiMapActivity", 2, "setOnItemClickListener" + paramInt);
    }
    paramAdapterView = (PoiMapActivity.b)this.this$0.mSearchResultList.get(paramInt);
    if (paramAdapterView != null)
    {
      this.this$0.aaH = true;
      this.this$0.a(paramAdapterView);
      this.this$0.report("share_locate", "click_sch_result", "", "", "", "");
    }
    this.n.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jni
 * JD-Core Version:    0.7.0.1
 */