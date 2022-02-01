package com.tencent.qqmail.InlineImage.delaystream;

import androidx.annotation.NonNull;
import com.tencent.qqmail.InlineImage.fetcher.CidImageFetcher;
import com.tencent.qqmail.model.qmdomain.Mail;

public class DelayCidInputStream
  extends DelayInputStream
{
  private static final String TAG = "DelayCidInputStream";
  
  public DelayCidInputStream(String paramString, @NonNull Mail paramMail)
  {
    super(paramString);
    this.fetcher = new CidImageFetcher(paramMail);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.delaystream.DelayCidInputStream
 * JD-Core Version:    0.7.0.1
 */