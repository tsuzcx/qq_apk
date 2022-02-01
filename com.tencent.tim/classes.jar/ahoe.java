import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.NowLiveFragment;

public class ahoe
  implements auuw.b
{
  public ahoe(NowLiveFragment paramNowLiveFragment) {}
  
  public void a(auuw.a parama)
  {
    switch (parama.id)
    {
    default: 
      return;
    case 0: 
      parama = this.this$0.getActivity().getIntent().getStringExtra("big_brother_source_key");
      if (aifl.aoW())
      {
        localObject = new Bundle();
        if (!TextUtils.isEmpty(parama)) {
          ((Bundle)localObject).putString("big_brother_source_key", parama);
        }
        aifl.cM((Bundle)localObject);
        return;
      }
      localObject = "" + this.this$0.bLd;
      Intent localIntent = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", (String)localObject);
      if (!TextUtils.isEmpty(parama)) {
        localIntent.putExtra("big_brother_source_key", parama);
      }
      localIntent.putExtra("reqType", 1);
      this.this$0.startActivity(localIntent);
      return;
    case 1: 
      parama = "" + this.this$0.bLe;
      localObject = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", parama);
      ((Intent)localObject).putExtra("reqType", 1);
      this.this$0.startActivity((Intent)localObject);
      return;
    }
    parama = "" + this.this$0.bLf;
    Object localObject = new Intent(this.this$0.getActivity(), QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", parama);
    ((Intent)localObject).putExtra("reqType", 1);
    ((Intent)localObject).putExtra("title", acfp.m(2131709203));
    this.this$0.startActivity((Intent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahoe
 * JD-Core Version:    0.7.0.1
 */