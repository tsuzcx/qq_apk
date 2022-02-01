package com.tencent.qqmail.InlineImage.fetcher;

import java.io.InputStream;

public abstract interface Fetcher
{
  public abstract InputStream fetch(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.InlineImage.fetcher.Fetcher
 * JD-Core Version:    0.7.0.1
 */