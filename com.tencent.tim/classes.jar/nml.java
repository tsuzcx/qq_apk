import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class nml
  implements View.OnClickListener
{
  nml(nmk paramnmk) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ClipboardManager localClipboardManager = (ClipboardManager)paramView.getContext().getSystemService("clipboard");
      String str = this.a.b.aD.getString("id_attribute_text");
      alkw.a(localClipboardManager, str);
      localClipboardManager.setText(str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("WebProteusViewCreator", 1, "showAsDropDown error,msg:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nml
 * JD-Core Version:    0.7.0.1
 */