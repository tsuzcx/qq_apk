import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity.25.2;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class nke
  implements InvocationHandler
{
  public nke(FastWebActivity.25.2 param2) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    this.a.a.this$0.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    FastWebActivity.a(this.a.a.this$0).setVisibility(8);
    QLog.d(FastWebActivity.a(this.a.a.this$0), 1, "open web page, set activity transparent");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nke
 * JD-Core Version:    0.7.0.1
 */