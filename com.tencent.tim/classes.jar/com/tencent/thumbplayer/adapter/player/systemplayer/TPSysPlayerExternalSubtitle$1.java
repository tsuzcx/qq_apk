package com.tencent.thumbplayer.adapter.player.systemplayer;

import com.tencent.thumbplayer.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.core.subtitle.ITPSubtitleParserCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPSysPlayerExternalSubtitle$1
  implements ITPSubtitleParserCallback
{
  TPSysPlayerExternalSubtitle$1(TPSysPlayerExternalSubtitle paramTPSysPlayerExternalSubtitle, long paramLong) {}
  
  public long onGetCurrentPlayPositionMs()
  {
    if (TPSysPlayerExternalSubtitle.access$200(this.this$0) != null) {
      return TPSysPlayerExternalSubtitle.access$200(this.this$0).getCurrentPosition();
    }
    return 0L;
  }
  
  public void onLoadResult(int paramInt)
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onLoadResult, index:" + paramInt);
    TPSysPlayerExternalSubtitle.access$000(this.this$0, this.val$opaque);
  }
  
  public void onSelectResult(int paramInt, long paramLong)
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSelectResult, errCode:" + paramInt + ", selectOpaque:" + paramLong + ", opaque =" + this.val$opaque);
    if ((paramInt == 0) && (TPSysPlayerExternalSubtitle.access$100(this.this$0) != null)) {
      TPSysPlayerExternalSubtitle.access$100(this.this$0).onTrackSelectSuccess(this.val$opaque);
    }
    while ((paramInt == 0) || (TPSysPlayerExternalSubtitle.access$100(this.this$0) == null)) {
      return;
    }
    TPSysPlayerExternalSubtitle.access$100(this.this$0).onTrackSelectFailure(paramInt, this.val$opaque);
  }
  
  public void onSubtitleFrame(TPSubtitleFrame paramTPSubtitleFrame)
  {
    TPLogUtil.i("TPSysPlayerExternalSubtitle", "onSubtitleFrame");
    if (TPSysPlayerExternalSubtitle.access$300(this.this$0) != null) {
      TPSysPlayerExternalSubtitle.access$300(this.this$0).onSubtitleFrameData(paramTPSubtitleFrame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.player.systemplayer.TPSysPlayerExternalSubtitle.1
 * JD-Core Version:    0.7.0.1
 */