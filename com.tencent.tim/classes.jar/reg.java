import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.activity.richmedia.subtitles.SubtitleLayout;
import com.tencent.qphone.base.util.QLog;

public class reg
  extends rdb
  implements rbw
{
  public SubtitleLayout a;
  private byte[] bG;
  private ViewStub y;
  
  public reg(@NonNull rdc paramrdc, byte[] paramArrayOfByte)
  {
    super(paramrdc);
    this.bG = paramArrayOfByte;
  }
  
  private void setVisibility(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while (this.a.getVisibility() == paramInt);
      this.a.setVisibility(paramInt);
      return;
    } while ((this.a == null) || (this.a.getVisibility() == paramInt));
    this.a.setVisibility(paramInt);
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    super.a(paramInt, paramrkm);
    if ((this.a == null) || (this.bG == null)) {
      ram.w("Q.qqstory.publish.edit.Subtitle", "editVideoPrePublish but subtitle layout is null");
    }
    for (;;)
    {
      return;
      try
      {
        String str = Base64.encodeToString(this.bG, 0);
        if (!TextUtils.isEmpty(str))
        {
          paramrkm.g.putExtra("subtitleData", str);
          QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode :" + str.length());
          return;
        }
      }
      catch (Exception paramrkm)
      {
        QLog.e("Q.qqstory.publish.edit.Subtitle", 2, "subtitle base64 encode exception:" + paramrkm.toString());
      }
    }
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    setVisibility(0);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.e(paramMessage);
    }
    setVisibility(0);
    return true;
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate()
  {
    this.y = ((ViewStub)y(2131379002));
    QQStoryContext.a();
    QQStoryContext.c();
    if (this.a == null)
    {
      ram.d("Q.qqstory.publish.edit.Subtitle", "makeSureInitLayout");
      ViewParent localViewParent = this.y.getParent();
      if ((localViewParent == null) || (!(localViewParent instanceof ViewGroup))) {
        break label95;
      }
    }
    label95:
    for (this.a = ((SubtitleLayout)this.y.inflate());; this.a = ((SubtitleLayout)y(2131379001)))
    {
      this.a.init(1);
      this.a.aq(this.bG);
      a(rbw.class, this);
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.a.stop();
      this.a.destroy();
      this.a = null;
    }
    this.bG = null;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.a != null) {
      this.a.pause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.a != null) {
      this.a.resume();
    }
  }
  
  public void setTimeStamp(long paramLong)
  {
    if (this.a != null) {
      this.a.setTimeStamp(paramLong);
    }
  }
  
  public void start()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.Subtitle", 2, "videoplayer start");
    }
    if (this.a != null) {
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     reg
 * JD-Core Version:    0.7.0.1
 */