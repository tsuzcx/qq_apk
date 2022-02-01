import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.jsoninflate.model.AlumBasicData;
import java.util.ArrayList;

class awnt
  implements AdapterView.OnItemClickListener
{
  awnt(awns paramawns, awnm paramawnm) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    if (this.b != null)
    {
      this.b.dismiss();
      if ((this.b.ed != null) && (paramInt < this.b.ed.size()))
      {
        localObject = (awnm.b)this.b.ed.get(paramInt);
        if (((awnm.b)localObject).type != 1) {
          break label148;
        }
        if ((!TextUtils.isEmpty(((awnm.b)localObject).jumpUrl)) && (awnr.a(this.a.this$0) != null))
        {
          Intent localIntent = new Intent(awnr.a(this.a.this$0), QQBrowserActivity.class);
          localIntent.putExtra("url", ((awnm.b)localObject).jumpUrl);
          awnr.a(this.a.this$0).startActivity(localIntent);
        }
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      label148:
      if (((awnm.b)localObject).type == 2)
      {
        if (awnr.a(this.a.this$0) != null)
        {
          if (!TextUtils.isEmpty(awnr.a(this.a.this$0).negative_feedback_url))
          {
            localObject = awnr.a(this.a.this$0).negative_feedback_url.replace("__ACT_TYPE__", "2001");
            this.a.this$0.dO((String)localObject);
          }
          if (awnr.a(this.a.this$0) != null) {
            this.a.this$0.af(3, awnr.a(this.a.this$0).cRl, awnr.a(this.a.this$0) + 1);
          }
        }
        if (this.a.this$0.a != null) {
          this.a.this$0.a.dbZ();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnt
 * JD-Core Version:    0.7.0.1
 */