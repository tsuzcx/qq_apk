package com.tencent.token.ui;

import android.webkit.DownloadListener;
import com.tencent.token.utils.s;

final class dk
  implements DownloadListener
{
  dk(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    s.a(this.a, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dk
 * JD-Core Version:    0.7.0.1
 */