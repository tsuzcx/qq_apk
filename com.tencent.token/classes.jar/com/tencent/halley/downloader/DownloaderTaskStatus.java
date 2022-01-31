package com.tencent.halley.downloader;

public enum DownloaderTaskStatus
{
  static
  {
    DOWNLOADING = new DownloaderTaskStatus("DOWNLOADING", 2);
    COMPLETE = new DownloaderTaskStatus("COMPLETE", 3);
    FAILED = new DownloaderTaskStatus("FAILED", 4);
    PAUSED = new DownloaderTaskStatus("PAUSED", 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.downloader.DownloaderTaskStatus
 * JD-Core Version:    0.7.0.1
 */