import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.MusicProviderView;

class ayeq
  implements View.OnClickListener
{
  ayeq(ayep paramayep) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EditRecognitionPart", 2, "mRecognitionBubble onClick: invoked. ");
    }
    MusicItemInfo localMusicItemInfo = ((axro)axov.a().c(8)).b();
    if ((MusicProviderView.dwS) && (localMusicItemInfo != null) && (localMusicItemInfo.mItemId != ayep.a(this.b).mItemId) && (localMusicItemInfo.mType == 5)) {
      this.b.eQX();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ayep.a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayeq
 * JD-Core Version:    0.7.0.1
 */