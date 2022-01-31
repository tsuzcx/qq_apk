import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter.ViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class cpk
  extends BroadcastReceiver
{
  public cpk(WebFacePreloadBaseAdapter paramWebFacePreloadBaseAdapter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (WebFacePreloadBaseAdapter.a(this.a) == null) {}
    for (;;)
    {
      return;
      if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) && (paramIntent.getIntExtra("faceType", -1) == WebFacePreloadBaseAdapter.a(this.a)))
      {
        paramContext = paramIntent.getStringArrayListExtra("uinList");
        paramIntent = paramIntent.getStringArrayListExtra("headPathList");
        int j;
        if ((paramContext != null) && (paramIntent != null))
        {
          j = paramContext.size();
          i = 0;
          while (i < j)
          {
            String str = (String)paramContext.get(i);
            if (WebFacePreloadBaseAdapter.a(this.a).contains(str)) {
              WebFacePreloadBaseAdapter.a(this.a).remove(str);
            }
            WebFacePreloadBaseAdapter.a(this.a).put(str, paramIntent.get(i));
            i += 1;
          }
          if (WebFacePreloadBaseAdapter.b(this.a) == 0)
          {
            int k = WebFacePreloadBaseAdapter.a(this.a).getChildCount();
            i = 0;
            while (i < k)
            {
              paramContext = WebFacePreloadBaseAdapter.a(this.a).getChildAt(i).getTag();
              if ((paramContext != null) && ((paramContext instanceof WebFacePreloadBaseAdapter.ViewHolder)))
              {
                paramContext = (WebFacePreloadBaseAdapter.ViewHolder)paramContext;
                if ((paramContext != null) && (paramContext.jdField_a_of_type_JavaLangString != null) && (paramContext.jdField_a_of_type_JavaLangString.length() > 0)) {
                  paramContext.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.a.a(paramContext.jdField_a_of_type_JavaLangString, false));
                }
              }
              i += 1;
            }
          }
        }
        for (int i = j; QLog.isColorLevel(); i = 0)
        {
          QLog.d("WebFacePreloadBaseAdapter", 2, "onReceive, uinListSize:" + i + " reqSize:" + WebFacePreloadBaseAdapter.a(this.a).size());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpk
 * JD-Core Version:    0.7.0.1
 */