package com.tencent.TMG.ptt;

class PttManager$3
  implements TokenFetcher.Voice2TextListener
{
  PttManager$3(PttManager paramPttManager, PttListener.Voice2TextListener paramVoice2TextListener, String paramString) {}
  
  public void onCompleted(int paramInt, String paramString, TokenFetcher.Voice2TextInfo paramVoice2TextInfo)
  {
    Object localObject = null;
    paramString = localObject;
    if (paramInt == 0)
    {
      paramString = localObject;
      if (paramVoice2TextInfo != null) {
        paramString = paramVoice2TextInfo.text;
      }
    }
    if (this.val$listener != null) {
      this.val$listener.onCompleted(paramInt, this.val$voiceUrl, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.3
 * JD-Core Version:    0.7.0.1
 */