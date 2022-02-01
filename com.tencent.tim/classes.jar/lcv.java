import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class lcv
  extends lcs
{
  private Activity activity;
  private boolean ajt;
  
  public lcv(@NotNull lct paramlct, Activity paramActivity)
  {
    super(paramlct, "RIJDailyPopupStep");
    this.activity = paramActivity;
  }
  
  private boolean BO()
  {
    boolean bool2 = false;
    boolean bool3 = true;
    Intent localIntent = this.activity.getIntent();
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      bool1 = bool2;
      if (localIntent.hasExtra("arg_channel_rowkey"))
      {
        bool1 = bool2;
        if (localIntent.hasExtra("arg_channel_article_url"))
        {
          String str1 = localIntent.getStringExtra("arg_channel_rowkey");
          String str2 = localIntent.getStringExtra("arg_channel_article_url");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
            break label199;
          }
          Object localObject = new Bundle();
          ((Bundle)localObject).putString("floating_window_rowkey", str1);
          ((Bundle)localObject).putString("float_layer_article_url", str2);
          awix.a(this.activity, 5, 1, (Bundle)localObject, 0);
          if (this.activity != null)
          {
            localObject = kxm.a(this.activity);
            if (localObject != null) {
              ((ReadinjoyTabFrame)localObject).oT(32);
            }
          }
          QLog.i("RIJDailyPopupStep", 1, "[handleDailyJumpToRecommendChannel], open floating window, rowKey = " + str1 + ", articleURL = " + str2);
        }
      }
    }
    label199:
    for (bool1 = bool3;; bool1 = false)
    {
      localIntent.removeExtra("arg_channel_rowkey");
      localIntent.removeExtra("arg_channel_article_url");
      return bool1;
    }
  }
  
  protected void aKn()
  {
    nn(this.ajt);
  }
  
  protected void aKo()
  {
    this.ajt = BO();
    nn(this.ajt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lcv
 * JD-Core Version:    0.7.0.1
 */