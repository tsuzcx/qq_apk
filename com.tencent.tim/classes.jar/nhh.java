import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinSlideDownView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

public class nhh
  implements anyk.b
{
  public nhh(ReadInJoySkinSlideDownView paramReadInJoySkinSlideDownView, View.OnClickListener paramOnClickListener1, String paramString1, int paramInt, String paramString2, Context paramContext, View.OnClickListener paramOnClickListener2) {}
  
  public void a(anxx paramanxx, anxy paramanxy, String paramString)
  {
    int i = 1;
    paramanxx = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    RefreshData localRefreshData = mfo.b(ReadInJoySkinSlideDownView.a(this.a), 0);
    if (paramString.equals("close"))
    {
      this.ct.onClick(this.a);
      paramanxy = new kxm.b();
      for (;;)
      {
        try
        {
          paramanxy.f();
          paramanxy.a("skin_id", this.aln);
          paramanxy.a("channel_id", this.aMH);
          if ((localRefreshData == null) || (!localRefreshData.isAD)) {
            continue;
          }
          paramanxy.a("ad_page", i);
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          continue;
        }
        kbp.a(paramanxx, "", "0X800969E", "0X800969E", 0, 0, this.aln, "" + kxm.nR(), String.valueOf(ReadInJoySkinSlideDownView.a(this.a)), paramanxy.build(), false);
        return;
        i = 0;
      }
    }
    if (paramString.equals("open_sound"))
    {
      if (this.a.mMediaPlayer == null) {
        this.a.mMediaPlayer = new MediaPlayer();
      }
      for (;;)
      {
        try
        {
          this.a.mMediaPlayer.setDataSource(this.alk + "/audio.mp3");
          this.a.mMediaPlayer.prepare();
          this.a.mMediaPlayer.start();
          paramanxy = new kxm.b();
          try
          {
            paramanxy.f();
            paramanxy.a("skin_id", this.aln);
            paramanxy.a("channel_id", this.aMH);
            if ((localRefreshData == null) || (!localRefreshData.isAD)) {
              break label436;
            }
            i = 1;
            paramanxy.a("ad_page", i);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
            continue;
          }
          kbp.a(paramanxx, "", "0X800969D", "0X800969D", 0, 0, this.aln, "" + kxm.nR(), String.valueOf(ReadInJoySkinSlideDownView.a(this.a)), paramanxy.build(), false);
          return;
        }
        catch (Exception paramanxy)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramanxy));
          continue;
        }
        try
        {
          if (this.a.mMediaPlayer.isPlaying()) {
            continue;
          }
          this.a.mMediaPlayer.start();
        }
        catch (Exception paramanxy) {}
        if (QLog.isColorLevel())
        {
          QLog.e("ReadInJoySkinSlideDownView", 2, QLog.getStackTraceString(paramanxy));
          continue;
          label436:
          i = 0;
        }
      }
    }
    paramanxx = aqik.c(paramanxx, this.val$context, paramString);
    if (paramanxx != null)
    {
      paramanxx.ace();
      ReadInJoySkinSlideDownView.a(this.a).onClick(this.a);
    }
    for (;;)
    {
      ReadInJoySkinSlideDownView.a(this.a, this.aMH, paramString, ((anxu)paramanxy).getTag());
      return;
      if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
      {
        paramanxx = new Intent(this.val$context, QQBrowserActivity.class);
        paramanxx.putExtra("url", paramString);
        this.val$context.startActivity(paramanxx);
        this.cx.onClick(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nhh
 * JD-Core Version:    0.7.0.1
 */