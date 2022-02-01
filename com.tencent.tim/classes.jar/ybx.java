import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

class ybx
  extends ajqz
{
  ybx(ybt paramybt) {}
  
  public void e(String paramString1, String paramString2, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i(this.this$0.TAG, 4, "onAutoInput, [" + paramString1 + "," + paramString2 + "," + paramObject + "," + System.currentTimeMillis() + "]");
    }
    if (!"tag_nearby_chat".equals(paramString1)) {}
    while ((TextUtils.isEmpty(paramString2)) || (this.this$0.a == null)) {
      return;
    }
    this.this$0.aey();
    this.this$0.a.setText(paramString2);
    this.this$0.a.selectAll();
    this.this$0.aXe = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ybx
 * JD-Core Version:    0.7.0.1
 */