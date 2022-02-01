import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqzr
  implements RadioGroup.OnCheckedChangeListener
{
  aqzr(aqzl paramaqzl) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.this$0.jdField_a_of_type_Arct != null) && (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Arct.czA))) {
      this.this$0.jdField_a_of_type_Arct.callSwitchChannelJs(paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      TouchWebView localTouchWebView = this.this$0.jdField_a_of_type_Arcd.a();
      if (localTouchWebView != null)
      {
        String str2 = localTouchWebView.getUrl();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (this.this$0.intent != null) {
            str1 = this.this$0.intent.getStringExtra("url");
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          localTouchWebView.loadUrl(str1.replaceAll("(?<=[?&])subIndex=[^&]*", "subIndex=" + paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzr
 * JD-Core Version:    0.7.0.1
 */