import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.MagazinePlayerView.1;
import com.tencent.qphone.base.util.QLog;

public class ajyb
  extends ajzh
{
  private String TAG = "MagazinePlayerView";
  public ajvk a;
  public VideoData b;
  private long mPlayTime;
  
  public ajyb(Context paramContext, ajvk paramajvk, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
    this.jdField_a_of_type_Ajvk = paramajvk;
  }
  
  public void a(RelativeLayout paramRelativeLayout, VideoData paramVideoData, ajyc paramajyc)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "play() called with: rootView = [" + paramRelativeLayout + "], videoData = [" + paramVideoData + "]");
    }
    this.b = paramVideoData;
    this.jdField_a_of_type_Ajyc = paramajyc;
    if (paramVideoData.type == 1)
    {
      A(paramRelativeLayout);
      this.mPlayTime = 0L;
      this.Bt.setVisibility(0);
      dAi();
      ajxr.a().a(this.Bt, paramVideoData.coverUrl, new ColorDrawable(0), new ColorDrawable(0), null);
      this.mHandler.post(new MagazinePlayerView.1(this));
      return;
    }
    super.a(paramRelativeLayout, paramVideoData, paramajyc);
  }
  
  public void pause()
  {
    if (this.b == null)
    {
      QLog.w(this.TAG, 2, "pasue mShortVideoInfo is null!!");
      return;
    }
    super.pause();
  }
  
  public void resume()
  {
    if (this.b == null) {}
    while (this.b.type == 1) {
      return;
    }
    if (this.jdField_a_of_type_Ajvk != null) {
      this.jdField_a_of_type_Ajvk.ahH();
    }
    super.resume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajyb
 * JD-Core Version:    0.7.0.1
 */