package com.tencent.TMG.audio;

import android.annotation.TargetApi;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.TMG.utils.QLog;

class TraeAudioManager$TraeAudioManagerLooper$3
  implements AudioManager.OnAudioFocusChangeListener
{
  TraeAudioManager$TraeAudioManagerLooper$3(TraeAudioManager.TraeAudioManagerLooper paramTraeAudioManagerLooper) {}
  
  @TargetApi(8)
  public void onAudioFocusChange(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 0, "focusChange:" + paramInt + " _focusSteamType:" + this.this$1._focusSteamType + " currMode:" + this.this$1.this$0._am.getMode() + " _activeMode:" + this.this$1.this$0._activeMode);
    }
    if (paramInt == -1) {}
    while ((paramInt == -2) || (paramInt == -3) || (paramInt != 1)) {
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioManager.TraeAudioManagerLooper.3
 * JD-Core Version:    0.7.0.1
 */