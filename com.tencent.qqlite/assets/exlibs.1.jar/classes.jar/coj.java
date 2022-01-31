import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;

public class coj
  extends AsyncTask
{
  private coj(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(ShortVideoPreviewActivity.e(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    ShortVideoPreviewActivity.d(this.a);
    switch (paramInteger.intValue())
    {
    default: 
      return;
    case 1: 
      Intent localIntent = this.a.getIntent();
      paramInteger = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      localIntent = new Intent();
      localIntent.setClassName(str, paramInteger);
      localIntent.addFlags(603979776);
      localIntent.putExtra("uin", ShortVideoPreviewActivity.b(this.a));
      localIntent.putExtra("uintype", ShortVideoPreviewActivity.f(this.a));
      localIntent.putExtra("file_send_business_type", 0);
      localIntent.putExtra("file_send_path", ShortVideoPreviewActivity.a(this.a));
      localIntent.putExtra("file_send_size", ShortVideoPreviewActivity.b(this.a));
      localIntent.putExtra("file_send_duration", (int)(ShortVideoPreviewActivity.a(this.a) / 1000L));
      localIntent.putExtra("file_source", ShortVideoPreviewActivity.c(this.a));
      localIntent.putExtra("thumbfile_send_path", ShortVideoPreviewActivity.d(this.a));
      localIntent.putExtra("file_shortvideo_md5", ShortVideoPreviewActivity.e(this.a));
      localIntent.putExtra("thumbfile_send_width", ShortVideoPreviewActivity.g(this.a));
      localIntent.putExtra("thumbfile_send_height", ShortVideoPreviewActivity.h(this.a));
      localIntent.putExtra("thumbfile_md5", ShortVideoPreviewActivity.f(this.a));
      this.a.startActivity(localIntent);
      this.a.finish();
      paramInteger = ShortVideoBusiManager.a(0, 0);
      paramInteger.a(ShortVideoBusiManager.a(0, localIntent, paramInteger));
      ShortVideoBusiManager.a(paramInteger, this.a.app);
      return;
    case 2: 
      ShortVideoPreviewActivity.d(this.a, 2131364432);
      return;
    case 3: 
      ShortVideoPreviewActivity.d(this.a, 2131364438);
      return;
    case 4: 
      ShortVideoPreviewActivity.d(this.a, 2131364436);
      return;
    }
    ShortVideoPreviewActivity.d(this.a, 2131364439);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    ShortVideoPreviewActivity.c(this.a, 2131364070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     coj
 * JD-Core Version:    0.7.0.1
 */