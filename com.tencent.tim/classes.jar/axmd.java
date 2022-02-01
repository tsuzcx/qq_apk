import NS_QQ_STORY_CLIENT.CLIENT.StBatchGetMusicInfoRsp;
import NS_QQ_STORY_META.META.StMusic;
import android.text.TextUtils;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

public class axmd
  implements rxc.a<CLIENT.StBatchGetMusicInfoRsp>
{
  public axmd(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, VsMusicItemInfo paramVsMusicItemInfo) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CLIENT.StBatchGetMusicInfoRsp paramStBatchGetMusicInfoRsp)
  {
    if ((!paramBoolean) || (paramStBatchGetMusicInfoRsp.vecMusic.size() == 0)) {
      axiy.e(AEEditorVideoEditFragment.access$500(), "[VSDispatchObserver.onVSRspCallBack.onReceive], music - request music detail failed");
    }
    for (;;)
    {
      return;
      int i = 0;
      if (i < paramStBatchGetMusicInfoRsp.vecMusic.size())
      {
        paramString = (META.StMusic)paramStBatchGetMusicInfoRsp.vecMusic.get(i);
        if ((paramString == null) || (TextUtils.isEmpty(paramString.strSongMid.get()))) {}
        while (!this.d.mSongMid.equals(paramString.strSongMid.get()))
        {
          i += 1;
          break;
        }
        this.d.a(paramString);
      }
      for (i = 1; (i != 0) && (AEEditorMusicHelper.a(this.d)) && (AEEditorVideoEditFragment.a(this.this$0) != null); i = 0)
      {
        AEEditorVideoEditFragment.a(this.this$0).a(new axnb.a(this.d, false));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axmd
 * JD-Core Version:    0.7.0.1
 */