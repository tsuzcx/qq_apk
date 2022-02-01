import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.1;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.10;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.3;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.4;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.5;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.6;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.7;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.8;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.29.9;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class ndx
  implements INetInfoHandler
{
  ndx(ndi paramndi) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    ndi.a(this.this$0).od(false);
    if ((!this.this$0.Fo()) || (!this.this$0.mIsResume)) {}
    while (!this.this$0.jdField_a_of_type_Mye.isPlaying()) {
      return;
    }
    this.this$0.jdField_a_of_type_Mye.pause();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.this$0.mChannelID == 70) {
      ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.9(this));
    }
    do
    {
      return;
      ndi.a(this.this$0).od(true);
    } while ((!this.this$0.Fo()) || (!this.this$0.mIsResume));
    ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.10(this));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.this$0.mChannelID == 70) {
      ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.1(this));
    }
    do
    {
      do
      {
        return;
        if (ndi.a(this.this$0) != null) {
          ndi.a(this.this$0).od(false);
        }
      } while ((!this.this$0.Fo()) || (!this.this$0.mIsResume));
      if ((!this.this$0.jdField_a_of_type_Mye.isPlaying()) && (!this.this$0.jdField_a_of_type_Mye.isPause()) && (ndi.a(this.this$0).nW()))
      {
        ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.2(this));
        return;
      }
      if ((this.this$0.jdField_a_of_type_Lgf$c != null) && (this.this$0.jdField_a_of_type_Mye.isPause()) && (this.this$0.jdField_a_of_type_Mye.da() == this.this$0.jdField_a_of_type_Lgf$c.a().articleID) && (ndi.a(this.this$0).nW()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.this$0.jdField_a_of_type_Mye.da());
        }
        this.this$0.jdField_a_of_type_Mye.resume();
        return;
      }
    } while ((this.this$0.k == null) || (!this.this$0.jdField_a_of_type_Mye.isPause()) || (this.this$0.jdField_a_of_type_Mye.da() != this.this$0.k.articleID) || (!ndi.a(this.this$0).nW()));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.this$0.jdField_a_of_type_Mye.da());
    }
    this.this$0.jdField_a_of_type_Mye.resume();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.this$0.mChannelID == 70) {
      ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.7(this));
    }
    do
    {
      do
      {
        return;
        ndi.a(this.this$0).od(true);
      } while ((!this.this$0.Fo()) || (!this.this$0.mIsResume));
      if ((!this.this$0.jdField_a_of_type_Mye.isPlaying()) && (!this.this$0.jdField_a_of_type_Mye.isPause()))
      {
        ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.8(this));
        return;
      }
      if ((this.this$0.jdField_a_of_type_Lgf$c != null) && (this.this$0.jdField_a_of_type_Mye.isPause()) && (this.this$0.jdField_a_of_type_Mye.da() == this.this$0.jdField_a_of_type_Lgf$c.a().articleID))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video", 2, "net change: continue to play before video ,id : " + this.this$0.jdField_a_of_type_Mye.da());
        }
        this.this$0.jdField_a_of_type_Mye.resume();
        return;
      }
    } while ((this.this$0.k == null) || (!this.this$0.jdField_a_of_type_Mye.isPause()) || (this.this$0.jdField_a_of_type_Mye.da() != this.this$0.k.articleID));
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "mVideoPlayParam net change: continue to play before video ,id : " + this.this$0.jdField_a_of_type_Mye.da());
    }
    this.this$0.jdField_a_of_type_Mye.resume();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.this$0.mChannelID == 70) {
      ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.5(this));
    }
    do
    {
      return;
      ndi.a(this.this$0).od(false);
    } while ((this.this$0.arA) || (this.this$0.jdField_a_of_type_Lgf$c == null) || (this.this$0.k == null));
    ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.6(this));
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.this$0.mChannelID == 70) {
      ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.3(this));
    }
    do
    {
      return;
      ndi.a(this.this$0).od(false);
    } while ((this.this$0.arA) || (this.this$0.jdField_a_of_type_Lgf$c == null) || (this.this$0.k == null));
    ndi.a(this.this$0).post(new ReadInJoyBaseAdapter.29.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ndx
 * JD-Core Version:    0.7.0.1
 */