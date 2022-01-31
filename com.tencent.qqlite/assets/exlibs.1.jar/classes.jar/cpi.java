import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.adapter.WebBaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.adapter.WebFacePreloadBaseAdapter.ViewHolder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class cpi
  extends BroadcastReceiver
{
  public cpi(WebBaseFacePreloadExpandableListAdapter paramWebBaseFacePreloadExpandableListAdapter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.a == null) {
      break label10;
    }
    for (;;)
    {
      label10:
      return;
      if ((paramIntent != null) && ("com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())))
      {
        paramContext = paramIntent.getStringArrayListExtra("uinList");
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("headPathList");
        if (paramIntent.getIntExtra("faceType", -1) != WebBaseFacePreloadExpandableListAdapter.a(this.a)) {
          break;
        }
        int j;
        if ((paramContext != null) && (localArrayList != null))
        {
          j = paramContext.size();
          i = 0;
          while (i < j)
          {
            paramIntent = (String)paramContext.get(i);
            if (WebBaseFacePreloadExpandableListAdapter.a(this.a).contains(paramIntent)) {
              WebBaseFacePreloadExpandableListAdapter.a(this.a).remove(paramIntent);
            }
            WebBaseFacePreloadExpandableListAdapter.a(this.a).put(paramIntent, localArrayList.get(i));
            i += 1;
          }
          if (WebBaseFacePreloadExpandableListAdapter.b(this.a) == 0)
          {
            int k = this.a.a.getChildCount();
            i = 0;
            while (i < k)
            {
              paramContext = this.a.a.getChildAt(i).getTag();
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
          QLog.d("WebFacePreloadBaseAdapter", 2, "onReceive, uinListSize:" + i + " reqSize:" + WebBaseFacePreloadExpandableListAdapter.a(this.a).size());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cpi
 * JD-Core Version:    0.7.0.1
 */