package dov.com.qq.im.aeeditor.module.edit;

import android.widget.ImageView;
import axiy;
import axnb.a;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.data.MusicData;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$12
  implements Runnable
{
  AEEditorVideoEditFragment$12(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, axnb.a parama, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if ((AEEditorVideoEditFragment.a(this.this$0) != null) && (!AEEditorVideoEditFragment.a(this.this$0).aPf()) && (!this.c.aPf()) && (AEEditorVideoEditFragment.a(this.this$0).getSongMid().equals(this.c.getSongMid()))) {}
    for (int i = 1; !this.dvs; i = 0)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.c, this.dvs);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          AEEditorVideoEditFragment.a(this.this$0).setBackgroundMusicChecked(false);
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 2131689955, 0).show();
      }
      axiy.e(AEEditorVideoEditFragment.access$500(), "[onDownloadFinished], download music failed, editorMusicInfo=" + this.c);
      return;
    }
    if (i != 0)
    {
      if (AEEditorVideoEditFragment.a(this.this$0) == null)
      {
        axiy.i(AEEditorVideoEditFragment.access$500(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      AEEditorVideoEditFragment.a(this.this$0, AEEditorMusicHelper.a(this.val$localPath, this.c.Rh(), this.c.Ri()));
      TAVCutVideoSession localTAVCutVideoSession = AEEditorVideoEditFragment.a(this.this$0);
      MusicData localMusicData = AEEditorVideoEditFragment.a(this.this$0);
      if (AEEditorVideoEditFragment.a(this.this$0)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        if (!this.this$0.dvj) {
          bool = true;
        }
        localTAVCutVideoSession.setBgmMusic(localMusicData, f, 1.0F, bool);
        if ((!this.this$0.dvj) && (AEEditorVideoEditFragment.a(this.this$0) != null) && (AEEditorVideoEditFragment.a(this.this$0).getVisibility() == 0)) {
          AEEditorVideoEditFragment.a(this.this$0, true);
        }
        AEEditorVideoEditFragment.a(this.this$0, this.c, this.dvs);
        return;
      }
    }
    AEEditorVideoEditFragment.a(this.this$0, this.c, this.dvs);
    axiy.i(AEEditorVideoEditFragment.access$500(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.12
 * JD-Core Version:    0.7.0.1
 */