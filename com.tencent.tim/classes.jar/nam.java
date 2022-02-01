import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;

public class nam
{
  private kcp jdField_a_of_type_Kcp;
  private kcq jdField_a_of_type_Kcq;
  private naf jdField_a_of_type_Naf;
  private naq.d jdField_a_of_type_Naq$d;
  private Activity mActivity;
  private QQAppInterface mApp;
  private Handler mUIHandler;
  
  nam(Activity paramActivity, naf paramnaf, naq.d paramd)
  {
    this.mActivity = paramActivity;
    this.jdField_a_of_type_Naf = paramnaf;
    this.jdField_a_of_type_Naq$d = paramd;
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    this.mUIHandler = new Handler();
    init();
  }
  
  private void db(int paramInt1, int paramInt2)
  {
    ThreadManager.post(new MultiVideoDataManager.1(this, paramInt1, paramInt2), 1, null, true);
  }
  
  private void init()
  {
    this.jdField_a_of_type_Kcp = ((kcp)this.mApp.getBusinessHandler(99));
    this.jdField_a_of_type_Kcq = new nam.a(null);
    this.mApp.addObserver(this.jdField_a_of_type_Kcq);
  }
  
  void da(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while ((i < paramInt1 + paramInt2) && (i < this.jdField_a_of_type_Naq$d.bg().size()))
    {
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_Naq$d.bg().get(i);
      if (localVideoInfo.playCount == 0) {
        this.jdField_a_of_type_Kcp.br(localVideoInfo.vid, localVideoInfo.Wz);
      }
      i += 1;
    }
    db(paramInt1, paramInt2);
  }
  
  public void doOnDestory()
  {
    this.mApp.removeObserver(this.jdField_a_of_type_Kcq);
  }
  
  class a
    extends kcq
  {
    private a() {}
    
    protected void n(boolean paramBoolean, Bundle paramBundle)
    {
      if ((!paramBoolean) || (paramBundle == null)) {}
      for (;;)
      {
        return;
        String str = paramBundle.getString("VALUE_VIDEO_VID");
        int i = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
        if (!TextUtils.isEmpty(str))
        {
          paramBundle = nam.a(nam.this).bg().iterator();
          while (paramBundle.hasNext())
          {
            VideoInfo localVideoInfo = (VideoInfo)paramBundle.next();
            if ((str.equals(localVideoInfo.vid)) && (i > 0) && (localVideoInfo.playCount == 0))
            {
              localVideoInfo.playCount = i;
              nam.a(nam.this).i(localVideoInfo);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nam
 * JD-Core Version:    0.7.0.1
 */